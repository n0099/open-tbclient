package com.baidu.tbadk.core.view.breathetip;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import com.airbnb.lottie.L;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.view.breathetip.tipview.BreatheTipView;
import com.baidu.tieba.d45;
import com.baidu.tieba.e45;
import com.baidu.tieba.f45;
import com.baidu.tieba.g45;
import com.baidu.tieba.h45;
import com.baidu.tieba.i45;
import com.baidu.tieba.jg;
import com.baidu.tieba.xe;
import com.baidu.tieba.ye;
import com.baidu.tieba.ze;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class BreatheTipWidget {
    public static /* synthetic */ Interceptable $ic;
    public static boolean h;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context a;
    public ye b;
    public h45 c;
    public BreatheTipView d;
    public View e;
    public i45 f;
    public final Runnable g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-2019225915, "Lcom/baidu/tbadk/core/view/breathetip/BreatheTipWidget;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-2019225915, "Lcom/baidu/tbadk/core/view/breathetip/BreatheTipWidget;");
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
    public static final class PointType {
        public static final /* synthetic */ PointType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final PointType DRAWABLE;
        public static final PointType LOTTIE;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1951397343, "Lcom/baidu/tbadk/core/view/breathetip/BreatheTipWidget$PointType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1951397343, "Lcom/baidu/tbadk/core/view/breathetip/BreatheTipWidget$PointType;");
                    return;
                }
            }
            LOTTIE = new PointType(L.TAG, 0);
            PointType pointType = new PointType("DRAWABLE", 1);
            DRAWABLE = pointType;
            $VALUES = new PointType[]{LOTTIE, pointType};
        }

        public PointType(String str, int i) {
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

        public static PointType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (PointType) Enum.valueOf(PointType.class, str);
            }
            return (PointType) invokeL.objValue;
        }

        public static PointType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (PointType[]) $VALUES.clone();
            }
            return (PointType[]) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BreatheTipWidget a;

        public a(BreatheTipWidget breatheTipWidget) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {breatheTipWidget};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = breatheTipWidget;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.d();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements ze.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BreatheTipWidget a;

        public b(BreatheTipWidget breatheTipWidget) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {breatheTipWidget};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = breatheTipWidget;
        }

        @Override // com.baidu.tieba.ze.a
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean unused = BreatheTipWidget.h = false;
                this.a.c.onDismiss();
            }
        }

        @Override // com.baidu.tieba.ze.a
        public void onShown() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.c.onShow();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements xe {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BreatheTipWidget a;

        public c(BreatheTipWidget breatheTipWidget) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {breatheTipWidget};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = breatheTipWidget;
        }

        @Override // com.baidu.tieba.xe
        public View c(LayoutInflater layoutInflater) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, layoutInflater)) == null) {
                if (this.a.f != null) {
                    return this.a.f.e();
                }
                return null;
            }
            return (View) invokeL.objValue;
        }

        @Override // com.baidu.tieba.xe
        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.a.f != null) {
                    return this.a.f.c();
                }
                return 0;
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.xe
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.a.f != null) {
                    return this.a.f.d();
                }
                return 0;
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.xe
        public int getXOffset() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                if (this.a.f != null) {
                    return this.a.f.f();
                }
                return 0;
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.xe
        public int getYOffset() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                if (this.a.f != null) {
                    return this.a.f.g();
                }
                return 0;
            }
            return invokeV.intValue;
        }
    }

    public BreatheTipWidget(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.g = new a(this);
        this.a = context;
    }

    public BreatheTipWidget g(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2)) == null) {
            this.e = view2;
            return this;
        }
        return (BreatheTipWidget) invokeL.objValue;
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            return h;
        }
        return invokeV.booleanValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ye yeVar = this.b;
            if (yeVar != null) {
                yeVar.d();
            }
            jg.a().removeCallbacks(this.g);
        }
    }

    public BreatheTipWidget f(e45 e45Var, d45 d45Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, e45Var, d45Var)) == null) {
            PointType pointType = d45Var.a;
            if (pointType == PointType.LOTTIE) {
                this.c = new f45(this.a);
            } else if (pointType == PointType.DRAWABLE) {
                this.c = new g45(this.a);
            }
            if (this.d == null) {
                this.d = new BreatheTipView(this.a);
            }
            h45 h45Var = this.c;
            if (h45Var != null) {
                h45Var.a(d45Var);
            }
            BreatheTipView breatheTipView = this.d;
            if (breatheTipView != null) {
                breatheTipView.setData(e45Var);
            }
            return this;
        }
        return (BreatheTipWidget) invokeLL.objValue;
    }

    public boolean h(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, activity)) == null) {
            if (h || this.e == null) {
                return false;
            }
            h = true;
            i45 i45Var = new i45();
            this.f = i45Var;
            i45Var.h(this.d, this.c, this.e);
            ze zeVar = new ze();
            zeVar.c(0);
            zeVar.k(this.e);
            zeVar.i(true);
            zeVar.j(true);
            zeVar.d(true);
            zeVar.h(new b(this));
            zeVar.a(new c(this));
            ye b2 = zeVar.b();
            this.b = b2;
            b2.k(false);
            this.b.l(true);
            this.b.n(activity, false);
            jg.a().postDelayed(this.g, 4000L);
            return true;
        }
        return invokeL.booleanValue;
    }
}
