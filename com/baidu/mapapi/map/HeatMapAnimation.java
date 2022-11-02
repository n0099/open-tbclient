package com.baidu.mapapi.map;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class HeatMapAnimation {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public AnimationType b;
    public boolean c;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
    public static final class AnimationType {
        public static /* synthetic */ Interceptable $ic;
        public static final AnimationType CosineCurve;
        public static final AnimationType InBack;
        public static final AnimationType InBounce;
        public static final AnimationType InCirc;
        public static final AnimationType InCubic;
        public static final AnimationType InCurve;
        public static final AnimationType InElastic;
        public static final AnimationType InExpo;
        public static final AnimationType InOutBack;
        public static final AnimationType InOutBounce;
        public static final AnimationType InOutCirc;
        public static final AnimationType InOutCubic;
        public static final AnimationType InOutElastic;
        public static final AnimationType InOutExpo;
        public static final AnimationType InOutQuad;
        public static final AnimationType InOutQuart;
        public static final AnimationType InOutQuint;
        public static final AnimationType InOutSine;
        public static final AnimationType InQuad;
        public static final AnimationType InQuart;
        public static final AnimationType InQuint;
        public static final AnimationType InSine;
        public static final AnimationType Linear;
        public static final AnimationType OutBack;
        public static final AnimationType OutBounce;
        public static final AnimationType OutCirc;
        public static final AnimationType OutCubic;
        public static final AnimationType OutCurve;
        public static final AnimationType OutElastic;
        public static final AnimationType OutExpo;
        public static final AnimationType OutInBack;
        public static final AnimationType OutInBounce;
        public static final AnimationType OutInCirc;
        public static final AnimationType OutInCubic;
        public static final AnimationType OutInElastic;
        public static final AnimationType OutInExpo;
        public static final AnimationType OutInQuad;
        public static final AnimationType OutInQuart;
        public static final AnimationType OutInQuint;
        public static final AnimationType OutInSine;
        public static final AnimationType OutQuad;
        public static final AnimationType OutQuart;
        public static final AnimationType OutQuint;
        public static final AnimationType OutSine;
        public static final AnimationType SineCurve;
        public static final /* synthetic */ AnimationType[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1648276531, "Lcom/baidu/mapapi/map/HeatMapAnimation$AnimationType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1648276531, "Lcom/baidu/mapapi/map/HeatMapAnimation$AnimationType;");
                    return;
                }
            }
            Linear = new AnimationType("Linear", 0);
            InQuad = new AnimationType("InQuad", 1);
            OutQuad = new AnimationType("OutQuad", 2);
            InOutQuad = new AnimationType("InOutQuad", 3);
            OutInQuad = new AnimationType("OutInQuad", 4);
            InCubic = new AnimationType("InCubic", 5);
            OutCubic = new AnimationType("OutCubic", 6);
            InOutCubic = new AnimationType("InOutCubic", 7);
            OutInCubic = new AnimationType("OutInCubic", 8);
            InQuart = new AnimationType("InQuart", 9);
            OutQuart = new AnimationType("OutQuart", 10);
            InOutQuart = new AnimationType("InOutQuart", 11);
            OutInQuart = new AnimationType("OutInQuart", 12);
            InQuint = new AnimationType("InQuint", 13);
            OutQuint = new AnimationType("OutQuint", 14);
            InOutQuint = new AnimationType("InOutQuint", 15);
            OutInQuint = new AnimationType("OutInQuint", 16);
            InSine = new AnimationType("InSine", 17);
            OutSine = new AnimationType("OutSine", 18);
            InOutSine = new AnimationType("InOutSine", 19);
            OutInSine = new AnimationType("OutInSine", 20);
            InExpo = new AnimationType("InExpo", 21);
            OutExpo = new AnimationType("OutExpo", 22);
            InOutExpo = new AnimationType("InOutExpo", 23);
            OutInExpo = new AnimationType("OutInExpo", 24);
            InCirc = new AnimationType("InCirc", 25);
            OutCirc = new AnimationType("OutCirc", 26);
            InOutCirc = new AnimationType("InOutCirc", 27);
            OutInCirc = new AnimationType("OutInCirc", 28);
            InElastic = new AnimationType("InElastic", 29);
            OutElastic = new AnimationType("OutElastic", 30);
            InOutElastic = new AnimationType("InOutElastic", 31);
            OutInElastic = new AnimationType("OutInElastic", 32);
            InBack = new AnimationType("InBack", 33);
            OutBack = new AnimationType("OutBack", 34);
            InOutBack = new AnimationType("InOutBack", 35);
            OutInBack = new AnimationType("OutInBack", 36);
            InBounce = new AnimationType("InBounce", 37);
            OutBounce = new AnimationType("OutBounce", 38);
            InOutBounce = new AnimationType("InOutBounce", 39);
            OutInBounce = new AnimationType("OutInBounce", 40);
            InCurve = new AnimationType("InCurve", 41);
            OutCurve = new AnimationType("OutCurve", 42);
            SineCurve = new AnimationType("SineCurve", 43);
            AnimationType animationType = new AnimationType("CosineCurve", 44);
            CosineCurve = animationType;
            a = new AnimationType[]{Linear, InQuad, OutQuad, InOutQuad, OutInQuad, InCubic, OutCubic, InOutCubic, OutInCubic, InQuart, OutQuart, InOutQuart, OutInQuart, InQuint, OutQuint, InOutQuint, OutInQuint, InSine, OutSine, InOutSine, OutInSine, InExpo, OutExpo, InOutExpo, OutInExpo, InCirc, OutCirc, InOutCirc, OutInCirc, InElastic, OutElastic, InOutElastic, OutInElastic, InBack, OutBack, InOutBack, OutInBack, InBounce, OutBounce, InOutBounce, OutInBounce, InCurve, OutCurve, SineCurve, animationType};
        }

        public AnimationType(String str, int i) {
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

        public static AnimationType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (AnimationType) Enum.valueOf(AnimationType.class, str);
            }
            return (AnimationType) invokeL.objValue;
        }

        public static AnimationType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (AnimationType[]) a.clone();
            }
            return (AnimationType[]) invokeV.objValue;
        }
    }

    public HeatMapAnimation(boolean z, int i, AnimationType animationType) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z), Integer.valueOf(i), animationType};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 100;
        this.b = AnimationType.Linear;
        if (i >= 0) {
            this.a = i;
        }
        this.b = animationType;
        this.c = z;
    }

    public int getAnimationType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.b.ordinal();
        }
        return invokeV.intValue;
    }

    public int getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.a;
        }
        return invokeV.intValue;
    }

    public boolean getIsAnimation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.c;
        }
        return invokeV.booleanValue;
    }

    public void setAnimation(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.c = z;
        }
    }

    public void setAnimationType(AnimationType animationType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, animationType) == null) {
            this.b = animationType;
        }
    }

    public void setDuration(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.a = i;
        }
    }
}
