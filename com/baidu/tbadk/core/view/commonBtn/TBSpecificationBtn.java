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
    public Object djE;
    private a djF;
    private Drawable djG;
    private Drawable djH;
    private Drawable djI;
    private boolean djJ;
    private boolean djK;
    private a.InterfaceC0380a djL;
    private String text;
    private Paint textPaint;
    private int textWidth;

    public TBSpecificationBtn(Context context) {
        super(context);
        this.djE = null;
        this.text = "";
        this.djJ = true;
        this.djK = true;
        this.djL = new a.InterfaceC0380a() { // from class: com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn.1
            @Override // com.baidu.tbadk.core.view.commonBtn.a.InterfaceC0380a
            public void aIp() {
                int width = TBSpecificationBtn.this.getWidth();
                if (width > 0 && TBSpecificationBtn.this.getLayoutParams().width == -2 && TBSpecificationBtn.this.getContentWidth() + (TBSpecificationBtn.this.djF.djU * 2) != width) {
                    TBSpecificationBtn.this.requestLayout();
                }
            }

            @Override // com.baidu.tbadk.core.view.commonBtn.a.InterfaceC0380a
            public void aIq() {
                TBSpecificationBtn.this.aIn();
                int width = TBSpecificationBtn.this.getWidth();
                if (width > 0 && TBSpecificationBtn.this.getLayoutParams().width == -2 && TBSpecificationBtn.this.getContentWidth() + (TBSpecificationBtn.this.djF.djU * 2) != width) {
                    TBSpecificationBtn.this.requestLayout();
                } else {
                    TBSpecificationBtn.this.invalidate();
                }
            }

            @Override // com.baidu.tbadk.core.view.commonBtn.a.InterfaceC0380a
            public void aIr() {
                TBSpecificationBtn.this.aIo();
                TBSpecificationBtn.this.invalidate();
            }
        };
        init();
    }

    public TBSpecificationBtn(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.djE = null;
        this.text = "";
        this.djJ = true;
        this.djK = true;
        this.djL = new a.InterfaceC0380a() { // from class: com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn.1
            @Override // com.baidu.tbadk.core.view.commonBtn.a.InterfaceC0380a
            public void aIp() {
                int width = TBSpecificationBtn.this.getWidth();
                if (width > 0 && TBSpecificationBtn.this.getLayoutParams().width == -2 && TBSpecificationBtn.this.getContentWidth() + (TBSpecificationBtn.this.djF.djU * 2) != width) {
                    TBSpecificationBtn.this.requestLayout();
                }
            }

            @Override // com.baidu.tbadk.core.view.commonBtn.a.InterfaceC0380a
            public void aIq() {
                TBSpecificationBtn.this.aIn();
                int width = TBSpecificationBtn.this.getWidth();
                if (width > 0 && TBSpecificationBtn.this.getLayoutParams().width == -2 && TBSpecificationBtn.this.getContentWidth() + (TBSpecificationBtn.this.djF.djU * 2) != width) {
                    TBSpecificationBtn.this.requestLayout();
                } else {
                    TBSpecificationBtn.this.invalidate();
                }
            }

            @Override // com.baidu.tbadk.core.view.commonBtn.a.InterfaceC0380a
            public void aIr() {
                TBSpecificationBtn.this.aIo();
                TBSpecificationBtn.this.invalidate();
            }
        };
        init();
    }

    public TBSpecificationBtn(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.djE = null;
        this.text = "";
        this.djJ = true;
        this.djK = true;
        this.djL = new a.InterfaceC0380a() { // from class: com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn.1
            @Override // com.baidu.tbadk.core.view.commonBtn.a.InterfaceC0380a
            public void aIp() {
                int width = TBSpecificationBtn.this.getWidth();
                if (width > 0 && TBSpecificationBtn.this.getLayoutParams().width == -2 && TBSpecificationBtn.this.getContentWidth() + (TBSpecificationBtn.this.djF.djU * 2) != width) {
                    TBSpecificationBtn.this.requestLayout();
                }
            }

            @Override // com.baidu.tbadk.core.view.commonBtn.a.InterfaceC0380a
            public void aIq() {
                TBSpecificationBtn.this.aIn();
                int width = TBSpecificationBtn.this.getWidth();
                if (width > 0 && TBSpecificationBtn.this.getLayoutParams().width == -2 && TBSpecificationBtn.this.getContentWidth() + (TBSpecificationBtn.this.djF.djU * 2) != width) {
                    TBSpecificationBtn.this.requestLayout();
                } else {
                    TBSpecificationBtn.this.invalidate();
                }
            }

            @Override // com.baidu.tbadk.core.view.commonBtn.a.InterfaceC0380a
            public void aIr() {
                TBSpecificationBtn.this.aIo();
                TBSpecificationBtn.this.invalidate();
            }
        };
        init();
    }

    private void init() {
        this.djF = new c();
        this.djF.djZ = this.djL;
        this.textPaint = new Paint();
        this.textPaint.setTextSize(l.getDimens(getContext(), R.dimen.tbds36));
        this.textPaint.setAntiAlias(true);
    }

    public void setConfig(a aVar) {
        if (aVar != null) {
            this.djF = aVar;
            this.djF.djZ = this.djL;
            this.djJ = true;
        }
    }

    public a getStyleConfig() {
        return this.djF;
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
                if (getContentWidth() + (this.djF.djU * 2) != width) {
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
        if (width > 0 && getLayoutParams().width == -2 && getContentWidth() + (this.djF.djU * 2) != width) {
            requestLayout();
            return;
        }
        int height = getHeight();
        if (height > 0 && getLayoutParams().height == -2 && ((int) this.textPaint.getTextSize()) + (this.djF.djV * 2) != height) {
            requestLayout();
        }
    }

    public void setClickState(boolean z) {
        this.djK = z;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int measureWidth = measureWidth(i);
        setMeasuredDimension(measureWidth, !this.djF.djT ? measureHeight(i2) : measureWidth);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aIn() {
        this.djH = this.djF.aIs();
        this.djI = this.djF.aIt();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aIo() {
        if (getHeight() != 0) {
            this.djG = this.djF.ak(getHeight() / 2);
        }
    }

    private int measureWidth(int i) {
        float contentWidth = getContentWidth();
        if (View.MeasureSpec.getMode(i) == 1073741824) {
            return View.MeasureSpec.getSize(i);
        }
        return (int) Math.max(this.djF.djX, contentWidth + (this.djF.djU * 2) + getPaddingLeft() + getPaddingRight());
    }

    private int measureHeight(int i) {
        float textSize = this.textPaint.getTextSize();
        if (View.MeasureSpec.getMode(i) == 1073741824) {
            return View.MeasureSpec.getSize(i);
        }
        return (int) Math.max(this.djF.bjq, textSize + (this.djF.djV * 2) + getPaddingTop() + getPaddingBottom());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getContentWidth() {
        int i = 0;
        if (this.djF.djQ[0] > 0) {
            i = this.djF.djR;
            if (!StringUtils.isNull(this.text)) {
                i += this.djF.djW;
            }
        }
        if (this.djF.djQ[1] > 0) {
            i = this.djF.djR;
            if (!StringUtils.isNull(this.text)) {
                i += this.djF.djW;
            }
        }
        return i + this.textWidth;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.djJ) {
            aIo();
            aIn();
            this.djJ = false;
        }
        if (this.djG != null) {
            if (this.djG instanceof GradientDrawable) {
                ((GradientDrawable) this.djG).setCornerRadius(getHeight() / 2);
            }
            this.djG.setBounds(0, 0, getWidth(), getHeight());
            this.djG.draw(canvas);
        }
        int width = ((getWidth() - getContentWidth()) - getPaddingRight()) / 2;
        int height = (getHeight() + getPaddingTop()) / 2;
        int i = this.djF.djR / 2;
        if (this.djH != null) {
            this.djH.setBounds(width, height - i, this.djF.djR + width, height + i);
            this.djH.draw(canvas);
            width += this.djF.djR + this.djF.djW;
        }
        if (this.djI != null) {
            this.djI.setBounds(this.djF.djW + width, height - i, this.djF.djW + width + this.djF.djR, height + i);
            this.djI.draw(canvas);
        }
        if (!StringUtils.isNull(this.text)) {
            Paint.FontMetrics fontMetrics = this.textPaint.getFontMetrics();
            float height2 = ((((getHeight() - getPaddingBottom()) + getPaddingTop()) + this.textPaint.getTextSize()) / 2.0f) - (fontMetrics.ascent - fontMetrics.top);
            this.textPaint.setColor(this.djF.djY ? am.getColor(this.djF.djN) : this.djF.djN);
            canvas.drawText(this.text, width, height2, this.textPaint);
        }
    }

    @Override // android.view.View
    protected void drawableStateChanged() {
        boolean z = true;
        boolean z2 = false;
        int[] drawableState = getDrawableState();
        int length = drawableState.length;
        int i = 0;
        while (true) {
            if (i < length) {
                int i2 = drawableState[i];
                if (i2 == -16842910) {
                    break;
                } else if (i2 == 16842919) {
                    z = false;
                    z2 = true;
                    break;
                } else {
                    i++;
                }
            } else {
                z = false;
                break;
            }
        }
        if (!this.djK) {
            setAlpha(1.0f);
        } else if (z) {
            setAlpha(0.3f);
        } else if (z2) {
            setAlpha(0.5f);
        } else {
            setAlpha(1.0f);
        }
        super.drawableStateChanged();
    }

    public void aHO() {
        aIn();
        aIo();
        invalidate();
    }
}
