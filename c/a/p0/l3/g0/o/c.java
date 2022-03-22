package c.a.p0.l3.g0.o;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.FileNotFoundException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
/* loaded from: classes2.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public g a;

    /* renamed from: b  reason: collision with root package name */
    public b f16188b;

    /* renamed from: c  reason: collision with root package name */
    public long f16189c;

    public c(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {gVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f16189c = 0L;
        this.a = gVar;
    }

    public void a() {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (bVar = this.f16188b) == null) {
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
    public boolean b(String str, j jVar, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        e eVar;
        int i5;
        int i6;
        e eVar2;
        a b2;
        a b3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, jVar, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            int b4 = i3 <= 0 ? c.a.d.c.j.b.d().b().b() : i3;
            int a = i <= 0 ? c.a.d.c.j.b.d().a() : i;
            int b5 = i4 <= 0 ? c.a.d.c.j.b.d().c().b() : i4;
            this.f16188b = new b(this.a);
            int i7 = 0;
            while (i7 < a) {
                e eVar3 = new e();
                int i8 = i7 + 1;
                try {
                    int i9 = b4;
                    i5 = b4;
                    i6 = i7;
                    try {
                        boolean c2 = this.f16188b.c(str, jVar, i9, b5, z, eVar3, z2);
                        c.a.d.f.e.a.c().g(this.a.a().e(), this.a.a().d("Host"), TextUtils.isEmpty(eVar3.f16201f), eVar3.i != null);
                        this.a.d(eVar3);
                        a b6 = a.b();
                        if (b6 != null) {
                            b6.c(this.a);
                        }
                        return c2;
                    } catch (FileNotFoundException e2) {
                        e = e2;
                        eVar2 = eVar3;
                        this.a.b().f16209b = -100;
                        eVar2.f16201f = String.valueOf(this.a.b().f16209b) + "|retryCount:" + i6 + "|" + e.getClass() + "|" + e.getMessage();
                        this.a.d(eVar2);
                        c.a.d.f.e.a.c().g(this.a.a().e(), this.a.a().d("Host"), TextUtils.isEmpty(eVar2.f16201f), eVar2.i != null);
                        this.a.d(eVar2);
                        b3 = a.b();
                        if (b3 == null) {
                            b4 = i5;
                            i7 = i8;
                        }
                        b3.c(this.a);
                        b4 = i5;
                        i7 = i8;
                    } catch (Exception e3) {
                        e = e3;
                        eVar = eVar3;
                        try {
                            this.a.b().f16209b = -10;
                            eVar.f16201f = String.valueOf(this.a.b().f16209b) + "|retryCount:" + i6 + "|" + e.getClass() + "|" + e.getMessage();
                            this.a.d(eVar);
                            c.a.d.f.e.a.c().g(this.a.a().e(), this.a.a().d("Host"), TextUtils.isEmpty(eVar.f16201f), eVar.i != null);
                            this.a.d(eVar);
                            b3 = a.b();
                            if (b3 == null) {
                                b4 = i5;
                                i7 = i8;
                            }
                            b3.c(this.a);
                            b4 = i5;
                            i7 = i8;
                        } catch (Throwable th) {
                            th = th;
                            c.a.d.f.e.a.c().g(this.a.a().e(), this.a.a().d("Host"), TextUtils.isEmpty(eVar.f16201f), eVar.i == null);
                            this.a.d(eVar);
                            b2 = a.b();
                            if (b2 != null) {
                                b2.c(this.a);
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        eVar = eVar3;
                        c.a.d.f.e.a.c().g(this.a.a().e(), this.a.a().d("Host"), TextUtils.isEmpty(eVar.f16201f), eVar.i == null);
                        this.a.d(eVar);
                        b2 = a.b();
                        if (b2 != null) {
                        }
                        throw th;
                    }
                } catch (FileNotFoundException e4) {
                    e = e4;
                    eVar2 = eVar3;
                    i5 = b4;
                    i6 = i7;
                } catch (Exception e5) {
                    e = e5;
                    eVar = eVar3;
                    i5 = b4;
                    i6 = i7;
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
        r0.c(r16.a);
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
    public void c(int i, int i2, int i3) {
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
        if (interceptable == null || interceptable.invokeIII(Constants.METHOD_SEND_USER_MSG, this, i, i2, i3) == null) {
            int b5 = i2 <= 0 ? c.a.d.c.j.b.d().b().b() : i2;
            int a = i <= 0 ? c.a.d.c.j.b.d().a() : i;
            int b6 = i3 <= 0 ? c.a.d.c.j.b.d().c().b() : i3;
            System.currentTimeMillis();
            boolean z = true;
            int i4 = 0;
            for (boolean z2 = true; !this.a.b().a && z == z2 && i4 < a; z2 = true) {
                e eVar = new e();
                this.a.d(eVar);
                try {
                    try {
                        try {
                            b bVar8 = new b(this.a);
                            this.f16188b = bVar8;
                            bVar8.g(b5, b6, eVar);
                        } catch (IllegalStateException e2) {
                            this.a.b().f16210c = -19;
                            eVar.f16201f = "errorCode:" + String.valueOf(-19) + "|" + e2.getClass() + "|" + e2.getMessage() + "|getcontent_illegal_error";
                            if (this.f16189c <= 0 && (bVar4 = this.f16188b) != null) {
                                this.f16189c = bVar4.f();
                            }
                            System.currentTimeMillis();
                            c.a.d.f.e.a.c().g(this.a.a().e(), this.a.a().d("Host"), TextUtils.isEmpty(eVar.f16201f), eVar.i != null);
                            this.a.e(eVar);
                            b4 = a.b();
                            if (b4 == null) {
                            }
                        } catch (SocketException e3) {
                            eVar.f16201f = String.valueOf(this.a.b().f16209b) + "|retryCount:" + i4 + "|" + e3.getClass() + "|" + e3.getMessage();
                            this.a.b().f16210c = -12;
                            if (this.f16189c <= 0 && (bVar3 = this.f16188b) != null) {
                                this.f16189c = bVar3.f();
                            }
                            System.currentTimeMillis();
                            c.a.d.f.e.a.c().g(this.a.a().e(), this.a.a().d("Host"), TextUtils.isEmpty(eVar.f16201f), eVar.i != null);
                            this.a.e(eVar);
                            b3 = a.b();
                        }
                    } catch (SocketTimeoutException e4) {
                        eVar.f16201f = String.valueOf(this.a.b().f16209b) + "|retryCount:" + i4 + "|" + e4.getClass() + "|" + e4.getMessage();
                        this.a.b().f16210c = -13;
                        if (this.f16189c <= 0 && (bVar2 = this.f16188b) != null) {
                            this.f16189c = bVar2.f();
                        }
                        System.currentTimeMillis();
                        c.a.d.f.e.a.c().g(this.a.a().e(), this.a.a().d("Host"), TextUtils.isEmpty(eVar.f16201f), eVar.i != null);
                        this.a.e(eVar);
                        b3 = a.b();
                    } catch (Exception e5) {
                        eVar.f16201f = String.valueOf(this.a.b().f16209b) + "|retryCount:" + i4 + "|" + e5.getClass() + "|" + e5.getMessage();
                        this.a.b().f16210c = -10;
                        BdLog.e(e5.getMessage());
                        if (this.f16189c <= 0 && (bVar = this.f16188b) != null) {
                            this.f16189c = bVar.f();
                        }
                        System.currentTimeMillis();
                        c.a.d.f.e.a.c().g(this.a.a().e(), this.a.a().d("Host"), TextUtils.isEmpty(eVar.f16201f), eVar.i != null);
                        this.a.e(eVar);
                        b2 = a.b();
                        if (b2 == null) {
                            return;
                        }
                    }
                    if (this.a.b().f16209b != 200) {
                        eVar.f16201f = String.valueOf(this.a.b().f16209b) + "|retryCount:" + i4;
                        z = e(this.a.b().f16209b);
                        if (this.f16189c <= 0 && (bVar7 = this.f16188b) != null) {
                            this.f16189c = bVar7.f();
                        }
                        System.currentTimeMillis();
                        c.a.d.f.e.a.c().g(this.a.a().e(), this.a.a().d("Host"), TextUtils.isEmpty(eVar.f16201f), eVar.i != null);
                        this.a.e(eVar);
                        b4 = a.b();
                        if (b4 == null) {
                            i4++;
                        }
                        b4.c(this.a);
                        i4++;
                    } else {
                        this.a.e(eVar);
                        if (this.f16189c <= 0 && (bVar6 = this.f16188b) != null) {
                            this.f16189c = bVar6.f();
                        }
                        System.currentTimeMillis();
                        c.a.d.f.e.a.c().g(this.a.a().e(), this.a.a().d("Host"), TextUtils.isEmpty(eVar.f16201f), eVar.i != null);
                        this.a.e(eVar);
                        b2 = a.b();
                        if (b2 == null) {
                            return;
                        }
                        b2.c(this.a);
                        return;
                    }
                } catch (Throwable th) {
                    if (this.f16189c <= 0 && (bVar5 = this.f16188b) != null) {
                        this.f16189c = bVar5.f();
                    }
                    System.currentTimeMillis();
                    c.a.d.f.e.a.c().g(this.a.a().e(), this.a.a().d("Host"), TextUtils.isEmpty(eVar.f16201f), eVar.i != null);
                    this.a.e(eVar);
                    a b7 = a.b();
                    if (b7 != null) {
                        b7.c(this.a);
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
            g gVar = this.a;
            if (gVar == null) {
                return false;
            }
            return gVar.b().a;
        }
        return invokeV.booleanValue;
    }

    public final boolean e(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            if (i == 202 || i == 201 || i == 205 || i == 304 || i == 305 || i == 408) {
                return true;
            }
            return (i == 502 || i == 503 || i == 504 || i == 404) ? false : true;
        }
        return invokeI.booleanValue;
    }

    public void f(int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048581, this, i, i2, i3) == null) {
            if (this.a.a().f()) {
                h(i, i2, i3);
            } else {
                g(i, i2, i3);
            }
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, CMP_L]}, finally: {[IGET, CMP_L, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, IF, INVOKE, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, IGET, INVOKE, IPUT, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, IF, INVOKE, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, IGET, IF, IGET, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, IF, INVOKE, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, IGET, IF] complete} */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 0, expect 1 */
    /* JADX WARN: Code restructure failed: missing block: B:100:0x0304, code lost:
        r3 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x01a2, code lost:
        if (r3 == null) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x020e, code lost:
        if (r3 == null) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0210, code lost:
        r3.c(r11.a);
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0215, code lost:
        r3 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0289, code lost:
        if (r3 == null) goto L107;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x02fd, code lost:
        if (r3 == null) goto L107;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x02ff, code lost:
        r3.c(r11.a);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void g(int i, int i2, int i3) {
        a b2;
        b bVar;
        b bVar2;
        b bVar3;
        a b3;
        b bVar4;
        b bVar5;
        b bVar6;
        b bVar7;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048582, this, i, i2, i3) == null) {
            if (i2 <= 0) {
                i2 = c.a.d.c.j.b.d().b().b();
            }
            if (i <= 0) {
                i = c.a.d.c.j.b.d().a();
            }
            if (i3 <= 0) {
                i3 = c.a.d.c.j.b.d().c().b();
            }
            System.currentTimeMillis();
            boolean z = true;
            int i4 = 0;
            while (!this.a.b().a && z && i4 < i) {
                e eVar = new e();
                int i5 = i4 + 1;
                try {
                    try {
                        b bVar8 = new b(this.a);
                        this.f16188b = bVar8;
                        bVar8.o(i2, i3, eVar);
                    } catch (UnsupportedOperationException unused) {
                        this.a.b().f16210c = -14;
                        eVar.f16201f = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.obfuscated_res_0x7f0f0c15);
                        this.a.d(eVar);
                        if (this.f16189c <= 0 && (bVar5 = this.f16188b) != null) {
                            this.f16189c = bVar5.f();
                        }
                        System.currentTimeMillis();
                        c.a.d.f.e.a.c().g(this.a.a().e(), this.a.a().d("Host"), TextUtils.isEmpty(eVar.f16201f), eVar.i != null);
                        this.a.d(eVar);
                        b3 = a.b();
                    } catch (Throwable th) {
                        try {
                            this.a.b().f16210c = -10;
                            eVar.f16201f = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.obfuscated_res_0x7f0f0c15);
                            BdLog.e(th.getMessage());
                            this.a.d(eVar);
                            if (this.f16189c <= 0 && (bVar4 = this.f16188b) != null) {
                                this.f16189c = bVar4.f();
                            }
                            System.currentTimeMillis();
                            c.a.d.f.e.a.c().g(this.a.a().e(), this.a.a().d("Host"), TextUtils.isEmpty(eVar.f16201f), eVar.i != null);
                            this.a.d(eVar);
                            b3 = a.b();
                        } catch (Throwable th2) {
                            if (this.f16189c <= 0 && (bVar3 = this.f16188b) != null) {
                                this.f16189c = bVar3.f();
                            }
                            System.currentTimeMillis();
                            c.a.d.f.e.a.c().g(this.a.a().e(), this.a.a().d("Host"), TextUtils.isEmpty(eVar.f16201f), eVar.i != null);
                            this.a.d(eVar);
                            a b4 = a.b();
                            if (b4 != null) {
                                b4.c(this.a);
                            }
                            throw th2;
                        }
                    }
                } catch (SocketException e2) {
                    this.a.b().f16210c = -12;
                    eVar.f16201f = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.obfuscated_res_0x7f0f0c15);
                    BdLog.e(e2.getMessage());
                    this.a.d(eVar);
                    if (this.f16189c <= 0 && (bVar2 = this.f16188b) != null) {
                        this.f16189c = bVar2.f();
                    }
                    System.currentTimeMillis();
                    c.a.d.f.e.a.c().g(this.a.a().e(), this.a.a().d("Host"), TextUtils.isEmpty(eVar.f16201f), eVar.i != null);
                    this.a.d(eVar);
                    b2 = a.b();
                } catch (SocketTimeoutException e3) {
                    this.a.b().f16210c = -13;
                    eVar.f16201f = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.obfuscated_res_0x7f0f0c15);
                    BdLog.e(e3.getMessage());
                    this.a.d(eVar);
                    if (this.f16189c <= 0 && (bVar = this.f16188b) != null) {
                        this.f16189c = bVar.f();
                    }
                    System.currentTimeMillis();
                    c.a.d.f.e.a.c().g(this.a.a().e(), this.a.a().d("Host"), TextUtils.isEmpty(eVar.f16201f), eVar.i != null);
                    this.a.d(eVar);
                    b2 = a.b();
                }
                if (this.a.b().f16209b != 200) {
                    eVar.f16201f = String.valueOf(this.a.b().f16209b) + "|retryCount:" + i4;
                    boolean e4 = e(this.a.b().f16209b);
                    this.a.d(eVar);
                    if (this.f16189c <= 0 && (bVar7 = this.f16188b) != null) {
                        this.f16189c = bVar7.f();
                    }
                    System.currentTimeMillis();
                    c.a.d.f.e.a.c().g(this.a.a().e(), this.a.a().d("Host"), TextUtils.isEmpty(eVar.f16201f), eVar.i != null);
                    this.a.d(eVar);
                    a b5 = a.b();
                    if (b5 != null) {
                        b5.c(this.a);
                    }
                    z = e4;
                    i4 = i5;
                } else {
                    if (this.f16189c <= 0 && (bVar6 = this.f16188b) != null) {
                        this.f16189c = bVar6.f();
                    }
                    System.currentTimeMillis();
                    c.a.d.f.e.a.c().g(this.a.a().e(), this.a.a().d("Host"), TextUtils.isEmpty(eVar.f16201f), eVar.i != null);
                    this.a.d(eVar);
                    a b6 = a.b();
                    if (b6 != null) {
                        b6.c(this.a);
                        return;
                    }
                    return;
                }
            }
        }
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 0, expect 1 */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x02bc, code lost:
        if (r4.m() != false) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x033b, code lost:
        if (r4.m() != false) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x033d, code lost:
        r3.c(r11.a);
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x01c0, code lost:
        if (r4.m() != false) goto L130;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0237, code lost:
        if (r4.m() != false) goto L130;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0239, code lost:
        r3.c(r11.a);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void h(int i, int i2, int i3) {
        a b2;
        b bVar;
        b bVar2;
        a b3;
        b bVar3;
        b bVar4;
        b bVar5;
        b bVar6;
        b bVar7;
        b bVar8;
        b bVar9;
        b bVar10;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048583, this, i, i2, i3) == null) {
            if (i2 <= 0) {
                i2 = c.a.d.c.j.b.d().b().b();
            }
            if (i <= 0) {
                i = c.a.d.c.j.b.d().a();
            }
            if (i3 <= 0) {
                i3 = c.a.d.c.j.b.d().c().b();
            }
            System.currentTimeMillis();
            boolean z = true;
            int i4 = 0;
            while (!this.a.b().a && z && i4 < i) {
                e eVar = new e();
                int i5 = i4 + 1;
                try {
                    try {
                        try {
                            b bVar11 = new b(this.a);
                            this.f16188b = bVar11;
                            bVar11.n(i2, i3, eVar);
                        } catch (SocketTimeoutException e2) {
                            this.a.b().f16210c = -13;
                            eVar.f16201f = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.obfuscated_res_0x7f0f0c15);
                            BdLog.e(e2.getMessage());
                            this.a.d(eVar);
                            if (this.f16189c <= 0 && (bVar6 = this.f16188b) != null) {
                                this.f16189c = bVar6.f();
                            }
                            System.currentTimeMillis();
                            c.a.d.f.e.a.c().g(this.a.a().e(), this.a.a().d("Host"), TextUtils.isEmpty(eVar.f16201f), eVar.i != null);
                            this.a.d(eVar);
                            b3 = a.b();
                            if (b3 != null) {
                                b bVar12 = this.f16188b;
                                if (bVar12 != null) {
                                }
                            }
                            z = true;
                            i4 = i5;
                        }
                    } catch (SocketException e3) {
                        this.a.b().f16210c = -12;
                        eVar.f16201f = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.obfuscated_res_0x7f0f0c15);
                        BdLog.e(e3.getMessage());
                        this.a.d(eVar);
                        if (this.f16189c <= 0 && (bVar3 = this.f16188b) != null) {
                            this.f16189c = bVar3.f();
                        }
                        System.currentTimeMillis();
                        c.a.d.f.e.a.c().g(this.a.a().e(), this.a.a().d("Host"), TextUtils.isEmpty(eVar.f16201f), eVar.i != null);
                        this.a.d(eVar);
                        b3 = a.b();
                        if (b3 != null) {
                            b bVar13 = this.f16188b;
                            if (bVar13 != null) {
                            }
                        }
                        z = true;
                        i4 = i5;
                    }
                } catch (UnsupportedOperationException unused) {
                    this.a.b().f16210c = -14;
                    eVar.f16201f = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.obfuscated_res_0x7f0f0c15);
                    this.a.d(eVar);
                    if (this.f16189c <= 0 && (bVar2 = this.f16188b) != null) {
                        this.f16189c = bVar2.f();
                    }
                    System.currentTimeMillis();
                    c.a.d.f.e.a.c().g(this.a.a().e(), this.a.a().d("Host"), TextUtils.isEmpty(eVar.f16201f), eVar.i != null);
                    this.a.d(eVar);
                    b2 = a.b();
                    if (b2 != null) {
                        b bVar14 = this.f16188b;
                        if (bVar14 != null) {
                        }
                    }
                    z = false;
                    i4 = i5;
                } catch (Throwable th) {
                    try {
                        this.a.b().f16210c = -10;
                        eVar.f16201f = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.obfuscated_res_0x7f0f0c15);
                        BdLog.e(th.getMessage());
                        this.a.d(eVar);
                        if (this.f16189c <= 0 && (bVar = this.f16188b) != null) {
                            this.f16189c = bVar.f();
                        }
                        System.currentTimeMillis();
                        c.a.d.f.e.a.c().g(this.a.a().e(), this.a.a().d("Host"), TextUtils.isEmpty(eVar.f16201f), eVar.i != null);
                        this.a.d(eVar);
                        b2 = a.b();
                        if (b2 != null) {
                            b bVar15 = this.f16188b;
                            if (bVar15 != null) {
                            }
                        }
                        z = false;
                        i4 = i5;
                    } catch (Throwable th2) {
                        if (this.f16189c <= 0 && (bVar5 = this.f16188b) != null) {
                            this.f16189c = bVar5.f();
                        }
                        System.currentTimeMillis();
                        c.a.d.f.e.a.c().g(this.a.a().e(), this.a.a().d("Host"), TextUtils.isEmpty(eVar.f16201f), eVar.i != null);
                        this.a.d(eVar);
                        a b4 = a.b();
                        if (b4 != null && (bVar4 = this.f16188b) != null && bVar4.m()) {
                            b4.c(this.a);
                        }
                        throw th2;
                    }
                }
                if (this.a.b().f16209b != 200) {
                    eVar.f16201f = String.valueOf(this.a.b().f16209b) + "|retryCount:" + i4;
                    boolean e4 = e(this.a.b().f16209b);
                    this.a.d(eVar);
                    if (this.f16189c <= 0 && (bVar10 = this.f16188b) != null) {
                        this.f16189c = bVar10.f();
                    }
                    System.currentTimeMillis();
                    c.a.d.f.e.a.c().g(this.a.a().e(), this.a.a().d("Host"), TextUtils.isEmpty(eVar.f16201f), eVar.i != null);
                    this.a.d(eVar);
                    a b5 = a.b();
                    if (b5 != null && (bVar9 = this.f16188b) != null && bVar9.m()) {
                        b5.c(this.a);
                    }
                    z = e4;
                    i4 = i5;
                } else {
                    if (this.f16189c <= 0 && (bVar8 = this.f16188b) != null) {
                        this.f16189c = bVar8.f();
                    }
                    System.currentTimeMillis();
                    c.a.d.f.e.a.c().g(this.a.a().e(), this.a.a().d("Host"), TextUtils.isEmpty(eVar.f16201f), eVar.i != null);
                    this.a.d(eVar);
                    a b6 = a.b();
                    if (b6 == null || (bVar7 = this.f16188b) == null || !bVar7.m()) {
                        return;
                    }
                    b6.c(this.a);
                    return;
                }
            }
        }
    }

    public void i() {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (gVar = this.a) == null) {
            return;
        }
        gVar.b().a = true;
    }
}
