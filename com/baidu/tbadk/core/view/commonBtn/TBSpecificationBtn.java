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
    public Object eTf;
    private TBSpecificationButtonConfig eTg;
    private Drawable eTh;
    private Drawable eTi;
    private Drawable eTj;
    private boolean eTk;
    private boolean eTl;
    private boolean eTm;
    private TBSpecificationButtonConfig.a eTn;
    private String text;
    private Paint textPaint;
    private int textWidth;

    public TBSpecificationBtn(Context context) {
        super(context);
        this.eTf = null;
        this.text = "";
        this.eTk = true;
        this.eTl = true;
        this.eTm = false;
        this.ajq = 0;
        this.eTn = new TBSpecificationButtonConfig.a() { // from class: com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn.1
            @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig.a
            public void bqH() {
                int width = TBSpecificationBtn.this.getWidth();
                if (width > 0 && TBSpecificationBtn.this.getLayoutParams().width == -2 && TBSpecificationBtn.this.getContentWidth() + TBSpecificationBtn.this.eTg.eTx + TBSpecificationBtn.this.eTg.eTy != width) {
                    TBSpecificationBtn.this.requestLayout();
                }
            }

            @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig.a
            public void bqI() {
                TBSpecificationBtn.this.bqG();
                int width = TBSpecificationBtn.this.getWidth();
                if (width > 0 && TBSpecificationBtn.this.getLayoutParams().width == -2 && TBSpecificationBtn.this.getContentWidth() + TBSpecificationBtn.this.eTg.eTx + TBSpecificationBtn.this.eTg.eTy != width) {
                    TBSpecificationBtn.this.requestLayout();
                } else {
                    TBSpecificationBtn.this.invalidate();
                }
            }

            @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig.a
            public void bqJ() {
                TBSpecificationBtn.this.pR(TBSpecificationBtn.this.ajq);
                TBSpecificationBtn.this.invalidate();
            }
        };
        init();
    }

    public TBSpecificationBtn(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eTf = null;
        this.text = "";
        this.eTk = true;
        this.eTl = true;
        this.eTm = false;
        this.ajq = 0;
        this.eTn = new TBSpecificationButtonConfig.a() { // from class: com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn.1
            @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig.a
            public void bqH() {
                int width = TBSpecificationBtn.this.getWidth();
                if (width > 0 && TBSpecificationBtn.this.getLayoutParams().width == -2 && TBSpecificationBtn.this.getContentWidth() + TBSpecificationBtn.this.eTg.eTx + TBSpecificationBtn.this.eTg.eTy != width) {
                    TBSpecificationBtn.this.requestLayout();
                }
            }

            @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig.a
            public void bqI() {
                TBSpecificationBtn.this.bqG();
                int width = TBSpecificationBtn.this.getWidth();
                if (width > 0 && TBSpecificationBtn.this.getLayoutParams().width == -2 && TBSpecificationBtn.this.getContentWidth() + TBSpecificationBtn.this.eTg.eTx + TBSpecificationBtn.this.eTg.eTy != width) {
                    TBSpecificationBtn.this.requestLayout();
                } else {
                    TBSpecificationBtn.this.invalidate();
                }
            }

            @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig.a
            public void bqJ() {
                TBSpecificationBtn.this.pR(TBSpecificationBtn.this.ajq);
                TBSpecificationBtn.this.invalidate();
            }
        };
        init();
    }

    public TBSpecificationBtn(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eTf = null;
        this.text = "";
        this.eTk = true;
        this.eTl = true;
        this.eTm = false;
        this.ajq = 0;
        this.eTn = new TBSpecificationButtonConfig.a() { // from class: com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn.1
            @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig.a
            public void bqH() {
                int width = TBSpecificationBtn.this.getWidth();
                if (width > 0 && TBSpecificationBtn.this.getLayoutParams().width == -2 && TBSpecificationBtn.this.getContentWidth() + TBSpecificationBtn.this.eTg.eTx + TBSpecificationBtn.this.eTg.eTy != width) {
                    TBSpecificationBtn.this.requestLayout();
                }
            }

            @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig.a
            public void bqI() {
                TBSpecificationBtn.this.bqG();
                int width = TBSpecificationBtn.this.getWidth();
                if (width > 0 && TBSpecificationBtn.this.getLayoutParams().width == -2 && TBSpecificationBtn.this.getContentWidth() + TBSpecificationBtn.this.eTg.eTx + TBSpecificationBtn.this.eTg.eTy != width) {
                    TBSpecificationBtn.this.requestLayout();
                } else {
                    TBSpecificationBtn.this.invalidate();
                }
            }

            @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig.a
            public void bqJ() {
                TBSpecificationBtn.this.pR(TBSpecificationBtn.this.ajq);
                TBSpecificationBtn.this.invalidate();
            }
        };
        init();
    }

    private void init() {
        this.ajq = TbadkCoreApplication.getInst().getSkinType();
        this.eTg = new b();
        this.eTg.eTD = this.eTn;
        this.textPaint = new Paint();
        this.textPaint.setTextSize(l.getDimens(getContext(), R.dimen.tbds36));
        this.textPaint.setAntiAlias(true);
    }

    public void setConfig(TBSpecificationButtonConfig tBSpecificationButtonConfig) {
        if (tBSpecificationButtonConfig != null) {
            this.eTg = tBSpecificationButtonConfig;
            this.eTg.eTD = this.eTn;
            this.eTk = true;
        }
    }

    public TBSpecificationButtonConfig getStyleConfig() {
        return this.eTg;
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
                if (getContentWidth() + this.eTg.eTx + this.eTg.eTy != width) {
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
        if (width > 0 && getLayoutParams().width == -2 && getContentWidth() + this.eTg.eTx + this.eTg.eTy != width) {
            requestLayout();
            return;
        }
        int height = getHeight();
        if (height > 0 && getLayoutParams().height == -2 && ((int) this.textPaint.getTextSize()) + (this.eTg.eTz * 2) != height) {
            requestLayout();
        }
    }

    public void setClickState(boolean z) {
        this.eTl = z;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int measureWidth = measureWidth(i);
        setMeasuredDimension(measureWidth, !this.eTg.eTw ? measureHeight(i2) : measureWidth);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqG() {
        this.eTi = this.eTg.bqK();
        this.eTj = this.eTg.bqL();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pR(int i) {
        if (getHeight() != 0) {
            this.eTg.ajq = i;
            this.eTh = this.eTg.ae(getHeight() / 2);
            this.textPaint.setColor(this.eTg.eTB ? ap.getColor(i, this.eTg.eTp) : this.eTg.eTp);
        }
    }

    private int measureWidth(int i) {
        float contentWidth = getContentWidth();
        if (View.MeasureSpec.getMode(i) == 1073741824) {
            return View.MeasureSpec.getSize(i);
        }
        return (int) Math.max(this.eTg.minWidth, contentWidth + this.eTg.eTx + this.eTg.eTy + getPaddingLeft() + getPaddingRight());
    }

    private int measureHeight(int i) {
        float textSize = this.textPaint.getTextSize();
        if (View.MeasureSpec.getMode(i) == 1073741824) {
            return View.MeasureSpec.getSize(i);
        }
        return (int) Math.max(this.eTg.minHeight, textSize + (this.eTg.eTz * 2) + getPaddingTop() + getPaddingBottom());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getContentWidth() {
        int i = 0;
        if (this.eTg.eTs[0] > 0) {
            i = this.eTg.eTu;
            if (!StringUtils.isNull(this.text)) {
                i += this.eTg.eTA;
            }
        }
        if (this.eTg.eTs[1] > 0) {
            i = this.eTg.eTu;
            if (!StringUtils.isNull(this.text)) {
                i += this.eTg.eTA;
            }
        }
        return i + this.textWidth;
    }

    public void setTextHorizontalCenter(boolean z) {
        this.eTm = z;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int width;
        if (this.eTk) {
            pR(this.ajq);
            bqG();
            this.eTk = false;
        }
        if (this.eTh != null) {
            if (this.eTh instanceof GradientDrawable) {
                ((GradientDrawable) this.eTh).setCornerRadius(getHeight() / 2);
            }
            this.eTh.setBounds(0, 0, getWidth(), getHeight());
            this.eTh.draw(canvas);
        }
        if (((getWidth() - getContentWidth()) - getPaddingRight()) - getPaddingLeft() == this.eTg.eTx + this.eTg.eTy) {
            width = this.eTg.eTx;
        } else {
            width = ((((getWidth() - getContentWidth()) - getPaddingRight()) - getPaddingLeft()) / 2) + getPaddingLeft();
        }
        int height = (getHeight() + getPaddingTop()) / 2;
        int i = this.eTg.eTu / 2;
        if (this.eTi != null) {
            this.eTi.setBounds(width, height - i, this.eTg.eTu + width, height + i);
            this.eTi.draw(canvas);
            width += this.eTg.eTu + this.eTg.eTA;
        }
        if (this.eTj != null) {
            this.eTj.setBounds(this.eTg.eTA + width, height - i, this.eTg.eTA + width + this.eTg.eTu, height + i);
            this.eTj.draw(canvas);
        }
        if (this.eTm) {
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
        if (!this.eTl) {
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

    public void bqd() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void changeSkinType(int i) {
        this.ajq = i;
        this.eTg.ajq = i;
        bqG();
        pR(i);
        invalidate();
    }
}
