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
    private int aiD;
    private boolean ewA;
    private boolean ewB;
    private boolean ewC;
    private TBSpecificationButtonConfig.a ewD;
    public Object ewv;
    private TBSpecificationButtonConfig eww;
    private Drawable ewx;
    private Drawable ewy;
    private Drawable ewz;
    private String text;
    private Paint textPaint;
    private int textWidth;

    public TBSpecificationBtn(Context context) {
        super(context);
        this.ewv = null;
        this.text = "";
        this.ewA = true;
        this.ewB = true;
        this.ewC = false;
        this.aiD = 0;
        this.ewD = new TBSpecificationButtonConfig.a() { // from class: com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn.1
            @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig.a
            public void blj() {
                int width = TBSpecificationBtn.this.getWidth();
                if (width > 0 && TBSpecificationBtn.this.getLayoutParams().width == -2 && TBSpecificationBtn.this.getContentWidth() + TBSpecificationBtn.this.eww.ewN + TBSpecificationBtn.this.eww.ewO != width) {
                    TBSpecificationBtn.this.requestLayout();
                }
            }

            @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig.a
            public void blk() {
                TBSpecificationBtn.this.bli();
                int width = TBSpecificationBtn.this.getWidth();
                if (width > 0 && TBSpecificationBtn.this.getLayoutParams().width == -2 && TBSpecificationBtn.this.getContentWidth() + TBSpecificationBtn.this.eww.ewN + TBSpecificationBtn.this.eww.ewO != width) {
                    TBSpecificationBtn.this.requestLayout();
                } else {
                    TBSpecificationBtn.this.invalidate();
                }
            }

            @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig.a
            public void bll() {
                TBSpecificationBtn.this.oV(TBSpecificationBtn.this.aiD);
                TBSpecificationBtn.this.invalidate();
            }
        };
        init();
    }

    public TBSpecificationBtn(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ewv = null;
        this.text = "";
        this.ewA = true;
        this.ewB = true;
        this.ewC = false;
        this.aiD = 0;
        this.ewD = new TBSpecificationButtonConfig.a() { // from class: com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn.1
            @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig.a
            public void blj() {
                int width = TBSpecificationBtn.this.getWidth();
                if (width > 0 && TBSpecificationBtn.this.getLayoutParams().width == -2 && TBSpecificationBtn.this.getContentWidth() + TBSpecificationBtn.this.eww.ewN + TBSpecificationBtn.this.eww.ewO != width) {
                    TBSpecificationBtn.this.requestLayout();
                }
            }

            @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig.a
            public void blk() {
                TBSpecificationBtn.this.bli();
                int width = TBSpecificationBtn.this.getWidth();
                if (width > 0 && TBSpecificationBtn.this.getLayoutParams().width == -2 && TBSpecificationBtn.this.getContentWidth() + TBSpecificationBtn.this.eww.ewN + TBSpecificationBtn.this.eww.ewO != width) {
                    TBSpecificationBtn.this.requestLayout();
                } else {
                    TBSpecificationBtn.this.invalidate();
                }
            }

            @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig.a
            public void bll() {
                TBSpecificationBtn.this.oV(TBSpecificationBtn.this.aiD);
                TBSpecificationBtn.this.invalidate();
            }
        };
        init();
    }

    public TBSpecificationBtn(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ewv = null;
        this.text = "";
        this.ewA = true;
        this.ewB = true;
        this.ewC = false;
        this.aiD = 0;
        this.ewD = new TBSpecificationButtonConfig.a() { // from class: com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn.1
            @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig.a
            public void blj() {
                int width = TBSpecificationBtn.this.getWidth();
                if (width > 0 && TBSpecificationBtn.this.getLayoutParams().width == -2 && TBSpecificationBtn.this.getContentWidth() + TBSpecificationBtn.this.eww.ewN + TBSpecificationBtn.this.eww.ewO != width) {
                    TBSpecificationBtn.this.requestLayout();
                }
            }

            @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig.a
            public void blk() {
                TBSpecificationBtn.this.bli();
                int width = TBSpecificationBtn.this.getWidth();
                if (width > 0 && TBSpecificationBtn.this.getLayoutParams().width == -2 && TBSpecificationBtn.this.getContentWidth() + TBSpecificationBtn.this.eww.ewN + TBSpecificationBtn.this.eww.ewO != width) {
                    TBSpecificationBtn.this.requestLayout();
                } else {
                    TBSpecificationBtn.this.invalidate();
                }
            }

            @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig.a
            public void bll() {
                TBSpecificationBtn.this.oV(TBSpecificationBtn.this.aiD);
                TBSpecificationBtn.this.invalidate();
            }
        };
        init();
    }

    private void init() {
        this.aiD = TbadkCoreApplication.getInst().getSkinType();
        this.eww = new b();
        this.eww.ewT = this.ewD;
        this.textPaint = new Paint();
        this.textPaint.setTextSize(l.getDimens(getContext(), R.dimen.tbds36));
        this.textPaint.setAntiAlias(true);
    }

    public void setConfig(TBSpecificationButtonConfig tBSpecificationButtonConfig) {
        if (tBSpecificationButtonConfig != null) {
            this.eww = tBSpecificationButtonConfig;
            this.eww.ewT = this.ewD;
            this.ewA = true;
        }
    }

    public TBSpecificationButtonConfig getStyleConfig() {
        return this.eww;
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
                if (getContentWidth() + this.eww.ewN + this.eww.ewO != width) {
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
        if (width > 0 && getLayoutParams().width == -2 && getContentWidth() + this.eww.ewN + this.eww.ewO != width) {
            requestLayout();
            return;
        }
        int height = getHeight();
        if (height > 0 && getLayoutParams().height == -2 && ((int) this.textPaint.getTextSize()) + (this.eww.ewP * 2) != height) {
            requestLayout();
        }
    }

    public void setClickState(boolean z) {
        this.ewB = z;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int measureWidth = measureWidth(i);
        setMeasuredDimension(measureWidth, !this.eww.ewM ? measureHeight(i2) : measureWidth);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bli() {
        this.ewy = this.eww.blm();
        this.ewz = this.eww.bln();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oV(int i) {
        if (getHeight() != 0) {
            this.eww.aiD = i;
            this.ewx = this.eww.aa(getHeight() / 2);
            this.textPaint.setColor(this.eww.ewR ? ap.getColor(i, this.eww.ewF) : this.eww.ewF);
        }
    }

    private int measureWidth(int i) {
        float contentWidth = getContentWidth();
        if (View.MeasureSpec.getMode(i) == 1073741824) {
            return View.MeasureSpec.getSize(i);
        }
        return (int) Math.max(this.eww.minWidth, contentWidth + this.eww.ewN + this.eww.ewO + getPaddingLeft() + getPaddingRight());
    }

    private int measureHeight(int i) {
        float textSize = this.textPaint.getTextSize();
        if (View.MeasureSpec.getMode(i) == 1073741824) {
            return View.MeasureSpec.getSize(i);
        }
        return (int) Math.max(this.eww.minHeight, textSize + (this.eww.ewP * 2) + getPaddingTop() + getPaddingBottom());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getContentWidth() {
        int i = 0;
        if (this.eww.ewI[0] > 0) {
            i = this.eww.ewK;
            if (!StringUtils.isNull(this.text)) {
                i += this.eww.ewQ;
            }
        }
        if (this.eww.ewI[1] > 0) {
            i = this.eww.ewK;
            if (!StringUtils.isNull(this.text)) {
                i += this.eww.ewQ;
            }
        }
        return i + this.textWidth;
    }

    public void setTextHorizontalCenter(boolean z) {
        this.ewC = z;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int width;
        if (this.ewA) {
            oV(this.aiD);
            bli();
            this.ewA = false;
        }
        if (this.ewx != null) {
            if (this.ewx instanceof GradientDrawable) {
                ((GradientDrawable) this.ewx).setCornerRadius(getHeight() / 2);
            }
            this.ewx.setBounds(0, 0, getWidth(), getHeight());
            this.ewx.draw(canvas);
        }
        if (((getWidth() - getContentWidth()) - getPaddingRight()) - getPaddingLeft() == this.eww.ewN + this.eww.ewO) {
            width = this.eww.ewN;
        } else {
            width = ((((getWidth() - getContentWidth()) - getPaddingRight()) - getPaddingLeft()) / 2) + getPaddingLeft();
        }
        int height = (getHeight() + getPaddingTop()) / 2;
        int i = this.eww.ewK / 2;
        if (this.ewy != null) {
            this.ewy.setBounds(width, height - i, this.eww.ewK + width, height + i);
            this.ewy.draw(canvas);
            width += this.eww.ewK + this.eww.ewQ;
        }
        if (this.ewz != null) {
            this.ewz.setBounds(this.eww.ewQ + width, height - i, this.eww.ewQ + width + this.eww.ewK, height + i);
            this.ewz.draw(canvas);
        }
        if (this.ewC) {
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
        if (!this.ewB) {
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
        this.aiD = i;
        this.eww.aiD = i;
        bli();
        oV(i);
        invalidate();
    }
}
