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
import c.a.d.f.p.n;
import c.a.o0.r.l0.n.b;
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
/* loaded from: classes5.dex */
public class TBSpecificationBtn extends View {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Object a;

    /* renamed from: b  reason: collision with root package name */
    public TBSpecificationButtonConfig f30234b;

    /* renamed from: c  reason: collision with root package name */
    public Drawable f30235c;

    /* renamed from: d  reason: collision with root package name */
    public Paint f30236d;

    /* renamed from: e  reason: collision with root package name */
    public String f30237e;

    /* renamed from: f  reason: collision with root package name */
    public Drawable f30238f;

    /* renamed from: g  reason: collision with root package name */
    public Drawable f30239g;

    /* renamed from: h  reason: collision with root package name */
    public Rect f30240h;
    public boolean i;
    public boolean j;
    public boolean k;
    public int l;
    public boolean m;
    public TBSpecificationButtonConfig.a n;

    /* loaded from: classes5.dex */
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
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (width = this.a.getWidth()) <= 0 || this.a.getLayoutParams().width != -2 || this.a.getContentWidth() + this.a.f30234b.j + this.a.f30234b.k == width) {
                return;
            }
            this.a.requestLayout();
        }

        @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig.a
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.o();
                int width = this.a.getWidth();
                if (width > 0 && this.a.getLayoutParams().width == -2 && this.a.getContentWidth() + this.a.f30234b.j + this.a.f30234b.k != width) {
                    this.a.requestLayout();
                } else {
                    this.a.invalidate();
                }
            }
        }

        @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig.a
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                TBSpecificationBtn tBSpecificationBtn = this.a;
                tBSpecificationBtn.n(tBSpecificationBtn.l);
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
        this.f30237e = "";
        this.f30240h = new Rect();
        this.i = true;
        this.j = true;
        this.k = false;
        this.l = 0;
        this.m = false;
        this.n = new a(this);
        m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getContentWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) {
            TBSpecificationButtonConfig tBSpecificationButtonConfig = this.f30234b;
            int i = 0;
            if (tBSpecificationButtonConfig.f30244e[0] > 0) {
                i = tBSpecificationButtonConfig.f30246g;
                if (!StringUtils.isNull(this.f30237e)) {
                    i += this.f30234b.m;
                }
            }
            TBSpecificationButtonConfig tBSpecificationButtonConfig2 = this.f30234b;
            if (tBSpecificationButtonConfig2.f30244e[1] > 0) {
                i = tBSpecificationButtonConfig2.f30246g;
                if (!StringUtils.isNull(this.f30237e)) {
                    i += this.f30234b.m;
                }
            }
            return i + this.f30240h.width();
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
            if (this.j) {
                if (z) {
                    setAlpha(SkinManager.RESOURCE_ALPHA_DISABLE);
                } else if (z2 && isClickable()) {
                    setAlpha(SkinManager.RESOURCE_ALPHA_PRESS);
                } else {
                    setAlpha(1.0f);
                }
            } else if (this.m) {
                setAlpha(SkinManager.RESOURCE_ALPHA_DISABLE);
            } else {
                setAlpha(1.0f);
            }
            super.drawableStateChanged();
        }
    }

    public TBSpecificationButtonConfig getStyleConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f30234b : (TBSpecificationButtonConfig) invokeV.objValue;
    }

    public String getText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f30237e : (String) invokeV.objValue;
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            l(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void l(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.l = i;
            this.f30234b.r = i;
            o();
            n(i);
            invalidate();
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.l = TbadkCoreApplication.getInst().getSkinType();
            b bVar = new b();
            this.f30234b = bVar;
            bVar.t = this.n;
            Paint paint = new Paint();
            this.f30236d = paint;
            paint.setTextSize(n.f(getContext(), R.dimen.T_X08));
            this.f30236d.setAntiAlias(true);
        }
    }

    public final void n(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048582, this, i) == null) || getHeight() == 0) {
            return;
        }
        TBSpecificationButtonConfig tBSpecificationButtonConfig = this.f30234b;
        tBSpecificationButtonConfig.r = i;
        this.f30235c = tBSpecificationButtonConfig.a(getHeight() / 2);
        Paint paint = this.f30236d;
        TBSpecificationButtonConfig tBSpecificationButtonConfig2 = this.f30234b;
        paint.setColor(tBSpecificationButtonConfig2.q ? SkinManager.getColor(i, tBSpecificationButtonConfig2.f30241b) : tBSpecificationButtonConfig2.f30241b);
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f30238f = this.f30234b.c();
            this.f30239g = this.f30234b.d();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, canvas) == null) {
            if (this.i) {
                n(this.l);
                o();
                this.i = false;
            }
            Drawable drawable = this.f30235c;
            if (drawable != null) {
                if (drawable instanceof GradientDrawable) {
                    ((GradientDrawable) drawable).setCornerRadius(getHeight() / 2);
                }
                this.f30235c.setBounds(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom());
                this.f30235c.draw(canvas);
            }
            int width = ((getWidth() - getContentWidth()) - getPaddingRight()) - getPaddingLeft();
            TBSpecificationButtonConfig tBSpecificationButtonConfig = this.f30234b;
            int i = tBSpecificationButtonConfig.j;
            if (width != tBSpecificationButtonConfig.k + i) {
                i = ((((getWidth() - getContentWidth()) - getPaddingRight()) - getPaddingLeft()) / 2) + getPaddingLeft();
            }
            int height = (getHeight() + getPaddingTop()) / 2;
            int i2 = this.f30234b.f30246g;
            int i3 = i2 / 2;
            Drawable drawable2 = this.f30238f;
            if (drawable2 != null) {
                drawable2.setBounds(i, height - i3, i2 + i, height + i3);
                this.f30238f.draw(canvas);
                TBSpecificationButtonConfig tBSpecificationButtonConfig2 = this.f30234b;
                i += tBSpecificationButtonConfig2.f30246g + tBSpecificationButtonConfig2.m;
            }
            if (this.k) {
                i = (getWidth() - this.f30240h.width()) / 2;
            }
            if (!StringUtils.isNull(this.f30237e)) {
                Paint paint = this.f30236d;
                String str = this.f30237e;
                paint.getTextBounds(str, 0, str.length(), this.f30240h);
                canvas.drawText(this.f30237e, i, (((getHeight() - getPaddingBottom()) + getPaddingTop()) / 2.0f) - this.f30240h.centerY(), this.f30236d);
            }
            Drawable drawable3 = this.f30239g;
            if (drawable3 != null) {
                int i4 = this.f30240h.right;
                TBSpecificationButtonConfig tBSpecificationButtonConfig3 = this.f30234b;
                int i5 = tBSpecificationButtonConfig3.m;
                drawable3.setBounds(i + i4 + i5, height - i3, i + i4 + i5 + tBSpecificationButtonConfig3.f30246g, height + i3);
                this.f30239g.draw(canvas);
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048585, this, i, i2) == null) {
            super.onMeasure(i, i2);
            int q = q(i);
            setMeasuredDimension(q, !this.f30234b.i ? p(i2) : q);
        }
    }

    public final int p(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) {
            float textSize = this.f30236d.getTextSize();
            if (View.MeasureSpec.getMode(i) == 1073741824) {
                return View.MeasureSpec.getSize(i);
            }
            return (int) Math.max(this.f30234b.o, textSize + (this.f30234b.l * 2) + getPaddingTop() + getPaddingBottom());
        }
        return invokeI.intValue;
    }

    public final int q(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i)) == null) {
            float contentWidth = getContentWidth();
            if (View.MeasureSpec.getMode(i) == 1073741824) {
                return View.MeasureSpec.getSize(i);
            }
            TBSpecificationButtonConfig tBSpecificationButtonConfig = this.f30234b;
            return (int) Math.max(this.f30234b.n, contentWidth + tBSpecificationButtonConfig.j + tBSpecificationButtonConfig.k + getPaddingLeft() + getPaddingRight());
        }
        return invokeI.intValue;
    }

    public void setClickState(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.j = z;
        }
    }

    public void setConfig(TBSpecificationButtonConfig tBSpecificationButtonConfig) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, tBSpecificationButtonConfig) == null) || tBSpecificationButtonConfig == null) {
            return;
        }
        this.f30234b = tBSpecificationButtonConfig;
        tBSpecificationButtonConfig.t = this.n;
        this.i = true;
    }

    public void setText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            if (StringUtils.isNull(str)) {
                str = "";
            }
            this.f30237e = str;
            if (this.f30234b.p) {
                this.f30236d.setFakeBoldText(true);
            }
            this.f30236d.getTextBounds(str, 0, str.length(), this.f30240h);
            int width = getWidth();
            if (width > 0) {
                if (getLayoutParams().width == -2) {
                    int contentWidth = getContentWidth();
                    TBSpecificationButtonConfig tBSpecificationButtonConfig = this.f30234b;
                    if (contentWidth + tBSpecificationButtonConfig.j + tBSpecificationButtonConfig.k != width) {
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
            this.k = z;
        }
    }

    public void setTextSize(@DimenRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            this.f30236d.setTextSize(n.f(getContext(), i));
            Paint paint = this.f30236d;
            String str = this.f30237e;
            paint.getTextBounds(str, 0, str.length(), this.f30240h);
            int width = getWidth();
            if (width > 0 && getLayoutParams().width == -2) {
                int contentWidth = getContentWidth();
                TBSpecificationButtonConfig tBSpecificationButtonConfig = this.f30234b;
                if (contentWidth + tBSpecificationButtonConfig.j + tBSpecificationButtonConfig.k != width) {
                    requestLayout();
                    return;
                }
            }
            int height = getHeight();
            if (height <= 0 || getLayoutParams().height != -2 || ((int) this.f30236d.getTextSize()) + (this.f30234b.l * 2) == height) {
                return;
            }
            requestLayout();
        }
    }

    public void setUseDisableState(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.j = false;
            this.m = z;
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
        this.f30237e = "";
        this.f30240h = new Rect();
        this.i = true;
        this.j = true;
        this.k = false;
        this.l = 0;
        this.m = false;
        this.n = new a(this);
        m();
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
        this.f30237e = "";
        this.f30240h = new Rect();
        this.i = true;
        this.j = true;
        this.k = false;
        this.l = 0;
        this.m = false;
        this.n = new a(this);
        m();
    }
}
