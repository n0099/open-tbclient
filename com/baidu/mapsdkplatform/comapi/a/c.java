package com.baidu.mapsdkplatform.comapi.a;

import android.animation.Animator;
import android.view.animation.Interpolator;
import com.baidu.mapapi.animation.Animation;
import com.baidu.mapapi.map.Marker;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public abstract class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public abstract void a();

    public abstract void a(int i2);

    public abstract void a(long j);

    public abstract void a(Animator animator);

    public abstract void a(Interpolator interpolator);

    public abstract void a(Animation.AnimationListener animationListener);

    public abstract void a(Marker marker, Animation animation);

    public abstract void b();

    public abstract void b(int i2);

    public abstract void c(int i2);
}
