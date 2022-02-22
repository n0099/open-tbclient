package c.i.b.a.e0.l;

import android.graphics.Color;
import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import androidx.core.view.InputDeviceCompat;
import c.i.b.a.e0.h;
import c.i.b.a.i0.k;
import c.i.b.a.i0.l;
import com.alibaba.fastjson.asm.Opcodes;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.advert.sdk.stretagy.SplashNativePolicy;
import com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.utils.ContactPermissionUtil;
import com.kuaishou.weapon.un.w0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import kotlin.text.Typography;
/* loaded from: classes9.dex */
public final class c extends d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public final l f29657f;

    /* renamed from: g  reason: collision with root package name */
    public final k f29658g;

    /* renamed from: h  reason: collision with root package name */
    public final int f29659h;

    /* renamed from: i  reason: collision with root package name */
    public final a[] f29660i;

    /* renamed from: j  reason: collision with root package name */
    public a f29661j;
    public List<c.i.b.a.e0.b> k;
    public List<c.i.b.a.e0.b> l;
    public b m;
    public int n;

    /* loaded from: classes9.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public static final int[] A;
        public static final int[] B;
        public static final boolean[] C;
        public static final int[] D;
        public static final int[] E;
        public static final int[] F;
        public static final int[] G;
        public static final int w;
        public static final int x;
        public static final int y;
        public static final int[] z;
        public transient /* synthetic */ FieldHolder $fh;
        public final List<SpannableString> a;

        /* renamed from: b  reason: collision with root package name */
        public final SpannableStringBuilder f29662b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f29663c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f29664d;

        /* renamed from: e  reason: collision with root package name */
        public int f29665e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f29666f;

        /* renamed from: g  reason: collision with root package name */
        public int f29667g;

        /* renamed from: h  reason: collision with root package name */
        public int f29668h;

        /* renamed from: i  reason: collision with root package name */
        public int f29669i;

        /* renamed from: j  reason: collision with root package name */
        public int f29670j;
        public boolean k;
        public int l;
        public int m;
        public int n;
        public int o;
        public int p;
        public int q;
        public int r;
        public int s;
        public int t;
        public int u;
        public int v;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1342961719, "Lc/i/b/a/e0/l/c$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1342961719, "Lc/i/b/a/e0/l/c$a;");
                    return;
                }
            }
            w = h(2, 2, 2, 0);
            x = h(0, 0, 0, 0);
            int h2 = h(0, 0, 0, 3);
            y = h2;
            z = new int[]{0, 0, 0, 0, 0, 2, 0};
            A = new int[]{0, 0, 0, 0, 0, 0, 2};
            B = new int[]{3, 3, 3, 3, 3, 3, 1};
            C = new boolean[]{false, false, false, true, true, true, false};
            int i2 = x;
            D = new int[]{i2, h2, i2, i2, h2, i2, i2};
            E = new int[]{0, 1, 2, 3, 4, 3, 4};
            F = new int[]{0, 0, 0, 0, 0, 3, 3};
            G = new int[]{i2, i2, i2, i2, i2, h2, h2};
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
                    return;
                }
            }
            this.a = new LinkedList();
            this.f29662b = new SpannableStringBuilder();
            l();
        }

        public static int g(int i2, int i3, int i4) {
            InterceptResult invokeIII;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeIII = interceptable.invokeIII(65538, null, i2, i3, i4)) == null) ? h(i2, i3, i4, 0) : invokeIII.intValue;
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x0029  */
        /* JADX WARN: Removed duplicated region for block: B:17:0x002c  */
        /* JADX WARN: Removed duplicated region for block: B:19:0x002f  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0032  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0035  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static int h(int i2, int i3, int i4, int i5) {
            InterceptResult invokeIIII;
            int i6;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIII = interceptable.invokeIIII(65539, null, i2, i3, i4, i5)) == null) {
                c.i.b.a.i0.a.c(i2, 0, 4);
                c.i.b.a.i0.a.c(i3, 0, 4);
                c.i.b.a.i0.a.c(i4, 0, 4);
                c.i.b.a.i0.a.c(i5, 0, 4);
                if (i5 != 0 && i5 != 1) {
                    if (i5 == 2) {
                        i6 = 127;
                    } else if (i5 == 3) {
                        i6 = 0;
                    }
                    return Color.argb(i6, i2 <= 1 ? 255 : 0, i3 <= 1 ? 255 : 0, i4 > 1 ? 255 : 0);
                }
                i6 = 255;
                return Color.argb(i6, i2 <= 1 ? 255 : 0, i3 <= 1 ? 255 : 0, i4 > 1 ? 255 : 0);
            }
            return invokeIIII.intValue;
        }

        public void a(char c2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{Character.valueOf(c2)}) != null) {
                return;
            }
            if (c2 == '\n') {
                this.a.add(d());
                this.f29662b.clear();
                if (this.p != -1) {
                    this.p = 0;
                }
                if (this.q != -1) {
                    this.q = 0;
                }
                if (this.r != -1) {
                    this.r = 0;
                }
                if (this.t != -1) {
                    this.t = 0;
                }
                while (true) {
                    if ((!this.k || this.a.size() < this.f29670j) && this.a.size() < 15) {
                        return;
                    }
                    this.a.remove(0);
                }
            } else {
                this.f29662b.append(c2);
            }
        }

        public void b() {
            int length;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (length = this.f29662b.length()) <= 0) {
                return;
            }
            this.f29662b.delete(length - 1, length);
        }

        /* JADX WARN: Removed duplicated region for block: B:25:0x0069  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0074  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0095  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x0097  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x00a3  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x00a5  */
        /* JADX WARN: Removed duplicated region for block: B:43:0x00b1  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public c.i.b.a.e0.l.b c() {
            InterceptResult invokeV;
            Layout.Alignment alignment;
            float f2;
            float f3;
            int i2;
            int i3;
            int i4;
            int i5;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                if (j()) {
                    return null;
                }
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                for (int i6 = 0; i6 < this.a.size(); i6++) {
                    spannableStringBuilder.append((CharSequence) this.a.get(i6));
                    spannableStringBuilder.append('\n');
                }
                spannableStringBuilder.append((CharSequence) d());
                int i7 = this.l;
                if (i7 != 0) {
                    if (i7 == 1) {
                        alignment = Layout.Alignment.ALIGN_OPPOSITE;
                    } else if (i7 == 2) {
                        alignment = Layout.Alignment.ALIGN_CENTER;
                    } else if (i7 != 3) {
                        throw new IllegalArgumentException("Unexpected justification value: " + this.l);
                    }
                    Layout.Alignment alignment2 = alignment;
                    if (!this.f29666f) {
                        f2 = this.f29668h / 99.0f;
                        f3 = this.f29667g / 99.0f;
                    } else {
                        f2 = this.f29668h / 209.0f;
                        f3 = this.f29667g / 74.0f;
                    }
                    float f4 = (f2 * 0.9f) + 0.05f;
                    float f5 = (f3 * 0.9f) + 0.05f;
                    i2 = this.f29669i;
                    if (i2 % 3 != 0) {
                        i3 = 0;
                    } else {
                        i3 = i2 % 3 == 1 ? 1 : 2;
                    }
                    i4 = this.f29669i;
                    if (i4 / 3 != 0) {
                        i5 = 0;
                    } else {
                        i5 = i4 / 3 == 1 ? 1 : 2;
                    }
                    return new c.i.b.a.e0.l.b(spannableStringBuilder, alignment2, f5, 0, i3, f4, i5, Float.MIN_VALUE, this.o != x, this.o, this.f29665e);
                }
                alignment = Layout.Alignment.ALIGN_NORMAL;
                Layout.Alignment alignment22 = alignment;
                if (!this.f29666f) {
                }
                float f42 = (f2 * 0.9f) + 0.05f;
                float f52 = (f3 * 0.9f) + 0.05f;
                i2 = this.f29669i;
                if (i2 % 3 != 0) {
                }
                i4 = this.f29669i;
                if (i4 / 3 != 0) {
                }
                return new c.i.b.a.e0.l.b(spannableStringBuilder, alignment22, f52, 0, i3, f42, i5, Float.MIN_VALUE, this.o != x, this.o, this.f29665e);
            }
            return (c.i.b.a.e0.l.b) invokeV.objValue;
        }

        public SpannableString d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.f29662b);
                int length = spannableStringBuilder.length();
                if (length > 0) {
                    if (this.p != -1) {
                        spannableStringBuilder.setSpan(new StyleSpan(2), this.p, length, 33);
                    }
                    if (this.q != -1) {
                        spannableStringBuilder.setSpan(new UnderlineSpan(), this.q, length, 33);
                    }
                    if (this.r != -1) {
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(this.s), this.r, length, 33);
                    }
                    if (this.t != -1) {
                        spannableStringBuilder.setSpan(new BackgroundColorSpan(this.u), this.t, length, 33);
                    }
                }
                return new SpannableString(spannableStringBuilder);
            }
            return (SpannableString) invokeV.objValue;
        }

        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.a.clear();
                this.f29662b.clear();
                this.p = -1;
                this.q = -1;
                this.r = -1;
                this.t = -1;
                this.v = 0;
            }
        }

        public void f(boolean z2, boolean z3, boolean z4, int i2, boolean z5, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), Integer.valueOf(i2), Boolean.valueOf(z5), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9)}) == null) {
                this.f29663c = true;
                this.f29664d = z2;
                this.k = z3;
                this.f29665e = i2;
                this.f29666f = z5;
                this.f29667g = i3;
                this.f29668h = i4;
                this.f29669i = i7;
                int i10 = i5 + 1;
                if (this.f29670j != i10) {
                    this.f29670j = i10;
                    while (true) {
                        if ((!z3 || this.a.size() < this.f29670j) && this.a.size() < 15) {
                            break;
                        }
                        this.a.remove(0);
                    }
                }
                if (i8 != 0 && this.m != i8) {
                    this.m = i8;
                    int i11 = i8 - 1;
                    q(D[i11], y, C[i11], 0, A[i11], B[i11], z[i11]);
                }
                if (i9 == 0 || this.n == i9) {
                    return;
                }
                this.n = i9;
                int i12 = i9 - 1;
                m(0, 1, 1, false, false, F[i12], E[i12]);
                n(w, G[i12], x);
            }
        }

        public boolean i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f29663c : invokeV.booleanValue;
        }

        public boolean j() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? !i() || (this.a.isEmpty() && this.f29662b.length() == 0) : invokeV.booleanValue;
        }

        public boolean k() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f29664d : invokeV.booleanValue;
        }

        public void l() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
                e();
                this.f29663c = false;
                this.f29664d = false;
                this.f29665e = 4;
                this.f29666f = false;
                this.f29667g = 0;
                this.f29668h = 0;
                this.f29669i = 0;
                this.f29670j = 15;
                this.k = true;
                this.l = 0;
                this.m = 0;
                this.n = 0;
                int i2 = x;
                this.o = i2;
                this.s = w;
                this.u = i2;
            }
        }

        public void m(int i2, int i3, int i4, boolean z2, boolean z3, int i5, int i6) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z2), Boolean.valueOf(z3), Integer.valueOf(i5), Integer.valueOf(i6)}) == null) {
                if (this.p != -1) {
                    if (!z2) {
                        this.f29662b.setSpan(new StyleSpan(2), this.p, this.f29662b.length(), 33);
                        this.p = -1;
                    }
                } else if (z2) {
                    this.p = this.f29662b.length();
                }
                if (this.q == -1) {
                    if (z3) {
                        this.q = this.f29662b.length();
                    }
                } else if (z3) {
                } else {
                    this.f29662b.setSpan(new UnderlineSpan(), this.q, this.f29662b.length(), 33);
                    this.q = -1;
                }
            }
        }

        public void n(int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIII(1048587, this, i2, i3, i4) == null) {
                if (this.r != -1 && this.s != i2) {
                    this.f29662b.setSpan(new ForegroundColorSpan(this.s), this.r, this.f29662b.length(), 33);
                }
                if (i2 != w) {
                    this.r = this.f29662b.length();
                    this.s = i2;
                }
                if (this.t != -1 && this.u != i3) {
                    this.f29662b.setSpan(new BackgroundColorSpan(this.u), this.t, this.f29662b.length(), 33);
                }
                if (i3 != x) {
                    this.t = this.f29662b.length();
                    this.u = i3;
                }
            }
        }

        public void o(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048588, this, i2, i3) == null) {
                if (this.v != i2) {
                    a('\n');
                }
                this.v = i2;
            }
        }

        public void p(boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048589, this, z2) == null) {
                this.f29664d = z2;
            }
        }

        public void q(int i2, int i3, boolean z2, int i4, int i5, int i6, int i7) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z2), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7)}) == null) {
                this.o = i2;
                this.l = i7;
            }
        }
    }

    /* loaded from: classes9.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int a;

        /* renamed from: b  reason: collision with root package name */
        public final int f29671b;

        /* renamed from: c  reason: collision with root package name */
        public final byte[] f29672c;

        /* renamed from: d  reason: collision with root package name */
        public int f29673d;

        public b(int i2, int i3) {
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
            this.a = i2;
            this.f29671b = i3;
            this.f29672c = new byte[(i3 * 2) - 1];
            this.f29673d = 0;
        }
    }

    public c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f29657f = new l();
        this.f29658g = new k();
        this.f29659h = i2 == -1 ? 1 : i2;
        this.f29660i = new a[8];
        for (int i5 = 0; i5 < 8; i5++) {
            this.f29660i[i5] = new a();
        }
        this.f29661j = this.f29660i[0];
        C();
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            int h2 = a.h(this.f29658g.g(2), this.f29658g.g(2), this.f29658g.g(2), this.f29658g.g(2));
            int g2 = this.f29658g.g(2);
            int g3 = a.g(this.f29658g.g(2), this.f29658g.g(2), this.f29658g.g(2));
            if (this.f29658g.f()) {
                g2 |= 4;
            }
            boolean f2 = this.f29658g.f();
            int g4 = this.f29658g.g(2);
            int g5 = this.f29658g.g(2);
            int g6 = this.f29658g.g(2);
            this.f29658g.n(8);
            this.f29661j.q(h2, g3, f2, g2, g4, g5, g6);
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            b bVar = this.m;
            int i2 = bVar.f29673d;
            if (i2 != (bVar.f29671b * 2) - 1) {
                String str = "DtvCcPacket ended prematurely; size is " + ((this.m.f29671b * 2) - 1) + ", but current index is " + this.m.f29673d + " (sequence number " + this.m.a + "); ignoring packet";
                return;
            }
            this.f29658g.k(bVar.f29672c, i2);
            int g2 = this.f29658g.g(3);
            int g3 = this.f29658g.g(5);
            if (g2 == 7) {
                this.f29658g.n(2);
                g2 += this.f29658g.g(6);
            }
            if (g3 == 0) {
                if (g2 != 0) {
                    String str2 = "serviceNumber is non-zero (" + g2 + ") when blockSize is 0";
                }
            } else if (g2 != this.f29659h) {
            } else {
                boolean z = false;
                while (this.f29658g.b() > 0) {
                    int g4 = this.f29658g.g(8);
                    if (g4 == 16) {
                        int g5 = this.f29658g.g(8);
                        if (g5 <= 31) {
                            q(g5);
                        } else {
                            if (g5 <= 127) {
                                v(g5);
                            } else if (g5 <= 159) {
                                r(g5);
                            } else if (g5 <= 255) {
                                w(g5);
                            } else {
                                String str3 = "Invalid extended command: " + g5;
                            }
                            z = true;
                        }
                    } else if (g4 <= 31) {
                        o(g4);
                    } else {
                        if (g4 <= 127) {
                            t(g4);
                        } else if (g4 <= 159) {
                            p(g4);
                        } else if (g4 <= 255) {
                            u(g4);
                        } else {
                            String str4 = "Invalid base command: " + g4;
                        }
                        z = true;
                    }
                }
                if (z) {
                    this.k = n();
                }
            }
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            for (int i2 = 0; i2 < 8; i2++) {
                this.f29660i[i2].l();
            }
        }
    }

    @Override // c.i.b.a.e0.l.d
    public c.i.b.a.e0.e e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            List<c.i.b.a.e0.b> list = this.k;
            this.l = list;
            return new f(list);
        }
        return (c.i.b.a.e0.e) invokeV.objValue;
    }

    @Override // c.i.b.a.e0.l.d
    public void f(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, hVar) == null) {
            this.f29657f.H(hVar.f30190g.array(), hVar.f30190g.limit());
            while (this.f29657f.a() >= 3) {
                int x = this.f29657f.x() & 7;
                int i2 = x & 3;
                boolean z = (x & 4) == 4;
                byte x2 = (byte) this.f29657f.x();
                byte x3 = (byte) this.f29657f.x();
                if (i2 == 2 || i2 == 3) {
                    if (z) {
                        if (i2 == 3) {
                            m();
                            int i3 = (x2 & 192) >> 6;
                            int i4 = x2 & 63;
                            if (i4 == 0) {
                                i4 = 64;
                            }
                            b bVar = new b(i3, i4);
                            this.m = bVar;
                            byte[] bArr = bVar.f29672c;
                            int i5 = bVar.f29673d;
                            bVar.f29673d = i5 + 1;
                            bArr[i5] = x3;
                        } else {
                            c.i.b.a.i0.a.a(i2 == 2);
                            b bVar2 = this.m;
                            if (bVar2 != null) {
                                byte[] bArr2 = bVar2.f29672c;
                                int i6 = bVar2.f29673d;
                                int i7 = i6 + 1;
                                bVar2.f29673d = i7;
                                bArr2[i6] = x2;
                                bVar2.f29673d = i7 + 1;
                                bArr2[i7] = x3;
                            }
                        }
                        b bVar3 = this.m;
                        if (bVar3.f29673d == (bVar3.f29671b * 2) - 1) {
                            m();
                        }
                    }
                }
            }
        }
    }

    @Override // c.i.b.a.e0.l.d, c.i.b.a.y.c
    public void flush() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.flush();
            this.k = null;
            this.l = null;
            this.n = 0;
            this.f29661j = this.f29660i[0];
            C();
            this.m = null;
        }
    }

    @Override // c.i.b.a.e0.l.d
    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.k != this.l : invokeV.booleanValue;
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || this.m == null) {
            return;
        }
        B();
        this.m = null;
    }

    public final List<c.i.b.a.e0.b> n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < 8; i2++) {
                if (!this.f29660i[i2].j() && this.f29660i[i2].k()) {
                    arrayList.add(this.f29660i[i2].c());
                }
            }
            Collections.sort(arrayList);
            return Collections.unmodifiableList(arrayList);
        }
        return (List) invokeV.objValue;
    }

    public final void o(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048585, this, i2) == null) || i2 == 0) {
            return;
        }
        if (i2 == 3) {
            this.k = n();
        } else if (i2 != 8) {
            switch (i2) {
                case 12:
                    C();
                    return;
                case 13:
                    this.f29661j.a('\n');
                    return;
                case 14:
                    return;
                default:
                    if (i2 >= 17 && i2 <= 23) {
                        String str = "Currently unsupported COMMAND_EXT1 Command: " + i2;
                        this.f29658g.n(8);
                        return;
                    } else if (i2 >= 24 && i2 <= 31) {
                        String str2 = "Currently unsupported COMMAND_P16 Command: " + i2;
                        this.f29658g.n(16);
                        return;
                    } else {
                        String str3 = "Invalid C0 command: " + i2;
                        return;
                    }
            }
        } else {
            this.f29661j.b();
        }
    }

    public final void p(int i2) {
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            int i3 = 1;
            switch (i2) {
                case 128:
                case SplashNativePolicy.SPLASH_CMD_SHOW_PLG /* 129 */:
                case 130:
                case 131:
                case 132:
                case SplashNativePolicy.SPLASH_CMD_ERROR /* 133 */:
                case 134:
                case 135:
                    int i4 = i2 + com.alipay.sdk.encrypt.a.f31098g;
                    if (this.n != i4) {
                        this.n = i4;
                        this.f29661j = this.f29660i[i4];
                        return;
                    }
                    return;
                case 136:
                    while (i3 <= 8) {
                        if (this.f29658g.f()) {
                            this.f29660i[8 - i3].e();
                        }
                        i3++;
                    }
                    return;
                case ContactPermissionUtil.DIALOG_NO_PERMISSION_CONTACTS /* 137 */:
                    for (int i5 = 1; i5 <= 8; i5++) {
                        if (this.f29658g.f()) {
                            this.f29660i[8 - i5].p(true);
                        }
                    }
                    return;
                case 138:
                    while (i3 <= 8) {
                        if (this.f29658g.f()) {
                            this.f29660i[8 - i3].p(false);
                        }
                        i3++;
                    }
                    return;
                case w0.o /* 139 */:
                    for (int i6 = 1; i6 <= 8; i6++) {
                        if (this.f29658g.f()) {
                            this.f29660i[8 - i6].p(!aVar.k());
                        }
                    }
                    return;
                case PbFullScreenEditorActivity.REPLY_MAX_SIZE /* 140 */:
                    while (i3 <= 8) {
                        if (this.f29658g.f()) {
                            this.f29660i[8 - i3].l();
                        }
                        i3++;
                    }
                    return;
                case 141:
                    this.f29658g.n(8);
                    return;
                case 142:
                    return;
                case w0.x0 /* 143 */:
                    C();
                    return;
                case 144:
                    if (!this.f29661j.i()) {
                        this.f29658g.n(16);
                        return;
                    } else {
                        x();
                        return;
                    }
                case w0.n /* 145 */:
                    if (!this.f29661j.i()) {
                        this.f29658g.n(24);
                        return;
                    } else {
                        y();
                        return;
                    }
                case 146:
                    if (!this.f29661j.i()) {
                        this.f29658g.n(16);
                        return;
                    } else {
                        z();
                        return;
                    }
                case 147:
                case 148:
                case Opcodes.FCMPL /* 149 */:
                case 150:
                default:
                    String str = "Invalid C1 command: " + i2;
                    return;
                case Opcodes.DCMPL /* 151 */:
                    if (!this.f29661j.i()) {
                        this.f29658g.n(32);
                        return;
                    } else {
                        A();
                        return;
                    }
                case 152:
                case 153:
                case Opcodes.IFNE /* 154 */:
                case com.baidu.apollon.a.f32571e /* 155 */:
                case 156:
                case w0.p0 /* 157 */:
                case 158:
                case 159:
                    int i7 = i2 - 152;
                    s(i7);
                    if (this.n != i7) {
                        this.n = i7;
                        this.f29661j = this.f29660i[i7];
                        return;
                    }
                    return;
            }
        }
    }

    public final void q(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048587, this, i2) == null) || i2 <= 7) {
            return;
        }
        if (i2 <= 15) {
            this.f29658g.n(8);
        } else if (i2 <= 23) {
            this.f29658g.n(16);
        } else if (i2 <= 31) {
            this.f29658g.n(24);
        }
    }

    public final void r(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            if (i2 <= 135) {
                this.f29658g.n(32);
            } else if (i2 <= 143) {
                this.f29658g.n(40);
            } else if (i2 <= 159) {
                this.f29658g.n(2);
                this.f29658g.n(this.f29658g.g(6) * 8);
            }
        }
    }

    public final void s(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            a aVar = this.f29660i[i2];
            this.f29658g.n(2);
            boolean f2 = this.f29658g.f();
            boolean f3 = this.f29658g.f();
            boolean f4 = this.f29658g.f();
            int g2 = this.f29658g.g(3);
            boolean f5 = this.f29658g.f();
            int g3 = this.f29658g.g(7);
            int g4 = this.f29658g.g(8);
            int g5 = this.f29658g.g(4);
            int g6 = this.f29658g.g(4);
            this.f29658g.n(2);
            int g7 = this.f29658g.g(6);
            this.f29658g.n(2);
            aVar.f(f2, f3, f4, g2, f5, g3, g4, g6, g7, g5, this.f29658g.g(3), this.f29658g.g(3));
        }
    }

    public final void t(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            if (i2 == 127) {
                this.f29661j.a((char) 9835);
            } else {
                this.f29661j.a((char) (i2 & 255));
            }
        }
    }

    public final void u(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            this.f29661j.a((char) (i2 & 255));
        }
    }

    public final void v(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            if (i2 == 32) {
                this.f29661j.a(' ');
            } else if (i2 == 33) {
                this.f29661j.a(Typography.nbsp);
            } else if (i2 == 37) {
                this.f29661j.a(Typography.ellipsis);
            } else if (i2 == 42) {
                this.f29661j.a((char) 352);
            } else if (i2 == 44) {
                this.f29661j.a((char) 338);
            } else if (i2 == 63) {
                this.f29661j.a((char) 376);
            } else if (i2 == 57) {
                this.f29661j.a(Typography.tm);
            } else if (i2 == 58) {
                this.f29661j.a((char) 353);
            } else if (i2 == 60) {
                this.f29661j.a((char) 339);
            } else if (i2 != 61) {
                switch (i2) {
                    case 48:
                        this.f29661j.a((char) 9608);
                        return;
                    case 49:
                        this.f29661j.a(Typography.leftSingleQuote);
                        return;
                    case 50:
                        this.f29661j.a(Typography.rightSingleQuote);
                        return;
                    case 51:
                        this.f29661j.a(Typography.leftDoubleQuote);
                        return;
                    case 52:
                        this.f29661j.a(Typography.rightDoubleQuote);
                        return;
                    case 53:
                        this.f29661j.a(Typography.bullet);
                        return;
                    default:
                        switch (i2) {
                            case 118:
                                this.f29661j.a((char) 8539);
                                return;
                            case 119:
                                this.f29661j.a((char) 8540);
                                return;
                            case 120:
                                this.f29661j.a((char) 8541);
                                return;
                            case 121:
                                this.f29661j.a((char) 8542);
                                return;
                            case 122:
                                this.f29661j.a((char) 9474);
                                return;
                            case 123:
                                this.f29661j.a((char) 9488);
                                return;
                            case 124:
                                this.f29661j.a((char) 9492);
                                return;
                            case 125:
                                this.f29661j.a((char) 9472);
                                return;
                            case 126:
                                this.f29661j.a((char) 9496);
                                return;
                            case 127:
                                this.f29661j.a((char) 9484);
                                return;
                            default:
                                String str = "Invalid G2 character: " + i2;
                                return;
                        }
                }
            } else {
                this.f29661j.a((char) 8480);
            }
        }
    }

    public final void w(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            if (i2 == 160) {
                this.f29661j.a((char) 13252);
                return;
            }
            String str = "Invalid G3 character: " + i2;
            this.f29661j.a('_');
        }
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.f29661j.m(this.f29658g.g(4), this.f29658g.g(2), this.f29658g.g(2), this.f29658g.f(), this.f29658g.f(), this.f29658g.g(3), this.f29658g.g(3));
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            int h2 = a.h(this.f29658g.g(2), this.f29658g.g(2), this.f29658g.g(2), this.f29658g.g(2));
            int h3 = a.h(this.f29658g.g(2), this.f29658g.g(2), this.f29658g.g(2), this.f29658g.g(2));
            this.f29658g.n(2);
            this.f29661j.n(h2, h3, a.g(this.f29658g.g(2), this.f29658g.g(2), this.f29658g.g(2)));
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            this.f29658g.n(4);
            int g2 = this.f29658g.g(4);
            this.f29658g.n(2);
            this.f29661j.o(g2, this.f29658g.g(6));
        }
    }
}
