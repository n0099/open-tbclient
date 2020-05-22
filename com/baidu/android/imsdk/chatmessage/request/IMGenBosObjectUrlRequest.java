package com.baidu.android.imsdk.chatmessage.request;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.webkit.CookieManager;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.upload.AsyncChatTask;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.HttpHelper;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class IMGenBosObjectUrlRequest implements HttpHelper.Request, HttpHelper.ResponseHandler {
    private String mContentType;
    private Context mContext;
    private String mFilePath;
    private String mFormat;
    private String mKey;
    private int mOriHeight;
    private int mOriWidth;
    private int mReqSource;

    public IMGenBosObjectUrlRequest(Context context, String str, String str2, String str3, int i, int i2, int i3, String str4) {
        this.mContext = context;
        this.mKey = str4;
        this.mFilePath = str;
        this.mContentType = str2;
        this.mFormat = str3;
        this.mReqSource = i;
        this.mOriWidth = i2;
        this.mOriHeight = i3;
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onSuccess(int i, byte[] bArr) {
        String str;
        String str2;
        int i2;
        String str3;
        HashMap hashMap;
        int i3;
        HashMap hashMap2;
        String str4;
        String string;
        String str5 = null;
        String str6 = new String(bArr);
        LogUtils.d("IMGenBosObjectUrlRequest", str6);
        try {
            JSONObject jSONObject = new JSONObject(str6);
            if (jSONObject.has("response_params")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("response_params");
                int i4 = jSONObject2.getInt("error_code");
                String string2 = jSONObject2.getString("authorization");
                try {
                    string = jSONObject2.getString("date");
                } catch (JSONException e) {
                    e = e;
                    str = null;
                    str2 = string2;
                }
                try {
                    hashMap2 = new HashMap();
                    hashMap2.put(AsyncChatTask.PUT_URL, jSONObject2.getString(AsyncChatTask.PUT_URL));
                    hashMap2.put(AsyncChatTask.GET_URL, jSONObject2.getString(AsyncChatTask.GET_URL));
                    if (jSONObject2.has(AsyncChatTask.THUMB_URL)) {
                        hashMap2.put(AsyncChatTask.THUMB_URL, jSONObject2.getString(AsyncChatTask.THUMB_URL));
                    }
                    if (jSONObject2.has("thumb_width")) {
                        hashMap2.put("thumb_width", jSONObject2.getString("thumb_width"));
                    }
                    if (jSONObject2.has("thumb_height")) {
                        hashMap2.put("thumb_height", jSONObject2.getString("thumb_height"));
                    }
                    str5 = string;
                    str4 = string2;
                    str3 = Constants.ERROR_MSG_SUCCESS;
                    i3 = i4;
                } catch (JSONException e2) {
                    e = e2;
                    str = string;
                    str2 = string2;
                    LogUtils.e("IMGenBosObjectUrlRequest", e.getMessage(), e);
                    i2 = 1010;
                    str3 = Constants.ERROR_MSG_JSON_PARSE_EXCEPTION;
                    new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                    hashMap = null;
                    ChatMsgManagerImpl.getInstance(this.mContext).onGenBosObjectUrl(this.mKey, i2, str3, str2, str, hashMap);
                }
            } else {
                int i5 = jSONObject.getInt("error_code");
                str3 = jSONObject.getString("error_msg");
                i3 = i5;
                hashMap2 = null;
                str4 = null;
            }
            hashMap = hashMap2;
            str = str5;
            String str7 = str4;
            i2 = i3;
            str2 = str7;
        } catch (JSONException e3) {
            e = e3;
            str = null;
            str2 = null;
        }
        ChatMsgManagerImpl.getInstance(this.mContext).onGenBosObjectUrl(this.mKey, i2, str3, str2, str, hashMap);
    }

    public Pair<Integer, String> transErrorCode(int i, byte[] bArr, Throwable th) {
        String str;
        if (th == null) {
            if (i == 1005) {
                str = new String(bArr);
            } else {
                str = "http response is error! response code:" + i;
                i = 1011;
            }
        } else {
            i = 1012;
            str = Constants.ERROR_MSG_HTTP_IOEXCEPTION_ERROR;
        }
        return new Pair<>(Integer.valueOf(i), str);
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onFailure(int i, byte[] bArr, Throwable th) {
        Pair<Integer, String> transErrorCode = transErrorCode(i, bArr, th);
        LogUtils.d("", "IMGenBosObjectUrlRequest onFailure " + transErrorCode.first);
        ChatMsgManagerImpl.getInstance(this.mContext).onGenBosObjectUrl(this.mKey, ((Integer) transErrorCode.first).intValue(), (String) transErrorCode.second, null, null, null);
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getHost() {
        switch (Utility.readIntData(this.mContext, Constants.KEY_ENV, 0)) {
            case 0:
                return "https://pim.baidu.com/rest/3.0/im/bos/generate_bos_url";
            case 1:
            case 2:
                return "http://cp01-ocean-749.epc.baidu.com:8111/rest/3.0/im/bos/generate_bos_url";
            case 3:
                return "http://180.97.36.95:8080/rest/3.0/im/bos/generate_bos_url";
            default:
                return "https://pim.baidu.com/rest/3.0/im/bos/generate_bos_url";
        }
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getMethod() {
        return "POST";
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public byte[] getRequestParameter() {
        StringBuilder sb = new StringBuilder();
        long appid = AccountManager.getAppid(this.mContext);
        sb.append("&appid=" + appid);
        sb.append("&uk=").append(AccountManager.getUK(this.mContext));
        sb.append("&content_length=" + new File(this.mFilePath).length());
        if (!TextUtils.isEmpty(this.mContentType)) {
            try {
                sb.append("&content_type=" + URLEncoder.encode(this.mContentType, "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                LogUtils.e("IMGenBosObjectUrlRequest", e.getMessage(), e);
                sb.append("&content_type=" + URLEncoder.encode(this.mContentType));
                new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
            }
        }
        sb.append("&format=" + this.mFormat);
        sb.append("&api_version=1");
        sb.append("&req_source=" + this.mReqSource);
        sb.append("&img_width=" + this.mOriWidth);
        sb.append("&img_height=" + this.mOriHeight);
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        sb.append("&timestamp=" + currentTimeMillis);
        String str = "";
        try {
            str = getMd5("" + currentTimeMillis + IMConfigInternal.getInstance().getIMConfig(this.mContext).getBduss(this.mContext) + appid);
        } catch (Exception e2) {
            LogUtils.e(getClass().getSimpleName(), "Exception ", e2);
            new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e2)).build();
        }
        sb.append("&sign=" + str);
        return sb.toString().getBytes();
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getContentType() {
        return "application/x-www-form-urlencoded";
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public Map<String, String> getHeaders() {
        HashMap hashMap = new HashMap();
        try {
            String bduss = IMConfigInternal.getInstance().getIMConfig(this.mContext).getBduss(this.mContext);
            CookieManager cookieManager = CookieManager.getInstance();
            cookieManager.setCookie("baidu.com", "BDUSS=" + bduss);
            hashMap.put("cookie", cookieManager.getCookie("baidu.com"));
        } catch (Exception e) {
            LogUtils.e("IMGenBosObjectUrlRequest", "set bduss exception");
            new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
        }
        return hashMap;
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public boolean shouldAbort() {
        return false;
    }

    public String getMd5(String str) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        messageDigest.update(str.getBytes());
        return Utility.byte2Hex(messageDigest.digest());
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public int getConnectTimeout() {
        return 15000;
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public int getReadTimeout() {
        return 15000;
    }
}
