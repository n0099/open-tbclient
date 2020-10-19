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
    private static g bha;
    private int bhb;
    private boolean bhc;
    private ClickableSpan bhe;
    private int mLastMotionY;
    private boolean bhd = false;
    private Runnable bhf = new Runnable() { // from class: com.baidu.live.im.g.1
        @Override // java.lang.Runnable
        public void run() {
            if (!g.this.bhc) {
                g.this.bhd = true;
                if (g.this.bhe != null && (g.this.bhe instanceof a)) {
                    ((a) g.this.bhe).KN();
                    g.this.bhe = null;
                }
            }
        }
    };

    /* loaded from: classes4.dex */
    public interface a {
        void KN();
    }

    public static g KM() {
        if (bha == null) {
            bha = new g();
        }
        return bha;
    }

    @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        this.bhe = a(textView, spannable, motionEvent);
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (motionEvent.getAction() == 0) {
            this.bhb = x;
            this.mLastMotionY = y;
            this.bhc = false;
            this.bhd = false;
            SafeHandler.getInst().postDelayed(this.bhf, 700L);
            if (this.bhe != null) {
                Selection.setSelection(spannable, spannable.getSpanStart(this.bhe), spannable.getSpanEnd(this.bhe));
            }
        } else if (motionEvent.getAction() == 2) {
            if (this.bhc) {
                if (this.bhe != null) {
                    Selection.removeSelection(spannable);
                    return true;
                }
                return true;
            } else if (Math.abs(this.bhb - x) > 20 || Math.abs(this.mLastMotionY - y) > 20) {
                this.bhc = true;
                SafeHandler.getInst().removeCallbacks(this.bhf);
            }
        } else if (motionEvent.getAction() == 1) {
            if (!this.bhd) {
                SafeHandler.getInst().removeCallbacks(this.bhf);
                if (this.bhe != null) {
                    this.bhe.onClick(textView);
                    Selection.removeSelection(spannable);
                    this.bhe = null;
                    return true;
                }
                return true;
            }
            this.bhd = false;
            return true;
        } else if (motionEvent.getAction() == 3) {
            if (!this.bhd) {
                SafeHandler.getInst().removeCallbacks(this.bhf);
            }
            if (this.bhe != null) {
                Selection.removeSelection(spannable);
            }
            this.bhe = null;
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
