package com.baidu.live.view.dispatch;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes2.dex */
public class DispatchedRelativeLayout extends RelativeLayout {
    private boolean aBv;
    private boolean aBw;
    private a aBx;

    public DispatchedRelativeLayout(Context context) {
        super(context);
        this.aBv = false;
        this.aBw = false;
    }

    public DispatchedRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aBv = false;
        this.aBw = false;
    }

    public DispatchedRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aBv = false;
        this.aBw = false;
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (!this.aBv || !b.a(view, this.aBx)) {
            super.addView(view, i, layoutParams);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (this.aBw || !this.aBv || !b.b(view, this.aBx)) {
            super.removeView(view);
        }
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        super.removeAllViews();
        if (!this.aBw && this.aBv && this.aBx != null) {
            this.aBx.ze();
        }
    }

    @Override // android.view.ViewGroup
    public int indexOfChild(View view) {
        if (!this.aBw && this.aBv) {
            if (this.aBx == null || !this.aBx.W(view)) {
                return super.indexOfChild(view);
            }
            return this.aBx.indexOfChild(view);
        }
        return super.indexOfChild(view);
    }

    public void setViewActionDispatched(boolean z) {
        if (this.aBv != z) {
            this.aBv = z;
            if (z) {
                zd();
            }
        }
    }

    public boolean zc() {
        return this.aBv;
    }

    private void zd() {
        if (this.aBv && getChildCount() > 0 && this.aBx != null) {
            LinkedList linkedList = new LinkedList();
            for (int i = 0; i < getChildCount(); i++) {
                View childAt = getChildAt(i);
                if (this.aBx.W(childAt)) {
                    linkedList.add(childAt);
                }
            }
            this.aBw = true;
            if (!linkedList.isEmpty()) {
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    View view = (View) it.next();
                    super.removeView(view);
                    this.aBx.onViewAdded(view);
                }
            }
            this.aBw = false;
        }
    }

    public void setViewActionDispatchListener(a aVar) {
        this.aBx = aVar;
        zd();
    }
}
