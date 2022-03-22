package c.a.n0.a.x.g;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.text.format.Formatter;
import android.util.Log;
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
import c.a.n0.a.k1.j;
import c.a.n0.a.p2.n0;
import c.a.n0.a.p2.q0;
import c.a.n0.a.p2.r0;
import c.a.n0.a.r1.a;
import c.a.n0.a.r1.b;
import c.a.n0.a.s1.b.b.h;
import c.a.n0.a.v0.e.b;
import c.a.n0.a.x.e.c;
import c.a.n0.a.x.g.g;
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
import com.baidu.swan.apps.view.SwanAppRoundedImageView;
import com.baidu.swan.apps.view.SwanAppWebPopWindow;
import com.baidu.swan.pms.PMSConstants;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.swan.support.v4.app.FragmentActivity;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tieba.R;
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
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a extends c.a.n0.a.x.g.d implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean Q0;
    public transient /* synthetic */ FieldHolder $fh;
    public SwanAppRoundedImageView F0;
    public BdBaseImageView G0;
    public TextView H0;
    public c.a.n0.a.q2.a I0;
    public long[] J0;
    public String K0;
    public String L0;
    public String M0;
    public Button N0;
    public RecyclerView O0;
    public SwanAppWebPopWindow P0;

    /* renamed from: c.a.n0.a.x.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0517a implements c.a.n0.d.i.a<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.n0.a.e2.g.g a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f7004b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f7005c;

        /* renamed from: c.a.n0.a.x.g.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class DialogInterface$OnClickListenerC0518a implements DialogInterface.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public DialogInterface$OnClickListenerC0518a(C0517a c0517a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c0517a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                    SwanAppActivity x = c.a.n0.a.t1.d.J().x();
                    if (x != null && Build.VERSION.SDK_INT >= 21) {
                        x.finishAndRemoveTask();
                    }
                    System.exit(0);
                }
            }
        }

        public C0517a(a aVar, c.a.n0.a.e2.g.g gVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, gVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7005c = aVar;
            this.a = gVar;
            this.f7004b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.d.i.a
        /* renamed from: a */
        public void run(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                if (bool != null && bool.booleanValue()) {
                    this.a.putInt(this.f7004b, 1);
                } else {
                    this.a.putInt(this.f7004b, 0);
                }
                h.a aVar = new h.a(this.f7005c.i0);
                aVar.U(R.string.obfuscated_res_0x7f0f1247);
                aVar.v(R.string.obfuscated_res_0x7f0f1246);
                aVar.n(new c.a.n0.a.q2.h.a());
                aVar.O(R.string.obfuscated_res_0x7f0f010f, new DialogInterface$OnClickListenerC0518a(this));
                aVar.X();
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.n0.a.e2.g.g a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f7006b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.d.i.a f7007c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ a f7008d;

        /* renamed from: c.a.n0.a.x.g.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0519a implements c.b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            public C0519a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = bVar;
            }

            @Override // c.a.n0.a.x.e.c.b
            public void a(boolean z, String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeZL(1048576, this, z, str) == null) {
                    if (z) {
                        this.a.f7007c.run(Boolean.TRUE);
                        return;
                    }
                    Activity activity = this.a.f7008d.i0;
                    if (activity == null || activity.isDestroyed()) {
                        return;
                    }
                    c.a.n0.a.x.e.c.b(this.a.f7008d.i0, R.string.obfuscated_res_0x7f0f1247, str);
                }
            }
        }

        public b(a aVar, c.a.n0.a.e2.g.g gVar, String str, c.a.n0.d.i.a aVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, gVar, str, aVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7008d = aVar;
            this.a = gVar;
            this.f7006b = str;
            this.f7007c = aVar2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                int i = this.a.getInt(this.f7006b, -1);
                if (i == 1) {
                    this.f7007c.run(Boolean.FALSE);
                } else if (i == 0) {
                    this.f7007c.run(Boolean.TRUE);
                } else {
                    c.a.n0.a.t1.e a0 = c.a.n0.a.t1.e.a0();
                    if (a0 == null) {
                        return;
                    }
                    c.a.n0.a.x.e.c.a(a0, this.f7008d.i0, new C0519a(this));
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View.OnLongClickListener a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f7009b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f7010c;

        public c(a aVar, View.OnLongClickListener onLongClickListener, View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, onLongClickListener, view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7010c = aVar;
            this.a = onLongClickListener;
            this.f7009b = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.n0.a.h2.k.b.a.d().g();
                this.a.onLongClick(this.f7009b);
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Runnable a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ long f7011b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f7012c;

        public d(a aVar, Runnable runnable, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, runnable, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7012c = aVar;
            this.a = runnable;
            this.f7011b = j;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                int action = motionEvent.getAction();
                if (action == 0) {
                    view.postDelayed(this.a, this.f7011b);
                    return false;
                } else if (action == 1 || action == 3) {
                    view.removeCallbacks(this.a);
                    return false;
                } else {
                    return false;
                }
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes.dex */
    public class e implements b.InterfaceC0435b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppRelatedSwanListAdapter a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f7013b;

        /* renamed from: c.a.n0.a.x.g.a$e$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0520a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c.a.n0.a.r1.a a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ e f7014b;

            public RunnableC0520a(e eVar, c.a.n0.a.r1.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar, aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f7014b = eVar;
                this.a = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f7014b.f7013b.O0.setVisibility(0);
                    this.f7014b.a.e(this.a);
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7013b = aVar;
            this.a = swanAppRelatedSwanListAdapter;
        }

        @Override // c.a.n0.a.r1.b.InterfaceC0435b
        public void a(c.a.n0.a.r1.a aVar) {
            List<a.C0434a> list;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null || (list = aVar.a) == null || list.size() <= 0) {
                return;
            }
            q0.e0(new RunnableC0520a(this, aVar));
            SwanAppRelatedSwanListAdapter.d("aboutrelated", null, "show");
        }
    }

    /* loaded from: classes.dex */
    public class f implements c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        /* renamed from: c.a.n0.a.x.g.a$f$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0521a implements c.a.n0.a.p2.g1.c<Boolean> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ f a;

            public C0521a(f fVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = fVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.a.n0.a.p2.g1.c
            /* renamed from: a */
            public void onCallback(Boolean bool) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                    if (bool.booleanValue()) {
                        c.a.n0.a.u.a.d(this.a.a.getContext());
                    } else {
                        c.a.n0.a.s0.b.h().a(this.a.a.i0, null);
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // c.a.n0.a.x.e.c.b
        public void a(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, str) == null) {
                if (!z) {
                    c.a.n0.a.x.e.c.c(this.a.i0, str);
                } else if (c.a.n0.a.u.a.a()) {
                    c.a.n0.a.u.a.d(this.a.getContext());
                } else {
                    c.a.n0.a.s0.b.h().f(new C0521a(this));
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class g implements c.a.n0.a.g0.b.b {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // c.a.n0.a.g0.b.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.n0.a.s1.b.f.e f2 = c.a.n0.a.s1.b.f.e.f(this.a.getContext(), R.string.obfuscated_res_0x7f0f12dd);
                f2.l(2);
                f2.G();
            }
        }

        @Override // c.a.n0.a.g0.b.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                c.a.n0.a.s1.b.f.e f2 = c.a.n0.a.s1.b.f.e.f(this.a.getContext(), R.string.obfuscated_res_0x7f0f0109);
                f2.l(2);
                f2.G();
            }
        }

        @Override // c.a.n0.a.g0.b.b
        public void c(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) || z) {
                return;
            }
            c.a.n0.a.s1.b.f.e f2 = c.a.n0.a.s1.b.f.e.f(this.a.getContext(), R.string.obfuscated_res_0x7f0f0108);
            f2.l(2);
            f2.G();
        }
    }

    /* loaded from: classes.dex */
    public class h implements c.a.n0.a.g0.b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f7015b;

        public h(a aVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7015b = aVar;
            this.a = str;
        }

        @Override // c.a.n0.a.g0.b.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.n0.a.s1.b.f.e f2 = c.a.n0.a.s1.b.f.e.f(this.f7015b.getContext(), R.string.obfuscated_res_0x7f0f12dd);
                f2.l(2);
                f2.G();
            }
        }

        @Override // c.a.n0.a.g0.b.a
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || z) {
                return;
            }
            c.a.n0.a.s1.b.f.e f2 = c.a.n0.a.s1.b.f.e.f(this.f7015b.getContext(), R.string.obfuscated_res_0x7f0f0151);
            f2.l(2);
            f2.G();
        }

        @Override // c.a.n0.a.g0.b.a
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                c.a.n0.a.z.b.a.t();
                if (c.a.n0.a.a1.a.k(this.f7015b.getActivity())) {
                    c.a.n0.a.a1.a.p("aboutconcern", this.a);
                    return;
                }
                Context context = this.f7015b.getContext();
                c.a.n0.a.s1.b.f.e g2 = c.a.n0.a.s1.b.f.e.g(context, c.a.n0.a.s0.a.l0().f(context));
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
        public final /* synthetic */ a a;

        public i(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.v3();
            }
        }
    }

    /* loaded from: classes.dex */
    public class j implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public FullScreenFloatView a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f7016b;

        /* renamed from: c.a.n0.a.x.g.a$j$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0522a implements c.a.n0.a.p2.g1.c<Boolean> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ j a;

            public C0522a(j jVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {jVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = jVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.a.n0.a.p2.g1.c
            /* renamed from: a */
            public void onCallback(Boolean bool) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                    if (bool.booleanValue()) {
                        c.a.n0.a.u.a.c(this.a.f7016b.getContext(), true);
                    } else {
                        c.a.n0.a.s0.b.h().a(this.a.f7016b.i0, null);
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7016b = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f7016b.i0 == null) {
                return;
            }
            if (a.Q0) {
                if (c.a.n0.a.x.o.e.a.f()) {
                    c.a.n0.a.u.a.d(this.f7016b.getContext());
                    return;
                }
                if (this.a == null) {
                    this.a = c.a.n0.a.w0.f.U().n(this.f7016b.i0);
                }
                if (this.f7016b.W1()) {
                    if (c.a.n0.a.u.a.a()) {
                        c.a.n0.a.u.a.c(this.f7016b.getContext(), false);
                        return;
                    } else {
                        c.a.n0.a.s0.b.h().f(new C0522a(this));
                        return;
                    }
                }
                this.a.setVisibility(this.a.getVisibility() == 0 ? 8 : 0);
            } else if (this.f7016b.W1()) {
                this.f7016b.w3();
            } else {
                c.a.n0.a.u.a.d(this.f7016b.getContext());
            }
        }
    }

    /* loaded from: classes.dex */
    public class k implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public SwanAppPropertyWindow a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f7017b;

        public k(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7017b = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.a == null) {
                    this.a = c.a.n0.a.w0.f.U().J(this.f7017b.i0);
                }
                this.a.setVisibility(this.a.getVisibility() == 0 ? 8 : 0);
            }
        }
    }

    /* loaded from: classes.dex */
    public class l implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.n0.a.v0.e.b a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.t1.e f7018b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f7019c;

        /* renamed from: c.a.n0.a.x.g.a$l$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class DialogInterface$OnClickListenerC0523a implements DialogInterface.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public DialogInterface$OnClickListenerC0523a(l lVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {lVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                }
            }
        }

        public l(a aVar, c.a.n0.a.v0.e.b bVar, c.a.n0.a.t1.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, bVar, eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7019c = aVar;
            this.a = bVar;
            this.f7018b = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f7019c.i0 == null) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("ENABLE V8: ");
            sb.append(c.a.n0.a.x.u.g.U().r0());
            sb.append("\n");
            sb.append("APS VERSION: ");
            sb.append(TextUtils.isEmpty(this.a.v1()) ? "" : this.a.v1());
            sb.append("\n");
            sb.append("APPID VERSION: ");
            sb.append(c.a.n0.a.l.a.c(this.f7018b.f6344b));
            sb.append("\n");
            String formatFileSize = Formatter.formatFileSize(AppRuntime.getAppContext(), this.a.i1());
            sb.append("小程序包大小: ");
            sb.append(TextUtils.isEmpty(formatFileSize) ? "" : formatFileSize);
            sb.append("(");
            sb.append(this.a.i1());
            sb.append(SmallTailInfo.EMOTION_SUFFIX);
            sb.append("\n");
            h.a aVar = new h.a(this.f7019c.i0);
            aVar.V(this.f7019c.i0.getResources().getString(R.string.obfuscated_res_0x7f0f01c0));
            aVar.x(sb.toString());
            aVar.n(new c.a.n0.a.q2.h.a());
            aVar.m(false);
            aVar.O(R.string.obfuscated_res_0x7f0f010f, new DialogInterface$OnClickListenerC0523a(this));
            aVar.X();
        }
    }

    /* loaded from: classes.dex */
    public class m implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        /* renamed from: c.a.n0.a.x.g.a$m$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class DialogInterface$OnClickListenerC0524a implements DialogInterface.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public DialogInterface$OnClickListenerC0524a(m mVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {mVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.a.i0 == null) {
                return;
            }
            String e2 = c.a.n0.a.g2.a.c().e(1);
            String string = this.a.i0.getResources().getString(R.string.obfuscated_res_0x7f0f00e2);
            h.a aVar = new h.a(this.a.i0);
            aVar.V(string);
            aVar.x(e2);
            aVar.n(new c.a.n0.a.q2.h.a());
            aVar.m(false);
            aVar.O(R.string.obfuscated_res_0x7f0f010f, new DialogInterface$OnClickListenerC0524a(this));
            aVar.X();
        }
    }

    /* loaded from: classes.dex */
    public class n implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        /* renamed from: c.a.n0.a.x.g.a$n$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0525a extends j.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ n a;

            /* renamed from: c.a.n0.a.x.g.a$n$a$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public class RunnableC0526a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ String a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ C0525a f7020b;

                public RunnableC0526a(C0525a c0525a, String str) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {c0525a, str};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f7020b = c0525a;
                    this.a = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        h.a aVar = new h.a(this.f7020b.a.a.i0);
                        aVar.U(R.string.obfuscated_res_0x7f0f0143);
                        aVar.x(this.a);
                        aVar.n(new c.a.n0.a.q2.h.a());
                        aVar.m(false);
                        aVar.O(R.string.obfuscated_res_0x7f0f010f, null);
                        aVar.X();
                    }
                }
            }

            public C0525a(n nVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {nVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = nVar;
            }

            @Override // c.a.n0.a.k1.j.a
            public void c(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    this.a.a.i0.runOnUiThread(new RunnableC0526a(this, str));
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.a.i0 == null) {
                return;
            }
            c.a.n0.a.k1.j.e().g(new C0525a(this));
        }
    }

    /* loaded from: classes.dex */
    public class o implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public c.a.n0.a.u.h.a a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f7021b;

        /* renamed from: c.a.n0.a.x.g.a$o$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class DialogInterface$OnClickListenerC0527a implements DialogInterface.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ o a;

            public DialogInterface$OnClickListenerC0527a(o oVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {oVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = oVar;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                    c.a.n0.a.u.h.a.g(1);
                    this.a.a = new c.a.n0.a.u.h.a(c.a.n0.a.s0.a.c());
                    this.a.a.h();
                }
            }
        }

        /* loaded from: classes.dex */
        public class b implements DialogInterface.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ o a;

            public b(o oVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {oVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = oVar;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                    this.a.b();
                    c.a.n0.a.u.h.a.g(2);
                    System.exit(0);
                }
            }
        }

        /* loaded from: classes.dex */
        public class c implements DialogInterface.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ o a;

            public c(o oVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {oVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = oVar;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                    this.a.b();
                    c.a.n0.a.u.h.a.g(0);
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7021b = aVar;
        }

        public final void b() {
            c.a.n0.a.u.h.a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (aVar = this.a) == null) {
                return;
            }
            aVar.i();
            this.a = null;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
                h.a aVar = new h.a(this.f7021b.i0);
                aVar.U(R.string.obfuscated_res_0x7f0f0145);
                aVar.v(R.string.obfuscated_res_0x7f0f0131);
                aVar.n(new c.a.n0.a.q2.h.a());
                aVar.m(true);
                if (c.a.n0.a.u.h.a.e() == 0) {
                    aVar.O(R.string.obfuscated_res_0x7f0f0132, new DialogInterface$OnClickListenerC0527a(this));
                }
                if (c.a.n0.a.u.h.a.e() != 2) {
                    aVar.H(R.string.obfuscated_res_0x7f0f0130, new b(this));
                }
                if (c.a.n0.a.u.h.a.e() != 0) {
                    aVar.B(R.string.obfuscated_res_0x7f0f1272, new c(this));
                }
                aVar.X();
            }
        }
    }

    /* loaded from: classes.dex */
    public class p implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public p(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.a.a3();
                this.a.h3("click", "baozhang");
            }
        }
    }

    /* loaded from: classes.dex */
    public class q implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public q(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                this.a.d3();
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-622887410, "Lc/a/n0/a/x/g/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-622887410, "Lc/a/n0/a/x/g/a;");
                return;
            }
        }
        Q0 = c.a.n0.a.a.a;
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
        this.J0 = new long[5];
    }

    public static a o3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? new a() : (a) invokeV.objValue;
    }

    @Override // c.a.n0.a.x.g.d
    public void K2() {
        c.a.n0.a.x.g.g V;
        c.a.n0.a.x.g.f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (V = c.a.n0.a.w0.f.U().V()) == null || (fVar = (c.a.n0.a.x.g.f) V.n(c.a.n0.a.x.g.f.class)) == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, fVar.r3());
        c.a.n0.a.w0.f.U().u(new c.a.n0.a.e0.d.c("sharebtn", hashMap));
        h3("click", "aboutshare");
    }

    @Override // c.a.n0.a.x.g.d
    public boolean L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.n0.a.x.g.d
    public void S1(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) {
            T1(view);
            if (!W1()) {
                H2(false);
            }
            y2(true);
            r2(-1);
            A2(-16777216);
            t2(null);
            v2(true);
        }
    }

    @NonNull
    public final String Z2(@NonNull String str, String str2) {
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

    @Override // c.a.n0.a.x.g.d
    public boolean a2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void a3() {
        SwanAppActivity activity;
        c.a.n0.a.t1.e a0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (activity = c.a.n0.a.w0.f.U().getActivity()) == null || (a0 = c.a.n0.a.t1.e.a0()) == null) {
            return;
        }
        SwanAppWebPopWindow swanAppWebPopWindow = this.P0;
        if (swanAppWebPopWindow == null || !swanAppWebPopWindow.x()) {
            SwanAppWebPopWindow swanAppWebPopWindow2 = new SwanAppWebPopWindow(activity, "https://baozhang.baidu.com/guarantee/baoshowdetail?appkey=" + a0.N());
            this.P0 = swanAppWebPopWindow2;
            swanAppWebPopWindow2.q0(R.string.obfuscated_res_0x7f0f1201);
            swanAppWebPopWindow2.m0(SwanAppWebPopWindow.CloseStyle.CLOSE_AT_BOTTOM);
            swanAppWebPopWindow2.n0();
            swanAppWebPopWindow2.l0();
            swanAppWebPopWindow2.s0();
        }
    }

    public final void b3() {
        SwanAppActivity activity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (activity = c.a.n0.a.w0.f.U().getActivity()) == null || c.a.n0.a.t1.e.a0() == null) {
            return;
        }
        SwanAppWebPopWindow swanAppWebPopWindow = this.P0;
        if (swanAppWebPopWindow == null || !swanAppWebPopWindow.x()) {
            SwanAppWebPopWindow swanAppWebPopWindow2 = new SwanAppWebPopWindow(activity, this.M0);
            this.P0 = swanAppWebPopWindow2;
            swanAppWebPopWindow2.r0(G(R.string.obfuscated_res_0x7f0f122f));
            swanAppWebPopWindow2.o0(activity.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07062e));
            swanAppWebPopWindow2.m0(SwanAppWebPopWindow.CloseStyle.CLOSE_AT_RIGHT);
            swanAppWebPopWindow2.l0();
            swanAppWebPopWindow2.s0();
            h3("click", "servicenote");
        }
    }

    @Override // c.a.n0.a.x.g.d
    public boolean c2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void c3() {
        c.a.n0.a.t1.e a0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (a0 = c.a.n0.a.t1.e.a0()) == null) {
            return;
        }
        b.a V = a0.V();
        String J = V.J();
        String F = V.F();
        if (!TextUtils.isEmpty(J) && !TextUtils.isEmpty(F)) {
            String h2 = q0.h(J, F);
            UnitedSchemeMainDispatcher unitedSchemeMainDispatcher = new UnitedSchemeMainDispatcher();
            unitedSchemeMainDispatcher.setDynamicDispatcher("swanAPI", new c.a.n0.a.v1.e());
            UnitedSchemeEntity unitedSchemeEntity = new UnitedSchemeEntity(Uri.parse(h2), UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE);
            unitedSchemeEntity.setOnlyVerify(false);
            unitedSchemeMainDispatcher.dispatch(this.i0, unitedSchemeEntity);
            if (Q0) {
                Log.d("SwanAppAboutFragment", "Open or download app");
            }
        } else if (Q0) {
            Log.d("SwanAppAboutFragment", "appOpenUrl or appDownloadUrl is empty, click no response");
        }
    }

    public final void d3() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || this.i0 == null) {
            return;
        }
        String str = c.a.n0.a.t1.d.J().r().V().f0().webUrl;
        if (TextUtils.isEmpty(str)) {
            r0.b(this.i0).c("");
            c.a.n0.a.s1.b.f.e.f(this.i0, R.string.obfuscated_res_0x7f0f12fa).G();
            return;
        }
        String Z2 = Z2(str, c.a.n0.a.c1.b.b(q0.n()));
        int i2 = R.string.obfuscated_res_0x7f0f12fb;
        if (Z2.length() > PluginCenter.PLUGIN_RETRY_MIN_TIME_INTERVAL) {
            i2 = R.string.obfuscated_res_0x7f0f12fc;
        } else {
            str = Z2;
        }
        r0.b(this.i0).c(str);
        c.a.n0.a.s1.b.f.e.f(this.i0, i2).G();
    }

    public final void e3() {
        SwanAppWebPopWindow swanAppWebPopWindow;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && O() && (swanAppWebPopWindow = this.P0) != null) {
            swanAppWebPopWindow.r();
        }
    }

    public final void f3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            if (c.a.n0.a.n1.a.a.H()) {
                if (Q0) {
                    Log.d("SwanAppAboutFragment", "in debug mode cannot add favor");
                }
                c.a.n0.a.s1.b.f.e.f(getContext(), R.string.obfuscated_res_0x7f0f0123).G();
                return;
            }
            String e2 = q0.n().e();
            SwanFavorDataManager.h().b(str, new h(this, e2));
            c.a.n0.a.a1.a.p("aboutconcern", e2);
        }
    }

    public final void g3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            SwanFavorDataManager h2 = SwanFavorDataManager.h();
            g gVar = new g(this);
            c.a.n0.a.d0.l.c l2 = c.a.n0.a.d0.l.c.l();
            l2.n(3);
            h2.c(str, gVar, l2.k());
            h3("click", "aboutmove");
        }
    }

    @Override // c.a.n0.a.x.g.d
    public void h2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && W1()) {
            k3();
            this.m0.s(c.a.n0.a.s0.a.M().a());
        }
    }

    public final void h3(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, str, str2) == null) {
            c.a.n0.a.d2.s.f fVar = new c.a.n0.a.d2.s.f();
            if (!TextUtils.isEmpty(str)) {
                fVar.f4188b = str;
            }
            if (!TextUtils.isEmpty(str2)) {
                fVar.f4191e = str2;
            }
            y1(fVar);
        }
    }

    public final void i3(@NonNull View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, view) == null) {
            String b2 = c.a.n0.a.x.g.b.b();
            c.a.n0.a.e2.g.g a = c.a.n0.a.x.g.b.a();
            Button button = (Button) view.findViewById(R.id.obfuscated_res_0x7f09043b);
            button.setVisibility(0);
            if (a.getInt(b2, -1) == 1) {
                button.setText(R.string.obfuscated_res_0x7f0f1244);
            } else {
                button.setText(R.string.obfuscated_res_0x7f0f1245);
            }
            button.setOnClickListener(new b(this, a, b2, new C0517a(this, a, b2)));
        }
    }

    public final void j3(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            n0.M(this.G0, this.H0, String.valueOf(i2));
        }
    }

    public void k3() {
        FragmentActivity activity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && (activity = getActivity()) != null && this.m0 == null) {
            c.a.n0.n.f fVar = new c.a.n0.n.f(activity, this.l0, 13, c.a.n0.a.s0.a.K(), new c.a.n0.a.q2.h.b());
            this.m0 = fVar;
            fVar.q(q0.P());
            new c.a.n0.a.a1.a(this.m0, this).z();
        }
    }

    public final void l3(View view) {
        c.a.n0.a.t1.e a0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, view) == null) || (a0 = c.a.n0.a.t1.e.a0()) == null || a0.V() == null) {
            return;
        }
        b.a V = a0.V();
        this.F0 = (SwanAppRoundedImageView) view.findViewById(R.id.obfuscated_res_0x7f09019a);
        TextView textView = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0901a9);
        textView.setText(V.K());
        if (V.G() == 0) {
            c.a.n0.a.q2.f.a(textView, new i(this));
        }
        c.a.n0.a.k1.k.f.j().n().h(textView);
        TextView textView2 = (TextView) view.findViewById(R.id.obfuscated_res_0x7f090191);
        textView2.setText(V.e1());
        Button button = (Button) view.findViewById(R.id.obfuscated_res_0x7f091cbb);
        button.setOnClickListener(this);
        Button button2 = (Button) view.findViewById(R.id.obfuscated_res_0x7f09010a);
        this.N0 = button2;
        button2.setOnClickListener(this);
        x3();
        if (c.a.n0.a.s0.a.y0().d()) {
            button.setVisibility(8);
            this.N0.setVisibility(8);
        }
        if (!c.a.n0.a.s0.a.t().b()) {
            this.N0.setVisibility(8);
        }
        c.a.n0.a.x.g.g V2 = c.a.n0.a.w0.f.U().V();
        if (V2 == null) {
            return;
        }
        if (V2.n(c.a.n0.a.s0.b.c().a()) != null) {
            button.setVisibility(8);
            this.N0.setVisibility(8);
        }
        c.a.n0.t.b.b().a(textView2);
        ((TextView) view.findViewById(R.id.obfuscated_res_0x7f091ca1)).setText(V.s1());
        ((TextView) view.findViewById(R.id.obfuscated_res_0x7f091dcd)).setText(V.t1());
        String G = c.a.n0.a.s0.a.o().G();
        this.M0 = G;
        if (!TextUtils.isEmpty(G)) {
            View findViewById = view.findViewById(R.id.obfuscated_res_0x7f090161);
            findViewById.setVisibility(0);
            findViewById.setOnClickListener(this);
        }
        this.O0 = (RecyclerView) view.findViewById(R.id.obfuscated_res_0x7f091a36);
        PMSAppInfo f0 = V.f0();
        if (n3(f0)) {
            s3(view, f0.brandsInfo);
        }
        this.H0 = (TextView) view.findViewById(R.id.obfuscated_res_0x7f09019e);
        this.G0 = (BdBaseImageView) view.findViewById(R.id.obfuscated_res_0x7f09019d);
        this.F0.setImageBitmap(q0.i(V, "SwanAppAboutFragment", false));
        this.F0.setOnClickListener(this);
        SwanAppBearInfo k1 = V.k1();
        if (k1 != null && k1.isValid()) {
            this.I0 = new c.a.n0.a.q2.a(this.i0, view, k1, R.id.obfuscated_res_0x7f09034f);
        }
        j3(V.getType());
        ((Button) view.findViewById(R.id.obfuscated_res_0x7f091602)).setVisibility(8);
        if (Q0 || c.a.n0.a.w0.f.U().N()) {
            View inflate = ((ViewStub) view.findViewById(R.id.obfuscated_res_0x7f090169)).inflate();
            if (W1() && (inflate instanceof Button)) {
                ((Button) inflate).setText(V.m0() ? R.string.obfuscated_res_0x7f0f010d : R.string.obfuscated_res_0x7f0f0199);
            }
            inflate.setOnClickListener(new j(this));
            if (!W1()) {
                ((ViewStub) view.findViewById(R.id.obfuscated_res_0x7f09016a)).inflate().setOnClickListener(new k(this));
            }
            if (W1()) {
                ((ViewStub) view.findViewById(R.id.obfuscated_res_0x7f09016c)).inflate().setOnClickListener(new l(this, V, a0));
            }
            if (W1()) {
                View inflate2 = ((ViewStub) view.findViewById(R.id.obfuscated_res_0x7f09016e)).inflate();
                if (inflate2 instanceof Button) {
                    Button button3 = (Button) inflate2;
                    button3.setText(R.string.obfuscated_res_0x7f0f00e2);
                    button3.setOnClickListener(new m(this));
                }
            }
            if (c.a.n0.a.k1.j.e().f()) {
                View inflate3 = ((ViewStub) view.findViewById(R.id.obfuscated_res_0x7f09016b)).inflate();
                if (inflate3 instanceof Button) {
                    Button button4 = (Button) inflate3;
                    button4.setText(R.string.obfuscated_res_0x7f0f0143);
                    button4.setOnClickListener(new n(this));
                }
            }
            View inflate4 = ((ViewStub) view.findViewById(R.id.obfuscated_res_0x7f09016d)).inflate();
            if (inflate4 instanceof Button) {
                ((Button) inflate4).setText(R.string.obfuscated_res_0x7f0f0145);
            }
            inflate4.setOnClickListener(new o(this));
            if (!W1()) {
                i3(view);
            }
        }
        if (m3(f0)) {
            ImageView imageView = (ImageView) view.findViewById(R.id.obfuscated_res_0x7f09029e);
            imageView.setVisibility(0);
            imageView.setOnClickListener(new p(this));
        }
        if (W1()) {
            return;
        }
        q3(this.F0, 2000L, new q(this));
    }

    public final boolean m3(PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, pMSAppInfo)) == null) {
            return (pMSAppInfo == null ? PMSConstants.PayProtected.NO_PAY_PROTECTED.type : pMSAppInfo.payProtected) == PMSConstants.PayProtected.PAY_PROTECTED.type;
        }
        return invokeL.booleanValue;
    }

    public final boolean n3(PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, pMSAppInfo)) == null) ? (c.a.n0.a.t1.d.J().l() != 0 || pMSAppInfo == null || TextUtils.isEmpty(pMSAppInfo.brandsInfo)) ? false : true : invokeL.booleanValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, view) == null) {
            int id = view.getId();
            if (id == R.id.obfuscated_res_0x7f09019a) {
                r3();
            } else if (id == R.id.obfuscated_res_0x7f091602) {
                c3();
            } else if (id == R.id.obfuscated_res_0x7f0903ec) {
                SchemeRouter.invoke(getContext(), this.K0);
                h3("click", "brand");
            } else if (id == R.id.obfuscated_res_0x7f090161) {
                b3();
            } else if (id == R.id.obfuscated_res_0x7f091cbb) {
                K2();
            } else if (id == R.id.obfuscated_res_0x7f09010a) {
                p3();
            }
        }
    }

    @Override // c.a.n0.a.x.g.d, com.baidu.swan.support.v4.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            super.onPause();
            e3();
        }
    }

    @Override // c.a.n0.a.x.g.d, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            super.onResume();
            c.a.n0.a.q2.a aVar = this.I0;
            if (aVar != null) {
                aVar.c();
            }
            F2(1);
            c.a.n0.n.f fVar = this.m0;
            if (fVar != null && fVar.j()) {
                this.m0.C(c.a.n0.a.s0.a.M().a());
            }
            if (this.N0 != null) {
                x3();
            }
        }
    }

    public final void p3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            String N = c.a.n0.a.t1.d.J().r().N();
            if (TextUtils.isEmpty(N)) {
                return;
            }
            if (c.a.n0.a.z.b.a.n(N)) {
                g3(N);
            } else {
                f3(N);
            }
            x3();
        }
    }

    public final void q3(View view, long j2, View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048601, this, new Object[]{view, Long.valueOf(j2), onLongClickListener}) == null) || view == null || onLongClickListener == null || j2 <= 0) {
            return;
        }
        view.setOnTouchListener(new d(this, new c(this, onLongClickListener, view), j2));
    }

    public final void r3() {
        c.a.n0.a.t1.e a0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048602, this) == null) || (a0 = c.a.n0.a.t1.e.a0()) == null) {
            return;
        }
        long[] jArr = this.J0;
        System.arraycopy(jArr, 1, jArr, 0, jArr.length - 1);
        long[] jArr2 = this.J0;
        jArr2[jArr2.length - 1] = SystemClock.uptimeMillis();
        if (this.J0[0] >= SystemClock.uptimeMillis() - 1000) {
            this.J0 = new long[5];
            if (a0.v0()) {
                t3();
            } else {
                v3();
            }
        }
    }

    public final void s3(View view, String str) {
        int length;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048603, this, view, str) == null) {
            if (Q0) {
                Log.i("SwanAppAboutFragment", str + "");
            }
            if (TextUtils.isEmpty(str) || view == null) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.K0 = jSONObject.optString("scheme");
                this.L0 = jSONObject.optString("description");
                if (!TextUtils.isEmpty(this.K0) && !TextUtils.isEmpty(this.L0) && (length = this.L0.length()) >= 20) {
                    if (length > 100) {
                        this.L0 = this.L0.substring(0, 100);
                    }
                    LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.obfuscated_res_0x7f0903ec);
                    linearLayout.setOnClickListener(this);
                    linearLayout.setVisibility(0);
                    ((TextView) view.findViewById(R.id.obfuscated_res_0x7f0903ea)).setText(this.L0);
                    SwanAppRelatedSwanListAdapter.d("brand", null, "show");
                    u3();
                }
            } catch (JSONException e2) {
                if (Q0) {
                    Log.i("SwanAppAboutFragment", e2.getMessage());
                }
            }
        }
    }

    public final void t3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            String g2 = c.a.n0.a.p2.p.g(this.i0);
            c.a.n0.a.s1.b.f.e.g(AppRuntime.getAppContext(), g2).F();
            c.a.n0.a.u.d.k("SwanAppAboutFragment", "showExtraInfo\n" + g2);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void u0(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, bundle) == null) {
            super.u0(bundle);
        }
    }

    public final void u3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
            linearLayoutManager.setOrientation(1);
            this.O0.setLayoutManager(linearLayoutManager);
            SwanAppRelatedSwanListAdapter swanAppRelatedSwanListAdapter = new SwanAppRelatedSwanListAdapter(getContext());
            this.O0.setAdapter(swanAppRelatedSwanListAdapter);
            c.a.n0.a.r1.b.c(new e(this, swanAppRelatedSwanListAdapter));
        }
    }

    public final void v3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            if (Q0) {
                Log.d("SwanAppAboutFragment", "startAboutFragment");
            }
            c.a.n0.a.x.g.g V = c.a.n0.a.w0.f.U().V();
            if (V == null) {
                c.a.n0.a.s1.b.f.e.f(getContext(), R.string.obfuscated_res_0x7f0f019b).G();
                return;
            }
            g.b i2 = V.i("navigateTo");
            i2.n(c.a.n0.a.x.g.g.f7048g, c.a.n0.a.x.g.g.i);
            i2.k("running_info", null).a();
        }
    }

    public final void w3() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048608, this) == null) || c.a.n0.a.t1.e.a0() == null) {
            return;
        }
        c.a.n0.a.x.e.c.a(c.a.n0.a.t1.e.a0(), this.i0, new f(this));
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View x0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048609, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0093, viewGroup, false);
            S1(inflate);
            l3(inflate);
            if (R1()) {
                inflate = U1(inflate);
            }
            return B1(inflate, this);
        }
        return (View) invokeLLL.objValue;
    }

    public final void x3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            if (c.a.n0.a.z.b.a.n(c.a.n0.a.t1.d.J().getAppId())) {
                this.N0.setText(R.string.obfuscated_res_0x7f0f128b);
                this.N0.setTextColor(AppCompatResources.getColorStateList(getContext(), R.color.obfuscated_res_0x7f060a17));
                this.N0.setBackgroundResource(R.drawable.obfuscated_res_0x7f0810f8);
                return;
            }
            this.N0.setText(R.string.obfuscated_res_0x7f0f1257);
            this.N0.setTextColor(-1);
            this.N0.setBackgroundResource(R.drawable.obfuscated_res_0x7f0810f6);
        }
    }
}
