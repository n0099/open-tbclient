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
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.zd3;
/* loaded from: classes2.dex */
public class SwanAppActionBar extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;
    public TextView b;
    public TextView c;
    public View d;
    public ImageView e;
    public View f;
    public ProgressBar g;
    public TextView h;
    public String i;
    public int j;
    public float k;
    public float l;
    public float m;
    public View n;
    public ImageView o;
    public ImageView p;
    public View q;
    public ImageView r;
    public c s;
    public boolean t;

    /* loaded from: classes2.dex */
    public class a implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GestureDetector a;
        public final /* synthetic */ SwanAppActionBar b;

        public a(SwanAppActionBar swanAppActionBar, GestureDetector gestureDetector) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppActionBar, gestureDetector};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = swanAppActionBar;
            this.a = gestureDetector;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) ? this.a.onTouchEvent(motionEvent) : invokeLL.booleanValue;
        }
    }

    /* loaded from: classes2.dex */
    public class b extends GestureDetector.SimpleOnGestureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppActionBar a;

        public b(SwanAppActionBar swanAppActionBar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppActionBar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = swanAppActionBar;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
                if (this.a.s != null) {
                    this.a.s.a(this.a);
                }
                return super.onDoubleTap(motionEvent);
            }
            return invokeL.booleanValue;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent)) == null) ? !this.a.t : invokeL.booleanValue;
        }

        public /* synthetic */ b(SwanAppActionBar swanAppActionBar, a aVar) {
            this(swanAppActionBar);
        }
    }

    /* loaded from: classes2.dex */
    public interface c {
        void a(View view2);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
        if (interceptable == null || interceptable.invokeZ(65541, this, z) == null) {
            setTitleColor(-16777216);
            setLeftBackViewSrc(R.drawable.obfuscated_res_0x7f080101);
            setLeftFloatBackViewSrc(R.drawable.obfuscated_res_0x7f080101);
            setLeftHomeViewSrc(R.drawable.obfuscated_res_0x7f080111);
            setRightMenuImageSrc(z ? R.drawable.obfuscated_res_0x7f080120 : R.drawable.obfuscated_res_0x7f080117);
            setRightExitImageSrc(R.drawable.obfuscated_res_0x7f08010b);
            setRightLineSrc(R.color.obfuscated_res_0x7f06037c);
            setRightZoneBgSrc(z ? R.color.obfuscated_res_0x7f0603e9 : R.drawable.obfuscated_res_0x7f08011e);
        }
    }

    private void setFrontColorWhite(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65542, this, z) == null) {
            setTitleColor(-1);
            setLeftBackViewSrc(R.drawable.obfuscated_res_0x7f080105);
            setLeftFloatBackViewSrc(R.drawable.obfuscated_res_0x7f080105);
            setLeftHomeViewSrc(R.drawable.obfuscated_res_0x7f080114);
            setRightMenuImageSrc(z ? R.drawable.obfuscated_res_0x7f080123 : R.drawable.obfuscated_res_0x7f08011d);
            setRightExitImageSrc(R.drawable.obfuscated_res_0x7f08010e);
            setRightLineSrc(R.color.obfuscated_res_0x7f06037d);
            setRightZoneBgSrc(z ? R.color.obfuscated_res_0x7f0603e9 : R.drawable.obfuscated_res_0x7f08011f);
        }
    }

    public final Drawable c(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            Drawable drawable = getResources().getDrawable(i);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            return drawable;
        }
        return (Drawable) invokeI.objValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d008d, this);
            this.a = findViewById(R.id.obfuscated_res_0x7f0920f9);
            TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f091254);
            this.b = textView;
            textView.setCompoundDrawables(c(R.drawable.obfuscated_res_0x7f080101), null, null, null);
            this.b.setTextColor(AppCompatResources.getColorStateList(getContext(), R.color.obfuscated_res_0x7f060a17));
            this.c = (TextView) findViewById(R.id.obfuscated_res_0x7f09125d);
            this.d = findViewById(R.id.obfuscated_res_0x7f0920f7);
            this.e = (ImageView) findViewById(R.id.obfuscated_res_0x7f091255);
            this.f = findViewById(R.id.obfuscated_res_0x7f0920f5);
            this.g = (ProgressBar) findViewById(R.id.obfuscated_res_0x7f09019d);
            this.h = (TextView) findViewById(R.id.obfuscated_res_0x7f0920ea);
            float f = this.k;
            if (f != -1.0f) {
                float f2 = this.l;
                if (f2 != -1.0f) {
                    float f3 = this.m;
                    if (f3 != -1.0f) {
                        this.b.setShadowLayer(f3, f, f2, this.j);
                    }
                }
            }
            this.n = findViewById(R.id.obfuscated_res_0x7f092101);
            this.o = (ImageView) findViewById(R.id.obfuscated_res_0x7f092103);
            this.p = (ImageView) findViewById(R.id.obfuscated_res_0x7f092105);
            this.q = findViewById(R.id.obfuscated_res_0x7f092104);
            this.r = (ImageView) findViewById(R.id.obfuscated_res_0x7f092102);
            setTitle(this.i);
            setTitleColor(-16777216);
            setRightMenuImageSrc(R.drawable.obfuscated_res_0x7f08011a);
            setOnTouchListener(new a(this, new GestureDetector(getContext(), new b(this, null))));
        }
    }

    public final void e(Context context, AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, attributeSet) == null) || attributeSet == null) {
            return;
        }
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, new int[]{R.attr.obfuscated_res_0x7f040693, R.attr.obfuscated_res_0x7f040697, R.attr.obfuscated_res_0x7f040698, R.attr.obfuscated_res_0x7f040699, R.attr.obfuscated_res_0x7f04069a}, 0, 0);
        try {
            this.i = obtainStyledAttributes.getString(0);
            this.j = obtainStyledAttributes.getColor(1, -16777216);
            this.k = obtainStyledAttributes.getFloat(2, -1.0f);
            this.l = obtainStyledAttributes.getFloat(3, -1.0f);
            this.m = obtainStyledAttributes.getFloat(4, -1.0f);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public boolean f(@ColorInt int i, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            if (i == -1) {
                setFrontColorWhite(z);
                return true;
            } else if (i == -16777216) {
                setFrontColorBlack(z);
                return true;
            } else {
                setFrontColorWhite(z);
                return false;
            }
        }
        return invokeCommon.booleanValue;
    }

    public void g(boolean z) {
        ProgressBar progressBar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048580, this, z) == null) || (progressBar = this.g) == null) {
            return;
        }
        if (z && progressBar.getVisibility() == 8) {
            this.g.setVisibility(0);
        } else if (z || this.g.getVisibility() != 0) {
        } else {
            this.g.setVisibility(8);
        }
    }

    public TextView getCenterTitleView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.h : (TextView) invokeV.objValue;
    }

    public View getRightMenu() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.n : (View) invokeV.objValue;
    }

    public void setActionBarCustom(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.t = z;
            int i = z ? 8 : 0;
            setLeftZoneVisibility(i);
            setCenterZoneVisibility(i);
            setLeftFloatZoneVisibility(z2 ? 0 : 8);
        }
    }

    public void setCenterZoneVisibility(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.f.setVisibility(i);
        }
    }

    public void setLeftBackViewClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, onClickListener) == null) {
            this.b.setOnClickListener(onClickListener);
        }
    }

    public void setLeftBackViewMinWidth(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            this.b.setMinimumWidth(i);
        }
    }

    public void setLeftBackViewSrc(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            Drawable drawable = i != 0 ? getResources().getDrawable(i) : null;
            if (drawable != null) {
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            }
            this.b.setCompoundDrawables(drawable, null, null, null);
            this.b.setSelected(false);
        }
    }

    public void setLeftBackViewVisibility(boolean z) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048588, this, z) == null) || (textView = this.b) == null) {
            return;
        }
        textView.setVisibility(z ? 0 : 8);
    }

    public void setLeftFloatBackViewClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, onClickListener) == null) {
            this.e.setOnClickListener(onClickListener);
        }
    }

    public void setLeftFloatBackViewSrc(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            this.e.setImageResource(i);
        }
    }

    public void setLeftFloatZoneVisibility(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            this.d.setVisibility(i);
        }
    }

    public void setLeftHomeViewClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, onClickListener) == null) {
            this.c.setOnClickListener(onClickListener);
        }
    }

    public void setLeftHomeViewSrc(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
            Drawable drawable = i != 0 ? getResources().getDrawable(i) : null;
            if (drawable != null) {
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            }
            this.c.setCompoundDrawables(drawable, null, null, null);
            this.c.setSelected(false);
        }
    }

    public void setLeftHomeViewVisibility(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
            this.c.setVisibility(i);
        }
    }

    public void setLeftZoneVisibility(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i) == null) {
            this.a.setVisibility(i);
        }
    }

    public void setOnDoubleClickListener(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, cVar) == null) {
            this.s = cVar;
        }
    }

    public void setRightExitImageSrc(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i) == null) {
            this.r.setImageDrawable(getResources().getDrawable(i));
        }
    }

    public void setRightExitOnClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, onClickListener) == null) {
            this.r.setOnClickListener(onClickListener);
        }
    }

    public void setRightExitViewVisibility(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            if (z) {
                this.r.setVisibility(0);
                this.q.setVisibility(0);
                return;
            }
            this.r.setVisibility(8);
            this.q.setVisibility(8);
            ((RelativeLayout.LayoutParams) this.n.getLayoutParams()).setMargins(0, 0, zd3.f(getContext(), 4.6f), 0);
        }
    }

    public void setRightFloatZoneVisibility(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i) == null) {
            this.n.setVisibility(i);
        }
    }

    public void setRightLineSrc(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i) == null) {
            this.q.setBackgroundResource(i);
        }
    }

    public void setRightMenuAlpha(float f) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048602, this, f) == null) || f < 0.0f || f > 1.0f) {
            return;
        }
        this.n.setAlpha(f);
    }

    public void setRightMenuEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048603, this, z) == null) {
            this.o.setEnabled(z);
            this.q.setEnabled(z);
            this.r.setEnabled(z);
        }
    }

    public void setRightMenuImageSrc(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i) == null) {
            this.o.setImageDrawable(getResources().getDrawable(i));
        }
    }

    public void setRightMenuOnClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, onClickListener) == null) {
            this.o.setOnClickListener(onClickListener);
        }
    }

    public void setRightMenuStyle() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            this.t = true;
            int i = 1 != 0 ? 8 : 0;
            setLeftZoneVisibility(i);
            setCenterZoneVisibility(i);
            setRightFloatZoneVisibility(0);
        }
    }

    public void setRightRedDotVisibility(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048607, this, z) == null) {
            this.p.setVisibility(z ? 0 : 8);
        }
    }

    public void setRightZoneBgSrc(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i) == null) {
            this.n.setBackgroundResource(i);
        }
    }

    public void setRightZoneImmersiveStyle() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            setRightMenuImageSrc(R.drawable.obfuscated_res_0x7f08011d);
            setRightExitImageSrc(R.drawable.obfuscated_res_0x7f08010e);
            setRightLineSrc(R.color.obfuscated_res_0x7f06037d);
            setRightZoneBgSrc(R.drawable.obfuscated_res_0x7f08011f);
        }
    }

    public void setRightZoneVisibility(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048610, this, z) == null) {
            this.n.setVisibility(z ? 0 : 8);
        }
    }

    public void setTitle(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, str) == null) {
            this.i = str;
            this.h.setText(str);
        }
    }

    public void setTitleColor(@ColorInt int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048613, this, i) == null) {
            this.h.setTextColor(i);
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
        e(context, attributeSet);
        d();
    }

    public void setTitle(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048611, this, i) == null) {
            setTitle(getResources().getString(i));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwanAppActionBar(Context context, AttributeSet attributeSet, int i) {
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
        e(context, attributeSet);
        d();
    }
}
