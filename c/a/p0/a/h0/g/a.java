package c.a.p0.a.h0.g;

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
import c.a.p0.a.f1.e.b;
import c.a.p0.a.h0.e.c;
import c.a.p0.a.h0.g.g;
import c.a.p0.a.r1.j;
import c.a.p0.a.v2.n0;
import c.a.p0.a.v2.q0;
import c.a.p0.a.v2.r0;
import c.a.p0.a.y1.a;
import c.a.p0.a.y1.b;
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
public class a extends c.a.p0.a.h0.g.d implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean N0;
    public transient /* synthetic */ FieldHolder $fh;
    public SwanAppRoundedImageView C0;
    public BdBaseImageView D0;
    public TextView E0;
    public c.a.p0.a.w2.a F0;
    public long[] G0;
    public String H0;
    public String I0;
    public String J0;
    public Button K0;
    public RecyclerView L0;
    public SwanAppWebPopWindow M0;

    /* renamed from: c.a.p0.a.h0.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0200a implements c.a.p0.d.i.a<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.k2.g.g f5828a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f5829b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f5830c;

        /* renamed from: c.a.p0.a.h0.g.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class DialogInterface$OnClickListenerC0201a implements DialogInterface.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public DialogInterface$OnClickListenerC0201a(C0200a c0200a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c0200a};
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
                    SwanAppActivity x = c.a.p0.a.a2.d.g().x();
                    if (x != null && Build.VERSION.SDK_INT >= 21) {
                        x.finishAndRemoveTask();
                    }
                    System.exit(0);
                }
            }
        }

        public C0200a(a aVar, c.a.p0.a.k2.g.g gVar, String str) {
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
            this.f5830c = aVar;
            this.f5828a = gVar;
            this.f5829b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.d.i.a
        /* renamed from: a */
        public void run(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                if (bool != null && bool.booleanValue()) {
                    this.f5828a.putInt(this.f5829b, 1);
                } else {
                    this.f5828a.putInt(this.f5829b, 0);
                }
                SwanAppAlertDialog.a aVar = new SwanAppAlertDialog.a(this.f5830c.k0);
                aVar.U(c.a.p0.a.h.swan_offline_perf_tool_tip);
                aVar.v(c.a.p0.a.h.swan_offline_perf_tool_message);
                aVar.n(new c.a.p0.a.w2.h.a());
                aVar.O(c.a.p0.a.h.aiapps_confirm, new DialogInterface$OnClickListenerC0201a(this));
                aVar.X();
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.k2.g.g f5831e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f5832f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.d.i.a f5833g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ a f5834h;

        /* renamed from: c.a.p0.a.h0.g.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0202a implements c.b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f5835a;

            public C0202a(b bVar) {
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
                this.f5835a = bVar;
            }

            @Override // c.a.p0.a.h0.e.c.b
            public void a(boolean z, String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeZL(1048576, this, z, str) == null) {
                    if (z) {
                        this.f5835a.f5833g.run(Boolean.TRUE);
                        return;
                    }
                    Activity activity = this.f5835a.f5834h.k0;
                    if (activity == null || activity.isDestroyed()) {
                        return;
                    }
                    c.a.p0.a.h0.e.c.b(this.f5835a.f5834h.k0, c.a.p0.a.h.swan_offline_perf_tool_tip, str);
                }
            }
        }

        public b(a aVar, c.a.p0.a.k2.g.g gVar, String str, c.a.p0.d.i.a aVar2) {
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
            this.f5834h = aVar;
            this.f5831e = gVar;
            this.f5832f = str;
            this.f5833g = aVar2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                int i2 = this.f5831e.getInt(this.f5832f, -1);
                if (i2 == 1) {
                    this.f5833g.run(Boolean.FALSE);
                } else if (i2 == 0) {
                    this.f5833g.run(Boolean.TRUE);
                } else {
                    c.a.p0.a.a2.e Q = c.a.p0.a.a2.e.Q();
                    if (Q == null) {
                        return;
                    }
                    c.a.p0.a.h0.e.c.a(Q, this.f5834h.k0, new C0202a(this));
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View.OnLongClickListener f5836e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ View f5837f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f5838g;

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
            this.f5838g = aVar;
            this.f5836e = onLongClickListener;
            this.f5837f = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.p0.a.n2.l.b.a.d().g();
                this.f5836e.onLongClick(this.f5837f);
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Runnable f5839e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f5840f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f5841g;

        public d(a aVar, Runnable runnable, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, runnable, Long.valueOf(j2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5841g = aVar;
            this.f5839e = runnable;
            this.f5840f = j2;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                int action = motionEvent.getAction();
                if (action == 0) {
                    view.postDelayed(this.f5839e, this.f5840f);
                    return false;
                } else if (action == 1 || action == 3) {
                    view.removeCallbacks(this.f5839e);
                    return false;
                } else {
                    return false;
                }
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes.dex */
    public class e implements b.InterfaceC0474b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SwanAppRelatedSwanListAdapter f5842a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f5843b;

        /* renamed from: c.a.p0.a.h0.g.a$e$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0203a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.p0.a.y1.a f5844e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ e f5845f;

            public RunnableC0203a(e eVar, c.a.p0.a.y1.a aVar) {
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
                this.f5845f = eVar;
                this.f5844e = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f5845f.f5843b.L0.setVisibility(0);
                    this.f5845f.f5842a.updateData(this.f5844e);
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
            this.f5843b = aVar;
            this.f5842a = swanAppRelatedSwanListAdapter;
        }

        @Override // c.a.p0.a.y1.b.InterfaceC0474b
        public void a(c.a.p0.a.y1.a aVar) {
            List<a.C0473a> list;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null || (list = aVar.f9844a) == null || list.size() <= 0) {
                return;
            }
            q0.b0(new RunnableC0203a(this, aVar));
            SwanAppRelatedSwanListAdapter.doUBCEventStatistic("aboutrelated", null, "show");
        }
    }

    /* loaded from: classes.dex */
    public class f implements c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f5846a;

        /* renamed from: c.a.p0.a.h0.g.a$f$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0204a implements c.a.p0.a.v2.e1.b<Boolean> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ f f5847e;

            public C0204a(f fVar) {
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
                this.f5847e = fVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.a.p0.a.v2.e1.b
            /* renamed from: a */
            public void onCallback(Boolean bool) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                    if (bool.booleanValue()) {
                        c.a.p0.a.e0.a.d(this.f5847e.f5846a.q());
                    } else {
                        c.a.p0.a.c1.b.h().a(this.f5847e.f5846a.k0, null);
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
            this.f5846a = aVar;
        }

        @Override // c.a.p0.a.h0.e.c.b
        public void a(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, str) == null) {
                if (!z) {
                    c.a.p0.a.h0.e.c.c(this.f5846a.k0, str);
                } else if (c.a.p0.a.e0.a.a()) {
                    c.a.p0.a.e0.a.d(this.f5846a.q());
                } else {
                    c.a.p0.a.c1.b.h().f(new C0204a(this));
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class g implements c.a.p0.a.q0.b.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f5848a;

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
            this.f5848a = aVar;
        }

        @Override // c.a.p0.a.q0.b.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.p0.a.z1.b.f.e f2 = c.a.p0.a.z1.b.f.e.f(this.f5848a.q(), c.a.p0.a.h.swanapp_tip_net_unavailable);
                f2.l(2);
                f2.F();
            }
        }

        @Override // c.a.p0.a.q0.b.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                c.a.p0.a.z1.b.f.e f2 = c.a.p0.a.z1.b.f.e.f(this.f5848a.q(), c.a.p0.a.h.aiapps_cancel_fav_fail);
                f2.l(2);
                f2.F();
            }
        }

        @Override // c.a.p0.a.q0.b.b
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                c.a.p0.a.z1.b.f.e f2 = c.a.p0.a.z1.b.f.e.f(this.f5848a.q(), c.a.p0.a.h.aiapps_cancel_fav_success);
                f2.l(2);
                f2.F();
            }
        }
    }

    /* loaded from: classes.dex */
    public class h implements c.a.p0.a.q0.b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f5849a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f5850b;

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
            this.f5850b = aVar;
            this.f5849a = str;
        }

        @Override // c.a.p0.a.q0.b.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.p0.a.z1.b.f.e f2 = c.a.p0.a.z1.b.f.e.f(this.f5850b.q(), c.a.p0.a.h.swanapp_tip_net_unavailable);
                f2.l(2);
                f2.F();
            }
        }

        @Override // c.a.p0.a.q0.b.a
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                c.a.p0.a.z1.b.f.e f2 = c.a.p0.a.z1.b.f.e.f(this.f5850b.q(), c.a.p0.a.h.aiapps_fav_fail);
                f2.l(2);
                f2.F();
            }
        }

        @Override // c.a.p0.a.q0.b.a
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                c.a.p0.a.j0.b.a.t();
                if (c.a.p0.a.j1.a.k(this.f5850b.h())) {
                    c.a.p0.a.j1.a.p("aboutconcern", this.f5849a);
                    return;
                }
                Context q = this.f5850b.q();
                c.a.p0.a.z1.b.f.e g2 = c.a.p0.a.z1.b.f.e.g(q, c.a.p0.a.c1.a.e0().f(q));
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
        public final /* synthetic */ a f5851e;

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
            this.f5851e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f5851e.i3();
            }
        }
    }

    /* loaded from: classes.dex */
    public class j implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public FullScreenFloatView f5852e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f5853f;

        /* renamed from: c.a.p0.a.h0.g.a$j$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0205a implements c.a.p0.a.v2.e1.b<Boolean> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ j f5854e;

            public C0205a(j jVar) {
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
                this.f5854e = jVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.a.p0.a.v2.e1.b
            /* renamed from: a */
            public void onCallback(Boolean bool) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                    if (bool.booleanValue()) {
                        c.a.p0.a.e0.a.c(this.f5854e.f5853f.q(), true);
                    } else {
                        c.a.p0.a.c1.b.h().a(this.f5854e.f5853f.k0, null);
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
            this.f5853f = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f5853f.k0 == null) {
                return;
            }
            if (a.N0) {
                if (c.a.p0.a.h0.o.e.a.k(null)) {
                    c.a.p0.a.e0.a.d(this.f5853f.q());
                    return;
                }
                if (this.f5852e == null) {
                    this.f5852e = c.a.p0.a.g1.f.V().n(this.f5853f.k0);
                }
                if (this.f5853f.S1()) {
                    if (c.a.p0.a.e0.a.a()) {
                        c.a.p0.a.e0.a.c(this.f5853f.q(), false);
                        return;
                    } else {
                        c.a.p0.a.c1.b.h().f(new C0205a(this));
                        return;
                    }
                }
                this.f5852e.setVisibility(this.f5852e.getVisibility() == 0 ? 8 : 0);
            } else if (this.f5853f.S1()) {
                this.f5853f.j3();
            } else {
                c.a.p0.a.e0.a.d(this.f5853f.q());
            }
        }
    }

    /* loaded from: classes.dex */
    public class k implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public SwanAppPropertyWindow f5855e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f5856f;

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
            this.f5856f = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f5855e == null) {
                    this.f5855e = c.a.p0.a.g1.f.V().L(this.f5856f.k0);
                }
                this.f5855e.setVisibility(this.f5855e.getVisibility() == 0 ? 8 : 0);
            }
        }
    }

    /* loaded from: classes.dex */
    public class l implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.f1.e.b f5857e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.a2.e f5858f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f5859g;

        /* renamed from: c.a.p0.a.h0.g.a$l$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class DialogInterface$OnClickListenerC0206a implements DialogInterface.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public DialogInterface$OnClickListenerC0206a(l lVar) {
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

        public l(a aVar, c.a.p0.a.f1.e.b bVar, c.a.p0.a.a2.e eVar) {
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
            this.f5859g = aVar;
            this.f5857e = bVar;
            this.f5858f = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f5859g.k0 == null) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("ENABLE V8: ");
            sb.append(c.a.p0.a.h0.u.g.N().h0());
            sb.append(StringUtils.LF);
            sb.append("APS VERSION: ");
            sb.append(TextUtils.isEmpty(this.f5857e.u1()) ? "" : this.f5857e.u1());
            sb.append(StringUtils.LF);
            sb.append("APPID VERSION: ");
            sb.append(c.a.p0.a.v.a.c(this.f5858f.f4558f));
            sb.append(StringUtils.LF);
            String formatFileSize = Formatter.formatFileSize(AppRuntime.getAppContext(), this.f5857e.g1());
            sb.append("小程序包大小: ");
            sb.append(TextUtils.isEmpty(formatFileSize) ? "" : formatFileSize);
            sb.append("(");
            sb.append(this.f5857e.g1());
            sb.append(SmallTailInfo.EMOTION_SUFFIX);
            sb.append(StringUtils.LF);
            SwanAppAlertDialog.a aVar = new SwanAppAlertDialog.a(this.f5859g.k0);
            aVar.V(this.f5859g.k0.getResources().getString(c.a.p0.a.h.aiapps_show_ext_info_title));
            aVar.x(sb.toString());
            aVar.n(new c.a.p0.a.w2.h.a());
            aVar.m(false);
            aVar.O(c.a.p0.a.h.aiapps_confirm, new DialogInterface$OnClickListenerC0206a(this));
            aVar.X();
        }
    }

    /* loaded from: classes.dex */
    public class m implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f5860e;

        /* renamed from: c.a.p0.a.h0.g.a$m$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class DialogInterface$OnClickListenerC0207a implements DialogInterface.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public DialogInterface$OnClickListenerC0207a(m mVar) {
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
            this.f5860e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f5860e.k0 == null) {
                return;
            }
            String e2 = c.a.p0.a.m2.a.c().e(1);
            String string = this.f5860e.k0.getResources().getString(c.a.p0.a.h.ai_games_debug_game_core_version);
            SwanAppAlertDialog.a aVar = new SwanAppAlertDialog.a(this.f5860e.k0);
            aVar.V(string);
            aVar.x(e2);
            aVar.n(new c.a.p0.a.w2.h.a());
            aVar.m(false);
            aVar.O(c.a.p0.a.h.aiapps_confirm, new DialogInterface$OnClickListenerC0207a(this));
            aVar.X();
        }
    }

    /* loaded from: classes.dex */
    public class n implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f5861e;

        /* renamed from: c.a.p0.a.h0.g.a$n$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0208a extends j.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ n f5862a;

            /* renamed from: c.a.p0.a.h0.g.a$n$a$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public class RunnableC0209a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ String f5863e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ C0208a f5864f;

                public RunnableC0209a(C0208a c0208a, String str) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {c0208a, str};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f5864f = c0208a;
                    this.f5863e = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        SwanAppAlertDialog.a aVar = new SwanAppAlertDialog.a(this.f5864f.f5862a.f5861e.k0);
                        aVar.U(c.a.p0.a.h.aiapps_debug_report_performance);
                        aVar.x(this.f5863e);
                        aVar.n(new c.a.p0.a.w2.h.a());
                        aVar.m(false);
                        aVar.O(c.a.p0.a.h.aiapps_confirm, null);
                        aVar.X();
                    }
                }
            }

            public C0208a(n nVar) {
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
                this.f5862a = nVar;
            }

            @Override // c.a.p0.a.r1.j.a
            public void c(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    this.f5862a.f5861e.k0.runOnUiThread(new RunnableC0209a(this, str));
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
            this.f5861e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f5861e.k0 == null) {
                return;
            }
            c.a.p0.a.r1.j.e().g(new C0208a(this));
        }
    }

    /* loaded from: classes.dex */
    public class o implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public c.a.p0.a.e0.h.a f5865e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f5866f;

        /* renamed from: c.a.p0.a.h0.g.a$o$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class DialogInterface$OnClickListenerC0210a implements DialogInterface.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ o f5867e;

            public DialogInterface$OnClickListenerC0210a(o oVar) {
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
                this.f5867e = oVar;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                    c.a.p0.a.e0.h.a.g(1);
                    this.f5867e.f5865e = new c.a.p0.a.e0.h.a(c.a.p0.a.c1.a.b());
                    this.f5867e.f5865e.h();
                }
            }
        }

        /* loaded from: classes.dex */
        public class b implements DialogInterface.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ o f5868e;

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
                this.f5868e = oVar;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                    this.f5868e.b();
                    c.a.p0.a.e0.h.a.g(2);
                    System.exit(0);
                }
            }
        }

        /* loaded from: classes.dex */
        public class c implements DialogInterface.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ o f5869e;

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
                this.f5869e = oVar;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                    this.f5869e.b();
                    c.a.p0.a.e0.h.a.g(0);
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
            this.f5866f = aVar;
        }

        public final void b() {
            c.a.p0.a.e0.h.a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (aVar = this.f5865e) == null) {
                return;
            }
            aVar.i();
            this.f5865e = null;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
                SwanAppAlertDialog.a aVar = new SwanAppAlertDialog.a(this.f5866f.k0);
                aVar.U(c.a.p0.a.h.aiapps_debug_start_inspect);
                aVar.v(c.a.p0.a.h.aiapps_debug_inspect_message);
                aVar.n(new c.a.p0.a.w2.h.a());
                aVar.m(true);
                if (c.a.p0.a.e0.h.a.e() == 0) {
                    aVar.O(c.a.p0.a.h.aiapps_debug_inspect_normal, new DialogInterface$OnClickListenerC0210a(this));
                }
                if (c.a.p0.a.e0.h.a.e() != 2) {
                    aVar.H(c.a.p0.a.h.aiapps_debug_inspect_enhance, new b(this));
                }
                if (c.a.p0.a.e0.h.a.e() != 0) {
                    aVar.B(c.a.p0.a.h.swanapp_close, new c(this));
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
        public final /* synthetic */ a f5870e;

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
            this.f5870e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f5870e.N2();
                this.f5870e.U2(PrefetchEvent.STATE_CLICK, "baozhang");
            }
        }
    }

    /* loaded from: classes.dex */
    public class q implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f5871e;

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
            this.f5871e = aVar;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                this.f5871e.Q2();
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1086868658, "Lc/a/p0/a/h0/g/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1086868658, "Lc/a/p0/a/h0/g/a;");
                return;
            }
        }
        N0 = c.a.p0.a.k.f7077a;
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

    public static a b3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? new a() : (a) invokeV.objValue;
    }

    @Override // c.a.p0.a.h0.g.d
    public void A2() {
        c.a.p0.a.h0.g.g W;
        c.a.p0.a.h0.g.f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (W = c.a.p0.a.g1.f.V().W()) == null || (fVar = (c.a.p0.a.h0.g.f) W.n(c.a.p0.a.h0.g.f.class)) == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, fVar.e3());
        c.a.p0.a.g1.f.V().v(new c.a.p0.a.o0.d.b("sharebtn", hashMap));
        U2(PrefetchEvent.STATE_CLICK, "aboutshare");
    }

    @Override // c.a.p0.a.h0.g.d
    public boolean J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @NonNull
    public final String M2(@NonNull String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2)) == null) {
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

    public final void N2() {
        SwanAppActivity activity;
        c.a.p0.a.a2.e Q;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (activity = c.a.p0.a.g1.f.V().getActivity()) == null || (Q = c.a.p0.a.a2.e.Q()) == null) {
            return;
        }
        SwanAppWebPopWindow swanAppWebPopWindow = this.M0;
        if (swanAppWebPopWindow == null || !swanAppWebPopWindow.x()) {
            SwanAppWebPopWindow swanAppWebPopWindow2 = new SwanAppWebPopWindow(activity, "https://baozhang.baidu.com/guarantee/baoshowdetail?appkey=" + Q.D());
            this.M0 = swanAppWebPopWindow2;
            swanAppWebPopWindow2.z0(c.a.p0.a.h.swan_app_baidu_guarantee_title);
            swanAppWebPopWindow2.v0(SwanAppWebPopWindow.CloseStyle.CLOSE_AT_BOTTOM);
            swanAppWebPopWindow2.w0();
            swanAppWebPopWindow2.u0();
            swanAppWebPopWindow2.B0();
        }
    }

    @Override // c.a.p0.a.h0.g.d
    public void O1(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view) == null) {
            P1(view);
            if (!S1()) {
                x2(false);
            }
            p2(true);
            j2(-1);
            r2(-16777216);
            l2(null);
            n2(true);
        }
    }

    public final void O2() {
        SwanAppActivity activity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (activity = c.a.p0.a.g1.f.V().getActivity()) == null || c.a.p0.a.a2.e.Q() == null) {
            return;
        }
        SwanAppWebPopWindow swanAppWebPopWindow = this.M0;
        if (swanAppWebPopWindow == null || !swanAppWebPopWindow.x()) {
            SwanAppWebPopWindow swanAppWebPopWindow2 = new SwanAppWebPopWindow(activity, this.J0);
            this.M0 = swanAppWebPopWindow2;
            swanAppWebPopWindow2.A0(U(c.a.p0.a.h.swan_app_service_agreement));
            swanAppWebPopWindow2.x0(activity.getResources().getDimensionPixelSize(c.a.p0.a.d.swan_half_screen_evalute_height));
            swanAppWebPopWindow2.v0(SwanAppWebPopWindow.CloseStyle.CLOSE_AT_RIGHT);
            swanAppWebPopWindow2.u0();
            swanAppWebPopWindow2.B0();
            U2(PrefetchEvent.STATE_CLICK, "servicenote");
        }
    }

    public final void P2() {
        c.a.p0.a.a2.e Q;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (Q = c.a.p0.a.a2.e.Q()) == null) {
            return;
        }
        b.a L = Q.L();
        String J = L.J();
        String F = L.F();
        if (!TextUtils.isEmpty(J) && !TextUtils.isEmpty(F)) {
            String h2 = q0.h(J, F);
            UnitedSchemeMainDispatcher unitedSchemeMainDispatcher = new UnitedSchemeMainDispatcher();
            unitedSchemeMainDispatcher.setDynamicDispatcher("swanAPI", new c.a.p0.a.c2.e());
            UnitedSchemeEntity unitedSchemeEntity = new UnitedSchemeEntity(Uri.parse(h2), UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE);
            unitedSchemeEntity.setOnlyVerify(false);
            unitedSchemeMainDispatcher.dispatch(this.k0, unitedSchemeEntity);
            boolean z = N0;
            return;
        }
        boolean z2 = N0;
    }

    public final void Q2() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || this.k0 == null) {
            return;
        }
        String str = c.a.p0.a.a2.d.g().r().L().f0().webUrl;
        if (TextUtils.isEmpty(str)) {
            r0.b(this.k0).c("");
            c.a.p0.a.z1.b.f.e.f(this.k0, c.a.p0.a.h.swanapp_web_url_copy_fail).F();
            return;
        }
        String M2 = M2(str, c.a.p0.a.l1.b.e(q0.n()));
        int i2 = c.a.p0.a.h.swanapp_web_url_copy_success;
        if (M2.length() > 4000) {
            i2 = c.a.p0.a.h.swanapp_web_url_param_to_long;
        } else {
            str = M2;
        }
        r0.b(this.k0).c(str);
        c.a.p0.a.z1.b.f.e.f(this.k0, i2).F();
    }

    public final void R2() {
        SwanAppWebPopWindow swanAppWebPopWindow;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && e0() && (swanAppWebPopWindow = this.M0) != null) {
            swanAppWebPopWindow.r();
        }
    }

    public final void S2(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            if (c.a.p0.a.u1.a.a.G()) {
                boolean z = N0;
                c.a.p0.a.z1.b.f.e.f(q(), c.a.p0.a.h.aiapps_debug_forbid_favor).F();
                return;
            }
            String h2 = q0.n().h();
            SwanFavorDataManager.h().b(str, new h(this, h2));
            c.a.p0.a.j1.a.p("aboutconcern", h2);
        }
    }

    public final void T2(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            SwanFavorDataManager h2 = SwanFavorDataManager.h();
            g gVar = new g(this);
            c.a.p0.a.n0.l.c l2 = c.a.p0.a.n0.l.c.l();
            l2.n(3);
            h2.c(str, gVar, l2.k());
            U2(PrefetchEvent.STATE_CLICK, "aboutmove");
        }
    }

    public final void U2(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, str, str2) == null) {
            c.a.p0.a.j2.p.f fVar = new c.a.p0.a.j2.p.f();
            if (!TextUtils.isEmpty(str)) {
                fVar.f7064b = str;
            }
            if (!TextUtils.isEmpty(str2)) {
                fVar.f7067e = str2;
            }
            w1(fVar);
        }
    }

    @Override // c.a.p0.a.h0.g.d
    public boolean V1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void V2(@NonNull View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, view) == null) {
            String b2 = c.a.p0.a.h0.g.b.b();
            c.a.p0.a.k2.g.g a2 = c.a.p0.a.h0.g.b.a();
            Button button = (Button) view.findViewById(c.a.p0.a.f.btn_ues_offline_perftool);
            button.setVisibility(0);
            if (a2.getInt(b2, -1) == 1) {
                button.setText(c.a.p0.a.h.swan_offline_perf_tool_disable);
            } else {
                button.setText(c.a.p0.a.h.swan_offline_perf_tool_enable);
            }
            button.setOnClickListener(new b(this, a2, b2, new C0200a(this, a2, b2)));
        }
    }

    public final void W2(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            n0.J(this.D0, this.E0, String.valueOf(i2));
        }
    }

    @Override // c.a.p0.a.h0.g.d
    public boolean X1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void X2() {
        FragmentActivity h2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && (h2 = h()) != null && this.o0 == null) {
            c.a.p0.k.n nVar = new c.a.p0.k.n(h2, this.n0, 13, c.a.p0.a.c1.a.G(), new c.a.p0.a.w2.h.b());
            this.o0 = nVar;
            nVar.n(q0.O());
            new c.a.p0.a.j1.a(this.o0, this).z();
        }
    }

    public final void Y2(View view) {
        c.a.p0.a.a2.e Q;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, view) == null) || (Q = c.a.p0.a.a2.e.Q()) == null || Q.L() == null) {
            return;
        }
        b.a L = Q.L();
        this.C0 = (SwanAppRoundedImageView) view.findViewById(c.a.p0.a.f.aiapps_icon);
        TextView textView = (TextView) view.findViewById(c.a.p0.a.f.aiapps_title);
        textView.setText(L.K());
        if (L.G() == 0) {
            c.a.p0.a.w2.f.a(textView, new i(this));
        }
        c.a.p0.a.r1.k.f.j().n().h(textView);
        TextView textView2 = (TextView) view.findViewById(c.a.p0.a.f.aiapps_description);
        textView2.setText(L.c1());
        Button button = (Button) view.findViewById(c.a.p0.a.f.share_friends);
        button.setOnClickListener(this);
        Button button2 = (Button) view.findViewById(c.a.p0.a.f.add_favor);
        this.K0 = button2;
        button2.setOnClickListener(this);
        k3();
        c.a.p0.a.h0.g.g W = c.a.p0.a.g1.f.V().W();
        if (W == null) {
            return;
        }
        if (W.n(c.a.p0.a.c1.b.c().a()) != null) {
            button.setVisibility(8);
            this.K0.setVisibility(8);
        }
        c.a.p0.q.d.b().a(textView2);
        ((TextView) view.findViewById(c.a.p0.a.f.service_category_value)).setText(L.q1());
        ((TextView) view.findViewById(c.a.p0.a.f.subject_info_value)).setText(L.r1());
        String D = c.a.p0.a.c1.a.n().D();
        this.J0 = D;
        if (!TextUtils.isEmpty(D)) {
            View findViewById = view.findViewById(c.a.p0.a.f.agreement_layout);
            findViewById.setVisibility(0);
            findViewById.setOnClickListener(this);
        }
        this.L0 = (RecyclerView) view.findViewById(c.a.p0.a.f.related_swan_app_list);
        PMSAppInfo f0 = L.f0();
        if (a3(f0)) {
            f3(view, f0.brandsInfo);
        }
        this.E0 = (TextView) view.findViewById(c.a.p0.a.f.aiapps_label_tv);
        this.D0 = (BdBaseImageView) view.findViewById(c.a.p0.a.f.aiapps_label_bg);
        this.C0.setImageBitmap(q0.i(L, "SwanAppAboutFragment", false));
        this.C0.setOnClickListener(this);
        SwanAppBearInfo i1 = L.i1();
        if (i1 != null && i1.isValid()) {
            this.F0 = new c.a.p0.a.w2.a(this.k0, view, i1, c.a.p0.a.f.bear_layout);
        }
        W2(L.t1());
        ((Button) view.findViewById(c.a.p0.a.f.open_app_button)).setVisibility(8);
        if (N0 || c.a.p0.a.g1.f.V().O()) {
            View inflate = ((ViewStub) view.findViewById(c.a.p0.a.f.ai_app_console)).inflate();
            if (S1() && (inflate instanceof Button)) {
                ((Button) inflate).setText(L.l0() ? c.a.p0.a.h.aiapps_close_debug_mode : c.a.p0.a.h.aiapps_open_debug_mode);
            }
            inflate.setOnClickListener(new j(this));
            if (!S1()) {
                ((ViewStub) view.findViewById(c.a.p0.a.f.ai_app_property)).inflate().setOnClickListener(new k(this));
            }
            if (S1()) {
                ((ViewStub) view.findViewById(c.a.p0.a.f.ai_app_show_ext_info)).inflate().setOnClickListener(new l(this, L, Q));
            }
            if (S1()) {
                View inflate2 = ((ViewStub) view.findViewById(c.a.p0.a.f.ai_app_swan_core_history_info)).inflate();
                if (inflate2 instanceof Button) {
                    Button button3 = (Button) inflate2;
                    button3.setText(c.a.p0.a.h.ai_games_debug_game_core_version);
                    button3.setOnClickListener(new m(this));
                }
            }
            if (c.a.p0.a.r1.j.e().f()) {
                View inflate3 = ((ViewStub) view.findViewById(c.a.p0.a.f.ai_app_report_performance)).inflate();
                if (inflate3 instanceof Button) {
                    Button button4 = (Button) inflate3;
                    button4.setText(c.a.p0.a.h.aiapps_debug_report_performance);
                    button4.setOnClickListener(new n(this));
                }
            }
            View inflate4 = ((ViewStub) view.findViewById(c.a.p0.a.f.ai_app_start_inspector)).inflate();
            if (inflate4 instanceof Button) {
                ((Button) inflate4).setText(c.a.p0.a.h.aiapps_debug_start_inspect);
            }
            inflate4.setOnClickListener(new o(this));
            if (!S1()) {
                V2(view);
            }
        }
        if (Z2(f0)) {
            ImageView imageView = (ImageView) view.findViewById(c.a.p0.a.f.apply_guarantee);
            imageView.setVisibility(0);
            imageView.setOnClickListener(new p(this));
        }
        if (S1()) {
            return;
        }
        d3(this.C0, 2000L, new q(this));
    }

    public final boolean Z2(PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, pMSAppInfo)) == null) {
            return (pMSAppInfo == null ? PMSConstants.PayProtected.NO_PAY_PROTECTED.type : pMSAppInfo.payProtected) == PMSConstants.PayProtected.PAY_PROTECTED.type;
        }
        return invokeL.booleanValue;
    }

    public final boolean a3(PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, pMSAppInfo)) == null) ? (c.a.p0.a.a2.d.g().l() != 0 || pMSAppInfo == null || TextUtils.isEmpty(pMSAppInfo.brandsInfo)) ? false : true : invokeL.booleanValue;
    }

    @Override // c.a.p0.a.h0.g.d
    public void c2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048596, this) == null) && S1()) {
            X2();
            this.o0.p(c.a.p0.a.c1.a.H().a());
        }
    }

    public final void c3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            String D = c.a.p0.a.a2.d.g().r().D();
            if (TextUtils.isEmpty(D)) {
                return;
            }
            if (c.a.p0.a.j0.b.a.n(D)) {
                T2(D);
            } else {
                S2(D);
            }
            k3();
        }
    }

    public final void d3(View view, long j2, View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{view, Long.valueOf(j2), onLongClickListener}) == null) || view == null || onLongClickListener == null || j2 <= 0) {
            return;
        }
        view.setOnTouchListener(new d(this, new c(this, onLongClickListener, view), j2));
    }

    public final void e3() {
        c.a.p0.a.a2.e Q;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048599, this) == null) || (Q = c.a.p0.a.a2.e.Q()) == null) {
            return;
        }
        long[] jArr = this.G0;
        System.arraycopy(jArr, 1, jArr, 0, jArr.length - 1);
        long[] jArr2 = this.G0;
        jArr2[jArr2.length - 1] = SystemClock.uptimeMillis();
        if (this.G0[0] >= SystemClock.uptimeMillis() - 1000) {
            this.G0 = new long[5];
            if (Q.m0()) {
                g3();
            } else {
                i3();
            }
        }
    }

    public final void f3(View view, String str) {
        int length;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048600, this, view, str) == null) {
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
                    LinearLayout linearLayout = (LinearLayout) view.findViewById(c.a.p0.a.f.brands_introduction_ll);
                    linearLayout.setOnClickListener(this);
                    linearLayout.setVisibility(0);
                    ((TextView) view.findViewById(c.a.p0.a.f.brands_introduction_details)).setText(this.I0);
                    SwanAppRelatedSwanListAdapter.doUBCEventStatistic("brand", null, "show");
                    h3();
                }
            } catch (JSONException e2) {
                if (N0) {
                    e2.getMessage();
                }
            }
        }
    }

    public final void g3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            String b2 = c.a.p0.a.v2.p.b(this.k0);
            c.a.p0.a.z1.b.f.e.g(AppRuntime.getAppContext(), b2).E();
            c.a.p0.a.e0.d.h("SwanAppAboutFragment", "showExtraInfo\n" + b2);
        }
    }

    public final void h3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(q());
            linearLayoutManager.setOrientation(1);
            this.L0.setLayoutManager(linearLayoutManager);
            SwanAppRelatedSwanListAdapter swanAppRelatedSwanListAdapter = new SwanAppRelatedSwanListAdapter(q());
            this.L0.setAdapter(swanAppRelatedSwanListAdapter);
            c.a.p0.a.y1.b.c(new e(this, swanAppRelatedSwanListAdapter));
        }
    }

    public final void i3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            boolean z = N0;
            c.a.p0.a.h0.g.g W = c.a.p0.a.g1.f.V().W();
            if (W == null) {
                c.a.p0.a.z1.b.f.e.f(q(), c.a.p0.a.h.aiapps_open_fragment_failed_toast).F();
                return;
            }
            g.b i2 = W.i("navigateTo");
            i2.n(c.a.p0.a.h0.g.g.f5928g, c.a.p0.a.h0.g.g.f5930i);
            i2.k("running_info", null).a();
        }
    }

    public final void j3() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048604, this) == null) || c.a.p0.a.a2.e.Q() == null) {
            return;
        }
        c.a.p0.a.h0.e.c.a(c.a.p0.a.a2.e.Q(), this.k0, new f(this));
    }

    public final void k3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            if (c.a.p0.a.j0.b.a.n(c.a.p0.a.a2.d.g().getAppId())) {
                this.K0.setText(c.a.p0.a.h.swanapp_favored);
                this.K0.setTextColor(z().getColorStateList(c.a.p0.a.c.swan_app_about_attentation_text_selector));
                this.K0.setBackgroundResource(c.a.p0.a.e.swan_app_about_cancel_attention_selector);
                return;
            }
            this.K0.setText(c.a.p0.a.h.swanapp_add_favor);
            this.K0.setTextColor(-1);
            this.K0.setBackgroundResource(c.a.p0.a.e.swan_app_about_attention_selector);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, view) == null) {
            int id = view.getId();
            if (id == c.a.p0.a.f.aiapps_icon) {
                e3();
            } else if (id == c.a.p0.a.f.open_app_button) {
                P2();
            } else if (id == c.a.p0.a.f.brands_introduction_ll) {
                SchemeRouter.invoke(q(), this.H0);
                U2(PrefetchEvent.STATE_CLICK, "brand");
            } else if (id == c.a.p0.a.f.agreement_layout) {
                O2();
            } else if (id == c.a.p0.a.f.share_friends) {
                A2();
            } else if (id == c.a.p0.a.f.add_favor) {
                c3();
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, bundle) == null) {
            super.onCreate(bundle);
        }
    }

    @Override // c.a.p0.a.h0.g.d, com.baidu.swan.support.v4.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            super.onPause();
            R2();
        }
    }

    @Override // c.a.p0.a.h0.g.d, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            super.onResume();
            c.a.p0.a.w2.a aVar = this.F0;
            if (aVar != null) {
                aVar.c();
            }
            v2(1);
            c.a.p0.k.n nVar = this.o0;
            if (nVar != null && nVar.g()) {
                this.o0.x(c.a.p0.a.c1.a.H().a());
            }
            if (this.K0 != null) {
                k3();
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View z0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048610, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(c.a.p0.a.g.aiapps_about_fragment, viewGroup, false);
            O1(inflate);
            Y2(inflate);
            if (N1()) {
                inflate = Q1(inflate);
            }
            return y1(inflate, this);
        }
        return (View) invokeLLL.objValue;
    }
}
