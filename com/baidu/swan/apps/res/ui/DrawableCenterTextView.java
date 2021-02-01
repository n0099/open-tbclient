package com.baidu.swan.apps.res.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.MotionEvent;
import android.widget.TextView;
import com.baidu.swan.apps.ao.ah;
/* loaded from: classes9.dex */
public class DrawableCenterTextView extends TextView {
    private GradientDrawable dvP;
    private Paint dvQ;
    private Pair<Object, Object> dvR;
    private Object dvS;
    private Object dvT;
    private int dvU;
    private boolean dvV;
    private boolean dvW;
    private boolean dvX;
    private boolean dvY;
    private float dvZ;
    private boolean dwa;
    private float mCornerRadius;
    private Path mRoundPath;

    public DrawableCenterTextView(Context context) {
        this(context, null);
    }

    public DrawableCenterTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dvP = new GradientDrawable();
        this.dvQ = null;
        this.mRoundPath = new Path();
        this.dvR = null;
        this.dvY = false;
        this.mCornerRadius = -1.0f;
        this.dvZ = 0.0f;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        q(canvas);
        p(canvas);
        super.onDraw(canvas);
    }

    private void p(Canvas canvas) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        Drawable[] compoundDrawables = getCompoundDrawables();
        Drawable drawable = null;
        if (compoundDrawables != null) {
            i = 0;
            while (i < compoundDrawables.length) {
                if (compoundDrawables[i] == null) {
                    i++;
                } else {
                    drawable = compoundDrawables[i];
                    break;
                }
            }
        }
        i = -1;
        int textViewWidth = ah.getTextViewWidth(this);
        int textViewHeight = ah.getTextViewHeight(this);
        int compoundDrawablePadding = getCompoundDrawablePadding();
        if (drawable != null) {
            Rect bounds = drawable.getBounds();
            i3 = bounds.right - bounds.left;
            i2 = bounds.bottom - bounds.top;
        } else {
            i2 = 0;
            i3 = 0;
        }
        if (i == 0 || i == 2) {
            i4 = textViewWidth + i3 + compoundDrawablePadding;
            i5 = 0;
        } else if (i == 1 || i == 3) {
            i5 = i2 + textViewHeight + compoundDrawablePadding;
            i4 = 0;
        } else {
            i5 = 0;
            i4 = 0;
        }
        int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
        switch (i) {
            case 0:
                setGravity(19);
                i7 = width - i4;
                i6 = 0;
                break;
            case 1:
                setGravity(49);
                i6 = height - i5;
                i7 = 0;
                break;
            case 2:
                setGravity(21);
                i7 = i4 - width;
                i6 = 0;
                break;
            case 3:
                setGravity(81);
                i6 = i5 - height;
                i7 = 0;
                break;
            default:
                setGravity(19);
                i7 = width - textViewWidth;
                i6 = 0;
                break;
        }
        canvas.translate(i7 / 2, i6 / 2);
    }

    private void q(Canvas canvas) {
        if (aGK()) {
            if (this.mCornerRadius >= 0.0f) {
                this.dvP.setCornerRadius(this.mCornerRadius);
            } else {
                this.dvP.setCornerRadius(4.0f);
            }
            if (this.dvW) {
                int dip2px = ah.dip2px(getContext(), 0.5f);
                if (this.dvS instanceof String) {
                    this.dvP.setStroke(dip2px, Color.parseColor(this.dvS.toString()));
                } else if (this.dvS instanceof Integer) {
                    this.dvP.setStroke(dip2px, getResources().getColor(Integer.valueOf(this.dvS.toString()).intValue()));
                }
            }
            if (this.dvY) {
                if (this.dvR.second instanceof String) {
                    this.dvP.setColor(Color.parseColor(this.dvR.second.toString()));
                } else if (this.dvR.second instanceof Integer) {
                    this.dvP.setColor(getResources().getColor(Integer.valueOf(this.dvR.second.toString()).intValue()));
                }
            } else if (this.dvR.first instanceof String) {
                this.dvP.setColor(Color.parseColor(this.dvR.first.toString()));
            } else if (this.dvR.first instanceof Integer) {
                this.dvP.setColor(getResources().getColor(Integer.valueOf(this.dvR.first.toString()).intValue()));
            }
            canvas.save();
            if (this.dwa) {
                aGI();
            } else {
                this.dvP.setBounds(0, 0, getWidth(), getHeight());
            }
            this.dvP.draw(canvas);
            if (this.dvX) {
                r(canvas);
            }
            canvas.restore();
        }
    }

    private void r(Canvas canvas) {
        float height;
        float f;
        float width = getWidth();
        float height2 = getHeight();
        Paint paint = new Paint();
        paint.setStrokeWidth(ah.dip2px(getContext(), 0.5f));
        if (this.dvT instanceof String) {
            paint.setColor(Color.parseColor(this.dvT.toString()));
        } else if (this.dvT instanceof Integer) {
            paint.setColor(getResources().getColor(Integer.valueOf(this.dvT.toString()).intValue()));
        }
        switch (this.dvU) {
            case 0:
                width = 0.0f;
                height = 0.0f;
                f = 0.0f;
                break;
            case 1:
                height2 = 0.0f;
                height = 0.0f;
                f = 0.0f;
                break;
            case 2:
                f = getWidth();
                height = 0.0f;
                break;
            case 3:
                height = getHeight();
                f = 0.0f;
                break;
            default:
                height = 0.0f;
                f = 0.0f;
                break;
        }
        canvas.drawLine(f, height, width, height2, paint);
    }

    public void setAnimationPercent(float f) {
        if (this.dvZ != f) {
            this.dvZ = f;
            postInvalidate();
        }
    }

    public void setAnimationModeActive(boolean z) {
        this.dwa = z;
    }

    private void aGI() {
        if (this.dvP != null) {
            int[] iArr = {getWidth(), getHeight()};
            if (this.dwa) {
                iArr[0] = (int) (getWidth() * this.dvZ);
                iArr[1] = getHeight();
            }
            int width = getWidth() / 2;
            this.dvP.setBounds(width - (iArr[0] / 2), 0, (iArr[0] / 2) + width, getHeight());
        }
    }

    @Override // android.widget.TextView
    public void setShadowLayer(float f, float f2, float f3, int i) {
        aGJ();
        RectF rectF = new RectF(f, f, f, f);
        rectF.offset(f2, f3);
        setPadding(rectF.left < 0.0f ? 0 : (int) (rectF.left + 0.5f), rectF.top < 0.0f ? 0 : (int) (rectF.top + 0.5f), rectF.right < 0.0f ? 0 : (int) (rectF.right + 0.5f), rectF.bottom >= 0.0f ? (int) (rectF.bottom + 0.5f) : 0);
        this.dvQ.setShadowLayer(f, f2, f3, i);
    }

    private void aGJ() {
        if (this.dvQ == null) {
            this.dvQ = new Paint();
            this.dvQ.setColor(0);
            this.dvQ.setStyle(Paint.Style.STROKE);
            this.dvQ.setAntiAlias(true);
            this.dvQ.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        }
    }

    public void a(Drawable drawable, int i, int i2, int i3) {
        if (drawable != null && i > -1 && i <= 3) {
            if (i2 <= 0 || i3 <= 0) {
                i2 = drawable.getIntrinsicWidth();
                i3 = drawable.getIntrinsicHeight();
            }
            drawable.setBounds(0, 0, i2, i3);
            switch (i) {
                case 0:
                    setCompoundDrawables(drawable, null, null, null);
                    return;
                case 1:
                    setCompoundDrawables(null, drawable, null, null);
                    return;
                case 2:
                    setCompoundDrawables(null, null, drawable, null);
                    return;
                case 3:
                    setCompoundDrawables(null, null, null, drawable);
                    return;
                default:
                    return;
            }
        }
    }

    public void ix(int i) {
        this.mCornerRadius = i;
    }

    private boolean aGK() {
        return this.dvV && this.dvR != null;
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                if (aGK()) {
                    this.dvY = true;
                    invalidate();
                    break;
                }
                break;
            case 1:
                if (aGK()) {
                    this.dvY = false;
                    invalidate();
                    break;
                }
                break;
            case 3:
                if (aGK()) {
                    this.dvY = false;
                    invalidate();
                    break;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }
}
