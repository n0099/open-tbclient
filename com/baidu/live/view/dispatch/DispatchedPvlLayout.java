package com.baidu.live.view.dispatch;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.view.PriorityVerticalLinearLayout;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes7.dex */
public class DispatchedPvlLayout extends PriorityVerticalLinearLayout {
    private a buA;
    private boolean buy;
    private boolean buz;

    public DispatchedPvlLayout(Context context) {
        super(context);
        this.buy = false;
        this.buz = false;
    }

    public DispatchedPvlLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.buy = false;
        this.buz = false;
    }

    public DispatchedPvlLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.buy = false;
        this.buz = false;
    }

    @Override // com.baidu.live.view.PriorityVerticalLinearLayout, android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if ((!this.buy || !b.a(view, this.buA)) && layoutParams != null) {
            super.addView(view, i, layoutParams);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (this.buz || !this.buy || !b.b(view, this.buA)) {
            super.removeView(view);
        }
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        super.removeAllViews();
        if (this.buy && this.buA != null) {
            this.buA.QP();
        }
    }

    @Override // android.view.ViewGroup
    public int indexOfChild(View view) {
        if (!this.buz && this.buy) {
            if (this.buA == null || !this.buA.ab(view)) {
                return super.indexOfChild(view);
            }
            return this.buA.indexOfChild(view);
        }
        return super.indexOfChild(view);
    }

    public void setViewActionDispatched(boolean z) {
        if (this.buy != z) {
            this.buy = z;
            if (z) {
                QO();
            }
        }
    }

    private void QO() {
        if (this.buy && getChildCount() > 0 && this.buA != null) {
            LinkedList linkedList = new LinkedList();
            for (int i = 0; i < getChildCount(); i++) {
                View childAt = getChildAt(i);
                if (this.buA.ab(childAt)) {
                    linkedList.add(childAt);
                }
            }
            if (!linkedList.isEmpty()) {
                this.buz = true;
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    View view = (View) it.next();
                    super.removeView(view);
                    this.buA.onViewAdded(view);
                }
                this.buz = false;
            }
        }
    }

    public void setViewActionDispatchListener(a aVar) {
        this.buA = aVar;
        QO();
    }
}
