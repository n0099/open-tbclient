package c.a.r0.a.u.e.c;

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
import c.a.r0.a.h0.g.d;
import c.a.r0.a.k;
import c.a.r0.a.k1.a;
import c.a.r0.a.u.e.c.a;
import c.a.r0.a.z2.n0;
import c.a.r0.a.z2.q;
import c.a.r0.a.z2.q0;
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
    public static volatile c f9091i;
    public transient /* synthetic */ FieldHolder $fh;
    public PopupWindow a;

    /* renamed from: b  reason: collision with root package name */
    public Timer f9092b;

    /* renamed from: c  reason: collision with root package name */
    public SwanAppActivity f9093c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.r0.a.h0.g.d f9094d;

    /* renamed from: e  reason: collision with root package name */
    public ContentObserver f9095e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.r0.a.t0.a f9096f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.r0.a.u.e.c.a f9097g;

    /* renamed from: h  reason: collision with root package name */
    public j f9098h;

    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShowFavoriteGuideApi.GuideType f9099e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f9100f;

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
            this.f9100f = cVar;
            this.f9099e = guideType;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f9100f.k();
                if (this.f9100f.f9098h != null) {
                    this.f9100f.f9098h.e(false);
                }
                ShowFavoriteGuideApi.F(this.f9099e, "flow_close_close", "click");
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShowFavoriteGuideApi.GuideType f9101e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Activity f9102f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c f9103g;

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

            @Override // c.a.r0.a.k1.a.h
            public void onFail() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (this.a.f9103g.f9098h != null) {
                        this.a.f9103g.f9098h.e(false);
                    }
                    c.a.r0.a.e0.d.i("FavoriteGuideHelper", "add favorite result=false");
                }
            }

            @Override // c.a.r0.a.k1.a.h
            public void onSuccess() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    if (this.a.f9103g.f9098h != null) {
                        this.a.f9103g.f9098h.e(true);
                    }
                    c.a.r0.a.e0.d.i("FavoriteGuideHelper", "add favorite result=true");
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
            this.f9103g = cVar;
            this.f9101e = guideType;
            this.f9102f = activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.a.r0.a.k1.a.h(this.f9102f, new a(this));
                this.f9103g.k();
                if (this.f9103g.f9092b != null) {
                    this.f9103g.f9092b.cancel();
                }
                ShowFavoriteGuideApi.GuideType guideType = this.f9101e;
                ShowFavoriteGuideApi.F(guideType, guideType == ShowFavoriteGuideApi.GuideType.WEAK ? "flow_add" : "flow_close_add", "click");
            }
        }
    }

    /* renamed from: c.a.r0.a.u.e.c.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class ViewTreeObserver$OnGlobalLayoutListenerC0574c implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ViewTreeObserver f9104e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.h0.g.g f9105f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.h0.g.f f9106g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f9107h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.d2.e f9108i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ c f9109j;

        public ViewTreeObserver$OnGlobalLayoutListenerC0574c(c cVar, ViewTreeObserver viewTreeObserver, c.a.r0.a.h0.g.g gVar, c.a.r0.a.h0.g.f fVar, String str, c.a.r0.a.d2.e eVar) {
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
            this.f9109j = cVar;
            this.f9104e = viewTreeObserver;
            this.f9105f = gVar;
            this.f9106g = fVar;
            this.f9107h = str;
            this.f9108i = eVar;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            c.a.r0.a.h0.g.f fVar;
            ViewTreeObserver viewTreeObserver;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f9109j.a != null || (viewTreeObserver = this.f9104e) == null || !viewTreeObserver.isAlive()) {
                    if (this.f9109j.f9094d != this.f9105f.m() || (!((fVar = this.f9106g) == null || TextUtils.equals(this.f9107h, fVar.n3())) || (!this.f9108i.v0() && n0.K()))) {
                        this.f9109j.k();
                        ViewTreeObserver viewTreeObserver2 = this.f9104e;
                        if (viewTreeObserver2 == null || !viewTreeObserver2.isAlive()) {
                            return;
                        }
                        this.f9104e.removeOnGlobalLayoutListener(this);
                        return;
                    }
                    return;
                }
                this.f9104e.removeOnGlobalLayoutListener(this);
            }
        }
    }

    /* loaded from: classes.dex */
    public class d extends TimerTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.d2.e f9110e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f9111f;

        public d(c cVar, c.a.r0.a.d2.e eVar) {
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
            this.f9111f = cVar;
            this.f9110e = eVar;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f9111f.k();
                if (this.f9111f.f9098h != null) {
                    this.f9111f.f9098h.e(c.a.r0.a.j0.b.a.n(this.f9110e.f5679f));
                }
                if (this.f9111f.f9092b != null) {
                    this.f9111f.f9092b.cancel();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements a.InterfaceC0573a {
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

        @Override // c.a.r0.a.u.e.c.a.InterfaceC0573a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.k();
            }
        }

        @Override // c.a.r0.a.u.e.c.a.InterfaceC0573a
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
        public final /* synthetic */ c.a.r0.a.d2.e a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ShowFavoriteGuideApi.GuideType f9112b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f9113c;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ f f9114e;

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
                this.f9114e = fVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && c.a.r0.a.j0.b.a.n(this.f9114e.a.f5679f)) {
                    f fVar = this.f9114e;
                    if (fVar.f9112b == ShowFavoriteGuideApi.GuideType.NORMAL && fVar.f9113c.f9098h != null) {
                        this.f9114e.f9113c.f9098h.e(true);
                    }
                    this.f9114e.f9113c.k();
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(c cVar, Handler handler, c.a.r0.a.d2.e eVar, ShowFavoriteGuideApi.GuideType guideType) {
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
            this.f9113c = cVar;
            this.a = eVar;
            this.f9112b = guideType;
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
    public class g extends c.a.r0.a.t0.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.r0.a.d2.e a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f9115b;

        public g(c cVar, c.a.r0.a.d2.e eVar) {
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
            this.f9115b = cVar;
            this.a = eVar;
        }

        @Override // c.a.r0.a.t0.a, c.a.r0.a.t0.b
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f9115b.a != null && this.f9115b.a.x()) {
                this.f9115b.k();
            }
        }

        @Override // c.a.r0.a.t0.a, c.a.r0.a.t0.b
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                c.a.r0.a.e0.d.i("FavoriteGuideHelper", "call onActivityDestroyed");
                this.f9115b.k();
                if (this.f9115b.f9093c == null || this.f9115b.f9096f == null) {
                    return;
                }
                this.f9115b.f9093c.unregisterCallback(this.f9115b.f9096f);
            }
        }

        @Override // c.a.r0.a.t0.a, c.a.r0.a.t0.b
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                super.e();
                c.a.r0.a.e0.d.i("FavoriteGuideHelper", "swanId=" + this.a.f5679f + ", nowId=" + c.a.r0.a.d2.e.f0());
                if (TextUtils.equals(this.a.f5679f, c.a.r0.a.d2.e.f0())) {
                    return;
                }
                this.f9115b.k();
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

        @Override // c.a.r0.a.h0.g.d.p
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
        public final /* synthetic */ c f9116e;

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
            this.f9116e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f9116e.a != null) {
                    this.f9116e.a.r();
                    this.f9116e.a = null;
                }
                if (this.f9116e.f9095e != null) {
                    AppRuntime.getAppContext().getContentResolver().unregisterContentObserver(this.f9116e.f9095e);
                    this.f9116e.f9095e = null;
                }
                if (this.f9116e.f9093c != null && this.f9116e.f9096f != null) {
                    this.f9116e.f9093c.unregisterCallback(this.f9116e.f9096f);
                }
                if (this.f9116e.f9094d != null) {
                    this.f9116e.f9094d.z2(null);
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
            if (f9091i == null) {
                synchronized (c.class) {
                    if (f9091i == null) {
                        f9091i = new c();
                    }
                }
            }
            return f9091i;
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
        c.a.r0.a.p.b.a.i k;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f9097g == null && (k = c.a.r0.a.c1.b.k()) != null) {
            c.a.r0.a.u.e.c.a a2 = k.a();
            this.f9097g = a2;
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

    public final synchronized void o(@NonNull Activity activity, @NonNull c.a.r0.a.d2.e eVar, ShowFavoriteGuideApi.GuideType guideType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, activity, eVar, guideType) == null) {
            synchronized (this) {
                this.f9095e = new f(this, null, eVar, guideType);
                AppRuntime.getAppContext().getContentResolver().registerContentObserver(c.a.r0.a.j0.b.a.d(), false, this.f9095e);
                if (activity instanceof SwanAppActivity) {
                    SwanAppActivity swanAppActivity = (SwanAppActivity) activity;
                    this.f9093c = swanAppActivity;
                    if (this.f9096f != null) {
                        swanAppActivity.unregisterCallback(this.f9096f);
                    }
                    g gVar = new g(this, eVar);
                    this.f9096f = gVar;
                    this.f9093c.registerCallback(gVar);
                }
                c.a.r0.a.h0.g.g swanAppFragmentManager = this.f9093c.getSwanAppFragmentManager();
                if (swanAppFragmentManager == null) {
                    return;
                }
                c.a.r0.a.h0.g.d m = swanAppFragmentManager.m();
                this.f9094d = m;
                if (m == null) {
                    return;
                }
                m.z2(new h(this));
            }
        }
    }

    @UiThread
    public void p(@Nullable j jVar, @NonNull Activity activity, @NonNull c.a.r0.a.d2.e eVar, @NonNull ShowFavoriteGuideApi.GuideType guideType, @Nullable String str, @Nullable String str2, long j2) {
        SwanAppActivity swanAppActivity;
        c.a.r0.a.h0.g.g swanAppFragmentManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{jVar, activity, eVar, guideType, str, str2, Long.valueOf(j2)}) == null) {
            String str3 = str;
            this.f9098h = jVar;
            k();
            if (eVar.v0()) {
                m();
                c.a.r0.a.u.e.c.a aVar = this.f9097g;
                if (aVar != null) {
                    aVar.c(0);
                }
            }
            o(activity, eVar, guideType);
            View inflate = LayoutInflater.from(activity).inflate(guideType == ShowFavoriteGuideApi.GuideType.TIPS ? c.a.r0.a.g.aiapps_favorite_guide_tips : c.a.r0.a.g.aiapps_favorite_guide_normal, (ViewGroup) null, false);
            TextView textView = (TextView) inflate.findViewById(c.a.r0.a.f.favorite_guide_content);
            if (textView != null && str3 != null) {
                if (guideType.limit != -1 && str.length() > guideType.limit) {
                    str3 = str3.substring(0, guideType.limit - 1) + "...";
                }
                textView.setText(str3);
            }
            View findViewById = activity.findViewById(c.a.r0.a.f.titlebar_right_menu_img);
            if (guideType != ShowFavoriteGuideApi.GuideType.TIPS) {
                RelativeLayout relativeLayout = (RelativeLayout) inflate.findViewById(c.a.r0.a.f.favorite_guide_container);
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
                q0.X((ImageView) inflate.findViewById(c.a.r0.a.f.favorite_guide_icon), str2, c.a.r0.a.e.aiapps_default_grey_icon);
                ImageView imageView = (ImageView) inflate.findViewById(c.a.r0.a.f.favorite_guide_close);
                if (guideType == ShowFavoriteGuideApi.GuideType.WEAK) {
                    imageView.setVisibility(8);
                } else {
                    imageView.setOnClickListener(new a(this, guideType));
                }
                ((Button) inflate.findViewById(c.a.r0.a.f.favorite_guide_add_btn)).setOnClickListener(new b(this, guideType, activity));
                PopupWindow popupWindow = new PopupWindow(inflate, -1, -2);
                this.a = popupWindow;
                popupWindow.K(16);
                this.a.N(activity.getWindow().getDecorView(), 81, 0, (int) n0.h(50.0f));
            } else if (findViewById != null) {
                int[] iArr = new int[2];
                findViewById.getLocationOnScreen(iArr);
                inflate.findViewById(c.a.r0.a.f.favorite_guide_arrow).setPadding(0, 0, ((n0.o(null) - iArr[0]) - (findViewById.getWidth() / 2)) - n0.g(7.0f), 0);
                this.a = new PopupWindow(inflate, -2, -2);
                SwanAppActivity swanAppActivity2 = this.f9093c;
                if (swanAppActivity2 != null && !swanAppActivity2.isFinishing() && !this.f9093c.isDestroyed() && findViewById.isAttachedToWindow()) {
                    try {
                        this.a.M(findViewById, 0, -n0.g(3.0f));
                    } catch (WindowManager.BadTokenException e2) {
                        if (k.a) {
                            e2.printStackTrace();
                        }
                    }
                }
            }
            if ((guideType == ShowFavoriteGuideApi.GuideType.NORMAL || guideType == ShowFavoriteGuideApi.GuideType.TIPS) && (swanAppActivity = this.f9093c) != null && (swanAppFragmentManager = swanAppActivity.getSwanAppFragmentManager()) != null && findViewById != null) {
                c.a.r0.a.h0.g.f l = swanAppFragmentManager.l();
                String n3 = l == null ? "" : l.n3();
                ViewTreeObserver viewTreeObserver = findViewById.getViewTreeObserver();
                viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver$OnGlobalLayoutListenerC0574c(this, viewTreeObserver, swanAppFragmentManager, l, n3, eVar));
            }
            if (guideType == ShowFavoriteGuideApi.GuideType.TIPS || guideType == ShowFavoriteGuideApi.GuideType.WEAK) {
                Timer timer = this.f9092b;
                if (timer != null) {
                    timer.cancel();
                }
                Timer timer2 = new Timer();
                this.f9092b = timer2;
                timer2.schedule(new d(this, eVar), 1000 * j2);
            }
            ShowFavoriteGuideApi.F(guideType, "", "show");
        }
    }
}
