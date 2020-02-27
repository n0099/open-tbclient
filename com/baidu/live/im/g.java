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
    private static g asl;
    private boolean asn;
    private ClickableSpan asp;
    private int mLastMotionX;
    private int mLastMotionY;
    private boolean aso = false;
    private Runnable asq = new Runnable() { // from class: com.baidu.live.im.g.1
        @Override // java.lang.Runnable
        public void run() {
            if (!g.this.asn) {
                g.this.aso = true;
                if (g.this.asp != null && (g.this.asp instanceof b.c)) {
                    ((b.c) g.this.asp).wT();
                    g.this.asp = null;
                }
            }
        }
    };

    public static g wo() {
        if (asl == null) {
            asl = new g();
        }
        return asl;
    }

    @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        this.asp = a(textView, spannable, motionEvent);
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (motionEvent.getAction() == 0) {
            this.mLastMotionX = x;
            this.mLastMotionY = y;
            this.asn = false;
            this.aso = false;
            SafeHandler.getInst().postDelayed(this.asq, 700L);
            if (this.asp != null) {
                Selection.setSelection(spannable, spannable.getSpanStart(this.asp), spannable.getSpanEnd(this.asp));
            }
        } else if (motionEvent.getAction() == 2) {
            if (this.asn) {
                if (this.asp != null) {
                    Selection.removeSelection(spannable);
                    return true;
                }
                return true;
            } else if (Math.abs(this.mLastMotionX - x) > 20 || Math.abs(this.mLastMotionY - y) > 20) {
                this.asn = true;
                SafeHandler.getInst().removeCallbacks(this.asq);
            }
        } else if (motionEvent.getAction() == 1) {
            if (!this.aso) {
                SafeHandler.getInst().removeCallbacks(this.asq);
                if (this.asp != null) {
                    this.asp.onClick(textView);
                    Selection.removeSelection(spannable);
                    this.asp = null;
                    return true;
                }
                return true;
            }
            this.aso = false;
            return true;
        } else if (motionEvent.getAction() == 3) {
            if (!this.aso) {
                SafeHandler.getInst().removeCallbacks(this.asq);
            }
            if (this.asp != null) {
                Selection.removeSelection(spannable);
            }
            this.asp = null;
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
