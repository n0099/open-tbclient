package com.baidu.android.imsdk.group.request;

import android.content.Context;
import android.util.Log;
import android.util.Pair;
import com.baidu.android.imsdk.IMListener;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.group.BIMValueCallBack;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.internal.ListenerManager;
import com.baidu.android.imsdk.task.TaskManager;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import java.security.NoSuchAlgorithmException;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class IMJoinGroupRequest extends FansGroupBaseHttpRequest {
    public static final String TAG = "IMJoinGroupRequest";
    public int mChannel;
    public String mGroupId;
    public long mInviterbuid;
    public boolean mIsFansGroup;
    public String mKey;
    public String mWhy;

    /* loaded from: classes.dex */
    public class Mytask extends TaskManager.Task {
        public Mytask(Context context, String str, String str2) {
            super(str, str2);
        }

        @Override // com.baidu.android.imsdk.task.TaskManager.Task, java.lang.Runnable
        public void run() {
            int i2;
            String str;
            try {
                JSONObject jSONObject = new JSONObject(this.mJson);
                i2 = jSONObject.getInt("error_code");
                str = jSONObject.optString("error_msg", "");
            } catch (JSONException e2) {
                LogUtils.e(LogUtils.TAG, "IMCreateGroupRequest JSONException", e2);
                i2 = 1010;
                new IMTrack.CrashBuilder(IMJoinGroupRequest.this.mContext).exception(Log.getStackTraceString(e2)).build();
                str = Constants.ERROR_MSG_JSON_PARSE_EXCEPTION;
            }
            IMListener removeListener = ListenerManager.getInstance().removeListener(IMJoinGroupRequest.this.mKey);
            if (removeListener instanceof BIMValueCallBack) {
                ((BIMValueCallBack) removeListener).onResult(i2, str, IMJoinGroupRequest.this.mGroupId);
            }
        }
    }

    public IMJoinGroupRequest(Context context, String str, boolean z, String str2, long j, int i2, String str3) {
        this.mContext = context;
        this.mKey = str;
        this.mIsFansGroup = z;
        this.mInviterbuid = j;
        this.mGroupId = str2;
        this.mChannel = i2;
        this.mWhy = str3;
    }

    private String getFansGroupRequestParam() throws NoSuchAlgorithmException {
        StringBuilder sb = new StringBuilder();
        sb.append("method=join");
        sb.append("&group_id=");
        sb.append(this.mGroupId);
        sb.append("&channel=");
        sb.append(this.mChannel);
        if (this.mInviterbuid > 0) {
            sb.append("&invitor_uk=");
            sb.append(Utility.transBDUID(String.valueOf(this.mInviterbuid)));
        }
        sb.append(getCommonParams());
        return sb.toString();
    }

    private String getNormalGroupRequestParam() throws NoSuchAlgorithmException {
        String bduss = IMConfigInternal.getInstance().getIMConfig(this.mContext).getBduss(this.mContext);
        long appid = AccountManager.getAppid(this.mContext);
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        StringBuilder sb = new StringBuilder();
        sb.append("method=join");
        sb.append("&appid=");
        sb.append(appid);
        sb.append("&group_id=");
        sb.append(this.mGroupId);
        sb.append("&timestamp=");
        sb.append(currentTimeMillis);
        sb.append("&sign=");
        sb.append(getMd5("" + currentTimeMillis + bduss + appid));
        if (this.mInviterbuid > 0) {
            sb.append("&inviter=");
            sb.append(this.mInviterbuid);
        }
        if (this.mWhy != null) {
            sb.append("&msg=");
            sb.append(this.mWhy);
        }
        sb.append("&channel=");
        sb.append(this.mChannel);
        return sb.toString();
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getContentType() {
        return "application/x-www-form-urlencoded";
    }

    @Override // com.baidu.android.imsdk.group.request.FansGroupBaseHttpRequest, com.baidu.android.imsdk.group.request.GroupBaseHttpRequest, com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getHost() {
        if (getHostUrl() == null) {
            return null;
        }
        if (this.mIsFansGroup) {
            return getHostUrl() + "rest/2.0/im/groupchatv1";
        }
        return getHostUrl() + "rest/2.0/im/groupchat";
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public byte[] getRequestParameter() throws NoSuchAlgorithmException {
        if (this.mIsFansGroup) {
            return getFansGroupRequestParam().getBytes();
        }
        return getNormalGroupRequestParam().getBytes();
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onFailure(int i2, byte[] bArr, Throwable th) {
        Pair<Integer, String> transErrorCode = transErrorCode(i2, bArr, th);
        IMListener removeListener = ListenerManager.getInstance().removeListener(this.mKey);
        if (removeListener == null || !(removeListener instanceof BIMValueCallBack)) {
            return;
        }
        ((BIMValueCallBack) removeListener).onResult(((Integer) transErrorCode.first).intValue(), (String) transErrorCode.second, this.mGroupId);
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onSuccess(int i2, byte[] bArr) {
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
