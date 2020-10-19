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
    private boolean bEt;
    private boolean bEu;
    private a bEv;

    public DispatchedRelativeLayout(Context context) {
        super(context);
        this.bEt = false;
        this.bEu = false;
    }

    public DispatchedRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bEt = false;
        this.bEu = false;
    }

    public DispatchedRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bEt = false;
        this.bEu = false;
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (!this.bEt || !b.a(view, this.bEv)) {
            super.addView(view, i, layoutParams);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (this.bEu || !this.bEt || !b.b(view, this.bEv)) {
            super.removeView(view);
        }
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        super.removeAllViews();
        if (!this.bEu && this.bEt && this.bEv != null) {
            this.bEv.Tr();
        }
    }

    @Override // android.view.ViewGroup
    public int indexOfChild(View view) {
        if (!this.bEu && this.bEt) {
            if (this.bEv == null || !this.bEv.ae(view)) {
                return super.indexOfChild(view);
            }
            return this.bEv.indexOfChild(view);
        }
        return super.indexOfChild(view);
    }

    public void setViewActionDispatched(boolean z) {
        if (this.bEt != z) {
            this.bEt = z;
            if (z) {
                Tq();
            }
        }
    }

    private void Tq() {
        if (this.bEt && getChildCount() > 0 && this.bEv != null) {
            LinkedList linkedList = new LinkedList();
            for (int i = 0; i < getChildCount(); i++) {
                View childAt = getChildAt(i);
                if (this.bEv.ae(childAt)) {
                    linkedList.add(childAt);
                }
            }
            this.bEu = true;
            if (!linkedList.isEmpty()) {
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    View view = (View) it.next();
                    super.removeView(view);
                    this.bEv.onViewAdded(view);
                }
            }
            this.bEu = false;
        }
    }

    public void setViewActionDispatchListener(a aVar) {
        this.bEv = aVar;
        Tq();
    }
}
