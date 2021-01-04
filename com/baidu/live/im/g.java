package com.baidu.live.im;

import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.widget.TextView;
import com.baidu.live.adp.lib.safe.SafeHandler;
/* loaded from: classes11.dex */
public class g extends LinkMovementMethod {
    private static g bnR;
    private int bnS;
    private boolean bnT;
    private ClickableSpan bnV;
    private int mLastMotionY;
    private boolean bnU = false;
    private Runnable bnW = new Runnable() { // from class: com.baidu.live.im.g.1
        @Override // java.lang.Runnable
        public void run() {
            if (!g.this.bnT) {
                g.this.bnU = true;
                if (g.this.bnV != null && (g.this.bnV instanceof a)) {
                    ((a) g.this.bnV).My();
                    g.this.bnV = null;
                }
            }
        }
    };

    /* loaded from: classes11.dex */
    public interface a {
        void My();
    }

    public static g Mx() {
        if (bnR == null) {
            bnR = new g();
        }
        return bnR;
    }

    @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        this.bnV = a(textView, spannable, motionEvent);
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (motionEvent.getAction() == 0) {
            this.bnS = x;
            this.mLastMotionY = y;
            this.bnT = false;
            this.bnU = false;
            SafeHandler.getInst().postDelayed(this.bnW, 700L);
            if (this.bnV != null) {
                Selection.setSelection(spannable, spannable.getSpanStart(this.bnV), spannable.getSpanEnd(this.bnV));
            }
        } else if (motionEvent.getAction() == 2) {
            if (this.bnT) {
                if (this.bnV != null) {
                    Selection.removeSelection(spannable);
                    return true;
                }
                return true;
            } else if (Math.abs(this.bnS - x) > 20 || Math.abs(this.mLastMotionY - y) > 20) {
                this.bnT = true;
                SafeHandler.getInst().removeCallbacks(this.bnW);
            }
        } else if (motionEvent.getAction() == 1) {
            if (!this.bnU) {
                SafeHandler.getInst().removeCallbacks(this.bnW);
                if (this.bnV != null) {
                    this.bnV.onClick(textView);
                    Selection.removeSelection(spannable);
                    this.bnV = null;
                    return true;
                }
                return true;
            }
            this.bnU = false;
            return true;
        } else if (motionEvent.getAction() == 3) {
            if (!this.bnU) {
                SafeHandler.getInst().removeCallbacks(this.bnW);
            }
            if (this.bnV != null) {
                Selection.removeSelection(spannable);
            }
            this.bnV = null;
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
