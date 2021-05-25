package com.baidu.android.imsdk.group.request;

import android.content.Context;
import android.util.Log;
import android.util.Pair;
import com.baidu.android.imsdk.IMListener;
import com.baidu.android.imsdk.db.DBTableDefine;
import com.baidu.android.imsdk.group.BIMValueCallBack;
import com.baidu.android.imsdk.group.GroupMember;
import com.baidu.android.imsdk.group.db.GroupInfoDAOImpl;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.ListenerManager;
import com.baidu.android.imsdk.task.TaskManager;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class IMQueryFansMemberRequest extends FansGroupBaseHttpRequest {
    public static final String TAG = "IMQueryFansMemberRequest";
    public ArrayList<String> mBuids;
    public String mGroupId;
    public String mKey;

    /* loaded from: classes.dex */
    public class Mytask extends TaskManager.Task {
        public Mytask(String str, String str2) {
            super(str, str2);
        }

        @Override // com.baidu.android.imsdk.task.TaskManager.Task, java.lang.Runnable
        public void run() {
            int i2;
            String str;
            ArrayList arrayList = new ArrayList();
            try {
                JSONObject jSONObject = new JSONObject(this.mJson);
                i2 = jSONObject.getInt("error_code");
                str = jSONObject.optString("error_msg", "");
                if (i2 == 0 && jSONObject.has("response_params")) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("response_params");
                    JSONArray jSONArray = jSONObject2.getJSONArray("members");
                    int i3 = 0;
                    int i4 = 0;
                    while (i4 < jSONArray.length()) {
                        JSONObject jSONObject3 = jSONArray.getJSONObject(i4);
                        long optLong = jSONObject3.optLong("bd_uid");
                        int optInt = jSONObject3.optInt("role");
                        long optLong2 = jSONObject3.optLong(DBTableDefine.GroupMemberColumns.COLUMN_JOIN_TIME);
                        long optLong3 = jSONObject3.optLong("uk");
                        String optString = jSONObject3.optString("avatar");
                        String optString2 = jSONObject3.optString("display_name");
                        String optString3 = jSONObject3.optString("name");
                        if (jSONObject3.optInt("status", i3) != 1) {
                            GroupMember groupMember = new GroupMember(String.valueOf(IMQueryFansMemberRequest.this.mGroupId), optLong3, optString2, optLong, optInt, optLong2);
                            groupMember.setPortrait(optString);
                            groupMember.setNickName(optString3);
                            arrayList.add(groupMember);
                        }
                        i4++;
                        i3 = 0;
                    }
                    if (IMQueryFansMemberRequest.this.mBuids != null && IMQueryFansMemberRequest.this.mBuids.size() != 0) {
                        if (GroupInfoDAOImpl.delGroupMember(IMQueryFansMemberRequest.this.mContext, IMQueryFansMemberRequest.this.mGroupId, IMQueryFansMemberRequest.this.mBuids) > 0) {
                            GroupInfoDAOImpl.addMemberToGroup(IMQueryFansMemberRequest.this.mContext, IMQueryFansMemberRequest.this.mGroupId, arrayList);
                        }
                    }
                    GroupInfoDAOImpl.delAllGroupMember(IMQueryFansMemberRequest.this.mContext, IMQueryFansMemberRequest.this.mGroupId);
                    GroupInfoDAOImpl.addMemberToGroup(IMQueryFansMemberRequest.this.mContext, IMQueryFansMemberRequest.this.mGroupId, arrayList);
                    GroupInfoDAOImpl.modifyGroupMemberVersion(IMQueryFansMemberRequest.this.mContext, IMQueryFansMemberRequest.this.mGroupId, jSONObject2.optLong("member_version"), System.currentTimeMillis());
                    GroupInfoDAOImpl.modifyGroupMemberNumber(IMQueryFansMemberRequest.this.mContext, IMQueryFansMemberRequest.this.mGroupId, jSONObject2.optInt("member_count"));
                }
            } catch (JSONException e2) {
                LogUtils.e(LogUtils.TAG, "IMCreateGroupRequest JSONException", e2);
                i2 = 1010;
                new IMTrack.CrashBuilder(IMQueryFansMemberRequest.this.mContext).exception(Log.getStackTraceString(e2)).build();
                str = Constants.ERROR_MSG_JSON_PARSE_EXCEPTION;
            }
            IMListener removeListener = ListenerManager.getInstance().removeListener(IMQueryFansMemberRequest.this.mKey);
            if (removeListener instanceof BIMValueCallBack) {
                ((BIMValueCallBack) removeListener).onResult(i2, str, arrayList);
            }
        }
    }

    public IMQueryFansMemberRequest(Context context, String str, String str2, ArrayList<String> arrayList) {
        this.mContext = context;
        this.mKey = str;
        this.mBuids = arrayList;
        this.mGroupId = str2;
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getContentType() {
        return "application/x-www-form-urlencoded";
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public byte[] getRequestParameter() throws NoSuchAlgorithmException {
        StringBuilder sb = new StringBuilder();
        sb.append("method=get_members");
        sb.append("&group_id=");
        sb.append(this.mGroupId);
        ArrayList<String> arrayList = this.mBuids;
        if (arrayList != null && arrayList.size() > 0) {
            JSONArray jSONArray = new JSONArray();
            Iterator<String> it = this.mBuids.iterator();
            while (it.hasNext()) {
                jSONArray.put(Utility.transBDUID(it.next()));
            }
            sb.append("&members=");
            sb.append(jSONArray.toString());
        }
        sb.append(getCommonParams());
        return sb.toString().getBytes();
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onFailure(int i2, byte[] bArr, Throwable th) {
        Pair<Integer, String> transErrorCode = transErrorCode(i2, bArr, th);
        IMListener removeListener = ListenerManager.getInstance().removeListener(this.mKey);
        if (removeListener instanceof BIMValueCallBack) {
            ((BIMValueCallBack) removeListener).onResult(((Integer) transErrorCode.first).intValue(), (String) transErrorCode.second, null);
        }
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onSuccess(int i2, byte[] bArr) {
        String str = new String(bArr);
        LogUtils.d(TAG, "json is groupid " + this.mGroupId + str);
        TaskManager.getInstance(this.mContext).submitForNetWork(new Mytask(this.mKey, str));
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public boolean shouldAbort() {
        return false;
    }
}
