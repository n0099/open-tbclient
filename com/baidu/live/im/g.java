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
    private static g aRA;
    private int aRB;
    private boolean aRC;
    private ClickableSpan aRE;
    private int mLastMotionY;
    private boolean aRD = false;
    private Runnable aRF = new Runnable() { // from class: com.baidu.live.im.g.1
        @Override // java.lang.Runnable
        public void run() {
            if (!g.this.aRC) {
                g.this.aRD = true;
                if (g.this.aRE != null && (g.this.aRE instanceof b.c)) {
                    ((b.c) g.this.aRE).Df();
                    g.this.aRE = null;
                }
            }
        }
    };

    public static g Cy() {
        if (aRA == null) {
            aRA = new g();
        }
        return aRA;
    }

    @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        this.aRE = a(textView, spannable, motionEvent);
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (motionEvent.getAction() == 0) {
            this.aRB = x;
            this.mLastMotionY = y;
            this.aRC = false;
            this.aRD = false;
            SafeHandler.getInst().postDelayed(this.aRF, 700L);
            if (this.aRE != null) {
                Selection.setSelection(spannable, spannable.getSpanStart(this.aRE), spannable.getSpanEnd(this.aRE));
            }
        } else if (motionEvent.getAction() == 2) {
            if (this.aRC) {
                if (this.aRE != null) {
                    Selection.removeSelection(spannable);
                    return true;
                }
                return true;
            } else if (Math.abs(this.aRB - x) > 20 || Math.abs(this.mLastMotionY - y) > 20) {
                this.aRC = true;
                SafeHandler.getInst().removeCallbacks(this.aRF);
            }
        } else if (motionEvent.getAction() == 1) {
            if (!this.aRD) {
                SafeHandler.getInst().removeCallbacks(this.aRF);
                if (this.aRE != null) {
                    this.aRE.onClick(textView);
                    Selection.removeSelection(spannable);
                    this.aRE = null;
                    return true;
                }
                return true;
            }
            this.aRD = false;
            return true;
        } else if (motionEvent.getAction() == 3) {
            if (!this.aRD) {
                SafeHandler.getInst().removeCallbacks(this.aRF);
            }
            if (this.aRE != null) {
                Selection.removeSelection(spannable);
            }
            this.aRE = null;
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
