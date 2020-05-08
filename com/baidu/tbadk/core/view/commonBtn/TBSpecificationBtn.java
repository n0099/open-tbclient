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
    public Object dJO;
    private a dJP;
    private Drawable dJQ;
    private Drawable dJR;
    private Drawable dJS;
    private boolean dJT;
    private boolean dJU;
    private a.InterfaceC0432a dJV;
    private String text;
    private Paint textPaint;
    private int textWidth;

    public TBSpecificationBtn(Context context) {
        super(context);
        this.dJO = null;
        this.text = "";
        this.dJT = true;
        this.dJU = true;
        this.dJV = new a.InterfaceC0432a() { // from class: com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn.1
            @Override // com.baidu.tbadk.core.view.commonBtn.a.InterfaceC0432a
            public void aQM() {
                int width = TBSpecificationBtn.this.getWidth();
                if (width > 0 && TBSpecificationBtn.this.getLayoutParams().width == -2 && TBSpecificationBtn.this.getContentWidth() + (TBSpecificationBtn.this.dJP.dKe * 2) != width) {
                    TBSpecificationBtn.this.requestLayout();
                }
            }

            @Override // com.baidu.tbadk.core.view.commonBtn.a.InterfaceC0432a
            public void aQN() {
                TBSpecificationBtn.this.aQK();
                int width = TBSpecificationBtn.this.getWidth();
                if (width > 0 && TBSpecificationBtn.this.getLayoutParams().width == -2 && TBSpecificationBtn.this.getContentWidth() + (TBSpecificationBtn.this.dJP.dKe * 2) != width) {
                    TBSpecificationBtn.this.requestLayout();
                } else {
                    TBSpecificationBtn.this.invalidate();
                }
            }

            @Override // com.baidu.tbadk.core.view.commonBtn.a.InterfaceC0432a
            public void aQO() {
                TBSpecificationBtn.this.aQL();
                TBSpecificationBtn.this.invalidate();
            }
        };
        init();
    }

    public TBSpecificationBtn(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dJO = null;
        this.text = "";
        this.dJT = true;
        this.dJU = true;
        this.dJV = new a.InterfaceC0432a() { // from class: com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn.1
            @Override // com.baidu.tbadk.core.view.commonBtn.a.InterfaceC0432a
            public void aQM() {
                int width = TBSpecificationBtn.this.getWidth();
                if (width > 0 && TBSpecificationBtn.this.getLayoutParams().width == -2 && TBSpecificationBtn.this.getContentWidth() + (TBSpecificationBtn.this.dJP.dKe * 2) != width) {
                    TBSpecificationBtn.this.requestLayout();
                }
            }

            @Override // com.baidu.tbadk.core.view.commonBtn.a.InterfaceC0432a
            public void aQN() {
                TBSpecificationBtn.this.aQK();
                int width = TBSpecificationBtn.this.getWidth();
                if (width > 0 && TBSpecificationBtn.this.getLayoutParams().width == -2 && TBSpecificationBtn.this.getContentWidth() + (TBSpecificationBtn.this.dJP.dKe * 2) != width) {
                    TBSpecificationBtn.this.requestLayout();
                } else {
                    TBSpecificationBtn.this.invalidate();
                }
            }

            @Override // com.baidu.tbadk.core.view.commonBtn.a.InterfaceC0432a
            public void aQO() {
                TBSpecificationBtn.this.aQL();
                TBSpecificationBtn.this.invalidate();
            }
        };
        init();
    }

    public TBSpecificationBtn(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dJO = null;
        this.text = "";
        this.dJT = true;
        this.dJU = true;
        this.dJV = new a.InterfaceC0432a() { // from class: com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn.1
            @Override // com.baidu.tbadk.core.view.commonBtn.a.InterfaceC0432a
            public void aQM() {
                int width = TBSpecificationBtn.this.getWidth();
                if (width > 0 && TBSpecificationBtn.this.getLayoutParams().width == -2 && TBSpecificationBtn.this.getContentWidth() + (TBSpecificationBtn.this.dJP.dKe * 2) != width) {
                    TBSpecificationBtn.this.requestLayout();
                }
            }

            @Override // com.baidu.tbadk.core.view.commonBtn.a.InterfaceC0432a
            public void aQN() {
                TBSpecificationBtn.this.aQK();
                int width = TBSpecificationBtn.this.getWidth();
                if (width > 0 && TBSpecificationBtn.this.getLayoutParams().width == -2 && TBSpecificationBtn.this.getContentWidth() + (TBSpecificationBtn.this.dJP.dKe * 2) != width) {
                    TBSpecificationBtn.this.requestLayout();
                } else {
                    TBSpecificationBtn.this.invalidate();
                }
            }

            @Override // com.baidu.tbadk.core.view.commonBtn.a.InterfaceC0432a
            public void aQO() {
                TBSpecificationBtn.this.aQL();
                TBSpecificationBtn.this.invalidate();
            }
        };
        init();
    }

    private void init() {
        this.dJP = new c();
        this.dJP.dKk = this.dJV;
        this.textPaint = new Paint();
        this.textPaint.setTextSize(l.getDimens(getContext(), R.dimen.tbds36));
        this.textPaint.setAntiAlias(true);
    }

    public void setConfig(a aVar) {
        if (aVar != null) {
            this.dJP = aVar;
            this.dJP.dKk = this.dJV;
            this.dJT = true;
        }
    }

    public a getStyleConfig() {
        return this.dJP;
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
                if (getContentWidth() + (this.dJP.dKe * 2) != width) {
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
        if (width > 0 && getLayoutParams().width == -2 && getContentWidth() + (this.dJP.dKe * 2) != width) {
            requestLayout();
            return;
        }
        int height = getHeight();
        if (height > 0 && getLayoutParams().height == -2 && ((int) this.textPaint.getTextSize()) + (this.dJP.dKf * 2) != height) {
            requestLayout();
        }
    }

    public void setClickState(boolean z) {
        this.dJU = z;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int measureWidth = measureWidth(i);
        setMeasuredDimension(measureWidth, !this.dJP.dKd ? measureHeight(i2) : measureWidth);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQK() {
        this.dJR = this.dJP.aQP();
        this.dJS = this.dJP.aQQ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQL() {
        if (getHeight() != 0) {
            this.dJQ = this.dJP.U(getHeight() / 2);
        }
    }

    private int measureWidth(int i) {
        float contentWidth = getContentWidth();
        if (View.MeasureSpec.getMode(i) == 1073741824) {
            return View.MeasureSpec.getSize(i);
        }
        return (int) Math.max(this.dJP.dKh, contentWidth + (this.dJP.dKe * 2) + getPaddingLeft() + getPaddingRight());
    }

    private int measureHeight(int i) {
        float textSize = this.textPaint.getTextSize();
        if (View.MeasureSpec.getMode(i) == 1073741824) {
            return View.MeasureSpec.getSize(i);
        }
        return (int) Math.max(this.dJP.bHQ, textSize + (this.dJP.dKf * 2) + getPaddingTop() + getPaddingBottom());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getContentWidth() {
        int i = 0;
        if (this.dJP.dKa[0] > 0) {
            i = this.dJP.dKb;
            if (!StringUtils.isNull(this.text)) {
                i += this.dJP.dKg;
            }
        }
        if (this.dJP.dKa[1] > 0) {
            i = this.dJP.dKb;
            if (!StringUtils.isNull(this.text)) {
                i += this.dJP.dKg;
            }
        }
        return i + this.textWidth;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.dJT) {
            aQL();
            aQK();
            this.dJT = false;
        }
        if (this.dJQ != null) {
            if (this.dJQ instanceof GradientDrawable) {
                ((GradientDrawable) this.dJQ).setCornerRadius(getHeight() / 2);
            }
            this.dJQ.setBounds(0, 0, getWidth(), getHeight());
            this.dJQ.draw(canvas);
        }
        int width = ((getWidth() - getContentWidth()) - getPaddingRight()) / 2;
        int height = (getHeight() + getPaddingTop()) / 2;
        int i = this.dJP.dKb / 2;
        if (this.dJR != null) {
            this.dJR.setBounds(width, height - i, this.dJP.dKb + width, height + i);
            this.dJR.draw(canvas);
            width += this.dJP.dKb + this.dJP.dKg;
        }
        if (this.dJS != null) {
            this.dJS.setBounds(this.dJP.dKg + width, height - i, this.dJP.dKg + width + this.dJP.dKb, height + i);
            this.dJS.draw(canvas);
        }
        if (!StringUtils.isNull(this.text)) {
            Paint.FontMetrics fontMetrics = this.textPaint.getFontMetrics();
            float height2 = ((((getHeight() - getPaddingBottom()) + getPaddingTop()) + this.textPaint.getTextSize()) / 2.0f) - (fontMetrics.ascent - fontMetrics.top);
            this.textPaint.setColor(this.dJP.dKi ? am.getColor(this.dJP.dJX) : this.dJP.dJX);
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
        if (!this.dJU) {
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

    public void aQm() {
        aQK();
        aQL();
        invalidate();
    }
}
