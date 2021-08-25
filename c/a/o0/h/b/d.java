package c.a.o0.h.b;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.a.k;
import c.a.o0.h.b.a;
import c.a.o0.h.b.e;
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
    public static volatile d f10962i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public HandlerThread f10963a;

    /* renamed from: b  reason: collision with root package name */
    public e f10964b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.o0.h.b.b f10965c;

    /* renamed from: d  reason: collision with root package name */
    public long f10966d;

    /* renamed from: e  reason: collision with root package name */
    public int f10967e;

    /* renamed from: f  reason: collision with root package name */
    public long f10968f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.o0.h.b.c f10969g;

    /* renamed from: h  reason: collision with root package name */
    public e.c f10970h;

    /* loaded from: classes3.dex */
    public class a implements a.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f10971a;

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
            this.f10971a = dVar;
        }

        @Override // c.a.o0.h.b.a.d
        public void onFail(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && k.f7049a) {
                String str2 = "handleLoginAndRealName: " + str;
            }
        }

        @Override // c.a.o0.h.b.a.d
        public void onSuccess() {
            Activity o;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (o = this.f10971a.o()) == null) {
                return;
            }
            c.a.o0.a.z1.b.f.e.f(o, c.a.o0.f.g.aiapps_anti_addiction_success).F();
        }
    }

    /* loaded from: classes3.dex */
    public class b implements a.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f10972a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a.d f10973b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d f10974c;

        /* loaded from: classes3.dex */
        public class a implements e.c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f10975a;

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
                this.f10975a = bVar;
            }

            @Override // c.a.o0.h.b.e.c
            public void onFail(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    this.f10975a.f10973b.onFail(str);
                }
            }

            @Override // c.a.o0.h.b.e.c
            public void onSuccess(Object obj) {
                Activity o;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
                    f fVar = (f) obj;
                    if (k.f7049a) {
                        fVar.toString();
                    }
                    int i2 = fVar.f10981a;
                    if (i2 == 0) {
                        this.f10975a.f10973b.onSuccess();
                    } else if (1 == i2) {
                        this.f10975a.f10973b.onFail(fVar.f10982b);
                    } else {
                        this.f10975a.f10973b.onFail(fVar.f10982b);
                        if (TextUtils.isEmpty(fVar.f10982b) || (o = this.f10975a.f10974c.o()) == null) {
                            return;
                        }
                        this.f10975a.f10974c.f10969g.f(o, fVar.f10982b, o.getString(c.a.o0.f.g.aiapps_anti_addiction_dialog_ok), true, null);
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
            this.f10974c = dVar;
            this.f10972a = str;
            this.f10973b = dVar2;
        }

        @Override // c.a.o0.h.b.a.d
        public void onFail(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f10973b.onFail(str);
            }
        }

        @Override // c.a.o0.h.b.a.d
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                c.a.o0.h.b.e.c(this.f10972a, new a(this));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f10976e;

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
            this.f10976e = dVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                this.f10976e.r();
            }
        }
    }

    /* renamed from: c.a.o0.h.b.d$d  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0554d implements e.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f10977a;

        public C0554d(d dVar) {
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
            this.f10977a = dVar;
        }

        @Override // c.a.o0.h.b.e.c
        public void onFail(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                boolean z = k.f7049a;
            }
        }

        @Override // c.a.o0.h.b.e.c
        public void onSuccess(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
                g gVar = (g) obj;
                if (k.f7049a) {
                    gVar.toString();
                }
                this.f10977a.f10966d = System.currentTimeMillis();
                if (this.f10977a.t(gVar.f10985c)) {
                    this.f10977a.s(gVar.f10986d * 1000);
                    this.f10977a.q(gVar.f10983a, gVar.f10984b);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f10978a;

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
            this.f10978a = dVar;
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
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || 1 == this.f10978a.f10967e) {
                return;
            }
            sendEmptyMessageDelayed(1, this.f10978a.f10968f);
        }

        @Override // android.os.Handler
        public void dispatchMessage(Message message) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048579, this, message) == null) && message.what == 1) {
                this.f10978a.z(false);
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
        this.f10967e = 0;
        this.f10968f = 300000L;
        this.f10970h = new C0554d(this);
        k();
    }

    public static d p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            if (f10962i == null) {
                synchronized (d.class) {
                    if (f10962i == null) {
                        f10962i = new d();
                    }
                }
            }
            return f10962i;
        }
        return (d) invokeV.objValue;
    }

    public static synchronized void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, null) == null) {
            synchronized (d.class) {
                if (f10962i != null) {
                    f10962i.m();
                    f10962i = null;
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
                c.a.o0.h.b.a.b(new b(this, str, dVar));
            }
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            l();
            z(true);
            y();
            this.f10969g = new c.a.o0.h.b.c();
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.f10963a == null) {
            HandlerThread handlerThread = new HandlerThread("anti_addiction_monitor");
            this.f10963a = handlerThread;
            handlerThread.start();
            this.f10964b = new e(this, this.f10963a.getLooper());
        }
    }

    public final synchronized void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            synchronized (this) {
                this.f10964b.a();
                if (this.f10963a != null) {
                    this.f10963a.quitSafely();
                    this.f10963a = null;
                }
                if (this.f10969g != null) {
                    this.f10969g.e();
                    this.f10969g = null;
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
                this.f10964b.a();
            }
        }
    }

    public final Activity o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            c.a.o0.a.a2.e Q = c.a.o0.a.a2.e.Q();
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
                if (k.f7049a) {
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
                this.f10969g.f(o, o.getString(c.a.o0.f.g.aiapps_anti_addiction_dialog_message), o.getString(c.a.o0.f.g.aiapps_anti_addiction_dialog_auth), true, new c(this));
            }
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            c.a.o0.h.b.a.c(new a(this));
        }
    }

    public final void s(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j2) == null) {
            if (300000 < j2) {
                this.f10968f = j2;
            } else {
                this.f10968f = 300000L;
            }
        }
    }

    public final boolean t(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) {
            this.f10967e = i2;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f10967e == 0 : invokeV.booleanValue;
    }

    public final void v(int i2, String str) {
        c.a.o0.h.b.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048587, this, i2, str) == null) || (bVar = this.f10965c) == null) {
            return;
        }
        try {
            bVar.x(i2, str);
        } catch (JSONException e2) {
            if (k.f7049a) {
                e2.printStackTrace();
            }
        }
    }

    public void x(c.a.o0.h.b.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bVar) == null) {
            this.f10965c = bVar;
        }
    }

    public synchronized void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            synchronized (this) {
                if (u() && !this.f10964b.b()) {
                    this.f10966d = System.currentTimeMillis();
                    this.f10964b.c();
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
                j2 = System.currentTimeMillis() - this.f10966d;
                if (180000 > j2) {
                    return;
                }
            }
            boolean z2 = k.f7049a;
            c.a.o0.h.b.e.d(j2, this.f10970h);
        }
    }
}
