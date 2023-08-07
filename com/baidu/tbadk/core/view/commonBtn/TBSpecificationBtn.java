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
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig;
import com.baidu.tieba.R;
import com.baidu.tieba.x95;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class TBSpecificationBtn extends View {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Object a;
    public TBSpecificationButtonConfig b;
    public Drawable c;
    public Paint d;
    public String e;
    public Drawable f;
    public Drawable g;
    public Rect h;
    public boolean i;
    public boolean j;
    public boolean k;
    public int l;
    public boolean m;
    public TBSpecificationButtonConfig.a n;

    /* loaded from: classes4.dex */
    public class a implements TBSpecificationButtonConfig.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TBSpecificationBtn a;

        public a(TBSpecificationBtn tBSpecificationBtn) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tBSpecificationBtn};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tBSpecificationBtn;
        }

        @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig.a
        public void a() {
            int width;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (width = this.a.getWidth()) > 0 && this.a.getLayoutParams().width == -2 && this.a.getContentWidth() + this.a.b.k + this.a.b.l != width) {
                this.a.requestLayout();
            }
        }

        @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig.a
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) {
                return;
            }
            this.a.n();
            int width = this.a.getWidth();
            if (width > 0 && this.a.getLayoutParams().width == -2 && this.a.getContentWidth() + this.a.b.k + this.a.b.l != width) {
                this.a.requestLayout();
            } else {
                this.a.invalidate();
            }
        }

        @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig.a
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                TBSpecificationBtn tBSpecificationBtn = this.a;
                tBSpecificationBtn.m(tBSpecificationBtn.l);
                this.a.invalidate();
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.e = "";
        this.h = new Rect();
        this.i = true;
        this.j = true;
        this.k = false;
        this.l = 0;
        this.m = false;
        this.n = new a(this);
        init();
    }

    public void setText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            if (StringUtils.isNull(str)) {
                str = "";
            }
            this.e = str;
            if (this.b.q) {
                this.d.setFakeBoldText(true);
            }
            this.d.getTextBounds(str, 0, str.length(), this.h);
            int width = getWidth();
            if (width > 0) {
                if (getLayoutParams().width == -2) {
                    int contentWidth = getContentWidth();
                    TBSpecificationButtonConfig tBSpecificationButtonConfig = this.b;
                    if (contentWidth + tBSpecificationButtonConfig.k + tBSpecificationButtonConfig.l != width) {
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TBSpecificationBtn(Context context, @Nullable AttributeSet attributeSet) {
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
        this.a = null;
        this.e = "";
        this.h = new Rect();
        this.i = true;
        this.j = true;
        this.k = false;
        this.l = 0;
        this.m = false;
        this.n = new a(this);
        init();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TBSpecificationBtn(Context context, @Nullable AttributeSet attributeSet, int i) {
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
        this.a = null;
        this.e = "";
        this.h = new Rect();
        this.i = true;
        this.j = true;
        this.k = false;
        this.l = 0;
        this.m = false;
        this.n = new a(this);
        init();
    }

    public void l(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.l = i;
            this.b.s = i;
            n();
            m(i);
            invalidate();
        }
    }

    public void setClickState(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.j = z;
        }
    }

    public void setConfig(TBSpecificationButtonConfig tBSpecificationButtonConfig) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048588, this, tBSpecificationButtonConfig) != null) || tBSpecificationButtonConfig == null) {
            return;
        }
        this.b = tBSpecificationButtonConfig;
        tBSpecificationButtonConfig.u = this.n;
        this.i = true;
    }

    public void setTextHorizontalCenter(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.k = z;
        }
    }

    public void setUseDisableState(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            this.j = false;
            this.m = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getContentWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) {
            TBSpecificationButtonConfig tBSpecificationButtonConfig = this.b;
            int i = 0;
            if (tBSpecificationButtonConfig.e[0] > 0) {
                i = tBSpecificationButtonConfig.g;
                if (!StringUtils.isNull(this.e)) {
                    i += this.b.n;
                }
            }
            TBSpecificationButtonConfig tBSpecificationButtonConfig2 = this.b;
            if (tBSpecificationButtonConfig2.e[1] > 0) {
                i = tBSpecificationButtonConfig2.g;
                if (!StringUtils.isNull(this.e)) {
                    i += this.b.n;
                }
            }
            return i + this.h.width();
        }
        return invokeV.intValue;
    }

    @Override // android.view.View
    public void drawableStateChanged() {
        int[] drawableState;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            boolean z = true;
            boolean z2 = false;
            for (int i : getDrawableState()) {
                if (i == 16842910) {
                    z = false;
                } else if (i == 16842919) {
                    z2 = true;
                }
            }
            if (!this.j) {
                if (this.m) {
                    setAlpha(SkinManager.RESOURCE_ALPHA_DISABLE);
                } else {
                    setAlpha(1.0f);
                }
            } else if (z) {
                setAlpha(SkinManager.RESOURCE_ALPHA_DISABLE);
            } else if (z2 && isClickable()) {
                setAlpha(SkinManager.RESOURCE_ALPHA_PRESS);
            } else {
                setAlpha(1.0f);
            }
            super.drawableStateChanged();
        }
    }

    private void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            this.l = TbadkCoreApplication.getInst().getSkinType();
            x95 x95Var = new x95();
            this.b = x95Var;
            x95Var.u = this.n;
            Paint paint = new Paint();
            this.d = paint;
            paint.setTextSize(BdUtilHelper.getDimens(getContext(), R.dimen.T_X08));
            this.d.setAntiAlias(true);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048585, this, i, i2) == null) {
            super.onMeasure(i, i2);
            int p = p(i);
            if (!this.b.j) {
                i3 = o(i2);
            } else {
                i3 = p;
            }
            setMeasuredDimension(p, i3);
        }
    }

    public TBSpecificationButtonConfig getStyleConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.b;
        }
        return (TBSpecificationButtonConfig) invokeV.objValue;
    }

    public String getText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.e;
        }
        return (String) invokeV.objValue;
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            l(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f = this.b.c();
            this.g = this.b.d();
        }
    }

    public final void m(int i) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048581, this, i) != null) || getHeight() == 0) {
            return;
        }
        TBSpecificationButtonConfig tBSpecificationButtonConfig = this.b;
        tBSpecificationButtonConfig.s = i;
        this.c = tBSpecificationButtonConfig.a(getHeight() / 2);
        Paint paint = this.d;
        TBSpecificationButtonConfig tBSpecificationButtonConfig2 = this.b;
        if (tBSpecificationButtonConfig2.r) {
            i2 = SkinManager.getColor(i, tBSpecificationButtonConfig2.b);
        } else {
            i2 = tBSpecificationButtonConfig2.b;
        }
        paint.setColor(i2);
    }

    public final int o(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
            float textSize = this.d.getTextSize();
            if (View.MeasureSpec.getMode(i) == 1073741824) {
                return View.MeasureSpec.getSize(i);
            }
            return (int) Math.max(this.b.p, textSize + (this.b.m * 2) + getPaddingTop() + getPaddingBottom());
        }
        return invokeI.intValue;
    }

    public final int p(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) {
            float contentWidth = getContentWidth();
            if (View.MeasureSpec.getMode(i) == 1073741824) {
                return View.MeasureSpec.getSize(i);
            }
            TBSpecificationButtonConfig tBSpecificationButtonConfig = this.b;
            return (int) Math.max(this.b.o, contentWidth + tBSpecificationButtonConfig.k + tBSpecificationButtonConfig.l + getPaddingLeft() + getPaddingRight());
        }
        return invokeI.intValue;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, canvas) == null) {
            if (this.i) {
                m(this.l);
                n();
                this.i = false;
            }
            Drawable drawable = this.c;
            if (drawable != null) {
                if (drawable instanceof GradientDrawable) {
                    ((GradientDrawable) drawable).setCornerRadius(getHeight() / 2);
                }
                this.c.setBounds(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom());
                this.c.draw(canvas);
            }
            int width = ((getWidth() - getContentWidth()) - getPaddingRight()) - getPaddingLeft();
            TBSpecificationButtonConfig tBSpecificationButtonConfig = this.b;
            int i = tBSpecificationButtonConfig.k;
            if (width != tBSpecificationButtonConfig.l + i) {
                i = ((((getWidth() - getContentWidth()) - getPaddingRight()) - getPaddingLeft()) / 2) + getPaddingLeft();
            }
            int height = (getHeight() + getPaddingTop()) / 2;
            TBSpecificationButtonConfig tBSpecificationButtonConfig2 = this.b;
            int i2 = tBSpecificationButtonConfig2.g;
            int i3 = i2 / 2;
            int i4 = tBSpecificationButtonConfig2.h;
            Drawable drawable2 = this.f;
            if (drawable2 != null) {
                drawable2.setBounds(i, (height - i3) + i4, i2 + i, height + i3 + i4);
                this.f.draw(canvas);
                TBSpecificationButtonConfig tBSpecificationButtonConfig3 = this.b;
                i += tBSpecificationButtonConfig3.g + tBSpecificationButtonConfig3.n;
            }
            if (this.k) {
                i = (getWidth() - this.h.width()) / 2;
            }
            if (!StringUtils.isNull(this.e)) {
                Paint paint = this.d;
                String str = this.e;
                paint.getTextBounds(str, 0, str.length(), this.h);
                canvas.drawText(this.e, i, (((getHeight() - getPaddingBottom()) + getPaddingTop()) / 2.0f) - this.h.centerY(), this.d);
            }
            Drawable drawable3 = this.g;
            if (drawable3 != null) {
                int i5 = this.h.right;
                TBSpecificationButtonConfig tBSpecificationButtonConfig4 = this.b;
                int i6 = tBSpecificationButtonConfig4.n;
                drawable3.setBounds(i + i5 + i6, (height - i3) + i4, i + i5 + i6 + tBSpecificationButtonConfig4.g, height + i3 + i4);
                this.g.draw(canvas);
            }
        }
    }

    public void setTextSize(@DimenRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            this.d.setTextSize(BdUtilHelper.getDimens(getContext(), i));
            Paint paint = this.d;
            String str = this.e;
            paint.getTextBounds(str, 0, str.length(), this.h);
            int width = getWidth();
            if (width > 0 && getLayoutParams().width == -2) {
                int contentWidth = getContentWidth();
                TBSpecificationButtonConfig tBSpecificationButtonConfig = this.b;
                if (contentWidth + tBSpecificationButtonConfig.k + tBSpecificationButtonConfig.l != width) {
                    requestLayout();
                    return;
                }
            }
            int height = getHeight();
            if (height > 0 && getLayoutParams().height == -2 && ((int) this.d.getTextSize()) + (this.b.m * 2) != height) {
                requestLayout();
            }
        }
    }
}
