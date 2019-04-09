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
    private GradientDrawable aGD;
    private Paint aGE;
    private Pair<Object, Object> aGF;
    private Object aGG;
    private Object aGH;
    private int aGI;
    private boolean aGJ;
    private boolean aGK;
    private boolean aGL;
    private boolean aGM;
    private float aGN;
    private boolean aGO;
    private float mCornerRadius;
    private Path mRoundPath;

    public DrawableCenterTextView(Context context) {
        this(context, null);
    }

    public DrawableCenterTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aGD = new GradientDrawable();
        this.aGE = null;
        this.mRoundPath = new Path();
        this.aGF = null;
        this.aGM = false;
        this.mCornerRadius = -1.0f;
        this.aGN = 0.0f;
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
                this.aGD.setCornerRadius(this.mCornerRadius);
            } else {
                this.aGD.setCornerRadius(4.0f);
            }
            if (this.aGK) {
                int dip2px = x.dip2px(getContext(), 0.5f);
                if (this.aGG instanceof String) {
                    this.aGD.setStroke(dip2px, Color.parseColor(this.aGG.toString()));
                } else if (this.aGG instanceof Integer) {
                    this.aGD.setStroke(dip2px, getResources().getColor(Integer.valueOf(this.aGG.toString()).intValue()));
                }
            }
            if (this.aGM) {
                if (this.aGF.second instanceof String) {
                    this.aGD.setColor(Color.parseColor(this.aGF.second.toString()));
                } else if (this.aGF.second instanceof Integer) {
                    this.aGD.setColor(getResources().getColor(Integer.valueOf(this.aGF.second.toString()).intValue()));
                }
            } else if (this.aGF.first instanceof String) {
                this.aGD.setColor(Color.parseColor(this.aGF.first.toString()));
            } else if (this.aGF.first instanceof Integer) {
                this.aGD.setColor(getResources().getColor(Integer.valueOf(this.aGF.first.toString()).intValue()));
            }
            canvas.save();
            if (this.aGO) {
                GT();
            } else {
                this.aGD.setBounds(0, 0, getWidth(), getHeight());
            }
            this.aGD.draw(canvas);
            if (this.aGL) {
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
        if (this.aGH instanceof String) {
            paint.setColor(Color.parseColor(this.aGH.toString()));
        } else if (this.aGH instanceof Integer) {
            paint.setColor(getResources().getColor(Integer.valueOf(this.aGH.toString()).intValue()));
        }
        switch (this.aGI) {
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
        if (this.aGN != f) {
            this.aGN = f;
            postInvalidate();
        }
    }

    public void setAnimationModeActive(boolean z) {
        this.aGO = z;
    }

    private void GT() {
        if (this.aGD != null) {
            int[] iArr = {getWidth(), getHeight()};
            if (this.aGO) {
                iArr[0] = (int) (getWidth() * this.aGN);
                iArr[1] = getHeight();
            }
            int width = getWidth() / 2;
            this.aGD.setBounds(width - (iArr[0] / 2), 0, (iArr[0] / 2) + width, getHeight());
        }
    }

    @Override // android.widget.TextView
    public void setShadowLayer(float f, float f2, float f3, int i) {
        GU();
        RectF rectF = new RectF(f, f, f, f);
        rectF.offset(f2, f3);
        setPadding(rectF.left < 0.0f ? 0 : (int) (rectF.left + 0.5f), rectF.top < 0.0f ? 0 : (int) (rectF.top + 0.5f), rectF.right < 0.0f ? 0 : (int) (rectF.right + 0.5f), rectF.bottom >= 0.0f ? (int) (rectF.bottom + 0.5f) : 0);
        this.aGE.setShadowLayer(f, f2, f3, i);
    }

    private void GU() {
        if (this.aGE == null) {
            this.aGE = new Paint();
            this.aGE.setColor(0);
            this.aGE.setStyle(Paint.Style.STROKE);
            this.aGE.setAntiAlias(true);
            this.aGE.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
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
        return this.aGJ && this.aGF != null;
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                if (GV()) {
                    this.aGM = true;
                    invalidate();
                    break;
                }
                break;
            case 1:
                if (GV()) {
                    this.aGM = false;
                    invalidate();
                    break;
                }
                break;
            case 3:
                if (GV()) {
                    this.aGM = false;
                    invalidate();
                    break;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }
}
