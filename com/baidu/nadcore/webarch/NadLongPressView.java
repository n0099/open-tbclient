package com.baidu.nadcore.webarch;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;
import androidx.annotation.Nullable;
/* loaded from: classes2.dex */
public class NadLongPressView extends ImageView {
    public int a;
    public int b;
    public boolean c;
    public final Runnable d;
    public b e;

    /* loaded from: classes2.dex */
    public interface b {
        void a();
    }

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (NadLongPressView.this.e != null) {
                NadLongPressView.this.e.a();
            }
        }
    }

    public NadLongPressView(Context context) {
        super(context);
        this.d = new a();
        this.e = null;
    }

    public void setHandler(b bVar) {
        this.e = bVar;
    }

    public NadLongPressView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = new a();
        this.e = null;
    }

    public NadLongPressView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = new a();
        this.e = null;
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2 && !this.c && (Math.abs(this.a - x) > 20 || Math.abs(this.b - y) > 20)) {
                    this.c = true;
                    removeCallbacks(this.d);
                }
            } else {
                removeCallbacks(this.d);
            }
        } else {
            this.a = x;
            this.b = y;
            this.c = false;
            postDelayed(this.d, 5000L);
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
