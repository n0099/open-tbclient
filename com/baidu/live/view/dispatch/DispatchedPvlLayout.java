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
    private boolean aFN;
    private boolean aFO;
    private a aFP;

    public DispatchedPvlLayout(Context context) {
        super(context);
        this.aFN = false;
        this.aFO = false;
    }

    public DispatchedPvlLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aFN = false;
        this.aFO = false;
    }

    public DispatchedPvlLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aFN = false;
        this.aFO = false;
    }

    @Override // com.baidu.live.view.PriorityVerticalLinearLayout, android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if ((!this.aFN || !b.a(view, this.aFP)) && layoutParams != null) {
            super.addView(view, i, layoutParams);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (this.aFO || !this.aFN || !b.b(view, this.aFP)) {
            super.removeView(view);
        }
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        super.removeAllViews();
        if (this.aFN && this.aFP != null) {
            this.aFP.Bw();
        }
    }

    @Override // android.view.ViewGroup
    public int indexOfChild(View view) {
        if (!this.aFO && this.aFN) {
            if (this.aFP == null || !this.aFP.W(view)) {
                return super.indexOfChild(view);
            }
            return this.aFP.indexOfChild(view);
        }
        return super.indexOfChild(view);
    }

    public void setViewActionDispatched(boolean z) {
        if (this.aFN != z) {
            this.aFN = z;
            if (z) {
                Bv();
            }
        }
    }

    public boolean Bu() {
        return this.aFN;
    }

    private void Bv() {
        if (this.aFN && getChildCount() > 0 && this.aFP != null) {
            LinkedList linkedList = new LinkedList();
            for (int i = 0; i < getChildCount(); i++) {
                View childAt = getChildAt(i);
                if (this.aFP.W(childAt)) {
                    linkedList.add(childAt);
                }
            }
            if (!linkedList.isEmpty()) {
                this.aFO = true;
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    View view = (View) it.next();
                    super.removeView(view);
                    this.aFP.onViewAdded(view);
                }
                this.aFO = false;
            }
        }
    }

    public void setViewActionDispatchListener(a aVar) {
        this.aFP = aVar;
        Bv();
    }
}
