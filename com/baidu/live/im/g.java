package com.baidu.live.im;

import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.widget.TextView;
import com.baidu.live.adp.lib.safe.SafeHandler;
/* loaded from: classes7.dex */
public class g extends LinkMovementMethod {
    private static g baQ;
    private int baR;
    private boolean baS;
    private ClickableSpan baU;
    private int mLastMotionY;
    private boolean baT = false;
    private Runnable baV = new Runnable() { // from class: com.baidu.live.im.g.1
        @Override // java.lang.Runnable
        public void run() {
            if (!g.this.baS) {
                g.this.baT = true;
                if (g.this.baU != null && (g.this.baU instanceof a)) {
                    ((a) g.this.baU).Jd();
                    g.this.baU = null;
                }
            }
        }
    };

    /* loaded from: classes7.dex */
    public interface a {
        void Jd();
    }

    public static g Jc() {
        if (baQ == null) {
            baQ = new g();
        }
        return baQ;
    }

    @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        this.baU = a(textView, spannable, motionEvent);
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (motionEvent.getAction() == 0) {
            this.baR = x;
            this.mLastMotionY = y;
            this.baS = false;
            this.baT = false;
            SafeHandler.getInst().postDelayed(this.baV, 700L);
            if (this.baU != null) {
                Selection.setSelection(spannable, spannable.getSpanStart(this.baU), spannable.getSpanEnd(this.baU));
            }
        } else if (motionEvent.getAction() == 2) {
            if (this.baS) {
                if (this.baU != null) {
                    Selection.removeSelection(spannable);
                    return true;
                }
                return true;
            } else if (Math.abs(this.baR - x) > 20 || Math.abs(this.mLastMotionY - y) > 20) {
                this.baS = true;
                SafeHandler.getInst().removeCallbacks(this.baV);
            }
        } else if (motionEvent.getAction() == 1) {
            if (!this.baT) {
                SafeHandler.getInst().removeCallbacks(this.baV);
                if (this.baU != null) {
                    this.baU.onClick(textView);
                    Selection.removeSelection(spannable);
                    this.baU = null;
                    return true;
                }
                return true;
            }
            this.baT = false;
            return true;
        } else if (motionEvent.getAction() == 3) {
            if (!this.baT) {
                SafeHandler.getInst().removeCallbacks(this.baV);
            }
            if (this.baU != null) {
                Selection.removeSelection(spannable);
            }
            this.baU = null;
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
