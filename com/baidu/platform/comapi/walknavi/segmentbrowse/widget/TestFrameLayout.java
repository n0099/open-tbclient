package com.baidu.platform.comapi.walknavi.segmentbrowse.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes6.dex */
public class TestFrameLayout extends FrameLayout {
    public TestFrameLayout(Context context) {
        super(context);
    }

    public TestFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        com.baidu.platform.comapi.wnplatform.d.a.a("child count", "count" + getChildCount());
        for (int i = 0; i < getChildCount(); i++) {
            getChildAt(i).dispatchTouchEvent(motionEvent);
        }
        return true;
    }
}
