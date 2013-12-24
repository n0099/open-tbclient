package android.support.v4.view;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
/* loaded from: classes.dex */
public class PagerTabStrip extends PagerTitleStrip {
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private final Paint l;
    private final Rect m;
    private int n;
    private boolean o;
    private boolean p;
    private int q;
    private boolean r;
    private float s;
    private float t;
    private int u;

    public void setTabIndicatorColor(int i) {
        this.f = i;
        this.l.setColor(this.f);
        invalidate();
    }

    public void setTabIndicatorColorResource(int i) {
        setTabIndicatorColor(getContext().getResources().getColor(i));
    }

    public int getTabIndicatorColor() {
        return this.f;
    }

    @Override // android.view.View
    public void setPadding(int i, int i2, int i3, int i4) {
        if (i4 < this.h) {
            i4 = this.h;
        }
        super.setPadding(i, i2, i3, i4);
    }

    @Override // android.support.v4.view.PagerTitleStrip
    public void setTextSpacing(int i) {
        if (i < this.i) {
            i = this.i;
        }
        super.setTextSpacing(i);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (!this.p) {
            this.o = drawable == null;
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        super.setBackgroundColor(i);
        if (!this.p) {
            this.o = ((-16777216) & i) == 0;
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (!this.p) {
            this.o = i == 0;
        }
    }

    public void setDrawFullUnderline(boolean z) {
        this.o = z;
        this.p = true;
        invalidate();
    }

    public boolean getDrawFullUnderline() {
        return this.o;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.support.v4.view.PagerTitleStrip
    public int getMinHeight() {
        return Math.max(super.getMinHeight(), this.j);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0 || !this.r) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            switch (action) {
                case 0:
                    this.s = x;
                    this.t = y;
                    this.r = false;
                    break;
                case 1:
                    if (x < this.c.getLeft() - this.k) {
                        this.a.setCurrentItem(this.a.getCurrentItem() - 1);
                        break;
                    } else if (x > this.c.getRight() + this.k) {
                        this.a.setCurrentItem(this.a.getCurrentItem() + 1);
                        break;
                    }
                    break;
                case 2:
                    if (Math.abs(x - this.s) > this.u || Math.abs(y - this.t) > this.u) {
                        this.r = true;
                        break;
                    }
                    break;
            }
            return true;
        }
        return false;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight();
        int left = this.c.getLeft() - this.k;
        int right = this.c.getRight() + this.k;
        int i = height - this.g;
        this.l.setColor((this.n << 24) | (this.f & 16777215));
        canvas.drawRect(left, i, right, height, this.l);
        if (this.o) {
            this.l.setColor((-16777216) | (this.f & 16777215));
            canvas.drawRect(getPaddingLeft(), height - this.q, getWidth() - getPaddingRight(), height, this.l);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.support.v4.view.PagerTitleStrip
    public void a(int i, float f, boolean z) {
        Rect rect = this.m;
        int height = getHeight();
        int left = this.c.getLeft() - this.k;
        int right = this.c.getRight() + this.k;
        int i2 = height - this.g;
        rect.set(left, i2, right, height);
        super.a(i, f, z);
        this.n = (int) (Math.abs(f - 0.5f) * 2.0f * 255.0f);
        rect.union(this.c.getLeft() - this.k, i2, this.c.getRight() + this.k, height);
        invalidate(rect);
    }
}
