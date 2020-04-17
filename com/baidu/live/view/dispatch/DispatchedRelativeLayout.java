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
    private boolean bbI;
    private boolean bbJ;
    private a bbK;

    public DispatchedRelativeLayout(Context context) {
        super(context);
        this.bbI = false;
        this.bbJ = false;
    }

    public DispatchedRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bbI = false;
        this.bbJ = false;
    }

    public DispatchedRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bbI = false;
        this.bbJ = false;
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (!this.bbI || !b.a(view, this.bbK)) {
            super.addView(view, i, layoutParams);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (this.bbJ || !this.bbI || !b.b(view, this.bbK)) {
            super.removeView(view);
        }
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        super.removeAllViews();
        if (!this.bbJ && this.bbI && this.bbK != null) {
            this.bbK.HH();
        }
    }

    @Override // android.view.ViewGroup
    public int indexOfChild(View view) {
        if (!this.bbJ && this.bbI) {
            if (this.bbK == null || !this.bbK.Y(view)) {
                return super.indexOfChild(view);
            }
            return this.bbK.indexOfChild(view);
        }
        return super.indexOfChild(view);
    }

    public void setViewActionDispatched(boolean z) {
        if (this.bbI != z) {
            this.bbI = z;
            if (z) {
                HG();
            }
        }
    }

    public boolean HF() {
        return this.bbI;
    }

    private void HG() {
        if (this.bbI && getChildCount() > 0 && this.bbK != null) {
            LinkedList linkedList = new LinkedList();
            for (int i = 0; i < getChildCount(); i++) {
                View childAt = getChildAt(i);
                if (this.bbK.Y(childAt)) {
                    linkedList.add(childAt);
                }
            }
            this.bbJ = true;
            if (!linkedList.isEmpty()) {
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    View view = (View) it.next();
                    super.removeView(view);
                    this.bbK.onViewAdded(view);
                }
            }
            this.bbJ = false;
        }
    }

    public void setViewActionDispatchListener(a aVar) {
        this.bbK = aVar;
        HG();
    }
}
