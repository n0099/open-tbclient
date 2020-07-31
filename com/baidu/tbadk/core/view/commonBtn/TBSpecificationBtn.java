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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.commonBtn.a;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class TBSpecificationBtn extends View {
    public Object emo;
    private a emp;
    private Drawable emq;
    private Drawable emr;
    private Drawable ems;
    private boolean emt;
    private boolean emu;
    private boolean emv;
    private a.InterfaceC0497a emw;
    private String text;
    private Paint textPaint;
    private int textWidth;

    public TBSpecificationBtn(Context context) {
        super(context);
        this.emo = null;
        this.text = "";
        this.emt = true;
        this.emu = true;
        this.emv = false;
        this.emw = new a.InterfaceC0497a() { // from class: com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn.1
            @Override // com.baidu.tbadk.core.view.commonBtn.a.InterfaceC0497a
            public void bcM() {
                int width = TBSpecificationBtn.this.getWidth();
                if (width > 0 && TBSpecificationBtn.this.getLayoutParams().width == -2 && TBSpecificationBtn.this.getContentWidth() + TBSpecificationBtn.this.emp.emF + TBSpecificationBtn.this.emp.emG != width) {
                    TBSpecificationBtn.this.requestLayout();
                }
            }

            @Override // com.baidu.tbadk.core.view.commonBtn.a.InterfaceC0497a
            public void bcN() {
                TBSpecificationBtn.this.bcK();
                int width = TBSpecificationBtn.this.getWidth();
                if (width > 0 && TBSpecificationBtn.this.getLayoutParams().width == -2 && TBSpecificationBtn.this.getContentWidth() + TBSpecificationBtn.this.emp.emF + TBSpecificationBtn.this.emp.emG != width) {
                    TBSpecificationBtn.this.requestLayout();
                } else {
                    TBSpecificationBtn.this.invalidate();
                }
            }

            @Override // com.baidu.tbadk.core.view.commonBtn.a.InterfaceC0497a
            public void bcO() {
                TBSpecificationBtn.this.bcL();
                TBSpecificationBtn.this.invalidate();
            }
        };
        init();
    }

    public TBSpecificationBtn(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.emo = null;
        this.text = "";
        this.emt = true;
        this.emu = true;
        this.emv = false;
        this.emw = new a.InterfaceC0497a() { // from class: com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn.1
            @Override // com.baidu.tbadk.core.view.commonBtn.a.InterfaceC0497a
            public void bcM() {
                int width = TBSpecificationBtn.this.getWidth();
                if (width > 0 && TBSpecificationBtn.this.getLayoutParams().width == -2 && TBSpecificationBtn.this.getContentWidth() + TBSpecificationBtn.this.emp.emF + TBSpecificationBtn.this.emp.emG != width) {
                    TBSpecificationBtn.this.requestLayout();
                }
            }

            @Override // com.baidu.tbadk.core.view.commonBtn.a.InterfaceC0497a
            public void bcN() {
                TBSpecificationBtn.this.bcK();
                int width = TBSpecificationBtn.this.getWidth();
                if (width > 0 && TBSpecificationBtn.this.getLayoutParams().width == -2 && TBSpecificationBtn.this.getContentWidth() + TBSpecificationBtn.this.emp.emF + TBSpecificationBtn.this.emp.emG != width) {
                    TBSpecificationBtn.this.requestLayout();
                } else {
                    TBSpecificationBtn.this.invalidate();
                }
            }

            @Override // com.baidu.tbadk.core.view.commonBtn.a.InterfaceC0497a
            public void bcO() {
                TBSpecificationBtn.this.bcL();
                TBSpecificationBtn.this.invalidate();
            }
        };
        init();
    }

    public TBSpecificationBtn(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.emo = null;
        this.text = "";
        this.emt = true;
        this.emu = true;
        this.emv = false;
        this.emw = new a.InterfaceC0497a() { // from class: com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn.1
            @Override // com.baidu.tbadk.core.view.commonBtn.a.InterfaceC0497a
            public void bcM() {
                int width = TBSpecificationBtn.this.getWidth();
                if (width > 0 && TBSpecificationBtn.this.getLayoutParams().width == -2 && TBSpecificationBtn.this.getContentWidth() + TBSpecificationBtn.this.emp.emF + TBSpecificationBtn.this.emp.emG != width) {
                    TBSpecificationBtn.this.requestLayout();
                }
            }

            @Override // com.baidu.tbadk.core.view.commonBtn.a.InterfaceC0497a
            public void bcN() {
                TBSpecificationBtn.this.bcK();
                int width = TBSpecificationBtn.this.getWidth();
                if (width > 0 && TBSpecificationBtn.this.getLayoutParams().width == -2 && TBSpecificationBtn.this.getContentWidth() + TBSpecificationBtn.this.emp.emF + TBSpecificationBtn.this.emp.emG != width) {
                    TBSpecificationBtn.this.requestLayout();
                } else {
                    TBSpecificationBtn.this.invalidate();
                }
            }

            @Override // com.baidu.tbadk.core.view.commonBtn.a.InterfaceC0497a
            public void bcO() {
                TBSpecificationBtn.this.bcL();
                TBSpecificationBtn.this.invalidate();
            }
        };
        init();
    }

    private void init() {
        this.emp = new c();
        this.emp.emL = this.emw;
        this.textPaint = new Paint();
        this.textPaint.setTextSize(l.getDimens(getContext(), R.dimen.tbds36));
        this.textPaint.setAntiAlias(true);
    }

    public void setConfig(a aVar) {
        if (aVar != null) {
            this.emp = aVar;
            this.emp.emL = this.emw;
            this.emt = true;
        }
    }

    public a getStyleConfig() {
        return this.emp;
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
                if (getContentWidth() + this.emp.emF + this.emp.emG != width) {
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
        if (width > 0 && getLayoutParams().width == -2 && getContentWidth() + this.emp.emF + this.emp.emG != width) {
            requestLayout();
            return;
        }
        int height = getHeight();
        if (height > 0 && getLayoutParams().height == -2 && ((int) this.textPaint.getTextSize()) + (this.emp.emH * 2) != height) {
            requestLayout();
        }
    }

    public void setClickState(boolean z) {
        this.emu = z;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int measureWidth = measureWidth(i);
        setMeasuredDimension(measureWidth, !this.emp.emE ? measureHeight(i2) : measureWidth);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcK() {
        this.emr = this.emp.bcP();
        this.ems = this.emp.bcQ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcL() {
        if (getHeight() != 0) {
            this.emq = this.emp.V(getHeight() / 2);
        }
    }

    private int measureWidth(int i) {
        float contentWidth = getContentWidth();
        if (View.MeasureSpec.getMode(i) == 1073741824) {
            return View.MeasureSpec.getSize(i);
        }
        return (int) Math.max(this.emp.minWidth, contentWidth + this.emp.emF + this.emp.emG + getPaddingLeft() + getPaddingRight());
    }

    private int measureHeight(int i) {
        float textSize = this.textPaint.getTextSize();
        if (View.MeasureSpec.getMode(i) == 1073741824) {
            return View.MeasureSpec.getSize(i);
        }
        return (int) Math.max(this.emp.minHeight, textSize + (this.emp.emH * 2) + getPaddingTop() + getPaddingBottom());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getContentWidth() {
        int i = 0;
        if (this.emp.emB[0] > 0) {
            i = this.emp.emC;
            if (!StringUtils.isNull(this.text)) {
                i += this.emp.emI;
            }
        }
        if (this.emp.emB[1] > 0) {
            i = this.emp.emC;
            if (!StringUtils.isNull(this.text)) {
                i += this.emp.emI;
            }
        }
        return i + this.textWidth;
    }

    public void setTextHorizontalCenter(boolean z) {
        this.emv = z;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int width;
        if (this.emt) {
            bcL();
            bcK();
            this.emt = false;
        }
        if (this.emq != null) {
            if (this.emq instanceof GradientDrawable) {
                ((GradientDrawable) this.emq).setCornerRadius(getHeight() / 2);
            }
            this.emq.setBounds(0, 0, getWidth(), getHeight());
            this.emq.draw(canvas);
        }
        if (((getWidth() - getContentWidth()) - getPaddingRight()) - getPaddingLeft() == this.emp.emF + this.emp.emG) {
            width = this.emp.emF;
        } else {
            width = ((((getWidth() - getContentWidth()) - getPaddingRight()) - getPaddingLeft()) / 2) + getPaddingLeft();
        }
        int height = (getHeight() + getPaddingTop()) / 2;
        int i = this.emp.emC / 2;
        if (this.emr != null) {
            this.emr.setBounds(width, height - i, this.emp.emC + width, height + i);
            this.emr.draw(canvas);
            width += this.emp.emC + this.emp.emI;
        }
        if (this.ems != null) {
            this.ems.setBounds(this.emp.emI + width, height - i, this.emp.emI + width + this.emp.emC, height + i);
            this.ems.draw(canvas);
        }
        if (this.emv) {
            width = (getWidth() - this.textWidth) / 2;
        }
        if (!StringUtils.isNull(this.text)) {
            Paint.FontMetrics fontMetrics = this.textPaint.getFontMetrics();
            float height2 = ((((getHeight() - getPaddingBottom()) + getPaddingTop()) + this.textPaint.getTextSize()) / 2.0f) - (fontMetrics.ascent - fontMetrics.top);
            this.textPaint.setColor(this.emp.emJ ? ao.getColor(this.emp.emy) : this.emp.emy);
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
        if (!this.emu) {
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

    public void bci() {
        bcK();
        bcL();
        invalidate();
    }
}
