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
    public Object djq;
    private a djr;
    private Drawable djs;
    private Drawable djt;
    private Drawable dju;
    private boolean djv;
    private boolean djw;
    private a.InterfaceC0380a djx;
    private String text;
    private Paint textPaint;
    private int textWidth;

    public TBSpecificationBtn(Context context) {
        super(context);
        this.djq = null;
        this.text = "";
        this.djv = true;
        this.djw = true;
        this.djx = new a.InterfaceC0380a() { // from class: com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn.1
            @Override // com.baidu.tbadk.core.view.commonBtn.a.InterfaceC0380a
            public void aIm() {
                int width = TBSpecificationBtn.this.getWidth();
                if (width > 0 && TBSpecificationBtn.this.getLayoutParams().width == -2 && TBSpecificationBtn.this.getContentWidth() + (TBSpecificationBtn.this.djr.djG * 2) != width) {
                    TBSpecificationBtn.this.requestLayout();
                }
            }

            @Override // com.baidu.tbadk.core.view.commonBtn.a.InterfaceC0380a
            public void aIn() {
                TBSpecificationBtn.this.aIk();
                int width = TBSpecificationBtn.this.getWidth();
                if (width > 0 && TBSpecificationBtn.this.getLayoutParams().width == -2 && TBSpecificationBtn.this.getContentWidth() + (TBSpecificationBtn.this.djr.djG * 2) != width) {
                    TBSpecificationBtn.this.requestLayout();
                } else {
                    TBSpecificationBtn.this.invalidate();
                }
            }

            @Override // com.baidu.tbadk.core.view.commonBtn.a.InterfaceC0380a
            public void aIo() {
                TBSpecificationBtn.this.aIl();
                TBSpecificationBtn.this.invalidate();
            }
        };
        init();
    }

    public TBSpecificationBtn(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.djq = null;
        this.text = "";
        this.djv = true;
        this.djw = true;
        this.djx = new a.InterfaceC0380a() { // from class: com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn.1
            @Override // com.baidu.tbadk.core.view.commonBtn.a.InterfaceC0380a
            public void aIm() {
                int width = TBSpecificationBtn.this.getWidth();
                if (width > 0 && TBSpecificationBtn.this.getLayoutParams().width == -2 && TBSpecificationBtn.this.getContentWidth() + (TBSpecificationBtn.this.djr.djG * 2) != width) {
                    TBSpecificationBtn.this.requestLayout();
                }
            }

            @Override // com.baidu.tbadk.core.view.commonBtn.a.InterfaceC0380a
            public void aIn() {
                TBSpecificationBtn.this.aIk();
                int width = TBSpecificationBtn.this.getWidth();
                if (width > 0 && TBSpecificationBtn.this.getLayoutParams().width == -2 && TBSpecificationBtn.this.getContentWidth() + (TBSpecificationBtn.this.djr.djG * 2) != width) {
                    TBSpecificationBtn.this.requestLayout();
                } else {
                    TBSpecificationBtn.this.invalidate();
                }
            }

            @Override // com.baidu.tbadk.core.view.commonBtn.a.InterfaceC0380a
            public void aIo() {
                TBSpecificationBtn.this.aIl();
                TBSpecificationBtn.this.invalidate();
            }
        };
        init();
    }

    public TBSpecificationBtn(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.djq = null;
        this.text = "";
        this.djv = true;
        this.djw = true;
        this.djx = new a.InterfaceC0380a() { // from class: com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn.1
            @Override // com.baidu.tbadk.core.view.commonBtn.a.InterfaceC0380a
            public void aIm() {
                int width = TBSpecificationBtn.this.getWidth();
                if (width > 0 && TBSpecificationBtn.this.getLayoutParams().width == -2 && TBSpecificationBtn.this.getContentWidth() + (TBSpecificationBtn.this.djr.djG * 2) != width) {
                    TBSpecificationBtn.this.requestLayout();
                }
            }

            @Override // com.baidu.tbadk.core.view.commonBtn.a.InterfaceC0380a
            public void aIn() {
                TBSpecificationBtn.this.aIk();
                int width = TBSpecificationBtn.this.getWidth();
                if (width > 0 && TBSpecificationBtn.this.getLayoutParams().width == -2 && TBSpecificationBtn.this.getContentWidth() + (TBSpecificationBtn.this.djr.djG * 2) != width) {
                    TBSpecificationBtn.this.requestLayout();
                } else {
                    TBSpecificationBtn.this.invalidate();
                }
            }

            @Override // com.baidu.tbadk.core.view.commonBtn.a.InterfaceC0380a
            public void aIo() {
                TBSpecificationBtn.this.aIl();
                TBSpecificationBtn.this.invalidate();
            }
        };
        init();
    }

    private void init() {
        this.djr = new c();
        this.djr.djL = this.djx;
        this.textPaint = new Paint();
        this.textPaint.setTextSize(l.getDimens(getContext(), R.dimen.tbds36));
        this.textPaint.setAntiAlias(true);
    }

    public void setConfig(a aVar) {
        if (aVar != null) {
            this.djr = aVar;
            this.djr.djL = this.djx;
            this.djv = true;
        }
    }

    public a getStyleConfig() {
        return this.djr;
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
                if (getContentWidth() + (this.djr.djG * 2) != width) {
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
        if (width > 0 && getLayoutParams().width == -2 && getContentWidth() + (this.djr.djG * 2) != width) {
            requestLayout();
            return;
        }
        int height = getHeight();
        if (height > 0 && getLayoutParams().height == -2 && ((int) this.textPaint.getTextSize()) + (this.djr.djH * 2) != height) {
            requestLayout();
        }
    }

    public void setClickState(boolean z) {
        this.djw = z;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int measureWidth = measureWidth(i);
        setMeasuredDimension(measureWidth, !this.djr.djF ? measureHeight(i2) : measureWidth);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aIk() {
        this.djt = this.djr.aIp();
        this.dju = this.djr.aIq();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aIl() {
        if (getHeight() != 0) {
            this.djs = this.djr.ak(getHeight() / 2);
        }
    }

    private int measureWidth(int i) {
        float contentWidth = getContentWidth();
        if (View.MeasureSpec.getMode(i) == 1073741824) {
            return View.MeasureSpec.getSize(i);
        }
        return (int) Math.max(this.djr.djJ, contentWidth + (this.djr.djG * 2) + getPaddingLeft() + getPaddingRight());
    }

    private int measureHeight(int i) {
        float textSize = this.textPaint.getTextSize();
        if (View.MeasureSpec.getMode(i) == 1073741824) {
            return View.MeasureSpec.getSize(i);
        }
        return (int) Math.max(this.djr.bjo, textSize + (this.djr.djH * 2) + getPaddingTop() + getPaddingBottom());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getContentWidth() {
        int i = 0;
        if (this.djr.djC[0] > 0) {
            i = this.djr.djD;
            if (!StringUtils.isNull(this.text)) {
                i += this.djr.djI;
            }
        }
        if (this.djr.djC[1] > 0) {
            i = this.djr.djD;
            if (!StringUtils.isNull(this.text)) {
                i += this.djr.djI;
            }
        }
        return i + this.textWidth;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.djv) {
            aIl();
            aIk();
            this.djv = false;
        }
        if (this.djs != null) {
            if (this.djs instanceof GradientDrawable) {
                ((GradientDrawable) this.djs).setCornerRadius(getHeight() / 2);
            }
            this.djs.setBounds(0, 0, getWidth(), getHeight());
            this.djs.draw(canvas);
        }
        int width = ((getWidth() - getContentWidth()) - getPaddingRight()) / 2;
        int height = (getHeight() + getPaddingTop()) / 2;
        int i = this.djr.djD / 2;
        if (this.djt != null) {
            this.djt.setBounds(width, height - i, this.djr.djD + width, height + i);
            this.djt.draw(canvas);
            width += this.djr.djD + this.djr.djI;
        }
        if (this.dju != null) {
            this.dju.setBounds(this.djr.djI + width, height - i, this.djr.djI + width + this.djr.djD, height + i);
            this.dju.draw(canvas);
        }
        if (!StringUtils.isNull(this.text)) {
            Paint.FontMetrics fontMetrics = this.textPaint.getFontMetrics();
            float height2 = ((((getHeight() - getPaddingBottom()) + getPaddingTop()) + this.textPaint.getTextSize()) / 2.0f) - (fontMetrics.ascent - fontMetrics.top);
            this.textPaint.setColor(this.djr.djK ? am.getColor(this.djr.djz) : this.djr.djz);
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
        if (!this.djw) {
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

    public void aHL() {
        aIk();
        aIl();
        invalidate();
    }
}
