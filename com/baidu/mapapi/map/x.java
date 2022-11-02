package com.baidu.mapapi.map;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.mapapi.map.SwipeDismissTouchListener;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class x extends AnimatorListenerAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ ViewGroup.LayoutParams a;
    public final /* synthetic */ int b;
    public final /* synthetic */ SwipeDismissTouchListener c;

    public x(SwipeDismissTouchListener swipeDismissTouchListener, ViewGroup.LayoutParams layoutParams, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {swipeDismissTouchListener, layoutParams, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = swipeDismissTouchListener;
        this.a = layoutParams;
        this.b = i;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        SwipeDismissTouchListener.DismissCallbacks dismissCallbacks;
        View view2;
        Object obj;
        View view3;
        View view4;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048576, this, animator) != null) {
            return;
        }
        dismissCallbacks = this.c.f;
        view2 = this.c.e;
        obj = this.c.l;
        dismissCallbacks.onDismiss(view2, obj);
        view3 = this.c.e;
        view3.setTranslationX(0.0f);
        this.a.height = this.b;
        view4 = this.c.e;
        view4.setLayoutParams(this.a);
    }
}
