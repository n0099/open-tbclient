package c.a.k.b.c;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.logsystem.basic.upload.LogSystemUploaderStrategy;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.utils.UtilsBlink;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ boolean f3527a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.k.b.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static abstract class AbstractC0085a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public byte[] f3528a;

        /* renamed from: b  reason: collision with root package name */
        public int f3529b;

        public AbstractC0085a() {
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

    /* loaded from: classes.dex */
    public static class b extends AbstractC0085a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: j  reason: collision with root package name */
        public static final byte[] f3530j;
        public static final /* synthetic */ boolean k;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public final byte[] f3531c;

        /* renamed from: d  reason: collision with root package name */
        public int f3532d;

        /* renamed from: e  reason: collision with root package name */
        public int f3533e;

        /* renamed from: f  reason: collision with root package name */
        public final boolean f3534f;

        /* renamed from: g  reason: collision with root package name */
        public final boolean f3535g;

        /* renamed from: h  reason: collision with root package name */
        public final boolean f3536h;

        /* renamed from: i  reason: collision with root package name */
        public final byte[] f3537i;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1984911169, "Lc/a/k/b/c/a$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1984911169, "Lc/a/k/b/c/a$b;");
                    return;
                }
            }
            k = !a.class.desiredAssertionStatus();
            f3530j = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, Constants.SHORT_PING_CMD_TYPE, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, LogSystemUploaderStrategy.ContentUtil.GZIP_HEAD_1, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, UtilsBlink.VER_TYPE_SEPARATOR, 95};
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
            this.f3528a = null;
            this.f3534f = false;
            this.f3535g = false;
            this.f3536h = false;
            this.f3537i = f3530j;
            this.f3531c = new byte[2];
            this.f3532d = 0;
            this.f3533e = 0 != 0 ? 19 : -1;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1302622659, "Lc/a/k/b/c/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1302622659, "Lc/a/k/b/c/a;");
                return;
            }
        }
        f3527a = !a.class.desiredAssertionStatus();
    }

    public a() {
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

    /* JADX WARN: Code restructure failed: missing block: B:49:0x0109, code lost:
        if (r2.f3536h == false) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x010b, code lost:
        r5[r11] = 13;
        r11 = r11 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0110, code lost:
        r5[r11] = 10;
        r11 = r11 + 1;
        r13 = r12;
     */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0205 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0216 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01f6  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:51:0x0110 -> B:41:0x00bd). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] a(byte[] bArr) {
        InterceptResult invokeL;
        int i2;
        int i3;
        int i4;
        int i5;
        byte b2;
        byte b3;
        byte b4;
        int i6;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65538, null, bArr)) != null) {
            return (byte[]) invokeL.objValue;
        }
        int length = bArr.length;
        b bVar = new b();
        int i7 = (length / 3) * 4;
        int i8 = 1;
        if (!bVar.f3534f) {
            int i9 = length % 3;
            if (i9 == 1) {
                i7 += 2;
            } else if (i9 == 2) {
                i7 += 3;
            }
        } else if (length % 3 > 0) {
            i7 += 4;
        }
        if (bVar.f3535g && length > 0) {
            i7 += (((length - 1) / 57) + 1) * (bVar.f3536h ? 2 : 1);
        }
        byte[] bArr2 = new byte[i7];
        bVar.f3528a = bArr2;
        byte[] bArr3 = bVar.f3537i;
        int i10 = bVar.f3533e;
        int i11 = length + 0;
        int i12 = bVar.f3532d;
        if (i12 != 1) {
            if (i12 == 2 && i11 > 0) {
                byte[] bArr4 = bVar.f3531c;
                i2 = ((bArr4[1] & 255) << 8) | ((bArr4[0] & 255) << 16) | (bArr[0] & 255);
                bVar.f3532d = 0;
                i3 = 1;
            }
            i2 = -1;
            i3 = 0;
        } else {
            if (2 <= i11) {
                i2 = ((bVar.f3531c[0] & 255) << 16) | ((bArr[0] & 255) << 8) | (bArr[1] & 255);
                bVar.f3532d = 0;
                i3 = 2;
            }
            i2 = -1;
            i3 = 0;
        }
        if (i2 != -1) {
            bArr2[0] = bArr3[(i2 >> 18) & 63];
            bArr2[1] = bArr3[(i2 >> 12) & 63];
            bArr2[2] = bArr3[(i2 >> 6) & 63];
            bArr2[3] = bArr3[i2 & 63];
            i10--;
            if (i10 == 0) {
                if (bVar.f3536h) {
                    i6 = 5;
                    bArr2[4] = 13;
                } else {
                    i6 = 4;
                }
                i4 = i6 + 1;
                bArr2[i6] = 10;
                i10 = 19;
            } else {
                i4 = 4;
            }
        } else {
            i4 = 0;
        }
        while (true) {
            int i13 = i3 + 3;
            if (i13 > i11) {
                int i14 = bVar.f3532d;
                if (i3 - i14 == i11 - 1) {
                    if (i14 > 0) {
                        b4 = bVar.f3531c[0];
                    } else {
                        b4 = bArr[i3];
                        i3++;
                        i8 = 0;
                    }
                    int i15 = (b4 & 255) << 4;
                    bVar.f3532d -= i8;
                    int i16 = i4 + 1;
                    bArr2[i4] = bArr3[(i15 >> 6) & 63];
                    int i17 = i16 + 1;
                    bArr2[i16] = bArr3[i15 & 63];
                    if (bVar.f3534f) {
                        int i18 = i17 + 1;
                        bArr2[i17] = 61;
                        i17 = i18 + 1;
                        bArr2[i18] = 61;
                    }
                    if (!bVar.f3535g) {
                        i4 = i17;
                        if (b.k) {
                        }
                        if (b.k) {
                        }
                        bVar.f3529b = i4;
                        bVar.f3533e = i10;
                        if (f3527a) {
                        }
                        return bVar.f3528a;
                    }
                    if (bVar.f3536h) {
                        bArr2[i17] = 13;
                        i17++;
                    }
                    i5 = i17 + 1;
                    bArr2[i17] = 10;
                    i4 = i5;
                    if (!b.k || bVar.f3532d == 0) {
                        if (!b.k || i3 == i11) {
                            bVar.f3529b = i4;
                            bVar.f3533e = i10;
                            if (!f3527a || i4 == i7) {
                                return bVar.f3528a;
                            }
                            throw new AssertionError();
                        }
                        throw new AssertionError();
                    }
                    throw new AssertionError();
                } else if (i3 - i14 != i11 - 2) {
                    if (bVar.f3535g && i4 > 0 && i10 != 19) {
                        if (bVar.f3536h) {
                            bArr2[i4] = 13;
                            i4++;
                        }
                        i5 = i4 + 1;
                        bArr2[i4] = 10;
                        i4 = i5;
                    }
                    if (b.k) {
                    }
                    if (b.k) {
                    }
                    bVar.f3529b = i4;
                    bVar.f3533e = i10;
                    if (f3527a) {
                    }
                    return bVar.f3528a;
                } else {
                    if (i14 > 1) {
                        b2 = bVar.f3531c[0];
                    } else {
                        byte b5 = bArr[i3];
                        i3++;
                        b2 = b5;
                        i8 = 0;
                    }
                    int i19 = (b2 & 255) << 10;
                    if (bVar.f3532d > 0) {
                        b3 = bVar.f3531c[i8];
                        i8++;
                    } else {
                        b3 = bArr[i3];
                        i3++;
                    }
                    int i20 = ((b3 & 255) << 2) | i19;
                    bVar.f3532d -= i8;
                    int i21 = i4 + 1;
                    bArr2[i4] = bArr3[(i20 >> 12) & 63];
                    int i22 = i21 + 1;
                    bArr2[i21] = bArr3[(i20 >> 6) & 63];
                    int i23 = i22 + 1;
                    bArr2[i22] = bArr3[i20 & 63];
                    if (bVar.f3534f) {
                        bArr2[i23] = 61;
                        i23++;
                    }
                    if (!bVar.f3535g) {
                        i4 = i23;
                        if (b.k) {
                        }
                        if (b.k) {
                        }
                        bVar.f3529b = i4;
                        bVar.f3533e = i10;
                        if (f3527a) {
                        }
                        return bVar.f3528a;
                    }
                    if (bVar.f3536h) {
                        bArr2[i23] = 13;
                        i23++;
                    }
                    i5 = i23 + 1;
                    bArr2[i23] = 10;
                    i4 = i5;
                    if (b.k) {
                    }
                    if (b.k) {
                    }
                    bVar.f3529b = i4;
                    bVar.f3533e = i10;
                    if (f3527a) {
                    }
                    return bVar.f3528a;
                }
            }
            int i24 = ((bArr[i3 + 1] & 255) << 8) | ((bArr[i3] & 255) << 16) | (bArr[i3 + 2] & 255);
            bArr2[i4] = bArr3[(i24 >> 18) & 63];
            bArr2[i4 + 1] = bArr3[(i24 >> 12) & 63];
            bArr2[i4 + 2] = bArr3[(i24 >> 6) & 63];
            bArr2[i4 + 3] = bArr3[i24 & 63];
            i4 += 4;
            i10--;
            if (i10 == 0) {
                break;
            }
            i3 = i13;
        }
    }
}
