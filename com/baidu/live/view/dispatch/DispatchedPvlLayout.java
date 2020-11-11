package com.baidu.live.view.dispatch;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.view.PriorityVerticalLinearLayout;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes4.dex */
public class DispatchedPvlLayout extends PriorityVerticalLinearLayout {
    private boolean bMX;
    private boolean bMY;
    private a bMZ;

    public DispatchedPvlLayout(Context context) {
        super(context);
        this.bMX = false;
        this.bMY = false;
    }

    public DispatchedPvlLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bMX = false;
        this.bMY = false;
    }

    public DispatchedPvlLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bMX = false;
        this.bMY = false;
    }

    @Override // com.baidu.live.view.PriorityVerticalLinearLayout, android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if ((!this.bMX || !b.a(view, this.bMZ)) && layoutParams != null) {
            super.addView(view, i, layoutParams);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (this.bMY || !this.bMX || !b.b(view, this.bMZ)) {
            super.removeView(view);
        }
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        super.removeAllViews();
        if (this.bMX && this.bMZ != null) {
            this.bMZ.WR();
        }
    }

    @Override // android.view.ViewGroup
    public int indexOfChild(View view) {
        if (!this.bMY && this.bMX) {
            if (this.bMZ == null || !this.bMZ.ai(view)) {
                return super.indexOfChild(view);
            }
            return this.bMZ.indexOfChild(view);
        }
        return super.indexOfChild(view);
    }

    public void setViewActionDispatched(boolean z) {
        if (this.bMX != z) {
            this.bMX = z;
            if (z) {
                WQ();
            }
        }
    }

    private void WQ() {
        if (this.bMX && getChildCount() > 0 && this.bMZ != null) {
            LinkedList linkedList = new LinkedList();
            for (int i = 0; i < getChildCount(); i++) {
                View childAt = getChildAt(i);
                if (this.bMZ.ai(childAt)) {
                    linkedList.add(childAt);
                }
            }
            if (!linkedList.isEmpty()) {
                this.bMY = true;
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    View view = (View) it.next();
                    super.removeView(view);
                    this.bMZ.onViewAdded(view);
                }
                this.bMY = false;
            }
        }
    }

    public void setViewActionDispatchListener(a aVar) {
        this.bMZ = aVar;
        WQ();
    }
}
