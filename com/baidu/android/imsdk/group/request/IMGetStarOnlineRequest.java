package com.baidu.android.imsdk.group.request;

import android.content.Context;
import android.util.Log;
import android.util.Pair;
import com.baidu.android.imsdk.IMListener;
import com.baidu.android.imsdk.group.BIMValueCallBack;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.internal.ListenerManager;
import com.baidu.android.imsdk.task.TaskManager;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.live.tbadk.core.atomdata.AlaCharmCardActivityConfig;
import java.security.NoSuchAlgorithmException;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class IMGetStarOnlineRequest extends GroupBaseHttpRequest {
    private static final String TAG = IMGetStarOnlineRequest.class.getSimpleName();
    private long mAppid;
    private String mGroupId;
    private String mKey;

    /* loaded from: classes3.dex */
    class Mytask extends TaskManager.Task {
        public Mytask(String str, String str2) {
            super(str, str2);
        }

        @Override // com.baidu.android.imsdk.task.TaskManager.Task, java.lang.Runnable
        public void run() {
            int i;
            String str;
            int i2;
            int i3 = 0;
            try {
                JSONObject jSONObject = new JSONObject(this.mJson);
                int i4 = jSONObject.getInt("error_code");
                String optString = jSONObject.optString("error_msg", "");
                if (i4 == 0 && jSONObject.has("response_params")) {
                    i3 = jSONObject.getJSONObject("response_params").getInt(AlaCharmCardActivityConfig.ONLINE_COUNT);
                }
                i = i4;
                str = optString;
                i2 = i3;
            } catch (JSONException e) {
                LogUtils.e(LogUtils.TAG, "IMCreateGroupRequest JSONException", e);
                new IMTrack.CrashBuilder(IMGetStarOnlineRequest.this.mContext).exception(Log.getStackTraceString(e)).build();
                i = 1010;
                str = Constants.ERROR_MSG_JSON_PARSE_EXCEPTION;
                i2 = 0;
            }
            IMListener removeListener = ListenerManager.getInstance().removeListener(IMGetStarOnlineRequest.this.mKey);
            if (removeListener != null && (removeListener instanceof BIMValueCallBack)) {
                ((BIMValueCallBack) removeListener).onResult(i, str, Integer.valueOf(i2));
            }
        }
    }

    public IMGetStarOnlineRequest(Context context, String str, long j, String str2) {
        this.mContext = context;
        this.mAppid = j;
        this.mKey = str;
        this.mGroupId = str2;
    }

    @Override // com.baidu.android.imsdk.group.request.GroupBaseHttpRequest, com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getHost() {
        if (getHostUrl() == null) {
            return null;
        }
        return getHostUrl() + "rest/2.0/im/chatroom";
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public byte[] getRequestParameter() throws NoSuchAlgorithmException {
        String bduss = IMConfigInternal.getInstance().getIMConfig(this.mContext).getBduss(this.mContext);
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        StringBuilder sb = new StringBuilder();
        sb.append("method=get_online_count");
        sb.append("&appid=").append(this.mAppid);
        sb.append("&group_id=").append(this.mGroupId);
        sb.append("&timestamp=").append(currentTimeMillis);
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
        LogUtils.d(TAG, "json is " + str);
        TaskManager.getInstance(this.mContext).submitForNetWork(new Mytask(this.mKey, str));
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onFailure(int i, byte[] bArr, Throwable th) {
        Pair<Integer, String> transErrorCode = transErrorCode(i, bArr, th);
        IMListener removeListener = ListenerManager.getInstance().removeListener(this.mKey);
        if (removeListener != null && (removeListener instanceof BIMValueCallBack)) {
            ((BIMValueCallBack) removeListener).onResult(((Integer) transErrorCode.first).intValue(), (String) transErrorCode.second, -1);
        }
    }
}
