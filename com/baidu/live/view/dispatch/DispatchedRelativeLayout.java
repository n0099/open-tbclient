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
    private boolean bQs;
    private boolean bQt;
    private a bQu;

    public DispatchedRelativeLayout(Context context) {
        super(context);
        this.bQs = false;
        this.bQt = false;
    }

    public DispatchedRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bQs = false;
        this.bQt = false;
    }

    public DispatchedRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bQs = false;
        this.bQt = false;
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (!this.bQs || !b.a(view, this.bQu)) {
            super.addView(view, i, layoutParams);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (this.bQt || !this.bQs || !b.b(view, this.bQu)) {
            super.removeView(view);
        }
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        super.removeAllViews();
        if (!this.bQt && this.bQs && this.bQu != null) {
            this.bQu.YI();
        }
    }

    @Override // android.view.ViewGroup
    public int indexOfChild(View view) {
        if (!this.bQt && this.bQs) {
            if (this.bQu == null || !this.bQu.ai(view)) {
                return super.indexOfChild(view);
            }
            return this.bQu.indexOfChild(view);
        }
        return super.indexOfChild(view);
    }

    public void setViewActionDispatched(boolean z) {
        if (this.bQs != z) {
            this.bQs = z;
            if (z) {
                YH();
            }
        }
    }

    private void YH() {
        if (this.bQs && getChildCount() > 0 && this.bQu != null) {
            LinkedList linkedList = new LinkedList();
            for (int i = 0; i < getChildCount(); i++) {
                View childAt = getChildAt(i);
                if (this.bQu.ai(childAt)) {
                    linkedList.add(childAt);
                }
            }
            this.bQt = true;
            if (!linkedList.isEmpty()) {
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    View view = (View) it.next();
                    super.removeView(view);
                    this.bQu.aj(view);
                }
            }
            this.bQt = false;
        }
    }

    public void setViewActionDispatchListener(a aVar) {
        this.bQu = aVar;
        YH();
    }
}
