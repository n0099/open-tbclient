package com.baidu.appsearchlib;

import android.util.Base64;
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.UnsupportedEncodingException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes3.dex */
public class Encryption {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public Encryption() {
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

    public static SecretKeySpec createKey(String str) {
        InterceptResult invokeL;
        byte[] bArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (str == null) {
                str = "";
            }
            StringBuffer stringBuffer = new StringBuffer(16);
            stringBuffer.append(str);
            while (stringBuffer.length() < 16) {
                stringBuffer.append("\u0000");
            }
            if (stringBuffer.length() > 16) {
                stringBuffer.setLength(16);
            }
            try {
                bArr = stringBuffer.toString().getBytes("UTF-8");
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
                bArr = null;
            }
            return new SecretKeySpec(bArr, "AES");
        }
        return (SecretKeySpec) invokeL.objValue;
    }

    public static String desEncrypt(String str) throws Exception {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            try {
                byte[] decode = Base64.decode(str, 0);
                Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
                cipher.init(2, createKey(Info.PASSWORD), new IvParameterSpec(Info.IV.getBytes()));
                return new String(cipher.doFinal(decode), IMAudioTransRequest.CHARSET);
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (String) invokeL.objValue;
    }
}
