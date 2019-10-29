package com.baidu.live.im;

import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.widget.TextView;
import com.baidu.live.adp.lib.safe.SafeHandler;
import com.baidu.live.im.a.b;
/* loaded from: classes6.dex */
public class g extends LinkMovementMethod {
    private static g agy;
    private boolean agA;
    private ClickableSpan agC;
    private int agz;
    private int mLastMotionY;
    private boolean agB = false;
    private Runnable agD = new Runnable() { // from class: com.baidu.live.im.g.1
        @Override // java.lang.Runnable
        public void run() {
            if (!g.this.agA) {
                g.this.agB = true;
                if (g.this.agC != null && (g.this.agC instanceof b.c)) {
                    ((b.c) g.this.agC).td();
                    g.this.agC = null;
                }
            }
        }
    };

    public static g sB() {
        if (agy == null) {
            agy = new g();
        }
        return agy;
    }

    @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        this.agC = a(textView, spannable, motionEvent);
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (motionEvent.getAction() == 0) {
            this.agz = x;
            this.mLastMotionY = y;
            this.agA = false;
            this.agB = false;
            SafeHandler.getInst().postDelayed(this.agD, 700L);
            if (this.agC != null) {
                Selection.setSelection(spannable, spannable.getSpanStart(this.agC), spannable.getSpanEnd(this.agC));
            }
        } else if (motionEvent.getAction() == 2) {
            if (this.agA) {
                if (this.agC != null) {
                    Selection.removeSelection(spannable);
                    return true;
                }
                return true;
            } else if (Math.abs(this.agz - x) > 20 || Math.abs(this.mLastMotionY - y) > 20) {
                this.agA = true;
                SafeHandler.getInst().removeCallbacks(this.agD);
            }
        } else if (motionEvent.getAction() == 1) {
            if (!this.agB) {
                SafeHandler.getInst().removeCallbacks(this.agD);
                if (this.agC != null) {
                    this.agC.onClick(textView);
                    Selection.removeSelection(spannable);
                    this.agC = null;
                    return true;
                }
                return true;
            }
            this.agB = false;
            return true;
        } else if (motionEvent.getAction() == 3) {
            if (!this.agB) {
                SafeHandler.getInst().removeCallbacks(this.agD);
            }
            if (this.agC != null) {
                Selection.removeSelection(spannable);
            }
            this.agC = null;
            return true;
        }
        return super.onTouchEvent(textView, spannable, motionEvent);
    }

    private ClickableSpan a(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        int x = ((int) motionEvent.getX()) - textView.getTotalPaddingLeft();
        int y = ((int) motionEvent.getY()) - textView.getTotalPaddingTop();
        int scrollX = x + textView.getScrollX();
        int scrollY = y + textView.getScrollY();
        Layout layout = textView.getLayout();
        int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical(scrollY), scrollX);
        ClickableSpan[] clickableSpanArr = (ClickableSpan[]) spannable.getSpans(offsetForHorizontal, offsetForHorizontal, ClickableSpan.class);
        if (clickableSpanArr.length <= 0) {
            return null;
        }
        return clickableSpanArr[0];
    }
}
