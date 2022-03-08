package com.baidu.swan.apps.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import androidx.customview.widget.ViewDragHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class DragView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int BASE_ALPHA = 20;
    public static final float BASE_BACKGROUND_ALPHA_DISTANCE = 300.0f;
    public static final float BASE_BACKGROUND_ALPHA_MAX_DISTANCE = 900.0f;
    public static final float BASE_FOREGROUND_ALPHA_DISTANCE = 200.0f;
    public static final int MAX_AUTO_CLOSE_DISTANCE = 300;
    public static final int MIN_BACKGROUND_ALPHA = 255;
    public static final float SENSITIVITY = 0.5f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ViewDragHelper f38078e;

    /* renamed from: f  reason: collision with root package name */
    public View f38079f;

    /* renamed from: g  reason: collision with root package name */
    public int f38080g;

    /* renamed from: h  reason: collision with root package name */
    public int f38081h;

    /* renamed from: i  reason: collision with root package name */
    public int f38082i;

    /* renamed from: j  reason: collision with root package name */
    public int f38083j;
    public b k;
    public int l;
    public float m;
    public boolean n;
    public int o;

    /* loaded from: classes5.dex */
    public class a extends ViewDragHelper.Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DragView a;

        public a(DragView dragView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dragView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dragView;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionVertical(View view, int i2, int i3) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, view, i2, i3)) == null) ? i2 < this.a.o ? this.a.o : i2 : invokeLII.intValue;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int getViewVerticalDragRange(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view)) == null) ? this.a.getMeasuredWidth() : invokeL.intValue;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewPositionChanged(View view, int i2, int i3, int i4, int i5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
                super.onViewPositionChanged(view, i2, i3, i4, i5);
                if (this.a.k != null) {
                    this.a.k.onClosing(i3 - this.a.f38081h);
                }
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewReleased(View view, float f2, float f3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{view, Float.valueOf(f2), Float.valueOf(f3)}) == null) || this.a.f38079f == null) {
                return;
            }
            int top = this.a.f38079f.getTop() - this.a.f38081h;
            if (Math.abs(top) <= this.a.l) {
                this.a.f38078e.smoothSlideViewTo(this.a.getChildAt(0), this.a.f38080g, this.a.f38081h);
            } else if (top < 0) {
                this.a.f38078e.smoothSlideViewTo(this.a.getChildAt(0), 0, -this.a.f38079f.getMeasuredHeight());
            } else {
                this.a.f38078e.smoothSlideViewTo(this.a.getChildAt(0), 0, this.a.f38079f.getMeasuredHeight());
            }
            this.a.postInvalidate();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public boolean tryCaptureView(View view, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, view, i2)) == null) ? this.a.n : invokeLI.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void onClose();

        void onClosing(int i2);

        void onDragViewTouchEvent(MotionEvent motionEvent);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DragView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = 300;
        this.m = 0.5f;
        this.n = true;
        this.o = Integer.MIN_VALUE;
        i();
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            super.addView(view);
            this.f38079f = view;
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.f38078e.continueSettling(true)) {
                ViewCompat.postInvalidateOnAnimation(this);
                return;
            }
            View view = this.f38079f;
            if (view == null || Math.abs(view.getTop() - this.f38081h) < this.l || (bVar = this.k) == null) {
                return;
            }
            bVar.onClose();
        }
    }

    public void disableDrag() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.n = false;
        }
    }

    public void enableDrag() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.n = true;
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f38078e = ViewDragHelper.create(this, this.m, new a(this));
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onFinishInflate();
            this.f38079f = getChildAt(0);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, motionEvent)) == null) {
            if (!this.n) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            int action = motionEvent.getAction();
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (motionEvent.getPointerCount() >= 2) {
                return false;
            }
            if (action != 0) {
                if (action == 2 && Math.abs(y - this.f38083j) <= Math.abs(x - this.f38082i)) {
                    return false;
                }
            } else {
                this.f38082i = x;
                this.f38083j = y;
            }
            try {
                return this.f38078e.shouldInterceptTouchEvent(motionEvent);
            } catch (ArrayIndexOutOfBoundsException e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            super.onLayout(z, i2, i3, i4, i5);
            this.f38080g = getLeft();
            this.f38081h = getTop();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, motionEvent)) == null) {
            if (this.n) {
                this.f38078e.processTouchEvent(motionEvent);
                b bVar = this.k;
                if (bVar != null) {
                    bVar.onDragViewTouchEvent(motionEvent);
                    return true;
                }
                return true;
            }
            return super.onTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    public void setOnCloseListener(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bVar) == null) {
            this.k = bVar;
        }
    }

    public void setTopMinValue(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.o = i2;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DragView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
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
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.l = 300;
        this.m = 0.5f;
        this.n = true;
        this.o = Integer.MIN_VALUE;
        i();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DragView(Context context, AttributeSet attributeSet, int i2) {
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
        this.l = 300;
        this.m = 0.5f;
        this.n = true;
        this.o = Integer.MIN_VALUE;
        i();
    }
}
