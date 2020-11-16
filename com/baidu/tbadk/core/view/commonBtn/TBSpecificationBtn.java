package com.baidu.tbadk.core.view.commonBtn;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.DimenRes;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class TBSpecificationBtn extends View {
    private int ajv;
    private Drawable eHG;
    public Object eYb;
    private TBSpecificationButtonConfig eYc;
    private Drawable eYd;
    private Drawable eYe;
    private Rect eYf;
    private boolean eYg;
    private boolean eYh;
    private boolean eYi;
    private boolean eYj;
    private TBSpecificationButtonConfig.a eYk;
    private String text;
    private Paint textPaint;

    public TBSpecificationBtn(Context context) {
        super(context);
        this.eYb = null;
        this.text = "";
        this.eYf = new Rect();
        this.eYg = true;
        this.eYh = true;
        this.eYi = false;
        this.ajv = 0;
        this.eYj = false;
        this.eYk = new TBSpecificationButtonConfig.a() { // from class: com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn.1
            @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig.a
            public void bsx() {
                int width = TBSpecificationBtn.this.getWidth();
                if (width > 0 && TBSpecificationBtn.this.getLayoutParams().width == -2 && TBSpecificationBtn.this.getContentWidth() + TBSpecificationBtn.this.eYc.eYu + TBSpecificationBtn.this.eYc.eYv != width) {
                    TBSpecificationBtn.this.requestLayout();
                }
            }

            @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig.a
            public void bsy() {
                TBSpecificationBtn.this.bsw();
                int width = TBSpecificationBtn.this.getWidth();
                if (width > 0 && TBSpecificationBtn.this.getLayoutParams().width == -2 && TBSpecificationBtn.this.getContentWidth() + TBSpecificationBtn.this.eYc.eYu + TBSpecificationBtn.this.eYc.eYv != width) {
                    TBSpecificationBtn.this.requestLayout();
                } else {
                    TBSpecificationBtn.this.invalidate();
                }
            }

            @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig.a
            public void bsz() {
                TBSpecificationBtn.this.qz(TBSpecificationBtn.this.ajv);
                TBSpecificationBtn.this.invalidate();
            }
        };
        init();
    }

    public TBSpecificationBtn(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eYb = null;
        this.text = "";
        this.eYf = new Rect();
        this.eYg = true;
        this.eYh = true;
        this.eYi = false;
        this.ajv = 0;
        this.eYj = false;
        this.eYk = new TBSpecificationButtonConfig.a() { // from class: com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn.1
            @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig.a
            public void bsx() {
                int width = TBSpecificationBtn.this.getWidth();
                if (width > 0 && TBSpecificationBtn.this.getLayoutParams().width == -2 && TBSpecificationBtn.this.getContentWidth() + TBSpecificationBtn.this.eYc.eYu + TBSpecificationBtn.this.eYc.eYv != width) {
                    TBSpecificationBtn.this.requestLayout();
                }
            }

            @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig.a
            public void bsy() {
                TBSpecificationBtn.this.bsw();
                int width = TBSpecificationBtn.this.getWidth();
                if (width > 0 && TBSpecificationBtn.this.getLayoutParams().width == -2 && TBSpecificationBtn.this.getContentWidth() + TBSpecificationBtn.this.eYc.eYu + TBSpecificationBtn.this.eYc.eYv != width) {
                    TBSpecificationBtn.this.requestLayout();
                } else {
                    TBSpecificationBtn.this.invalidate();
                }
            }

            @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig.a
            public void bsz() {
                TBSpecificationBtn.this.qz(TBSpecificationBtn.this.ajv);
                TBSpecificationBtn.this.invalidate();
            }
        };
        init();
    }

    public TBSpecificationBtn(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eYb = null;
        this.text = "";
        this.eYf = new Rect();
        this.eYg = true;
        this.eYh = true;
        this.eYi = false;
        this.ajv = 0;
        this.eYj = false;
        this.eYk = new TBSpecificationButtonConfig.a() { // from class: com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn.1
            @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig.a
            public void bsx() {
                int width = TBSpecificationBtn.this.getWidth();
                if (width > 0 && TBSpecificationBtn.this.getLayoutParams().width == -2 && TBSpecificationBtn.this.getContentWidth() + TBSpecificationBtn.this.eYc.eYu + TBSpecificationBtn.this.eYc.eYv != width) {
                    TBSpecificationBtn.this.requestLayout();
                }
            }

            @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig.a
            public void bsy() {
                TBSpecificationBtn.this.bsw();
                int width = TBSpecificationBtn.this.getWidth();
                if (width > 0 && TBSpecificationBtn.this.getLayoutParams().width == -2 && TBSpecificationBtn.this.getContentWidth() + TBSpecificationBtn.this.eYc.eYu + TBSpecificationBtn.this.eYc.eYv != width) {
                    TBSpecificationBtn.this.requestLayout();
                } else {
                    TBSpecificationBtn.this.invalidate();
                }
            }

            @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig.a
            public void bsz() {
                TBSpecificationBtn.this.qz(TBSpecificationBtn.this.ajv);
                TBSpecificationBtn.this.invalidate();
            }
        };
        init();
    }

    private void init() {
        this.ajv = TbadkCoreApplication.getInst().getSkinType();
        this.eYc = new b();
        this.eYc.eYA = this.eYk;
        this.textPaint = new Paint();
        this.textPaint.setTextSize(l.getDimens(getContext(), R.dimen.T_X08));
        this.textPaint.setAntiAlias(true);
    }

    public void setConfig(TBSpecificationButtonConfig tBSpecificationButtonConfig) {
        if (tBSpecificationButtonConfig != null) {
            this.eYc = tBSpecificationButtonConfig;
            this.eYc.eYA = this.eYk;
            this.eYg = true;
        }
    }

    public TBSpecificationButtonConfig getStyleConfig() {
        return this.eYc;
    }

    public void setText(String str) {
        if (StringUtils.isNull(str)) {
            str = "";
        }
        this.text = str;
        this.textPaint.getTextBounds(str, 0, str.length(), this.eYf);
        int width = getWidth();
        if (width > 0) {
            if (getLayoutParams().width == -2) {
                if (getContentWidth() + this.eYc.eYu + this.eYc.eYv != width) {
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
        this.textPaint.getTextBounds(this.text, 0, this.text.length(), this.eYf);
        int width = getWidth();
        if (width > 0 && getLayoutParams().width == -2 && getContentWidth() + this.eYc.eYu + this.eYc.eYv != width) {
            requestLayout();
            return;
        }
        int height = getHeight();
        if (height > 0 && getLayoutParams().height == -2 && ((int) this.textPaint.getTextSize()) + (this.eYc.eYw * 2) != height) {
            requestLayout();
        }
    }

    public void setClickState(boolean z) {
        this.eYh = z;
    }

    public void setUseDisableState(boolean z) {
        this.eYh = false;
        this.eYj = z;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int measureWidth = measureWidth(i);
        setMeasuredDimension(measureWidth, !this.eYc.eYt ? measureHeight(i2) : measureWidth);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsw() {
        this.eYd = this.eYc.bsA();
        this.eYe = this.eYc.bsB();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qz(int i) {
        if (getHeight() != 0) {
            this.eYc.ajv = i;
            this.eHG = this.eYc.ah(getHeight() / 2);
            this.textPaint.setColor(this.eYc.eYy ? ap.getColor(i, this.eYc.eYm) : this.eYc.eYm);
        }
    }

    private int measureWidth(int i) {
        float contentWidth = getContentWidth();
        if (View.MeasureSpec.getMode(i) == 1073741824) {
            return View.MeasureSpec.getSize(i);
        }
        return (int) Math.max(this.eYc.minWidth, contentWidth + this.eYc.eYu + this.eYc.eYv + getPaddingLeft() + getPaddingRight());
    }

    private int measureHeight(int i) {
        float textSize = this.textPaint.getTextSize();
        if (View.MeasureSpec.getMode(i) == 1073741824) {
            return View.MeasureSpec.getSize(i);
        }
        return (int) Math.max(this.eYc.minHeight, textSize + (this.eYc.eYw * 2) + getPaddingTop() + getPaddingBottom());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getContentWidth() {
        int i = 0;
        if (this.eYc.eYp[0] > 0) {
            i = this.eYc.eYr;
            if (!StringUtils.isNull(this.text)) {
                i += this.eYc.eYx;
            }
        }
        if (this.eYc.eYp[1] > 0) {
            i = this.eYc.eYr;
            if (!StringUtils.isNull(this.text)) {
                i += this.eYc.eYx;
            }
        }
        return i + this.eYf.width();
    }

    public void setTextHorizontalCenter(boolean z) {
        this.eYi = z;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int width;
        if (this.eYg) {
            qz(this.ajv);
            bsw();
            this.eYg = false;
        }
        if (this.eHG != null) {
            if (this.eHG instanceof GradientDrawable) {
                ((GradientDrawable) this.eHG).setCornerRadius(getHeight() / 2);
            }
            this.eHG.setBounds(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom());
            this.eHG.draw(canvas);
        }
        if (((getWidth() - getContentWidth()) - getPaddingRight()) - getPaddingLeft() == this.eYc.eYu + this.eYc.eYv) {
            width = this.eYc.eYu;
        } else {
            width = ((((getWidth() - getContentWidth()) - getPaddingRight()) - getPaddingLeft()) / 2) + getPaddingLeft();
        }
        int height = (getHeight() + getPaddingTop()) / 2;
        int i = this.eYc.eYr / 2;
        if (this.eYd != null) {
            this.eYd.setBounds(width, height - i, this.eYc.eYr + width, height + i);
            this.eYd.draw(canvas);
            width += this.eYc.eYr + this.eYc.eYx;
        }
        if (this.eYe != null) {
            this.eYe.setBounds(this.eYc.eYx + width, height - i, this.eYc.eYx + width + this.eYc.eYr, height + i);
            this.eYe.draw(canvas);
        }
        if (this.eYi) {
            width = (getWidth() - this.eYf.width()) / 2;
        }
        if (!StringUtils.isNull(this.text)) {
            this.textPaint.getTextBounds(this.text, 0, this.text.length(), this.eYf);
            canvas.drawText(this.text, width, (((getHeight() - getPaddingBottom()) + getPaddingTop()) / 2.0f) - this.eYf.centerY(), this.textPaint);
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
        if (!this.eYh) {
            if (this.eYj) {
                setAlpha(ap.eMz);
            } else {
                setAlpha(1.0f);
            }
        } else if (z2) {
            setAlpha(ap.eMz);
        } else if (z && isClickable()) {
            setAlpha(ap.eMy);
        } else {
            setAlpha(1.0f);
        }
        super.drawableStateChanged();
    }

    public void brT() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void changeSkinType(int i) {
        this.ajv = i;
        this.eYc.ajv = i;
        bsw();
        qz(i);
        invalidate();
    }
}
