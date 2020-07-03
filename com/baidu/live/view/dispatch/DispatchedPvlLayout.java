package com.baidu.live.view.dispatch;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.view.PriorityVerticalLinearLayout;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes3.dex */
public class DispatchedPvlLayout extends PriorityVerticalLinearLayout {
    private boolean boq;
    private boolean bor;
    private a bos;

    public DispatchedPvlLayout(Context context) {
        super(context);
        this.boq = false;
        this.bor = false;
    }

    public DispatchedPvlLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.boq = false;
        this.bor = false;
    }

    public DispatchedPvlLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.boq = false;
        this.bor = false;
    }

    @Override // com.baidu.live.view.PriorityVerticalLinearLayout, android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if ((!this.boq || !b.a(view, this.bos)) && layoutParams != null) {
            super.addView(view, i, layoutParams);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (this.bor || !this.boq || !b.b(view, this.bos)) {
            super.removeView(view);
        }
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        super.removeAllViews();
        if (this.boq && this.bos != null) {
            this.bos.KJ();
        }
    }

    @Override // android.view.ViewGroup
    public int indexOfChild(View view) {
        if (!this.bor && this.boq) {
            if (this.bos == null || !this.bos.X(view)) {
                return super.indexOfChild(view);
            }
            return this.bos.indexOfChild(view);
        }
        return super.indexOfChild(view);
    }

    public void setViewActionDispatched(boolean z) {
        if (this.boq != z) {
            this.boq = z;
            if (z) {
                KI();
            }
        }
    }

    private void KI() {
        if (this.boq && getChildCount() > 0 && this.bos != null) {
            LinkedList linkedList = new LinkedList();
            for (int i = 0; i < getChildCount(); i++) {
                View childAt = getChildAt(i);
                if (this.bos.X(childAt)) {
                    linkedList.add(childAt);
                }
            }
            if (!linkedList.isEmpty()) {
                this.bor = true;
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    View view = (View) it.next();
                    super.removeView(view);
                    this.bos.onViewAdded(view);
                }
                this.bor = false;
            }
        }
    }

    public void setViewActionDispatchListener(a aVar) {
        this.bos = aVar;
        KI();
    }
}
