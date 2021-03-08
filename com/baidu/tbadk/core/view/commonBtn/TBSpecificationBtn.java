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
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class TBSpecificationBtn extends View {
    private int aln;
    private Drawable eXT;
    public Object foo;
    private TBSpecificationButtonConfig fop;
    private Drawable foq;

    /* renamed from: for  reason: not valid java name */
    private Drawable f3for;
    private Rect fot;
    private boolean fou;
    private boolean fov;
    private boolean fow;
    private boolean fox;
    private TBSpecificationButtonConfig.a foy;
    private String text;
    private Paint textPaint;

    public TBSpecificationBtn(Context context) {
        super(context);
        this.foo = null;
        this.text = "";
        this.fot = new Rect();
        this.fou = true;
        this.fov = true;
        this.fow = false;
        this.aln = 0;
        this.fox = false;
        this.foy = new TBSpecificationButtonConfig.a() { // from class: com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn.1
            @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig.a
            public void buV() {
                int width = TBSpecificationBtn.this.getWidth();
                if (width > 0 && TBSpecificationBtn.this.getLayoutParams().width == -2 && TBSpecificationBtn.this.getContentWidth() + TBSpecificationBtn.this.fop.foI + TBSpecificationBtn.this.fop.foJ != width) {
                    TBSpecificationBtn.this.requestLayout();
                }
            }

            @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig.a
            public void buW() {
                TBSpecificationBtn.this.buU();
                int width = TBSpecificationBtn.this.getWidth();
                if (width > 0 && TBSpecificationBtn.this.getLayoutParams().width == -2 && TBSpecificationBtn.this.getContentWidth() + TBSpecificationBtn.this.fop.foI + TBSpecificationBtn.this.fop.foJ != width) {
                    TBSpecificationBtn.this.requestLayout();
                } else {
                    TBSpecificationBtn.this.invalidate();
                }
            }

            @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig.a
            public void buX() {
                TBSpecificationBtn.this.pM(TBSpecificationBtn.this.aln);
                TBSpecificationBtn.this.invalidate();
            }
        };
        init();
    }

    public TBSpecificationBtn(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.foo = null;
        this.text = "";
        this.fot = new Rect();
        this.fou = true;
        this.fov = true;
        this.fow = false;
        this.aln = 0;
        this.fox = false;
        this.foy = new TBSpecificationButtonConfig.a() { // from class: com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn.1
            @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig.a
            public void buV() {
                int width = TBSpecificationBtn.this.getWidth();
                if (width > 0 && TBSpecificationBtn.this.getLayoutParams().width == -2 && TBSpecificationBtn.this.getContentWidth() + TBSpecificationBtn.this.fop.foI + TBSpecificationBtn.this.fop.foJ != width) {
                    TBSpecificationBtn.this.requestLayout();
                }
            }

            @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig.a
            public void buW() {
                TBSpecificationBtn.this.buU();
                int width = TBSpecificationBtn.this.getWidth();
                if (width > 0 && TBSpecificationBtn.this.getLayoutParams().width == -2 && TBSpecificationBtn.this.getContentWidth() + TBSpecificationBtn.this.fop.foI + TBSpecificationBtn.this.fop.foJ != width) {
                    TBSpecificationBtn.this.requestLayout();
                } else {
                    TBSpecificationBtn.this.invalidate();
                }
            }

            @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig.a
            public void buX() {
                TBSpecificationBtn.this.pM(TBSpecificationBtn.this.aln);
                TBSpecificationBtn.this.invalidate();
            }
        };
        init();
    }

    public TBSpecificationBtn(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.foo = null;
        this.text = "";
        this.fot = new Rect();
        this.fou = true;
        this.fov = true;
        this.fow = false;
        this.aln = 0;
        this.fox = false;
        this.foy = new TBSpecificationButtonConfig.a() { // from class: com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn.1
            @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig.a
            public void buV() {
                int width = TBSpecificationBtn.this.getWidth();
                if (width > 0 && TBSpecificationBtn.this.getLayoutParams().width == -2 && TBSpecificationBtn.this.getContentWidth() + TBSpecificationBtn.this.fop.foI + TBSpecificationBtn.this.fop.foJ != width) {
                    TBSpecificationBtn.this.requestLayout();
                }
            }

            @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig.a
            public void buW() {
                TBSpecificationBtn.this.buU();
                int width = TBSpecificationBtn.this.getWidth();
                if (width > 0 && TBSpecificationBtn.this.getLayoutParams().width == -2 && TBSpecificationBtn.this.getContentWidth() + TBSpecificationBtn.this.fop.foI + TBSpecificationBtn.this.fop.foJ != width) {
                    TBSpecificationBtn.this.requestLayout();
                } else {
                    TBSpecificationBtn.this.invalidate();
                }
            }

            @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig.a
            public void buX() {
                TBSpecificationBtn.this.pM(TBSpecificationBtn.this.aln);
                TBSpecificationBtn.this.invalidate();
            }
        };
        init();
    }

    private void init() {
        this.aln = TbadkCoreApplication.getInst().getSkinType();
        this.fop = new b();
        this.fop.foO = this.foy;
        this.textPaint = new Paint();
        this.textPaint.setTextSize(l.getDimens(getContext(), R.dimen.T_X08));
        this.textPaint.setAntiAlias(true);
    }

    public void setConfig(TBSpecificationButtonConfig tBSpecificationButtonConfig) {
        if (tBSpecificationButtonConfig != null) {
            this.fop = tBSpecificationButtonConfig;
            this.fop.foO = this.foy;
            this.fou = true;
        }
    }

    public TBSpecificationButtonConfig getStyleConfig() {
        return this.fop;
    }

    public void setText(String str) {
        if (StringUtils.isNull(str)) {
            str = "";
        }
        this.text = str;
        this.textPaint.getTextBounds(str, 0, str.length(), this.fot);
        int width = getWidth();
        if (width > 0) {
            if (getLayoutParams().width == -2) {
                if (getContentWidth() + this.fop.foI + this.fop.foJ != width) {
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

    public void setTextSize(@DimenRes int i) {
        this.textPaint.setTextSize(l.getDimens(getContext(), i));
        this.textPaint.getTextBounds(this.text, 0, this.text.length(), this.fot);
        int width = getWidth();
        if (width > 0 && getLayoutParams().width == -2 && getContentWidth() + this.fop.foI + this.fop.foJ != width) {
            requestLayout();
            return;
        }
        int height = getHeight();
        if (height > 0 && getLayoutParams().height == -2 && ((int) this.textPaint.getTextSize()) + (this.fop.foK * 2) != height) {
            requestLayout();
        }
    }

    public void setClickState(boolean z) {
        this.fov = z;
    }

    public void setUseDisableState(boolean z) {
        this.fov = false;
        this.fox = z;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int measureWidth = measureWidth(i);
        setMeasuredDimension(measureWidth, !this.fop.foH ? measureHeight(i2) : measureWidth);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buU() {
        this.foq = this.fop.buY();
        this.f3for = this.fop.buZ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pM(int i) {
        if (getHeight() != 0) {
            this.fop.aln = i;
            this.eXT = this.fop.ao(getHeight() / 2);
            this.textPaint.setColor(this.fop.foM ? ap.getColor(i, this.fop.foB) : this.fop.foB);
        }
    }

    private int measureWidth(int i) {
        float contentWidth = getContentWidth();
        if (View.MeasureSpec.getMode(i) == 1073741824) {
            return View.MeasureSpec.getSize(i);
        }
        return (int) Math.max(this.fop.minWidth, contentWidth + this.fop.foI + this.fop.foJ + getPaddingLeft() + getPaddingRight());
    }

    private int measureHeight(int i) {
        float textSize = this.textPaint.getTextSize();
        if (View.MeasureSpec.getMode(i) == 1073741824) {
            return View.MeasureSpec.getSize(i);
        }
        return (int) Math.max(this.fop.minHeight, textSize + (this.fop.foK * 2) + getPaddingTop() + getPaddingBottom());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getContentWidth() {
        int i = 0;
        if (this.fop.foE[0] > 0) {
            i = this.fop.iconSize;
            if (!StringUtils.isNull(this.text)) {
                i += this.fop.foL;
            }
        }
        if (this.fop.foE[1] > 0) {
            i = this.fop.iconSize;
            if (!StringUtils.isNull(this.text)) {
                i += this.fop.foL;
            }
        }
        return i + this.fot.width();
    }

    public void setTextHorizontalCenter(boolean z) {
        this.fow = z;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int width;
        if (this.fou) {
            pM(this.aln);
            buU();
            this.fou = false;
        }
        if (this.eXT != null) {
            if (this.eXT instanceof GradientDrawable) {
                ((GradientDrawable) this.eXT).setCornerRadius(getHeight() / 2);
            }
            this.eXT.setBounds(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom());
            this.eXT.draw(canvas);
        }
        if (((getWidth() - getContentWidth()) - getPaddingRight()) - getPaddingLeft() == this.fop.foI + this.fop.foJ) {
            width = this.fop.foI;
        } else {
            width = ((((getWidth() - getContentWidth()) - getPaddingRight()) - getPaddingLeft()) / 2) + getPaddingLeft();
        }
        int height = (getHeight() + getPaddingTop()) / 2;
        int i = this.fop.iconSize / 2;
        if (this.foq != null) {
            this.foq.setBounds(width, height - i, this.fop.iconSize + width, height + i);
            this.foq.draw(canvas);
            width += this.fop.iconSize + this.fop.foL;
        }
        if (this.f3for != null) {
            this.f3for.setBounds(this.fop.foL + width, height - i, this.fop.foL + width + this.fop.iconSize, height + i);
            this.f3for.draw(canvas);
        }
        if (this.fow) {
            width = (getWidth() - this.fot.width()) / 2;
        }
        if (!StringUtils.isNull(this.text)) {
            this.textPaint.getTextBounds(this.text, 0, this.text.length(), this.fot);
            canvas.drawText(this.text, width, (((getHeight() - getPaddingBottom()) + getPaddingTop()) / 2.0f) - this.fot.centerY(), this.textPaint);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void drawableStateChanged() {
        int[] drawableState;
        boolean z = false;
        boolean z2 = true;
        for (int i : getDrawableState()) {
            if (i == 16842910) {
                z2 = false;
            } else if (i == 16842919) {
                z = true;
            }
        }
        if (!this.fov) {
            if (this.fox) {
                setAlpha(ap.fcn);
            } else {
                setAlpha(1.0f);
            }
        } else if (z2) {
            setAlpha(ap.fcn);
        } else if (z && isClickable()) {
            setAlpha(ap.fcm);
        } else {
            setAlpha(1.0f);
        }
        super.drawableStateChanged();
    }

    public void bus() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void changeSkinType(int i) {
        this.aln = i;
        this.fop.aln = i;
        buU();
        pM(i);
        invalidate();
    }
}
