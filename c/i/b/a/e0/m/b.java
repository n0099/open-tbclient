package c.i.b.a.e0.m;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Region;
import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import c.i.b.a.i0.k;
import c.i.b.a.i0.v;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes4.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static final byte[] f33488h;

    /* renamed from: i  reason: collision with root package name */
    public static final byte[] f33489i;

    /* renamed from: j  reason: collision with root package name */
    public static final byte[] f33490j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Paint f33491a;

    /* renamed from: b  reason: collision with root package name */
    public final Paint f33492b;

    /* renamed from: c  reason: collision with root package name */
    public final Canvas f33493c;

    /* renamed from: d  reason: collision with root package name */
    public final C1492b f33494d;

    /* renamed from: e  reason: collision with root package name */
    public final a f33495e;

    /* renamed from: f  reason: collision with root package name */
    public final h f33496f;

    /* renamed from: g  reason: collision with root package name */
    public Bitmap f33497g;

    /* loaded from: classes4.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final int f33498a;

        /* renamed from: b  reason: collision with root package name */
        public final int[] f33499b;

        /* renamed from: c  reason: collision with root package name */
        public final int[] f33500c;

        /* renamed from: d  reason: collision with root package name */
        public final int[] f33501d;

        public a(int i2, int[] iArr, int[] iArr2, int[] iArr3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), iArr, iArr2, iArr3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f33498a = i2;
            this.f33499b = iArr;
            this.f33500c = iArr2;
            this.f33501d = iArr3;
        }
    }

    /* renamed from: c.i.b.a.e0.m.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static final class C1492b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final int f33502a;

        /* renamed from: b  reason: collision with root package name */
        public final int f33503b;

        /* renamed from: c  reason: collision with root package name */
        public final int f33504c;

        /* renamed from: d  reason: collision with root package name */
        public final int f33505d;

        /* renamed from: e  reason: collision with root package name */
        public final int f33506e;

        /* renamed from: f  reason: collision with root package name */
        public final int f33507f;

        public C1492b(int i2, int i3, int i4, int i5, int i6, int i7) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i8 = newInitContext.flag;
                if ((i8 & 1) != 0) {
                    int i9 = i8 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f33502a = i2;
            this.f33503b = i3;
            this.f33504c = i4;
            this.f33505d = i5;
            this.f33506e = i6;
            this.f33507f = i7;
        }
    }

    /* loaded from: classes4.dex */
    public static final class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final int f33508a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f33509b;

        /* renamed from: c  reason: collision with root package name */
        public final byte[] f33510c;

        /* renamed from: d  reason: collision with root package name */
        public final byte[] f33511d;

        public c(int i2, boolean z, byte[] bArr, byte[] bArr2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Boolean.valueOf(z), bArr, bArr2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f33508a = i2;
            this.f33509b = z;
            this.f33510c = bArr;
            this.f33511d = bArr2;
        }
    }

    /* loaded from: classes4.dex */
    public static final class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final int f33512a;

        /* renamed from: b  reason: collision with root package name */
        public final int f33513b;

        /* renamed from: c  reason: collision with root package name */
        public final SparseArray<e> f33514c;

        public d(int i2, int i3, int i4, SparseArray<e> sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f33512a = i3;
            this.f33513b = i4;
            this.f33514c = sparseArray;
        }
    }

    /* loaded from: classes4.dex */
    public static final class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final int f33515a;

        /* renamed from: b  reason: collision with root package name */
        public final int f33516b;

        public e(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f33515a = i2;
            this.f33516b = i3;
        }
    }

    /* loaded from: classes4.dex */
    public static final class f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final int f33517a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f33518b;

        /* renamed from: c  reason: collision with root package name */
        public final int f33519c;

        /* renamed from: d  reason: collision with root package name */
        public final int f33520d;

        /* renamed from: e  reason: collision with root package name */
        public final int f33521e;

        /* renamed from: f  reason: collision with root package name */
        public final int f33522f;

        /* renamed from: g  reason: collision with root package name */
        public final int f33523g;

        /* renamed from: h  reason: collision with root package name */
        public final int f33524h;

        /* renamed from: i  reason: collision with root package name */
        public final int f33525i;

        /* renamed from: j  reason: collision with root package name */
        public final SparseArray<g> f33526j;

        public f(int i2, boolean z, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, SparseArray<g> sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r3;
                Object[] objArr = {Integer.valueOf(i2), Boolean.valueOf(z), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9), Integer.valueOf(i10), sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i11 = newInitContext.flag;
                if ((i11 & 1) != 0) {
                    int i12 = i11 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f33517a = i2;
            this.f33518b = z;
            this.f33519c = i3;
            this.f33520d = i4;
            this.f33521e = i6;
            this.f33522f = i7;
            this.f33523g = i8;
            this.f33524h = i9;
            this.f33525i = i10;
            this.f33526j = sparseArray;
        }

        public void a(f fVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) || fVar == null) {
                return;
            }
            SparseArray<g> sparseArray = fVar.f33526j;
            for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                this.f33526j.put(sparseArray.keyAt(i2), sparseArray.valueAt(i2));
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final int f33527a;

        /* renamed from: b  reason: collision with root package name */
        public final int f33528b;

        public g(int i2, int i3, int i4, int i5, int i6, int i7) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i8 = newInitContext.flag;
                if ((i8 & 1) != 0) {
                    int i9 = i8 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f33527a = i4;
            this.f33528b = i5;
        }
    }

    /* loaded from: classes4.dex */
    public static final class h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final int f33529a;

        /* renamed from: b  reason: collision with root package name */
        public final int f33530b;

        /* renamed from: c  reason: collision with root package name */
        public final SparseArray<f> f33531c;

        /* renamed from: d  reason: collision with root package name */
        public final SparseArray<a> f33532d;

        /* renamed from: e  reason: collision with root package name */
        public final SparseArray<c> f33533e;

        /* renamed from: f  reason: collision with root package name */
        public final SparseArray<a> f33534f;

        /* renamed from: g  reason: collision with root package name */
        public final SparseArray<c> f33535g;

        /* renamed from: h  reason: collision with root package name */
        public C1492b f33536h;

        /* renamed from: i  reason: collision with root package name */
        public d f33537i;

        public h(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f33531c = new SparseArray<>();
            this.f33532d = new SparseArray<>();
            this.f33533e = new SparseArray<>();
            this.f33534f = new SparseArray<>();
            this.f33535g = new SparseArray<>();
            this.f33529a = i2;
            this.f33530b = i3;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f33531c.clear();
                this.f33532d.clear();
                this.f33533e.clear();
                this.f33534f.clear();
                this.f33535g.clear();
                this.f33536h = null;
                this.f33537i = null;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1190193178, "Lc/i/b/a/e0/m/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1190193178, "Lc/i/b/a/e0/m/b;");
                return;
            }
        }
        f33488h = new byte[]{0, 7, 8, 15};
        f33489i = new byte[]{0, 119, -120, -1};
        f33490j = new byte[]{0, 17, 34, 51, 68, 85, 102, 119, -120, -103, -86, -69, -52, -35, -18, -1};
    }

    public b(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Paint paint = new Paint();
        this.f33491a = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.f33491a.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        this.f33491a.setPathEffect(null);
        Paint paint2 = new Paint();
        this.f33492b = paint2;
        paint2.setStyle(Paint.Style.FILL);
        this.f33492b.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OVER));
        this.f33492b.setPathEffect(null);
        this.f33493c = new Canvas();
        this.f33494d = new C1492b(719, 575, 0, 719, 0, 575);
        this.f33495e = new a(0, c(), d(), e());
        this.f33496f = new h(i2, i3);
    }

    public static byte[] a(int i2, int i3, k kVar) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(65538, null, i2, i3, kVar)) == null) {
            byte[] bArr = new byte[i2];
            for (int i4 = 0; i4 < i2; i4++) {
                bArr[i4] = (byte) kVar.g(i3);
            }
            return bArr;
        }
        return (byte[]) invokeIIL.objValue;
    }

    public static int[] c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? new int[]{0, -1, -16777216, -8421505} : (int[]) invokeV.objValue;
    }

    public static int[] d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            int[] iArr = new int[16];
            iArr[0] = 0;
            for (int i2 = 1; i2 < 16; i2++) {
                if (i2 < 8) {
                    iArr[i2] = f(255, (i2 & 1) != 0 ? 255 : 0, (i2 & 2) != 0 ? 255 : 0, (i2 & 4) != 0 ? 255 : 0);
                } else {
                    iArr[i2] = f(255, (i2 & 1) != 0 ? 127 : 0, (i2 & 2) != 0 ? 127 : 0, (i2 & 4) == 0 ? 0 : 127);
                }
            }
            return iArr;
        }
        return (int[]) invokeV.objValue;
    }

    public static int[] e() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) {
            int[] iArr = new int[256];
            iArr[0] = 0;
            for (int i3 = 0; i3 < 256; i3++) {
                if (i3 < 8) {
                    iArr[i3] = f(63, (i3 & 1) != 0 ? 255 : 0, (i3 & 2) != 0 ? 255 : 0, (i3 & 4) == 0 ? 0 : 255);
                } else {
                    int i4 = i3 & 136;
                    int i5 = Constants.METHOD_IM_GET_USER_PROFILE_BY_BAIDU_UID;
                    if (i4 == 0) {
                        int i6 = ((i3 & 1) != 0 ? 85 : 0) + ((i3 & 16) != 0 ? Constants.METHOD_IM_GET_USER_PROFILE_BY_BAIDU_UID : 0);
                        int i7 = ((i3 & 2) != 0 ? 85 : 0) + ((i3 & 32) != 0 ? Constants.METHOD_IM_GET_USER_PROFILE_BY_BAIDU_UID : 0);
                        i2 = (i3 & 4) == 0 ? 0 : 85;
                        if ((i3 & 64) == 0) {
                            i5 = 0;
                        }
                        iArr[i3] = f(255, i6, i7, i2 + i5);
                    } else if (i4 == 8) {
                        int i8 = ((i3 & 1) != 0 ? 85 : 0) + ((i3 & 16) != 0 ? Constants.METHOD_IM_GET_USER_PROFILE_BY_BAIDU_UID : 0);
                        int i9 = ((i3 & 2) != 0 ? 85 : 0) + ((i3 & 32) != 0 ? Constants.METHOD_IM_GET_USER_PROFILE_BY_BAIDU_UID : 0);
                        i2 = (i3 & 4) == 0 ? 0 : 85;
                        if ((i3 & 64) == 0) {
                            i5 = 0;
                        }
                        iArr[i3] = f(127, i8, i9, i2 + i5);
                    } else if (i4 == 128) {
                        iArr[i3] = f(255, ((i3 & 1) != 0 ? 43 : 0) + 127 + ((i3 & 16) != 0 ? 85 : 0), ((i3 & 2) != 0 ? 43 : 0) + 127 + ((i3 & 32) != 0 ? 85 : 0), ((i3 & 4) == 0 ? 0 : 43) + 127 + ((i3 & 64) == 0 ? 0 : 85));
                    } else if (i4 == 136) {
                        iArr[i3] = f(255, ((i3 & 1) != 0 ? 43 : 0) + ((i3 & 16) != 0 ? 85 : 0), ((i3 & 2) != 0 ? 43 : 0) + ((i3 & 32) != 0 ? 85 : 0), ((i3 & 4) == 0 ? 0 : 43) + ((i3 & 64) == 0 ? 0 : 85));
                    }
                }
            }
            return iArr;
        }
        return (int[]) invokeV.objValue;
    }

    public static int f(int i2, int i3, int i4, int i5) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIIII = interceptable.invokeIIII(AdIconUtil.BAIDU_LOGO_ID, null, i2, i3, i4, i5)) == null) ? (i2 << 24) | (i3 << 16) | (i4 << 8) | i5 : invokeIIII.intValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0067 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0087 A[LOOP:0: B:5:0x000d->B:35:0x0087, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0086 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int g(k kVar, int[] iArr, byte[] bArr, int i2, int i3, Paint paint, Canvas canvas) {
        InterceptResult invokeCommon;
        boolean z;
        int i4;
        int g2;
        int g3;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{kVar, iArr, bArr, Integer.valueOf(i2), Integer.valueOf(i3), paint, canvas})) != null) {
            return invokeCommon.intValue;
        }
        int i5 = i2;
        boolean z2 = false;
        while (true) {
            byte g4 = kVar.g(2);
            if (g4 != 0) {
                z = z2;
            } else {
                if (kVar.f()) {
                    g2 = kVar.g(3) + 3;
                    g3 = kVar.g(2);
                } else if (kVar.f()) {
                    z = z2;
                    g4 = 0;
                } else {
                    int g5 = kVar.g(2);
                    if (g5 == 0) {
                        g4 = 0;
                        z = true;
                    } else if (g5 == 1) {
                        z = z2;
                        g4 = 0;
                        i4 = 2;
                        if (i4 != 0 && paint != null) {
                            if (bArr != null) {
                                g4 = bArr[g4];
                            }
                            paint.setColor(iArr[g4]);
                            canvas.drawRect(i5, i3, i5 + i4, i3 + 1, paint);
                        }
                        i5 += i4;
                        if (!z) {
                            return i5;
                        }
                        z2 = z;
                    } else if (g5 == 2) {
                        g2 = kVar.g(4) + 12;
                        g3 = kVar.g(2);
                    } else if (g5 != 3) {
                        z = z2;
                        g4 = 0;
                    } else {
                        g2 = kVar.g(8) + 29;
                        g3 = kVar.g(2);
                    }
                    i4 = 0;
                    if (i4 != 0) {
                        if (bArr != null) {
                        }
                        paint.setColor(iArr[g4]);
                        canvas.drawRect(i5, i3, i5 + i4, i3 + 1, paint);
                    }
                    i5 += i4;
                    if (!z) {
                    }
                }
                z = z2;
                i4 = g2;
                g4 = g3;
                if (i4 != 0) {
                }
                i5 += i4;
                if (!z) {
                }
            }
            i4 = 1;
            if (i4 != 0) {
            }
            i5 += i4;
            if (!z) {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0092 A[LOOP:0: B:5:0x000d->B:38:0x0092, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0091 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int h(k kVar, int[] iArr, byte[] bArr, int i2, int i3, Paint paint, Canvas canvas) {
        InterceptResult invokeCommon;
        boolean z;
        int i4;
        int g2;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{kVar, iArr, bArr, Integer.valueOf(i2), Integer.valueOf(i3), paint, canvas})) != null) {
            return invokeCommon.intValue;
        }
        int i5 = i2;
        boolean z2 = false;
        while (true) {
            byte g3 = kVar.g(4);
            if (g3 != 0) {
                z = z2;
            } else {
                if (!kVar.f()) {
                    int g4 = kVar.g(3);
                    if (g4 != 0) {
                        z = z2;
                        i4 = g4 + 2;
                        g3 = 0;
                    } else {
                        g3 = 0;
                        z = true;
                        i4 = 0;
                    }
                } else {
                    if (!kVar.f()) {
                        g2 = kVar.g(2) + 4;
                        g3 = kVar.g(4);
                    } else {
                        int g5 = kVar.g(2);
                        if (g5 == 0) {
                            z = z2;
                            g3 = 0;
                        } else if (g5 == 1) {
                            z = z2;
                            g3 = 0;
                            i4 = 2;
                        } else if (g5 == 2) {
                            g2 = kVar.g(4) + 9;
                            g3 = kVar.g(4);
                        } else if (g5 != 3) {
                            z = z2;
                            g3 = 0;
                            i4 = 0;
                        } else {
                            g2 = kVar.g(8) + 25;
                            g3 = kVar.g(4);
                        }
                    }
                    z = z2;
                    i4 = g2;
                }
                if (i4 != 0 && paint != null) {
                    if (bArr != null) {
                        g3 = bArr[g3];
                    }
                    paint.setColor(iArr[g3]);
                    canvas.drawRect(i5, i3, i5 + i4, i3 + 1, paint);
                }
                i5 += i4;
                if (!z) {
                    return i5;
                }
                z2 = z;
            }
            i4 = 1;
            if (i4 != 0) {
                if (bArr != null) {
                }
                paint.setColor(iArr[g3]);
                canvas.drawRect(i5, i3, i5 + i4, i3 + 1, paint);
            }
            i5 += i4;
            if (!z) {
            }
        }
    }

    public static int i(k kVar, int[] iArr, byte[] bArr, int i2, int i3, Paint paint, Canvas canvas) {
        InterceptResult invokeCommon;
        boolean z;
        int g2;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(65545, null, new Object[]{kVar, iArr, bArr, Integer.valueOf(i2), Integer.valueOf(i3), paint, canvas})) != null) {
            return invokeCommon.intValue;
        }
        int i4 = i2;
        boolean z2 = false;
        while (true) {
            byte g3 = kVar.g(8);
            if (g3 != 0) {
                z = z2;
                g2 = 1;
            } else if (!kVar.f()) {
                int g4 = kVar.g(7);
                if (g4 != 0) {
                    z = z2;
                    g2 = g4;
                    g3 = 0;
                } else {
                    g3 = 0;
                    z = true;
                    g2 = 0;
                }
            } else {
                z = z2;
                g2 = kVar.g(7);
                g3 = kVar.g(8);
            }
            if (g2 != 0 && paint != null) {
                if (bArr != null) {
                    g3 = bArr[g3];
                }
                paint.setColor(iArr[g3]);
                canvas.drawRect(i4, i3, i4 + g2, i3 + 1, paint);
            }
            i4 += g2;
            if (z) {
                return i4;
            }
            z2 = z;
        }
    }

    public static void j(byte[] bArr, int[] iArr, int i2, int i3, int i4, Paint paint, Canvas canvas) {
        byte[] bArr2;
        byte[] bArr3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65546, null, new Object[]{bArr, iArr, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), paint, canvas}) == null) {
            k kVar = new k(bArr);
            int i5 = i3;
            int i6 = i4;
            byte[] bArr4 = null;
            byte[] bArr5 = null;
            while (kVar.b() != 0) {
                int g2 = kVar.g(8);
                if (g2 != 240) {
                    switch (g2) {
                        case 16:
                            if (i2 == 3) {
                                bArr3 = bArr4 == null ? f33489i : bArr4;
                            } else if (i2 == 2) {
                                bArr3 = bArr5 == null ? f33488h : bArr5;
                            } else {
                                bArr2 = null;
                                i5 = g(kVar, iArr, bArr2, i5, i6, paint, canvas);
                                kVar.c();
                                continue;
                            }
                            bArr2 = bArr3;
                            i5 = g(kVar, iArr, bArr2, i5, i6, paint, canvas);
                            kVar.c();
                            continue;
                        case 17:
                            i5 = h(kVar, iArr, i2 == 3 ? f33490j : null, i5, i6, paint, canvas);
                            kVar.c();
                            continue;
                        case 18:
                            i5 = i(kVar, iArr, null, i5, i6, paint, canvas);
                            continue;
                        default:
                            switch (g2) {
                                case 32:
                                    bArr5 = a(4, 4, kVar);
                                    continue;
                                case 33:
                                    bArr4 = a(4, 8, kVar);
                                    continue;
                                case 34:
                                    bArr4 = a(16, 8, kVar);
                                    continue;
                                default:
                                    continue;
                            }
                    }
                } else {
                    i6 += 2;
                    i5 = i3;
                }
            }
        }
    }

    public static void k(c cVar, a aVar, int i2, int i3, int i4, Paint paint, Canvas canvas) {
        int[] iArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65547, null, new Object[]{cVar, aVar, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), paint, canvas}) == null) {
            if (i2 == 3) {
                iArr = aVar.f33501d;
            } else if (i2 == 2) {
                iArr = aVar.f33500c;
            } else {
                iArr = aVar.f33499b;
            }
            int[] iArr2 = iArr;
            j(cVar.f33510c, iArr2, i2, i3, i4, paint, canvas);
            j(cVar.f33511d, iArr2, i2, i3, i4 + 1, paint, canvas);
        }
    }

    public static a l(k kVar, int i2) {
        InterceptResult invokeLI;
        int g2;
        int i3;
        int g3;
        int g4;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65548, null, kVar, i2)) == null) {
            int i5 = 8;
            int g5 = kVar.g(8);
            kVar.n(8);
            int i6 = 2;
            int i7 = i2 - 2;
            int[] c2 = c();
            int[] d2 = d();
            int[] e2 = e();
            while (i7 > 0) {
                int g6 = kVar.g(i5);
                int g7 = kVar.g(i5);
                int i8 = i7 - 2;
                int[] iArr = (g7 & 128) != 0 ? c2 : (g7 & 64) != 0 ? d2 : e2;
                if ((g7 & 1) != 0) {
                    g4 = kVar.g(i5);
                    i4 = kVar.g(i5);
                    g2 = kVar.g(i5);
                    g3 = kVar.g(i5);
                    i3 = i8 - 4;
                } else {
                    int g8 = kVar.g(4) << 4;
                    g2 = kVar.g(4) << 4;
                    i3 = i8 - 2;
                    g3 = kVar.g(i6) << 6;
                    g4 = kVar.g(6) << i6;
                    i4 = g8;
                }
                if (g4 == 0) {
                    i4 = 0;
                    g2 = 0;
                    g3 = 255;
                }
                double d3 = g4;
                double d4 = i4 + com.alipay.sdk.encrypt.a.f35987g;
                double d5 = g2 + com.alipay.sdk.encrypt.a.f35987g;
                iArr[g6] = f((byte) (255 - (g3 & 255)), v.k((int) (d3 + (1.402d * d4)), 0, 255), v.k((int) ((d3 - (0.34414d * d5)) - (d4 * 0.71414d)), 0, 255), v.k((int) (d3 + (d5 * 1.772d)), 0, 255));
                i7 = i3;
                g5 = g5;
                i5 = 8;
                i6 = 2;
            }
            return new a(g5, c2, d2, e2);
        }
        return (a) invokeLI.objValue;
    }

    public static C1492b m(k kVar) {
        InterceptResult invokeL;
        int i2;
        int i3;
        int i4;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, kVar)) == null) {
            kVar.n(4);
            boolean f2 = kVar.f();
            kVar.n(3);
            int g2 = kVar.g(16);
            int g3 = kVar.g(16);
            if (f2) {
                int g4 = kVar.g(16);
                int g5 = kVar.g(16);
                int g6 = kVar.g(16);
                i3 = kVar.g(16);
                i2 = g5;
                i5 = g6;
                i4 = g4;
            } else {
                i2 = g2;
                i3 = g3;
                i4 = 0;
                i5 = 0;
            }
            return new C1492b(g2, g3, i4, i2, i5, i3);
        }
        return (C1492b) invokeL.objValue;
    }

    public static c n(k kVar) {
        InterceptResult invokeL;
        byte[] bArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, kVar)) == null) {
            int g2 = kVar.g(16);
            kVar.n(4);
            int g3 = kVar.g(2);
            boolean f2 = kVar.f();
            kVar.n(1);
            byte[] bArr2 = null;
            if (g3 == 1) {
                kVar.n(kVar.g(8) * 16);
            } else if (g3 == 0) {
                int g4 = kVar.g(16);
                int g5 = kVar.g(16);
                if (g4 > 0) {
                    bArr2 = new byte[g4];
                    kVar.i(bArr2, 0, g4);
                }
                if (g5 > 0) {
                    bArr = new byte[g5];
                    kVar.i(bArr, 0, g5);
                    return new c(g2, f2, bArr2, bArr);
                }
            }
            bArr = bArr2;
            return new c(g2, f2, bArr2, bArr);
        }
        return (c) invokeL.objValue;
    }

    public static d o(k kVar, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65551, null, kVar, i2)) == null) {
            int g2 = kVar.g(8);
            int g3 = kVar.g(4);
            int g4 = kVar.g(2);
            kVar.n(2);
            int i3 = i2 - 2;
            SparseArray sparseArray = new SparseArray();
            while (i3 > 0) {
                int g5 = kVar.g(8);
                kVar.n(8);
                i3 -= 6;
                sparseArray.put(g5, new e(kVar.g(16), kVar.g(16)));
            }
            return new d(g2, g3, g4, sparseArray);
        }
        return (d) invokeLI.objValue;
    }

    public static f p(k kVar, int i2) {
        InterceptResult invokeLI;
        int g2;
        int g3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65552, null, kVar, i2)) == null) {
            int g4 = kVar.g(8);
            kVar.n(4);
            boolean f2 = kVar.f();
            kVar.n(3);
            int i3 = 16;
            int g5 = kVar.g(16);
            int g6 = kVar.g(16);
            int g7 = kVar.g(3);
            int g8 = kVar.g(3);
            int i4 = 2;
            kVar.n(2);
            int g9 = kVar.g(8);
            int g10 = kVar.g(8);
            int g11 = kVar.g(4);
            int g12 = kVar.g(2);
            kVar.n(2);
            int i5 = i2 - 10;
            SparseArray sparseArray = new SparseArray();
            while (i5 > 0) {
                int g13 = kVar.g(i3);
                int g14 = kVar.g(i4);
                int g15 = kVar.g(i4);
                int g16 = kVar.g(12);
                int i6 = g12;
                kVar.n(4);
                int g17 = kVar.g(12);
                i5 -= 6;
                if (g14 == 1 || g14 == 2) {
                    i5 -= 2;
                    g2 = kVar.g(8);
                    g3 = kVar.g(8);
                } else {
                    g2 = 0;
                    g3 = 0;
                }
                sparseArray.put(g13, new g(g14, g15, g16, g17, g2, g3));
                g12 = i6;
                i4 = 2;
                i3 = 16;
            }
            return new f(g4, f2, g5, g6, g7, g8, g9, g10, g11, g12, sparseArray);
        }
        return (f) invokeLI.objValue;
    }

    public static void q(k kVar, h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65553, null, kVar, hVar) == null) {
            int g2 = kVar.g(8);
            int g3 = kVar.g(16);
            int g4 = kVar.g(16);
            int d2 = kVar.d() + g4;
            if (g4 * 8 > kVar.b()) {
                kVar.n(kVar.b());
                return;
            }
            switch (g2) {
                case 16:
                    if (g3 == hVar.f33529a) {
                        d dVar = hVar.f33537i;
                        d o = o(kVar, g4);
                        if (o.f33513b != 0) {
                            hVar.f33537i = o;
                            hVar.f33531c.clear();
                            hVar.f33532d.clear();
                            hVar.f33533e.clear();
                            break;
                        } else if (dVar != null && dVar.f33512a != o.f33512a) {
                            hVar.f33537i = o;
                            break;
                        }
                    }
                    break;
                case 17:
                    d dVar2 = hVar.f33537i;
                    if (g3 == hVar.f33529a && dVar2 != null) {
                        f p = p(kVar, g4);
                        if (dVar2.f33513b == 0) {
                            p.a(hVar.f33531c.get(p.f33517a));
                        }
                        hVar.f33531c.put(p.f33517a, p);
                        break;
                    }
                    break;
                case 18:
                    if (g3 == hVar.f33529a) {
                        a l = l(kVar, g4);
                        hVar.f33532d.put(l.f33498a, l);
                        break;
                    } else if (g3 == hVar.f33530b) {
                        a l2 = l(kVar, g4);
                        hVar.f33534f.put(l2.f33498a, l2);
                        break;
                    }
                    break;
                case 19:
                    if (g3 == hVar.f33529a) {
                        c n = n(kVar);
                        hVar.f33533e.put(n.f33508a, n);
                        break;
                    } else if (g3 == hVar.f33530b) {
                        c n2 = n(kVar);
                        hVar.f33535g.put(n2.f33508a, n2);
                        break;
                    }
                    break;
                case 20:
                    if (g3 == hVar.f33529a) {
                        hVar.f33536h = m(kVar);
                        break;
                    }
                    break;
            }
            kVar.o(d2 - kVar.d());
        }
    }

    public List<c.i.b.a.e0.b> b(byte[] bArr, int i2) {
        InterceptResult invokeLI;
        int i3;
        int i4;
        SparseArray<g> sparseArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, bArr, i2)) == null) {
            k kVar = new k(bArr, i2);
            while (kVar.b() >= 48 && kVar.g(8) == 15) {
                q(kVar, this.f33496f);
            }
            h hVar = this.f33496f;
            if (hVar.f33537i == null) {
                return Collections.emptyList();
            }
            C1492b c1492b = hVar.f33536h;
            if (c1492b == null) {
                c1492b = this.f33494d;
            }
            Bitmap bitmap = this.f33497g;
            if (bitmap == null || c1492b.f33502a + 1 != bitmap.getWidth() || c1492b.f33503b + 1 != this.f33497g.getHeight()) {
                Bitmap createBitmap = Bitmap.createBitmap(c1492b.f33502a + 1, c1492b.f33503b + 1, Bitmap.Config.ARGB_8888);
                this.f33497g = createBitmap;
                this.f33493c.setBitmap(createBitmap);
            }
            ArrayList arrayList = new ArrayList();
            SparseArray<e> sparseArray2 = this.f33496f.f33537i.f33514c;
            for (int i5 = 0; i5 < sparseArray2.size(); i5++) {
                e valueAt = sparseArray2.valueAt(i5);
                f fVar = this.f33496f.f33531c.get(sparseArray2.keyAt(i5));
                int i6 = valueAt.f33515a + c1492b.f33504c;
                int i7 = valueAt.f33516b + c1492b.f33506e;
                float f2 = i6;
                float f3 = i7;
                this.f33493c.clipRect(f2, f3, Math.min(fVar.f33519c + i6, c1492b.f33505d), Math.min(fVar.f33520d + i7, c1492b.f33507f), Region.Op.REPLACE);
                a aVar = this.f33496f.f33532d.get(fVar.f33522f);
                if (aVar == null && (aVar = this.f33496f.f33534f.get(fVar.f33522f)) == null) {
                    aVar = this.f33495e;
                }
                SparseArray<g> sparseArray3 = fVar.f33526j;
                int i8 = 0;
                while (i8 < sparseArray3.size()) {
                    int keyAt = sparseArray3.keyAt(i8);
                    g valueAt2 = sparseArray3.valueAt(i8);
                    c cVar = this.f33496f.f33533e.get(keyAt);
                    c cVar2 = cVar == null ? this.f33496f.f33535g.get(keyAt) : cVar;
                    if (cVar2 != null) {
                        i4 = i8;
                        sparseArray = sparseArray3;
                        k(cVar2, aVar, fVar.f33521e, valueAt2.f33527a + i6, i7 + valueAt2.f33528b, cVar2.f33509b ? null : this.f33491a, this.f33493c);
                    } else {
                        i4 = i8;
                        sparseArray = sparseArray3;
                    }
                    i8 = i4 + 1;
                    sparseArray3 = sparseArray;
                }
                if (fVar.f33518b) {
                    int i9 = fVar.f33521e;
                    if (i9 == 3) {
                        i3 = aVar.f33501d[fVar.f33523g];
                    } else if (i9 == 2) {
                        i3 = aVar.f33500c[fVar.f33524h];
                    } else {
                        i3 = aVar.f33499b[fVar.f33525i];
                    }
                    this.f33492b.setColor(i3);
                    this.f33493c.drawRect(f2, f3, fVar.f33519c + i6, fVar.f33520d + i7, this.f33492b);
                }
                Bitmap createBitmap2 = Bitmap.createBitmap(this.f33497g, i6, i7, fVar.f33519c, fVar.f33520d);
                int i10 = c1492b.f33502a;
                int i11 = c1492b.f33503b;
                arrayList.add(new c.i.b.a.e0.b(createBitmap2, f2 / i10, 0, f3 / i11, 0, fVar.f33519c / i10, fVar.f33520d / i11));
                this.f33493c.drawColor(0, PorterDuff.Mode.CLEAR);
            }
            return arrayList;
        }
        return (List) invokeLI.objValue;
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f33496f.a();
        }
    }
}
