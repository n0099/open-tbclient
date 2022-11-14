package com.baidu.swan.menu;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.tieba.na4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class SwanAppMenuItemView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView a;
    public TextView b;
    public TextView c;
    public ImageView d;
    public na4 e;
    public int f;
    public int g;
    public boolean h;
    public Runnable i;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppMenuItemView a;

        public a(SwanAppMenuItemView swanAppMenuItemView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppMenuItemView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = swanAppMenuItemView;
        }

        @Override // java.lang.Runnable
        public void run() {
            na4 na4Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (na4Var = this.a.e) != null && na4Var.d() != null) {
                SwanAppMenuItemView swanAppMenuItemView = this.a;
                swanAppMenuItemView.h = swanAppMenuItemView.e.d().a(this.a.e);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwanAppMenuItemView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.h = false;
        this.i = new a(this);
        d();
    }

    public final void g(na4 na4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, na4Var) != null) || na4Var == null) {
            return;
        }
        setAlpha(1.0f);
        this.b.setText(na4Var.h(getContext()));
        Drawable b = b(na4Var);
        if (b != null) {
            this.a.setImageDrawable(b);
            this.a.setImageLevel(na4Var.b());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwanAppMenuItemView(Context context, AttributeSet attributeSet) {
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
        this.h = false;
        this.i = new a(this);
        d();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwanAppMenuItemView(Context context, AttributeSet attributeSet, int i) {
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
        this.h = false;
        this.i = new a(this);
        d();
    }

    private void setAllPressed(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65539, this, z) == null) {
            this.a.setPressed(z);
            this.b.setPressed(z);
            setPressed(z);
        }
    }

    public final String a(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j)) == null) {
            if (j <= 99) {
                return String.valueOf(j);
            }
            return "99+";
        }
        return (String) invokeJ.objValue;
    }

    public final Drawable b(na4 na4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, na4Var)) == null) {
            return na4Var.a(getContext());
        }
        return (Drawable) invokeL.objValue;
    }

    public final int c(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            Resources resources = getResources();
            return (int) (((i * 0.5d) + (resources.getDimension(R.dimen.obfuscated_res_0x7f0700e2) * 0.5d)) - resources.getDimension(R.dimen.obfuscated_res_0x7f0700e3));
        }
        return invokeI.intValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            setGravity(49);
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d008e, this);
            this.a = (ImageView) findViewById(R.id.obfuscated_res_0x7f090198);
            this.b = (TextView) findViewById(R.id.obfuscated_res_0x7f09019b);
            this.c = (TextView) findViewById(R.id.obfuscated_res_0x7f09019a);
            this.d = (ImageView) findViewById(R.id.obfuscated_res_0x7f090199);
            setBackgroundResource(0);
        }
    }

    public final void e(na4 na4Var, int i) {
        float f;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048580, this, na4Var, i) == null) {
            this.b.setEllipsize(TextUtils.TruncateAt.END);
            if (na4Var.i()) {
                f = 1.0f;
            } else {
                f = 0.3f;
            }
            this.b.setAlpha(f);
            this.a.setEnabled(na4Var.i());
            this.a.setScaleType(ImageView.ScaleType.CENTER);
            this.a.setVisibility(0);
            g(na4Var);
            f(na4Var, i);
        }
    }

    public final void f(na4 na4Var, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(1048581, this, na4Var, i) != null) || na4Var == null) {
            return;
        }
        int f = na4Var.f();
        if (f != 0) {
            if (f != 1) {
                if (f != 2) {
                    this.c.setVisibility(8);
                    this.d.setVisibility(8);
                    return;
                }
                this.c.setVisibility(8);
                this.d.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f081199));
                this.d.setVisibility(0);
                return;
            } else if (i <= 0) {
                return;
            } else {
                this.d.setVisibility(8);
                this.c.setText(a(na4Var.e()));
                this.c.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f060a80));
                this.c.setBackground(getResources().getDrawable(R.drawable.obfuscated_res_0x7f081198));
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.c.getLayoutParams();
                marginLayoutParams.leftMargin = c(i);
                this.c.setLayoutParams(marginLayoutParams);
                this.c.setVisibility(0);
                return;
            }
        }
        this.c.setVisibility(8);
        this.c.setVisibility(8);
    }

    public void h(na4 na4Var, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(1048583, this, na4Var, i) != null) || na4Var == null) {
            return;
        }
        e(na4Var, i);
        this.e = na4Var;
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, motionEvent)) == null) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 1) {
                    if (action != 2) {
                        if (action == 3) {
                            removeCallbacks(this.i);
                            this.h = false;
                            setAllPressed(false);
                            return super.onTouchEvent(motionEvent);
                        }
                    } else if (Math.abs(this.f - x) > 10 || Math.abs(this.g - y) > 10) {
                        removeCallbacks(this.i);
                        this.h = false;
                    }
                } else {
                    removeCallbacks(this.i);
                    if (!this.h && this.e.g() != null) {
                        this.e.g().b(this, this.e);
                    }
                    this.h = false;
                    setAllPressed(false);
                    return super.onTouchEvent(motionEvent);
                }
            } else {
                na4 na4Var = this.e;
                if (na4Var != null && na4Var.d() != null) {
                    removeCallbacks(this.i);
                    this.h = false;
                    this.f = x;
                    this.g = y;
                    postDelayed(this.i, 3000L);
                    setAllPressed(true);
                } else {
                    return super.onTouchEvent(motionEvent);
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
