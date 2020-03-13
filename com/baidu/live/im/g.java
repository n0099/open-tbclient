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
/* loaded from: classes3.dex */
public class g extends LinkMovementMethod {
    private static g asn;
    private boolean aso;
    private ClickableSpan asq;
    private int mLastMotionX;
    private int mLastMotionY;
    private boolean asp = false;
    private Runnable asr = new Runnable() { // from class: com.baidu.live.im.g.1
        @Override // java.lang.Runnable
        public void run() {
            if (!g.this.aso) {
                g.this.asp = true;
                if (g.this.asq != null && (g.this.asq instanceof b.c)) {
                    ((b.c) g.this.asq).wT();
                    g.this.asq = null;
                }
            }
        }
    };

    public static g wo() {
        if (asn == null) {
            asn = new g();
        }
        return asn;
    }

    @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        this.asq = a(textView, spannable, motionEvent);
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (motionEvent.getAction() == 0) {
            this.mLastMotionX = x;
            this.mLastMotionY = y;
            this.aso = false;
            this.asp = false;
            SafeHandler.getInst().postDelayed(this.asr, 700L);
            if (this.asq != null) {
                Selection.setSelection(spannable, spannable.getSpanStart(this.asq), spannable.getSpanEnd(this.asq));
            }
        } else if (motionEvent.getAction() == 2) {
            if (this.aso) {
                if (this.asq != null) {
                    Selection.removeSelection(spannable);
                    return true;
                }
                return true;
            } else if (Math.abs(this.mLastMotionX - x) > 20 || Math.abs(this.mLastMotionY - y) > 20) {
                this.aso = true;
                SafeHandler.getInst().removeCallbacks(this.asr);
            }
        } else if (motionEvent.getAction() == 1) {
            if (!this.asp) {
                SafeHandler.getInst().removeCallbacks(this.asr);
                if (this.asq != null) {
                    this.asq.onClick(textView);
                    Selection.removeSelection(spannable);
                    this.asq = null;
                    return true;
                }
                return true;
            }
            this.asp = false;
            return true;
        } else if (motionEvent.getAction() == 3) {
            if (!this.asp) {
                SafeHandler.getInst().removeCallbacks(this.asr);
            }
            if (this.asq != null) {
                Selection.removeSelection(spannable);
            }
            this.asq = null;
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
