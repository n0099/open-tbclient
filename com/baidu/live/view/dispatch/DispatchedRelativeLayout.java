package com.baidu.live.view.dispatch;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes4.dex */
public class DispatchedRelativeLayout extends RelativeLayout {
    private boolean bxQ;
    private boolean bxR;
    private a bxS;

    public DispatchedRelativeLayout(Context context) {
        super(context);
        this.bxQ = false;
        this.bxR = false;
    }

    public DispatchedRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bxQ = false;
        this.bxR = false;
    }

    public DispatchedRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bxQ = false;
        this.bxR = false;
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (!this.bxQ || !b.a(view, this.bxS)) {
            super.addView(view, i, layoutParams);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (this.bxR || !this.bxQ || !b.b(view, this.bxS)) {
            super.removeView(view);
        }
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        super.removeAllViews();
        if (!this.bxR && this.bxQ && this.bxS != null) {
            this.bxS.Ry();
        }
    }

    @Override // android.view.ViewGroup
    public int indexOfChild(View view) {
        if (!this.bxR && this.bxQ) {
            if (this.bxS == null || !this.bxS.ad(view)) {
                return super.indexOfChild(view);
            }
            return this.bxS.indexOfChild(view);
        }
        return super.indexOfChild(view);
    }

    public void setViewActionDispatched(boolean z) {
        if (this.bxQ != z) {
            this.bxQ = z;
            if (z) {
                Rx();
            }
        }
    }

    private void Rx() {
        if (this.bxQ && getChildCount() > 0 && this.bxS != null) {
            LinkedList linkedList = new LinkedList();
            for (int i = 0; i < getChildCount(); i++) {
                View childAt = getChildAt(i);
                if (this.bxS.ad(childAt)) {
                    linkedList.add(childAt);
                }
            }
            this.bxR = true;
            if (!linkedList.isEmpty()) {
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    View view = (View) it.next();
                    super.removeView(view);
                    this.bxS.onViewAdded(view);
                }
            }
            this.bxR = false;
        }
    }

    public void setViewActionDispatchListener(a aVar) {
        this.bxS = aVar;
        Rx();
    }
}
