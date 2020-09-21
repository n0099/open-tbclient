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
    private static g bdo;
    private int bdp;
    private boolean bdq;
    private ClickableSpan bds;
    private int mLastMotionY;
    private boolean bdr = false;
    private Runnable bdt = new Runnable() { // from class: com.baidu.live.im.g.1
        @Override // java.lang.Runnable
        public void run() {
            if (!g.this.bdq) {
                g.this.bdr = true;
                if (g.this.bds != null && (g.this.bds instanceof a)) {
                    ((a) g.this.bds).JH();
                    g.this.bds = null;
                }
            }
        }
    };

    /* loaded from: classes4.dex */
    public interface a {
        void JH();
    }

    public static g JG() {
        if (bdo == null) {
            bdo = new g();
        }
        return bdo;
    }

    @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        this.bds = a(textView, spannable, motionEvent);
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (motionEvent.getAction() == 0) {
            this.bdp = x;
            this.mLastMotionY = y;
            this.bdq = false;
            this.bdr = false;
            SafeHandler.getInst().postDelayed(this.bdt, 700L);
            if (this.bds != null) {
                Selection.setSelection(spannable, spannable.getSpanStart(this.bds), spannable.getSpanEnd(this.bds));
            }
        } else if (motionEvent.getAction() == 2) {
            if (this.bdq) {
                if (this.bds != null) {
                    Selection.removeSelection(spannable);
                    return true;
                }
                return true;
            } else if (Math.abs(this.bdp - x) > 20 || Math.abs(this.mLastMotionY - y) > 20) {
                this.bdq = true;
                SafeHandler.getInst().removeCallbacks(this.bdt);
            }
        } else if (motionEvent.getAction() == 1) {
            if (!this.bdr) {
                SafeHandler.getInst().removeCallbacks(this.bdt);
                if (this.bds != null) {
                    this.bds.onClick(textView);
                    Selection.removeSelection(spannable);
                    this.bds = null;
                    return true;
                }
                return true;
            }
            this.bdr = false;
            return true;
        } else if (motionEvent.getAction() == 3) {
            if (!this.bdr) {
                SafeHandler.getInst().removeCallbacks(this.bdt);
            }
            if (this.bds != null) {
                Selection.removeSelection(spannable);
            }
            this.bds = null;
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
