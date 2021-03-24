package com.baidu.android.imsdk.group.request;

import android.content.Context;
import android.util.Log;
import android.util.Pair;
import com.baidu.android.imsdk.IMListener;
import com.baidu.android.imsdk.conversation.ConversationManagerImpl;
import com.baidu.android.imsdk.group.BIMValueCallBack;
import com.baidu.android.imsdk.group.CreateResultInfo;
import com.baidu.android.imsdk.group.GroupInfo;
import com.baidu.android.imsdk.group.GroupMember;
import com.baidu.android.imsdk.group.db.GroupInfoDAOImpl;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.internal.ListenerManager;
import com.baidu.android.imsdk.task.TaskManager;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.LogUtils;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class IMQueryGroupRequest extends GroupBaseHttpRequest {
    public static final String TAG = "IMQueryGroupRequest";
    public boolean isCreateGroup;
    public ArrayList<GroupMember> mAddMembers;
    public long mAppid;
    public ArrayList<String> mGroupIds;
    public String mKey;

    /* loaded from: classes2.dex */
    public class Mytask extends TaskManager.Task {
        public Mytask(String str, String str2) {
            super(str, str2);
        }

        /* JADX WARN: Removed duplicated region for block: B:37:0x0154  */
        /* JADX WARN: Removed duplicated region for block: B:46:0x01c4  */
        @Override // com.baidu.android.imsdk.task.TaskManager.Task, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            String str;
            int i;
            StringBuilder sb;
            Mytask mytask = this;
            ArrayList arrayList = new ArrayList();
            try {
                JSONObject jSONObject = new JSONObject(mytask.mJson);
                int i2 = jSONObject.getInt("error_code");
                String optString = jSONObject.optString("error_msg", "");
                if (i2 == 0 && jSONObject.has("response_params")) {
                    JSONArray jSONArray = jSONObject.getJSONObject("response_params").getJSONArray("group_info");
                    int i3 = 0;
                    while (i3 < jSONArray.length()) {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i3);
                        long optLong = jSONObject2.optLong("group_id");
                        String optString2 = jSONObject2.optString("group_name");
                        int optInt = jSONObject2.optInt("group_type");
                        int optInt2 = jSONObject2.optInt("group_num");
                        long optLong2 = jSONObject2.optLong("create_time");
                        int i4 = i3;
                        long optLong3 = jSONObject2.optLong("bd_uid");
                        int i5 = i2;
                        String str2 = optString;
                        long optLong4 = jSONObject2.optLong("uk");
                        JSONArray jSONArray2 = jSONArray;
                        int optInt3 = jSONObject2.optInt("status", -1);
                        String trim = jSONObject2.optString("group_image").trim();
                        String str3 = IMQueryGroupRequest.TAG;
                        ArrayList arrayList2 = arrayList;
                        try {
                            sb = new StringBuilder();
                        } catch (JSONException e2) {
                            e = e2;
                        }
                        try {
                            sb.append("GETGROUP status=");
                            sb.append(optInt3);
                            sb.append(" type=");
                            sb.append(optInt);
                            sb.append("  groupname=");
                            sb.append(optString2);
                            sb.append(" id=");
                            sb.append(optLong);
                            LogUtils.d(str3, sb.toString());
                            if (optInt3 != 0 && optInt3 != 2 && optInt3 != 1) {
                                mytask = this;
                                arrayList = arrayList2;
                                i3 = i4 + 1;
                                i2 = i5;
                                optString = str2;
                                jSONArray = jSONArray2;
                            }
                            GroupInfo groupInfo = new GroupInfo(String.valueOf(optLong));
                            groupInfo.setGroupName(optString2);
                            groupInfo.setType(optInt);
                            groupInfo.setNum(optInt2);
                            groupInfo.setCreateTime(optLong2);
                            groupInfo.setBuid(optLong3);
                            groupInfo.setUk(optLong4);
                            groupInfo.setHeadUrl(trim);
                            if (optInt3 == 2) {
                                groupInfo.setBrief(1);
                            }
                            mytask = this;
                            GroupInfoDAOImpl.updateGroupInfo(IMQueryGroupRequest.this.mContext, groupInfo);
                            ConversationManagerImpl.getInstance(IMQueryGroupRequest.this.mContext).updateConversationName(optString2, 1, String.valueOf(optLong));
                            arrayList = arrayList2;
                            arrayList.add(groupInfo);
                            if (optInt3 == 1) {
                                GroupInfoDAOImpl.setGroupState(IMQueryGroupRequest.this.mContext, String.valueOf(optLong), optInt3);
                            }
                            i3 = i4 + 1;
                            i2 = i5;
                            optString = str2;
                            jSONArray = jSONArray2;
                        } catch (JSONException e3) {
                            e = e3;
                            mytask = this;
                            arrayList = arrayList2;
                            LogUtils.e(LogUtils.TAG, "IMCreateGroupRequest JSONException", e);
                            i = 1010;
                            new IMTrack.CrashBuilder(IMQueryGroupRequest.this.mContext).exception(Log.getStackTraceString(e)).build();
                            str = Constants.ERROR_MSG_JSON_PARSE_EXCEPTION;
                            if (i != 0) {
                            }
                        }
                    }
                }
                i = i2;
                str = optString;
            } catch (JSONException e4) {
                e = e4;
            }
            if (i != 0) {
                IMListener removeListener = ListenerManager.getInstance().removeListener(IMQueryGroupRequest.this.mKey);
                if (!IMQueryGroupRequest.this.isCreateGroup) {
                    if (removeListener != null) {
                        ((BIMValueCallBack) removeListener).onResult(0, "successful", arrayList);
                        return;
                    }
                    return;
                }
                BIMValueCallBack bIMValueCallBack = (BIMValueCallBack) removeListener;
                CreateResultInfo createResultInfo = new CreateResultInfo();
                createResultInfo.groupid = (String) IMQueryGroupRequest.this.mGroupIds.get(0);
                createResultInfo.memberlist = IMQueryGroupRequest.this.mAddMembers;
                String str4 = IMQueryGroupRequest.TAG;
                LogUtils.d(str4, "FXF query group info " + ((GroupInfo) arrayList.get(0)).toString());
                if (bIMValueCallBack == null) {
                    LogUtils.e(IMQueryGroupRequest.TAG, "query group info fail, listener is null");
                    return;
                } else {
                    bIMValueCallBack.onResult(0, "successful", createResultInfo);
                    return;
                }
            }
            IMListener removeListener2 = ListenerManager.getInstance().removeListener(IMQueryGroupRequest.this.mKey);
            if (removeListener2 == null || !(removeListener2 instanceof BIMValueCallBack)) {
                return;
            }
            if (IMQueryGroupRequest.this.isCreateGroup) {
                CreateResultInfo createResultInfo2 = new CreateResultInfo();
                createResultInfo2.groupid = (String) IMQueryGroupRequest.this.mGroupIds.get(0);
                createResultInfo2.memberlist = IMQueryGroupRequest.this.mAddMembers;
                ((BIMValueCallBack) removeListener2).onResult(0, str, createResultInfo2);
                return;
            }
            ((BIMValueCallBack) removeListener2).onResult(i, str, null);
        }
    }

    public IMQueryGroupRequest(Context context, String str, long j, ArrayList<String> arrayList, boolean z, ArrayList<GroupMember> arrayList2) {
        this.isCreateGroup = false;
        this.mContext = context;
        this.mAppid = j;
        this.mKey = str;
        this.mGroupIds = arrayList;
        this.mAddMembers = arrayList2;
        this.isCreateGroup = z;
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getContentType() {
        return "application/x-www-form-urlencoded";
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public byte[] getRequestParameter() throws NoSuchAlgorithmException {
        String bduss = IMConfigInternal.getInstance().getIMConfig(this.mContext).getBduss(this.mContext);
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        StringBuilder sb = new StringBuilder();
        sb.append("method=get_group_info");
        sb.append("&appid=");
        sb.append(this.mAppid);
        sb.append("&timestamp=");
        sb.append(currentTimeMillis);
        ArrayList<String> arrayList = this.mGroupIds;
        if (arrayList != null && arrayList.size() > 0) {
            JSONArray jSONArray = new JSONArray();
            Iterator<String> it = this.mGroupIds.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next());
            }
            sb.append("&group_ids=");
            sb.append(jSONArray.toString());
        }
        sb.append("&sign=");
        sb.append(getMd5("" + currentTimeMillis + bduss + this.mAppid));
        return sb.toString().getBytes();
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onFailure(int i, byte[] bArr, Throwable th) {
        Pair<Integer, String> transErrorCode = transErrorCode(i, bArr, th);
        IMListener removeListener = ListenerManager.getInstance().removeListener(this.mKey);
        if (removeListener == null || !(removeListener instanceof BIMValueCallBack)) {
            return;
        }
        if (this.isCreateGroup) {
            CreateResultInfo createResultInfo = new CreateResultInfo();
            createResultInfo.groupid = this.mGroupIds.get(0);
            ((BIMValueCallBack) removeListener).onResult(0, (String) transErrorCode.second, createResultInfo);
            return;
        }
        ((BIMValueCallBack) removeListener).onResult(((Integer) transErrorCode.first).intValue(), (String) transErrorCode.second, null);
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onSuccess(int i, byte[] bArr) {
        String str = new String(bArr);
        String str2 = TAG;
        LogUtils.d(str2, "IMQueryGroupRequest " + this.mGroupIds + " json is " + str);
        TaskManager.getInstance(this.mContext).submitForNetWork(new Mytask(this.mKey, str));
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public boolean shouldAbort() {
        return false;
    }
}
