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
import com.baidu.swan.apps.an.z;
/* loaded from: classes2.dex */
public class DrawableCenterTextView extends TextView {
    private GradientDrawable aJC;
    private Paint aJD;
    private Pair<Object, Object> aJE;
    private Object aJF;
    private Object aJG;
    private int aJH;
    private boolean aJI;
    private boolean aJJ;
    private boolean aJK;
    private boolean aJL;
    private float aJM;
    private boolean aJN;
    private float mCornerRadius;
    private Path mRoundPath;

    public DrawableCenterTextView(Context context) {
        this(context, null);
    }

    public DrawableCenterTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aJC = new GradientDrawable();
        this.aJD = null;
        this.mRoundPath = new Path();
        this.aJE = null;
        this.aJL = false;
        this.mCornerRadius = -1.0f;
        this.aJM = 0.0f;
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
        int b = z.b(this);
        int a = z.a(this);
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
        if (Kc()) {
            if (this.mCornerRadius >= 0.0f) {
                this.aJC.setCornerRadius(this.mCornerRadius);
            } else {
                this.aJC.setCornerRadius(4.0f);
            }
            if (this.aJJ) {
                int dip2px = z.dip2px(getContext(), 0.5f);
                if (this.aJF instanceof String) {
                    this.aJC.setStroke(dip2px, Color.parseColor(this.aJF.toString()));
                } else if (this.aJF instanceof Integer) {
                    this.aJC.setStroke(dip2px, getResources().getColor(Integer.valueOf(this.aJF.toString()).intValue()));
                }
            }
            if (this.aJL) {
                if (this.aJE.second instanceof String) {
                    this.aJC.setColor(Color.parseColor(this.aJE.second.toString()));
                } else if (this.aJE.second instanceof Integer) {
                    this.aJC.setColor(getResources().getColor(Integer.valueOf(this.aJE.second.toString()).intValue()));
                }
            } else if (this.aJE.first instanceof String) {
                this.aJC.setColor(Color.parseColor(this.aJE.first.toString()));
            } else if (this.aJE.first instanceof Integer) {
                this.aJC.setColor(getResources().getColor(Integer.valueOf(this.aJE.first.toString()).intValue()));
            }
            canvas.save();
            if (this.aJN) {
                Ka();
            } else {
                this.aJC.setBounds(0, 0, getWidth(), getHeight());
            }
            this.aJC.draw(canvas);
            if (this.aJK) {
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
        paint.setStrokeWidth(z.dip2px(getContext(), 0.5f));
        if (this.aJG instanceof String) {
            paint.setColor(Color.parseColor(this.aJG.toString()));
        } else if (this.aJG instanceof Integer) {
            paint.setColor(getResources().getColor(Integer.valueOf(this.aJG.toString()).intValue()));
        }
        switch (this.aJH) {
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
        if (this.aJM != f) {
            this.aJM = f;
            postInvalidate();
        }
    }

    public void setAnimationModeActive(boolean z) {
        this.aJN = z;
    }

    private void Ka() {
        if (this.aJC != null) {
            int[] iArr = {getWidth(), getHeight()};
            if (this.aJN) {
                iArr[0] = (int) (getWidth() * this.aJM);
                iArr[1] = getHeight();
            }
            int width = getWidth() / 2;
            this.aJC.setBounds(width - (iArr[0] / 2), 0, (iArr[0] / 2) + width, getHeight());
        }
    }

    @Override // android.widget.TextView
    public void setShadowLayer(float f, float f2, float f3, int i) {
        Kb();
        RectF rectF = new RectF(f, f, f, f);
        rectF.offset(f2, f3);
        setPadding(rectF.left < 0.0f ? 0 : (int) (rectF.left + 0.5f), rectF.top < 0.0f ? 0 : (int) (rectF.top + 0.5f), rectF.right < 0.0f ? 0 : (int) (rectF.right + 0.5f), rectF.bottom >= 0.0f ? (int) (rectF.bottom + 0.5f) : 0);
        this.aJD.setShadowLayer(f, f2, f3, i);
    }

    private void Kb() {
        if (this.aJD == null) {
            this.aJD = new Paint();
            this.aJD.setColor(0);
            this.aJD.setStyle(Paint.Style.STROKE);
            this.aJD.setAntiAlias(true);
            this.aJD.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
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

    public void cU(int i) {
        this.mCornerRadius = i;
    }

    private boolean Kc() {
        return this.aJI && this.aJE != null;
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                if (Kc()) {
                    this.aJL = true;
                    invalidate();
                    break;
                }
                break;
            case 1:
                if (Kc()) {
                    this.aJL = false;
                    invalidate();
                    break;
                }
                break;
            case 3:
                if (Kc()) {
                    this.aJL = false;
                    invalidate();
                    break;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }
}
