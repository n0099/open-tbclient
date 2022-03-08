package c.q.a;

import android.graphics.Bitmap;
import android.os.Build;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class e4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int[] a;

    /* renamed from: b  reason: collision with root package name */
    public final int[] f28948b;

    /* renamed from: c  reason: collision with root package name */
    public ByteBuffer f28949c;

    /* renamed from: d  reason: collision with root package name */
    public byte[] f28950d;

    /* renamed from: e  reason: collision with root package name */
    public byte[] f28951e;

    /* renamed from: f  reason: collision with root package name */
    public int f28952f;

    /* renamed from: g  reason: collision with root package name */
    public int f28953g;

    /* renamed from: h  reason: collision with root package name */
    public q4 f28954h;

    /* renamed from: i  reason: collision with root package name */
    public short[] f28955i;

    /* renamed from: j  reason: collision with root package name */
    public byte[] f28956j;
    public byte[] k;
    public byte[] l;
    public int[] m;
    public int n;
    public int o;
    public m4 p;
    public n5 q;
    public Bitmap r;
    public boolean s;
    public int t;
    public int u;
    public int v;
    public int w;
    public boolean x;

    public e4() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        n5 n5Var = new n5();
        this.f28948b = new int[256];
        this.f28952f = 0;
        this.f28953g = 0;
        this.q = n5Var;
        this.p = new m4();
    }

    public synchronized int a(byte[] bArr) {
        InterceptResult invokeL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bArr)) == null) {
            synchronized (this) {
                if (this.f28954h == null) {
                    this.f28954h = new q4();
                }
                q4 q4Var = this.f28954h;
                q4Var.a(bArr);
                if (q4Var.f29092b != null) {
                    if (!q4Var.b()) {
                        String str = "";
                        for (int i3 = 0; i3 < 6; i3++) {
                            str = str + ((char) q4Var.d());
                        }
                        if (str.startsWith("GIF")) {
                            q4Var.f29093c.f29034f = q4Var.f29092b.getShort();
                            q4Var.f29093c.f29035g = q4Var.f29092b.getShort();
                            int d2 = q4Var.d();
                            q4Var.f29093c.f29036h = (d2 & 128) != 0;
                            m4 m4Var = q4Var.f29093c;
                            m4Var.f29037i = 2 << (d2 & 7);
                            m4Var.f29038j = q4Var.d();
                            q4Var.f29093c.k = q4Var.d();
                            if (q4Var.f29093c.f29036h && !q4Var.b()) {
                                m4 m4Var2 = q4Var.f29093c;
                                m4Var2.a = q4Var.c(m4Var2.f29037i);
                                m4 m4Var3 = q4Var.f29093c;
                                m4Var3.l = m4Var3.a[m4Var3.f29038j];
                            }
                        } else {
                            q4Var.f29093c.f29030b = 1;
                        }
                        if (!q4Var.b()) {
                            boolean z = false;
                            while (!z && !q4Var.b() && q4Var.f29093c.f29031c <= Integer.MAX_VALUE) {
                                int d3 = q4Var.d();
                                if (d3 == 33) {
                                    int d4 = q4Var.d();
                                    if (d4 != 1) {
                                        if (d4 == 249) {
                                            q4Var.f29093c.f29032d = new i4();
                                            q4Var.d();
                                            int d5 = q4Var.d();
                                            i4 i4Var = q4Var.f29093c.f29032d;
                                            int i4 = (d5 & 28) >> 2;
                                            i4Var.f28989g = i4;
                                            if (i4 == 0) {
                                                i4Var.f28989g = 1;
                                            }
                                            q4Var.f29093c.f29032d.f28988f = (d5 & 1) != 0;
                                            short s = q4Var.f29092b.getShort();
                                            if (s < 2) {
                                                s = 10;
                                            }
                                            i4 i4Var2 = q4Var.f29093c.f29032d;
                                            i4Var2.f28991i = s * 10;
                                            i4Var2.f28990h = q4Var.d();
                                            q4Var.d();
                                        } else if (d4 != 254 && d4 == 255) {
                                            q4Var.e();
                                            String str2 = "";
                                            for (int i5 = 0; i5 < 11; i5++) {
                                                str2 = str2 + ((char) q4Var.a[i5]);
                                            }
                                            if (str2.equals("NETSCAPE2.0")) {
                                                do {
                                                    q4Var.e();
                                                    byte[] bArr2 = q4Var.a;
                                                    if (bArr2[0] == 1) {
                                                        m4 m4Var4 = q4Var.f29093c;
                                                        int i6 = ((bArr2[2] & 255) << 8) | (bArr2[1] & 255);
                                                        m4Var4.m = i6;
                                                        if (i6 == 0) {
                                                            m4Var4.m = -1;
                                                        }
                                                    }
                                                    if (q4Var.f29094d > 0) {
                                                    }
                                                } while (!q4Var.b());
                                            }
                                        }
                                    }
                                    q4Var.f();
                                } else if (d3 == 44) {
                                    m4 m4Var5 = q4Var.f29093c;
                                    if (m4Var5.f29032d == null) {
                                        m4Var5.f29032d = new i4();
                                    }
                                    q4Var.f29093c.f29032d.a = q4Var.f29092b.getShort();
                                    q4Var.f29093c.f29032d.f28984b = q4Var.f29092b.getShort();
                                    q4Var.f29093c.f29032d.f28985c = q4Var.f29092b.getShort();
                                    q4Var.f29093c.f29032d.f28986d = q4Var.f29092b.getShort();
                                    int d6 = q4Var.d();
                                    boolean z2 = (d6 & 128) != 0;
                                    int pow = (int) Math.pow(2.0d, (d6 & 7) + 1);
                                    q4Var.f29093c.f29032d.f28987e = (d6 & 64) != 0;
                                    if (z2) {
                                        q4Var.f29093c.f29032d.k = q4Var.c(pow);
                                    } else {
                                        q4Var.f29093c.f29032d.k = null;
                                    }
                                    q4Var.f29093c.f29032d.f28992j = q4Var.f29092b.position();
                                    q4Var.d();
                                    q4Var.f();
                                    if (!q4Var.b()) {
                                        m4 m4Var6 = q4Var.f29093c;
                                        m4Var6.f29031c++;
                                        m4Var6.f29033e.add(m4Var6.f29032d);
                                    }
                                } else if (d3 != 59) {
                                    q4Var.f29093c.f29030b = 1;
                                } else {
                                    z = true;
                                }
                            }
                            m4 m4Var7 = q4Var.f29093c;
                            if (m4Var7.f29031c < 0) {
                                m4Var7.f29030b = 1;
                            }
                        }
                    }
                    m4 m4Var8 = q4Var.f29093c;
                    this.p = m4Var8;
                    if (bArr != null) {
                        e(m4Var8, bArr);
                    }
                    i2 = this.t;
                } else {
                    throw new IllegalStateException("You must call setData() before parseHeader()");
                }
            }
            return i2;
        }
        return invokeL.intValue;
    }

    public final Bitmap b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            Bitmap a = this.q.a(this.w, this.v, this.x ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
            if (Build.VERSION.SDK_INT >= 12) {
                a.setHasAlpha(true);
            }
            return a;
        }
        return (Bitmap) invokeV.objValue;
    }

    public synchronized void c(m4 m4Var, ByteBuffer byteBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, m4Var, byteBuffer) == null) {
            synchronized (this) {
                d(m4Var, byteBuffer, 1);
            }
        }
    }

    public synchronized void d(m4 m4Var, ByteBuffer byteBuffer, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048579, this, m4Var, byteBuffer, i2) == null) {
            synchronized (this) {
                if (i2 <= 0) {
                    throw new IllegalArgumentException("Sample size must be >=0, not: " + i2);
                }
                int highestOneBit = Integer.highestOneBit(i2);
                this.t = 0;
                this.p = m4Var;
                this.x = false;
                this.n = -1;
                this.o = 0;
                ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
                this.f28949c = asReadOnlyBuffer;
                asReadOnlyBuffer.position(0);
                this.f28949c.order(ByteOrder.LITTLE_ENDIAN);
                this.s = false;
                Iterator it = m4Var.f29033e.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    } else if (((i4) it.next()).f28989g == 3) {
                        this.s = true;
                        break;
                    }
                }
                this.u = highestOneBit;
                int i3 = m4Var.f29034f;
                this.w = i3 / highestOneBit;
                int i4 = m4Var.f29035g;
                this.v = i4 / highestOneBit;
                this.l = this.q.b(i3 * i4);
                this.m = this.q.c(this.w * this.v);
            }
        }
    }

    public synchronized void e(m4 m4Var, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, m4Var, bArr) == null) {
            synchronized (this) {
                c(m4Var, ByteBuffer.wrap(bArr));
            }
        }
    }

    public final void f(int[] iArr, i4 i4Var, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048581, this, iArr, i4Var, i2) == null) {
            int i3 = i4Var.f28986d;
            int i4 = this.u;
            int i5 = i3 / i4;
            int i6 = i4Var.f28984b / i4;
            int i7 = i4Var.f28985c / i4;
            int i8 = i4Var.a / i4;
            int i9 = this.w;
            int i10 = (i6 * i9) + i8;
            int i11 = (i5 * i9) + i10;
            while (i10 < i11) {
                int i12 = i10 + i7;
                for (int i13 = i10; i13 < i12; i13++) {
                    iArr[i13] = i2;
                }
                i10 += this.w;
            }
        }
    }

    public boolean g(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            if (i2 < -1 || i2 >= this.p.f29031c) {
                return false;
            }
            this.n = i2;
            return true;
        }
        return invokeI.booleanValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:260:0x01fc */
    /* JADX DEBUG: Multi-variable search result rejected for r2v32, resolved type: short */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:225:0x0184 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0189  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized Bitmap h() {
        InterceptResult invokeV;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        short s;
        int i10;
        int i11;
        int i12;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            synchronized (this) {
                int i13 = 1;
                if (this.p.f29031c <= 0 || this.n < 0) {
                    this.t = 1;
                }
                int i14 = this.t;
                if (i14 != 1 && i14 != 2) {
                    int i15 = 0;
                    this.t = 0;
                    i4 i4Var = (i4) this.p.f29033e.get(this.n);
                    int i16 = this.n - 1;
                    i4 i4Var2 = i16 >= 0 ? (i4) this.p.f29033e.get(i16) : null;
                    int[] iArr = i4Var.k;
                    if (iArr == null) {
                        iArr = this.p.a;
                    }
                    this.a = iArr;
                    if (iArr == null) {
                        this.t = 1;
                        return null;
                    }
                    if (i4Var.f28988f) {
                        System.arraycopy(iArr, 0, this.f28948b, 0, iArr.length);
                        int[] iArr2 = this.f28948b;
                        this.a = iArr2;
                        iArr2[i4Var.f28990h] = 0;
                    }
                    int[] iArr3 = this.m;
                    if (i4Var2 == null) {
                        Arrays.fill(iArr3, 0);
                    }
                    if (i4Var2 != null && (i11 = i4Var2.f28989g) > 0) {
                        if (i11 == 2) {
                            if (!i4Var.f28988f) {
                                m4 m4Var = this.p;
                                i12 = m4Var.l;
                                if (i4Var.k != null && m4Var.f29038j == i4Var.f28990h) {
                                }
                                f(iArr3, i4Var2, i12);
                            } else if (this.n == 0) {
                                this.x = true;
                            }
                            i12 = 0;
                            f(iArr3, i4Var2, i12);
                        } else if (i11 == 3) {
                            Bitmap bitmap = this.r;
                            if (bitmap == null) {
                                f(iArr3, i4Var2, 0);
                            } else {
                                int i17 = i4Var2.f28986d;
                                int i18 = this.u;
                                int i19 = i4Var2.f28984b / i18;
                                int i20 = i4Var2.f28985c / i18;
                                int i21 = i4Var2.a / i18;
                                int i22 = this.w;
                                bitmap.getPixels(iArr3, (i19 * i22) + i21, i22, i21, i19, i20, i17 / i18);
                            }
                        }
                    }
                    this.f28952f = 0;
                    this.f28953g = 0;
                    this.f28949c.position(i4Var.f28992j);
                    int i23 = i4Var.f28985c * i4Var.f28986d;
                    byte[] bArr = this.l;
                    if (bArr == null || bArr.length < i23) {
                        this.l = this.q.b(i23);
                    }
                    if (this.f28955i == null) {
                        this.f28955i = new short[4096];
                    }
                    if (this.f28956j == null) {
                        this.f28956j = new byte[4096];
                    }
                    if (this.k == null) {
                        this.k = new byte[4097];
                    }
                    int i24 = i();
                    int i25 = 1 << i24;
                    int i26 = i25 + 1;
                    int i27 = i25 + 2;
                    int i28 = i24 + 1;
                    int i29 = (1 << i28) - 1;
                    for (int i30 = 0; i30 < i25; i30++) {
                        this.f28955i[i30] = 0;
                        this.f28956j[i30] = (byte) i30;
                    }
                    int i31 = i28;
                    int i32 = i27;
                    int i33 = i29;
                    int i34 = 0;
                    int i35 = 0;
                    int i36 = 0;
                    int i37 = 0;
                    int i38 = 0;
                    int i39 = 0;
                    int i40 = 0;
                    int i41 = 0;
                    int i42 = -1;
                    while (true) {
                        if (i34 >= i23) {
                            break;
                        }
                        if (i35 == 0) {
                            i35 = i();
                            if (i35 > 0) {
                                try {
                                    if (this.f28950d == null) {
                                        this.f28950d = this.q.b(255);
                                    }
                                    int i43 = this.f28952f - this.f28953g;
                                    if (i43 >= i35) {
                                        System.arraycopy(this.f28951e, this.f28953g, this.f28950d, i15, i35);
                                        i10 = this.f28953g + i35;
                                    } else if (this.f28949c.remaining() + i43 >= i35) {
                                        try {
                                            System.arraycopy(this.f28951e, this.f28953g, this.f28950d, i15, i43);
                                            this.f28953g = this.f28952f;
                                            j();
                                            int i44 = i35 - i43;
                                            System.arraycopy(this.f28951e, i15, this.f28950d, i43, i44);
                                            i10 = this.f28953g + i44;
                                        } catch (Exception unused) {
                                            i13 = 1;
                                            this.t = i13;
                                            if (i35 > 0) {
                                            }
                                        }
                                    } else {
                                        this.t = i13;
                                    }
                                    this.f28953g = i10;
                                } catch (Exception unused2) {
                                }
                            }
                            if (i35 > 0) {
                                this.t = 3;
                                break;
                            }
                            i37 = 0;
                        }
                        i36 += (this.f28950d[i37] & 255) << i38;
                        i37++;
                        i35--;
                        int i45 = i38 + 8;
                        int i46 = i40;
                        int i47 = i32;
                        int i48 = i31;
                        int i49 = i42;
                        while (i45 >= i48) {
                            int i50 = i28;
                            int i51 = i36 & i33;
                            i36 >>= i48;
                            i45 -= i48;
                            if (i51 != i25) {
                                if (i51 > i47) {
                                    i9 = i45;
                                    this.t = 3;
                                } else {
                                    i9 = i45;
                                    if (i51 != i26) {
                                        if (i49 == -1) {
                                            this.k[i41] = this.f28956j[i51];
                                            i41++;
                                            i49 = i51;
                                            i46 = i49;
                                            i28 = i50;
                                            i45 = i9;
                                        } else {
                                            if (i51 >= i47) {
                                                this.k[i41] = (byte) i46;
                                                s = i49;
                                                i41++;
                                            } else {
                                                s = i51;
                                            }
                                            while (s >= i25) {
                                                this.k[i41] = this.f28956j[s];
                                                s = this.f28955i[s];
                                                i41++;
                                                i51 = i51;
                                            }
                                            int i52 = i51;
                                            byte[] bArr2 = this.f28956j;
                                            int i53 = bArr2[s] & 255;
                                            int i54 = i41 + 1;
                                            int i55 = i25;
                                            byte b2 = (byte) i53;
                                            this.k[i41] = b2;
                                            if (i47 < 4096) {
                                                this.f28955i[i47] = (short) i49;
                                                bArr2[i47] = b2;
                                                i47++;
                                                if ((i47 & i33) == 0 && i47 < 4096) {
                                                    i48++;
                                                    i33 += i47;
                                                }
                                            }
                                            i41 = i54;
                                            while (i41 > 0) {
                                                i41--;
                                                this.l[i39] = this.k[i41];
                                                i34++;
                                                i39++;
                                            }
                                            i46 = i53;
                                            i28 = i50;
                                            i45 = i9;
                                            i49 = i52;
                                            i25 = i55;
                                        }
                                    }
                                }
                                i42 = i49;
                                i31 = i48;
                                i28 = i50;
                                i38 = i9;
                                i15 = 0;
                                i13 = 1;
                                i40 = i46;
                                i32 = i47;
                                break;
                            }
                            i47 = i27;
                            i33 = i29;
                            i28 = i50;
                            i48 = i28;
                            i49 = -1;
                        }
                        i42 = i49;
                        i38 = i45;
                        i40 = i46;
                        i32 = i47;
                        i31 = i48;
                        i15 = 0;
                        i13 = 1;
                    }
                    for (int i56 = i39; i56 < i23; i56++) {
                        this.l[i56] = 0;
                    }
                    int i57 = i4Var.f28986d;
                    int i58 = this.u;
                    int i59 = i57 / i58;
                    int i60 = i4Var.f28984b / i58;
                    int i61 = i4Var.f28985c / i58;
                    int i62 = i4Var.a / i58;
                    boolean z = this.n == 0;
                    int i63 = 0;
                    int i64 = 1;
                    int i65 = 0;
                    int i66 = 8;
                    while (i65 < i59) {
                        if (i4Var.f28987e) {
                            if (i63 >= i59) {
                                i64++;
                                if (i64 == 2) {
                                    i63 = 4;
                                } else if (i64 == 3) {
                                    i63 = 2;
                                    i66 = 4;
                                } else if (i64 == 4) {
                                    i63 = 1;
                                    i66 = 2;
                                }
                            }
                            i3 = i63 + i66;
                        } else {
                            i3 = i63;
                            i63 = i65;
                        }
                        int i67 = i63 + i60;
                        if (i67 < this.v) {
                            int i68 = this.w;
                            int i69 = i67 * i68;
                            int i70 = i69 + i62;
                            int i71 = i70 + i61;
                            int i72 = i69 + i68;
                            if (i72 < i71) {
                                i71 = i72;
                            }
                            int i73 = this.u;
                            int i74 = i65 * i73 * i4Var.f28985c;
                            int i75 = ((i71 - i70) * i73) + i74;
                            int i76 = i70;
                            while (i76 < i71) {
                                int i77 = i59;
                                int i78 = i60;
                                if (this.u == 1) {
                                    i7 = this.a[this.l[i74] & 255];
                                    i4 = i61;
                                    i5 = i62;
                                    i6 = i64;
                                } else {
                                    int i79 = i4Var.f28985c;
                                    i4 = i61;
                                    int i80 = i74;
                                    int i81 = 0;
                                    int i82 = 0;
                                    int i83 = 0;
                                    int i84 = 0;
                                    int i85 = 0;
                                    while (true) {
                                        if (i80 >= this.u + i74) {
                                            i5 = i62;
                                            break;
                                        }
                                        byte[] bArr3 = this.l;
                                        i5 = i62;
                                        if (i80 >= bArr3.length || i80 >= i75) {
                                            break;
                                        }
                                        int i86 = this.a[bArr3[i80] & 255];
                                        if (i86 != 0) {
                                            i8 = i64;
                                            i84 += (i86 >> 24) & 255;
                                            i83 += (i86 >> 16) & 255;
                                            i82 += (i86 >> 8) & 255;
                                            i81 += i86 & 255;
                                            i85++;
                                        } else {
                                            i8 = i64;
                                        }
                                        i80++;
                                        i62 = i5;
                                        i64 = i8;
                                    }
                                    i6 = i64;
                                    int i87 = i79 + i74;
                                    for (int i88 = i87; i88 < this.u + i87; i88++) {
                                        byte[] bArr4 = this.l;
                                        if (i88 >= bArr4.length || i88 >= i75) {
                                            break;
                                        }
                                        int i89 = this.a[bArr4[i88] & 255];
                                        if (i89 != 0) {
                                            i84 += (i89 >> 24) & 255;
                                            i83 += (i89 >> 16) & 255;
                                            i82 += (i89 >> 8) & 255;
                                            i81 += i89 & 255;
                                            i85++;
                                        }
                                    }
                                    i7 = i85 == 0 ? 0 : ((i84 / i85) << 24) | ((i83 / i85) << 16) | ((i82 / i85) << 8) | (i81 / i85);
                                }
                                if (i7 != 0) {
                                    iArr3[i76] = i7;
                                } else if (!this.x && z) {
                                    this.x = true;
                                }
                                i74 += this.u;
                                i76++;
                                i59 = i77;
                                i60 = i78;
                                i61 = i4;
                                i62 = i5;
                                i64 = i6;
                            }
                        }
                        i65++;
                        i63 = i3;
                        i59 = i59;
                        i60 = i60;
                        i61 = i61;
                        i62 = i62;
                        i64 = i64;
                    }
                    if (this.s && ((i2 = i4Var.f28989g) == 0 || i2 == 1)) {
                        if (this.r == null) {
                            this.r = b();
                        }
                        Bitmap bitmap2 = this.r;
                        int i90 = this.w;
                        bitmap2.setPixels(iArr3, 0, i90, 0, 0, i90, this.v);
                    }
                    Bitmap b3 = b();
                    int i91 = this.w;
                    b3.setPixels(iArr3, 0, i91, 0, 0, i91, this.v);
                    return b3;
                }
                return null;
            }
        }
        return (Bitmap) invokeV.objValue;
    }

    public final int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            try {
                j();
                byte[] bArr = this.f28951e;
                int i2 = this.f28953g;
                this.f28953g = i2 + 1;
                return bArr[i2] & 255;
            } catch (Exception unused) {
                this.t = 1;
                return 0;
            }
        }
        return invokeV.intValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || this.f28952f > this.f28953g) {
            return;
        }
        if (this.f28951e == null) {
            this.f28951e = this.q.b(16384);
        }
        this.f28953g = 0;
        int min = Math.min(this.f28949c.remaining(), 16384);
        this.f28952f = min;
        this.f28949c.get(this.f28951e, 0, min);
    }
}
