package c.a.r0.a.h0.g;

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
import c.a.r0.a.h0.g.l;
import c.a.r0.a.n2.n;
import c.a.r0.a.z2.q;
import c.a.r0.a.z2.q0;
import c.a.r0.n.o;
import c.a.r0.q.k.i.p;
import c.a.r0.r.a.a.m;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
import com.baidu.swan.apps.SwanAppClearCacheErrorActivity;
import com.baidu.swan.apps.SwanAppErrorActivity;
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
public class e extends c.a.r0.a.h0.g.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String J0;
    public String K0;
    public ForbiddenInfo L0;
    public int M0;
    public int N0;
    public String O0;
    public String P0;
    public String Q0;
    public int R0;

    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f6513e;

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
            this.f6513e = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Activity activity;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (activity = this.f6513e.g0) == null) {
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
        public final /* synthetic */ c.a.r0.a.f1.e.b f6514e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f6515f;

        public b(e eVar, c.a.r0.a.f1.e.b bVar) {
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
            this.f6515f = eVar;
            this.f6514e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Activity activity;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && (activity = this.f6515f.g0) != null && SwanAppNetworkUtils.i(activity)) {
                Bundle bundle = new Bundle();
                bundle.putBoolean("property_web_mode_degrade", true);
                SwanLauncher.j().n(this.f6514e, bundle);
                this.f6515f.g0.finishAndRemoveTask();
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f6516e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f6517f;

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
            this.f6517f = eVar;
            this.f6516e = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f6517f.L0 == null || TextUtils.isEmpty(this.f6517f.L0.forbiddenDetail)) {
                return;
            }
            c.a.r0.a.c1.a.u().b(this.f6517f.getActivity(), this.f6516e, this.f6517f.L0.appTitle, this.f6517f.L0.forbiddenDetail);
        }
    }

    /* loaded from: classes.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.f1.e.b f6518e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f6519f;

        public d(e eVar, c.a.r0.a.f1.e.b bVar) {
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
            this.f6519f = eVar;
            this.f6518e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Activity activity;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && (activity = this.f6519f.g0) != null && SwanAppNetworkUtils.i(activity)) {
                SwanLauncher.j().n(this.f6518e, null);
                this.f6519f.g0.finish();
            }
        }
    }

    /* renamed from: c.a.r0.a.h0.g.e$e  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC0355e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f6520e;

        public View$OnClickListenerC0355e(e eVar) {
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
            this.f6520e = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || TextUtils.isEmpty(this.f6520e.P0)) {
                return;
            }
            Activity activity = this.f6520e.g0;
            if (activity instanceof FragmentActivity) {
                m supportFragmentManager = ((FragmentActivity) activity).getSupportFragmentManager();
                l.d V2 = l.V2(this.f6520e.P0);
                V2.a(false);
                V2.c(supportFragmentManager);
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f6521e;

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
            this.f6521e = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                FragmentActivity activity = this.f6521e.getActivity();
                if (!(activity instanceof SwanAppClearCacheErrorActivity)) {
                    if (c.a.r0.a.h0.g.d.I0) {
                        throw new IllegalStateException("非SwanAppClearCacheErrorActivity");
                    }
                    return;
                }
                ((SwanAppClearCacheErrorActivity) activity).markHasGotoClearCache();
                try {
                    this.f6521e.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("baiduboxapp://v16/ucenter/cleanCache")));
                } catch (Exception e2) {
                    c.a.r0.a.e0.d.l("SwanAppErrorFragment", "打开清理缓存界面失败", e2);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f6522e;

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
            this.f6522e = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f6522e.J1();
            }
        }
    }

    /* loaded from: classes.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.f1.e.b f6523e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f6524f;

        public h(e eVar, c.a.r0.a.f1.e.b bVar) {
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
            this.f6524f = eVar;
            this.f6523e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Activity activity;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && (activity = this.f6524f.g0) != null && SwanAppNetworkUtils.i(activity)) {
                SwanLauncher.j().n(this.f6523e, null);
                this.f6524f.g0.finish();
            }
        }
    }

    /* loaded from: classes.dex */
    public class i implements c.a.r0.n.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f6525e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f6526f;

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
            this.f6526f = eVar;
            this.f6525e = activity;
        }

        @Override // c.a.r0.n.e
        public boolean b(View view, o oVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, oVar)) == null) {
                int c2 = oVar.c();
                if (c2 == 5) {
                    this.f6526f.d3(this.f6525e);
                } else if (c2 == 9) {
                    this.f6526f.a3(this.f6525e);
                    return true;
                } else if (c2 == 39) {
                    this.f6526f.e3(this.f6525e);
                } else if (c2 == 46) {
                    this.f6526f.b3(oVar, this.f6525e);
                } else if (c2 == 47) {
                    this.f6526f.c3(oVar, this.f6525e);
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
            public final /* synthetic */ c.a.r0.a.n2.s.e f6527e;

            public a(c.a.r0.a.n2.s.e eVar) {
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
                this.f6527e = eVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c.a.r0.a.n2.b.i("934", "85", this.f6527e.f());
                }
            }
        }

        public static void a(String str, c.a.r0.a.f1.e.b bVar, ForbiddenInfo forbiddenInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(65536, null, str, bVar, forbiddenInfo) == null) {
                c.a.r0.a.n2.s.e eVar = new c.a.r0.a.n2.s.e();
                eVar.f8161f = forbiddenInfo.appId;
                eVar.f8162g = "errormenu";
                eVar.f8157b = "click";
                eVar.f8160e = str;
                eVar.f8158c = forbiddenInfo.launchSource;
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

    public static e Z2(String str, String str2, String str3, int i2, ForbiddenInfo forbiddenInfo, int i3, int i4) {
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
            eVar.d1(bundle);
            return eVar;
        }
        return (e) invokeCommon.objValue;
    }

    @Override // c.a.r0.a.h0.g.d
    public boolean K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.r0.a.h0.g.d
    public void O1(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
            super.O1(view);
            P1(view);
            n2(-1);
            w2(-16777216);
            r2(false);
            D2(true);
            this.k0.setRightExitOnClickListener(new a(this));
            ForbiddenInfo forbiddenInfo = this.L0;
            if (forbiddenInfo == null || TextUtils.isEmpty(forbiddenInfo.appTitle)) {
                return;
            }
            p2(this.L0.appTitle);
        }
    }

    public final boolean Q2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            ForbiddenInfo forbiddenInfo = this.L0;
            if (forbiddenInfo == null) {
                return false;
            }
            return forbiddenInfo.enableSliding();
        }
        return invokeV.booleanValue;
    }

    public final CharSequence R2(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            Map<String, String> g2 = c.a.r0.q.k.i.j.f().g();
            ForbiddenInfo forbiddenInfo = this.L0;
            if (forbiddenInfo != null) {
                String str2 = forbiddenInfo.forbiddenDetail;
                if (str2.length() > 4) {
                    String m = c.a.r0.q.k.i.j.m(g2, str2.substring(str2.length() - 4));
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
                String m2 = c.a.r0.q.k.i.j.m(g2, "net_conn_failed");
                return TextUtils.isEmpty(m2) ? R(c.a.r0.a.h.swanapp_error_page_btn_text_reload) : m2;
            } else if (c2 == 1) {
                String m3 = c.a.r0.q.k.i.j.m(g2, "app_open_failed");
                return TextUtils.isEmpty(m3) ? R(c.a.r0.a.h.swanapp_error_page_btn_text_reload) : m3;
            } else if (c2 == 2) {
                String m4 = c.a.r0.q.k.i.j.m(g2, "app_need_upgrade");
                return TextUtils.isEmpty(m4) ? R(c.a.r0.a.h.swanapp_error_page_btn_text_reload) : m4;
            } else if (c2 == 3) {
                String m5 = c.a.r0.q.k.i.j.m(g2, "app_page_banned");
                return TextUtils.isEmpty(m5) ? R(c.a.r0.a.h.swanapp_error_page_btn_text_goto_home) : m5;
            } else if (c2 == 4) {
                String m6 = c.a.r0.q.k.i.j.m(g2, "0049");
                return TextUtils.isEmpty(m6) ? R(c.a.r0.a.h.swanapp_error_page_btn_text_reload) : m6;
            } else if (c2 != 5) {
                return "";
            } else {
                String m7 = c.a.r0.q.k.i.j.m(g2, "2205");
                return TextUtils.isEmpty(m7) ? R(c.a.r0.a.h.swanapp_error_page_btn_text_goto_clear) : m7;
            }
        }
        return (CharSequence) invokeL.objValue;
    }

    public final JSONObject S2(Activity activity) {
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
                    if (c.a.r0.a.h0.g.d.I0) {
                        e2.printStackTrace();
                    }
                }
                return jSONObject;
            }
            return null;
        }
        return (JSONObject) invokeL.objValue;
    }

    public final c.a.r0.a.f1.e.b T2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (getActivity() == null || !(getActivity() instanceof SwanAppErrorActivity)) {
                return null;
            }
            return ((SwanAppErrorActivity) getActivity()).getLaunchInfo();
        }
        return (c.a.r0.a.f1.e.b) invokeV.objValue;
    }

    public final String U2(String str, String str2) {
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
                    str3 = getContext().getString(c.a.r0.a.h.swanapp_tip_net_unavailable);
                } else if (c2 == 1) {
                    str3 = getContext().getString(c.a.r0.a.h.swanapp_error_page_normal_error);
                } else if (c2 == 2) {
                    str3 = getContext().getString(c.a.r0.a.h.swanapp_error_page_need_update_sdk_opensource);
                } else if (c2 == 3) {
                    str3 = getContext().getString(c.a.r0.a.h.swanapp_error_page_path_forbidden);
                } else if (c2 == 4) {
                    str3 = getContext().getString(c.a.r0.a.h.swanapp_error_page_memory_lack);
                } else if (c2 == 5) {
                    str3 = getContext().getString(c.a.r0.a.h.swanapp_error_page_disk_space_lack);
                }
                Map<String, String> g2 = c.a.r0.q.k.i.j.f().g();
                if (g2 != null) {
                    ForbiddenInfo forbiddenInfo = this.L0;
                    if (forbiddenInfo != null) {
                        String str4 = forbiddenInfo.forbiddenDetail;
                        if (str4.length() > 4) {
                            String o = c.a.r0.q.k.i.j.o(g2, str4.substring(str4.length() - 4));
                            if (!TextUtils.isEmpty(o)) {
                                return o;
                            }
                        }
                    }
                    String o2 = c.a.r0.q.k.i.j.o(g2, str2);
                    if (!TextUtils.isEmpty(o2)) {
                        return o2;
                    }
                }
            }
            return str3;
        }
        return (String) invokeLL.objValue;
    }

    public void V2() {
        FragmentActivity activity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (activity = getActivity()) != null && this.q0 == null) {
            c.a.r0.n.n nVar = new c.a.r0.n.n(activity, this.k0, 19, c.a.r0.a.c1.a.K(), new c.a.r0.a.a3.h.b());
            this.q0 = nVar;
            nVar.r(new i(this, activity));
            k3();
        }
    }

    @Override // c.a.r0.a.h0.g.d
    public boolean W1() {
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
    public void W2(View view) {
        String str;
        c.a.r0.a.f1.e.b launchInfo;
        String N;
        ForbiddenInfo forbiddenInfo;
        String j3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, view) == null) || view == null) {
            return;
        }
        ImageView imageView = (ImageView) view.findViewById(c.a.r0.a.f.ai_apps_error_image);
        TextView textView = (TextView) view.findViewById(c.a.r0.a.f.ai_apps_emptyview_btn);
        TextView textView2 = (TextView) view.findViewById(c.a.r0.a.f.ai_apps_webmode_btn);
        TextView textView3 = (TextView) view.findViewById(c.a.r0.a.f.ai_apps_error_text_one);
        TextView textView4 = (TextView) view.findViewById(c.a.r0.a.f.ai_apps_error_feedback);
        TextView textView5 = (TextView) view.findViewById(c.a.r0.a.f.ai_apps_error_bottom_feedback);
        String str2 = this.J0;
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
                    n.w(this.L0, "offline");
                    j3 = j3();
                    imageView.setImageDrawable(getContext().getDrawable(c.a.r0.a.e.swanapp_error_page_service_offline));
                    textView.setVisibility(8);
                    str = j3;
                    break;
                case 1:
                    n.w(this.L0, "pageblock");
                    j3 = TextUtils.isEmpty(this.L0.forbiddenInformation) ? getContext().getString(c.a.r0.a.h.swanapp_error_page_path_forbidden) : this.L0.forbiddenInformation;
                    imageView.setImageDrawable(getContext().getDrawable(c.a.r0.a.e.swanapp_error_page_forbidden_path));
                    if (g3(this.J0, "app_page_banned")) {
                        textView.setVisibility(0);
                        textView.setText(R2(this.J0));
                    } else {
                        textView.setVisibility(8);
                    }
                    if (Y2()) {
                        textView.setVisibility(8);
                    }
                    str = j3;
                    break;
                case 2:
                    n.w(this.L0, "neterror");
                    j3 = U2(this.J0, "net_conn_failed");
                    imageView.setImageDrawable(getContext().getDrawable(c.a.r0.a.e.swanapp_error_page_network_error));
                    if (g3(this.J0, "net_conn_failed")) {
                        textView.setVisibility(0);
                        textView.setText(R2(this.J0));
                    } else {
                        textView.setVisibility(8);
                    }
                    textView3.setVisibility(8);
                    str = j3;
                    break;
                case 3:
                    n.w(this.L0, "commonerror");
                    j3 = U2(this.J0, "app_open_failed");
                    imageView.setImageDrawable(getContext().getDrawable(c.a.r0.a.e.swanapp_error_page_general_tips));
                    if (g3(this.J0, "app_open_failed")) {
                        textView.setVisibility(0);
                        textView.setText(R2(this.J0));
                    } else {
                        textView.setVisibility(8);
                    }
                    str = j3;
                    break;
                case 4:
                    n.w(this.L0, "update");
                    str = U2(this.J0, "app_need_upgrade");
                    if (g3(this.J0, "app_need_upgrade")) {
                        textView.setVisibility(0);
                        textView.setText(R2(this.J0));
                        break;
                    } else {
                        textView.setVisibility(8);
                        break;
                    }
                case 5:
                    n.w(this.L0, "lackresources");
                    j3 = U2(this.J0, "0049");
                    imageView.setImageDrawable(getContext().getDrawable(c.a.r0.a.e.swanapp_error_page_device_res_lack));
                    if (g3(this.J0, "0049")) {
                        textView.setVisibility(0);
                        textView.setText(R2(this.J0));
                    } else {
                        textView.setVisibility(8);
                    }
                    str = j3;
                    break;
                case 6:
                    n.w(this.L0, "outdisk");
                    j3 = U2(this.J0, "2205");
                    imageView.setImageDrawable(getContext().getDrawable(c.a.r0.a.e.swanapp_error_page_device_res_lack));
                    if (q0.G()) {
                        textView.setVisibility(0);
                    } else {
                        textView.setVisibility(8);
                    }
                    if (g3(this.J0, "2205")) {
                        textView.setVisibility(0);
                        textView.setText(R2(this.J0));
                    } else {
                        textView.setVisibility(8);
                    }
                    str = j3;
                    break;
                case 7:
                    str = getContext().getString(c.a.r0.a.h.aiapps_game_loadv8_so_failed);
                    textView.setVisibility(8);
                    break;
            }
            TextView textView6 = (TextView) view.findViewById(c.a.r0.a.f.ai_apps_error_msg);
            if (TextUtils.isEmpty(str)) {
                str = getContext().getString(c.a.r0.a.h.swanapp_error_page_normal_error);
            }
            textView6.setText(str);
            Activity activity = this.g0;
            launchInfo = !(activity instanceof SwanAppErrorActivity) ? ((SwanAppErrorActivity) activity).getLaunchInfo() : null;
            c.a.r0.a.d2.e a0 = c.a.r0.a.d2.e.a0();
            if (launchInfo == null) {
                N = launchInfo.H();
            } else {
                N = a0 != null ? a0.N() : null;
            }
            forbiddenInfo = this.L0;
            if (forbiddenInfo != null && !TextUtils.isEmpty(forbiddenInfo.forbiddenDetail)) {
                textView3.setText("(" + this.L0.forbiddenDetail + SmallTailInfo.EMOTION_SUFFIX);
                textView3.setTextColor(getResources().getColor(c.a.r0.a.c.aiapps_error_detail_color));
            }
            f3(textView, launchInfo);
            textView2.setOnClickListener(new b(this, launchInfo));
            if (q0.G() && !TextUtils.equals(this.J0, SwanAppErrorActivity.TYPE_NETWORK_ERROR)) {
                textView4.setVisibility(0);
                textView4.setOnClickListener(new c(this, N));
            }
            z = (this.R0 == 1 || TextUtils.isEmpty(this.Q0)) ? false : false;
            if (!X2() && z && p.d()) {
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
        TextView textView62 = (TextView) view.findViewById(c.a.r0.a.f.ai_apps_error_msg);
        if (TextUtils.isEmpty(str)) {
        }
        textView62.setText(str);
        Activity activity2 = this.g0;
        if (!(activity2 instanceof SwanAppErrorActivity)) {
        }
        c.a.r0.a.d2.e a02 = c.a.r0.a.d2.e.a0();
        if (launchInfo == null) {
        }
        forbiddenInfo = this.L0;
        if (forbiddenInfo != null) {
            textView3.setText("(" + this.L0.forbiddenDetail + SmallTailInfo.EMOTION_SUFFIX);
            textView3.setTextColor(getResources().getColor(c.a.r0.a.c.aiapps_error_detail_color));
        }
        f3(textView, launchInfo);
        textView2.setOnClickListener(new b(this, launchInfo));
        if (q0.G()) {
            textView4.setVisibility(0);
            textView4.setOnClickListener(new c(this, N));
        }
        if (this.R0 == 1) {
        }
        if (!X2()) {
        }
        textView5.setVisibility(8);
        textView2.setVisibility(8);
        textView4.setVisibility(0);
    }

    public final boolean X2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            ArrayList<String> a2 = p.b().a();
            return a2 != null && a2.contains(this.K0);
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.r0.a.h0.g.d
    public boolean Y1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean Y2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            ForbiddenInfo forbiddenInfo = this.L0;
            return forbiddenInfo != null && q0.I(forbiddenInfo.launchPath);
        }
        return invokeV.booleanValue;
    }

    public void a3(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, activity) == null) {
            c.a.r0.a.c1.a.K().h(activity, S2(activity));
            j.a("feedback", T2(), this.L0);
        }
    }

    public void b3(o oVar, Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, oVar, activity) == null) {
            c.a.r0.a.c1.a.K().g(activity, oVar);
            j.a(ErrorContentResponse.Operations.NOTICE, T2(), this.L0);
        }
    }

    public void c3(o oVar, Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, oVar, activity) == null) {
            c.a.r0.a.c1.a.K().b(activity, oVar);
            j.a(ErrorContentResponse.Operations.NOTICE, T2(), this.L0);
        }
    }

    @Override // c.a.r0.a.h0.g.d
    public void d2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            V2();
            h3();
            k3();
            i3();
        }
    }

    public void d3(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, activity) == null) {
            c.a.r0.a.k1.a.j(activity);
            j.a("daynightmode", T2(), this.L0);
        }
    }

    public void e3(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, activity) == null) {
            if (activity instanceof SwanAppErrorActivity) {
                c.a.r0.a.k1.a.t(activity);
            }
            j.a("refresh", T2(), this.L0);
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public final void f3(TextView textView, c.a.r0.a.f1.e.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048595, this, textView, bVar) == null) {
            if (TextUtils.equals(this.O0, "1")) {
                textView.setOnClickListener(new d(this, bVar));
            } else if (TextUtils.equals(this.O0, "2")) {
                textView.setOnClickListener(new View$OnClickListenerC0355e(this));
            } else if (TextUtils.equals(this.O0, "3")) {
                textView.setOnClickListener(new f(this));
            } else if (TextUtils.equals(this.O0, "4")) {
                if (Y2()) {
                    textView.setVisibility(8);
                } else {
                    textView.setOnClickListener(new g(this));
                }
            } else {
                textView.setText(c.a.r0.a.h.swanapp_error_page_btn_text_reload);
                textView.setOnClickListener(new h(this, bVar));
            }
        }
    }

    public final boolean g3(@NonNull String str, @NonNull String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048596, this, str, str2)) == null) {
            if (TextUtils.isEmpty(str2)) {
                return false;
            }
            Map<String, String> g2 = c.a.r0.q.k.i.j.f().g();
            ForbiddenInfo forbiddenInfo = this.L0;
            if (forbiddenInfo != null) {
                String str3 = forbiddenInfo.forbiddenDetail;
                if (str3.length() > 4) {
                    String substring = str3.substring(str3.length() - 4);
                    if (!TextUtils.isEmpty(c.a.r0.q.k.i.j.l(g2, substring))) {
                        this.O0 = c.a.r0.q.k.i.j.l(g2, substring);
                        this.P0 = c.a.r0.q.k.i.j.n(g2, substring);
                        return !TextUtils.equals(this.O0, "0");
                    }
                }
            }
            String l = c.a.r0.q.k.i.j.l(g2, str2);
            this.O0 = l;
            if (TextUtils.isEmpty(l)) {
                if (TextUtils.equals(str, SwanAppErrorActivity.TYPE_PATH_FORBIDDEN)) {
                    this.O0 = "4";
                } else if (TextUtils.equals(str, SwanAppErrorActivity.TYPE_DISK_LACK)) {
                    this.O0 = "3";
                } else if (TextUtils.equals(str, SwanAppErrorActivity.TYPE_APP_FORBIDDEN)) {
                    this.O0 = "0";
                } else if (TextUtils.equals(str, SwanAppErrorActivity.TYPE_LOAD_V8_FAILED)) {
                    this.O0 = "0";
                } else {
                    this.O0 = "1";
                }
            }
            this.P0 = c.a.r0.q.k.i.j.n(g2, str2);
            return !TextUtils.equals(this.O0, "0");
        }
        return invokeLL.booleanValue;
    }

    public final void h3() {
        c.a.r0.n.n nVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048597, this) == null) || (nVar = this.q0) == null) {
            return;
        }
        nVar.v(c.a.r0.a.c1.a.M().a());
    }

    public final void i3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            j.a(SupportMenuInflater.XML_MENU, T2(), this.L0);
        }
    }

    @Override // c.a.r0.a.h0.g.d, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, motionEvent)) == null) ? Q2() : invokeL.booleanValue;
    }

    public final String j3() {
        InterceptResult invokeV;
        PMSAppInfo u;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            String string = getContext().getString(c.a.r0.a.h.swanapp_error_page_app_forbidden);
            ForbiddenInfo forbiddenInfo = this.L0;
            if (forbiddenInfo == null) {
                return string;
            }
            String str = forbiddenInfo.appId;
            return (TextUtils.isEmpty(str) || (u = c.a.r0.q.g.a.i().u(str)) == null || TextUtils.isEmpty(u.statusDesc)) ? string : u.statusDesc;
        }
        return (String) invokeV.objValue;
    }

    public final void k3() {
        c.a.r0.n.n nVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048601, this) == null) || (nVar = this.q0) == null) {
            return;
        }
        o k2 = nVar.k(46);
        o k3 = this.q0.k(47);
        if (k2 != null && this.M0 > 0) {
            k3.o(1);
            k3.n(this.M0);
        }
        if (k3 == null || this.N0 <= 0) {
            return;
        }
        k3.o(1);
        k3.n(this.N0);
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, bundle) == null) {
            super.onCreate(bundle);
            Bundle t = t();
            if (t == null) {
                return;
            }
            this.J0 = t.getString(SwanAppErrorActivity.KEY_SWAN_ERROR_TYPE);
            this.K0 = t.getString(SwanAppErrorActivity.KEY_SWAN_ERROR_CODE);
            this.Q0 = t.getString("webUrl");
            this.R0 = t.getInt(SwanAppErrorActivity.KEY_SWAN_WEB_PERMIT);
            this.L0 = (ForbiddenInfo) t.getParcelable("key_forbidden_info");
            this.M0 = t.getInt("key_show_menu_notice");
            this.N0 = t.getInt("key_show_menu_privacy");
        }
    }

    @Override // c.a.r0.a.h0.g.d, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            super.onResume();
            c.a.r0.n.n nVar = this.q0;
            if (nVar != null && nVar.l()) {
                this.q0.E(c.a.r0.a.c1.a.M().a());
            }
            SwanAppActionBar swanAppActionBar = this.k0;
            if (swanAppActionBar != null) {
                c.a.r0.a.l1.a.o(swanAppActionBar, this.N0 + this.M0);
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View w0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048604, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(c.a.r0.a.g.aiapps_error_fragment, viewGroup, false);
            W2(inflate);
            O1(inflate);
            return N1() ? Q1(inflate) : inflate;
        }
        return (View) invokeLLL.objValue;
    }
}
