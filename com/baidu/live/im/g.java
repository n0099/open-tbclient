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
    private static g bmm;
    private int bmn;
    private boolean bmo;
    private ClickableSpan bmq;
    private int mLastMotionY;
    private boolean bmp = false;
    private Runnable bmr = new Runnable() { // from class: com.baidu.live.im.g.1
        @Override // java.lang.Runnable
        public void run() {
            if (!g.this.bmo) {
                g.this.bmp = true;
                if (g.this.bmq != null && (g.this.bmq instanceof a)) {
                    ((a) g.this.bmq).Nb();
                    g.this.bmq = null;
                }
            }
        }
    };

    /* loaded from: classes4.dex */
    public interface a {
        void Nb();
    }

    public static g Na() {
        if (bmm == null) {
            bmm = new g();
        }
        return bmm;
    }

    @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        this.bmq = a(textView, spannable, motionEvent);
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (motionEvent.getAction() == 0) {
            this.bmn = x;
            this.mLastMotionY = y;
            this.bmo = false;
            this.bmp = false;
            SafeHandler.getInst().postDelayed(this.bmr, 700L);
            if (this.bmq != null) {
                Selection.setSelection(spannable, spannable.getSpanStart(this.bmq), spannable.getSpanEnd(this.bmq));
            }
        } else if (motionEvent.getAction() == 2) {
            if (this.bmo) {
                if (this.bmq != null) {
                    Selection.removeSelection(spannable);
                    return true;
                }
                return true;
            } else if (Math.abs(this.bmn - x) > 20 || Math.abs(this.mLastMotionY - y) > 20) {
                this.bmo = true;
                SafeHandler.getInst().removeCallbacks(this.bmr);
            }
        } else if (motionEvent.getAction() == 1) {
            if (!this.bmp) {
                SafeHandler.getInst().removeCallbacks(this.bmr);
                if (this.bmq != null) {
                    this.bmq.onClick(textView);
                    Selection.removeSelection(spannable);
                    this.bmq = null;
                    return true;
                }
                return true;
            }
            this.bmp = false;
            return true;
        } else if (motionEvent.getAction() == 3) {
            if (!this.bmp) {
                SafeHandler.getInst().removeCallbacks(this.bmr);
            }
            if (this.bmq != null) {
                Selection.removeSelection(spannable);
            }
            this.bmq = null;
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
