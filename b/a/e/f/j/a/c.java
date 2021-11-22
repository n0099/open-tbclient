package b.a.e.f.j.a;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import b.a.e.f.p.j;
import b.a.e.f.p.k;
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
    public static boolean f1782f = true;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public e f1783a;

    /* renamed from: b  reason: collision with root package name */
    public b f1784b;

    /* renamed from: c  reason: collision with root package name */
    public int f1785c;

    /* renamed from: d  reason: collision with root package name */
    public long f1786d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f1787e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1718550107, "Lb/a/e/f/j/a/c;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1718550107, "Lb/a/e/f/j/a/c;");
        }
    }

    public c(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f1785c = 0;
        this.f1786d = 0L;
        this.f1787e = true;
        this.f1783a = eVar;
    }

    public final void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            try {
                if (this.f1783a == null || i2 <= 0) {
                    return;
                }
                this.f1783a.b().a("Retry-Count", String.valueOf(i2));
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    public void b() {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (bVar = this.f1784b) == null) {
            return;
        }
        bVar.b();
    }

    /* JADX WARN: Code restructure failed: missing block: B:114:0x03cc, code lost:
        if (r0 == null) goto L137;
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x04cf, code lost:
        if (r0 == null) goto L137;
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x04d1, code lost:
        r0.c(r23.f1783a);
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x04d6, code lost:
        r10 = r27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0252, code lost:
        if (r0 == null) goto L137;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x030f, code lost:
        if (r0 == null) goto L137;
     */
    /* JADX WARN: Removed duplicated region for block: B:219:0x08be  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x08c0  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x0909  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean c(String str, h hVar, int i2, int i3, int i4, int i5, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        d dVar;
        int i6;
        int i7;
        String str2;
        int i8;
        d dVar2;
        d dVar3;
        d dVar4;
        d dVar5;
        String str3;
        d dVar6;
        d dVar7;
        d dVar8;
        d dVar9;
        a b2;
        a b3;
        a b4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, hVar, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            String str4 = "responseCode:";
            int b5 = i4 <= 0 ? b.a.e.c.j.b.d().b().b() : i4;
            int b6 = i5 <= 0 ? b.a.e.c.j.b.d().c().b() : i5;
            b bVar = new b(this.f1783a);
            this.f1784b = bVar;
            bVar.u(f1782f);
            int i9 = 0;
            boolean z3 = false;
            for (int a2 = i2 <= 0 ? b.a.e.c.j.b.d().a() : i2; i9 < a2; a2 = i7) {
                d dVar10 = new d();
                this.f1783a.c().f1810c = -1;
                this.f1784b.s(i9);
                int i10 = i9 + 1;
                try {
                    try {
                        dVar10.f1792e = i10;
                        try {
                            this.f1785c = i9;
                            a(i9);
                            str2 = str4;
                            i8 = i10;
                            i6 = i9;
                            i7 = a2;
                        } catch (IllegalStateException e2) {
                            e = e2;
                            str2 = str4;
                            i8 = i10;
                            dVar9 = dVar10;
                            i6 = i9;
                            i7 = a2;
                        } catch (ConnectException e3) {
                            e = e3;
                            str2 = str4;
                            i8 = i10;
                            dVar8 = dVar10;
                            i6 = i9;
                            i7 = a2;
                        } catch (SocketException e4) {
                            e = e4;
                            str2 = str4;
                            i8 = i10;
                            dVar7 = dVar10;
                            i6 = i9;
                            i7 = a2;
                        } catch (SocketTimeoutException e5) {
                            e = e5;
                            str2 = str4;
                            i8 = i10;
                            dVar6 = dVar10;
                            i6 = i9;
                            i7 = a2;
                        }
                    } catch (IllegalStateException e6) {
                        e = e6;
                        str3 = str4;
                        i8 = i10;
                        dVar9 = dVar10;
                        i6 = i9;
                        i7 = a2;
                    } catch (ConnectException e7) {
                        e = e7;
                        str3 = str4;
                        i8 = i10;
                        dVar8 = dVar10;
                        i6 = i9;
                        i7 = a2;
                    } catch (SocketException e8) {
                        e = e8;
                        str3 = str4;
                        i8 = i10;
                        dVar7 = dVar10;
                        i6 = i9;
                        i7 = a2;
                    } catch (SocketTimeoutException e9) {
                        e = e9;
                        str3 = str4;
                        i8 = i10;
                        dVar6 = dVar10;
                        i6 = i9;
                        i7 = a2;
                    }
                } catch (FileNotFoundException e10) {
                    e = e10;
                    str2 = str4;
                    i8 = i10;
                    dVar5 = dVar10;
                    i6 = i9;
                    i7 = a2;
                } catch (UnknownHostException e11) {
                    e = e11;
                    str2 = str4;
                    i8 = i10;
                    dVar4 = dVar10;
                    i6 = i9;
                    i7 = a2;
                } catch (SSLException e12) {
                    e = e12;
                    str2 = str4;
                    i8 = i10;
                    dVar3 = dVar10;
                    i6 = i9;
                    i7 = a2;
                } catch (IOException e13) {
                    e = e13;
                    str2 = str4;
                    i8 = i10;
                    dVar2 = dVar10;
                    i6 = i9;
                    i7 = a2;
                } catch (Exception e14) {
                    e = e14;
                    str2 = str4;
                    i8 = i10;
                    dVar = dVar10;
                    i6 = i9;
                    i7 = a2;
                } catch (Throwable th) {
                    th = th;
                    dVar = dVar10;
                    i6 = i9;
                    i7 = a2;
                }
                try {
                    z3 = this.f1784b.d(str, hVar, b5, b6, z, dVar10, z2);
                    if (!z3 && this.f1783a.c().f1808a) {
                        this.f1783a.c().f1810c = -14;
                    }
                    b.a.e.f.e.a.c().g(this.f1783a.b().i(), this.f1783a.b().g("Host"), TextUtils.isEmpty(dVar10.f1795h), dVar10.l != null);
                    if (!z3 && i6 == i7 - 1) {
                        dVar10.f1795h += "|" + b.a.e.f.j.a.j.d.c();
                        dVar10.f1795h += "|netAvailable:" + j.A();
                    }
                    this.f1783a.e(dVar10);
                    a b7 = a.b();
                    if (b7 != null) {
                        b7.c(this.f1783a);
                    }
                    return z3;
                } catch (FileNotFoundException e15) {
                    e = e15;
                    dVar5 = dVar10;
                    StringBuilder sb = new StringBuilder();
                    str3 = str2;
                    sb.append(str3);
                    sb.append(String.valueOf(this.f1783a.c().f1809b));
                    sb.append("|retryCount:");
                    sb.append(i6);
                    sb.append("|");
                    sb.append(e.getClass().getName());
                    sb.append("|");
                    sb.append(e.getMessage());
                    dVar5.f1795h = sb.toString();
                    this.f1783a.c().f1810c = -100;
                    b.a.e.f.e.a.c().g(this.f1783a.b().i(), this.f1783a.b().g("Host"), TextUtils.isEmpty(dVar5.f1795h), dVar5.l != null);
                    if (!z3 && i6 == i7 - 1) {
                        dVar5.f1795h += "|" + b.a.e.f.j.a.j.d.c();
                        dVar5.f1795h += "|netAvailable:" + j.A();
                    }
                    this.f1783a.e(dVar5);
                    b4 = a.b();
                    if (b4 == null) {
                        str4 = str3;
                        i9 = i8;
                    }
                    b4.c(this.f1783a);
                    str4 = str3;
                    i9 = i8;
                } catch (IllegalStateException e16) {
                    e = e16;
                    dVar9 = dVar10;
                    str3 = str2;
                    dVar9.f1795h = str3 + String.valueOf(this.f1783a.c().f1809b) + "|retryCount:" + i6 + "|" + e.getClass().getName() + "|" + e.getMessage() + "|getcontent_illegal_error";
                    this.f1783a.c().f1810c = -19;
                    b.a.e.f.e.a.c().g(this.f1783a.b().i(), this.f1783a.b().g("Host"), TextUtils.isEmpty(dVar9.f1795h), dVar9.l != null);
                    if (!z3 && i6 == i7 - 1) {
                        dVar9.f1795h += "|" + b.a.e.f.j.a.j.d.c();
                        dVar9.f1795h += "|netAvailable:" + j.A();
                    }
                    this.f1783a.e(dVar9);
                    b4 = a.b();
                    if (b4 == null) {
                        str4 = str3;
                        i9 = i8;
                    }
                    b4.c(this.f1783a);
                    str4 = str3;
                    i9 = i8;
                } catch (ConnectException e17) {
                    e = e17;
                    dVar8 = dVar10;
                    str3 = str2;
                    dVar8.f1795h = str3 + String.valueOf(this.f1783a.c().f1809b) + "|retryCount:" + i6 + "|" + e.getClass().getName() + "|" + e.getMessage();
                    this.f1783a.c().f1810c = -22;
                    b.a.e.f.e.a.c().g(this.f1783a.b().i(), this.f1783a.b().g("Host"), TextUtils.isEmpty(dVar8.f1795h), dVar8.l != null);
                    if (!z3 && i6 == i7 - 1) {
                        dVar8.f1795h += "|" + b.a.e.f.j.a.j.d.c();
                        dVar8.f1795h += "|netAvailable:" + j.A();
                    }
                    this.f1783a.e(dVar8);
                    b4 = a.b();
                    if (b4 == null) {
                        str4 = str3;
                        i9 = i8;
                    }
                    b4.c(this.f1783a);
                    str4 = str3;
                    i9 = i8;
                } catch (SocketException e18) {
                    e = e18;
                    dVar7 = dVar10;
                    str3 = str2;
                    dVar7.f1795h = str3 + String.valueOf(this.f1783a.c().f1809b) + "|retryCount:" + i6 + "|" + e.getClass().getName() + "|" + e.getMessage();
                    this.f1783a.c().f1810c = -12;
                    b.a.e.f.e.a.c().g(this.f1783a.b().i(), this.f1783a.b().g("Host"), TextUtils.isEmpty(dVar7.f1795h), dVar7.l != null);
                    if (!z3 && i6 == i7 - 1) {
                        dVar7.f1795h += "|" + b.a.e.f.j.a.j.d.c();
                        dVar7.f1795h += "|netAvailable:" + j.A();
                    }
                    this.f1783a.e(dVar7);
                    b4 = a.b();
                    if (b4 == null) {
                        str4 = str3;
                        i9 = i8;
                    }
                    b4.c(this.f1783a);
                    str4 = str3;
                    i9 = i8;
                } catch (SocketTimeoutException e19) {
                    e = e19;
                    dVar6 = dVar10;
                    str3 = str2;
                    dVar6.f1795h = str3 + String.valueOf(this.f1783a.c().f1809b) + "|retryCount:" + i6 + "|" + e.getClass().getName() + "|" + e.getMessage();
                    this.f1783a.c().f1810c = -13;
                    b.a.e.f.e.a.c().g(this.f1783a.b().i(), this.f1783a.b().g("Host"), TextUtils.isEmpty(dVar6.f1795h), dVar6.l != null);
                    if (!z3 && i6 == i7 - 1) {
                        dVar6.f1795h += "|" + b.a.e.f.j.a.j.d.c();
                        dVar6.f1795h += "|netAvailable:" + j.A();
                    }
                    this.f1783a.e(dVar6);
                    b4 = a.b();
                    if (b4 == null) {
                        str4 = str3;
                        i9 = i8;
                    }
                    b4.c(this.f1783a);
                    str4 = str3;
                    i9 = i8;
                } catch (UnknownHostException e20) {
                    e = e20;
                    dVar4 = dVar10;
                    dVar4.f1795h = "errorCode:" + String.valueOf(this.f1783a.c().f1809b) + "|retryCount:" + i6 + "|" + e.getClass().getName() + "|" + e.getMessage();
                    this.f1783a.c().f1810c = -21;
                    b.a.e.f.e.a.c().g(this.f1783a.b().i(), this.f1783a.b().g("Host"), TextUtils.isEmpty(dVar4.f1795h), dVar4.l != null);
                    if (!z3 && i6 == i7 - 1) {
                        dVar4.f1795h += "|" + b.a.e.f.j.a.j.d.c();
                        dVar4.f1795h += "|netAvailable:" + j.A();
                    }
                    this.f1783a.e(dVar4);
                    b3 = a.b();
                } catch (SSLException e21) {
                    e = e21;
                    dVar3 = dVar10;
                    if (this.f1783a.b().e() && i6 < i7 - 1) {
                        String b8 = b.a.e.f.j.a.j.d.b(this.f1783a.b().i());
                        if (!k.isEmpty(b8)) {
                            this.f1783a.b().s(b8);
                        }
                        BdStatisticsManager.getInstance().eventStat(null, "c13429", "", 1, "obj_type", "1");
                    } else {
                        dVar3.f1795h = "errorCode:" + String.valueOf(this.f1783a.c().f1809b) + "|retryCount:" + i6 + "|" + e.getClass().getName() + "|" + e.getMessage();
                        this.f1783a.c().f1810c = -20;
                    }
                    b.a.e.f.e.a.c().g(this.f1783a.b().i(), this.f1783a.b().g("Host"), TextUtils.isEmpty(dVar3.f1795h), dVar3.l != null);
                    if (!z3 && i6 == i7 - 1) {
                        dVar3.f1795h += "|" + b.a.e.f.j.a.j.d.c();
                        dVar3.f1795h += "|netAvailable:" + j.A();
                    }
                    this.f1783a.e(dVar3);
                    b3 = a.b();
                } catch (IOException e22) {
                    e = e22;
                    dVar2 = dVar10;
                    dVar2.f1795h = "errorCode:" + String.valueOf(this.f1783a.c().f1809b) + "|retryCount:" + i6 + "|" + e.getClass().getName() + "|" + e.getMessage();
                    this.f1783a.c().f1810c = -19;
                    b.a.e.f.e.a.c().g(this.f1783a.b().i(), this.f1783a.b().g("Host"), TextUtils.isEmpty(dVar2.f1795h), dVar2.l != null);
                    if (!z3 && i6 == i7 - 1) {
                        dVar2.f1795h += "|" + b.a.e.f.j.a.j.d.c();
                        dVar2.f1795h += "|netAvailable:" + j.A();
                    }
                    this.f1783a.e(dVar2);
                    b3 = a.b();
                } catch (Exception e23) {
                    e = e23;
                    dVar = dVar10;
                    try {
                        dVar.f1795h = "errorCode:" + String.valueOf(this.f1783a.c().f1809b) + "|retryCount:" + i6 + "|" + e.getClass().getName() + "|" + e.getMessage();
                        this.f1783a.c().f1810c = -10;
                        BdLog.e(e.getMessage());
                        b.a.e.f.e.a.c().g(this.f1783a.b().i(), this.f1783a.b().g("Host"), TextUtils.isEmpty(dVar.f1795h), dVar.l != null);
                        if (!z3 && i6 == i7 - 1) {
                            dVar.f1795h += "|" + b.a.e.f.j.a.j.d.c();
                            dVar.f1795h += "|netAvailable:" + j.A();
                        }
                        this.f1783a.e(dVar);
                        b3 = a.b();
                    } catch (Throwable th2) {
                        th = th2;
                        b.a.e.f.e.a.c().g(this.f1783a.b().i(), this.f1783a.b().g("Host"), TextUtils.isEmpty(dVar.f1795h), dVar.l == null);
                        if (!z3 && i6 == i7 - 1) {
                            dVar.f1795h += "|" + b.a.e.f.j.a.j.d.c();
                            dVar.f1795h += "|netAvailable:" + j.A();
                        }
                        this.f1783a.e(dVar);
                        b2 = a.b();
                        if (b2 != null) {
                            b2.c(this.f1783a);
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    dVar = dVar10;
                    b.a.e.f.e.a.c().g(this.f1783a.b().i(), this.f1783a.b().g("Host"), TextUtils.isEmpty(dVar.f1795h), dVar.l == null);
                    if (!z3) {
                        dVar.f1795h += "|" + b.a.e.f.j.a.j.d.c();
                        dVar.f1795h += "|netAvailable:" + j.A();
                    }
                    this.f1783a.e(dVar);
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

    public boolean d(String str, h hVar, int i2, int i3, int i4, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{str, hVar, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z)})) == null) ? c(str, hVar, i2, -1, i3, i4, false, z) : invokeCommon.booleanValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:107:0x03a9, code lost:
        if (r0 == null) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x03ab, code lost:
        r0.c(r19.f1783a);
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x03b0, code lost:
        r12 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x031a, code lost:
        if (r0 == null) goto L81;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void e(int i2, int i3, int i4) {
        int i5;
        b bVar;
        a b2;
        b bVar2;
        a b3;
        b bVar3;
        b bVar4;
        b bVar5;
        b bVar6;
        b bVar7;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048580, this, i2, i3, i4) == null) {
            int b4 = i3 <= 0 ? b.a.e.c.j.b.d().b().b() : i3;
            int a2 = i2 <= 0 ? b.a.e.c.j.b.d().a() : i2;
            int b5 = i4 <= 0 ? b.a.e.c.j.b.d().c().b() : i4;
            long currentTimeMillis = System.currentTimeMillis();
            int i6 = true;
            int i7 = 0;
            for (int i8 = 1; !this.f1783a.c().f1808a && i6 == i8 && i7 < a2; i8 = 1) {
                d dVar = new d();
                this.f1783a.e(dVar);
                try {
                    try {
                        try {
                            this.f1785c = i7;
                            dVar.f1792e = i7 + 1;
                            dVar.v = i8;
                            a(i7);
                            b bVar8 = new b(this.f1783a);
                            this.f1784b = bVar8;
                            bVar8.s(i7);
                            this.f1784b.u(f1782f);
                            this.f1784b.k(b4, b5, dVar);
                        } catch (SocketTimeoutException e2) {
                            i5 = b4;
                            dVar.f1795h = String.valueOf(this.f1783a.c().f1809b) + "|retryCount:" + i7 + "|" + e2.getClass() + "|" + e2.getMessage();
                            this.f1783a.c().f1810c = -13;
                            if (this.f1786d <= 0 && (bVar4 = this.f1784b) != null) {
                                this.f1786d = bVar4.i();
                            }
                            dVar.f1793f = System.currentTimeMillis() - currentTimeMillis;
                            b.a.e.f.e.a.c().g(this.f1783a.b().i(), this.f1783a.b().g("Host"), TextUtils.isEmpty(dVar.f1795h), dVar.l != null);
                            this.f1783a.f(dVar);
                            b2 = a.b();
                        } catch (Exception e3) {
                            dVar.f1795h = String.valueOf(this.f1783a.c().f1809b) + "|retryCount:" + i7 + "|" + e3.getClass() + "|" + e3.getMessage();
                            this.f1783a.c().f1810c = -10;
                            BdLog.e(e3.getMessage());
                            if (this.f1786d <= 0 && (bVar3 = this.f1784b) != null) {
                                this.f1786d = bVar3.i();
                            }
                            dVar.f1793f = System.currentTimeMillis() - currentTimeMillis;
                            b.a.e.f.e.a.c().g(this.f1783a.b().i(), this.f1783a.b().g("Host"), TextUtils.isEmpty(dVar.f1795h), dVar.l != null);
                            this.f1783a.f(dVar);
                            b3 = a.b();
                            if (b3 == null) {
                                return;
                            }
                        }
                    } catch (SocketException e4) {
                        i5 = b4;
                        dVar.f1795h = String.valueOf(this.f1783a.c().f1809b) + "|retryCount:" + i7 + "|" + e4.getClass() + "|" + e4.getMessage();
                        this.f1783a.c().f1810c = -12;
                        if (this.f1786d <= 0 && (bVar2 = this.f1784b) != null) {
                            this.f1786d = bVar2.i();
                        }
                        dVar.f1793f = System.currentTimeMillis() - currentTimeMillis;
                        b.a.e.f.e.a.c().g(this.f1783a.b().i(), this.f1783a.b().g("Host"), TextUtils.isEmpty(dVar.f1795h), dVar.l != null);
                        this.f1783a.f(dVar);
                        b2 = a.b();
                    } catch (IOException e5) {
                        this.f1783a.c().f1810c = -19;
                        dVar.f1795h = "errorCode:" + String.valueOf(-19) + "|" + e5.getClass() + "|" + e5.getMessage() + "|getcontent_illegal_error";
                        if (this.f1786d <= 0 && (bVar = this.f1784b) != null) {
                            this.f1786d = bVar.i();
                        }
                        dVar.f1793f = System.currentTimeMillis() - currentTimeMillis;
                        i5 = b4;
                        b.a.e.f.e.a.c().g(this.f1783a.b().i(), this.f1783a.b().g("Host"), TextUtils.isEmpty(dVar.f1795h), dVar.l != null);
                        this.f1783a.f(dVar);
                        a b6 = a.b();
                        if (b6 != null) {
                            b6.c(this.f1783a);
                        }
                    }
                    if (this.f1783a.c().f1809b != 200) {
                        dVar.f1795h = String.valueOf(this.f1783a.c().f1809b) + "|retryCount:" + i7;
                        boolean m = m(this.f1783a.c().f1809b);
                        if (this.f1786d <= 0 && (bVar7 = this.f1784b) != null) {
                            this.f1786d = bVar7.i();
                        }
                        dVar.f1793f = System.currentTimeMillis() - currentTimeMillis;
                        b.a.e.f.e.a.c().g(this.f1783a.b().i(), this.f1783a.b().g("Host"), TextUtils.isEmpty(dVar.f1795h), dVar.l != null);
                        this.f1783a.f(dVar);
                        a b7 = a.b();
                        if (b7 != null) {
                            b7.c(this.f1783a);
                        }
                        i6 = m;
                        i5 = b4;
                        i7++;
                        b4 = i5;
                    } else {
                        this.f1783a.f(dVar);
                        if (this.f1786d <= 0 && (bVar6 = this.f1784b) != null) {
                            this.f1786d = bVar6.i();
                        }
                        dVar.f1793f = System.currentTimeMillis() - currentTimeMillis;
                        b.a.e.f.e.a.c().g(this.f1783a.b().i(), this.f1783a.b().g("Host"), TextUtils.isEmpty(dVar.f1795h), dVar.l != null);
                        this.f1783a.f(dVar);
                        b3 = a.b();
                        if (b3 == null) {
                            return;
                        }
                        b3.c(this.f1783a);
                        return;
                    }
                } catch (Throwable th) {
                    if (this.f1786d <= 0 && (bVar5 = this.f1784b) != null) {
                        this.f1786d = bVar5.i();
                    }
                    dVar.f1793f = System.currentTimeMillis() - currentTimeMillis;
                    b.a.e.f.e.a.c().g(this.f1783a.b().i(), this.f1783a.b().g("Host"), TextUtils.isEmpty(dVar.f1795h), dVar.l != null);
                    this.f1783a.f(dVar);
                    a b8 = a.b();
                    if (b8 != null) {
                        b8.c(this.f1783a);
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
            b bVar = this.f1784b;
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
            b bVar = this.f1784b;
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
            long j = this.f1786d;
            if (j > 0) {
                return j;
            }
            b bVar = this.f1784b;
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
            b bVar = this.f1784b;
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
            b bVar = this.f1784b;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f1785c : invokeV.intValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            e eVar = this.f1783a;
            if (eVar == null) {
                return false;
            }
            return eVar.c().f1808a;
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
            if (this.f1783a.b().j()) {
                p(i2, i3, i4);
            } else {
                o(i2, i3, i4);
            }
        }
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 0, expect 1 */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x0345, code lost:
        if (r0 == null) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x0347, code lost:
        r0.c(r16.f1783a);
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x034c, code lost:
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x01d7, code lost:
        if (r0 == null) goto L94;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0249, code lost:
        if (r0 == null) goto L94;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x024b, code lost:
        r0.c(r16.f1783a);
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0250, code lost:
        r0 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x02ca, code lost:
        if (r0 == null) goto L65;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void o(int i2, int i3, int i4) {
        a b2;
        b bVar;
        a b3;
        b bVar2;
        b bVar3;
        b bVar4;
        b bVar5;
        b bVar6;
        b bVar7;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048590, this, i2, i3, i4) == null) {
            int b4 = i3 <= 0 ? b.a.e.c.j.b.d().b().b() : i3;
            int a2 = i2 <= 0 ? b.a.e.c.j.b.d().a() : i2;
            int b5 = i4 <= 0 ? b.a.e.c.j.b.d().c().b() : i4;
            long currentTimeMillis = System.currentTimeMillis();
            boolean z = true;
            int i5 = 0;
            for (boolean z2 = true; !this.f1783a.c().f1808a && z == z2 && i5 < a2; z2 = true) {
                d dVar = new d();
                this.f1785c = i5;
                int i6 = i5 + 1;
                dVar.f1792e = i6;
                a(i5);
                try {
                    try {
                        try {
                            b bVar8 = new b(this.f1783a);
                            this.f1784b = bVar8;
                            bVar8.s(i5);
                            this.f1784b.u(f1782f);
                            this.f1784b.t(this.f1787e);
                            this.f1784b.r(b4, b5, dVar);
                        } catch (SocketException e2) {
                            this.f1783a.c().f1810c = -12;
                            dVar.f1795h = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                            BdLog.e(e2.getMessage());
                            this.f1783a.e(dVar);
                            if (this.f1786d <= 0 && (bVar5 = this.f1784b) != null) {
                                this.f1786d = bVar5.i();
                            }
                            dVar.f1793f = System.currentTimeMillis() - currentTimeMillis;
                            b.a.e.f.e.a.c().g(this.f1783a.b().i(), this.f1783a.b().g("Host"), TextUtils.isEmpty(dVar.f1795h), dVar.l != null);
                            this.f1783a.e(dVar);
                            b3 = a.b();
                        }
                    } catch (UnsupportedOperationException unused) {
                        this.f1783a.c().f1810c = -14;
                        dVar.f1795h = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        this.f1783a.e(dVar);
                        if (this.f1786d <= 0 && (bVar3 = this.f1784b) != null) {
                            this.f1786d = bVar3.i();
                        }
                        dVar.f1793f = System.currentTimeMillis() - currentTimeMillis;
                        b.a.e.f.e.a.c().g(this.f1783a.b().i(), this.f1783a.b().g("Host"), TextUtils.isEmpty(dVar.f1795h), dVar.l != null);
                        this.f1783a.e(dVar);
                        b2 = a.b();
                    }
                } catch (SocketTimeoutException e3) {
                    this.f1783a.c().f1810c = -13;
                    dVar.f1795h = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.f1783a.e(dVar);
                    if (this.f1786d <= 0 && (bVar2 = this.f1784b) != null) {
                        this.f1786d = bVar2.i();
                    }
                    dVar.f1793f = System.currentTimeMillis() - currentTimeMillis;
                    b.a.e.f.e.a.c().g(this.f1783a.b().i(), this.f1783a.b().g("Host"), TextUtils.isEmpty(dVar.f1795h), dVar.l != null);
                    this.f1783a.e(dVar);
                    b3 = a.b();
                } catch (Throwable th) {
                    try {
                        this.f1783a.c().f1810c = -10;
                        dVar.f1795h = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(th.getMessage());
                        this.f1783a.e(dVar);
                        if (this.f1786d <= 0 && (bVar = this.f1784b) != null) {
                            this.f1786d = bVar.i();
                        }
                        dVar.f1793f = System.currentTimeMillis() - currentTimeMillis;
                        b.a.e.f.e.a.c().g(this.f1783a.b().i(), this.f1783a.b().g("Host"), TextUtils.isEmpty(dVar.f1795h), dVar.l != null);
                        this.f1783a.e(dVar);
                        b2 = a.b();
                    } catch (Throwable th2) {
                        if (this.f1786d <= 0 && (bVar4 = this.f1784b) != null) {
                            this.f1786d = bVar4.i();
                        }
                        dVar.f1793f = System.currentTimeMillis() - currentTimeMillis;
                        b.a.e.f.e.a.c().g(this.f1783a.b().i(), this.f1783a.b().g("Host"), TextUtils.isEmpty(dVar.f1795h), dVar.l != null);
                        this.f1783a.e(dVar);
                        a b6 = a.b();
                        if (b6 != null) {
                            b6.c(this.f1783a);
                        }
                        throw th2;
                    }
                }
                if (this.f1783a.c().f1809b != 200) {
                    dVar.f1795h = String.valueOf(this.f1783a.c().f1809b) + "|retryCount:" + i5;
                    z = m(this.f1783a.c().f1809b);
                    this.f1783a.e(dVar);
                    if (this.f1786d <= 0 && (bVar7 = this.f1784b) != null) {
                        this.f1786d = bVar7.i();
                    }
                    dVar.f1793f = System.currentTimeMillis() - currentTimeMillis;
                    b.a.e.f.e.a.c().g(this.f1783a.b().i(), this.f1783a.b().g("Host"), TextUtils.isEmpty(dVar.f1795h), dVar.l != null);
                    this.f1783a.e(dVar);
                    a b7 = a.b();
                    if (b7 != null) {
                        b7.c(this.f1783a);
                    }
                    i5 = i6;
                } else {
                    if (this.f1786d <= 0 && (bVar6 = this.f1784b) != null) {
                        this.f1786d = bVar6.i();
                    }
                    dVar.f1793f = System.currentTimeMillis() - currentTimeMillis;
                    b.a.e.f.e.a.c().g(this.f1783a.b().i(), this.f1783a.b().g("Host"), TextUtils.isEmpty(dVar.f1795h), dVar.l != null);
                    this.f1783a.e(dVar);
                    a b8 = a.b();
                    if (b8 != null) {
                        b8.c(this.f1783a);
                        return;
                    }
                    return;
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:107:0x02f6, code lost:
        if (r8.p() != false) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x037b, code lost:
        if (r8.p() != false) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x037d, code lost:
        r0.c(r16.f1783a);
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
            int b3 = i3 <= 0 ? b.a.e.c.j.b.d().b().b() : i3;
            int a2 = i2 <= 0 ? b.a.e.c.j.b.d().a() : i2;
            int b4 = i4 <= 0 ? b.a.e.c.j.b.d().c().b() : i4;
            long currentTimeMillis = System.currentTimeMillis();
            boolean z = true;
            int i5 = 0;
            for (boolean z2 = true; !this.f1783a.c().f1808a && z == z2 && i5 < a2; z2 = true) {
                d dVar = new d();
                int i6 = i5 + 1;
                dVar.f1792e = i6;
                this.f1785c = i5;
                a(i5);
                try {
                    try {
                        try {
                            b bVar9 = new b(this.f1783a);
                            this.f1784b = bVar9;
                            bVar9.s(i5);
                            this.f1784b.u(f1782f);
                            this.f1784b.q(b3, b4, dVar);
                        } catch (SocketTimeoutException e2) {
                            this.f1783a.c().f1810c = -13;
                            dVar.f1795h = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                            BdLog.e(e2.getMessage());
                            this.f1783a.e(dVar);
                            if (this.f1786d <= 0 && (bVar4 = this.f1784b) != null) {
                                this.f1786d = bVar4.i();
                            }
                            dVar.f1793f = System.currentTimeMillis() - currentTimeMillis;
                            b.a.e.f.e.a.c().g(this.f1783a.b().i(), this.f1783a.b().g("Host"), TextUtils.isEmpty(dVar.f1795h), dVar.l != null);
                            this.f1783a.e(dVar);
                            b2 = a.b();
                            if (b2 != null) {
                                b bVar10 = this.f1784b;
                                if (bVar10 != null) {
                                }
                            }
                            z = true;
                            i5 = i6;
                        }
                    } catch (UnsupportedOperationException unused) {
                        this.f1783a.c().f1810c = -14;
                        dVar.f1795h = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        this.f1783a.e(dVar);
                        if (this.f1786d <= 0 && (bVar3 = this.f1784b) != null) {
                            this.f1786d = bVar3.i();
                        }
                        dVar.f1793f = System.currentTimeMillis() - currentTimeMillis;
                        b.a.e.f.e.a.c().g(this.f1783a.b().i(), this.f1783a.b().g("Host"), TextUtils.isEmpty(dVar.f1795h), dVar.l != null);
                        this.f1783a.e(dVar);
                        a b5 = a.b();
                        if (b5 != null && (bVar2 = this.f1784b) != null && bVar2.p()) {
                            b5.c(this.f1783a);
                        }
                        z = false;
                    } catch (SocketException e3) {
                        this.f1783a.c().f1810c = -12;
                        dVar.f1795h = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e3.getMessage());
                        this.f1783a.e(dVar);
                        if (this.f1786d <= 0 && (bVar = this.f1784b) != null) {
                            this.f1786d = bVar.i();
                        }
                        dVar.f1793f = System.currentTimeMillis() - currentTimeMillis;
                        b.a.e.f.e.a.c().g(this.f1783a.b().i(), this.f1783a.b().g("Host"), TextUtils.isEmpty(dVar.f1795h), dVar.l != null);
                        this.f1783a.e(dVar);
                        b2 = a.b();
                        if (b2 != null) {
                            b bVar11 = this.f1784b;
                            if (bVar11 != null) {
                            }
                        }
                        z = true;
                        i5 = i6;
                    }
                    if (this.f1783a.c().f1809b != 200) {
                        dVar.f1795h = String.valueOf(this.f1783a.c().f1809b) + "|retryCount:" + i5;
                        z = m(this.f1783a.c().f1809b);
                        this.f1783a.e(dVar);
                        if (this.f1786d <= 0 && (bVar8 = this.f1784b) != null) {
                            this.f1786d = bVar8.i();
                        }
                        dVar.f1793f = System.currentTimeMillis() - currentTimeMillis;
                        b.a.e.f.e.a.c().g(this.f1783a.b().i(), this.f1783a.b().g("Host"), TextUtils.isEmpty(dVar.f1795h), dVar.l != null);
                        this.f1783a.e(dVar);
                        a b6 = a.b();
                        if (b6 != null && (bVar7 = this.f1784b) != null && bVar7.p()) {
                            b6.c(this.f1783a);
                        }
                        i5 = i6;
                    } else {
                        if (this.f1786d <= 0 && (bVar6 = this.f1784b) != null) {
                            this.f1786d = bVar6.i();
                        }
                        dVar.f1793f = System.currentTimeMillis() - currentTimeMillis;
                        b.a.e.f.e.a.c().g(this.f1783a.b().i(), this.f1783a.b().g("Host"), TextUtils.isEmpty(dVar.f1795h), dVar.l != null);
                        this.f1783a.e(dVar);
                        a b7 = a.b();
                        if (b7 == null || (bVar5 = this.f1784b) == null || !bVar5.p()) {
                            return;
                        }
                        b7.c(this.f1783a);
                        return;
                    }
                }
            }
        }
    }

    public void q() {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (eVar = this.f1783a) == null) {
            return;
        }
        eVar.c().f1808a = true;
    }
}
