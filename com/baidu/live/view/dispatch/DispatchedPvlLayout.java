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
    private boolean boL;
    private boolean boM;
    private a boN;

    public DispatchedPvlLayout(Context context) {
        super(context);
        this.boL = false;
        this.boM = false;
    }

    public DispatchedPvlLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.boL = false;
        this.boM = false;
    }

    public DispatchedPvlLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.boL = false;
        this.boM = false;
    }

    @Override // com.baidu.live.view.PriorityVerticalLinearLayout, android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if ((!this.boL || !b.a(view, this.boN)) && layoutParams != null) {
            super.addView(view, i, layoutParams);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (this.boM || !this.boL || !b.b(view, this.boN)) {
            super.removeView(view);
        }
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        super.removeAllViews();
        if (this.boL && this.boN != null) {
            this.boN.KQ();
        }
    }

    @Override // android.view.ViewGroup
    public int indexOfChild(View view) {
        if (!this.boM && this.boL) {
            if (this.boN == null || !this.boN.aa(view)) {
                return super.indexOfChild(view);
            }
            return this.boN.indexOfChild(view);
        }
        return super.indexOfChild(view);
    }

    public void setViewActionDispatched(boolean z) {
        if (this.boL != z) {
            this.boL = z;
            if (z) {
                KP();
            }
        }
    }

    private void KP() {
        if (this.boL && getChildCount() > 0 && this.boN != null) {
            LinkedList linkedList = new LinkedList();
            for (int i = 0; i < getChildCount(); i++) {
                View childAt = getChildAt(i);
                if (this.boN.aa(childAt)) {
                    linkedList.add(childAt);
                }
            }
            if (!linkedList.isEmpty()) {
                this.boM = true;
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    View view = (View) it.next();
                    super.removeView(view);
                    this.boN.onViewAdded(view);
                }
                this.boM = false;
            }
        }
    }

    public void setViewActionDispatchListener(a aVar) {
        this.boN = aVar;
        KP();
    }
}
