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
    private Object aIA;
    private int aIB;
    private boolean aIC;
    private boolean aID;
    private boolean aIE;
    private boolean aIF;
    private float aIG;
    private boolean aIH;
    private GradientDrawable aIw;
    private Paint aIx;
    private Pair<Object, Object> aIy;
    private Object aIz;
    private float mCornerRadius;
    private Path mRoundPath;

    public DrawableCenterTextView(Context context) {
        this(context, null);
    }

    public DrawableCenterTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aIw = new GradientDrawable();
        this.aIx = null;
        this.mRoundPath = new Path();
        this.aIy = null;
        this.aIF = false;
        this.mCornerRadius = -1.0f;
        this.aIG = 0.0f;
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
        if (Jl()) {
            if (this.mCornerRadius >= 0.0f) {
                this.aIw.setCornerRadius(this.mCornerRadius);
            } else {
                this.aIw.setCornerRadius(4.0f);
            }
            if (this.aID) {
                int dip2px = z.dip2px(getContext(), 0.5f);
                if (this.aIz instanceof String) {
                    this.aIw.setStroke(dip2px, Color.parseColor(this.aIz.toString()));
                } else if (this.aIz instanceof Integer) {
                    this.aIw.setStroke(dip2px, getResources().getColor(Integer.valueOf(this.aIz.toString()).intValue()));
                }
            }
            if (this.aIF) {
                if (this.aIy.second instanceof String) {
                    this.aIw.setColor(Color.parseColor(this.aIy.second.toString()));
                } else if (this.aIy.second instanceof Integer) {
                    this.aIw.setColor(getResources().getColor(Integer.valueOf(this.aIy.second.toString()).intValue()));
                }
            } else if (this.aIy.first instanceof String) {
                this.aIw.setColor(Color.parseColor(this.aIy.first.toString()));
            } else if (this.aIy.first instanceof Integer) {
                this.aIw.setColor(getResources().getColor(Integer.valueOf(this.aIy.first.toString()).intValue()));
            }
            canvas.save();
            if (this.aIH) {
                Jj();
            } else {
                this.aIw.setBounds(0, 0, getWidth(), getHeight());
            }
            this.aIw.draw(canvas);
            if (this.aIE) {
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
        if (this.aIA instanceof String) {
            paint.setColor(Color.parseColor(this.aIA.toString()));
        } else if (this.aIA instanceof Integer) {
            paint.setColor(getResources().getColor(Integer.valueOf(this.aIA.toString()).intValue()));
        }
        switch (this.aIB) {
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
        if (this.aIG != f) {
            this.aIG = f;
            postInvalidate();
        }
    }

    public void setAnimationModeActive(boolean z) {
        this.aIH = z;
    }

    private void Jj() {
        if (this.aIw != null) {
            int[] iArr = {getWidth(), getHeight()};
            if (this.aIH) {
                iArr[0] = (int) (getWidth() * this.aIG);
                iArr[1] = getHeight();
            }
            int width = getWidth() / 2;
            this.aIw.setBounds(width - (iArr[0] / 2), 0, (iArr[0] / 2) + width, getHeight());
        }
    }

    @Override // android.widget.TextView
    public void setShadowLayer(float f, float f2, float f3, int i) {
        Jk();
        RectF rectF = new RectF(f, f, f, f);
        rectF.offset(f2, f3);
        setPadding(rectF.left < 0.0f ? 0 : (int) (rectF.left + 0.5f), rectF.top < 0.0f ? 0 : (int) (rectF.top + 0.5f), rectF.right < 0.0f ? 0 : (int) (rectF.right + 0.5f), rectF.bottom >= 0.0f ? (int) (rectF.bottom + 0.5f) : 0);
        this.aIx.setShadowLayer(f, f2, f3, i);
    }

    private void Jk() {
        if (this.aIx == null) {
            this.aIx = new Paint();
            this.aIx.setColor(0);
            this.aIx.setStyle(Paint.Style.STROKE);
            this.aIx.setAntiAlias(true);
            this.aIx.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
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

    public void cQ(int i) {
        this.mCornerRadius = i;
    }

    private boolean Jl() {
        return this.aIC && this.aIy != null;
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                if (Jl()) {
                    this.aIF = true;
                    invalidate();
                    break;
                }
                break;
            case 1:
                if (Jl()) {
                    this.aIF = false;
                    invalidate();
                    break;
                }
                break;
            case 3:
                if (Jl()) {
                    this.aIF = false;
                    invalidate();
                    break;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }
}
