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
    private static g bmx;
    private ClickableSpan bmB;
    private int bmy;
    private boolean bmz;
    private int mLastMotionY;
    private boolean bmA = false;
    private Runnable bmC = new Runnable() { // from class: com.baidu.live.im.g.1
        @Override // java.lang.Runnable
        public void run() {
            if (!g.this.bmz) {
                g.this.bmA = true;
                if (g.this.bmB != null && (g.this.bmB instanceof a)) {
                    ((a) g.this.bmB).Kb();
                    g.this.bmB = null;
                }
            }
        }
    };

    /* loaded from: classes11.dex */
    public interface a {
        void Kb();
    }

    public static g Ka() {
        if (bmx == null) {
            bmx = new g();
        }
        return bmx;
    }

    @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        this.bmB = a(textView, spannable, motionEvent);
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (motionEvent.getAction() == 0) {
            this.bmy = x;
            this.mLastMotionY = y;
            this.bmz = false;
            this.bmA = false;
            SafeHandler.getInst().postDelayed(this.bmC, 700L);
            if (this.bmB != null) {
                Selection.setSelection(spannable, spannable.getSpanStart(this.bmB), spannable.getSpanEnd(this.bmB));
            }
        } else if (motionEvent.getAction() == 2) {
            if (this.bmz) {
                if (this.bmB != null) {
                    Selection.removeSelection(spannable);
                    return true;
                }
                return true;
            } else if (Math.abs(this.bmy - x) > 20 || Math.abs(this.mLastMotionY - y) > 20) {
                this.bmz = true;
                SafeHandler.getInst().removeCallbacks(this.bmC);
            }
        } else if (motionEvent.getAction() == 1) {
            if (!this.bmA) {
                SafeHandler.getInst().removeCallbacks(this.bmC);
                if (this.bmB != null) {
                    this.bmB.onClick(textView);
                    Selection.removeSelection(spannable);
                    this.bmB = null;
                    return true;
                }
                return true;
            }
            this.bmA = false;
            return true;
        } else if (motionEvent.getAction() == 3) {
            if (!this.bmA) {
                SafeHandler.getInst().removeCallbacks(this.bmC);
            }
            if (this.bmB != null) {
                Selection.removeSelection(spannable);
            }
            this.bmB = null;
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
