package b.a.p0.a.h0.g;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.text.format.Formatter;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b.a.p0.a.f1.e.b;
import b.a.p0.a.h0.e.c;
import b.a.p0.a.h0.g.g;
import b.a.p0.a.r1.j;
import b.a.p0.a.v2.n0;
import b.a.p0.a.v2.q0;
import b.a.p0.a.v2.r0;
import b.a.p0.a.y1.a;
import b.a.p0.a.y1.b;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.UnitedSchemeMainDispatcher;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.console.property.SwanAppPropertyWindow;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.apps.favordata.SwanFavorDataManager;
import com.baidu.swan.apps.model.SwanAppBearInfo;
import com.baidu.swan.apps.relateswans.SwanAppRelatedSwanListAdapter;
import com.baidu.swan.apps.res.ui.BdBaseImageView;
import com.baidu.swan.apps.res.ui.FullScreenFloatView;
import com.baidu.swan.apps.res.widget.dialog.SwanAppAlertDialog;
import com.baidu.swan.apps.view.SwanAppRoundedImageView;
import com.baidu.swan.apps.view.SwanAppWebPopWindow;
import com.baidu.swan.pms.PMSConstants;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.swan.support.v4.app.FragmentActivity;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a extends b.a.p0.a.h0.g.d implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean N0;
    public transient /* synthetic */ FieldHolder $fh;
    public SwanAppRoundedImageView C0;
    public BdBaseImageView D0;
    public TextView E0;
    public b.a.p0.a.w2.a F0;
    public long[] G0;
    public String H0;
    public String I0;
    public String J0;
    public Button K0;
    public RecyclerView L0;
    public SwanAppWebPopWindow M0;

    /* renamed from: b.a.p0.a.h0.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0195a implements b.a.p0.d.i.a<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.k2.g.g f5186a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f5187b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f5188c;

        /* renamed from: b.a.p0.a.h0.g.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class DialogInterface$OnClickListenerC0196a implements DialogInterface.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public DialogInterface$OnClickListenerC0196a(C0195a c0195a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c0195a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                    SwanAppActivity x = b.a.p0.a.a2.d.g().x();
                    if (x != null && Build.VERSION.SDK_INT >= 21) {
                        x.finishAndRemoveTask();
                    }
                    System.exit(0);
                }
            }
        }

        public C0195a(a aVar, b.a.p0.a.k2.g.g gVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, gVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5188c = aVar;
            this.f5186a = gVar;
            this.f5187b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.d.i.a
        /* renamed from: a */
        public void run(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                if (bool != null && bool.booleanValue()) {
                    this.f5186a.putInt(this.f5187b, 1);
                } else {
                    this.f5186a.putInt(this.f5187b, 0);
                }
                SwanAppAlertDialog.a aVar = new SwanAppAlertDialog.a(this.f5188c.k0);
                aVar.U(b.a.p0.a.h.swan_offline_perf_tool_tip);
                aVar.v(b.a.p0.a.h.swan_offline_perf_tool_message);
                aVar.n(new b.a.p0.a.w2.h.a());
                aVar.O(b.a.p0.a.h.aiapps_confirm, new DialogInterface$OnClickListenerC0196a(this));
                aVar.X();
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.k2.g.g f5189e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f5190f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.d.i.a f5191g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ a f5192h;

        /* renamed from: b.a.p0.a.h0.g.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0197a implements c.b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f5193a;

            public C0197a(b bVar) {
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
                this.f5193a = bVar;
            }

            @Override // b.a.p0.a.h0.e.c.b
            public void a(boolean z, String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeZL(1048576, this, z, str) == null) {
                    if (z) {
                        this.f5193a.f5191g.run(Boolean.TRUE);
                        return;
                    }
                    Activity activity = this.f5193a.f5192h.k0;
                    if (activity == null || activity.isDestroyed()) {
                        return;
                    }
                    b.a.p0.a.h0.e.c.b(this.f5193a.f5192h.k0, b.a.p0.a.h.swan_offline_perf_tool_tip, str);
                }
            }
        }

        public b(a aVar, b.a.p0.a.k2.g.g gVar, String str, b.a.p0.d.i.a aVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, gVar, str, aVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5192h = aVar;
            this.f5189e = gVar;
            this.f5190f = str;
            this.f5191g = aVar2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                int i2 = this.f5189e.getInt(this.f5190f, -1);
                if (i2 == 1) {
                    this.f5191g.run(Boolean.FALSE);
                } else if (i2 == 0) {
                    this.f5191g.run(Boolean.TRUE);
                } else {
                    b.a.p0.a.a2.e P = b.a.p0.a.a2.e.P();
                    if (P == null) {
                        return;
                    }
                    b.a.p0.a.h0.e.c.a(P, this.f5192h.k0, new C0197a(this));
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View.OnLongClickListener f5194e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ View f5195f;

        public c(a aVar, View.OnLongClickListener onLongClickListener, View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, onLongClickListener, view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5194e = onLongClickListener;
            this.f5195f = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.a.p0.a.n2.l.b.a.d().g();
                this.f5194e.onLongClick(this.f5195f);
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Runnable f5196e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f5197f;

        public d(a aVar, Runnable runnable, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, runnable, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5196e = runnable;
            this.f5197f = j;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                int action = motionEvent.getAction();
                if (action == 0) {
                    view.postDelayed(this.f5196e, this.f5197f);
                    return false;
                } else if (action == 1 || action == 3) {
                    view.removeCallbacks(this.f5196e);
                    return false;
                } else {
                    return false;
                }
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes.dex */
    public class e implements b.InterfaceC0469b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SwanAppRelatedSwanListAdapter f5198a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f5199b;

        /* renamed from: b.a.p0.a.h0.g.a$e$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0198a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b.a.p0.a.y1.a f5200e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ e f5201f;

            public RunnableC0198a(e eVar, b.a.p0.a.y1.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar, aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f5201f = eVar;
                this.f5200e = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f5201f.f5199b.L0.setVisibility(0);
                    this.f5201f.f5198a.updateData(this.f5200e);
                }
            }
        }

        public e(a aVar, SwanAppRelatedSwanListAdapter swanAppRelatedSwanListAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, swanAppRelatedSwanListAdapter};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5199b = aVar;
            this.f5198a = swanAppRelatedSwanListAdapter;
        }

        @Override // b.a.p0.a.y1.b.InterfaceC0469b
        public void a(b.a.p0.a.y1.a aVar) {
            List<a.C0468a> list;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null || (list = aVar.f9086a) == null || list.size() <= 0) {
                return;
            }
            q0.b0(new RunnableC0198a(this, aVar));
            SwanAppRelatedSwanListAdapter.doUBCEventStatistic("aboutrelated", null, "show");
        }
    }

    /* loaded from: classes.dex */
    public class f implements c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f5202a;

        /* renamed from: b.a.p0.a.h0.g.a$f$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0199a implements b.a.p0.a.v2.e1.b<Boolean> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ f f5203e;

            public C0199a(f fVar) {
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
                this.f5203e = fVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // b.a.p0.a.v2.e1.b
            /* renamed from: a */
            public void onCallback(Boolean bool) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                    if (bool.booleanValue()) {
                        b.a.p0.a.e0.a.d(this.f5203e.f5202a.getContext());
                    } else {
                        b.a.p0.a.c1.b.h().a(this.f5203e.f5202a.k0, null);
                    }
                }
            }
        }

        public f(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5202a = aVar;
        }

        @Override // b.a.p0.a.h0.e.c.b
        public void a(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, str) == null) {
                if (!z) {
                    b.a.p0.a.h0.e.c.c(this.f5202a.k0, str);
                } else if (b.a.p0.a.e0.a.a()) {
                    b.a.p0.a.e0.a.d(this.f5202a.getContext());
                } else {
                    b.a.p0.a.c1.b.h().f(new C0199a(this));
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class g implements b.a.p0.a.q0.b.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f5204a;

        public g(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5204a = aVar;
        }

        @Override // b.a.p0.a.q0.b.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.a.p0.a.z1.b.f.e f2 = b.a.p0.a.z1.b.f.e.f(this.f5204a.getContext(), b.a.p0.a.h.swanapp_tip_net_unavailable);
                f2.l(2);
                f2.F();
            }
        }

        @Override // b.a.p0.a.q0.b.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                b.a.p0.a.z1.b.f.e f2 = b.a.p0.a.z1.b.f.e.f(this.f5204a.getContext(), b.a.p0.a.h.aiapps_cancel_fav_fail);
                f2.l(2);
                f2.F();
            }
        }

        @Override // b.a.p0.a.q0.b.b
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                b.a.p0.a.z1.b.f.e f2 = b.a.p0.a.z1.b.f.e.f(this.f5204a.getContext(), b.a.p0.a.h.aiapps_cancel_fav_success);
                f2.l(2);
                f2.F();
            }
        }
    }

    /* loaded from: classes.dex */
    public class h implements b.a.p0.a.q0.b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f5205a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f5206b;

        public h(a aVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5206b = aVar;
            this.f5205a = str;
        }

        @Override // b.a.p0.a.q0.b.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.a.p0.a.z1.b.f.e f2 = b.a.p0.a.z1.b.f.e.f(this.f5206b.getContext(), b.a.p0.a.h.swanapp_tip_net_unavailable);
                f2.l(2);
                f2.F();
            }
        }

        @Override // b.a.p0.a.q0.b.a
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                b.a.p0.a.z1.b.f.e f2 = b.a.p0.a.z1.b.f.e.f(this.f5206b.getContext(), b.a.p0.a.h.aiapps_fav_fail);
                f2.l(2);
                f2.F();
            }
        }

        @Override // b.a.p0.a.q0.b.a
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                b.a.p0.a.j0.b.a.t();
                if (b.a.p0.a.j1.a.k(this.f5206b.getActivity())) {
                    b.a.p0.a.j1.a.p("aboutconcern", this.f5205a);
                    return;
                }
                Context context = this.f5206b.getContext();
                b.a.p0.a.z1.b.f.e g2 = b.a.p0.a.z1.b.f.e.g(context, b.a.p0.a.c1.a.e0().f(context));
                g2.l(2);
                g2.p(2);
                g2.F();
            }
        }
    }

    /* loaded from: classes.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f5207e;

        public i(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5207e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f5207e.e3();
            }
        }
    }

    /* loaded from: classes.dex */
    public class j implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public FullScreenFloatView f5208e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f5209f;

        /* renamed from: b.a.p0.a.h0.g.a$j$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0200a implements b.a.p0.a.v2.e1.b<Boolean> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ j f5210e;

            public C0200a(j jVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {jVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f5210e = jVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // b.a.p0.a.v2.e1.b
            /* renamed from: a */
            public void onCallback(Boolean bool) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                    if (bool.booleanValue()) {
                        b.a.p0.a.e0.a.c(this.f5210e.f5209f.getContext(), true);
                    } else {
                        b.a.p0.a.c1.b.h().a(this.f5210e.f5209f.k0, null);
                    }
                }
            }
        }

        public j(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5209f = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f5209f.k0 == null) {
                return;
            }
            if (a.N0) {
                if (b.a.p0.a.h0.o.e.a.k(null)) {
                    b.a.p0.a.e0.a.d(this.f5209f.getContext());
                    return;
                }
                if (this.f5208e == null) {
                    this.f5208e = b.a.p0.a.g1.f.T().m(this.f5209f.k0);
                }
                if (this.f5209f.O1()) {
                    if (b.a.p0.a.e0.a.a()) {
                        b.a.p0.a.e0.a.c(this.f5209f.getContext(), false);
                        return;
                    } else {
                        b.a.p0.a.c1.b.h().f(new C0200a(this));
                        return;
                    }
                }
                this.f5208e.setVisibility(this.f5208e.getVisibility() == 0 ? 8 : 0);
            } else if (this.f5209f.O1()) {
                this.f5209f.f3();
            } else {
                b.a.p0.a.e0.a.d(this.f5209f.getContext());
            }
        }
    }

    /* loaded from: classes.dex */
    public class k implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public SwanAppPropertyWindow f5211e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f5212f;

        public k(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5212f = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f5211e == null) {
                    this.f5211e = b.a.p0.a.g1.f.T().J(this.f5212f.k0);
                }
                this.f5211e.setVisibility(this.f5211e.getVisibility() == 0 ? 8 : 0);
            }
        }
    }

    /* loaded from: classes.dex */
    public class l implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.f1.e.b f5213e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.a2.e f5214f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f5215g;

        /* renamed from: b.a.p0.a.h0.g.a$l$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class DialogInterface$OnClickListenerC0201a implements DialogInterface.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public DialogInterface$OnClickListenerC0201a(l lVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {lVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                }
            }
        }

        public l(a aVar, b.a.p0.a.f1.e.b bVar, b.a.p0.a.a2.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, bVar, eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5215g = aVar;
            this.f5213e = bVar;
            this.f5214f = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f5215g.k0 == null) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("ENABLE V8: ");
            sb.append(b.a.p0.a.h0.u.g.M().g0());
            sb.append(StringUtils.LF);
            sb.append("APS VERSION: ");
            sb.append(TextUtils.isEmpty(this.f5213e.s1()) ? "" : this.f5213e.s1());
            sb.append(StringUtils.LF);
            sb.append("APPID VERSION: ");
            sb.append(b.a.p0.a.v.a.c(this.f5214f.f3961f));
            sb.append(StringUtils.LF);
            String formatFileSize = Formatter.formatFileSize(AppRuntime.getAppContext(), this.f5213e.f1());
            sb.append("小程序包大小: ");
            sb.append(TextUtils.isEmpty(formatFileSize) ? "" : formatFileSize);
            sb.append("(");
            sb.append(this.f5213e.f1());
            sb.append(SmallTailInfo.EMOTION_SUFFIX);
            sb.append(StringUtils.LF);
            SwanAppAlertDialog.a aVar = new SwanAppAlertDialog.a(this.f5215g.k0);
            aVar.V(this.f5215g.k0.getResources().getString(b.a.p0.a.h.aiapps_show_ext_info_title));
            aVar.x(sb.toString());
            aVar.n(new b.a.p0.a.w2.h.a());
            aVar.m(false);
            aVar.O(b.a.p0.a.h.aiapps_confirm, new DialogInterface$OnClickListenerC0201a(this));
            aVar.X();
        }
    }

    /* loaded from: classes.dex */
    public class m implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f5216e;

        /* renamed from: b.a.p0.a.h0.g.a$m$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class DialogInterface$OnClickListenerC0202a implements DialogInterface.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public DialogInterface$OnClickListenerC0202a(m mVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {mVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                }
            }
        }

        public m(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5216e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f5216e.k0 == null) {
                return;
            }
            String e2 = b.a.p0.a.m2.a.c().e(1);
            String string = this.f5216e.k0.getResources().getString(b.a.p0.a.h.ai_games_debug_game_core_version);
            SwanAppAlertDialog.a aVar = new SwanAppAlertDialog.a(this.f5216e.k0);
            aVar.V(string);
            aVar.x(e2);
            aVar.n(new b.a.p0.a.w2.h.a());
            aVar.m(false);
            aVar.O(b.a.p0.a.h.aiapps_confirm, new DialogInterface$OnClickListenerC0202a(this));
            aVar.X();
        }
    }

    /* loaded from: classes.dex */
    public class n implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f5217e;

        /* renamed from: b.a.p0.a.h0.g.a$n$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0203a extends j.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ n f5218a;

            /* renamed from: b.a.p0.a.h0.g.a$n$a$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public class RunnableC0204a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ String f5219e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ C0203a f5220f;

                public RunnableC0204a(C0203a c0203a, String str) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {c0203a, str};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f5220f = c0203a;
                    this.f5219e = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        SwanAppAlertDialog.a aVar = new SwanAppAlertDialog.a(this.f5220f.f5218a.f5217e.k0);
                        aVar.U(b.a.p0.a.h.aiapps_debug_report_performance);
                        aVar.x(this.f5219e);
                        aVar.n(new b.a.p0.a.w2.h.a());
                        aVar.m(false);
                        aVar.O(b.a.p0.a.h.aiapps_confirm, null);
                        aVar.X();
                    }
                }
            }

            public C0203a(n nVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {nVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f5218a = nVar;
            }

            @Override // b.a.p0.a.r1.j.a
            public void c(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    this.f5218a.f5217e.k0.runOnUiThread(new RunnableC0204a(this, str));
                }
            }
        }

        public n(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5217e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f5217e.k0 == null) {
                return;
            }
            b.a.p0.a.r1.j.e().g(new C0203a(this));
        }
    }

    /* loaded from: classes.dex */
    public class o implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public b.a.p0.a.e0.h.a f5221e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f5222f;

        /* renamed from: b.a.p0.a.h0.g.a$o$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class DialogInterface$OnClickListenerC0205a implements DialogInterface.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ o f5223e;

            public DialogInterface$OnClickListenerC0205a(o oVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {oVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f5223e = oVar;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                    b.a.p0.a.e0.h.a.g(1);
                    this.f5223e.f5221e = new b.a.p0.a.e0.h.a(b.a.p0.a.c1.a.b());
                    this.f5223e.f5221e.h();
                }
            }
        }

        /* loaded from: classes.dex */
        public class b implements DialogInterface.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ o f5224e;

            public b(o oVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {oVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f5224e = oVar;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                    this.f5224e.b();
                    b.a.p0.a.e0.h.a.g(2);
                    System.exit(0);
                }
            }
        }

        /* loaded from: classes.dex */
        public class c implements DialogInterface.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ o f5225e;

            public c(o oVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {oVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f5225e = oVar;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                    this.f5225e.b();
                    b.a.p0.a.e0.h.a.g(0);
                }
            }
        }

        public o(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5222f = aVar;
        }

        public final void b() {
            b.a.p0.a.e0.h.a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (aVar = this.f5221e) == null) {
                return;
            }
            aVar.i();
            this.f5221e = null;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
                SwanAppAlertDialog.a aVar = new SwanAppAlertDialog.a(this.f5222f.k0);
                aVar.U(b.a.p0.a.h.aiapps_debug_start_inspect);
                aVar.v(b.a.p0.a.h.aiapps_debug_inspect_message);
                aVar.n(new b.a.p0.a.w2.h.a());
                aVar.m(true);
                if (b.a.p0.a.e0.h.a.e() == 0) {
                    aVar.O(b.a.p0.a.h.aiapps_debug_inspect_normal, new DialogInterface$OnClickListenerC0205a(this));
                }
                if (b.a.p0.a.e0.h.a.e() != 2) {
                    aVar.H(b.a.p0.a.h.aiapps_debug_inspect_enhance, new b(this));
                }
                if (b.a.p0.a.e0.h.a.e() != 0) {
                    aVar.B(b.a.p0.a.h.swanapp_close, new c(this));
                }
                aVar.X();
            }
        }
    }

    /* loaded from: classes.dex */
    public class p implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f5226e;

        public p(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5226e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f5226e.J2();
                this.f5226e.Q2(PrefetchEvent.STATE_CLICK, "baozhang");
            }
        }
    }

    /* loaded from: classes.dex */
    public class q implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f5227e;

        public q(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5227e = aVar;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                this.f5227e.M2();
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1597402835, "Lb/a/p0/a/h0/g/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1597402835, "Lb/a/p0/a/h0/g/a;");
                return;
            }
        }
        N0 = b.a.p0.a.k.f6397a;
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.G0 = new long[5];
    }

    public static a X2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? new a() : (a) invokeV.objValue;
    }

    @Override // b.a.p0.a.h0.g.d
    public boolean I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @NonNull
    public final String I2(@NonNull String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) {
            if (TextUtils.isEmpty(str2)) {
                return str;
            }
            if (str.endsWith(File.separator)) {
                str = str.substring(0, str.length() - 1);
            }
            if (str2.startsWith(File.separator)) {
                str2 = str2.substring(1);
            }
            return str + File.separator + str2;
        }
        return (String) invokeLL.objValue;
    }

    public final void J2() {
        SwanAppActivity activity;
        b.a.p0.a.a2.e P;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (activity = b.a.p0.a.g1.f.T().getActivity()) == null || (P = b.a.p0.a.a2.e.P()) == null) {
            return;
        }
        SwanAppWebPopWindow swanAppWebPopWindow = this.M0;
        if (swanAppWebPopWindow == null || !swanAppWebPopWindow.x()) {
            SwanAppWebPopWindow swanAppWebPopWindow2 = new SwanAppWebPopWindow(activity, "https://baozhang.baidu.com/guarantee/baoshowdetail?appkey=" + P.k());
            this.M0 = swanAppWebPopWindow2;
            swanAppWebPopWindow2.x0(b.a.p0.a.h.swan_app_baidu_guarantee_title);
            swanAppWebPopWindow2.t0(SwanAppWebPopWindow.CloseStyle.CLOSE_AT_BOTTOM);
            swanAppWebPopWindow2.u0();
            swanAppWebPopWindow2.s0();
            swanAppWebPopWindow2.z0();
        }
    }

    @Override // b.a.p0.a.h0.g.d
    public void K1(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            L1(view);
            if (!O1()) {
                t2(false);
            }
            l2(true);
            f2(-1);
            n2(-16777216);
            h2(null);
            j2(true);
        }
    }

    public final void K2() {
        SwanAppActivity activity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (activity = b.a.p0.a.g1.f.T().getActivity()) == null || b.a.p0.a.a2.e.P() == null) {
            return;
        }
        SwanAppWebPopWindow swanAppWebPopWindow = this.M0;
        if (swanAppWebPopWindow == null || !swanAppWebPopWindow.x()) {
            SwanAppWebPopWindow swanAppWebPopWindow2 = new SwanAppWebPopWindow(activity, this.J0);
            this.M0 = swanAppWebPopWindow2;
            swanAppWebPopWindow2.y0(P(b.a.p0.a.h.swan_app_service_agreement));
            swanAppWebPopWindow2.v0(activity.getResources().getDimensionPixelSize(b.a.p0.a.d.swan_half_screen_evalute_height));
            swanAppWebPopWindow2.t0(SwanAppWebPopWindow.CloseStyle.CLOSE_AT_RIGHT);
            swanAppWebPopWindow2.s0();
            swanAppWebPopWindow2.z0();
            Q2(PrefetchEvent.STATE_CLICK, "servicenote");
        }
    }

    public final void L2() {
        b.a.p0.a.a2.e P;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (P = b.a.p0.a.a2.e.P()) == null) {
            return;
        }
        b.a K = P.K();
        String I = K.I();
        String E = K.E();
        if (!TextUtils.isEmpty(I) && !TextUtils.isEmpty(E)) {
            String h2 = q0.h(I, E);
            UnitedSchemeMainDispatcher unitedSchemeMainDispatcher = new UnitedSchemeMainDispatcher();
            unitedSchemeMainDispatcher.setDynamicDispatcher("swanAPI", new b.a.p0.a.c2.e());
            UnitedSchemeEntity unitedSchemeEntity = new UnitedSchemeEntity(Uri.parse(h2), UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE);
            unitedSchemeEntity.setOnlyVerify(false);
            unitedSchemeMainDispatcher.dispatch(this.k0, unitedSchemeEntity);
            boolean z = N0;
            return;
        }
        boolean z2 = N0;
    }

    public final void M2() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.k0 == null) {
            return;
        }
        String str = b.a.p0.a.a2.d.g().r().K().e0().webUrl;
        if (TextUtils.isEmpty(str)) {
            r0.b(this.k0).c("");
            b.a.p0.a.z1.b.f.e.f(this.k0, b.a.p0.a.h.swanapp_web_url_copy_fail).F();
            return;
        }
        String I2 = I2(str, b.a.p0.a.l1.b.b(q0.n()));
        int i2 = b.a.p0.a.h.swanapp_web_url_copy_success;
        if (I2.length() > PluginCenter.PLUGIN_RETRY_MIN_TIME_INTERVAL) {
            i2 = b.a.p0.a.h.swanapp_web_url_param_to_long;
        } else {
            str = I2;
        }
        r0.b(this.k0).c(str);
        b.a.p0.a.z1.b.f.e.f(this.k0, i2).F();
    }

    public final void N2() {
        SwanAppWebPopWindow swanAppWebPopWindow;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && a0() && (swanAppWebPopWindow = this.M0) != null) {
            swanAppWebPopWindow.r();
        }
    }

    public final void O2(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            if (b.a.p0.a.u1.a.a.G()) {
                boolean z = N0;
                b.a.p0.a.z1.b.f.e.f(getContext(), b.a.p0.a.h.aiapps_debug_forbid_favor).F();
                return;
            }
            String f2 = q0.n().f();
            SwanFavorDataManager.h().b(str, new h(this, f2));
            b.a.p0.a.j1.a.p("aboutconcern", f2);
        }
    }

    public final void P2(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            SwanFavorDataManager h2 = SwanFavorDataManager.h();
            g gVar = new g(this);
            b.a.p0.a.n0.l.c l2 = b.a.p0.a.n0.l.c.l();
            l2.n(3);
            h2.c(str, gVar, l2.k());
            Q2(PrefetchEvent.STATE_CLICK, "aboutmove");
        }
    }

    public final void Q2(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, str, str2) == null) {
            b.a.p0.a.j2.p.f fVar = new b.a.p0.a.j2.p.f();
            if (!TextUtils.isEmpty(str)) {
                fVar.f6384b = str;
            }
            if (!TextUtils.isEmpty(str2)) {
                fVar.f6387e = str2;
            }
            s1(fVar);
        }
    }

    @Override // b.a.p0.a.h0.g.d
    public boolean R1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void R2(@NonNull View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, view) == null) {
            String b2 = b.a.p0.a.h0.g.b.b();
            b.a.p0.a.k2.g.g a2 = b.a.p0.a.h0.g.b.a();
            Button button = (Button) view.findViewById(b.a.p0.a.f.btn_ues_offline_perftool);
            button.setVisibility(0);
            if (a2.getInt(b2, -1) == 1) {
                button.setText(b.a.p0.a.h.swan_offline_perf_tool_disable);
            } else {
                button.setText(b.a.p0.a.h.swan_offline_perf_tool_enable);
            }
            button.setOnClickListener(new b(this, a2, b2, new C0195a(this, a2, b2)));
        }
    }

    public final void S2(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            n0.J(this.D0, this.E0, String.valueOf(i2));
        }
    }

    @Override // b.a.p0.a.h0.g.d
    public boolean T1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void T2() {
        FragmentActivity activity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && (activity = getActivity()) != null && this.o0 == null) {
            b.a.p0.k.n nVar = new b.a.p0.k.n(activity, this.n0, 13, b.a.p0.a.c1.a.G(), new b.a.p0.a.w2.h.b());
            this.o0 = nVar;
            nVar.n(q0.O());
            new b.a.p0.a.j1.a(this.o0, this).z();
        }
    }

    public final void U2(View view) {
        b.a.p0.a.a2.e P;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, view) == null) || (P = b.a.p0.a.a2.e.P()) == null || P.K() == null) {
            return;
        }
        b.a K = P.K();
        this.C0 = (SwanAppRoundedImageView) view.findViewById(b.a.p0.a.f.aiapps_icon);
        TextView textView = (TextView) view.findViewById(b.a.p0.a.f.aiapps_title);
        textView.setText(K.J());
        if (K.F() == 0) {
            b.a.p0.a.w2.f.a(textView, new i(this));
        }
        b.a.p0.a.r1.k.f.j().n().h(textView);
        TextView textView2 = (TextView) view.findViewById(b.a.p0.a.f.aiapps_description);
        textView2.setText(K.b1());
        Button button = (Button) view.findViewById(b.a.p0.a.f.share_friends);
        button.setOnClickListener(this);
        Button button2 = (Button) view.findViewById(b.a.p0.a.f.add_favor);
        this.K0 = button2;
        button2.setOnClickListener(this);
        g3();
        b.a.p0.a.h0.g.g U = b.a.p0.a.g1.f.T().U();
        if (U == null) {
            return;
        }
        if (U.n(b.a.p0.a.c1.b.c().a()) != null) {
            button.setVisibility(8);
            this.K0.setVisibility(8);
        }
        b.a.p0.q.d.b().a(textView2);
        ((TextView) view.findViewById(b.a.p0.a.f.service_category_value)).setText(K.p1());
        ((TextView) view.findViewById(b.a.p0.a.f.subject_info_value)).setText(K.q1());
        String D = b.a.p0.a.c1.a.n().D();
        this.J0 = D;
        if (!TextUtils.isEmpty(D)) {
            View findViewById = view.findViewById(b.a.p0.a.f.agreement_layout);
            findViewById.setVisibility(0);
            findViewById.setOnClickListener(this);
        }
        this.L0 = (RecyclerView) view.findViewById(b.a.p0.a.f.related_swan_app_list);
        PMSAppInfo e0 = K.e0();
        if (W2(e0)) {
            b3(view, e0.brandsInfo);
        }
        this.E0 = (TextView) view.findViewById(b.a.p0.a.f.aiapps_label_tv);
        this.D0 = (BdBaseImageView) view.findViewById(b.a.p0.a.f.aiapps_label_bg);
        this.C0.setImageBitmap(q0.i(K, "SwanAppAboutFragment", false));
        this.C0.setOnClickListener(this);
        SwanAppBearInfo h1 = K.h1();
        if (h1 != null && h1.isValid()) {
            this.F0 = new b.a.p0.a.w2.a(this.k0, view, h1, b.a.p0.a.f.bear_layout);
        }
        S2(K.getType());
        ((Button) view.findViewById(b.a.p0.a.f.open_app_button)).setVisibility(8);
        if (N0 || b.a.p0.a.g1.f.T().M()) {
            View inflate = ((ViewStub) view.findViewById(b.a.p0.a.f.ai_app_console)).inflate();
            if (O1() && (inflate instanceof Button)) {
                ((Button) inflate).setText(K.k0() ? b.a.p0.a.h.aiapps_close_debug_mode : b.a.p0.a.h.aiapps_open_debug_mode);
            }
            inflate.setOnClickListener(new j(this));
            if (!O1()) {
                ((ViewStub) view.findViewById(b.a.p0.a.f.ai_app_property)).inflate().setOnClickListener(new k(this));
            }
            if (O1()) {
                ((ViewStub) view.findViewById(b.a.p0.a.f.ai_app_show_ext_info)).inflate().setOnClickListener(new l(this, K, P));
            }
            if (O1()) {
                View inflate2 = ((ViewStub) view.findViewById(b.a.p0.a.f.ai_app_swan_core_history_info)).inflate();
                if (inflate2 instanceof Button) {
                    Button button3 = (Button) inflate2;
                    button3.setText(b.a.p0.a.h.ai_games_debug_game_core_version);
                    button3.setOnClickListener(new m(this));
                }
            }
            if (b.a.p0.a.r1.j.e().f()) {
                View inflate3 = ((ViewStub) view.findViewById(b.a.p0.a.f.ai_app_report_performance)).inflate();
                if (inflate3 instanceof Button) {
                    Button button4 = (Button) inflate3;
                    button4.setText(b.a.p0.a.h.aiapps_debug_report_performance);
                    button4.setOnClickListener(new n(this));
                }
            }
            View inflate4 = ((ViewStub) view.findViewById(b.a.p0.a.f.ai_app_start_inspector)).inflate();
            if (inflate4 instanceof Button) {
                ((Button) inflate4).setText(b.a.p0.a.h.aiapps_debug_start_inspect);
            }
            inflate4.setOnClickListener(new o(this));
            if (!O1()) {
                R2(view);
            }
        }
        if (V2(e0)) {
            ImageView imageView = (ImageView) view.findViewById(b.a.p0.a.f.apply_guarantee);
            imageView.setVisibility(0);
            imageView.setOnClickListener(new p(this));
        }
        if (O1()) {
            return;
        }
        Z2(this.C0, 2000L, new q(this));
    }

    public final boolean V2(PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, pMSAppInfo)) == null) {
            return (pMSAppInfo == null ? PMSConstants.PayProtected.NO_PAY_PROTECTED.type : pMSAppInfo.payProtected) == PMSConstants.PayProtected.PAY_PROTECTED.type;
        }
        return invokeL.booleanValue;
    }

    public final boolean W2(PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, pMSAppInfo)) == null) ? (b.a.p0.a.a2.d.g().l() != 0 || pMSAppInfo == null || TextUtils.isEmpty(pMSAppInfo.brandsInfo)) ? false : true : invokeL.booleanValue;
    }

    @Override // b.a.p0.a.h0.g.d
    public void Y1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048595, this) == null) && O1()) {
            T2();
            this.o0.p(b.a.p0.a.c1.a.H().a());
        }
    }

    public final void Y2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            String k2 = b.a.p0.a.a2.d.g().r().k();
            if (TextUtils.isEmpty(k2)) {
                return;
            }
            if (b.a.p0.a.j0.b.a.n(k2)) {
                P2(k2);
            } else {
                O2(k2);
            }
            g3();
        }
    }

    public final void Z2(View view, long j2, View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{view, Long.valueOf(j2), onLongClickListener}) == null) || view == null || onLongClickListener == null || j2 <= 0) {
            return;
        }
        view.setOnTouchListener(new d(this, new c(this, onLongClickListener, view), j2));
    }

    public final void a3() {
        b.a.p0.a.a2.e P;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048598, this) == null) || (P = b.a.p0.a.a2.e.P()) == null) {
            return;
        }
        long[] jArr = this.G0;
        System.arraycopy(jArr, 1, jArr, 0, jArr.length - 1);
        long[] jArr2 = this.G0;
        jArr2[jArr2.length - 1] = SystemClock.uptimeMillis();
        if (this.G0[0] >= SystemClock.uptimeMillis() - 1000) {
            this.G0 = new long[5];
            if (P.l0()) {
                c3();
            } else {
                e3();
            }
        }
    }

    public final void b3(View view, String str) {
        int length;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048599, this, view, str) == null) {
            if (N0) {
                String str2 = str + "";
            }
            if (TextUtils.isEmpty(str) || view == null) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.H0 = jSONObject.optString("scheme");
                this.I0 = jSONObject.optString("description");
                if (!TextUtils.isEmpty(this.H0) && !TextUtils.isEmpty(this.I0) && (length = this.I0.length()) >= 20) {
                    if (length > 100) {
                        this.I0 = this.I0.substring(0, 100);
                    }
                    LinearLayout linearLayout = (LinearLayout) view.findViewById(b.a.p0.a.f.brands_introduction_ll);
                    linearLayout.setOnClickListener(this);
                    linearLayout.setVisibility(0);
                    ((TextView) view.findViewById(b.a.p0.a.f.brands_introduction_details)).setText(this.I0);
                    SwanAppRelatedSwanListAdapter.doUBCEventStatistic("brand", null, "show");
                    d3();
                }
            } catch (JSONException e2) {
                if (N0) {
                    e2.getMessage();
                }
            }
        }
    }

    public final void c3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            String b2 = b.a.p0.a.v2.p.b(this.k0);
            b.a.p0.a.z1.b.f.e.g(AppRuntime.getAppContext(), b2).E();
            b.a.p0.a.e0.d.h("SwanAppAboutFragment", "showExtraInfo\n" + b2);
        }
    }

    public final void d3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
            linearLayoutManager.setOrientation(1);
            this.L0.setLayoutManager(linearLayoutManager);
            SwanAppRelatedSwanListAdapter swanAppRelatedSwanListAdapter = new SwanAppRelatedSwanListAdapter(getContext());
            this.L0.setAdapter(swanAppRelatedSwanListAdapter);
            b.a.p0.a.y1.b.c(new e(this, swanAppRelatedSwanListAdapter));
        }
    }

    public final void e3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            boolean z = N0;
            b.a.p0.a.h0.g.g U = b.a.p0.a.g1.f.T().U();
            if (U == null) {
                b.a.p0.a.z1.b.f.e.f(getContext(), b.a.p0.a.h.aiapps_open_fragment_failed_toast).F();
                return;
            }
            g.b i2 = U.i("navigateTo");
            i2.n(b.a.p0.a.h0.g.g.f5280g, b.a.p0.a.h0.g.g.f5282i);
            i2.k("running_info", null).a();
        }
    }

    public final void f3() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048603, this) == null) || b.a.p0.a.a2.e.P() == null) {
            return;
        }
        b.a.p0.a.h0.e.c.a(b.a.p0.a.a2.e.P(), this.k0, new f(this));
    }

    public final void g3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            if (b.a.p0.a.j0.b.a.n(b.a.p0.a.a2.d.g().getAppId())) {
                this.K0.setText(b.a.p0.a.h.swanapp_favored);
                this.K0.setTextColor(getResources().getColorStateList(b.a.p0.a.c.swan_app_about_attentation_text_selector));
                this.K0.setBackgroundResource(b.a.p0.a.e.swan_app_about_cancel_attention_selector);
                return;
            }
            this.K0.setText(b.a.p0.a.h.swanapp_add_favor);
            this.K0.setTextColor(-1);
            this.K0.setBackgroundResource(b.a.p0.a.e.swan_app_about_attention_selector);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, view) == null) {
            int id = view.getId();
            if (id == b.a.p0.a.f.aiapps_icon) {
                a3();
            } else if (id == b.a.p0.a.f.open_app_button) {
                L2();
            } else if (id == b.a.p0.a.f.brands_introduction_ll) {
                SchemeRouter.invoke(getContext(), this.H0);
                Q2(PrefetchEvent.STATE_CLICK, "brand");
            } else if (id == b.a.p0.a.f.agreement_layout) {
                K2();
            } else if (id == b.a.p0.a.f.share_friends) {
                w2();
            } else if (id == b.a.p0.a.f.add_favor) {
                Y2();
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, bundle) == null) {
            super.onCreate(bundle);
        }
    }

    @Override // b.a.p0.a.h0.g.d, com.baidu.swan.support.v4.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            super.onPause();
            N2();
        }
    }

    @Override // b.a.p0.a.h0.g.d, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            super.onResume();
            b.a.p0.a.w2.a aVar = this.F0;
            if (aVar != null) {
                aVar.c();
            }
            r2(1);
            b.a.p0.k.n nVar = this.o0;
            if (nVar != null && nVar.g()) {
                this.o0.x(b.a.p0.a.c1.a.H().a());
            }
            if (this.K0 != null) {
                g3();
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View w0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048609, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(b.a.p0.a.g.aiapps_about_fragment, viewGroup, false);
            K1(inflate);
            U2(inflate);
            if (J1()) {
                inflate = M1(inflate);
            }
            return u1(inflate, this);
        }
        return (View) invokeLLL.objValue;
    }

    @Override // b.a.p0.a.h0.g.d
    public void w2() {
        b.a.p0.a.h0.g.g U;
        b.a.p0.a.h0.g.f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048610, this) == null) || (U = b.a.p0.a.g1.f.T().U()) == null || (fVar = (b.a.p0.a.h0.g.f) U.n(b.a.p0.a.h0.g.f.class)) == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, fVar.a3());
        b.a.p0.a.g1.f.T().u(new b.a.p0.a.o0.d.b("sharebtn", hashMap));
        Q2(PrefetchEvent.STATE_CLICK, "aboutshare");
    }
}
