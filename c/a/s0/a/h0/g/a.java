package c.a.s0.a.h0.g;

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
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c.a.s0.a.b2.a;
import c.a.s0.a.b2.b;
import c.a.s0.a.f1.e.b;
import c.a.s0.a.h0.e.c;
import c.a.s0.a.h0.g.g;
import c.a.s0.a.u1.j;
import c.a.s0.a.z2.n0;
import c.a.s0.a.z2.q0;
import c.a.s0.a.z2.r0;
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
public class a extends c.a.s0.a.h0.g.d implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean U0;
    public transient /* synthetic */ FieldHolder $fh;
    public SwanAppRoundedImageView J0;
    public BdBaseImageView K0;
    public TextView L0;
    public c.a.s0.a.a3.a M0;
    public long[] N0;
    public String O0;
    public String P0;
    public String Q0;
    public Button R0;
    public RecyclerView S0;
    public SwanAppWebPopWindow T0;

    /* renamed from: c.a.s0.a.h0.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0371a implements c.a.s0.d.i.a<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.s0.a.o2.g.g a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f6544b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f6545c;

        /* renamed from: c.a.s0.a.h0.g.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class DialogInterface$OnClickListenerC0372a implements DialogInterface.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public DialogInterface$OnClickListenerC0372a(C0371a c0371a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c0371a};
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
                    SwanAppActivity x = c.a.s0.a.d2.d.J().x();
                    if (x != null && Build.VERSION.SDK_INT >= 21) {
                        x.finishAndRemoveTask();
                    }
                    System.exit(0);
                }
            }
        }

        public C0371a(a aVar, c.a.s0.a.o2.g.g gVar, String str) {
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
            this.f6545c = aVar;
            this.a = gVar;
            this.f6544b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.s0.d.i.a
        /* renamed from: a */
        public void run(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                if (bool != null && bool.booleanValue()) {
                    this.a.putInt(this.f6544b, 1);
                } else {
                    this.a.putInt(this.f6544b, 0);
                }
                SwanAppAlertDialog.a aVar = new SwanAppAlertDialog.a(this.f6545c.g0);
                aVar.U(c.a.s0.a.h.swan_offline_perf_tool_tip);
                aVar.v(c.a.s0.a.h.swan_offline_perf_tool_message);
                aVar.n(new c.a.s0.a.a3.h.a());
                aVar.O(c.a.s0.a.h.aiapps_confirm, new DialogInterface$OnClickListenerC0372a(this));
                aVar.X();
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.s0.a.o2.g.g f6546e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f6547f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c.a.s0.d.i.a f6548g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ a f6549h;

        /* renamed from: c.a.s0.a.h0.g.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0373a implements c.b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            public C0373a(b bVar) {
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

            @Override // c.a.s0.a.h0.e.c.b
            public void a(boolean z, String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeZL(1048576, this, z, str) == null) {
                    if (z) {
                        this.a.f6548g.run(Boolean.TRUE);
                        return;
                    }
                    Activity activity = this.a.f6549h.g0;
                    if (activity == null || activity.isDestroyed()) {
                        return;
                    }
                    c.a.s0.a.h0.e.c.b(this.a.f6549h.g0, c.a.s0.a.h.swan_offline_perf_tool_tip, str);
                }
            }
        }

        public b(a aVar, c.a.s0.a.o2.g.g gVar, String str, c.a.s0.d.i.a aVar2) {
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
            this.f6549h = aVar;
            this.f6546e = gVar;
            this.f6547f = str;
            this.f6548g = aVar2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                int i2 = this.f6546e.getInt(this.f6547f, -1);
                if (i2 == 1) {
                    this.f6548g.run(Boolean.FALSE);
                } else if (i2 == 0) {
                    this.f6548g.run(Boolean.TRUE);
                } else {
                    c.a.s0.a.d2.e a0 = c.a.s0.a.d2.e.a0();
                    if (a0 == null) {
                        return;
                    }
                    c.a.s0.a.h0.e.c.a(a0, this.f6549h.g0, new C0373a(this));
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View.OnLongClickListener f6550e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ View f6551f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f6552g;

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
            this.f6552g = aVar;
            this.f6550e = onLongClickListener;
            this.f6551f = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.s0.a.r2.k.b.a.d().g();
                this.f6550e.onLongClick(this.f6551f);
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Runnable f6553e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f6554f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f6555g;

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
            this.f6555g = aVar;
            this.f6553e = runnable;
            this.f6554f = j2;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                int action = motionEvent.getAction();
                if (action == 0) {
                    view.postDelayed(this.f6553e, this.f6554f);
                    return false;
                } else if (action == 1 || action == 3) {
                    view.removeCallbacks(this.f6553e);
                    return false;
                } else {
                    return false;
                }
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes.dex */
    public class e implements b.InterfaceC0293b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppRelatedSwanListAdapter a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f6556b;

        /* renamed from: c.a.s0.a.h0.g.a$e$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0374a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.s0.a.b2.a f6557e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ e f6558f;

            public RunnableC0374a(e eVar, c.a.s0.a.b2.a aVar) {
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
                this.f6558f = eVar;
                this.f6557e = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f6558f.f6556b.S0.setVisibility(0);
                    this.f6558f.a.updateData(this.f6557e);
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
            this.f6556b = aVar;
            this.a = swanAppRelatedSwanListAdapter;
        }

        @Override // c.a.s0.a.b2.b.InterfaceC0293b
        public void a(c.a.s0.a.b2.a aVar) {
            List<a.C0292a> list;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null || (list = aVar.a) == null || list.size() <= 0) {
                return;
            }
            q0.e0(new RunnableC0374a(this, aVar));
            SwanAppRelatedSwanListAdapter.doUBCEventStatistic("aboutrelated", null, "show");
        }
    }

    /* loaded from: classes.dex */
    public class f implements c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        /* renamed from: c.a.s0.a.h0.g.a$f$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0375a implements c.a.s0.a.z2.g1.c<Boolean> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ f f6559e;

            public C0375a(f fVar) {
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
                this.f6559e = fVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.a.s0.a.z2.g1.c
            /* renamed from: a */
            public void onCallback(Boolean bool) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                    if (bool.booleanValue()) {
                        c.a.s0.a.e0.a.d(this.f6559e.a.getContext());
                    } else {
                        c.a.s0.a.c1.b.h().a(this.f6559e.a.g0, null);
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
            this.a = aVar;
        }

        @Override // c.a.s0.a.h0.e.c.b
        public void a(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, str) == null) {
                if (!z) {
                    c.a.s0.a.h0.e.c.c(this.a.g0, str);
                } else if (c.a.s0.a.e0.a.a()) {
                    c.a.s0.a.e0.a.d(this.a.getContext());
                } else {
                    c.a.s0.a.c1.b.h().f(new C0375a(this));
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class g implements c.a.s0.a.q0.b.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

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
            this.a = aVar;
        }

        @Override // c.a.s0.a.q0.b.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.s0.a.c2.b.f.e f2 = c.a.s0.a.c2.b.f.e.f(this.a.getContext(), c.a.s0.a.h.swanapp_tip_net_unavailable);
                f2.l(2);
                f2.G();
            }
        }

        @Override // c.a.s0.a.q0.b.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                c.a.s0.a.c2.b.f.e f2 = c.a.s0.a.c2.b.f.e.f(this.a.getContext(), c.a.s0.a.h.aiapps_cancel_fav_success);
                f2.l(2);
                f2.G();
            }
        }

        @Override // c.a.s0.a.q0.b.b
        public void c(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) || z) {
                return;
            }
            c.a.s0.a.c2.b.f.e f2 = c.a.s0.a.c2.b.f.e.f(this.a.getContext(), c.a.s0.a.h.aiapps_cancel_fav_fail);
            f2.l(2);
            f2.G();
        }
    }

    /* loaded from: classes.dex */
    public class h implements c.a.s0.a.q0.b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f6560b;

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
            this.f6560b = aVar;
            this.a = str;
        }

        @Override // c.a.s0.a.q0.b.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.s0.a.c2.b.f.e f2 = c.a.s0.a.c2.b.f.e.f(this.f6560b.getContext(), c.a.s0.a.h.swanapp_tip_net_unavailable);
                f2.l(2);
                f2.G();
            }
        }

        @Override // c.a.s0.a.q0.b.a
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || z) {
                return;
            }
            c.a.s0.a.c2.b.f.e f2 = c.a.s0.a.c2.b.f.e.f(this.f6560b.getContext(), c.a.s0.a.h.aiapps_fav_fail);
            f2.l(2);
            f2.G();
        }

        @Override // c.a.s0.a.q0.b.a
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                c.a.s0.a.j0.b.a.t();
                if (c.a.s0.a.k1.a.k(this.f6560b.getActivity())) {
                    c.a.s0.a.k1.a.p("aboutconcern", this.a);
                    return;
                }
                Context context = this.f6560b.getContext();
                c.a.s0.a.c2.b.f.e g2 = c.a.s0.a.c2.b.f.e.g(context, c.a.s0.a.c1.a.l0().f(context));
                g2.l(2);
                g2.q(2);
                g2.G();
            }
        }
    }

    /* loaded from: classes.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f6561e;

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
            this.f6561e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f6561e.r3();
            }
        }
    }

    /* loaded from: classes.dex */
    public class j implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public FullScreenFloatView f6562e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f6563f;

        /* renamed from: c.a.s0.a.h0.g.a$j$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0376a implements c.a.s0.a.z2.g1.c<Boolean> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ j f6564e;

            public C0376a(j jVar) {
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
                this.f6564e = jVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.a.s0.a.z2.g1.c
            /* renamed from: a */
            public void onCallback(Boolean bool) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                    if (bool.booleanValue()) {
                        c.a.s0.a.e0.a.c(this.f6564e.f6563f.getContext(), true);
                    } else {
                        c.a.s0.a.c1.b.h().a(this.f6564e.f6563f.g0, null);
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
            this.f6563f = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f6563f.g0 == null) {
                return;
            }
            if (a.U0) {
                if (c.a.s0.a.h0.o.e.a.f()) {
                    c.a.s0.a.e0.a.d(this.f6563f.getContext());
                    return;
                }
                if (this.f6562e == null) {
                    this.f6562e = c.a.s0.a.g1.f.U().n(this.f6563f.g0);
                }
                if (this.f6563f.S1()) {
                    if (c.a.s0.a.e0.a.a()) {
                        c.a.s0.a.e0.a.c(this.f6563f.getContext(), false);
                        return;
                    } else {
                        c.a.s0.a.c1.b.h().f(new C0376a(this));
                        return;
                    }
                }
                this.f6562e.setVisibility(this.f6562e.getVisibility() == 0 ? 8 : 0);
            } else if (this.f6563f.S1()) {
                this.f6563f.s3();
            } else {
                c.a.s0.a.e0.a.d(this.f6563f.getContext());
            }
        }
    }

    /* loaded from: classes.dex */
    public class k implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public SwanAppPropertyWindow f6565e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f6566f;

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
            this.f6566f = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f6565e == null) {
                    this.f6565e = c.a.s0.a.g1.f.U().J(this.f6566f.g0);
                }
                this.f6565e.setVisibility(this.f6565e.getVisibility() == 0 ? 8 : 0);
            }
        }
    }

    /* loaded from: classes.dex */
    public class l implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.s0.a.f1.e.b f6567e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.s0.a.d2.e f6568f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f6569g;

        /* renamed from: c.a.s0.a.h0.g.a$l$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class DialogInterface$OnClickListenerC0377a implements DialogInterface.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public DialogInterface$OnClickListenerC0377a(l lVar) {
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

        public l(a aVar, c.a.s0.a.f1.e.b bVar, c.a.s0.a.d2.e eVar) {
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
            this.f6569g = aVar;
            this.f6567e = bVar;
            this.f6568f = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f6569g.g0 == null) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("ENABLE V8: ");
            sb.append(c.a.s0.a.h0.u.g.U().r0());
            sb.append(StringUtils.LF);
            sb.append("APS VERSION: ");
            sb.append(TextUtils.isEmpty(this.f6567e.v1()) ? "" : this.f6567e.v1());
            sb.append(StringUtils.LF);
            sb.append("APPID VERSION: ");
            sb.append(c.a.s0.a.v.a.c(this.f6568f.f5779f));
            sb.append(StringUtils.LF);
            String formatFileSize = Formatter.formatFileSize(AppRuntime.getAppContext(), this.f6567e.i1());
            sb.append("小程序包大小: ");
            sb.append(TextUtils.isEmpty(formatFileSize) ? "" : formatFileSize);
            sb.append("(");
            sb.append(this.f6567e.i1());
            sb.append(SmallTailInfo.EMOTION_SUFFIX);
            sb.append(StringUtils.LF);
            SwanAppAlertDialog.a aVar = new SwanAppAlertDialog.a(this.f6569g.g0);
            aVar.V(this.f6569g.g0.getResources().getString(c.a.s0.a.h.aiapps_show_ext_info_title));
            aVar.x(sb.toString());
            aVar.n(new c.a.s0.a.a3.h.a());
            aVar.m(false);
            aVar.O(c.a.s0.a.h.aiapps_confirm, new DialogInterface$OnClickListenerC0377a(this));
            aVar.X();
        }
    }

    /* loaded from: classes.dex */
    public class m implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f6570e;

        /* renamed from: c.a.s0.a.h0.g.a$m$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class DialogInterface$OnClickListenerC0378a implements DialogInterface.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public DialogInterface$OnClickListenerC0378a(m mVar) {
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
            this.f6570e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f6570e.g0 == null) {
                return;
            }
            String e2 = c.a.s0.a.q2.a.c().e(1);
            String string = this.f6570e.g0.getResources().getString(c.a.s0.a.h.ai_games_debug_game_core_version);
            SwanAppAlertDialog.a aVar = new SwanAppAlertDialog.a(this.f6570e.g0);
            aVar.V(string);
            aVar.x(e2);
            aVar.n(new c.a.s0.a.a3.h.a());
            aVar.m(false);
            aVar.O(c.a.s0.a.h.aiapps_confirm, new DialogInterface$OnClickListenerC0378a(this));
            aVar.X();
        }
    }

    /* loaded from: classes.dex */
    public class n implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f6571e;

        /* renamed from: c.a.s0.a.h0.g.a$n$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0379a extends j.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ n a;

            /* renamed from: c.a.s0.a.h0.g.a$n$a$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public class RunnableC0380a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ String f6572e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ C0379a f6573f;

                public RunnableC0380a(C0379a c0379a, String str) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {c0379a, str};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f6573f = c0379a;
                    this.f6572e = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        SwanAppAlertDialog.a aVar = new SwanAppAlertDialog.a(this.f6573f.a.f6571e.g0);
                        aVar.U(c.a.s0.a.h.aiapps_debug_report_performance);
                        aVar.x(this.f6572e);
                        aVar.n(new c.a.s0.a.a3.h.a());
                        aVar.m(false);
                        aVar.O(c.a.s0.a.h.aiapps_confirm, null);
                        aVar.X();
                    }
                }
            }

            public C0379a(n nVar) {
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
                this.a = nVar;
            }

            @Override // c.a.s0.a.u1.j.a
            public void c(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    this.a.f6571e.g0.runOnUiThread(new RunnableC0380a(this, str));
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
            this.f6571e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f6571e.g0 == null) {
                return;
            }
            c.a.s0.a.u1.j.e().g(new C0379a(this));
        }
    }

    /* loaded from: classes.dex */
    public class o implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public c.a.s0.a.e0.h.a f6574e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f6575f;

        /* renamed from: c.a.s0.a.h0.g.a$o$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class DialogInterface$OnClickListenerC0381a implements DialogInterface.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ o f6576e;

            public DialogInterface$OnClickListenerC0381a(o oVar) {
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
                this.f6576e = oVar;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                    c.a.s0.a.e0.h.a.g(1);
                    this.f6576e.f6574e = new c.a.s0.a.e0.h.a(c.a.s0.a.c1.a.c());
                    this.f6576e.f6574e.h();
                }
            }
        }

        /* loaded from: classes.dex */
        public class b implements DialogInterface.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ o f6577e;

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
                this.f6577e = oVar;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                    this.f6577e.b();
                    c.a.s0.a.e0.h.a.g(2);
                    System.exit(0);
                }
            }
        }

        /* loaded from: classes.dex */
        public class c implements DialogInterface.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ o f6578e;

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
                this.f6578e = oVar;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                    this.f6578e.b();
                    c.a.s0.a.e0.h.a.g(0);
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
            this.f6575f = aVar;
        }

        public final void b() {
            c.a.s0.a.e0.h.a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (aVar = this.f6574e) == null) {
                return;
            }
            aVar.i();
            this.f6574e = null;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
                SwanAppAlertDialog.a aVar = new SwanAppAlertDialog.a(this.f6575f.g0);
                aVar.U(c.a.s0.a.h.aiapps_debug_start_inspect);
                aVar.v(c.a.s0.a.h.aiapps_debug_inspect_message);
                aVar.n(new c.a.s0.a.a3.h.a());
                aVar.m(true);
                if (c.a.s0.a.e0.h.a.e() == 0) {
                    aVar.O(c.a.s0.a.h.aiapps_debug_inspect_normal, new DialogInterface$OnClickListenerC0381a(this));
                }
                if (c.a.s0.a.e0.h.a.e() != 2) {
                    aVar.H(c.a.s0.a.h.aiapps_debug_inspect_enhance, new b(this));
                }
                if (c.a.s0.a.e0.h.a.e() != 0) {
                    aVar.B(c.a.s0.a.h.swanapp_close, new c(this));
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
        public final /* synthetic */ a f6579e;

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
            this.f6579e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f6579e.W2();
                this.f6579e.d3("click", "baozhang");
            }
        }
    }

    /* loaded from: classes.dex */
    public class q implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f6580e;

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
            this.f6580e = aVar;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                this.f6580e.Z2();
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1474116815, "Lc/a/s0/a/h0/g/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1474116815, "Lc/a/s0/a/h0/g/a;");
                return;
            }
        }
        U0 = c.a.s0.a.k.a;
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
        this.N0 = new long[5];
    }

    public static a k3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? new a() : (a) invokeV.objValue;
    }

    @Override // c.a.s0.a.h0.g.d
    public void G2() {
        c.a.s0.a.h0.g.g V;
        c.a.s0.a.h0.g.f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (V = c.a.s0.a.g1.f.U().V()) == null || (fVar = (c.a.s0.a.h0.g.f) V.n(c.a.s0.a.h0.g.f.class)) == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, fVar.n3());
        c.a.s0.a.g1.f.U().u(new c.a.s0.a.o0.d.c("sharebtn", hashMap));
        d3("click", "aboutshare");
    }

    @Override // c.a.s0.a.h0.g.d
    public boolean K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.s0.a.h0.g.d
    public void O1(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) {
            P1(view);
            if (!S1()) {
                D2(false);
            }
            u2(true);
            n2(-1);
            w2(-16777216);
            p2(null);
            r2(true);
        }
    }

    @NonNull
    public final String V2(@NonNull String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, str2)) == null) {
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

    @Override // c.a.s0.a.h0.g.d
    public boolean W1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void W2() {
        SwanAppActivity activity;
        c.a.s0.a.d2.e a0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (activity = c.a.s0.a.g1.f.U().getActivity()) == null || (a0 = c.a.s0.a.d2.e.a0()) == null) {
            return;
        }
        SwanAppWebPopWindow swanAppWebPopWindow = this.T0;
        if (swanAppWebPopWindow == null || !swanAppWebPopWindow.x()) {
            SwanAppWebPopWindow swanAppWebPopWindow2 = new SwanAppWebPopWindow(activity, "https://baozhang.baidu.com/guarantee/baoshowdetail?appkey=" + a0.N());
            this.T0 = swanAppWebPopWindow2;
            swanAppWebPopWindow2.q0(c.a.s0.a.h.swan_app_baidu_guarantee_title);
            swanAppWebPopWindow2.m0(SwanAppWebPopWindow.CloseStyle.CLOSE_AT_BOTTOM);
            swanAppWebPopWindow2.n0();
            swanAppWebPopWindow2.l0();
            swanAppWebPopWindow2.s0();
        }
    }

    public final void X2() {
        SwanAppActivity activity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (activity = c.a.s0.a.g1.f.U().getActivity()) == null || c.a.s0.a.d2.e.a0() == null) {
            return;
        }
        SwanAppWebPopWindow swanAppWebPopWindow = this.T0;
        if (swanAppWebPopWindow == null || !swanAppWebPopWindow.x()) {
            SwanAppWebPopWindow swanAppWebPopWindow2 = new SwanAppWebPopWindow(activity, this.Q0);
            this.T0 = swanAppWebPopWindow2;
            swanAppWebPopWindow2.r0(I(c.a.s0.a.h.swan_app_service_agreement));
            swanAppWebPopWindow2.o0(activity.getResources().getDimensionPixelSize(c.a.s0.a.d.swan_half_screen_evalute_height));
            swanAppWebPopWindow2.m0(SwanAppWebPopWindow.CloseStyle.CLOSE_AT_RIGHT);
            swanAppWebPopWindow2.l0();
            swanAppWebPopWindow2.s0();
            d3("click", "servicenote");
        }
    }

    @Override // c.a.s0.a.h0.g.d
    public boolean Y1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void Y2() {
        c.a.s0.a.d2.e a0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (a0 = c.a.s0.a.d2.e.a0()) == null) {
            return;
        }
        b.a V = a0.V();
        String J = V.J();
        String F = V.F();
        if (!TextUtils.isEmpty(J) && !TextUtils.isEmpty(F)) {
            String h2 = q0.h(J, F);
            UnitedSchemeMainDispatcher unitedSchemeMainDispatcher = new UnitedSchemeMainDispatcher();
            unitedSchemeMainDispatcher.setDynamicDispatcher("swanAPI", new c.a.s0.a.f2.e());
            UnitedSchemeEntity unitedSchemeEntity = new UnitedSchemeEntity(Uri.parse(h2), UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE);
            unitedSchemeEntity.setOnlyVerify(false);
            unitedSchemeMainDispatcher.dispatch(this.g0, unitedSchemeEntity);
            boolean z = U0;
            return;
        }
        boolean z2 = U0;
    }

    public final void Z2() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || this.g0 == null) {
            return;
        }
        String str = c.a.s0.a.d2.d.J().r().V().f0().webUrl;
        if (TextUtils.isEmpty(str)) {
            r0.b(this.g0).c("");
            c.a.s0.a.c2.b.f.e.f(this.g0, c.a.s0.a.h.swanapp_web_url_copy_fail).G();
            return;
        }
        String V2 = V2(str, c.a.s0.a.m1.b.b(q0.n()));
        int i2 = c.a.s0.a.h.swanapp_web_url_copy_success;
        if (V2.length() > PluginCenter.PLUGIN_RETRY_MIN_TIME_INTERVAL) {
            i2 = c.a.s0.a.h.swanapp_web_url_param_to_long;
        } else {
            str = V2;
        }
        r0.b(this.g0).c(str);
        c.a.s0.a.c2.b.f.e.f(this.g0, i2).G();
    }

    public final void a3() {
        SwanAppWebPopWindow swanAppWebPopWindow;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && U() && (swanAppWebPopWindow = this.T0) != null) {
            swanAppWebPopWindow.r();
        }
    }

    public final void b3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            if (c.a.s0.a.x1.a.a.H()) {
                boolean z = U0;
                c.a.s0.a.c2.b.f.e.f(getContext(), c.a.s0.a.h.aiapps_debug_forbid_favor).G();
                return;
            }
            String f2 = q0.n().f();
            SwanFavorDataManager.h().b(str, new h(this, f2));
            c.a.s0.a.k1.a.p("aboutconcern", f2);
        }
    }

    public final void c3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            SwanFavorDataManager h2 = SwanFavorDataManager.h();
            g gVar = new g(this);
            c.a.s0.a.n0.l.c l2 = c.a.s0.a.n0.l.c.l();
            l2.n(3);
            h2.c(str, gVar, l2.k());
            d3("click", "aboutmove");
        }
    }

    @Override // c.a.s0.a.h0.g.d
    public void d2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && S1()) {
            g3();
            this.q0.v(c.a.s0.a.c1.a.M().a());
        }
    }

    public final void d3(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, str, str2) == null) {
            c.a.s0.a.n2.s.f fVar = new c.a.s0.a.n2.s.f();
            if (!TextUtils.isEmpty(str)) {
                fVar.f8219b = str;
            }
            if (!TextUtils.isEmpty(str2)) {
                fVar.f8222e = str2;
            }
            u1(fVar);
        }
    }

    public final void e3(@NonNull View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, view) == null) {
            String b2 = c.a.s0.a.h0.g.b.b();
            c.a.s0.a.o2.g.g a = c.a.s0.a.h0.g.b.a();
            Button button = (Button) view.findViewById(c.a.s0.a.f.btn_ues_offline_perftool);
            button.setVisibility(0);
            if (a.getInt(b2, -1) == 1) {
                button.setText(c.a.s0.a.h.swan_offline_perf_tool_disable);
            } else {
                button.setText(c.a.s0.a.h.swan_offline_perf_tool_enable);
            }
            button.setOnClickListener(new b(this, a, b2, new C0371a(this, a, b2)));
        }
    }

    public final void f3(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            n0.N(this.K0, this.L0, String.valueOf(i2));
        }
    }

    public void g3() {
        FragmentActivity activity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && (activity = getActivity()) != null && this.q0 == null) {
            c.a.s0.n.n nVar = new c.a.s0.n.n(activity, this.k0, 13, c.a.s0.a.c1.a.K(), new c.a.s0.a.a3.h.b());
            this.q0 = nVar;
            nVar.t(q0.P());
            new c.a.s0.a.k1.a(this.q0, this).z();
        }
    }

    public final void h3(View view) {
        c.a.s0.a.d2.e a0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, view) == null) || (a0 = c.a.s0.a.d2.e.a0()) == null || a0.V() == null) {
            return;
        }
        b.a V = a0.V();
        this.J0 = (SwanAppRoundedImageView) view.findViewById(c.a.s0.a.f.aiapps_icon);
        TextView textView = (TextView) view.findViewById(c.a.s0.a.f.aiapps_title);
        textView.setText(V.K());
        if (V.G() == 0) {
            c.a.s0.a.a3.f.a(textView, new i(this));
        }
        c.a.s0.a.u1.k.f.j().n().h(textView);
        TextView textView2 = (TextView) view.findViewById(c.a.s0.a.f.aiapps_description);
        textView2.setText(V.e1());
        Button button = (Button) view.findViewById(c.a.s0.a.f.share_friends);
        button.setOnClickListener(this);
        Button button2 = (Button) view.findViewById(c.a.s0.a.f.add_favor);
        this.R0 = button2;
        button2.setOnClickListener(this);
        t3();
        if (c.a.s0.a.c1.a.y0().d()) {
            button.setVisibility(8);
            this.R0.setVisibility(8);
        }
        if (!c.a.s0.a.c1.a.t().b()) {
            this.R0.setVisibility(8);
        }
        c.a.s0.a.h0.g.g V2 = c.a.s0.a.g1.f.U().V();
        if (V2 == null) {
            return;
        }
        if (V2.n(c.a.s0.a.c1.b.c().a()) != null) {
            button.setVisibility(8);
            this.R0.setVisibility(8);
        }
        c.a.s0.t.d.b().a(textView2);
        ((TextView) view.findViewById(c.a.s0.a.f.service_category_value)).setText(V.s1());
        ((TextView) view.findViewById(c.a.s0.a.f.subject_info_value)).setText(V.t1());
        String G = c.a.s0.a.c1.a.o().G();
        this.Q0 = G;
        if (!TextUtils.isEmpty(G)) {
            View findViewById = view.findViewById(c.a.s0.a.f.agreement_layout);
            findViewById.setVisibility(0);
            findViewById.setOnClickListener(this);
        }
        this.S0 = (RecyclerView) view.findViewById(c.a.s0.a.f.related_swan_app_list);
        PMSAppInfo f0 = V.f0();
        if (j3(f0)) {
            o3(view, f0.brandsInfo);
        }
        this.L0 = (TextView) view.findViewById(c.a.s0.a.f.aiapps_label_tv);
        this.K0 = (BdBaseImageView) view.findViewById(c.a.s0.a.f.aiapps_label_bg);
        this.J0.setImageBitmap(q0.i(V, "SwanAppAboutFragment", false));
        this.J0.setOnClickListener(this);
        SwanAppBearInfo k1 = V.k1();
        if (k1 != null && k1.isValid()) {
            this.M0 = new c.a.s0.a.a3.a(this.g0, view, k1, c.a.s0.a.f.bear_layout);
        }
        f3(V.getType());
        ((Button) view.findViewById(c.a.s0.a.f.open_app_button)).setVisibility(8);
        if (U0 || c.a.s0.a.g1.f.U().N()) {
            View inflate = ((ViewStub) view.findViewById(c.a.s0.a.f.ai_app_console)).inflate();
            if (S1() && (inflate instanceof Button)) {
                ((Button) inflate).setText(V.m0() ? c.a.s0.a.h.aiapps_close_debug_mode : c.a.s0.a.h.aiapps_open_debug_mode);
            }
            inflate.setOnClickListener(new j(this));
            if (!S1()) {
                ((ViewStub) view.findViewById(c.a.s0.a.f.ai_app_property)).inflate().setOnClickListener(new k(this));
            }
            if (S1()) {
                ((ViewStub) view.findViewById(c.a.s0.a.f.ai_app_show_ext_info)).inflate().setOnClickListener(new l(this, V, a0));
            }
            if (S1()) {
                View inflate2 = ((ViewStub) view.findViewById(c.a.s0.a.f.ai_app_swan_core_history_info)).inflate();
                if (inflate2 instanceof Button) {
                    Button button3 = (Button) inflate2;
                    button3.setText(c.a.s0.a.h.ai_games_debug_game_core_version);
                    button3.setOnClickListener(new m(this));
                }
            }
            if (c.a.s0.a.u1.j.e().f()) {
                View inflate3 = ((ViewStub) view.findViewById(c.a.s0.a.f.ai_app_report_performance)).inflate();
                if (inflate3 instanceof Button) {
                    Button button4 = (Button) inflate3;
                    button4.setText(c.a.s0.a.h.aiapps_debug_report_performance);
                    button4.setOnClickListener(new n(this));
                }
            }
            View inflate4 = ((ViewStub) view.findViewById(c.a.s0.a.f.ai_app_start_inspector)).inflate();
            if (inflate4 instanceof Button) {
                ((Button) inflate4).setText(c.a.s0.a.h.aiapps_debug_start_inspect);
            }
            inflate4.setOnClickListener(new o(this));
            if (!S1()) {
                e3(view);
            }
        }
        if (i3(f0)) {
            ImageView imageView = (ImageView) view.findViewById(c.a.s0.a.f.apply_guarantee);
            imageView.setVisibility(0);
            imageView.setOnClickListener(new p(this));
        }
        if (S1()) {
            return;
        }
        m3(this.J0, 2000L, new q(this));
    }

    public final boolean i3(PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, pMSAppInfo)) == null) {
            return (pMSAppInfo == null ? PMSConstants.PayProtected.NO_PAY_PROTECTED.type : pMSAppInfo.payProtected) == PMSConstants.PayProtected.PAY_PROTECTED.type;
        }
        return invokeL.booleanValue;
    }

    public final boolean j3(PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, pMSAppInfo)) == null) ? (c.a.s0.a.d2.d.J().l() != 0 || pMSAppInfo == null || TextUtils.isEmpty(pMSAppInfo.brandsInfo)) ? false : true : invokeL.booleanValue;
    }

    public final void l3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            String N = c.a.s0.a.d2.d.J().r().N();
            if (TextUtils.isEmpty(N)) {
                return;
            }
            if (c.a.s0.a.j0.b.a.n(N)) {
                c3(N);
            } else {
                b3(N);
            }
            t3();
        }
    }

    public final void m3(View view, long j2, View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{view, Long.valueOf(j2), onLongClickListener}) == null) || view == null || onLongClickListener == null || j2 <= 0) {
            return;
        }
        view.setOnTouchListener(new d(this, new c(this, onLongClickListener, view), j2));
    }

    public final void n3() {
        c.a.s0.a.d2.e a0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048599, this) == null) || (a0 = c.a.s0.a.d2.e.a0()) == null) {
            return;
        }
        long[] jArr = this.N0;
        System.arraycopy(jArr, 1, jArr, 0, jArr.length - 1);
        long[] jArr2 = this.N0;
        jArr2[jArr2.length - 1] = SystemClock.uptimeMillis();
        if (this.N0[0] >= SystemClock.uptimeMillis() - 1000) {
            this.N0 = new long[5];
            if (a0.v0()) {
                p3();
            } else {
                r3();
            }
        }
    }

    public final void o3(View view, String str) {
        int length;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048600, this, view, str) == null) {
            if (U0) {
                String str2 = str + "";
            }
            if (TextUtils.isEmpty(str) || view == null) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.O0 = jSONObject.optString("scheme");
                this.P0 = jSONObject.optString("description");
                if (!TextUtils.isEmpty(this.O0) && !TextUtils.isEmpty(this.P0) && (length = this.P0.length()) >= 20) {
                    if (length > 100) {
                        this.P0 = this.P0.substring(0, 100);
                    }
                    LinearLayout linearLayout = (LinearLayout) view.findViewById(c.a.s0.a.f.brands_introduction_ll);
                    linearLayout.setOnClickListener(this);
                    linearLayout.setVisibility(0);
                    ((TextView) view.findViewById(c.a.s0.a.f.brands_introduction_details)).setText(this.P0);
                    SwanAppRelatedSwanListAdapter.doUBCEventStatistic("brand", null, "show");
                    q3();
                }
            } catch (JSONException e2) {
                if (U0) {
                    e2.getMessage();
                }
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, view) == null) {
            int id = view.getId();
            if (id == c.a.s0.a.f.aiapps_icon) {
                n3();
            } else if (id == c.a.s0.a.f.open_app_button) {
                Y2();
            } else if (id == c.a.s0.a.f.brands_introduction_ll) {
                SchemeRouter.invoke(getContext(), this.O0);
                d3("click", "brand");
            } else if (id == c.a.s0.a.f.agreement_layout) {
                X2();
            } else if (id == c.a.s0.a.f.share_friends) {
                G2();
            } else if (id == c.a.s0.a.f.add_favor) {
                l3();
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, bundle) == null) {
            super.onCreate(bundle);
        }
    }

    @Override // c.a.s0.a.h0.g.d, com.baidu.swan.support.v4.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            super.onPause();
            a3();
        }
    }

    @Override // c.a.s0.a.h0.g.d, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            super.onResume();
            c.a.s0.a.a3.a aVar = this.M0;
            if (aVar != null) {
                aVar.c();
            }
            B2(1);
            c.a.s0.n.n nVar = this.q0;
            if (nVar != null && nVar.l()) {
                this.q0.E(c.a.s0.a.c1.a.M().a());
            }
            if (this.R0 != null) {
                t3();
            }
        }
    }

    public final void p3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            String g2 = c.a.s0.a.z2.p.g(this.g0);
            c.a.s0.a.c2.b.f.e.g(AppRuntime.getAppContext(), g2).F();
            c.a.s0.a.e0.d.k("SwanAppAboutFragment", "showExtraInfo\n" + g2);
        }
    }

    public final void q3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
            linearLayoutManager.setOrientation(1);
            this.S0.setLayoutManager(linearLayoutManager);
            SwanAppRelatedSwanListAdapter swanAppRelatedSwanListAdapter = new SwanAppRelatedSwanListAdapter(getContext());
            this.S0.setAdapter(swanAppRelatedSwanListAdapter);
            c.a.s0.a.b2.b.c(new e(this, swanAppRelatedSwanListAdapter));
        }
    }

    public final void r3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            boolean z = U0;
            c.a.s0.a.h0.g.g V = c.a.s0.a.g1.f.U().V();
            if (V == null) {
                c.a.s0.a.c2.b.f.e.f(getContext(), c.a.s0.a.h.aiapps_open_fragment_failed_toast).G();
                return;
            }
            g.b i2 = V.i("navigateTo");
            i2.n(c.a.s0.a.h0.g.g.f6641g, c.a.s0.a.h0.g.g.f6643i);
            i2.k("running_info", null).a();
        }
    }

    public final void s3() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048608, this) == null) || c.a.s0.a.d2.e.a0() == null) {
            return;
        }
        c.a.s0.a.h0.e.c.a(c.a.s0.a.d2.e.a0(), this.g0, new f(this));
    }

    public final void t3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            if (c.a.s0.a.j0.b.a.n(c.a.s0.a.d2.d.J().getAppId())) {
                this.R0.setText(c.a.s0.a.h.swanapp_favored);
                this.R0.setTextColor(AppCompatResources.getColorStateList(getContext(), c.a.s0.a.c.swan_app_about_attentation_text_selector));
                this.R0.setBackgroundResource(c.a.s0.a.e.swan_app_about_cancel_attention_selector);
                return;
            }
            this.R0.setText(c.a.s0.a.h.swanapp_add_favor);
            this.R0.setTextColor(-1);
            this.R0.setBackgroundResource(c.a.s0.a.e.swan_app_about_attention_selector);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View w0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048610, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(c.a.s0.a.g.aiapps_about_fragment, viewGroup, false);
            O1(inflate);
            h3(inflate);
            if (N1()) {
                inflate = Q1(inflate);
            }
            return x1(inflate, this);
        }
        return (View) invokeLLL.objValue;
    }
}
