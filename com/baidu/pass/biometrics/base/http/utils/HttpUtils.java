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
import kotlin.text.Typography;
/* loaded from: classes2.dex */
public class HttpUtils {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public HttpUtils() {
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
                public int compare(RestNameValuePair restNameValuePair, RestNameValuePair restNameValuePair2) {
                    InterceptResult invokeLL2;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLL2 = interceptable2.invokeLL(1048576, this, restNameValuePair, restNameValuePair2)) == null) ? restNameValuePair.getName().compareTo(restNameValuePair2.getName()) : invokeLL2.intValue;
                }
            });
            RestNameValuePair restNameValuePair = new RestNameValuePair();
            restNameValuePair.setName("key");
            MessageDigest messageDigest = null;
            try {
                str = Crypto.sha1(context.getPackageName());
            } catch (Exception e2) {
                e2.printStackTrace();
                str = null;
            }
            restNameValuePair.setValue(str);
            arrayList.add(restNameValuePair);
            try {
                messageDigest = MessageDigest.getInstance("MD5");
            } catch (NoSuchAlgorithmException e3) {
                e3.printStackTrace();
            }
            if (messageDigest == null) {
                return "";
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                RestNameValuePair restNameValuePair2 = (RestNameValuePair) arrayList.get(i2);
                String name = restNameValuePair2.getName();
                String value = restNameValuePair2.getValue();
                if (!TextUtils.isEmpty(name)) {
                    if (value == null) {
                        value = "";
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append(name);
                    sb.append(a.f1890h);
                    sb.append(value);
                    if (i2 != arrayList.size() - 1) {
                        sb.append(Typography.amp);
                    }
                    if (!TextUtils.isEmpty(sb)) {
                        messageDigest.update(sb.toString().getBytes(Charset.forName("UTF-8")));
                    }
                }
            }
            byte[] digest = messageDigest.digest();
            StringBuilder sb2 = new StringBuilder();
            for (byte b2 : digest) {
                sb2.append(Integer.toHexString((b2 & 255) | (-256)).substring(6));
            }
            return sb2.toString();
        }
        return (String) invokeLL.objValue;
    }
}
