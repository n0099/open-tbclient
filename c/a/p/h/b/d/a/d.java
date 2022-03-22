package c.a.p.h.b.d.a;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.security.DigestException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.MGF1ParameterSpec;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.BadPaddingException;
import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.PSource;
/* loaded from: classes2.dex */
public final class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static final Map<String, byte[]> f11772h;
    public transient /* synthetic */ FieldHolder $fh;
    public final int a;

    /* renamed from: b  reason: collision with root package name */
    public final int f11773b;

    /* renamed from: c  reason: collision with root package name */
    public SecureRandom f11774c;

    /* renamed from: d  reason: collision with root package name */
    public final int f11775d;

    /* renamed from: e  reason: collision with root package name */
    public MessageDigest f11776e;

    /* renamed from: f  reason: collision with root package name */
    public MessageDigest f11777f;

    /* renamed from: g  reason: collision with root package name */
    public byte[] f11778g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1580343561, "Lc/a/p/h/b/d/a/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1580343561, "Lc/a/p/h/b/d/a/d;");
                return;
            }
        }
        f11772h = Collections.synchronizedMap(new HashMap());
    }

    public d(int i, int i2, SecureRandom secureRandom, OAEPParameterSpec oAEPParameterSpec) throws InvalidKeyException, InvalidAlgorithmParameterException {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), secureRandom, oAEPParameterSpec};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = i;
        this.f11773b = i2;
        this.f11774c = secureRandom;
        if (i2 < 64) {
            throw new InvalidKeyException("Padded size must be at least 64");
        }
        if (i == 1 || i == 2) {
            i2 -= 11;
        } else if (i != 3) {
            if (i != 4) {
                throw new InvalidKeyException("Invalid padding: " + i);
            }
            byte[] bArr = null;
            String str2 = "SHA-1";
            if (oAEPParameterSpec != null) {
                try {
                    String digestAlgorithm = oAEPParameterSpec.getDigestAlgorithm();
                    String mGFAlgorithm = oAEPParameterSpec.getMGFAlgorithm();
                    if (!mGFAlgorithm.equalsIgnoreCase("MGF1")) {
                        throw new InvalidAlgorithmParameterException("Unsupported MGF algo: " + mGFAlgorithm);
                    }
                    String digestAlgorithm2 = ((MGF1ParameterSpec) oAEPParameterSpec.getMGFParameters()).getDigestAlgorithm();
                    PSource pSource = oAEPParameterSpec.getPSource();
                    String algorithm = pSource.getAlgorithm();
                    if (!algorithm.equalsIgnoreCase("PSpecified")) {
                        throw new InvalidAlgorithmParameterException("Unsupported pSource algo: " + algorithm);
                    }
                    str2 = digestAlgorithm2;
                    bArr = ((PSource.PSpecified) pSource).getValue();
                    str = digestAlgorithm;
                } catch (NoSuchAlgorithmException e2) {
                    e = e2;
                    throw new InvalidKeyException("Digest " + str2 + " not available", e);
                }
            } else {
                str = "SHA-1";
            }
            try {
                this.f11776e = MessageDigest.getInstance(str);
                this.f11777f = MessageDigest.getInstance(str2);
                byte[] e3 = e(this.f11776e, bArr);
                this.f11778g = e3;
                int length = (i2 - 2) - (e3.length * 2);
                this.f11775d = length;
                if (length > 0) {
                    return;
                }
                throw new InvalidKeyException("Key is too short for encryption using OAEPPadding with " + str + " and MGF1" + str2);
            } catch (NoSuchAlgorithmException e4) {
                e = e4;
                str2 = str;
                throw new InvalidKeyException("Digest " + str2 + " not available", e);
            }
        }
        this.f11775d = i2;
    }

    public static d b(int i, int i2, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIIL = interceptable.invokeIIL(65538, null, i, i2, secureRandom)) == null) ? new d(i, i2, secureRandom, null) : (d) invokeIIL.objValue;
    }

    public static d c(int i, int i2, SecureRandom secureRandom, OAEPParameterSpec oAEPParameterSpec) throws InvalidKeyException, InvalidAlgorithmParameterException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), secureRandom, oAEPParameterSpec})) == null) ? new d(i, i2, secureRandom, oAEPParameterSpec) : (d) invokeCommon.objValue;
    }

    public static byte[] e(MessageDigest messageDigest, byte[] bArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, messageDigest, bArr)) == null) {
            if (bArr == null || bArr.length == 0) {
                String algorithm = messageDigest.getAlgorithm();
                byte[] bArr2 = f11772h.get(algorithm);
                if (bArr2 == null) {
                    byte[] digest = messageDigest.digest();
                    f11772h.put(algorithm, digest);
                    return digest;
                }
                return bArr2;
            }
            return messageDigest.digest(bArr);
        }
        return (byte[]) invokeLL.objValue;
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f11775d : invokeV.intValue;
    }

    public final void d(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4) throws BadPaddingException {
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{bArr, Integer.valueOf(i), Integer.valueOf(i2), bArr2, Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            byte[] bArr3 = new byte[4];
            byte[] bArr4 = new byte[20];
            while (i4 > 0) {
                this.f11777f.update(bArr, i, i2);
                this.f11777f.update(bArr3);
                try {
                    this.f11777f.digest(bArr4, 0, 20);
                    for (int i6 = 0; i6 < 20 && i4 > 0; i6++) {
                        bArr2[i3] = (byte) (bArr4[i6] ^ bArr2[i3]);
                        i4--;
                        i3++;
                    }
                    if (i4 > 0) {
                        while (true) {
                            byte b2 = (byte) (bArr3[i5] + 1);
                            bArr3[i5] = b2;
                            i5 = (b2 == 0 && i5 > 0) ? i5 - 1 : 3;
                        }
                    }
                } catch (DigestException e2) {
                    throw new BadPaddingException(e2.toString());
                }
            }
        }
    }

    public byte[] f(byte[] bArr) throws BadPaddingException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bArr)) == null) {
            if (bArr.length > this.f11775d) {
                throw new BadPaddingException("Data must be shorter than " + (this.f11775d + 1) + " bytes");
            }
            int i = this.a;
            if (i == 1 || i == 2) {
                return i(bArr);
            }
            if (i != 3) {
                if (i == 4) {
                    return k(bArr);
                }
                throw new AssertionError();
            }
            return bArr;
        }
        return (byte[]) invokeL.objValue;
    }

    public byte[] g(byte[] bArr, int i, int i2) throws BadPaddingException {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLII = interceptable.invokeLII(1048579, this, bArr, i, i2)) == null) ? f(a.d(bArr, i, i2)) : (byte[]) invokeLII.objValue;
    }

    public byte[] h(byte[] bArr) throws BadPaddingException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, bArr)) == null) {
            if (bArr.length != this.f11773b) {
                throw new BadPaddingException("Padded length must be " + this.f11773b);
            }
            int i = this.a;
            if (i == 1 || i == 2) {
                return j(bArr);
            }
            if (i != 3) {
                if (i == 4) {
                    return l(bArr);
                }
                throw new AssertionError();
            }
            return bArr;
        }
        return (byte[]) invokeL.objValue;
    }

    public final byte[] i(byte[] bArr) throws BadPaddingException {
        InterceptResult invokeL;
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, bArr)) == null) {
            int i3 = this.f11773b;
            byte[] bArr2 = new byte[i3];
            System.arraycopy(bArr, 0, bArr2, i3 - bArr.length, bArr.length);
            int length = (this.f11773b - 3) - bArr.length;
            bArr2[0] = 0;
            int i4 = this.a;
            bArr2[1] = (byte) i4;
            int i5 = -1;
            int i6 = 2;
            if (i4 != 1) {
                if (this.f11774c == null) {
                    this.f11774c = a.a;
                }
                byte[] bArr3 = new byte[64];
                while (true) {
                    int i7 = length - 1;
                    if (length <= 0) {
                        break;
                    }
                    while (true) {
                        if (i5 < 0) {
                            this.f11774c.nextBytes(bArr3);
                            i5 = 63;
                        }
                        i = i5 - 1;
                        i2 = bArr3[i5] & 255;
                        if (i2 != 0) {
                            break;
                        }
                        i5 = i;
                    }
                    bArr2[i6] = (byte) i2;
                    i5 = i;
                    length = i7;
                    i6++;
                }
            } else {
                while (true) {
                    int i8 = length - 1;
                    if (length <= 0) {
                        break;
                    }
                    bArr2[i6] = -1;
                    i6++;
                    length = i8;
                }
            }
            return bArr2;
        }
        return (byte[]) invokeL.objValue;
    }

    public final byte[] j(byte[] bArr) throws BadPaddingException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048582, this, bArr)) != null) {
            return (byte[]) invokeL.objValue;
        }
        if (bArr[0] != 0) {
            throw new BadPaddingException("Data must start with zero");
        }
        int i = 2;
        if (bArr[1] != this.a) {
            throw new BadPaddingException("Blocktype mismatch: " + ((int) bArr[1]));
        }
        while (true) {
            int i2 = i + 1;
            int i3 = bArr[i] & 255;
            if (i3 == 0) {
                int length = bArr.length - i2;
                if (length <= this.f11775d) {
                    byte[] bArr2 = new byte[length];
                    System.arraycopy(bArr, bArr.length - length, bArr2, 0, length);
                    return bArr2;
                }
                throw new BadPaddingException("Padding string too short");
            } else if (i2 == bArr.length) {
                throw new BadPaddingException("Padding string not terminated");
            } else {
                if (this.a == 1 && i3 != 255) {
                    throw new BadPaddingException("Padding byte not 0xff: " + i3);
                }
                i = i2;
            }
        }
    }

    public final byte[] k(byte[] bArr) throws BadPaddingException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, bArr)) == null) {
            if (this.f11774c == null) {
                this.f11774c = a.a;
            }
            int length = this.f11778g.length;
            byte[] bArr2 = new byte[length];
            this.f11774c.nextBytes(bArr2);
            int i = this.f11773b;
            byte[] bArr3 = new byte[i];
            System.arraycopy(bArr2, 0, bArr3, 1, length);
            int i2 = length + 1;
            int i3 = i - i2;
            int length2 = this.f11773b - bArr.length;
            System.arraycopy(this.f11778g, 0, bArr3, i2, length);
            bArr3[length2 - 1] = 1;
            System.arraycopy(bArr, 0, bArr3, length2, bArr.length);
            d(bArr3, 1, length, bArr3, i2, i3);
            d(bArr3, i2, i3, bArr3, 1, length);
            return bArr3;
        }
        return (byte[]) invokeL.objValue;
    }

    public final byte[] l(byte[] bArr) throws BadPaddingException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bArr)) == null) {
            int length = this.f11778g.length;
            if (bArr[0] == 0) {
                int i = length + 1;
                int length2 = bArr.length - i;
                d(bArr, i, length2, bArr, 1, length);
                d(bArr, 1, length, bArr, i, length2);
                for (int i2 = 0; i2 < length; i2++) {
                    if (this.f11778g[i2] != bArr[i + i2]) {
                        throw new BadPaddingException("lHash mismatch");
                    }
                }
                int i3 = i + length;
                while (bArr[i3] == 0) {
                    i3++;
                    if (i3 >= bArr.length) {
                        throw new BadPaddingException("Padding string not terminated");
                    }
                }
                int i4 = i3 + 1;
                if (bArr[i3] == 1) {
                    int length3 = bArr.length - i4;
                    byte[] bArr2 = new byte[length3];
                    System.arraycopy(bArr, i4, bArr2, 0, length3);
                    return bArr2;
                }
                throw new BadPaddingException("Padding string not terminated by 0x01 byte");
            }
            throw new BadPaddingException("Data must start with zero");
        }
        return (byte[]) invokeL.objValue;
    }
}
