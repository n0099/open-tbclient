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
    private static g bnX;
    private int bnY;
    private boolean bnZ;
    private ClickableSpan bob;
    private int mLastMotionY;
    private boolean boa = false;
    private Runnable boc = new Runnable() { // from class: com.baidu.live.im.g.1
        @Override // java.lang.Runnable
        public void run() {
            if (!g.this.bnZ) {
                g.this.boa = true;
                if (g.this.bob != null && (g.this.bob instanceof a)) {
                    ((a) g.this.bob).Ke();
                    g.this.bob = null;
                }
            }
        }
    };

    /* loaded from: classes10.dex */
    public interface a {
        void Ke();
    }

    public static g Kd() {
        if (bnX == null) {
            bnX = new g();
        }
        return bnX;
    }

    @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        this.bob = a(textView, spannable, motionEvent);
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (motionEvent.getAction() == 0) {
            this.bnY = x;
            this.mLastMotionY = y;
            this.bnZ = false;
            this.boa = false;
            SafeHandler.getInst().postDelayed(this.boc, 700L);
            if (this.bob != null) {
                Selection.setSelection(spannable, spannable.getSpanStart(this.bob), spannable.getSpanEnd(this.bob));
            }
        } else if (motionEvent.getAction() == 2) {
            if (this.bnZ) {
                if (this.bob != null) {
                    Selection.removeSelection(spannable);
                    return true;
                }
                return true;
            } else if (Math.abs(this.bnY - x) > 20 || Math.abs(this.mLastMotionY - y) > 20) {
                this.bnZ = true;
                SafeHandler.getInst().removeCallbacks(this.boc);
            }
        } else if (motionEvent.getAction() == 1) {
            if (!this.boa) {
                SafeHandler.getInst().removeCallbacks(this.boc);
                if (this.bob != null) {
                    this.bob.onClick(textView);
                    Selection.removeSelection(spannable);
                    this.bob = null;
                    return true;
                }
                return true;
            }
            this.boa = false;
            return true;
        } else if (motionEvent.getAction() == 3) {
            if (!this.boa) {
                SafeHandler.getInst().removeCallbacks(this.boc);
            }
            if (this.bob != null) {
                Selection.removeSelection(spannable);
            }
            this.bob = null;
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
