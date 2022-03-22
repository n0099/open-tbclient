package com.baidu.android.imsdk.utils;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes3.dex */
public abstract class BaseUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String METHOD_RECEIVEESSAGE = "93";
    public static final String METHOD_SENDMESSAGE = "55";
    public transient /* synthetic */ FieldHolder $fh;

    public BaseUtils() {
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

    public static boolean containsEmoji(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            int length = str.length();
            for (int i = 0; i < length; i++) {
                if (isEmojiCharacter(str.charAt(i))) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static String getMd5(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.update(str.getBytes());
                return Utility.byte2Hex(messageDigest.digest());
            } catch (NoSuchAlgorithmException e2) {
                LogUtils.e("BaseUtils", "MD5 error " + e2.getMessage());
                return str;
            }
        }
        return (String) invokeL.objValue;
    }

    public static boolean isEmojiCharacter(char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{Character.valueOf(c2)})) == null) ? c2 == 0 || c2 == '\t' || c2 == '\n' || c2 == '\r' || (c2 >= ' ' && c2 <= 55295) || ((c2 >= 57344 && c2 <= 65533) || (c2 >= 0 && c2 <= 65535)) : invokeCommon.booleanValue;
    }
}
