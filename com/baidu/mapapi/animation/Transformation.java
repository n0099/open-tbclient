package com.baidu.mapapi.animation;

import android.graphics.Point;
import android.view.animation.Interpolator;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.animation.Animation;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapsdkplatform.comapi.a.c;
import com.baidu.mapsdkplatform.comapi.a.l;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class Transformation extends Animation {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public Transformation(Point... pointArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pointArr};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (pointArr == null || pointArr.length == 0) {
            throw new NullPointerException("BDMapSDKException: the points is null");
        }
        this.bdAnimation = new l(pointArr);
    }

    public Transformation(LatLng... latLngArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {latLngArr};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (latLngArr == null || latLngArr.length == 0) {
            throw new NullPointerException("BDMapSDKException: the latlngs is null");
        }
        this.bdAnimation = new l(latLngArr);
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

    public void setRepeatCount(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.bdAnimation.b(i2);
        }
    }

    public void setRepeatMode(Animation.RepeatMode repeatMode) {
        c cVar;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, repeatMode) == null) {
            if (repeatMode == Animation.RepeatMode.RESTART) {
                cVar = this.bdAnimation;
                i2 = 1;
            } else if (repeatMode != Animation.RepeatMode.REVERSE) {
                return;
            } else {
                cVar = this.bdAnimation;
                i2 = 2;
            }
            cVar.a(i2);
        }
    }
}
