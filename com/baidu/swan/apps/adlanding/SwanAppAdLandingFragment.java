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
import c.a.r0.a.z2.n0;
import c.a.r0.a.z2.q0;
import c.a.r0.a.z2.u;
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
/* loaded from: classes11.dex */
public class SwanAppAdLandingFragment extends c.a.r0.a.h0.g.l implements c.a.r0.h.i.m.b {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean Q1;
    public transient /* synthetic */ FieldHolder $fh;
    public FrameLayout A1;
    public int B1;
    public int C1;
    public int D1;
    public String E1;
    public c.a.r0.a.q.f.b F1;
    public String G1;
    public String H1;
    public TextView I1;
    public String J1;
    public SwanAppAlertDialog K1;
    public View L1;
    public String M1;
    public String N1;
    public c.a.r0.h.i.l.a O1;
    public View.OnClickListener P1;
    public String Q0;
    public LandingType R0;
    public c.a.r0.a.j1.g.a S0;
    public c.a.r0.h.i.r.c T0;
    public FrameLayout U0;
    public String V0;
    public String W0;
    public String X0;
    public c.a.r0.h.i.k.f.f Y0;
    public c.a.r0.h.i.k.f.a Z0;
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
    /* loaded from: classes11.dex */
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
    /* loaded from: classes11.dex */
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

    /* loaded from: classes11.dex */
    public class a extends c.a.r0.a.h0.j.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ SwanAppAdLandingFragment f38604c;

        /* renamed from: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment$a$a  reason: collision with other inner class name */
        /* loaded from: classes11.dex */
        public class RunnableC1875a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f38605e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f38606f;

            public RunnableC1875a(a aVar, String str) {
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
                this.f38606f = aVar;
                this.f38605e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f38606f.f38604c.k0.setTitle(TextUtils.isEmpty(this.f38605e) ? "" : this.f38605e);
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
            this.f38604c = swanAppAdLandingFragment;
        }

        @Override // c.a.r0.a.h0.j.a, c.a.r0.a.h0.j.d
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                SwanAppAdLandingFragment swanAppAdLandingFragment = this.f38604c;
                swanAppAdLandingFragment.T3(swanAppAdLandingFragment.K0.canGoBack());
                this.f38604c.k0.post(new RunnableC1875a(this, str));
            }
        }

        @Override // c.a.r0.a.h0.j.a, c.a.r0.a.h0.j.d
        public boolean c(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                if (c.a.r0.a.e2.a.b.e(str) || c.a.r0.a.e2.a.b.f(str)) {
                    try {
                        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                        c.a.r0.a.d2.e a0 = c.a.r0.a.d2.e.a0();
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

        @Override // c.a.r0.a.h0.j.a, c.a.r0.a.h0.j.d
        public void e(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                super.e(str);
                if (TextUtils.isEmpty(this.f38604c.j1) || this.f38604c.T0 == null) {
                    return;
                }
                this.f38604c.T0.e(this.f38604c.j1);
            }
        }

        @Override // c.a.r0.a.h0.j.a, c.a.r0.a.h0.j.d
        public void goBack() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                SwanAppAdLandingFragment swanAppAdLandingFragment = this.f38604c;
                swanAppAdLandingFragment.T3(swanAppAdLandingFragment.K0.canGoBack());
            }
        }
    }

    /* loaded from: classes11.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppAdLandingFragment f38607e;

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
            this.f38607e = swanAppAdLandingFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.a.r0.a.h0.g.l.S2();
            }
        }
    }

    /* loaded from: classes11.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppAdLandingFragment f38608e;

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
            this.f38608e = swanAppAdLandingFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.r0.a.c2.b.f.e g2 = c.a.r0.a.c2.b.f.e.g(this.f38608e.getContext(), "第三方页面应用未经百度审核");
                g2.p(ToastLocation.BOTTOM);
                g2.G();
            }
        }
    }

    /* loaded from: classes11.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppAdLandingFragment f38609e;

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
            this.f38609e = swanAppAdLandingFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.a.r0.a.h0.g.l.X2("adLanding", c.a.r0.a.m1.b.e(this.f38609e.N1, this.f38609e.N1));
                this.f38609e.K1.dismiss();
            }
        }
    }

    /* loaded from: classes11.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppAdLandingFragment f38610e;

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
            this.f38610e = swanAppAdLandingFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.a.r0.a.h0.g.l.X2("adLanding", c.a.r0.a.m1.b.e(this.f38610e.M1, this.f38610e.M1));
                this.f38610e.K1.dismiss();
            }
        }
    }

    /* loaded from: classes11.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppAdLandingFragment f38611e;

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
            this.f38611e = swanAppAdLandingFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f38611e.K1.dismiss();
            }
        }
    }

    /* loaded from: classes11.dex */
    public class g implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppAdLandingFragment f38612e;

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
            this.f38612e = swanAppAdLandingFragment;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
            }
        }
    }

    /* loaded from: classes11.dex */
    public class h implements c.a.r0.a.j1.g.b {
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

        @Override // c.a.r0.a.j1.g.b
        public void a(c.a.r0.a.c1.d.k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, kVar) == null) {
                this.a.r4("vcontinueplay");
            }
        }

        @Override // c.a.r0.a.j1.g.b
        public void b(c.a.r0.a.c1.d.k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, kVar) == null) {
                this.a.c1.bringToFront();
                this.a.c1.setVisibility(0);
                this.a.n1 = 0;
                SwanAppAdLandingFragment.o3(this.a);
                this.a.r4("vplayend");
                this.a.r4("scard");
            }
        }

        @Override // c.a.r0.a.j1.g.b
        public void c(c.a.r0.a.c1.d.k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, kVar) == null) {
                this.a.r4("vpause");
            }
        }

        @Override // c.a.r0.a.j1.g.b
        public void d(c.a.r0.a.c1.d.k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, kVar) == null) {
                if (this.a.o1 == 0) {
                    this.a.r4("vstart");
                    return;
                }
                this.a.c1.setVisibility(8);
                this.a.r4("vrepeatedplay");
            }
        }

        @Override // c.a.r0.a.j1.g.b
        public void e(c.a.r0.a.c1.d.k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, kVar) == null) {
            }
        }

        @Override // c.a.r0.a.j1.g.b
        public boolean f(c.a.r0.a.c1.d.k kVar, int i2, int i3) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(1048581, this, kVar, i2, i3)) == null) {
                return false;
            }
            return invokeLII.booleanValue;
        }
    }

    /* loaded from: classes11.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppAdLandingFragment f38613e;

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
            this.f38613e = swanAppAdLandingFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            }
        }
    }

    /* loaded from: classes11.dex */
    public class j implements c.a.r0.h.i.k.f.a {
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

        @Override // c.a.r0.h.i.k.f.a
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                this.a.Y0.d(i2);
            }
        }

        @Override // c.a.r0.h.i.k.f.a
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.r4("appinstallbegin");
            }
        }

        @Override // c.a.r0.h.i.k.f.a
        public void c(DownloadState downloadState, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, downloadState, i2) == null) {
                this.a.Y0.b(downloadState);
                if (this.a.b1 == downloadState) {
                    return;
                }
                if (this.a.b1 == DownloadState.NOT_START && downloadState == DownloadState.DOWNLOADING) {
                    this.a.r4("appdownloadbegin");
                } else if (downloadState == DownloadState.DOWNLOAD_PAUSED) {
                    this.a.r4("appdownloadpause");
                } else if (this.a.b1 == DownloadState.DOWNLOAD_PAUSED && downloadState == DownloadState.DOWNLOADING) {
                    this.a.r4("appdownloadcontinue");
                } else if (downloadState == DownloadState.DOWNLOADED) {
                    this.a.r4("appdownloadfinish");
                    this.a.r4("appinstallbegin");
                } else if (downloadState == DownloadState.INSTALLED) {
                    this.a.r4("appinstallfinish");
                }
                this.a.b1 = downloadState;
            }
        }

        @Override // c.a.r0.h.i.k.f.a
        public void d(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                this.a.o4(str);
            }
        }

        @Override // c.a.r0.h.i.k.f.a
        public String e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                this.a.r4("appinstallopen");
                SwanAppAdLandingFragment swanAppAdLandingFragment = this.a;
                return swanAppAdLandingFragment.U3(swanAppAdLandingFragment.a1.a);
            }
            return (String) invokeV.objValue;
        }

        @Override // c.a.r0.h.i.k.f.a
        public void f(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048581, this, z) == null) && this.a.J1.equals("1")) {
                if (z) {
                    this.a.s4();
                } else {
                    this.a.p4();
                }
            }
        }
    }

    /* loaded from: classes11.dex */
    public class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f38614e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SwanAppAdLandingFragment f38615f;

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
            this.f38615f = swanAppAdLandingFragment;
            this.f38614e = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int height = this.f38615f.U0.getHeight();
                if (this.f38615f.k4() || this.f38615f.i4()) {
                    ViewGroup.LayoutParams layoutParams = this.f38614e.getLayoutParams();
                    layoutParams.height = height;
                    this.f38614e.setLayoutParams(layoutParams);
                }
                if (this.f38615f.k4()) {
                    ViewGroup.LayoutParams layoutParams2 = this.f38615f.q1.getLayoutParams();
                    layoutParams2.height = height + (this.f38615f.t1.booleanValue() ? this.f38615f.C1 : this.f38615f.d1);
                    this.f38615f.q1.setLayoutParams(layoutParams2);
                }
                this.f38615f.s1.removeView(this.f38615f.U0);
                if (this.f38615f.r1 != null) {
                    this.f38615f.r1.setVisibility(0);
                }
            }
        }
    }

    /* loaded from: classes11.dex */
    public class l implements c.a.r0.a.h0.j.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CustomerAdScrollView a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SwanAppAdLandingFragment f38616b;

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
            this.f38616b = swanAppAdLandingFragment;
            this.a = customerAdScrollView;
        }

        @Override // c.a.r0.a.h0.j.c
        public void onScrollChanged(int i2, int i3, int i4, int i5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIII(1048576, this, i2, i3, i4, i5) == null) {
                this.a.setIsWebViewOnBottom(((((float) this.f38616b.K0.getContentHeight()) * this.f38616b.K0.getScale()) - ((float) this.f38616b.K0.covertToView().getHeight())) - ((float) this.f38616b.K0.getWebViewScrollY()) < 10.0f);
            }
        }
    }

    /* loaded from: classes11.dex */
    public class m extends c.a.r0.a.h0.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CustomerAdScrollView a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SwanAppAdLandingFragment f38617b;

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
            this.f38617b = swanAppAdLandingFragment;
            this.a = customerAdScrollView;
        }

        @Override // c.a.r0.a.h0.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                super.a(str);
                if (Math.abs((this.f38617b.K0.getContentHeight() * this.f38617b.K0.getScale()) - this.f38617b.K0.covertToView().getHeight()) < 10.0f) {
                    this.a.setIsWebViewOnBottom(true);
                } else {
                    this.a.setIsWebViewOnBottom(false);
                }
            }
        }
    }

    /* loaded from: classes11.dex */
    public class n implements c.a.r0.a.q.f.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CustomerAdScrollView a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SwanAppAdLandingFragment f38618b;

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
            this.f38618b = swanAppAdLandingFragment;
            this.a = customerAdScrollView;
        }

        @Override // c.a.r0.a.q.f.a
        public void onScrollChanged(int i2, int i3, int i4, int i5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIII(1048576, this, i2, i3, i4, i5) == null) {
                CustomerAdScrollView customerAdScrollView = this.a;
                SwanAppAdLandingFragment swanAppAdLandingFragment = this.f38618b;
                customerAdScrollView.setIsFooterLayoutShow(swanAppAdLandingFragment.l4(swanAppAdLandingFragment.r1));
            }
        }
    }

    /* loaded from: classes11.dex */
    public class o implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppAdLandingFragment f38619e;

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
            this.f38619e = swanAppAdLandingFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                int id = view.getId();
                HashMap<String, String> hashMap = new HashMap<>();
                if (id == c.a.r0.a.f.ad_tail_head_image) {
                    hashMap.put("da_area", "tail_icon");
                } else if (id == c.a.r0.a.f.ad_tail_brand_name) {
                    hashMap.put("da_area", "tail_name");
                } else if (id == c.a.r0.a.f.ad_tail_btn) {
                    hashMap.put("da_area", this.f38619e.f1 == ActionType.DL.value() ? "tail_downloadbtn" : "tail_detailbtn");
                }
                if (this.f38619e.T0 != null) {
                    this.f38619e.T0.d("c", hashMap);
                }
                c.a.r0.a.h0.g.l.X2("adLanding", c.a.r0.a.m1.b.e(this.f38619e.Q0, this.f38619e.Q0));
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
        Q1 = c.a.r0.a.k.a;
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

    public static /* synthetic */ int o3(SwanAppAdLandingFragment swanAppAdLandingFragment) {
        int i2 = swanAppAdLandingFragment.o1;
        swanAppAdLandingFragment.o1 = i2 + 1;
        return i2;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void A0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            super.A0(z);
            if (z) {
                n4();
            } else {
                q4();
            }
        }
    }

    @Override // c.a.r0.a.h0.g.l, c.a.r0.a.h0.g.d
    public boolean K() {
        InterceptResult invokeV;
        c.a.r0.a.j1.g.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (j4() && (aVar = this.S0) != null) {
                return aVar.onBackPressed();
            }
            r4("lpout");
            return super.K();
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.r0.a.h0.g.l, c.a.r0.a.h0.g.d
    public void O1(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) {
            super.O1(view);
            this.k0.setLeftHomeViewSrc(c.a.r0.a.e.aiapps_action_bar_close_black_selector);
            this.k0.setLeftHomeViewClickListener(new b(this));
        }
    }

    @Override // c.a.r0.a.h0.g.l
    public c.a.r0.a.h0.j.d T2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? new a(this) : (c.a.r0.a.h0.j.d) invokeV.objValue;
    }

    public final void T3(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.k0.setLeftHomeViewVisibility(z ? 0 : 8);
        }
    }

    public final String U3(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) ? c.a.r0.a.o2.g.h.a().getString(str, "") : (String) invokeL.objValue;
    }

    public final void V3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            c.a.r0.h.i.l.a aVar = this.O1;
            if (aVar != null) {
                o(aVar);
                return;
            }
            c.a.r0.h.i.p.b bVar = new c.a.r0.h.i.p.b(getContext());
            bVar.d(this);
            c.a.r0.h.i.p.c cVar = new c.a.r0.h.i.p.c(getContext());
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

    @Override // c.a.r0.a.h0.g.l, c.a.r0.a.h0.g.d
    public boolean W1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void W3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.Y0.f();
            if (TextUtils.isEmpty(this.a1.f39655b)) {
                String U3 = U3(this.G1);
                this.a1.f39655b = U3;
                this.Y0.a(U3);
            }
            if (q0.F(getContext(), this.a1.f39655b)) {
                s4();
                this.Y0.b(DownloadState.INSTALLED);
                return;
            }
            if (TextUtils.isEmpty(this.a1.a)) {
                this.a1.a = this.G1;
            }
            c.a.r0.a.c1.a.d().d(getContext(), this.a1.a(), DownloadParams.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.Z0);
        }
    }

    public final void X3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            q0.e0(new c(this));
        }
    }

    public final void Y3(c.a.r0.h.i.l.a aVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048586, this, aVar, z) == null) {
            SwanAppAlertDialog swanAppAlertDialog = this.K1;
            if (swanAppAlertDialog != null) {
                swanAppAlertDialog.show();
                return;
            }
            ((ViewGroup) this.L1.findViewById(c.a.r0.a.f.ad_landing_download_btn)).addView(this.Y0.getRealView());
            ((AdImageVIew) this.L1.findViewById(c.a.r0.a.f.ad_landing_download_icon)).setImageUrl(aVar.g());
            ((TextView) this.L1.findViewById(c.a.r0.a.f.ad_landing_download_appname)).setText(aVar.c());
            ((TextView) this.L1.findViewById(c.a.r0.a.f.ad_landing_download_publisher)).setText(aVar.d());
            ((TextView) this.L1.findViewById(c.a.r0.a.f.ad_landing_download_apksize)).setText(aVar.a());
            ((TextView) this.L1.findViewById(c.a.r0.a.f.ad_landing_download_version)).setText(aVar.j());
            TextView textView = (TextView) this.L1.findViewById(c.a.r0.a.f.ad_landing_download_hint);
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
            if (TextUtils.isEmpty(this.a1.f39655b)) {
                String U3 = U3(aVar.b());
                this.a1.f39655b = U3;
                this.Y0.a(U3);
            }
            if (q0.F(getContext(), this.a1.f39655b)) {
                this.Y0.b(DownloadState.INSTALLED);
            }
            if (TextUtils.isEmpty(this.a1.a)) {
                this.a1.a = aVar.b();
            }
            this.Y0.e(this.a1);
            c.a.r0.a.c2.b.b.b bVar = new c.a.r0.a.c2.b.b.b(getContext());
            bVar.i(true);
            bVar.k(false);
            bVar.T(false);
            bVar.m(false);
            bVar.t(false);
            bVar.n(new c.a.r0.a.a3.h.a());
            bVar.p(c.a.r0.a.e.aiapps_action_sheet_bg);
            bVar.F(c.a.r0.a.c.swan_app_action_sheet_cancel_text);
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
                window.setWindowAnimations(c.a.r0.a.i.action_sheet_animation);
            }
            this.K1.setEnableImmersion(false);
            this.K1.setCanceledOnTouchOutside(true);
            this.K1.show();
        }
    }

    public final void Z3(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, viewGroup) == null) {
            this.Z0 = new j(this);
            this.a1 = new DownloadParams(this.W0, this.X0);
            c.a.r0.h.i.k.g.b bVar = new c.a.r0.h.i.k.g.b();
            bVar.l(getContext(), this.a1, this.Z0);
            this.Y0 = bVar;
            bVar.e(this.a1);
            a4();
        }
    }

    public final void a4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            View inflate = View.inflate(getContext(), c.a.r0.a.g.aiapps_ad_landing_download, null);
            this.L1 = inflate;
            ((TextView) inflate.findViewById(c.a.r0.a.f.ad_landing_download_privacy)).setOnClickListener(new d(this));
            ((TextView) this.L1.findViewById(c.a.r0.a.f.ad_landing_download_permission)).setOnClickListener(new e(this));
            ((ImageView) this.L1.findViewById(c.a.r0.a.f.close_ad_download_btn)).setOnClickListener(new f(this));
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

    public final void b4(ViewGroup viewGroup, ViewGroup viewGroup2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, viewGroup, viewGroup2) == null) {
            this.r1 = (LinearLayout) ((LinearLayout) LayoutInflater.from(getContext()).inflate(c.a.r0.a.g.swanapp_ad_footer_view, (ViewGroup) null)).findViewById(c.a.r0.a.f.ad_footer);
            CustomerAdScrollView customerAdScrollView = new CustomerAdScrollView(getContext());
            LinearLayout linearLayout = new LinearLayout(getContext());
            linearLayout.setOrientation(1);
            linearLayout.addView(viewGroup2, new LinearLayout.LayoutParams(-1, -2));
            linearLayout.addView(this.r1, new LinearLayout.LayoutParams(-1, getContext().getResources().getDimensionPixelSize(c.a.r0.a.d.swanapp_ad_dimens_footer_height)));
            customerAdScrollView.addView(linearLayout, new LinearLayout.LayoutParams(-1, -2));
            viewGroup.addView(customerAdScrollView);
            this.J0.u(new l(this, customerAdScrollView));
            this.J0.d(new m(this, customerAdScrollView));
            customerAdScrollView.setScrollViewListener(new n(this, customerAdScrollView));
        }
    }

    public final void c4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(getContext()).inflate(c.a.r0.a.g.swanapp_ad_landing_portrait_video, (ViewGroup) null);
            this.q1.addView(relativeLayout, new FrameLayout.LayoutParams(-1, this.C1));
            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) relativeLayout.findViewById(c.a.r0.a.f.ad_landing_bg_image);
            SimpleDraweeView simpleDraweeView2 = (SimpleDraweeView) relativeLayout.findViewById(c.a.r0.a.f.ad_landing_mask);
            this.A1 = (FrameLayout) relativeLayout.findViewById(c.a.r0.a.f.ad_landing_video);
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

    public final void d4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(getContext()).inflate(c.a.r0.a.g.swanapp_ad_video_tail_view, (ViewGroup) null);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.height = this.t1.booleanValue() ? this.C1 : this.d1;
            this.c1 = (RelativeLayout) relativeLayout.findViewById(c.a.r0.a.f.ad_tail_root);
            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) relativeLayout.findViewById(c.a.r0.a.f.ad_tail_video_img);
            SimpleDraweeView simpleDraweeView2 = (SimpleDraweeView) relativeLayout.findViewById(c.a.r0.a.f.ad_tail_head_image);
            TextView textView = (TextView) relativeLayout.findViewById(c.a.r0.a.f.ad_tail_brand_name);
            TextView textView2 = (TextView) relativeLayout.findViewById(c.a.r0.a.f.ad_tail_btn);
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
            simpleDraweeView.getHierarchy().setPlaceholderImage(getResources().getDrawable(c.a.r0.a.e.swanapp_ad_tab_video_img_default_icon));
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

    public final void e4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            if (this.t1.booleanValue()) {
                c4();
            }
            c.a.r0.a.q.d dVar = new c.a.r0.a.q.d(this.k1, this.l1, this.J0.c(), this.t1.booleanValue() ? 0 : this.e1, this.t1.booleanValue() ? 0 : this.d1, this.n1, this.t1.booleanValue());
            c.a.r0.a.j1.g.a aVar = new c.a.r0.a.j1.g.a(getContext(), dVar.a());
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

    public final void f4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
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

    /* JADX WARN: Type inference failed for: r0v4, types: [c.a.r0.a.p.e.c] */
    public final void g4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            c.a.r0.a.p.e.e l2 = l();
            this.J0 = l2;
            l2.a0(T2());
            this.K0 = this.J0.t();
            this.J0.loadUrl(this.Q0);
            FrameLayout frameLayout = new FrameLayout(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            View covertToView = this.K0.covertToView();
            c.a.r0.a.d2.n.g gVar = new c.a.r0.a.d2.n.g();
            gVar.f5577e = SwanAppConfigData.t("#FFFFFF");
            this.J0.A(frameLayout, gVar);
            this.J0.Q(frameLayout, gVar);
            this.J0.k(frameLayout, covertToView);
            if (i4()) {
                b4(this.q1, frameLayout);
            } else {
                this.q1.addView(frameLayout);
            }
            WebViewContainer webViewContainer = this.q1;
            if (webViewContainer != null) {
                webViewContainer.setInternalWebView(this.K0);
            }
            if (k4()) {
                layoutParams.topMargin = this.t1.booleanValue() ? this.C1 : this.d1;
            }
            covertToView.setLayoutParams(layoutParams);
            this.U0.post(new k(this, covertToView));
        }
    }

    public final void h4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            c.a.r0.a.q.f.b bVar = new c.a.r0.a.q.f.b(getContext());
            this.F1 = bVar;
            bVar.o(k4() ? this.d1 : 0);
            WebViewContainer k2 = this.F1.k();
            this.q1 = k2;
            this.s1.addView(k2);
        }
    }

    public final boolean i4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? TextUtils.equals("swan-custom-ad", this.V0) : invokeV.booleanValue;
    }

    public final boolean j4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? getActivity().getResources().getConfiguration().orientation == 2 : invokeV.booleanValue;
    }

    public final boolean k4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.R0 == LandingType.VIDEO : invokeV.booleanValue;
    }

    @Override // c.a.r0.a.h0.g.l
    public c.a.r0.a.p.e.e l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            c.a.r0.a.q.e eVar = new c.a.r0.a.q.e(getContext());
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
                        this.this$0.V3();
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
        return (c.a.r0.a.p.e.e) invokeV.objValue;
    }

    public final boolean l4(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, view)) == null) {
            if (view == null || view.getVisibility() != 0) {
                return false;
            }
            return view.getGlobalVisibleRect(new Rect());
        }
        return invokeL.booleanValue;
    }

    public final void m4() {
        Bundle t;
        String I;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048601, this) == null) || (t = t()) == null) {
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
                I = I(c.a.r0.a.h.swanapp_ad_download_button);
            } else {
                I = I(c.a.r0.a.h.swanapp_ad_landingpage_button);
            }
            this.g1 = I;
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

    public final void n4() {
        c.a.r0.a.j1.g.a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048602, this) == null) && (aVar = this.S0) != null && aVar.n()) {
            this.S0.p();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // c.a.r0.h.i.m.b
    public void o(c.a.r0.h.i.l.a aVar) {
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, aVar) == null) {
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
                W3();
            } else if (c2 == 1) {
                Y3(aVar, true);
            } else if (c2 == 2) {
                Y3(aVar, false);
            } else if (c2 != 3) {
            } else {
                X3();
            }
        }
    }

    public final void o4(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048604, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        c.a.r0.a.o2.g.h.a().putString(this.a1.a, str);
    }

    @Override // c.a.r0.a.h0.g.l, com.baidu.swan.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, bundle) == null) {
            super.onCreate(bundle);
            m4();
            this.T0 = new c.a.r0.h.i.r.c(getContext(), this.m1);
            FragmentActivity activity = getActivity();
            if (activity != null) {
                boolean z = 1 == activity.getRequestedOrientation();
                this.p1 = z;
                if (!z) {
                    B2(1);
                }
            }
            if (Q1) {
                String str = "onCreate() : " + this;
            }
        }
    }

    @Override // c.a.r0.a.h0.g.l, com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            if (k4()) {
                r4("vplayend");
            }
            c.a.r0.a.j1.g.a aVar = this.S0;
            if (aVar != null) {
                aVar.onDestroy();
            }
            if (!this.p1) {
                B2(0);
            }
            super.onDestroy();
        }
    }

    @Override // c.a.r0.a.h0.g.d, com.baidu.swan.support.v4.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            super.onPause();
            n4();
        }
    }

    @Override // c.a.r0.a.h0.g.d, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            super.onResume();
            c.a.r0.a.q.f.b bVar = this.F1;
            if (bVar == null || !bVar.l() || m0()) {
                return;
            }
            q4();
        }
    }

    public final void p4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            this.q1.removeView(this.Y0.getRealView());
            this.q1.removeView(this.I1);
        }
    }

    public final void q4() {
        c.a.r0.a.j1.g.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048610, this) == null) || (aVar = this.S0) == null || aVar.n() || this.S0.m()) {
            return;
        }
        this.S0.s();
    }

    public final void r4(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, str) == null) {
            HashMap<String, String> hashMap = new HashMap<>();
            c.a.r0.a.j1.g.a aVar = this.S0;
            if (aVar != null) {
                hashMap.put("cur_time", String.valueOf(aVar.e() / 1000));
            }
            c.a.r0.h.i.r.c cVar = this.T0;
            if (cVar != null) {
                cVar.d(str, hashMap);
            }
        }
    }

    public final void s4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            p4();
            this.q1.addView(this.I1);
            this.q1.addView(this.Y0.getRealView());
        }
    }

    @Override // c.a.r0.a.h0.g.l, com.baidu.swan.support.v4.app.Fragment
    public View w0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048613, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(c.a.r0.a.g.aiapps_webview_fragment, viewGroup, false);
            O1(inflate);
            this.s1 = (ViewGroup) inflate.findViewById(c.a.r0.a.f.swan_app_webview_fragment);
            this.U0 = (FrameLayout) inflate.findViewById(c.a.r0.a.f.aiapps_webView_container);
            f4();
            h4();
            Z3(this.q1);
            g4();
            if (k4()) {
                e4();
                d4();
            }
            if (N1()) {
                inflate = Q1(inflate);
            }
            r4("lpin");
            return x1(inflate, this);
        }
        return (View) invokeLLL.objValue;
    }
}
