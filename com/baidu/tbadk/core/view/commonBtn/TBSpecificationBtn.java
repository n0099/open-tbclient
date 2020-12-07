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
    private int aku;
    private Drawable eOQ;
    private Drawable ffA;
    private Drawable ffB;
    private Rect ffC;
    private boolean ffD;
    private boolean ffE;
    private boolean ffF;
    private boolean ffG;
    private TBSpecificationButtonConfig.a ffH;
    public Object ffy;
    private TBSpecificationButtonConfig ffz;
    private String text;
    private Paint textPaint;

    public TBSpecificationBtn(Context context) {
        super(context);
        this.ffy = null;
        this.text = "";
        this.ffC = new Rect();
        this.ffD = true;
        this.ffE = true;
        this.ffF = false;
        this.aku = 0;
        this.ffG = false;
        this.ffH = new TBSpecificationButtonConfig.a() { // from class: com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn.1
            @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig.a
            public void bvX() {
                int width = TBSpecificationBtn.this.getWidth();
                if (width > 0 && TBSpecificationBtn.this.getLayoutParams().width == -2 && TBSpecificationBtn.this.getContentWidth() + TBSpecificationBtn.this.ffz.ffR + TBSpecificationBtn.this.ffz.ffS != width) {
                    TBSpecificationBtn.this.requestLayout();
                }
            }

            @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig.a
            public void bvY() {
                TBSpecificationBtn.this.bvW();
                int width = TBSpecificationBtn.this.getWidth();
                if (width > 0 && TBSpecificationBtn.this.getLayoutParams().width == -2 && TBSpecificationBtn.this.getContentWidth() + TBSpecificationBtn.this.ffz.ffR + TBSpecificationBtn.this.ffz.ffS != width) {
                    TBSpecificationBtn.this.requestLayout();
                } else {
                    TBSpecificationBtn.this.invalidate();
                }
            }

            @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig.a
            public void bvZ() {
                TBSpecificationBtn.this.ra(TBSpecificationBtn.this.aku);
                TBSpecificationBtn.this.invalidate();
            }
        };
        init();
    }

    public TBSpecificationBtn(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ffy = null;
        this.text = "";
        this.ffC = new Rect();
        this.ffD = true;
        this.ffE = true;
        this.ffF = false;
        this.aku = 0;
        this.ffG = false;
        this.ffH = new TBSpecificationButtonConfig.a() { // from class: com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn.1
            @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig.a
            public void bvX() {
                int width = TBSpecificationBtn.this.getWidth();
                if (width > 0 && TBSpecificationBtn.this.getLayoutParams().width == -2 && TBSpecificationBtn.this.getContentWidth() + TBSpecificationBtn.this.ffz.ffR + TBSpecificationBtn.this.ffz.ffS != width) {
                    TBSpecificationBtn.this.requestLayout();
                }
            }

            @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig.a
            public void bvY() {
                TBSpecificationBtn.this.bvW();
                int width = TBSpecificationBtn.this.getWidth();
                if (width > 0 && TBSpecificationBtn.this.getLayoutParams().width == -2 && TBSpecificationBtn.this.getContentWidth() + TBSpecificationBtn.this.ffz.ffR + TBSpecificationBtn.this.ffz.ffS != width) {
                    TBSpecificationBtn.this.requestLayout();
                } else {
                    TBSpecificationBtn.this.invalidate();
                }
            }

            @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig.a
            public void bvZ() {
                TBSpecificationBtn.this.ra(TBSpecificationBtn.this.aku);
                TBSpecificationBtn.this.invalidate();
            }
        };
        init();
    }

    public TBSpecificationBtn(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ffy = null;
        this.text = "";
        this.ffC = new Rect();
        this.ffD = true;
        this.ffE = true;
        this.ffF = false;
        this.aku = 0;
        this.ffG = false;
        this.ffH = new TBSpecificationButtonConfig.a() { // from class: com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn.1
            @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig.a
            public void bvX() {
                int width = TBSpecificationBtn.this.getWidth();
                if (width > 0 && TBSpecificationBtn.this.getLayoutParams().width == -2 && TBSpecificationBtn.this.getContentWidth() + TBSpecificationBtn.this.ffz.ffR + TBSpecificationBtn.this.ffz.ffS != width) {
                    TBSpecificationBtn.this.requestLayout();
                }
            }

            @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig.a
            public void bvY() {
                TBSpecificationBtn.this.bvW();
                int width = TBSpecificationBtn.this.getWidth();
                if (width > 0 && TBSpecificationBtn.this.getLayoutParams().width == -2 && TBSpecificationBtn.this.getContentWidth() + TBSpecificationBtn.this.ffz.ffR + TBSpecificationBtn.this.ffz.ffS != width) {
                    TBSpecificationBtn.this.requestLayout();
                } else {
                    TBSpecificationBtn.this.invalidate();
                }
            }

            @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig.a
            public void bvZ() {
                TBSpecificationBtn.this.ra(TBSpecificationBtn.this.aku);
                TBSpecificationBtn.this.invalidate();
            }
        };
        init();
    }

    private void init() {
        this.aku = TbadkCoreApplication.getInst().getSkinType();
        this.ffz = new b();
        this.ffz.ffX = this.ffH;
        this.textPaint = new Paint();
        this.textPaint.setTextSize(l.getDimens(getContext(), R.dimen.T_X08));
        this.textPaint.setAntiAlias(true);
    }

    public void setConfig(TBSpecificationButtonConfig tBSpecificationButtonConfig) {
        if (tBSpecificationButtonConfig != null) {
            this.ffz = tBSpecificationButtonConfig;
            this.ffz.ffX = this.ffH;
            this.ffD = true;
        }
    }

    public TBSpecificationButtonConfig getStyleConfig() {
        return this.ffz;
    }

    public void setText(String str) {
        if (StringUtils.isNull(str)) {
            str = "";
        }
        this.text = str;
        this.textPaint.getTextBounds(str, 0, str.length(), this.ffC);
        int width = getWidth();
        if (width > 0) {
            if (getLayoutParams().width == -2) {
                if (getContentWidth() + this.ffz.ffR + this.ffz.ffS != width) {
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
        this.textPaint.getTextBounds(this.text, 0, this.text.length(), this.ffC);
        int width = getWidth();
        if (width > 0 && getLayoutParams().width == -2 && getContentWidth() + this.ffz.ffR + this.ffz.ffS != width) {
            requestLayout();
            return;
        }
        int height = getHeight();
        if (height > 0 && getLayoutParams().height == -2 && ((int) this.textPaint.getTextSize()) + (this.ffz.ffT * 2) != height) {
            requestLayout();
        }
    }

    public void setClickState(boolean z) {
        this.ffE = z;
    }

    public void setUseDisableState(boolean z) {
        this.ffE = false;
        this.ffG = z;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int measureWidth = measureWidth(i);
        setMeasuredDimension(measureWidth, !this.ffz.ffQ ? measureHeight(i2) : measureWidth);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bvW() {
        this.ffA = this.ffz.bwa();
        this.ffB = this.ffz.bwb();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ra(int i) {
        if (getHeight() != 0) {
            this.ffz.aku = i;
            this.eOQ = this.ffz.ah(getHeight() / 2);
            this.textPaint.setColor(this.ffz.ffV ? ap.getColor(i, this.ffz.ffJ) : this.ffz.ffJ);
        }
    }

    private int measureWidth(int i) {
        float contentWidth = getContentWidth();
        if (View.MeasureSpec.getMode(i) == 1073741824) {
            return View.MeasureSpec.getSize(i);
        }
        return (int) Math.max(this.ffz.minWidth, contentWidth + this.ffz.ffR + this.ffz.ffS + getPaddingLeft() + getPaddingRight());
    }

    private int measureHeight(int i) {
        float textSize = this.textPaint.getTextSize();
        if (View.MeasureSpec.getMode(i) == 1073741824) {
            return View.MeasureSpec.getSize(i);
        }
        return (int) Math.max(this.ffz.minHeight, textSize + (this.ffz.ffT * 2) + getPaddingTop() + getPaddingBottom());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getContentWidth() {
        int i = 0;
        if (this.ffz.ffM[0] > 0) {
            i = this.ffz.ffO;
            if (!StringUtils.isNull(this.text)) {
                i += this.ffz.ffU;
            }
        }
        if (this.ffz.ffM[1] > 0) {
            i = this.ffz.ffO;
            if (!StringUtils.isNull(this.text)) {
                i += this.ffz.ffU;
            }
        }
        return i + this.ffC.width();
    }

    public void setTextHorizontalCenter(boolean z) {
        this.ffF = z;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int width;
        if (this.ffD) {
            ra(this.aku);
            bvW();
            this.ffD = false;
        }
        if (this.eOQ != null) {
            if (this.eOQ instanceof GradientDrawable) {
                ((GradientDrawable) this.eOQ).setCornerRadius(getHeight() / 2);
            }
            this.eOQ.setBounds(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom());
            this.eOQ.draw(canvas);
        }
        if (((getWidth() - getContentWidth()) - getPaddingRight()) - getPaddingLeft() == this.ffz.ffR + this.ffz.ffS) {
            width = this.ffz.ffR;
        } else {
            width = ((((getWidth() - getContentWidth()) - getPaddingRight()) - getPaddingLeft()) / 2) + getPaddingLeft();
        }
        int height = (getHeight() + getPaddingTop()) / 2;
        int i = this.ffz.ffO / 2;
        if (this.ffA != null) {
            this.ffA.setBounds(width, height - i, this.ffz.ffO + width, height + i);
            this.ffA.draw(canvas);
            width += this.ffz.ffO + this.ffz.ffU;
        }
        if (this.ffB != null) {
            this.ffB.setBounds(this.ffz.ffU + width, height - i, this.ffz.ffU + width + this.ffz.ffO, height + i);
            this.ffB.draw(canvas);
        }
        if (this.ffF) {
            width = (getWidth() - this.ffC.width()) / 2;
        }
        if (!StringUtils.isNull(this.text)) {
            this.textPaint.getTextBounds(this.text, 0, this.text.length(), this.ffC);
            canvas.drawText(this.text, width, (((getHeight() - getPaddingBottom()) + getPaddingTop()) / 2.0f) - this.ffC.centerY(), this.textPaint);
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
        if (!this.ffE) {
            if (this.ffG) {
                setAlpha(ap.eTL);
            } else {
                setAlpha(1.0f);
            }
        } else if (z2) {
            setAlpha(ap.eTL);
        } else if (z && isClickable()) {
            setAlpha(ap.eTK);
        } else {
            setAlpha(1.0f);
        }
        super.drawableStateChanged();
    }

    public void bvt() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void changeSkinType(int i) {
        this.aku = i;
        this.ffz.aku = i;
        bvW();
        ra(i);
        invalidate();
    }
}
