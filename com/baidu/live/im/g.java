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
    private static g asx;
    private ClickableSpan asA;
    private boolean asy;
    private int mLastMotionX;
    private int mLastMotionY;
    private boolean asz = false;
    private Runnable asB = new Runnable() { // from class: com.baidu.live.im.g.1
        @Override // java.lang.Runnable
        public void run() {
            if (!g.this.asy) {
                g.this.asz = true;
                if (g.this.asA != null && (g.this.asA instanceof b.c)) {
                    ((b.c) g.this.asA).wY();
                    g.this.asA = null;
                }
            }
        }
    };

    public static g wt() {
        if (asx == null) {
            asx = new g();
        }
        return asx;
    }

    @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        this.asA = a(textView, spannable, motionEvent);
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (motionEvent.getAction() == 0) {
            this.mLastMotionX = x;
            this.mLastMotionY = y;
            this.asy = false;
            this.asz = false;
            SafeHandler.getInst().postDelayed(this.asB, 700L);
            if (this.asA != null) {
                Selection.setSelection(spannable, spannable.getSpanStart(this.asA), spannable.getSpanEnd(this.asA));
            }
        } else if (motionEvent.getAction() == 2) {
            if (this.asy) {
                if (this.asA != null) {
                    Selection.removeSelection(spannable);
                    return true;
                }
                return true;
            } else if (Math.abs(this.mLastMotionX - x) > 20 || Math.abs(this.mLastMotionY - y) > 20) {
                this.asy = true;
                SafeHandler.getInst().removeCallbacks(this.asB);
            }
        } else if (motionEvent.getAction() == 1) {
            if (!this.asz) {
                SafeHandler.getInst().removeCallbacks(this.asB);
                if (this.asA != null) {
                    this.asA.onClick(textView);
                    Selection.removeSelection(spannable);
                    this.asA = null;
                    return true;
                }
                return true;
            }
            this.asz = false;
            return true;
        } else if (motionEvent.getAction() == 3) {
            if (!this.asz) {
                SafeHandler.getInst().removeCallbacks(this.asB);
            }
            if (this.asA != null) {
                Selection.removeSelection(spannable);
            }
            this.asA = null;
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
