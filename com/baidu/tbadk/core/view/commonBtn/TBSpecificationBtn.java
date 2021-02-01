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
    private int ajU;
    private Drawable eWu;
    public Object fmP;
    private TBSpecificationButtonConfig fmQ;
    private Drawable fmR;
    private Drawable fmS;
    private Rect fmT;
    private boolean fmU;
    private boolean fmV;
    private boolean fmW;
    private boolean fmX;
    private TBSpecificationButtonConfig.a fmY;
    private String text;
    private Paint textPaint;

    public TBSpecificationBtn(Context context) {
        super(context);
        this.fmP = null;
        this.text = "";
        this.fmT = new Rect();
        this.fmU = true;
        this.fmV = true;
        this.fmW = false;
        this.ajU = 0;
        this.fmX = false;
        this.fmY = new TBSpecificationButtonConfig.a() { // from class: com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn.1
            @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig.a
            public void buS() {
                int width = TBSpecificationBtn.this.getWidth();
                if (width > 0 && TBSpecificationBtn.this.getLayoutParams().width == -2 && TBSpecificationBtn.this.getContentWidth() + TBSpecificationBtn.this.fmQ.fni + TBSpecificationBtn.this.fmQ.fnj != width) {
                    TBSpecificationBtn.this.requestLayout();
                }
            }

            @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig.a
            public void buT() {
                TBSpecificationBtn.this.buR();
                int width = TBSpecificationBtn.this.getWidth();
                if (width > 0 && TBSpecificationBtn.this.getLayoutParams().width == -2 && TBSpecificationBtn.this.getContentWidth() + TBSpecificationBtn.this.fmQ.fni + TBSpecificationBtn.this.fmQ.fnj != width) {
                    TBSpecificationBtn.this.requestLayout();
                } else {
                    TBSpecificationBtn.this.invalidate();
                }
            }

            @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig.a
            public void buU() {
                TBSpecificationBtn.this.pL(TBSpecificationBtn.this.ajU);
                TBSpecificationBtn.this.invalidate();
            }
        };
        init();
    }

    public TBSpecificationBtn(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fmP = null;
        this.text = "";
        this.fmT = new Rect();
        this.fmU = true;
        this.fmV = true;
        this.fmW = false;
        this.ajU = 0;
        this.fmX = false;
        this.fmY = new TBSpecificationButtonConfig.a() { // from class: com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn.1
            @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig.a
            public void buS() {
                int width = TBSpecificationBtn.this.getWidth();
                if (width > 0 && TBSpecificationBtn.this.getLayoutParams().width == -2 && TBSpecificationBtn.this.getContentWidth() + TBSpecificationBtn.this.fmQ.fni + TBSpecificationBtn.this.fmQ.fnj != width) {
                    TBSpecificationBtn.this.requestLayout();
                }
            }

            @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig.a
            public void buT() {
                TBSpecificationBtn.this.buR();
                int width = TBSpecificationBtn.this.getWidth();
                if (width > 0 && TBSpecificationBtn.this.getLayoutParams().width == -2 && TBSpecificationBtn.this.getContentWidth() + TBSpecificationBtn.this.fmQ.fni + TBSpecificationBtn.this.fmQ.fnj != width) {
                    TBSpecificationBtn.this.requestLayout();
                } else {
                    TBSpecificationBtn.this.invalidate();
                }
            }

            @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig.a
            public void buU() {
                TBSpecificationBtn.this.pL(TBSpecificationBtn.this.ajU);
                TBSpecificationBtn.this.invalidate();
            }
        };
        init();
    }

    public TBSpecificationBtn(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fmP = null;
        this.text = "";
        this.fmT = new Rect();
        this.fmU = true;
        this.fmV = true;
        this.fmW = false;
        this.ajU = 0;
        this.fmX = false;
        this.fmY = new TBSpecificationButtonConfig.a() { // from class: com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn.1
            @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig.a
            public void buS() {
                int width = TBSpecificationBtn.this.getWidth();
                if (width > 0 && TBSpecificationBtn.this.getLayoutParams().width == -2 && TBSpecificationBtn.this.getContentWidth() + TBSpecificationBtn.this.fmQ.fni + TBSpecificationBtn.this.fmQ.fnj != width) {
                    TBSpecificationBtn.this.requestLayout();
                }
            }

            @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig.a
            public void buT() {
                TBSpecificationBtn.this.buR();
                int width = TBSpecificationBtn.this.getWidth();
                if (width > 0 && TBSpecificationBtn.this.getLayoutParams().width == -2 && TBSpecificationBtn.this.getContentWidth() + TBSpecificationBtn.this.fmQ.fni + TBSpecificationBtn.this.fmQ.fnj != width) {
                    TBSpecificationBtn.this.requestLayout();
                } else {
                    TBSpecificationBtn.this.invalidate();
                }
            }

            @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig.a
            public void buU() {
                TBSpecificationBtn.this.pL(TBSpecificationBtn.this.ajU);
                TBSpecificationBtn.this.invalidate();
            }
        };
        init();
    }

    private void init() {
        this.ajU = TbadkCoreApplication.getInst().getSkinType();
        this.fmQ = new b();
        this.fmQ.fno = this.fmY;
        this.textPaint = new Paint();
        this.textPaint.setTextSize(l.getDimens(getContext(), R.dimen.T_X08));
        this.textPaint.setAntiAlias(true);
    }

    public void setConfig(TBSpecificationButtonConfig tBSpecificationButtonConfig) {
        if (tBSpecificationButtonConfig != null) {
            this.fmQ = tBSpecificationButtonConfig;
            this.fmQ.fno = this.fmY;
            this.fmU = true;
        }
    }

    public TBSpecificationButtonConfig getStyleConfig() {
        return this.fmQ;
    }

    public void setText(String str) {
        if (StringUtils.isNull(str)) {
            str = "";
        }
        this.text = str;
        this.textPaint.getTextBounds(str, 0, str.length(), this.fmT);
        int width = getWidth();
        if (width > 0) {
            if (getLayoutParams().width == -2) {
                if (getContentWidth() + this.fmQ.fni + this.fmQ.fnj != width) {
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
        this.textPaint.getTextBounds(this.text, 0, this.text.length(), this.fmT);
        int width = getWidth();
        if (width > 0 && getLayoutParams().width == -2 && getContentWidth() + this.fmQ.fni + this.fmQ.fnj != width) {
            requestLayout();
            return;
        }
        int height = getHeight();
        if (height > 0 && getLayoutParams().height == -2 && ((int) this.textPaint.getTextSize()) + (this.fmQ.fnk * 2) != height) {
            requestLayout();
        }
    }

    public void setClickState(boolean z) {
        this.fmV = z;
    }

    public void setUseDisableState(boolean z) {
        this.fmV = false;
        this.fmX = z;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int measureWidth = measureWidth(i);
        setMeasuredDimension(measureWidth, !this.fmQ.fnh ? measureHeight(i2) : measureWidth);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buR() {
        this.fmR = this.fmQ.buV();
        this.fmS = this.fmQ.buW();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pL(int i) {
        if (getHeight() != 0) {
            this.fmQ.ajU = i;
            this.eWu = this.fmQ.ak(getHeight() / 2);
            this.textPaint.setColor(this.fmQ.fnm ? ap.getColor(i, this.fmQ.fnb) : this.fmQ.fnb);
        }
    }

    private int measureWidth(int i) {
        float contentWidth = getContentWidth();
        if (View.MeasureSpec.getMode(i) == 1073741824) {
            return View.MeasureSpec.getSize(i);
        }
        return (int) Math.max(this.fmQ.minWidth, contentWidth + this.fmQ.fni + this.fmQ.fnj + getPaddingLeft() + getPaddingRight());
    }

    private int measureHeight(int i) {
        float textSize = this.textPaint.getTextSize();
        if (View.MeasureSpec.getMode(i) == 1073741824) {
            return View.MeasureSpec.getSize(i);
        }
        return (int) Math.max(this.fmQ.minHeight, textSize + (this.fmQ.fnk * 2) + getPaddingTop() + getPaddingBottom());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getContentWidth() {
        int i = 0;
        if (this.fmQ.fne[0] > 0) {
            i = this.fmQ.iconSize;
            if (!StringUtils.isNull(this.text)) {
                i += this.fmQ.fnl;
            }
        }
        if (this.fmQ.fne[1] > 0) {
            i = this.fmQ.iconSize;
            if (!StringUtils.isNull(this.text)) {
                i += this.fmQ.fnl;
            }
        }
        return i + this.fmT.width();
    }

    public void setTextHorizontalCenter(boolean z) {
        this.fmW = z;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int width;
        if (this.fmU) {
            pL(this.ajU);
            buR();
            this.fmU = false;
        }
        if (this.eWu != null) {
            if (this.eWu instanceof GradientDrawable) {
                ((GradientDrawable) this.eWu).setCornerRadius(getHeight() / 2);
            }
            this.eWu.setBounds(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom());
            this.eWu.draw(canvas);
        }
        if (((getWidth() - getContentWidth()) - getPaddingRight()) - getPaddingLeft() == this.fmQ.fni + this.fmQ.fnj) {
            width = this.fmQ.fni;
        } else {
            width = ((((getWidth() - getContentWidth()) - getPaddingRight()) - getPaddingLeft()) / 2) + getPaddingLeft();
        }
        int height = (getHeight() + getPaddingTop()) / 2;
        int i = this.fmQ.iconSize / 2;
        if (this.fmR != null) {
            this.fmR.setBounds(width, height - i, this.fmQ.iconSize + width, height + i);
            this.fmR.draw(canvas);
            width += this.fmQ.iconSize + this.fmQ.fnl;
        }
        if (this.fmS != null) {
            this.fmS.setBounds(this.fmQ.fnl + width, height - i, this.fmQ.fnl + width + this.fmQ.iconSize, height + i);
            this.fmS.draw(canvas);
        }
        if (this.fmW) {
            width = (getWidth() - this.fmT.width()) / 2;
        }
        if (!StringUtils.isNull(this.text)) {
            this.textPaint.getTextBounds(this.text, 0, this.text.length(), this.fmT);
            canvas.drawText(this.text, width, (((getHeight() - getPaddingBottom()) + getPaddingTop()) / 2.0f) - this.fmT.centerY(), this.textPaint);
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
        if (!this.fmV) {
            if (this.fmX) {
                setAlpha(ap.faO);
            } else {
                setAlpha(1.0f);
            }
        } else if (z2) {
            setAlpha(ap.faO);
        } else if (z && isClickable()) {
            setAlpha(ap.faN);
        } else {
            setAlpha(1.0f);
        }
        super.drawableStateChanged();
    }

    public void bup() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void changeSkinType(int i) {
        this.ajU = i;
        this.fmQ.ajU = i;
        buR();
        pL(i);
        invalidate();
    }
}
