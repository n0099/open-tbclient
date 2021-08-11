package com.baidu.android.imsdk.chatmessage.request;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.webkit.CookieManager;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.upload.AsyncChatTask;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.HttpHelper;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes4.dex */
public class IMGenBosObjectUrlRequest implements HttpHelper.Request, HttpHelper.ResponseHandler {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String mContentType;
    public Context mContext;
    public String mFilePath;
    public String mFormat;
    public String mKey;
    public int mOriHeight;
    public int mOriWidth;
    public int mReqSource;

    public IMGenBosObjectUrlRequest(Context context, String str, String str2, String str3, int i2, int i3, int i4, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, str2, str3, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str4};
            interceptable.invokeUnInit(65536, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mContext = context;
        this.mKey = str4;
        this.mFilePath = str;
        this.mContentType = str2;
        this.mFormat = str3;
        this.mReqSource = i2;
        this.mOriWidth = i3;
        this.mOriHeight = i4;
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public int getConnectTimeout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return 15000;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getContentType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "application/x-www-form-urlencoded" : (String) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public Map<String, String> getHeaders() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            HashMap hashMap = new HashMap();
            try {
                String bduss = IMConfigInternal.getInstance().getIMConfig(this.mContext).getBduss(this.mContext);
                CookieManager cookieManager = CookieManager.getInstance();
                cookieManager.setCookie("baidu.com", "BDUSS=" + bduss);
                hashMap.put("cookie", cookieManager.getCookie("baidu.com"));
            } catch (Exception e2) {
                LogUtils.e("IMGenBosObjectUrlRequest", "set bduss exception");
                new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e2)).build();
            }
            return hashMap;
        }
        return (Map) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            int readIntData = Utility.readIntData(this.mContext, Constants.KEY_ENV, 0);
            return readIntData != 1 ? readIntData != 2 ? readIntData != 3 ? "https://pim.baidu.com/rest/3.0/im/bos/generate_bos_url" : "http://180.97.36.95:8080/rest/3.0/im/bos/generate_bos_url" : "http://sz-shaheenv-odprestapi-b.bcc-szwg.baidu.com:8080/rest/3.0/im/bos/generate_bos_url" : "http://rd-im-server.bcc-szth.baidu.com:8111/rest/3.0/im/bos/generate_bos_url";
        }
        return (String) invokeV.objValue;
    }

    public String getMd5(String str) throws NoSuchAlgorithmException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            return Utility.byte2Hex(messageDigest.digest());
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getMethod() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? "POST" : (String) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public int getReadTimeout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return 15000;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public byte[] getRequestParameter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            String str = "";
            StringBuilder sb = new StringBuilder();
            long appid = AccountManager.getAppid(this.mContext);
            sb.append("&appid=" + appid);
            sb.append("&uk=");
            sb.append(AccountManager.getUK(this.mContext));
            long j2 = 0;
            if (Utility.isMediaUri(this.mFilePath)) {
                try {
                    InputStream openInputStream = this.mContext.getContentResolver().openInputStream(Uri.parse(this.mFilePath));
                    if (openInputStream != null) {
                        j2 = openInputStream.available();
                    }
                } catch (Exception unused) {
                }
            } else {
                j2 = new File(this.mFilePath).length();
            }
            sb.append("&content_length=" + j2);
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
            try {
                str = getMd5("" + currentTimeMillis + bduss + appid);
            } catch (Exception e3) {
                LogUtils.e(IMGenBosObjectUrlRequest.class.getSimpleName(), "Exception ", e3);
                new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e3)).build();
            }
            sb.append("&sign=" + str);
            return sb.toString().getBytes();
        }
        return (byte[]) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onFailure(int i2, byte[] bArr, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, bArr, th) == null) {
            Pair<Integer, String> transErrorCode = transErrorCode(i2, bArr, th);
            LogUtils.d("", "IMGenBosObjectUrlRequest onFailure " + transErrorCode.first);
            ChatMsgManagerImpl.getInstance(this.mContext).onGenBosObjectUrl(this.mKey, ((Integer) transErrorCode.first).intValue(), (String) transErrorCode.second, null, null, null);
        }
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onSuccess(int i2, byte[] bArr) {
        String str;
        String str2;
        String str3;
        HashMap hashMap;
        String str4;
        String str5;
        int i3;
        int i4;
        String string;
        HashMap hashMap2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048585, this, i2, bArr) == null) {
            String str6 = new String(bArr);
            LogUtils.d("IMGenBosObjectUrlRequest", str6);
            String str7 = null;
            try {
                JSONObject jSONObject = new JSONObject(str6);
                if (jSONObject.has("response_params")) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("response_params");
                    i4 = jSONObject2.getInt("error_code");
                    str = jSONObject2.getString("authorization");
                    try {
                        str2 = jSONObject2.getString("date");
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
                            string = Constants.ERROR_MSG_SUCCESS;
                            str7 = str;
                        } catch (JSONException e2) {
                            e = e2;
                            LogUtils.e("IMGenBosObjectUrlRequest", e.getMessage(), e);
                            new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                            str3 = Constants.ERROR_MSG_JSON_PARSE_EXCEPTION;
                            hashMap = null;
                            str4 = str;
                            str5 = str2;
                            i3 = 1010;
                            ChatMsgManagerImpl.getInstance(this.mContext).onGenBosObjectUrl(this.mKey, i3, str3, str4, str5, hashMap);
                        }
                    } catch (JSONException e3) {
                        e = e3;
                        str2 = null;
                    }
                } else {
                    i4 = jSONObject.getInt("error_code");
                    string = jSONObject.getString("error_msg");
                    str2 = null;
                    hashMap2 = null;
                }
                str3 = string;
                i3 = i4;
                str4 = str7;
                str5 = str2;
                hashMap = hashMap2;
            } catch (JSONException e4) {
                e = e4;
                str = null;
                str2 = null;
            }
            ChatMsgManagerImpl.getInstance(this.mContext).onGenBosObjectUrl(this.mKey, i3, str3, str4, str5, hashMap);
        }
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public boolean shouldAbort() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public Pair<Integer, String> transErrorCode(int i2, byte[] bArr, Throwable th) {
        InterceptResult invokeILL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048587, this, i2, bArr, th)) == null) {
            if (th != null) {
                i2 = 1012;
                str = Constants.ERROR_MSG_HTTP_IOEXCEPTION_ERROR;
            } else if (i2 == 1005) {
                str = new String(bArr);
            } else {
                str = "http response is error! response code:" + i2;
                i2 = 1011;
            }
            return new Pair<>(Integer.valueOf(i2), str);
        }
        return (Pair) invokeILL.objValue;
    }
}
