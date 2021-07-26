package com.baidu.sapi2.views.swipeback;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewCompat;
import androidx.customview.widget.ViewDragHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c0.a.i;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes2.dex */
public class SwipeBackLayout extends ViewGroup {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String t = "SwipeBackLayout";
    public static final int u = 1;
    public static final int v = 2;
    public static final int w = 4;
    public static final int x = 8;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f10120a;

    /* renamed from: b  reason: collision with root package name */
    public final ViewDragHelper f10121b;

    /* renamed from: c  reason: collision with root package name */
    public View f10122c;

    /* renamed from: d  reason: collision with root package name */
    public View f10123d;

    /* renamed from: e  reason: collision with root package name */
    public int f10124e;

    /* renamed from: f  reason: collision with root package name */
    public int f10125f;

    /* renamed from: g  reason: collision with root package name */
    public int f10126g;

    /* renamed from: h  reason: collision with root package name */
    public float f10127h;

    /* renamed from: i  reason: collision with root package name */
    public float f10128i;
    public int j;
    public boolean k;
    public float l;
    public float m;
    public int n;
    public int o;
    public float p;
    public int q;
    public d r;
    public d s;

    /* loaded from: classes2.dex */
    public class a implements d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SwipeBackLayout f10129a;

        public a(SwipeBackLayout swipeBackLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swipeBackLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10129a = swipeBackLayout;
        }

        @Override // com.baidu.sapi2.views.swipeback.SwipeBackLayout.d
        public void a(View view, float f2, float f3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, Float.valueOf(f2), Float.valueOf(f3)}) == null) {
                this.f10129a.invalidate();
            }
        }

        @Override // com.baidu.sapi2.views.swipeback.SwipeBackLayout.d
        public void a(View view, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, z) == null) && z) {
                this.f10129a.a();
            }
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface b {
    }

    /* loaded from: classes2.dex */
    public class c extends ViewDragHelper.Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SwipeBackLayout f10130a;

        public c(SwipeBackLayout swipeBackLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swipeBackLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10130a = swipeBackLayout;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionHorizontal(View view, int i2, int i3) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, view, i2, i3)) == null) {
                SwipeBackLayout swipeBackLayout = this.f10130a;
                swipeBackLayout.n = swipeBackLayout.getPaddingLeft();
                if (this.f10130a.c()) {
                    if (this.f10130a.f10120a != 1 || com.baidu.sapi2.views.swipeback.a.a.c(this.f10130a.f10123d, this.f10130a.l, this.f10130a.m, false)) {
                        if (this.f10130a.f10120a == 2 && !com.baidu.sapi2.views.swipeback.a.a.b(this.f10130a.f10123d, this.f10130a.l, this.f10130a.m, false)) {
                            SwipeBackLayout swipeBackLayout2 = this.f10130a;
                            swipeBackLayout2.n = Math.min(Math.max(i2, -swipeBackLayout2.f10124e), this.f10130a.getPaddingRight());
                        }
                    } else {
                        SwipeBackLayout swipeBackLayout3 = this.f10130a;
                        swipeBackLayout3.n = Math.min(Math.max(i2, swipeBackLayout3.getPaddingLeft()), this.f10130a.f10124e);
                    }
                }
                return this.f10130a.n;
            }
            return invokeLII.intValue;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionVertical(View view, int i2, int i3) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, i2, i3)) == null) {
                SwipeBackLayout swipeBackLayout = this.f10130a;
                swipeBackLayout.o = swipeBackLayout.getPaddingTop();
                if (this.f10130a.c()) {
                    if (this.f10130a.f10120a != 4 || com.baidu.sapi2.views.swipeback.a.a.d(this.f10130a.f10123d, this.f10130a.l, this.f10130a.m, false)) {
                        if (this.f10130a.f10120a == 8 && !com.baidu.sapi2.views.swipeback.a.a.a(this.f10130a.f10123d, this.f10130a.l, this.f10130a.m, false)) {
                            SwipeBackLayout swipeBackLayout2 = this.f10130a;
                            swipeBackLayout2.o = Math.min(Math.max(i2, -swipeBackLayout2.f10125f), this.f10130a.getPaddingBottom());
                        }
                    } else {
                        SwipeBackLayout swipeBackLayout3 = this.f10130a;
                        swipeBackLayout3.o = Math.min(Math.max(i2, swipeBackLayout3.getPaddingTop()), this.f10130a.f10125f);
                    }
                }
                return this.f10130a.o;
            }
            return invokeLII.intValue;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int getViewHorizontalDragRange(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view)) == null) ? this.f10130a.f10124e : invokeL.intValue;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int getViewVerticalDragRange(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, view)) == null) ? this.f10130a.f10125f : invokeL.intValue;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onEdgeTouched(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048580, this, i2, i3) == null) {
                super.onEdgeTouched(i2, i3);
                this.f10130a.q = i2;
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewDragStateChanged(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
                super.onViewDragStateChanged(i2);
                if (i2 != 0 || this.f10130a.r == null) {
                    return;
                }
                if (this.f10130a.f10128i == 0.0f) {
                    this.f10130a.r.a(this.f10130a.f10122c, false);
                } else if (this.f10130a.f10128i == 1.0f) {
                    this.f10130a.r.a(this.f10130a.f10122c, true);
                }
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewPositionChanged(View view, int i2, int i3, int i4, int i5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
                super.onViewPositionChanged(view, i2, i3, i4, i5);
                int abs = Math.abs(i2);
                int abs2 = Math.abs(i3);
                int i6 = this.f10130a.f10120a;
                if (i6 == 1 || i6 == 2) {
                    SwipeBackLayout swipeBackLayout = this.f10130a;
                    swipeBackLayout.f10128i = (abs * 1.0f) / swipeBackLayout.f10124e;
                } else if (i6 == 4 || i6 == 8) {
                    SwipeBackLayout swipeBackLayout2 = this.f10130a;
                    swipeBackLayout2.f10128i = (abs2 * 1.0f) / swipeBackLayout2.f10125f;
                }
                if (this.f10130a.r != null) {
                    this.f10130a.r.a(this.f10130a.f10122c, this.f10130a.f10128i, this.f10130a.f10127h);
                }
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewReleased(View view, float f2, float f3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{view, Float.valueOf(f2), Float.valueOf(f3)}) == null) {
                super.onViewReleased(view, f2, f3);
                SwipeBackLayout swipeBackLayout = this.f10130a;
                boolean z = false;
                swipeBackLayout.n = swipeBackLayout.o = 0;
                if (!this.f10130a.c()) {
                    this.f10130a.q = -1;
                    return;
                }
                this.f10130a.q = -1;
                if ((this.f10130a.a(f2, f3) || this.f10130a.f10128i >= this.f10130a.f10127h) ? true : true) {
                    int i2 = this.f10130a.f10120a;
                    if (i2 == 1) {
                        SwipeBackLayout swipeBackLayout2 = this.f10130a;
                        swipeBackLayout2.a(swipeBackLayout2.f10124e);
                        return;
                    } else if (i2 == 2) {
                        SwipeBackLayout swipeBackLayout3 = this.f10130a;
                        swipeBackLayout3.a(-swipeBackLayout3.f10124e);
                        return;
                    } else if (i2 == 4) {
                        SwipeBackLayout swipeBackLayout4 = this.f10130a;
                        swipeBackLayout4.b(swipeBackLayout4.f10125f);
                        return;
                    } else if (i2 != 8) {
                        return;
                    } else {
                        SwipeBackLayout swipeBackLayout5 = this.f10130a;
                        swipeBackLayout5.b(-swipeBackLayout5.f10125f);
                        return;
                    }
                }
                int i3 = this.f10130a.f10120a;
                if (i3 == 1 || i3 == 2) {
                    SwipeBackLayout swipeBackLayout6 = this.f10130a;
                    swipeBackLayout6.a(swipeBackLayout6.getPaddingLeft());
                } else if (i3 == 4 || i3 == 8) {
                    SwipeBackLayout swipeBackLayout7 = this.f10130a;
                    swipeBackLayout7.b(swipeBackLayout7.getPaddingTop());
                }
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public boolean tryCaptureView(View view, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, view, i2)) == null) ? view == this.f10130a.f10122c : invokeLI.booleanValue;
        }

        public /* synthetic */ c(SwipeBackLayout swipeBackLayout, a aVar) {
            this(swipeBackLayout);
        }
    }

    /* loaded from: classes2.dex */
    public interface d {
        void a(View view, float f2, float f3);

        void a(View view, boolean z);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SwipeBackLayout(@NonNull Context context) {
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

    @Override // android.view.View
    public void computeScroll() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.f10121b.continueSettling(true)) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public float getAutoFinishedVelocityLimit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.p : invokeV.floatValue;
    }

    public int getDirectionMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f10120a : invokeV.intValue;
    }

    public int getMaskAlpha() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.j : invokeV.intValue;
    }

    public float getSwipeBackFactor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f10127h : invokeV.floatValue;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, canvas) == null) {
            super.onDraw(canvas);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        View view;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, motionEvent)) == null) {
            int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
            if (actionMasked == 0) {
                this.l = motionEvent.getRawX();
                this.m = motionEvent.getRawY();
            } else if (actionMasked == 2 && (view = this.f10123d) != null && com.baidu.sapi2.views.swipeback.a.a.a(view, this.l, this.m)) {
                float abs = Math.abs(motionEvent.getRawX() - this.l);
                float abs2 = Math.abs(motionEvent.getRawY() - this.m);
                int i2 = this.f10120a;
                if (i2 != 1 && i2 != 2) {
                    if ((i2 == 4 || i2 == 8) && abs > this.f10126g && abs > abs2) {
                        return super.onInterceptTouchEvent(motionEvent);
                    }
                } else if (abs2 > this.f10126g && abs2 > abs) {
                    return super.onInterceptTouchEvent(motionEvent);
                }
            }
            boolean shouldInterceptTouchEvent = this.f10121b.shouldInterceptTouchEvent(motionEvent);
            return shouldInterceptTouchEvent ? shouldInterceptTouchEvent : super.onInterceptTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) || getChildCount() == 0) {
            return;
        }
        int paddingLeft = getPaddingLeft() + this.n;
        int paddingTop = getPaddingTop() + this.o;
        this.f10122c.layout(paddingLeft, paddingTop, this.f10122c.getMeasuredWidth() + paddingLeft, this.f10122c.getMeasuredHeight() + paddingTop);
        if (z) {
            this.f10124e = getWidth();
            this.f10125f = getHeight();
        }
        this.f10123d = com.baidu.sapi2.views.swipeback.a.a.a((ViewGroup) this);
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048589, this, i2, i3) == null) {
            super.onMeasure(i2, i3);
            int childCount = getChildCount();
            if (childCount <= 1) {
                int i5 = 0;
                if (childCount > 0) {
                    measureChildren(i2, i3);
                    View childAt = getChildAt(0);
                    this.f10122c = childAt;
                    i5 = childAt.getMeasuredWidth();
                    i4 = this.f10122c.getMeasuredHeight();
                } else {
                    i4 = 0;
                }
                setMeasuredDimension(View.resolveSize(i5, i2) + getPaddingLeft() + getPaddingRight(), View.resolveSize(i4, i3) + getPaddingTop() + getPaddingBottom());
                return;
            }
            throw new IllegalStateException("SwipeBackLayout must contains only one direct child.");
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, motionEvent)) == null) {
            this.f10121b.processTouchEvent(motionEvent);
            return true;
        }
        return invokeL.booleanValue;
    }

    public void setAutoFinishedVelocityLimit(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048591, this, f2) == null) {
            this.p = f2;
        }
    }

    public void setDirectionMode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            this.f10120a = i2;
            this.f10121b.setEdgeTrackingEnabled(i2);
        }
    }

    public void setMaskAlpha(@IntRange(from = 0, to = 255) int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            if (i2 > 255) {
                i2 = 255;
            } else if (i2 < 0) {
                i2 = 0;
            }
            this.j = i2;
        }
    }

    public void setSwipeBackFactor(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048594, this, f2) == null) {
            if (f2 > 1.0f) {
                f2 = 1.0f;
            } else if (f2 < 0.0f) {
                f2 = 0.0f;
            }
            this.f10127h = f2;
        }
    }

    public void setSwipeBackListener(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, dVar) == null) {
            this.r = dVar;
        }
    }

    public void setSwipeFromEdge(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            this.k = z;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SwipeBackLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
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
    public SwipeBackLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
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
        this.f10120a = 1;
        this.f10127h = 0.5f;
        this.j = 125;
        this.k = false;
        this.n = 0;
        this.o = 0;
        this.p = 2000.0f;
        this.q = -1;
        this.s = new a(this);
        setWillNotDraw(false);
        ViewDragHelper create = ViewDragHelper.create(this, 1.0f, new c(this, null));
        this.f10121b = create;
        create.setEdgeTrackingEnabled(this.f10120a);
        this.f10126g = this.f10121b.getTouchSlop();
        setSwipeBackListener(this.s);
        a(context, attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, this)) == null) {
            if (this.k) {
                int i2 = this.f10120a;
                return i2 != 1 ? i2 != 2 ? i2 != 4 ? i2 != 8 || this.q == 8 : this.q == 4 : this.q == 2 : this.q == 1;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void b(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048579, this, i2) == null) && this.f10121b.settleCapturedViewAt(getPaddingLeft(), i2)) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    private void a(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, this, context, attributeSet) == null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.sapi_sdk_SwipeBackLayout);
            setDirectionMode(obtainStyledAttributes.getInt(i.sapi_sdk_SwipeBackLayout_sapi_sdk_directionMode, this.f10120a));
            setSwipeBackFactor(obtainStyledAttributes.getFloat(i.sapi_sdk_SwipeBackLayout_sapi_sdk_swipeBackFactor, this.f10127h));
            setMaskAlpha(obtainStyledAttributes.getInteger(i.sapi_sdk_SwipeBackLayout_sapi_sdk_maskAlpha, this.j));
            this.k = obtainStyledAttributes.getBoolean(i.sapi_sdk_SwipeBackLayout_sapi_sdk_isSwipeFromEdge, this.k);
            obtainStyledAttributes.recycle();
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.k : invokeV.booleanValue;
    }

    public void a(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, activity) == null) {
            ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
            ViewGroup viewGroup2 = (ViewGroup) viewGroup.getChildAt(0);
            viewGroup2.setBackgroundColor(0);
            viewGroup.removeView(viewGroup2);
            addView(viewGroup2);
            viewGroup.addView(this);
        }
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) && this.f10121b.settleCapturedViewAt(i2, getPaddingTop())) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ((Activity) getContext()).finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            int i2 = this.f10120a;
            return i2 != 1 ? i2 != 2 ? i2 != 4 ? i2 == 8 && f3 < (-this.p) : f3 > this.p : f2 < (-this.p) : f2 > this.p;
        }
        return invokeCommon.booleanValue;
    }
}
