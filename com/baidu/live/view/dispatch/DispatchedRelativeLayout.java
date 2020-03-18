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
    private boolean aGb;
    private boolean aGc;
    private a aGd;

    public DispatchedRelativeLayout(Context context) {
        super(context);
        this.aGb = false;
        this.aGc = false;
    }

    public DispatchedRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aGb = false;
        this.aGc = false;
    }

    public DispatchedRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aGb = false;
        this.aGc = false;
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (!this.aGb || !b.a(view, this.aGd)) {
            super.addView(view, i, layoutParams);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (this.aGc || !this.aGb || !b.b(view, this.aGd)) {
            super.removeView(view);
        }
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        super.removeAllViews();
        if (!this.aGc && this.aGb && this.aGd != null) {
            this.aGd.BD();
        }
    }

    @Override // android.view.ViewGroup
    public int indexOfChild(View view) {
        if (!this.aGc && this.aGb) {
            if (this.aGd == null || !this.aGd.W(view)) {
                return super.indexOfChild(view);
            }
            return this.aGd.indexOfChild(view);
        }
        return super.indexOfChild(view);
    }

    public void setViewActionDispatched(boolean z) {
        if (this.aGb != z) {
            this.aGb = z;
            if (z) {
                BC();
            }
        }
    }

    public boolean BB() {
        return this.aGb;
    }

    private void BC() {
        if (this.aGb && getChildCount() > 0 && this.aGd != null) {
            LinkedList linkedList = new LinkedList();
            for (int i = 0; i < getChildCount(); i++) {
                View childAt = getChildAt(i);
                if (this.aGd.W(childAt)) {
                    linkedList.add(childAt);
                }
            }
            this.aGc = true;
            if (!linkedList.isEmpty()) {
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    View view = (View) it.next();
                    super.removeView(view);
                    this.aGd.onViewAdded(view);
                }
            }
            this.aGc = false;
        }
    }

    public void setViewActionDispatchListener(a aVar) {
        this.aGd = aVar;
        BC();
    }
}
