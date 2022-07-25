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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.o64;
/* loaded from: classes2.dex */
public class SwanAppMenuItemView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView a;
    public TextView b;
    public TextView c;
    public ImageView d;
    public o64 e;
    public int f;
    public int g;
    public boolean h;
    public Runnable i;

    /* loaded from: classes2.dex */
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
            o64 o64Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (o64Var = this.a.e) == null || o64Var.d() == null) {
                return;
            }
            SwanAppMenuItemView swanAppMenuItemView = this.a;
            swanAppMenuItemView.h = swanAppMenuItemView.e.d().a(this.a.e);
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
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j)) == null) ? j <= 99 ? String.valueOf(j) : "99+" : (String) invokeJ.objValue;
    }

    public final Drawable b(o64 o64Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, o64Var)) == null) ? o64Var.a(getContext()) : (Drawable) invokeL.objValue;
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
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d008a, this);
            this.a = (ImageView) findViewById(R.id.obfuscated_res_0x7f090189);
            this.b = (TextView) findViewById(R.id.obfuscated_res_0x7f09018c);
            this.c = (TextView) findViewById(R.id.obfuscated_res_0x7f09018b);
            this.d = (ImageView) findViewById(R.id.obfuscated_res_0x7f09018a);
            setBackgroundResource(0);
        }
    }

    public final void e(o64 o64Var, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048580, this, o64Var, i) == null) {
            this.b.setEllipsize(TextUtils.TruncateAt.END);
            this.b.setAlpha(o64Var.i() ? 1.0f : 0.3f);
            this.a.setEnabled(o64Var.i());
            this.a.setScaleType(ImageView.ScaleType.CENTER);
            this.a.setVisibility(0);
            g(o64Var);
            f(o64Var, i);
        }
    }

    public final void f(o64 o64Var, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048581, this, o64Var, i) == null) || o64Var == null) {
            return;
        }
        int f = o64Var.f();
        if (f == 0) {
            this.c.setVisibility(8);
            this.c.setVisibility(8);
        } else if (f != 1) {
            if (f != 2) {
                this.c.setVisibility(8);
                this.d.setVisibility(8);
                return;
            }
            this.c.setVisibility(8);
            this.d.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f0810c5));
            this.d.setVisibility(0);
        } else if (i <= 0) {
        } else {
            this.d.setVisibility(8);
            this.c.setText(a(o64Var.e()));
            this.c.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f060a34));
            this.c.setBackground(getResources().getDrawable(R.drawable.obfuscated_res_0x7f0810c4));
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.c.getLayoutParams();
            marginLayoutParams.leftMargin = c(i);
            this.c.setLayoutParams(marginLayoutParams);
            this.c.setVisibility(0);
        }
    }

    public final void g(o64 o64Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, o64Var) == null) || o64Var == null) {
            return;
        }
        setAlpha(1.0f);
        this.b.setText(o64Var.h(getContext()));
        Drawable b = b(o64Var);
        if (b != null) {
            this.a.setImageDrawable(b);
            this.a.setImageLevel(o64Var.b());
        }
    }

    public void h(o64 o64Var, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048583, this, o64Var, i) == null) || o64Var == null) {
            return;
        }
        e(o64Var, i);
        this.e = o64Var;
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
            if (action == 0) {
                o64 o64Var = this.e;
                if (o64Var != null && o64Var.d() != null) {
                    removeCallbacks(this.i);
                    this.h = false;
                    this.f = x;
                    this.g = y;
                    postDelayed(this.i, 3000L);
                    setAllPressed(true);
                } else {
                    return super.onTouchEvent(motionEvent);
                }
            } else if (action == 1) {
                removeCallbacks(this.i);
                if (!this.h && this.e.g() != null) {
                    this.e.g().b(this, this.e);
                }
                this.h = false;
                setAllPressed(false);
                return super.onTouchEvent(motionEvent);
            } else if (action != 2) {
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
            return true;
        }
        return invokeL.booleanValue;
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
}
