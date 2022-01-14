package c.a.r.h.b.d.a;

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
/* loaded from: classes.dex */
public final class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static final Map<String, byte[]> f4947h;
    public transient /* synthetic */ FieldHolder $fh;
    public final int a;

    /* renamed from: b  reason: collision with root package name */
    public final int f4948b;

    /* renamed from: c  reason: collision with root package name */
    public SecureRandom f4949c;

    /* renamed from: d  reason: collision with root package name */
    public final int f4950d;

    /* renamed from: e  reason: collision with root package name */
    public MessageDigest f4951e;

    /* renamed from: f  reason: collision with root package name */
    public MessageDigest f4952f;

    /* renamed from: g  reason: collision with root package name */
    public byte[] f4953g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1838508999, "Lc/a/r/h/b/d/a/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1838508999, "Lc/a/r/h/b/d/a/d;");
                return;
            }
        }
        f4947h = Collections.synchronizedMap(new HashMap());
    }

    public d(int i2, int i3, SecureRandom secureRandom, OAEPParameterSpec oAEPParameterSpec) throws InvalidKeyException, InvalidAlgorithmParameterException {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), secureRandom, oAEPParameterSpec};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = i2;
        this.f4948b = i3;
        this.f4949c = secureRandom;
        if (i3 < 64) {
            throw new InvalidKeyException("Padded size must be at least 64");
        }
        if (i2 == 1 || i2 == 2) {
            i3 -= 11;
        } else if (i2 != 3) {
            if (i2 != 4) {
                throw new InvalidKeyException("Invalid padding: " + i2);
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
                this.f4951e = MessageDigest.getInstance(str);
                this.f4952f = MessageDigest.getInstance(str2);
                byte[] e3 = e(this.f4951e, bArr);
                this.f4953g = e3;
                int length = (i3 - 2) - (e3.length * 2);
                this.f4950d = length;
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
        this.f4950d = i3;
    }

    public static d b(int i2, int i3, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIIL = interceptable.invokeIIL(65538, null, i2, i3, secureRandom)) == null) ? new d(i2, i3, secureRandom, null) : (d) invokeIIL.objValue;
    }

    public static d c(int i2, int i3, SecureRandom secureRandom, OAEPParameterSpec oAEPParameterSpec) throws InvalidKeyException, InvalidAlgorithmParameterException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), secureRandom, oAEPParameterSpec})) == null) ? new d(i2, i3, secureRandom, oAEPParameterSpec) : (d) invokeCommon.objValue;
    }

    public static byte[] e(MessageDigest messageDigest, byte[] bArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, messageDigest, bArr)) == null) {
            if (bArr == null || bArr.length == 0) {
                String algorithm = messageDigest.getAlgorithm();
                byte[] bArr2 = f4947h.get(algorithm);
                if (bArr2 == null) {
                    byte[] digest = messageDigest.digest();
                    f4947h.put(algorithm, digest);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f4950d : invokeV.intValue;
    }

    public final void d(byte[] bArr, int i2, int i3, byte[] bArr2, int i4, int i5) throws BadPaddingException {
        int i6;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{bArr, Integer.valueOf(i2), Integer.valueOf(i3), bArr2, Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            byte[] bArr3 = new byte[4];
            byte[] bArr4 = new byte[20];
            while (i5 > 0) {
                this.f4952f.update(bArr, i2, i3);
                this.f4952f.update(bArr3);
                try {
                    this.f4952f.digest(bArr4, 0, 20);
                    for (int i7 = 0; i7 < 20 && i5 > 0; i7++) {
                        bArr2[i4] = (byte) (bArr4[i7] ^ bArr2[i4]);
                        i5--;
                        i4++;
                    }
                    if (i5 > 0) {
                        while (true) {
                            byte b2 = (byte) (bArr3[i6] + 1);
                            bArr3[i6] = b2;
                            i6 = (b2 == 0 && i6 > 0) ? i6 - 1 : 3;
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
            if (bArr.length > this.f4950d) {
                throw new BadPaddingException("Data must be shorter than " + (this.f4950d + 1) + " bytes");
            }
            int i2 = this.a;
            if (i2 == 1 || i2 == 2) {
                return i(bArr);
            }
            if (i2 != 3) {
                if (i2 == 4) {
                    return k(bArr);
                }
                throw new AssertionError();
            }
            return bArr;
        }
        return (byte[]) invokeL.objValue;
    }

    public byte[] g(byte[] bArr, int i2, int i3) throws BadPaddingException {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLII = interceptable.invokeLII(1048579, this, bArr, i2, i3)) == null) ? f(a.d(bArr, i2, i3)) : (byte[]) invokeLII.objValue;
    }

    public byte[] h(byte[] bArr) throws BadPaddingException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, bArr)) == null) {
            if (bArr.length != this.f4948b) {
                throw new BadPaddingException("Padded length must be " + this.f4948b);
            }
            int i2 = this.a;
            if (i2 == 1 || i2 == 2) {
                return j(bArr);
            }
            if (i2 != 3) {
                if (i2 == 4) {
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
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, bArr)) == null) {
            int i4 = this.f4948b;
            byte[] bArr2 = new byte[i4];
            System.arraycopy(bArr, 0, bArr2, i4 - bArr.length, bArr.length);
            int length = (this.f4948b - 3) - bArr.length;
            bArr2[0] = 0;
            int i5 = this.a;
            bArr2[1] = (byte) i5;
            int i6 = -1;
            int i7 = 2;
            if (i5 != 1) {
                if (this.f4949c == null) {
                    this.f4949c = a.a;
                }
                byte[] bArr3 = new byte[64];
                while (true) {
                    int i8 = length - 1;
                    if (length <= 0) {
                        break;
                    }
                    while (true) {
                        if (i6 < 0) {
                            this.f4949c.nextBytes(bArr3);
                            i6 = 63;
                        }
                        i2 = i6 - 1;
                        i3 = bArr3[i6] & 255;
                        if (i3 != 0) {
                            break;
                        }
                        i6 = i2;
                    }
                    bArr2[i7] = (byte) i3;
                    i6 = i2;
                    length = i8;
                    i7++;
                }
            } else {
                while (true) {
                    int i9 = length - 1;
                    if (length <= 0) {
                        break;
                    }
                    bArr2[i7] = -1;
                    i7++;
                    length = i9;
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
        int i2 = 2;
        if (bArr[1] != this.a) {
            throw new BadPaddingException("Blocktype mismatch: " + ((int) bArr[1]));
        }
        while (true) {
            int i3 = i2 + 1;
            int i4 = bArr[i2] & 255;
            if (i4 == 0) {
                int length = bArr.length - i3;
                if (length <= this.f4950d) {
                    byte[] bArr2 = new byte[length];
                    System.arraycopy(bArr, bArr.length - length, bArr2, 0, length);
                    return bArr2;
                }
                throw new BadPaddingException("Padding string too short");
            } else if (i3 == bArr.length) {
                throw new BadPaddingException("Padding string not terminated");
            } else {
                if (this.a == 1 && i4 != 255) {
                    throw new BadPaddingException("Padding byte not 0xff: " + i4);
                }
                i2 = i3;
            }
        }
    }

    public final byte[] k(byte[] bArr) throws BadPaddingException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, bArr)) == null) {
            if (this.f4949c == null) {
                this.f4949c = a.a;
            }
            int length = this.f4953g.length;
            byte[] bArr2 = new byte[length];
            this.f4949c.nextBytes(bArr2);
            int i2 = this.f4948b;
            byte[] bArr3 = new byte[i2];
            System.arraycopy(bArr2, 0, bArr3, 1, length);
            int i3 = length + 1;
            int i4 = i2 - i3;
            int length2 = this.f4948b - bArr.length;
            System.arraycopy(this.f4953g, 0, bArr3, i3, length);
            bArr3[length2 - 1] = 1;
            System.arraycopy(bArr, 0, bArr3, length2, bArr.length);
            d(bArr3, 1, length, bArr3, i3, i4);
            d(bArr3, i3, i4, bArr3, 1, length);
            return bArr3;
        }
        return (byte[]) invokeL.objValue;
    }

    public final byte[] l(byte[] bArr) throws BadPaddingException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bArr)) == null) {
            int length = this.f4953g.length;
            if (bArr[0] == 0) {
                int i2 = length + 1;
                int length2 = bArr.length - i2;
                d(bArr, i2, length2, bArr, 1, length);
                d(bArr, 1, length, bArr, i2, length2);
                for (int i3 = 0; i3 < length; i3++) {
                    if (this.f4953g[i3] != bArr[i2 + i3]) {
                        throw new BadPaddingException("lHash mismatch");
                    }
                }
                int i4 = i2 + length;
                while (bArr[i4] == 0) {
                    i4++;
                    if (i4 >= bArr.length) {
                        throw new BadPaddingException("Padding string not terminated");
                    }
                }
                int i5 = i4 + 1;
                if (bArr[i4] == 1) {
                    int length3 = bArr.length - i5;
                    byte[] bArr2 = new byte[length3];
                    System.arraycopy(bArr, i5, bArr2, 0, length3);
                    return bArr2;
                }
                throw new BadPaddingException("Padding string not terminated by 0x01 byte");
            }
            throw new BadPaddingException("Data must start with zero");
        }
        return (byte[]) invokeL.objValue;
    }
}
