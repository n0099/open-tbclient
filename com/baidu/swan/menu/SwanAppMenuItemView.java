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
import c.a.n0.n.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class SwanAppMenuItemView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f29668b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f29669c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f29670d;

    /* renamed from: e  reason: collision with root package name */
    public g f29671e;

    /* renamed from: f  reason: collision with root package name */
    public int f29672f;

    /* renamed from: g  reason: collision with root package name */
    public int f29673g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f29674h;
    public Runnable i;

    /* loaded from: classes4.dex */
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
            g gVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (gVar = this.a.f29671e) == null || gVar.d() == null) {
                return;
            }
            SwanAppMenuItemView swanAppMenuItemView = this.a;
            swanAppMenuItemView.f29674h = swanAppMenuItemView.f29671e.d().a(this.a.f29671e);
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
        this.f29674h = false;
        this.i = new a(this);
        d();
    }

    private void setAllPressed(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65539, this, z) == null) {
            this.a.setPressed(z);
            this.f29668b.setPressed(z);
            setPressed(z);
        }
    }

    public final String a(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j)) == null) ? j <= 99 ? String.valueOf(j) : "99+" : (String) invokeJ.objValue;
    }

    public final Drawable b(g gVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gVar)) == null) ? gVar.a(getContext()) : (Drawable) invokeL.objValue;
    }

    public final int c(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            Resources resources = getResources();
            return (int) (((i * 0.5d) + (resources.getDimension(R.dimen.obfuscated_res_0x7f0700e4) * 0.5d)) - resources.getDimension(R.dimen.obfuscated_res_0x7f0700e5));
        }
        return invokeI.intValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            setGravity(49);
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d0091, this);
            this.a = (ImageView) findViewById(R.id.obfuscated_res_0x7f09018d);
            this.f29668b = (TextView) findViewById(R.id.obfuscated_res_0x7f090190);
            this.f29669c = (TextView) findViewById(R.id.obfuscated_res_0x7f09018f);
            this.f29670d = (ImageView) findViewById(R.id.obfuscated_res_0x7f09018e);
            setBackgroundResource(0);
        }
    }

    public final void e(g gVar, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048580, this, gVar, i) == null) {
            this.f29668b.setEllipsize(TextUtils.TruncateAt.END);
            this.f29668b.setAlpha(gVar.i() ? 1.0f : 0.3f);
            this.a.setEnabled(gVar.i());
            this.a.setScaleType(ImageView.ScaleType.CENTER);
            this.a.setVisibility(0);
            g(gVar);
            f(gVar, i);
        }
    }

    public final void f(g gVar, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048581, this, gVar, i) == null) || gVar == null) {
            return;
        }
        int f2 = gVar.f();
        if (f2 == 0) {
            this.f29669c.setVisibility(8);
            this.f29669c.setVisibility(8);
        } else if (f2 != 1) {
            if (f2 != 2) {
                this.f29669c.setVisibility(8);
                this.f29670d.setVisibility(8);
                return;
            }
            this.f29669c.setVisibility(8);
            this.f29670d.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f08111d));
            this.f29670d.setVisibility(0);
        } else if (i <= 0) {
        } else {
            this.f29670d.setVisibility(8);
            this.f29669c.setText(a(gVar.e()));
            this.f29669c.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f060a37));
            this.f29669c.setBackground(getResources().getDrawable(R.drawable.obfuscated_res_0x7f08111c));
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f29669c.getLayoutParams();
            marginLayoutParams.leftMargin = c(i);
            this.f29669c.setLayoutParams(marginLayoutParams);
            this.f29669c.setVisibility(0);
        }
    }

    public final void g(g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, gVar) == null) || gVar == null) {
            return;
        }
        setAlpha(1.0f);
        this.f29668b.setText(gVar.h(getContext()));
        Drawable b2 = b(gVar);
        if (b2 != null) {
            this.a.setImageDrawable(b2);
            this.a.setImageLevel(gVar.b());
        }
    }

    public void h(g gVar, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048583, this, gVar, i) == null) || gVar == null) {
            return;
        }
        e(gVar, i);
        this.f29671e = gVar;
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
                g gVar = this.f29671e;
                if (gVar != null && gVar.d() != null) {
                    removeCallbacks(this.i);
                    this.f29674h = false;
                    this.f29672f = x;
                    this.f29673g = y;
                    postDelayed(this.i, 3000L);
                    setAllPressed(true);
                } else {
                    return super.onTouchEvent(motionEvent);
                }
            } else if (action == 1) {
                removeCallbacks(this.i);
                if (!this.f29674h && this.f29671e.g() != null) {
                    this.f29671e.g().b(this, this.f29671e);
                }
                this.f29674h = false;
                setAllPressed(false);
                return super.onTouchEvent(motionEvent);
            } else if (action != 2) {
                if (action == 3) {
                    removeCallbacks(this.i);
                    this.f29674h = false;
                    setAllPressed(false);
                    return super.onTouchEvent(motionEvent);
                }
            } else if (Math.abs(this.f29672f - x) > 10 || Math.abs(this.f29673g - y) > 10) {
                removeCallbacks(this.i);
                this.f29674h = false;
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
        this.f29674h = false;
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
        this.f29674h = false;
        this.i = new a(this);
        d();
    }
}
