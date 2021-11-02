package com.baidu.swan.apps.adlanding;

import android.content.Intent;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.h0.g.k;
import b.a.p0.a.v2.q0;
import b.a.p0.a.v2.u;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.browser.sailor.ISailorDownloadListener;
import com.baidu.mobads.container.adrequest.AdParamInfo;
import com.baidu.swan.apps.adlanding.customer.CustomerAdScrollView;
import com.baidu.swan.apps.adlanding.customer.WebViewContainer;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
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
/* loaded from: classes8.dex */
public class SwanAppAdLandingFragment extends k {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean A1;
    public transient /* synthetic */ FieldHolder $fh;
    public String J0;
    public LandingType K0;
    public b.a.p0.a.i1.g.a L0;
    public b.a.p0.f.i.q.c M0;
    public FrameLayout N0;
    public String O0;
    public String P0;
    public String Q0;
    public b.a.p0.f.i.k.f.f R0;
    public b.a.p0.f.i.k.f.a S0;
    public DownloadParams T0;
    public DownloadState U0;
    public RelativeLayout V0;
    public int W0;
    public int X0;
    public int Y0;
    public String Z0;
    public String a1;
    public String b1;
    public String c1;
    public String d1;
    public String e1;
    public JSONObject f1;
    public int g1;
    public int h1;
    public boolean i1;
    public WebViewContainer j1;
    public LinearLayout k1;
    public ViewGroup l1;
    public Boolean m1;
    public int n1;
    public int o1;
    public String p1;
    public String q1;
    public float r1;
    public float s1;
    public FrameLayout t1;
    public int u1;
    public int v1;
    public int w1;
    public String x1;
    public b.a.p0.a.q.e.b y1;
    public View.OnClickListener z1;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes8.dex */
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
    /* loaded from: classes8.dex */
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

    /* loaded from: classes8.dex */
    public class a extends b.a.p0.a.h0.j.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ SwanAppAdLandingFragment f43279c;

        /* renamed from: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC1688a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f43280e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f43281f;

            public RunnableC1688a(a aVar, String str) {
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
                this.f43281f = aVar;
                this.f43280e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f43281f.f43279c.n0.setTitle(TextUtils.isEmpty(this.f43280e) ? "" : this.f43280e);
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
            this.f43279c = swanAppAdLandingFragment;
        }

        @Override // b.a.p0.a.h0.j.a, b.a.p0.a.h0.j.d
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                SwanAppAdLandingFragment swanAppAdLandingFragment = this.f43279c;
                swanAppAdLandingFragment.z3(swanAppAdLandingFragment.D0.canGoBack());
                this.f43279c.n0.post(new RunnableC1688a(this, str));
            }
        }

        @Override // b.a.p0.a.h0.j.a, b.a.p0.a.h0.j.d
        public boolean c(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                if (b.a.p0.a.b2.a.b.e(str) || b.a.p0.a.b2.a.b.f(str)) {
                    try {
                        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                        b.a.p0.a.a2.e P = b.a.p0.a.a2.e.P();
                        if (P != null) {
                            P.x().startActivity(intent);
                            return true;
                        }
                    } catch (Exception e2) {
                        if (SwanAppAdLandingFragment.A1) {
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
                if (TextUtils.isEmpty(this.f43279c.c1)) {
                    return;
                }
                this.f43279c.M0.e(this.f43279c.c1);
            }
        }

        @Override // b.a.p0.a.h0.j.a, b.a.p0.a.h0.j.d
        public void goBack() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                SwanAppAdLandingFragment swanAppAdLandingFragment = this.f43279c;
                swanAppAdLandingFragment.z3(swanAppAdLandingFragment.D0.canGoBack());
            }
        }
    }

    /* loaded from: classes8.dex */
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
                k.F2();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements b.a.p0.a.i1.g.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SwanAppAdLandingFragment f43282a;

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
            this.f43282a = swanAppAdLandingFragment;
        }

        @Override // b.a.p0.a.i1.g.b
        public void a(b.a.p0.a.c1.d.j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) {
                this.f43282a.R3("vcontinueplay");
            }
        }

        @Override // b.a.p0.a.i1.g.b
        public void b(b.a.p0.a.c1.d.j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jVar) == null) {
                this.f43282a.V0.bringToFront();
                this.f43282a.V0.setVisibility(0);
                this.f43282a.g1 = 0;
                SwanAppAdLandingFragment.b3(this.f43282a);
                this.f43282a.R3("vplayend");
                this.f43282a.R3("scard");
            }
        }

        @Override // b.a.p0.a.i1.g.b
        public void c(b.a.p0.a.c1.d.j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jVar) == null) {
                this.f43282a.R3("vpause");
            }
        }

        @Override // b.a.p0.a.i1.g.b
        public void d(b.a.p0.a.c1.d.j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, jVar) == null) {
                if (this.f43282a.h1 == 0) {
                    this.f43282a.R3("vstart");
                    return;
                }
                this.f43282a.V0.setVisibility(8);
                this.f43282a.R3("vrepeatedplay");
            }
        }

        @Override // b.a.p0.a.i1.g.b
        public void e(b.a.p0.a.c1.d.j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, jVar) == null) {
            }
        }

        @Override // b.a.p0.a.i1.g.b
        public boolean f(b.a.p0.a.c1.d.j jVar, int i2, int i3) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(1048581, this, jVar, i2, i3)) == null) {
                return false;
            }
            return invokeLII.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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

    /* loaded from: classes8.dex */
    public class e implements b.a.p0.f.i.k.f.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f43283a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SwanAppAdLandingFragment f43284b;

        public e(SwanAppAdLandingFragment swanAppAdLandingFragment, ViewGroup viewGroup) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppAdLandingFragment, viewGroup};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43284b = swanAppAdLandingFragment;
            this.f43283a = viewGroup;
        }

        @Override // b.a.p0.f.i.k.f.a
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                this.f43284b.R0.d(i2);
            }
        }

        @Override // b.a.p0.f.i.k.f.a
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f43284b.R3("appinstallbegin");
            }
        }

        @Override // b.a.p0.f.i.k.f.a
        public void c(DownloadState downloadState, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, downloadState, i2) == null) {
                this.f43284b.R0.b(downloadState);
                if (this.f43284b.U0 == downloadState) {
                    return;
                }
                if (this.f43284b.U0 == DownloadState.NOT_START && downloadState == DownloadState.DOWNLOADING) {
                    this.f43284b.R3("appdownloadbegin");
                } else if (downloadState == DownloadState.DOWNLOAD_PAUSED) {
                    this.f43284b.R3("appdownloadpause");
                } else if (this.f43284b.U0 == DownloadState.DOWNLOAD_PAUSED && downloadState == DownloadState.DOWNLOADING) {
                    this.f43284b.R3("appdownloadcontinue");
                } else if (downloadState == DownloadState.DOWNLOADED) {
                    this.f43284b.R3("appdownloadfinish");
                    this.f43284b.R3("appinstallbegin");
                } else if (downloadState == DownloadState.INSTALLED) {
                    this.f43284b.R3("appinstallfinish");
                }
                this.f43284b.U0 = downloadState;
            }
        }

        @Override // b.a.p0.f.i.k.f.a
        public void d(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                this.f43284b.P3(str);
            }
        }

        @Override // b.a.p0.f.i.k.f.a
        public String e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                this.f43284b.R3("appinstallopen");
                SwanAppAdLandingFragment swanAppAdLandingFragment = this.f43284b;
                return swanAppAdLandingFragment.A3(swanAppAdLandingFragment.T0.f44548a);
            }
            return (String) invokeV.objValue;
        }

        @Override // b.a.p0.f.i.k.f.a
        public void f(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
                if (z) {
                    this.f43283a.removeView(this.f43284b.R0.getRealView());
                    this.f43283a.addView(this.f43284b.R0.getRealView());
                    return;
                }
                this.f43283a.removeView(this.f43284b.R0.getRealView());
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f43285e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SwanAppAdLandingFragment f43286f;

        public f(SwanAppAdLandingFragment swanAppAdLandingFragment, View view) {
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
            this.f43286f = swanAppAdLandingFragment;
            this.f43285e = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int height = this.f43286f.N0.getHeight();
                if (this.f43286f.L3() || this.f43286f.J3()) {
                    ViewGroup.LayoutParams layoutParams = this.f43285e.getLayoutParams();
                    layoutParams.height = height;
                    this.f43285e.setLayoutParams(layoutParams);
                }
                if (this.f43286f.L3()) {
                    ViewGroup.LayoutParams layoutParams2 = this.f43286f.j1.getLayoutParams();
                    layoutParams2.height = height + (this.f43286f.m1.booleanValue() ? this.f43286f.v1 : this.f43286f.W0);
                    this.f43286f.j1.setLayoutParams(layoutParams2);
                }
                this.f43286f.l1.removeView(this.f43286f.N0);
                if (this.f43286f.k1 != null) {
                    this.f43286f.k1.setVisibility(0);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g implements b.a.p0.a.h0.j.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CustomerAdScrollView f43287a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SwanAppAdLandingFragment f43288b;

        public g(SwanAppAdLandingFragment swanAppAdLandingFragment, CustomerAdScrollView customerAdScrollView) {
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
            this.f43288b = swanAppAdLandingFragment;
            this.f43287a = customerAdScrollView;
        }

        @Override // b.a.p0.a.h0.j.c
        public void onScrollChanged(int i2, int i3, int i4, int i5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIII(1048576, this, i2, i3, i4, i5) == null) {
                this.f43287a.setIsWebViewOnBottom(((((float) this.f43288b.D0.getContentHeight()) * this.f43288b.D0.getScale()) - ((float) this.f43288b.D0.covertToView().getHeight())) - ((float) this.f43288b.D0.getWebViewScrollY()) < 10.0f);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class h extends b.a.p0.a.h0.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CustomerAdScrollView f43289a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SwanAppAdLandingFragment f43290b;

        public h(SwanAppAdLandingFragment swanAppAdLandingFragment, CustomerAdScrollView customerAdScrollView) {
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
            this.f43290b = swanAppAdLandingFragment;
            this.f43289a = customerAdScrollView;
        }

        @Override // b.a.p0.a.h0.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                super.a(str);
                if (Math.abs((this.f43290b.D0.getContentHeight() * this.f43290b.D0.getScale()) - this.f43290b.D0.covertToView().getHeight()) < 10.0f) {
                    this.f43289a.setIsWebViewOnBottom(true);
                } else {
                    this.f43289a.setIsWebViewOnBottom(false);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class i implements b.a.p0.a.q.e.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CustomerAdScrollView f43291a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SwanAppAdLandingFragment f43292b;

        public i(SwanAppAdLandingFragment swanAppAdLandingFragment, CustomerAdScrollView customerAdScrollView) {
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
            this.f43292b = swanAppAdLandingFragment;
            this.f43291a = customerAdScrollView;
        }

        @Override // b.a.p0.a.q.e.a
        public void onScrollChanged(int i2, int i3, int i4, int i5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIII(1048576, this, i2, i3, i4, i5) == null) {
                CustomerAdScrollView customerAdScrollView = this.f43291a;
                SwanAppAdLandingFragment swanAppAdLandingFragment = this.f43292b;
                customerAdScrollView.setIsFooterLayoutShow(swanAppAdLandingFragment.M3(swanAppAdLandingFragment.k1));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class j implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppAdLandingFragment f43293e;

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
            this.f43293e = swanAppAdLandingFragment;
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
                    hashMap.put("da_area", this.f43293e.Y0 == ActionType.DL.value() ? "tail_downloadbtn" : "tail_detailbtn");
                }
                this.f43293e.M0.d("c", hashMap);
                k.K2("adLanding", b.a.p0.a.l1.b.e(this.f43293e.J0, this.f43293e.J0));
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
        A1 = b.a.p0.a.k.f6397a;
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
        this.K0 = LandingType.NORMAL;
        this.O0 = "";
        this.P0 = "";
        this.Q0 = "";
        this.U0 = DownloadState.NOT_START;
        this.g1 = 0;
        this.h1 = 0;
        this.i1 = true;
        this.m1 = Boolean.FALSE;
        this.z1 = new j(this);
    }

    public static /* synthetic */ int b3(SwanAppAdLandingFragment swanAppAdLandingFragment) {
        int i2 = swanAppAdLandingFragment.h1;
        swanAppAdLandingFragment.h1 = i2 + 1;
        return i2;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void A0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            super.A0(z);
            if (z) {
                O3();
            } else {
                Q3();
            }
        }
    }

    public final String A3(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) ? b.a.p0.a.k2.g.h.a().getString(str, "") : (String) invokeL.objValue;
    }

    public final void B3(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup) == null) {
            this.S0 = new e(this, viewGroup);
            this.T0 = new DownloadParams(this.P0, this.Q0);
            b.a.p0.f.i.k.g.b bVar = new b.a.p0.f.i.k.g.b();
            bVar.l(getContext(), this.T0, this.S0);
            this.R0 = bVar;
            bVar.e(this.T0);
        }
    }

    public final void C3(ViewGroup viewGroup, ViewGroup viewGroup2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, viewGroup, viewGroup2) == null) {
            this.k1 = (LinearLayout) ((LinearLayout) LayoutInflater.from(getContext()).inflate(b.a.p0.a.g.swanapp_ad_footer_view, (ViewGroup) null)).findViewById(b.a.p0.a.f.ad_footer);
            CustomerAdScrollView customerAdScrollView = new CustomerAdScrollView(getContext());
            LinearLayout linearLayout = new LinearLayout(getContext());
            linearLayout.setOrientation(1);
            linearLayout.addView(viewGroup2, new LinearLayout.LayoutParams(-1, -2));
            linearLayout.addView(this.k1, new LinearLayout.LayoutParams(-1, getContext().getResources().getDimensionPixelSize(b.a.p0.a.d.swanapp_ad_dimens_footer_height)));
            customerAdScrollView.addView(linearLayout, new LinearLayout.LayoutParams(-1, -2));
            viewGroup.addView(customerAdScrollView);
            this.C0.t(new g(this, customerAdScrollView));
            this.C0.c(new h(this, customerAdScrollView));
            customerAdScrollView.setScrollViewListener(new i(this, customerAdScrollView));
        }
    }

    public final void D3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(getContext()).inflate(b.a.p0.a.g.swanapp_ad_landing_portrait_video, (ViewGroup) null);
            this.j1.addView(relativeLayout, new FrameLayout.LayoutParams(-1, this.v1));
            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) relativeLayout.findViewById(b.a.p0.a.f.ad_landing_bg_image);
            SimpleDraweeView simpleDraweeView2 = (SimpleDraweeView) relativeLayout.findViewById(b.a.p0.a.f.ad_landing_mask);
            this.t1 = (FrameLayout) relativeLayout.findViewById(b.a.p0.a.f.ad_landing_video);
            if (!TextUtils.isEmpty(this.p1)) {
                simpleDraweeView.setImageURI(Uri.parse(this.p1));
                simpleDraweeView.setOnClickListener(this.z1);
            } else {
                simpleDraweeView.setVisibility(4);
            }
            if (!TextUtils.isEmpty(this.q1)) {
                simpleDraweeView2.setImageURI(Uri.parse(this.q1));
            } else {
                simpleDraweeView2.setVisibility(4);
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.t1.getLayoutParams();
            layoutParams.width = this.X0;
            layoutParams.height = this.W0;
            layoutParams.rightMargin = this.w1;
            this.t1.setLayoutParams(layoutParams);
        }
    }

    public final void E3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(getContext()).inflate(b.a.p0.a.g.swanapp_ad_video_tail_view, (ViewGroup) null);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.height = this.m1.booleanValue() ? this.v1 : this.W0;
            this.V0 = (RelativeLayout) relativeLayout.findViewById(b.a.p0.a.f.ad_tail_root);
            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) relativeLayout.findViewById(b.a.p0.a.f.ad_tail_video_img);
            SimpleDraweeView simpleDraweeView2 = (SimpleDraweeView) relativeLayout.findViewById(b.a.p0.a.f.ad_tail_head_image);
            TextView textView = (TextView) relativeLayout.findViewById(b.a.p0.a.f.ad_tail_brand_name);
            TextView textView2 = (TextView) relativeLayout.findViewById(b.a.p0.a.f.ad_tail_btn);
            if (!TextUtils.isEmpty(this.Z0)) {
                textView2.setText(this.Z0);
                textView2.setVisibility(0);
            } else {
                textView2.setVisibility(8);
            }
            if (!TextUtils.isEmpty(this.a1)) {
                textView.setText(this.a1);
                textView.setVisibility(0);
            } else {
                textView.setVisibility(4);
            }
            if (!TextUtils.isEmpty(this.b1)) {
                simpleDraweeView2.setImageURI(Uri.parse(this.b1));
                simpleDraweeView2.setVisibility(0);
            } else {
                simpleDraweeView2.setVisibility(8);
            }
            simpleDraweeView.getHierarchy().setPlaceholderImage(getResources().getDrawable(b.a.p0.a.e.swanapp_ad_tab_video_img_default_icon));
            String str = this.m1.booleanValue() ? this.x1 : this.d1;
            if (!TextUtils.isEmpty(str)) {
                simpleDraweeView.setImageURI(u.m(str));
            }
            simpleDraweeView.setVisibility(0);
            simpleDraweeView.setOnClickListener(new d(this));
            simpleDraweeView2.setOnClickListener(this.z1);
            textView.setOnClickListener(this.z1);
            textView2.setOnClickListener(this.z1);
            this.j1.addView(this.V0, layoutParams);
            this.V0.setVisibility(4);
        }
    }

    public final void F3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (this.m1.booleanValue()) {
                D3();
            }
            b.a.p0.a.q.c cVar = new b.a.p0.a.q.c(this.d1, this.e1, this.C0.b(), this.m1.booleanValue() ? 0 : this.X0, this.m1.booleanValue() ? 0 : this.W0, this.g1, this.m1.booleanValue());
            b.a.p0.a.i1.g.a aVar = new b.a.p0.a.i1.g.a(getContext(), cVar.a());
            this.L0 = aVar;
            this.y1.p(aVar);
            this.L0.u(new c(this));
            if (this.m1.booleanValue()) {
                this.L0.w(this.t1);
            }
            this.L0.o(cVar.a());
            this.L0.v(false);
        }
    }

    @Override // b.a.p0.a.h0.g.k
    public b.a.p0.a.h0.j.d G2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? new a(this) : (b.a.p0.a.h0.j.d) invokeV.objValue;
    }

    public final void G3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            DisplayMetrics displayMetrics = getActivity().getResources().getDisplayMetrics();
            int i2 = displayMetrics != null ? displayMetrics.widthPixels : 0;
            if (this.m1.booleanValue()) {
                float f2 = this.o1 / this.n1;
                this.u1 = i2;
                int i3 = (int) (i2 * f2);
                this.v1 = i3;
                this.X0 = (int) (i2 * this.r1);
                this.W0 = i3;
                this.w1 = (int) (i2 * this.s1);
                return;
            }
            this.W0 = (i2 * 9) / 16;
            this.X0 = i2;
        }
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [b.a.p0.a.p.e.c] */
    public final void H3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            b.a.p0.a.p.e.e k = k();
            this.C0 = k;
            k.X(G2());
            this.D0 = this.C0.s();
            this.C0.loadUrl(this.J0);
            FrameLayout frameLayout = new FrameLayout(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            View covertToView = this.D0.covertToView();
            b.a.p0.a.a2.n.g gVar = new b.a.p0.a.a2.n.g();
            gVar.f4008e = SwanAppConfigData.s("#FFFFFF");
            this.C0.z(frameLayout, gVar);
            this.C0.O(frameLayout, gVar);
            this.C0.j(frameLayout, covertToView);
            if (J3()) {
                C3(this.j1, frameLayout);
            } else {
                this.j1.addView(frameLayout);
            }
            WebViewContainer webViewContainer = this.j1;
            if (webViewContainer != null) {
                webViewContainer.setInternalWebView(this.D0);
            }
            if (L3()) {
                layoutParams.topMargin = this.m1.booleanValue() ? this.v1 : this.W0;
            }
            covertToView.setLayoutParams(layoutParams);
            this.N0.post(new f(this, covertToView));
        }
    }

    @Override // b.a.p0.a.h0.g.k, b.a.p0.a.h0.g.d
    public boolean I() {
        InterceptResult invokeV;
        b.a.p0.a.i1.g.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (K3() && (aVar = this.L0) != null) {
                return aVar.onBackPressed();
            }
            R3("lpout");
            return super.I();
        }
        return invokeV.booleanValue;
    }

    public final void I3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            b.a.p0.a.q.e.b bVar = new b.a.p0.a.q.e.b(getContext());
            this.y1 = bVar;
            bVar.o(L3() ? this.W0 : 0);
            WebViewContainer k = this.y1.k();
            this.j1 = k;
            this.l1.addView(k);
        }
    }

    public final boolean J3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? TextUtils.equals("swan-custom-ad", this.O0) : invokeV.booleanValue;
    }

    @Override // b.a.p0.a.h0.g.k, b.a.p0.a.h0.g.d
    public void K1(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, view) == null) {
            super.K1(view);
            this.n0.setLeftHomeViewSrc(b.a.p0.a.e.aiapps_action_bar_close_black_selector);
            this.n0.setLeftHomeViewClickListener(new b(this));
        }
    }

    public final boolean K3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? getActivity().getResources().getConfiguration().orientation == 2 : invokeV.booleanValue;
    }

    public final boolean L3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.K0 == LandingType.VIDEO : invokeV.booleanValue;
    }

    public final boolean M3(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, view)) == null) {
            if (view == null || view.getVisibility() != 0) {
                return false;
            }
            return view.getGlobalVisibleRect(new Rect());
        }
        return invokeL.booleanValue;
    }

    public final void N3() {
        Bundle n;
        String P;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (n = n()) == null) {
            return;
        }
        this.J0 = n.getString("url", "");
        if (TextUtils.isEmpty(this.F0)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(this.F0);
            this.e1 = jSONObject.optString("vurl", "");
            this.d1 = jSONObject.optString("w_picurl", "");
            this.b1 = jSONObject.optString("icon", "");
            int optInt = jSONObject.optInt("act", ActionType.LP.value());
            this.Y0 = optInt;
            if (optInt == ActionType.DL.value()) {
                P = P(b.a.p0.a.h.swanapp_ad_download_button);
            } else {
                P = P(b.a.p0.a.h.swanapp_ad_landingpage_button);
            }
            this.Z0 = P;
            this.a1 = jSONObject.optString("appname", "");
            this.g1 = jSONObject.optInt("currentTime", 0);
            this.f1 = jSONObject.optJSONObject("monitors");
            this.P0 = jSONObject.optString("url", "");
            this.Q0 = jSONObject.optString("name", "");
            this.O0 = jSONObject.optString("from", "");
            this.c1 = jSONObject.optString("monitorUrl", "");
            this.n1 = jSONObject.optInt("w", 16);
            this.o1 = jSONObject.optInt("h", 9);
            this.p1 = jSONObject.optString("playingbg", "");
            this.q1 = jSONObject.optString("maskUrl", "");
            this.r1 = (float) jSONObject.optDouble("playerWidthRatio", 0.5d);
            this.s1 = (float) jSONObject.optDouble("rightMarginRatio", 0.0d);
            this.x1 = jSONObject.optString("horizontalCover", "");
        } catch (JSONException e2) {
            if (A1) {
                e2.printStackTrace();
            }
        }
        if (!TextUtils.isEmpty(this.e1)) {
            this.K0 = LandingType.VIDEO;
        }
        this.m1 = Boolean.valueOf(TextUtils.equals("ad-video-portrait", this.O0));
    }

    public final void O3() {
        b.a.p0.a.i1.g.a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048594, this) == null) && (aVar = this.L0) != null && aVar.n()) {
            this.L0.p();
        }
    }

    public final void P3(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        b.a.p0.a.k2.g.h.a().putString(this.T0.f44548a, str);
    }

    public final void Q3() {
        b.a.p0.a.i1.g.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || (aVar = this.L0) == null || aVar.n() || this.L0.m()) {
            return;
        }
        this.L0.r();
    }

    @Override // b.a.p0.a.h0.g.k, b.a.p0.a.h0.g.d
    public boolean R1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void R3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, str) == null) {
            HashMap<String, String> hashMap = new HashMap<>();
            b.a.p0.a.i1.g.a aVar = this.L0;
            if (aVar != null) {
                hashMap.put("cur_time", String.valueOf(aVar.e() / 1000));
            }
            this.M0.d(str, hashMap);
        }
    }

    @Override // b.a.p0.a.h0.g.k
    public b.a.p0.a.p.e.e k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            b.a.p0.a.q.d dVar = new b.a.p0.a.q.d(getContext());
            dVar.s().setDownloadListener(new ISailorDownloadListener(this) { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.9
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
                        if (SwanAppAdLandingFragment.A1) {
                            String str5 = "onDownloadStart: url=" + str + ", userAgent=" + str2 + ", mimeType=" + str4;
                        }
                        this.this$0.R0.f();
                        if (TextUtils.isEmpty(this.this$0.T0.f44549b)) {
                            String A3 = this.this$0.A3(str);
                            this.this$0.T0.f44549b = A3;
                            this.this$0.R0.a(A3);
                        }
                        if (q0.F(this.this$0.getContext(), this.this$0.T0.f44549b)) {
                            this.this$0.j1.removeView(this.this$0.R0.getRealView());
                            this.this$0.j1.addView(this.this$0.R0.getRealView());
                            this.this$0.R0.b(DownloadState.INSTALLED);
                            return;
                        }
                        if (TextUtils.isEmpty(this.this$0.T0.f44548a)) {
                            this.this$0.T0.f44548a = str;
                        }
                        b.a.p0.a.c1.a.c().b(this.this$0.getContext(), this.this$0.T0.a(), DownloadParams.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.this$0.S0);
                    }
                }

                @Override // com.baidu.browser.sailor.ISailorDownloadListener
                public void onPlayVideo(String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                    }
                }
            });
            return dVar;
        }
        return (b.a.p0.a.p.e.e) invokeV.objValue;
    }

    @Override // b.a.p0.a.h0.g.k, com.baidu.swan.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, bundle) == null) {
            super.onCreate(bundle);
            N3();
            FragmentActivity activity = getActivity();
            if (activity != null) {
                boolean z = 1 == activity.getRequestedOrientation();
                this.i1 = z;
                if (!z) {
                    r2(1);
                }
            }
            if (A1) {
                String str = "onCreate() : " + this;
            }
        }
    }

    @Override // b.a.p0.a.h0.g.k, com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            if (L3()) {
                R3("vplayend");
            }
            b.a.p0.a.i1.g.a aVar = this.L0;
            if (aVar != null) {
                aVar.onDestroy();
            }
            if (!this.i1) {
                r2(0);
            }
            super.onDestroy();
        }
    }

    @Override // b.a.p0.a.h0.g.d, com.baidu.swan.support.v4.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            super.onPause();
            O3();
        }
    }

    @Override // b.a.p0.a.h0.g.d, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            super.onResume();
            b.a.p0.a.q.e.b bVar = this.y1;
            if (bVar == null || !bVar.l() || m0()) {
                return;
            }
            Q3();
        }
    }

    @Override // b.a.p0.a.h0.g.k, com.baidu.swan.support.v4.app.Fragment
    public View w0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048604, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(b.a.p0.a.g.aiapps_webview_fragment, viewGroup, false);
            K1(inflate);
            this.l1 = (ViewGroup) inflate.findViewById(b.a.p0.a.f.swan_app_webview_fragment);
            this.N0 = (FrameLayout) inflate.findViewById(b.a.p0.a.f.aiapps_webView_container);
            G3();
            I3();
            B3(this.j1);
            H3();
            if (L3()) {
                F3();
                E3();
            }
            if (J1()) {
                inflate = M1(inflate);
            }
            this.M0 = new b.a.p0.f.i.q.c(getContext(), this.f1);
            R3("lpin");
            return u1(inflate, this);
        }
        return (View) invokeLLL.objValue;
    }

    public final void z3(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048605, this, z) == null) {
            this.n0.setLeftHomeViewVisibility(z ? 0 : 8);
        }
    }
}
