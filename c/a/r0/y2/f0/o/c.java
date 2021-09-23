package c.a.r0.y2.f0.o;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.R;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.FileNotFoundException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
/* loaded from: classes4.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public g f29446a;

    /* renamed from: b  reason: collision with root package name */
    public b f29447b;

    /* renamed from: c  reason: collision with root package name */
    public long f29448c;

    public c(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {gVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f29448c = 0L;
        this.f29446a = gVar;
    }

    public void a() {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (bVar = this.f29447b) == null) {
            return;
        }
        bVar.a();
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01f3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean b(String str, j jVar, int i2, int i3, int i4, int i5, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        e eVar;
        int i6;
        int i7;
        e eVar2;
        a b2;
        a b3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, jVar, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            int b4 = i4 <= 0 ? c.a.e.c.j.b.d().b().b() : i4;
            int a2 = i2 <= 0 ? c.a.e.c.j.b.d().a() : i2;
            int b5 = i5 <= 0 ? c.a.e.c.j.b.d().c().b() : i5;
            this.f29447b = new b(this.f29446a);
            int i8 = 0;
            while (i8 < a2) {
                e eVar3 = new e();
                int i9 = i8 + 1;
                try {
                    int i10 = b4;
                    i6 = b4;
                    i7 = i8;
                    try {
                        boolean c2 = this.f29447b.c(str, jVar, i10, b5, z, eVar3, z2);
                        c.a.e.e.e.a.c().g(this.f29446a.a().e(), this.f29446a.a().d("Host"), TextUtils.isEmpty(eVar3.f29462f), eVar3.f29465i != null);
                        this.f29446a.d(eVar3);
                        a b6 = a.b();
                        if (b6 != null) {
                            b6.c(this.f29446a);
                        }
                        return c2;
                    } catch (FileNotFoundException e2) {
                        e = e2;
                        eVar2 = eVar3;
                        this.f29446a.b().f29475b = -100;
                        eVar2.f29462f = String.valueOf(this.f29446a.b().f29475b) + "|retryCount:" + i7 + "|" + e.getClass() + "|" + e.getMessage();
                        this.f29446a.d(eVar2);
                        c.a.e.e.e.a.c().g(this.f29446a.a().e(), this.f29446a.a().d("Host"), TextUtils.isEmpty(eVar2.f29462f), eVar2.f29465i != null);
                        this.f29446a.d(eVar2);
                        b3 = a.b();
                        if (b3 == null) {
                            b4 = i6;
                            i8 = i9;
                        }
                        b3.c(this.f29446a);
                        b4 = i6;
                        i8 = i9;
                    } catch (Exception e3) {
                        e = e3;
                        eVar = eVar3;
                        try {
                            this.f29446a.b().f29475b = -10;
                            eVar.f29462f = String.valueOf(this.f29446a.b().f29475b) + "|retryCount:" + i7 + "|" + e.getClass() + "|" + e.getMessage();
                            this.f29446a.d(eVar);
                            c.a.e.e.e.a.c().g(this.f29446a.a().e(), this.f29446a.a().d("Host"), TextUtils.isEmpty(eVar.f29462f), eVar.f29465i != null);
                            this.f29446a.d(eVar);
                            b3 = a.b();
                            if (b3 == null) {
                                b4 = i6;
                                i8 = i9;
                            }
                            b3.c(this.f29446a);
                            b4 = i6;
                            i8 = i9;
                        } catch (Throwable th) {
                            th = th;
                            c.a.e.e.e.a.c().g(this.f29446a.a().e(), this.f29446a.a().d("Host"), TextUtils.isEmpty(eVar.f29462f), eVar.f29465i == null);
                            this.f29446a.d(eVar);
                            b2 = a.b();
                            if (b2 != null) {
                                b2.c(this.f29446a);
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        eVar = eVar3;
                        c.a.e.e.e.a.c().g(this.f29446a.a().e(), this.f29446a.a().d("Host"), TextUtils.isEmpty(eVar.f29462f), eVar.f29465i == null);
                        this.f29446a.d(eVar);
                        b2 = a.b();
                        if (b2 != null) {
                        }
                        throw th;
                    }
                } catch (FileNotFoundException e4) {
                    e = e4;
                    eVar2 = eVar3;
                    i6 = b4;
                    i7 = i8;
                } catch (Exception e5) {
                    e = e5;
                    eVar = eVar3;
                    i6 = b4;
                    i7 = i8;
                } catch (Throwable th3) {
                    th = th3;
                    eVar = eVar3;
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:102:0x035c, code lost:
        if (r0 == null) goto L95;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x035e, code lost:
        r0.c(r16.f29446a);
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x0363, code lost:
        r10 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x02d5, code lost:
        if (r0 == null) goto L95;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void c(int i2, int i3, int i4) {
        a b2;
        b bVar;
        a b3;
        b bVar2;
        b bVar3;
        a b4;
        b bVar4;
        b bVar5;
        b bVar6;
        b bVar7;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(Constants.METHOD_SEND_USER_MSG, this, i2, i3, i4) == null) {
            int b5 = i3 <= 0 ? c.a.e.c.j.b.d().b().b() : i3;
            int a2 = i2 <= 0 ? c.a.e.c.j.b.d().a() : i2;
            int b6 = i4 <= 0 ? c.a.e.c.j.b.d().c().b() : i4;
            System.currentTimeMillis();
            boolean z = true;
            int i5 = 0;
            for (boolean z2 = true; !this.f29446a.b().f29474a && z == z2 && i5 < a2; z2 = true) {
                e eVar = new e();
                this.f29446a.d(eVar);
                try {
                    try {
                        try {
                            b bVar8 = new b(this.f29446a);
                            this.f29447b = bVar8;
                            bVar8.g(b5, b6, eVar);
                        } catch (IllegalStateException e2) {
                            this.f29446a.b().f29476c = -19;
                            eVar.f29462f = "errorCode:" + String.valueOf(-19) + "|" + e2.getClass() + "|" + e2.getMessage() + "|getcontent_illegal_error";
                            if (this.f29448c <= 0 && (bVar4 = this.f29447b) != null) {
                                this.f29448c = bVar4.f();
                            }
                            System.currentTimeMillis();
                            c.a.e.e.e.a.c().g(this.f29446a.a().e(), this.f29446a.a().d("Host"), TextUtils.isEmpty(eVar.f29462f), eVar.f29465i != null);
                            this.f29446a.e(eVar);
                            b4 = a.b();
                            if (b4 == null) {
                            }
                        } catch (SocketException e3) {
                            eVar.f29462f = String.valueOf(this.f29446a.b().f29475b) + "|retryCount:" + i5 + "|" + e3.getClass() + "|" + e3.getMessage();
                            this.f29446a.b().f29476c = -12;
                            if (this.f29448c <= 0 && (bVar3 = this.f29447b) != null) {
                                this.f29448c = bVar3.f();
                            }
                            System.currentTimeMillis();
                            c.a.e.e.e.a.c().g(this.f29446a.a().e(), this.f29446a.a().d("Host"), TextUtils.isEmpty(eVar.f29462f), eVar.f29465i != null);
                            this.f29446a.e(eVar);
                            b3 = a.b();
                        }
                    } catch (SocketTimeoutException e4) {
                        eVar.f29462f = String.valueOf(this.f29446a.b().f29475b) + "|retryCount:" + i5 + "|" + e4.getClass() + "|" + e4.getMessage();
                        this.f29446a.b().f29476c = -13;
                        if (this.f29448c <= 0 && (bVar2 = this.f29447b) != null) {
                            this.f29448c = bVar2.f();
                        }
                        System.currentTimeMillis();
                        c.a.e.e.e.a.c().g(this.f29446a.a().e(), this.f29446a.a().d("Host"), TextUtils.isEmpty(eVar.f29462f), eVar.f29465i != null);
                        this.f29446a.e(eVar);
                        b3 = a.b();
                    } catch (Exception e5) {
                        eVar.f29462f = String.valueOf(this.f29446a.b().f29475b) + "|retryCount:" + i5 + "|" + e5.getClass() + "|" + e5.getMessage();
                        this.f29446a.b().f29476c = -10;
                        BdLog.e(e5.getMessage());
                        if (this.f29448c <= 0 && (bVar = this.f29447b) != null) {
                            this.f29448c = bVar.f();
                        }
                        System.currentTimeMillis();
                        c.a.e.e.e.a.c().g(this.f29446a.a().e(), this.f29446a.a().d("Host"), TextUtils.isEmpty(eVar.f29462f), eVar.f29465i != null);
                        this.f29446a.e(eVar);
                        b2 = a.b();
                        if (b2 == null) {
                            return;
                        }
                    }
                    if (this.f29446a.b().f29475b != 200) {
                        eVar.f29462f = String.valueOf(this.f29446a.b().f29475b) + "|retryCount:" + i5;
                        z = e(this.f29446a.b().f29475b);
                        if (this.f29448c <= 0 && (bVar7 = this.f29447b) != null) {
                            this.f29448c = bVar7.f();
                        }
                        System.currentTimeMillis();
                        c.a.e.e.e.a.c().g(this.f29446a.a().e(), this.f29446a.a().d("Host"), TextUtils.isEmpty(eVar.f29462f), eVar.f29465i != null);
                        this.f29446a.e(eVar);
                        b4 = a.b();
                        if (b4 == null) {
                            i5++;
                        }
                        b4.c(this.f29446a);
                        i5++;
                    } else {
                        this.f29446a.e(eVar);
                        if (this.f29448c <= 0 && (bVar6 = this.f29447b) != null) {
                            this.f29448c = bVar6.f();
                        }
                        System.currentTimeMillis();
                        c.a.e.e.e.a.c().g(this.f29446a.a().e(), this.f29446a.a().d("Host"), TextUtils.isEmpty(eVar.f29462f), eVar.f29465i != null);
                        this.f29446a.e(eVar);
                        b2 = a.b();
                        if (b2 == null) {
                            return;
                        }
                        b2.c(this.f29446a);
                        return;
                    }
                } catch (Throwable th) {
                    if (this.f29448c <= 0 && (bVar5 = this.f29447b) != null) {
                        this.f29448c = bVar5.f();
                    }
                    System.currentTimeMillis();
                    c.a.e.e.e.a.c().g(this.f29446a.a().e(), this.f29446a.a().d("Host"), TextUtils.isEmpty(eVar.f29462f), eVar.f29465i != null);
                    this.f29446a.e(eVar);
                    a b7 = a.b();
                    if (b7 != null) {
                        b7.c(this.f29446a);
                    }
                    throw th;
                }
            }
        }
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            g gVar = this.f29446a;
            if (gVar == null) {
                return false;
            }
            return gVar.b().f29474a;
        }
        return invokeV.booleanValue;
    }

    public final boolean e(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            if (i2 == 202 || i2 == 201 || i2 == 205 || i2 == 304 || i2 == 305 || i2 == 408) {
                return true;
            }
            return (i2 == 502 || i2 == 503 || i2 == 504 || i2 == 404) ? false : true;
        }
        return invokeI.booleanValue;
    }

    public void f(int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048581, this, i2, i3, i4) == null) {
            if (this.f29446a.a().f()) {
                h(i2, i3, i4);
            } else {
                g(i2, i3, i4);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x0309, code lost:
        r3 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x028c, code lost:
        if (r3 == null) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0302, code lost:
        if (r3 == null) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0304, code lost:
        r3.c(r11.f29446a);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void g(int i2, int i3, int i4) {
        a b2;
        b bVar;
        b bVar2;
        b bVar3;
        b bVar4;
        b bVar5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048582, this, i2, i3, i4) == null) {
            if (i3 <= 0) {
                i3 = c.a.e.c.j.b.d().b().b();
            }
            if (i2 <= 0) {
                i2 = c.a.e.c.j.b.d().a();
            }
            if (i4 <= 0) {
                i4 = c.a.e.c.j.b.d().c().b();
            }
            System.currentTimeMillis();
            boolean z = true;
            int i5 = 0;
            while (!this.f29446a.b().f29474a && z && i5 < i2) {
                e eVar = new e();
                int i6 = i5 + 1;
                try {
                    try {
                        try {
                            b bVar6 = new b(this.f29446a);
                            this.f29447b = bVar6;
                            bVar6.o(i3, i4, eVar);
                        } catch (SocketTimeoutException e2) {
                            this.f29446a.b().f29476c = -13;
                            eVar.f29462f = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                            BdLog.e(e2.getMessage());
                            this.f29446a.d(eVar);
                            if (this.f29448c <= 0 && (bVar3 = this.f29447b) != null) {
                                this.f29448c = bVar3.f();
                            }
                            System.currentTimeMillis();
                            c.a.e.e.e.a.c().g(this.f29446a.a().e(), this.f29446a.a().d("Host"), TextUtils.isEmpty(eVar.f29462f), eVar.f29465i != null);
                            this.f29446a.d(eVar);
                            b2 = a.b();
                        }
                    } catch (UnsupportedOperationException unused) {
                        this.f29446a.b().f29476c = -14;
                        eVar.f29462f = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        this.f29446a.d(eVar);
                        if (this.f29448c <= 0 && (bVar2 = this.f29447b) != null) {
                            this.f29448c = bVar2.f();
                        }
                        System.currentTimeMillis();
                        c.a.e.e.e.a.c().g(this.f29446a.a().e(), this.f29446a.a().d("Host"), TextUtils.isEmpty(eVar.f29462f), eVar.f29465i != null);
                        this.f29446a.d(eVar);
                        a b3 = a.b();
                        if (b3 != null) {
                            b3.c(this.f29446a);
                        }
                        z = false;
                    } catch (SocketException e3) {
                        this.f29446a.b().f29476c = -12;
                        eVar.f29462f = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e3.getMessage());
                        this.f29446a.d(eVar);
                        if (this.f29448c <= 0 && (bVar = this.f29447b) != null) {
                            this.f29448c = bVar.f();
                        }
                        System.currentTimeMillis();
                        c.a.e.e.e.a.c().g(this.f29446a.a().e(), this.f29446a.a().d("Host"), TextUtils.isEmpty(eVar.f29462f), eVar.f29465i != null);
                        this.f29446a.d(eVar);
                        b2 = a.b();
                    }
                    if (this.f29446a.b().f29475b != 200) {
                        eVar.f29462f = String.valueOf(this.f29446a.b().f29475b) + "|retryCount:" + i5;
                        boolean e4 = e(this.f29446a.b().f29475b);
                        this.f29446a.d(eVar);
                        if (this.f29448c <= 0 && (bVar5 = this.f29447b) != null) {
                            this.f29448c = bVar5.f();
                        }
                        System.currentTimeMillis();
                        c.a.e.e.e.a.c().g(this.f29446a.a().e(), this.f29446a.a().d("Host"), TextUtils.isEmpty(eVar.f29462f), eVar.f29465i != null);
                        this.f29446a.d(eVar);
                        a b4 = a.b();
                        if (b4 != null) {
                            b4.c(this.f29446a);
                        }
                        z = e4;
                        i5 = i6;
                    } else {
                        if (this.f29448c <= 0 && (bVar4 = this.f29447b) != null) {
                            this.f29448c = bVar4.f();
                        }
                        System.currentTimeMillis();
                        c.a.e.e.e.a.c().g(this.f29446a.a().e(), this.f29446a.a().d("Host"), TextUtils.isEmpty(eVar.f29462f), eVar.f29465i != null);
                        this.f29446a.d(eVar);
                        a b5 = a.b();
                        if (b5 != null) {
                            b5.c(this.f29446a);
                            return;
                        }
                        return;
                    }
                }
            }
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, CMP_L]}, finally: {[IGET, CMP_L, IGET, INVOKE, IF, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, IF, INVOKE, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, IGET, INVOKE, IPUT, IGET, INVOKE, IF, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, IF, INVOKE, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, IGET, IF, IGET, IGET, INVOKE, IF, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, IF, INVOKE, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, IGET, IF] complete} */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 0, expect 1 */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x02bf, code lost:
        if (r4.m() != false) goto L132;
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x0340, code lost:
        if (r4.m() != false) goto L132;
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x0342, code lost:
        r3.c(r11.f29446a);
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x01bf, code lost:
        if (r4.m() != false) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0238, code lost:
        if (r4.m() != false) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x023a, code lost:
        r3.c(r11.f29446a);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void h(int i2, int i3, int i4) {
        a b2;
        b bVar;
        b bVar2;
        b bVar3;
        b bVar4;
        a b3;
        b bVar5;
        b bVar6;
        b bVar7;
        b bVar8;
        b bVar9;
        b bVar10;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048583, this, i2, i3, i4) == null) {
            if (i3 <= 0) {
                i3 = c.a.e.c.j.b.d().b().b();
            }
            if (i2 <= 0) {
                i2 = c.a.e.c.j.b.d().a();
            }
            if (i4 <= 0) {
                i4 = c.a.e.c.j.b.d().c().b();
            }
            System.currentTimeMillis();
            boolean z = true;
            int i5 = 0;
            while (!this.f29446a.b().f29474a && z && i5 < i2) {
                e eVar = new e();
                int i6 = i5 + 1;
                try {
                    try {
                        b bVar11 = new b(this.f29446a);
                        this.f29447b = bVar11;
                        bVar11.n(i3, i4, eVar);
                    } catch (UnsupportedOperationException unused) {
                        this.f29446a.b().f29476c = -14;
                        eVar.f29462f = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        this.f29446a.d(eVar);
                        if (this.f29448c <= 0 && (bVar6 = this.f29447b) != null) {
                            this.f29448c = bVar6.f();
                        }
                        System.currentTimeMillis();
                        c.a.e.e.e.a.c().g(this.f29446a.a().e(), this.f29446a.a().d("Host"), TextUtils.isEmpty(eVar.f29462f), eVar.f29465i != null);
                        this.f29446a.d(eVar);
                        b3 = a.b();
                        if (b3 != null) {
                            b bVar12 = this.f29447b;
                            if (bVar12 != null) {
                            }
                        }
                        z = false;
                        i5 = i6;
                    } catch (Throwable th) {
                        try {
                            this.f29446a.b().f29476c = -10;
                            eVar.f29462f = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                            BdLog.e(th.getMessage());
                            this.f29446a.d(eVar);
                            if (this.f29448c <= 0 && (bVar5 = this.f29447b) != null) {
                                this.f29448c = bVar5.f();
                            }
                            System.currentTimeMillis();
                            c.a.e.e.e.a.c().g(this.f29446a.a().e(), this.f29446a.a().d("Host"), TextUtils.isEmpty(eVar.f29462f), eVar.f29465i != null);
                            this.f29446a.d(eVar);
                            b3 = a.b();
                            if (b3 != null) {
                                b bVar13 = this.f29447b;
                                if (bVar13 != null) {
                                }
                            }
                            z = false;
                            i5 = i6;
                        } catch (Throwable th2) {
                            if (this.f29448c <= 0 && (bVar4 = this.f29447b) != null) {
                                this.f29448c = bVar4.f();
                            }
                            System.currentTimeMillis();
                            c.a.e.e.e.a.c().g(this.f29446a.a().e(), this.f29446a.a().d("Host"), TextUtils.isEmpty(eVar.f29462f), eVar.f29465i != null);
                            this.f29446a.d(eVar);
                            a b4 = a.b();
                            if (b4 != null && (bVar3 = this.f29447b) != null && bVar3.m()) {
                                b4.c(this.f29446a);
                            }
                            throw th2;
                        }
                    }
                } catch (SocketException e2) {
                    this.f29446a.b().f29476c = -12;
                    eVar.f29462f = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e2.getMessage());
                    this.f29446a.d(eVar);
                    if (this.f29448c <= 0 && (bVar2 = this.f29447b) != null) {
                        this.f29448c = bVar2.f();
                    }
                    System.currentTimeMillis();
                    c.a.e.e.e.a.c().g(this.f29446a.a().e(), this.f29446a.a().d("Host"), TextUtils.isEmpty(eVar.f29462f), eVar.f29465i != null);
                    this.f29446a.d(eVar);
                    b2 = a.b();
                    if (b2 != null) {
                        b bVar14 = this.f29447b;
                        if (bVar14 != null) {
                        }
                    }
                    z = true;
                    i5 = i6;
                } catch (SocketTimeoutException e3) {
                    this.f29446a.b().f29476c = -13;
                    eVar.f29462f = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.f29446a.d(eVar);
                    if (this.f29448c <= 0 && (bVar = this.f29447b) != null) {
                        this.f29448c = bVar.f();
                    }
                    System.currentTimeMillis();
                    c.a.e.e.e.a.c().g(this.f29446a.a().e(), this.f29446a.a().d("Host"), TextUtils.isEmpty(eVar.f29462f), eVar.f29465i != null);
                    this.f29446a.d(eVar);
                    b2 = a.b();
                    if (b2 != null) {
                        b bVar15 = this.f29447b;
                        if (bVar15 != null) {
                        }
                    }
                    z = true;
                    i5 = i6;
                }
                if (this.f29446a.b().f29475b != 200) {
                    eVar.f29462f = String.valueOf(this.f29446a.b().f29475b) + "|retryCount:" + i5;
                    boolean e4 = e(this.f29446a.b().f29475b);
                    this.f29446a.d(eVar);
                    if (this.f29448c <= 0 && (bVar10 = this.f29447b) != null) {
                        this.f29448c = bVar10.f();
                    }
                    System.currentTimeMillis();
                    c.a.e.e.e.a.c().g(this.f29446a.a().e(), this.f29446a.a().d("Host"), TextUtils.isEmpty(eVar.f29462f), eVar.f29465i != null);
                    this.f29446a.d(eVar);
                    a b5 = a.b();
                    if (b5 != null && (bVar9 = this.f29447b) != null && bVar9.m()) {
                        b5.c(this.f29446a);
                    }
                    z = e4;
                    i5 = i6;
                } else {
                    if (this.f29448c <= 0 && (bVar8 = this.f29447b) != null) {
                        this.f29448c = bVar8.f();
                    }
                    System.currentTimeMillis();
                    c.a.e.e.e.a.c().g(this.f29446a.a().e(), this.f29446a.a().d("Host"), TextUtils.isEmpty(eVar.f29462f), eVar.f29465i != null);
                    this.f29446a.d(eVar);
                    a b6 = a.b();
                    if (b6 == null || (bVar7 = this.f29447b) == null || !bVar7.m()) {
                        return;
                    }
                    b6.c(this.f29446a);
                    return;
                }
            }
        }
    }

    public void i() {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (gVar = this.f29446a) == null) {
            return;
        }
        gVar.b().f29474a = true;
    }
}
