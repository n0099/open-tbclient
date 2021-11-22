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
import b.a.p0.a.z2.n0;
import b.a.p0.a.z2.q0;
import b.a.p0.a.z2.u;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.browser.sailor.ISailorDownloadListener;
import com.baidu.mobads.container.adrequest.AdParamInfo;
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
/* loaded from: classes7.dex */
public class SwanAppAdLandingFragment extends b.a.p0.a.h0.g.l implements b.a.p0.h.i.m.b {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean P1;
    public transient /* synthetic */ FieldHolder $fh;
    public int A1;
    public int B1;
    public int C1;
    public String D1;
    public b.a.p0.a.q.f.b E1;
    public String F1;
    public String G1;
    public TextView H1;
    public String I1;
    public SwanAppAlertDialog J1;
    public View K1;
    public String L1;
    public String M1;
    public b.a.p0.h.i.l.a N1;
    public View.OnClickListener O1;
    public String P0;
    public LandingType Q0;
    public b.a.p0.a.j1.g.a R0;
    public b.a.p0.h.i.r.c S0;
    public FrameLayout T0;
    public String U0;
    public String V0;
    public String W0;
    public b.a.p0.h.i.k.f.f X0;
    public b.a.p0.h.i.k.f.a Y0;
    public DownloadParams Z0;
    public DownloadState a1;
    public RelativeLayout b1;
    public int c1;
    public int d1;
    public int e1;
    public String f1;
    public String g1;
    public String h1;
    public String i1;
    public String j1;
    public String k1;
    public JSONObject l1;
    public int m1;
    public int n1;
    public boolean o1;
    public WebViewContainer p1;
    public LinearLayout q1;
    public ViewGroup r1;
    public Boolean s1;
    public int t1;
    public int u1;
    public String v1;
    public String w1;
    public float x1;
    public float y1;
    public FrameLayout z1;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes7.dex */
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
    /* loaded from: classes7.dex */
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
            LandingType landingType = new LandingType(AdParamInfo.AdClickActionString.AD_CLICK_ACTION_VIDEO, 1);
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

    /* loaded from: classes7.dex */
    public class a extends b.a.p0.a.h0.j.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ SwanAppAdLandingFragment f44225c;

        /* renamed from: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class RunnableC1723a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f44226e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f44227f;

            public RunnableC1723a(a aVar, String str) {
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
                this.f44227f = aVar;
                this.f44226e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f44227f.f44225c.o0.setTitle(TextUtils.isEmpty(this.f44226e) ? "" : this.f44226e);
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
            this.f44225c = swanAppAdLandingFragment;
        }

        @Override // b.a.p0.a.h0.j.a, b.a.p0.a.h0.j.d
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                SwanAppAdLandingFragment swanAppAdLandingFragment = this.f44225c;
                swanAppAdLandingFragment.W3(swanAppAdLandingFragment.J0.canGoBack());
                this.f44225c.o0.post(new RunnableC1723a(this, str));
            }
        }

        @Override // b.a.p0.a.h0.j.a, b.a.p0.a.h0.j.d
        public boolean c(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                if (b.a.p0.a.e2.a.b.e(str) || b.a.p0.a.e2.a.b.f(str)) {
                    try {
                        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                        b.a.p0.a.d2.e a0 = b.a.p0.a.d2.e.a0();
                        if (a0 != null) {
                            a0.x().startActivity(intent);
                            return true;
                        }
                    } catch (Exception e2) {
                        if (SwanAppAdLandingFragment.P1) {
                            e2.printStackTrace();
                        }
                    }
                }
                return super.c(str);
            }
            return invokeL.booleanValue;
        }

        @Override // b.a.p0.a.h0.j.a, b.a.p0.a.h0.j.d
        public void e(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                super.e(str);
                if (TextUtils.isEmpty(this.f44225c.i1) || this.f44225c.S0 == null) {
                    return;
                }
                this.f44225c.S0.e(this.f44225c.i1);
            }
        }

        @Override // b.a.p0.a.h0.j.a, b.a.p0.a.h0.j.d
        public void goBack() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                SwanAppAdLandingFragment swanAppAdLandingFragment = this.f44225c;
                swanAppAdLandingFragment.W3(swanAppAdLandingFragment.J0.canGoBack());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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
                }
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                b.a.p0.a.h0.g.l.V2();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppAdLandingFragment f44228e;

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
            this.f44228e = swanAppAdLandingFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.a.p0.a.c2.b.f.e g2 = b.a.p0.a.c2.b.f.e.g(this.f44228e.getContext(), "第三方页面应用未经百度审核");
                g2.p(ToastLocation.BOTTOM);
                g2.G();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppAdLandingFragment f44229e;

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
            this.f44229e = swanAppAdLandingFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                b.a.p0.a.h0.g.l.a3("adLanding", b.a.p0.a.m1.b.e(this.f44229e.M1, this.f44229e.M1));
                this.f44229e.J1.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppAdLandingFragment f44230e;

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
            this.f44230e = swanAppAdLandingFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                b.a.p0.a.h0.g.l.a3("adLanding", b.a.p0.a.m1.b.e(this.f44230e.L1, this.f44230e.L1));
                this.f44230e.J1.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppAdLandingFragment f44231e;

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
            this.f44231e = swanAppAdLandingFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f44231e.J1.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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
                }
            }
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h implements b.a.p0.a.j1.g.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SwanAppAdLandingFragment f44232a;

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
            this.f44232a = swanAppAdLandingFragment;
        }

        @Override // b.a.p0.a.j1.g.b
        public void a(b.a.p0.a.c1.d.k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, kVar) == null) {
                this.f44232a.u4("vcontinueplay");
            }
        }

        @Override // b.a.p0.a.j1.g.b
        public void b(b.a.p0.a.c1.d.k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, kVar) == null) {
                this.f44232a.b1.bringToFront();
                this.f44232a.b1.setVisibility(0);
                this.f44232a.m1 = 0;
                SwanAppAdLandingFragment.r3(this.f44232a);
                this.f44232a.u4("vplayend");
                this.f44232a.u4("scard");
            }
        }

        @Override // b.a.p0.a.j1.g.b
        public void c(b.a.p0.a.c1.d.k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, kVar) == null) {
                this.f44232a.u4("vpause");
            }
        }

        @Override // b.a.p0.a.j1.g.b
        public void d(b.a.p0.a.c1.d.k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, kVar) == null) {
                if (this.f44232a.n1 == 0) {
                    this.f44232a.u4("vstart");
                    return;
                }
                this.f44232a.b1.setVisibility(8);
                this.f44232a.u4("vrepeatedplay");
            }
        }

        @Override // b.a.p0.a.j1.g.b
        public void e(b.a.p0.a.c1.d.k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, kVar) == null) {
            }
        }

        @Override // b.a.p0.a.j1.g.b
        public boolean f(b.a.p0.a.c1.d.k kVar, int i2, int i3) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(1048581, this, kVar, i2, i3)) == null) {
                return false;
            }
            return invokeLII.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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
                }
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j implements b.a.p0.h.i.k.f.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SwanAppAdLandingFragment f44233a;

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
            this.f44233a = swanAppAdLandingFragment;
        }

        @Override // b.a.p0.h.i.k.f.a
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                this.f44233a.X0.d(i2);
            }
        }

        @Override // b.a.p0.h.i.k.f.a
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f44233a.u4("appinstallbegin");
            }
        }

        @Override // b.a.p0.h.i.k.f.a
        public void c(DownloadState downloadState, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, downloadState, i2) == null) {
                this.f44233a.X0.b(downloadState);
                if (this.f44233a.a1 == downloadState) {
                    return;
                }
                if (this.f44233a.a1 == DownloadState.NOT_START && downloadState == DownloadState.DOWNLOADING) {
                    this.f44233a.u4("appdownloadbegin");
                } else if (downloadState == DownloadState.DOWNLOAD_PAUSED) {
                    this.f44233a.u4("appdownloadpause");
                } else if (this.f44233a.a1 == DownloadState.DOWNLOAD_PAUSED && downloadState == DownloadState.DOWNLOADING) {
                    this.f44233a.u4("appdownloadcontinue");
                } else if (downloadState == DownloadState.DOWNLOADED) {
                    this.f44233a.u4("appdownloadfinish");
                    this.f44233a.u4("appinstallbegin");
                } else if (downloadState == DownloadState.INSTALLED) {
                    this.f44233a.u4("appinstallfinish");
                }
                this.f44233a.a1 = downloadState;
            }
        }

        @Override // b.a.p0.h.i.k.f.a
        public void d(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                this.f44233a.r4(str);
            }
        }

        @Override // b.a.p0.h.i.k.f.a
        public String e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                this.f44233a.u4("appinstallopen");
                SwanAppAdLandingFragment swanAppAdLandingFragment = this.f44233a;
                return swanAppAdLandingFragment.X3(swanAppAdLandingFragment.Z0.f45356a);
            }
            return (String) invokeV.objValue;
        }

        @Override // b.a.p0.h.i.k.f.a
        public void f(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048581, this, z) == null) && this.f44233a.I1.equals("1")) {
                if (z) {
                    this.f44233a.v4();
                } else {
                    this.f44233a.s4();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f44234e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SwanAppAdLandingFragment f44235f;

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
            this.f44235f = swanAppAdLandingFragment;
            this.f44234e = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int height = this.f44235f.T0.getHeight();
                if (this.f44235f.n4() || this.f44235f.l4()) {
                    ViewGroup.LayoutParams layoutParams = this.f44234e.getLayoutParams();
                    layoutParams.height = height;
                    this.f44234e.setLayoutParams(layoutParams);
                }
                if (this.f44235f.n4()) {
                    ViewGroup.LayoutParams layoutParams2 = this.f44235f.p1.getLayoutParams();
                    layoutParams2.height = height + (this.f44235f.s1.booleanValue() ? this.f44235f.B1 : this.f44235f.c1);
                    this.f44235f.p1.setLayoutParams(layoutParams2);
                }
                this.f44235f.r1.removeView(this.f44235f.T0);
                if (this.f44235f.q1 != null) {
                    this.f44235f.q1.setVisibility(0);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class l implements b.a.p0.a.h0.j.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CustomerAdScrollView f44236a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SwanAppAdLandingFragment f44237b;

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
            this.f44237b = swanAppAdLandingFragment;
            this.f44236a = customerAdScrollView;
        }

        @Override // b.a.p0.a.h0.j.c
        public void onScrollChanged(int i2, int i3, int i4, int i5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIII(1048576, this, i2, i3, i4, i5) == null) {
                this.f44236a.setIsWebViewOnBottom(((((float) this.f44237b.J0.getContentHeight()) * this.f44237b.J0.getScale()) - ((float) this.f44237b.J0.covertToView().getHeight())) - ((float) this.f44237b.J0.getWebViewScrollY()) < 10.0f);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class m extends b.a.p0.a.h0.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CustomerAdScrollView f44238a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SwanAppAdLandingFragment f44239b;

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
            this.f44239b = swanAppAdLandingFragment;
            this.f44238a = customerAdScrollView;
        }

        @Override // b.a.p0.a.h0.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                super.a(str);
                if (Math.abs((this.f44239b.J0.getContentHeight() * this.f44239b.J0.getScale()) - this.f44239b.J0.covertToView().getHeight()) < 10.0f) {
                    this.f44238a.setIsWebViewOnBottom(true);
                } else {
                    this.f44238a.setIsWebViewOnBottom(false);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class n implements b.a.p0.a.q.f.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CustomerAdScrollView f44240a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SwanAppAdLandingFragment f44241b;

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
            this.f44241b = swanAppAdLandingFragment;
            this.f44240a = customerAdScrollView;
        }

        @Override // b.a.p0.a.q.f.a
        public void onScrollChanged(int i2, int i3, int i4, int i5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIII(1048576, this, i2, i3, i4, i5) == null) {
                CustomerAdScrollView customerAdScrollView = this.f44240a;
                SwanAppAdLandingFragment swanAppAdLandingFragment = this.f44241b;
                customerAdScrollView.setIsFooterLayoutShow(swanAppAdLandingFragment.o4(swanAppAdLandingFragment.q1));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class o implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppAdLandingFragment f44242e;

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
            this.f44242e = swanAppAdLandingFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                int id = view.getId();
                HashMap<String, String> hashMap = new HashMap<>();
                if (id == b.a.p0.a.f.ad_tail_head_image) {
                    hashMap.put("da_area", "tail_icon");
                } else if (id == b.a.p0.a.f.ad_tail_brand_name) {
                    hashMap.put("da_area", "tail_name");
                } else if (id == b.a.p0.a.f.ad_tail_btn) {
                    hashMap.put("da_area", this.f44242e.e1 == ActionType.DL.value() ? "tail_downloadbtn" : "tail_detailbtn");
                }
                if (this.f44242e.S0 != null) {
                    this.f44242e.S0.d("c", hashMap);
                }
                b.a.p0.a.h0.g.l.a3("adLanding", b.a.p0.a.m1.b.e(this.f44242e.P0, this.f44242e.P0));
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
        P1 = b.a.p0.a.k.f6863a;
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
        this.Q0 = LandingType.NORMAL;
        this.U0 = "";
        this.V0 = "";
        this.W0 = "";
        this.a1 = DownloadState.NOT_START;
        this.l1 = new JSONObject();
        this.m1 = 0;
        this.n1 = 0;
        this.o1 = true;
        this.s1 = Boolean.FALSE;
        this.J1 = null;
        this.N1 = null;
        this.O1 = new o(this);
    }

    public static /* synthetic */ int r3(SwanAppAdLandingFragment swanAppAdLandingFragment) {
        int i2 = swanAppAdLandingFragment.n1;
        swanAppAdLandingFragment.n1 = i2 + 1;
        return i2;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void D0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            super.D0(z);
            if (z) {
                q4();
            } else {
                t4();
            }
        }
    }

    @Override // b.a.p0.a.h0.g.l, b.a.p0.a.h0.g.d
    public boolean K() {
        InterceptResult invokeV;
        b.a.p0.a.j1.g.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (m4() && (aVar = this.R0) != null) {
                return aVar.onBackPressed();
            }
            u4("lpout");
            return super.K();
        }
        return invokeV.booleanValue;
    }

    @Override // b.a.p0.a.h0.g.l, b.a.p0.a.h0.g.d
    public void R1(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) {
            super.R1(view);
            this.o0.setLeftHomeViewSrc(b.a.p0.a.e.aiapps_action_bar_close_black_selector);
            this.o0.setLeftHomeViewClickListener(new b(this));
        }
    }

    @Override // b.a.p0.a.h0.g.l
    public b.a.p0.a.h0.j.d W2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? new a(this) : (b.a.p0.a.h0.j.d) invokeV.objValue;
    }

    public final void W3(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.o0.setLeftHomeViewVisibility(z ? 0 : 8);
        }
    }

    public final String X3(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) ? b.a.p0.a.o2.g.h.a().getString(str, "") : (String) invokeL.objValue;
    }

    public final void Y3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            b.a.p0.h.i.l.a aVar = this.N1;
            if (aVar != null) {
                g(aVar);
                return;
            }
            b.a.p0.h.i.p.b bVar = new b.a.p0.h.i.p.b(getContext());
            bVar.d(this);
            b.a.p0.h.i.p.c cVar = new b.a.p0.h.i.p.c(getContext());
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("charge_url", this.G1);
                jSONObject.put("apk_url", this.F1);
                jSONObject.put("ssl", 1);
            } catch (JSONException e2) {
                if (P1) {
                    e2.printStackTrace();
                }
            }
            bVar.c(cVar, jSONObject);
        }
    }

    @Override // b.a.p0.a.h0.g.l, b.a.p0.a.h0.g.d
    public boolean Z1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void Z3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.X0.f();
            if (TextUtils.isEmpty(this.Z0.f45357b)) {
                String X3 = X3(this.F1);
                this.Z0.f45357b = X3;
                this.X0.a(X3);
            }
            if (q0.F(getContext(), this.Z0.f45357b)) {
                v4();
                this.X0.b(DownloadState.INSTALLED);
                return;
            }
            if (TextUtils.isEmpty(this.Z0.f45356a)) {
                this.Z0.f45356a = this.F1;
            }
            b.a.p0.a.c1.a.d().d(getContext(), this.Z0.a(), DownloadParams.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.Y0);
        }
    }

    public final void a4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            q0.e0(new c(this));
        }
    }

    public final void b4(b.a.p0.h.i.l.a aVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048586, this, aVar, z) == null) {
            SwanAppAlertDialog swanAppAlertDialog = this.J1;
            if (swanAppAlertDialog != null) {
                swanAppAlertDialog.show();
                return;
            }
            ((ViewGroup) this.K1.findViewById(b.a.p0.a.f.ad_landing_download_btn)).addView(this.X0.getRealView());
            ((AdImageVIew) this.K1.findViewById(b.a.p0.a.f.ad_landing_download_icon)).setImageUrl(aVar.g());
            ((TextView) this.K1.findViewById(b.a.p0.a.f.ad_landing_download_appname)).setText(aVar.c());
            ((TextView) this.K1.findViewById(b.a.p0.a.f.ad_landing_download_publisher)).setText(aVar.d());
            ((TextView) this.K1.findViewById(b.a.p0.a.f.ad_landing_download_apksize)).setText(aVar.a());
            ((TextView) this.K1.findViewById(b.a.p0.a.f.ad_landing_download_version)).setText(aVar.j());
            TextView textView = (TextView) this.K1.findViewById(b.a.p0.a.f.ad_landing_download_hint);
            if (!z) {
                textView.setText(aVar.e());
                textView.setVisibility(0);
            }
            this.L1 = aVar.h();
            this.M1 = aVar.i();
            ViewGroup.LayoutParams layoutParams = this.X0.getRealView().getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(-1, -2);
                this.X0.getRealView().setLayoutParams(layoutParams);
            }
            int o2 = n0.o(getContext());
            float l2 = n0.l(getContext());
            layoutParams.width = o2 - (((int) ((10.0f * l2) + 0.5f)) * 2);
            if (TextUtils.isEmpty(this.Z0.f45357b)) {
                String X3 = X3(aVar.b());
                this.Z0.f45357b = X3;
                this.X0.a(X3);
            }
            if (q0.F(getContext(), this.Z0.f45357b)) {
                this.X0.b(DownloadState.INSTALLED);
            }
            if (TextUtils.isEmpty(this.Z0.f45356a)) {
                this.Z0.f45356a = aVar.b();
            }
            this.X0.e(this.Z0);
            b.a.p0.a.c2.b.b.b bVar = new b.a.p0.a.c2.b.b.b(getContext());
            bVar.i(true);
            bVar.k(false);
            bVar.T(false);
            bVar.m(false);
            bVar.t(false);
            bVar.n(new b.a.p0.a.a3.h.a());
            bVar.p(b.a.p0.a.e.aiapps_action_sheet_bg);
            bVar.F(b.a.p0.a.c.swan_app_action_sheet_cancel_text);
            bVar.K(new g(this));
            bVar.W(this.K1);
            bVar.j();
            bVar.q((int) (l2 * (z ? 225.0f : 250.0f)));
            SwanAppAlertDialog c2 = bVar.c();
            this.J1 = c2;
            Window window = c2.getWindow();
            if (window != null) {
                window.setGravity(80);
                window.setDimAmount(0.65f);
                window.setLayout(n0.s(getContext()), -2);
                window.setWindowAnimations(b.a.p0.a.i.action_sheet_animation);
            }
            this.J1.setEnableImmersion(false);
            this.J1.setCanceledOnTouchOutside(true);
            this.J1.show();
        }
    }

    public final void c4(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, viewGroup) == null) {
            this.Y0 = new j(this);
            this.Z0 = new DownloadParams(this.V0, this.W0);
            b.a.p0.h.i.k.g.b bVar = new b.a.p0.h.i.k.g.b();
            bVar.l(getContext(), this.Z0, this.Y0);
            this.X0 = bVar;
            bVar.e(this.Z0);
            d4();
        }
    }

    public final void d4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            View inflate = View.inflate(getContext(), b.a.p0.a.g.aiapps_ad_landing_download, null);
            this.K1 = inflate;
            ((TextView) inflate.findViewById(b.a.p0.a.f.ad_landing_download_privacy)).setOnClickListener(new d(this));
            ((TextView) this.K1.findViewById(b.a.p0.a.f.ad_landing_download_permission)).setOnClickListener(new e(this));
            ((ImageView) this.K1.findViewById(b.a.p0.a.f.close_ad_download_btn)).setOnClickListener(new f(this));
            TextView textView = new TextView(getContext());
            this.H1 = textView;
            textView.setText("温馨提示：您已访问至第三方页面");
            this.H1.setTextColor(-16777216);
            GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{0, -1});
            gradientDrawable.setShape(0);
            this.H1.setBackground(gradientDrawable);
            this.H1.getBackground().setAlpha(180);
            this.H1.setPadding(0, 0, 0, 10);
            this.H1.setGravity(80);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, 260);
            layoutParams.gravity = 81;
            layoutParams.bottomMargin = ((int) (getContext().getResources().getDisplayMetrics().heightPixels * 0.14d)) - 80;
            this.H1.setLayoutParams(layoutParams);
            this.H1.setGravity(81);
        }
    }

    public final void e4(ViewGroup viewGroup, ViewGroup viewGroup2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, viewGroup, viewGroup2) == null) {
            this.q1 = (LinearLayout) ((LinearLayout) LayoutInflater.from(getContext()).inflate(b.a.p0.a.g.swanapp_ad_footer_view, (ViewGroup) null)).findViewById(b.a.p0.a.f.ad_footer);
            CustomerAdScrollView customerAdScrollView = new CustomerAdScrollView(getContext());
            LinearLayout linearLayout = new LinearLayout(getContext());
            linearLayout.setOrientation(1);
            linearLayout.addView(viewGroup2, new LinearLayout.LayoutParams(-1, -2));
            linearLayout.addView(this.q1, new LinearLayout.LayoutParams(-1, getContext().getResources().getDimensionPixelSize(b.a.p0.a.d.swanapp_ad_dimens_footer_height)));
            customerAdScrollView.addView(linearLayout, new LinearLayout.LayoutParams(-1, -2));
            viewGroup.addView(customerAdScrollView);
            this.I0.u(new l(this, customerAdScrollView));
            this.I0.d(new m(this, customerAdScrollView));
            customerAdScrollView.setScrollViewListener(new n(this, customerAdScrollView));
        }
    }

    public final void f4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(getContext()).inflate(b.a.p0.a.g.swanapp_ad_landing_portrait_video, (ViewGroup) null);
            this.p1.addView(relativeLayout, new FrameLayout.LayoutParams(-1, this.B1));
            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) relativeLayout.findViewById(b.a.p0.a.f.ad_landing_bg_image);
            SimpleDraweeView simpleDraweeView2 = (SimpleDraweeView) relativeLayout.findViewById(b.a.p0.a.f.ad_landing_mask);
            this.z1 = (FrameLayout) relativeLayout.findViewById(b.a.p0.a.f.ad_landing_video);
            if (!TextUtils.isEmpty(this.v1)) {
                simpleDraweeView.setImageURI(Uri.parse(this.v1));
                simpleDraweeView.setOnClickListener(this.O1);
            } else {
                simpleDraweeView.setVisibility(4);
            }
            if (!TextUtils.isEmpty(this.w1)) {
                simpleDraweeView2.setImageURI(Uri.parse(this.w1));
            } else {
                simpleDraweeView2.setVisibility(4);
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.z1.getLayoutParams();
            layoutParams.width = this.d1;
            layoutParams.height = this.c1;
            layoutParams.rightMargin = this.C1;
            this.z1.setLayoutParams(layoutParams);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // b.a.p0.h.i.m.b
    public void g(b.a.p0.h.i.l.a aVar) {
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, aVar) == null) {
            this.N1 = aVar;
            String f2 = aVar.f();
            this.I1 = f2;
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
                Z3();
            } else if (c2 == 1) {
                b4(aVar, true);
            } else if (c2 == 2) {
                b4(aVar, false);
            } else if (c2 != 3) {
            } else {
                a4();
            }
        }
    }

    public final void g4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(getContext()).inflate(b.a.p0.a.g.swanapp_ad_video_tail_view, (ViewGroup) null);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.height = this.s1.booleanValue() ? this.B1 : this.c1;
            this.b1 = (RelativeLayout) relativeLayout.findViewById(b.a.p0.a.f.ad_tail_root);
            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) relativeLayout.findViewById(b.a.p0.a.f.ad_tail_video_img);
            SimpleDraweeView simpleDraweeView2 = (SimpleDraweeView) relativeLayout.findViewById(b.a.p0.a.f.ad_tail_head_image);
            TextView textView = (TextView) relativeLayout.findViewById(b.a.p0.a.f.ad_tail_brand_name);
            TextView textView2 = (TextView) relativeLayout.findViewById(b.a.p0.a.f.ad_tail_btn);
            if (!TextUtils.isEmpty(this.f1)) {
                textView2.setText(this.f1);
                textView2.setVisibility(0);
            } else {
                textView2.setVisibility(8);
            }
            if (!TextUtils.isEmpty(this.g1)) {
                textView.setText(this.g1);
                textView.setVisibility(0);
            } else {
                textView.setVisibility(4);
            }
            if (!TextUtils.isEmpty(this.h1)) {
                simpleDraweeView2.setImageURI(Uri.parse(this.h1));
                simpleDraweeView2.setVisibility(0);
            } else {
                simpleDraweeView2.setVisibility(8);
            }
            simpleDraweeView.getHierarchy().setPlaceholderImage(getResources().getDrawable(b.a.p0.a.e.swanapp_ad_tab_video_img_default_icon));
            String str = this.s1.booleanValue() ? this.D1 : this.j1;
            if (!TextUtils.isEmpty(str)) {
                simpleDraweeView.setImageURI(u.m(str));
            }
            simpleDraweeView.setVisibility(0);
            simpleDraweeView.setOnClickListener(new i(this));
            simpleDraweeView2.setOnClickListener(this.O1);
            textView.setOnClickListener(this.O1);
            textView2.setOnClickListener(this.O1);
            this.p1.addView(this.b1, layoutParams);
            this.b1.setVisibility(4);
        }
    }

    public final void h4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            if (this.s1.booleanValue()) {
                f4();
            }
            b.a.p0.a.q.d dVar = new b.a.p0.a.q.d(this.j1, this.k1, this.I0.c(), this.s1.booleanValue() ? 0 : this.d1, this.s1.booleanValue() ? 0 : this.c1, this.m1, this.s1.booleanValue());
            b.a.p0.a.j1.g.a aVar = new b.a.p0.a.j1.g.a(getContext(), dVar.a());
            this.R0 = aVar;
            this.E1.p(aVar);
            this.R0.v(new h(this));
            if (this.s1.booleanValue()) {
                this.R0.x(this.z1);
            }
            this.R0.o(dVar.a());
            this.R0.w(false);
        }
    }

    public final void i4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            DisplayMetrics displayMetrics = getActivity().getResources().getDisplayMetrics();
            int i2 = displayMetrics != null ? displayMetrics.widthPixels : 0;
            if (this.s1.booleanValue()) {
                float f2 = this.u1 / this.t1;
                this.A1 = i2;
                int i3 = (int) (i2 * f2);
                this.B1 = i3;
                this.d1 = (int) (i2 * this.x1);
                this.c1 = i3;
                this.C1 = (int) (i2 * this.y1);
                return;
            }
            this.c1 = (i2 * 9) / 16;
            this.d1 = i2;
        }
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [b.a.p0.a.p.e.c] */
    public final void j4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            b.a.p0.a.p.e.e l2 = l();
            this.I0 = l2;
            l2.a0(W2());
            this.J0 = this.I0.t();
            this.I0.loadUrl(this.P0);
            FrameLayout frameLayout = new FrameLayout(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            View covertToView = this.J0.covertToView();
            b.a.p0.a.d2.n.g gVar = new b.a.p0.a.d2.n.g();
            gVar.f4521e = SwanAppConfigData.t("#FFFFFF");
            this.I0.A(frameLayout, gVar);
            this.I0.Q(frameLayout, gVar);
            this.I0.k(frameLayout, covertToView);
            if (l4()) {
                e4(this.p1, frameLayout);
            } else {
                this.p1.addView(frameLayout);
            }
            WebViewContainer webViewContainer = this.p1;
            if (webViewContainer != null) {
                webViewContainer.setInternalWebView(this.J0);
            }
            if (n4()) {
                layoutParams.topMargin = this.s1.booleanValue() ? this.B1 : this.c1;
            }
            covertToView.setLayoutParams(layoutParams);
            this.T0.post(new k(this, covertToView));
        }
    }

    public final void k4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            b.a.p0.a.q.f.b bVar = new b.a.p0.a.q.f.b(getContext());
            this.E1 = bVar;
            bVar.o(n4() ? this.c1 : 0);
            WebViewContainer k2 = this.E1.k();
            this.p1 = k2;
            this.r1.addView(k2);
        }
    }

    @Override // b.a.p0.a.h0.g.l
    public b.a.p0.a.p.e.e l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            b.a.p0.a.q.e eVar = new b.a.p0.a.q.e(getContext());
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
                        if (SwanAppAdLandingFragment.P1) {
                            String str5 = "onDownloadStart: url=" + str + ", userAgent=" + str2 + ", mimeType=" + str4;
                        }
                        this.this$0.F1 = str;
                        this.this$0.Y3();
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
        return (b.a.p0.a.p.e.e) invokeV.objValue;
    }

    public final boolean l4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? TextUtils.equals("swan-custom-ad", this.U0) : invokeV.booleanValue;
    }

    public final boolean m4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? getActivity().getResources().getConfiguration().orientation == 2 : invokeV.booleanValue;
    }

    public final boolean n4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.Q0 == LandingType.VIDEO : invokeV.booleanValue;
    }

    public final boolean o4(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, view)) == null) {
            if (view == null || view.getVisibility() != 0) {
                return false;
            }
            return view.getGlobalVisibleRect(new Rect());
        }
        return invokeL.booleanValue;
    }

    @Override // b.a.p0.a.h0.g.l, com.baidu.swan.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, bundle) == null) {
            super.onCreate(bundle);
            p4();
            this.S0 = new b.a.p0.h.i.r.c(getContext(), this.l1);
            FragmentActivity activity = getActivity();
            if (activity != null) {
                boolean z = 1 == activity.getRequestedOrientation();
                this.o1 = z;
                if (!z) {
                    E2(1);
                }
            }
            if (P1) {
                String str = "onCreate() : " + this;
            }
        }
    }

    @Override // b.a.p0.a.h0.g.l, com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            if (n4()) {
                u4("vplayend");
            }
            b.a.p0.a.j1.g.a aVar = this.R0;
            if (aVar != null) {
                aVar.onDestroy();
            }
            if (!this.o1) {
                E2(0);
            }
            super.onDestroy();
        }
    }

    @Override // b.a.p0.a.h0.g.d, com.baidu.swan.support.v4.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            super.onPause();
            q4();
        }
    }

    @Override // b.a.p0.a.h0.g.d, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            super.onResume();
            b.a.p0.a.q.f.b bVar = this.E1;
            if (bVar == null || !bVar.l() || p0()) {
                return;
            }
            t4();
        }
    }

    public final void p4() {
        Bundle o2;
        String P;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048606, this) == null) || (o2 = o()) == null) {
            return;
        }
        this.P0 = o2.getString("url", "");
        if (TextUtils.isEmpty(this.L0)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(this.L0);
            this.k1 = jSONObject.optString("vurl", "");
            this.j1 = jSONObject.optString("w_picurl", "");
            this.h1 = jSONObject.optString("icon", "");
            int optInt = jSONObject.optInt("act", ActionType.LP.value());
            this.e1 = optInt;
            if (optInt == ActionType.DL.value()) {
                P = P(b.a.p0.a.h.swanapp_ad_download_button);
            } else {
                P = P(b.a.p0.a.h.swanapp_ad_landingpage_button);
            }
            this.f1 = P;
            this.g1 = jSONObject.optString("appname", "");
            this.m1 = jSONObject.optInt("currentTime", 0);
            this.l1 = jSONObject.optJSONObject("monitors");
            this.V0 = jSONObject.optString("url", "");
            this.W0 = jSONObject.optString("name", "");
            this.U0 = jSONObject.optString("from", "");
            this.i1 = jSONObject.optString("monitorUrl", "");
            this.t1 = jSONObject.optInt("w", 16);
            this.u1 = jSONObject.optInt("h", 9);
            this.v1 = jSONObject.optString("playingbg", "");
            this.w1 = jSONObject.optString("maskUrl", "");
            this.x1 = (float) jSONObject.optDouble("playerWidthRatio", 0.5d);
            this.y1 = (float) jSONObject.optDouble("rightMarginRatio", 0.0d);
            this.D1 = jSONObject.optString("horizontalCover", "");
            this.G1 = jSONObject.optString("costUrl", "");
        } catch (JSONException e2) {
            if (P1) {
                e2.printStackTrace();
            }
        }
        if (!TextUtils.isEmpty(this.k1)) {
            this.Q0 = LandingType.VIDEO;
        }
        this.s1 = Boolean.valueOf(TextUtils.equals("ad-video-portrait", this.U0));
    }

    public final void q4() {
        b.a.p0.a.j1.g.a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048607, this) == null) && (aVar = this.R0) != null && aVar.n()) {
            this.R0.p();
        }
    }

    public final void r4(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048608, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        b.a.p0.a.o2.g.h.a().putString(this.Z0.f45356a, str);
    }

    public final void s4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            this.p1.removeView(this.X0.getRealView());
            this.p1.removeView(this.H1);
        }
    }

    public final void t4() {
        b.a.p0.a.j1.g.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048610, this) == null) || (aVar = this.R0) == null || aVar.n() || this.R0.m()) {
            return;
        }
        this.R0.s();
    }

    public final void u4(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, str) == null) {
            HashMap<String, String> hashMap = new HashMap<>();
            b.a.p0.a.j1.g.a aVar = this.R0;
            if (aVar != null) {
                hashMap.put("cur_time", String.valueOf(aVar.e() / 1000));
            }
            b.a.p0.h.i.r.c cVar = this.S0;
            if (cVar != null) {
                cVar.d(str, hashMap);
            }
        }
    }

    public final void v4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            s4();
            this.p1.addView(this.H1);
            this.p1.addView(this.X0.getRealView());
        }
    }

    @Override // b.a.p0.a.h0.g.l, com.baidu.swan.support.v4.app.Fragment
    public View z0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048613, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(b.a.p0.a.g.aiapps_webview_fragment, viewGroup, false);
            R1(inflate);
            this.r1 = (ViewGroup) inflate.findViewById(b.a.p0.a.f.swan_app_webview_fragment);
            this.T0 = (FrameLayout) inflate.findViewById(b.a.p0.a.f.aiapps_webView_container);
            i4();
            k4();
            c4(this.p1);
            j4();
            if (n4()) {
                h4();
                g4();
            }
            if (Q1()) {
                inflate = T1(inflate);
            }
            u4("lpin");
            return A1(inflate, this);
        }
        return (View) invokeLLL.objValue;
    }
}
