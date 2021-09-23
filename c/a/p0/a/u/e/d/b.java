package c.a.p0.a.u.e.d;

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
import c.a.p0.a.h0.g.d;
import c.a.p0.a.j1.a;
import c.a.p0.a.k;
import c.a.p0.a.u.e.d.a;
import c.a.p0.a.v2.n0;
import c.a.p0.a.v2.q;
import c.a.p0.a.v2.q0;
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
    public static volatile b f8800i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public PopupWindow f8801a;

    /* renamed from: b  reason: collision with root package name */
    public Timer f8802b;

    /* renamed from: c  reason: collision with root package name */
    public SwanAppActivity f8803c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.p0.a.h0.g.d f8804d;

    /* renamed from: e  reason: collision with root package name */
    public ContentObserver f8805e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.p0.a.t0.a f8806f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.p0.a.u.e.d.a f8807g;

    /* renamed from: h  reason: collision with root package name */
    public j f8808h;

    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShowFavoriteGuideApi.GuideType f8809e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f8810f;

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
            this.f8810f = bVar;
            this.f8809e = guideType;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f8810f.k();
                if (this.f8810f.f8808h != null) {
                    this.f8810f.f8808h.e(false);
                }
                ShowFavoriteGuideApi.z(this.f8809e, "flow_close_close", PrefetchEvent.STATE_CLICK);
            }
        }
    }

    /* renamed from: c.a.p0.a.u.e.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC0389b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShowFavoriteGuideApi.GuideType f8811e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Activity f8812f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b f8813g;

        /* renamed from: c.a.p0.a.u.e.d.b$b$a */
        /* loaded from: classes.dex */
        public class a implements a.h {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ View$OnClickListenerC0389b f8814a;

            public a(View$OnClickListenerC0389b view$OnClickListenerC0389b) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {view$OnClickListenerC0389b};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f8814a = view$OnClickListenerC0389b;
            }

            @Override // c.a.p0.a.j1.a.h
            public void onFail() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (this.f8814a.f8813g.f8808h != null) {
                        this.f8814a.f8813g.f8808h.e(false);
                    }
                    c.a.p0.a.e0.d.g("FavoriteGuideHelper", "add favorite result=false");
                }
            }

            @Override // c.a.p0.a.j1.a.h
            public void onSuccess() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    if (this.f8814a.f8813g.f8808h != null) {
                        this.f8814a.f8813g.f8808h.e(true);
                    }
                    c.a.p0.a.e0.d.g("FavoriteGuideHelper", "add favorite result=true");
                }
            }
        }

        public View$OnClickListenerC0389b(b bVar, ShowFavoriteGuideApi.GuideType guideType, Activity activity) {
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
            this.f8813g = bVar;
            this.f8811e = guideType;
            this.f8812f = activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.a.p0.a.j1.a.h(this.f8812f, new a(this));
                this.f8813g.k();
                if (this.f8813g.f8802b != null) {
                    this.f8813g.f8802b.cancel();
                }
                ShowFavoriteGuideApi.GuideType guideType = this.f8811e;
                ShowFavoriteGuideApi.z(guideType, guideType == ShowFavoriteGuideApi.GuideType.WEAK ? "flow_add" : "flow_close_add", PrefetchEvent.STATE_CLICK);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ViewTreeObserver f8815e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.h0.g.g f8816f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.h0.g.f f8817g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f8818h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.a2.e f8819i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ b f8820j;

        public c(b bVar, ViewTreeObserver viewTreeObserver, c.a.p0.a.h0.g.g gVar, c.a.p0.a.h0.g.f fVar, String str, c.a.p0.a.a2.e eVar) {
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
            this.f8820j = bVar;
            this.f8815e = viewTreeObserver;
            this.f8816f = gVar;
            this.f8817g = fVar;
            this.f8818h = str;
            this.f8819i = eVar;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            c.a.p0.a.h0.g.f fVar;
            ViewTreeObserver viewTreeObserver;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f8820j.f8801a != null || (viewTreeObserver = this.f8815e) == null || !viewTreeObserver.isAlive()) {
                    if (this.f8820j.f8804d != this.f8816f.m() || (!((fVar = this.f8817g) == null || TextUtils.equals(this.f8818h, fVar.e3())) || (!this.f8819i.m0() && n0.G()))) {
                        this.f8820j.k();
                        ViewTreeObserver viewTreeObserver2 = this.f8815e;
                        if (viewTreeObserver2 == null || !viewTreeObserver2.isAlive()) {
                            return;
                        }
                        this.f8815e.removeOnGlobalLayoutListener(this);
                        return;
                    }
                    return;
                }
                this.f8815e.removeOnGlobalLayoutListener(this);
            }
        }
    }

    /* loaded from: classes.dex */
    public class d extends TimerTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.a2.e f8821e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f8822f;

        public d(b bVar, c.a.p0.a.a2.e eVar) {
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
            this.f8822f = bVar;
            this.f8821e = eVar;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f8822f.k();
                if (this.f8822f.f8808h != null) {
                    this.f8822f.f8808h.e(c.a.p0.a.j0.b.a.n(this.f8821e.f4566f));
                }
                if (this.f8822f.f8802b != null) {
                    this.f8822f.f8802b.cancel();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements a.InterfaceC0388a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f8823a;

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
            this.f8823a = bVar;
        }

        @Override // c.a.p0.a.u.e.d.a.InterfaceC0388a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f8823a.k();
            }
        }

        @Override // c.a.p0.a.u.e.d.a.InterfaceC0388a
        public void b(int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) && i2 == 1) {
                this.f8823a.k();
            }
        }
    }

    /* loaded from: classes.dex */
    public class f extends ContentObserver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.a2.e f8824a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ShowFavoriteGuideApi.GuideType f8825b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b f8826c;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ f f8827e;

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
                this.f8827e = fVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && c.a.p0.a.j0.b.a.n(this.f8827e.f8824a.f4566f)) {
                    f fVar = this.f8827e;
                    if (fVar.f8825b == ShowFavoriteGuideApi.GuideType.NORMAL && fVar.f8826c.f8808h != null) {
                        this.f8827e.f8826c.f8808h.e(true);
                    }
                    this.f8827e.f8826c.k();
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(b bVar, Handler handler, c.a.p0.a.a2.e eVar, ShowFavoriteGuideApi.GuideType guideType) {
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
            this.f8826c = bVar;
            this.f8824a = eVar;
            this.f8825b = guideType;
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
    public class g extends c.a.p0.a.t0.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.a2.e f8828a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f8829b;

        public g(b bVar, c.a.p0.a.a2.e eVar) {
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
            this.f8829b = bVar;
            this.f8828a = eVar;
        }

        @Override // c.a.p0.a.t0.a, c.a.p0.a.t0.b
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f8829b.f8801a != null && this.f8829b.f8801a.x()) {
                this.f8829b.k();
            }
        }

        @Override // c.a.p0.a.t0.a, c.a.p0.a.t0.b
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                c.a.p0.a.e0.d.g("FavoriteGuideHelper", "call onActivityDestroyed");
                this.f8829b.k();
                if (this.f8829b.f8803c == null || this.f8829b.f8806f == null) {
                    return;
                }
                this.f8829b.f8803c.unregisterCallback(this.f8829b.f8806f);
            }
        }

        @Override // c.a.p0.a.t0.a, c.a.p0.a.t0.b
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                super.e();
                c.a.p0.a.e0.d.g("FavoriteGuideHelper", "swanId=" + this.f8828a.f4566f + ", nowId=" + c.a.p0.a.a2.e.V());
                if (TextUtils.equals(this.f8828a.f4566f, c.a.p0.a.a2.e.V())) {
                    return;
                }
                this.f8829b.k();
            }
        }
    }

    /* loaded from: classes.dex */
    public class h implements d.m {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f8830a;

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
            this.f8830a = bVar;
        }

        @Override // c.a.p0.a.h0.g.d.m
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f8830a.k();
            }
        }
    }

    /* loaded from: classes.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f8831e;

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
            this.f8831e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f8831e.f8801a != null) {
                    this.f8831e.f8801a.r();
                    this.f8831e.f8801a = null;
                }
                if (this.f8831e.f8805e != null) {
                    AppRuntime.getAppContext().getContentResolver().unregisterContentObserver(this.f8831e.f8805e);
                    this.f8831e.f8805e = null;
                }
                if (this.f8831e.f8803c != null && this.f8831e.f8806f != null) {
                    this.f8831e.f8803c.unregisterCallback(this.f8831e.f8806f);
                }
                if (this.f8831e.f8804d != null) {
                    this.f8831e.f8804d.u2(null);
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
            if (f8800i == null) {
                synchronized (b.class) {
                    if (f8800i == null) {
                        f8800i = new b();
                    }
                }
            }
            return f8800i;
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
        c.a.p0.a.p.b.a.i k;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f8807g == null && (k = c.a.p0.a.c1.b.k()) != null) {
            c.a.p0.a.u.e.d.a a2 = k.a();
            this.f8807g = a2;
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

    public final synchronized void o(@NonNull Activity activity, @NonNull c.a.p0.a.a2.e eVar, ShowFavoriteGuideApi.GuideType guideType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, activity, eVar, guideType) == null) {
            synchronized (this) {
                this.f8805e = new f(this, null, eVar, guideType);
                AppRuntime.getAppContext().getContentResolver().registerContentObserver(c.a.p0.a.j0.b.a.d(), false, this.f8805e);
                if (activity instanceof SwanAppActivity) {
                    SwanAppActivity swanAppActivity = (SwanAppActivity) activity;
                    this.f8803c = swanAppActivity;
                    if (this.f8806f != null) {
                        swanAppActivity.unregisterCallback(this.f8806f);
                    }
                    g gVar = new g(this, eVar);
                    this.f8806f = gVar;
                    this.f8803c.registerCallback(gVar);
                }
                c.a.p0.a.h0.g.g swanAppFragmentManager = this.f8803c.getSwanAppFragmentManager();
                if (swanAppFragmentManager == null) {
                    return;
                }
                c.a.p0.a.h0.g.d m = swanAppFragmentManager.m();
                this.f8804d = m;
                if (m == null) {
                    return;
                }
                m.u2(new h(this));
            }
        }
    }

    @UiThread
    public void p(@Nullable j jVar, @NonNull Activity activity, @NonNull c.a.p0.a.a2.e eVar, @NonNull ShowFavoriteGuideApi.GuideType guideType, @Nullable String str, @Nullable String str2, long j2) {
        SwanAppActivity swanAppActivity;
        c.a.p0.a.h0.g.g swanAppFragmentManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{jVar, activity, eVar, guideType, str, str2, Long.valueOf(j2)}) == null) {
            String str3 = str;
            this.f8808h = jVar;
            k();
            if (eVar.m0()) {
                m();
                c.a.p0.a.u.e.d.a aVar = this.f8807g;
                if (aVar != null) {
                    aVar.c(0);
                }
            }
            o(activity, eVar, guideType);
            View inflate = LayoutInflater.from(activity).inflate(guideType == ShowFavoriteGuideApi.GuideType.TIPS ? c.a.p0.a.g.aiapps_favorite_guide_tips : c.a.p0.a.g.aiapps_favorite_guide_normal, (ViewGroup) null, false);
            TextView textView = (TextView) inflate.findViewById(c.a.p0.a.f.favorite_guide_content);
            if (textView != null && str3 != null) {
                if (guideType.limit != -1 && str.length() > guideType.limit) {
                    str3 = str3.substring(0, guideType.limit - 1) + "...";
                }
                textView.setText(str3);
            }
            View findViewById = activity.findViewById(c.a.p0.a.f.titlebar_right_menu_img);
            if (guideType != ShowFavoriteGuideApi.GuideType.TIPS) {
                RelativeLayout relativeLayout = (RelativeLayout) inflate.findViewById(c.a.p0.a.f.favorite_guide_container);
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
                q0.U((ImageView) inflate.findViewById(c.a.p0.a.f.favorite_guide_icon), str2, c.a.p0.a.e.aiapps_default_grey_icon);
                ImageView imageView = (ImageView) inflate.findViewById(c.a.p0.a.f.favorite_guide_close);
                if (guideType == ShowFavoriteGuideApi.GuideType.WEAK) {
                    imageView.setVisibility(8);
                } else {
                    imageView.setOnClickListener(new a(this, guideType));
                }
                ((Button) inflate.findViewById(c.a.p0.a.f.favorite_guide_add_btn)).setOnClickListener(new View$OnClickListenerC0389b(this, guideType, activity));
                PopupWindow popupWindow = new PopupWindow(inflate, -1, -2);
                this.f8801a = popupWindow;
                popupWindow.R(16);
                this.f8801a.U(activity.getWindow().getDecorView(), 81, 0, (int) n0.h(50.0f));
            } else if (findViewById != null) {
                int[] iArr = new int[2];
                findViewById.getLocationOnScreen(iArr);
                inflate.findViewById(c.a.p0.a.f.favorite_guide_arrow).setPadding(0, 0, ((n0.o(null) - iArr[0]) - (findViewById.getWidth() / 2)) - n0.g(7.0f), 0);
                this.f8801a = new PopupWindow(inflate, -2, -2);
                SwanAppActivity swanAppActivity2 = this.f8803c;
                if (swanAppActivity2 != null && !swanAppActivity2.isFinishing() && !this.f8803c.isDestroyed() && findViewById.isAttachedToWindow()) {
                    try {
                        this.f8801a.T(findViewById, 0, -n0.g(3.0f));
                    } catch (WindowManager.BadTokenException e2) {
                        if (k.f7085a) {
                            e2.printStackTrace();
                        }
                    }
                }
            }
            if ((guideType == ShowFavoriteGuideApi.GuideType.NORMAL || guideType == ShowFavoriteGuideApi.GuideType.TIPS) && (swanAppActivity = this.f8803c) != null && (swanAppFragmentManager = swanAppActivity.getSwanAppFragmentManager()) != null && findViewById != null) {
                c.a.p0.a.h0.g.f l = swanAppFragmentManager.l();
                String e3 = l == null ? "" : l.e3();
                ViewTreeObserver viewTreeObserver = findViewById.getViewTreeObserver();
                viewTreeObserver.addOnGlobalLayoutListener(new c(this, viewTreeObserver, swanAppFragmentManager, l, e3, eVar));
            }
            if (guideType == ShowFavoriteGuideApi.GuideType.TIPS || guideType == ShowFavoriteGuideApi.GuideType.WEAK) {
                Timer timer = this.f8802b;
                if (timer != null) {
                    timer.cancel();
                }
                Timer timer2 = new Timer();
                this.f8802b = timer2;
                timer2.schedule(new d(this, eVar), 1000 * j2);
            }
            ShowFavoriteGuideApi.z(guideType, "", "show");
        }
    }
}
