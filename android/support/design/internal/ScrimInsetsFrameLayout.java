package android.support.design.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.RestrictTo;
import android.support.design.R;
import android.support.v4.view.OnApplyWindowInsetsListener;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.WindowInsetsCompat;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
@RestrictTo
/* loaded from: classes2.dex */
public class ScrimInsetsFrameLayout extends FrameLayout {
    Drawable ku;
    Rect kv;
    private Rect mTempRect;

    public ScrimInsetsFrameLayout(Context context) {
        this(context, null);
    }

    public ScrimInsetsFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScrimInsetsFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mTempRect = new Rect();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ScrimInsetsFrameLayout, i, R.style.Widget_Design_ScrimInsetsFrameLayout);
        this.ku = obtainStyledAttributes.getDrawable(R.styleable.ScrimInsetsFrameLayout_insetForeground);
        obtainStyledAttributes.recycle();
        setWillNotDraw(true);
        ViewCompat.setOnApplyWindowInsetsListener(this, new OnApplyWindowInsetsListener() { // from class: android.support.design.internal.ScrimInsetsFrameLayout.1
            @Override // android.support.v4.view.OnApplyWindowInsetsListener
            public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                if (ScrimInsetsFrameLayout.this.kv == null) {
                    ScrimInsetsFrameLayout.this.kv = new Rect();
                }
                ScrimInsetsFrameLayout.this.kv.set(windowInsetsCompat.getSystemWindowInsetLeft(), windowInsetsCompat.getSystemWindowInsetTop(), windowInsetsCompat.getSystemWindowInsetRight(), windowInsetsCompat.getSystemWindowInsetBottom());
                ScrimInsetsFrameLayout.this.onInsetsChanged(windowInsetsCompat);
                ScrimInsetsFrameLayout.this.setWillNotDraw(!windowInsetsCompat.hasSystemWindowInsets() || ScrimInsetsFrameLayout.this.ku == null);
                ViewCompat.postInvalidateOnAnimation(ScrimInsetsFrameLayout.this);
                return windowInsetsCompat.consumeSystemWindowInsets();
            }
        });
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        int width = getWidth();
        int height = getHeight();
        if (this.kv != null && this.ku != null) {
            int save = canvas.save();
            canvas.translate(getScrollX(), getScrollY());
            this.mTempRect.set(0, 0, width, this.kv.top);
            this.ku.setBounds(this.mTempRect);
            this.ku.draw(canvas);
            this.mTempRect.set(0, height - this.kv.bottom, width, height);
            this.ku.setBounds(this.mTempRect);
            this.ku.draw(canvas);
            this.mTempRect.set(0, this.kv.top, this.kv.left, height - this.kv.bottom);
            this.ku.setBounds(this.mTempRect);
            this.ku.draw(canvas);
            this.mTempRect.set(width - this.kv.right, this.kv.top, width, height - this.kv.bottom);
            this.ku.setBounds(this.mTempRect);
            this.ku.draw(canvas);
            canvas.restoreToCount(save);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.ku != null) {
            this.ku.setCallback(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.ku != null) {
            this.ku.setCallback(null);
        }
    }

    protected void onInsetsChanged(WindowInsetsCompat windowInsetsCompat) {
    }
}
