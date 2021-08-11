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
import c.a.o0.s.f0.n.b;
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
    public TBSpecificationButtonConfig f47712e;

    /* renamed from: f  reason: collision with root package name */
    public Drawable f47713f;

    /* renamed from: g  reason: collision with root package name */
    public Paint f47714g;

    /* renamed from: h  reason: collision with root package name */
    public String f47715h;

    /* renamed from: i  reason: collision with root package name */
    public Drawable f47716i;

    /* renamed from: j  reason: collision with root package name */
    public Drawable f47717j;
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
        public final /* synthetic */ TBSpecificationBtn f47718a;

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
            this.f47718a = tBSpecificationBtn;
        }

        @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig.a
        public void a() {
            int width;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (width = this.f47718a.getWidth()) <= 0 || this.f47718a.getLayoutParams().width != -2 || this.f47718a.getContentWidth() + this.f47718a.f47712e.f47728j + this.f47718a.f47712e.k == width) {
                return;
            }
            this.f47718a.requestLayout();
        }

        @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig.a
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f47718a.h();
                int width = this.f47718a.getWidth();
                if (width > 0 && this.f47718a.getLayoutParams().width == -2 && this.f47718a.getContentWidth() + this.f47718a.f47712e.f47728j + this.f47718a.f47712e.k != width) {
                    this.f47718a.requestLayout();
                } else {
                    this.f47718a.invalidate();
                }
            }
        }

        @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig.a
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                TBSpecificationBtn tBSpecificationBtn = this.f47718a;
                tBSpecificationBtn.g(tBSpecificationBtn.o);
                this.f47718a.invalidate();
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
        this.f47715h = "";
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
            TBSpecificationButtonConfig tBSpecificationButtonConfig = this.f47712e;
            int i2 = 0;
            if (tBSpecificationButtonConfig.f47723e[0] > 0) {
                i2 = tBSpecificationButtonConfig.f47725g;
                if (!StringUtils.isNull(this.f47715h)) {
                    i2 += this.f47712e.m;
                }
            }
            TBSpecificationButtonConfig tBSpecificationButtonConfig2 = this.f47712e;
            if (tBSpecificationButtonConfig2.f47723e[1] > 0) {
                i2 = tBSpecificationButtonConfig2.f47725g;
                if (!StringUtils.isNull(this.f47715h)) {
                    i2 += this.f47712e.m;
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
            this.f47712e = bVar;
            bVar.s = this.q;
            Paint paint = new Paint();
            this.f47714g = paint;
            paint.setTextSize(l.g(getContext(), R.dimen.T_X08));
            this.f47714g.setAntiAlias(true);
        }
    }

    public final void g(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048580, this, i2) == null) || getHeight() == 0) {
            return;
        }
        TBSpecificationButtonConfig tBSpecificationButtonConfig = this.f47712e;
        tBSpecificationButtonConfig.q = i2;
        this.f47713f = tBSpecificationButtonConfig.a(getHeight() / 2);
        Paint paint = this.f47714g;
        TBSpecificationButtonConfig tBSpecificationButtonConfig2 = this.f47712e;
        paint.setColor(tBSpecificationButtonConfig2.p ? SkinManager.getColor(i2, tBSpecificationButtonConfig2.f47720b) : tBSpecificationButtonConfig2.f47720b);
    }

    public TBSpecificationButtonConfig getStyleConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f47712e : (TBSpecificationButtonConfig) invokeV.objValue;
    }

    public String getText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f47715h : (String) invokeV.objValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f47716i = this.f47712e.c();
            this.f47717j = this.f47712e.d();
        }
    }

    public final int i(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
            float textSize = this.f47714g.getTextSize();
            if (View.MeasureSpec.getMode(i2) == 1073741824) {
                return View.MeasureSpec.getSize(i2);
            }
            return (int) Math.max(this.f47712e.o, textSize + (this.f47712e.l * 2) + getPaddingTop() + getPaddingBottom());
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
            TBSpecificationButtonConfig tBSpecificationButtonConfig = this.f47712e;
            return (int) Math.max(this.f47712e.n, contentWidth + tBSpecificationButtonConfig.f47728j + tBSpecificationButtonConfig.k + getPaddingLeft() + getPaddingRight());
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
            Drawable drawable = this.f47713f;
            if (drawable != null) {
                if (drawable instanceof GradientDrawable) {
                    ((GradientDrawable) drawable).setCornerRadius(getHeight() / 2);
                }
                this.f47713f.setBounds(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom());
                this.f47713f.draw(canvas);
            }
            int width = ((getWidth() - getContentWidth()) - getPaddingRight()) - getPaddingLeft();
            TBSpecificationButtonConfig tBSpecificationButtonConfig = this.f47712e;
            int i2 = tBSpecificationButtonConfig.f47728j;
            if (width != tBSpecificationButtonConfig.k + i2) {
                i2 = ((((getWidth() - getContentWidth()) - getPaddingRight()) - getPaddingLeft()) / 2) + getPaddingLeft();
            }
            int height = (getHeight() + getPaddingTop()) / 2;
            int i3 = this.f47712e.f47725g;
            int i4 = i3 / 2;
            Drawable drawable2 = this.f47716i;
            if (drawable2 != null) {
                drawable2.setBounds(i2, height - i4, i3 + i2, height + i4);
                this.f47716i.draw(canvas);
                TBSpecificationButtonConfig tBSpecificationButtonConfig2 = this.f47712e;
                i2 += tBSpecificationButtonConfig2.f47725g + tBSpecificationButtonConfig2.m;
            }
            if (this.n) {
                i2 = (getWidth() - this.k.width()) / 2;
            }
            if (!StringUtils.isNull(this.f47715h)) {
                Paint paint = this.f47714g;
                String str = this.f47715h;
                paint.getTextBounds(str, 0, str.length(), this.k);
                canvas.drawText(this.f47715h, i2, (((getHeight() - getPaddingBottom()) + getPaddingTop()) / 2.0f) - this.k.centerY(), this.f47714g);
            }
            Drawable drawable3 = this.f47717j;
            if (drawable3 != null) {
                int i5 = this.k.right;
                TBSpecificationButtonConfig tBSpecificationButtonConfig3 = this.f47712e;
                int i6 = tBSpecificationButtonConfig3.m;
                drawable3.setBounds(i2 + i5 + i6, height - i4, i2 + i5 + i6 + tBSpecificationButtonConfig3.f47725g, height + i4);
                this.f47717j.draw(canvas);
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048587, this, i2, i3) == null) {
            super.onMeasure(i2, i3);
            int j2 = j(i2);
            setMeasuredDimension(j2, !this.f47712e.f47727i ? i(i3) : j2);
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
        this.f47712e = tBSpecificationButtonConfig;
        tBSpecificationButtonConfig.s = this.q;
        this.l = true;
    }

    public void setText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            if (StringUtils.isNull(str)) {
                str = "";
            }
            this.f47715h = str;
            this.f47714g.getTextBounds(str, 0, str.length(), this.k);
            int width = getWidth();
            if (width > 0) {
                if (getLayoutParams().width == -2) {
                    int contentWidth = getContentWidth();
                    TBSpecificationButtonConfig tBSpecificationButtonConfig = this.f47712e;
                    if (contentWidth + tBSpecificationButtonConfig.f47728j + tBSpecificationButtonConfig.k != width) {
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
            this.f47714g.setTextSize(l.g(getContext(), i2));
            Paint paint = this.f47714g;
            String str = this.f47715h;
            paint.getTextBounds(str, 0, str.length(), this.k);
            int width = getWidth();
            if (width > 0 && getLayoutParams().width == -2) {
                int contentWidth = getContentWidth();
                TBSpecificationButtonConfig tBSpecificationButtonConfig = this.f47712e;
                if (contentWidth + tBSpecificationButtonConfig.f47728j + tBSpecificationButtonConfig.k != width) {
                    requestLayout();
                    return;
                }
            }
            int height = getHeight();
            if (height <= 0 || getLayoutParams().height != -2 || ((int) this.f47714g.getTextSize()) + (this.f47712e.l * 2) == height) {
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
            this.f47712e.q = i2;
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
        this.f47715h = "";
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
        this.f47715h = "";
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
