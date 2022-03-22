package com.baidu.swan.apps.res.ui;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.widget.Button;
import c.a.n0.a.a;
import c.a.n0.a.p2.n0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.res.ui.FullScreenFloatView;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class FloatButton extends FullScreenFloatView {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean o;
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
        o = a.a;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    private void d(float f2, float f3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65539, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) || this.a == null) {
            return;
        }
        if (o) {
            Log.e("FloatButton", "move--> x = " + f2 + ", y = " + f3);
        }
        int i = this.f29110b;
        int i2 = (int) (f2 - (i / 2));
        int i3 = this.f29111c;
        int i4 = (int) (f3 - (i3 / 2));
        int i5 = this.f29112d - i;
        int i6 = (this.f29113e - i3) - 168;
        if (i2 <= 0) {
            i2 = 0;
        }
        if (i4 <= 288) {
            i4 = 288;
        }
        if (i2 <= i5) {
            i5 = i2;
        }
        if (i4 <= i6) {
            i6 = i4;
        }
        if (o) {
            Log.e("FloatButton", "move--> left = 0, top = 288, mStatusBarHeight = " + this.f29114f);
        }
        this.a.setX(i5);
        this.a.setY(i6);
        requestLayout();
    }

    @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        FullScreenFloatView.c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            Rect rect = new Rect();
            int action = motionEvent.getAction();
            if (action == 0) {
                this.a.getHitRect(rect);
                if (rect.contains((int) x, (int) y)) {
                    this.j = x;
                    this.k = y;
                    this.f29116h = true;
                    this.f29115g = true;
                    postDelayed(this.l, ViewConfiguration.getTapTimeout());
                }
            } else if (action == 1) {
                if (this.f29115g) {
                    FullScreenFloatView.c cVar2 = this.m;
                    if (cVar2 != null) {
                        cVar2.onClick();
                    }
                    removeCallbacks(this.l);
                } else if (this.f29116h && (cVar = this.m) != null) {
                    cVar.a();
                }
                if (o) {
                    Log.e("FloatButton", "ACTION_UP--> x = " + x + ", y = " + y + ",mIsClickDrag = " + this.f29115g);
                }
                if (this.i && !this.f29115g && x >= 0.0f) {
                    int i = this.f29112d;
                    if (x <= i && y >= 0.0f && y <= this.f29113e + this.f29111c) {
                        this.a.animate().x(i - this.f29110b).setInterpolator(new AccelerateInterpolator()).setDuration(300L).start();
                    }
                }
                this.f29115g = false;
                this.f29116h = false;
            } else if (action == 2) {
                float abs = Math.abs(x - this.j);
                float abs2 = Math.abs(y - this.k);
                if (Math.sqrt((abs2 * abs2) + (abs * abs)) > 10.0d) {
                    this.f29115g = false;
                }
                d(x, y);
            } else if (action == 3) {
                this.f29115g = false;
                this.f29116h = false;
            } else if (action == 4) {
                this.f29115g = false;
                this.f29116h = false;
            }
            return this.f29115g | this.f29116h;
        }
        return invokeL.booleanValue;
    }

    public void setFloatButtonDefaultPosition() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            findViewById(R.id.obfuscated_res_0x7f0909c8).setBottom(n0.O(191.0f));
        }
    }

    public void setFloatButtonDrawable(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, drawable) == null) || drawable == null) {
            return;
        }
        View findViewById = findViewById(R.id.obfuscated_res_0x7f0909c8);
        if (findViewById instanceof Button) {
            findViewById.setBackground(drawable);
        }
    }

    public void setFloatButtonStyle(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, jSONObject) == null) {
            View findViewById = findViewById(R.id.obfuscated_res_0x7f0909c8);
            String optString = jSONObject != null ? jSONObject.optString("backgroundColor", "#4E4E4E") : "#4E4E4E";
            if (findViewById instanceof Button) {
                ((GradientDrawable) findViewById.getBackground()).setColor(SwanAppConfigData.t(optString));
                ((Button) findViewById).setTextColor(SwanAppConfigData.t("#FFFFFF"));
                findViewById.setAlpha((float) 0.8999999761581421d);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FloatButton(Context context, AttributeSet attributeSet, int i) {
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
    }
}
