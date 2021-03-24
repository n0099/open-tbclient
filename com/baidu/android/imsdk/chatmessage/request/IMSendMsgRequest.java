package com.baidu.android.imsdk.chatmessage.request;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.utils.BaseHttpRequest;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class IMSendMsgRequest extends BaseHttpRequest {
    public static final String TAG = "IMSendMsgRequest";
    public String key;
    public ChatMsg msg;

    public IMSendMsgRequest(Context context, ChatMsg chatMsg, String str) {
        this.mContext = context;
        this.msg = chatMsg;
        this.key = str;
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getContentType() {
        return "application/x-www-form-urlencoded";
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public Map<String, String> getHeaders() {
        HashMap hashMap = new HashMap();
        String bduss = IMConfigInternal.getInstance().getIMConfig(this.mContext).getBduss(this.mContext);
        if (!TextUtils.isEmpty(bduss)) {
            hashMap.put("Cookie", "BDUSS=" + bduss);
        }
        return hashMap;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getHost() {
        int readIntData = Utility.readIntData(this.mContext, Constants.KEY_ENV, 0);
        String str = "https://pim.baidu.com/";
        if (readIntData != 0) {
            if (readIntData == 1 || readIntData == 2) {
                str = "http://rd-im-server.bcc-szth.baidu.com:8111/";
            } else if (readIntData == 3) {
                str = Constants.URL_HTTP_BOX;
            }
        }
        boolean isStudioHostSendMsg = Utility.isStudioHostSendMsg(this.mContext);
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("imsapi/1.0/send_mcast_msg/");
        sb.append(isStudioHostSendMsg ? "liveshowhost" : "liveshowuser");
        return sb.toString();
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getMethod() {
        return "POST";
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public byte[] getRequestParameter() throws NoSuchAlgorithmException {
        StringBuilder sb = new StringBuilder();
        sb.append("appid=");
        sb.append(Utility.readAppId(this.mContext));
        sb.append("&sdk_version=");
        sb.append(IMConfigInternal.getInstance().getSDKVersionValue(this.mContext));
        sb.append("&app_version=");
        sb.append(Utility.getAppVersionName(this.mContext));
        sb.append("&device_type=android");
        sb.append("&cuid=");
        sb.append(Utility.getDeviceId(this.mContext));
        sb.append("&mcast_id=");
        sb.append(this.msg.getContacter());
        sb.append("&content=");
        sb.append(this.msg.getMsgContent());
        sb.append("&msg_key=");
        sb.append(this.msg.getMsgKey());
        sb.append("&msg_type=");
        sb.append(this.msg.getMsgType());
        sb.append("&timestamp=");
        sb.append(System.currentTimeMillis() / 1000);
        String[] split = sb.toString().split("&");
        Arrays.sort(split);
        String str = "";
        for (String str2 : split) {
            str = str + str2;
        }
        LogUtils.d(TAG, "smd5: " + str);
        sb.append("&sign=");
        sb.append(getMd5(str));
        return sb.toString().getBytes();
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onFailure(int i, byte[] bArr, Throwable th) {
        Pair<Integer, String> transErrorCode = transErrorCode(i, bArr, th);
        LogUtils.d(TAG, "onFailure errorCode: " + transErrorCode.first);
        ChatMsgManagerImpl.getInstance(this.mContext).onSendMessageResult(((Integer) transErrorCode.first).intValue(), this.msg, -1L, this.key);
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onSuccess(int i, byte[] bArr) {
        int i2;
        String str = new String(bArr);
        LogUtils.d(TAG, "onSuccess :" + str);
        try {
            i2 = new JSONObject(str).getInt("error_code");
        } catch (Exception e2) {
            LogUtils.e(TAG, "JSONException", e2);
            i2 = 1010;
        }
        ChatMsgManagerImpl.getInstance(this.mContext).onSendMessageResult(i2, this.msg, System.currentTimeMillis(), this.key);
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public boolean shouldAbort() {
        return false;
    }
}
