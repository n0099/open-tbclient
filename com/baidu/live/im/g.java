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
    private static g bjK;
    private int bjL;
    private boolean bjM;
    private ClickableSpan bjO;
    private int mLastMotionY;
    private boolean bjN = false;
    private Runnable bjP = new Runnable() { // from class: com.baidu.live.im.g.1
        @Override // java.lang.Runnable
        public void run() {
            if (!g.this.bjM) {
                g.this.bjN = true;
                if (g.this.bjO != null && (g.this.bjO instanceof a)) {
                    ((a) g.this.bjO).LH();
                    g.this.bjO = null;
                }
            }
        }
    };

    /* loaded from: classes4.dex */
    public interface a {
        void LH();
    }

    public static g LG() {
        if (bjK == null) {
            bjK = new g();
        }
        return bjK;
    }

    @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        this.bjO = a(textView, spannable, motionEvent);
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (motionEvent.getAction() == 0) {
            this.bjL = x;
            this.mLastMotionY = y;
            this.bjM = false;
            this.bjN = false;
            SafeHandler.getInst().postDelayed(this.bjP, 700L);
            if (this.bjO != null) {
                Selection.setSelection(spannable, spannable.getSpanStart(this.bjO), spannable.getSpanEnd(this.bjO));
            }
        } else if (motionEvent.getAction() == 2) {
            if (this.bjM) {
                if (this.bjO != null) {
                    Selection.removeSelection(spannable);
                    return true;
                }
                return true;
            } else if (Math.abs(this.bjL - x) > 20 || Math.abs(this.mLastMotionY - y) > 20) {
                this.bjM = true;
                SafeHandler.getInst().removeCallbacks(this.bjP);
            }
        } else if (motionEvent.getAction() == 1) {
            if (!this.bjN) {
                SafeHandler.getInst().removeCallbacks(this.bjP);
                if (this.bjO != null) {
                    this.bjO.onClick(textView);
                    Selection.removeSelection(spannable);
                    this.bjO = null;
                    return true;
                }
                return true;
            }
            this.bjN = false;
            return true;
        } else if (motionEvent.getAction() == 3) {
            if (!this.bjN) {
                SafeHandler.getInst().removeCallbacks(this.bjP);
            }
            if (this.bjO != null) {
                Selection.removeSelection(spannable);
            }
            this.bjO = null;
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
