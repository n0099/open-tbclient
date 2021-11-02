package com.baidu.searchbox.datacollector.growth.utils;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.logsystem.basic.upload.LogSystemUploaderStrategy;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.Base64;
import com.baidu.webkit.internal.utils.UtilsBlink;
import io.flutter.plugin.common.StandardMessageCodec;
import java.io.ByteArrayInputStream;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.cert.CertificateFactory;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.jvm.internal.ByteCompanionObject;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class UBCEncryptor {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String RSA_ALGORITHM = "RSA/ECB/PKCS1Padding";
    public static final String TRANSFORMATION = "AES/CTR/NoPadding";
    public static byte[] mCertBytes;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class MixedEncryptedResult {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String encryptedAESKeys;
        public String encryptedInput;

        public MixedEncryptedResult() {
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
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-217906327, "Lcom/baidu/searchbox/datacollector/growth/utils/UBCEncryptor;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-217906327, "Lcom/baidu/searchbox/datacollector/growth/utils/UBCEncryptor;");
                return;
            }
        }
        mCertBytes = new byte[]{48, -126, 3, 24, 48, -126, 2, 0, 2, 9, 0, -46, 74, 92, -68, 76, 89, -37, 110, 48, 13, 6, 9, ExifInterface.START_CODE, -122, 72, -122, -9, 13, 1, 1, 11, 5, 0, 48, 78, 49, 11, 48, 9, 6, 3, 85, 4, 6, 19, 2, 67, 78, 49, 11, 48, 9, 6, 3, 85, 4, 8, StandardMessageCodec.LIST, 2, 66, 74, 49, 11, 48, 9, 6, 3, 85, 4, 7, StandardMessageCodec.LIST, 2, 66, 74, 49, 11, 48, 9, 6, 3, 85, 4, 10, StandardMessageCodec.LIST, 2, 66, 68, 49, 11, 48, 9, 6, 3, 85, 4, 11, StandardMessageCodec.LIST, 2, 66, 68, 49, 11, 48, 9, 6, 3, 85, 4, 3, StandardMessageCodec.LIST, 2, 66, 68, 48, 30, 23, 13, 50, 48, 49, 50, 49, 54, 48, 57, 53, 49, 49, 53, 90, 23, 13, 51, 48, 49, 50, 49, 52, 48, 57, 53, 49, 49, 53, 90, 48, 78, 49, 11, 48, 9, 6, 3, 85, 4, 6, 19, 2, 67, 78, 49, 11, 48, 9, 6, 3, 85, 4, 8, StandardMessageCodec.LIST, 2, 66, 74, 49, 11, 48, 9, 6, 3, 85, 4, 7, StandardMessageCodec.LIST, 2, 66, 74, 49, 11, 48, 9, 6, 3, 85, 4, 10, StandardMessageCodec.LIST, 2, 66, 68, 49, 11, 48, 9, 6, 3, 85, 4, 11, StandardMessageCodec.LIST, 2, 66, 68, 49, 11, 48, 9, 6, 3, 85, 4, 3, StandardMessageCodec.LIST, 2, 66, 68, 48, -126, 1, 34, 48, 13, 6, 9, ExifInterface.START_CODE, -122, 72, -122, -9, 13, 1, 1, 1, 5, 0, 3, -126, 1, 15, 0, 48, -126, 1, 10, 2, -126, 1, 1, 0, -47, -118, 50, 5, -99, -115, 57, 89, ExifInterface.MARKER_SOF11, 77, ExifInterface.MARKER_SOF5, 94, 37, -74, -91, 71, 77, -83, 6, 81, 124, 25, 0, ExifInterface.MARKER_SOI, 37, 38, 92, 77, 92, 74, -48, 78, ExifInterface.MARKER_SOF13, 75, -81, -115, -105, -121, 30, -18, -22, 64, -76, -93, 58, 85, 24, 73, -26, 48, 55, 13, 6, -74, 76, 9, -16, 85, -94, 83, 86, -78, 90, -36, -42, -120, -36, 0, -75, 95, -98, 118, -26, 32, 55, ExifInterface.MARKER_SOS, 111, 10, ExifInterface.MARKER_SOF14, -105, -45, -28, 109, -108, ExifInterface.MARKER_SOS, 78, -18, ExifInterface.MARKER_SOI, -127, -47, 119, -99, 97, -103, -123, -88, 103, 7, -14, -120, ExifInterface.MARKER_EOI, 16, -104, -105, -46, -25, 29, ByteCompanionObject.MAX_VALUE, -102, -104, -37, -70, -99, -17, 76, Base64.INTERNAL_PADDING, -69, -76, -52, -22, 88, -33, -37, ExifInterface.MARKER_SOF1, -124, -73, 71, -9, -4, 30, -126, -15, ByteCompanionObject.MIN_VALUE, 34, 21, 103, -118, 64, 86, UtilsBlink.VER_TYPE_SEPARATOR, -20, 95, -77, 79, -10, 44, 44, 96, 77, -69, 59, -89, -23, ExifInterface.MARKER_SOF13, -12, 90, 76, -48, 65, 18, 2, 38, -9, 40, 25, 54, 9, 18, 50, 10, 39, -28, 99, -100, 74, 23, ExifInterface.MARKER_SOF1, 84, -95, -120, 28, 73, -121, -94, -19, -22, ExifInterface.MARKER_APP1, 23, -108, -124, -85, ExifInterface.MARKER_SOF0, 60, -17, 122, -52, -47, -36, 61, 57, -111, 20, -82, 54, 43, 62, ExifInterface.MARKER_EOI, 55, 120, 58, 81, 65, ExifInterface.MARKER_SOF9, -80, -126, StandardMessageCodec.LIST, 66, 32, 49, LogSystemUploaderStrategy.ContentUtil.GZIP_HEAD_2, ExifInterface.WEBP_VP8L_SIGNATURE, -47, 21, ByteCompanionObject.MIN_VALUE, -72, -56, -45, 92, -99, 3, -2, 85, 83, -112, -125, -107, 114, -11, 65, 53, 60, -122, -91, 121, -93, 85, 64, -119, 41, ExifInterface.MARKER_SOF0, 119, ExifInterface.START_CODE, -104, 53, 52, 43, 2, 3, 1, 0, 1, 48, 13, 6, 9, ExifInterface.START_CODE, -122, 72, -122, -9, 13, 1, 1, 11, 5, 0, 3, -126, 1, 1, 0, 5, 104, -81, 59, -92, ExifInterface.MARKER_SOF13, PublicSuffixDatabase.EXCEPTION_MARKER, -1, 98, 91, 105, 94, -16, 17, 54, -28, 74, 44, 122, 16, 9, ExifInterface.MARKER_SOS, 36, 105, -124, -29, 96, -101, -25, 5, -52, ExifInterface.MARKER_SOF11, -45, 65, 70, -115, -36, -105, 114, -93, -65, 68, 24, ExifInterface.MARKER_EOI, 71, 5, 15, 88, 122, StandardMessageCodec.LIST, 65, 40, -11, 51, -13, 50, 0, -66, UtilsBlink.VER_TYPE_SEPARATOR, LogSystemUploaderStrategy.ContentUtil.GZIP_HEAD_2, 21, -1, -86, -116, -37, -46, 92, ExifInterface.MARKER_SOF10, -88, -122, 36, -88, -18, 20, -27, -4, -22, 9, -37, -127, 28, LogSystemUploaderStrategy.ContentUtil.GZIP_HEAD_1, -120, 68, -29, ExifInterface.MARKER_SOF1, ByteCompanionObject.MAX_VALUE, -36, -19, 69, -67, -95, 115, ByteCompanionObject.MAX_VALUE, 78, 27, ExifInterface.START_CODE, -56, -126, 74, 61, StandardMessageCodec.LIST, -106, -92, -113, 105, -56, ExifInterface.MARKER_SOF2, 80, ExifInterface.MARKER_SOF5, -107, 76, 16, -111, -24, ByteCompanionObject.MAX_VALUE, 65, 5, -33, ExifInterface.MARKER_SOF10, -118, -19, -42, -105, 48, 48, 39, 111, -105, -112, -13, 114, -73, 29, StandardMessageCodec.LIST, 113, -113, 31, 84, 69, StandardMessageCodec.LIST, 43, 38, Constants.SHORT_PING_CMD_TYPE, -44, ExifInterface.START_CODE, -48, -81, ByteCompanionObject.MIN_VALUE, -96, -47, -91, -127, -83, -28, 100, ExifInterface.MARKER_EOI, -122, -78, 5, -8, 37, 19, 10, 37, 92, 56, -75, 77, LogSystemUploaderStrategy.ContentUtil.GZIP_HEAD_2, 110, -115, 122, 108, ByteCompanionObject.MIN_VALUE, -25, -114, 119, -93, 67, -9, 59, -42, ExifInterface.MARKER_SOF1, 18, -97, 120, 122, 68, 53, -14, 110, -79, -116, ByteCompanionObject.MAX_VALUE, -28, 72, 89, -34, -35, 37, 52, -42, ExifInterface.MARKER_SOF5, 10, -102, -36, 2, -110, 69, 4, -28, 119, 21, 75, 78, -35, 97, -91, -76, 14, 8, -10, 11, 58, -4, 23, ExifInterface.MARKER_SOF0, -117, -113, 36, -42, -26, -77, 116, 55, -126, ExifInterface.MARKER_SOF3, 24, -48, 40, -60, Base64.INTERNAL_PADDING, 79, 82, ExifInterface.MARKER_SOS, -43, 44, 53, -44, -113, -12, 112, 17, 113, -86};
    }

    public UBCEncryptor() {
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

    public static String decryptByAes(String str, byte[] bArr, byte[] bArr2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, str, bArr, bArr2)) == null) {
            try {
                byte[] decode = android.util.Base64.decode(str.getBytes("utf-8"), 2);
                SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
                Cipher cipher = Cipher.getInstance(TRANSFORMATION);
                cipher.init(2, secretKeySpec, new IvParameterSpec(bArr2));
                return new String(cipher.doFinal(decode), "utf-8");
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (String) invokeLLL.objValue;
    }

    public static String encryptByAES(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, bArr, bArr2, bArr3)) == null) {
            try {
                SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "AES");
                Cipher cipher = Cipher.getInstance(TRANSFORMATION);
                cipher.init(1, secretKeySpec, new IvParameterSpec(bArr3));
                return new String(android.util.Base64.encode(cipher.doFinal(bArr), 2), "utf-8");
            } catch (Exception e2) {
                throw new IllegalStateException(e2);
            }
        }
        return (String) invokeLLL.objValue;
    }

    public static String encryptByRSA(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, bArr)) == null) {
            try {
                Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
                cipher.init(1, getPublicKey());
                return new String(android.util.Base64.encode(cipher.doFinal(bArr), 2), "utf-8");
            } catch (Exception e2) {
                throw new IllegalStateException(e2);
            }
        }
        return (String) invokeL.objValue;
    }

    public static MixedEncryptedResult encryptByRSAAndAESMixed(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, str)) == null) {
            if (!TextUtils.isEmpty(str)) {
                byte[] generateAesKey = generateAesKey(128);
                byte[] generateAesIv = generateAesIv();
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("key", android.util.Base64.encodeToString(generateAesKey, 2));
                    jSONObject.put("iv", android.util.Base64.encodeToString(generateAesIv, 2));
                    String encryptByRSA = encryptByRSA(jSONObject.toString().getBytes());
                    String encryptByAES = encryptByAES(str.getBytes(), generateAesKey, generateAesIv);
                    MixedEncryptedResult mixedEncryptedResult = new MixedEncryptedResult();
                    mixedEncryptedResult.encryptedAESKeys = encryptByRSA;
                    mixedEncryptedResult.encryptedInput = encryptByAES;
                    return mixedEncryptedResult;
                } catch (JSONException e2) {
                    throw new IllegalStateException(e2);
                }
            }
            throw new IllegalArgumentException();
        }
        return (MixedEncryptedResult) invokeL.objValue;
    }

    public static byte[] generateAesIv() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            try {
                byte[] bArr = new byte[16];
                SecureRandom.getInstance("SHA1PRNG").nextBytes(bArr);
                return bArr;
            } catch (NoSuchAlgorithmException e2) {
                throw new IllegalStateException(e2);
            }
        }
        return (byte[]) invokeV.objValue;
    }

    public static byte[] generateAesKey(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65544, null, i2)) == null) {
            try {
                KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
                keyGenerator.init(i2);
                return keyGenerator.generateKey().getEncoded();
            } catch (Exception e2) {
                throw new IllegalStateException(e2);
            }
        }
        return (byte[]) invokeI.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:20:0x0034 */
    /* JADX DEBUG: Multi-variable search result rejected for r1v8, resolved type: java.io.ByteArrayInputStream */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0037 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.baidu.titan.sdk.runtime.Interceptable] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static PublicKey getPublicKey() {
        ByteArrayInputStream byteArrayInputStream;
        InterceptResult invokeV;
        Throwable th;
        Exception e2;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = (byteArrayInputStream = interceptable).invokeV(65545, null)) != null) {
            return (PublicKey) invokeV.objValue;
        }
        try {
            try {
                ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(mCertBytes);
                try {
                    PublicKey publicKey = CertificateFactory.getInstance("X.509").generateCertificate(byteArrayInputStream2).getPublicKey();
                    try {
                        byteArrayInputStream2.close();
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                    return publicKey;
                } catch (Exception e4) {
                    e2 = e4;
                    throw new IllegalStateException(e2);
                }
            } catch (Throwable th2) {
                th = th2;
                if (byteArrayInputStream != 0) {
                    try {
                        byteArrayInputStream.close();
                    } catch (Exception e5) {
                        e5.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Exception e6) {
            e2 = e6;
        } catch (Throwable th3) {
            byteArrayInputStream = 0;
            th = th3;
            if (byteArrayInputStream != 0) {
            }
            throw th;
        }
    }

    public static String encryptByRSA(byte[] bArr, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, bArr, str)) == null) {
            try {
                Cipher cipher = Cipher.getInstance(str);
                cipher.init(1, getPublicKey());
                return new String(android.util.Base64.encode(cipher.doFinal(bArr), 2), "utf-8");
            } catch (Exception e2) {
                throw new IllegalStateException(e2);
            }
        }
        return (String) invokeLL.objValue;
    }
}
