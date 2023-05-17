package com.baidu.tbadk.core.view.breathetip;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import com.airbnb.lottie.L;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.network.outback.EngineName;
import com.baidu.tbadk.core.view.breathetip.tipview.BreatheTipView;
import com.baidu.tieba.Cif;
import com.baidu.tieba.g75;
import com.baidu.tieba.gf;
import com.baidu.tieba.h75;
import com.baidu.tieba.hf;
import com.baidu.tieba.i75;
import com.baidu.tieba.j75;
import com.baidu.tieba.k75;
import com.baidu.tieba.l75;
import com.baidu.tieba.sg;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class BreatheTipWidget {
    public static /* synthetic */ Interceptable $ic;
    public static boolean i;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context a;
    public hf b;
    public k75 c;
    public BreatheTipView d;
    public View e;
    public l75 f;
    public FromType g;
    public final Runnable h;

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

    /* loaded from: classes4.dex */
    public class b implements Cif.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BreatheTipWidget a;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    boolean unused = BreatheTipWidget.i = false;
                }
            }
        }

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

        @Override // com.baidu.tieba.Cif.a
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.g != FromType.GOD) {
                    boolean unused = BreatheTipWidget.i = false;
                } else {
                    sg.a().postDelayed(new a(this), 500L);
                }
                this.a.c.onDismiss();
            }
        }

        @Override // com.baidu.tieba.Cif.a
        public void onShown() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.c.onShow();
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes4.dex */
    public static final class FromType {
        public static final /* synthetic */ FromType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final FromType DEFAULT;
        public static final FromType GOD;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-876724311, "Lcom/baidu/tbadk/core/view/breathetip/BreatheTipWidget$FromType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-876724311, "Lcom/baidu/tbadk/core/view/breathetip/BreatheTipWidget$FromType;");
                    return;
                }
            }
            DEFAULT = new FromType(EngineName.DEFAULT_ENGINE, 0);
            FromType fromType = new FromType("GOD", 1);
            GOD = fromType;
            $VALUES = new FromType[]{DEFAULT, fromType};
        }

        public FromType(String str, int i) {
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

        public static FromType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (FromType) Enum.valueOf(FromType.class, str);
            }
            return (FromType) invokeL.objValue;
        }

        public static FromType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (FromType[]) $VALUES.clone();
            }
            return (FromType[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
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
                this.a.e();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements gf {
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

        @Override // com.baidu.tieba.gf
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

        @Override // com.baidu.tieba.gf
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

        @Override // com.baidu.tieba.gf
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

        @Override // com.baidu.tieba.gf
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

        @Override // com.baidu.tieba.gf
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.g = FromType.DEFAULT;
        this.h = new a(this);
        this.a = context;
    }

    public BreatheTipWidget h(FromType fromType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, fromType)) == null) {
            this.g = fromType;
            return this;
        }
        return (BreatheTipWidget) invokeL.objValue;
    }

    public BreatheTipWidget i(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, view2)) == null) {
            this.e = view2;
            return this;
        }
        return (BreatheTipWidget) invokeL.objValue;
    }

    public static boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            return i;
        }
        return invokeV.booleanValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            hf hfVar = this.b;
            if (hfVar != null) {
                hfVar.d();
            }
            sg.a().removeCallbacks(this.h);
        }
    }

    public BreatheTipWidget g(h75 h75Var, g75 g75Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, h75Var, g75Var)) == null) {
            PointType pointType = g75Var.a;
            if (pointType == PointType.LOTTIE) {
                this.c = new i75(this.a);
            } else if (pointType == PointType.DRAWABLE) {
                this.c = new j75(this.a);
            }
            if (this.d == null) {
                this.d = new BreatheTipView(this.a);
            }
            k75 k75Var = this.c;
            if (k75Var != null) {
                k75Var.a(g75Var);
            }
            BreatheTipView breatheTipView = this.d;
            if (breatheTipView != null) {
                breatheTipView.setData(h75Var);
            }
            return this;
        }
        return (BreatheTipWidget) invokeLL.objValue;
    }

    public boolean j(Activity activity, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048580, this, activity, j)) == null) {
            if (i || this.e == null) {
                return false;
            }
            i = true;
            l75 l75Var = new l75();
            this.f = l75Var;
            l75Var.h(this.d, this.c, this.e);
            Cif cif = new Cif();
            cif.c(0);
            cif.k(this.e);
            cif.i(true);
            cif.j(true);
            cif.d(true);
            cif.h(new b(this));
            cif.a(new c(this));
            hf b2 = cif.b();
            this.b = b2;
            b2.k(false);
            this.b.l(true);
            this.b.n(activity, false);
            sg.a().postDelayed(this.h, j);
            return true;
        }
        return invokeLJ.booleanValue;
    }
}
