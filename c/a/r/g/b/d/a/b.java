package c.a.r.g.b.d.a;

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
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.PSource;
/* loaded from: classes3.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f15405a;

    /* renamed from: b  reason: collision with root package name */
    public String f15406b;

    /* renamed from: c  reason: collision with root package name */
    public d f15407c;

    /* renamed from: d  reason: collision with root package name */
    public byte[] f15408d;

    /* renamed from: e  reason: collision with root package name */
    public int f15409e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.r.g.b.e.a f15410f;

    /* renamed from: g  reason: collision with root package name */
    public String f15411g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(2035022442, "Lc/a/r/g/b/d/a/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(2035022442, "Lc/a/r/g/b/d/a/b;");
        }
    }

    public b() {
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
        this.f15411g = "SHA-1";
        this.f15406b = "PKCS1Padding";
    }

    public void a(int i2, c.a.r.g.b.e.a aVar, SecureRandom secureRandom) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048576, this, i2, aVar, secureRandom) == null) {
            try {
                b(i2, aVar, secureRandom, null);
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
    public final void b(int i2, c.a.r.g.b.e.a aVar, SecureRandom secureRandom, AlgorithmParameterSpec algorithmParameterSpec) {
        boolean z;
        OAEPParameterSpec oAEPParameterSpec;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), aVar, secureRandom, algorithmParameterSpec}) != null) {
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
            if (aVar instanceof c.a.r.g.b.e.a) {
                throw new InvalidKeyException("only support helios key");
            }
            this.f15405a = z ? 1 : 4;
            this.f15410f = aVar;
            int a2 = a.a(aVar.b());
            this.f15409e = 0;
            String str = this.f15406b;
            if (str == "NoPadding") {
                if (algorithmParameterSpec != null) {
                    throw new InvalidAlgorithmParameterException("Parameters not supported");
                }
                this.f15407c = d.b(3, a2, secureRandom);
                this.f15408d = new byte[a2];
                return;
            } else if (str == "PKCS1Padding") {
                if (algorithmParameterSpec != null) {
                    throw new InvalidAlgorithmParameterException("Parameters not supported");
                }
                d b2 = d.b(this.f15405a > 2 ? 1 : 2, a2, secureRandom);
                this.f15407c = b2;
                if (z) {
                    this.f15408d = new byte[b2.a()];
                    return;
                } else {
                    this.f15408d = new byte[a2];
                    return;
                }
            } else {
                int i3 = this.f15405a;
                if (i3 == 3 || i3 == 4) {
                    throw new InvalidKeyException("OAEP cannot be used to sign or verify signatures");
                }
                if (algorithmParameterSpec == null) {
                    oAEPParameterSpec = new OAEPParameterSpec(this.f15411g, "MGF1", MGF1ParameterSpec.SHA1, PSource.PSpecified.DEFAULT);
                } else if (!(algorithmParameterSpec instanceof OAEPParameterSpec)) {
                    throw new InvalidAlgorithmParameterException("Wrong Parameters for OAEP Padding");
                } else {
                    oAEPParameterSpec = (OAEPParameterSpec) algorithmParameterSpec;
                }
                d c2 = d.c(4, a2, secureRandom, oAEPParameterSpec);
                this.f15407c = c2;
                if (z) {
                    this.f15408d = new byte[c2.a()];
                    return;
                } else {
                    this.f15408d = new byte[a2];
                    return;
                }
            }
        }
        z = true;
        if (aVar instanceof c.a.r.g.b.e.a) {
        }
    }

    public final byte[] c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            int i2 = this.f15409e;
            byte[] bArr = this.f15408d;
            if (i2 > bArr.length) {
                throw new IllegalBlockSizeException("Data must not be longer than " + this.f15408d.length + " bytes");
            }
            try {
                int i3 = this.f15405a;
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 != 3) {
                            if (i3 == 4) {
                                return this.f15407c.h(a.e(a.d(bArr, 0, i2), this.f15410f));
                            }
                            throw new AssertionError("Internal error");
                        }
                        throw new UnsupportedOperationException("only verify supported");
                    }
                    throw new UnsupportedOperationException("only verify supported");
                }
                return a.e(this.f15407c.g(bArr, 0, i2), this.f15410f);
            } finally {
                this.f15409e = 0;
            }
        }
        return (byte[]) invokeV.objValue;
    }

    public byte[] d(byte[] bArr, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048579, this, bArr, i2, i3)) == null) {
            f(bArr, i2, i3);
            return c();
        }
        return (byte[]) invokeLII.objValue;
    }

    public void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            String str2 = "NoPadding";
            if (!str.equalsIgnoreCase("NoPadding")) {
                str2 = "PKCS1Padding";
                if (!str.equalsIgnoreCase("PKCS1Padding")) {
                    String lowerCase = str.toLowerCase(Locale.ENGLISH);
                    if (lowerCase.equals("oaeppadding")) {
                        this.f15406b = "OAEP";
                        return;
                    } else if (!lowerCase.startsWith("oaepwith") || !lowerCase.endsWith("andmgf1padding")) {
                        throw new NoSuchPaddingException("Padding " + str + " not supported");
                    } else {
                        this.f15406b = "OAEP";
                        this.f15411g = str.substring(8, str.length() - 14);
                        throw new NoSuchPaddingException("MessageDigest not available for " + str);
                    }
                }
            }
            this.f15406b = str2;
        }
    }

    public final void f(byte[] bArr, int i2, int i3) {
        int i4;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(1048581, this, bArr, i2, i3) == null) || i3 == 0 || bArr == null) {
            return;
        }
        int i5 = this.f15409e;
        int i6 = i5 + i3;
        byte[] bArr2 = this.f15408d;
        if (i6 > bArr2.length) {
            i4 = bArr2.length + 1;
        } else {
            System.arraycopy(bArr, i2, bArr2, i5, i3);
            i4 = this.f15409e + i3;
        }
        this.f15409e = i4;
    }
}
