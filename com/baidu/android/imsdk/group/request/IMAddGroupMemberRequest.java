package com.baidu.android.imsdk.group.request;

import android.content.Context;
import android.util.Log;
import android.util.Pair;
import com.baidu.android.imsdk.IMListener;
import com.baidu.android.imsdk.db.DBTableDefine;
import com.baidu.android.imsdk.group.BIMValueCallBack;
import com.baidu.android.imsdk.group.CreateResultInfo;
import com.baidu.android.imsdk.group.GroupMember;
import com.baidu.android.imsdk.group.db.GroupInfoDAOImpl;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.internal.ListenerManager;
import com.baidu.android.imsdk.task.TaskManager;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.HttpHelper;
import com.baidu.android.imsdk.utils.LogUtils;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class IMAddGroupMemberRequest extends GroupBaseHttpRequest {
    public static final String TAG = "IMAddGroupMemberRequest";
    public boolean isCreateGroup;
    public long mAppid;
    public long mGroupId;
    public String mKey;
    public ArrayList<String> mMembers;

    /* loaded from: classes.dex */
    public class Mytask extends TaskManager.Task {
        public Mytask(Context context, String str, String str2) {
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
                str = jSONObject.optString("error_msg", "");
                if (i == 0 && jSONObject.has("response_params")) {
                    JSONArray jSONArray = jSONObject.getJSONObject("response_params").getJSONArray("members");
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                        long optLong = jSONObject2.optLong("bd_uid");
                        int optInt = jSONObject2.optInt("role");
                        long optLong2 = jSONObject2.optLong(DBTableDefine.GroupMemberColumns.COLUMN_JOIN_TIME);
                        long optLong3 = jSONObject2.optLong("uk");
                        int optInt2 = jSONObject2.optInt("status", -1);
                        GroupMember groupMember = new GroupMember(String.valueOf(IMAddGroupMemberRequest.this.mGroupId), optLong3, "", optLong, optInt, optLong2);
                        groupMember.setAddStatus(optInt2);
                        arrayList.add(groupMember);
                    }
                    ArrayList arrayList2 = new ArrayList();
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        GroupMember groupMember2 = (GroupMember) it.next();
                        if (groupMember2.getAddStatus() == 0) {
                            arrayList2.add(groupMember2);
                        }
                    }
                    String str2 = IMAddGroupMemberRequest.TAG;
                    LogUtils.d(str2, "FXF add group member " + arrayList.size());
                    GroupInfoDAOImpl.addMemberToGroup(IMAddGroupMemberRequest.this.mContext, String.valueOf(IMAddGroupMemberRequest.this.mGroupId), arrayList);
                }
            } catch (JSONException e2) {
                LogUtils.e(LogUtils.TAG, "IMCreateGroupRequest JSONException", e2);
                i = 1010;
                new IMTrack.CrashBuilder(IMAddGroupMemberRequest.this.mContext).exception(Log.getStackTraceString(e2)).build();
                str = Constants.ERROR_MSG_JSON_PARSE_EXCEPTION;
            }
            if (i != 0) {
                IMListener removeListener = ListenerManager.getInstance().removeListener(IMAddGroupMemberRequest.this.mKey);
                if (removeListener == null || !(removeListener instanceof BIMValueCallBack)) {
                    return;
                }
                if (IMAddGroupMemberRequest.this.isCreateGroup) {
                    CreateResultInfo createResultInfo = new CreateResultInfo();
                    createResultInfo.groupid = String.valueOf(IMAddGroupMemberRequest.this.mGroupId);
                    ((BIMValueCallBack) removeListener).onResult(0, str, createResultInfo);
                    return;
                }
                ((BIMValueCallBack) removeListener).onResult(i, str, null);
            } else if (IMAddGroupMemberRequest.this.isCreateGroup) {
                ArrayList arrayList3 = new ArrayList();
                arrayList3.add(String.valueOf(IMAddGroupMemberRequest.this.mGroupId));
                IMQueryGroupRequest iMQueryGroupRequest = new IMQueryGroupRequest(IMAddGroupMemberRequest.this.mContext, IMAddGroupMemberRequest.this.mKey, IMAddGroupMemberRequest.this.mAppid, arrayList3, true, arrayList);
                HttpHelper.executor(IMAddGroupMemberRequest.this.mContext, iMQueryGroupRequest, iMQueryGroupRequest);
            } else {
                ((BIMValueCallBack) ListenerManager.getInstance().removeListener(IMAddGroupMemberRequest.this.mKey)).onResult(0, str, arrayList);
            }
        }
    }

    public IMAddGroupMemberRequest(Context context, String str, long j, long j2, ArrayList<String> arrayList, boolean z) {
        this.isCreateGroup = false;
        this.mContext = context;
        this.mAppid = j;
        this.mKey = str;
        this.mMembers = arrayList;
        this.mGroupId = j2;
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
        sb.append("method=add_member");
        sb.append("&appid=");
        sb.append(this.mAppid);
        sb.append("&group_id=");
        sb.append(this.mGroupId);
        sb.append("&timestamp=");
        sb.append(currentTimeMillis);
        sb.append("&sign=");
        sb.append(getMd5("" + currentTimeMillis + bduss + this.mAppid));
        ArrayList<String> arrayList = this.mMembers;
        if (arrayList != null && arrayList.size() > 0) {
            JSONArray jSONArray = new JSONArray();
            Iterator<String> it = this.mMembers.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next());
            }
            sb.append("&members=");
            sb.append(jSONArray.toString());
        }
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
            createResultInfo.groupid = String.valueOf(this.mGroupId);
            ((BIMValueCallBack) removeListener).onResult(0, (String) transErrorCode.second, createResultInfo);
            return;
        }
        ((BIMValueCallBack) removeListener).onResult(((Integer) transErrorCode.first).intValue(), (String) transErrorCode.second, null);
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onSuccess(int i, byte[] bArr) {
        String str = new String(bArr);
        String str2 = TAG;
        LogUtils.d(str2, "json is " + str);
        TaskManager.getInstance(this.mContext).submitForNetWork(new Mytask(this.mContext, this.mKey, str));
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public boolean shouldAbort() {
        return false;
    }
}
