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
    private static g bir;
    private int bis;
    private boolean bit;
    private ClickableSpan biv;
    private int mLastMotionY;
    private boolean biu = false;
    private Runnable biw = new Runnable() { // from class: com.baidu.live.im.g.1
        @Override // java.lang.Runnable
        public void run() {
            if (!g.this.bit) {
                g.this.biu = true;
                if (g.this.biv != null && (g.this.biv instanceof a)) {
                    ((a) g.this.biv).Lh();
                    g.this.biv = null;
                }
            }
        }
    };

    /* loaded from: classes4.dex */
    public interface a {
        void Lh();
    }

    public static g Lg() {
        if (bir == null) {
            bir = new g();
        }
        return bir;
    }

    @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        this.biv = a(textView, spannable, motionEvent);
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (motionEvent.getAction() == 0) {
            this.bis = x;
            this.mLastMotionY = y;
            this.bit = false;
            this.biu = false;
            SafeHandler.getInst().postDelayed(this.biw, 700L);
            if (this.biv != null) {
                Selection.setSelection(spannable, spannable.getSpanStart(this.biv), spannable.getSpanEnd(this.biv));
            }
        } else if (motionEvent.getAction() == 2) {
            if (this.bit) {
                if (this.biv != null) {
                    Selection.removeSelection(spannable);
                    return true;
                }
                return true;
            } else if (Math.abs(this.bis - x) > 20 || Math.abs(this.mLastMotionY - y) > 20) {
                this.bit = true;
                SafeHandler.getInst().removeCallbacks(this.biw);
            }
        } else if (motionEvent.getAction() == 1) {
            if (!this.biu) {
                SafeHandler.getInst().removeCallbacks(this.biw);
                if (this.biv != null) {
                    this.biv.onClick(textView);
                    Selection.removeSelection(spannable);
                    this.biv = null;
                    return true;
                }
                return true;
            }
            this.biu = false;
            return true;
        } else if (motionEvent.getAction() == 3) {
            if (!this.biu) {
                SafeHandler.getInst().removeCallbacks(this.biw);
            }
            if (this.biv != null) {
                Selection.removeSelection(spannable);
            }
            this.biv = null;
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
