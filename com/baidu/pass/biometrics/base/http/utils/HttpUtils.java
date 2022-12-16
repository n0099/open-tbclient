package com.baidu.pass.biometrics.base.http.utils;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.sdk.encrypt.a;
import com.baidu.pass.biometrics.base.restnet.RestNameValuePair;
import com.baidu.pass.biometrics.base.utils.Crypto;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
/* loaded from: classes2.dex */
public class HttpUtils {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public HttpUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static String getNonce(Context context, List<RestNameValuePair> list) {
        InterceptResult invokeLL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, list)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(list);
            Collections.sort(arrayList, new Comparator<RestNameValuePair>() { // from class: com.baidu.pass.biometrics.base.http.utils.HttpUtils.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                public int compare(RestNameValuePair restNameValuePair, RestNameValuePair restNameValuePair2) {
                    InterceptResult invokeLL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLL2 = interceptable2.invokeLL(1048576, this, restNameValuePair, restNameValuePair2)) == null) {
                        return restNameValuePair.getName().compareTo(restNameValuePair2.getName());
                    }
                    return invokeLL2.intValue;
                }
            });
            RestNameValuePair restNameValuePair = new RestNameValuePair();
            restNameValuePair.setName("key");
            MessageDigest messageDigest = null;
            try {
                str = Crypto.sha1(context.getPackageName());
            } catch (Exception e) {
                e.printStackTrace();
                str = null;
            }
            restNameValuePair.setValue(str);
            arrayList.add(restNameValuePair);
            try {
                messageDigest = MessageDigest.getInstance("MD5");
            } catch (NoSuchAlgorithmException e2) {
                e2.printStackTrace();
            }
            if (messageDigest == null) {
                return "";
            }
            for (int i = 0; i < arrayList.size(); i++) {
                RestNameValuePair restNameValuePair2 = (RestNameValuePair) arrayList.get(i);
                String name = restNameValuePair2.getName();
                String value = restNameValuePair2.getValue();
                if (!TextUtils.isEmpty(name)) {
                    if (value == null) {
                        value = "";
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append(name);
                    sb.append(a.h);
                    sb.append(value);
                    if (i != arrayList.size() - 1) {
                        sb.append('&');
                    }
                    if (!TextUtils.isEmpty(sb)) {
                        messageDigest.update(sb.toString().getBytes(Charset.forName("UTF-8")));
                    }
                }
            }
            byte[] digest = messageDigest.digest();
            StringBuilder sb2 = new StringBuilder();
            for (byte b : digest) {
                sb2.append(Integer.toHexString((b & 255) | (-256)).substring(6));
            }
            return sb2.toString();
        }
        return (String) invokeLL.objValue;
    }
}
