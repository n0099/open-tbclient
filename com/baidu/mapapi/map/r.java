package com.baidu.mapapi.map;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class r implements ValueAnimator.AnimatorUpdateListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ViewGroup.LayoutParams f41584a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SwipeDismissTouchListener f41585b;

    public r(SwipeDismissTouchListener swipeDismissTouchListener, ViewGroup.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {swipeDismissTouchListener, layoutParams};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f41585b = swipeDismissTouchListener;
        this.f41584a = layoutParams;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        View view;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
            this.f41584a.height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            view = this.f41585b.f41474e;
            view.setLayoutParams(this.f41584a);
        }
    }
}
