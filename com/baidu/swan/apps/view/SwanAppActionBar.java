package com.baidu.swan.apps.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.e;
import c.a.p0.a.f;
import c.a.p0.a.g;
import c.a.p0.a.j;
import c.a.p0.a.v2.n0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class SwanAppActionBar extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public View f46749e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f46750f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f46751g;

    /* renamed from: h  reason: collision with root package name */
    public View f46752h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f46753i;

    /* renamed from: j  reason: collision with root package name */
    public View f46754j;
    public ProgressBar k;
    public TextView l;
    public String m;
    public int n;
    public float o;
    public float p;
    public float q;
    public View r;
    public ImageView s;
    public ImageView t;
    public View u;
    public ImageView v;
    public c w;
    public boolean x;

    /* loaded from: classes6.dex */
    public class a implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ GestureDetector f46755e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SwanAppActionBar f46756f;

        public a(SwanAppActionBar swanAppActionBar, GestureDetector gestureDetector) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppActionBar, gestureDetector};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46756f = swanAppActionBar;
            this.f46755e = gestureDetector;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) ? this.f46755e.onTouchEvent(motionEvent) : invokeLL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class b extends GestureDetector.SimpleOnGestureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppActionBar f46757e;

        public b(SwanAppActionBar swanAppActionBar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppActionBar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46757e = swanAppActionBar;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
                if (this.f46757e.w != null) {
                    this.f46757e.w.a(this.f46757e);
                }
                return super.onDoubleTap(motionEvent);
            }
            return invokeL.booleanValue;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent)) == null) ? !this.f46757e.x : invokeL.booleanValue;
        }

        public /* synthetic */ b(SwanAppActionBar swanAppActionBar, a aVar) {
            this(swanAppActionBar);
        }
    }

    /* loaded from: classes6.dex */
    public interface c {
        void a(View view);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwanAppActionBar(Context context) {
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
        d();
    }

    private void setFrontColorBlack(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(AdIconUtil.AD_TEXT_ID, this, z) == null) {
            setTitleColor(-16777216);
            setLeftBackViewSrc(e.aiapps_action_bar_back_black_selector);
            setLeftFloatBackViewSrc(e.aiapps_action_bar_back_black_selector);
            setLeftHomeViewSrc(e.aiapps_action_bar_home_black_selector);
            setRightMenuImageSrc(z ? e.aiapps_action_bar_single_menu_black_selector : e.aiapps_action_bar_menu_black_selector);
            setRightExitImageSrc(e.aiapps_action_bar_exit_black_selector);
            setRightLineSrc(c.a.p0.a.c.aiapps_action_bar_menu_line_color);
            setRightZoneBgSrc(z ? c.a.p0.a.c.aiapps_transparent : e.aiapps_action_bar_right_menu_bg);
        }
    }

    private void setFrontColorWhite(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(AdIconUtil.BAIDU_LOGO_ID, this, z) == null) {
            setTitleColor(-1);
            setLeftBackViewSrc(e.aiapps_action_bar_back_white_selector);
            setLeftFloatBackViewSrc(e.aiapps_action_bar_back_white_selector);
            setLeftHomeViewSrc(e.aiapps_action_bar_home_white_selector);
            setRightMenuImageSrc(z ? e.aiapps_action_bar_single_menu_white_selector : e.aiapps_action_bar_menu_white_selector);
            setRightExitImageSrc(e.aiapps_action_bar_exit_white_selector);
            setRightLineSrc(c.a.p0.a.c.aiapps_action_bar_menu_line_white);
            setRightZoneBgSrc(z ? c.a.p0.a.c.aiapps_transparent : e.aiapps_action_bar_right_menu_bg_solid);
        }
    }

    public final Drawable c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            Drawable drawable = getResources().getDrawable(i2);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            return drawable;
        }
        return (Drawable) invokeI.objValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LayoutInflater.from(getContext()).inflate(g.aiapps_action_bar, this);
            this.f46749e = findViewById(f.titlebar_left_zone);
            TextView textView = (TextView) findViewById(f.left_first_view);
            this.f46750f = textView;
            textView.setCompoundDrawables(c(e.aiapps_action_bar_back_black_selector), null, null, null);
            this.f46750f.setTextColor(getResources().getColorStateList(c.a.p0.a.c.swan_app_action_bar_operation_btn_selector));
            this.f46751g = (TextView) findViewById(f.left_second_view);
            this.f46752h = findViewById(f.titlebar_left_float_zone);
            this.f46753i = (ImageView) findViewById(f.left_float_back_view);
            this.f46754j = findViewById(f.titlebar_center_zone);
            this.k = (ProgressBar) findViewById(f.aiapps_nav_loading_progressbar);
            this.l = (TextView) findViewById(f.title_text_center);
            float f2 = this.o;
            if (f2 != -1.0f) {
                float f3 = this.p;
                if (f3 != -1.0f) {
                    float f4 = this.q;
                    if (f4 != -1.0f) {
                        this.f46750f.setShadowLayer(f4, f2, f3, this.n);
                    }
                }
            }
            this.r = findViewById(f.titlebar_right_menu);
            this.s = (ImageView) findViewById(f.titlebar_right_menu_img);
            this.t = (ImageView) findViewById(f.titlebar_right_menu_red_dot);
            this.u = findViewById(f.titlebar_right_menu_line);
            this.v = (ImageView) findViewById(f.titlebar_right_menu_exit);
            setTitle(this.m);
            setTitleColor(-16777216);
            setRightMenuImageSrc(e.aiapps_action_bar_menu_normal_selector);
            setOnTouchListener(new a(this, new GestureDetector(getContext(), new b(this, null))));
        }
    }

    public final void e(Context context, AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, attributeSet) == null) || attributeSet == null) {
            return;
        }
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, j.SwanAppActionBar, 0, 0);
        try {
            this.m = obtainStyledAttributes.getString(j.SwanAppActionBar_titleText);
            this.n = obtainStyledAttributes.getColor(j.SwanAppActionBar_titleTxtShadowColor, -16777216);
            this.o = obtainStyledAttributes.getFloat(j.SwanAppActionBar_titleTxtShadowDx, -1.0f);
            this.p = obtainStyledAttributes.getFloat(j.SwanAppActionBar_titleTxtShadowDy, -1.0f);
            this.q = obtainStyledAttributes.getFloat(j.SwanAppActionBar_titleTxtShadowRadius, -1.0f);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public TextView getCenterTitleView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.l : (TextView) invokeV.objValue;
    }

    public View getRightMenu() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.r : (View) invokeV.objValue;
    }

    public void setActionBarCustom(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.x = z;
            int i2 = z ? 8 : 0;
            setLeftZoneVisibility(i2);
            setCenterZoneVisibility(i2);
            setLeftFloatZoneVisibility(z2 ? 0 : 8);
        }
    }

    public boolean setActionBarFrontColor(@ColorInt int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            if (i2 == -1) {
                setFrontColorWhite(z);
                return true;
            } else if (i2 == -16777216) {
                setFrontColorBlack(z);
                return true;
            } else {
                setFrontColorWhite(z);
                return false;
            }
        }
        return invokeCommon.booleanValue;
    }

    public void setCenterZoneVisibility(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.f46754j.setVisibility(i2);
        }
    }

    public void setLeftBackViewClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, onClickListener) == null) {
            this.f46750f.setOnClickListener(onClickListener);
        }
    }

    public void setLeftBackViewMinWidth(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.f46750f.setMinimumWidth(i2);
        }
    }

    public void setLeftBackViewSrc(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            Drawable drawable = i2 != 0 ? getResources().getDrawable(i2) : null;
            if (drawable != null) {
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            }
            this.f46750f.setCompoundDrawables(drawable, null, null, null);
            this.f46750f.setSelected(false);
        }
    }

    public void setLeftBackViewVisibility(boolean z) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048587, this, z) == null) || (textView = this.f46750f) == null) {
            return;
        }
        textView.setVisibility(z ? 0 : 8);
    }

    public void setLeftFloatBackViewClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, onClickListener) == null) {
            this.f46753i.setOnClickListener(onClickListener);
        }
    }

    public void setLeftFloatBackViewSrc(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            this.f46753i.setImageResource(i2);
        }
    }

    public void setLeftFloatZoneVisibility(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.f46752h.setVisibility(i2);
        }
    }

    public void setLeftHomeViewClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, onClickListener) == null) {
            this.f46751g.setOnClickListener(onClickListener);
        }
    }

    public void setLeftHomeViewSrc(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            Drawable drawable = i2 != 0 ? getResources().getDrawable(i2) : null;
            if (drawable != null) {
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            }
            this.f46751g.setCompoundDrawables(drawable, null, null, null);
            this.f46751g.setSelected(false);
        }
    }

    public void setLeftHomeViewVisibility(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            this.f46751g.setVisibility(i2);
        }
    }

    public void setLeftZoneVisibility(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            this.f46749e.setVisibility(i2);
        }
    }

    public void setOnDoubleClickListener(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, cVar) == null) {
            this.w = cVar;
        }
    }

    public void setRightExitImageSrc(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            this.v.setImageDrawable(getResources().getDrawable(i2));
        }
    }

    public void setRightExitOnClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, onClickListener) == null) {
            this.v.setOnClickListener(onClickListener);
        }
    }

    public void setRightExitViewVisibility(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            if (z) {
                this.v.setVisibility(0);
                this.u.setVisibility(0);
                return;
            }
            this.v.setVisibility(8);
            this.u.setVisibility(8);
            ((RelativeLayout.LayoutParams) this.r.getLayoutParams()).setMargins(0, 0, n0.f(getContext(), 4.6f), 0);
        }
    }

    public void setRightLineSrc(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i2) == null) {
            this.u.setBackgroundResource(i2);
        }
    }

    public void setRightMenuAlpha(float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048600, this, f2) == null) || f2 < 0.0f || f2 > 1.0f) {
            return;
        }
        this.r.setAlpha(f2);
    }

    public void setRightMenuEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
            this.s.setEnabled(z);
            this.u.setEnabled(z);
            this.v.setEnabled(z);
        }
    }

    public void setRightMenuImageSrc(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i2) == null) {
            this.s.setImageDrawable(getResources().getDrawable(i2));
        }
    }

    public void setRightMenuOnClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, onClickListener) == null) {
            this.s.setOnClickListener(onClickListener);
        }
    }

    public void setRightRedDotVisibility(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048604, this, z) == null) {
            this.t.setVisibility(z ? 0 : 8);
        }
    }

    public void setRightZoneBgSrc(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048605, this, i2) == null) {
            this.r.setBackgroundResource(i2);
        }
    }

    public void setRightZoneVisibility(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048606, this, z) == null) {
            this.r.setVisibility(z ? 0 : 8);
        }
    }

    public void setTitle(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, str) == null) {
            this.m = str;
            this.l.setText(str);
        }
    }

    public void setTitleColor(@ColorInt int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048609, this, i2) == null) {
            this.l.setTextColor(i2);
        }
    }

    public void showLoadingProgressBar(boolean z) {
        ProgressBar progressBar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048610, this, z) == null) || (progressBar = this.k) == null) {
            return;
        }
        if (z && progressBar.getVisibility() == 8) {
            this.k.setVisibility(0);
        } else if (z || this.k.getVisibility() != 0) {
        } else {
            this.k.setVisibility(8);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwanAppActionBar(Context context, AttributeSet attributeSet) {
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
        e(context, attributeSet);
        d();
    }

    public void setTitle(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048607, this, i2) == null) {
            setTitle(getResources().getString(i2));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwanAppActionBar(Context context, AttributeSet attributeSet, int i2) {
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
        e(context, attributeSet);
        d();
    }
}
