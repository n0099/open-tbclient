package com.baidu.swan.games.view.desktopguide;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.annotation.UiThread;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.f1.e.b;
import c.a.n0.a.f2.a;
import c.a.n0.a.j2.k;
import c.a.n0.a.u.e.d.a;
import c.a.n0.a.v2.n0;
import c.a.n0.a.v2.q0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.menu.PopupWindow;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public class DesktopGuideApi implements c.a.n0.h.o0.e.b {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean n;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public volatile c.a.n0.a.y.b.a f46847b;

    /* renamed from: c  reason: collision with root package name */
    public volatile DesktopGuideType f46848c;

    /* renamed from: d  reason: collision with root package name */
    public PopupWindow f46849d;

    /* renamed from: e  reason: collision with root package name */
    public Runnable f46850e;

    /* renamed from: f  reason: collision with root package name */
    public AtomicBoolean f46851f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.n0.h.o0.a f46852g;

    /* renamed from: h  reason: collision with root package name */
    public volatile long f46853h;

    /* renamed from: i  reason: collision with root package name */
    public volatile long f46854i;

    /* renamed from: j  reason: collision with root package name */
    public volatile long f46855j;
    public long k;
    public long l;
    public long m;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes6.dex */
    public static final class DesktopApiStatus {
        public static final /* synthetic */ DesktopApiStatus[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final DesktopApiStatus ADD_FAIL;
        public static final DesktopApiStatus ADD_SUCCESS;
        public static final DesktopApiStatus ADD_UNKNOWN;
        public static final DesktopApiStatus ALREADY_IN_DESKTOP;
        public static final DesktopApiStatus EXEC_FAILURE;
        public static final DesktopApiStatus REACH_MAX_TIMES;
        public static final DesktopApiStatus USER_CANCEL;
        public transient /* synthetic */ FieldHolder $fh;
        public int statusCode;
        public String statusMsg;
        public boolean success;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2144968094, "Lcom/baidu/swan/games/view/desktopguide/DesktopGuideApi$DesktopApiStatus;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(2144968094, "Lcom/baidu/swan/games/view/desktopguide/DesktopGuideApi$DesktopApiStatus;");
                    return;
                }
            }
            ALREADY_IN_DESKTOP = new DesktopApiStatus("ALREADY_IN_DESKTOP", 0, true, 1, "shortcut already in the desktop.");
            ADD_SUCCESS = new DesktopApiStatus("ADD_SUCCESS", 1, true, 2, "add shortcut to desktop success.");
            ADD_UNKNOWN = new DesktopApiStatus("ADD_UNKNOWN", 2, true, 3, "try to add but could not get the addition result.");
            EXEC_FAILURE = new DesktopApiStatus("EXEC_FAILURE", 3, false, -1, "api internal error.");
            REACH_MAX_TIMES = new DesktopApiStatus("REACH_MAX_TIMES", 4, false, -2, "reach max invoke times limit.");
            USER_CANCEL = new DesktopApiStatus("USER_CANCEL", 5, false, -3, "cancel by user.");
            DesktopApiStatus desktopApiStatus = new DesktopApiStatus("ADD_FAIL", 6, false, -4, "add shortcut to desktop failed.");
            ADD_FAIL = desktopApiStatus;
            $VALUES = new DesktopApiStatus[]{ALREADY_IN_DESKTOP, ADD_SUCCESS, ADD_UNKNOWN, EXEC_FAILURE, REACH_MAX_TIMES, USER_CANCEL, desktopApiStatus};
        }

        public DesktopApiStatus(String str, int i2, boolean z, int i3, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), Boolean.valueOf(z), Integer.valueOf(i3), str2};
                interceptable.invokeUnInit(65537, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str3 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.success = z;
            this.statusCode = i3;
            this.statusMsg = String.format(z ? "showAddToDesktopGuide: success, %s" : "showAddToDesktopGuide: fail, %s", str2);
        }

        public static DesktopApiStatus valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (DesktopApiStatus) Enum.valueOf(DesktopApiStatus.class, str) : (DesktopApiStatus) invokeL.objValue;
        }

        public static DesktopApiStatus[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (DesktopApiStatus[]) $VALUES.clone() : (DesktopApiStatus[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes6.dex */
    public static final class DesktopGuideType {
        public static final /* synthetic */ DesktopGuideType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final DesktopGuideType BAR;
        public static final DesktopGuideType BAR_AUTOHIDE;
        public transient /* synthetic */ FieldHolder $fh;
        @StringRes
        public int defaultText;
        public int limit;
        public int showWidth4px;
        public String typeName;
        public String ubcType;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2015056588, "Lcom/baidu/swan/games/view/desktopguide/DesktopGuideApi$DesktopGuideType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-2015056588, "Lcom/baidu/swan/games/view/desktopguide/DesktopGuideApi$DesktopGuideType;");
                    return;
                }
            }
            BAR = new DesktopGuideType("BAR", 0, "bar", -1, 992, "desk_flow", c.a.n0.f.g.swangame_desktop_guide_default_hint);
            DesktopGuideType desktopGuideType = new DesktopGuideType("BAR_AUTOHIDE", 1, "bar-autohide", -1, 865, "desk_flow_close", c.a.n0.f.g.swangame_desktop_guide_default_hint);
            BAR_AUTOHIDE = desktopGuideType;
            $VALUES = new DesktopGuideType[]{BAR, desktopGuideType};
        }

        public DesktopGuideType(String str, int i2, String str2, int i3, @StringRes int i4, String str3, int i5) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), str2, Integer.valueOf(i3), Integer.valueOf(i4), str3, Integer.valueOf(i5)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i6 = newInitContext.flag;
                if ((i6 & 1) != 0) {
                    int i7 = i6 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str4 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.typeName = str2;
            this.limit = i3;
            this.showWidth4px = i4;
            this.ubcType = str3;
            this.defaultText = i5;
        }

        public static DesktopGuideType parse(String str) {
            InterceptResult invokeL;
            DesktopGuideType[] values;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, str)) == null) {
                for (DesktopGuideType desktopGuideType : values()) {
                    if (TextUtils.equals(desktopGuideType.typeName, str)) {
                        return desktopGuideType;
                    }
                }
                return BAR;
            }
            return (DesktopGuideType) invokeL.objValue;
        }

        public static DesktopGuideType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) ? (DesktopGuideType) Enum.valueOf(DesktopGuideType.class, str) : (DesktopGuideType) invokeL.objValue;
        }

        public static DesktopGuideType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? (DesktopGuideType[]) $VALUES.clone() : (DesktopGuideType[]) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class a implements a.InterfaceC0378a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ DesktopGuideApi f46856a;

        public a(DesktopGuideApi desktopGuideApi) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {desktopGuideApi};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46856a = desktopGuideApi;
        }

        @Override // c.a.n0.a.u.e.d.a.InterfaceC0378a
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f46856a.f46849d != null && this.f46856a.f46849d.x()) {
                this.f46856a.p();
                this.f46856a.o(DesktopApiStatus.USER_CANCEL);
            }
        }

        @Override // c.a.n0.a.u.e.d.a.InterfaceC0378a
        public void b(int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) && i2 == 0 && this.f46856a.f46849d != null && this.f46856a.f46849d.x()) {
                this.f46856a.p();
                this.f46856a.o(DesktopApiStatus.USER_CANCEL);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ DesktopGuideApi f46857e;

        public b(DesktopGuideApi desktopGuideApi) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {desktopGuideApi};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46857e = desktopGuideApi;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f46857e.p();
                this.f46857e.o(DesktopApiStatus.USER_CANCEL);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppActivity f46858e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.a2.e f46859f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f46860g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Bitmap f46861h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ DesktopGuideApi f46862i;

        public c(DesktopGuideApi desktopGuideApi, SwanAppActivity swanAppActivity, c.a.n0.a.a2.e eVar, String str, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {desktopGuideApi, swanAppActivity, eVar, str, bitmap};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46862i = desktopGuideApi;
            this.f46858e = swanAppActivity;
            this.f46859f = eVar;
            this.f46860g = str;
            this.f46861h = bitmap;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                DesktopGuideApi desktopGuideApi = this.f46862i;
                desktopGuideApi.w(this.f46858e, this.f46859f, desktopGuideApi.f46848c, this.f46860g, this.f46861h);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ DesktopGuideType f46863e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ DesktopGuideApi f46864f;

        public d(DesktopGuideApi desktopGuideApi, DesktopGuideType desktopGuideType) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {desktopGuideApi, desktopGuideType};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46864f = desktopGuideApi;
            this.f46863e = desktopGuideType;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f46864f.p();
                this.f46864f.o(DesktopApiStatus.USER_CANCEL);
                k.f(this.f46863e.ubcType, "flow_close_close", PrefetchEvent.STATE_CLICK);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f46865e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.a2.e f46866f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ DesktopGuideType f46867g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ DesktopGuideApi f46868h;

        public e(DesktopGuideApi desktopGuideApi, Activity activity, c.a.n0.a.a2.e eVar, DesktopGuideType desktopGuideType) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {desktopGuideApi, activity, eVar, desktopGuideType};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46868h = desktopGuideApi;
            this.f46865e = activity;
            this.f46866f = eVar;
            this.f46867g = desktopGuideType;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f46868h.p();
                this.f46868h.m(this.f46865e, this.f46866f);
                k.f(this.f46867g.ubcType, "desk_flow".equals(this.f46867g.ubcType) ? "flow_close_add" : "flow_add", PrefetchEvent.STATE_CLICK);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements PopupWindow.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ DesktopGuideApi f46869a;

        public f(DesktopGuideApi desktopGuideApi) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {desktopGuideApi};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46869a = desktopGuideApi;
        }

        @Override // com.baidu.swan.menu.PopupWindow.b
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f46869a.f46851f.set(false);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ DesktopGuideApi f46870e;

        public g(DesktopGuideApi desktopGuideApi) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {desktopGuideApi};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46870e = desktopGuideApi;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f46870e.f46849d == null) {
                return;
            }
            this.f46870e.f46849d.r();
            this.f46870e.f46849d = null;
        }
    }

    /* loaded from: classes6.dex */
    public class h implements a.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.a2.e f46871a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ DesktopGuideApi f46872b;

        public h(DesktopGuideApi desktopGuideApi, c.a.n0.a.a2.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {desktopGuideApi, eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46872b = desktopGuideApi;
            this.f46871a = eVar;
        }

        @Override // c.a.n0.a.f2.a.f
        public void a(int i2) {
            DesktopApiStatus desktopApiStatus;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (i2 == -1) {
                    desktopApiStatus = DesktopApiStatus.ADD_UNKNOWN;
                    str = "desk_notknown";
                } else if (i2 != 1) {
                    desktopApiStatus = DesktopApiStatus.ADD_FAIL;
                    if (this.f46872b.f46855j + 1 < 3) {
                        DesktopGuideApi desktopGuideApi = this.f46872b;
                        desktopGuideApi.u(this.f46871a, desktopGuideApi.f46853h, this.f46872b.f46854i, this.f46872b.f46855j + 1);
                    }
                    str = "desk_fail";
                } else {
                    desktopApiStatus = DesktopApiStatus.ADD_SUCCESS;
                    str = "desk_success";
                }
                this.f46872b.o(desktopApiStatus);
                k.f(this.f46872b.f46848c.ubcType, str, PrefetchEvent.STATE_CLICK);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-538462652, "Lcom/baidu/swan/games/view/desktopguide/DesktopGuideApi;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-538462652, "Lcom/baidu/swan/games/view/desktopguide/DesktopGuideApi;");
                return;
            }
        }
        n = c.a.n0.a.k.f6803a;
    }

    public DesktopGuideApi(c.a.n0.a.l0.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f46851f = new AtomicBoolean(false);
        x();
        q();
    }

    public final void m(@NonNull Context context, @NonNull c.a.n0.a.a2.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, eVar) == null) {
            b.a N = eVar.N();
            if (N == null) {
                o(DesktopApiStatus.EXEC_FAILURE);
            } else {
                c.a.n0.a.f2.a.k(context, N, new h(this, eVar));
            }
        }
    }

    public final void n(ViewGroup viewGroup, DesktopGuideType desktopGuideType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup, desktopGuideType) == null) {
            ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
            int i2 = desktopGuideType.showWidth4px;
            int g2 = n0.g(7.0f);
            int o = n0.o(null);
            int i3 = g2 * 2;
            if (o - i2 < i3) {
                i2 = o - i3;
            }
            layoutParams.width = i2;
            viewGroup.setLayoutParams(layoutParams);
        }
    }

    @AnyThread
    public final void o(DesktopApiStatus desktopApiStatus) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, desktopApiStatus) == null) || this.f46847b == null) {
            return;
        }
        c.a.n0.h.m0.c.a(this.f46847b, desktopApiStatus.success, new c.a.n0.h.o0.e.a(desktopApiStatus.statusCode, desktopApiStatus.statusMsg));
    }

    @AnyThread
    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            Runnable runnable = this.f46850e;
            if (runnable != null) {
                q0.a0(runnable);
            }
            q0.b0(new g(this));
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f46850e = new b(this);
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.f46852g == null) {
            c.a.n0.h.o0.a d2 = c.a.n0.h.o0.a.d();
            this.f46852g = d2;
            if (d2 != null) {
                d2.b(new a(this));
            }
        }
    }

    public final boolean s(@NonNull Context context, @NonNull c.a.n0.a.a2.e eVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, context, eVar)) == null) ? c.a.n0.a.f2.a.s(context, eVar.O(), eVar.f4284f) == 1 : invokeLL.booleanValue;
    }

    public final void t(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            String string = c.a.n0.a.k2.g.h.a().getString(str, "");
            String[] split = string.split("#");
            if (split.length == 3 && TextUtils.isDigitsOnly(split[0]) && TextUtils.isDigitsOnly(split[1]) && TextUtils.isDigitsOnly(split[2])) {
                this.f46853h = Long.parseLong(split[0]);
                this.f46854i = Long.parseLong(split[1]);
                this.f46855j = Long.parseLong(split[2]);
            }
            if (n) {
                String str2 = "duration=" + this.k + ", mIntervalDays=" + this.l + ", mMaxTimes=" + this.m + " ,storageValue=" + string;
            }
        }
    }

    public final void u(@NonNull c.a.n0.a.a2.e eVar, long j2, long j3, long j4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{eVar, Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4)}) == null) {
            c.a.n0.a.k2.g.b a2 = c.a.n0.a.k2.g.h.a();
            a2.putString("desktop_guide_count_" + eVar.f4284f, j2 + "#" + j3 + "#" + j4);
        }
    }

    public void v(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, jsObject) == null) {
            c.a.n0.a.y.b.a G = c.a.n0.a.y.b.a.G(jsObject);
            if (G == null) {
                G = new c.a.n0.a.y.b.a();
            }
            this.f46847b = G;
            c.a.n0.a.a2.e i2 = c.a.n0.a.a2.e.i();
            if (i2 == null) {
                o(DesktopApiStatus.EXEC_FAILURE);
                return;
            }
            SwanAppActivity x = i2.x();
            if (x == null) {
                o(DesktopApiStatus.EXEC_FAILURE);
                return;
            }
            this.f46848c = DesktopGuideType.parse(G.C("type"));
            String C = G.C("content");
            if (TextUtils.isEmpty(C)) {
                C = x.getString(this.f46848c.defaultText);
            }
            if (s(x, i2)) {
                o(DesktopApiStatus.ALREADY_IN_DESKTOP);
                return;
            }
            t("desktop_guide_count_" + i2.f4284f);
            long currentTimeMillis = System.currentTimeMillis();
            if (this.f46853h < this.m && currentTimeMillis - this.f46854i > this.l * 86400000) {
                if (this.f46851f.get()) {
                    o(DesktopApiStatus.REACH_MAX_TIMES);
                    return;
                }
                this.f46851f.set(true);
                u(i2, 1 + this.f46853h, currentTimeMillis, 0L);
                q0.b0(new c(this, x, i2, C, q0.i(i2.N(), "ShowAddToDesktopGuide", false)));
                return;
            }
            o(DesktopApiStatus.REACH_MAX_TIMES);
        }
    }

    @UiThread
    public final void w(@NonNull Activity activity, @NonNull c.a.n0.a.a2.e eVar, @NonNull DesktopGuideType desktopGuideType, @NonNull String str, Bitmap bitmap) {
        Runnable runnable;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048586, this, activity, eVar, desktopGuideType, str, bitmap) == null) {
            r();
            c.a.n0.h.o0.a aVar = this.f46852g;
            if (aVar != null) {
                aVar.c(1);
            }
            View inflate = LayoutInflater.from(activity).inflate(c.a.n0.a.g.aiapps_favorite_guide_normal, (ViewGroup) null, false);
            TextView textView = (TextView) inflate.findViewById(c.a.n0.a.f.favorite_guide_content);
            if (desktopGuideType.limit != -1 && str.length() > desktopGuideType.limit) {
                str = str.substring(0, desktopGuideType.limit - 1) + "...";
            }
            textView.setText(str);
            n((ViewGroup) inflate.findViewById(c.a.n0.a.f.favorite_guide_container), desktopGuideType);
            ImageView imageView = (ImageView) inflate.findViewById(c.a.n0.a.f.favorite_guide_icon);
            if (bitmap != null) {
                imageView.setImageBitmap(bitmap);
            } else {
                imageView.setImageResource(c.a.n0.a.e.aiapps_default_grey_icon);
            }
            ImageView imageView2 = (ImageView) inflate.findViewById(c.a.n0.a.f.favorite_guide_close);
            if (desktopGuideType == DesktopGuideType.BAR_AUTOHIDE) {
                imageView2.setVisibility(8);
            } else {
                imageView2.setOnClickListener(new d(this, desktopGuideType));
            }
            Button button = (Button) inflate.findViewById(c.a.n0.a.f.favorite_guide_add_btn);
            button.setText(c.a.n0.f.g.aiapps_game_desktop_guide_add);
            button.setOnClickListener(new e(this, activity, eVar, desktopGuideType));
            PopupWindow popupWindow = new PopupWindow(inflate, -1, -2);
            this.f46849d = popupWindow;
            popupWindow.R(16);
            this.f46849d.U(activity.getWindow().getDecorView(), 81, 0, n0.g(50.0f));
            this.f46849d.P(new f(this));
            if (desktopGuideType == DesktopGuideType.BAR_AUTOHIDE && (runnable = this.f46850e) != null) {
                q0.a0(runnable);
                q0.Y(this.f46850e, this.k * 1000);
            }
            k.f(desktopGuideType.ubcType, c.a.n0.h.o0.e.b.f11152a, "show");
        }
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            c.a.n0.a.k2.g.b a2 = c.a.n0.a.k2.g.h.a();
            this.k = a2.getLong("swan_favorite_guide_duration", 3L);
            this.l = a2.getLong("swan_favorite_guide_intervalDays", 3L);
            this.m = a2.getLong("swan_favorite_guide_maxTimes", 3L);
        }
    }
}
