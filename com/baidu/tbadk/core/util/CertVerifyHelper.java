package com.baidu.tbadk.core.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayInputStream;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Arrays;
/* loaded from: classes4.dex */
public class CertVerifyHelper {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DEFAUKLT_PACKAGE_PUBLIC_KEY = "30819f300d06092a864886f70d010101050003818d0030818902818100b17c8a1a350a202f33e461293638cbf1b6bd481877a87379cd6b99d2ec33aa123d9e16028e94c89a3ea268bd5b055869cd99bf10780e7fafa6254a4471d4d57d36589331e28f66b0044bd8e6cc0cd82dc4fa21f28887776b2094118f859739e8271811894260d9a8f36482fc4e2e9df40dc953e2c2da429ea1101524bce33fd10203010001";
    public transient /* synthetic */ FieldHolder $fh;

    public CertVerifyHelper() {
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

    public static byte[] getPublicKey(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 64);
                if (packageInfo == null || packageInfo.signatures[0] == null) {
                    return null;
                }
                return parsePublicKey(packageInfo.signatures[0].toByteArray());
            } catch (Exception e2) {
                BdLog.e(e2);
                return null;
            }
        }
        return (byte[]) invokeL.objValue;
    }

    public static byte[] hexStr2Bytes(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            int length = str.length() / 2;
            byte[] bArr = new byte[length];
            for (int i2 = 0; i2 < length; i2++) {
                int i3 = i2 * 2;
                int i4 = i3 + 1;
                bArr[i2] = (byte) (Integer.decode("0x" + str.substring(i3, i4) + str.substring(i4, i4 + 1)).intValue() & 255);
            }
            return bArr;
        }
        return (byte[]) invokeL.objValue;
    }

    public static boolean isOfficial(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            byte[] publicKey = getPublicKey(context);
            return publicKey == null || publicKey.length == 0 || Arrays.equals(publicKey, hexStr2Bytes(DEFAUKLT_PACKAGE_PUBLIC_KEY));
        }
        return invokeL.booleanValue;
    }

    public static byte[] parsePublicKey(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65540, null, bArr)) == null) {
            try {
                return ((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(bArr))).getPublicKey().getEncoded();
            } catch (CertificateException e2) {
                BdLog.e(e2);
                return null;
            }
        }
        return (byte[]) invokeL.objValue;
    }
}
