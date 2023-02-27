package com.baidu.searchbox.ui.span;

import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.view.MotionEvent;
import android.widget.TextView;
import androidx.annotation.Nullable;
/* loaded from: classes3.dex */
public class BdLinkTouchDecorHelper {
    public ITouchableSpan mTouchableSpan;

    private ITouchableSpan getPressedSpan(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        int i;
        int x = ((int) motionEvent.getX()) - textView.getTotalPaddingLeft();
        int y = ((int) motionEvent.getY()) - textView.getTotalPaddingTop();
        int scrollX = x + textView.getScrollX();
        Layout layout = textView.getLayout();
        int lineForVertical = layout.getLineForVertical(y + textView.getScrollY());
        float f = scrollX;
        if (f >= layout.getLineLeft(lineForVertical) && f <= layout.getLineRight(lineForVertical)) {
            i = layout.getOffsetForHorizontal(lineForVertical, f);
        } else {
            i = -1;
        }
        ITouchableSpan[] iTouchableSpanArr = (ITouchableSpan[]) spannable.getSpans(i, i, ITouchableSpan.class);
        if (iTouchableSpanArr.length <= 0) {
            return null;
        }
        return iTouchableSpanArr[0];
    }

    private void updatePressStatus(ITouchableSpan iTouchableSpan, TextView textView, boolean z) {
        if (iTouchableSpan != null) {
            iTouchableSpan.setPressed(z);
        }
        if (textView instanceof ISpanTouchFix) {
            ((ISpanTouchFix) textView).onSpanSetPressed(z);
        }
    }

    public void clearSpanState(@Nullable TextView textView) {
        ITouchableSpan iTouchableSpan = this.mTouchableSpan;
        if (iTouchableSpan != null && textView != null) {
            updatePressStatus(iTouchableSpan, textView, false);
        }
    }

    public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        boolean z;
        boolean z2;
        boolean z3 = true;
        if (motionEvent.getAction() == 0) {
            ITouchableSpan pressedSpan = getPressedSpan(textView, spannable, motionEvent);
            this.mTouchableSpan = pressedSpan;
            if (pressedSpan != null) {
                updatePressStatus(pressedSpan, textView, true);
                Selection.setSelection(spannable, spannable.getSpanStart(this.mTouchableSpan), spannable.getSpanEnd(this.mTouchableSpan));
            }
            if (textView instanceof ISpanTouchFix) {
                ISpanTouchFix iSpanTouchFix = (ISpanTouchFix) textView;
                if (this.mTouchableSpan != null) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                iSpanTouchFix.setTouchSpanHit(z2);
            }
            if (this.mTouchableSpan != null) {
                return true;
            }
            return false;
        } else if (motionEvent.getAction() == 2) {
            ITouchableSpan pressedSpan2 = getPressedSpan(textView, spannable, motionEvent);
            ITouchableSpan iTouchableSpan = this.mTouchableSpan;
            if (iTouchableSpan != null && pressedSpan2 != iTouchableSpan) {
                updatePressStatus(iTouchableSpan, textView, false);
                this.mTouchableSpan = null;
                Selection.removeSelection(spannable);
            }
            if (textView instanceof ISpanTouchFix) {
                ISpanTouchFix iSpanTouchFix2 = (ISpanTouchFix) textView;
                if (this.mTouchableSpan != null) {
                    z = true;
                } else {
                    z = false;
                }
                iSpanTouchFix2.setTouchSpanHit(z);
            }
            if (this.mTouchableSpan != null) {
                return true;
            }
            return false;
        } else if (motionEvent.getAction() == 1) {
            ITouchableSpan iTouchableSpan2 = this.mTouchableSpan;
            if (iTouchableSpan2 != null) {
                updatePressStatus(iTouchableSpan2, textView, false);
                this.mTouchableSpan.onClick(textView);
            } else {
                z3 = false;
            }
            this.mTouchableSpan = null;
            Selection.removeSelection(spannable);
            if (textView instanceof ISpanTouchFix) {
                ((ISpanTouchFix) textView).setTouchSpanHit(z3);
            }
            return z3;
        } else {
            ITouchableSpan iTouchableSpan3 = this.mTouchableSpan;
            if (iTouchableSpan3 != null) {
                updatePressStatus(iTouchableSpan3, textView, false);
            }
            if (textView instanceof ISpanTouchFix) {
                ((ISpanTouchFix) textView).setTouchSpanHit(false);
            }
            Selection.removeSelection(spannable);
            return false;
        }
    }
}
