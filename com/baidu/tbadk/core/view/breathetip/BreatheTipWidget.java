package com.baidu.tbadk.core.view.breathetip;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import com.airbnb.lottie.L;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.view.breathetip.tipview.BreatheTipView;
import com.baidu.tieba.a65;
import com.baidu.tieba.b65;
import com.baidu.tieba.c65;
import com.baidu.tieba.sa;
import com.baidu.tieba.ta;
import com.baidu.tieba.ua;
import com.baidu.tieba.x55;
import com.baidu.tieba.y55;
import com.baidu.tieba.z55;
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
    public static boolean j;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context a;
    public ta b;
    public b65 c;
    public BreatheTipView d;
    public View e;
    public c65 f;
    public FromType g;
    public boolean h;
    public final Runnable i;

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
    public class b implements ua.a {
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
                    boolean unused = BreatheTipWidget.j = false;
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

        @Override // com.baidu.tieba.ua.a
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.g != FromType.GOD) {
                    boolean unused = BreatheTipWidget.j = false;
                } else {
                    SafeHandler.getInst().postDelayed(new a(this), 500L);
                }
                this.a.c.onDismiss();
            }
        }

        @Override // com.baidu.tieba.ua.a
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
            DEFAULT = new FromType("DEFAULT", 0);
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
    public class c implements sa {
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

        @Override // com.baidu.tieba.sa
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

        @Override // com.baidu.tieba.sa
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

        @Override // com.baidu.tieba.sa
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

        @Override // com.baidu.tieba.sa
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

        @Override // com.baidu.tieba.sa
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
        this.g = FromType.DEFAULT;
        this.h = true;
        this.i = new a(this);
        this.a = context;
    }

    public BreatheTipWidget g(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
            this.h = z;
            return this;
        }
        return (BreatheTipWidget) invokeZ.objValue;
    }

    public BreatheTipWidget i(FromType fromType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, fromType)) == null) {
            this.g = fromType;
            return this;
        }
        return (BreatheTipWidget) invokeL.objValue;
    }

    public BreatheTipWidget j(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, view2)) == null) {
            this.e = view2;
            return this;
        }
        return (BreatheTipWidget) invokeL.objValue;
    }

    public static boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            return j;
        }
        return invokeV.booleanValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ta taVar = this.b;
            if (taVar != null) {
                taVar.d();
            }
            SafeHandler.getInst().removeCallbacks(this.i);
        }
    }

    public BreatheTipWidget h(y55 y55Var, x55 x55Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, y55Var, x55Var)) == null) {
            PointType pointType = x55Var.a;
            if (pointType == PointType.LOTTIE) {
                this.c = new z55(this.a);
            } else if (pointType == PointType.DRAWABLE) {
                this.c = new a65(this.a);
            }
            if (this.d == null) {
                this.d = new BreatheTipView(this.a);
            }
            b65 b65Var = this.c;
            if (b65Var != null) {
                b65Var.a(x55Var);
            }
            BreatheTipView breatheTipView = this.d;
            if (breatheTipView != null) {
                breatheTipView.setData(y55Var);
            }
            return this;
        }
        return (BreatheTipWidget) invokeLL.objValue;
    }

    public boolean k(Activity activity, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048581, this, activity, j2)) == null) {
            if (j || this.e == null) {
                return false;
            }
            j = true;
            c65 c65Var = new c65();
            this.f = c65Var;
            c65Var.h(this.d, this.c, this.e);
            ua uaVar = new ua();
            uaVar.c(0);
            uaVar.k(this.e);
            uaVar.i(true);
            uaVar.j(true);
            uaVar.d(this.h);
            uaVar.h(new b(this));
            uaVar.a(new c(this));
            ta b2 = uaVar.b();
            this.b = b2;
            b2.k(false);
            this.b.l(true);
            this.b.o(activity, false);
            SafeHandler.getInst().postDelayed(this.i, j2);
            return true;
        }
        return invokeLJ.booleanValue;
    }
}
