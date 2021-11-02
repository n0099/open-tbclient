package b.a.p0.a.u.e.d;

import android.app.Activity;
import android.database.ContentObserver;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import b.a.p0.a.h0.g.d;
import b.a.p0.a.j1.a;
import b.a.p0.a.k;
import b.a.p0.a.u.e.d.a;
import b.a.p0.a.v2.n0;
import b.a.p0.a.v2.q;
import b.a.p0.a.v2.q0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.api.module.favorite.ShowFavoriteGuideApi;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.menu.PopupWindow;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Timer;
import java.util.TimerTask;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static volatile b f8063i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public PopupWindow f8064a;

    /* renamed from: b  reason: collision with root package name */
    public Timer f8065b;

    /* renamed from: c  reason: collision with root package name */
    public SwanAppActivity f8066c;

    /* renamed from: d  reason: collision with root package name */
    public b.a.p0.a.h0.g.d f8067d;

    /* renamed from: e  reason: collision with root package name */
    public ContentObserver f8068e;

    /* renamed from: f  reason: collision with root package name */
    public b.a.p0.a.t0.a f8069f;

    /* renamed from: g  reason: collision with root package name */
    public b.a.p0.a.u.e.d.a f8070g;

    /* renamed from: h  reason: collision with root package name */
    public j f8071h;

    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShowFavoriteGuideApi.GuideType f8072e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f8073f;

        public a(b bVar, ShowFavoriteGuideApi.GuideType guideType) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, guideType};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8073f = bVar;
            this.f8072e = guideType;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f8073f.k();
                if (this.f8073f.f8071h != null) {
                    this.f8073f.f8071h.e(false);
                }
                ShowFavoriteGuideApi.y(this.f8072e, "flow_close_close", PrefetchEvent.STATE_CLICK);
            }
        }
    }

    /* renamed from: b.a.p0.a.u.e.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC0384b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShowFavoriteGuideApi.GuideType f8074e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Activity f8075f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b f8076g;

        /* renamed from: b.a.p0.a.u.e.d.b$b$a */
        /* loaded from: classes.dex */
        public class a implements a.h {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ View$OnClickListenerC0384b f8077a;

            public a(View$OnClickListenerC0384b view$OnClickListenerC0384b) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {view$OnClickListenerC0384b};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f8077a = view$OnClickListenerC0384b;
            }

            @Override // b.a.p0.a.j1.a.h
            public void onFail() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (this.f8077a.f8076g.f8071h != null) {
                        this.f8077a.f8076g.f8071h.e(false);
                    }
                    b.a.p0.a.e0.d.g("FavoriteGuideHelper", "add favorite result=false");
                }
            }

            @Override // b.a.p0.a.j1.a.h
            public void onSuccess() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    if (this.f8077a.f8076g.f8071h != null) {
                        this.f8077a.f8076g.f8071h.e(true);
                    }
                    b.a.p0.a.e0.d.g("FavoriteGuideHelper", "add favorite result=true");
                }
            }
        }

        public View$OnClickListenerC0384b(b bVar, ShowFavoriteGuideApi.GuideType guideType, Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, guideType, activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8076g = bVar;
            this.f8074e = guideType;
            this.f8075f = activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                b.a.p0.a.j1.a.h(this.f8075f, new a(this));
                this.f8076g.k();
                if (this.f8076g.f8065b != null) {
                    this.f8076g.f8065b.cancel();
                }
                ShowFavoriteGuideApi.GuideType guideType = this.f8074e;
                ShowFavoriteGuideApi.y(guideType, guideType == ShowFavoriteGuideApi.GuideType.WEAK ? "flow_add" : "flow_close_add", PrefetchEvent.STATE_CLICK);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ViewTreeObserver f8078e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.h0.g.g f8079f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.h0.g.f f8080g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f8081h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.a2.e f8082i;
        public final /* synthetic */ b j;

        public c(b bVar, ViewTreeObserver viewTreeObserver, b.a.p0.a.h0.g.g gVar, b.a.p0.a.h0.g.f fVar, String str, b.a.p0.a.a2.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, viewTreeObserver, gVar, fVar, str, eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.j = bVar;
            this.f8078e = viewTreeObserver;
            this.f8079f = gVar;
            this.f8080g = fVar;
            this.f8081h = str;
            this.f8082i = eVar;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            b.a.p0.a.h0.g.f fVar;
            ViewTreeObserver viewTreeObserver;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.j.f8064a != null || (viewTreeObserver = this.f8078e) == null || !viewTreeObserver.isAlive()) {
                    if (this.j.f8067d != this.f8079f.m() || (!((fVar = this.f8080g) == null || TextUtils.equals(this.f8081h, fVar.a3())) || (!this.f8082i.l0() && n0.G()))) {
                        this.j.k();
                        ViewTreeObserver viewTreeObserver2 = this.f8078e;
                        if (viewTreeObserver2 == null || !viewTreeObserver2.isAlive()) {
                            return;
                        }
                        this.f8078e.removeOnGlobalLayoutListener(this);
                        return;
                    }
                    return;
                }
                this.f8078e.removeOnGlobalLayoutListener(this);
            }
        }
    }

    /* loaded from: classes.dex */
    public class d extends TimerTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.a2.e f8083e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f8084f;

        public d(b bVar, b.a.p0.a.a2.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8084f = bVar;
            this.f8083e = eVar;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f8084f.k();
                if (this.f8084f.f8071h != null) {
                    this.f8084f.f8071h.e(b.a.p0.a.j0.b.a.n(this.f8083e.f3961f));
                }
                if (this.f8084f.f8065b != null) {
                    this.f8084f.f8065b.cancel();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements a.InterfaceC0383a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f8085a;

        public e(b bVar) {
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
            this.f8085a = bVar;
        }

        @Override // b.a.p0.a.u.e.d.a.InterfaceC0383a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f8085a.k();
            }
        }

        @Override // b.a.p0.a.u.e.d.a.InterfaceC0383a
        public void b(int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) && i2 == 1) {
                this.f8085a.k();
            }
        }
    }

    /* loaded from: classes.dex */
    public class f extends ContentObserver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.a2.e f8086a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ShowFavoriteGuideApi.GuideType f8087b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b f8088c;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ f f8089e;

            public a(f fVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f8089e = fVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && b.a.p0.a.j0.b.a.n(this.f8089e.f8086a.f3961f)) {
                    f fVar = this.f8089e;
                    if (fVar.f8087b == ShowFavoriteGuideApi.GuideType.NORMAL && fVar.f8088c.f8071h != null) {
                        this.f8089e.f8088c.f8071h.e(true);
                    }
                    this.f8089e.f8088c.k();
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(b bVar, Handler handler, b.a.p0.a.a2.e eVar, ShowFavoriteGuideApi.GuideType guideType) {
            super(handler);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, handler, eVar, guideType};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Handler) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8088c = bVar;
            this.f8086a = eVar;
            this.f8087b = guideType;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                super.onChange(z);
                q.g().execute(new a(this));
            }
        }
    }

    /* loaded from: classes.dex */
    public class g extends b.a.p0.a.t0.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.a2.e f8090a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f8091b;

        public g(b bVar, b.a.p0.a.a2.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8091b = bVar;
            this.f8090a = eVar;
        }

        @Override // b.a.p0.a.t0.a, b.a.p0.a.t0.b
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f8091b.f8064a != null && this.f8091b.f8064a.x()) {
                this.f8091b.k();
            }
        }

        @Override // b.a.p0.a.t0.a, b.a.p0.a.t0.b
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                b.a.p0.a.e0.d.g("FavoriteGuideHelper", "call onActivityDestroyed");
                this.f8091b.k();
                if (this.f8091b.f8066c == null || this.f8091b.f8069f == null) {
                    return;
                }
                this.f8091b.f8066c.unregisterCallback(this.f8091b.f8069f);
            }
        }

        @Override // b.a.p0.a.t0.a, b.a.p0.a.t0.b
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                super.e();
                b.a.p0.a.e0.d.g("FavoriteGuideHelper", "swanId=" + this.f8090a.f3961f + ", nowId=" + b.a.p0.a.a2.e.U());
                if (TextUtils.equals(this.f8090a.f3961f, b.a.p0.a.a2.e.U())) {
                    return;
                }
                this.f8091b.k();
            }
        }
    }

    /* loaded from: classes.dex */
    public class h implements d.m {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f8092a;

        public h(b bVar) {
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
            this.f8092a = bVar;
        }

        @Override // b.a.p0.a.h0.g.d.m
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f8092a.k();
            }
        }
    }

    /* loaded from: classes.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f8093e;

        public i(b bVar) {
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
            this.f8093e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f8093e.f8064a != null) {
                    this.f8093e.f8064a.r();
                    this.f8093e.f8064a = null;
                }
                if (this.f8093e.f8068e != null) {
                    AppRuntime.getAppContext().getContentResolver().unregisterContentObserver(this.f8093e.f8068e);
                    this.f8093e.f8068e = null;
                }
                if (this.f8093e.f8066c != null && this.f8093e.f8069f != null) {
                    this.f8093e.f8066c.unregisterCallback(this.f8093e.f8069f);
                }
                if (this.f8093e.f8067d != null) {
                    this.f8093e.f8067d.q2(null);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public interface j {
        void e(boolean z);
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static b l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            if (f8063i == null) {
                synchronized (b.class) {
                    if (f8063i == null) {
                        f8063i = new b();
                    }
                }
            }
            return f8063i;
        }
        return (b) invokeV.objValue;
    }

    @AnyThread
    public final synchronized void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this) {
                q0.b0(new i(this));
            }
        }
    }

    public final void m() {
        b.a.p0.a.p.b.a.i k;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f8070g == null && (k = b.a.p0.a.c1.b.k()) != null) {
            b.a.p0.a.u.e.d.a a2 = k.a();
            this.f8070g = a2;
            if (a2 != null) {
                a2.b(new e(this));
            }
        }
    }

    public boolean n(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) ? TextUtils.isEmpty(str) || ShowFavoriteGuideApi.GuideType.parse(str) == ShowFavoriteGuideApi.GuideType.NORMAL : invokeL.booleanValue;
    }

    public final synchronized void o(@NonNull Activity activity, @NonNull b.a.p0.a.a2.e eVar, ShowFavoriteGuideApi.GuideType guideType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, activity, eVar, guideType) == null) {
            synchronized (this) {
                this.f8068e = new f(this, null, eVar, guideType);
                AppRuntime.getAppContext().getContentResolver().registerContentObserver(b.a.p0.a.j0.b.a.d(), false, this.f8068e);
                if (activity instanceof SwanAppActivity) {
                    SwanAppActivity swanAppActivity = (SwanAppActivity) activity;
                    this.f8066c = swanAppActivity;
                    if (this.f8069f != null) {
                        swanAppActivity.unregisterCallback(this.f8069f);
                    }
                    g gVar = new g(this, eVar);
                    this.f8069f = gVar;
                    this.f8066c.registerCallback(gVar);
                }
                b.a.p0.a.h0.g.g swanAppFragmentManager = this.f8066c.getSwanAppFragmentManager();
                if (swanAppFragmentManager == null) {
                    return;
                }
                b.a.p0.a.h0.g.d m = swanAppFragmentManager.m();
                this.f8067d = m;
                if (m == null) {
                    return;
                }
                m.q2(new h(this));
            }
        }
    }

    @UiThread
    public void p(@Nullable j jVar, @NonNull Activity activity, @NonNull b.a.p0.a.a2.e eVar, @NonNull ShowFavoriteGuideApi.GuideType guideType, @Nullable String str, @Nullable String str2, long j2) {
        SwanAppActivity swanAppActivity;
        b.a.p0.a.h0.g.g swanAppFragmentManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{jVar, activity, eVar, guideType, str, str2, Long.valueOf(j2)}) == null) {
            String str3 = str;
            this.f8071h = jVar;
            k();
            if (eVar.l0()) {
                m();
                b.a.p0.a.u.e.d.a aVar = this.f8070g;
                if (aVar != null) {
                    aVar.c(0);
                }
            }
            o(activity, eVar, guideType);
            View inflate = LayoutInflater.from(activity).inflate(guideType == ShowFavoriteGuideApi.GuideType.TIPS ? b.a.p0.a.g.aiapps_favorite_guide_tips : b.a.p0.a.g.aiapps_favorite_guide_normal, (ViewGroup) null, false);
            TextView textView = (TextView) inflate.findViewById(b.a.p0.a.f.favorite_guide_content);
            if (textView != null && str3 != null) {
                if (guideType.limit != -1 && str.length() > guideType.limit) {
                    str3 = str3.substring(0, guideType.limit - 1) + "...";
                }
                textView.setText(str3);
            }
            View findViewById = activity.findViewById(b.a.p0.a.f.titlebar_right_menu_img);
            if (guideType != ShowFavoriteGuideApi.GuideType.TIPS) {
                RelativeLayout relativeLayout = (RelativeLayout) inflate.findViewById(b.a.p0.a.f.favorite_guide_container);
                ViewGroup.LayoutParams layoutParams = relativeLayout.getLayoutParams();
                int i2 = guideType.showWidth4px;
                int g2 = n0.g(7.0f);
                int o = n0.o(null);
                int i3 = g2 * 2;
                if (o - i2 < i3) {
                    i2 = o - i3;
                }
                layoutParams.width = i2;
                relativeLayout.setLayoutParams(layoutParams);
                q0.U((ImageView) inflate.findViewById(b.a.p0.a.f.favorite_guide_icon), str2, b.a.p0.a.e.aiapps_default_grey_icon);
                ImageView imageView = (ImageView) inflate.findViewById(b.a.p0.a.f.favorite_guide_close);
                if (guideType == ShowFavoriteGuideApi.GuideType.WEAK) {
                    imageView.setVisibility(8);
                } else {
                    imageView.setOnClickListener(new a(this, guideType));
                }
                ((Button) inflate.findViewById(b.a.p0.a.f.favorite_guide_add_btn)).setOnClickListener(new View$OnClickListenerC0384b(this, guideType, activity));
                PopupWindow popupWindow = new PopupWindow(inflate, -1, -2);
                this.f8064a = popupWindow;
                popupWindow.R(16);
                this.f8064a.U(activity.getWindow().getDecorView(), 81, 0, (int) n0.h(50.0f));
            } else if (findViewById != null) {
                int[] iArr = new int[2];
                findViewById.getLocationOnScreen(iArr);
                inflate.findViewById(b.a.p0.a.f.favorite_guide_arrow).setPadding(0, 0, ((n0.o(null) - iArr[0]) - (findViewById.getWidth() / 2)) - n0.g(7.0f), 0);
                this.f8064a = new PopupWindow(inflate, -2, -2);
                SwanAppActivity swanAppActivity2 = this.f8066c;
                if (swanAppActivity2 != null && !swanAppActivity2.isFinishing() && !this.f8066c.isDestroyed() && findViewById.isAttachedToWindow()) {
                    try {
                        this.f8064a.T(findViewById, 0, -n0.g(3.0f));
                    } catch (WindowManager.BadTokenException e2) {
                        if (k.f6397a) {
                            e2.printStackTrace();
                        }
                    }
                }
            }
            if ((guideType == ShowFavoriteGuideApi.GuideType.NORMAL || guideType == ShowFavoriteGuideApi.GuideType.TIPS) && (swanAppActivity = this.f8066c) != null && (swanAppFragmentManager = swanAppActivity.getSwanAppFragmentManager()) != null && findViewById != null) {
                b.a.p0.a.h0.g.f l = swanAppFragmentManager.l();
                String a3 = l == null ? "" : l.a3();
                ViewTreeObserver viewTreeObserver = findViewById.getViewTreeObserver();
                viewTreeObserver.addOnGlobalLayoutListener(new c(this, viewTreeObserver, swanAppFragmentManager, l, a3, eVar));
            }
            if (guideType == ShowFavoriteGuideApi.GuideType.TIPS || guideType == ShowFavoriteGuideApi.GuideType.WEAK) {
                Timer timer = this.f8065b;
                if (timer != null) {
                    timer.cancel();
                }
                Timer timer2 = new Timer();
                this.f8065b = timer2;
                timer2.schedule(new d(this, eVar), 1000 * j2);
            }
            ShowFavoriteGuideApi.y(guideType, "", "show");
        }
    }
}
