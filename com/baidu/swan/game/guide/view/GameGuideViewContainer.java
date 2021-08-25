package com.baidu.swan.game.guide.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.a.v2.n0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class GameGuideViewContainer extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f46878e;

    /* renamed from: f  reason: collision with root package name */
    public int f46879f;

    /* renamed from: g  reason: collision with root package name */
    public int f46880g;

    /* renamed from: h  reason: collision with root package name */
    public int f46881h;

    /* renamed from: i  reason: collision with root package name */
    public int f46882i;

    /* renamed from: j  reason: collision with root package name */
    public int f46883j;
    public int k;

    /* loaded from: classes6.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ViewGroup.MarginLayoutParams f46884e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ GameGuideViewContainer f46885f;

        public a(GameGuideViewContainer gameGuideViewContainer, ViewGroup.MarginLayoutParams marginLayoutParams) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gameGuideViewContainer, marginLayoutParams};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46885f = gameGuideViewContainer;
            this.f46884e = marginLayoutParams;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                this.f46884e.rightMargin = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                this.f46885f.requestLayout();
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GameGuideViewContainer(@NonNull Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void a(int i2) {
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            int i5 = this.f46881h;
            int i6 = i5 / 2;
            if (i2 >= i6) {
                i3 = (int) (((i5 - i2) / i6) * 400.0f);
                i4 = n0.g(10.0f);
            } else {
                i3 = (int) ((i2 / i6) * 400.0f);
                i4 = i5 - this.f46878e;
            }
            if (i3 <= 0) {
                i3 = 400;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();
            ValueAnimator ofInt = ValueAnimator.ofInt(marginLayoutParams.rightMargin, i4);
            ofInt.setInterpolator(new DecelerateInterpolator());
            ofInt.setDuration(i3);
            ofInt.addUpdateListener(new a(this, marginLayoutParams));
            ofInt.start();
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f46881h = getContext().getResources().getDisplayMetrics().widthPixels;
            this.f46880g = getContext().getResources().getDisplayMetrics().heightPixels;
            if (2 == getContext().getResources().getConfiguration().orientation) {
                this.f46881h += n0.s();
            } else {
                this.f46880g += n0.s();
            }
            this.k = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        }
    }

    public final boolean c(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3)) == null) ? Math.sqrt((double) ((i2 * i2) + (i3 * i3))) > ((double) this.k) : invokeII.booleanValue;
    }

    public final int d(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            int g2 = i2 < n0.g(10.0f) ? n0.g(10.0f) : i2;
            int i3 = this.f46881h;
            int i4 = this.f46878e;
            return i2 > i3 - i4 ? i3 - i4 : g2;
        }
        return invokeI.intValue;
    }

    public final int e(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            int i3 = i2 < 0 ? 0 : i2;
            int i4 = this.f46880g;
            int i5 = this.f46879f;
            return i2 > i4 - i5 ? i4 - i5 : i3;
        }
        return invokeI.intValue;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, motionEvent)) == null) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action == 2 && c(((int) motionEvent.getRawX()) - this.f46882i, ((int) motionEvent.getRawY()) - this.f46883j)) {
                    return true;
                }
            } else {
                this.f46882i = (int) motionEvent.getRawX();
                this.f46883j = (int) motionEvent.getRawY();
            }
            return super.onInterceptTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048582, this, i2, i3, i4, i5) == null) {
            super.onSizeChanged(i2, i3, i4, i5);
            this.f46878e = i2;
            this.f46879f = i3;
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, motionEvent)) == null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f46882i = (int) motionEvent.getRawX();
                this.f46883j = (int) motionEvent.getRawY();
                return true;
            }
            if (action == 1) {
                a((int) motionEvent.getRawX());
                performClick();
            } else if (action == 2) {
                int rawX = (int) motionEvent.getRawX();
                int rawY = (int) motionEvent.getRawY();
                int i2 = rawX - this.f46882i;
                int i3 = rawY - this.f46883j;
                if (c(i2, i3)) {
                    marginLayoutParams.rightMargin = d(marginLayoutParams.rightMargin - i2);
                    marginLayoutParams.topMargin = e(marginLayoutParams.topMargin + i3);
                    setLayoutParams(marginLayoutParams);
                    this.f46882i = rawX;
                    this.f46883j = rawY;
                    return true;
                }
            } else if (action == 3) {
                a((int) motionEvent.getRawX());
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.View
    public boolean performClick() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? super.performClick() : invokeV.booleanValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GameGuideViewContainer(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, -1);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GameGuideViewContainer(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        b();
    }
}
