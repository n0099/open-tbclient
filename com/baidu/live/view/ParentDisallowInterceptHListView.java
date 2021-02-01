package com.baidu.live.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.baidu.live.tieba.horizonallist.widget.HListView;
/* loaded from: classes11.dex */
public class ParentDisallowInterceptHListView extends HListView {
    public ParentDisallowInterceptHListView(Context context) {
        super(context);
    }

    public ParentDisallowInterceptHListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ParentDisallowInterceptHListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.baidu.live.tieba.horizonallist.widget.HListView, com.baidu.live.tieba.horizonallist.widget.AbsHListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & 255) {
            case 0:
            case 5:
                requestDisallowInterceptTouchEvent(true);
                break;
            case 1:
            case 3:
                requestDisallowInterceptTouchEvent(false);
                break;
        }
        return super.onTouchEvent(motionEvent);
    }
}
