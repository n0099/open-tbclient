package androidx.core.content.pm;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.Size;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public final class PackageInfoCompat {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @RequiresApi(28)
    /* loaded from: classes.dex */
    public static class Api28Impl {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public Api28Impl() {
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

        @Nullable
        public static Signature[] getApkContentsSigners(@NonNull SigningInfo signingInfo) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, signingInfo)) == null) {
                return signingInfo.getApkContentsSigners();
            }
            return (Signature[]) invokeL.objValue;
        }

        @Nullable
        public static Signature[] getSigningCertificateHistory(@NonNull SigningInfo signingInfo) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, signingInfo)) == null) {
                return signingInfo.getSigningCertificateHistory();
            }
            return (Signature[]) invokeL.objValue;
        }

        public static boolean hasMultipleSigners(@NonNull SigningInfo signingInfo) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, signingInfo)) == null) {
                return signingInfo.hasMultipleSigners();
            }
            return invokeL.booleanValue;
        }

        public static boolean hasSigningCertificate(@NonNull PackageManager packageManager, @NonNull String str, @NonNull byte[] bArr, int i) {
            InterceptResult invokeLLLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(InputDeviceCompat.SOURCE_TRACKBALL, null, packageManager, str, bArr, i)) == null) {
                return packageManager.hasSigningCertificate(str, bArr, i);
            }
            return invokeLLLI.booleanValue;
        }
    }

    public PackageInfoCompat() {
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

    public static boolean byteArrayContains(@NonNull byte[][] bArr, @NonNull byte[] bArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, bArr, bArr2)) == null) {
            for (byte[] bArr3 : bArr) {
                if (Arrays.equals(bArr2, bArr3)) {
                    return true;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static byte[] computeSHA256Digest(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bArr)) == null) {
            try {
                return MessageDigest.getInstance("SHA256").digest(bArr);
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException("Device doesn't support SHA256 cert checking", e);
            }
        }
        return (byte[]) invokeL.objValue;
    }

    public static long getLongVersionCode(@NonNull PackageInfo packageInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, packageInfo)) == null) {
            if (Build.VERSION.SDK_INT >= 28) {
                return packageInfo.getLongVersionCode();
            }
            return packageInfo.versionCode;
        }
        return invokeL.longValue;
    }

    @NonNull
    public static List<Signature> getSignatures(@NonNull PackageManager packageManager, @NonNull String str) throws PackageManager.NameNotFoundException {
        InterceptResult invokeLL;
        Signature[] signatureArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, packageManager, str)) == null) {
            if (Build.VERSION.SDK_INT >= 28) {
                SigningInfo signingInfo = packageManager.getPackageInfo(str, 134217728).signingInfo;
                if (Api28Impl.hasMultipleSigners(signingInfo)) {
                    signatureArr = Api28Impl.getApkContentsSigners(signingInfo);
                } else {
                    signatureArr = Api28Impl.getSigningCertificateHistory(signingInfo);
                }
            } else {
                signatureArr = packageManager.getPackageInfo(str, 64).signatures;
            }
            if (signatureArr == null) {
                return Collections.emptyList();
            }
            return Arrays.asList(signatureArr);
        }
        return (List) invokeLL.objValue;
    }

    public static boolean hasSignatures(@NonNull PackageManager packageManager, @NonNull String str, @NonNull @Size(min = 1) Map<byte[], Integer> map, boolean z) throws PackageManager.NameNotFoundException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, null, new Object[]{packageManager, str, map, Boolean.valueOf(z)})) == null) {
            if (map.isEmpty()) {
                return false;
            }
            Set<byte[]> keySet = map.keySet();
            for (byte[] bArr : keySet) {
                if (bArr != null) {
                    Integer num = map.get(bArr);
                    if (num != null) {
                        int intValue = num.intValue();
                        if (intValue != 0 && intValue != 1) {
                            throw new IllegalArgumentException("Unsupported certificate type " + num + " when verifying " + str);
                        }
                    } else {
                        throw new IllegalArgumentException("Type must be specified for cert when verifying " + str);
                    }
                } else {
                    throw new IllegalArgumentException("Cert byte array cannot be null when verifying " + str);
                }
            }
            List<Signature> signatures = getSignatures(packageManager, str);
            if (!z && Build.VERSION.SDK_INT >= 28) {
                for (byte[] bArr2 : keySet) {
                    if (!Api28Impl.hasSigningCertificate(packageManager, str, bArr2, map.get(bArr2).intValue())) {
                        return false;
                    }
                }
                return true;
            }
            if (signatures.size() != 0 && map.size() <= signatures.size() && (!z || map.size() == signatures.size())) {
                byte[][] bArr3 = null;
                if (map.containsValue(1)) {
                    bArr3 = new byte[signatures.size()];
                    for (int i = 0; i < signatures.size(); i++) {
                        bArr3[i] = computeSHA256Digest(signatures.get(i).toByteArray());
                    }
                }
                Iterator<byte[]> it = keySet.iterator();
                if (it.hasNext()) {
                    byte[] next = it.next();
                    Integer num2 = map.get(next);
                    int intValue2 = num2.intValue();
                    if (intValue2 != 0) {
                        if (intValue2 == 1) {
                            if (!byteArrayContains(bArr3, next)) {
                                return false;
                            }
                        } else {
                            throw new IllegalArgumentException("Unsupported certificate type " + num2);
                        }
                    } else if (!signatures.contains(new Signature(next))) {
                        return false;
                    }
                    return true;
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }
}
