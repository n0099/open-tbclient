package com.baidu.live.view.dispatch;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes10.dex */
public class DispatchedRelativeLayout extends RelativeLayout {
    private boolean bWg;
    private boolean bWh;
    private a bWi;

    public DispatchedRelativeLayout(Context context) {
        super(context);
        this.bWg = false;
        this.bWh = false;
    }

    public DispatchedRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bWg = false;
        this.bWh = false;
    }

    public DispatchedRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bWg = false;
        this.bWh = false;
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (!this.bWg || !b.a(view, this.bWi)) {
            super.addView(view, i, layoutParams);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (this.bWh || !this.bWg || !b.b(view, this.bWi)) {
            super.removeView(view);
        }
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        super.removeAllViews();
        if (!this.bWh && this.bWg && this.bWi != null) {
            this.bWi.XP();
        }
    }

    @Override // android.view.ViewGroup
    public int indexOfChild(View view) {
        if (!this.bWh && this.bWg) {
            if (this.bWi == null || !this.bWi.ai(view)) {
                return super.indexOfChild(view);
            }
            return this.bWi.indexOfChild(view);
        }
        return super.indexOfChild(view);
    }

    public void setViewActionDispatched(boolean z) {
        if (this.bWg != z) {
            this.bWg = z;
            if (z) {
                XO();
            }
        }
    }

    private void XO() {
        if (this.bWg && getChildCount() > 0 && this.bWi != null) {
            LinkedList linkedList = new LinkedList();
            for (int i = 0; i < getChildCount(); i++) {
                View childAt = getChildAt(i);
                if (this.bWi.ai(childAt)) {
                    linkedList.add(childAt);
                }
            }
            this.bWh = true;
            if (!linkedList.isEmpty()) {
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    View view = (View) it.next();
                    super.removeView(view);
                    this.bWi.onViewAdded(view);
                }
            }
            this.bWh = false;
        }
    }

    public void setViewActionDispatchListener(a aVar) {
        this.bWi = aVar;
        XO();
    }
}
