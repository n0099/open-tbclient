package com.baidu.swan.apps.res.ui;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.widget.Button;
import c.a.p0.a.f;
import c.a.p0.a.k;
import c.a.p0.a.v2.n0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.res.ui.FullScreenFloatView;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class FloatButton extends FullScreenFloatView {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f46387f;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1659105044, "Lcom/baidu/swan/apps/res/ui/FloatButton;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1659105044, "Lcom/baidu/swan/apps/res/ui/FloatButton;");
                return;
            }
        }
        f46387f = k.f7085a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FloatButton(Context context, AttributeSet attributeSet) {
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
    }

    private void b(float f2, float f3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65539, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) || this.mFloatImgView == null) {
            return;
        }
        if (f46387f) {
            String str = "move--> x = " + f2 + ", y = " + f3;
        }
        int i2 = this.mFloatViewWidth;
        int i3 = (int) (f2 - (i2 / 2));
        int i4 = this.mFloatViewHeight;
        int i5 = (int) (f3 - (i4 / 2));
        int i6 = this.mParentWidth - i2;
        int i7 = (this.mParentHeight - i4) - 168;
        if (i3 <= 0) {
            i3 = 0;
        }
        if (i5 <= 288) {
            i5 = 288;
        }
        if (i3 <= i6) {
            i6 = i3;
        }
        if (i5 <= i7) {
            i7 = i5;
        }
        if (f46387f) {
            String str2 = "move--> left = 0, top = 288, mStatusBarHeight = " + this.mStatusBarHeight;
        }
        this.mFloatImgView.setX(i6);
        this.mFloatImgView.setY(i7);
        requestLayout();
    }

    @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        FullScreenFloatView.c cVar;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
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
                    FullScreenFloatView.c cVar2 = this.mDragImageListener;
                    if (cVar2 != null) {
                        cVar2.onClick();
                    }
                    removeCallbacks(this.mCheckClick);
                } else if (this.mIsTouchDrag && (cVar = this.mDragImageListener) != null) {
                    cVar.a();
                }
                if (f46387f) {
                    r0 = "ACTION_UP--> x = " + x + ", y = " + y + ",mIsClickDrag = " + this.mIsClickDrag;
                }
                if (this.mIsAutoAttachEnable && !this.mIsClickDrag && x >= 0.0f) {
                    if (x <= this.mParentWidth && y >= 0.0f && y <= this.mParentHeight + this.mFloatViewHeight) {
                        this.mFloatImgView.animate().x(i2 - this.mFloatViewWidth).setInterpolator(new AccelerateInterpolator()).setDuration(300L).start();
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
            return this.mIsClickDrag | this.mIsTouchDrag;
        }
        return invokeL.booleanValue;
    }

    public void setFloatButtonDefaultPosition() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            findViewById(f.float_imgview).setBottom(n0.L(191.0f));
        }
    }

    public void setFloatButtonDrawable(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, drawable) == null) || drawable == null) {
            return;
        }
        View findViewById = findViewById(f.float_imgview);
        if (findViewById instanceof Button) {
            findViewById.setBackground(drawable);
        }
    }

    public void setFloatButtonStyle(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, jSONObject) == null) {
            View findViewById = findViewById(f.float_imgview);
            String optString = jSONObject != null ? jSONObject.optString("backgroundColor", "#4E4E4E") : "#4E4E4E";
            if (findViewById instanceof Button) {
                ((GradientDrawable) findViewById.getBackground()).setColor(SwanAppConfigData.s(optString));
                ((Button) findViewById).setTextColor(SwanAppConfigData.s("#FFFFFF"));
                findViewById.setAlpha((float) 0.8999999761581421d);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FloatButton(Context context, AttributeSet attributeSet, int i2) {
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
    }
}
