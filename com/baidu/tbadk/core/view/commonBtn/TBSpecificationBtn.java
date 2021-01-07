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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class TBSpecificationBtn extends View {
    private int akW;
    private Drawable eYP;
    public Object fpg;
    private TBSpecificationButtonConfig fph;
    private Drawable fpi;
    private Drawable fpj;
    private Rect fpk;
    private boolean fpl;
    private boolean fpm;
    private boolean fpn;
    private boolean fpo;
    private TBSpecificationButtonConfig.a fpp;
    private String text;
    private Paint textPaint;

    public TBSpecificationBtn(Context context) {
        super(context);
        this.fpg = null;
        this.text = "";
        this.fpk = new Rect();
        this.fpl = true;
        this.fpm = true;
        this.fpn = false;
        this.akW = 0;
        this.fpo = false;
        this.fpp = new TBSpecificationButtonConfig.a() { // from class: com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn.1
            @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig.a
            public void bys() {
                int width = TBSpecificationBtn.this.getWidth();
                if (width > 0 && TBSpecificationBtn.this.getLayoutParams().width == -2 && TBSpecificationBtn.this.getContentWidth() + TBSpecificationBtn.this.fph.fpA + TBSpecificationBtn.this.fph.fpB != width) {
                    TBSpecificationBtn.this.requestLayout();
                }
            }

            @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig.a
            public void byt() {
                TBSpecificationBtn.this.byr();
                int width = TBSpecificationBtn.this.getWidth();
                if (width > 0 && TBSpecificationBtn.this.getLayoutParams().width == -2 && TBSpecificationBtn.this.getContentWidth() + TBSpecificationBtn.this.fph.fpA + TBSpecificationBtn.this.fph.fpB != width) {
                    TBSpecificationBtn.this.requestLayout();
                } else {
                    TBSpecificationBtn.this.invalidate();
                }
            }

            @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig.a
            public void byu() {
                TBSpecificationBtn.this.rm(TBSpecificationBtn.this.akW);
                TBSpecificationBtn.this.invalidate();
            }
        };
        init();
    }

    public TBSpecificationBtn(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fpg = null;
        this.text = "";
        this.fpk = new Rect();
        this.fpl = true;
        this.fpm = true;
        this.fpn = false;
        this.akW = 0;
        this.fpo = false;
        this.fpp = new TBSpecificationButtonConfig.a() { // from class: com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn.1
            @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig.a
            public void bys() {
                int width = TBSpecificationBtn.this.getWidth();
                if (width > 0 && TBSpecificationBtn.this.getLayoutParams().width == -2 && TBSpecificationBtn.this.getContentWidth() + TBSpecificationBtn.this.fph.fpA + TBSpecificationBtn.this.fph.fpB != width) {
                    TBSpecificationBtn.this.requestLayout();
                }
            }

            @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig.a
            public void byt() {
                TBSpecificationBtn.this.byr();
                int width = TBSpecificationBtn.this.getWidth();
                if (width > 0 && TBSpecificationBtn.this.getLayoutParams().width == -2 && TBSpecificationBtn.this.getContentWidth() + TBSpecificationBtn.this.fph.fpA + TBSpecificationBtn.this.fph.fpB != width) {
                    TBSpecificationBtn.this.requestLayout();
                } else {
                    TBSpecificationBtn.this.invalidate();
                }
            }

            @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig.a
            public void byu() {
                TBSpecificationBtn.this.rm(TBSpecificationBtn.this.akW);
                TBSpecificationBtn.this.invalidate();
            }
        };
        init();
    }

    public TBSpecificationBtn(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fpg = null;
        this.text = "";
        this.fpk = new Rect();
        this.fpl = true;
        this.fpm = true;
        this.fpn = false;
        this.akW = 0;
        this.fpo = false;
        this.fpp = new TBSpecificationButtonConfig.a() { // from class: com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn.1
            @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig.a
            public void bys() {
                int width = TBSpecificationBtn.this.getWidth();
                if (width > 0 && TBSpecificationBtn.this.getLayoutParams().width == -2 && TBSpecificationBtn.this.getContentWidth() + TBSpecificationBtn.this.fph.fpA + TBSpecificationBtn.this.fph.fpB != width) {
                    TBSpecificationBtn.this.requestLayout();
                }
            }

            @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig.a
            public void byt() {
                TBSpecificationBtn.this.byr();
                int width = TBSpecificationBtn.this.getWidth();
                if (width > 0 && TBSpecificationBtn.this.getLayoutParams().width == -2 && TBSpecificationBtn.this.getContentWidth() + TBSpecificationBtn.this.fph.fpA + TBSpecificationBtn.this.fph.fpB != width) {
                    TBSpecificationBtn.this.requestLayout();
                } else {
                    TBSpecificationBtn.this.invalidate();
                }
            }

            @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig.a
            public void byu() {
                TBSpecificationBtn.this.rm(TBSpecificationBtn.this.akW);
                TBSpecificationBtn.this.invalidate();
            }
        };
        init();
    }

    private void init() {
        this.akW = TbadkCoreApplication.getInst().getSkinType();
        this.fph = new b();
        this.fph.fpG = this.fpp;
        this.textPaint = new Paint();
        this.textPaint.setTextSize(l.getDimens(getContext(), R.dimen.T_X08));
        this.textPaint.setAntiAlias(true);
    }

    public void setConfig(TBSpecificationButtonConfig tBSpecificationButtonConfig) {
        if (tBSpecificationButtonConfig != null) {
            this.fph = tBSpecificationButtonConfig;
            this.fph.fpG = this.fpp;
            this.fpl = true;
        }
    }

    public TBSpecificationButtonConfig getStyleConfig() {
        return this.fph;
    }

    public void setText(String str) {
        if (StringUtils.isNull(str)) {
            str = "";
        }
        this.text = str;
        this.textPaint.getTextBounds(str, 0, str.length(), this.fpk);
        int width = getWidth();
        if (width > 0) {
            if (getLayoutParams().width == -2) {
                if (getContentWidth() + this.fph.fpA + this.fph.fpB != width) {
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
        this.textPaint.getTextBounds(this.text, 0, this.text.length(), this.fpk);
        int width = getWidth();
        if (width > 0 && getLayoutParams().width == -2 && getContentWidth() + this.fph.fpA + this.fph.fpB != width) {
            requestLayout();
            return;
        }
        int height = getHeight();
        if (height > 0 && getLayoutParams().height == -2 && ((int) this.textPaint.getTextSize()) + (this.fph.fpC * 2) != height) {
            requestLayout();
        }
    }

    public void setClickState(boolean z) {
        this.fpm = z;
    }

    public void setUseDisableState(boolean z) {
        this.fpm = false;
        this.fpo = z;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int measureWidth = measureWidth(i);
        setMeasuredDimension(measureWidth, !this.fph.fpz ? measureHeight(i2) : measureWidth);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void byr() {
        this.fpi = this.fph.byv();
        this.fpj = this.fph.byw();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rm(int i) {
        if (getHeight() != 0) {
            this.fph.akW = i;
            this.eYP = this.fph.aj(getHeight() / 2);
            this.textPaint.setColor(this.fph.fpE ? ao.getColor(i, this.fph.fpt) : this.fph.fpt);
        }
    }

    private int measureWidth(int i) {
        float contentWidth = getContentWidth();
        if (View.MeasureSpec.getMode(i) == 1073741824) {
            return View.MeasureSpec.getSize(i);
        }
        return (int) Math.max(this.fph.minWidth, contentWidth + this.fph.fpA + this.fph.fpB + getPaddingLeft() + getPaddingRight());
    }

    private int measureHeight(int i) {
        float textSize = this.textPaint.getTextSize();
        if (View.MeasureSpec.getMode(i) == 1073741824) {
            return View.MeasureSpec.getSize(i);
        }
        return (int) Math.max(this.fph.minHeight, textSize + (this.fph.fpC * 2) + getPaddingTop() + getPaddingBottom());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getContentWidth() {
        int i = 0;
        if (this.fph.fpw[0] > 0) {
            i = this.fph.iconSize;
            if (!StringUtils.isNull(this.text)) {
                i += this.fph.fpD;
            }
        }
        if (this.fph.fpw[1] > 0) {
            i = this.fph.iconSize;
            if (!StringUtils.isNull(this.text)) {
                i += this.fph.fpD;
            }
        }
        return i + this.fpk.width();
    }

    public void setTextHorizontalCenter(boolean z) {
        this.fpn = z;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int width;
        if (this.fpl) {
            rm(this.akW);
            byr();
            this.fpl = false;
        }
        if (this.eYP != null) {
            if (this.eYP instanceof GradientDrawable) {
                ((GradientDrawable) this.eYP).setCornerRadius(getHeight() / 2);
            }
            this.eYP.setBounds(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom());
            this.eYP.draw(canvas);
        }
        if (((getWidth() - getContentWidth()) - getPaddingRight()) - getPaddingLeft() == this.fph.fpA + this.fph.fpB) {
            width = this.fph.fpA;
        } else {
            width = ((((getWidth() - getContentWidth()) - getPaddingRight()) - getPaddingLeft()) / 2) + getPaddingLeft();
        }
        int height = (getHeight() + getPaddingTop()) / 2;
        int i = this.fph.iconSize / 2;
        if (this.fpi != null) {
            this.fpi.setBounds(width, height - i, this.fph.iconSize + width, height + i);
            this.fpi.draw(canvas);
            width += this.fph.iconSize + this.fph.fpD;
        }
        if (this.fpj != null) {
            this.fpj.setBounds(this.fph.fpD + width, height - i, this.fph.fpD + width + this.fph.iconSize, height + i);
            this.fpj.draw(canvas);
        }
        if (this.fpn) {
            width = (getWidth() - this.fpk.width()) / 2;
        }
        if (!StringUtils.isNull(this.text)) {
            this.textPaint.getTextBounds(this.text, 0, this.text.length(), this.fpk);
            canvas.drawText(this.text, width, (((getHeight() - getPaddingBottom()) + getPaddingTop()) / 2.0f) - this.fpk.centerY(), this.textPaint);
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
        if (!this.fpm) {
            if (this.fpo) {
                setAlpha(ao.fdi);
            } else {
                setAlpha(1.0f);
            }
        } else if (z2) {
            setAlpha(ao.fdi);
        } else if (z && isClickable()) {
            setAlpha(ao.fdh);
        } else {
            setAlpha(1.0f);
        }
        super.drawableStateChanged();
    }

    public void bxP() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void changeSkinType(int i) {
        this.akW = i;
        this.fph.akW = i;
        byr();
        rm(i);
        invalidate();
    }
}
