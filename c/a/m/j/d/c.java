package c.a.m.j.d;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.MGF1ParameterSpec;
import java.util.Locale;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.PSource;
/* loaded from: classes.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public String f4228b;

    /* renamed from: c  reason: collision with root package name */
    public f f4229c;

    /* renamed from: d  reason: collision with root package name */
    public byte[] f4230d;

    /* renamed from: e  reason: collision with root package name */
    public int f4231e;

    /* renamed from: f  reason: collision with root package name */
    public d f4232f;

    /* renamed from: g  reason: collision with root package name */
    public String f4233g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1882906224, "Lc/a/m/j/d/c;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1882906224, "Lc/a/m/j/d/c;");
        }
    }

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f4233g = "SHA-1";
        this.f4228b = "PKCS1Padding";
    }

    public void a(int i2, d dVar, SecureRandom secureRandom) throws InvalidKeyException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048576, this, i2, dVar, secureRandom) == null) {
            try {
                b(i2, dVar, secureRandom, null);
            } catch (InvalidAlgorithmParameterException e2) {
                InvalidKeyException invalidKeyException = new InvalidKeyException("Wrong parameters");
                invalidKeyException.initCause(e2);
                throw invalidKeyException;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00c8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void b(int i2, d dVar, SecureRandom secureRandom, AlgorithmParameterSpec algorithmParameterSpec) throws InvalidKeyException, InvalidAlgorithmParameterException {
        boolean z;
        OAEPParameterSpec oAEPParameterSpec;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), dVar, secureRandom, algorithmParameterSpec}) != null) {
            return;
        }
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 != 4) {
                        throw new InvalidKeyException("Unknown mode: " + i2);
                    }
                }
            }
            z = false;
            if (dVar instanceof d) {
                throw new InvalidKeyException("only support helios key");
            }
            this.a = z ? 1 : 4;
            this.f4232f = dVar;
            int a = b.a(dVar.a());
            this.f4231e = 0;
            String str = this.f4228b;
            if (str == "NoPadding") {
                if (algorithmParameterSpec != null) {
                    throw new InvalidAlgorithmParameterException("Parameters not supported");
                }
                this.f4229c = f.b(3, a, secureRandom);
                this.f4230d = new byte[a];
                return;
            } else if (str == "PKCS1Padding") {
                if (algorithmParameterSpec != null) {
                    throw new InvalidAlgorithmParameterException("Parameters not supported");
                }
                f b2 = f.b(this.a > 2 ? 1 : 2, a, secureRandom);
                this.f4229c = b2;
                if (z) {
                    this.f4230d = new byte[b2.a()];
                    return;
                } else {
                    this.f4230d = new byte[a];
                    return;
                }
            } else {
                int i3 = this.a;
                if (i3 == 3 || i3 == 4) {
                    throw new InvalidKeyException("OAEP cannot be used to sign or verify signatures");
                }
                if (algorithmParameterSpec == null) {
                    oAEPParameterSpec = new OAEPParameterSpec(this.f4233g, "MGF1", MGF1ParameterSpec.SHA1, PSource.PSpecified.DEFAULT);
                } else if (!(algorithmParameterSpec instanceof OAEPParameterSpec)) {
                    throw new InvalidAlgorithmParameterException("Wrong Parameters for OAEP Padding");
                } else {
                    oAEPParameterSpec = (OAEPParameterSpec) algorithmParameterSpec;
                }
                f c2 = f.c(4, a, secureRandom, oAEPParameterSpec);
                this.f4229c = c2;
                if (z) {
                    this.f4230d = new byte[c2.a()];
                    return;
                } else {
                    this.f4230d = new byte[a];
                    return;
                }
            }
        }
        z = true;
        if (dVar instanceof d) {
        }
    }

    public final byte[] c() throws BadPaddingException, IllegalBlockSizeException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            int i2 = this.f4231e;
            byte[] bArr = this.f4230d;
            if (i2 > bArr.length) {
                throw new IllegalBlockSizeException("Data must not be longer than " + this.f4230d.length + " bytes");
            }
            try {
                int i3 = this.a;
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 != 3) {
                            if (i3 == 4) {
                                return this.f4229c.j(b.e(b.d(bArr, 0, i2), this.f4232f));
                            }
                            throw new AssertionError("Internal error");
                        }
                        throw new UnsupportedOperationException("only verify supported");
                    }
                    throw new UnsupportedOperationException("only verify supported");
                }
                return b.e(this.f4229c.g(bArr, 0, i2), this.f4232f);
            } finally {
                this.f4231e = 0;
            }
        }
        return (byte[]) invokeV.objValue;
    }

    public byte[] d(byte[] bArr, int i2, int i3) throws BadPaddingException, IllegalBlockSizeException {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048579, this, bArr, i2, i3)) == null) {
            f(bArr, i2, i3);
            return c();
        }
        return (byte[]) invokeLII.objValue;
    }

    public void e(String str) throws NoSuchPaddingException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            String str2 = "NoPadding";
            if (!str.equalsIgnoreCase("NoPadding")) {
                str2 = "PKCS1Padding";
                if (!str.equalsIgnoreCase("PKCS1Padding")) {
                    String lowerCase = str.toLowerCase(Locale.ENGLISH);
                    if (lowerCase.equals("oaeppadding")) {
                        this.f4228b = "OAEP";
                        return;
                    } else if (!lowerCase.startsWith("oaepwith") || !lowerCase.endsWith("andmgf1padding")) {
                        throw new NoSuchPaddingException("Padding " + str + " not supported");
                    } else {
                        this.f4228b = "OAEP";
                        this.f4233g = str.substring(8, str.length() - 14);
                        throw new NoSuchPaddingException("MessageDigest not available for " + str);
                    }
                }
            }
            this.f4228b = str2;
        }
    }

    public final void f(byte[] bArr, int i2, int i3) {
        int i4;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(1048581, this, bArr, i2, i3) == null) || i3 == 0 || bArr == null) {
            return;
        }
        int i5 = this.f4231e;
        int i6 = i5 + i3;
        byte[] bArr2 = this.f4230d;
        if (i6 > bArr2.length) {
            i4 = bArr2.length + 1;
        } else {
            System.arraycopy(bArr, i2, bArr2, i5, i3);
            i4 = this.f4231e + i3;
        }
        this.f4231e = i4;
    }
}
