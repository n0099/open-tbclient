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
import c.a.p0.n.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class SwanAppMenuItemView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f38580e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f38581f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f38582g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f38583h;

    /* renamed from: i  reason: collision with root package name */
    public g f38584i;

    /* renamed from: j  reason: collision with root package name */
    public int f38585j;
    public int k;
    public boolean l;
    public Runnable m;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppMenuItemView f38586e;

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
            this.f38586e = swanAppMenuItemView;
        }

        @Override // java.lang.Runnable
        public void run() {
            g gVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (gVar = this.f38586e.f38584i) == null || gVar.d() == null) {
                return;
            }
            SwanAppMenuItemView swanAppMenuItemView = this.f38586e;
            swanAppMenuItemView.l = swanAppMenuItemView.f38584i.d().a(this.f38586e.f38584i);
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
            this.f38580e.setPressed(z);
            this.f38581f.setPressed(z);
            setPressed(z);
        }
    }

    public final String a(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j2)) == null) ? j2 <= 99 ? String.valueOf(j2) : "99+" : (String) invokeJ.objValue;
    }

    public final Drawable b(g gVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gVar)) == null) ? gVar.a(getContext()) : (Drawable) invokeL.objValue;
    }

    public final int c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            Resources resources = getResources();
            return (int) (((i2 * 0.5d) + (resources.getDimension(R.dimen.aiapp_menu_item_icon_width) * 0.5d)) - resources.getDimension(R.dimen.aiapp_menu_item_new_tips_cross_with_icon));
        }
        return invokeI.intValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            setGravity(49);
            LayoutInflater.from(getContext()).inflate(R.layout.aiapp_menu_item_view_layout, this);
            this.f38580e = (ImageView) findViewById(R.id.aiapp_menu_item_icon);
            this.f38581f = (TextView) findViewById(R.id.aiapp_menu_item_title);
            this.f38582g = (TextView) findViewById(R.id.aiapp_menu_item_new_tips);
            this.f38583h = (ImageView) findViewById(R.id.aiapp_menu_item_new_dot);
            setBackgroundResource(0);
        }
    }

    public final void e(g gVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048580, this, gVar, i2) == null) {
            this.f38581f.setEllipsize(TextUtils.TruncateAt.END);
            this.f38581f.setAlpha(gVar.i() ? 1.0f : 0.3f);
            this.f38580e.setEnabled(gVar.i());
            this.f38580e.setScaleType(ImageView.ScaleType.CENTER);
            this.f38580e.setVisibility(0);
            g(gVar);
            f(gVar, i2);
        }
    }

    public final void f(g gVar, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048581, this, gVar, i2) == null) || gVar == null) {
            return;
        }
        int f2 = gVar.f();
        if (f2 == 0) {
            this.f38582g.setVisibility(8);
            this.f38582g.setVisibility(8);
        } else if (f2 != 1) {
            if (f2 != 2) {
                this.f38582g.setVisibility(8);
                this.f38583h.setVisibility(8);
                return;
            }
            this.f38582g.setVisibility(8);
            this.f38583h.setImageDrawable(getResources().getDrawable(R.drawable.swan_app_menu_new_dot));
            this.f38583h.setVisibility(0);
        } else if (i2 <= 0) {
        } else {
            this.f38583h.setVisibility(8);
            this.f38582g.setText(a(gVar.e()));
            this.f38582g.setTextColor(getResources().getColor(R.color.swan_app_menu_item_tip_text));
            this.f38582g.setBackground(getResources().getDrawable(R.drawable.swan_app_menu_new_bg));
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f38582g.getLayoutParams();
            marginLayoutParams.leftMargin = c(i2);
            this.f38582g.setLayoutParams(marginLayoutParams);
            this.f38582g.setVisibility(0);
        }
    }

    public final void g(g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, gVar) == null) || gVar == null) {
            return;
        }
        setAlpha(1.0f);
        this.f38581f.setText(gVar.h(getContext()));
        Drawable b2 = b(gVar);
        if (b2 != null) {
            this.f38580e.setImageDrawable(b2);
            this.f38580e.setImageLevel(gVar.b());
        }
    }

    public void h(g gVar, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048583, this, gVar, i2) == null) || gVar == null) {
            return;
        }
        e(gVar, i2);
        this.f38584i = gVar;
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
                g gVar = this.f38584i;
                if (gVar != null && gVar.d() != null) {
                    removeCallbacks(this.m);
                    this.l = false;
                    this.f38585j = x;
                    this.k = y;
                    postDelayed(this.m, 3000L);
                    setAllPressed(true);
                } else {
                    return super.onTouchEvent(motionEvent);
                }
            } else if (action == 1) {
                removeCallbacks(this.m);
                if (!this.l && this.f38584i.g() != null) {
                    this.f38584i.g().b(this, this.f38584i);
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
            } else if (Math.abs(this.f38585j - x) > 10 || Math.abs(this.k - y) > 10) {
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
