package com.baidu.live.im;

import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.widget.TextView;
import com.baidu.live.adp.lib.safe.SafeHandler;
/* loaded from: classes4.dex */
public class g extends LinkMovementMethod {
    private static g bhW;
    private int bhX;
    private boolean bhY;
    private ClickableSpan bia;
    private int mLastMotionY;
    private boolean bhZ = false;
    private Runnable bib = new Runnable() { // from class: com.baidu.live.im.g.1
        @Override // java.lang.Runnable
        public void run() {
            if (!g.this.bhY) {
                g.this.bhZ = true;
                if (g.this.bia != null && (g.this.bia instanceof a)) {
                    ((a) g.this.bia).KY();
                    g.this.bia = null;
                }
            }
        }
    };

    /* loaded from: classes4.dex */
    public interface a {
        void KY();
    }

    public static g KX() {
        if (bhW == null) {
            bhW = new g();
        }
        return bhW;
    }

    @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        this.bia = a(textView, spannable, motionEvent);
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (motionEvent.getAction() == 0) {
            this.bhX = x;
            this.mLastMotionY = y;
            this.bhY = false;
            this.bhZ = false;
            SafeHandler.getInst().postDelayed(this.bib, 700L);
            if (this.bia != null) {
                Selection.setSelection(spannable, spannable.getSpanStart(this.bia), spannable.getSpanEnd(this.bia));
            }
        } else if (motionEvent.getAction() == 2) {
            if (this.bhY) {
                if (this.bia != null) {
                    Selection.removeSelection(spannable);
                    return true;
                }
                return true;
            } else if (Math.abs(this.bhX - x) > 20 || Math.abs(this.mLastMotionY - y) > 20) {
                this.bhY = true;
                SafeHandler.getInst().removeCallbacks(this.bib);
            }
        } else if (motionEvent.getAction() == 1) {
            if (!this.bhZ) {
                SafeHandler.getInst().removeCallbacks(this.bib);
                if (this.bia != null) {
                    this.bia.onClick(textView);
                    Selection.removeSelection(spannable);
                    this.bia = null;
                    return true;
                }
                return true;
            }
            this.bhZ = false;
            return true;
        } else if (motionEvent.getAction() == 3) {
            if (!this.bhZ) {
                SafeHandler.getInst().removeCallbacks(this.bib);
            }
            if (this.bia != null) {
                Selection.removeSelection(spannable);
            }
            this.bia = null;
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
