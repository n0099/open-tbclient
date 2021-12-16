package c.a.q0.a.u.e.c;

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
import c.a.q0.a.h0.g.d;
import c.a.q0.a.k;
import c.a.q0.a.k1.a;
import c.a.q0.a.u.e.c.a;
import c.a.q0.a.z2.n0;
import c.a.q0.a.z2.q;
import c.a.q0.a.z2.q0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.api.module.favorite.ShowFavoriteGuideApi;
import com.baidu.swan.menu.PopupWindow;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Timer;
import java.util.TimerTask;
/* loaded from: classes.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static volatile c f8414i;
    public transient /* synthetic */ FieldHolder $fh;
    public PopupWindow a;

    /* renamed from: b  reason: collision with root package name */
    public Timer f8415b;

    /* renamed from: c  reason: collision with root package name */
    public SwanAppActivity f8416c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.q0.a.h0.g.d f8417d;

    /* renamed from: e  reason: collision with root package name */
    public ContentObserver f8418e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.q0.a.t0.a f8419f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.q0.a.u.e.c.a f8420g;

    /* renamed from: h  reason: collision with root package name */
    public j f8421h;

    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShowFavoriteGuideApi.GuideType f8422e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f8423f;

        public a(c cVar, ShowFavoriteGuideApi.GuideType guideType) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, guideType};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8423f = cVar;
            this.f8422e = guideType;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f8423f.k();
                if (this.f8423f.f8421h != null) {
                    this.f8423f.f8421h.e(false);
                }
                ShowFavoriteGuideApi.F(this.f8422e, "flow_close_close", "click");
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShowFavoriteGuideApi.GuideType f8424e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Activity f8425f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c f8426g;

        /* loaded from: classes.dex */
        public class a implements a.h {
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

            @Override // c.a.q0.a.k1.a.h
            public void onFail() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (this.a.f8426g.f8421h != null) {
                        this.a.f8426g.f8421h.e(false);
                    }
                    c.a.q0.a.e0.d.i("FavoriteGuideHelper", "add favorite result=false");
                }
            }

            @Override // c.a.q0.a.k1.a.h
            public void onSuccess() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    if (this.a.f8426g.f8421h != null) {
                        this.a.f8426g.f8421h.e(true);
                    }
                    c.a.q0.a.e0.d.i("FavoriteGuideHelper", "add favorite result=true");
                }
            }
        }

        public b(c cVar, ShowFavoriteGuideApi.GuideType guideType, Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, guideType, activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8426g = cVar;
            this.f8424e = guideType;
            this.f8425f = activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.a.q0.a.k1.a.h(this.f8425f, new a(this));
                this.f8426g.k();
                if (this.f8426g.f8415b != null) {
                    this.f8426g.f8415b.cancel();
                }
                ShowFavoriteGuideApi.GuideType guideType = this.f8424e;
                ShowFavoriteGuideApi.F(guideType, guideType == ShowFavoriteGuideApi.GuideType.WEAK ? "flow_add" : "flow_close_add", "click");
            }
        }
    }

    /* renamed from: c.a.q0.a.u.e.c.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class ViewTreeObserver$OnGlobalLayoutListenerC0506c implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ViewTreeObserver f8427e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.a.h0.g.g f8428f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.a.h0.g.f f8429g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f8430h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.a.d2.e f8431i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ c f8432j;

        public ViewTreeObserver$OnGlobalLayoutListenerC0506c(c cVar, ViewTreeObserver viewTreeObserver, c.a.q0.a.h0.g.g gVar, c.a.q0.a.h0.g.f fVar, String str, c.a.q0.a.d2.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, viewTreeObserver, gVar, fVar, str, eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8432j = cVar;
            this.f8427e = viewTreeObserver;
            this.f8428f = gVar;
            this.f8429g = fVar;
            this.f8430h = str;
            this.f8431i = eVar;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            c.a.q0.a.h0.g.f fVar;
            ViewTreeObserver viewTreeObserver;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f8432j.a != null || (viewTreeObserver = this.f8427e) == null || !viewTreeObserver.isAlive()) {
                    if (this.f8432j.f8417d != this.f8428f.m() || (!((fVar = this.f8429g) == null || TextUtils.equals(this.f8430h, fVar.u3())) || (!this.f8431i.v0() && n0.K()))) {
                        this.f8432j.k();
                        ViewTreeObserver viewTreeObserver2 = this.f8427e;
                        if (viewTreeObserver2 == null || !viewTreeObserver2.isAlive()) {
                            return;
                        }
                        this.f8427e.removeOnGlobalLayoutListener(this);
                        return;
                    }
                    return;
                }
                this.f8427e.removeOnGlobalLayoutListener(this);
            }
        }
    }

    /* loaded from: classes.dex */
    public class d extends TimerTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.a.d2.e f8433e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f8434f;

        public d(c cVar, c.a.q0.a.d2.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8434f = cVar;
            this.f8433e = eVar;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f8434f.k();
                if (this.f8434f.f8421h != null) {
                    this.f8434f.f8421h.e(c.a.q0.a.j0.b.a.n(this.f8433e.f4925f));
                }
                if (this.f8434f.f8415b != null) {
                    this.f8434f.f8415b.cancel();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements a.InterfaceC0505a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public e(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // c.a.q0.a.u.e.c.a.InterfaceC0505a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.k();
            }
        }

        @Override // c.a.q0.a.u.e.c.a.InterfaceC0505a
        public void b(int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) && i2 == 1) {
                this.a.k();
            }
        }
    }

    /* loaded from: classes.dex */
    public class f extends ContentObserver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.q0.a.d2.e a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ShowFavoriteGuideApi.GuideType f8435b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f8436c;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ f f8437e;

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
                this.f8437e = fVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && c.a.q0.a.j0.b.a.n(this.f8437e.a.f4925f)) {
                    f fVar = this.f8437e;
                    if (fVar.f8435b == ShowFavoriteGuideApi.GuideType.NORMAL && fVar.f8436c.f8421h != null) {
                        this.f8437e.f8436c.f8421h.e(true);
                    }
                    this.f8437e.f8436c.k();
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(c cVar, Handler handler, c.a.q0.a.d2.e eVar, ShowFavoriteGuideApi.GuideType guideType) {
            super(handler);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, handler, eVar, guideType};
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
            this.f8436c = cVar;
            this.a = eVar;
            this.f8435b = guideType;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                super.onChange(z);
                q.h().execute(new a(this));
            }
        }
    }

    /* loaded from: classes.dex */
    public class g extends c.a.q0.a.t0.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.q0.a.d2.e a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f8438b;

        public g(c cVar, c.a.q0.a.d2.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8438b = cVar;
            this.a = eVar;
        }

        @Override // c.a.q0.a.t0.a, c.a.q0.a.t0.b
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f8438b.a != null && this.f8438b.a.x()) {
                this.f8438b.k();
            }
        }

        @Override // c.a.q0.a.t0.a, c.a.q0.a.t0.b
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                c.a.q0.a.e0.d.i("FavoriteGuideHelper", "call onActivityDestroyed");
                this.f8438b.k();
                if (this.f8438b.f8416c == null || this.f8438b.f8419f == null) {
                    return;
                }
                this.f8438b.f8416c.unregisterCallback(this.f8438b.f8419f);
            }
        }

        @Override // c.a.q0.a.t0.a, c.a.q0.a.t0.b
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                super.e();
                c.a.q0.a.e0.d.i("FavoriteGuideHelper", "swanId=" + this.a.f4925f + ", nowId=" + c.a.q0.a.d2.e.f0());
                if (TextUtils.equals(this.a.f4925f, c.a.q0.a.d2.e.f0())) {
                    return;
                }
                this.f8438b.k();
            }
        }
    }

    /* loaded from: classes.dex */
    public class h implements d.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public h(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // c.a.q0.a.h0.g.d.p
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.k();
            }
        }
    }

    /* loaded from: classes.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f8439e;

        public i(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8439e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f8439e.a != null) {
                    this.f8439e.a.r();
                    this.f8439e.a = null;
                }
                if (this.f8439e.f8418e != null) {
                    AppRuntime.getAppContext().getContentResolver().unregisterContentObserver(this.f8439e.f8418e);
                    this.f8439e.f8418e = null;
                }
                if (this.f8439e.f8416c != null && this.f8439e.f8419f != null) {
                    this.f8439e.f8416c.unregisterCallback(this.f8439e.f8419f);
                }
                if (this.f8439e.f8417d != null) {
                    this.f8439e.f8417d.G2(null);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public interface j {
        void e(boolean z);
    }

    public c() {
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

    public static c l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            if (f8414i == null) {
                synchronized (c.class) {
                    if (f8414i == null) {
                        f8414i = new c();
                    }
                }
            }
            return f8414i;
        }
        return (c) invokeV.objValue;
    }

    @AnyThread
    public final synchronized void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this) {
                q0.e0(new i(this));
            }
        }
    }

    public final void m() {
        c.a.q0.a.p.b.a.i k2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f8420g == null && (k2 = c.a.q0.a.c1.b.k()) != null) {
            c.a.q0.a.u.e.c.a a2 = k2.a();
            this.f8420g = a2;
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

    public final synchronized void o(@NonNull Activity activity, @NonNull c.a.q0.a.d2.e eVar, ShowFavoriteGuideApi.GuideType guideType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, activity, eVar, guideType) == null) {
            synchronized (this) {
                this.f8418e = new f(this, null, eVar, guideType);
                AppRuntime.getAppContext().getContentResolver().registerContentObserver(c.a.q0.a.j0.b.a.d(), false, this.f8418e);
                if (activity instanceof SwanAppActivity) {
                    SwanAppActivity swanAppActivity = (SwanAppActivity) activity;
                    this.f8416c = swanAppActivity;
                    if (this.f8419f != null) {
                        swanAppActivity.unregisterCallback(this.f8419f);
                    }
                    g gVar = new g(this, eVar);
                    this.f8419f = gVar;
                    this.f8416c.registerCallback(gVar);
                }
                c.a.q0.a.h0.g.g swanAppFragmentManager = this.f8416c.getSwanAppFragmentManager();
                if (swanAppFragmentManager == null) {
                    return;
                }
                c.a.q0.a.h0.g.d m = swanAppFragmentManager.m();
                this.f8417d = m;
                if (m == null) {
                    return;
                }
                m.G2(new h(this));
            }
        }
    }

    @UiThread
    public void p(@Nullable j jVar, @NonNull Activity activity, @NonNull c.a.q0.a.d2.e eVar, @NonNull ShowFavoriteGuideApi.GuideType guideType, @Nullable String str, @Nullable String str2, long j2) {
        SwanAppActivity swanAppActivity;
        c.a.q0.a.h0.g.g swanAppFragmentManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{jVar, activity, eVar, guideType, str, str2, Long.valueOf(j2)}) == null) {
            String str3 = str;
            this.f8421h = jVar;
            k();
            if (eVar.v0()) {
                m();
                c.a.q0.a.u.e.c.a aVar = this.f8420g;
                if (aVar != null) {
                    aVar.c(0);
                }
            }
            o(activity, eVar, guideType);
            View inflate = LayoutInflater.from(activity).inflate(guideType == ShowFavoriteGuideApi.GuideType.TIPS ? c.a.q0.a.g.aiapps_favorite_guide_tips : c.a.q0.a.g.aiapps_favorite_guide_normal, (ViewGroup) null, false);
            TextView textView = (TextView) inflate.findViewById(c.a.q0.a.f.favorite_guide_content);
            if (textView != null && str3 != null) {
                if (guideType.limit != -1 && str.length() > guideType.limit) {
                    str3 = str3.substring(0, guideType.limit - 1) + "...";
                }
                textView.setText(str3);
            }
            View findViewById = activity.findViewById(c.a.q0.a.f.titlebar_right_menu_img);
            if (guideType != ShowFavoriteGuideApi.GuideType.TIPS) {
                RelativeLayout relativeLayout = (RelativeLayout) inflate.findViewById(c.a.q0.a.f.favorite_guide_container);
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
                q0.X((ImageView) inflate.findViewById(c.a.q0.a.f.favorite_guide_icon), str2, c.a.q0.a.e.aiapps_default_grey_icon);
                ImageView imageView = (ImageView) inflate.findViewById(c.a.q0.a.f.favorite_guide_close);
                if (guideType == ShowFavoriteGuideApi.GuideType.WEAK) {
                    imageView.setVisibility(8);
                } else {
                    imageView.setOnClickListener(new a(this, guideType));
                }
                ((Button) inflate.findViewById(c.a.q0.a.f.favorite_guide_add_btn)).setOnClickListener(new b(this, guideType, activity));
                PopupWindow popupWindow = new PopupWindow(inflate, -1, -2);
                this.a = popupWindow;
                popupWindow.O(16);
                this.a.T(activity.getWindow().getDecorView(), 81, 0, (int) n0.h(50.0f));
            } else if (findViewById != null) {
                int[] iArr = new int[2];
                findViewById.getLocationOnScreen(iArr);
                inflate.findViewById(c.a.q0.a.f.favorite_guide_arrow).setPadding(0, 0, ((n0.o(null) - iArr[0]) - (findViewById.getWidth() / 2)) - n0.g(7.0f), 0);
                this.a = new PopupWindow(inflate, -2, -2);
                SwanAppActivity swanAppActivity2 = this.f8416c;
                if (swanAppActivity2 != null && !swanAppActivity2.isFinishing() && !this.f8416c.isDestroyed() && findViewById.isAttachedToWindow()) {
                    try {
                        this.a.S(findViewById, 0, -n0.g(3.0f));
                    } catch (WindowManager.BadTokenException e2) {
                        if (k.a) {
                            e2.printStackTrace();
                        }
                    }
                }
            }
            if ((guideType == ShowFavoriteGuideApi.GuideType.NORMAL || guideType == ShowFavoriteGuideApi.GuideType.TIPS) && (swanAppActivity = this.f8416c) != null && (swanAppFragmentManager = swanAppActivity.getSwanAppFragmentManager()) != null && findViewById != null) {
                c.a.q0.a.h0.g.f l = swanAppFragmentManager.l();
                String u3 = l == null ? "" : l.u3();
                ViewTreeObserver viewTreeObserver = findViewById.getViewTreeObserver();
                viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver$OnGlobalLayoutListenerC0506c(this, viewTreeObserver, swanAppFragmentManager, l, u3, eVar));
            }
            if (guideType == ShowFavoriteGuideApi.GuideType.TIPS || guideType == ShowFavoriteGuideApi.GuideType.WEAK) {
                Timer timer = this.f8415b;
                if (timer != null) {
                    timer.cancel();
                }
                Timer timer2 = new Timer();
                this.f8415b = timer2;
                timer2.schedule(new d(this, eVar), 1000 * j2);
            }
            ShowFavoriteGuideApi.F(guideType, "", "show");
        }
    }
}
