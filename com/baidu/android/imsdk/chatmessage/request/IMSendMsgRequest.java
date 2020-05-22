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
import com.baidu.webkit.internal.ETAG;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.cookie.SM;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class IMSendMsgRequest extends BaseHttpRequest {
    private static final String TAG = "IMSendMsgRequest";
    private String key;
    private ChatMsg msg;

    public IMSendMsgRequest(Context context, ChatMsg chatMsg, String str) {
        this.mContext = context;
        this.msg = chatMsg;
        this.key = str;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onSuccess(int i, byte[] bArr) {
        int i2;
        String str = new String(bArr);
        LogUtils.d(TAG, "onSuccess :" + str);
        try {
            i2 = new JSONObject(str).getInt("error_code");
        } catch (Exception e) {
            LogUtils.e(TAG, "JSONException", e);
            i2 = 1010;
        }
        ChatMsgManagerImpl.getInstance(this.mContext).onSendMessageResult(i2, this.msg, System.currentTimeMillis(), this.key);
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onFailure(int i, byte[] bArr, Throwable th) {
        Pair<Integer, String> transErrorCode = transErrorCode(i, bArr, th);
        LogUtils.d(TAG, "onFailure errorCode: " + transErrorCode.first);
        ChatMsgManagerImpl.getInstance(this.mContext).onSendMessageResult(((Integer) transErrorCode.first).intValue(), this.msg, -1L, this.key);
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getHost() {
        String str = Constants.URL_HTTP_ONLINE;
        switch (Utility.readIntData(this.mContext, Constants.KEY_ENV, 0)) {
            case 0:
                str = Constants.URL_HTTP_ONLINE;
                break;
            case 1:
            case 2:
                str = "http://cp01-ocean-749.epc.baidu.com:8111/";
                break;
            case 3:
                str = Constants.URL_HTTP_BOX;
                break;
        }
        return str + "imsapi/1.0/send_mcast_msg/" + (Utility.isStudioHostSendMsg(this.mContext) ? "liveshowhost" : "liveshowuser");
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getMethod() {
        return "POST";
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public byte[] getRequestParameter() throws NoSuchAlgorithmException {
        StringBuilder sb = new StringBuilder();
        sb.append("appid=").append(Utility.readAppId(this.mContext));
        sb.append("&sdk_version=").append(IMConfigInternal.getInstance().getSDKVersionValue(this.mContext));
        sb.append("&app_version=").append(Utility.getAppVersionName(this.mContext));
        sb.append("&device_type=android");
        sb.append("&cuid=").append(Utility.getDeviceId(this.mContext));
        sb.append("&mcast_id=").append(this.msg.getContacter());
        sb.append("&content=").append(this.msg.getMsgContent());
        sb.append("&msg_key=").append(this.msg.getMsgKey());
        sb.append("&msg_type=").append(this.msg.getMsgType());
        sb.append("&timestamp=").append(System.currentTimeMillis() / 1000);
        String[] split = sb.toString().split(ETAG.ITEM_SEPARATOR);
        Arrays.sort(split);
        String str = "";
        for (int i = 0; i < split.length; i++) {
            str = str + split[i];
        }
        LogUtils.d(TAG, "smd5: " + str);
        sb.append("&sign=").append(getMd5(str));
        return sb.toString().getBytes();
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public Map<String, String> getHeaders() {
        HashMap hashMap = new HashMap();
        String bduss = IMConfigInternal.getInstance().getIMConfig(this.mContext).getBduss(this.mContext);
        if (!TextUtils.isEmpty(bduss)) {
            hashMap.put(SM.COOKIE, "BDUSS=" + bduss);
        }
        return hashMap;
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public boolean shouldAbort() {
        return false;
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getContentType() {
        return "application/x-www-form-urlencoded";
    }
}
