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
import com.baidu.swan.apps.an.x;
/* loaded from: classes2.dex */
public class DrawableCenterTextView extends TextView {
    private Paint aGA;
    private Pair<Object, Object> aGB;
    private Object aGC;
    private Object aGD;
    private int aGE;
    private boolean aGF;
    private boolean aGG;
    private boolean aGH;
    private boolean aGI;
    private float aGJ;
    private boolean aGK;
    private GradientDrawable aGz;
    private float mCornerRadius;
    private Path mRoundPath;

    public DrawableCenterTextView(Context context) {
        this(context, null);
    }

    public DrawableCenterTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aGz = new GradientDrawable();
        this.aGA = null;
        this.mRoundPath = new Path();
        this.aGB = null;
        this.aGI = false;
        this.mCornerRadius = -1.0f;
        this.aGJ = 0.0f;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        h(canvas);
        g(canvas);
        super.onDraw(canvas);
    }

    private void g(Canvas canvas) {
        int i;
        Drawable drawable;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7 = 0;
        Drawable[] compoundDrawables = getCompoundDrawables();
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
        drawable = null;
        int b = x.b(this);
        int a = x.a(this);
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
            i4 = b + i3 + compoundDrawablePadding;
            i5 = 0;
        } else if (i == 1 || i == 3) {
            i5 = i2 + a + compoundDrawablePadding;
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
                i6 = width - i4;
                break;
            case 1:
                setGravity(49);
                i6 = 0;
                i7 = height - i5;
                break;
            case 2:
                setGravity(21);
                i6 = i4 - width;
                break;
            case 3:
                setGravity(81);
                i6 = 0;
                i7 = i5 - height;
                break;
            default:
                setGravity(19);
                i6 = width - b;
                break;
        }
        canvas.translate(i6 / 2, i7 / 2);
    }

    private void h(Canvas canvas) {
        if (GX()) {
            if (this.mCornerRadius >= 0.0f) {
                this.aGz.setCornerRadius(this.mCornerRadius);
            } else {
                this.aGz.setCornerRadius(4.0f);
            }
            if (this.aGG) {
                int dip2px = x.dip2px(getContext(), 0.5f);
                if (this.aGC instanceof String) {
                    this.aGz.setStroke(dip2px, Color.parseColor(this.aGC.toString()));
                } else if (this.aGC instanceof Integer) {
                    this.aGz.setStroke(dip2px, getResources().getColor(Integer.valueOf(this.aGC.toString()).intValue()));
                }
            }
            if (this.aGI) {
                if (this.aGB.second instanceof String) {
                    this.aGz.setColor(Color.parseColor(this.aGB.second.toString()));
                } else if (this.aGB.second instanceof Integer) {
                    this.aGz.setColor(getResources().getColor(Integer.valueOf(this.aGB.second.toString()).intValue()));
                }
            } else if (this.aGB.first instanceof String) {
                this.aGz.setColor(Color.parseColor(this.aGB.first.toString()));
            } else if (this.aGB.first instanceof Integer) {
                this.aGz.setColor(getResources().getColor(Integer.valueOf(this.aGB.first.toString()).intValue()));
            }
            canvas.save();
            if (this.aGK) {
                GV();
            } else {
                this.aGz.setBounds(0, 0, getWidth(), getHeight());
            }
            this.aGz.draw(canvas);
            if (this.aGH) {
                i(canvas);
            }
            canvas.restore();
        }
    }

    private void i(Canvas canvas) {
        float height;
        float f;
        float width = getWidth();
        float height2 = getHeight();
        Paint paint = new Paint();
        paint.setStrokeWidth(x.dip2px(getContext(), 0.5f));
        if (this.aGD instanceof String) {
            paint.setColor(Color.parseColor(this.aGD.toString()));
        } else if (this.aGD instanceof Integer) {
            paint.setColor(getResources().getColor(Integer.valueOf(this.aGD.toString()).intValue()));
        }
        switch (this.aGE) {
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
        if (this.aGJ != f) {
            this.aGJ = f;
            postInvalidate();
        }
    }

    public void setAnimationModeActive(boolean z) {
        this.aGK = z;
    }

    private void GV() {
        if (this.aGz != null) {
            int[] iArr = {getWidth(), getHeight()};
            if (this.aGK) {
                iArr[0] = (int) (getWidth() * this.aGJ);
                iArr[1] = getHeight();
            }
            int width = getWidth() / 2;
            this.aGz.setBounds(width - (iArr[0] / 2), 0, (iArr[0] / 2) + width, getHeight());
        }
    }

    @Override // android.widget.TextView
    public void setShadowLayer(float f, float f2, float f3, int i) {
        GW();
        RectF rectF = new RectF(f, f, f, f);
        rectF.offset(f2, f3);
        setPadding(rectF.left < 0.0f ? 0 : (int) (rectF.left + 0.5f), rectF.top < 0.0f ? 0 : (int) (rectF.top + 0.5f), rectF.right < 0.0f ? 0 : (int) (rectF.right + 0.5f), rectF.bottom >= 0.0f ? (int) (rectF.bottom + 0.5f) : 0);
        this.aGA.setShadowLayer(f, f2, f3, i);
    }

    private void GW() {
        if (this.aGA == null) {
            this.aGA = new Paint();
            this.aGA.setColor(0);
            this.aGA.setStyle(Paint.Style.STROKE);
            this.aGA.setAntiAlias(true);
            this.aGA.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
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

    public void cM(int i) {
        this.mCornerRadius = i;
    }

    private boolean GX() {
        return this.aGF && this.aGB != null;
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                if (GX()) {
                    this.aGI = true;
                    invalidate();
                    break;
                }
                break;
            case 1:
                if (GX()) {
                    this.aGI = false;
                    invalidate();
                    break;
                }
                break;
            case 3:
                if (GX()) {
                    this.aGI = false;
                    invalidate();
                    break;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }
}
