package com.baidu.mobads.container.util;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.security.MessageDigest;
/* loaded from: classes7.dex */
public class EncryptUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "EncryptUtils";
    public transient /* synthetic */ FieldHolder $fh;

    public EncryptUtils() {
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

    public static String getMD5(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            byte[] bytes = str.getBytes();
            char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.update(bytes);
                byte[] digest = messageDigest.digest();
                char[] cArr2 = new char[32];
                int i2 = 0;
                for (int i3 = 0; i3 < 16; i3++) {
                    byte b2 = digest[i3];
                    int i4 = i2 + 1;
                    cArr2[i2] = cArr[(b2 >>> 4) & 15];
                    i2 = i4 + 1;
                    cArr2[i4] = cArr[b2 & 15];
                }
                return new String(cArr2);
            } catch (Exception e2) {
                RemoteXAdLogger.getInstance().e(TAG, "", e2);
                return null;
            }
        }
        return (String) invokeL.objValue;
    }
}
