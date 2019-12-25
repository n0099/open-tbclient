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
    private static g aoh;
    private boolean aoi;
    private ClickableSpan aok;
    private int mLastMotionX;
    private int mLastMotionY;
    private boolean aoj = false;
    private Runnable aol = new Runnable() { // from class: com.baidu.live.im.g.1
        @Override // java.lang.Runnable
        public void run() {
            if (!g.this.aoi) {
                g.this.aoj = true;
                if (g.this.aok != null && (g.this.aok instanceof b.c)) {
                    ((b.c) g.this.aok).uY();
                    g.this.aok = null;
                }
            }
        }
    };

    public static g ut() {
        if (aoh == null) {
            aoh = new g();
        }
        return aoh;
    }

    @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        this.aok = a(textView, spannable, motionEvent);
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (motionEvent.getAction() == 0) {
            this.mLastMotionX = x;
            this.mLastMotionY = y;
            this.aoi = false;
            this.aoj = false;
            SafeHandler.getInst().postDelayed(this.aol, 700L);
            if (this.aok != null) {
                Selection.setSelection(spannable, spannable.getSpanStart(this.aok), spannable.getSpanEnd(this.aok));
            }
        } else if (motionEvent.getAction() == 2) {
            if (this.aoi) {
                if (this.aok != null) {
                    Selection.removeSelection(spannable);
                    return true;
                }
                return true;
            } else if (Math.abs(this.mLastMotionX - x) > 20 || Math.abs(this.mLastMotionY - y) > 20) {
                this.aoi = true;
                SafeHandler.getInst().removeCallbacks(this.aol);
            }
        } else if (motionEvent.getAction() == 1) {
            if (!this.aoj) {
                SafeHandler.getInst().removeCallbacks(this.aol);
                if (this.aok != null) {
                    this.aok.onClick(textView);
                    Selection.removeSelection(spannable);
                    this.aok = null;
                    return true;
                }
                return true;
            }
            this.aoj = false;
            return true;
        } else if (motionEvent.getAction() == 3) {
            if (!this.aoj) {
                SafeHandler.getInst().removeCallbacks(this.aol);
            }
            if (this.aok != null) {
                Selection.removeSelection(spannable);
            }
            this.aok = null;
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
