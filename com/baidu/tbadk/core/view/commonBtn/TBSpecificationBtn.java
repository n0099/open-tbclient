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
/* loaded from: classes2.dex */
public class TBSpecificationBtn extends View {
    private int aiB;
    public Object ewr;
    private TBSpecificationButtonConfig ews;
    private Drawable ewt;
    private Drawable ewu;
    private Drawable ewv;
    private boolean eww;
    private boolean ewx;
    private boolean ewy;
    private TBSpecificationButtonConfig.a ewz;
    private String text;
    private Paint textPaint;
    private int textWidth;

    public TBSpecificationBtn(Context context) {
        super(context);
        this.ewr = null;
        this.text = "";
        this.eww = true;
        this.ewx = true;
        this.ewy = false;
        this.aiB = 0;
        this.ewz = new TBSpecificationButtonConfig.a() { // from class: com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn.1
            @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig.a
            public void blj() {
                int width = TBSpecificationBtn.this.getWidth();
                if (width > 0 && TBSpecificationBtn.this.getLayoutParams().width == -2 && TBSpecificationBtn.this.getContentWidth() + TBSpecificationBtn.this.ews.ewJ + TBSpecificationBtn.this.ews.ewK != width) {
                    TBSpecificationBtn.this.requestLayout();
                }
            }

            @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig.a
            public void blk() {
                TBSpecificationBtn.this.bli();
                int width = TBSpecificationBtn.this.getWidth();
                if (width > 0 && TBSpecificationBtn.this.getLayoutParams().width == -2 && TBSpecificationBtn.this.getContentWidth() + TBSpecificationBtn.this.ews.ewJ + TBSpecificationBtn.this.ews.ewK != width) {
                    TBSpecificationBtn.this.requestLayout();
                } else {
                    TBSpecificationBtn.this.invalidate();
                }
            }

            @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig.a
            public void bll() {
                TBSpecificationBtn.this.oV(TBSpecificationBtn.this.aiB);
                TBSpecificationBtn.this.invalidate();
            }
        };
        init();
    }

    public TBSpecificationBtn(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ewr = null;
        this.text = "";
        this.eww = true;
        this.ewx = true;
        this.ewy = false;
        this.aiB = 0;
        this.ewz = new TBSpecificationButtonConfig.a() { // from class: com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn.1
            @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig.a
            public void blj() {
                int width = TBSpecificationBtn.this.getWidth();
                if (width > 0 && TBSpecificationBtn.this.getLayoutParams().width == -2 && TBSpecificationBtn.this.getContentWidth() + TBSpecificationBtn.this.ews.ewJ + TBSpecificationBtn.this.ews.ewK != width) {
                    TBSpecificationBtn.this.requestLayout();
                }
            }

            @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig.a
            public void blk() {
                TBSpecificationBtn.this.bli();
                int width = TBSpecificationBtn.this.getWidth();
                if (width > 0 && TBSpecificationBtn.this.getLayoutParams().width == -2 && TBSpecificationBtn.this.getContentWidth() + TBSpecificationBtn.this.ews.ewJ + TBSpecificationBtn.this.ews.ewK != width) {
                    TBSpecificationBtn.this.requestLayout();
                } else {
                    TBSpecificationBtn.this.invalidate();
                }
            }

            @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig.a
            public void bll() {
                TBSpecificationBtn.this.oV(TBSpecificationBtn.this.aiB);
                TBSpecificationBtn.this.invalidate();
            }
        };
        init();
    }

    public TBSpecificationBtn(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ewr = null;
        this.text = "";
        this.eww = true;
        this.ewx = true;
        this.ewy = false;
        this.aiB = 0;
        this.ewz = new TBSpecificationButtonConfig.a() { // from class: com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn.1
            @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig.a
            public void blj() {
                int width = TBSpecificationBtn.this.getWidth();
                if (width > 0 && TBSpecificationBtn.this.getLayoutParams().width == -2 && TBSpecificationBtn.this.getContentWidth() + TBSpecificationBtn.this.ews.ewJ + TBSpecificationBtn.this.ews.ewK != width) {
                    TBSpecificationBtn.this.requestLayout();
                }
            }

            @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig.a
            public void blk() {
                TBSpecificationBtn.this.bli();
                int width = TBSpecificationBtn.this.getWidth();
                if (width > 0 && TBSpecificationBtn.this.getLayoutParams().width == -2 && TBSpecificationBtn.this.getContentWidth() + TBSpecificationBtn.this.ews.ewJ + TBSpecificationBtn.this.ews.ewK != width) {
                    TBSpecificationBtn.this.requestLayout();
                } else {
                    TBSpecificationBtn.this.invalidate();
                }
            }

            @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig.a
            public void bll() {
                TBSpecificationBtn.this.oV(TBSpecificationBtn.this.aiB);
                TBSpecificationBtn.this.invalidate();
            }
        };
        init();
    }

    private void init() {
        this.aiB = TbadkCoreApplication.getInst().getSkinType();
        this.ews = new b();
        this.ews.ewP = this.ewz;
        this.textPaint = new Paint();
        this.textPaint.setTextSize(l.getDimens(getContext(), R.dimen.tbds36));
        this.textPaint.setAntiAlias(true);
    }

    public void setConfig(TBSpecificationButtonConfig tBSpecificationButtonConfig) {
        if (tBSpecificationButtonConfig != null) {
            this.ews = tBSpecificationButtonConfig;
            this.ews.ewP = this.ewz;
            this.eww = true;
        }
    }

    public TBSpecificationButtonConfig getStyleConfig() {
        return this.ews;
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
                if (getContentWidth() + this.ews.ewJ + this.ews.ewK != width) {
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
        if (width > 0 && getLayoutParams().width == -2 && getContentWidth() + this.ews.ewJ + this.ews.ewK != width) {
            requestLayout();
            return;
        }
        int height = getHeight();
        if (height > 0 && getLayoutParams().height == -2 && ((int) this.textPaint.getTextSize()) + (this.ews.ewL * 2) != height) {
            requestLayout();
        }
    }

    public void setClickState(boolean z) {
        this.ewx = z;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int measureWidth = measureWidth(i);
        setMeasuredDimension(measureWidth, !this.ews.ewI ? measureHeight(i2) : measureWidth);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bli() {
        this.ewu = this.ews.blm();
        this.ewv = this.ews.bln();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oV(int i) {
        if (getHeight() != 0) {
            this.ews.aiB = i;
            this.ewt = this.ews.aa(getHeight() / 2);
            this.textPaint.setColor(this.ews.ewN ? ap.getColor(i, this.ews.ewB) : this.ews.ewB);
        }
    }

    private int measureWidth(int i) {
        float contentWidth = getContentWidth();
        if (View.MeasureSpec.getMode(i) == 1073741824) {
            return View.MeasureSpec.getSize(i);
        }
        return (int) Math.max(this.ews.minWidth, contentWidth + this.ews.ewJ + this.ews.ewK + getPaddingLeft() + getPaddingRight());
    }

    private int measureHeight(int i) {
        float textSize = this.textPaint.getTextSize();
        if (View.MeasureSpec.getMode(i) == 1073741824) {
            return View.MeasureSpec.getSize(i);
        }
        return (int) Math.max(this.ews.minHeight, textSize + (this.ews.ewL * 2) + getPaddingTop() + getPaddingBottom());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getContentWidth() {
        int i = 0;
        if (this.ews.ewE[0] > 0) {
            i = this.ews.ewG;
            if (!StringUtils.isNull(this.text)) {
                i += this.ews.ewM;
            }
        }
        if (this.ews.ewE[1] > 0) {
            i = this.ews.ewG;
            if (!StringUtils.isNull(this.text)) {
                i += this.ews.ewM;
            }
        }
        return i + this.textWidth;
    }

    public void setTextHorizontalCenter(boolean z) {
        this.ewy = z;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int width;
        if (this.eww) {
            oV(this.aiB);
            bli();
            this.eww = false;
        }
        if (this.ewt != null) {
            if (this.ewt instanceof GradientDrawable) {
                ((GradientDrawable) this.ewt).setCornerRadius(getHeight() / 2);
            }
            this.ewt.setBounds(0, 0, getWidth(), getHeight());
            this.ewt.draw(canvas);
        }
        if (((getWidth() - getContentWidth()) - getPaddingRight()) - getPaddingLeft() == this.ews.ewJ + this.ews.ewK) {
            width = this.ews.ewJ;
        } else {
            width = ((((getWidth() - getContentWidth()) - getPaddingRight()) - getPaddingLeft()) / 2) + getPaddingLeft();
        }
        int height = (getHeight() + getPaddingTop()) / 2;
        int i = this.ews.ewG / 2;
        if (this.ewu != null) {
            this.ewu.setBounds(width, height - i, this.ews.ewG + width, height + i);
            this.ewu.draw(canvas);
            width += this.ews.ewG + this.ews.ewM;
        }
        if (this.ewv != null) {
            this.ewv.setBounds(this.ews.ewM + width, height - i, this.ews.ewM + width + this.ews.ewG, height + i);
            this.ewv.draw(canvas);
        }
        if (this.ewy) {
            width = (getWidth() - this.textWidth) / 2;
        }
        if (!StringUtils.isNull(this.text)) {
            Paint.FontMetrics fontMetrics = this.textPaint.getFontMetrics();
            canvas.drawText(this.text, width, ((((getHeight() - getPaddingBottom()) + getPaddingTop()) + this.textPaint.getTextSize()) / 2.0f) - (fontMetrics.ascent - fontMetrics.top), this.textPaint);
        }
    }

    @Override // android.view.View
    protected void drawableStateChanged() {
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
        if (!this.ewx) {
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

    public void bkF() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void changeSkinType(int i) {
        this.aiB = i;
        this.ews.aiB = i;
        bli();
        oV(i);
        invalidate();
    }
}
