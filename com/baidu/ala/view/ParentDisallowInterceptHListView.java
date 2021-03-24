package com.baidu.ala.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.baidu.tieba.horizonalList.widget.HListView;
/* loaded from: classes2.dex */
public class ParentDisallowInterceptHListView extends HListView {
    public ParentDisallowInterceptHListView(Context context) {
        super(context);
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x000f, code lost:
        if (r0 != 5) goto L8;
     */
    @Override // com.baidu.tieba.horizonalList.widget.HListView, com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            if (action == 1 || action == 3) {
                requestDisallowInterceptTouchEvent(false);
            }
            return super.onTouchEvent(motionEvent);
        }
        requestDisallowInterceptTouchEvent(true);
        return super.onTouchEvent(motionEvent);
    }

    public ParentDisallowInterceptHListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ParentDisallowInterceptHListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
