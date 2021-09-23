package c.a.p0.h.b;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.k;
import c.a.p0.h.b.a;
import c.a.p0.h.b.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
/* loaded from: classes3.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static volatile d f10998i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public HandlerThread f10999a;

    /* renamed from: b  reason: collision with root package name */
    public e f11000b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.p0.h.b.b f11001c;

    /* renamed from: d  reason: collision with root package name */
    public long f11002d;

    /* renamed from: e  reason: collision with root package name */
    public int f11003e;

    /* renamed from: f  reason: collision with root package name */
    public long f11004f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.p0.h.b.c f11005g;

    /* renamed from: h  reason: collision with root package name */
    public e.c f11006h;

    /* loaded from: classes3.dex */
    public class a implements a.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f11007a;

        public a(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11007a = dVar;
        }

        @Override // c.a.p0.h.b.a.d
        public void onFail(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && k.f7085a) {
                String str2 = "handleLoginAndRealName: " + str;
            }
        }

        @Override // c.a.p0.h.b.a.d
        public void onSuccess() {
            Activity o;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (o = this.f11007a.o()) == null) {
                return;
            }
            c.a.p0.a.z1.b.f.e.f(o, c.a.p0.f.g.aiapps_anti_addiction_success).F();
        }
    }

    /* loaded from: classes3.dex */
    public class b implements a.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f11008a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a.d f11009b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d f11010c;

        /* loaded from: classes3.dex */
        public class a implements e.c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f11011a;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f11011a = bVar;
            }

            @Override // c.a.p0.h.b.e.c
            public void onFail(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    this.f11011a.f11009b.onFail(str);
                }
            }

            @Override // c.a.p0.h.b.e.c
            public void onSuccess(Object obj) {
                Activity o;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
                    f fVar = (f) obj;
                    if (k.f7085a) {
                        fVar.toString();
                    }
                    int i2 = fVar.f11017a;
                    if (i2 == 0) {
                        this.f11011a.f11009b.onSuccess();
                    } else if (1 == i2) {
                        this.f11011a.f11009b.onFail(fVar.f11018b);
                    } else {
                        this.f11011a.f11009b.onFail(fVar.f11018b);
                        if (TextUtils.isEmpty(fVar.f11018b) || (o = this.f11011a.f11010c.o()) == null) {
                            return;
                        }
                        this.f11011a.f11010c.f11005g.f(o, fVar.f11018b, o.getString(c.a.p0.f.g.aiapps_anti_addiction_dialog_ok), true, null);
                    }
                }
            }
        }

        public b(d dVar, String str, a.d dVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, str, dVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11010c = dVar;
            this.f11008a = str;
            this.f11009b = dVar2;
        }

        @Override // c.a.p0.h.b.a.d
        public void onFail(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f11009b.onFail(str);
            }
        }

        @Override // c.a.p0.h.b.a.d
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                c.a.p0.h.b.e.c(this.f11008a, new a(this));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f11012e;

        public c(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11012e = dVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                this.f11012e.r();
            }
        }
    }

    /* renamed from: c.a.p0.h.b.d$d  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0556d implements e.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f11013a;

        public C0556d(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11013a = dVar;
        }

        @Override // c.a.p0.h.b.e.c
        public void onFail(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                boolean z = k.f7085a;
            }
        }

        @Override // c.a.p0.h.b.e.c
        public void onSuccess(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
                g gVar = (g) obj;
                if (k.f7085a) {
                    gVar.toString();
                }
                this.f11013a.f11002d = System.currentTimeMillis();
                if (this.f11013a.t(gVar.f11021c)) {
                    this.f11013a.s(gVar.f11022d * 1000);
                    this.f11013a.q(gVar.f11019a, gVar.f11020b);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f11014a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(d dVar, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11014a = dVar;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                removeCallbacksAndMessages(null);
            }
        }

        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? hasMessages(1) : invokeV.booleanValue;
        }

        public void c() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || 1 == this.f11014a.f11003e) {
                return;
            }
            sendEmptyMessageDelayed(1, this.f11014a.f11004f);
        }

        @Override // android.os.Handler
        public void dispatchMessage(Message message) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048579, this, message) == null) && message.what == 1) {
                this.f11014a.z(false);
                c();
            }
        }
    }

    public d() {
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
        this.f11003e = 0;
        this.f11004f = 300000L;
        this.f11006h = new C0556d(this);
        k();
    }

    public static d p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            if (f10998i == null) {
                synchronized (d.class) {
                    if (f10998i == null) {
                        f10998i = new d();
                    }
                }
            }
            return f10998i;
        }
        return (d) invokeV.objValue;
    }

    public static synchronized void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, null) == null) {
            synchronized (d.class) {
                if (f10998i != null) {
                    f10998i.m();
                    f10998i = null;
                }
            }
        }
    }

    public void j(String str, a.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, dVar) == null) {
            if (TextUtils.isEmpty(str)) {
                dVar.onFail("orderInfo is null");
            } else if (!u()) {
                dVar.onSuccess();
            } else {
                c.a.p0.h.b.a.b(new b(this, str, dVar));
            }
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            l();
            z(true);
            y();
            this.f11005g = new c.a.p0.h.b.c();
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.f10999a == null) {
            HandlerThread handlerThread = new HandlerThread("anti_addiction_monitor");
            this.f10999a = handlerThread;
            handlerThread.start();
            this.f11000b = new e(this, this.f10999a.getLooper());
        }
    }

    public final synchronized void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            synchronized (this) {
                this.f11000b.a();
                if (this.f10999a != null) {
                    this.f10999a.quitSafely();
                    this.f10999a = null;
                }
                if (this.f11005g != null) {
                    this.f11005g.e();
                    this.f11005g = null;
                }
            }
        }
    }

    public synchronized void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            synchronized (this) {
                if (u()) {
                    z(false);
                }
                this.f11000b.a();
            }
        }
    }

    public final Activity o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            c.a.p0.a.a2.e Q = c.a.p0.a.a2.e.Q();
            if (Q == null || Q.x() == null) {
                return null;
            }
            return Q.x();
        }
        return (Activity) invokeV.objValue;
    }

    public final void q(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048582, this, i2, str) == null) {
            if (i2 < 0) {
                if (k.f7085a) {
                    String str2 = "server AntiAddiction state error = " + i2 + " msg = " + str;
                }
            } else if (i2 != 0) {
                if (i2 != 1) {
                    v(i2, str);
                    return;
                }
                Activity o = o();
                if (o == null) {
                    return;
                }
                this.f11005g.f(o, o.getString(c.a.p0.f.g.aiapps_anti_addiction_dialog_message), o.getString(c.a.p0.f.g.aiapps_anti_addiction_dialog_auth), true, new c(this));
            }
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            c.a.p0.h.b.a.c(new a(this));
        }
    }

    public final void s(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j2) == null) {
            if (300000 < j2) {
                this.f11004f = j2;
            } else {
                this.f11004f = 300000L;
            }
        }
    }

    public final boolean t(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) {
            this.f11003e = i2;
            if (1 == i2) {
                n();
                return false;
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public final boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f11003e == 0 : invokeV.booleanValue;
    }

    public final void v(int i2, String str) {
        c.a.p0.h.b.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048587, this, i2, str) == null) || (bVar = this.f11001c) == null) {
            return;
        }
        try {
            bVar.x(i2, str);
        } catch (JSONException e2) {
            if (k.f7085a) {
                e2.printStackTrace();
            }
        }
    }

    public void x(c.a.p0.h.b.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bVar) == null) {
            this.f11001c = bVar;
        }
    }

    public synchronized void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            synchronized (this) {
                if (u() && !this.f11000b.b()) {
                    this.f11002d = System.currentTimeMillis();
                    this.f11000b.c();
                }
            }
        }
    }

    public final void z(boolean z) {
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            if (z) {
                j2 = 0;
            } else {
                j2 = System.currentTimeMillis() - this.f11002d;
                if (180000 > j2) {
                    return;
                }
            }
            boolean z2 = k.f7085a;
            c.a.p0.h.b.e.d(j2, this.f11006h);
        }
    }
}
