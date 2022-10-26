package com.baidu.mapapi.animation;

import android.view.animation.Interpolator;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.animation.Animation;
import com.baidu.mapsdkplatform.comapi.a.c;
import com.baidu.mapsdkplatform.comapi.a.j;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class SingleScaleAnimation extends Animation {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
    public final class ScaleType {
        public static /* synthetic */ Interceptable $ic;
        public static final ScaleType SCALE_X;
        public static final ScaleType SCALE_Y;
        public static final /* synthetic */ ScaleType[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(960618027, "Lcom/baidu/mapapi/animation/SingleScaleAnimation$ScaleType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(960618027, "Lcom/baidu/mapapi/animation/SingleScaleAnimation$ScaleType;");
                    return;
                }
            }
            SCALE_X = new ScaleType("SCALE_X", 0);
            ScaleType scaleType = new ScaleType("SCALE_Y", 1);
            SCALE_Y = scaleType;
            a = new ScaleType[]{SCALE_X, scaleType};
        }

        public ScaleType(String str, int i) {
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

        public static ScaleType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (ScaleType) Enum.valueOf(ScaleType.class, str) : (ScaleType) invokeL.objValue;
        }

        public static ScaleType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (ScaleType[]) a.clone() : (ScaleType[]) invokeV.objValue;
        }
    }

    public SingleScaleAnimation(ScaleType scaleType, float... fArr) {
        j jVar;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {scaleType, fArr};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (fArr == null || fArr.length == 0) {
            throw new NullPointerException("BDMapSDKException: the scales is null");
        }
        if (scaleType == ScaleType.SCALE_X) {
            jVar = new j(1, fArr);
        } else if (scaleType != ScaleType.SCALE_Y) {
            return;
        } else {
            jVar = new j(2, fArr);
        }
        this.bdAnimation = jVar;
    }

    @Override // com.baidu.mapapi.animation.Animation
    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.bdAnimation.b();
        }
    }

    @Override // com.baidu.mapapi.animation.Animation
    public void setAnimationListener(Animation.AnimationListener animationListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animationListener) == null) {
            this.bdAnimation.a(animationListener);
        }
    }

    @Override // com.baidu.mapapi.animation.Animation
    public void setDuration(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j) == null) {
            this.bdAnimation.a(j);
        }
    }

    @Override // com.baidu.mapapi.animation.Animation
    public void setInterpolator(Interpolator interpolator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, interpolator) == null) {
            this.bdAnimation.a(interpolator);
        }
    }

    public void setRepeatCount(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.bdAnimation.b(i);
        }
    }

    public void setRepeatMode(Animation.RepeatMode repeatMode) {
        c cVar;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, repeatMode) == null) {
            if (repeatMode == Animation.RepeatMode.RESTART) {
                cVar = this.bdAnimation;
                i = 1;
            } else if (repeatMode != Animation.RepeatMode.REVERSE) {
                return;
            } else {
                cVar = this.bdAnimation;
                i = 2;
            }
            cVar.a(i);
        }
    }
}
