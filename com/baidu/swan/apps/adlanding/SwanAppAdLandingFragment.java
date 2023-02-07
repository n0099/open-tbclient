package com.baidu.swan.apps.adlanding;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.browser.sailor.ISailorDownloadListener;
import com.baidu.swan.apps.adlanding.customer.CustomerAdScrollView;
import com.baidu.swan.apps.adlanding.customer.WebViewContainer;
import com.baidu.swan.apps.res.widget.toast.ToastLocation;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.view.SwanAppActionBar;
import com.baidu.swan.game.ad.component.AdImageVIew;
import com.baidu.swan.game.ad.downloader.model.DownloadParams;
import com.baidu.swan.game.ad.downloader.model.DownloadState;
import com.baidu.swan.support.v4.app.FragmentActivity;
import com.baidu.tieba.R;
import com.baidu.tieba.a83;
import com.baidu.tieba.ct2;
import com.baidu.tieba.cx3;
import com.baidu.tieba.ds2;
import com.baidu.tieba.eo3;
import com.baidu.tieba.ex3;
import com.baidu.tieba.fv1;
import com.baidu.tieba.fx3;
import com.baidu.tieba.gp1;
import com.baidu.tieba.gy3;
import com.baidu.tieba.ha2;
import com.baidu.tieba.hx3;
import com.baidu.tieba.ja2;
import com.baidu.tieba.k72;
import com.baidu.tieba.k82;
import com.baidu.tieba.ka2;
import com.baidu.tieba.kh3;
import com.baidu.tieba.l93;
import com.baidu.tieba.n93;
import com.baidu.tieba.nm3;
import com.baidu.tieba.o83;
import com.baidu.tieba.ox2;
import com.baidu.tieba.px2;
import com.baidu.tieba.qm3;
import com.baidu.tieba.rv1;
import com.baidu.tieba.sv1;
import com.baidu.tieba.tv1;
import com.baidu.tieba.ul3;
import com.baidu.tieba.uv1;
import com.baidu.tieba.vx3;
import com.baidu.tieba.w83;
import com.baidu.tieba.wx3;
import com.baidu.tieba.wy2;
import com.baidu.tieba.xw3;
import com.baidu.tieba.z73;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class SwanAppAdLandingFragment extends k82 implements hx3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean N1;
    public transient /* synthetic */ FieldHolder $fh;
    public int A1;
    public String B1;
    public uv1 C1;
    public String D1;
    public String E1;
    public TextView F1;
    public String G1;
    public a83 H1;
    public View I1;
    public String J1;
    public String K1;
    public fx3 L1;
    public View.OnClickListener M1;
    public String N0;
    public LandingType O0;
    public ox2 P0;
    public gy3 Q0;
    public FrameLayout R0;
    public String S0;
    public String T0;
    public String U0;
    public cx3 V0;
    public xw3 W0;
    public DownloadParams X0;
    public DownloadState Y0;
    public RelativeLayout Z0;
    public int a1;
    public int b1;
    public int c1;
    public String d1;
    public String e1;
    public String f1;
    public String g1;
    public String h1;
    public String i1;
    public JSONObject j1;
    public int k1;
    public int l1;
    public boolean m1;
    public WebViewContainer n1;
    public LinearLayout o1;
    public ViewGroup p1;
    public Boolean q1;
    public int r1;
    public int s1;
    public String t1;
    public String u1;
    public float v1;
    public float w1;
    public FrameLayout x1;
    public int y1;
    public int z1;

    @Override // com.baidu.tieba.k82, com.baidu.tieba.c82
    public boolean c2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes3.dex */
    public class a extends ha2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppAdLandingFragment c;

        /* renamed from: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0193a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String a;
            public final /* synthetic */ a b;

            public RunnableC0193a(a aVar, String str) {
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
                this.b = aVar;
                this.a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                String str;
                Interceptable interceptable = $ic;
                if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                    return;
                }
                SwanAppActionBar swanAppActionBar = this.b.c.f0;
                if (TextUtils.isEmpty(this.a)) {
                    str = "";
                } else {
                    str = this.a;
                }
                swanAppActionBar.setTitle(str);
            }
        }

        public a(SwanAppAdLandingFragment swanAppAdLandingFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppAdLandingFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = swanAppAdLandingFragment;
        }

        @Override // com.baidu.tieba.ha2, com.baidu.tieba.ka2
        public void d(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                SwanAppAdLandingFragment swanAppAdLandingFragment = this.c;
                swanAppAdLandingFragment.Z3(swanAppAdLandingFragment.H0.canGoBack());
                this.c.f0.post(new RunnableC0193a(this, str));
            }
        }

        @Override // com.baidu.tieba.ha2, com.baidu.tieba.ka2
        public boolean a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                if (n93.e(str) || n93.f(str)) {
                    try {
                        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                        w83 b0 = w83.b0();
                        if (b0 != null) {
                            b0.w().startActivity(intent);
                            return true;
                        }
                    } catch (Exception e) {
                        if (SwanAppAdLandingFragment.N1) {
                            e.printStackTrace();
                        }
                    }
                }
                return super.a(str);
            }
            return invokeL.booleanValue;
        }

        @Override // com.baidu.tieba.ha2, com.baidu.tieba.ka2
        public void e(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                super.e(str);
                if (!TextUtils.isEmpty(this.c.g1) && this.c.Q0 != null) {
                    this.c.Q0.e(this.c.g1);
                }
            }
        }

        @Override // com.baidu.tieba.ha2, com.baidu.tieba.ka2
        public void goBack() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                SwanAppAdLandingFragment swanAppAdLandingFragment = this.c;
                swanAppAdLandingFragment.Z3(swanAppAdLandingFragment.H0.canGoBack());
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
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

        public ActionType(String str, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.type = i2;
        }

        public static ActionType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (ActionType) Enum.valueOf(ActionType.class, str);
            }
            return (ActionType) invokeL.objValue;
        }

        public static ActionType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (ActionType[]) $VALUES.clone();
            }
            return (ActionType[]) invokeV.objValue;
        }

        public int value() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.type;
            }
            return invokeV.intValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
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
            LandingType landingType = new LandingType(HlsPlaylistParser.TYPE_VIDEO, 1);
            VIDEO = landingType;
            $VALUES = new LandingType[]{NORMAL, landingType};
        }

        public LandingType(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (LandingType) Enum.valueOf(LandingType.class, str);
            }
            return (LandingType) invokeL.objValue;
        }

        public static LandingType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (LandingType[]) $VALUES.clone();
            }
            return (LandingType[]) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppAdLandingFragment a;

        public b(SwanAppAdLandingFragment swanAppAdLandingFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppAdLandingFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = swanAppAdLandingFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                k82.Y2();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppAdLandingFragment a;

        public c(SwanAppAdLandingFragment swanAppAdLandingFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppAdLandingFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = swanAppAdLandingFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                o83 g = o83.g(this.a.getContext(), "第三方页面应用未经百度审核");
                g.p(ToastLocation.BOTTOM);
                g.G();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppAdLandingFragment a;

        public d(SwanAppAdLandingFragment swanAppAdLandingFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppAdLandingFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = swanAppAdLandingFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                k82.d3("adLanding", wy2.d(this.a.K1, this.a.K1));
                this.a.H1.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppAdLandingFragment a;

        public e(SwanAppAdLandingFragment swanAppAdLandingFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppAdLandingFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = swanAppAdLandingFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                k82.d3("adLanding", wy2.d(this.a.J1, this.a.J1));
                this.a.H1.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppAdLandingFragment a;

        public f(SwanAppAdLandingFragment swanAppAdLandingFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppAdLandingFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = swanAppAdLandingFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.H1.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppAdLandingFragment a;

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
            }
        }

        public g(SwanAppAdLandingFragment swanAppAdLandingFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppAdLandingFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = swanAppAdLandingFragment;
        }
    }

    /* loaded from: classes3.dex */
    public class h implements px2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppAdLandingFragment a;

        @Override // com.baidu.tieba.px2
        public void e(ct2 ct2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, ct2Var) == null) {
            }
        }

        @Override // com.baidu.tieba.px2
        public boolean f(ct2 ct2Var, int i, int i2) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(1048581, this, ct2Var, i, i2)) == null) {
                return false;
            }
            return invokeLII.booleanValue;
        }

        public h(SwanAppAdLandingFragment swanAppAdLandingFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppAdLandingFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = swanAppAdLandingFragment;
        }

        @Override // com.baidu.tieba.px2
        public void a(ct2 ct2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, ct2Var) != null) {
                return;
            }
            this.a.x4("vcontinueplay");
        }

        @Override // com.baidu.tieba.px2
        public void c(ct2 ct2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ct2Var) != null) {
                return;
            }
            this.a.x4("vpause");
        }

        @Override // com.baidu.tieba.px2
        public void b(ct2 ct2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ct2Var) == null) {
                this.a.Z0.bringToFront();
                this.a.Z0.setVisibility(0);
                this.a.k1 = 0;
                SwanAppAdLandingFragment.u3(this.a);
                this.a.x4("vplayend");
                this.a.x4("scard");
            }
        }

        @Override // com.baidu.tieba.px2
        public void d(ct2 ct2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, ct2Var) == null) {
                if (this.a.l1 != 0) {
                    this.a.Z0.setVisibility(8);
                    this.a.x4("vrepeatedplay");
                    return;
                }
                this.a.x4("vstart");
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppAdLandingFragment a;

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
            }
        }

        public i(SwanAppAdLandingFragment swanAppAdLandingFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppAdLandingFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = swanAppAdLandingFragment;
        }
    }

    /* loaded from: classes3.dex */
    public class j implements xw3 {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = swanAppAdLandingFragment;
        }

        @Override // com.baidu.tieba.xw3
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                this.a.V0.d(i);
            }
        }

        @Override // com.baidu.tieba.xw3
        public void d(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048579, this, str) != null) {
                return;
            }
            this.a.u4(str);
        }

        @Override // com.baidu.tieba.xw3
        public void f(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeZ(1048581, this, z) != null) || !this.a.G1.equals("1")) {
                return;
            }
            if (z) {
                this.a.y4();
            } else {
                this.a.v4();
            }
        }

        @Override // com.baidu.tieba.xw3
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) {
                return;
            }
            this.a.x4("appinstallbegin");
        }

        @Override // com.baidu.tieba.xw3
        public String e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeV = interceptable.invokeV(1048580, this)) != null) {
                return (String) invokeV.objValue;
            }
            this.a.x4("appinstallopen");
            SwanAppAdLandingFragment swanAppAdLandingFragment = this.a;
            return swanAppAdLandingFragment.a4(swanAppAdLandingFragment.X0.a);
        }

        @Override // com.baidu.tieba.xw3
        public void c(DownloadState downloadState, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, downloadState, i) == null) {
                this.a.V0.b(downloadState);
                if (this.a.Y0 == downloadState) {
                    return;
                }
                if (this.a.Y0 != DownloadState.NOT_START || downloadState != DownloadState.DOWNLOADING) {
                    if (downloadState != DownloadState.DOWNLOAD_PAUSED) {
                        if (this.a.Y0 != DownloadState.DOWNLOAD_PAUSED || downloadState != DownloadState.DOWNLOADING) {
                            if (downloadState != DownloadState.DOWNLOADED) {
                                if (downloadState == DownloadState.INSTALLED) {
                                    this.a.x4("appinstallfinish");
                                }
                            } else {
                                this.a.x4("appdownloadfinish");
                                this.a.x4("appinstallbegin");
                            }
                        } else {
                            this.a.x4("appdownloadcontinue");
                        }
                    } else {
                        this.a.x4("appdownloadpause");
                    }
                } else {
                    this.a.x4("appdownloadbegin");
                }
                this.a.Y0 = downloadState;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View a;
        public final /* synthetic */ SwanAppAdLandingFragment b;

        public k(SwanAppAdLandingFragment swanAppAdLandingFragment, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppAdLandingFragment, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = swanAppAdLandingFragment;
            this.a = view2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int height = this.b.R0.getHeight();
                if (this.b.q4() || this.b.o4()) {
                    ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
                    layoutParams.height = height;
                    this.a.setLayoutParams(layoutParams);
                }
                if (this.b.q4()) {
                    ViewGroup.LayoutParams layoutParams2 = this.b.n1.getLayoutParams();
                    layoutParams2.height = height + (this.b.q1.booleanValue() ? this.b.z1 : this.b.a1);
                    this.b.n1.setLayoutParams(layoutParams2);
                }
                this.b.p1.removeView(this.b.R0);
                if (this.b.o1 != null) {
                    this.b.o1.setVisibility(0);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class l implements ja2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CustomerAdScrollView a;
        public final /* synthetic */ SwanAppAdLandingFragment b;

        public l(SwanAppAdLandingFragment swanAppAdLandingFragment, CustomerAdScrollView customerAdScrollView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppAdLandingFragment, customerAdScrollView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = swanAppAdLandingFragment;
            this.a = customerAdScrollView;
        }

        @Override // com.baidu.tieba.ja2
        public void onScrollChanged(int i, int i2, int i3, int i4) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIII(1048576, this, i, i2, i3, i4) == null) {
                float contentHeight = ((this.b.H0.getContentHeight() * this.b.H0.getScale()) - this.b.H0.covertToView().getHeight()) - this.b.H0.getWebViewScrollY();
                CustomerAdScrollView customerAdScrollView = this.a;
                if (contentHeight < 10.0f) {
                    z = true;
                } else {
                    z = false;
                }
                customerAdScrollView.setIsWebViewOnBottom(z);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class m extends k72 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CustomerAdScrollView a;
        public final /* synthetic */ SwanAppAdLandingFragment b;

        public m(SwanAppAdLandingFragment swanAppAdLandingFragment, CustomerAdScrollView customerAdScrollView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppAdLandingFragment, customerAdScrollView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = swanAppAdLandingFragment;
            this.a = customerAdScrollView;
        }

        @Override // com.baidu.tieba.k72
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                super.a(str);
                if (Math.abs((this.b.H0.getContentHeight() * this.b.H0.getScale()) - this.b.H0.covertToView().getHeight()) < 10.0f) {
                    this.a.setIsWebViewOnBottom(true);
                } else {
                    this.a.setIsWebViewOnBottom(false);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class n implements tv1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CustomerAdScrollView a;
        public final /* synthetic */ SwanAppAdLandingFragment b;

        public n(SwanAppAdLandingFragment swanAppAdLandingFragment, CustomerAdScrollView customerAdScrollView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppAdLandingFragment, customerAdScrollView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = swanAppAdLandingFragment;
            this.a = customerAdScrollView;
        }

        @Override // com.baidu.tieba.tv1
        public void onScrollChanged(int i, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIII(1048576, this, i, i2, i3, i4) == null) {
                CustomerAdScrollView customerAdScrollView = this.a;
                SwanAppAdLandingFragment swanAppAdLandingFragment = this.b;
                customerAdScrollView.setIsFooterLayoutShow(swanAppAdLandingFragment.r4(swanAppAdLandingFragment.o1));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class o implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppAdLandingFragment a;

        public o(SwanAppAdLandingFragment swanAppAdLandingFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppAdLandingFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = swanAppAdLandingFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                int id = view2.getId();
                HashMap<String, String> hashMap = new HashMap<>();
                if (id == R.id.obfuscated_res_0x7f0900fe) {
                    hashMap.put("da_area", "tail_icon");
                } else if (id == R.id.obfuscated_res_0x7f0900fb) {
                    hashMap.put("da_area", "tail_name");
                } else if (id == R.id.obfuscated_res_0x7f0900fc) {
                    if (this.a.c1 == ActionType.DL.value()) {
                        str = "tail_downloadbtn";
                    } else {
                        str = "tail_detailbtn";
                    }
                    hashMap.put("da_area", str);
                }
                if (this.a.Q0 != null) {
                    this.a.Q0.d("c", hashMap);
                }
                k82.d3("adLanding", wy2.d(this.a.N0, this.a.N0));
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
        N1 = gp1.a;
    }

    @Override // com.baidu.tieba.k82, com.baidu.tieba.c82
    public boolean J() {
        InterceptResult invokeV;
        ox2 ox2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (p4() && (ox2Var = this.P0) != null) {
                return ox2Var.onBackPressed();
            }
            x4("lpout");
            return super.J();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.k82
    public ka2 Z2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return new a(this);
        }
        return (ka2) invokeV.objValue;
    }

    public final void d4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            qm3.e0(new c(this));
        }
    }

    @Override // com.baidu.tieba.k82
    public fv1 k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            sv1 sv1Var = new sv1(getContext());
            sv1Var.r().setDownloadListener(new ISailorDownloadListener(this) { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ SwanAppAdLandingFragment this$0;

                @Override // com.baidu.browser.sailor.ISailorDownloadListener
                public void onDownloadFlash(String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, str) == null) {
                    }
                }

                @Override // com.baidu.browser.sailor.ISailorDownloadListener
                public void onPlayVideo(String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                    }
                }

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
                public void onDownloadStart(String str, String str2, String str3, String str4, long j2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, str2, str3, str4, Long.valueOf(j2)}) == null) {
                        if (SwanAppAdLandingFragment.N1) {
                            Log.d("SwanAppAdLandFragment", "onDownloadStart: url=" + str + ", userAgent=" + str2 + ", mimeType=" + str4);
                        }
                        this.this$0.D1 = str;
                        this.this$0.b4();
                    }
                }
            });
            return sv1Var;
        }
        return (fv1) invokeV.objValue;
    }

    public final boolean o4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return TextUtils.equals("swan-custom-ad", this.S0);
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.c82, com.baidu.swan.support.v4.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            super.onPause();
            t4();
        }
    }

    @Override // com.baidu.tieba.c82, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            super.onResume();
            uv1 uv1Var = this.C1;
            if (uv1Var != null && uv1Var.l() && !m0()) {
                w4();
            }
        }
    }

    public final boolean p4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            if (getActivity().getResources().getConfiguration().orientation == 2) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean q4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            if (this.O0 == LandingType.VIDEO) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void t4() {
        ox2 ox2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048605, this) == null) && (ox2Var = this.P0) != null && ox2Var.n()) {
            this.P0.p();
        }
    }

    public final void v4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            this.n1.removeView(this.V0.getRealView());
            this.n1.removeView(this.F1);
        }
    }

    public final void w4() {
        ox2 ox2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048609, this) == null) && (ox2Var = this.P0) != null && !ox2Var.n() && !this.P0.m()) {
            this.P0.s();
        }
    }

    @Override // com.baidu.tieba.k82, com.baidu.swan.support.v4.app.Fragment
    public void y0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            if (q4()) {
                x4("vplayend");
            }
            ox2 ox2Var = this.P0;
            if (ox2Var != null) {
                ox2Var.onDestroy();
            }
            if (!this.m1) {
                H2(0);
            }
            super.y0();
        }
    }

    public final void y4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            v4();
            this.n1.addView(this.F1);
            this.n1.addView(this.V0.getRealView());
        }
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
        this.O0 = LandingType.NORMAL;
        this.S0 = "";
        this.T0 = "";
        this.U0 = "";
        this.Y0 = DownloadState.NOT_START;
        this.j1 = new JSONObject();
        this.k1 = 0;
        this.l1 = 0;
        this.m1 = true;
        this.q1 = Boolean.FALSE;
        this.H1 = null;
        this.L1 = null;
        this.M1 = new o(this);
    }

    public final void b4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            fx3 fx3Var = this.L1;
            if (fx3Var != null) {
                i(fx3Var);
                return;
            }
            vx3 vx3Var = new vx3(getContext());
            vx3Var.d(this);
            wx3 wx3Var = new wx3(getContext());
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("charge_url", this.E1);
                jSONObject.put("apk_url", this.D1);
                jSONObject.put("ssl", 1);
            } catch (JSONException e2) {
                if (N1) {
                    e2.printStackTrace();
                }
            }
            vx3Var.c(wx3Var, jSONObject);
        }
    }

    public final void l4() {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            DisplayMetrics displayMetrics = getActivity().getResources().getDisplayMetrics();
            if (displayMetrics != null) {
                i2 = displayMetrics.widthPixels;
            } else {
                i2 = 0;
            }
            if (this.q1.booleanValue()) {
                float f2 = this.s1 / this.r1;
                this.y1 = i2;
                int i3 = (int) (i2 * f2);
                this.z1 = i3;
                this.b1 = (int) (i2 * this.v1);
                this.a1 = i3;
                this.A1 = (int) (i2 * this.w1);
                return;
            }
            this.a1 = (i2 * 9) / 16;
            this.b1 = i2;
        }
    }

    public static /* synthetic */ int u3(SwanAppAdLandingFragment swanAppAdLandingFragment) {
        int i2 = swanAppAdLandingFragment.l1;
        swanAppAdLandingFragment.l1 = i2 + 1;
        return i2;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void C0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            super.C0(z);
            if (z) {
                t4();
            } else {
                w4();
            }
        }
    }

    @Override // com.baidu.tieba.k82, com.baidu.tieba.c82
    public void U1(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) {
            super.U1(view2);
            this.f0.setLeftHomeViewSrc(R.drawable.obfuscated_res_0x7f080109);
            this.f0.setLeftHomeViewClickListener(new b(this));
        }
    }

    public final void Z3(boolean z) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            SwanAppActionBar swanAppActionBar = this.f0;
            if (z) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            swanAppActionBar.setLeftHomeViewVisibility(i2);
        }
    }

    public final String a4(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            return kh3.a().getString(str, "");
        }
        return (String) invokeL.objValue;
    }

    public final boolean r4(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, view2)) == null) {
            if (view2 != null && view2.getVisibility() == 0) {
                return view2.getGlobalVisibleRect(new Rect());
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void u4(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048607, this, str) == null) && !TextUtils.isEmpty(str)) {
            kh3.a().putString(this.X0.a, str);
        }
    }

    public final void x4(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, str) == null) {
            HashMap<String, String> hashMap = new HashMap<>();
            ox2 ox2Var = this.P0;
            if (ox2Var != null) {
                hashMap.put("cur_time", String.valueOf(ox2Var.e() / 1000));
            }
            gy3 gy3Var = this.Q0;
            if (gy3Var != null) {
                gy3Var.d(str, hashMap);
            }
        }
    }

    public final void c4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.V0.f();
            if (TextUtils.isEmpty(this.X0.b)) {
                String a4 = a4(this.D1);
                this.X0.b = a4;
                this.V0.a(a4);
            }
            if (qm3.F(getContext(), this.X0.b)) {
                y4();
                this.V0.b(DownloadState.INSTALLED);
                return;
            }
            if (TextUtils.isEmpty(this.X0.a)) {
                this.X0.a = this.D1;
            }
            ds2.d().d(getContext(), this.X0.a(), DownloadParams.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.W0);
        }
    }

    public final void i4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d0845, (ViewGroup) null);
            this.n1.addView(relativeLayout, new FrameLayout.LayoutParams(-1, this.z1));
            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) relativeLayout.findViewById(R.id.obfuscated_res_0x7f0900ca);
            SimpleDraweeView simpleDraweeView2 = (SimpleDraweeView) relativeLayout.findViewById(R.id.obfuscated_res_0x7f0900d7);
            this.x1 = (FrameLayout) relativeLayout.findViewById(R.id.obfuscated_res_0x7f0900d8);
            if (!TextUtils.isEmpty(this.t1)) {
                simpleDraweeView.setImageURI(Uri.parse(this.t1));
                simpleDraweeView.setOnClickListener(this.M1);
            } else {
                simpleDraweeView.setVisibility(4);
            }
            if (!TextUtils.isEmpty(this.u1)) {
                simpleDraweeView2.setImageURI(Uri.parse(this.u1));
            } else {
                simpleDraweeView2.setVisibility(4);
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.x1.getLayoutParams();
            layoutParams.width = this.b1;
            layoutParams.height = this.a1;
            layoutParams.rightMargin = this.A1;
            this.x1.setLayoutParams(layoutParams);
        }
    }

    public final void k4() {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            if (this.q1.booleanValue()) {
                i4();
            }
            if (this.q1.booleanValue()) {
                i2 = 0;
            } else {
                i2 = this.b1;
            }
            if (this.q1.booleanValue()) {
                i3 = 0;
            } else {
                i3 = this.a1;
            }
            rv1 rv1Var = new rv1(this.h1, this.i1, this.G0.a(), i2, i3, this.k1, this.q1.booleanValue());
            ox2 ox2Var = new ox2(getContext(), rv1Var.a());
            this.P0 = ox2Var;
            this.C1.p(ox2Var);
            this.P0.v(new h(this));
            if (this.q1.booleanValue()) {
                this.P0.x(this.x1);
            }
            this.P0.o(rv1Var.a());
            this.P0.w(false);
        }
    }

    public final void e4(fx3 fx3Var, boolean z) {
        float f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048586, this, fx3Var, z) == null) {
            a83 a83Var = this.H1;
            if (a83Var != null) {
                a83Var.show();
                return;
            }
            ((ViewGroup) this.I1.findViewById(R.id.obfuscated_res_0x7f0900cd)).addView(this.V0.getRealView());
            ((AdImageVIew) this.I1.findViewById(R.id.obfuscated_res_0x7f0900cf)).setImageUrl(fx3Var.g());
            ((TextView) this.I1.findViewById(R.id.obfuscated_res_0x7f0900cc)).setText(fx3Var.c());
            ((TextView) this.I1.findViewById(R.id.obfuscated_res_0x7f0900d4)).setText(fx3Var.d());
            ((TextView) this.I1.findViewById(R.id.obfuscated_res_0x7f0900cb)).setText(fx3Var.a());
            ((TextView) this.I1.findViewById(R.id.obfuscated_res_0x7f0900d6)).setText(fx3Var.j());
            TextView textView = (TextView) this.I1.findViewById(R.id.obfuscated_res_0x7f0900ce);
            if (!z) {
                textView.setText(fx3Var.e());
                textView.setVisibility(0);
            }
            this.J1 = fx3Var.h();
            this.K1 = fx3Var.i();
            ViewGroup.LayoutParams layoutParams = this.V0.getRealView().getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(-1, -2);
                this.V0.getRealView().setLayoutParams(layoutParams);
            }
            int o2 = nm3.o(getContext());
            float l2 = nm3.l(getContext());
            layoutParams.width = o2 - (((int) ((10.0f * l2) + 0.5f)) * 2);
            if (TextUtils.isEmpty(this.X0.b)) {
                String a4 = a4(fx3Var.b());
                this.X0.b = a4;
                this.V0.a(a4);
            }
            if (qm3.F(getContext(), this.X0.b)) {
                this.V0.b(DownloadState.INSTALLED);
            }
            if (TextUtils.isEmpty(this.X0.a)) {
                this.X0.a = fx3Var.b();
            }
            this.V0.e(this.X0);
            z73 z73Var = new z73(getContext());
            z73Var.i(true);
            z73Var.k(false);
            z73Var.T(false);
            z73Var.m(false);
            z73Var.t(false);
            z73Var.n(new eo3());
            z73Var.p(R.drawable.obfuscated_res_0x7f080125);
            z73Var.F(R.color.obfuscated_res_0x7f060a74);
            z73Var.K(new g(this));
            z73Var.W(this.I1);
            z73Var.j();
            if (z) {
                f2 = 225.0f;
            } else {
                f2 = 250.0f;
            }
            z73Var.q((int) (l2 * f2));
            a83 c2 = z73Var.c();
            this.H1 = c2;
            Window window = c2.getWindow();
            if (window != null) {
                window.setGravity(80);
                window.setDimAmount(0.65f);
                window.setLayout(nm3.s(getContext()), -2);
                window.setWindowAnimations(R.style.obfuscated_res_0x7f10039d);
            }
            this.H1.a(false);
            this.H1.setCanceledOnTouchOutside(true);
            this.H1.show();
        }
    }

    public final void f4(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, viewGroup) == null) {
            this.W0 = new j(this);
            this.X0 = new DownloadParams(this.T0, this.U0);
            ex3 ex3Var = new ex3();
            ex3Var.l(getContext(), this.X0, this.W0);
            this.V0 = ex3Var;
            ex3Var.e(this.X0);
            g4();
        }
    }

    public final void g4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            View inflate = View.inflate(getContext(), R.layout.obfuscated_res_0x7f0d0093, null);
            this.I1 = inflate;
            ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0900d3)).setOnClickListener(new d(this));
            ((TextView) this.I1.findViewById(R.id.obfuscated_res_0x7f0900d2)).setOnClickListener(new e(this));
            ((ImageView) this.I1.findViewById(R.id.obfuscated_res_0x7f09068d)).setOnClickListener(new f(this));
            TextView textView = new TextView(getContext());
            this.F1 = textView;
            textView.setText("温馨提示：您已访问至第三方页面");
            this.F1.setTextColor(-16777216);
            GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{0, -1});
            gradientDrawable.setShape(0);
            this.F1.setBackground(gradientDrawable);
            this.F1.getBackground().setAlpha(180);
            this.F1.setPadding(0, 0, 0, 10);
            this.F1.setGravity(80);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, 260);
            layoutParams.gravity = 81;
            layoutParams.bottomMargin = ((int) (getContext().getResources().getDisplayMetrics().heightPixels * 0.14d)) - 80;
            this.F1.setLayoutParams(layoutParams);
            this.F1.setGravity(81);
        }
    }

    public final void j4() {
        int i2;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d0846, (ViewGroup) null);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            if (this.q1.booleanValue()) {
                i2 = this.z1;
            } else {
                i2 = this.a1;
            }
            layoutParams.height = i2;
            this.Z0 = (RelativeLayout) relativeLayout.findViewById(R.id.obfuscated_res_0x7f0900ff);
            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) relativeLayout.findViewById(R.id.obfuscated_res_0x7f090100);
            SimpleDraweeView simpleDraweeView2 = (SimpleDraweeView) relativeLayout.findViewById(R.id.obfuscated_res_0x7f0900fe);
            TextView textView = (TextView) relativeLayout.findViewById(R.id.obfuscated_res_0x7f0900fb);
            TextView textView2 = (TextView) relativeLayout.findViewById(R.id.obfuscated_res_0x7f0900fc);
            if (!TextUtils.isEmpty(this.d1)) {
                textView2.setText(this.d1);
                textView2.setVisibility(0);
            } else {
                textView2.setVisibility(8);
            }
            if (!TextUtils.isEmpty(this.e1)) {
                textView.setText(this.e1);
                textView.setVisibility(0);
            } else {
                textView.setVisibility(4);
            }
            if (!TextUtils.isEmpty(this.f1)) {
                simpleDraweeView2.setImageURI(Uri.parse(this.f1));
                simpleDraweeView2.setVisibility(0);
            } else {
                simpleDraweeView2.setVisibility(8);
            }
            simpleDraweeView.getHierarchy().setPlaceholderImage(getResources().getDrawable(R.drawable.obfuscated_res_0x7f0811e7));
            if (this.q1.booleanValue()) {
                str = this.B1;
            } else {
                str = this.h1;
            }
            if (!TextUtils.isEmpty(str)) {
                simpleDraweeView.setImageURI(ul3.m(str));
            }
            simpleDraweeView.setVisibility(0);
            simpleDraweeView.setOnClickListener(new i(this));
            simpleDraweeView2.setOnClickListener(this.M1);
            textView.setOnClickListener(this.M1);
            textView2.setOnClickListener(this.M1);
            this.n1.addView(this.Z0, layoutParams);
            this.Z0.setVisibility(4);
        }
    }

    public final void s4() {
        Bundle p;
        String G;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048604, this) != null) || (p = p()) == null) {
            return;
        }
        this.N0 = p.getString("url", "");
        if (TextUtils.isEmpty(this.J0)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(this.J0);
            this.i1 = jSONObject.optString("vurl", "");
            this.h1 = jSONObject.optString("w_picurl", "");
            this.f1 = jSONObject.optString("icon", "");
            int optInt = jSONObject.optInt("act", ActionType.LP.value());
            this.c1 = optInt;
            if (optInt == ActionType.DL.value()) {
                G = G(R.string.obfuscated_res_0x7f0f1342);
            } else {
                G = G(R.string.obfuscated_res_0x7f0f134b);
            }
            this.d1 = G;
            this.e1 = jSONObject.optString("appname", "");
            this.k1 = jSONObject.optInt("currentTime", 0);
            this.j1 = jSONObject.optJSONObject("monitors");
            this.T0 = jSONObject.optString("url", "");
            this.U0 = jSONObject.optString("name", "");
            this.S0 = jSONObject.optString("from", "");
            this.g1 = jSONObject.optString("monitorUrl", "");
            this.r1 = jSONObject.optInt("w", 16);
            this.s1 = jSONObject.optInt("h", 9);
            this.t1 = jSONObject.optString("playingbg", "");
            this.u1 = jSONObject.optString("maskUrl", "");
            this.v1 = (float) jSONObject.optDouble("playerWidthRatio", 0.5d);
            this.w1 = (float) jSONObject.optDouble("rightMarginRatio", 0.0d);
            this.B1 = jSONObject.optString("horizontalCover", "");
            this.E1 = jSONObject.optString("costUrl", "");
        } catch (JSONException e2) {
            if (N1) {
                e2.printStackTrace();
            }
        }
        if (!TextUtils.isEmpty(this.i1)) {
            this.O0 = LandingType.VIDEO;
        }
        this.q1 = Boolean.valueOf(TextUtils.equals("ad-video-portrait", this.S0));
    }

    public final void h4(ViewGroup viewGroup, ViewGroup viewGroup2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, viewGroup, viewGroup2) == null) {
            this.o1 = (LinearLayout) ((LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d0844, (ViewGroup) null)).findViewById(R.id.obfuscated_res_0x7f0900a4);
            CustomerAdScrollView customerAdScrollView = new CustomerAdScrollView(getContext());
            LinearLayout linearLayout = new LinearLayout(getContext());
            linearLayout.setOrientation(1);
            linearLayout.addView(viewGroup2, new LinearLayout.LayoutParams(-1, -2));
            linearLayout.addView(this.o1, new LinearLayout.LayoutParams(-1, getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0706a9)));
            customerAdScrollView.addView(linearLayout, new LinearLayout.LayoutParams(-1, -2));
            viewGroup.addView(customerAdScrollView);
            this.G0.t(new l(this, customerAdScrollView));
            this.G0.b(new m(this, customerAdScrollView));
            customerAdScrollView.setScrollViewListener(new n(this, customerAdScrollView));
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.baidu.tieba.hx3
    public void i(fx3 fx3Var) {
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, fx3Var) == null) {
            this.L1 = fx3Var;
            String f2 = fx3Var.f();
            this.G1 = f2;
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
            if (c2 != 0) {
                if (c2 != 1) {
                    if (c2 != 2) {
                        if (c2 == 3) {
                            d4();
                            return;
                        }
                        return;
                    }
                    e4(fx3Var, false);
                    return;
                }
                e4(fx3Var, true);
                return;
            }
            c4();
        }
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [com.baidu.tieba.dv1] */
    public final void m4() {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            fv1 k2 = k();
            this.G0 = k2;
            k2.Y(Z2());
            this.H0 = this.G0.r();
            this.G0.loadUrl(this.N0);
            FrameLayout frameLayout = new FrameLayout(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            View covertToView = this.H0.covertToView();
            l93 l93Var = new l93();
            l93Var.e = SwanAppConfigData.t("#FFFFFF");
            this.G0.z(frameLayout, l93Var);
            this.G0.O(frameLayout, l93Var);
            this.G0.j(frameLayout, covertToView);
            if (o4()) {
                h4(this.n1, frameLayout);
            } else {
                this.n1.addView(frameLayout);
            }
            WebViewContainer webViewContainer = this.n1;
            if (webViewContainer != null) {
                webViewContainer.setInternalWebView(this.H0);
            }
            if (q4()) {
                if (this.q1.booleanValue()) {
                    i2 = this.z1;
                } else {
                    i2 = this.a1;
                }
                layoutParams.topMargin = i2;
            }
            covertToView.setLayoutParams(layoutParams);
            this.R0.post(new k(this, covertToView));
        }
    }

    public final void n4() {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            uv1 uv1Var = new uv1(getContext());
            this.C1 = uv1Var;
            if (q4()) {
                i2 = this.a1;
            } else {
                i2 = 0;
            }
            uv1Var.o(i2);
            WebViewContainer k2 = this.C1.k();
            this.n1 = k2;
            this.p1.addView(k2);
        }
    }

    @Override // com.baidu.tieba.k82, com.baidu.swan.support.v4.app.Fragment
    public void u0(Bundle bundle) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, bundle) == null) {
            super.u0(bundle);
            s4();
            this.Q0 = new gy3(getContext(), this.j1);
            FragmentActivity activity = getActivity();
            if (activity != null) {
                if (1 == activity.getRequestedOrientation()) {
                    z = true;
                } else {
                    z = false;
                }
                this.m1 = z;
                if (!z) {
                    H2(1);
                }
            }
            if (N1) {
                Log.d("SwanAppAdLandFragment", "onCreate() : " + this);
            }
        }
    }

    @Override // com.baidu.tieba.k82, com.baidu.swan.support.v4.app.Fragment
    public View x0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048610, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d00dd, viewGroup, false);
            U1(inflate);
            this.p1 = (ViewGroup) inflate.findViewById(R.id.obfuscated_res_0x7f0920cd);
            this.R0 = (FrameLayout) inflate.findViewById(R.id.obfuscated_res_0x7f0901a8);
            l4();
            n4();
            f4(this.n1);
            m4();
            if (q4()) {
                k4();
                j4();
            }
            if (T1()) {
                inflate = W1(inflate);
            }
            x4("lpin");
            return D1(inflate, this);
        }
        return (View) invokeLLL.objValue;
    }
}
