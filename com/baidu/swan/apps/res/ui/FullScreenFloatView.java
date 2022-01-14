package com.baidu.swan.apps.res.ui;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.widget.Button;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.a.d;
import c.a.r0.a.f;
import c.a.r0.a.k;
import c.a.r0.a.z2.n0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes11.dex */
public class FullScreenFloatView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ANIMATION_TIME = 300;
    public static final int BOTTOM = 4;
    public static final int LEFT = 1;
    public static final int MIN_DISTANCE = 10;
    public static final int RIGHT = 2;
    public static final int TOP = 3;

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f39092e;
    public transient /* synthetic */ FieldHolder $fh;
    public b mCheckClick;
    public c mDragImageListener;
    public View mFloatImgView;
    public int mFloatViewHeight;
    public int mFloatViewWidth;
    public boolean mIsAutoAttachEnable;
    public boolean mIsClickDrag;
    public boolean mIsTouchDrag;
    public int mParentHeight;
    public int mParentWidth;
    public float mStartX;
    public float mStartY;
    public int mStatusBarHeight;

    /* loaded from: classes11.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes11.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FullScreenFloatView f39093e;

        public b(FullScreenFloatView fullScreenFloatView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fullScreenFloatView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f39093e = fullScreenFloatView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f39093e.mIsClickDrag = false;
                boolean unused = FullScreenFloatView.f39092e;
            }
        }

        public /* synthetic */ b(FullScreenFloatView fullScreenFloatView, a aVar) {
            this(fullScreenFloatView);
        }
    }

    /* loaded from: classes11.dex */
    public interface c {
        void a();

        void onClick();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(201030676, "Lcom/baidu/swan/apps/res/ui/FullScreenFloatView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(201030676, "Lcom/baidu/swan/apps/res/ui/FullScreenFloatView;");
                return;
            }
        }
        f39092e = k.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FullScreenFloatView(Context context, AttributeSet attributeSet, int i2) {
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
        this.mStatusBarHeight = 66;
        this.mIsClickDrag = false;
        this.mIsTouchDrag = false;
        this.mIsAutoAttachEnable = true;
        this.mCheckClick = new b(this, null);
        setStatusBarHeight();
    }

    public final void b(float f2, float f3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) || this.mFloatImgView == null) {
            return;
        }
        if (f39092e) {
            String str = "move--> x = " + f2 + ", y = " + f3;
        }
        int i2 = (int) (f2 - (this.mFloatViewWidth / 2));
        int i3 = (int) (f3 - (this.mFloatViewHeight / 2));
        if (i2 <= 0) {
            i2 = 0;
        }
        if (i3 <= 0) {
            i3 = 0;
        }
        int i4 = this.mParentWidth;
        int i5 = this.mFloatViewWidth;
        if (i2 > i4 - i5) {
            i2 = i4 - i5;
        }
        int i6 = this.mParentHeight;
        int i7 = this.mFloatViewHeight;
        if (i3 > i6 - i7) {
            i3 = i6 - i7;
        }
        int i8 = (this.mParentWidth - i2) - this.mFloatViewWidth;
        int i9 = (this.mParentHeight - i3) - this.mFloatViewHeight;
        if (f39092e) {
            String str2 = "move--> left = " + i2 + ", top = " + i3 + ", right = " + i8 + ",bottom = " + i9 + ", mStatusBarHeight = " + this.mStatusBarHeight;
        }
        this.mFloatImgView.setX(i2);
        this.mFloatImgView.setY(i3);
        requestLayout();
    }

    public void dragInit(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
            if (this.mParentWidth == 0) {
                this.mParentWidth = getWidth();
            }
            if (this.mParentHeight == 0) {
                this.mParentHeight = getHeight();
            }
            this.mFloatViewWidth = view.getWidth();
            this.mFloatViewHeight = view.getHeight();
            if (f39092e) {
                String str = "dragInit-> mScreenWidth = " + this.mParentWidth + ", mScreenHeight = " + this.mParentHeight + ",mFloatViewWidth = " + this.mFloatViewWidth + ", mFloatViewHeight = " + this.mFloatViewHeight;
            }
        }
    }

    public c getDragImageListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mDragImageListener : (c) invokeV.objValue;
    }

    public int minDistance(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            if (f39092e) {
                r0 = "minDIstance---> x = " + f2 + ", y = " + f3;
            }
            boolean z = f2 <= ((float) this.mParentWidth) - f2;
            boolean z2 = f3 <= ((float) this.mParentHeight) - f3;
            if (z && z2) {
                return f2 <= f3 ? 1 : 3;
            } else if (z && !z2) {
                return f2 <= ((float) this.mParentHeight) - f3 ? 1 : 4;
            } else if (!z && z2) {
                return ((float) this.mParentWidth) - f2 <= f3 ? 2 : 3;
            } else if (z || z2) {
                return 0;
            } else {
                return ((float) this.mParentWidth) - f2 <= ((float) this.mParentHeight) - f3 ? 2 : 4;
            }
        }
        return invokeCommon.intValue;
    }

    public void moveToDefaultPosition() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.mFloatImgView == null) {
            return;
        }
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(d.swan_app_dimens_21dp);
        int dimensionPixelOffset2 = getResources().getDimensionPixelOffset(d.swan_app_dimens_51dp);
        this.mFloatImgView.animate().x((n0.o(getContext()) - dimensionPixelOffset) - this.mFloatViewWidth).y((n0.n(getContext()) - dimensionPixelOffset2) - this.mFloatViewHeight).setInterpolator(new AccelerateInterpolator()).setDuration(300L).start();
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            this.mParentWidth = getHeight() + this.mStatusBarHeight;
            this.mParentHeight = getWidth() - this.mStatusBarHeight;
            if (f39092e) {
                String str = "onConfigurationChanged--> newConfig " + configuration.orientation + ", mScreenWidth = " + this.mParentWidth + ", mScreenHeight = " + this.mParentHeight;
            }
            moveToDefaultPosition();
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, motionEvent)) == null) {
            if (motionEvent.getAction() != 0) {
                return false;
            }
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            Rect rect = new Rect();
            if (this.mFloatImgView == null) {
                View findViewById = findViewById(f.float_imgview);
                this.mFloatImgView = findViewById;
                dragInit(findViewById);
            }
            this.mFloatImgView.getHitRect(rect);
            if (rect.contains((int) x, (int) y)) {
                this.mIsTouchDrag = true;
                this.mStartX = x;
                this.mStartY = y;
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            super.onLayout(z, i2, i3, i4, i5);
            this.mParentWidth = getWidth();
            this.mParentHeight = getHeight();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, motionEvent)) == null) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            Rect rect = new Rect();
            int action = motionEvent.getAction();
            if (action == 0) {
                this.mFloatImgView.getHitRect(rect);
                if (rect.contains((int) x, (int) y)) {
                    this.mStartX = x;
                    this.mStartY = y;
                    this.mIsTouchDrag = true;
                    this.mIsClickDrag = true;
                    postDelayed(this.mCheckClick, ViewConfiguration.getTapTimeout());
                }
            } else if (action == 1) {
                if (this.mIsClickDrag) {
                    c cVar2 = this.mDragImageListener;
                    if (cVar2 != null) {
                        cVar2.onClick();
                    }
                    removeCallbacks(this.mCheckClick);
                } else if (this.mIsTouchDrag && (cVar = this.mDragImageListener) != null) {
                    cVar.a();
                }
                if (f39092e) {
                    String str = "ACTION_UP--> x = " + x + ", y = " + y + ",mIsClickDrag = " + this.mIsClickDrag;
                }
                if (this.mIsAutoAttachEnable && !this.mIsClickDrag) {
                    int i2 = this.mFloatViewWidth;
                    if (x > i2 / 2 && x < this.mParentWidth - (i2 / 2)) {
                        int i3 = this.mFloatViewHeight;
                        if (y > i3 / 2 && y < this.mParentHeight - (i3 / 2)) {
                            int minDistance = minDistance(x, y);
                            if (f39092e) {
                                String str2 = "mScreenHeight = " + this.mParentHeight + ", mintype = " + minDistance;
                            }
                            if (minDistance == 1) {
                                x = 0.0f;
                            } else if (minDistance == 2) {
                                x = this.mParentWidth - this.mFloatViewWidth;
                            } else if (minDistance == 3) {
                                y = 0.0f;
                            } else if (minDistance == 4) {
                                y = this.mParentHeight - this.mFloatViewHeight;
                            }
                            if (minDistance == 1 || minDistance == 2) {
                                this.mFloatImgView.animate().x(x).setInterpolator(new AccelerateInterpolator()).setDuration(300L).start();
                            } else if (minDistance == 3 || minDistance == 4) {
                                this.mFloatImgView.animate().y(y).setInterpolator(new AccelerateInterpolator()).setDuration(300L).start();
                            }
                        }
                    }
                }
                this.mIsClickDrag = false;
                this.mIsTouchDrag = false;
            } else if (action == 2) {
                float abs = Math.abs(x - this.mStartX);
                float abs2 = Math.abs(y - this.mStartY);
                if (Math.sqrt((abs2 * abs2) + (abs * abs)) > 10.0d) {
                    this.mIsClickDrag = false;
                }
                b(x, y);
            } else if (action == 3) {
                this.mIsClickDrag = false;
                this.mIsTouchDrag = false;
            } else if (action == 4) {
                this.mIsClickDrag = false;
                this.mIsTouchDrag = false;
            }
            return this.mIsClickDrag || this.mIsTouchDrag;
        }
        return invokeL.booleanValue;
    }

    public void setAutoAttachEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.mIsAutoAttachEnable = z;
        }
    }

    public void setDragImageListener(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, cVar) == null) {
            this.mDragImageListener = cVar;
        }
    }

    public void setFloatButtonText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            View findViewById = findViewById(f.float_imgview);
            if (findViewById instanceof Button) {
                ((Button) findViewById).setText(str);
            }
        }
    }

    public void setFloatImageBackground(int i2) {
        View findViewById;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048588, this, i2) == null) || (findViewById = findViewById(f.float_imgview)) == null) {
            return;
        }
        findViewById.setBackgroundResource(i2);
    }

    public void setStatusBarHeight() {
        int identifier;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (identifier = getResources().getIdentifier("status_bar_height", "dimen", "android")) <= 0) {
            return;
        }
        this.mStatusBarHeight = getResources().getDimensionPixelSize(identifier);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FullScreenFloatView(Context context, AttributeSet attributeSet) {
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
        this.mStatusBarHeight = 66;
        this.mIsClickDrag = false;
        this.mIsTouchDrag = false;
        this.mIsAutoAttachEnable = true;
        this.mCheckClick = new b(this, null);
        setStatusBarHeight();
    }
}
