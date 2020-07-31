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
    private static g aVz;
    private int aVA;
    private boolean aVB;
    private ClickableSpan aVD;
    private int mLastMotionY;
    private boolean aVC = false;
    private Runnable aVE = new Runnable() { // from class: com.baidu.live.im.g.1
        @Override // java.lang.Runnable
        public void run() {
            if (!g.this.aVB) {
                g.this.aVC = true;
                if (g.this.aVD != null && (g.this.aVD instanceof a)) {
                    ((a) g.this.aVD).DA();
                    g.this.aVD = null;
                }
            }
        }
    };

    /* loaded from: classes4.dex */
    public interface a {
        void DA();
    }

    public static g Dz() {
        if (aVz == null) {
            aVz = new g();
        }
        return aVz;
    }

    @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        this.aVD = a(textView, spannable, motionEvent);
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (motionEvent.getAction() == 0) {
            this.aVA = x;
            this.mLastMotionY = y;
            this.aVB = false;
            this.aVC = false;
            SafeHandler.getInst().postDelayed(this.aVE, 700L);
            if (this.aVD != null) {
                Selection.setSelection(spannable, spannable.getSpanStart(this.aVD), spannable.getSpanEnd(this.aVD));
            }
        } else if (motionEvent.getAction() == 2) {
            if (this.aVB) {
                if (this.aVD != null) {
                    Selection.removeSelection(spannable);
                    return true;
                }
                return true;
            } else if (Math.abs(this.aVA - x) > 20 || Math.abs(this.mLastMotionY - y) > 20) {
                this.aVB = true;
                SafeHandler.getInst().removeCallbacks(this.aVE);
            }
        } else if (motionEvent.getAction() == 1) {
            if (!this.aVC) {
                SafeHandler.getInst().removeCallbacks(this.aVE);
                if (this.aVD != null) {
                    this.aVD.onClick(textView);
                    Selection.removeSelection(spannable);
                    this.aVD = null;
                    return true;
                }
                return true;
            }
            this.aVC = false;
            return true;
        } else if (motionEvent.getAction() == 3) {
            if (!this.aVC) {
                SafeHandler.getInst().removeCallbacks(this.aVE);
            }
            if (this.aVD != null) {
                Selection.removeSelection(spannable);
            }
            this.aVD = null;
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
