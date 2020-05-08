package com.baidu.live.view.dispatch;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes3.dex */
public class DispatchedRelativeLayout extends RelativeLayout {
    private boolean bbN;
    private boolean bbO;
    private a bbP;

    public DispatchedRelativeLayout(Context context) {
        super(context);
        this.bbN = false;
        this.bbO = false;
    }

    public DispatchedRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bbN = false;
        this.bbO = false;
    }

    public DispatchedRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bbN = false;
        this.bbO = false;
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (!this.bbN || !b.a(view, this.bbP)) {
            super.addView(view, i, layoutParams);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (this.bbO || !this.bbN || !b.b(view, this.bbP)) {
            super.removeView(view);
        }
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        super.removeAllViews();
        if (!this.bbO && this.bbN && this.bbP != null) {
            this.bbP.HG();
        }
    }

    @Override // android.view.ViewGroup
    public int indexOfChild(View view) {
        if (!this.bbO && this.bbN) {
            if (this.bbP == null || !this.bbP.Y(view)) {
                return super.indexOfChild(view);
            }
            return this.bbP.indexOfChild(view);
        }
        return super.indexOfChild(view);
    }

    public void setViewActionDispatched(boolean z) {
        if (this.bbN != z) {
            this.bbN = z;
            if (z) {
                HF();
            }
        }
    }

    public boolean HE() {
        return this.bbN;
    }

    private void HF() {
        if (this.bbN && getChildCount() > 0 && this.bbP != null) {
            LinkedList linkedList = new LinkedList();
            for (int i = 0; i < getChildCount(); i++) {
                View childAt = getChildAt(i);
                if (this.bbP.Y(childAt)) {
                    linkedList.add(childAt);
                }
            }
            this.bbO = true;
            if (!linkedList.isEmpty()) {
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    View view = (View) it.next();
                    super.removeView(view);
                    this.bbP.onViewAdded(view);
                }
            }
            this.bbO = false;
        }
    }

    public void setViewActionDispatchListener(a aVar) {
        this.bbP = aVar;
        HF();
    }
}
