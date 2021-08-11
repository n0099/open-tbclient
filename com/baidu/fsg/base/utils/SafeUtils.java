package com.baidu.fsg.base.utils;

import android.text.TextUtils;
import com.baidu.fsg.base.armor.RimArmor;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.UnsupportedEncodingException;
/* loaded from: classes5.dex */
public final class SafeUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "SafeUtils";
    public transient /* synthetic */ FieldHolder $fh;

    public SafeUtils() {
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

    public static String encrypt(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, str2)) == null) ? !TextUtils.isEmpty(str2) ? RimArmor.getInstance().encryptProxy(str2) : "" : (String) invokeLL.objValue;
    }

    public static String xor(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                try {
                    return new String(xor(str.getBytes("UTF-8"), str2.getBytes("UTF-8")), "UTF-8");
                } catch (UnsupportedEncodingException e2) {
                    e2.printStackTrace();
                }
            }
            return "";
        }
        return (String) invokeLL.objValue;
    }

    public static byte[] xor(byte[] bArr, byte[] bArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, bArr, bArr2)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (bArr == null || bArr2 == null) {
                return null;
            }
            for (int i2 = 0; i2 < bArr.length; i2++) {
                bArr[i2] = (byte) (bArr[i2] ^ bArr2[i2 % bArr2.length]);
            }
            String str = "xor cost time " + (System.currentTimeMillis() - currentTimeMillis) + "ms";
            return bArr;
        }
        return (byte[]) invokeLL.objValue;
    }
}
