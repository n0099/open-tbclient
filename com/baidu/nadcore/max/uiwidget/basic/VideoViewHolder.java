package com.baidu.nadcore.max.uiwidget.basic;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: classes2.dex */
public class VideoViewHolder extends FrameLayout {
    public int a;
    public int b;
    public a c;
    public boolean d;

    /* loaded from: classes2.dex */
    public interface a {
        void a();

        void onClick();

        void onTouch(View view2, MotionEvent motionEvent);
    }

    public VideoViewHolder(@NonNull Context context) {
        this(context, null);
    }

    public void setEnableSlideLeft(boolean z) {
        this.d = z;
    }

    public void setInterceptOnTouchListener(a aVar) {
        this.c = aVar;
    }

    public VideoViewHolder(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VideoViewHolder(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final boolean a(int i, int i2) {
        if (!this.d || getWidth() <= 0 || getHeight() <= 0 || this.b - i2 > 0 || (this.a - i) / getWidth() <= 0.1f || Math.abs((this.b - i2) / getHeight()) >= 0.05f) {
            return false;
        }
        return true;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int rawX = (int) motionEvent.getRawX();
        int rawY = (int) motionEvent.getRawY();
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            if (action == 1 && this.c != null) {
                if (a(rawX, rawY)) {
                    this.c.a();
                } else {
                    this.c.onClick();
                }
            }
        } else {
            this.a = (int) motionEvent.getRawX();
            this.b = (int) motionEvent.getRawY();
        }
        a aVar = this.c;
        if (aVar != null) {
            aVar.onTouch(this, motionEvent);
            return false;
        }
        return false;
    }
}
