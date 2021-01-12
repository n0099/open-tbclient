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
    private int akf;
    private Drawable eUe;
    private Drawable fkA;
    private Rect fkB;
    private boolean fkC;
    private boolean fkD;
    private boolean fkE;
    private boolean fkF;
    private TBSpecificationButtonConfig.a fkG;
    public Object fkx;
    private TBSpecificationButtonConfig fky;
    private Drawable fkz;
    private String text;
    private Paint textPaint;

    public TBSpecificationBtn(Context context) {
        super(context);
        this.fkx = null;
        this.text = "";
        this.fkB = new Rect();
        this.fkC = true;
        this.fkD = true;
        this.fkE = false;
        this.akf = 0;
        this.fkF = false;
        this.fkG = new TBSpecificationButtonConfig.a() { // from class: com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn.1
            @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig.a
            public void buy() {
                int width = TBSpecificationBtn.this.getWidth();
                if (width > 0 && TBSpecificationBtn.this.getLayoutParams().width == -2 && TBSpecificationBtn.this.getContentWidth() + TBSpecificationBtn.this.fky.fkQ + TBSpecificationBtn.this.fky.fkR != width) {
                    TBSpecificationBtn.this.requestLayout();
                }
            }

            @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig.a
            public void buz() {
                TBSpecificationBtn.this.bux();
                int width = TBSpecificationBtn.this.getWidth();
                if (width > 0 && TBSpecificationBtn.this.getLayoutParams().width == -2 && TBSpecificationBtn.this.getContentWidth() + TBSpecificationBtn.this.fky.fkQ + TBSpecificationBtn.this.fky.fkR != width) {
                    TBSpecificationBtn.this.requestLayout();
                } else {
                    TBSpecificationBtn.this.invalidate();
                }
            }

            @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig.a
            public void buA() {
                TBSpecificationBtn.this.pG(TBSpecificationBtn.this.akf);
                TBSpecificationBtn.this.invalidate();
            }
        };
        init();
    }

    public TBSpecificationBtn(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fkx = null;
        this.text = "";
        this.fkB = new Rect();
        this.fkC = true;
        this.fkD = true;
        this.fkE = false;
        this.akf = 0;
        this.fkF = false;
        this.fkG = new TBSpecificationButtonConfig.a() { // from class: com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn.1
            @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig.a
            public void buy() {
                int width = TBSpecificationBtn.this.getWidth();
                if (width > 0 && TBSpecificationBtn.this.getLayoutParams().width == -2 && TBSpecificationBtn.this.getContentWidth() + TBSpecificationBtn.this.fky.fkQ + TBSpecificationBtn.this.fky.fkR != width) {
                    TBSpecificationBtn.this.requestLayout();
                }
            }

            @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig.a
            public void buz() {
                TBSpecificationBtn.this.bux();
                int width = TBSpecificationBtn.this.getWidth();
                if (width > 0 && TBSpecificationBtn.this.getLayoutParams().width == -2 && TBSpecificationBtn.this.getContentWidth() + TBSpecificationBtn.this.fky.fkQ + TBSpecificationBtn.this.fky.fkR != width) {
                    TBSpecificationBtn.this.requestLayout();
                } else {
                    TBSpecificationBtn.this.invalidate();
                }
            }

            @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig.a
            public void buA() {
                TBSpecificationBtn.this.pG(TBSpecificationBtn.this.akf);
                TBSpecificationBtn.this.invalidate();
            }
        };
        init();
    }

    public TBSpecificationBtn(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fkx = null;
        this.text = "";
        this.fkB = new Rect();
        this.fkC = true;
        this.fkD = true;
        this.fkE = false;
        this.akf = 0;
        this.fkF = false;
        this.fkG = new TBSpecificationButtonConfig.a() { // from class: com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn.1
            @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig.a
            public void buy() {
                int width = TBSpecificationBtn.this.getWidth();
                if (width > 0 && TBSpecificationBtn.this.getLayoutParams().width == -2 && TBSpecificationBtn.this.getContentWidth() + TBSpecificationBtn.this.fky.fkQ + TBSpecificationBtn.this.fky.fkR != width) {
                    TBSpecificationBtn.this.requestLayout();
                }
            }

            @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig.a
            public void buz() {
                TBSpecificationBtn.this.bux();
                int width = TBSpecificationBtn.this.getWidth();
                if (width > 0 && TBSpecificationBtn.this.getLayoutParams().width == -2 && TBSpecificationBtn.this.getContentWidth() + TBSpecificationBtn.this.fky.fkQ + TBSpecificationBtn.this.fky.fkR != width) {
                    TBSpecificationBtn.this.requestLayout();
                } else {
                    TBSpecificationBtn.this.invalidate();
                }
            }

            @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig.a
            public void buA() {
                TBSpecificationBtn.this.pG(TBSpecificationBtn.this.akf);
                TBSpecificationBtn.this.invalidate();
            }
        };
        init();
    }

    private void init() {
        this.akf = TbadkCoreApplication.getInst().getSkinType();
        this.fky = new b();
        this.fky.fkW = this.fkG;
        this.textPaint = new Paint();
        this.textPaint.setTextSize(l.getDimens(getContext(), R.dimen.T_X08));
        this.textPaint.setAntiAlias(true);
    }

    public void setConfig(TBSpecificationButtonConfig tBSpecificationButtonConfig) {
        if (tBSpecificationButtonConfig != null) {
            this.fky = tBSpecificationButtonConfig;
            this.fky.fkW = this.fkG;
            this.fkC = true;
        }
    }

    public TBSpecificationButtonConfig getStyleConfig() {
        return this.fky;
    }

    public void setText(String str) {
        if (StringUtils.isNull(str)) {
            str = "";
        }
        this.text = str;
        this.textPaint.getTextBounds(str, 0, str.length(), this.fkB);
        int width = getWidth();
        if (width > 0) {
            if (getLayoutParams().width == -2) {
                if (getContentWidth() + this.fky.fkQ + this.fky.fkR != width) {
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
        this.textPaint.getTextBounds(this.text, 0, this.text.length(), this.fkB);
        int width = getWidth();
        if (width > 0 && getLayoutParams().width == -2 && getContentWidth() + this.fky.fkQ + this.fky.fkR != width) {
            requestLayout();
            return;
        }
        int height = getHeight();
        if (height > 0 && getLayoutParams().height == -2 && ((int) this.textPaint.getTextSize()) + (this.fky.fkS * 2) != height) {
            requestLayout();
        }
    }

    public void setClickState(boolean z) {
        this.fkD = z;
    }

    public void setUseDisableState(boolean z) {
        this.fkD = false;
        this.fkF = z;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int measureWidth = measureWidth(i);
        setMeasuredDimension(measureWidth, !this.fky.fkP ? measureHeight(i2) : measureWidth);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bux() {
        this.fkz = this.fky.buB();
        this.fkA = this.fky.buC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pG(int i) {
        if (getHeight() != 0) {
            this.fky.akf = i;
            this.eUe = this.fky.aj(getHeight() / 2);
            this.textPaint.setColor(this.fky.fkU ? ao.getColor(i, this.fky.fkJ) : this.fky.fkJ);
        }
    }

    private int measureWidth(int i) {
        float contentWidth = getContentWidth();
        if (View.MeasureSpec.getMode(i) == 1073741824) {
            return View.MeasureSpec.getSize(i);
        }
        return (int) Math.max(this.fky.minWidth, contentWidth + this.fky.fkQ + this.fky.fkR + getPaddingLeft() + getPaddingRight());
    }

    private int measureHeight(int i) {
        float textSize = this.textPaint.getTextSize();
        if (View.MeasureSpec.getMode(i) == 1073741824) {
            return View.MeasureSpec.getSize(i);
        }
        return (int) Math.max(this.fky.minHeight, textSize + (this.fky.fkS * 2) + getPaddingTop() + getPaddingBottom());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getContentWidth() {
        int i = 0;
        if (this.fky.fkM[0] > 0) {
            i = this.fky.iconSize;
            if (!StringUtils.isNull(this.text)) {
                i += this.fky.fkT;
            }
        }
        if (this.fky.fkM[1] > 0) {
            i = this.fky.iconSize;
            if (!StringUtils.isNull(this.text)) {
                i += this.fky.fkT;
            }
        }
        return i + this.fkB.width();
    }

    public void setTextHorizontalCenter(boolean z) {
        this.fkE = z;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int width;
        if (this.fkC) {
            pG(this.akf);
            bux();
            this.fkC = false;
        }
        if (this.eUe != null) {
            if (this.eUe instanceof GradientDrawable) {
                ((GradientDrawable) this.eUe).setCornerRadius(getHeight() / 2);
            }
            this.eUe.setBounds(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom());
            this.eUe.draw(canvas);
        }
        if (((getWidth() - getContentWidth()) - getPaddingRight()) - getPaddingLeft() == this.fky.fkQ + this.fky.fkR) {
            width = this.fky.fkQ;
        } else {
            width = ((((getWidth() - getContentWidth()) - getPaddingRight()) - getPaddingLeft()) / 2) + getPaddingLeft();
        }
        int height = (getHeight() + getPaddingTop()) / 2;
        int i = this.fky.iconSize / 2;
        if (this.fkz != null) {
            this.fkz.setBounds(width, height - i, this.fky.iconSize + width, height + i);
            this.fkz.draw(canvas);
            width += this.fky.iconSize + this.fky.fkT;
        }
        if (this.fkA != null) {
            this.fkA.setBounds(this.fky.fkT + width, height - i, this.fky.fkT + width + this.fky.iconSize, height + i);
            this.fkA.draw(canvas);
        }
        if (this.fkE) {
            width = (getWidth() - this.fkB.width()) / 2;
        }
        if (!StringUtils.isNull(this.text)) {
            this.textPaint.getTextBounds(this.text, 0, this.text.length(), this.fkB);
            canvas.drawText(this.text, width, (((getHeight() - getPaddingBottom()) + getPaddingTop()) / 2.0f) - this.fkB.centerY(), this.textPaint);
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
        if (!this.fkD) {
            if (this.fkF) {
                setAlpha(ao.eYz);
            } else {
                setAlpha(1.0f);
            }
        } else if (z2) {
            setAlpha(ao.eYz);
        } else if (z && isClickable()) {
            setAlpha(ao.eYy);
        } else {
            setAlpha(1.0f);
        }
        super.drawableStateChanged();
    }

    public void btV() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void changeSkinType(int i) {
        this.akf = i;
        this.fky.akf = i;
        bux();
        pG(i);
        invalidate();
    }
}
