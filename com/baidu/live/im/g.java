package com.baidu.live.im;

import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.widget.TextView;
import com.baidu.live.adp.lib.safe.SafeHandler;
/* loaded from: classes10.dex */
public class g extends LinkMovementMethod {
    private static g bje;
    private int bjf;
    private boolean bjg;
    private ClickableSpan bji;
    private int mLastMotionY;
    private boolean bjh = false;
    private Runnable bjj = new Runnable() { // from class: com.baidu.live.im.g.1
        @Override // java.lang.Runnable
        public void run() {
            if (!g.this.bjg) {
                g.this.bjh = true;
                if (g.this.bji != null && (g.this.bji instanceof a)) {
                    ((a) g.this.bji).ID();
                    g.this.bji = null;
                }
            }
        }
    };

    /* loaded from: classes10.dex */
    public interface a {
        void ID();
    }

    public static g IC() {
        if (bje == null) {
            bje = new g();
        }
        return bje;
    }

    @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        this.bji = a(textView, spannable, motionEvent);
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (motionEvent.getAction() == 0) {
            this.bjf = x;
            this.mLastMotionY = y;
            this.bjg = false;
            this.bjh = false;
            SafeHandler.getInst().postDelayed(this.bjj, 700L);
            if (this.bji != null) {
                Selection.setSelection(spannable, spannable.getSpanStart(this.bji), spannable.getSpanEnd(this.bji));
            }
        } else if (motionEvent.getAction() == 2) {
            if (this.bjg) {
                if (this.bji != null) {
                    Selection.removeSelection(spannable);
                    return true;
                }
                return true;
            } else if (Math.abs(this.bjf - x) > 20 || Math.abs(this.mLastMotionY - y) > 20) {
                this.bjg = true;
                SafeHandler.getInst().removeCallbacks(this.bjj);
            }
        } else if (motionEvent.getAction() == 1) {
            if (!this.bjh) {
                SafeHandler.getInst().removeCallbacks(this.bjj);
                if (this.bji != null) {
                    this.bji.onClick(textView);
                    Selection.removeSelection(spannable);
                    this.bji = null;
                    return true;
                }
                return true;
            }
            this.bjh = false;
            return true;
        } else if (motionEvent.getAction() == 3) {
            if (!this.bjh) {
                SafeHandler.getInst().removeCallbacks(this.bjj);
            }
            if (this.bji != null) {
                Selection.removeSelection(spannable);
            }
            this.bji = null;
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
