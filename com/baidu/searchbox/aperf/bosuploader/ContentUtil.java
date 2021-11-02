package com.baidu.searchbox.aperf.bosuploader;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.security.MD5Util;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class ContentUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_LOCAL_EXPIRED_AT = "localExpireAt";
    public static final String REQ_KEY_REQ = "req";
    public static final String REQ_KEY_SIGN = "sign";
    public static final String REQ_KEY_TIMESTAMP = "timestamp";
    public static final String REQ_KEY_TYPE = "type";
    public static final String RESULT_KEY_AK = "ak";
    public static final String RESULT_KEY_BUCKET = "bucket";
    public static final String RESULT_KEY_ENDPOINT = "endpoint";
    public static final String RESULT_KEY_EXPIRE = "expire";
    public static final String RESULT_KEY_EXPIRED_AT = "expireAt";
    public static final String RESULT_KEY_SK = "sk";
    public static final String RESULT_KEY_TOKEN = "token";
    public static final String TAG_DATA = "data";
    public static final String TAG_ERRNO = "errno";
    public static final String TAG_ERRNO_INVALID = "-1";
    public static final String TAG_ERRNO_NO_ERROR = "0";
    public static final String TOKEN = "gettoken";
    public transient /* synthetic */ FieldHolder $fh;

    public ContentUtil() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static boolean checkStsValid(STSInfo sTSInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, sTSInfo)) == null) {
            if (sTSInfo == null || TextUtils.isEmpty(sTSInfo.ak) || TextUtils.isEmpty(sTSInfo.sk) || TextUtils.isEmpty(sTSInfo.token) || TextUtils.isEmpty(sTSInfo.expired) || TextUtils.isEmpty(sTSInfo.bucket) || TextUtils.isEmpty(sTSInfo.endpoint)) {
                return false;
            }
            try {
                return sTSInfo.expiredAt >= System.currentTimeMillis();
            } catch (NumberFormatException unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static String createRequest(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
                jSONObject2.put("type", str);
                jSONObject2.put("timestamp", valueOf);
                jSONObject2.put("sign", createSign(jSONObject2));
                jSONObject.put(REQ_KEY_REQ, jSONObject2);
                return jSONObject.toString();
            } catch (JSONException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public static STSInfo createSTSFromResponse(String str) {
        InterceptResult invokeL;
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65539, null, str)) != null) {
            return (STSInfo) invokeL.objValue;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!"0".equals(jSONObject.optString("errno", "-1")) || (optJSONObject = jSONObject.optJSONObject("data")) == null) {
                return null;
            }
            optJSONObject.put(KEY_LOCAL_EXPIRED_AT, System.currentTimeMillis() + (optJSONObject.optLong(RESULT_KEY_EXPIRE) * 1000));
            return createSTSInfo(optJSONObject);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return null;
    }

    public static STSInfo createSTSInfo(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            try {
                return createSTSInfo(new JSONObject(str));
            } catch (JSONException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (STSInfo) invokeL.objValue;
    }

    public static String createSign(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, jSONObject)) == null) {
            if (jSONObject != null) {
                StringBuffer stringBuffer = new StringBuffer();
                HashMap hashMap = new HashMap();
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    try {
                        String string = jSONObject.getString(next);
                        if (!TextUtils.isEmpty(string)) {
                            hashMap.put(next, string);
                        }
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
                ArrayList<Map.Entry> arrayList = new ArrayList(hashMap.entrySet());
                Collections.sort(arrayList, new Comparator<Map.Entry<String, String>>() { // from class: com.baidu.searchbox.aperf.bosuploader.ContentUtil.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                            }
                        }
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // java.util.Comparator
                    public int compare(Map.Entry<String, String> entry, Map.Entry<String, String> entry2) {
                        InterceptResult invokeLL;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, entry, entry2)) == null) ? entry.getKey().compareTo(entry2.getKey()) : invokeLL.intValue;
                    }
                });
                for (Map.Entry entry : arrayList) {
                    stringBuffer.append((String) entry.getKey());
                    stringBuffer.append("=");
                    stringBuffer.append((String) entry.getValue());
                }
                stringBuffer.append(TOKEN);
                try {
                    return MD5Util.toMd5(stringBuffer.toString().getBytes("UTF-8"), false);
                } catch (UnsupportedEncodingException e3) {
                    e3.printStackTrace();
                }
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public static STSInfo createSTSInfo(@NonNull JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, jSONObject)) == null) {
            STSInfo sTSInfo = new STSInfo(jSONObject.optString(RESULT_KEY_AK), jSONObject.optString(RESULT_KEY_SK), jSONObject.optString("token"), jSONObject.optLong(KEY_LOCAL_EXPIRED_AT), jSONObject.optString(RESULT_KEY_EXPIRE), jSONObject.optString(RESULT_KEY_BUCKET), jSONObject.optString(RESULT_KEY_ENDPOINT));
            sTSInfo.setOrigin(jSONObject.toString());
            return sTSInfo;
        }
        return (STSInfo) invokeL.objValue;
    }
}
