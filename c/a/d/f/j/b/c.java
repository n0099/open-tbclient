package c.a.d.f.j.b;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.l;
import c.a.d.f.p.m;
import com.baidu.adp.R;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import javax.net.ssl.SSLException;
/* loaded from: classes.dex */
public class c {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: f  reason: collision with root package name */
    public static boolean f1970f = true;
    public transient /* synthetic */ FieldHolder $fh;
    public f a;

    /* renamed from: b  reason: collision with root package name */
    public b f1971b;

    /* renamed from: c  reason: collision with root package name */
    public int f1972c;

    /* renamed from: d  reason: collision with root package name */
    public long f1973d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f1974e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-2027565436, "Lc/a/d/f/j/b/c;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-2027565436, "Lc/a/d/f/j/b/c;");
        }
    }

    public c(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f1972c = 0;
        this.f1973d = 0L;
        this.f1974e = true;
        this.a = fVar;
    }

    public final void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            try {
                if (this.a == null || i2 <= 0) {
                    return;
                }
                this.a.b().a("Retry-Count", String.valueOf(i2));
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    public void b() {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (bVar = this.f1971b) == null) {
            return;
        }
        bVar.b();
    }

    /* JADX WARN: Code restructure failed: missing block: B:114:0x03c9, code lost:
        if (r0 == null) goto L137;
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x04cc, code lost:
        if (r0 == null) goto L137;
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x04ce, code lost:
        r0.c(r23.a);
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x04d3, code lost:
        r10 = r27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x024f, code lost:
        if (r0 == null) goto L137;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x030c, code lost:
        if (r0 == null) goto L137;
     */
    /* JADX WARN: Removed duplicated region for block: B:219:0x08ba  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x08bc  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x0905  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean c(String str, i iVar, int i2, int i3, int i4, int i5, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        e eVar;
        int i6;
        int i7;
        String str2;
        int i8;
        e eVar2;
        e eVar3;
        e eVar4;
        e eVar5;
        String str3;
        e eVar6;
        e eVar7;
        e eVar8;
        e eVar9;
        a b2;
        a b3;
        a b4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, iVar, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            String str4 = "responseCode:";
            int b5 = i4 <= 0 ? c.a.d.c.j.b.d().b().b() : i4;
            int b6 = i5 <= 0 ? c.a.d.c.j.b.d().c().b() : i5;
            b bVar = new b(this.a);
            this.f1971b = bVar;
            bVar.t(f1970f);
            int i9 = 0;
            boolean z3 = false;
            for (int a = i2 <= 0 ? c.a.d.c.j.b.d().a() : i2; i9 < a; a = i7) {
                e eVar10 = new e();
                this.a.c().f1998c = -1;
                this.f1971b.r(i9);
                int i10 = i9 + 1;
                try {
                    try {
                        eVar10.f1981e = i10;
                        try {
                            this.f1972c = i9;
                            a(i9);
                            str2 = str4;
                            i8 = i10;
                            i6 = i9;
                            i7 = a;
                        } catch (IllegalStateException e2) {
                            e = e2;
                            str2 = str4;
                            i8 = i10;
                            eVar9 = eVar10;
                            i6 = i9;
                            i7 = a;
                        } catch (ConnectException e3) {
                            e = e3;
                            str2 = str4;
                            i8 = i10;
                            eVar8 = eVar10;
                            i6 = i9;
                            i7 = a;
                        } catch (SocketException e4) {
                            e = e4;
                            str2 = str4;
                            i8 = i10;
                            eVar7 = eVar10;
                            i6 = i9;
                            i7 = a;
                        } catch (SocketTimeoutException e5) {
                            e = e5;
                            str2 = str4;
                            i8 = i10;
                            eVar6 = eVar10;
                            i6 = i9;
                            i7 = a;
                        }
                    } catch (IllegalStateException e6) {
                        e = e6;
                        str3 = str4;
                        i8 = i10;
                        eVar9 = eVar10;
                        i6 = i9;
                        i7 = a;
                    } catch (ConnectException e7) {
                        e = e7;
                        str3 = str4;
                        i8 = i10;
                        eVar8 = eVar10;
                        i6 = i9;
                        i7 = a;
                    } catch (SocketException e8) {
                        e = e8;
                        str3 = str4;
                        i8 = i10;
                        eVar7 = eVar10;
                        i6 = i9;
                        i7 = a;
                    } catch (SocketTimeoutException e9) {
                        e = e9;
                        str3 = str4;
                        i8 = i10;
                        eVar6 = eVar10;
                        i6 = i9;
                        i7 = a;
                    }
                } catch (FileNotFoundException e10) {
                    e = e10;
                    str2 = str4;
                    i8 = i10;
                    eVar5 = eVar10;
                    i6 = i9;
                    i7 = a;
                } catch (UnknownHostException e11) {
                    e = e11;
                    str2 = str4;
                    i8 = i10;
                    eVar4 = eVar10;
                    i6 = i9;
                    i7 = a;
                } catch (SSLException e12) {
                    e = e12;
                    str2 = str4;
                    i8 = i10;
                    eVar3 = eVar10;
                    i6 = i9;
                    i7 = a;
                } catch (IOException e13) {
                    e = e13;
                    str2 = str4;
                    i8 = i10;
                    eVar2 = eVar10;
                    i6 = i9;
                    i7 = a;
                } catch (Exception e14) {
                    e = e14;
                    str2 = str4;
                    i8 = i10;
                    eVar = eVar10;
                    i6 = i9;
                    i7 = a;
                } catch (Throwable th) {
                    th = th;
                    eVar = eVar10;
                    i6 = i9;
                    i7 = a;
                }
                try {
                    z3 = this.f1971b.d(str, iVar, b5, b6, z, eVar10, z2);
                    if (!z3 && this.a.c().a) {
                        this.a.c().f1998c = -14;
                    }
                    c.a.d.f.e.a.c().g(this.a.b().l(), this.a.b().g("Host"), TextUtils.isEmpty(eVar10.f1984h), eVar10.l != null);
                    if (!z3 && i6 == i7 - 1) {
                        eVar10.f1984h += "|" + c.a.d.f.j.b.l.d.c();
                        eVar10.f1984h += "|netAvailable:" + l.A();
                    }
                    this.a.e(eVar10);
                    a b7 = a.b();
                    if (b7 != null) {
                        b7.c(this.a);
                    }
                    return z3;
                } catch (FileNotFoundException e15) {
                    e = e15;
                    eVar5 = eVar10;
                    StringBuilder sb = new StringBuilder();
                    str3 = str2;
                    sb.append(str3);
                    sb.append(String.valueOf(this.a.c().f1997b));
                    sb.append("|retryCount:");
                    sb.append(i6);
                    sb.append("|");
                    sb.append(e.getClass().getName());
                    sb.append("|");
                    sb.append(e.getMessage());
                    eVar5.f1984h = sb.toString();
                    this.a.c().f1998c = -100;
                    c.a.d.f.e.a.c().g(this.a.b().l(), this.a.b().g("Host"), TextUtils.isEmpty(eVar5.f1984h), eVar5.l != null);
                    if (!z3 && i6 == i7 - 1) {
                        eVar5.f1984h += "|" + c.a.d.f.j.b.l.d.c();
                        eVar5.f1984h += "|netAvailable:" + l.A();
                    }
                    this.a.e(eVar5);
                    b4 = a.b();
                    if (b4 == null) {
                        str4 = str3;
                        i9 = i8;
                    }
                    b4.c(this.a);
                    str4 = str3;
                    i9 = i8;
                } catch (IllegalStateException e16) {
                    e = e16;
                    eVar9 = eVar10;
                    str3 = str2;
                    eVar9.f1984h = str3 + String.valueOf(this.a.c().f1997b) + "|retryCount:" + i6 + "|" + e.getClass().getName() + "|" + e.getMessage() + "|getcontent_illegal_error";
                    this.a.c().f1998c = -19;
                    c.a.d.f.e.a.c().g(this.a.b().l(), this.a.b().g("Host"), TextUtils.isEmpty(eVar9.f1984h), eVar9.l != null);
                    if (!z3 && i6 == i7 - 1) {
                        eVar9.f1984h += "|" + c.a.d.f.j.b.l.d.c();
                        eVar9.f1984h += "|netAvailable:" + l.A();
                    }
                    this.a.e(eVar9);
                    b4 = a.b();
                    if (b4 == null) {
                        str4 = str3;
                        i9 = i8;
                    }
                    b4.c(this.a);
                    str4 = str3;
                    i9 = i8;
                } catch (ConnectException e17) {
                    e = e17;
                    eVar8 = eVar10;
                    str3 = str2;
                    eVar8.f1984h = str3 + String.valueOf(this.a.c().f1997b) + "|retryCount:" + i6 + "|" + e.getClass().getName() + "|" + e.getMessage();
                    this.a.c().f1998c = -22;
                    c.a.d.f.e.a.c().g(this.a.b().l(), this.a.b().g("Host"), TextUtils.isEmpty(eVar8.f1984h), eVar8.l != null);
                    if (!z3 && i6 == i7 - 1) {
                        eVar8.f1984h += "|" + c.a.d.f.j.b.l.d.c();
                        eVar8.f1984h += "|netAvailable:" + l.A();
                    }
                    this.a.e(eVar8);
                    b4 = a.b();
                    if (b4 == null) {
                        str4 = str3;
                        i9 = i8;
                    }
                    b4.c(this.a);
                    str4 = str3;
                    i9 = i8;
                } catch (SocketException e18) {
                    e = e18;
                    eVar7 = eVar10;
                    str3 = str2;
                    eVar7.f1984h = str3 + String.valueOf(this.a.c().f1997b) + "|retryCount:" + i6 + "|" + e.getClass().getName() + "|" + e.getMessage();
                    this.a.c().f1998c = -12;
                    c.a.d.f.e.a.c().g(this.a.b().l(), this.a.b().g("Host"), TextUtils.isEmpty(eVar7.f1984h), eVar7.l != null);
                    if (!z3 && i6 == i7 - 1) {
                        eVar7.f1984h += "|" + c.a.d.f.j.b.l.d.c();
                        eVar7.f1984h += "|netAvailable:" + l.A();
                    }
                    this.a.e(eVar7);
                    b4 = a.b();
                    if (b4 == null) {
                        str4 = str3;
                        i9 = i8;
                    }
                    b4.c(this.a);
                    str4 = str3;
                    i9 = i8;
                } catch (SocketTimeoutException e19) {
                    e = e19;
                    eVar6 = eVar10;
                    str3 = str2;
                    eVar6.f1984h = str3 + String.valueOf(this.a.c().f1997b) + "|retryCount:" + i6 + "|" + e.getClass().getName() + "|" + e.getMessage();
                    this.a.c().f1998c = -13;
                    c.a.d.f.e.a.c().g(this.a.b().l(), this.a.b().g("Host"), TextUtils.isEmpty(eVar6.f1984h), eVar6.l != null);
                    if (!z3 && i6 == i7 - 1) {
                        eVar6.f1984h += "|" + c.a.d.f.j.b.l.d.c();
                        eVar6.f1984h += "|netAvailable:" + l.A();
                    }
                    this.a.e(eVar6);
                    b4 = a.b();
                    if (b4 == null) {
                        str4 = str3;
                        i9 = i8;
                    }
                    b4.c(this.a);
                    str4 = str3;
                    i9 = i8;
                } catch (UnknownHostException e20) {
                    e = e20;
                    eVar4 = eVar10;
                    eVar4.f1984h = "errorCode:" + String.valueOf(this.a.c().f1997b) + "|retryCount:" + i6 + "|" + e.getClass().getName() + "|" + e.getMessage();
                    this.a.c().f1998c = -21;
                    c.a.d.f.e.a.c().g(this.a.b().l(), this.a.b().g("Host"), TextUtils.isEmpty(eVar4.f1984h), eVar4.l != null);
                    if (!z3 && i6 == i7 - 1) {
                        eVar4.f1984h += "|" + c.a.d.f.j.b.l.d.c();
                        eVar4.f1984h += "|netAvailable:" + l.A();
                    }
                    this.a.e(eVar4);
                    b3 = a.b();
                } catch (SSLException e21) {
                    e = e21;
                    eVar3 = eVar10;
                    if (this.a.b().e() && i6 < i7 - 1) {
                        String b8 = c.a.d.f.j.b.l.d.b(this.a.b().l());
                        if (!m.isEmpty(b8)) {
                            this.a.b().t(b8);
                        }
                        BdStatisticsManager.getInstance().eventStat(null, "c13429", "", 1, "obj_type", "1");
                    } else {
                        eVar3.f1984h = "errorCode:" + String.valueOf(this.a.c().f1997b) + "|retryCount:" + i6 + "|" + e.getClass().getName() + "|" + e.getMessage();
                        this.a.c().f1998c = -20;
                    }
                    c.a.d.f.e.a.c().g(this.a.b().l(), this.a.b().g("Host"), TextUtils.isEmpty(eVar3.f1984h), eVar3.l != null);
                    if (!z3 && i6 == i7 - 1) {
                        eVar3.f1984h += "|" + c.a.d.f.j.b.l.d.c();
                        eVar3.f1984h += "|netAvailable:" + l.A();
                    }
                    this.a.e(eVar3);
                    b3 = a.b();
                } catch (IOException e22) {
                    e = e22;
                    eVar2 = eVar10;
                    eVar2.f1984h = "errorCode:" + String.valueOf(this.a.c().f1997b) + "|retryCount:" + i6 + "|" + e.getClass().getName() + "|" + e.getMessage();
                    this.a.c().f1998c = -19;
                    c.a.d.f.e.a.c().g(this.a.b().l(), this.a.b().g("Host"), TextUtils.isEmpty(eVar2.f1984h), eVar2.l != null);
                    if (!z3 && i6 == i7 - 1) {
                        eVar2.f1984h += "|" + c.a.d.f.j.b.l.d.c();
                        eVar2.f1984h += "|netAvailable:" + l.A();
                    }
                    this.a.e(eVar2);
                    b3 = a.b();
                } catch (Exception e23) {
                    e = e23;
                    eVar = eVar10;
                    try {
                        eVar.f1984h = "errorCode:" + String.valueOf(this.a.c().f1997b) + "|retryCount:" + i6 + "|" + e.getClass().getName() + "|" + e.getMessage();
                        this.a.c().f1998c = -10;
                        BdLog.e(e.getMessage());
                        c.a.d.f.e.a.c().g(this.a.b().l(), this.a.b().g("Host"), TextUtils.isEmpty(eVar.f1984h), eVar.l != null);
                        if (!z3 && i6 == i7 - 1) {
                            eVar.f1984h += "|" + c.a.d.f.j.b.l.d.c();
                            eVar.f1984h += "|netAvailable:" + l.A();
                        }
                        this.a.e(eVar);
                        b3 = a.b();
                    } catch (Throwable th2) {
                        th = th2;
                        c.a.d.f.e.a.c().g(this.a.b().l(), this.a.b().g("Host"), TextUtils.isEmpty(eVar.f1984h), eVar.l == null);
                        if (!z3 && i6 == i7 - 1) {
                            eVar.f1984h += "|" + c.a.d.f.j.b.l.d.c();
                            eVar.f1984h += "|netAvailable:" + l.A();
                        }
                        this.a.e(eVar);
                        b2 = a.b();
                        if (b2 != null) {
                            b2.c(this.a);
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    eVar = eVar10;
                    c.a.d.f.e.a.c().g(this.a.b().l(), this.a.b().g("Host"), TextUtils.isEmpty(eVar.f1984h), eVar.l == null);
                    if (!z3) {
                        eVar.f1984h += "|" + c.a.d.f.j.b.l.d.c();
                        eVar.f1984h += "|netAvailable:" + l.A();
                    }
                    this.a.e(eVar);
                    b2 = a.b();
                    if (b2 != null) {
                    }
                    throw th;
                }
            }
            return z3;
        }
        return invokeCommon.booleanValue;
    }

    public boolean d(String str, i iVar, int i2, int i3, int i4, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{str, iVar, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z)})) == null) ? c(str, iVar, i2, -1, i3, i4, false, z) : invokeCommon.booleanValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:107:0x03a6, code lost:
        if (r0 == null) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x03a8, code lost:
        r0.c(r19.a);
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x03ad, code lost:
        r12 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0317, code lost:
        if (r0 == null) goto L82;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void e(int i2, int i3, int i4) {
        a b2;
        b bVar;
        int i5;
        b bVar2;
        a b3;
        b bVar3;
        b bVar4;
        b bVar5;
        b bVar6;
        b bVar7;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048580, this, i2, i3, i4) == null) {
            int b4 = i3 <= 0 ? c.a.d.c.j.b.d().b().b() : i3;
            int a = i2 <= 0 ? c.a.d.c.j.b.d().a() : i2;
            int b5 = i4 <= 0 ? c.a.d.c.j.b.d().c().b() : i4;
            long currentTimeMillis = System.currentTimeMillis();
            int i6 = true;
            int i7 = 0;
            for (int i8 = 1; !this.a.c().a && i6 == i8 && i7 < a; i8 = 1) {
                e eVar = new e();
                this.a.e(eVar);
                try {
                    try {
                        try {
                            this.f1972c = i7;
                            eVar.f1981e = i7 + 1;
                            eVar.v = i8;
                            a(i7);
                            b bVar8 = new b(this.a);
                            this.f1971b = bVar8;
                            bVar8.r(i7);
                            this.f1971b.t(f1970f);
                            this.f1971b.k(b4, b5, eVar);
                        } catch (SocketException e2) {
                            i5 = b4;
                            eVar.f1984h = String.valueOf(this.a.c().f1997b) + "|retryCount:" + i7 + "|" + e2.getClass() + "|" + e2.getMessage();
                            this.a.c().f1998c = -12;
                            if (this.f1973d <= 0 && (bVar4 = this.f1971b) != null) {
                                this.f1973d = bVar4.i();
                            }
                            eVar.f1982f = System.currentTimeMillis() - currentTimeMillis;
                            c.a.d.f.e.a.c().g(this.a.b().l(), this.a.b().g("Host"), TextUtils.isEmpty(eVar.f1984h), eVar.l != null);
                            this.a.f(eVar);
                            b3 = a.b();
                        } catch (SocketTimeoutException e3) {
                            i5 = b4;
                            eVar.f1984h = String.valueOf(this.a.c().f1997b) + "|retryCount:" + i7 + "|" + e3.getClass() + "|" + e3.getMessage();
                            this.a.c().f1998c = -13;
                            if (this.f1973d <= 0 && (bVar3 = this.f1971b) != null) {
                                this.f1973d = bVar3.i();
                            }
                            eVar.f1982f = System.currentTimeMillis() - currentTimeMillis;
                            c.a.d.f.e.a.c().g(this.a.b().l(), this.a.b().g("Host"), TextUtils.isEmpty(eVar.f1984h), eVar.l != null);
                            this.a.f(eVar);
                            b3 = a.b();
                        }
                    } catch (IOException e4) {
                        this.a.c().f1998c = -19;
                        eVar.f1984h = "errorCode:" + String.valueOf(-19) + "|" + e4.getClass() + "|" + e4.getMessage() + "|getcontent_illegal_error";
                        if (this.f1973d <= 0 && (bVar2 = this.f1971b) != null) {
                            this.f1973d = bVar2.i();
                        }
                        eVar.f1982f = System.currentTimeMillis() - currentTimeMillis;
                        i5 = b4;
                        c.a.d.f.e.a.c().g(this.a.b().l(), this.a.b().g("Host"), TextUtils.isEmpty(eVar.f1984h), eVar.l != null);
                        this.a.f(eVar);
                        a b6 = a.b();
                        if (b6 != null) {
                            b6.c(this.a);
                        }
                    } catch (Exception e5) {
                        eVar.f1984h = String.valueOf(this.a.c().f1997b) + "|retryCount:" + i7 + "|" + e5.getClass() + "|" + e5.getMessage();
                        this.a.c().f1998c = -10;
                        BdLog.e(e5.getMessage());
                        if (this.f1973d <= 0 && (bVar = this.f1971b) != null) {
                            this.f1973d = bVar.i();
                        }
                        eVar.f1982f = System.currentTimeMillis() - currentTimeMillis;
                        c.a.d.f.e.a.c().g(this.a.b().l(), this.a.b().g("Host"), TextUtils.isEmpty(eVar.f1984h), eVar.l != null);
                        this.a.f(eVar);
                        b2 = a.b();
                        if (b2 == null) {
                            return;
                        }
                    }
                    if (this.a.c().f1997b != 200) {
                        eVar.f1984h = String.valueOf(this.a.c().f1997b) + "|retryCount:" + i7;
                        boolean m = m(this.a.c().f1997b);
                        if (this.f1973d <= 0 && (bVar7 = this.f1971b) != null) {
                            this.f1973d = bVar7.i();
                        }
                        eVar.f1982f = System.currentTimeMillis() - currentTimeMillis;
                        c.a.d.f.e.a.c().g(this.a.b().l(), this.a.b().g("Host"), TextUtils.isEmpty(eVar.f1984h), eVar.l != null);
                        this.a.f(eVar);
                        a b7 = a.b();
                        if (b7 != null) {
                            b7.c(this.a);
                        }
                        i6 = m;
                        i5 = b4;
                        i7++;
                        b4 = i5;
                    } else {
                        this.a.f(eVar);
                        if (this.f1973d <= 0 && (bVar6 = this.f1971b) != null) {
                            this.f1973d = bVar6.i();
                        }
                        eVar.f1982f = System.currentTimeMillis() - currentTimeMillis;
                        c.a.d.f.e.a.c().g(this.a.b().l(), this.a.b().g("Host"), TextUtils.isEmpty(eVar.f1984h), eVar.l != null);
                        this.a.f(eVar);
                        b2 = a.b();
                        if (b2 == null) {
                            return;
                        }
                        b2.c(this.a);
                        return;
                    }
                } catch (Throwable th) {
                    if (this.f1973d <= 0 && (bVar5 = this.f1971b) != null) {
                        this.f1973d = bVar5.i();
                    }
                    eVar.f1982f = System.currentTimeMillis() - currentTimeMillis;
                    c.a.d.f.e.a.c().g(this.a.b().l(), this.a.b().g("Host"), TextUtils.isEmpty(eVar.f1984h), eVar.l != null);
                    this.a.f(eVar);
                    a b8 = a.b();
                    if (b8 != null) {
                        b8.c(this.a);
                    }
                    throw th;
                }
            }
        }
    }

    public long f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            b bVar = this.f1971b;
            if (bVar == null) {
                return -1L;
            }
            return bVar.e();
        }
        return invokeV.longValue;
    }

    public long g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            b bVar = this.f1971b;
            if (bVar == null) {
                return -1L;
            }
            return bVar.h();
        }
        return invokeV.longValue;
    }

    public long h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            long j2 = this.f1973d;
            if (j2 > 0) {
                return j2;
            }
            b bVar = this.f1971b;
            if (bVar == null) {
                return -1L;
            }
            return bVar.i();
        }
        return invokeV.longValue;
    }

    public long i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            b bVar = this.f1971b;
            if (bVar == null) {
                return -1L;
            }
            return bVar.l();
        }
        return invokeV.longValue;
    }

    public long j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            b bVar = this.f1971b;
            if (bVar == null) {
                return -1L;
            }
            return bVar.j();
        }
        return invokeV.longValue;
    }

    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f1972c : invokeV.intValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            f fVar = this.a;
            if (fVar == null) {
                return false;
            }
            return fVar.c().a;
        }
        return invokeV.booleanValue;
    }

    public final boolean m(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i2)) == null) {
            if (i2 == 202 || i2 == 201 || i2 == 205 || i2 == 304 || i2 == 305 || i2 == 408) {
                return true;
            }
            return (i2 == 502 || i2 == 503 || i2 == 504 || i2 == 404) ? false : true;
        }
        return invokeI.booleanValue;
    }

    public void n(int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048589, this, i2, i3, i4) == null) {
            if (this.a.b().m()) {
                p(i2, i3, i4);
            } else {
                o(i2, i3, i4);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:101:0x0344, code lost:
        if (r0 == null) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x0346, code lost:
        r0.c(r16.a);
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x034b, code lost:
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x02c9, code lost:
        if (r0 == null) goto L64;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void o(int i2, int i3, int i4) {
        b bVar;
        a b2;
        b bVar2;
        b bVar3;
        b bVar4;
        b bVar5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048590, this, i2, i3, i4) == null) {
            int b3 = i3 <= 0 ? c.a.d.c.j.b.d().b().b() : i3;
            int a = i2 <= 0 ? c.a.d.c.j.b.d().a() : i2;
            int b4 = i4 <= 0 ? c.a.d.c.j.b.d().c().b() : i4;
            long currentTimeMillis = System.currentTimeMillis();
            boolean z = true;
            int i5 = 0;
            for (boolean z2 = true; !this.a.c().a && z == z2 && i5 < a; z2 = true) {
                e eVar = new e();
                this.f1972c = i5;
                int i6 = i5 + 1;
                eVar.f1981e = i6;
                a(i5);
                try {
                    try {
                        try {
                            try {
                                b bVar6 = new b(this.a);
                                this.f1971b = bVar6;
                                bVar6.r(i5);
                                this.f1971b.t(f1970f);
                                this.f1971b.s(this.f1974e);
                                this.f1971b.q(b3, b4, eVar);
                            } catch (SocketTimeoutException e2) {
                                this.a.c().f1998c = -13;
                                eVar.f1984h = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                                BdLog.e(e2.getMessage());
                                this.a.e(eVar);
                                if (this.f1973d <= 0 && (bVar3 = this.f1971b) != null) {
                                    this.f1973d = bVar3.i();
                                }
                                eVar.f1982f = System.currentTimeMillis() - currentTimeMillis;
                                c.a.d.f.e.a.c().g(this.a.b().l(), this.a.b().g("Host"), TextUtils.isEmpty(eVar.f1984h), eVar.l != null);
                                this.a.e(eVar);
                                b2 = a.b();
                            }
                        } catch (SocketException e3) {
                            this.a.c().f1998c = -12;
                            eVar.f1984h = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                            BdLog.e(e3.getMessage());
                            this.a.e(eVar);
                            if (this.f1973d <= 0 && (bVar2 = this.f1971b) != null) {
                                this.f1973d = bVar2.i();
                            }
                            eVar.f1982f = System.currentTimeMillis() - currentTimeMillis;
                            c.a.d.f.e.a.c().g(this.a.b().l(), this.a.b().g("Host"), TextUtils.isEmpty(eVar.f1984h), eVar.l != null);
                            this.a.e(eVar);
                            b2 = a.b();
                        }
                    } catch (UnsupportedOperationException unused) {
                        this.a.c().f1998c = -14;
                        eVar.f1984h = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        this.a.e(eVar);
                        if (this.f1973d <= 0 && (bVar = this.f1971b) != null) {
                            this.f1973d = bVar.i();
                        }
                        eVar.f1982f = System.currentTimeMillis() - currentTimeMillis;
                        c.a.d.f.e.a.c().g(this.a.b().l(), this.a.b().g("Host"), TextUtils.isEmpty(eVar.f1984h), eVar.l != null);
                        this.a.e(eVar);
                        a b5 = a.b();
                        if (b5 != null) {
                            b5.c(this.a);
                        }
                        z = false;
                    }
                    if (this.a.c().f1997b != 200) {
                        eVar.f1984h = String.valueOf(this.a.c().f1997b) + "|retryCount:" + i5;
                        z = m(this.a.c().f1997b);
                        this.a.e(eVar);
                        if (this.f1973d <= 0 && (bVar5 = this.f1971b) != null) {
                            this.f1973d = bVar5.i();
                        }
                        eVar.f1982f = System.currentTimeMillis() - currentTimeMillis;
                        c.a.d.f.e.a.c().g(this.a.b().l(), this.a.b().g("Host"), TextUtils.isEmpty(eVar.f1984h), eVar.l != null);
                        this.a.e(eVar);
                        a b6 = a.b();
                        if (b6 != null) {
                            b6.c(this.a);
                        }
                        i5 = i6;
                    } else {
                        if (this.f1973d <= 0 && (bVar4 = this.f1971b) != null) {
                            this.f1973d = bVar4.i();
                        }
                        eVar.f1982f = System.currentTimeMillis() - currentTimeMillis;
                        c.a.d.f.e.a.c().g(this.a.b().l(), this.a.b().g("Host"), TextUtils.isEmpty(eVar.f1984h), eVar.l != null);
                        this.a.e(eVar);
                        a b7 = a.b();
                        if (b7 != null) {
                            b7.c(this.a);
                            return;
                        }
                        return;
                    }
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:107:0x02f5, code lost:
        if (r8.o() != false) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x037a, code lost:
        if (r8.o() != false) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x037c, code lost:
        r0.c(r16.a);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void p(int i2, int i3, int i4) {
        a b2;
        b bVar;
        b bVar2;
        b bVar3;
        b bVar4;
        b bVar5;
        b bVar6;
        b bVar7;
        b bVar8;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048591, this, i2, i3, i4) == null) {
            int b3 = i3 <= 0 ? c.a.d.c.j.b.d().b().b() : i3;
            int a = i2 <= 0 ? c.a.d.c.j.b.d().a() : i2;
            int b4 = i4 <= 0 ? c.a.d.c.j.b.d().c().b() : i4;
            long currentTimeMillis = System.currentTimeMillis();
            boolean z = true;
            int i5 = 0;
            for (boolean z2 = true; !this.a.c().a && z == z2 && i5 < a; z2 = true) {
                e eVar = new e();
                int i6 = i5 + 1;
                eVar.f1981e = i6;
                this.f1972c = i5;
                a(i5);
                try {
                    try {
                        try {
                            b bVar9 = new b(this.a);
                            this.f1971b = bVar9;
                            bVar9.r(i5);
                            this.f1971b.t(f1970f);
                            this.f1971b.p(b3, b4, eVar);
                        } catch (SocketTimeoutException e2) {
                            this.a.c().f1998c = -13;
                            eVar.f1984h = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                            BdLog.e(e2.getMessage());
                            this.a.e(eVar);
                            if (this.f1973d <= 0 && (bVar4 = this.f1971b) != null) {
                                this.f1973d = bVar4.i();
                            }
                            eVar.f1982f = System.currentTimeMillis() - currentTimeMillis;
                            c.a.d.f.e.a.c().g(this.a.b().l(), this.a.b().g("Host"), TextUtils.isEmpty(eVar.f1984h), eVar.l != null);
                            this.a.e(eVar);
                            b2 = a.b();
                            if (b2 != null) {
                                b bVar10 = this.f1971b;
                                if (bVar10 != null) {
                                }
                            }
                            z = true;
                            i5 = i6;
                        }
                    } catch (UnsupportedOperationException unused) {
                        this.a.c().f1998c = -14;
                        eVar.f1984h = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        this.a.e(eVar);
                        if (this.f1973d <= 0 && (bVar3 = this.f1971b) != null) {
                            this.f1973d = bVar3.i();
                        }
                        eVar.f1982f = System.currentTimeMillis() - currentTimeMillis;
                        c.a.d.f.e.a.c().g(this.a.b().l(), this.a.b().g("Host"), TextUtils.isEmpty(eVar.f1984h), eVar.l != null);
                        this.a.e(eVar);
                        a b5 = a.b();
                        if (b5 != null && (bVar2 = this.f1971b) != null && bVar2.o()) {
                            b5.c(this.a);
                        }
                        z = false;
                    } catch (SocketException e3) {
                        this.a.c().f1998c = -12;
                        eVar.f1984h = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e3.getMessage());
                        this.a.e(eVar);
                        if (this.f1973d <= 0 && (bVar = this.f1971b) != null) {
                            this.f1973d = bVar.i();
                        }
                        eVar.f1982f = System.currentTimeMillis() - currentTimeMillis;
                        c.a.d.f.e.a.c().g(this.a.b().l(), this.a.b().g("Host"), TextUtils.isEmpty(eVar.f1984h), eVar.l != null);
                        this.a.e(eVar);
                        b2 = a.b();
                        if (b2 != null) {
                            b bVar11 = this.f1971b;
                            if (bVar11 != null) {
                            }
                        }
                        z = true;
                        i5 = i6;
                    }
                    if (this.a.c().f1997b != 200) {
                        eVar.f1984h = String.valueOf(this.a.c().f1997b) + "|retryCount:" + i5;
                        z = m(this.a.c().f1997b);
                        this.a.e(eVar);
                        if (this.f1973d <= 0 && (bVar8 = this.f1971b) != null) {
                            this.f1973d = bVar8.i();
                        }
                        eVar.f1982f = System.currentTimeMillis() - currentTimeMillis;
                        c.a.d.f.e.a.c().g(this.a.b().l(), this.a.b().g("Host"), TextUtils.isEmpty(eVar.f1984h), eVar.l != null);
                        this.a.e(eVar);
                        a b6 = a.b();
                        if (b6 != null && (bVar7 = this.f1971b) != null && bVar7.o()) {
                            b6.c(this.a);
                        }
                        i5 = i6;
                    } else {
                        if (this.f1973d <= 0 && (bVar6 = this.f1971b) != null) {
                            this.f1973d = bVar6.i();
                        }
                        eVar.f1982f = System.currentTimeMillis() - currentTimeMillis;
                        c.a.d.f.e.a.c().g(this.a.b().l(), this.a.b().g("Host"), TextUtils.isEmpty(eVar.f1984h), eVar.l != null);
                        this.a.e(eVar);
                        a b7 = a.b();
                        if (b7 == null || (bVar5 = this.f1971b) == null || !bVar5.o()) {
                            return;
                        }
                        b7.c(this.a);
                        return;
                    }
                }
            }
        }
    }

    public void q() {
        f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (fVar = this.a) == null) {
            return;
        }
        fVar.c().a = true;
    }
}
