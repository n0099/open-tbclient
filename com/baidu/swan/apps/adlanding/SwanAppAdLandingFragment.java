package com.baidu.swan.apps.adlanding;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.z2.n0;
import c.a.p0.a.z2.q0;
import c.a.p0.a.z2.u;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.browser.sailor.ISailorDownloadListener;
import com.baidu.swan.apps.adlanding.customer.CustomerAdScrollView;
import com.baidu.swan.apps.adlanding.customer.WebViewContainer;
import com.baidu.swan.apps.res.widget.dialog.SwanAppAlertDialog;
import com.baidu.swan.apps.res.widget.toast.ToastLocation;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.game.ad.component.AdImageVIew;
import com.baidu.swan.game.ad.downloader.model.DownloadParams;
import com.baidu.swan.game.ad.downloader.model.DownloadState;
import com.baidu.swan.support.v4.app.FragmentActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class SwanAppAdLandingFragment extends c.a.p0.a.h0.g.l implements c.a.p0.h.i.m.b {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean Q1;
    public transient /* synthetic */ FieldHolder $fh;
    public FrameLayout A1;
    public int B1;
    public int C1;
    public int D1;
    public String E1;
    public c.a.p0.a.q.f.b F1;
    public String G1;
    public String H1;
    public TextView I1;
    public String J1;
    public SwanAppAlertDialog K1;
    public View L1;
    public String M1;
    public String N1;
    public c.a.p0.h.i.l.a O1;
    public View.OnClickListener P1;
    public String Q0;
    public LandingType R0;
    public c.a.p0.a.j1.g.a S0;
    public c.a.p0.h.i.r.c T0;
    public FrameLayout U0;
    public String V0;
    public String W0;
    public String X0;
    public c.a.p0.h.i.k.f.f Y0;
    public c.a.p0.h.i.k.f.a Z0;
    public DownloadParams a1;
    public DownloadState b1;
    public RelativeLayout c1;
    public int d1;
    public int e1;
    public int f1;
    public String g1;
    public String h1;
    public String i1;
    public String j1;
    public String k1;
    public String l1;
    public JSONObject m1;
    public int n1;
    public int o1;
    public boolean p1;
    public WebViewContainer q1;
    public LinearLayout r1;
    public ViewGroup s1;
    public Boolean t1;
    public int u1;
    public int v1;
    public String w1;
    public String x1;
    public float y1;
    public float z1;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes9.dex */
    public static final class ActionType {
        public static final /* synthetic */ ActionType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final ActionType DL;
        public static final ActionType LP;
        public transient /* synthetic */ FieldHolder $fh;
        public int type;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1192262243, "Lcom/baidu/swan/apps/adlanding/SwanAppAdLandingFragment$ActionType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1192262243, "Lcom/baidu/swan/apps/adlanding/SwanAppAdLandingFragment$ActionType;");
                    return;
                }
            }
            LP = new ActionType("LP", 0, 1);
            ActionType actionType = new ActionType("DL", 1, 2);
            DL = actionType;
            $VALUES = new ActionType[]{LP, actionType};
        }

        public ActionType(String str, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.type = i3;
        }

        public static ActionType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (ActionType) Enum.valueOf(ActionType.class, str) : (ActionType) invokeL.objValue;
        }

        public static ActionType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (ActionType[]) $VALUES.clone() : (ActionType[]) invokeV.objValue;
        }

        public int value() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.type : invokeV.intValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes9.dex */
    public static final class LandingType {
        public static final /* synthetic */ LandingType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final LandingType NORMAL;
        public static final LandingType VIDEO;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-706175822, "Lcom/baidu/swan/apps/adlanding/SwanAppAdLandingFragment$LandingType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-706175822, "Lcom/baidu/swan/apps/adlanding/SwanAppAdLandingFragment$LandingType;");
                    return;
                }
            }
            NORMAL = new LandingType("NORMAL", 0);
            LandingType landingType = new LandingType("VIDEO", 1);
            VIDEO = landingType;
            $VALUES = new LandingType[]{NORMAL, landingType};
        }

        public LandingType(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static LandingType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (LandingType) Enum.valueOf(LandingType.class, str) : (LandingType) invokeL.objValue;
        }

        public static LandingType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (LandingType[]) $VALUES.clone() : (LandingType[]) invokeV.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public class a extends c.a.p0.a.h0.j.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ SwanAppAdLandingFragment f39281c;

        /* renamed from: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment$a$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class RunnableC1793a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f39282e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f39283f;

            public RunnableC1793a(a aVar, String str) {
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
                this.f39283f = aVar;
                this.f39282e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f39283f.f39281c.k0.setTitle(TextUtils.isEmpty(this.f39282e) ? "" : this.f39282e);
                }
            }
        }

        public a(SwanAppAdLandingFragment swanAppAdLandingFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppAdLandingFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f39281c = swanAppAdLandingFragment;
        }

        @Override // c.a.p0.a.h0.j.a, c.a.p0.a.h0.j.d
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                SwanAppAdLandingFragment swanAppAdLandingFragment = this.f39281c;
                swanAppAdLandingFragment.a4(swanAppAdLandingFragment.K0.canGoBack());
                this.f39281c.k0.post(new RunnableC1793a(this, str));
            }
        }

        @Override // c.a.p0.a.h0.j.a, c.a.p0.a.h0.j.d
        public boolean c(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                if (c.a.p0.a.e2.a.b.e(str) || c.a.p0.a.e2.a.b.f(str)) {
                    try {
                        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                        c.a.p0.a.d2.e a0 = c.a.p0.a.d2.e.a0();
                        if (a0 != null) {
                            a0.x().startActivity(intent);
                            return true;
                        }
                    } catch (Exception e2) {
                        if (SwanAppAdLandingFragment.Q1) {
                            e2.printStackTrace();
                        }
                    }
                }
                return super.c(str);
            }
            return invokeL.booleanValue;
        }

        @Override // c.a.p0.a.h0.j.a, c.a.p0.a.h0.j.d
        public void e(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                super.e(str);
                if (TextUtils.isEmpty(this.f39281c.j1) || this.f39281c.T0 == null) {
                    return;
                }
                this.f39281c.T0.e(this.f39281c.j1);
            }
        }

        @Override // c.a.p0.a.h0.j.a, c.a.p0.a.h0.j.d
        public void goBack() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                SwanAppAdLandingFragment swanAppAdLandingFragment = this.f39281c;
                swanAppAdLandingFragment.a4(swanAppAdLandingFragment.K0.canGoBack());
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppAdLandingFragment f39284e;

        public b(SwanAppAdLandingFragment swanAppAdLandingFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppAdLandingFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f39284e = swanAppAdLandingFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.a.p0.a.h0.g.l.Z2();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppAdLandingFragment f39285e;

        public c(SwanAppAdLandingFragment swanAppAdLandingFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppAdLandingFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f39285e = swanAppAdLandingFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.p0.a.c2.b.f.e g2 = c.a.p0.a.c2.b.f.e.g(this.f39285e.getContext(), "第三方页面应用未经百度审核");
                g2.p(ToastLocation.BOTTOM);
                g2.G();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppAdLandingFragment f39286e;

        public d(SwanAppAdLandingFragment swanAppAdLandingFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppAdLandingFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f39286e = swanAppAdLandingFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.a.p0.a.h0.g.l.e3("adLanding", c.a.p0.a.m1.b.e(this.f39286e.N1, this.f39286e.N1));
                this.f39286e.K1.dismiss();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppAdLandingFragment f39287e;

        public e(SwanAppAdLandingFragment swanAppAdLandingFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppAdLandingFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f39287e = swanAppAdLandingFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.a.p0.a.h0.g.l.e3("adLanding", c.a.p0.a.m1.b.e(this.f39287e.M1, this.f39287e.M1));
                this.f39287e.K1.dismiss();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppAdLandingFragment f39288e;

        public f(SwanAppAdLandingFragment swanAppAdLandingFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppAdLandingFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f39288e = swanAppAdLandingFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f39288e.K1.dismiss();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class g implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppAdLandingFragment f39289e;

        public g(SwanAppAdLandingFragment swanAppAdLandingFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppAdLandingFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f39289e = swanAppAdLandingFragment;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
            }
        }
    }

    /* loaded from: classes9.dex */
    public class h implements c.a.p0.a.j1.g.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppAdLandingFragment a;

        public h(SwanAppAdLandingFragment swanAppAdLandingFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppAdLandingFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = swanAppAdLandingFragment;
        }

        @Override // c.a.p0.a.j1.g.b
        public void a(c.a.p0.a.c1.d.k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, kVar) == null) {
                this.a.y4("vcontinueplay");
            }
        }

        @Override // c.a.p0.a.j1.g.b
        public void b(c.a.p0.a.c1.d.k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, kVar) == null) {
                this.a.c1.bringToFront();
                this.a.c1.setVisibility(0);
                this.a.n1 = 0;
                SwanAppAdLandingFragment.v3(this.a);
                this.a.y4("vplayend");
                this.a.y4("scard");
            }
        }

        @Override // c.a.p0.a.j1.g.b
        public void c(c.a.p0.a.c1.d.k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, kVar) == null) {
                this.a.y4("vpause");
            }
        }

        @Override // c.a.p0.a.j1.g.b
        public void d(c.a.p0.a.c1.d.k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, kVar) == null) {
                if (this.a.o1 == 0) {
                    this.a.y4("vstart");
                    return;
                }
                this.a.c1.setVisibility(8);
                this.a.y4("vrepeatedplay");
            }
        }

        @Override // c.a.p0.a.j1.g.b
        public void e(c.a.p0.a.c1.d.k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, kVar) == null) {
            }
        }

        @Override // c.a.p0.a.j1.g.b
        public boolean f(c.a.p0.a.c1.d.k kVar, int i2, int i3) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(1048581, this, kVar, i2, i3)) == null) {
                return false;
            }
            return invokeLII.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppAdLandingFragment f39290e;

        public i(SwanAppAdLandingFragment swanAppAdLandingFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppAdLandingFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f39290e = swanAppAdLandingFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            }
        }
    }

    /* loaded from: classes9.dex */
    public class j implements c.a.p0.h.i.k.f.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppAdLandingFragment a;

        public j(SwanAppAdLandingFragment swanAppAdLandingFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppAdLandingFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = swanAppAdLandingFragment;
        }

        @Override // c.a.p0.h.i.k.f.a
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                this.a.Y0.d(i2);
            }
        }

        @Override // c.a.p0.h.i.k.f.a
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.y4("appinstallbegin");
            }
        }

        @Override // c.a.p0.h.i.k.f.a
        public void c(DownloadState downloadState, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, downloadState, i2) == null) {
                this.a.Y0.b(downloadState);
                if (this.a.b1 == downloadState) {
                    return;
                }
                if (this.a.b1 == DownloadState.NOT_START && downloadState == DownloadState.DOWNLOADING) {
                    this.a.y4("appdownloadbegin");
                } else if (downloadState == DownloadState.DOWNLOAD_PAUSED) {
                    this.a.y4("appdownloadpause");
                } else if (this.a.b1 == DownloadState.DOWNLOAD_PAUSED && downloadState == DownloadState.DOWNLOADING) {
                    this.a.y4("appdownloadcontinue");
                } else if (downloadState == DownloadState.DOWNLOADED) {
                    this.a.y4("appdownloadfinish");
                    this.a.y4("appinstallbegin");
                } else if (downloadState == DownloadState.INSTALLED) {
                    this.a.y4("appinstallfinish");
                }
                this.a.b1 = downloadState;
            }
        }

        @Override // c.a.p0.h.i.k.f.a
        public void d(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                this.a.v4(str);
            }
        }

        @Override // c.a.p0.h.i.k.f.a
        public String e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                this.a.y4("appinstallopen");
                SwanAppAdLandingFragment swanAppAdLandingFragment = this.a;
                return swanAppAdLandingFragment.b4(swanAppAdLandingFragment.a1.a);
            }
            return (String) invokeV.objValue;
        }

        @Override // c.a.p0.h.i.k.f.a
        public void f(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048581, this, z) == null) && this.a.J1.equals("1")) {
                if (z) {
                    this.a.z4();
                } else {
                    this.a.w4();
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f39291e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SwanAppAdLandingFragment f39292f;

        public k(SwanAppAdLandingFragment swanAppAdLandingFragment, View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppAdLandingFragment, view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f39292f = swanAppAdLandingFragment;
            this.f39291e = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int height = this.f39292f.U0.getHeight();
                if (this.f39292f.r4() || this.f39292f.p4()) {
                    ViewGroup.LayoutParams layoutParams = this.f39291e.getLayoutParams();
                    layoutParams.height = height;
                    this.f39291e.setLayoutParams(layoutParams);
                }
                if (this.f39292f.r4()) {
                    ViewGroup.LayoutParams layoutParams2 = this.f39292f.q1.getLayoutParams();
                    layoutParams2.height = height + (this.f39292f.t1.booleanValue() ? this.f39292f.C1 : this.f39292f.d1);
                    this.f39292f.q1.setLayoutParams(layoutParams2);
                }
                this.f39292f.s1.removeView(this.f39292f.U0);
                if (this.f39292f.r1 != null) {
                    this.f39292f.r1.setVisibility(0);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class l implements c.a.p0.a.h0.j.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CustomerAdScrollView a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SwanAppAdLandingFragment f39293b;

        public l(SwanAppAdLandingFragment swanAppAdLandingFragment, CustomerAdScrollView customerAdScrollView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppAdLandingFragment, customerAdScrollView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f39293b = swanAppAdLandingFragment;
            this.a = customerAdScrollView;
        }

        @Override // c.a.p0.a.h0.j.c
        public void onScrollChanged(int i2, int i3, int i4, int i5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIII(1048576, this, i2, i3, i4, i5) == null) {
                this.a.setIsWebViewOnBottom(((((float) this.f39293b.K0.getContentHeight()) * this.f39293b.K0.getScale()) - ((float) this.f39293b.K0.covertToView().getHeight())) - ((float) this.f39293b.K0.getWebViewScrollY()) < 10.0f);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class m extends c.a.p0.a.h0.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CustomerAdScrollView a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SwanAppAdLandingFragment f39294b;

        public m(SwanAppAdLandingFragment swanAppAdLandingFragment, CustomerAdScrollView customerAdScrollView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppAdLandingFragment, customerAdScrollView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f39294b = swanAppAdLandingFragment;
            this.a = customerAdScrollView;
        }

        @Override // c.a.p0.a.h0.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                super.a(str);
                if (Math.abs((this.f39294b.K0.getContentHeight() * this.f39294b.K0.getScale()) - this.f39294b.K0.covertToView().getHeight()) < 10.0f) {
                    this.a.setIsWebViewOnBottom(true);
                } else {
                    this.a.setIsWebViewOnBottom(false);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class n implements c.a.p0.a.q.f.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CustomerAdScrollView a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SwanAppAdLandingFragment f39295b;

        public n(SwanAppAdLandingFragment swanAppAdLandingFragment, CustomerAdScrollView customerAdScrollView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppAdLandingFragment, customerAdScrollView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f39295b = swanAppAdLandingFragment;
            this.a = customerAdScrollView;
        }

        @Override // c.a.p0.a.q.f.a
        public void onScrollChanged(int i2, int i3, int i4, int i5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIII(1048576, this, i2, i3, i4, i5) == null) {
                CustomerAdScrollView customerAdScrollView = this.a;
                SwanAppAdLandingFragment swanAppAdLandingFragment = this.f39295b;
                customerAdScrollView.setIsFooterLayoutShow(swanAppAdLandingFragment.s4(swanAppAdLandingFragment.r1));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class o implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppAdLandingFragment f39296e;

        public o(SwanAppAdLandingFragment swanAppAdLandingFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppAdLandingFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f39296e = swanAppAdLandingFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                int id = view.getId();
                HashMap<String, String> hashMap = new HashMap<>();
                if (id == c.a.p0.a.f.ad_tail_head_image) {
                    hashMap.put("da_area", "tail_icon");
                } else if (id == c.a.p0.a.f.ad_tail_brand_name) {
                    hashMap.put("da_area", "tail_name");
                } else if (id == c.a.p0.a.f.ad_tail_btn) {
                    hashMap.put("da_area", this.f39296e.f1 == ActionType.DL.value() ? "tail_downloadbtn" : "tail_detailbtn");
                }
                if (this.f39296e.T0 != null) {
                    this.f39296e.T0.d("c", hashMap);
                }
                c.a.p0.a.h0.g.l.e3("adLanding", c.a.p0.a.m1.b.e(this.f39296e.Q0, this.f39296e.Q0));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(275537983, "Lcom/baidu/swan/apps/adlanding/SwanAppAdLandingFragment;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(275537983, "Lcom/baidu/swan/apps/adlanding/SwanAppAdLandingFragment;");
                return;
            }
        }
        Q1 = c.a.p0.a.k.a;
    }

    public SwanAppAdLandingFragment() {
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
        this.R0 = LandingType.NORMAL;
        this.V0 = "";
        this.W0 = "";
        this.X0 = "";
        this.b1 = DownloadState.NOT_START;
        this.m1 = new JSONObject();
        this.n1 = 0;
        this.o1 = 0;
        this.p1 = true;
        this.t1 = Boolean.FALSE;
        this.K1 = null;
        this.O1 = null;
        this.P1 = new o(this);
    }

    public static /* synthetic */ int v3(SwanAppAdLandingFragment swanAppAdLandingFragment) {
        int i2 = swanAppAdLandingFragment.o1;
        swanAppAdLandingFragment.o1 = i2 + 1;
        return i2;
    }

    @Override // c.a.p0.a.h0.g.l, com.baidu.swan.support.v4.app.Fragment
    public View D0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(c.a.p0.a.g.aiapps_webview_fragment, viewGroup, false);
            V1(inflate);
            this.s1 = (ViewGroup) inflate.findViewById(c.a.p0.a.f.swan_app_webview_fragment);
            this.U0 = (FrameLayout) inflate.findViewById(c.a.p0.a.f.aiapps_webView_container);
            m4();
            o4();
            g4(this.q1);
            n4();
            if (r4()) {
                l4();
                k4();
            }
            if (U1()) {
                inflate = X1(inflate);
            }
            y4("lpin");
            return E1(inflate, this);
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void H0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            super.H0(z);
            if (z) {
                u4();
            } else {
                x4();
            }
        }
    }

    @Override // c.a.p0.a.h0.g.l, c.a.p0.a.h0.g.d
    public boolean K() {
        InterceptResult invokeV;
        c.a.p0.a.j1.g.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (q4() && (aVar = this.S0) != null) {
                return aVar.onBackPressed();
            }
            y4("lpout");
            return super.K();
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.p0.a.h0.g.l, c.a.p0.a.h0.g.d
    public void V1(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            super.V1(view);
            this.k0.setLeftHomeViewSrc(c.a.p0.a.e.aiapps_action_bar_close_black_selector);
            this.k0.setLeftHomeViewClickListener(new b(this));
        }
    }

    @Override // c.a.p0.a.h0.g.l
    public c.a.p0.a.h0.j.d a3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? new a(this) : (c.a.p0.a.h0.j.d) invokeV.objValue;
    }

    public final void a4(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.k0.setLeftHomeViewVisibility(z ? 0 : 8);
        }
    }

    public final String b4(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) ? c.a.p0.a.o2.g.h.a().getString(str, "") : (String) invokeL.objValue;
    }

    public final void c4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            c.a.p0.h.i.l.a aVar = this.O1;
            if (aVar != null) {
                o(aVar);
                return;
            }
            c.a.p0.h.i.p.b bVar = new c.a.p0.h.i.p.b(getContext());
            bVar.d(this);
            c.a.p0.h.i.p.c cVar = new c.a.p0.h.i.p.c(getContext());
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("charge_url", this.H1);
                jSONObject.put("apk_url", this.G1);
                jSONObject.put("ssl", 1);
            } catch (JSONException e2) {
                if (Q1) {
                    e2.printStackTrace();
                }
            }
            bVar.c(cVar, jSONObject);
        }
    }

    @Override // c.a.p0.a.h0.g.l, c.a.p0.a.h0.g.d
    public boolean d2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void d4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.Y0.f();
            if (TextUtils.isEmpty(this.a1.f40391b)) {
                String b4 = b4(this.G1);
                this.a1.f40391b = b4;
                this.Y0.a(b4);
            }
            if (q0.F(getContext(), this.a1.f40391b)) {
                z4();
                this.Y0.b(DownloadState.INSTALLED);
                return;
            }
            if (TextUtils.isEmpty(this.a1.a)) {
                this.a1.a = this.G1;
            }
            c.a.p0.a.c1.a.d().d(getContext(), this.a1.a(), DownloadParams.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.Z0);
        }
    }

    public final void e4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            q0.e0(new c(this));
        }
    }

    public final void f4(c.a.p0.h.i.l.a aVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048587, this, aVar, z) == null) {
            SwanAppAlertDialog swanAppAlertDialog = this.K1;
            if (swanAppAlertDialog != null) {
                swanAppAlertDialog.show();
                return;
            }
            ((ViewGroup) this.L1.findViewById(c.a.p0.a.f.ad_landing_download_btn)).addView(this.Y0.getRealView());
            ((AdImageVIew) this.L1.findViewById(c.a.p0.a.f.ad_landing_download_icon)).setImageUrl(aVar.g());
            ((TextView) this.L1.findViewById(c.a.p0.a.f.ad_landing_download_appname)).setText(aVar.c());
            ((TextView) this.L1.findViewById(c.a.p0.a.f.ad_landing_download_publisher)).setText(aVar.d());
            ((TextView) this.L1.findViewById(c.a.p0.a.f.ad_landing_download_apksize)).setText(aVar.a());
            ((TextView) this.L1.findViewById(c.a.p0.a.f.ad_landing_download_version)).setText(aVar.j());
            TextView textView = (TextView) this.L1.findViewById(c.a.p0.a.f.ad_landing_download_hint);
            if (!z) {
                textView.setText(aVar.e());
                textView.setVisibility(0);
            }
            this.M1 = aVar.h();
            this.N1 = aVar.i();
            ViewGroup.LayoutParams layoutParams = this.Y0.getRealView().getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(-1, -2);
                this.Y0.getRealView().setLayoutParams(layoutParams);
            }
            int o2 = n0.o(getContext());
            float l2 = n0.l(getContext());
            layoutParams.width = o2 - (((int) ((10.0f * l2) + 0.5f)) * 2);
            if (TextUtils.isEmpty(this.a1.f40391b)) {
                String b4 = b4(aVar.b());
                this.a1.f40391b = b4;
                this.Y0.a(b4);
            }
            if (q0.F(getContext(), this.a1.f40391b)) {
                this.Y0.b(DownloadState.INSTALLED);
            }
            if (TextUtils.isEmpty(this.a1.a)) {
                this.a1.a = aVar.b();
            }
            this.Y0.e(this.a1);
            c.a.p0.a.c2.b.b.b bVar = new c.a.p0.a.c2.b.b.b(getContext());
            bVar.i(true);
            bVar.k(false);
            bVar.T(false);
            bVar.m(false);
            bVar.t(false);
            bVar.n(new c.a.p0.a.a3.h.a());
            bVar.p(c.a.p0.a.e.aiapps_action_sheet_bg);
            bVar.F(c.a.p0.a.c.swan_app_action_sheet_cancel_text);
            bVar.K(new g(this));
            bVar.W(this.L1);
            bVar.j();
            bVar.q((int) (l2 * (z ? 225.0f : 250.0f)));
            SwanAppAlertDialog c2 = bVar.c();
            this.K1 = c2;
            Window window = c2.getWindow();
            if (window != null) {
                window.setGravity(80);
                window.setDimAmount(0.65f);
                window.setLayout(n0.s(getContext()), -2);
                window.setWindowAnimations(c.a.p0.a.i.action_sheet_animation);
            }
            this.K1.setEnableImmersion(false);
            this.K1.setCanceledOnTouchOutside(true);
            this.K1.show();
        }
    }

    public final void g4(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, viewGroup) == null) {
            this.Z0 = new j(this);
            this.a1 = new DownloadParams(this.W0, this.X0);
            c.a.p0.h.i.k.g.b bVar = new c.a.p0.h.i.k.g.b();
            bVar.l(getContext(), this.a1, this.Z0);
            this.Y0 = bVar;
            bVar.e(this.a1);
            h4();
        }
    }

    public final void h4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            View inflate = View.inflate(getContext(), c.a.p0.a.g.aiapps_ad_landing_download, null);
            this.L1 = inflate;
            ((TextView) inflate.findViewById(c.a.p0.a.f.ad_landing_download_privacy)).setOnClickListener(new d(this));
            ((TextView) this.L1.findViewById(c.a.p0.a.f.ad_landing_download_permission)).setOnClickListener(new e(this));
            ((ImageView) this.L1.findViewById(c.a.p0.a.f.close_ad_download_btn)).setOnClickListener(new f(this));
            TextView textView = new TextView(getContext());
            this.I1 = textView;
            textView.setText("温馨提示：您已访问至第三方页面");
            this.I1.setTextColor(-16777216);
            GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{0, -1});
            gradientDrawable.setShape(0);
            this.I1.setBackground(gradientDrawable);
            this.I1.getBackground().setAlpha(180);
            this.I1.setPadding(0, 0, 0, 10);
            this.I1.setGravity(80);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, 260);
            layoutParams.gravity = 81;
            layoutParams.bottomMargin = ((int) (getContext().getResources().getDisplayMetrics().heightPixels * 0.14d)) - 80;
            this.I1.setLayoutParams(layoutParams);
            this.I1.setGravity(81);
        }
    }

    public final void i4(ViewGroup viewGroup, ViewGroup viewGroup2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, viewGroup, viewGroup2) == null) {
            this.r1 = (LinearLayout) ((LinearLayout) LayoutInflater.from(getContext()).inflate(c.a.p0.a.g.swanapp_ad_footer_view, (ViewGroup) null)).findViewById(c.a.p0.a.f.ad_footer);
            CustomerAdScrollView customerAdScrollView = new CustomerAdScrollView(getContext());
            LinearLayout linearLayout = new LinearLayout(getContext());
            linearLayout.setOrientation(1);
            linearLayout.addView(viewGroup2, new LinearLayout.LayoutParams(-1, -2));
            linearLayout.addView(this.r1, new LinearLayout.LayoutParams(-1, getContext().getResources().getDimensionPixelSize(c.a.p0.a.d.swanapp_ad_dimens_footer_height)));
            customerAdScrollView.addView(linearLayout, new LinearLayout.LayoutParams(-1, -2));
            viewGroup.addView(customerAdScrollView);
            this.J0.u(new l(this, customerAdScrollView));
            this.J0.d(new m(this, customerAdScrollView));
            customerAdScrollView.setScrollViewListener(new n(this, customerAdScrollView));
        }
    }

    public final void j4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(getContext()).inflate(c.a.p0.a.g.swanapp_ad_landing_portrait_video, (ViewGroup) null);
            this.q1.addView(relativeLayout, new FrameLayout.LayoutParams(-1, this.C1));
            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) relativeLayout.findViewById(c.a.p0.a.f.ad_landing_bg_image);
            SimpleDraweeView simpleDraweeView2 = (SimpleDraweeView) relativeLayout.findViewById(c.a.p0.a.f.ad_landing_mask);
            this.A1 = (FrameLayout) relativeLayout.findViewById(c.a.p0.a.f.ad_landing_video);
            if (!TextUtils.isEmpty(this.w1)) {
                simpleDraweeView.setImageURI(Uri.parse(this.w1));
                simpleDraweeView.setOnClickListener(this.P1);
            } else {
                simpleDraweeView.setVisibility(4);
            }
            if (!TextUtils.isEmpty(this.x1)) {
                simpleDraweeView2.setImageURI(Uri.parse(this.x1));
            } else {
                simpleDraweeView2.setVisibility(4);
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.A1.getLayoutParams();
            layoutParams.width = this.e1;
            layoutParams.height = this.d1;
            layoutParams.rightMargin = this.D1;
            this.A1.setLayoutParams(layoutParams);
        }
    }

    public final void k4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(getContext()).inflate(c.a.p0.a.g.swanapp_ad_video_tail_view, (ViewGroup) null);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.height = this.t1.booleanValue() ? this.C1 : this.d1;
            this.c1 = (RelativeLayout) relativeLayout.findViewById(c.a.p0.a.f.ad_tail_root);
            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) relativeLayout.findViewById(c.a.p0.a.f.ad_tail_video_img);
            SimpleDraweeView simpleDraweeView2 = (SimpleDraweeView) relativeLayout.findViewById(c.a.p0.a.f.ad_tail_head_image);
            TextView textView = (TextView) relativeLayout.findViewById(c.a.p0.a.f.ad_tail_brand_name);
            TextView textView2 = (TextView) relativeLayout.findViewById(c.a.p0.a.f.ad_tail_btn);
            if (!TextUtils.isEmpty(this.g1)) {
                textView2.setText(this.g1);
                textView2.setVisibility(0);
            } else {
                textView2.setVisibility(8);
            }
            if (!TextUtils.isEmpty(this.h1)) {
                textView.setText(this.h1);
                textView.setVisibility(0);
            } else {
                textView.setVisibility(4);
            }
            if (!TextUtils.isEmpty(this.i1)) {
                simpleDraweeView2.setImageURI(Uri.parse(this.i1));
                simpleDraweeView2.setVisibility(0);
            } else {
                simpleDraweeView2.setVisibility(8);
            }
            simpleDraweeView.getHierarchy().setPlaceholderImage(getResources().getDrawable(c.a.p0.a.e.swanapp_ad_tab_video_img_default_icon));
            String str = this.t1.booleanValue() ? this.E1 : this.k1;
            if (!TextUtils.isEmpty(str)) {
                simpleDraweeView.setImageURI(u.m(str));
            }
            simpleDraweeView.setVisibility(0);
            simpleDraweeView.setOnClickListener(new i(this));
            simpleDraweeView2.setOnClickListener(this.P1);
            textView.setOnClickListener(this.P1);
            textView2.setOnClickListener(this.P1);
            this.q1.addView(this.c1, layoutParams);
            this.c1.setVisibility(4);
        }
    }

    @Override // c.a.p0.a.h0.g.l
    public c.a.p0.a.p.e.e l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            c.a.p0.a.q.e eVar = new c.a.p0.a.q.e(getContext());
            eVar.t().setDownloadListener(new ISailorDownloadListener(this) { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ SwanAppAdLandingFragment this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // com.baidu.browser.sailor.ISailorDownloadListener
                public void onDownloadFlash(String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, str) == null) {
                    }
                }

                @Override // com.baidu.browser.sailor.ISailorDownloadListener
                public void onDownloadStart(String str, String str2, String str3, String str4, long j2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, str2, str3, str4, Long.valueOf(j2)}) == null) {
                        if (SwanAppAdLandingFragment.Q1) {
                            String str5 = "onDownloadStart: url=" + str + ", userAgent=" + str2 + ", mimeType=" + str4;
                        }
                        this.this$0.G1 = str;
                        this.this$0.c4();
                    }
                }

                @Override // com.baidu.browser.sailor.ISailorDownloadListener
                public void onPlayVideo(String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                    }
                }
            });
            return eVar;
        }
        return (c.a.p0.a.p.e.e) invokeV.objValue;
    }

    public final void l4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            if (this.t1.booleanValue()) {
                j4();
            }
            c.a.p0.a.q.d dVar = new c.a.p0.a.q.d(this.k1, this.l1, this.J0.c(), this.t1.booleanValue() ? 0 : this.e1, this.t1.booleanValue() ? 0 : this.d1, this.n1, this.t1.booleanValue());
            c.a.p0.a.j1.g.a aVar = new c.a.p0.a.j1.g.a(getContext(), dVar.a());
            this.S0 = aVar;
            this.F1.p(aVar);
            this.S0.v(new h(this));
            if (this.t1.booleanValue()) {
                this.S0.x(this.A1);
            }
            this.S0.o(dVar.a());
            this.S0.w(false);
        }
    }

    public final void m4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            DisplayMetrics displayMetrics = getActivity().getResources().getDisplayMetrics();
            int i2 = displayMetrics != null ? displayMetrics.widthPixels : 0;
            if (this.t1.booleanValue()) {
                float f2 = this.v1 / this.u1;
                this.B1 = i2;
                int i3 = (int) (i2 * f2);
                this.C1 = i3;
                this.e1 = (int) (i2 * this.y1);
                this.d1 = i3;
                this.D1 = (int) (i2 * this.z1);
                return;
            }
            this.d1 = (i2 * 9) / 16;
            this.e1 = i2;
        }
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [c.a.p0.a.p.e.c] */
    public final void n4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            c.a.p0.a.p.e.e l2 = l();
            this.J0 = l2;
            l2.a0(a3());
            this.K0 = this.J0.t();
            this.J0.loadUrl(this.Q0);
            FrameLayout frameLayout = new FrameLayout(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            View covertToView = this.K0.covertToView();
            c.a.p0.a.d2.n.g gVar = new c.a.p0.a.d2.n.g();
            gVar.f4658e = SwanAppConfigData.t("#FFFFFF");
            this.J0.A(frameLayout, gVar);
            this.J0.Q(frameLayout, gVar);
            this.J0.k(frameLayout, covertToView);
            if (p4()) {
                i4(this.q1, frameLayout);
            } else {
                this.q1.addView(frameLayout);
            }
            WebViewContainer webViewContainer = this.q1;
            if (webViewContainer != null) {
                webViewContainer.setInternalWebView(this.K0);
            }
            if (r4()) {
                layoutParams.topMargin = this.t1.booleanValue() ? this.C1 : this.d1;
            }
            covertToView.setLayoutParams(layoutParams);
            this.U0.post(new k(this, covertToView));
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // c.a.p0.h.i.m.b
    public void o(c.a.p0.h.i.l.a aVar) {
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, aVar) == null) {
            this.O1 = aVar;
            String f2 = aVar.f();
            this.J1 = f2;
            switch (f2.hashCode()) {
                case 49:
                    if (f2.equals("1")) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 50:
                    if (f2.equals("2")) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 51:
                    if (f2.equals("3")) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 52:
                    if (f2.equals("4")) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            if (c2 == 0) {
                d4();
            } else if (c2 == 1) {
                f4(aVar, true);
            } else if (c2 == 2) {
                f4(aVar, false);
            } else if (c2 != 3) {
            } else {
                e4();
            }
        }
    }

    public final void o4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            c.a.p0.a.q.f.b bVar = new c.a.p0.a.q.f.b(getContext());
            this.F1 = bVar;
            bVar.o(r4() ? this.d1 : 0);
            WebViewContainer k2 = this.F1.k();
            this.q1 = k2;
            this.s1.addView(k2);
        }
    }

    @Override // c.a.p0.a.h0.g.l, com.baidu.swan.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, bundle) == null) {
            super.onCreate(bundle);
            t4();
            this.T0 = new c.a.p0.h.i.r.c(getContext(), this.m1);
            FragmentActivity activity = getActivity();
            if (activity != null) {
                boolean z = 1 == activity.getRequestedOrientation();
                this.p1 = z;
                if (!z) {
                    I2(1);
                }
            }
            if (Q1) {
                String str = "onCreate() : " + this;
            }
        }
    }

    @Override // c.a.p0.a.h0.g.l, com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            if (r4()) {
                y4("vplayend");
            }
            c.a.p0.a.j1.g.a aVar = this.S0;
            if (aVar != null) {
                aVar.onDestroy();
            }
            if (!this.p1) {
                I2(0);
            }
            super.onDestroy();
        }
    }

    @Override // c.a.p0.a.h0.g.d, com.baidu.swan.support.v4.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            super.onPause();
            u4();
        }
    }

    @Override // c.a.p0.a.h0.g.d, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            super.onResume();
            c.a.p0.a.q.f.b bVar = this.F1;
            if (bVar == null || !bVar.l() || t0()) {
                return;
            }
            x4();
        }
    }

    public final boolean p4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? TextUtils.equals("swan-custom-ad", this.V0) : invokeV.booleanValue;
    }

    public final boolean q4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? getActivity().getResources().getConfiguration().orientation == 2 : invokeV.booleanValue;
    }

    public final boolean r4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.R0 == LandingType.VIDEO : invokeV.booleanValue;
    }

    public final boolean s4(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, view)) == null) {
            if (view == null || view.getVisibility() != 0) {
                return false;
            }
            return view.getGlobalVisibleRect(new Rect());
        }
        return invokeL.booleanValue;
    }

    public final void t4() {
        Bundle t;
        String X;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048607, this) == null) || (t = t()) == null) {
            return;
        }
        this.Q0 = t.getString("url", "");
        if (TextUtils.isEmpty(this.M0)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(this.M0);
            this.l1 = jSONObject.optString("vurl", "");
            this.k1 = jSONObject.optString("w_picurl", "");
            this.i1 = jSONObject.optString("icon", "");
            int optInt = jSONObject.optInt("act", ActionType.LP.value());
            this.f1 = optInt;
            if (optInt == ActionType.DL.value()) {
                X = X(c.a.p0.a.h.swanapp_ad_download_button);
            } else {
                X = X(c.a.p0.a.h.swanapp_ad_landingpage_button);
            }
            this.g1 = X;
            this.h1 = jSONObject.optString("appname", "");
            this.n1 = jSONObject.optInt("currentTime", 0);
            this.m1 = jSONObject.optJSONObject("monitors");
            this.W0 = jSONObject.optString("url", "");
            this.X0 = jSONObject.optString("name", "");
            this.V0 = jSONObject.optString("from", "");
            this.j1 = jSONObject.optString("monitorUrl", "");
            this.u1 = jSONObject.optInt("w", 16);
            this.v1 = jSONObject.optInt("h", 9);
            this.w1 = jSONObject.optString("playingbg", "");
            this.x1 = jSONObject.optString("maskUrl", "");
            this.y1 = (float) jSONObject.optDouble("playerWidthRatio", 0.5d);
            this.z1 = (float) jSONObject.optDouble("rightMarginRatio", 0.0d);
            this.E1 = jSONObject.optString("horizontalCover", "");
            this.H1 = jSONObject.optString("costUrl", "");
        } catch (JSONException e2) {
            if (Q1) {
                e2.printStackTrace();
            }
        }
        if (!TextUtils.isEmpty(this.l1)) {
            this.R0 = LandingType.VIDEO;
        }
        this.t1 = Boolean.valueOf(TextUtils.equals("ad-video-portrait", this.V0));
    }

    public final void u4() {
        c.a.p0.a.j1.g.a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048608, this) == null) && (aVar = this.S0) != null && aVar.n()) {
            this.S0.p();
        }
    }

    public final void v4(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048609, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        c.a.p0.a.o2.g.h.a().putString(this.a1.a, str);
    }

    public final void w4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            this.q1.removeView(this.Y0.getRealView());
            this.q1.removeView(this.I1);
        }
    }

    public final void x4() {
        c.a.p0.a.j1.g.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048611, this) == null) || (aVar = this.S0) == null || aVar.n() || this.S0.m()) {
            return;
        }
        this.S0.s();
    }

    public final void y4(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, str) == null) {
            HashMap<String, String> hashMap = new HashMap<>();
            c.a.p0.a.j1.g.a aVar = this.S0;
            if (aVar != null) {
                hashMap.put("cur_time", String.valueOf(aVar.e() / 1000));
            }
            c.a.p0.h.i.r.c cVar = this.T0;
            if (cVar != null) {
                cVar.d(str, hashMap);
            }
        }
    }

    public final void z4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            w4();
            this.q1.addView(this.I1);
            this.q1.addView(this.Y0.getRealView());
        }
    }
}
