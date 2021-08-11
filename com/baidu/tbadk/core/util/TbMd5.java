package com.baidu.tbadk.core.util;

import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.q;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.security.MessageDigest;
/* loaded from: classes6.dex */
public class TbMd5 {
    public static /* synthetic */ Interceptable $ic;
    public static final char[] HEX_DIGITS;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-550252309, "Lcom/baidu/tbadk/core/util/TbMd5;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-550252309, "Lcom/baidu/tbadk/core/util/TbMd5;");
                return;
            }
        }
        HEX_DIGITS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    }

    public TbMd5() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static String creatSignInt(PackageInfo packageInfo) throws NumberFormatException {
        InterceptResult invokeL;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, packageInfo)) == null) {
            String signMd5 = getSignMd5(packageInfo);
            if (signMd5 == null || signMd5.length() < 32) {
                return "-1";
            }
            String substring = signMd5.substring(8, 24);
            long j2 = 0;
            long j3 = 0;
            for (int i4 = 0; i4 < 8; i4++) {
                j3 = (j3 * 16) + Integer.parseInt(substring.substring(i4, i3), 16);
            }
            for (int i5 = 8; i5 < substring.length(); i5++) {
                j2 = (j2 * 16) + Integer.parseInt(substring.substring(i5, i2), 16);
            }
            return String.valueOf(4294967295L & (j2 + j3));
        }
        return (String) invokeL.objValue;
    }

    public static String getAPKHexMD5(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bArr)) == null) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.update(bArr);
                byte[] digest = messageDigest.digest();
                char[] cArr = new char[32];
                int i2 = 0;
                for (int i3 = 0; i3 < 16; i3++) {
                    byte b2 = digest[i3];
                    int i4 = i2 + 1;
                    cArr[i2] = HEX_DIGITS[(b2 >>> 4) & 15];
                    i2 = i4 + 1;
                    cArr[i4] = HEX_DIGITS[b2 & 15];
                }
                return new String(cArr);
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public static String getAPKMd5(PackageInfo packageInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, packageInfo)) == null) {
            if (packageInfo == null) {
                return null;
            }
            File file = new File(packageInfo.applicationInfo.publicSourceDir);
            if (file.exists()) {
                try {
                    return q.b(new FileInputStream(file));
                } catch (FileNotFoundException e2) {
                    BdLog.detailException(e2);
                }
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static String getNameMd5FromUrl(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) ? q.c(str) : (String) invokeL.objValue;
    }

    public static String getSignMd5(PackageInfo packageInfo) {
        InterceptResult invokeL;
        Signature[] signatureArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, packageInfo)) == null) {
            if (packageInfo == null || (signatureArr = packageInfo.signatures) == null || signatureArr.length == 0 || signatureArr[0] == null) {
                return null;
            }
            try {
                return q.d(signatureArr[0].toCharsString().getBytes());
            } catch (Exception e2) {
                BdLog.detailException(e2);
                return null;
            }
        }
        return (String) invokeL.objValue;
    }
}
