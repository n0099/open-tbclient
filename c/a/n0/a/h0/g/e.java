package c.a.n0.a.h0.g;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.v2.q;
import c.a.n0.a.v2.q0;
import c.a.n0.k.n;
import c.a.n0.k.o;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
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
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class e extends c.a.n0.a.h0.g.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String C0;
    public ForbiddenInfo D0;
    public int E0;
    public int F0;
    public String G0;

    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f5629e;

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
            this.f5629e = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Activity activity;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (activity = this.f5629e.k0) == null) {
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
        public final /* synthetic */ c.a.n0.a.f1.e.b f5630e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f5631f;

        public b(e eVar, c.a.n0.a.f1.e.b bVar) {
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
            this.f5631f = eVar;
            this.f5630e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Activity activity;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                String str = this.f5631f.G0;
                if (((str.hashCode() == 49 && str.equals("1")) ? (char) 0 : (char) 65535) == 0 && (activity = this.f5631f.k0) != null && SwanAppNetworkUtils.i(activity)) {
                    SwanLauncher.j().n(this.f5630e, null);
                    this.f5631f.k0.finish();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f5632e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f5633f;

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
            this.f5633f = eVar;
            this.f5632e = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f5633f.D0 == null || TextUtils.isEmpty(this.f5633f.D0.forbiddenDetail)) {
                return;
            }
            c.a.n0.a.c1.a.t().b(this.f5633f.h(), this.f5632e, this.f5633f.D0.appTitle, this.f5633f.D0.forbiddenDetail);
        }
    }

    /* loaded from: classes.dex */
    public class d implements c.a.n0.k.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f5634e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f5635f;

        public d(e eVar, Activity activity) {
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
            this.f5635f = eVar;
            this.f5634e = activity;
        }

        @Override // c.a.n0.k.e
        public boolean b(View view, o oVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, oVar)) == null) {
                int c2 = oVar.c();
                if (c2 == 5) {
                    this.f5635f.T2(this.f5634e);
                } else if (c2 == 9) {
                    this.f5635f.Q2(this.f5634e);
                    return true;
                } else if (c2 == 39) {
                    this.f5635f.U2(this.f5634e);
                } else if (c2 == 46) {
                    this.f5635f.R2(oVar, this.f5634e);
                } else if (c2 == 47) {
                    this.f5635f.S2(oVar, this.f5634e);
                }
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* renamed from: c.a.n0.a.h0.g.e$e  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0203e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c.a.n0.a.h0.g.e$e$a */
        /* loaded from: classes.dex */
        public static class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.n0.a.j2.p.e f5636e;

            public a(c.a.n0.a.j2.p.e eVar) {
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
                this.f5636e = eVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c.a.n0.a.j2.b.i("934", "85", this.f5636e.f());
                }
            }
        }

        public static void a(String str, c.a.n0.a.f1.e.b bVar, ForbiddenInfo forbiddenInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(65536, null, str, bVar, forbiddenInfo) == null) {
                c.a.n0.a.j2.p.e eVar = new c.a.n0.a.j2.p.e();
                eVar.f6794f = forbiddenInfo.appId;
                eVar.f6795g = "errormenu";
                eVar.f6790b = PrefetchEvent.STATE_CLICK;
                eVar.f6793e = str;
                eVar.f6791c = forbiddenInfo.launchSource;
                eVar.b(c.a.n0.a.j2.k.k(bVar.W()));
                eVar.d(bVar.r0().getString(UBCCloudControlProcessor.UBC_KEY));
                q.i(new a(eVar), "SwanAppFuncClickUBC");
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

    public static e P2(String str, ForbiddenInfo forbiddenInfo, int i2, int i3) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(65539, null, str, forbiddenInfo, i2, i3)) == null) {
            e eVar = new e();
            Bundle bundle = new Bundle();
            bundle.putString(SwanAppErrorActivity.KEY_SWAN_ERROR_TYPE, str);
            bundle.putParcelable("key_forbidden_info", forbiddenInfo);
            bundle.putInt("key_show_menu_notice", i2);
            bundle.putInt("key_show_menu_privacy", i3);
            eVar.h1(bundle);
            return eVar;
        }
        return (e) invokeLLII.objValue;
    }

    public final boolean H2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ForbiddenInfo forbiddenInfo = this.D0;
            if (forbiddenInfo == null) {
                return false;
            }
            return forbiddenInfo.enableSliding();
        }
        return invokeV.booleanValue;
    }

    public final CharSequence I2(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            Map<String, String> c2 = c.a.n0.n.j.i.i.b().c();
            ForbiddenInfo forbiddenInfo = this.D0;
            if (forbiddenInfo != null) {
                String str2 = forbiddenInfo.forbiddenDetail;
                if (str2.length() > 4) {
                    String substring = str2.substring(str2.length() - 4);
                    String str3 = c2.get(substring + "_btn_text");
                    if (!TextUtils.isEmpty(str3)) {
                        return str3;
                    }
                }
            }
            char c3 = 65535;
            int hashCode = str.hashCode();
            if (hashCode != -1242268664) {
                if (hashCode != 38398066) {
                    if (hashCode == 731215244 && str.equals(SwanAppErrorActivity.TYPE_NORMAL)) {
                        c3 = 1;
                    }
                } else if (str.equals(SwanAppErrorActivity.TYPE_NETWORK_ERROR)) {
                    c3 = 0;
                }
            } else if (str.equals(SwanAppErrorActivity.TYPE_NEED_UPDATE_SDK)) {
                c3 = 2;
            }
            if (c3 == 0) {
                String str4 = c2.get("net_conn_failed_btn_text");
                return TextUtils.isEmpty(str4) ? d0(c.a.n0.a.h.aiapps_magicbox_on_empty_reload) : str4;
            } else if (c3 == 1) {
                String str5 = c2.get("app_open_failed_btn_text");
                return TextUtils.isEmpty(str5) ? d0(c.a.n0.a.h.aiapps_magicbox_on_empty_reload) : str5;
            } else if (c3 != 2) {
                return "";
            } else {
                String str6 = c2.get("app_need_upgrade_btn_text");
                return TextUtils.isEmpty(str6) ? d0(c.a.n0.a.h.aiapps_magicbox_on_empty_reload) : str6;
            }
        }
        return (CharSequence) invokeL.objValue;
    }

    @Override // c.a.n0.a.h0.g.d
    public boolean J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public final JSONObject J2(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, activity)) == null) {
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
                    if (c.a.n0.a.h0.g.d.B0) {
                        e2.printStackTrace();
                    }
                }
                return jSONObject;
            }
            return null;
        }
        return (JSONObject) invokeL.objValue;
    }

    public final c.a.n0.a.f1.e.b K2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (h() == null || !(h() instanceof SwanAppErrorActivity)) {
                return null;
            }
            return ((SwanAppErrorActivity) h()).getLaunchInfo();
        }
        return (c.a.n0.a.f1.e.b) invokeV.objValue;
    }

    public final String L2(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, str2)) == null) {
            String str3 = "";
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                char c2 = 65535;
                int hashCode = str.hashCode();
                if (hashCode != -1242268664) {
                    if (hashCode != 38398066) {
                        if (hashCode == 731215244 && str.equals(SwanAppErrorActivity.TYPE_NORMAL)) {
                            c2 = 1;
                        }
                    } else if (str.equals(SwanAppErrorActivity.TYPE_NETWORK_ERROR)) {
                        c2 = 0;
                    }
                } else if (str.equals(SwanAppErrorActivity.TYPE_NEED_UPDATE_SDK)) {
                    c2 = 2;
                }
                if (c2 == 0) {
                    str3 = q().getString(c.a.n0.a.h.swanapp_tip_net_unavailable);
                } else if (c2 == 1) {
                    str3 = q().getString(c.a.n0.a.h.swanapp_normal_error);
                } else if (c2 == 2) {
                    str3 = q().getString(c.a.n0.a.h.swanapp_normal_error);
                }
                Map<String, String> c3 = c.a.n0.n.j.i.i.b().c();
                if (c3 != null) {
                    ForbiddenInfo forbiddenInfo = this.D0;
                    if (forbiddenInfo != null) {
                        String str4 = forbiddenInfo.forbiddenDetail;
                        if (str4.length() > 4) {
                            String substring = str4.substring(str4.length() - 4);
                            String str5 = c3.get(substring + "_tips");
                            if (!TextUtils.isEmpty(str5)) {
                                return str5;
                            }
                        }
                    }
                    String str6 = c3.get(str2 + "_tips");
                    if (!TextUtils.isEmpty(str6)) {
                        return str6;
                    }
                }
            }
            return str3;
        }
        return (String) invokeLL.objValue;
    }

    public void M2() {
        FragmentActivity h2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (h2 = h()) != null && this.o0 == null) {
            n nVar = new n(h2, this.n0, 19, c.a.n0.a.c1.a.G(), new c.a.n0.a.w2.h.b());
            this.o0 = nVar;
            nVar.l(new d(this, h2));
            Z2();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:61:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0187  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void N2(View view) {
        String str;
        c.a.n0.a.f1.e.b launchInfo;
        String D;
        ForbiddenInfo forbiddenInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, view) == null) || view == null) {
            return;
        }
        ImageView imageView = (ImageView) view.findViewById(c.a.n0.a.f.ai_apps_error_image);
        TextView textView = (TextView) view.findViewById(c.a.n0.a.f.ai_apps_emptyview_btn);
        TextView textView2 = (TextView) view.findViewById(c.a.n0.a.f.ai_apps_error_text_one);
        TextView textView3 = (TextView) view.findViewById(c.a.n0.a.f.ai_apps_error_feedback);
        String str2 = this.C0;
        if (str2 != null) {
            char c2 = 65535;
            switch (str2.hashCode()) {
                case -1869797338:
                    if (str2.equals(SwanAppErrorActivity.TYPE_LOAD_V8_FAILED)) {
                        c2 = 5;
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
                case 731215244:
                    if (str2.equals(SwanAppErrorActivity.TYPE_NORMAL)) {
                        c2 = 3;
                        break;
                    }
                    break;
            }
            if (c2 == 0) {
                c.a.n0.a.j2.k.t(this.D0, "offline");
                str = Y2();
            } else if (c2 == 1) {
                c.a.n0.a.j2.k.t(this.D0, "pageblock");
                str = TextUtils.isEmpty(this.D0.forbiddenInformation) ? q().getString(c.a.n0.a.h.swanapp_path_forbidden) : this.D0.forbiddenInformation;
            } else if (c2 == 2) {
                c.a.n0.a.j2.k.t(this.D0, "neterror");
                String L2 = L2(this.C0, "net_conn_failed");
                imageView.setImageDrawable(q().getResources().getDrawable(c.a.n0.a.e.aiapps_empty_icon_network));
                if (O2(this.C0)) {
                    textView.setVisibility(0);
                    textView.setText(I2(this.C0));
                } else {
                    textView.setVisibility(8);
                }
                textView2.setVisibility(8);
                str = L2;
            } else if (c2 == 3) {
                c.a.n0.a.j2.k.t(this.D0, "commonerror");
                str = L2(this.C0, "app_open_failed");
                if (O2(this.C0)) {
                    textView.setVisibility(0);
                    textView.setText(I2(this.C0));
                } else {
                    textView.setVisibility(8);
                }
            } else if (c2 == 4) {
                c.a.n0.a.j2.k.t(this.D0, "update");
                str = L2(this.C0, "app_need_upgrade");
                if (O2(this.C0)) {
                    textView.setVisibility(0);
                    textView.setText(I2(this.C0));
                } else {
                    textView.setVisibility(8);
                }
            } else if (c2 == 5) {
                str = q().getString(c.a.n0.a.h.aiapps_game_loadv8_so_failed);
                textView.setVisibility(8);
            }
            TextView textView4 = (TextView) view.findViewById(c.a.n0.a.f.ai_apps_error_msg);
            if (str == null) {
                str = q().getString(c.a.n0.a.h.swanapp_normal_error);
            }
            textView4.setText(str);
            Activity activity = this.k0;
            launchInfo = !(activity instanceof SwanAppErrorActivity) ? ((SwanAppErrorActivity) activity).getLaunchInfo() : null;
            c.a.n0.a.a2.e Q = c.a.n0.a.a2.e.Q();
            if (launchInfo == null) {
                D = launchInfo.H();
            } else {
                D = Q != null ? Q.D() : null;
            }
            forbiddenInfo = this.D0;
            if (forbiddenInfo != null && !TextUtils.isEmpty(forbiddenInfo.forbiddenDetail)) {
                textView2.setText("(" + this.D0.forbiddenDetail + SmallTailInfo.EMOTION_SUFFIX);
                textView2.setTextColor(z().getColor(c.a.n0.a.c.aiapps_error_detail_color));
            }
            textView.setOnClickListener(new b(this, launchInfo));
            if (q0.G() || TextUtils.equals(this.C0, SwanAppErrorActivity.TYPE_NETWORK_ERROR)) {
            }
            textView3.setVisibility(0);
            textView3.setOnClickListener(new c(this, D));
            return;
        }
        str = null;
        TextView textView42 = (TextView) view.findViewById(c.a.n0.a.f.ai_apps_error_msg);
        if (str == null) {
        }
        textView42.setText(str);
        Activity activity2 = this.k0;
        if (!(activity2 instanceof SwanAppErrorActivity)) {
        }
        c.a.n0.a.a2.e Q2 = c.a.n0.a.a2.e.Q();
        if (launchInfo == null) {
        }
        forbiddenInfo = this.D0;
        if (forbiddenInfo != null) {
            textView2.setText("(" + this.D0.forbiddenDetail + SmallTailInfo.EMOTION_SUFFIX);
            textView2.setTextColor(z().getColor(c.a.n0.a.c.aiapps_error_detail_color));
        }
        textView.setOnClickListener(new b(this, launchInfo));
        if (q0.G()) {
        }
    }

    @Override // c.a.n0.a.h0.g.d
    public void O1(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view) == null) {
            super.O1(view);
            P1(view);
            j2(-1);
            r2(-16777216);
            n2(false);
            x2(true);
            this.n0.setRightExitOnClickListener(new a(this));
            ForbiddenInfo forbiddenInfo = this.D0;
            if (forbiddenInfo == null || TextUtils.isEmpty(forbiddenInfo.appTitle)) {
                return;
            }
            l2(this.D0.appTitle);
        }
    }

    public final boolean O2(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            char c2 = 65535;
            int hashCode = str.hashCode();
            if (hashCode != -1242268664) {
                if (hashCode != 38398066) {
                    if (hashCode == 731215244 && str.equals(SwanAppErrorActivity.TYPE_NORMAL)) {
                        c2 = 1;
                    }
                } else if (str.equals(SwanAppErrorActivity.TYPE_NETWORK_ERROR)) {
                    c2 = 0;
                }
            } else if (str.equals(SwanAppErrorActivity.TYPE_NEED_UPDATE_SDK)) {
                c2 = 2;
            }
            if (c2 != 0) {
                if (c2 != 1) {
                    if (c2 != 2) {
                        return false;
                    }
                    return V2("app_need_upgrade_btn_cmd");
                }
                return V2("app_open_failed_btn_cmd");
            }
            return V2("net_conn_failed_btn_cmd");
        }
        return invokeL.booleanValue;
    }

    public void Q2(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, activity) == null) {
            c.a.n0.a.c1.a.G().f(activity, J2(activity));
            C0203e.a("feedback", K2(), this.D0);
        }
    }

    public void R2(o oVar, Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, oVar, activity) == null) {
            c.a.n0.a.c1.a.G().e(activity, oVar);
            C0203e.a(ErrorContentResponse.Operations.NOTICE, K2(), this.D0);
        }
    }

    public void S2(o oVar, Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, oVar, activity) == null) {
            c.a.n0.a.c1.a.G().a(activity, oVar);
            C0203e.a(ErrorContentResponse.Operations.NOTICE, K2(), this.D0);
        }
    }

    public void T2(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, activity) == null) {
            c.a.n0.a.j1.a.j(activity);
            C0203e.a("daynightmode", K2(), this.D0);
        }
    }

    public void U2(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, activity) == null) {
            if (activity instanceof SwanAppErrorActivity) {
                c.a.n0.a.j1.a.t(activity);
            }
            C0203e.a("refresh", K2(), this.D0);
        }
    }

    @Override // c.a.n0.a.h0.g.d
    public boolean V1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean V2(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, str)) == null) {
            Map<String, String> c2 = c.a.n0.n.j.i.i.b().c();
            ForbiddenInfo forbiddenInfo = this.D0;
            if (forbiddenInfo != null) {
                String str2 = forbiddenInfo.forbiddenDetail;
                if (str2.length() > 4) {
                    String substring = str2.substring(str2.length() - 4);
                    if (!TextUtils.isEmpty(c2.get(substring + "_btn_cmd"))) {
                        String str3 = c2.get(substring + "_btn_cmd");
                        this.G0 = str3;
                        return !TextUtils.equals(str3, "0");
                    }
                }
            }
            String str4 = c2.get(str);
            this.G0 = str4;
            if (TextUtils.isEmpty(str4)) {
                this.G0 = "1";
            }
            return !TextUtils.equals(this.G0, "0");
        }
        return invokeL.booleanValue;
    }

    public final void W2() {
        n nVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (nVar = this.o0) == null) {
            return;
        }
        nVar.p(c.a.n0.a.c1.a.H().a());
    }

    @Override // c.a.n0.a.h0.g.d
    public boolean X1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void X2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            C0203e.a(SupportMenuInflater.XML_MENU, K2(), this.D0);
        }
    }

    public final String Y2() {
        InterceptResult invokeV;
        PMSAppInfo s;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            String string = q().getString(c.a.n0.a.h.swanapp_app_forbidden);
            ForbiddenInfo forbiddenInfo = this.D0;
            if (forbiddenInfo == null) {
                return string;
            }
            String str = forbiddenInfo.appId;
            return (TextUtils.isEmpty(str) || (s = c.a.n0.n.g.a.h().s(str)) == null || TextUtils.isEmpty(s.statusDesc)) ? string : s.statusDesc;
        }
        return (String) invokeV.objValue;
    }

    public final void Z2() {
        n nVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048597, this) == null) || (nVar = this.o0) == null) {
            return;
        }
        o f2 = nVar.f(46);
        o f3 = this.o0.f(47);
        if (f2 != null && this.E0 > 0) {
            f3.o(1);
            f3.n(this.E0);
        }
        if (f3 == null || this.F0 <= 0) {
            return;
        }
        f3.o(1);
        f3.n(this.F0);
    }

    @Override // c.a.n0.a.h0.g.d
    public void c2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            M2();
            W2();
            Z2();
            X2();
        }
    }

    @Override // c.a.n0.a.h0.g.d, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, motionEvent)) == null) ? H2() : invokeL.booleanValue;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, bundle) == null) {
            super.onCreate(bundle);
            Bundle o = o();
            if (o == null) {
                return;
            }
            this.C0 = o.getString(SwanAppErrorActivity.KEY_SWAN_ERROR_TYPE);
            this.D0 = (ForbiddenInfo) o.getParcelable("key_forbidden_info");
            this.E0 = o.getInt("key_show_menu_notice");
            this.F0 = o.getInt("key_show_menu_privacy");
        }
    }

    @Override // c.a.n0.a.h0.g.d, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            super.onResume();
            n nVar = this.o0;
            if (nVar != null && nVar.g()) {
                this.o0.x(c.a.n0.a.c1.a.H().a());
            }
            SwanAppActionBar swanAppActionBar = this.n0;
            if (swanAppActionBar != null) {
                c.a.n0.a.k1.a.o(swanAppActionBar, this.F0 + this.E0);
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View z0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048602, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(c.a.n0.a.g.aiapps_error_fragment, viewGroup, false);
            N2(inflate);
            O1(inflate);
            return N1() ? Q1(inflate) : inflate;
        }
        return (View) invokeLLL.objValue;
    }
}
