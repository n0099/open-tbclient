package com.baidu.mobads.sdk.internal.widget;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public final class FakeDrag {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ViewPager2 a;
    public final ScrollEventAdapter b;
    public final RecyclerView c;
    public VelocityTracker d;
    public int e;
    public float f;
    public int g;
    public long h;

    public FakeDrag(ViewPager2 viewPager2, ScrollEventAdapter scrollEventAdapter, RecyclerView recyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {viewPager2, scrollEventAdapter, recyclerView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = viewPager2;
        this.b = scrollEventAdapter;
        this.c = recyclerView;
    }

    private void a(long j, int i, float f, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, this, new Object[]{Long.valueOf(j), Integer.valueOf(i), Float.valueOf(f), Float.valueOf(f2)}) == null) {
            MotionEvent obtain = MotionEvent.obtain(this.h, j, i, f, f2, 0);
            this.d.addMovement(obtain);
            obtain.recycle();
        }
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            VelocityTracker velocityTracker = this.d;
            if (velocityTracker == null) {
                this.d = VelocityTracker.obtain();
                this.e = ViewConfiguration.get(this.a.getContext()).getScaledMaximumFlingVelocity();
                return;
            }
            velocityTracker.clear();
        }
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.b.g();
        }
        return invokeV.booleanValue;
    }

    @UiThread
    public boolean a(float f) {
        InterceptResult invokeF;
        boolean z;
        int i;
        float f2;
        float f3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f)) == null) {
            int i2 = 0;
            if (!this.b.g()) {
                return false;
            }
            float f4 = this.f - f;
            this.f = f4;
            int round = Math.round(f4 - this.g);
            this.g += round;
            long uptimeMillis = SystemClock.uptimeMillis();
            if (this.a.getOrientation() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                i = round;
            } else {
                i = 0;
            }
            if (!z) {
                i2 = round;
            }
            if (z) {
                f2 = this.f;
            } else {
                f2 = 0.0f;
            }
            if (z) {
                f3 = 0.0f;
            } else {
                f3 = this.f;
            }
            this.c.scrollBy(i, i2);
            a(uptimeMillis, 2, f2, f3);
            return true;
        }
        return invokeF.booleanValue;
    }

    @UiThread
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.b.f()) {
                return false;
            }
            this.g = 0;
            this.f = 0;
            this.h = SystemClock.uptimeMillis();
            d();
            this.b.b();
            if (!this.b.e()) {
                this.c.stopScroll();
            }
            a(this.h, 0, 0.0f, 0.0f);
            return true;
        }
        return invokeV.booleanValue;
    }

    @UiThread
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (!this.b.g()) {
                return false;
            }
            this.b.c();
            VelocityTracker velocityTracker = this.d;
            velocityTracker.computeCurrentVelocity(1000, this.e);
            if (!this.c.fling((int) velocityTracker.getXVelocity(), (int) velocityTracker.getYVelocity())) {
                this.a.d();
                return true;
            }
            return true;
        }
        return invokeV.booleanValue;
    }
}
