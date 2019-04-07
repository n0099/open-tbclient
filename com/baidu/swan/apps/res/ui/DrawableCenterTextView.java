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
    private GradientDrawable aGC;
    private Paint aGD;
    private Pair<Object, Object> aGE;
    private Object aGF;
    private Object aGG;
    private int aGH;
    private boolean aGI;
    private boolean aGJ;
    private boolean aGK;
    private boolean aGL;
    private float aGM;
    private boolean aGN;
    private float mCornerRadius;
    private Path mRoundPath;

    public DrawableCenterTextView(Context context) {
        this(context, null);
    }

    public DrawableCenterTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aGC = new GradientDrawable();
        this.aGD = null;
        this.mRoundPath = new Path();
        this.aGE = null;
        this.aGL = false;
        this.mCornerRadius = -1.0f;
        this.aGM = 0.0f;
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
        if (GV()) {
            if (this.mCornerRadius >= 0.0f) {
                this.aGC.setCornerRadius(this.mCornerRadius);
            } else {
                this.aGC.setCornerRadius(4.0f);
            }
            if (this.aGJ) {
                int dip2px = x.dip2px(getContext(), 0.5f);
                if (this.aGF instanceof String) {
                    this.aGC.setStroke(dip2px, Color.parseColor(this.aGF.toString()));
                } else if (this.aGF instanceof Integer) {
                    this.aGC.setStroke(dip2px, getResources().getColor(Integer.valueOf(this.aGF.toString()).intValue()));
                }
            }
            if (this.aGL) {
                if (this.aGE.second instanceof String) {
                    this.aGC.setColor(Color.parseColor(this.aGE.second.toString()));
                } else if (this.aGE.second instanceof Integer) {
                    this.aGC.setColor(getResources().getColor(Integer.valueOf(this.aGE.second.toString()).intValue()));
                }
            } else if (this.aGE.first instanceof String) {
                this.aGC.setColor(Color.parseColor(this.aGE.first.toString()));
            } else if (this.aGE.first instanceof Integer) {
                this.aGC.setColor(getResources().getColor(Integer.valueOf(this.aGE.first.toString()).intValue()));
            }
            canvas.save();
            if (this.aGN) {
                GT();
            } else {
                this.aGC.setBounds(0, 0, getWidth(), getHeight());
            }
            this.aGC.draw(canvas);
            if (this.aGK) {
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
        if (this.aGG instanceof String) {
            paint.setColor(Color.parseColor(this.aGG.toString()));
        } else if (this.aGG instanceof Integer) {
            paint.setColor(getResources().getColor(Integer.valueOf(this.aGG.toString()).intValue()));
        }
        switch (this.aGH) {
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
        if (this.aGM != f) {
            this.aGM = f;
            postInvalidate();
        }
    }

    public void setAnimationModeActive(boolean z) {
        this.aGN = z;
    }

    private void GT() {
        if (this.aGC != null) {
            int[] iArr = {getWidth(), getHeight()};
            if (this.aGN) {
                iArr[0] = (int) (getWidth() * this.aGM);
                iArr[1] = getHeight();
            }
            int width = getWidth() / 2;
            this.aGC.setBounds(width - (iArr[0] / 2), 0, (iArr[0] / 2) + width, getHeight());
        }
    }

    @Override // android.widget.TextView
    public void setShadowLayer(float f, float f2, float f3, int i) {
        GU();
        RectF rectF = new RectF(f, f, f, f);
        rectF.offset(f2, f3);
        setPadding(rectF.left < 0.0f ? 0 : (int) (rectF.left + 0.5f), rectF.top < 0.0f ? 0 : (int) (rectF.top + 0.5f), rectF.right < 0.0f ? 0 : (int) (rectF.right + 0.5f), rectF.bottom >= 0.0f ? (int) (rectF.bottom + 0.5f) : 0);
        this.aGD.setShadowLayer(f, f2, f3, i);
    }

    private void GU() {
        if (this.aGD == null) {
            this.aGD = new Paint();
            this.aGD.setColor(0);
            this.aGD.setStyle(Paint.Style.STROKE);
            this.aGD.setAntiAlias(true);
            this.aGD.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
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

    public void cL(int i) {
        this.mCornerRadius = i;
    }

    private boolean GV() {
        return this.aGI && this.aGE != null;
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                if (GV()) {
                    this.aGL = true;
                    invalidate();
                    break;
                }
                break;
            case 1:
                if (GV()) {
                    this.aGL = false;
                    invalidate();
                    break;
                }
                break;
            case 3:
                if (GV()) {
                    this.aGL = false;
                    invalidate();
                    break;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }
}
