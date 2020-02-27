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
    private boolean aFL;
    private boolean aFM;
    private a aFN;

    public DispatchedPvlLayout(Context context) {
        super(context);
        this.aFL = false;
        this.aFM = false;
    }

    public DispatchedPvlLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aFL = false;
        this.aFM = false;
    }

    public DispatchedPvlLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aFL = false;
        this.aFM = false;
    }

    @Override // com.baidu.live.view.PriorityVerticalLinearLayout, android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if ((!this.aFL || !b.a(view, this.aFN)) && layoutParams != null) {
            super.addView(view, i, layoutParams);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (this.aFM || !this.aFL || !b.b(view, this.aFN)) {
            super.removeView(view);
        }
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        super.removeAllViews();
        if (this.aFL && this.aFN != null) {
            this.aFN.Bu();
        }
    }

    @Override // android.view.ViewGroup
    public int indexOfChild(View view) {
        if (!this.aFM && this.aFL) {
            if (this.aFN == null || !this.aFN.W(view)) {
                return super.indexOfChild(view);
            }
            return this.aFN.indexOfChild(view);
        }
        return super.indexOfChild(view);
    }

    public void setViewActionDispatched(boolean z) {
        if (this.aFL != z) {
            this.aFL = z;
            if (z) {
                Bt();
            }
        }
    }

    public boolean Bs() {
        return this.aFL;
    }

    private void Bt() {
        if (this.aFL && getChildCount() > 0 && this.aFN != null) {
            LinkedList linkedList = new LinkedList();
            for (int i = 0; i < getChildCount(); i++) {
                View childAt = getChildAt(i);
                if (this.aFN.W(childAt)) {
                    linkedList.add(childAt);
                }
            }
            if (!linkedList.isEmpty()) {
                this.aFM = true;
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    View view = (View) it.next();
                    super.removeView(view);
                    this.aFN.onViewAdded(view);
                }
                this.aFM = false;
            }
        }
    }

    public void setViewActionDispatchListener(a aVar) {
        this.aFN = aVar;
        Bt();
    }
}
