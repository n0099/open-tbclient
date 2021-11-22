package com.baidu.tbadk.core.view.viewpager;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.Scroller;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.MotionEventCompat;
import androidx.viewpager.widget.ViewPager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Field;
/* loaded from: classes8.dex */
public class BdBaseViewPager extends ViewPager {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public boolean f46472e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f46473f;

    /* renamed from: g  reason: collision with root package name */
    public float f46474g;

    /* renamed from: h  reason: collision with root package name */
    public float f46475h;

    /* renamed from: i  reason: collision with root package name */
    public int f46476i;

    /* loaded from: classes8.dex */
    public class a extends Scroller {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f46477a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ BdBaseViewPager f46478b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(BdBaseViewPager bdBaseViewPager, Context context) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdBaseViewPager, context};
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
            this.f46478b = bdBaseViewPager;
            this.f46477a = 1000;
        }

        public void a(ViewPager viewPager) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, viewPager) == null) {
                try {
                    Field declaredField = ViewPager.class.getDeclaredField("mScroller");
                    declaredField.setAccessible(true);
                    declaredField.set(viewPager, this);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }

        public void b(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                this.f46477a = i2;
            }
        }

        @Override // android.widget.Scroller
        public void startScroll(int i2, int i3, int i4, int i5, int i6) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)}) == null) {
                super.startScroll(i2, i3, i4, i5, this.f46477a);
            }
        }

        @Override // android.widget.Scroller
        public void startScroll(int i2, int i3, int i4, int i5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIII(Constants.METHOD_SEND_USER_MSG, this, i2, i3, i4, i5) == null) {
                super.startScroll(i2, i3, i4, i5, this.f46477a);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BdBaseViewPager(Context context) {
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
        this.f46472e = false;
        this.f46473f = false;
        this.f46476i = -1;
        initViewPager();
    }

    private void initViewPager() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            ViewConfiguration.get(getContext()).getScaledPagingTouchSlop();
        }
    }

    public final boolean a(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
            int action = (motionEvent.getAction() & 65280) >> 8;
            return motionEvent.getPointerId(action) == -1 || action == -1 || action >= motionEvent.getPointerCount();
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent)) == null) {
            if (a(motionEvent)) {
                return true;
            }
            if (motionEvent.getPointerCount() > 1 && this.f46472e) {
                requestDisallowInterceptTouchEvent(false);
                boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
                requestDisallowInterceptTouchEvent(true);
                return dispatchTouchEvent;
            }
            try {
                return super.dispatchTouchEvent(motionEvent);
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public int getScrollState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            try {
                Field declaredField = ViewPager.class.getDeclaredField("mScrollState");
                declaredField.setAccessible(true);
                return ((Integer) declaredField.get(this)).intValue();
            } catch (Exception e2) {
                e2.printStackTrace();
                return -1;
            }
        }
        return invokeV.intValue;
    }

    public boolean isDisallowSlip() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f46473f : invokeV.booleanValue;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        int findPointerIndex;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, motionEvent)) == null) {
            if (this.f46473f) {
                return false;
            }
            if (a(motionEvent)) {
                return true;
            }
            int action = motionEvent.getAction() & 255;
            if (action == 0) {
                this.f46474g = motionEvent.getX();
                this.f46475h = motionEvent.getY();
                this.f46476i = motionEvent.getPointerId(0);
                if (getCurrentItem() != 0) {
                    requestParentInterceptTouchEvent(true);
                }
            } else if (action == 2) {
                int i2 = this.f46476i;
                if (i2 != -1 && (findPointerIndex = motionEvent.findPointerIndex(i2)) != -1 && findPointerIndex < motionEvent.getPointerCount()) {
                    float x = motionEvent.getX(findPointerIndex) - this.f46474g;
                    float abs = Math.abs(x);
                    float abs2 = Math.abs(motionEvent.getY(findPointerIndex) - this.f46475h);
                    if (x > 0.0f && abs > abs2 && getCurrentItem() == 0 && getScrollState() == 0) {
                        requestParentInterceptTouchEvent(false);
                        return false;
                    } else if (abs > 0.0f && abs > abs2 && getCurrentItem() != 0) {
                        requestParentInterceptTouchEvent(true);
                    }
                }
            } else if (action == 6) {
                onSecondaryPointerUp(motionEvent);
            }
            return super.onInterceptTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    public final void onSecondaryPointerUp(MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, motionEvent) == null) {
            int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
            if (motionEvent.getPointerId(actionIndex) == this.f46476i) {
                int i2 = actionIndex == 0 ? 1 : 0;
                this.f46474g = motionEvent.getX(i2);
                this.f46476i = motionEvent.getPointerId(i2);
            }
        }
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        int findPointerIndex;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, motionEvent)) == null) {
            if (this.f46473f) {
                return false;
            }
            int action = motionEvent.getAction() & 255;
            if (action != 0) {
                if (action != 1) {
                    if (action == 2) {
                        int i2 = this.f46476i;
                        if (i2 != -1 && (findPointerIndex = motionEvent.findPointerIndex(i2)) != -1 && findPointerIndex < motionEvent.getPointerCount()) {
                            float x = motionEvent.getX(findPointerIndex) - this.f46474g;
                            float abs = Math.abs(x);
                            float abs2 = Math.abs(motionEvent.getY(findPointerIndex) - this.f46475h);
                            if (x > 0.0f && abs > abs2 && getCurrentItem() == 0 && getScrollState() == 0) {
                                requestParentInterceptTouchEvent(false);
                                return false;
                            } else if (abs > 0.0f && abs > abs2 && getCurrentItem() != 0) {
                                requestParentInterceptTouchEvent(true);
                            }
                        }
                    } else if (action != 3) {
                        if (action == 5) {
                            int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
                            this.f46474g = motionEvent.getX(actionIndex);
                            this.f46476i = motionEvent.getPointerId(actionIndex);
                        } else if (action == 6) {
                            onSecondaryPointerUp(motionEvent);
                            this.f46474g = motionEvent.getX(motionEvent.findPointerIndex(this.f46476i));
                        }
                    }
                }
                requestParentInterceptTouchEvent(false);
            } else {
                this.f46474g = motionEvent.getX();
                this.f46475h = motionEvent.getY();
                this.f46476i = motionEvent.getPointerId(0);
                if (getCurrentItem() != 0) {
                    requestParentInterceptTouchEvent(true);
                }
            }
            if (a(motionEvent)) {
                return true;
            }
            try {
                return super.onTouchEvent(motionEvent);
            } catch (IllegalArgumentException unused) {
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.f46472e = z;
            super.requestDisallowInterceptTouchEvent(z);
        }
    }

    public void requestParentInterceptTouchEvent(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) || getParent() == null) {
            return;
        }
        getParent().requestDisallowInterceptTouchEvent(z);
    }

    public void setmDisallowSlip(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.f46473f = z;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BdBaseViewPager(Context context, AttributeSet attributeSet) {
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
        this.f46472e = false;
        this.f46473f = false;
        this.f46476i = -1;
        initViewPager();
    }
}
