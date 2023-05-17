package com.baidu.searchbox.ui.span;

import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.text.method.Touch;
import android.view.MotionEvent;
import android.widget.TextView;
import androidx.annotation.Nullable;
/* loaded from: classes4.dex */
public class BdLinkTouchMovementMethod extends LinkMovementMethod {
    public static BdLinkTouchMovementMethod instance;
    public BdLinkTouchDecorHelper mBdLinkTouchDecorHelper = new BdLinkTouchDecorHelper();

    public static BdLinkTouchMovementMethod getInstance() {
        if (instance == null) {
            synchronized (BdLinkTouchMovementMethod.class) {
                if (instance == null) {
                    instance = new BdLinkTouchMovementMethod();
                }
            }
        }
        return instance;
    }

    public void clearSpanUiStatus(@Nullable TextView textView) {
        BdLinkTouchDecorHelper bdLinkTouchDecorHelper;
        if (textView != null && (bdLinkTouchDecorHelper = this.mBdLinkTouchDecorHelper) != null) {
            bdLinkTouchDecorHelper.clearSpanState(textView);
        }
    }

    @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        if (!this.mBdLinkTouchDecorHelper.onTouchEvent(textView, spannable, motionEvent) && !Touch.onTouchEvent(textView, spannable, motionEvent)) {
            return false;
        }
        return true;
    }
}
