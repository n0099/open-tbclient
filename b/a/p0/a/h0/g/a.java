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
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b.a.p0.a.b2.a;
import b.a.p0.a.b2.b;
import b.a.p0.a.f1.e.b;
import b.a.p0.a.h0.e.c;
import b.a.p0.a.h0.g.g;
import b.a.p0.a.u1.j;
import b.a.p0.a.z2.n0;
import b.a.p0.a.z2.q0;
import b.a.p0.a.z2.r0;
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
    public static final boolean T0;
    public transient /* synthetic */ FieldHolder $fh;
    public SwanAppRoundedImageView I0;
    public BdBaseImageView J0;
    public TextView K0;
    public b.a.p0.a.a3.a L0;
    public long[] M0;
    public String N0;
    public String O0;
    public String P0;
    public Button Q0;
    public RecyclerView R0;
    public SwanAppWebPopWindow S0;

    /* renamed from: b.a.p0.a.h0.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0202a implements b.a.p0.d.i.a<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.o2.g.g f5368a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f5369b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f5370c;

        /* renamed from: b.a.p0.a.h0.g.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class DialogInterface$OnClickListenerC0203a implements DialogInterface.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public DialogInterface$OnClickListenerC0203a(C0202a c0202a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c0202a};
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
                    SwanAppActivity x = b.a.p0.a.d2.d.J().x();
                    if (x != null && Build.VERSION.SDK_INT >= 21) {
                        x.finishAndRemoveTask();
                    }
                    System.exit(0);
                }
            }
        }

        public C0202a(a aVar, b.a.p0.a.o2.g.g gVar, String str) {
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
            this.f5370c = aVar;
            this.f5368a = gVar;
            this.f5369b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.d.i.a
        /* renamed from: a */
        public void run(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                if (bool != null && bool.booleanValue()) {
                    this.f5368a.putInt(this.f5369b, 1);
                } else {
                    this.f5368a.putInt(this.f5369b, 0);
                }
                SwanAppAlertDialog.a aVar = new SwanAppAlertDialog.a(this.f5370c.l0);
                aVar.U(b.a.p0.a.h.swan_offline_perf_tool_tip);
                aVar.v(b.a.p0.a.h.swan_offline_perf_tool_message);
                aVar.n(new b.a.p0.a.a3.h.a());
                aVar.O(b.a.p0.a.h.aiapps_confirm, new DialogInterface$OnClickListenerC0203a(this));
                aVar.X();
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.o2.g.g f5371e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f5372f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.d.i.a f5373g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ a f5374h;

        /* renamed from: b.a.p0.a.h0.g.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0204a implements c.b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f5375a;

            public C0204a(b bVar) {
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
                this.f5375a = bVar;
            }

            @Override // b.a.p0.a.h0.e.c.b
            public void a(boolean z, String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeZL(1048576, this, z, str) == null) {
                    if (z) {
                        this.f5375a.f5373g.run(Boolean.TRUE);
                        return;
                    }
                    Activity activity = this.f5375a.f5374h.l0;
                    if (activity == null || activity.isDestroyed()) {
                        return;
                    }
                    b.a.p0.a.h0.e.c.b(this.f5375a.f5374h.l0, b.a.p0.a.h.swan_offline_perf_tool_tip, str);
                }
            }
        }

        public b(a aVar, b.a.p0.a.o2.g.g gVar, String str, b.a.p0.d.i.a aVar2) {
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
            this.f5374h = aVar;
            this.f5371e = gVar;
            this.f5372f = str;
            this.f5373g = aVar2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                int i2 = this.f5371e.getInt(this.f5372f, -1);
                if (i2 == 1) {
                    this.f5373g.run(Boolean.FALSE);
                } else if (i2 == 0) {
                    this.f5373g.run(Boolean.TRUE);
                } else {
                    b.a.p0.a.d2.e a0 = b.a.p0.a.d2.e.a0();
                    if (a0 == null) {
                        return;
                    }
                    b.a.p0.a.h0.e.c.a(a0, this.f5374h.l0, new C0204a(this));
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View.OnLongClickListener f5376e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ View f5377f;

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
            this.f5376e = onLongClickListener;
            this.f5377f = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.a.p0.a.r2.k.b.a.d().g();
                this.f5376e.onLongClick(this.f5377f);
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Runnable f5378e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f5379f;

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
            this.f5378e = runnable;
            this.f5379f = j;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                int action = motionEvent.getAction();
                if (action == 0) {
                    view.postDelayed(this.f5378e, this.f5379f);
                    return false;
                } else if (action == 1 || action == 3) {
                    view.removeCallbacks(this.f5378e);
                    return false;
                } else {
                    return false;
                }
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes.dex */
    public class e implements b.InterfaceC0124b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SwanAppRelatedSwanListAdapter f5380a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f5381b;

        /* renamed from: b.a.p0.a.h0.g.a$e$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0205a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b.a.p0.a.b2.a f5382e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ e f5383f;

            public RunnableC0205a(e eVar, b.a.p0.a.b2.a aVar) {
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
                this.f5383f = eVar;
                this.f5382e = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f5383f.f5381b.R0.setVisibility(0);
                    this.f5383f.f5380a.updateData(this.f5382e);
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
            this.f5381b = aVar;
            this.f5380a = swanAppRelatedSwanListAdapter;
        }

        @Override // b.a.p0.a.b2.b.InterfaceC0124b
        public void a(b.a.p0.a.b2.a aVar) {
            List<a.C0123a> list;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null || (list = aVar.f4153a) == null || list.size() <= 0) {
                return;
            }
            q0.e0(new RunnableC0205a(this, aVar));
            SwanAppRelatedSwanListAdapter.doUBCEventStatistic("aboutrelated", null, "show");
        }
    }

    /* loaded from: classes.dex */
    public class f implements c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f5384a;

        /* renamed from: b.a.p0.a.h0.g.a$f$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0206a implements b.a.p0.a.z2.g1.c<Boolean> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ f f5385e;

            public C0206a(f fVar) {
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
                this.f5385e = fVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // b.a.p0.a.z2.g1.c
            /* renamed from: a */
            public void onCallback(Boolean bool) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                    if (bool.booleanValue()) {
                        b.a.p0.a.e0.a.d(this.f5385e.f5384a.getContext());
                    } else {
                        b.a.p0.a.c1.b.h().a(this.f5385e.f5384a.l0, null);
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
            this.f5384a = aVar;
        }

        @Override // b.a.p0.a.h0.e.c.b
        public void a(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, str) == null) {
                if (!z) {
                    b.a.p0.a.h0.e.c.c(this.f5384a.l0, str);
                } else if (b.a.p0.a.e0.a.a()) {
                    b.a.p0.a.e0.a.d(this.f5384a.getContext());
                } else {
                    b.a.p0.a.c1.b.h().f(new C0206a(this));
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class g implements b.a.p0.a.q0.b.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f5386a;

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
            this.f5386a = aVar;
        }

        @Override // b.a.p0.a.q0.b.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.a.p0.a.c2.b.f.e f2 = b.a.p0.a.c2.b.f.e.f(this.f5386a.getContext(), b.a.p0.a.h.swanapp_tip_net_unavailable);
                f2.l(2);
                f2.G();
            }
        }

        @Override // b.a.p0.a.q0.b.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                b.a.p0.a.c2.b.f.e f2 = b.a.p0.a.c2.b.f.e.f(this.f5386a.getContext(), b.a.p0.a.h.aiapps_cancel_fav_success);
                f2.l(2);
                f2.G();
            }
        }

        @Override // b.a.p0.a.q0.b.b
        public void c(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) || z) {
                return;
            }
            b.a.p0.a.c2.b.f.e f2 = b.a.p0.a.c2.b.f.e.f(this.f5386a.getContext(), b.a.p0.a.h.aiapps_cancel_fav_fail);
            f2.l(2);
            f2.G();
        }
    }

    /* loaded from: classes.dex */
    public class h implements b.a.p0.a.q0.b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f5387a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f5388b;

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
            this.f5388b = aVar;
            this.f5387a = str;
        }

        @Override // b.a.p0.a.q0.b.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.a.p0.a.c2.b.f.e f2 = b.a.p0.a.c2.b.f.e.f(this.f5388b.getContext(), b.a.p0.a.h.swanapp_tip_net_unavailable);
                f2.l(2);
                f2.G();
            }
        }

        @Override // b.a.p0.a.q0.b.a
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || z) {
                return;
            }
            b.a.p0.a.c2.b.f.e f2 = b.a.p0.a.c2.b.f.e.f(this.f5388b.getContext(), b.a.p0.a.h.aiapps_fav_fail);
            f2.l(2);
            f2.G();
        }

        @Override // b.a.p0.a.q0.b.a
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                b.a.p0.a.j0.b.a.t();
                if (b.a.p0.a.k1.a.k(this.f5388b.getActivity())) {
                    b.a.p0.a.k1.a.p("aboutconcern", this.f5387a);
                    return;
                }
                Context context = this.f5388b.getContext();
                b.a.p0.a.c2.b.f.e g2 = b.a.p0.a.c2.b.f.e.g(context, b.a.p0.a.c1.a.l0().f(context));
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
        public final /* synthetic */ a f5389e;

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
            this.f5389e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f5389e.u3();
            }
        }
    }

    /* loaded from: classes.dex */
    public class j implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public FullScreenFloatView f5390e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f5391f;

        /* renamed from: b.a.p0.a.h0.g.a$j$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0207a implements b.a.p0.a.z2.g1.c<Boolean> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ j f5392e;

            public C0207a(j jVar) {
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
                this.f5392e = jVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // b.a.p0.a.z2.g1.c
            /* renamed from: a */
            public void onCallback(Boolean bool) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                    if (bool.booleanValue()) {
                        b.a.p0.a.e0.a.c(this.f5392e.f5391f.getContext(), true);
                    } else {
                        b.a.p0.a.c1.b.h().a(this.f5392e.f5391f.l0, null);
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
            this.f5391f = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f5391f.l0 == null) {
                return;
            }
            if (a.T0) {
                if (b.a.p0.a.h0.o.e.a.f()) {
                    b.a.p0.a.e0.a.d(this.f5391f.getContext());
                    return;
                }
                if (this.f5390e == null) {
                    this.f5390e = b.a.p0.a.g1.f.U().m(this.f5391f.l0);
                }
                if (this.f5391f.V1()) {
                    if (b.a.p0.a.e0.a.a()) {
                        b.a.p0.a.e0.a.c(this.f5391f.getContext(), false);
                        return;
                    } else {
                        b.a.p0.a.c1.b.h().f(new C0207a(this));
                        return;
                    }
                }
                this.f5390e.setVisibility(this.f5390e.getVisibility() == 0 ? 8 : 0);
            } else if (this.f5391f.V1()) {
                this.f5391f.v3();
            } else {
                b.a.p0.a.e0.a.d(this.f5391f.getContext());
            }
        }
    }

    /* loaded from: classes.dex */
    public class k implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public SwanAppPropertyWindow f5393e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f5394f;

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
            this.f5394f = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f5393e == null) {
                    this.f5393e = b.a.p0.a.g1.f.U().J(this.f5394f.l0);
                }
                this.f5393e.setVisibility(this.f5393e.getVisibility() == 0 ? 8 : 0);
            }
        }
    }

    /* loaded from: classes.dex */
    public class l implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.f1.e.b f5395e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.d2.e f5396f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f5397g;

        /* renamed from: b.a.p0.a.h0.g.a$l$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class DialogInterface$OnClickListenerC0208a implements DialogInterface.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public DialogInterface$OnClickListenerC0208a(l lVar) {
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

        public l(a aVar, b.a.p0.a.f1.e.b bVar, b.a.p0.a.d2.e eVar) {
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
            this.f5397g = aVar;
            this.f5395e = bVar;
            this.f5396f = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f5397g.l0 == null) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("ENABLE V8: ");
            sb.append(b.a.p0.a.h0.u.g.U().r0());
            sb.append(StringUtils.LF);
            sb.append("APS VERSION: ");
            sb.append(TextUtils.isEmpty(this.f5395e.v1()) ? "" : this.f5395e.v1());
            sb.append(StringUtils.LF);
            sb.append("APPID VERSION: ");
            sb.append(b.a.p0.a.v.a.c(this.f5396f.f4474f));
            sb.append(StringUtils.LF);
            String formatFileSize = Formatter.formatFileSize(AppRuntime.getAppContext(), this.f5395e.i1());
            sb.append("小程序包大小: ");
            sb.append(TextUtils.isEmpty(formatFileSize) ? "" : formatFileSize);
            sb.append("(");
            sb.append(this.f5395e.i1());
            sb.append(SmallTailInfo.EMOTION_SUFFIX);
            sb.append(StringUtils.LF);
            SwanAppAlertDialog.a aVar = new SwanAppAlertDialog.a(this.f5397g.l0);
            aVar.V(this.f5397g.l0.getResources().getString(b.a.p0.a.h.aiapps_show_ext_info_title));
            aVar.x(sb.toString());
            aVar.n(new b.a.p0.a.a3.h.a());
            aVar.m(false);
            aVar.O(b.a.p0.a.h.aiapps_confirm, new DialogInterface$OnClickListenerC0208a(this));
            aVar.X();
        }
    }

    /* loaded from: classes.dex */
    public class m implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f5398e;

        /* renamed from: b.a.p0.a.h0.g.a$m$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class DialogInterface$OnClickListenerC0209a implements DialogInterface.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public DialogInterface$OnClickListenerC0209a(m mVar) {
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
            this.f5398e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f5398e.l0 == null) {
                return;
            }
            String e2 = b.a.p0.a.q2.a.c().e(1);
            String string = this.f5398e.l0.getResources().getString(b.a.p0.a.h.ai_games_debug_game_core_version);
            SwanAppAlertDialog.a aVar = new SwanAppAlertDialog.a(this.f5398e.l0);
            aVar.V(string);
            aVar.x(e2);
            aVar.n(new b.a.p0.a.a3.h.a());
            aVar.m(false);
            aVar.O(b.a.p0.a.h.aiapps_confirm, new DialogInterface$OnClickListenerC0209a(this));
            aVar.X();
        }
    }

    /* loaded from: classes.dex */
    public class n implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f5399e;

        /* renamed from: b.a.p0.a.h0.g.a$n$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0210a extends j.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ n f5400a;

            /* renamed from: b.a.p0.a.h0.g.a$n$a$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public class RunnableC0211a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ String f5401e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ C0210a f5402f;

                public RunnableC0211a(C0210a c0210a, String str) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {c0210a, str};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f5402f = c0210a;
                    this.f5401e = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        SwanAppAlertDialog.a aVar = new SwanAppAlertDialog.a(this.f5402f.f5400a.f5399e.l0);
                        aVar.U(b.a.p0.a.h.aiapps_debug_report_performance);
                        aVar.x(this.f5401e);
                        aVar.n(new b.a.p0.a.a3.h.a());
                        aVar.m(false);
                        aVar.O(b.a.p0.a.h.aiapps_confirm, null);
                        aVar.X();
                    }
                }
            }

            public C0210a(n nVar) {
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
                this.f5400a = nVar;
            }

            @Override // b.a.p0.a.u1.j.a
            public void c(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    this.f5400a.f5399e.l0.runOnUiThread(new RunnableC0211a(this, str));
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
            this.f5399e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f5399e.l0 == null) {
                return;
            }
            b.a.p0.a.u1.j.e().g(new C0210a(this));
        }
    }

    /* loaded from: classes.dex */
    public class o implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public b.a.p0.a.e0.h.a f5403e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f5404f;

        /* renamed from: b.a.p0.a.h0.g.a$o$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class DialogInterface$OnClickListenerC0212a implements DialogInterface.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ o f5405e;

            public DialogInterface$OnClickListenerC0212a(o oVar) {
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
                this.f5405e = oVar;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                    b.a.p0.a.e0.h.a.g(1);
                    this.f5405e.f5403e = new b.a.p0.a.e0.h.a(b.a.p0.a.c1.a.c());
                    this.f5405e.f5403e.h();
                }
            }
        }

        /* loaded from: classes.dex */
        public class b implements DialogInterface.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ o f5406e;

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
                this.f5406e = oVar;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                    this.f5406e.b();
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
            public final /* synthetic */ o f5407e;

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
                this.f5407e = oVar;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                    this.f5407e.b();
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
            this.f5404f = aVar;
        }

        public final void b() {
            b.a.p0.a.e0.h.a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (aVar = this.f5403e) == null) {
                return;
            }
            aVar.i();
            this.f5403e = null;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
                SwanAppAlertDialog.a aVar = new SwanAppAlertDialog.a(this.f5404f.l0);
                aVar.U(b.a.p0.a.h.aiapps_debug_start_inspect);
                aVar.v(b.a.p0.a.h.aiapps_debug_inspect_message);
                aVar.n(new b.a.p0.a.a3.h.a());
                aVar.m(true);
                if (b.a.p0.a.e0.h.a.e() == 0) {
                    aVar.O(b.a.p0.a.h.aiapps_debug_inspect_normal, new DialogInterface$OnClickListenerC0212a(this));
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
        public final /* synthetic */ a f5408e;

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
            this.f5408e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f5408e.Z2();
                this.f5408e.g3(PrefetchEvent.STATE_CLICK, "baozhang");
            }
        }
    }

    /* loaded from: classes.dex */
    public class q implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f5409e;

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
            this.f5409e = aVar;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                this.f5409e.c3();
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
        T0 = b.a.p0.a.k.f6863a;
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
        this.M0 = new long[5];
    }

    public static a n3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? new a() : (a) invokeV.objValue;
    }

    @Override // b.a.p0.a.h0.g.d
    public void J2() {
        b.a.p0.a.h0.g.g V;
        b.a.p0.a.h0.g.f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (V = b.a.p0.a.g1.f.U().V()) == null || (fVar = (b.a.p0.a.h0.g.f) V.n(b.a.p0.a.h0.g.f.class)) == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, fVar.q3());
        b.a.p0.a.g1.f.U().u(new b.a.p0.a.o0.d.c("sharebtn", hashMap));
        g3(PrefetchEvent.STATE_CLICK, "aboutshare");
    }

    @Override // b.a.p0.a.h0.g.d
    public boolean K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // b.a.p0.a.h0.g.d
    public void R1(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) {
            S1(view);
            if (!V1()) {
                G2(false);
            }
            x2(true);
            q2(-1);
            z2(-16777216);
            s2(null);
            u2(true);
        }
    }

    @NonNull
    public final String Y2(@NonNull String str, String str2) {
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

    @Override // b.a.p0.a.h0.g.d
    public boolean Z1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void Z2() {
        SwanAppActivity activity;
        b.a.p0.a.d2.e a0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (activity = b.a.p0.a.g1.f.U().getActivity()) == null || (a0 = b.a.p0.a.d2.e.a0()) == null) {
            return;
        }
        SwanAppWebPopWindow swanAppWebPopWindow = this.S0;
        if (swanAppWebPopWindow == null || !swanAppWebPopWindow.x()) {
            SwanAppWebPopWindow swanAppWebPopWindow2 = new SwanAppWebPopWindow(activity, "https://baozhang.baidu.com/guarantee/baoshowdetail?appkey=" + a0.N());
            this.S0 = swanAppWebPopWindow2;
            swanAppWebPopWindow2.x0(b.a.p0.a.h.swan_app_baidu_guarantee_title);
            swanAppWebPopWindow2.t0(SwanAppWebPopWindow.CloseStyle.CLOSE_AT_BOTTOM);
            swanAppWebPopWindow2.u0();
            swanAppWebPopWindow2.s0();
            swanAppWebPopWindow2.z0();
        }
    }

    public final void a3() {
        SwanAppActivity activity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (activity = b.a.p0.a.g1.f.U().getActivity()) == null || b.a.p0.a.d2.e.a0() == null) {
            return;
        }
        SwanAppWebPopWindow swanAppWebPopWindow = this.S0;
        if (swanAppWebPopWindow == null || !swanAppWebPopWindow.x()) {
            SwanAppWebPopWindow swanAppWebPopWindow2 = new SwanAppWebPopWindow(activity, this.P0);
            this.S0 = swanAppWebPopWindow2;
            swanAppWebPopWindow2.y0(P(b.a.p0.a.h.swan_app_service_agreement));
            swanAppWebPopWindow2.v0(activity.getResources().getDimensionPixelSize(b.a.p0.a.d.swan_half_screen_evalute_height));
            swanAppWebPopWindow2.t0(SwanAppWebPopWindow.CloseStyle.CLOSE_AT_RIGHT);
            swanAppWebPopWindow2.s0();
            swanAppWebPopWindow2.z0();
            g3(PrefetchEvent.STATE_CLICK, "servicenote");
        }
    }

    @Override // b.a.p0.a.h0.g.d
    public boolean b2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void b3() {
        b.a.p0.a.d2.e a0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (a0 = b.a.p0.a.d2.e.a0()) == null) {
            return;
        }
        b.a V = a0.V();
        String J = V.J();
        String F = V.F();
        if (!TextUtils.isEmpty(J) && !TextUtils.isEmpty(F)) {
            String h2 = q0.h(J, F);
            UnitedSchemeMainDispatcher unitedSchemeMainDispatcher = new UnitedSchemeMainDispatcher();
            unitedSchemeMainDispatcher.setDynamicDispatcher("swanAPI", new b.a.p0.a.f2.e());
            UnitedSchemeEntity unitedSchemeEntity = new UnitedSchemeEntity(Uri.parse(h2), UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE);
            unitedSchemeEntity.setOnlyVerify(false);
            unitedSchemeMainDispatcher.dispatch(this.l0, unitedSchemeEntity);
            boolean z = T0;
            return;
        }
        boolean z2 = T0;
    }

    public final void c3() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || this.l0 == null) {
            return;
        }
        String str = b.a.p0.a.d2.d.J().r().V().f0().webUrl;
        if (TextUtils.isEmpty(str)) {
            r0.b(this.l0).c("");
            b.a.p0.a.c2.b.f.e.f(this.l0, b.a.p0.a.h.swanapp_web_url_copy_fail).G();
            return;
        }
        String Y2 = Y2(str, b.a.p0.a.m1.b.b(q0.n()));
        int i2 = b.a.p0.a.h.swanapp_web_url_copy_success;
        if (Y2.length() > PluginCenter.PLUGIN_RETRY_MIN_TIME_INTERVAL) {
            i2 = b.a.p0.a.h.swanapp_web_url_param_to_long;
        } else {
            str = Y2;
        }
        r0.b(this.l0).c(str);
        b.a.p0.a.c2.b.f.e.f(this.l0, i2).G();
    }

    public final void d3() {
        SwanAppWebPopWindow swanAppWebPopWindow;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && c0() && (swanAppWebPopWindow = this.S0) != null) {
            swanAppWebPopWindow.r();
        }
    }

    public final void e3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            if (b.a.p0.a.x1.a.a.H()) {
                boolean z = T0;
                b.a.p0.a.c2.b.f.e.f(getContext(), b.a.p0.a.h.aiapps_debug_forbid_favor).G();
                return;
            }
            String f2 = q0.n().f();
            SwanFavorDataManager.h().b(str, new h(this, f2));
            b.a.p0.a.k1.a.p("aboutconcern", f2);
        }
    }

    public final void f3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            SwanFavorDataManager h2 = SwanFavorDataManager.h();
            g gVar = new g(this);
            b.a.p0.a.n0.l.c l2 = b.a.p0.a.n0.l.c.l();
            l2.n(3);
            h2.c(str, gVar, l2.k());
            g3(PrefetchEvent.STATE_CLICK, "aboutmove");
        }
    }

    @Override // b.a.p0.a.h0.g.d
    public void g2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && V1()) {
            j3();
            this.p0.r(b.a.p0.a.c1.a.M().a());
        }
    }

    public final void g3(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, str, str2) == null) {
            b.a.p0.a.n2.s.f fVar = new b.a.p0.a.n2.s.f();
            if (!TextUtils.isEmpty(str)) {
                fVar.f7380b = str;
            }
            if (!TextUtils.isEmpty(str2)) {
                fVar.f7383e = str2;
            }
            x1(fVar);
        }
    }

    public final void h3(@NonNull View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, view) == null) {
            String b2 = b.a.p0.a.h0.g.b.b();
            b.a.p0.a.o2.g.g a2 = b.a.p0.a.h0.g.b.a();
            Button button = (Button) view.findViewById(b.a.p0.a.f.btn_ues_offline_perftool);
            button.setVisibility(0);
            if (a2.getInt(b2, -1) == 1) {
                button.setText(b.a.p0.a.h.swan_offline_perf_tool_disable);
            } else {
                button.setText(b.a.p0.a.h.swan_offline_perf_tool_enable);
            }
            button.setOnClickListener(new b(this, a2, b2, new C0202a(this, a2, b2)));
        }
    }

    public final void i3(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            n0.N(this.J0, this.K0, String.valueOf(i2));
        }
    }

    public void j3() {
        FragmentActivity activity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && (activity = getActivity()) != null && this.p0 == null) {
            b.a.p0.n.n nVar = new b.a.p0.n.n(activity, this.o0, 13, b.a.p0.a.c1.a.K(), new b.a.p0.a.a3.h.b());
            this.p0 = nVar;
            nVar.p(q0.P());
            new b.a.p0.a.k1.a(this.p0, this).z();
        }
    }

    public final void k3(View view) {
        b.a.p0.a.d2.e a0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, view) == null) || (a0 = b.a.p0.a.d2.e.a0()) == null || a0.V() == null) {
            return;
        }
        b.a V = a0.V();
        this.I0 = (SwanAppRoundedImageView) view.findViewById(b.a.p0.a.f.aiapps_icon);
        TextView textView = (TextView) view.findViewById(b.a.p0.a.f.aiapps_title);
        textView.setText(V.K());
        if (V.G() == 0) {
            b.a.p0.a.a3.f.a(textView, new i(this));
        }
        b.a.p0.a.u1.k.f.j().n().h(textView);
        TextView textView2 = (TextView) view.findViewById(b.a.p0.a.f.aiapps_description);
        textView2.setText(V.e1());
        Button button = (Button) view.findViewById(b.a.p0.a.f.share_friends);
        button.setOnClickListener(this);
        Button button2 = (Button) view.findViewById(b.a.p0.a.f.add_favor);
        this.Q0 = button2;
        button2.setOnClickListener(this);
        w3();
        if (b.a.p0.a.c1.a.y0().d()) {
            button.setVisibility(8);
            this.Q0.setVisibility(8);
        }
        if (!b.a.p0.a.c1.a.t().b()) {
            this.Q0.setVisibility(8);
        }
        b.a.p0.a.h0.g.g V2 = b.a.p0.a.g1.f.U().V();
        if (V2 == null) {
            return;
        }
        if (V2.n(b.a.p0.a.c1.b.c().a()) != null) {
            button.setVisibility(8);
            this.Q0.setVisibility(8);
        }
        b.a.p0.t.d.b().a(textView2);
        ((TextView) view.findViewById(b.a.p0.a.f.service_category_value)).setText(V.s1());
        ((TextView) view.findViewById(b.a.p0.a.f.subject_info_value)).setText(V.t1());
        String G = b.a.p0.a.c1.a.o().G();
        this.P0 = G;
        if (!TextUtils.isEmpty(G)) {
            View findViewById = view.findViewById(b.a.p0.a.f.agreement_layout);
            findViewById.setVisibility(0);
            findViewById.setOnClickListener(this);
        }
        this.R0 = (RecyclerView) view.findViewById(b.a.p0.a.f.related_swan_app_list);
        PMSAppInfo f0 = V.f0();
        if (m3(f0)) {
            r3(view, f0.brandsInfo);
        }
        this.K0 = (TextView) view.findViewById(b.a.p0.a.f.aiapps_label_tv);
        this.J0 = (BdBaseImageView) view.findViewById(b.a.p0.a.f.aiapps_label_bg);
        this.I0.setImageBitmap(q0.i(V, "SwanAppAboutFragment", false));
        this.I0.setOnClickListener(this);
        SwanAppBearInfo k1 = V.k1();
        if (k1 != null && k1.isValid()) {
            this.L0 = new b.a.p0.a.a3.a(this.l0, view, k1, b.a.p0.a.f.bear_layout);
        }
        i3(V.getType());
        ((Button) view.findViewById(b.a.p0.a.f.open_app_button)).setVisibility(8);
        if (T0 || b.a.p0.a.g1.f.U().N()) {
            View inflate = ((ViewStub) view.findViewById(b.a.p0.a.f.ai_app_console)).inflate();
            if (V1() && (inflate instanceof Button)) {
                ((Button) inflate).setText(V.m0() ? b.a.p0.a.h.aiapps_close_debug_mode : b.a.p0.a.h.aiapps_open_debug_mode);
            }
            inflate.setOnClickListener(new j(this));
            if (!V1()) {
                ((ViewStub) view.findViewById(b.a.p0.a.f.ai_app_property)).inflate().setOnClickListener(new k(this));
            }
            if (V1()) {
                ((ViewStub) view.findViewById(b.a.p0.a.f.ai_app_show_ext_info)).inflate().setOnClickListener(new l(this, V, a0));
            }
            if (V1()) {
                View inflate2 = ((ViewStub) view.findViewById(b.a.p0.a.f.ai_app_swan_core_history_info)).inflate();
                if (inflate2 instanceof Button) {
                    Button button3 = (Button) inflate2;
                    button3.setText(b.a.p0.a.h.ai_games_debug_game_core_version);
                    button3.setOnClickListener(new m(this));
                }
            }
            if (b.a.p0.a.u1.j.e().f()) {
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
            if (!V1()) {
                h3(view);
            }
        }
        if (l3(f0)) {
            ImageView imageView = (ImageView) view.findViewById(b.a.p0.a.f.apply_guarantee);
            imageView.setVisibility(0);
            imageView.setOnClickListener(new p(this));
        }
        if (V1()) {
            return;
        }
        p3(this.I0, 2000L, new q(this));
    }

    public final boolean l3(PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, pMSAppInfo)) == null) {
            return (pMSAppInfo == null ? PMSConstants.PayProtected.NO_PAY_PROTECTED.type : pMSAppInfo.payProtected) == PMSConstants.PayProtected.PAY_PROTECTED.type;
        }
        return invokeL.booleanValue;
    }

    public final boolean m3(PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, pMSAppInfo)) == null) ? (b.a.p0.a.d2.d.J().l() != 0 || pMSAppInfo == null || TextUtils.isEmpty(pMSAppInfo.brandsInfo)) ? false : true : invokeL.booleanValue;
    }

    public final void o3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            String N = b.a.p0.a.d2.d.J().r().N();
            if (TextUtils.isEmpty(N)) {
                return;
            }
            if (b.a.p0.a.j0.b.a.n(N)) {
                f3(N);
            } else {
                e3(N);
            }
            w3();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, view) == null) {
            int id = view.getId();
            if (id == b.a.p0.a.f.aiapps_icon) {
                q3();
            } else if (id == b.a.p0.a.f.open_app_button) {
                b3();
            } else if (id == b.a.p0.a.f.brands_introduction_ll) {
                SchemeRouter.invoke(getContext(), this.N0);
                g3(PrefetchEvent.STATE_CLICK, "brand");
            } else if (id == b.a.p0.a.f.agreement_layout) {
                a3();
            } else if (id == b.a.p0.a.f.share_friends) {
                J2();
            } else if (id == b.a.p0.a.f.add_favor) {
                o3();
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, bundle) == null) {
            super.onCreate(bundle);
        }
    }

    @Override // b.a.p0.a.h0.g.d, com.baidu.swan.support.v4.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            super.onPause();
            d3();
        }
    }

    @Override // b.a.p0.a.h0.g.d, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            super.onResume();
            b.a.p0.a.a3.a aVar = this.L0;
            if (aVar != null) {
                aVar.c();
            }
            E2(1);
            b.a.p0.n.n nVar = this.p0;
            if (nVar != null && nVar.i()) {
                this.p0.A(b.a.p0.a.c1.a.M().a());
            }
            if (this.Q0 != null) {
                w3();
            }
        }
    }

    public final void p3(View view, long j2, View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048602, this, new Object[]{view, Long.valueOf(j2), onLongClickListener}) == null) || view == null || onLongClickListener == null || j2 <= 0) {
            return;
        }
        view.setOnTouchListener(new d(this, new c(this, onLongClickListener, view), j2));
    }

    public final void q3() {
        b.a.p0.a.d2.e a0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048603, this) == null) || (a0 = b.a.p0.a.d2.e.a0()) == null) {
            return;
        }
        long[] jArr = this.M0;
        System.arraycopy(jArr, 1, jArr, 0, jArr.length - 1);
        long[] jArr2 = this.M0;
        jArr2[jArr2.length - 1] = SystemClock.uptimeMillis();
        if (this.M0[0] >= SystemClock.uptimeMillis() - 1000) {
            this.M0 = new long[5];
            if (a0.v0()) {
                s3();
            } else {
                u3();
            }
        }
    }

    public final void r3(View view, String str) {
        int length;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048604, this, view, str) == null) {
            if (T0) {
                String str2 = str + "";
            }
            if (TextUtils.isEmpty(str) || view == null) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.N0 = jSONObject.optString("scheme");
                this.O0 = jSONObject.optString("description");
                if (!TextUtils.isEmpty(this.N0) && !TextUtils.isEmpty(this.O0) && (length = this.O0.length()) >= 20) {
                    if (length > 100) {
                        this.O0 = this.O0.substring(0, 100);
                    }
                    LinearLayout linearLayout = (LinearLayout) view.findViewById(b.a.p0.a.f.brands_introduction_ll);
                    linearLayout.setOnClickListener(this);
                    linearLayout.setVisibility(0);
                    ((TextView) view.findViewById(b.a.p0.a.f.brands_introduction_details)).setText(this.O0);
                    SwanAppRelatedSwanListAdapter.doUBCEventStatistic("brand", null, "show");
                    t3();
                }
            } catch (JSONException e2) {
                if (T0) {
                    e2.getMessage();
                }
            }
        }
    }

    public final void s3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            String g2 = b.a.p0.a.z2.p.g(this.l0);
            b.a.p0.a.c2.b.f.e.g(AppRuntime.getAppContext(), g2).F();
            b.a.p0.a.e0.d.k("SwanAppAboutFragment", "showExtraInfo\n" + g2);
        }
    }

    public final void t3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
            linearLayoutManager.setOrientation(1);
            this.R0.setLayoutManager(linearLayoutManager);
            SwanAppRelatedSwanListAdapter swanAppRelatedSwanListAdapter = new SwanAppRelatedSwanListAdapter(getContext());
            this.R0.setAdapter(swanAppRelatedSwanListAdapter);
            b.a.p0.a.b2.b.c(new e(this, swanAppRelatedSwanListAdapter));
        }
    }

    public final void u3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            boolean z = T0;
            b.a.p0.a.h0.g.g V = b.a.p0.a.g1.f.U().V();
            if (V == null) {
                b.a.p0.a.c2.b.f.e.f(getContext(), b.a.p0.a.h.aiapps_open_fragment_failed_toast).G();
                return;
            }
            g.b i2 = V.i("navigateTo");
            i2.n(b.a.p0.a.h0.g.g.f5478g, b.a.p0.a.h0.g.g.f5480i);
            i2.k("running_info", null).a();
        }
    }

    public final void v3() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048608, this) == null) || b.a.p0.a.d2.e.a0() == null) {
            return;
        }
        b.a.p0.a.h0.e.c.a(b.a.p0.a.d2.e.a0(), this.l0, new f(this));
    }

    public final void w3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            if (b.a.p0.a.j0.b.a.n(b.a.p0.a.d2.d.J().getAppId())) {
                this.Q0.setText(b.a.p0.a.h.swanapp_favored);
                this.Q0.setTextColor(AppCompatResources.getColorStateList(getContext(), b.a.p0.a.c.swan_app_about_attentation_text_selector));
                this.Q0.setBackgroundResource(b.a.p0.a.e.swan_app_about_cancel_attention_selector);
                return;
            }
            this.Q0.setText(b.a.p0.a.h.swanapp_add_favor);
            this.Q0.setTextColor(-1);
            this.Q0.setBackgroundResource(b.a.p0.a.e.swan_app_about_attention_selector);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View z0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048610, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(b.a.p0.a.g.aiapps_about_fragment, viewGroup, false);
            R1(inflate);
            k3(inflate);
            if (Q1()) {
                inflate = T1(inflate);
            }
            return A1(inflate, this);
        }
        return (View) invokeLLL.objValue;
    }
}
