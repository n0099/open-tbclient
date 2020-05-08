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
/* loaded from: classes3.dex */
public class g extends LinkMovementMethod {
    private static g aLA;
    private int aLB;
    private boolean aLC;
    private ClickableSpan aLE;
    private int mLastMotionY;
    private boolean aLD = false;
    private Runnable aLF = new Runnable() { // from class: com.baidu.live.im.g.1
        @Override // java.lang.Runnable
        public void run() {
            if (!g.this.aLC) {
                g.this.aLD = true;
                if (g.this.aLE != null && (g.this.aLE instanceof b.c)) {
                    ((b.c) g.this.aLE).BI();
                    g.this.aLE = null;
                }
            }
        }
    };

    public static g Bc() {
        if (aLA == null) {
            aLA = new g();
        }
        return aLA;
    }

    @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        this.aLE = a(textView, spannable, motionEvent);
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (motionEvent.getAction() == 0) {
            this.aLB = x;
            this.mLastMotionY = y;
            this.aLC = false;
            this.aLD = false;
            SafeHandler.getInst().postDelayed(this.aLF, 700L);
            if (this.aLE != null) {
                Selection.setSelection(spannable, spannable.getSpanStart(this.aLE), spannable.getSpanEnd(this.aLE));
            }
        } else if (motionEvent.getAction() == 2) {
            if (this.aLC) {
                if (this.aLE != null) {
                    Selection.removeSelection(spannable);
                    return true;
                }
                return true;
            } else if (Math.abs(this.aLB - x) > 20 || Math.abs(this.mLastMotionY - y) > 20) {
                this.aLC = true;
                SafeHandler.getInst().removeCallbacks(this.aLF);
            }
        } else if (motionEvent.getAction() == 1) {
            if (!this.aLD) {
                SafeHandler.getInst().removeCallbacks(this.aLF);
                if (this.aLE != null) {
                    this.aLE.onClick(textView);
                    Selection.removeSelection(spannable);
                    this.aLE = null;
                    return true;
                }
                return true;
            }
            this.aLD = false;
            return true;
        } else if (motionEvent.getAction() == 3) {
            if (!this.aLD) {
                SafeHandler.getInst().removeCallbacks(this.aLF);
            }
            if (this.aLE != null) {
                Selection.removeSelection(spannable);
            }
            this.aLE = null;
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
