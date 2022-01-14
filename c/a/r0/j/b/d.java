package c.a.r0.j.b;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.a.k;
import c.a.r0.j.b.a;
import c.a.r0.j.b.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
/* loaded from: classes6.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static volatile d f10821i;
    public transient /* synthetic */ FieldHolder $fh;
    public HandlerThread a;

    /* renamed from: b  reason: collision with root package name */
    public e f10822b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.r0.j.b.b f10823c;

    /* renamed from: d  reason: collision with root package name */
    public long f10824d;

    /* renamed from: e  reason: collision with root package name */
    public int f10825e;

    /* renamed from: f  reason: collision with root package name */
    public long f10826f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.r0.j.b.c f10827g;

    /* renamed from: h  reason: collision with root package name */
    public e.d f10828h;

    /* loaded from: classes6.dex */
    public class a implements a.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

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
            this.a = dVar;
        }

        @Override // c.a.r0.j.b.a.d
        public void onFail(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && k.a) {
                String str2 = "handleLoginAndRealName: " + str;
            }
        }

        @Override // c.a.r0.j.b.a.d
        public void onSuccess() {
            Activity activity;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (activity = this.a.getActivity()) == null) {
                return;
            }
            c.a.r0.a.c2.b.f.e.f(activity, c.a.r0.h.g.aiapps_anti_addiction_success).G();
        }
    }

    /* loaded from: classes6.dex */
    public class b implements a.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a.d f10829b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d f10830c;

        /* loaded from: classes6.dex */
        public class a implements e.d {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

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
                this.a = bVar;
            }

            @Override // c.a.r0.j.b.e.d
            public void onFail(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    this.a.f10829b.onFail(str);
                }
            }

            @Override // c.a.r0.j.b.e.d
            public void onSuccess(Object obj) {
                Activity activity;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
                    f fVar = (f) obj;
                    if (k.a) {
                        fVar.toString();
                    }
                    int i2 = fVar.a;
                    if (i2 == 0) {
                        this.a.f10829b.onSuccess();
                    } else if (1 == i2) {
                        this.a.f10829b.onFail(fVar.f10832b);
                    } else {
                        this.a.f10829b.onFail(fVar.f10832b);
                        if (TextUtils.isEmpty(fVar.f10832b) || (activity = this.a.f10830c.getActivity()) == null) {
                            return;
                        }
                        this.a.f10830c.f10827g.f(activity, fVar.f10832b, activity.getString(c.a.r0.h.g.aiapps_anti_addiction_dialog_ok), true, null);
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
            this.f10830c = dVar;
            this.a = str;
            this.f10829b = dVar2;
        }

        @Override // c.a.r0.j.b.a.d
        public void onFail(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f10829b.onFail(str);
            }
        }

        @Override // c.a.r0.j.b.a.d
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                c.a.r0.j.b.e.h(this.a, new a(this));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f10831e;

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
            this.f10831e = dVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                this.f10831e.q();
            }
        }
    }

    /* renamed from: c.a.r0.j.b.d$d  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0733d implements e.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        public C0733d(d dVar) {
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
            this.a = dVar;
        }

        @Override // c.a.r0.j.b.e.d
        public void onFail(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                boolean z = k.a;
            }
        }

        @Override // c.a.r0.j.b.e.d
        public void onSuccess(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
                g gVar = (g) obj;
                if (k.a) {
                    gVar.toString();
                }
                this.a.f10824d = System.currentTimeMillis();
                if (this.a.s(gVar.f10834c)) {
                    this.a.r(gVar.f10835d * 1000);
                    this.a.p(gVar.a, gVar.f10833b);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

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
            this.a = dVar;
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
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || 1 == this.a.f10825e) {
                return;
            }
            sendEmptyMessageDelayed(1, this.a.f10826f);
        }

        @Override // android.os.Handler
        public void dispatchMessage(Message message) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048579, this, message) == null) && message.what == 1) {
                this.a.y(false);
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
        this.f10825e = 0;
        this.f10826f = 300000L;
        this.f10828h = new C0733d(this);
        k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Activity getActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) {
            c.a.r0.a.d2.e a0 = c.a.r0.a.d2.e.a0();
            if (a0 == null || a0.x() == null) {
                return null;
            }
            return a0.x();
        }
        return (Activity) invokeV.objValue;
    }

    public static d o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            if (f10821i == null) {
                synchronized (d.class) {
                    if (f10821i == null) {
                        f10821i = new d();
                    }
                }
            }
            return f10821i;
        }
        return (d) invokeV.objValue;
    }

    public static synchronized void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, null) == null) {
            synchronized (d.class) {
                if (f10821i != null) {
                    f10821i.m();
                    f10821i = null;
                }
            }
        }
    }

    public void j(String str, a.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, dVar) == null) {
            if (TextUtils.isEmpty(str)) {
                dVar.onFail("orderInfo is null");
            } else if (!t()) {
                dVar.onSuccess();
            } else {
                c.a.r0.j.b.a.b(new b(this, str, dVar));
            }
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            l();
            y(true);
            x();
            this.f10827g = new c.a.r0.j.b.c();
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.a == null) {
            HandlerThread handlerThread = new HandlerThread("anti_addiction_monitor");
            this.a = handlerThread;
            handlerThread.start();
            this.f10822b = new e(this, this.a.getLooper());
        }
    }

    public final synchronized void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            synchronized (this) {
                this.f10822b.a();
                if (this.a != null) {
                    this.a.quitSafely();
                    this.a = null;
                }
                if (this.f10827g != null) {
                    this.f10827g.e();
                    this.f10827g = null;
                }
            }
        }
    }

    public synchronized void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            synchronized (this) {
                if (t()) {
                    y(false);
                }
                this.f10822b.a();
            }
        }
    }

    public final void p(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048581, this, i2, str) == null) {
            if (i2 < 0) {
                if (k.a) {
                    String str2 = "server AntiAddiction state error = " + i2 + " msg = " + str;
                }
            } else if (i2 != 0) {
                if (i2 != 1) {
                    u(i2, str);
                    return;
                }
                Activity activity = getActivity();
                if (activity == null) {
                    return;
                }
                this.f10827g.f(activity, activity.getString(c.a.r0.h.g.aiapps_anti_addiction_dialog_message), activity.getString(c.a.r0.h.g.aiapps_anti_addiction_dialog_auth), true, new c(this));
            }
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            c.a.r0.j.b.a.c(new a(this));
        }
    }

    public final void r(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048583, this, j2) == null) {
            if (300000 < j2) {
                this.f10826f = j2;
            } else {
                this.f10826f = 300000L;
            }
        }
    }

    public final boolean s(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
            this.f10825e = i2;
            if (1 == i2) {
                n();
                return false;
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public final boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f10825e == 0 : invokeV.booleanValue;
    }

    public final void u(int i2, String str) {
        c.a.r0.j.b.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048586, this, i2, str) == null) || (bVar = this.f10823c) == null) {
            return;
        }
        try {
            bVar.x(i2, str);
        } catch (JSONException e2) {
            if (k.a) {
                e2.printStackTrace();
            }
        }
    }

    public void w(c.a.r0.j.b.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bVar) == null) {
            this.f10823c = bVar;
        }
    }

    public synchronized void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            synchronized (this) {
                if (t() && !this.f10822b.b()) {
                    this.f10824d = System.currentTimeMillis();
                    this.f10822b.c();
                }
            }
        }
    }

    public final void y(boolean z) {
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            if (z) {
                j2 = 0;
            } else {
                j2 = System.currentTimeMillis() - this.f10824d;
                if (180000 > j2) {
                    return;
                }
            }
            boolean z2 = k.a;
            c.a.r0.j.b.e.i(j2, this.f10828h);
        }
    }
}
