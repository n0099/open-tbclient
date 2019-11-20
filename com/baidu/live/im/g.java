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
    private static g agg;
    private int agh;
    private boolean agi;
    private ClickableSpan agk;
    private int mLastMotionY;
    private boolean agj = false;
    private Runnable agl = new Runnable() { // from class: com.baidu.live.im.g.1
        @Override // java.lang.Runnable
        public void run() {
            if (!g.this.agi) {
                g.this.agj = true;
                if (g.this.agk != null && (g.this.agk instanceof b.c)) {
                    ((b.c) g.this.agk).te();
                    g.this.agk = null;
                }
            }
        }
    };

    public static g sC() {
        if (agg == null) {
            agg = new g();
        }
        return agg;
    }

    @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        this.agk = a(textView, spannable, motionEvent);
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (motionEvent.getAction() == 0) {
            this.agh = x;
            this.mLastMotionY = y;
            this.agi = false;
            this.agj = false;
            SafeHandler.getInst().postDelayed(this.agl, 700L);
            if (this.agk != null) {
                Selection.setSelection(spannable, spannable.getSpanStart(this.agk), spannable.getSpanEnd(this.agk));
            }
        } else if (motionEvent.getAction() == 2) {
            if (this.agi) {
                if (this.agk != null) {
                    Selection.removeSelection(spannable);
                    return true;
                }
                return true;
            } else if (Math.abs(this.agh - x) > 20 || Math.abs(this.mLastMotionY - y) > 20) {
                this.agi = true;
                SafeHandler.getInst().removeCallbacks(this.agl);
            }
        } else if (motionEvent.getAction() == 1) {
            if (!this.agj) {
                SafeHandler.getInst().removeCallbacks(this.agl);
                if (this.agk != null) {
                    this.agk.onClick(textView);
                    Selection.removeSelection(spannable);
                    this.agk = null;
                    return true;
                }
                return true;
            }
            this.agj = false;
            return true;
        } else if (motionEvent.getAction() == 3) {
            if (!this.agj) {
                SafeHandler.getInst().removeCallbacks(this.agl);
            }
            if (this.agk != null) {
                Selection.removeSelection(spannable);
            }
            this.agk = null;
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
