package com.baidu.nadcore.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import java.lang.reflect.Field;
/* loaded from: classes3.dex */
public class LoadingProgressBar extends ProgressBar {
    public int a;
    public Drawable b;
    public long c;
    public int d;

    @Override // android.widget.ProgressBar, android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
    }

    public LoadingProgressBar(Context context) {
        super(context);
        this.a = 0;
        a();
    }

    @Override // android.widget.ProgressBar
    public synchronized void setIndeterminate(boolean z) {
        super.setIndeterminate(z);
        if (z) {
            this.b = getIndeterminateDrawable();
        }
    }

    @Override // android.widget.ProgressBar
    public synchronized void setIndeterminateDrawable(Drawable drawable) {
        super.setIndeterminateDrawable(drawable);
        if (isIndeterminate()) {
            this.b = drawable;
        }
    }

    public LoadingProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = 0;
        a();
    }

    public LoadingProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = 0;
        a();
    }

    public final void a() {
        this.d = 200;
        try {
            Field declaredField = ProgressBar.class.getDeclaredField("mDuration");
            if (declaredField != null) {
                declaredField.setAccessible(true);
                this.d = (int) ((declaredField.getInt(this) / 12.0f) + 0.5f);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.d = (int) ((((this.d * 12.0f) / 36.0f) / 2.0f) + 0.5f);
    }

    @Override // android.widget.ProgressBar, android.view.View
    public synchronized void onDraw(Canvas canvas) {
        Drawable drawable = this.b;
        if (drawable == null) {
            return;
        }
        drawable.draw(canvas);
        if (SystemClock.uptimeMillis() - this.c >= this.d) {
            this.c = SystemClock.uptimeMillis();
            int i = this.a + 277;
            this.a = i;
            if (i >= 10000) {
                this.a = i - 10000;
            }
            drawable.setLevel(this.a);
            postInvalidateDelayed(this.d);
        }
    }
}
