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
    public Object dfk;
    private a dfl;
    private Drawable dfm;
    private Drawable dfn;
    private Drawable dfo;
    private boolean dfp;
    private boolean dfq;
    private a.InterfaceC0370a dfr;
    private String text;
    private Paint textPaint;
    private int textWidth;

    public TBSpecificationBtn(Context context) {
        super(context);
        this.dfk = null;
        this.text = "";
        this.dfp = true;
        this.dfq = true;
        this.dfr = new a.InterfaceC0370a() { // from class: com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn.1
            @Override // com.baidu.tbadk.core.view.commonBtn.a.InterfaceC0370a
            public void aFX() {
                int width = TBSpecificationBtn.this.getWidth();
                if (width > 0 && TBSpecificationBtn.this.getLayoutParams().width == -2 && TBSpecificationBtn.this.getContentWidth() + (TBSpecificationBtn.this.dfl.dfA * 2) != width) {
                    TBSpecificationBtn.this.requestLayout();
                }
            }

            @Override // com.baidu.tbadk.core.view.commonBtn.a.InterfaceC0370a
            public void aFY() {
                TBSpecificationBtn.this.aFV();
                int width = TBSpecificationBtn.this.getWidth();
                if (width > 0 && TBSpecificationBtn.this.getLayoutParams().width == -2 && TBSpecificationBtn.this.getContentWidth() + (TBSpecificationBtn.this.dfl.dfA * 2) != width) {
                    TBSpecificationBtn.this.requestLayout();
                } else {
                    TBSpecificationBtn.this.invalidate();
                }
            }

            @Override // com.baidu.tbadk.core.view.commonBtn.a.InterfaceC0370a
            public void aFZ() {
                TBSpecificationBtn.this.aFW();
                TBSpecificationBtn.this.invalidate();
            }
        };
        init();
    }

    public TBSpecificationBtn(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dfk = null;
        this.text = "";
        this.dfp = true;
        this.dfq = true;
        this.dfr = new a.InterfaceC0370a() { // from class: com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn.1
            @Override // com.baidu.tbadk.core.view.commonBtn.a.InterfaceC0370a
            public void aFX() {
                int width = TBSpecificationBtn.this.getWidth();
                if (width > 0 && TBSpecificationBtn.this.getLayoutParams().width == -2 && TBSpecificationBtn.this.getContentWidth() + (TBSpecificationBtn.this.dfl.dfA * 2) != width) {
                    TBSpecificationBtn.this.requestLayout();
                }
            }

            @Override // com.baidu.tbadk.core.view.commonBtn.a.InterfaceC0370a
            public void aFY() {
                TBSpecificationBtn.this.aFV();
                int width = TBSpecificationBtn.this.getWidth();
                if (width > 0 && TBSpecificationBtn.this.getLayoutParams().width == -2 && TBSpecificationBtn.this.getContentWidth() + (TBSpecificationBtn.this.dfl.dfA * 2) != width) {
                    TBSpecificationBtn.this.requestLayout();
                } else {
                    TBSpecificationBtn.this.invalidate();
                }
            }

            @Override // com.baidu.tbadk.core.view.commonBtn.a.InterfaceC0370a
            public void aFZ() {
                TBSpecificationBtn.this.aFW();
                TBSpecificationBtn.this.invalidate();
            }
        };
        init();
    }

    public TBSpecificationBtn(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dfk = null;
        this.text = "";
        this.dfp = true;
        this.dfq = true;
        this.dfr = new a.InterfaceC0370a() { // from class: com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn.1
            @Override // com.baidu.tbadk.core.view.commonBtn.a.InterfaceC0370a
            public void aFX() {
                int width = TBSpecificationBtn.this.getWidth();
                if (width > 0 && TBSpecificationBtn.this.getLayoutParams().width == -2 && TBSpecificationBtn.this.getContentWidth() + (TBSpecificationBtn.this.dfl.dfA * 2) != width) {
                    TBSpecificationBtn.this.requestLayout();
                }
            }

            @Override // com.baidu.tbadk.core.view.commonBtn.a.InterfaceC0370a
            public void aFY() {
                TBSpecificationBtn.this.aFV();
                int width = TBSpecificationBtn.this.getWidth();
                if (width > 0 && TBSpecificationBtn.this.getLayoutParams().width == -2 && TBSpecificationBtn.this.getContentWidth() + (TBSpecificationBtn.this.dfl.dfA * 2) != width) {
                    TBSpecificationBtn.this.requestLayout();
                } else {
                    TBSpecificationBtn.this.invalidate();
                }
            }

            @Override // com.baidu.tbadk.core.view.commonBtn.a.InterfaceC0370a
            public void aFZ() {
                TBSpecificationBtn.this.aFW();
                TBSpecificationBtn.this.invalidate();
            }
        };
        init();
    }

    private void init() {
        this.dfl = new c();
        this.dfl.dfF = this.dfr;
        this.textPaint = new Paint();
        this.textPaint.setTextSize(l.getDimens(getContext(), R.dimen.tbds36));
        this.textPaint.setAntiAlias(true);
    }

    public void setConfig(a aVar) {
        if (aVar != null) {
            this.dfl = aVar;
            this.dfl.dfF = this.dfr;
            this.dfp = true;
        }
    }

    public a getStyleConfig() {
        return this.dfl;
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
                if (getContentWidth() + (this.dfl.dfA * 2) != width) {
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
        if (width > 0 && getLayoutParams().width == -2 && getContentWidth() + (this.dfl.dfA * 2) != width) {
            requestLayout();
            return;
        }
        int height = getHeight();
        if (height > 0 && getLayoutParams().height == -2 && ((int) this.textPaint.getTextSize()) + (this.dfl.dfB * 2) != height) {
            requestLayout();
        }
    }

    public void setClickState(boolean z) {
        this.dfq = z;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int measureWidth = measureWidth(i);
        setMeasuredDimension(measureWidth, !this.dfl.dfz ? measureHeight(i2) : measureWidth);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aFV() {
        this.dfn = this.dfl.aGa();
        this.dfo = this.dfl.aGb();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aFW() {
        if (getHeight() != 0) {
            this.dfm = this.dfl.al(getHeight() / 2);
        }
    }

    private int measureWidth(int i) {
        float contentWidth = getContentWidth();
        if (View.MeasureSpec.getMode(i) == 1073741824) {
            return View.MeasureSpec.getSize(i);
        }
        return (int) Math.max(this.dfl.dfD, contentWidth + (this.dfl.dfA * 2) + getPaddingLeft() + getPaddingRight());
    }

    private int measureHeight(int i) {
        float textSize = this.textPaint.getTextSize();
        if (View.MeasureSpec.getMode(i) == 1073741824) {
            return View.MeasureSpec.getSize(i);
        }
        return (int) Math.max(this.dfl.beZ, textSize + (this.dfl.dfB * 2) + getPaddingTop() + getPaddingBottom());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getContentWidth() {
        int i = 0;
        if (this.dfl.dfw[0] > 0) {
            i = this.dfl.dfx;
            if (!StringUtils.isNull(this.text)) {
                i += this.dfl.dfC;
            }
        }
        if (this.dfl.dfw[1] > 0) {
            i = this.dfl.dfx;
            if (!StringUtils.isNull(this.text)) {
                i += this.dfl.dfC;
            }
        }
        return i + this.textWidth;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.dfp) {
            aFW();
            aFV();
            this.dfp = false;
        }
        if (this.dfm != null) {
            if (this.dfm instanceof GradientDrawable) {
                ((GradientDrawable) this.dfm).setCornerRadius(getHeight() / 2);
            }
            this.dfm.setBounds(0, 0, getWidth(), getHeight());
            this.dfm.draw(canvas);
        }
        int width = ((getWidth() - getContentWidth()) - getPaddingRight()) / 2;
        int height = (getHeight() + getPaddingTop()) / 2;
        int i = this.dfl.dfx / 2;
        if (this.dfn != null) {
            this.dfn.setBounds(width, height - i, this.dfl.dfx + width, height + i);
            this.dfn.draw(canvas);
            width += this.dfl.dfx + this.dfl.dfC;
        }
        if (this.dfo != null) {
            this.dfo.setBounds(this.dfl.dfC + width, height - i, this.dfl.dfC + width + this.dfl.dfx, height + i);
            this.dfo.draw(canvas);
        }
        if (!StringUtils.isNull(this.text)) {
            Paint.FontMetrics fontMetrics = this.textPaint.getFontMetrics();
            float height2 = ((((getHeight() - getPaddingBottom()) + getPaddingTop()) + this.textPaint.getTextSize()) / 2.0f) - (fontMetrics.ascent - fontMetrics.top);
            this.textPaint.setColor(this.dfl.dfE ? am.getColor(this.dfl.dft) : this.dfl.dft);
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
        if (!this.dfq) {
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

    public void aFw() {
        aFV();
        aFW();
        invalidate();
    }
}
