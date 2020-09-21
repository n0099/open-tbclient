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
    private int aiX;
    public Object eyC;
    private TBSpecificationButtonConfig eyD;
    private Drawable eyE;
    private Drawable eyF;
    private Drawable eyG;
    private boolean eyH;
    private boolean eyI;
    private boolean eyJ;
    private TBSpecificationButtonConfig.a eyK;
    private String text;
    private Paint textPaint;
    private int textWidth;

    public TBSpecificationBtn(Context context) {
        super(context);
        this.eyC = null;
        this.text = "";
        this.eyH = true;
        this.eyI = true;
        this.eyJ = false;
        this.aiX = 0;
        this.eyK = new TBSpecificationButtonConfig.a() { // from class: com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn.1
            @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig.a
            public void bme() {
                int width = TBSpecificationBtn.this.getWidth();
                if (width > 0 && TBSpecificationBtn.this.getLayoutParams().width == -2 && TBSpecificationBtn.this.getContentWidth() + TBSpecificationBtn.this.eyD.eyU + TBSpecificationBtn.this.eyD.eyV != width) {
                    TBSpecificationBtn.this.requestLayout();
                }
            }

            @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig.a
            public void bmf() {
                TBSpecificationBtn.this.bmd();
                int width = TBSpecificationBtn.this.getWidth();
                if (width > 0 && TBSpecificationBtn.this.getLayoutParams().width == -2 && TBSpecificationBtn.this.getContentWidth() + TBSpecificationBtn.this.eyD.eyU + TBSpecificationBtn.this.eyD.eyV != width) {
                    TBSpecificationBtn.this.requestLayout();
                } else {
                    TBSpecificationBtn.this.invalidate();
                }
            }

            @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig.a
            public void bmg() {
                TBSpecificationBtn.this.ph(TBSpecificationBtn.this.aiX);
                TBSpecificationBtn.this.invalidate();
            }
        };
        init();
    }

    public TBSpecificationBtn(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eyC = null;
        this.text = "";
        this.eyH = true;
        this.eyI = true;
        this.eyJ = false;
        this.aiX = 0;
        this.eyK = new TBSpecificationButtonConfig.a() { // from class: com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn.1
            @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig.a
            public void bme() {
                int width = TBSpecificationBtn.this.getWidth();
                if (width > 0 && TBSpecificationBtn.this.getLayoutParams().width == -2 && TBSpecificationBtn.this.getContentWidth() + TBSpecificationBtn.this.eyD.eyU + TBSpecificationBtn.this.eyD.eyV != width) {
                    TBSpecificationBtn.this.requestLayout();
                }
            }

            @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig.a
            public void bmf() {
                TBSpecificationBtn.this.bmd();
                int width = TBSpecificationBtn.this.getWidth();
                if (width > 0 && TBSpecificationBtn.this.getLayoutParams().width == -2 && TBSpecificationBtn.this.getContentWidth() + TBSpecificationBtn.this.eyD.eyU + TBSpecificationBtn.this.eyD.eyV != width) {
                    TBSpecificationBtn.this.requestLayout();
                } else {
                    TBSpecificationBtn.this.invalidate();
                }
            }

            @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig.a
            public void bmg() {
                TBSpecificationBtn.this.ph(TBSpecificationBtn.this.aiX);
                TBSpecificationBtn.this.invalidate();
            }
        };
        init();
    }

    public TBSpecificationBtn(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eyC = null;
        this.text = "";
        this.eyH = true;
        this.eyI = true;
        this.eyJ = false;
        this.aiX = 0;
        this.eyK = new TBSpecificationButtonConfig.a() { // from class: com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn.1
            @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig.a
            public void bme() {
                int width = TBSpecificationBtn.this.getWidth();
                if (width > 0 && TBSpecificationBtn.this.getLayoutParams().width == -2 && TBSpecificationBtn.this.getContentWidth() + TBSpecificationBtn.this.eyD.eyU + TBSpecificationBtn.this.eyD.eyV != width) {
                    TBSpecificationBtn.this.requestLayout();
                }
            }

            @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig.a
            public void bmf() {
                TBSpecificationBtn.this.bmd();
                int width = TBSpecificationBtn.this.getWidth();
                if (width > 0 && TBSpecificationBtn.this.getLayoutParams().width == -2 && TBSpecificationBtn.this.getContentWidth() + TBSpecificationBtn.this.eyD.eyU + TBSpecificationBtn.this.eyD.eyV != width) {
                    TBSpecificationBtn.this.requestLayout();
                } else {
                    TBSpecificationBtn.this.invalidate();
                }
            }

            @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig.a
            public void bmg() {
                TBSpecificationBtn.this.ph(TBSpecificationBtn.this.aiX);
                TBSpecificationBtn.this.invalidate();
            }
        };
        init();
    }

    private void init() {
        this.aiX = TbadkCoreApplication.getInst().getSkinType();
        this.eyD = new b();
        this.eyD.eza = this.eyK;
        this.textPaint = new Paint();
        this.textPaint.setTextSize(l.getDimens(getContext(), R.dimen.tbds36));
        this.textPaint.setAntiAlias(true);
    }

    public void setConfig(TBSpecificationButtonConfig tBSpecificationButtonConfig) {
        if (tBSpecificationButtonConfig != null) {
            this.eyD = tBSpecificationButtonConfig;
            this.eyD.eza = this.eyK;
            this.eyH = true;
        }
    }

    public TBSpecificationButtonConfig getStyleConfig() {
        return this.eyD;
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
                if (getContentWidth() + this.eyD.eyU + this.eyD.eyV != width) {
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
        if (width > 0 && getLayoutParams().width == -2 && getContentWidth() + this.eyD.eyU + this.eyD.eyV != width) {
            requestLayout();
            return;
        }
        int height = getHeight();
        if (height > 0 && getLayoutParams().height == -2 && ((int) this.textPaint.getTextSize()) + (this.eyD.eyW * 2) != height) {
            requestLayout();
        }
    }

    public void setClickState(boolean z) {
        this.eyI = z;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int measureWidth = measureWidth(i);
        setMeasuredDimension(measureWidth, !this.eyD.eyT ? measureHeight(i2) : measureWidth);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmd() {
        this.eyF = this.eyD.bmh();
        this.eyG = this.eyD.bmi();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ph(int i) {
        if (getHeight() != 0) {
            this.eyD.aiX = i;
            this.eyE = this.eyD.aa(getHeight() / 2);
            this.textPaint.setColor(this.eyD.eyY ? ap.getColor(i, this.eyD.eyM) : this.eyD.eyM);
        }
    }

    private int measureWidth(int i) {
        float contentWidth = getContentWidth();
        if (View.MeasureSpec.getMode(i) == 1073741824) {
            return View.MeasureSpec.getSize(i);
        }
        return (int) Math.max(this.eyD.minWidth, contentWidth + this.eyD.eyU + this.eyD.eyV + getPaddingLeft() + getPaddingRight());
    }

    private int measureHeight(int i) {
        float textSize = this.textPaint.getTextSize();
        if (View.MeasureSpec.getMode(i) == 1073741824) {
            return View.MeasureSpec.getSize(i);
        }
        return (int) Math.max(this.eyD.minHeight, textSize + (this.eyD.eyW * 2) + getPaddingTop() + getPaddingBottom());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getContentWidth() {
        int i = 0;
        if (this.eyD.eyP[0] > 0) {
            i = this.eyD.eyR;
            if (!StringUtils.isNull(this.text)) {
                i += this.eyD.eyX;
            }
        }
        if (this.eyD.eyP[1] > 0) {
            i = this.eyD.eyR;
            if (!StringUtils.isNull(this.text)) {
                i += this.eyD.eyX;
            }
        }
        return i + this.textWidth;
    }

    public void setTextHorizontalCenter(boolean z) {
        this.eyJ = z;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int width;
        if (this.eyH) {
            ph(this.aiX);
            bmd();
            this.eyH = false;
        }
        if (this.eyE != null) {
            if (this.eyE instanceof GradientDrawable) {
                ((GradientDrawable) this.eyE).setCornerRadius(getHeight() / 2);
            }
            this.eyE.setBounds(0, 0, getWidth(), getHeight());
            this.eyE.draw(canvas);
        }
        if (((getWidth() - getContentWidth()) - getPaddingRight()) - getPaddingLeft() == this.eyD.eyU + this.eyD.eyV) {
            width = this.eyD.eyU;
        } else {
            width = ((((getWidth() - getContentWidth()) - getPaddingRight()) - getPaddingLeft()) / 2) + getPaddingLeft();
        }
        int height = (getHeight() + getPaddingTop()) / 2;
        int i = this.eyD.eyR / 2;
        if (this.eyF != null) {
            this.eyF.setBounds(width, height - i, this.eyD.eyR + width, height + i);
            this.eyF.draw(canvas);
            width += this.eyD.eyR + this.eyD.eyX;
        }
        if (this.eyG != null) {
            this.eyG.setBounds(this.eyD.eyX + width, height - i, this.eyD.eyX + width + this.eyD.eyR, height + i);
            this.eyG.draw(canvas);
        }
        if (this.eyJ) {
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
        if (!this.eyI) {
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

    public void blA() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void changeSkinType(int i) {
        this.aiX = i;
        this.eyD.aiX = i;
        bmd();
        ph(i);
        invalidate();
    }
}
