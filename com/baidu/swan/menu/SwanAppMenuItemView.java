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
import c.a.r0.n.f;
import c.a.r0.n.g;
import c.a.r0.n.h;
import c.a.r0.n.i;
import c.a.r0.n.j;
import c.a.r0.n.o;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes11.dex */
public class SwanAppMenuItemView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f39920e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f39921f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f39922g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f39923h;

    /* renamed from: i  reason: collision with root package name */
    public o f39924i;

    /* renamed from: j  reason: collision with root package name */
    public int f39925j;
    public int k;
    public boolean l;
    public Runnable m;

    /* loaded from: classes11.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppMenuItemView f39926e;

        public a(SwanAppMenuItemView swanAppMenuItemView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppMenuItemView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f39926e = swanAppMenuItemView;
        }

        @Override // java.lang.Runnable
        public void run() {
            o oVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (oVar = this.f39926e.f39924i) == null || oVar.d() == null) {
                return;
            }
            SwanAppMenuItemView swanAppMenuItemView = this.f39926e;
            swanAppMenuItemView.l = swanAppMenuItemView.f39924i.d().a(this.f39926e.f39924i);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = false;
        this.m = new a(this);
        d();
    }

    private void setAllPressed(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65539, this, z) == null) {
            this.f39920e.setPressed(z);
            this.f39921f.setPressed(z);
            setPressed(z);
        }
    }

    public final String a(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j2)) == null) ? j2 <= 99 ? String.valueOf(j2) : "99+" : (String) invokeJ.objValue;
    }

    public final Drawable b(o oVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, oVar)) == null) ? oVar.a(getContext()) : (Drawable) invokeL.objValue;
    }

    public final int c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            Resources resources = getResources();
            return (int) (((i2 * 0.5d) + (resources.getDimension(g.aiapp_menu_item_icon_width) * 0.5d)) - resources.getDimension(g.aiapp_menu_item_new_tips_cross_with_icon));
        }
        return invokeI.intValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            setGravity(49);
            LayoutInflater.from(getContext()).inflate(j.aiapp_menu_item_view_layout, this);
            this.f39920e = (ImageView) findViewById(i.aiapp_menu_item_icon);
            this.f39921f = (TextView) findViewById(i.aiapp_menu_item_title);
            this.f39922g = (TextView) findViewById(i.aiapp_menu_item_new_tips);
            this.f39923h = (ImageView) findViewById(i.aiapp_menu_item_new_dot);
            setBackgroundResource(0);
        }
    }

    public final void e(o oVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048580, this, oVar, i2) == null) {
            this.f39921f.setEllipsize(TextUtils.TruncateAt.END);
            this.f39921f.setAlpha(oVar.i() ? 1.0f : 0.3f);
            this.f39920e.setEnabled(oVar.i());
            this.f39920e.setScaleType(ImageView.ScaleType.CENTER);
            this.f39920e.setVisibility(0);
            g(oVar);
            f(oVar, i2);
        }
    }

    public final void f(o oVar, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048581, this, oVar, i2) == null) || oVar == null) {
            return;
        }
        int f2 = oVar.f();
        if (f2 == 0) {
            this.f39922g.setVisibility(8);
            this.f39922g.setVisibility(8);
        } else if (f2 != 1) {
            if (f2 != 2) {
                this.f39922g.setVisibility(8);
                this.f39923h.setVisibility(8);
                return;
            }
            this.f39922g.setVisibility(8);
            this.f39923h.setImageDrawable(getResources().getDrawable(h.swan_app_menu_new_dot));
            this.f39923h.setVisibility(0);
        } else if (i2 <= 0) {
        } else {
            this.f39923h.setVisibility(8);
            this.f39922g.setText(a(oVar.e()));
            this.f39922g.setTextColor(getResources().getColor(f.swan_app_menu_item_tip_text));
            this.f39922g.setBackground(getResources().getDrawable(h.swan_app_menu_new_bg));
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f39922g.getLayoutParams();
            marginLayoutParams.leftMargin = c(i2);
            this.f39922g.setLayoutParams(marginLayoutParams);
            this.f39922g.setVisibility(0);
        }
    }

    public final void g(o oVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, oVar) == null) || oVar == null) {
            return;
        }
        setAlpha(1.0f);
        this.f39921f.setText(oVar.h(getContext()));
        Drawable b2 = b(oVar);
        if (b2 != null) {
            this.f39920e.setImageDrawable(b2);
            this.f39920e.setImageLevel(oVar.b());
        }
    }

    public void h(o oVar, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048583, this, oVar, i2) == null) || oVar == null) {
            return;
        }
        e(oVar, i2);
        this.f39924i = oVar;
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
                o oVar = this.f39924i;
                if (oVar != null && oVar.d() != null) {
                    removeCallbacks(this.m);
                    this.l = false;
                    this.f39925j = x;
                    this.k = y;
                    postDelayed(this.m, 3000L);
                    setAllPressed(true);
                } else {
                    return super.onTouchEvent(motionEvent);
                }
            } else if (action == 1) {
                removeCallbacks(this.m);
                if (!this.l && this.f39924i.g() != null) {
                    this.f39924i.g().b(this, this.f39924i);
                }
                this.l = false;
                setAllPressed(false);
                return super.onTouchEvent(motionEvent);
            } else if (action != 2) {
                if (action == 3) {
                    removeCallbacks(this.m);
                    this.l = false;
                    setAllPressed(false);
                    return super.onTouchEvent(motionEvent);
                }
            } else if (Math.abs(this.f39925j - x) > 10 || Math.abs(this.k - y) > 10) {
                removeCallbacks(this.m);
                this.l = false;
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
        this.l = false;
        this.m = new a(this);
        d();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwanAppMenuItemView(Context context, AttributeSet attributeSet, int i2) {
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
        this.l = false;
        this.m = new a(this);
        d();
    }
}
