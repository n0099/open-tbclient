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
    private static g aLu;
    private int aLv;
    private boolean aLw;
    private ClickableSpan aLy;
    private int mLastMotionY;
    private boolean aLx = false;
    private Runnable aLz = new Runnable() { // from class: com.baidu.live.im.g.1
        @Override // java.lang.Runnable
        public void run() {
            if (!g.this.aLw) {
                g.this.aLx = true;
                if (g.this.aLy != null && (g.this.aLy instanceof b.c)) {
                    ((b.c) g.this.aLy).BJ();
                    g.this.aLy = null;
                }
            }
        }
    };

    public static g Bd() {
        if (aLu == null) {
            aLu = new g();
        }
        return aLu;
    }

    @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        this.aLy = a(textView, spannable, motionEvent);
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (motionEvent.getAction() == 0) {
            this.aLv = x;
            this.mLastMotionY = y;
            this.aLw = false;
            this.aLx = false;
            SafeHandler.getInst().postDelayed(this.aLz, 700L);
            if (this.aLy != null) {
                Selection.setSelection(spannable, spannable.getSpanStart(this.aLy), spannable.getSpanEnd(this.aLy));
            }
        } else if (motionEvent.getAction() == 2) {
            if (this.aLw) {
                if (this.aLy != null) {
                    Selection.removeSelection(spannable);
                    return true;
                }
                return true;
            } else if (Math.abs(this.aLv - x) > 20 || Math.abs(this.mLastMotionY - y) > 20) {
                this.aLw = true;
                SafeHandler.getInst().removeCallbacks(this.aLz);
            }
        } else if (motionEvent.getAction() == 1) {
            if (!this.aLx) {
                SafeHandler.getInst().removeCallbacks(this.aLz);
                if (this.aLy != null) {
                    this.aLy.onClick(textView);
                    Selection.removeSelection(spannable);
                    this.aLy = null;
                    return true;
                }
                return true;
            }
            this.aLx = false;
            return true;
        } else if (motionEvent.getAction() == 3) {
            if (!this.aLx) {
                SafeHandler.getInst().removeCallbacks(this.aLz);
            }
            if (this.aLy != null) {
                Selection.removeSelection(spannable);
            }
            this.aLy = null;
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
