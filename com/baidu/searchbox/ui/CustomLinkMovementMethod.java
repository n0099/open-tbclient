package com.baidu.searchbox.ui;

import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.text.method.Touch;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.widget.TextView;
/* loaded from: classes13.dex */
public class CustomLinkMovementMethod extends LinkMovementMethod {
    private OnLinkMovementListener mLinkListener;

    /* loaded from: classes13.dex */
    public interface OnLinkMovementListener {
        void onLinkTouch(TextView textView, MotionEvent motionEvent);

        void onNoLinkTouch(TextView textView, MotionEvent motionEvent);
    }

    @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 1 || action == 0) {
            int x = ((int) motionEvent.getX()) - textView.getTotalPaddingLeft();
            int y = ((int) motionEvent.getY()) - textView.getTotalPaddingTop();
            int scrollX = x + textView.getScrollX();
            int scrollY = y + textView.getScrollY();
            Layout layout = textView.getLayout();
            int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical(scrollY), scrollX);
            Object[] objArr = (ClickableSpan[]) spannable.getSpans(offsetForHorizontal, offsetForHorizontal, ClickableSpan.class);
            if (objArr.length != 0) {
                if (action == 1) {
                    objArr[0].onClick(textView);
                } else if (action == 0) {
                    Selection.setSelection(spannable, spannable.getSpanStart(objArr[0]), spannable.getSpanEnd(objArr[0]));
                }
                if (this.mLinkListener != null) {
                    this.mLinkListener.onLinkTouch(textView, motionEvent);
                }
                return true;
            }
            if (this.mLinkListener != null) {
                this.mLinkListener.onNoLinkTouch(textView, motionEvent);
            }
            Selection.removeSelection(spannable);
            super.onTouchEvent(textView, spannable, motionEvent);
            return false;
        }
        return Touch.onTouchEvent(textView, spannable, motionEvent);
    }

    public void setLinkMovementListener(OnLinkMovementListener onLinkMovementListener) {
        this.mLinkListener = onLinkMovementListener;
    }
}
