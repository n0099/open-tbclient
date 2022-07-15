package com.baidu.swan.games.view.desktopguide;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.Log;
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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.menu.PopupWindow;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.a73;
import com.repackage.be3;
import com.repackage.el2;
import com.repackage.h03;
import com.repackage.i34;
import com.repackage.j34;
import com.repackage.os1;
import com.repackage.p83;
import com.repackage.r72;
import com.repackage.rg1;
import com.repackage.s24;
import com.repackage.so1;
import com.repackage.u53;
import com.repackage.v83;
import com.repackage.yd3;
import com.repackage.z24;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public class DesktopGuideApi implements j34 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean n;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile os1 b;
    public volatile DesktopGuideType c;
    public PopupWindow d;
    public Runnable e;
    public AtomicBoolean f;
    public z24 g;
    public volatile long h;
    public volatile long i;
    public volatile long j;
    public long k;
    public long l;
    public long m;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
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

        public DesktopApiStatus(String str, int i, boolean z, int i2, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2), str2};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str3 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.success = z;
            this.statusCode = i2;
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
    /* loaded from: classes2.dex */
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
            BAR = new DesktopGuideType("BAR", 0, "bar", -1, 992, "desk_flow", R.string.obfuscated_res_0x7f0f133f);
            DesktopGuideType desktopGuideType = new DesktopGuideType("BAR_AUTOHIDE", 1, "bar-autohide", -1, 865, "desk_flow_close", R.string.obfuscated_res_0x7f0f133f);
            BAR_AUTOHIDE = desktopGuideType;
            $VALUES = new DesktopGuideType[]{BAR, desktopGuideType};
        }

        public DesktopGuideType(String str, int i, String str2, int i2, @StringRes int i3, String str3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i), str2, Integer.valueOf(i2), Integer.valueOf(i3), str3, Integer.valueOf(i4)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str4 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.typeName = str2;
            this.limit = i2;
            this.showWidth4px = i3;
            this.ubcType = str3;
            this.defaultText = i4;
        }

        public static DesktopGuideType parse(String str) {
            InterceptResult invokeL;
            DesktopGuideType[] values;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) {
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

    /* loaded from: classes2.dex */
    public class a implements so1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DesktopGuideApi a;

        public a(DesktopGuideApi desktopGuideApi) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {desktopGuideApi};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = desktopGuideApi;
        }

        @Override // com.repackage.so1.a
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.d != null && this.a.d.x()) {
                this.a.p();
                this.a.o(DesktopApiStatus.USER_CANCEL);
            }
        }

        @Override // com.repackage.so1.a
        public void b(int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) && i == 0 && this.a.d != null && this.a.d.x()) {
                this.a.p();
                this.a.o(DesktopApiStatus.USER_CANCEL);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DesktopGuideApi a;

        public b(DesktopGuideApi desktopGuideApi) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {desktopGuideApi};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = desktopGuideApi;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.p();
                this.a.o(DesktopApiStatus.USER_CANCEL);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppActivity a;
        public final /* synthetic */ h03 b;
        public final /* synthetic */ String c;
        public final /* synthetic */ Bitmap d;
        public final /* synthetic */ DesktopGuideApi e;

        public c(DesktopGuideApi desktopGuideApi, SwanAppActivity swanAppActivity, h03 h03Var, String str, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {desktopGuideApi, swanAppActivity, h03Var, str, bitmap};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = desktopGuideApi;
            this.a = swanAppActivity;
            this.b = h03Var;
            this.c = str;
            this.d = bitmap;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                DesktopGuideApi desktopGuideApi = this.e;
                desktopGuideApi.w(this.a, this.b, desktopGuideApi.c, this.c, this.d);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DesktopGuideType a;
        public final /* synthetic */ DesktopGuideApi b;

        public d(DesktopGuideApi desktopGuideApi, DesktopGuideType desktopGuideType) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {desktopGuideApi, desktopGuideType};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = desktopGuideApi;
            this.a = desktopGuideType;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.b.p();
                this.b.o(DesktopApiStatus.USER_CANCEL);
                a73.f(this.a.ubcType, "flow_close_close", "click");
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ h03 b;
        public final /* synthetic */ DesktopGuideType c;
        public final /* synthetic */ DesktopGuideApi d;

        public e(DesktopGuideApi desktopGuideApi, Activity activity, h03 h03Var, DesktopGuideType desktopGuideType) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {desktopGuideApi, activity, h03Var, desktopGuideType};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = desktopGuideApi;
            this.a = activity;
            this.b = h03Var;
            this.c = desktopGuideType;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.d.p();
                this.d.m(this.a, this.b);
                a73.f(this.c.ubcType, "desk_flow".equals(this.c.ubcType) ? "flow_close_add" : "flow_add", "click");
            }
        }
    }

    /* loaded from: classes2.dex */
    public class f implements PopupWindow.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DesktopGuideApi a;

        public f(DesktopGuideApi desktopGuideApi) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {desktopGuideApi};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = desktopGuideApi;
        }

        @Override // com.baidu.swan.menu.PopupWindow.b
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.f.set(false);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DesktopGuideApi a;

        public g(DesktopGuideApi desktopGuideApi) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {desktopGuideApi};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = desktopGuideApi;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.d == null) {
                return;
            }
            this.a.d.r();
            this.a.d = null;
        }
    }

    /* loaded from: classes2.dex */
    public class h implements u53.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h03 a;
        public final /* synthetic */ DesktopGuideApi b;

        public h(DesktopGuideApi desktopGuideApi, h03 h03Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {desktopGuideApi, h03Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = desktopGuideApi;
            this.a = h03Var;
        }

        @Override // com.repackage.u53.f
        public void a(int i) {
            DesktopApiStatus desktopApiStatus;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (i == -1) {
                    desktopApiStatus = DesktopApiStatus.ADD_UNKNOWN;
                    str = "desk_notknown";
                } else if (i != 1) {
                    desktopApiStatus = DesktopApiStatus.ADD_FAIL;
                    if (this.b.j + 1 < 3) {
                        DesktopGuideApi desktopGuideApi = this.b;
                        desktopGuideApi.u(this.a, desktopGuideApi.h, this.b.i, this.b.j + 1);
                    }
                    str = "desk_fail";
                } else {
                    desktopApiStatus = DesktopApiStatus.ADD_SUCCESS;
                    str = "desk_success";
                }
                this.b.o(desktopApiStatus);
                a73.f(this.b.c.ubcType, str, "click");
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
        n = rg1.a;
    }

    public DesktopGuideApi(r72 r72Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {r72Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f = new AtomicBoolean(false);
        x();
        q();
    }

    public final void m(@NonNull Context context, @NonNull h03 h03Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, h03Var) == null) {
            el2.a Y = h03Var.Y();
            if (Y == null) {
                o(DesktopApiStatus.EXEC_FAILURE);
            } else {
                u53.k(context, Y, new h(this, h03Var));
            }
        }
    }

    public final void n(ViewGroup viewGroup, DesktopGuideType desktopGuideType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup, desktopGuideType) == null) {
            ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
            int i = desktopGuideType.showWidth4px;
            int g2 = yd3.g(7.0f);
            int o = yd3.o(null);
            int i2 = g2 * 2;
            if (o - i < i2) {
                i = o - i2;
            }
            layoutParams.width = i;
            viewGroup.setLayoutParams(layoutParams);
        }
    }

    @AnyThread
    public final void o(DesktopApiStatus desktopApiStatus) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, desktopApiStatus) == null) || this.b == null) {
            return;
        }
        s24.call(this.b, desktopApiStatus.success, new i34(desktopApiStatus.statusCode, desktopApiStatus.statusMsg));
    }

    @AnyThread
    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            Runnable runnable = this.e;
            if (runnable != null) {
                be3.d0(runnable);
            }
            be3.e0(new g(this));
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.e = new b(this);
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.g == null) {
            z24 c2 = z24.c();
            this.g = c2;
            if (c2 != null) {
                c2.a(new a(this));
            }
        }
    }

    public final boolean s(@NonNull Context context, @NonNull h03 h03Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, context, h03Var)) == null) ? u53.s(context, h03Var.Z(), h03Var.b) == 1 : invokeLL.booleanValue;
    }

    public final void t(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            String string = v83.a().getString(str, "");
            String[] split = string.split("#");
            if (split.length == 3 && TextUtils.isDigitsOnly(split[0]) && TextUtils.isDigitsOnly(split[1]) && TextUtils.isDigitsOnly(split[2])) {
                this.h = Long.parseLong(split[0]);
                this.i = Long.parseLong(split[1]);
                this.j = Long.parseLong(split[2]);
            }
            if (n) {
                Log.d("ShowAddToDesktopGuide", "duration=" + this.k + ", mIntervalDays=" + this.l + ", mMaxTimes=" + this.m + " ,storageValue=" + string);
            }
        }
    }

    public final void u(@NonNull h03 h03Var, long j, long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{h03Var, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            p83 a2 = v83.a();
            a2.putString("desktop_guide_count_" + h03Var.b, j + "#" + j2 + "#" + j3);
        }
    }

    public void v(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, jsObject) == null) {
            os1 F = os1.F(jsObject);
            if (F == null) {
                F = new os1();
            }
            this.b = F;
            h03 M = h03.M();
            if (M == null) {
                o(DesktopApiStatus.EXEC_FAILURE);
                return;
            }
            SwanAppActivity w = M.w();
            if (w == null) {
                o(DesktopApiStatus.EXEC_FAILURE);
                return;
            }
            this.c = DesktopGuideType.parse(F.B("type"));
            String B = F.B("content");
            if (TextUtils.isEmpty(B)) {
                B = w.getString(this.c.defaultText);
            }
            if (s(w, M)) {
                o(DesktopApiStatus.ALREADY_IN_DESKTOP);
                return;
            }
            t("desktop_guide_count_" + M.b);
            long currentTimeMillis = System.currentTimeMillis();
            if (this.h < this.m && currentTimeMillis - this.i > this.l * 86400000) {
                if (this.f.get()) {
                    o(DesktopApiStatus.REACH_MAX_TIMES);
                    return;
                }
                this.f.set(true);
                u(M, 1 + this.h, currentTimeMillis, 0L);
                be3.e0(new c(this, w, M, B, be3.i(M.Y(), "ShowAddToDesktopGuide", false)));
                return;
            }
            o(DesktopApiStatus.REACH_MAX_TIMES);
        }
    }

    @UiThread
    public final void w(@NonNull Activity activity, @NonNull h03 h03Var, @NonNull DesktopGuideType desktopGuideType, @NonNull String str, Bitmap bitmap) {
        Runnable runnable;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048586, this, activity, h03Var, desktopGuideType, str, bitmap) == null) {
            r();
            z24 z24Var = this.g;
            if (z24Var != null) {
                z24Var.b(1);
            }
            View inflate = LayoutInflater.from(activity).inflate(R.layout.obfuscated_res_0x7f0d00a1, (ViewGroup) null, false);
            TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f09095b);
            if (desktopGuideType.limit != -1 && str.length() > desktopGuideType.limit) {
                str = str.substring(0, desktopGuideType.limit - 1) + StringHelper.STRING_MORE;
            }
            textView.setText(str);
            n((ViewGroup) inflate.findViewById(R.id.obfuscated_res_0x7f09095a), desktopGuideType);
            ImageView imageView = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f09095c);
            if (bitmap != null) {
                imageView.setImageBitmap(bitmap);
            } else {
                imageView.setImageResource(R.drawable.obfuscated_res_0x7f08013e);
            }
            ImageView imageView2 = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f090959);
            if (desktopGuideType == DesktopGuideType.BAR_AUTOHIDE) {
                imageView2.setVisibility(8);
            } else {
                imageView2.setOnClickListener(new d(this, desktopGuideType));
            }
            Button button = (Button) inflate.findViewById(R.id.obfuscated_res_0x7f090957);
            button.setText(R.string.obfuscated_res_0x7f0f0164);
            button.setOnClickListener(new e(this, activity, h03Var, desktopGuideType));
            PopupWindow popupWindow = new PopupWindow(inflate, -1, -2);
            this.d = popupWindow;
            popupWindow.L(16);
            this.d.O(activity.getWindow().getDecorView(), 81, 0, yd3.g(50.0f));
            this.d.I(new f(this));
            if (desktopGuideType == DesktopGuideType.BAR_AUTOHIDE && (runnable = this.e) != null) {
                be3.d0(runnable);
                be3.b0(this.e, this.k * 1000);
            }
            a73.f(desktopGuideType.ubcType, j34.a, "show");
        }
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            p83 a2 = v83.a();
            this.k = a2.getLong("swan_favorite_guide_duration", 3L);
            this.l = a2.getLong("swan_favorite_guide_intervalDays", 3L);
            this.m = a2.getLong("swan_favorite_guide_maxTimes", 3L);
        }
    }
}
