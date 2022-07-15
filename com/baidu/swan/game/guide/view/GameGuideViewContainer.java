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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.rd3;
import com.repackage.yd3;
/* loaded from: classes2.dex */
public class GameGuideViewContainer extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;

    /* loaded from: classes2.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ViewGroup.MarginLayoutParams a;
        public final /* synthetic */ GameGuideViewContainer b;

        public a(GameGuideViewContainer gameGuideViewContainer, ViewGroup.MarginLayoutParams marginLayoutParams) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gameGuideViewContainer, marginLayoutParams};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = gameGuideViewContainer;
            this.a = marginLayoutParams;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                this.a.rightMargin = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                this.b.requestLayout();
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void a(int i) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            int i4 = this.d;
            int i5 = i4 / 2;
            if (i >= i5) {
                i2 = (int) (((i4 - i) / i5) * 400.0f);
                i3 = yd3.g(10.0f);
            } else {
                i2 = (int) ((i / i5) * 400.0f);
                i3 = i4 - this.a;
            }
            if (i2 <= 0) {
                i2 = 400;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();
            ValueAnimator ofInt = ValueAnimator.ofInt(marginLayoutParams.rightMargin, i3);
            ofInt.setInterpolator(new DecelerateInterpolator());
            ofInt.setDuration(i2);
            ofInt.addUpdateListener(new a(this, marginLayoutParams));
            ofInt.start();
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.d = getContext().getResources().getDisplayMetrics().widthPixels;
            this.c = getContext().getResources().getDisplayMetrics().heightPixels;
            if (2 == getContext().getResources().getConfiguration().orientation) {
                this.d += rd3.c();
            } else {
                this.c += rd3.c();
            }
            this.g = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        }
    }

    public final boolean c(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2)) == null) ? Math.sqrt((double) ((i * i) + (i2 * i2))) > ((double) this.g) : invokeII.booleanValue;
    }

    public final int d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            int g = i < yd3.g(10.0f) ? yd3.g(10.0f) : i;
            int i2 = this.d;
            int i3 = this.a;
            return i > i2 - i3 ? i2 - i3 : g;
        }
        return invokeI.intValue;
    }

    public final int e(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            int i2 = i < 0 ? 0 : i;
            int i3 = this.c;
            int i4 = this.b;
            return i > i3 - i4 ? i3 - i4 : i2;
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
                if (action == 2 && c(((int) motionEvent.getRawX()) - this.e, ((int) motionEvent.getRawY()) - this.f)) {
                    return true;
                }
            } else {
                this.e = (int) motionEvent.getRawX();
                this.f = (int) motionEvent.getRawY();
            }
            return super.onInterceptTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048582, this, i, i2, i3, i4) == null) {
            super.onSizeChanged(i, i2, i3, i4);
            this.a = i;
            this.b = i2;
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
                this.e = (int) motionEvent.getRawX();
                this.f = (int) motionEvent.getRawY();
                return true;
            }
            if (action == 1) {
                a((int) motionEvent.getRawX());
                performClick();
            } else if (action == 2) {
                int rawX = (int) motionEvent.getRawX();
                int rawY = (int) motionEvent.getRawY();
                int i = rawX - this.e;
                int i2 = rawY - this.f;
                if (c(i, i2)) {
                    marginLayoutParams.rightMargin = d(marginLayoutParams.rightMargin - i);
                    marginLayoutParams.topMargin = e(marginLayoutParams.topMargin + i2);
                    setLayoutParams(marginLayoutParams);
                    this.e = rawX;
                    this.f = rawY;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GameGuideViewContainer(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
