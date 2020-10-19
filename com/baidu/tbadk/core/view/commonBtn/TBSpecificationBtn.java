package com.baidu.tbadk.core.view.commonBtn;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
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
    private int ajp;
    public Object eKJ;
    private TBSpecificationButtonConfig eKK;
    private Drawable eKL;
    private Drawable eKM;
    private Drawable eKN;
    private boolean eKO;
    private boolean eKP;
    private boolean eKQ;
    private TBSpecificationButtonConfig.a eKR;
    private String text;
    private Paint textPaint;
    private int textWidth;

    public TBSpecificationBtn(Context context) {
        super(context);
        this.eKJ = null;
        this.text = "";
        this.eKO = true;
        this.eKP = true;
        this.eKQ = false;
        this.ajp = 0;
        this.eKR = new TBSpecificationButtonConfig.a() { // from class: com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn.1
            @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig.a
            public void boO() {
                int width = TBSpecificationBtn.this.getWidth();
                if (width > 0 && TBSpecificationBtn.this.getLayoutParams().width == -2 && TBSpecificationBtn.this.getContentWidth() + TBSpecificationBtn.this.eKK.eLb + TBSpecificationBtn.this.eKK.eLc != width) {
                    TBSpecificationBtn.this.requestLayout();
                }
            }

            @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig.a
            public void boP() {
                TBSpecificationBtn.this.boN();
                int width = TBSpecificationBtn.this.getWidth();
                if (width > 0 && TBSpecificationBtn.this.getLayoutParams().width == -2 && TBSpecificationBtn.this.getContentWidth() + TBSpecificationBtn.this.eKK.eLb + TBSpecificationBtn.this.eKK.eLc != width) {
                    TBSpecificationBtn.this.requestLayout();
                } else {
                    TBSpecificationBtn.this.invalidate();
                }
            }

            @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig.a
            public void boQ() {
                TBSpecificationBtn.this.pG(TBSpecificationBtn.this.ajp);
                TBSpecificationBtn.this.invalidate();
            }
        };
        init();
    }

    public TBSpecificationBtn(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eKJ = null;
        this.text = "";
        this.eKO = true;
        this.eKP = true;
        this.eKQ = false;
        this.ajp = 0;
        this.eKR = new TBSpecificationButtonConfig.a() { // from class: com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn.1
            @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig.a
            public void boO() {
                int width = TBSpecificationBtn.this.getWidth();
                if (width > 0 && TBSpecificationBtn.this.getLayoutParams().width == -2 && TBSpecificationBtn.this.getContentWidth() + TBSpecificationBtn.this.eKK.eLb + TBSpecificationBtn.this.eKK.eLc != width) {
                    TBSpecificationBtn.this.requestLayout();
                }
            }

            @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig.a
            public void boP() {
                TBSpecificationBtn.this.boN();
                int width = TBSpecificationBtn.this.getWidth();
                if (width > 0 && TBSpecificationBtn.this.getLayoutParams().width == -2 && TBSpecificationBtn.this.getContentWidth() + TBSpecificationBtn.this.eKK.eLb + TBSpecificationBtn.this.eKK.eLc != width) {
                    TBSpecificationBtn.this.requestLayout();
                } else {
                    TBSpecificationBtn.this.invalidate();
                }
            }

            @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig.a
            public void boQ() {
                TBSpecificationBtn.this.pG(TBSpecificationBtn.this.ajp);
                TBSpecificationBtn.this.invalidate();
            }
        };
        init();
    }

    public TBSpecificationBtn(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eKJ = null;
        this.text = "";
        this.eKO = true;
        this.eKP = true;
        this.eKQ = false;
        this.ajp = 0;
        this.eKR = new TBSpecificationButtonConfig.a() { // from class: com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn.1
            @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig.a
            public void boO() {
                int width = TBSpecificationBtn.this.getWidth();
                if (width > 0 && TBSpecificationBtn.this.getLayoutParams().width == -2 && TBSpecificationBtn.this.getContentWidth() + TBSpecificationBtn.this.eKK.eLb + TBSpecificationBtn.this.eKK.eLc != width) {
                    TBSpecificationBtn.this.requestLayout();
                }
            }

            @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig.a
            public void boP() {
                TBSpecificationBtn.this.boN();
                int width = TBSpecificationBtn.this.getWidth();
                if (width > 0 && TBSpecificationBtn.this.getLayoutParams().width == -2 && TBSpecificationBtn.this.getContentWidth() + TBSpecificationBtn.this.eKK.eLb + TBSpecificationBtn.this.eKK.eLc != width) {
                    TBSpecificationBtn.this.requestLayout();
                } else {
                    TBSpecificationBtn.this.invalidate();
                }
            }

            @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig.a
            public void boQ() {
                TBSpecificationBtn.this.pG(TBSpecificationBtn.this.ajp);
                TBSpecificationBtn.this.invalidate();
            }
        };
        init();
    }

    private void init() {
        this.ajp = TbadkCoreApplication.getInst().getSkinType();
        this.eKK = new b();
        this.eKK.eLh = this.eKR;
        this.textPaint = new Paint();
        this.textPaint.setTextSize(l.getDimens(getContext(), R.dimen.tbds36));
        this.textPaint.setAntiAlias(true);
    }

    public void setConfig(TBSpecificationButtonConfig tBSpecificationButtonConfig) {
        if (tBSpecificationButtonConfig != null) {
            this.eKK = tBSpecificationButtonConfig;
            this.eKK.eLh = this.eKR;
            this.eKO = true;
        }
    }

    public TBSpecificationButtonConfig getStyleConfig() {
        return this.eKK;
    }

    public void setText(String str) {
        if (StringUtils.isNull(str)) {
            str = "";
        }
        this.text = str;
        this.textWidth = (int) this.textPaint.measureText(str);
        int width = getWidth();
        if (width > 0) {
            if (getLayoutParams().width == -2) {
                if (getContentWidth() + this.eKK.eLb + this.eKK.eLc != width) {
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
        this.textWidth = (int) this.textPaint.measureText(this.text);
        int width = getWidth();
        if (width > 0 && getLayoutParams().width == -2 && getContentWidth() + this.eKK.eLb + this.eKK.eLc != width) {
            requestLayout();
            return;
        }
        int height = getHeight();
        if (height > 0 && getLayoutParams().height == -2 && ((int) this.textPaint.getTextSize()) + (this.eKK.eLd * 2) != height) {
            requestLayout();
        }
    }

    public void setClickState(boolean z) {
        this.eKP = z;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int measureWidth = measureWidth(i);
        setMeasuredDimension(measureWidth, !this.eKK.eLa ? measureHeight(i2) : measureWidth);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void boN() {
        this.eKM = this.eKK.boR();
        this.eKN = this.eKK.boS();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pG(int i) {
        if (getHeight() != 0) {
            this.eKK.ajp = i;
            this.eKL = this.eKK.ac(getHeight() / 2);
            this.textPaint.setColor(this.eKK.eLf ? ap.getColor(i, this.eKK.eKT) : this.eKK.eKT);
        }
    }

    private int measureWidth(int i) {
        float contentWidth = getContentWidth();
        if (View.MeasureSpec.getMode(i) == 1073741824) {
            return View.MeasureSpec.getSize(i);
        }
        return (int) Math.max(this.eKK.minWidth, contentWidth + this.eKK.eLb + this.eKK.eLc + getPaddingLeft() + getPaddingRight());
    }

    private int measureHeight(int i) {
        float textSize = this.textPaint.getTextSize();
        if (View.MeasureSpec.getMode(i) == 1073741824) {
            return View.MeasureSpec.getSize(i);
        }
        return (int) Math.max(this.eKK.minHeight, textSize + (this.eKK.eLd * 2) + getPaddingTop() + getPaddingBottom());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getContentWidth() {
        int i = 0;
        if (this.eKK.eKW[0] > 0) {
            i = this.eKK.eKY;
            if (!StringUtils.isNull(this.text)) {
                i += this.eKK.eLe;
            }
        }
        if (this.eKK.eKW[1] > 0) {
            i = this.eKK.eKY;
            if (!StringUtils.isNull(this.text)) {
                i += this.eKK.eLe;
            }
        }
        return i + this.textWidth;
    }

    public void setTextHorizontalCenter(boolean z) {
        this.eKQ = z;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int width;
        if (this.eKO) {
            pG(this.ajp);
            boN();
            this.eKO = false;
        }
        if (this.eKL != null) {
            if (this.eKL instanceof GradientDrawable) {
                ((GradientDrawable) this.eKL).setCornerRadius(getHeight() / 2);
            }
            this.eKL.setBounds(0, 0, getWidth(), getHeight());
            this.eKL.draw(canvas);
        }
        if (((getWidth() - getContentWidth()) - getPaddingRight()) - getPaddingLeft() == this.eKK.eLb + this.eKK.eLc) {
            width = this.eKK.eLb;
        } else {
            width = ((((getWidth() - getContentWidth()) - getPaddingRight()) - getPaddingLeft()) / 2) + getPaddingLeft();
        }
        int height = (getHeight() + getPaddingTop()) / 2;
        int i = this.eKK.eKY / 2;
        if (this.eKM != null) {
            this.eKM.setBounds(width, height - i, this.eKK.eKY + width, height + i);
            this.eKM.draw(canvas);
            width += this.eKK.eKY + this.eKK.eLe;
        }
        if (this.eKN != null) {
            this.eKN.setBounds(this.eKK.eLe + width, height - i, this.eKK.eLe + width + this.eKK.eKY, height + i);
            this.eKN.draw(canvas);
        }
        if (this.eKQ) {
            width = (getWidth() - this.textWidth) / 2;
        }
        if (!StringUtils.isNull(this.text)) {
            Paint.FontMetrics fontMetrics = this.textPaint.getFontMetrics();
            canvas.drawText(this.text, width, ((((getHeight() - getPaddingBottom()) + getPaddingTop()) + this.textPaint.getTextSize()) / 2.0f) - (fontMetrics.ascent - fontMetrics.top), this.textPaint);
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
        if (!this.eKP) {
            setAlpha(1.0f);
        } else if (z2) {
            setAlpha(0.3f);
        } else if (z && isClickable()) {
            setAlpha(0.5f);
        } else {
            setAlpha(1.0f);
        }
        super.drawableStateChanged();
    }

    public void bok() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void changeSkinType(int i) {
        this.ajp = i;
        this.eKK.ajp = i;
        boN();
        pG(i);
        invalidate();
    }
}
