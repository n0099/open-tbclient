package com.baidu.android.imsdk.chatmessage.request;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.webkit.CookieManager;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.upload.AsyncChatTask;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.HttpHelper;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.minivideo.plugin.capture.utils.EncryptUtils;
import java.io.File;
import java.io.InputStream;
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
        HashMap hashMap2;
        String string;
        int i3;
        String string2;
        String str4 = new String(bArr);
        LogUtils.d("IMGenBosObjectUrlRequest", str4);
        try {
            JSONObject jSONObject = new JSONObject(str4);
            if (jSONObject.has("response_params")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("response_params");
                i3 = jSONObject2.getInt("error_code");
                String string3 = jSONObject2.getString("authorization");
                try {
                    string2 = jSONObject2.getString("date");
                } catch (JSONException e) {
                    e = e;
                    str = null;
                    str2 = string3;
                }
                try {
                    hashMap2 = new HashMap();
                    hashMap2.put(AsyncChatTask.PUT_URL, jSONObject2.getString(AsyncChatTask.PUT_URL));
                    hashMap2.put(AsyncChatTask.GET_URL, jSONObject2.getString(AsyncChatTask.GET_URL));
                    if (jSONObject2.has("thumb_url")) {
                        hashMap2.put("thumb_url", jSONObject2.getString("thumb_url"));
                    }
                    if (jSONObject2.has("thumb_width")) {
                        hashMap2.put("thumb_width", jSONObject2.getString("thumb_width"));
                    }
                    if (jSONObject2.has("thumb_height")) {
                        hashMap2.put("thumb_height", jSONObject2.getString("thumb_height"));
                    }
                    str = string2;
                    str2 = string3;
                    string = Constants.ERROR_MSG_SUCCESS;
                } catch (JSONException e2) {
                    e = e2;
                    str = string2;
                    str2 = string3;
                    LogUtils.e("IMGenBosObjectUrlRequest", e.getMessage(), e);
                    i2 = 1010;
                    str3 = Constants.ERROR_MSG_JSON_PARSE_EXCEPTION;
                    new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                    hashMap = null;
                    ChatMsgManagerImpl.getInstance(this.mContext).onGenBosObjectUrl(this.mKey, i2, str3, str2, str, hashMap);
                }
            } else {
                int i4 = jSONObject.getInt("error_code");
                hashMap2 = null;
                str = null;
                str2 = null;
                string = jSONObject.getString("error_msg");
                i3 = i4;
            }
            hashMap = hashMap2;
            str3 = string;
            i2 = i3;
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
                return "http://rd-im-server.bcc-szth.baidu.com:8111/rest/3.0/im/bos/generate_bos_url";
            case 2:
                return "http://10.64.132.67:8080/rest/3.0/im/bos/generate_bos_url";
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
        long j = 0;
        if (Utility.isMediaUri(this.mFilePath)) {
            try {
                InputStream openInputStream = this.mContext.getContentResolver().openInputStream(Uri.parse(this.mFilePath));
                if (openInputStream != null) {
                    j = openInputStream.available();
                }
            } catch (Exception e) {
            }
        } else {
            j = new File(this.mFilePath).length();
        }
        sb.append("&content_length=" + j);
        if (!TextUtils.isEmpty(this.mContentType)) {
            try {
                sb.append("&content_type=" + URLEncoder.encode(this.mContentType, "UTF-8"));
            } catch (UnsupportedEncodingException e2) {
                LogUtils.e("IMGenBosObjectUrlRequest", e2.getMessage(), e2);
                sb.append("&content_type=" + URLEncoder.encode(this.mContentType));
                new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e2)).build();
            }
        }
        if (!TextUtils.isEmpty(this.mFormat)) {
            sb.append("&format=" + this.mFormat);
        }
        sb.append("&api_version=1");
        sb.append("&req_source=" + this.mReqSource);
        sb.append("&img_width=" + this.mOriWidth);
        sb.append("&img_height=" + this.mOriHeight);
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        sb.append("&timestamp=" + currentTimeMillis);
        sb.append("&account_type=");
        String bduss = IMConfigInternal.getInstance().getIMConfig(this.mContext).getBduss(this.mContext);
        if (AccountManager.isCuidLogin(this.mContext)) {
            sb.append(6);
            sb.append("&token=");
            sb.append(bduss);
        } else {
            sb.append(1);
        }
        String str = "";
        try {
            str = getMd5("" + currentTimeMillis + bduss + appid);
        } catch (Exception e3) {
            LogUtils.e(getClass().getSimpleName(), "Exception ", e3);
            new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e3)).build();
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
        MessageDigest messageDigest = MessageDigest.getInstance(EncryptUtils.ENCRYPT_MD5);
        messageDigest.update(str.getBytes());
        return Utility.byte2Hex(messageDigest.digest());
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public int getConnectTimeout() {
        return BdStatisticsManager.INIT_UPLOAD_TIME_INTERVAL;
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public int getReadTimeout() {
        return BdStatisticsManager.INIT_UPLOAD_TIME_INTERVAL;
    }
}
