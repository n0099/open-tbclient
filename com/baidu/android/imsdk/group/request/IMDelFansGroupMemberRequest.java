package com.baidu.android.imsdk.group.request;

import android.content.Context;
import android.util.Log;
import android.util.Pair;
import com.baidu.android.imsdk.IMListener;
import com.baidu.android.imsdk.group.BIMValueCallBack;
import com.baidu.android.imsdk.group.GroupInfo;
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
public class IMDelFansGroupMemberRequest extends FansGroupBaseHttpRequest {
    public static final String TAG = "IMDelFansGroupMemberRequest";
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
                    JSONArray jSONArray = jSONObject.getJSONObject("response_params").getJSONArray("members");
                    for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i3);
                        long optLong = jSONObject2.optLong("bd_uid");
                        if (jSONObject2.optInt("status") == 0) {
                            arrayList.add(String.valueOf(optLong));
                        }
                    }
                    int delGroupMember = GroupInfoDAOImpl.delGroupMember(IMDelFansGroupMemberRequest.this.mContext, IMDelFansGroupMemberRequest.this.mGroupId, arrayList);
                    if (delGroupMember > 0) {
                        ArrayList arrayList2 = new ArrayList();
                        arrayList2.add(IMDelFansGroupMemberRequest.this.mGroupId);
                        ArrayList<GroupInfo> groupInfo = GroupInfoDAOImpl.getGroupInfo(IMDelFansGroupMemberRequest.this.mContext, arrayList2);
                        if (groupInfo != null && groupInfo.size() > 0) {
                            GroupInfoDAOImpl.modifyGroupMemberNumber(IMDelFansGroupMemberRequest.this.mContext, IMDelFansGroupMemberRequest.this.mGroupId, groupInfo.get(0).getNum() - delGroupMember);
                        }
                    }
                }
            } catch (JSONException e2) {
                LogUtils.e(LogUtils.TAG, "IMCreateGroupRequest JSONException", e2);
                i2 = 1010;
                new IMTrack.CrashBuilder(IMDelFansGroupMemberRequest.this.mContext).exception(Log.getStackTraceString(e2)).build();
                str = Constants.ERROR_MSG_JSON_PARSE_EXCEPTION;
            }
            IMListener removeListener = ListenerManager.getInstance().removeListener(IMDelFansGroupMemberRequest.this.mKey);
            if (removeListener instanceof BIMValueCallBack) {
                ((BIMValueCallBack) removeListener).onResult(i2, str, arrayList);
            }
        }
    }

    public IMDelFansGroupMemberRequest(Context context, String str, ArrayList<String> arrayList, String str2) {
        this.mContext = context;
        this.mKey = str2;
        this.mGroupId = str;
        this.mBuids = arrayList;
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getContentType() {
        return "application/x-www-form-urlencoded";
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public byte[] getRequestParameter() throws NoSuchAlgorithmException {
        StringBuilder sb = new StringBuilder();
        sb.append("method=delete_members");
        sb.append("&group_id=");
        sb.append(this.mGroupId);
        JSONArray jSONArray = new JSONArray();
        Iterator<String> it = this.mBuids.iterator();
        while (it.hasNext()) {
            jSONArray.put(Utility.transBDUID(it.next()));
        }
        sb.append("&members=");
        sb.append(jSONArray.toString());
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
        LogUtils.d(TAG, "json is " + str);
        TaskManager.getInstance(this.mContext).submitForNetWork(new Mytask(this.mKey, str));
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public boolean shouldAbort() {
        return false;
    }
}
