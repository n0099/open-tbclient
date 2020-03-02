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
    private boolean aFM;
    private boolean aFN;
    private a aFO;

    public DispatchedPvlLayout(Context context) {
        super(context);
        this.aFM = false;
        this.aFN = false;
    }

    public DispatchedPvlLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aFM = false;
        this.aFN = false;
    }

    public DispatchedPvlLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aFM = false;
        this.aFN = false;
    }

    @Override // com.baidu.live.view.PriorityVerticalLinearLayout, android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if ((!this.aFM || !b.a(view, this.aFO)) && layoutParams != null) {
            super.addView(view, i, layoutParams);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (this.aFN || !this.aFM || !b.b(view, this.aFO)) {
            super.removeView(view);
        }
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        super.removeAllViews();
        if (this.aFM && this.aFO != null) {
            this.aFO.Bw();
        }
    }

    @Override // android.view.ViewGroup
    public int indexOfChild(View view) {
        if (!this.aFN && this.aFM) {
            if (this.aFO == null || !this.aFO.W(view)) {
                return super.indexOfChild(view);
            }
            return this.aFO.indexOfChild(view);
        }
        return super.indexOfChild(view);
    }

    public void setViewActionDispatched(boolean z) {
        if (this.aFM != z) {
            this.aFM = z;
            if (z) {
                Bv();
            }
        }
    }

    public boolean Bu() {
        return this.aFM;
    }

    private void Bv() {
        if (this.aFM && getChildCount() > 0 && this.aFO != null) {
            LinkedList linkedList = new LinkedList();
            for (int i = 0; i < getChildCount(); i++) {
                View childAt = getChildAt(i);
                if (this.aFO.W(childAt)) {
                    linkedList.add(childAt);
                }
            }
            if (!linkedList.isEmpty()) {
                this.aFN = true;
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    View view = (View) it.next();
                    super.removeView(view);
                    this.aFO.onViewAdded(view);
                }
                this.aFN = false;
            }
        }
    }

    public void setViewActionDispatchListener(a aVar) {
        this.aFO = aVar;
        Bv();
    }
}
