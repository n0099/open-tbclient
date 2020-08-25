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
/* loaded from: classes9.dex */
public class IMQueryGroupRequest extends GroupBaseHttpRequest {
    private static final String TAG = IMQueryGroupRequest.class.getSimpleName();
    private boolean isCreateGroup;
    ArrayList<GroupMember> mAddMembers;
    private long mAppid;
    private ArrayList<String> mGroupIds;
    private String mKey;

    /* loaded from: classes9.dex */
    class Mytask extends TaskManager.Task {
        public Mytask(String str, String str2) {
            super(str, str2);
        }

        @Override // com.baidu.android.imsdk.task.TaskManager.Task, java.lang.Runnable
        public void run() {
            int i;
            String str;
            ArrayList arrayList = new ArrayList();
            try {
                JSONObject jSONObject = new JSONObject(this.mJson);
                i = jSONObject.getInt("error_code");
                String optString = jSONObject.optString("error_msg", "");
                if (i == 0 && jSONObject.has("response_params")) {
                    JSONArray jSONArray = jSONObject.getJSONObject("response_params").getJSONArray("group_info");
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                        long optLong = jSONObject2.optLong("group_id");
                        String optString2 = jSONObject2.optString("group_name");
                        int optInt = jSONObject2.optInt("group_type");
                        int optInt2 = jSONObject2.optInt("group_num");
                        long optLong2 = jSONObject2.optLong("create_time");
                        long optLong3 = jSONObject2.optLong("bd_uid");
                        long optLong4 = jSONObject2.optLong("uk");
                        int optInt3 = jSONObject2.optInt("status", -1);
                        String trim = jSONObject2.optString("group_image").trim();
                        LogUtils.d(IMQueryGroupRequest.TAG, "GETGROUP status=" + optInt3 + " type=" + optInt + "  groupname=" + optString2 + " id=" + optLong);
                        if (optInt3 == 0 || optInt3 == 2 || optInt3 == 1) {
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
                            GroupInfoDAOImpl.updateGroupInfo(IMQueryGroupRequest.this.mContext, groupInfo);
                            ConversationManagerImpl.getInstance(IMQueryGroupRequest.this.mContext).updateConversationName(optString2, 1, String.valueOf(optLong));
                            arrayList.add(groupInfo);
                            if (optInt3 == 1) {
                                GroupInfoDAOImpl.setGroupState(IMQueryGroupRequest.this.mContext, String.valueOf(optLong), optInt3);
                            }
                        }
                    }
                }
                str = optString;
            } catch (JSONException e) {
                LogUtils.e(LogUtils.TAG, "IMCreateGroupRequest JSONException", e);
                new IMTrack.CrashBuilder(IMQueryGroupRequest.this.mContext).exception(Log.getStackTraceString(e)).build();
                i = 1010;
                str = Constants.ERROR_MSG_JSON_PARSE_EXCEPTION;
            }
            if (i == 0) {
                IMListener removeListener = ListenerManager.getInstance().removeListener(IMQueryGroupRequest.this.mKey);
                if (IMQueryGroupRequest.this.isCreateGroup) {
                    BIMValueCallBack bIMValueCallBack = (BIMValueCallBack) removeListener;
                    CreateResultInfo createResultInfo = new CreateResultInfo();
                    createResultInfo.groupid = (String) IMQueryGroupRequest.this.mGroupIds.get(0);
                    createResultInfo.memberlist = IMQueryGroupRequest.this.mAddMembers;
                    LogUtils.d(IMQueryGroupRequest.TAG, "FXF query group info " + ((GroupInfo) arrayList.get(0)).toString());
                    if (bIMValueCallBack == null) {
                        LogUtils.e(IMQueryGroupRequest.TAG, "query group info fail, listener is null");
                        return;
                    } else {
                        bIMValueCallBack.onResult(0, "successful", createResultInfo);
                        return;
                    }
                } else if (removeListener != null) {
                    ((BIMValueCallBack) removeListener).onResult(0, "successful", arrayList);
                    return;
                } else {
                    return;
                }
            }
            IMListener removeListener2 = ListenerManager.getInstance().removeListener(IMQueryGroupRequest.this.mKey);
            if (removeListener2 != null && (removeListener2 instanceof BIMValueCallBack)) {
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

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public byte[] getRequestParameter() throws NoSuchAlgorithmException {
        String bduss = IMConfigInternal.getInstance().getIMConfig(this.mContext).getBduss(this.mContext);
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        StringBuilder sb = new StringBuilder();
        sb.append("method=get_group_info");
        sb.append("&appid=").append(this.mAppid);
        sb.append("&timestamp=").append(currentTimeMillis);
        if (this.mGroupIds != null && this.mGroupIds.size() > 0) {
            JSONArray jSONArray = new JSONArray();
            Iterator<String> it = this.mGroupIds.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next());
            }
            sb.append("&group_ids=").append(jSONArray.toString());
        }
        sb.append("&sign=").append(getMd5("" + currentTimeMillis + bduss + this.mAppid));
        return sb.toString().getBytes();
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getContentType() {
        return "application/x-www-form-urlencoded";
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public boolean shouldAbort() {
        return false;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onSuccess(int i, byte[] bArr) {
        String str = new String(bArr);
        LogUtils.d(TAG, "IMQueryGroupRequest " + this.mGroupIds + " json is " + str);
        TaskManager.getInstance(this.mContext).submitForNetWork(new Mytask(this.mKey, str));
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onFailure(int i, byte[] bArr, Throwable th) {
        Pair<Integer, String> transErrorCode = transErrorCode(i, bArr, th);
        IMListener removeListener = ListenerManager.getInstance().removeListener(this.mKey);
        if (removeListener != null && (removeListener instanceof BIMValueCallBack)) {
            if (this.isCreateGroup) {
                CreateResultInfo createResultInfo = new CreateResultInfo();
                createResultInfo.groupid = this.mGroupIds.get(0);
                ((BIMValueCallBack) removeListener).onResult(0, (String) transErrorCode.second, createResultInfo);
                return;
            }
            ((BIMValueCallBack) removeListener).onResult(((Integer) transErrorCode.first).intValue(), (String) transErrorCode.second, null);
        }
    }
}
