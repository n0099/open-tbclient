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
    private static g baO;
    private int baP;
    private boolean baQ;
    private ClickableSpan baS;
    private int mLastMotionY;
    private boolean baR = false;
    private Runnable baT = new Runnable() { // from class: com.baidu.live.im.g.1
        @Override // java.lang.Runnable
        public void run() {
            if (!g.this.baQ) {
                g.this.baR = true;
                if (g.this.baS != null && (g.this.baS instanceof a)) {
                    ((a) g.this.baS).Jd();
                    g.this.baS = null;
                }
            }
        }
    };

    /* loaded from: classes7.dex */
    public interface a {
        void Jd();
    }

    public static g Jc() {
        if (baO == null) {
            baO = new g();
        }
        return baO;
    }

    @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        this.baS = a(textView, spannable, motionEvent);
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (motionEvent.getAction() == 0) {
            this.baP = x;
            this.mLastMotionY = y;
            this.baQ = false;
            this.baR = false;
            SafeHandler.getInst().postDelayed(this.baT, 700L);
            if (this.baS != null) {
                Selection.setSelection(spannable, spannable.getSpanStart(this.baS), spannable.getSpanEnd(this.baS));
            }
        } else if (motionEvent.getAction() == 2) {
            if (this.baQ) {
                if (this.baS != null) {
                    Selection.removeSelection(spannable);
                    return true;
                }
                return true;
            } else if (Math.abs(this.baP - x) > 20 || Math.abs(this.mLastMotionY - y) > 20) {
                this.baQ = true;
                SafeHandler.getInst().removeCallbacks(this.baT);
            }
        } else if (motionEvent.getAction() == 1) {
            if (!this.baR) {
                SafeHandler.getInst().removeCallbacks(this.baT);
                if (this.baS != null) {
                    this.baS.onClick(textView);
                    Selection.removeSelection(spannable);
                    this.baS = null;
                    return true;
                }
                return true;
            }
            this.baR = false;
            return true;
        } else if (motionEvent.getAction() == 3) {
            if (!this.baR) {
                SafeHandler.getInst().removeCallbacks(this.baT);
            }
            if (this.baS != null) {
                Selection.removeSelection(spannable);
            }
            this.baS = null;
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
