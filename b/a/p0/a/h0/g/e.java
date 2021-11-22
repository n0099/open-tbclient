package b.a.p0.a.h0.g;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.h0.g.l;
import b.a.p0.a.n2.n;
import b.a.p0.a.z2.q;
import b.a.p0.a.z2.q0;
import b.a.p0.n.o;
import b.a.p0.q.k.i.p;
import b.a.p0.r.a.a.m;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
import com.baidu.swan.apps.SwanAppClearCacheErrorActivity;
import com.baidu.swan.apps.SwanAppErrorActivity;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.apps.env.launch.SwanLauncher;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.scheme.actions.forbidden.ForbiddenInfo;
import com.baidu.swan.apps.view.SwanAppActionBar;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.swan.support.v4.app.FragmentActivity;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.paysdk.datamodel.ErrorContentResponse;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class e extends b.a.p0.a.h0.g.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String I0;
    public String J0;
    public ForbiddenInfo K0;
    public int L0;
    public int M0;
    public String N0;
    public String O0;
    public String P0;
    public int Q0;

    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f5447e;

        public a(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5447e = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Activity activity;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (activity = this.f5447e.l0) == null) {
                return;
            }
            activity.finish();
        }
    }

    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.f1.e.b f5448e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f5449f;

        public b(e eVar, b.a.p0.a.f1.e.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5449f = eVar;
            this.f5448e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Activity activity;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && (activity = this.f5449f.l0) != null && SwanAppNetworkUtils.i(activity)) {
                Bundle bundle = new Bundle();
                bundle.putBoolean("property_web_mode_degrade", true);
                SwanLauncher.j().n(this.f5448e, bundle);
                this.f5449f.l0.finishAndRemoveTask();
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f5450e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f5451f;

        public c(e eVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5451f = eVar;
            this.f5450e = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f5451f.K0 == null || TextUtils.isEmpty(this.f5451f.K0.forbiddenDetail)) {
                return;
            }
            b.a.p0.a.c1.a.u().b(this.f5451f.getActivity(), this.f5450e, this.f5451f.K0.appTitle, this.f5451f.K0.forbiddenDetail);
        }
    }

    /* loaded from: classes.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.f1.e.b f5452e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f5453f;

        public d(e eVar, b.a.p0.a.f1.e.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5453f = eVar;
            this.f5452e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Activity activity;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && (activity = this.f5453f.l0) != null && SwanAppNetworkUtils.i(activity)) {
                SwanLauncher.j().n(this.f5452e, null);
                this.f5453f.l0.finish();
            }
        }
    }

    /* renamed from: b.a.p0.a.h0.g.e$e  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC0215e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f5454e;

        public View$OnClickListenerC0215e(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5454e = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || TextUtils.isEmpty(this.f5454e.O0)) {
                return;
            }
            Activity activity = this.f5454e.l0;
            if (activity instanceof FragmentActivity) {
                m supportFragmentManager = ((FragmentActivity) activity).getSupportFragmentManager();
                l.d Y2 = l.Y2(this.f5454e.O0);
                Y2.a(false);
                Y2.c(supportFragmentManager);
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f5455e;

        public f(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5455e = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                FragmentActivity activity = this.f5455e.getActivity();
                if (!(activity instanceof SwanAppClearCacheErrorActivity)) {
                    if (b.a.p0.a.h0.g.d.H0) {
                        throw new IllegalStateException("非SwanAppClearCacheErrorActivity");
                    }
                    return;
                }
                ((SwanAppClearCacheErrorActivity) activity).markHasGotoClearCache();
                try {
                    this.f5455e.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("baiduboxapp://v16/ucenter/cleanCache")));
                } catch (Exception e2) {
                    b.a.p0.a.e0.d.l("SwanAppErrorFragment", "打开清理缓存界面失败", e2);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f5456e;

        public g(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5456e = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f5456e.M1();
            }
        }
    }

    /* loaded from: classes.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.f1.e.b f5457e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f5458f;

        public h(e eVar, b.a.p0.a.f1.e.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5458f = eVar;
            this.f5457e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Activity activity;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && (activity = this.f5458f.l0) != null && SwanAppNetworkUtils.i(activity)) {
                SwanLauncher.j().n(this.f5457e, null);
                this.f5458f.l0.finish();
            }
        }
    }

    /* loaded from: classes.dex */
    public class i implements b.a.p0.n.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f5459e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f5460f;

        public i(e eVar, Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5460f = eVar;
            this.f5459e = activity;
        }

        @Override // b.a.p0.n.e
        public boolean b(View view, o oVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, oVar)) == null) {
                int c2 = oVar.c();
                if (c2 == 5) {
                    this.f5460f.g3(this.f5459e);
                } else if (c2 == 9) {
                    this.f5460f.d3(this.f5459e);
                    return true;
                } else if (c2 == 39) {
                    this.f5460f.h3(this.f5459e);
                } else if (c2 == 46) {
                    this.f5460f.e3(oVar, this.f5459e);
                } else if (c2 == 47) {
                    this.f5460f.f3(oVar, this.f5459e);
                }
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes.dex */
    public static class j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes.dex */
        public static class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b.a.p0.a.n2.s.e f5461e;

            public a(b.a.p0.a.n2.s.e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f5461e = eVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    b.a.p0.a.n2.b.i("934", "85", this.f5461e.f());
                }
            }
        }

        public static void a(String str, b.a.p0.a.f1.e.b bVar, ForbiddenInfo forbiddenInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(65536, null, str, bVar, forbiddenInfo) == null) {
                b.a.p0.a.n2.s.e eVar = new b.a.p0.a.n2.s.e();
                eVar.f7384f = forbiddenInfo.appId;
                eVar.f7385g = "errormenu";
                eVar.f7380b = PrefetchEvent.STATE_CLICK;
                eVar.f7383e = str;
                eVar.f7381c = forbiddenInfo.launchSource;
                eVar.b(n.k(bVar.W()));
                eVar.d(bVar.s0().getString(UBCCloudControlProcessor.UBC_KEY));
                q.j(new a(eVar), "SwanAppFuncClickUBC");
            }
        }
    }

    public e() {
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

    public static e c3(String str, String str2, String str3, int i2, ForbiddenInfo forbiddenInfo, int i3, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{str, str2, str3, Integer.valueOf(i2), forbiddenInfo, Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            e eVar = new e();
            Bundle bundle = new Bundle();
            bundle.putString(SwanAppErrorActivity.KEY_SWAN_ERROR_TYPE, str2);
            bundle.putString(SwanAppErrorActivity.KEY_SWAN_ERROR_CODE, str);
            bundle.putString("webUrl", str3);
            bundle.putInt(SwanAppErrorActivity.KEY_SWAN_WEB_PERMIT, i2);
            bundle.putParcelable("key_forbidden_info", forbiddenInfo);
            bundle.putInt("key_show_menu_notice", i3);
            bundle.putInt("key_show_menu_privacy", i4);
            eVar.g1(bundle);
            return eVar;
        }
        return (e) invokeCommon.objValue;
    }

    @Override // b.a.p0.a.h0.g.d
    public boolean K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // b.a.p0.a.h0.g.d
    public void R1(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
            super.R1(view);
            S1(view);
            q2(-1);
            z2(-16777216);
            u2(false);
            G2(true);
            this.o0.setRightExitOnClickListener(new a(this));
            ForbiddenInfo forbiddenInfo = this.K0;
            if (forbiddenInfo == null || TextUtils.isEmpty(forbiddenInfo.appTitle)) {
                return;
            }
            s2(this.K0.appTitle);
        }
    }

    public final boolean T2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            ForbiddenInfo forbiddenInfo = this.K0;
            if (forbiddenInfo == null) {
                return false;
            }
            return forbiddenInfo.enableSliding();
        }
        return invokeV.booleanValue;
    }

    public final CharSequence U2(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            Map<String, String> g2 = b.a.p0.q.k.i.j.f().g();
            ForbiddenInfo forbiddenInfo = this.K0;
            if (forbiddenInfo != null) {
                String str2 = forbiddenInfo.forbiddenDetail;
                if (str2.length() > 4) {
                    String m = b.a.p0.q.k.i.j.m(g2, str2.substring(str2.length() - 4));
                    if (!TextUtils.isEmpty(m)) {
                        return m;
                    }
                }
            }
            char c2 = 65535;
            switch (str.hashCode()) {
                case -1242268664:
                    if (str.equals(SwanAppErrorActivity.TYPE_NEED_UPDATE_SDK)) {
                        c2 = 2;
                        break;
                    }
                    break;
                case -429452284:
                    if (str.equals(SwanAppErrorActivity.TYPE_PATH_FORBIDDEN)) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 38398066:
                    if (str.equals(SwanAppErrorActivity.TYPE_NETWORK_ERROR)) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 517286506:
                    if (str.equals(SwanAppErrorActivity.TYPE_MEMORY_LACK)) {
                        c2 = 4;
                        break;
                    }
                    break;
                case 517347882:
                    if (str.equals(SwanAppErrorActivity.TYPE_DISK_LACK)) {
                        c2 = 5;
                        break;
                    }
                    break;
                case 731215244:
                    if (str.equals(SwanAppErrorActivity.TYPE_NORMAL)) {
                        c2 = 1;
                        break;
                    }
                    break;
            }
            if (c2 == 0) {
                String m2 = b.a.p0.q.k.i.j.m(g2, "net_conn_failed");
                return TextUtils.isEmpty(m2) ? X(b.a.p0.a.h.swanapp_error_page_btn_text_reload) : m2;
            } else if (c2 == 1) {
                String m3 = b.a.p0.q.k.i.j.m(g2, "app_open_failed");
                return TextUtils.isEmpty(m3) ? X(b.a.p0.a.h.swanapp_error_page_btn_text_reload) : m3;
            } else if (c2 == 2) {
                String m4 = b.a.p0.q.k.i.j.m(g2, "app_need_upgrade");
                return TextUtils.isEmpty(m4) ? X(b.a.p0.a.h.swanapp_error_page_btn_text_reload) : m4;
            } else if (c2 == 3) {
                String m5 = b.a.p0.q.k.i.j.m(g2, "app_page_banned");
                return TextUtils.isEmpty(m5) ? X(b.a.p0.a.h.swanapp_error_page_btn_text_goto_home) : m5;
            } else if (c2 == 4) {
                String m6 = b.a.p0.q.k.i.j.m(g2, "0049");
                return TextUtils.isEmpty(m6) ? X(b.a.p0.a.h.swanapp_error_page_btn_text_reload) : m6;
            } else if (c2 != 5) {
                return "";
            } else {
                String m7 = b.a.p0.q.k.i.j.m(g2, "2205");
                return TextUtils.isEmpty(m7) ? X(b.a.p0.a.h.swanapp_error_page_btn_text_goto_clear) : m7;
            }
        }
        return (CharSequence) invokeL.objValue;
    }

    public final JSONObject V2(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, activity)) == null) {
            if (activity instanceof SwanAppErrorActivity) {
                ForbiddenInfo forbiddenInfo = ((SwanAppErrorActivity) activity).getForbiddenInfo();
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("title", forbiddenInfo.appTitle);
                    jSONObject.put("url", forbiddenInfo.launchPath);
                    jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, forbiddenInfo.appId);
                    jSONObject.put("errorPath", forbiddenInfo.launchPath);
                    jSONObject.put("errorDes", forbiddenInfo.forbiddenReason);
                } catch (JSONException e2) {
                    if (b.a.p0.a.h0.g.d.H0) {
                        e2.printStackTrace();
                    }
                }
                return jSONObject;
            }
            return null;
        }
        return (JSONObject) invokeL.objValue;
    }

    public final b.a.p0.a.f1.e.b W2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (getActivity() == null || !(getActivity() instanceof SwanAppErrorActivity)) {
                return null;
            }
            return ((SwanAppErrorActivity) getActivity()).getLaunchInfo();
        }
        return (b.a.p0.a.f1.e.b) invokeV.objValue;
    }

    public final String X2(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, str, str2)) == null) {
            String str3 = "";
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                char c2 = 65535;
                switch (str.hashCode()) {
                    case -1242268664:
                        if (str.equals(SwanAppErrorActivity.TYPE_NEED_UPDATE_SDK)) {
                            c2 = 2;
                            break;
                        }
                        break;
                    case -429452284:
                        if (str.equals(SwanAppErrorActivity.TYPE_PATH_FORBIDDEN)) {
                            c2 = 3;
                            break;
                        }
                        break;
                    case 38398066:
                        if (str.equals(SwanAppErrorActivity.TYPE_NETWORK_ERROR)) {
                            c2 = 0;
                            break;
                        }
                        break;
                    case 517286506:
                        if (str.equals(SwanAppErrorActivity.TYPE_MEMORY_LACK)) {
                            c2 = 4;
                            break;
                        }
                        break;
                    case 517347882:
                        if (str.equals(SwanAppErrorActivity.TYPE_DISK_LACK)) {
                            c2 = 5;
                            break;
                        }
                        break;
                    case 731215244:
                        if (str.equals(SwanAppErrorActivity.TYPE_NORMAL)) {
                            c2 = 1;
                            break;
                        }
                        break;
                }
                if (c2 == 0) {
                    str3 = getContext().getString(b.a.p0.a.h.swanapp_tip_net_unavailable);
                } else if (c2 == 1) {
                    str3 = getContext().getString(b.a.p0.a.h.swanapp_error_page_normal_error);
                } else if (c2 == 2) {
                    str3 = getContext().getString(b.a.p0.a.h.swanapp_error_page_need_update_sdk_opensource);
                } else if (c2 == 3) {
                    str3 = getContext().getString(b.a.p0.a.h.swanapp_error_page_path_forbidden);
                } else if (c2 == 4) {
                    str3 = getContext().getString(b.a.p0.a.h.swanapp_error_page_memory_lack);
                } else if (c2 == 5) {
                    str3 = getContext().getString(b.a.p0.a.h.swanapp_error_page_disk_space_lack);
                }
                Map<String, String> g2 = b.a.p0.q.k.i.j.f().g();
                if (g2 != null) {
                    ForbiddenInfo forbiddenInfo = this.K0;
                    if (forbiddenInfo != null) {
                        String str4 = forbiddenInfo.forbiddenDetail;
                        if (str4.length() > 4) {
                            String o = b.a.p0.q.k.i.j.o(g2, str4.substring(str4.length() - 4));
                            if (!TextUtils.isEmpty(o)) {
                                return o;
                            }
                        }
                    }
                    String o2 = b.a.p0.q.k.i.j.o(g2, str2);
                    if (!TextUtils.isEmpty(o2)) {
                        return o2;
                    }
                }
            }
            return str3;
        }
        return (String) invokeLL.objValue;
    }

    public void Y2() {
        FragmentActivity activity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (activity = getActivity()) != null && this.p0 == null) {
            b.a.p0.n.n nVar = new b.a.p0.n.n(activity, this.o0, 19, b.a.p0.a.c1.a.K(), new b.a.p0.a.a3.h.b());
            this.p0 = nVar;
            nVar.n(new i(this, activity));
            n3();
        }
    }

    @Override // b.a.p0.a.h0.g.d
    public boolean Z1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:80:0x0240  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0253  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x025a  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0261  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0266  */
    @SuppressLint({"UseCompatLoadingForDrawables"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void Z2(View view) {
        String str;
        b.a.p0.a.f1.e.b launchInfo;
        String N;
        ForbiddenInfo forbiddenInfo;
        String m3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, view) == null) || view == null) {
            return;
        }
        ImageView imageView = (ImageView) view.findViewById(b.a.p0.a.f.ai_apps_error_image);
        TextView textView = (TextView) view.findViewById(b.a.p0.a.f.ai_apps_emptyview_btn);
        TextView textView2 = (TextView) view.findViewById(b.a.p0.a.f.ai_apps_webmode_btn);
        TextView textView3 = (TextView) view.findViewById(b.a.p0.a.f.ai_apps_error_text_one);
        TextView textView4 = (TextView) view.findViewById(b.a.p0.a.f.ai_apps_error_feedback);
        TextView textView5 = (TextView) view.findViewById(b.a.p0.a.f.ai_apps_error_bottom_feedback);
        String str2 = this.I0;
        boolean z = true;
        if (str2 != null) {
            char c2 = 65535;
            switch (str2.hashCode()) {
                case -1869797338:
                    if (str2.equals(SwanAppErrorActivity.TYPE_LOAD_V8_FAILED)) {
                        c2 = 7;
                        break;
                    }
                    break;
                case -1242268664:
                    if (str2.equals(SwanAppErrorActivity.TYPE_NEED_UPDATE_SDK)) {
                        c2 = 4;
                        break;
                    }
                    break;
                case -429452284:
                    if (str2.equals(SwanAppErrorActivity.TYPE_PATH_FORBIDDEN)) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 38398066:
                    if (str2.equals(SwanAppErrorActivity.TYPE_NETWORK_ERROR)) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 157273878:
                    if (str2.equals(SwanAppErrorActivity.TYPE_APP_FORBIDDEN)) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 517286506:
                    if (str2.equals(SwanAppErrorActivity.TYPE_MEMORY_LACK)) {
                        c2 = 5;
                        break;
                    }
                    break;
                case 517347882:
                    if (str2.equals(SwanAppErrorActivity.TYPE_DISK_LACK)) {
                        c2 = 6;
                        break;
                    }
                    break;
                case 731215244:
                    if (str2.equals(SwanAppErrorActivity.TYPE_NORMAL)) {
                        c2 = 3;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    n.w(this.K0, "offline");
                    m3 = m3();
                    imageView.setImageDrawable(getContext().getDrawable(b.a.p0.a.e.swanapp_error_page_service_offline));
                    textView.setVisibility(8);
                    str = m3;
                    break;
                case 1:
                    n.w(this.K0, "pageblock");
                    m3 = TextUtils.isEmpty(this.K0.forbiddenInformation) ? getContext().getString(b.a.p0.a.h.swanapp_error_page_path_forbidden) : this.K0.forbiddenInformation;
                    imageView.setImageDrawable(getContext().getDrawable(b.a.p0.a.e.swanapp_error_page_forbidden_path));
                    if (j3(this.I0, "app_page_banned")) {
                        textView.setVisibility(0);
                        textView.setText(U2(this.I0));
                    } else {
                        textView.setVisibility(8);
                    }
                    if (b3()) {
                        textView.setVisibility(8);
                    }
                    str = m3;
                    break;
                case 2:
                    n.w(this.K0, "neterror");
                    m3 = X2(this.I0, "net_conn_failed");
                    imageView.setImageDrawable(getContext().getDrawable(b.a.p0.a.e.swanapp_error_page_network_error));
                    if (j3(this.I0, "net_conn_failed")) {
                        textView.setVisibility(0);
                        textView.setText(U2(this.I0));
                    } else {
                        textView.setVisibility(8);
                    }
                    textView3.setVisibility(8);
                    str = m3;
                    break;
                case 3:
                    n.w(this.K0, "commonerror");
                    m3 = X2(this.I0, "app_open_failed");
                    imageView.setImageDrawable(getContext().getDrawable(b.a.p0.a.e.swanapp_error_page_general_tips));
                    if (j3(this.I0, "app_open_failed")) {
                        textView.setVisibility(0);
                        textView.setText(U2(this.I0));
                    } else {
                        textView.setVisibility(8);
                    }
                    str = m3;
                    break;
                case 4:
                    n.w(this.K0, "update");
                    str = X2(this.I0, "app_need_upgrade");
                    if (j3(this.I0, "app_need_upgrade")) {
                        textView.setVisibility(0);
                        textView.setText(U2(this.I0));
                        break;
                    } else {
                        textView.setVisibility(8);
                        break;
                    }
                case 5:
                    n.w(this.K0, "lackresources");
                    m3 = X2(this.I0, "0049");
                    imageView.setImageDrawable(getContext().getDrawable(b.a.p0.a.e.swanapp_error_page_device_res_lack));
                    if (j3(this.I0, "0049")) {
                        textView.setVisibility(0);
                        textView.setText(U2(this.I0));
                    } else {
                        textView.setVisibility(8);
                    }
                    str = m3;
                    break;
                case 6:
                    n.w(this.K0, "outdisk");
                    m3 = X2(this.I0, "2205");
                    imageView.setImageDrawable(getContext().getDrawable(b.a.p0.a.e.swanapp_error_page_device_res_lack));
                    if (q0.G()) {
                        textView.setVisibility(0);
                    } else {
                        textView.setVisibility(8);
                    }
                    if (j3(this.I0, "2205")) {
                        textView.setVisibility(0);
                        textView.setText(U2(this.I0));
                    } else {
                        textView.setVisibility(8);
                    }
                    str = m3;
                    break;
                case 7:
                    str = getContext().getString(b.a.p0.a.h.aiapps_game_loadv8_so_failed);
                    textView.setVisibility(8);
                    break;
            }
            TextView textView6 = (TextView) view.findViewById(b.a.p0.a.f.ai_apps_error_msg);
            if (TextUtils.isEmpty(str)) {
                str = getContext().getString(b.a.p0.a.h.swanapp_error_page_normal_error);
            }
            textView6.setText(str);
            Activity activity = this.l0;
            launchInfo = !(activity instanceof SwanAppErrorActivity) ? ((SwanAppErrorActivity) activity).getLaunchInfo() : null;
            b.a.p0.a.d2.e a0 = b.a.p0.a.d2.e.a0();
            if (launchInfo == null) {
                N = launchInfo.H();
            } else {
                N = a0 != null ? a0.N() : null;
            }
            forbiddenInfo = this.K0;
            if (forbiddenInfo != null && !TextUtils.isEmpty(forbiddenInfo.forbiddenDetail)) {
                textView3.setText("(" + this.K0.forbiddenDetail + SmallTailInfo.EMOTION_SUFFIX);
                textView3.setTextColor(getResources().getColor(b.a.p0.a.c.aiapps_error_detail_color));
            }
            i3(textView, launchInfo);
            textView2.setOnClickListener(new b(this, launchInfo));
            if (q0.G() && !TextUtils.equals(this.I0, SwanAppErrorActivity.TYPE_NETWORK_ERROR)) {
                textView4.setVisibility(0);
                textView4.setOnClickListener(new c(this, N));
            }
            z = (this.Q0 == 1 || TextUtils.isEmpty(this.P0)) ? false : false;
            if (!a3() && z && p.d()) {
                textView5.setVisibility(0);
                textView2.setVisibility(0);
                textView4.setVisibility(8);
                return;
            }
            textView5.setVisibility(8);
            textView2.setVisibility(8);
            textView4.setVisibility(0);
        }
        str = null;
        TextView textView62 = (TextView) view.findViewById(b.a.p0.a.f.ai_apps_error_msg);
        if (TextUtils.isEmpty(str)) {
        }
        textView62.setText(str);
        Activity activity2 = this.l0;
        if (!(activity2 instanceof SwanAppErrorActivity)) {
        }
        b.a.p0.a.d2.e a02 = b.a.p0.a.d2.e.a0();
        if (launchInfo == null) {
        }
        forbiddenInfo = this.K0;
        if (forbiddenInfo != null) {
            textView3.setText("(" + this.K0.forbiddenDetail + SmallTailInfo.EMOTION_SUFFIX);
            textView3.setTextColor(getResources().getColor(b.a.p0.a.c.aiapps_error_detail_color));
        }
        i3(textView, launchInfo);
        textView2.setOnClickListener(new b(this, launchInfo));
        if (q0.G()) {
            textView4.setVisibility(0);
            textView4.setOnClickListener(new c(this, N));
        }
        if (this.Q0 == 1) {
        }
        if (!a3()) {
        }
        textView5.setVisibility(8);
        textView2.setVisibility(8);
        textView4.setVisibility(0);
    }

    public final boolean a3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            ArrayList<String> a2 = p.b().a();
            return a2 != null && a2.contains(this.J0);
        }
        return invokeV.booleanValue;
    }

    @Override // b.a.p0.a.h0.g.d
    public boolean b2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean b3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            ForbiddenInfo forbiddenInfo = this.K0;
            return forbiddenInfo != null && q0.I(forbiddenInfo.launchPath);
        }
        return invokeV.booleanValue;
    }

    public void d3(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, activity) == null) {
            b.a.p0.a.c1.a.K().h(activity, V2(activity));
            j.a("feedback", W2(), this.K0);
        }
    }

    public void e3(o oVar, Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, oVar, activity) == null) {
            b.a.p0.a.c1.a.K().g(activity, oVar);
            j.a(ErrorContentResponse.Operations.NOTICE, W2(), this.K0);
        }
    }

    public void f3(o oVar, Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, oVar, activity) == null) {
            b.a.p0.a.c1.a.K().b(activity, oVar);
            j.a(ErrorContentResponse.Operations.NOTICE, W2(), this.K0);
        }
    }

    @Override // b.a.p0.a.h0.g.d
    public void g2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            Y2();
            k3();
            n3();
            l3();
        }
    }

    public void g3(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, activity) == null) {
            b.a.p0.a.k1.a.j(activity);
            j.a("daynightmode", W2(), this.K0);
        }
    }

    public void h3(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, activity) == null) {
            if (activity instanceof SwanAppErrorActivity) {
                b.a.p0.a.k1.a.t(activity);
            }
            j.a("refresh", W2(), this.K0);
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public final void i3(TextView textView, b.a.p0.a.f1.e.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048595, this, textView, bVar) == null) {
            if (TextUtils.equals(this.N0, "1")) {
                textView.setOnClickListener(new d(this, bVar));
            } else if (TextUtils.equals(this.N0, "2")) {
                textView.setOnClickListener(new View$OnClickListenerC0215e(this));
            } else if (TextUtils.equals(this.N0, "3")) {
                textView.setOnClickListener(new f(this));
            } else if (TextUtils.equals(this.N0, "4")) {
                if (b3()) {
                    textView.setVisibility(8);
                } else {
                    textView.setOnClickListener(new g(this));
                }
            } else {
                textView.setText(b.a.p0.a.h.swanapp_error_page_btn_text_reload);
                textView.setOnClickListener(new h(this, bVar));
            }
        }
    }

    @Override // b.a.p0.a.h0.g.d, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, motionEvent)) == null) ? T2() : invokeL.booleanValue;
    }

    public final boolean j3(@NonNull String str, @NonNull String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048597, this, str, str2)) == null) {
            if (TextUtils.isEmpty(str2)) {
                return false;
            }
            Map<String, String> g2 = b.a.p0.q.k.i.j.f().g();
            ForbiddenInfo forbiddenInfo = this.K0;
            if (forbiddenInfo != null) {
                String str3 = forbiddenInfo.forbiddenDetail;
                if (str3.length() > 4) {
                    String substring = str3.substring(str3.length() - 4);
                    if (!TextUtils.isEmpty(b.a.p0.q.k.i.j.l(g2, substring))) {
                        this.N0 = b.a.p0.q.k.i.j.l(g2, substring);
                        this.O0 = b.a.p0.q.k.i.j.n(g2, substring);
                        return !TextUtils.equals(this.N0, "0");
                    }
                }
            }
            String l = b.a.p0.q.k.i.j.l(g2, str2);
            this.N0 = l;
            if (TextUtils.isEmpty(l)) {
                if (TextUtils.equals(str, SwanAppErrorActivity.TYPE_PATH_FORBIDDEN)) {
                    this.N0 = "4";
                } else if (TextUtils.equals(str, SwanAppErrorActivity.TYPE_DISK_LACK)) {
                    this.N0 = "3";
                } else if (TextUtils.equals(str, SwanAppErrorActivity.TYPE_APP_FORBIDDEN)) {
                    this.N0 = "0";
                } else if (TextUtils.equals(str, SwanAppErrorActivity.TYPE_LOAD_V8_FAILED)) {
                    this.N0 = "0";
                } else {
                    this.N0 = "1";
                }
            }
            this.O0 = b.a.p0.q.k.i.j.n(g2, str2);
            return !TextUtils.equals(this.N0, "0");
        }
        return invokeLL.booleanValue;
    }

    public final void k3() {
        b.a.p0.n.n nVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048598, this) == null) || (nVar = this.p0) == null) {
            return;
        }
        nVar.r(b.a.p0.a.c1.a.M().a());
    }

    public final void l3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            j.a(SupportMenuInflater.XML_MENU, W2(), this.K0);
        }
    }

    public final String m3() {
        InterceptResult invokeV;
        PMSAppInfo u;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            String string = getContext().getString(b.a.p0.a.h.swanapp_error_page_app_forbidden);
            ForbiddenInfo forbiddenInfo = this.K0;
            if (forbiddenInfo == null) {
                return string;
            }
            String str = forbiddenInfo.appId;
            return (TextUtils.isEmpty(str) || (u = b.a.p0.q.g.a.i().u(str)) == null || TextUtils.isEmpty(u.statusDesc)) ? string : u.statusDesc;
        }
        return (String) invokeV.objValue;
    }

    public final void n3() {
        b.a.p0.n.n nVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048601, this) == null) || (nVar = this.p0) == null) {
            return;
        }
        o h2 = nVar.h(46);
        o h3 = this.p0.h(47);
        if (h2 != null && this.L0 > 0) {
            h3.o(1);
            h3.n(this.L0);
        }
        if (h3 == null || this.M0 <= 0) {
            return;
        }
        h3.o(1);
        h3.n(this.M0);
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, bundle) == null) {
            super.onCreate(bundle);
            Bundle o = o();
            if (o == null) {
                return;
            }
            this.I0 = o.getString(SwanAppErrorActivity.KEY_SWAN_ERROR_TYPE);
            this.J0 = o.getString(SwanAppErrorActivity.KEY_SWAN_ERROR_CODE);
            this.P0 = o.getString("webUrl");
            this.Q0 = o.getInt(SwanAppErrorActivity.KEY_SWAN_WEB_PERMIT);
            this.K0 = (ForbiddenInfo) o.getParcelable("key_forbidden_info");
            this.L0 = o.getInt("key_show_menu_notice");
            this.M0 = o.getInt("key_show_menu_privacy");
        }
    }

    @Override // b.a.p0.a.h0.g.d, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            super.onResume();
            b.a.p0.n.n nVar = this.p0;
            if (nVar != null && nVar.i()) {
                this.p0.A(b.a.p0.a.c1.a.M().a());
            }
            SwanAppActionBar swanAppActionBar = this.o0;
            if (swanAppActionBar != null) {
                b.a.p0.a.l1.a.o(swanAppActionBar, this.M0 + this.L0);
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View z0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048604, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(b.a.p0.a.g.aiapps_error_fragment, viewGroup, false);
            Z2(inflate);
            R1(inflate);
            return Q1() ? T1(inflate) : inflate;
        }
        return (View) invokeLLL.objValue;
    }
}
