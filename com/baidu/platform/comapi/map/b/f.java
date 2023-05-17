package com.baidu.platform.comapi.map.b;

import android.os.Build;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.platform.comapi.map.b.a;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int a;
    public final int b;
    public VelocityTracker c;

    public f() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        ViewConfiguration viewConfiguration = ViewConfiguration.get(com.baidu.platform.comapi.b.d());
        if (viewConfiguration == null) {
            this.b = ViewConfiguration.getMinimumFlingVelocity();
            this.a = ViewConfiguration.getMaximumFlingVelocity();
            return;
        }
        this.b = viewConfiguration.getScaledMinimumFlingVelocity();
        this.a = viewConfiguration.getScaledMaximumFlingVelocity();
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.c = VelocityTracker.obtain();
        }
    }

    public void b() {
        VelocityTracker velocityTracker;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (velocityTracker = this.c) != null) {
            velocityTracker.recycle();
            this.c = null;
        }
    }

    public void a(MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent) == null) {
            VelocityTracker velocityTracker = this.c;
            if (velocityTracker == null) {
                this.c = VelocityTracker.obtain();
            } else {
                velocityTracker.addMovement(motionEvent);
            }
        }
    }

    public Pair<a.d, a.d> c() {
        InterceptResult invokeV;
        float xVelocity;
        float yVelocity;
        float xVelocity2;
        float yVelocity2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            VelocityTracker velocityTracker = this.c;
            if (velocityTracker == null) {
                return new Pair<>(new a.d(0.0d, 0.0d), new a.d(0.0d, 0.0d));
            }
            velocityTracker.computeCurrentVelocity(1000, this.a);
            if (Build.VERSION.SDK_INT < 8) {
                xVelocity = this.c.getXVelocity();
                yVelocity = this.c.getYVelocity();
                xVelocity2 = this.c.getXVelocity();
                yVelocity2 = this.c.getYVelocity();
            } else {
                xVelocity = this.c.getXVelocity(0);
                yVelocity = this.c.getYVelocity(0);
                xVelocity2 = this.c.getXVelocity(1);
                yVelocity2 = this.c.getYVelocity(1);
            }
            return new Pair<>(new a.d(xVelocity, yVelocity), new a.d(xVelocity2, yVelocity2));
        }
        return (Pair) invokeV.objValue;
    }
}
