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
import com.baidu.swan.game.ad.component.AdImageVIew;
import com.baidu.swan.game.ad.downloader.model.DownloadParams;
import com.baidu.swan.game.ad.downloader.model.DownloadState;
import com.baidu.swan.support.v4.app.FragmentActivity;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser;
import com.repackage.ao2;
import com.repackage.bd3;
import com.repackage.cm1;
import com.repackage.dm1;
import com.repackage.em1;
import com.repackage.fc3;
import com.repackage.fm1;
import com.repackage.fo3;
import com.repackage.go3;
import com.repackage.hn3;
import com.repackage.hp2;
import com.repackage.hz2;
import com.repackage.ky2;
import com.repackage.ly2;
import com.repackage.mn3;
import com.repackage.nj2;
import com.repackage.oi2;
import com.repackage.on3;
import com.repackage.pe3;
import com.repackage.pn3;
import com.repackage.ql1;
import com.repackage.qo3;
import com.repackage.rf1;
import com.repackage.rn3;
import com.repackage.s02;
import com.repackage.u02;
import com.repackage.v02;
import com.repackage.v73;
import com.repackage.vx1;
import com.repackage.vy1;
import com.repackage.wz2;
import com.repackage.yc3;
import com.repackage.yz2;
import com.repackage.zn2;
import com.repackage.zy2;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class SwanAppAdLandingFragment extends vy1 implements rn3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean M1;
    public transient /* synthetic */ FieldHolder $fh;
    public String A1;
    public fm1 B1;
    public String C1;
    public String D1;
    public TextView E1;
    public String F1;
    public ly2 G1;
    public View H1;
    public String I1;
    public String J1;
    public pn3 K1;
    public View.OnClickListener L1;
    public String M0;
    public LandingType N0;
    public zn2 O0;
    public qo3 P0;
    public FrameLayout Q0;
    public String R0;
    public String S0;
    public String T0;
    public mn3 U0;
    public hn3 V0;
    public DownloadParams W0;
    public DownloadState X0;
    public RelativeLayout Y0;
    public int Z0;
    public int a1;
    public int b1;
    public String c1;
    public String d1;
    public String e1;
    public String f1;
    public String g1;
    public String h1;
    public JSONObject i1;
    public int j1;
    public int k1;
    public boolean l1;
    public WebViewContainer m1;
    public LinearLayout n1;
    public ViewGroup o1;
    public Boolean p1;
    public int q1;
    public int r1;
    public String s1;
    public String t1;
    public float u1;
    public float v1;
    public FrameLayout w1;
    public int x1;
    public int y1;
    public int z1;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
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
    /* loaded from: classes2.dex */
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
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (LandingType) Enum.valueOf(LandingType.class, str) : (LandingType) invokeL.objValue;
        }

        public static LandingType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (LandingType[]) $VALUES.clone() : (LandingType[]) invokeV.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public class a extends s02 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppAdLandingFragment c;

        /* renamed from: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC0154a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String a;
            public final /* synthetic */ a b;

            public RunnableC0154a(a aVar, String str) {
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
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.b.c.l0.setTitle(TextUtils.isEmpty(this.a) ? "" : this.a);
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

        @Override // com.repackage.s02, com.repackage.v02
        public boolean b(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                if (yz2.e(str) || yz2.f(str)) {
                    try {
                        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                        hz2 a0 = hz2.a0();
                        if (a0 != null) {
                            a0.x().startActivity(intent);
                            return true;
                        }
                    } catch (Exception e) {
                        if (SwanAppAdLandingFragment.M1) {
                            e.printStackTrace();
                        }
                    }
                }
                return super.b(str);
            }
            return invokeL.booleanValue;
        }

        @Override // com.repackage.s02, com.repackage.v02
        public void d(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                SwanAppAdLandingFragment swanAppAdLandingFragment = this.c;
                swanAppAdLandingFragment.Y3(swanAppAdLandingFragment.G0.canGoBack());
                this.c.l0.post(new RunnableC0154a(this, str));
            }
        }

        @Override // com.repackage.s02, com.repackage.v02
        public void e(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                super.e(str);
                if (TextUtils.isEmpty(this.c.f1) || this.c.P0 == null) {
                    return;
                }
                this.c.P0.e(this.c.f1);
            }
        }

        @Override // com.repackage.s02, com.repackage.v02
        public void goBack() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                SwanAppAdLandingFragment swanAppAdLandingFragment = this.c;
                swanAppAdLandingFragment.Y3(swanAppAdLandingFragment.G0.canGoBack());
            }
        }
    }

    /* loaded from: classes2.dex */
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
                vy1.X2();
            }
        }
    }

    /* loaded from: classes2.dex */
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
                zy2 g = zy2.g(this.a.getContext(), "第三方页面应用未经百度审核");
                g.p(ToastLocation.BOTTOM);
                g.G();
            }
        }
    }

    /* loaded from: classes2.dex */
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
                vy1.c3("adLanding", hp2.d(this.a.J1, this.a.J1));
                this.a.G1.dismiss();
            }
        }
    }

    /* loaded from: classes2.dex */
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
                vy1.c3("adLanding", hp2.d(this.a.I1, this.a.I1));
                this.a.G1.dismiss();
            }
        }
    }

    /* loaded from: classes2.dex */
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
                this.a.G1.dismiss();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class g implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppAdLandingFragment a;

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

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public class h implements ao2 {
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

        @Override // com.repackage.ao2
        public void a(nj2 nj2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nj2Var) == null) {
                this.a.w4("vcontinueplay");
            }
        }

        @Override // com.repackage.ao2
        public void b(nj2 nj2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, nj2Var) == null) {
                this.a.Y0.bringToFront();
                this.a.Y0.setVisibility(0);
                this.a.j1 = 0;
                SwanAppAdLandingFragment.t3(this.a);
                this.a.w4("vplayend");
                this.a.w4("scard");
            }
        }

        @Override // com.repackage.ao2
        public void c(nj2 nj2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, nj2Var) == null) {
                this.a.w4("vpause");
            }
        }

        @Override // com.repackage.ao2
        public void d(nj2 nj2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, nj2Var) == null) {
                if (this.a.k1 == 0) {
                    this.a.w4("vstart");
                    return;
                }
                this.a.Y0.setVisibility(8);
                this.a.w4("vrepeatedplay");
            }
        }

        @Override // com.repackage.ao2
        public void e(nj2 nj2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, nj2Var) == null) {
            }
        }

        @Override // com.repackage.ao2
        public boolean f(nj2 nj2Var, int i, int i2) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(1048581, this, nj2Var, i, i2)) == null) {
                return false;
            }
            return invokeLII.booleanValue;
        }
    }

    /* loaded from: classes2.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppAdLandingFragment a;

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

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public class j implements hn3 {
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

        @Override // com.repackage.hn3
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                this.a.U0.d(i);
            }
        }

        @Override // com.repackage.hn3
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.w4("appinstallbegin");
            }
        }

        @Override // com.repackage.hn3
        public void c(DownloadState downloadState, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, downloadState, i) == null) {
                this.a.U0.b(downloadState);
                if (this.a.X0 == downloadState) {
                    return;
                }
                if (this.a.X0 == DownloadState.NOT_START && downloadState == DownloadState.DOWNLOADING) {
                    this.a.w4("appdownloadbegin");
                } else if (downloadState == DownloadState.DOWNLOAD_PAUSED) {
                    this.a.w4("appdownloadpause");
                } else if (this.a.X0 == DownloadState.DOWNLOAD_PAUSED && downloadState == DownloadState.DOWNLOADING) {
                    this.a.w4("appdownloadcontinue");
                } else if (downloadState == DownloadState.DOWNLOADED) {
                    this.a.w4("appdownloadfinish");
                    this.a.w4("appinstallbegin");
                } else if (downloadState == DownloadState.INSTALLED) {
                    this.a.w4("appinstallfinish");
                }
                this.a.X0 = downloadState;
            }
        }

        @Override // com.repackage.hn3
        public void d(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                this.a.t4(str);
            }
        }

        @Override // com.repackage.hn3
        public String e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                this.a.w4("appinstallopen");
                SwanAppAdLandingFragment swanAppAdLandingFragment = this.a;
                return swanAppAdLandingFragment.Z3(swanAppAdLandingFragment.W0.a);
            }
            return (String) invokeV.objValue;
        }

        @Override // com.repackage.hn3
        public void f(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048581, this, z) == null) && this.a.F1.equals("1")) {
                if (z) {
                    this.a.x4();
                } else {
                    this.a.u4();
                }
            }
        }
    }

    /* loaded from: classes2.dex */
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
                int height = this.b.Q0.getHeight();
                if (this.b.p4() || this.b.n4()) {
                    ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
                    layoutParams.height = height;
                    this.a.setLayoutParams(layoutParams);
                }
                if (this.b.p4()) {
                    ViewGroup.LayoutParams layoutParams2 = this.b.m1.getLayoutParams();
                    layoutParams2.height = height + (this.b.p1.booleanValue() ? this.b.y1 : this.b.Z0);
                    this.b.m1.setLayoutParams(layoutParams2);
                }
                this.b.o1.removeView(this.b.Q0);
                if (this.b.n1 != null) {
                    this.b.n1.setVisibility(0);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class l implements u02 {
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

        @Override // com.repackage.u02
        public void onScrollChanged(int i, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIII(1048576, this, i, i2, i3, i4) == null) {
                this.a.setIsWebViewOnBottom(((((float) this.b.G0.getContentHeight()) * this.b.G0.getScale()) - ((float) this.b.G0.covertToView().getHeight())) - ((float) this.b.G0.getWebViewScrollY()) < 10.0f);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class m extends vx1 {
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

        @Override // com.repackage.vx1
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                super.a(str);
                if (Math.abs((this.b.G0.getContentHeight() * this.b.G0.getScale()) - this.b.G0.covertToView().getHeight()) < 10.0f) {
                    this.a.setIsWebViewOnBottom(true);
                } else {
                    this.a.setIsWebViewOnBottom(false);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class n implements em1 {
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

        @Override // com.repackage.em1
        public void onScrollChanged(int i, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIII(1048576, this, i, i2, i3, i4) == null) {
                CustomerAdScrollView customerAdScrollView = this.a;
                SwanAppAdLandingFragment swanAppAdLandingFragment = this.b;
                customerAdScrollView.setIsFooterLayoutShow(swanAppAdLandingFragment.q4(swanAppAdLandingFragment.n1));
            }
        }
    }

    /* loaded from: classes2.dex */
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
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                int id = view2.getId();
                HashMap<String, String> hashMap = new HashMap<>();
                if (id == R.id.obfuscated_res_0x7f0900eb) {
                    hashMap.put("da_area", "tail_icon");
                } else if (id == R.id.obfuscated_res_0x7f0900e8) {
                    hashMap.put("da_area", "tail_name");
                } else if (id == R.id.obfuscated_res_0x7f0900e9) {
                    hashMap.put("da_area", this.a.b1 == ActionType.DL.value() ? "tail_downloadbtn" : "tail_detailbtn");
                }
                if (this.a.P0 != null) {
                    this.a.P0.d("c", hashMap);
                }
                vy1.c3("adLanding", hp2.d(this.a.M0, this.a.M0));
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
        M1 = rf1.a;
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
        this.N0 = LandingType.NORMAL;
        this.R0 = "";
        this.S0 = "";
        this.T0 = "";
        this.X0 = DownloadState.NOT_START;
        this.i1 = new JSONObject();
        this.j1 = 0;
        this.k1 = 0;
        this.l1 = true;
        this.p1 = Boolean.FALSE;
        this.G1 = null;
        this.K1 = null;
        this.L1 = new o(this);
    }

    public static /* synthetic */ int t3(SwanAppAdLandingFragment swanAppAdLandingFragment) {
        int i2 = swanAppAdLandingFragment.k1;
        swanAppAdLandingFragment.k1 = i2 + 1;
        return i2;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void D0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            super.D0(z);
            if (z) {
                s4();
            } else {
                v4();
            }
        }
    }

    @Override // com.repackage.vy1, com.repackage.ny1
    public boolean L() {
        InterceptResult invokeV;
        zn2 zn2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (o4() && (zn2Var = this.O0) != null) {
                return zn2Var.onBackPressed();
            }
            w4("lpout");
            return super.L();
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.vy1, com.repackage.ny1
    public void T1(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) {
            super.T1(view2);
            this.l0.setLeftHomeViewSrc(R.drawable.obfuscated_res_0x7f080109);
            this.l0.setLeftHomeViewClickListener(new b(this));
        }
    }

    @Override // com.repackage.vy1
    public v02 Y2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? new a(this) : (v02) invokeV.objValue;
    }

    public final void Y3(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.l0.setLeftHomeViewVisibility(z ? 0 : 8);
        }
    }

    public final String Z3(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) ? v73.a().getString(str, "") : (String) invokeL.objValue;
    }

    public final void a4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            pn3 pn3Var = this.K1;
            if (pn3Var != null) {
                g(pn3Var);
                return;
            }
            fo3 fo3Var = new fo3(getContext());
            fo3Var.d(this);
            go3 go3Var = new go3(getContext());
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("charge_url", this.D1);
                jSONObject.put("apk_url", this.C1);
                jSONObject.put("ssl", 1);
            } catch (JSONException e2) {
                if (M1) {
                    e2.printStackTrace();
                }
            }
            fo3Var.c(go3Var, jSONObject);
        }
    }

    @Override // com.repackage.vy1, com.repackage.ny1
    public boolean b2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void b4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.U0.f();
            if (TextUtils.isEmpty(this.W0.b)) {
                String Z3 = Z3(this.C1);
                this.W0.b = Z3;
                this.U0.a(Z3);
            }
            if (bd3.F(getContext(), this.W0.b)) {
                x4();
                this.U0.b(DownloadState.INSTALLED);
                return;
            }
            if (TextUtils.isEmpty(this.W0.a)) {
                this.W0.a = this.C1;
            }
            oi2.d().d(getContext(), this.W0.a(), DownloadParams.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.V0);
        }
    }

    public final void c4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            bd3.e0(new c(this));
        }
    }

    public final void d4(pn3 pn3Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048586, this, pn3Var, z) == null) {
            ly2 ly2Var = this.G1;
            if (ly2Var != null) {
                ly2Var.show();
                return;
            }
            ((ViewGroup) this.H1.findViewById(R.id.obfuscated_res_0x7f0900bf)).addView(this.U0.getRealView());
            ((AdImageVIew) this.H1.findViewById(R.id.obfuscated_res_0x7f0900c1)).setImageUrl(pn3Var.g());
            ((TextView) this.H1.findViewById(R.id.obfuscated_res_0x7f0900be)).setText(pn3Var.c());
            ((TextView) this.H1.findViewById(R.id.obfuscated_res_0x7f0900c6)).setText(pn3Var.d());
            ((TextView) this.H1.findViewById(R.id.obfuscated_res_0x7f0900bd)).setText(pn3Var.a());
            ((TextView) this.H1.findViewById(R.id.obfuscated_res_0x7f0900c8)).setText(pn3Var.j());
            TextView textView = (TextView) this.H1.findViewById(R.id.obfuscated_res_0x7f0900c0);
            if (!z) {
                textView.setText(pn3Var.e());
                textView.setVisibility(0);
            }
            this.I1 = pn3Var.h();
            this.J1 = pn3Var.i();
            ViewGroup.LayoutParams layoutParams = this.U0.getRealView().getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(-1, -2);
                this.U0.getRealView().setLayoutParams(layoutParams);
            }
            int o2 = yc3.o(getContext());
            float l2 = yc3.l(getContext());
            layoutParams.width = o2 - (((int) ((10.0f * l2) + 0.5f)) * 2);
            if (TextUtils.isEmpty(this.W0.b)) {
                String Z3 = Z3(pn3Var.b());
                this.W0.b = Z3;
                this.U0.a(Z3);
            }
            if (bd3.F(getContext(), this.W0.b)) {
                this.U0.b(DownloadState.INSTALLED);
            }
            if (TextUtils.isEmpty(this.W0.a)) {
                this.W0.a = pn3Var.b();
            }
            this.U0.e(this.W0);
            ky2 ky2Var = new ky2(getContext());
            ky2Var.i(true);
            ky2Var.k(false);
            ky2Var.T(false);
            ky2Var.m(false);
            ky2Var.t(false);
            ky2Var.n(new pe3());
            ky2Var.p(R.drawable.obfuscated_res_0x7f080125);
            ky2Var.F(R.color.obfuscated_res_0x7f060a33);
            ky2Var.K(new g(this));
            ky2Var.W(this.H1);
            ky2Var.j();
            ky2Var.q((int) (l2 * (z ? 225.0f : 250.0f)));
            ly2 c2 = ky2Var.c();
            this.G1 = c2;
            Window window = c2.getWindow();
            if (window != null) {
                window.setGravity(80);
                window.setDimAmount(0.65f);
                window.setLayout(yc3.s(getContext()), -2);
                window.setWindowAnimations(R.style.obfuscated_res_0x7f100394);
            }
            this.G1.a(false);
            this.G1.setCanceledOnTouchOutside(true);
            this.G1.show();
        }
    }

    public final void e4(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, viewGroup) == null) {
            this.V0 = new j(this);
            this.W0 = new DownloadParams(this.S0, this.T0);
            on3 on3Var = new on3();
            on3Var.l(getContext(), this.W0, this.V0);
            this.U0 = on3Var;
            on3Var.e(this.W0);
            f4();
        }
    }

    public final void f4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            View inflate = View.inflate(getContext(), R.layout.obfuscated_res_0x7f0d0092, null);
            this.H1 = inflate;
            ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0900c5)).setOnClickListener(new d(this));
            ((TextView) this.H1.findViewById(R.id.obfuscated_res_0x7f0900c4)).setOnClickListener(new e(this));
            ((ImageView) this.H1.findViewById(R.id.obfuscated_res_0x7f090648)).setOnClickListener(new f(this));
            TextView textView = new TextView(getContext());
            this.E1 = textView;
            textView.setText("温馨提示：您已访问至第三方页面");
            this.E1.setTextColor(-16777216);
            GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{0, -1});
            gradientDrawable.setShape(0);
            this.E1.setBackground(gradientDrawable);
            this.E1.getBackground().setAlpha(180);
            this.E1.setPadding(0, 0, 0, 10);
            this.E1.setGravity(80);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, 260);
            layoutParams.gravity = 81;
            layoutParams.bottomMargin = ((int) (getContext().getResources().getDisplayMetrics().heightPixels * 0.14d)) - 80;
            this.E1.setLayoutParams(layoutParams);
            this.E1.setGravity(81);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.repackage.rn3
    public void g(pn3 pn3Var) {
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, pn3Var) == null) {
            this.K1 = pn3Var;
            String f2 = pn3Var.f();
            this.F1 = f2;
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
                b4();
            } else if (c2 == 1) {
                d4(pn3Var, true);
            } else if (c2 == 2) {
                d4(pn3Var, false);
            } else if (c2 != 3) {
            } else {
                c4();
            }
        }
    }

    public final void g4(ViewGroup viewGroup, ViewGroup viewGroup2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, viewGroup, viewGroup2) == null) {
            this.n1 = (LinearLayout) ((LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d07b2, (ViewGroup) null)).findViewById(R.id.obfuscated_res_0x7f09009e);
            CustomerAdScrollView customerAdScrollView = new CustomerAdScrollView(getContext());
            LinearLayout linearLayout = new LinearLayout(getContext());
            linearLayout.setOrientation(1);
            linearLayout.addView(viewGroup2, new LinearLayout.LayoutParams(-1, -2));
            linearLayout.addView(this.n1, new LinearLayout.LayoutParams(-1, getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07064c)));
            customerAdScrollView.addView(linearLayout, new LinearLayout.LayoutParams(-1, -2));
            viewGroup.addView(customerAdScrollView);
            this.F0.v(new l(this, customerAdScrollView));
            this.F0.d(new m(this, customerAdScrollView));
            customerAdScrollView.setScrollViewListener(new n(this, customerAdScrollView));
        }
    }

    public final void h4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d07b3, (ViewGroup) null);
            this.m1.addView(relativeLayout, new FrameLayout.LayoutParams(-1, this.y1));
            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) relativeLayout.findViewById(R.id.obfuscated_res_0x7f0900bc);
            SimpleDraweeView simpleDraweeView2 = (SimpleDraweeView) relativeLayout.findViewById(R.id.obfuscated_res_0x7f0900c9);
            this.w1 = (FrameLayout) relativeLayout.findViewById(R.id.obfuscated_res_0x7f0900ca);
            if (!TextUtils.isEmpty(this.s1)) {
                simpleDraweeView.setImageURI(Uri.parse(this.s1));
                simpleDraweeView.setOnClickListener(this.L1);
            } else {
                simpleDraweeView.setVisibility(4);
            }
            if (!TextUtils.isEmpty(this.t1)) {
                simpleDraweeView2.setImageURI(Uri.parse(this.t1));
            } else {
                simpleDraweeView2.setVisibility(4);
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.w1.getLayoutParams();
            layoutParams.width = this.a1;
            layoutParams.height = this.Z0;
            layoutParams.rightMargin = this.z1;
            this.w1.setLayoutParams(layoutParams);
        }
    }

    public final void i4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d07b4, (ViewGroup) null);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.height = this.p1.booleanValue() ? this.y1 : this.Z0;
            this.Y0 = (RelativeLayout) relativeLayout.findViewById(R.id.obfuscated_res_0x7f0900ec);
            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) relativeLayout.findViewById(R.id.obfuscated_res_0x7f0900ed);
            SimpleDraweeView simpleDraweeView2 = (SimpleDraweeView) relativeLayout.findViewById(R.id.obfuscated_res_0x7f0900eb);
            TextView textView = (TextView) relativeLayout.findViewById(R.id.obfuscated_res_0x7f0900e8);
            TextView textView2 = (TextView) relativeLayout.findViewById(R.id.obfuscated_res_0x7f0900e9);
            if (!TextUtils.isEmpty(this.c1)) {
                textView2.setText(this.c1);
                textView2.setVisibility(0);
            } else {
                textView2.setVisibility(8);
            }
            if (!TextUtils.isEmpty(this.d1)) {
                textView.setText(this.d1);
                textView.setVisibility(0);
            } else {
                textView.setVisibility(4);
            }
            if (!TextUtils.isEmpty(this.e1)) {
                simpleDraweeView2.setImageURI(Uri.parse(this.e1));
                simpleDraweeView2.setVisibility(0);
            } else {
                simpleDraweeView2.setVisibility(8);
            }
            simpleDraweeView.getHierarchy().setPlaceholderImage(getResources().getDrawable(R.drawable.obfuscated_res_0x7f081169));
            String str = this.p1.booleanValue() ? this.A1 : this.g1;
            if (!TextUtils.isEmpty(str)) {
                simpleDraweeView.setImageURI(fc3.m(str));
            }
            simpleDraweeView.setVisibility(0);
            simpleDraweeView.setOnClickListener(new i(this));
            simpleDraweeView2.setOnClickListener(this.L1);
            textView.setOnClickListener(this.L1);
            textView2.setOnClickListener(this.L1);
            this.m1.addView(this.Y0, layoutParams);
            this.Y0.setVisibility(4);
        }
    }

    public final void j4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            if (this.p1.booleanValue()) {
                h4();
            }
            cm1 cm1Var = new cm1(this.g1, this.h1, this.F0.c(), this.p1.booleanValue() ? 0 : this.a1, this.p1.booleanValue() ? 0 : this.Z0, this.j1, this.p1.booleanValue());
            zn2 zn2Var = new zn2(getContext(), cm1Var.a());
            this.O0 = zn2Var;
            this.B1.p(zn2Var);
            this.O0.v(new h(this));
            if (this.p1.booleanValue()) {
                this.O0.x(this.w1);
            }
            this.O0.o(cm1Var.a());
            this.O0.w(false);
        }
    }

    public final void k4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            DisplayMetrics displayMetrics = getActivity().getResources().getDisplayMetrics();
            int i2 = displayMetrics != null ? displayMetrics.widthPixels : 0;
            if (this.p1.booleanValue()) {
                float f2 = this.r1 / this.q1;
                this.x1 = i2;
                int i3 = (int) (i2 * f2);
                this.y1 = i3;
                this.a1 = (int) (i2 * this.u1);
                this.Z0 = i3;
                this.z1 = (int) (i2 * this.v1);
                return;
            }
            this.Z0 = (i2 * 9) / 16;
            this.a1 = i2;
        }
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [com.repackage.ol1] */
    public final void l4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            ql1 m2 = m();
            this.F0 = m2;
            m2.c0(Y2());
            this.G0 = this.F0.u();
            this.F0.loadUrl(this.M0);
            FrameLayout frameLayout = new FrameLayout(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            View covertToView = this.G0.covertToView();
            wz2 wz2Var = new wz2();
            wz2Var.e = SwanAppConfigData.t("#FFFFFF");
            this.F0.B(frameLayout, wz2Var);
            this.F0.R(frameLayout, wz2Var);
            this.F0.l(frameLayout, covertToView);
            if (n4()) {
                g4(this.m1, frameLayout);
            } else {
                this.m1.addView(frameLayout);
            }
            WebViewContainer webViewContainer = this.m1;
            if (webViewContainer != null) {
                webViewContainer.setInternalWebView(this.G0);
            }
            if (p4()) {
                layoutParams.topMargin = this.p1.booleanValue() ? this.y1 : this.Z0;
            }
            covertToView.setLayoutParams(layoutParams);
            this.Q0.post(new k(this, covertToView));
        }
    }

    @Override // com.repackage.vy1
    public ql1 m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            dm1 dm1Var = new dm1(getContext());
            dm1Var.u().setDownloadListener(new ISailorDownloadListener(this) { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.9
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
                        if (SwanAppAdLandingFragment.M1) {
                            Log.d("SwanAppAdLandFragment", "onDownloadStart: url=" + str + ", userAgent=" + str2 + ", mimeType=" + str4);
                        }
                        this.this$0.C1 = str;
                        this.this$0.a4();
                    }
                }

                @Override // com.baidu.browser.sailor.ISailorDownloadListener
                public void onPlayVideo(String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                    }
                }
            });
            return dm1Var;
        }
        return (ql1) invokeV.objValue;
    }

    public final void m4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            fm1 fm1Var = new fm1(getContext());
            this.B1 = fm1Var;
            fm1Var.o(p4() ? this.Z0 : 0);
            WebViewContainer k2 = this.B1.k();
            this.m1 = k2;
            this.o1.addView(k2);
        }
    }

    public final boolean n4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? TextUtils.equals("swan-custom-ad", this.R0) : invokeV.booleanValue;
    }

    public final boolean o4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? getActivity().getResources().getConfiguration().orientation == 2 : invokeV.booleanValue;
    }

    @Override // com.repackage.ny1, com.baidu.swan.support.v4.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            super.onPause();
            s4();
        }
    }

    @Override // com.repackage.ny1, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            super.onResume();
            fm1 fm1Var = this.B1;
            if (fm1Var == null || !fm1Var.l() || n0()) {
                return;
            }
            v4();
        }
    }

    public final boolean p4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.N0 == LandingType.VIDEO : invokeV.booleanValue;
    }

    public final boolean q4(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, view2)) == null) {
            if (view2 == null || view2.getVisibility() != 0) {
                return false;
            }
            return view2.getGlobalVisibleRect(new Rect());
        }
        return invokeL.booleanValue;
    }

    public final void r4() {
        Bundle q;
        String H;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048604, this) == null) || (q = q()) == null) {
            return;
        }
        this.M0 = q.getString("url", "");
        if (TextUtils.isEmpty(this.I0)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(this.I0);
            this.h1 = jSONObject.optString("vurl", "");
            this.g1 = jSONObject.optString("w_picurl", "");
            this.e1 = jSONObject.optString("icon", "");
            int optInt = jSONObject.optInt("act", ActionType.LP.value());
            this.b1 = optInt;
            if (optInt == ActionType.DL.value()) {
                H = H(R.string.obfuscated_res_0x7f0f1283);
            } else {
                H = H(R.string.obfuscated_res_0x7f0f128c);
            }
            this.c1 = H;
            this.d1 = jSONObject.optString("appname", "");
            this.j1 = jSONObject.optInt("currentTime", 0);
            this.i1 = jSONObject.optJSONObject("monitors");
            this.S0 = jSONObject.optString("url", "");
            this.T0 = jSONObject.optString("name", "");
            this.R0 = jSONObject.optString("from", "");
            this.f1 = jSONObject.optString("monitorUrl", "");
            this.q1 = jSONObject.optInt("w", 16);
            this.r1 = jSONObject.optInt("h", 9);
            this.s1 = jSONObject.optString("playingbg", "");
            this.t1 = jSONObject.optString("maskUrl", "");
            this.u1 = (float) jSONObject.optDouble("playerWidthRatio", 0.5d);
            this.v1 = (float) jSONObject.optDouble("rightMarginRatio", 0.0d);
            this.A1 = jSONObject.optString("horizontalCover", "");
            this.D1 = jSONObject.optString("costUrl", "");
        } catch (JSONException e2) {
            if (M1) {
                e2.printStackTrace();
            }
        }
        if (!TextUtils.isEmpty(this.h1)) {
            this.N0 = LandingType.VIDEO;
        }
        this.p1 = Boolean.valueOf(TextUtils.equals("ad-video-portrait", this.R0));
    }

    public final void s4() {
        zn2 zn2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048605, this) == null) && (zn2Var = this.O0) != null && zn2Var.n()) {
            this.O0.p();
        }
    }

    public final void t4(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048606, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        v73.a().putString(this.W0.a, str);
    }

    public final void u4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            this.m1.removeView(this.U0.getRealView());
            this.m1.removeView(this.E1);
        }
    }

    @Override // com.repackage.vy1, com.baidu.swan.support.v4.app.Fragment
    public void v0(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, bundle) == null) {
            super.v0(bundle);
            r4();
            this.P0 = new qo3(getContext(), this.i1);
            FragmentActivity activity = getActivity();
            if (activity != null) {
                boolean z = 1 == activity.getRequestedOrientation();
                this.l1 = z;
                if (!z) {
                    G2(1);
                }
            }
            if (M1) {
                Log.d("SwanAppAdLandFragment", "onCreate() : " + this);
            }
        }
    }

    public final void v4() {
        zn2 zn2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048609, this) == null) || (zn2Var = this.O0) == null || zn2Var.n() || this.O0.m()) {
            return;
        }
        this.O0.s();
    }

    public final void w4(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, str) == null) {
            HashMap<String, String> hashMap = new HashMap<>();
            zn2 zn2Var = this.O0;
            if (zn2Var != null) {
                hashMap.put("cur_time", String.valueOf(zn2Var.e() / 1000));
            }
            qo3 qo3Var = this.P0;
            if (qo3Var != null) {
                qo3Var.d(str, hashMap);
            }
        }
    }

    public final void x4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            u4();
            this.m1.addView(this.E1);
            this.m1.addView(this.U0.getRealView());
        }
    }

    @Override // com.repackage.vy1, com.baidu.swan.support.v4.app.Fragment
    public View y0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048612, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d00dc, viewGroup, false);
            T1(inflate);
            this.o1 = (ViewGroup) inflate.findViewById(R.id.obfuscated_res_0x7f091de1);
            this.Q0 = (FrameLayout) inflate.findViewById(R.id.obfuscated_res_0x7f0901a5);
            k4();
            m4();
            e4(this.m1);
            l4();
            if (p4()) {
                j4();
                i4();
            }
            if (S1()) {
                inflate = V1(inflate);
            }
            w4("lpin");
            return C1(inflate, this);
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.repackage.vy1, com.baidu.swan.support.v4.app.Fragment
    public void z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            if (p4()) {
                w4("vplayend");
            }
            zn2 zn2Var = this.O0;
            if (zn2Var != null) {
                zn2Var.onDestroy();
            }
            if (!this.l1) {
                G2(0);
            }
            super.z0();
        }
    }
}
