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
import com.baidu.tieba.oh3;
import com.baidu.tieba.vh3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
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

    public final void a(int i) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            int i4 = this.d;
            int i5 = i4 / 2;
            if (i >= i5) {
                i2 = (int) (((i4 - i) / i5) * 400.0f);
                i3 = vh3.g(10.0f);
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
                this.d += oh3.c();
            } else {
                this.c += oh3.c();
            }
            this.g = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        }
    }

    public final boolean c(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2)) == null) {
            if (Math.sqrt((i * i) + (i2 * i2)) > this.g) {
                return true;
            }
            return false;
        }
        return invokeII.booleanValue;
    }

    public final int d(int i) {
        InterceptResult invokeI;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            if (i < vh3.g(10.0f)) {
                i2 = vh3.g(10.0f);
            } else {
                i2 = i;
            }
            int i3 = this.d;
            int i4 = this.a;
            if (i > i3 - i4) {
                return i3 - i4;
            }
            return i2;
        }
        return invokeI.intValue;
    }

    public final int e(int i) {
        InterceptResult invokeI;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            if (i < 0) {
                i2 = 0;
            } else {
                i2 = i;
            }
            int i3 = this.c;
            int i4 = this.b;
            if (i > i3 - i4) {
                return i3 - i4;
            }
            return i2;
        }
        return invokeI.intValue;
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
            if (action != 0) {
                if (action != 1) {
                    if (action != 2) {
                        if (action == 3) {
                            a((int) motionEvent.getRawX());
                        }
                    } else {
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
                    }
                } else {
                    a((int) motionEvent.getRawX());
                    performClick();
                }
                return true;
            }
            this.e = (int) motionEvent.getRawX();
            this.f = (int) motionEvent.getRawY();
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.View
    public boolean performClick() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return super.performClick();
        }
        return invokeV.booleanValue;
    }
}
