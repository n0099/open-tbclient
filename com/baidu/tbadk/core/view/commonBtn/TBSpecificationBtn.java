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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.commonBtn.a;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class TBSpecificationBtn extends View {
    public Object dJK;
    private a dJL;
    private Drawable dJM;
    private Drawable dJN;
    private Drawable dJO;
    private boolean dJP;
    private boolean dJQ;
    private a.InterfaceC0411a dJR;
    private String text;
    private Paint textPaint;
    private int textWidth;

    public TBSpecificationBtn(Context context) {
        super(context);
        this.dJK = null;
        this.text = "";
        this.dJP = true;
        this.dJQ = true;
        this.dJR = new a.InterfaceC0411a() { // from class: com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn.1
            @Override // com.baidu.tbadk.core.view.commonBtn.a.InterfaceC0411a
            public void aQP() {
                int width = TBSpecificationBtn.this.getWidth();
                if (width > 0 && TBSpecificationBtn.this.getLayoutParams().width == -2 && TBSpecificationBtn.this.getContentWidth() + (TBSpecificationBtn.this.dJL.dKa * 2) != width) {
                    TBSpecificationBtn.this.requestLayout();
                }
            }

            @Override // com.baidu.tbadk.core.view.commonBtn.a.InterfaceC0411a
            public void aQQ() {
                TBSpecificationBtn.this.aQN();
                int width = TBSpecificationBtn.this.getWidth();
                if (width > 0 && TBSpecificationBtn.this.getLayoutParams().width == -2 && TBSpecificationBtn.this.getContentWidth() + (TBSpecificationBtn.this.dJL.dKa * 2) != width) {
                    TBSpecificationBtn.this.requestLayout();
                } else {
                    TBSpecificationBtn.this.invalidate();
                }
            }

            @Override // com.baidu.tbadk.core.view.commonBtn.a.InterfaceC0411a
            public void aQR() {
                TBSpecificationBtn.this.aQO();
                TBSpecificationBtn.this.invalidate();
            }
        };
        init();
    }

    public TBSpecificationBtn(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dJK = null;
        this.text = "";
        this.dJP = true;
        this.dJQ = true;
        this.dJR = new a.InterfaceC0411a() { // from class: com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn.1
            @Override // com.baidu.tbadk.core.view.commonBtn.a.InterfaceC0411a
            public void aQP() {
                int width = TBSpecificationBtn.this.getWidth();
                if (width > 0 && TBSpecificationBtn.this.getLayoutParams().width == -2 && TBSpecificationBtn.this.getContentWidth() + (TBSpecificationBtn.this.dJL.dKa * 2) != width) {
                    TBSpecificationBtn.this.requestLayout();
                }
            }

            @Override // com.baidu.tbadk.core.view.commonBtn.a.InterfaceC0411a
            public void aQQ() {
                TBSpecificationBtn.this.aQN();
                int width = TBSpecificationBtn.this.getWidth();
                if (width > 0 && TBSpecificationBtn.this.getLayoutParams().width == -2 && TBSpecificationBtn.this.getContentWidth() + (TBSpecificationBtn.this.dJL.dKa * 2) != width) {
                    TBSpecificationBtn.this.requestLayout();
                } else {
                    TBSpecificationBtn.this.invalidate();
                }
            }

            @Override // com.baidu.tbadk.core.view.commonBtn.a.InterfaceC0411a
            public void aQR() {
                TBSpecificationBtn.this.aQO();
                TBSpecificationBtn.this.invalidate();
            }
        };
        init();
    }

    public TBSpecificationBtn(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dJK = null;
        this.text = "";
        this.dJP = true;
        this.dJQ = true;
        this.dJR = new a.InterfaceC0411a() { // from class: com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn.1
            @Override // com.baidu.tbadk.core.view.commonBtn.a.InterfaceC0411a
            public void aQP() {
                int width = TBSpecificationBtn.this.getWidth();
                if (width > 0 && TBSpecificationBtn.this.getLayoutParams().width == -2 && TBSpecificationBtn.this.getContentWidth() + (TBSpecificationBtn.this.dJL.dKa * 2) != width) {
                    TBSpecificationBtn.this.requestLayout();
                }
            }

            @Override // com.baidu.tbadk.core.view.commonBtn.a.InterfaceC0411a
            public void aQQ() {
                TBSpecificationBtn.this.aQN();
                int width = TBSpecificationBtn.this.getWidth();
                if (width > 0 && TBSpecificationBtn.this.getLayoutParams().width == -2 && TBSpecificationBtn.this.getContentWidth() + (TBSpecificationBtn.this.dJL.dKa * 2) != width) {
                    TBSpecificationBtn.this.requestLayout();
                } else {
                    TBSpecificationBtn.this.invalidate();
                }
            }

            @Override // com.baidu.tbadk.core.view.commonBtn.a.InterfaceC0411a
            public void aQR() {
                TBSpecificationBtn.this.aQO();
                TBSpecificationBtn.this.invalidate();
            }
        };
        init();
    }

    private void init() {
        this.dJL = new c();
        this.dJL.dKg = this.dJR;
        this.textPaint = new Paint();
        this.textPaint.setTextSize(l.getDimens(getContext(), R.dimen.tbds36));
        this.textPaint.setAntiAlias(true);
    }

    public void setConfig(a aVar) {
        if (aVar != null) {
            this.dJL = aVar;
            this.dJL.dKg = this.dJR;
            this.dJP = true;
        }
    }

    public a getStyleConfig() {
        return this.dJL;
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
                if (getContentWidth() + (this.dJL.dKa * 2) != width) {
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
        if (width > 0 && getLayoutParams().width == -2 && getContentWidth() + (this.dJL.dKa * 2) != width) {
            requestLayout();
            return;
        }
        int height = getHeight();
        if (height > 0 && getLayoutParams().height == -2 && ((int) this.textPaint.getTextSize()) + (this.dJL.dKb * 2) != height) {
            requestLayout();
        }
    }

    public void setClickState(boolean z) {
        this.dJQ = z;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int measureWidth = measureWidth(i);
        setMeasuredDimension(measureWidth, !this.dJL.dJZ ? measureHeight(i2) : measureWidth);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQN() {
        this.dJN = this.dJL.aQS();
        this.dJO = this.dJL.aQT();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQO() {
        if (getHeight() != 0) {
            this.dJM = this.dJL.U(getHeight() / 2);
        }
    }

    private int measureWidth(int i) {
        float contentWidth = getContentWidth();
        if (View.MeasureSpec.getMode(i) == 1073741824) {
            return View.MeasureSpec.getSize(i);
        }
        return (int) Math.max(this.dJL.dKd, contentWidth + (this.dJL.dKa * 2) + getPaddingLeft() + getPaddingRight());
    }

    private int measureHeight(int i) {
        float textSize = this.textPaint.getTextSize();
        if (View.MeasureSpec.getMode(i) == 1073741824) {
            return View.MeasureSpec.getSize(i);
        }
        return (int) Math.max(this.dJL.bHL, textSize + (this.dJL.dKb * 2) + getPaddingTop() + getPaddingBottom());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getContentWidth() {
        int i = 0;
        if (this.dJL.dJW[0] > 0) {
            i = this.dJL.dJX;
            if (!StringUtils.isNull(this.text)) {
                i += this.dJL.dKc;
            }
        }
        if (this.dJL.dJW[1] > 0) {
            i = this.dJL.dJX;
            if (!StringUtils.isNull(this.text)) {
                i += this.dJL.dKc;
            }
        }
        return i + this.textWidth;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.dJP) {
            aQO();
            aQN();
            this.dJP = false;
        }
        if (this.dJM != null) {
            if (this.dJM instanceof GradientDrawable) {
                ((GradientDrawable) this.dJM).setCornerRadius(getHeight() / 2);
            }
            this.dJM.setBounds(0, 0, getWidth(), getHeight());
            this.dJM.draw(canvas);
        }
        int width = ((getWidth() - getContentWidth()) - getPaddingRight()) / 2;
        int height = (getHeight() + getPaddingTop()) / 2;
        int i = this.dJL.dJX / 2;
        if (this.dJN != null) {
            this.dJN.setBounds(width, height - i, this.dJL.dJX + width, height + i);
            this.dJN.draw(canvas);
            width += this.dJL.dJX + this.dJL.dKc;
        }
        if (this.dJO != null) {
            this.dJO.setBounds(this.dJL.dKc + width, height - i, this.dJL.dKc + width + this.dJL.dJX, height + i);
            this.dJO.draw(canvas);
        }
        if (!StringUtils.isNull(this.text)) {
            Paint.FontMetrics fontMetrics = this.textPaint.getFontMetrics();
            float height2 = ((((getHeight() - getPaddingBottom()) + getPaddingTop()) + this.textPaint.getTextSize()) / 2.0f) - (fontMetrics.ascent - fontMetrics.top);
            this.textPaint.setColor(this.dJL.dKe ? am.getColor(this.dJL.dJT) : this.dJL.dJT);
            canvas.drawText(this.text, width, height2, this.textPaint);
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
        if (!this.dJQ) {
            setAlpha(1.0f);
        } else if (z2) {
            setAlpha(0.3f);
        } else if (z) {
            setAlpha(0.5f);
        } else {
            setAlpha(1.0f);
        }
        super.drawableStateChanged();
    }

    public void aQp() {
        aQN();
        aQO();
        invalidate();
    }
}
