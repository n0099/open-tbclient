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
    private boolean bHs;
    private boolean bHt;
    private a bHu;

    public DispatchedPvlLayout(Context context) {
        super(context);
        this.bHs = false;
        this.bHt = false;
    }

    public DispatchedPvlLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bHs = false;
        this.bHt = false;
    }

    public DispatchedPvlLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bHs = false;
        this.bHt = false;
    }

    @Override // com.baidu.live.view.PriorityVerticalLinearLayout, android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if ((!this.bHs || !b.a(view, this.bHu)) && layoutParams != null) {
            super.addView(view, i, layoutParams);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (this.bHt || !this.bHs || !b.b(view, this.bHu)) {
            super.removeView(view);
        }
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        super.removeAllViews();
        if (this.bHs && this.bHu != null) {
            this.bHu.Ur();
        }
    }

    @Override // android.view.ViewGroup
    public int indexOfChild(View view) {
        if (!this.bHt && this.bHs) {
            if (this.bHu == null || !this.bHu.ae(view)) {
                return super.indexOfChild(view);
            }
            return this.bHu.indexOfChild(view);
        }
        return super.indexOfChild(view);
    }

    public void setViewActionDispatched(boolean z) {
        if (this.bHs != z) {
            this.bHs = z;
            if (z) {
                Uq();
            }
        }
    }

    private void Uq() {
        if (this.bHs && getChildCount() > 0 && this.bHu != null) {
            LinkedList linkedList = new LinkedList();
            for (int i = 0; i < getChildCount(); i++) {
                View childAt = getChildAt(i);
                if (this.bHu.ae(childAt)) {
                    linkedList.add(childAt);
                }
            }
            if (!linkedList.isEmpty()) {
                this.bHt = true;
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    View view = (View) it.next();
                    super.removeView(view);
                    this.bHu.onViewAdded(view);
                }
                this.bHt = false;
            }
        }
    }

    public void setViewActionDispatchListener(a aVar) {
        this.bHu = aVar;
        Uq();
    }
}
