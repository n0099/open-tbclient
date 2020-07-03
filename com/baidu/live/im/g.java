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
    private static g aUg;
    private int aUh;
    private boolean aUi;
    private ClickableSpan aUk;
    private int mLastMotionY;
    private boolean aUj = false;
    private Runnable aUl = new Runnable() { // from class: com.baidu.live.im.g.1
        @Override // java.lang.Runnable
        public void run() {
            if (!g.this.aUi) {
                g.this.aUj = true;
                if (g.this.aUk != null && (g.this.aUk instanceof b.c)) {
                    ((b.c) g.this.aUk).DG();
                    g.this.aUk = null;
                }
            }
        }
    };

    public static g CY() {
        if (aUg == null) {
            aUg = new g();
        }
        return aUg;
    }

    @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        this.aUk = a(textView, spannable, motionEvent);
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (motionEvent.getAction() == 0) {
            this.aUh = x;
            this.mLastMotionY = y;
            this.aUi = false;
            this.aUj = false;
            SafeHandler.getInst().postDelayed(this.aUl, 700L);
            if (this.aUk != null) {
                Selection.setSelection(spannable, spannable.getSpanStart(this.aUk), spannable.getSpanEnd(this.aUk));
            }
        } else if (motionEvent.getAction() == 2) {
            if (this.aUi) {
                if (this.aUk != null) {
                    Selection.removeSelection(spannable);
                    return true;
                }
                return true;
            } else if (Math.abs(this.aUh - x) > 20 || Math.abs(this.mLastMotionY - y) > 20) {
                this.aUi = true;
                SafeHandler.getInst().removeCallbacks(this.aUl);
            }
        } else if (motionEvent.getAction() == 1) {
            if (!this.aUj) {
                SafeHandler.getInst().removeCallbacks(this.aUl);
                if (this.aUk != null) {
                    this.aUk.onClick(textView);
                    Selection.removeSelection(spannable);
                    this.aUk = null;
                    return true;
                }
                return true;
            }
            this.aUj = false;
            return true;
        } else if (motionEvent.getAction() == 3) {
            if (!this.aUj) {
                SafeHandler.getInst().removeCallbacks(this.aUl);
            }
            if (this.aUk != null) {
                Selection.removeSelection(spannable);
            }
            this.aUk = null;
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
