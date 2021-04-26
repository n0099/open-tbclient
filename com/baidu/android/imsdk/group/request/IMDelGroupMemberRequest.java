package com.baidu.android.imsdk.group.request;

import android.content.Context;
import android.util.Log;
import android.util.Pair;
import com.baidu.android.imsdk.IMListener;
import com.baidu.android.imsdk.group.BIMValueCallBack;
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
/* loaded from: classes.dex */
public class IMDelGroupMemberRequest extends GroupBaseHttpRequest {
    public static final String TAG = "IMDelGroupMemberRequest";
    public long mAppid;
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
                        arrayList.add(String.valueOf(jSONArray.getJSONObject(i3).optLong("bd_uid")));
                    }
                }
            } catch (JSONException e2) {
                LogUtils.e(LogUtils.TAG, "IMCreateGroupRequest JSONException", e2);
                i2 = 1010;
                new IMTrack.CrashBuilder(IMDelGroupMemberRequest.this.mContext).exception(Log.getStackTraceString(e2)).build();
                str = Constants.ERROR_MSG_JSON_PARSE_EXCEPTION;
            }
            if (i2 == 0) {
                GroupInfoDAOImpl.delGroupMember(IMDelGroupMemberRequest.this.mContext, IMDelGroupMemberRequest.this.mGroupId, arrayList);
            }
            IMListener removeListener = ListenerManager.getInstance().removeListener(IMDelGroupMemberRequest.this.mKey);
            if (removeListener == null || !(removeListener instanceof BIMValueCallBack)) {
                return;
            }
            ((BIMValueCallBack) removeListener).onResult(i2, str, arrayList);
        }
    }

    public IMDelGroupMemberRequest(Context context, String str, long j, String str2, ArrayList<String> arrayList) {
        this.mContext = context;
        this.mAppid = j;
        this.mKey = str;
        this.mGroupId = str2;
        this.mBuids = arrayList;
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
        sb.append("method=delete_members");
        sb.append("&appid=");
        sb.append(this.mAppid);
        sb.append("&group_id=");
        sb.append(this.mGroupId);
        JSONArray jSONArray = new JSONArray();
        Iterator<String> it = this.mBuids.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next());
        }
        sb.append("&members=");
        sb.append(jSONArray.toString());
        sb.append("&timestamp=");
        sb.append(currentTimeMillis);
        sb.append("&sign=");
        sb.append(getMd5("" + currentTimeMillis + bduss + this.mAppid));
        return sb.toString().getBytes();
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onFailure(int i2, byte[] bArr, Throwable th) {
        Pair<Integer, String> transErrorCode = transErrorCode(i2, bArr, th);
        IMListener removeListener = ListenerManager.getInstance().removeListener(this.mKey);
        if (removeListener == null || !(removeListener instanceof BIMValueCallBack)) {
            return;
        }
        ((BIMValueCallBack) removeListener).onResult(((Integer) transErrorCode.first).intValue(), (String) transErrorCode.second, new ArrayList());
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onSuccess(int i2, byte[] bArr) {
        String str = new String(bArr);
        String str2 = TAG;
        LogUtils.d(str2, "json is " + str);
        TaskManager.getInstance(this.mContext).submitForNetWork(new Mytask(this.mKey, str));
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public boolean shouldAbort() {
        return false;
    }
}
