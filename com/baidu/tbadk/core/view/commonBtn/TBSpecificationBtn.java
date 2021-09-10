package com.baidu.tbadk.core.view.commonBtn;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.DimenRes;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.l;
import c.a.q0.s.f0.n.b;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class TBSpecificationBtn extends View {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Object btnState;

    /* renamed from: e  reason: collision with root package name */
    public TBSpecificationButtonConfig f47932e;

    /* renamed from: f  reason: collision with root package name */
    public Drawable f47933f;

    /* renamed from: g  reason: collision with root package name */
    public Paint f47934g;

    /* renamed from: h  reason: collision with root package name */
    public String f47935h;

    /* renamed from: i  reason: collision with root package name */
    public Drawable f47936i;

    /* renamed from: j  reason: collision with root package name */
    public Drawable f47937j;
    public Rect k;
    public boolean l;
    public boolean m;
    public boolean n;
    public int o;
    public boolean p;
    public TBSpecificationButtonConfig.a q;

    /* loaded from: classes6.dex */
    public class a implements TBSpecificationButtonConfig.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TBSpecificationBtn f47938a;

        public a(TBSpecificationBtn tBSpecificationBtn) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tBSpecificationBtn};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47938a = tBSpecificationBtn;
        }

        @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig.a
        public void a() {
            int width;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (width = this.f47938a.getWidth()) <= 0 || this.f47938a.getLayoutParams().width != -2 || this.f47938a.getContentWidth() + this.f47938a.f47932e.f47948j + this.f47938a.f47932e.k == width) {
                return;
            }
            this.f47938a.requestLayout();
        }

        @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig.a
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f47938a.h();
                int width = this.f47938a.getWidth();
                if (width > 0 && this.f47938a.getLayoutParams().width == -2 && this.f47938a.getContentWidth() + this.f47938a.f47932e.f47948j + this.f47938a.f47932e.k != width) {
                    this.f47938a.requestLayout();
                } else {
                    this.f47938a.invalidate();
                }
            }
        }

        @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig.a
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                TBSpecificationBtn tBSpecificationBtn = this.f47938a;
                tBSpecificationBtn.g(tBSpecificationBtn.o);
                this.f47938a.invalidate();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TBSpecificationBtn(Context context) {
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
        this.btnState = null;
        this.f47935h = "";
        this.k = new Rect();
        this.l = true;
        this.m = true;
        this.n = false;
        this.o = 0;
        this.p = false;
        this.q = new a(this);
        f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getContentWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) {
            TBSpecificationButtonConfig tBSpecificationButtonConfig = this.f47932e;
            int i2 = 0;
            if (tBSpecificationButtonConfig.f47943e[0] > 0) {
                i2 = tBSpecificationButtonConfig.f47945g;
                if (!StringUtils.isNull(this.f47935h)) {
                    i2 += this.f47932e.m;
                }
            }
            TBSpecificationButtonConfig tBSpecificationButtonConfig2 = this.f47932e;
            if (tBSpecificationButtonConfig2.f47943e[1] > 0) {
                i2 = tBSpecificationButtonConfig2.f47945g;
                if (!StringUtils.isNull(this.f47935h)) {
                    i2 += this.f47932e.m;
                }
            }
            return i2 + this.k.width();
        }
        return invokeV.intValue;
    }

    public void changeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            changeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View
    public void drawableStateChanged() {
        int[] drawableState;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            boolean z = true;
            boolean z2 = false;
            for (int i2 : getDrawableState()) {
                if (i2 == 16842910) {
                    z = false;
                } else if (i2 == 16842919) {
                    z2 = true;
                }
            }
            if (this.m) {
                if (z) {
                    setAlpha(SkinManager.RESOURCE_ALPHA_DISABLE);
                } else if (z2 && isClickable()) {
                    setAlpha(SkinManager.RESOURCE_ALPHA_PRESS);
                } else {
                    setAlpha(1.0f);
                }
            } else if (this.p) {
                setAlpha(SkinManager.RESOURCE_ALPHA_DISABLE);
            } else {
                setAlpha(1.0f);
            }
            super.drawableStateChanged();
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.o = TbadkCoreApplication.getInst().getSkinType();
            b bVar = new b();
            this.f47932e = bVar;
            bVar.s = this.q;
            Paint paint = new Paint();
            this.f47934g = paint;
            paint.setTextSize(l.g(getContext(), R.dimen.T_X08));
            this.f47934g.setAntiAlias(true);
        }
    }

    public final void g(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048580, this, i2) == null) || getHeight() == 0) {
            return;
        }
        TBSpecificationButtonConfig tBSpecificationButtonConfig = this.f47932e;
        tBSpecificationButtonConfig.q = i2;
        this.f47933f = tBSpecificationButtonConfig.a(getHeight() / 2);
        Paint paint = this.f47934g;
        TBSpecificationButtonConfig tBSpecificationButtonConfig2 = this.f47932e;
        paint.setColor(tBSpecificationButtonConfig2.p ? SkinManager.getColor(i2, tBSpecificationButtonConfig2.f47940b) : tBSpecificationButtonConfig2.f47940b);
    }

    public TBSpecificationButtonConfig getStyleConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f47932e : (TBSpecificationButtonConfig) invokeV.objValue;
    }

    public String getText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f47935h : (String) invokeV.objValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f47936i = this.f47932e.c();
            this.f47937j = this.f47932e.d();
        }
    }

    public final int i(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
            float textSize = this.f47934g.getTextSize();
            if (View.MeasureSpec.getMode(i2) == 1073741824) {
                return View.MeasureSpec.getSize(i2);
            }
            return (int) Math.max(this.f47932e.o, textSize + (this.f47932e.l * 2) + getPaddingTop() + getPaddingBottom());
        }
        return invokeI.intValue;
    }

    public final int j(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) {
            float contentWidth = getContentWidth();
            if (View.MeasureSpec.getMode(i2) == 1073741824) {
                return View.MeasureSpec.getSize(i2);
            }
            TBSpecificationButtonConfig tBSpecificationButtonConfig = this.f47932e;
            return (int) Math.max(this.f47932e.n, contentWidth + tBSpecificationButtonConfig.f47948j + tBSpecificationButtonConfig.k + getPaddingLeft() + getPaddingRight());
        }
        return invokeI.intValue;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, canvas) == null) {
            if (this.l) {
                g(this.o);
                h();
                this.l = false;
            }
            Drawable drawable = this.f47933f;
            if (drawable != null) {
                if (drawable instanceof GradientDrawable) {
                    ((GradientDrawable) drawable).setCornerRadius(getHeight() / 2);
                }
                this.f47933f.setBounds(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom());
                this.f47933f.draw(canvas);
            }
            int width = ((getWidth() - getContentWidth()) - getPaddingRight()) - getPaddingLeft();
            TBSpecificationButtonConfig tBSpecificationButtonConfig = this.f47932e;
            int i2 = tBSpecificationButtonConfig.f47948j;
            if (width != tBSpecificationButtonConfig.k + i2) {
                i2 = ((((getWidth() - getContentWidth()) - getPaddingRight()) - getPaddingLeft()) / 2) + getPaddingLeft();
            }
            int height = (getHeight() + getPaddingTop()) / 2;
            int i3 = this.f47932e.f47945g;
            int i4 = i3 / 2;
            Drawable drawable2 = this.f47936i;
            if (drawable2 != null) {
                drawable2.setBounds(i2, height - i4, i3 + i2, height + i4);
                this.f47936i.draw(canvas);
                TBSpecificationButtonConfig tBSpecificationButtonConfig2 = this.f47932e;
                i2 += tBSpecificationButtonConfig2.f47945g + tBSpecificationButtonConfig2.m;
            }
            if (this.n) {
                i2 = (getWidth() - this.k.width()) / 2;
            }
            if (!StringUtils.isNull(this.f47935h)) {
                Paint paint = this.f47934g;
                String str = this.f47935h;
                paint.getTextBounds(str, 0, str.length(), this.k);
                canvas.drawText(this.f47935h, i2, (((getHeight() - getPaddingBottom()) + getPaddingTop()) / 2.0f) - this.k.centerY(), this.f47934g);
            }
            Drawable drawable3 = this.f47937j;
            if (drawable3 != null) {
                int i5 = this.k.right;
                TBSpecificationButtonConfig tBSpecificationButtonConfig3 = this.f47932e;
                int i6 = tBSpecificationButtonConfig3.m;
                drawable3.setBounds(i2 + i5 + i6, height - i4, i2 + i5 + i6 + tBSpecificationButtonConfig3.f47945g, height + i4);
                this.f47937j.draw(canvas);
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048587, this, i2, i3) == null) {
            super.onMeasure(i2, i3);
            int j2 = j(i2);
            setMeasuredDimension(j2, !this.f47932e.f47947i ? i(i3) : j2);
        }
    }

    public void setClickState(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.m = z;
        }
    }

    public void setConfig(TBSpecificationButtonConfig tBSpecificationButtonConfig) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, tBSpecificationButtonConfig) == null) || tBSpecificationButtonConfig == null) {
            return;
        }
        this.f47932e = tBSpecificationButtonConfig;
        tBSpecificationButtonConfig.s = this.q;
        this.l = true;
    }

    public void setText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            if (StringUtils.isNull(str)) {
                str = "";
            }
            this.f47935h = str;
            this.f47934g.getTextBounds(str, 0, str.length(), this.k);
            int width = getWidth();
            if (width > 0) {
                if (getLayoutParams().width == -2) {
                    int contentWidth = getContentWidth();
                    TBSpecificationButtonConfig tBSpecificationButtonConfig = this.f47932e;
                    if (contentWidth + tBSpecificationButtonConfig.f47948j + tBSpecificationButtonConfig.k != width) {
                        requestLayout();
                        return;
                    } else {
                        invalidate();
                        return;
                    }
                }
                invalidate();
            }
        }
    }

    public void setTextHorizontalCenter(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.n = z;
        }
    }

    public void setTextSize(@DimenRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            this.f47934g.setTextSize(l.g(getContext(), i2));
            Paint paint = this.f47934g;
            String str = this.f47935h;
            paint.getTextBounds(str, 0, str.length(), this.k);
            int width = getWidth();
            if (width > 0 && getLayoutParams().width == -2) {
                int contentWidth = getContentWidth();
                TBSpecificationButtonConfig tBSpecificationButtonConfig = this.f47932e;
                if (contentWidth + tBSpecificationButtonConfig.f47948j + tBSpecificationButtonConfig.k != width) {
                    requestLayout();
                    return;
                }
            }
            int height = getHeight();
            if (height <= 0 || getLayoutParams().height != -2 || ((int) this.f47934g.getTextSize()) + (this.f47932e.l * 2) == height) {
                return;
            }
            requestLayout();
        }
    }

    public void setUseDisableState(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.m = false;
            this.p = z;
        }
    }

    public void changeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.o = i2;
            this.f47932e.q = i2;
            h();
            g(i2);
            invalidate();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TBSpecificationBtn(Context context, @Nullable AttributeSet attributeSet) {
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
        this.btnState = null;
        this.f47935h = "";
        this.k = new Rect();
        this.l = true;
        this.m = true;
        this.n = false;
        this.o = 0;
        this.p = false;
        this.q = new a(this);
        f();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TBSpecificationBtn(Context context, @Nullable AttributeSet attributeSet, int i2) {
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
        this.btnState = null;
        this.f47935h = "";
        this.k = new Rect();
        this.l = true;
        this.m = true;
        this.n = false;
        this.o = 0;
        this.p = false;
        this.q = new a(this);
        f();
    }
}
