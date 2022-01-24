package c.a.z0.b;

import androidx.core.view.InputDeviceCompat;
import c.a.z0.b.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.searchbox.logsystem.basic.upload.ContentUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.Base64;
import com.baidu.webkit.internal.utils.UtilsBlink;
import com.kwad.yoga.YogaNodeJNIBase;
import io.flutter.plugin.common.StandardMessageCodec;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
/* loaded from: classes9.dex */
public class a extends b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: j  reason: collision with root package name */
    public static final byte[] f26895j;
    public static final byte[] k;
    public static final byte[] l;
    public static final byte[] m;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final byte[] f26896e;

    /* renamed from: f  reason: collision with root package name */
    public final byte[] f26897f;

    /* renamed from: g  reason: collision with root package name */
    public final byte[] f26898g;

    /* renamed from: h  reason: collision with root package name */
    public final int f26899h;

    /* renamed from: i  reason: collision with root package name */
    public final int f26900i;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2125218278, "Lc/a/z0/b/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2125218278, "Lc/a/z0/b/a;");
                return;
            }
        }
        f26895j = new byte[]{13, 10};
        k = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, Constants.SHORT_PING_CMD_TYPE, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, ContentUtil.GZIP_HEAD_1, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
        l = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, Constants.SHORT_PING_CMD_TYPE, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, ContentUtil.GZIP_HEAD_1, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, UtilsBlink.VER_TYPE_SEPARATOR, 95};
        m = new byte[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, 62, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, StandardMessageCodec.LIST, 13, 14, 15, YogaNodeJNIBase.HAS_NEW_LAYOUT, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, PublicSuffixDatabase.EXCEPTION_MARKER, 34, Base64.INTERNAL_PADDING, 36, 37, 38, 39, 40, 41, 42, 43, 44, UtilsBlink.VER_TYPE_SEPARATOR, 46, 47, 48, 49, 50, 51};
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a() {
        this(0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static byte[] n(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) ? new a().d(str) : (byte[]) invokeL.objValue;
    }

    public static byte[] o(byte[] bArr, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(65543, null, bArr, z)) == null) ? p(bArr, z, false) : (byte[]) invokeLZ.objValue;
    }

    public static byte[] p(byte[] bArr, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{bArr, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) ? q(bArr, z, z2, Integer.MAX_VALUE) : (byte[]) invokeCommon.objValue;
    }

    public static byte[] q(byte[] bArr, boolean z, boolean z2, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, null, new Object[]{bArr, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i2)})) == null) {
            if (bArr == null || bArr.length == 0) {
                return bArr;
            }
            a aVar = z ? new a(z2) : new a(0, f26895j, z2);
            long j2 = aVar.j(bArr);
            if (j2 <= i2) {
                return aVar.g(bArr);
            }
            throw new IllegalArgumentException("Input array too big, the output array would be bigger (" + j2 + ") than the specified maximum size of " + i2);
        }
        return (byte[]) invokeCommon.objValue;
    }

    public static String r(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65546, null, bArr)) == null) ? d.d(o(bArr, false)) : (String) invokeL.objValue;
    }

    @Override // c.a.z0.b.b
    public void c(byte[] bArr, int i2, int i3, b.a aVar) {
        byte b2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{bArr, Integer.valueOf(i2), Integer.valueOf(i3), aVar}) == null) || aVar.f26908f) {
            return;
        }
        if (i3 < 0) {
            aVar.f26908f = true;
        }
        int i4 = 0;
        while (true) {
            if (i4 >= i3) {
                break;
            }
            byte[] h2 = h(this.f26899h, aVar);
            int i5 = i2 + 1;
            byte b3 = bArr[i2];
            if (b3 == 61) {
                aVar.f26908f = true;
                break;
            }
            if (b3 >= 0) {
                byte[] bArr2 = m;
                if (b3 < bArr2.length && (b2 = bArr2[b3]) >= 0) {
                    int i6 = (aVar.f26910h + 1) % 4;
                    aVar.f26910h = i6;
                    int i7 = (aVar.a << 6) + b2;
                    aVar.a = i7;
                    if (i6 == 0) {
                        int i8 = aVar.f26906d;
                        int i9 = i8 + 1;
                        aVar.f26906d = i9;
                        h2[i8] = (byte) ((i7 >> 16) & 255);
                        int i10 = i9 + 1;
                        aVar.f26906d = i10;
                        h2[i9] = (byte) ((i7 >> 8) & 255);
                        aVar.f26906d = i10 + 1;
                        h2[i10] = (byte) (i7 & 255);
                    }
                }
            }
            i4++;
            i2 = i5;
        }
        if (!aVar.f26908f || aVar.f26910h == 0) {
            return;
        }
        byte[] h3 = h(this.f26899h, aVar);
        int i11 = aVar.f26910h;
        if (i11 != 1) {
            if (i11 == 2) {
                int i12 = aVar.a >> 4;
                aVar.a = i12;
                int i13 = aVar.f26906d;
                aVar.f26906d = i13 + 1;
                h3[i13] = (byte) (i12 & 255);
            } else if (i11 == 3) {
                int i14 = aVar.a >> 2;
                aVar.a = i14;
                int i15 = aVar.f26906d;
                int i16 = i15 + 1;
                aVar.f26906d = i16;
                h3[i15] = (byte) ((i14 >> 8) & 255);
                aVar.f26906d = i16 + 1;
                h3[i16] = (byte) (i14 & 255);
            } else {
                throw new IllegalStateException("Impossible modulus " + aVar.f26910h);
            }
        }
    }

    @Override // c.a.z0.b.b
    public void f(byte[] bArr, int i2, int i3, b.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{bArr, Integer.valueOf(i2), Integer.valueOf(i3), aVar}) == null) || aVar.f26908f) {
            return;
        }
        if (i3 >= 0) {
            int i4 = 0;
            while (i4 < i3) {
                byte[] h2 = h(this.f26900i, aVar);
                aVar.f26910h = (aVar.f26910h + 1) % 3;
                int i5 = i2 + 1;
                int i6 = bArr[i2];
                if (i6 < 0) {
                    i6 += 256;
                }
                int i7 = (aVar.a << 8) + i6;
                aVar.a = i7;
                if (aVar.f26910h == 0) {
                    int i8 = aVar.f26906d;
                    int i9 = i8 + 1;
                    aVar.f26906d = i9;
                    byte[] bArr2 = this.f26896e;
                    h2[i8] = bArr2[(i7 >> 18) & 63];
                    int i10 = i9 + 1;
                    aVar.f26906d = i10;
                    h2[i9] = bArr2[(i7 >> 12) & 63];
                    int i11 = i10 + 1;
                    aVar.f26906d = i11;
                    h2[i10] = bArr2[(i7 >> 6) & 63];
                    int i12 = i11 + 1;
                    aVar.f26906d = i12;
                    h2[i11] = bArr2[i7 & 63];
                    int i13 = aVar.f26909g + 4;
                    aVar.f26909g = i13;
                    int i14 = this.f26902c;
                    if (i14 > 0 && i14 <= i13) {
                        byte[] bArr3 = this.f26898g;
                        System.arraycopy(bArr3, 0, h2, i12, bArr3.length);
                        aVar.f26906d += this.f26898g.length;
                        aVar.f26909g = 0;
                    }
                }
                i4++;
                i2 = i5;
            }
            return;
        }
        aVar.f26908f = true;
        if (aVar.f26910h == 0 && this.f26902c == 0) {
            return;
        }
        byte[] h3 = h(this.f26900i, aVar);
        int i15 = aVar.f26906d;
        int i16 = aVar.f26910h;
        if (i16 != 0) {
            if (i16 == 1) {
                int i17 = i15 + 1;
                aVar.f26906d = i17;
                byte[] bArr4 = this.f26896e;
                int i18 = aVar.a;
                h3[i15] = bArr4[(i18 >> 2) & 63];
                int i19 = i17 + 1;
                aVar.f26906d = i19;
                h3[i17] = bArr4[(i18 << 4) & 63];
                if (bArr4 == k) {
                    int i20 = i19 + 1;
                    aVar.f26906d = i20;
                    h3[i19] = 61;
                    aVar.f26906d = i20 + 1;
                    h3[i20] = 61;
                }
            } else if (i16 == 2) {
                int i21 = i15 + 1;
                aVar.f26906d = i21;
                byte[] bArr5 = this.f26896e;
                int i22 = aVar.a;
                h3[i15] = bArr5[(i22 >> 10) & 63];
                int i23 = i21 + 1;
                aVar.f26906d = i23;
                h3[i21] = bArr5[(i22 >> 4) & 63];
                int i24 = i23 + 1;
                aVar.f26906d = i24;
                h3[i23] = bArr5[(i22 << 2) & 63];
                if (bArr5 == k) {
                    aVar.f26906d = i24 + 1;
                    h3[i24] = 61;
                }
            } else {
                throw new IllegalStateException("Impossible modulus " + aVar.f26910h);
            }
        }
        int i25 = aVar.f26909g;
        int i26 = aVar.f26906d;
        int i27 = i25 + (i26 - i15);
        aVar.f26909g = i27;
        if (this.f26902c <= 0 || i27 <= 0) {
            return;
        }
        byte[] bArr6 = this.f26898g;
        System.arraycopy(bArr6, 0, h3, i26, bArr6.length);
        aVar.f26906d += this.f26898g.length;
    }

    @Override // c.a.z0.b.b
    public boolean k(byte b2) {
        InterceptResult invokeB;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeB = interceptable.invokeB(Constants.METHOD_SEND_USER_MSG, this, b2)) == null) {
            if (b2 >= 0) {
                byte[] bArr = this.f26897f;
                if (b2 < bArr.length && bArr[b2] != -1) {
                    return true;
                }
            }
            return false;
        }
        return invokeB.booleanValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(boolean z) {
        this(76, f26895j, z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z)};
            interceptable.invokeUnInit(65541, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Integer) objArr2[0]).intValue(), (byte[]) objArr2[1], ((Boolean) objArr2[2]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65541, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(int i2) {
        this(i2, f26895j);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Integer) objArr2[0]).intValue(), (byte[]) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(int i2, byte[] bArr) {
        this(i2, bArr, false);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), bArr};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Integer) objArr2[0]).intValue(), (byte[]) objArr2[1], ((Boolean) objArr2[2]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(int i2, byte[] bArr, boolean z) {
        super(3, 4, i2, bArr == null ? 0 : bArr.length);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), bArr, Boolean.valueOf(z)};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
        this.f26897f = m;
        if (bArr != null) {
            if (b(bArr)) {
                String d2 = d.d(bArr);
                throw new IllegalArgumentException("lineSeparator must not contain base64 characters: [" + d2 + PreferencesUtil.RIGHT_MOUNT);
            } else if (i2 > 0) {
                this.f26900i = bArr.length + 4;
                byte[] bArr2 = new byte[bArr.length];
                this.f26898g = bArr2;
                System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            } else {
                this.f26900i = 4;
                this.f26898g = null;
            }
        } else {
            this.f26900i = 4;
            this.f26898g = null;
        }
        this.f26899h = this.f26900i - 1;
        this.f26896e = z ? l : k;
    }
}
