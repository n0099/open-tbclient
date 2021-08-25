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
/* loaded from: classes5.dex */
public class q extends AnimatorListenerAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ViewGroup.LayoutParams f41581a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f41582b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SwipeDismissTouchListener f41583c;

    public q(SwipeDismissTouchListener swipeDismissTouchListener, ViewGroup.LayoutParams layoutParams, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {swipeDismissTouchListener, layoutParams, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f41583c = swipeDismissTouchListener;
        this.f41581a = layoutParams;
        this.f41582b = i2;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        SwipeDismissTouchListener.DismissCallbacks dismissCallbacks;
        View view;
        Object obj;
        View view2;
        View view3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
            dismissCallbacks = this.f41583c.f41475f;
            view = this.f41583c.f41474e;
            obj = this.f41583c.l;
            dismissCallbacks.onDismiss(view, obj);
            view2 = this.f41583c.f41474e;
            view2.setTranslationX(0.0f);
            this.f41581a.height = this.f41582b;
            view3 = this.f41583c.f41474e;
            view3.setLayoutParams(this.f41581a);
        }
    }
}
