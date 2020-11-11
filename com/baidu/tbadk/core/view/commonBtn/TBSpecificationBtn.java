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
    private int ajq;
    public Object eYU;
    private TBSpecificationButtonConfig eYV;
    private Drawable eYW;
    private Drawable eYX;
    private Drawable eYY;
    private boolean eYZ;
    private boolean eZa;
    private boolean eZb;
    private TBSpecificationButtonConfig.a eZc;
    private String text;
    private Paint textPaint;
    private int textWidth;

    public TBSpecificationBtn(Context context) {
        super(context);
        this.eYU = null;
        this.text = "";
        this.eYZ = true;
        this.eZa = true;
        this.eZb = false;
        this.ajq = 0;
        this.eZc = new TBSpecificationButtonConfig.a() { // from class: com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn.1
            @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig.a
            public void bth() {
                int width = TBSpecificationBtn.this.getWidth();
                if (width > 0 && TBSpecificationBtn.this.getLayoutParams().width == -2 && TBSpecificationBtn.this.getContentWidth() + TBSpecificationBtn.this.eYV.eZm + TBSpecificationBtn.this.eYV.eZn != width) {
                    TBSpecificationBtn.this.requestLayout();
                }
            }

            @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig.a
            public void bti() {
                TBSpecificationBtn.this.btg();
                int width = TBSpecificationBtn.this.getWidth();
                if (width > 0 && TBSpecificationBtn.this.getLayoutParams().width == -2 && TBSpecificationBtn.this.getContentWidth() + TBSpecificationBtn.this.eYV.eZm + TBSpecificationBtn.this.eYV.eZn != width) {
                    TBSpecificationBtn.this.requestLayout();
                } else {
                    TBSpecificationBtn.this.invalidate();
                }
            }

            @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig.a
            public void btj() {
                TBSpecificationBtn.this.qb(TBSpecificationBtn.this.ajq);
                TBSpecificationBtn.this.invalidate();
            }
        };
        init();
    }

    public TBSpecificationBtn(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eYU = null;
        this.text = "";
        this.eYZ = true;
        this.eZa = true;
        this.eZb = false;
        this.ajq = 0;
        this.eZc = new TBSpecificationButtonConfig.a() { // from class: com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn.1
            @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig.a
            public void bth() {
                int width = TBSpecificationBtn.this.getWidth();
                if (width > 0 && TBSpecificationBtn.this.getLayoutParams().width == -2 && TBSpecificationBtn.this.getContentWidth() + TBSpecificationBtn.this.eYV.eZm + TBSpecificationBtn.this.eYV.eZn != width) {
                    TBSpecificationBtn.this.requestLayout();
                }
            }

            @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig.a
            public void bti() {
                TBSpecificationBtn.this.btg();
                int width = TBSpecificationBtn.this.getWidth();
                if (width > 0 && TBSpecificationBtn.this.getLayoutParams().width == -2 && TBSpecificationBtn.this.getContentWidth() + TBSpecificationBtn.this.eYV.eZm + TBSpecificationBtn.this.eYV.eZn != width) {
                    TBSpecificationBtn.this.requestLayout();
                } else {
                    TBSpecificationBtn.this.invalidate();
                }
            }

            @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig.a
            public void btj() {
                TBSpecificationBtn.this.qb(TBSpecificationBtn.this.ajq);
                TBSpecificationBtn.this.invalidate();
            }
        };
        init();
    }

    public TBSpecificationBtn(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eYU = null;
        this.text = "";
        this.eYZ = true;
        this.eZa = true;
        this.eZb = false;
        this.ajq = 0;
        this.eZc = new TBSpecificationButtonConfig.a() { // from class: com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn.1
            @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig.a
            public void bth() {
                int width = TBSpecificationBtn.this.getWidth();
                if (width > 0 && TBSpecificationBtn.this.getLayoutParams().width == -2 && TBSpecificationBtn.this.getContentWidth() + TBSpecificationBtn.this.eYV.eZm + TBSpecificationBtn.this.eYV.eZn != width) {
                    TBSpecificationBtn.this.requestLayout();
                }
            }

            @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig.a
            public void bti() {
                TBSpecificationBtn.this.btg();
                int width = TBSpecificationBtn.this.getWidth();
                if (width > 0 && TBSpecificationBtn.this.getLayoutParams().width == -2 && TBSpecificationBtn.this.getContentWidth() + TBSpecificationBtn.this.eYV.eZm + TBSpecificationBtn.this.eYV.eZn != width) {
                    TBSpecificationBtn.this.requestLayout();
                } else {
                    TBSpecificationBtn.this.invalidate();
                }
            }

            @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig.a
            public void btj() {
                TBSpecificationBtn.this.qb(TBSpecificationBtn.this.ajq);
                TBSpecificationBtn.this.invalidate();
            }
        };
        init();
    }

    private void init() {
        this.ajq = TbadkCoreApplication.getInst().getSkinType();
        this.eYV = new b();
        this.eYV.eZs = this.eZc;
        this.textPaint = new Paint();
        this.textPaint.setTextSize(l.getDimens(getContext(), R.dimen.tbds36));
        this.textPaint.setAntiAlias(true);
    }

    public void setConfig(TBSpecificationButtonConfig tBSpecificationButtonConfig) {
        if (tBSpecificationButtonConfig != null) {
            this.eYV = tBSpecificationButtonConfig;
            this.eYV.eZs = this.eZc;
            this.eYZ = true;
        }
    }

    public TBSpecificationButtonConfig getStyleConfig() {
        return this.eYV;
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
                if (getContentWidth() + this.eYV.eZm + this.eYV.eZn != width) {
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
        if (width > 0 && getLayoutParams().width == -2 && getContentWidth() + this.eYV.eZm + this.eYV.eZn != width) {
            requestLayout();
            return;
        }
        int height = getHeight();
        if (height > 0 && getLayoutParams().height == -2 && ((int) this.textPaint.getTextSize()) + (this.eYV.eZo * 2) != height) {
            requestLayout();
        }
    }

    public void setClickState(boolean z) {
        this.eZa = z;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int measureWidth = measureWidth(i);
        setMeasuredDimension(measureWidth, !this.eYV.eZl ? measureHeight(i2) : measureWidth);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btg() {
        this.eYX = this.eYV.btk();
        this.eYY = this.eYV.btl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qb(int i) {
        if (getHeight() != 0) {
            this.eYV.ajq = i;
            this.eYW = this.eYV.ag(getHeight() / 2);
            this.textPaint.setColor(this.eYV.eZq ? ap.getColor(i, this.eYV.eZe) : this.eYV.eZe);
        }
    }

    private int measureWidth(int i) {
        float contentWidth = getContentWidth();
        if (View.MeasureSpec.getMode(i) == 1073741824) {
            return View.MeasureSpec.getSize(i);
        }
        return (int) Math.max(this.eYV.minWidth, contentWidth + this.eYV.eZm + this.eYV.eZn + getPaddingLeft() + getPaddingRight());
    }

    private int measureHeight(int i) {
        float textSize = this.textPaint.getTextSize();
        if (View.MeasureSpec.getMode(i) == 1073741824) {
            return View.MeasureSpec.getSize(i);
        }
        return (int) Math.max(this.eYV.minHeight, textSize + (this.eYV.eZo * 2) + getPaddingTop() + getPaddingBottom());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getContentWidth() {
        int i = 0;
        if (this.eYV.eZh[0] > 0) {
            i = this.eYV.eZj;
            if (!StringUtils.isNull(this.text)) {
                i += this.eYV.eZp;
            }
        }
        if (this.eYV.eZh[1] > 0) {
            i = this.eYV.eZj;
            if (!StringUtils.isNull(this.text)) {
                i += this.eYV.eZp;
            }
        }
        return i + this.textWidth;
    }

    public void setTextHorizontalCenter(boolean z) {
        this.eZb = z;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int width;
        if (this.eYZ) {
            qb(this.ajq);
            btg();
            this.eYZ = false;
        }
        if (this.eYW != null) {
            if (this.eYW instanceof GradientDrawable) {
                ((GradientDrawable) this.eYW).setCornerRadius(getHeight() / 2);
            }
            this.eYW.setBounds(0, 0, getWidth(), getHeight());
            this.eYW.draw(canvas);
        }
        if (((getWidth() - getContentWidth()) - getPaddingRight()) - getPaddingLeft() == this.eYV.eZm + this.eYV.eZn) {
            width = this.eYV.eZm;
        } else {
            width = ((((getWidth() - getContentWidth()) - getPaddingRight()) - getPaddingLeft()) / 2) + getPaddingLeft();
        }
        int height = (getHeight() + getPaddingTop()) / 2;
        int i = this.eYV.eZj / 2;
        if (this.eYX != null) {
            this.eYX.setBounds(width, height - i, this.eYV.eZj + width, height + i);
            this.eYX.draw(canvas);
            width += this.eYV.eZj + this.eYV.eZp;
        }
        if (this.eYY != null) {
            this.eYY.setBounds(this.eYV.eZp + width, height - i, this.eYV.eZp + width + this.eYV.eZj, height + i);
            this.eYY.draw(canvas);
        }
        if (this.eZb) {
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
        if (!this.eZa) {
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

    public void bsD() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void changeSkinType(int i) {
        this.ajq = i;
        this.eYV.ajq = i;
        btg();
        qb(i);
        invalidate();
    }
}
