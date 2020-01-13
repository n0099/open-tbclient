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
/* loaded from: classes2.dex */
public class g extends LinkMovementMethod {
    private static g aoT;
    private boolean aoU;
    private ClickableSpan aoW;
    private int mLastMotionX;
    private int mLastMotionY;
    private boolean aoV = false;
    private Runnable aoX = new Runnable() { // from class: com.baidu.live.im.g.1
        @Override // java.lang.Runnable
        public void run() {
            if (!g.this.aoU) {
                g.this.aoV = true;
                if (g.this.aoW != null && (g.this.aoW instanceof b.c)) {
                    ((b.c) g.this.aoW).vp();
                    g.this.aoW = null;
                }
            }
        }
    };

    public static g uK() {
        if (aoT == null) {
            aoT = new g();
        }
        return aoT;
    }

    @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        this.aoW = a(textView, spannable, motionEvent);
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (motionEvent.getAction() == 0) {
            this.mLastMotionX = x;
            this.mLastMotionY = y;
            this.aoU = false;
            this.aoV = false;
            SafeHandler.getInst().postDelayed(this.aoX, 700L);
            if (this.aoW != null) {
                Selection.setSelection(spannable, spannable.getSpanStart(this.aoW), spannable.getSpanEnd(this.aoW));
            }
        } else if (motionEvent.getAction() == 2) {
            if (this.aoU) {
                if (this.aoW != null) {
                    Selection.removeSelection(spannable);
                    return true;
                }
                return true;
            } else if (Math.abs(this.mLastMotionX - x) > 20 || Math.abs(this.mLastMotionY - y) > 20) {
                this.aoU = true;
                SafeHandler.getInst().removeCallbacks(this.aoX);
            }
        } else if (motionEvent.getAction() == 1) {
            if (!this.aoV) {
                SafeHandler.getInst().removeCallbacks(this.aoX);
                if (this.aoW != null) {
                    this.aoW.onClick(textView);
                    Selection.removeSelection(spannable);
                    this.aoW = null;
                    return true;
                }
                return true;
            }
            this.aoV = false;
            return true;
        } else if (motionEvent.getAction() == 3) {
            if (!this.aoV) {
                SafeHandler.getInst().removeCallbacks(this.aoX);
            }
            if (this.aoW != null) {
                Selection.removeSelection(spannable);
            }
            this.aoW = null;
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
