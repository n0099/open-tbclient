package com.baidu.live.view.dispatch;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.view.PriorityVerticalLinearLayout;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes11.dex */
public class DispatchedPvlLayout extends PriorityVerticalLinearLayout {
    private boolean bUG;
    private boolean bUH;
    private a bUI;

    public DispatchedPvlLayout(Context context) {
        super(context);
        this.bUG = false;
        this.bUH = false;
    }

    public DispatchedPvlLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bUG = false;
        this.bUH = false;
    }

    public DispatchedPvlLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bUG = false;
        this.bUH = false;
    }

    @Override // com.baidu.live.view.PriorityVerticalLinearLayout, android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if ((!this.bUG || !b.a(view, this.bUI)) && layoutParams != null) {
            super.addView(view, i, layoutParams);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (this.bUH || !this.bUG || !b.b(view, this.bUI)) {
            super.removeView(view);
        }
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        super.removeAllViews();
        if (this.bUG && this.bUI != null) {
            this.bUI.XM();
        }
    }

    @Override // android.view.ViewGroup
    public int indexOfChild(View view) {
        if (!this.bUH && this.bUG) {
            if (this.bUI == null || !this.bUI.ai(view)) {
                return super.indexOfChild(view);
            }
            return this.bUI.indexOfChild(view);
        }
        return super.indexOfChild(view);
    }

    public void setViewActionDispatched(boolean z) {
        if (this.bUG != z) {
            this.bUG = z;
            if (z) {
                XL();
            }
        }
    }

    private void XL() {
        if (this.bUG && getChildCount() > 0 && this.bUI != null) {
            LinkedList linkedList = new LinkedList();
            for (int i = 0; i < getChildCount(); i++) {
                View childAt = getChildAt(i);
                if (this.bUI.ai(childAt)) {
                    linkedList.add(childAt);
                }
            }
            if (!linkedList.isEmpty()) {
                this.bUH = true;
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    View view = (View) it.next();
                    super.removeView(view);
                    this.bUI.onViewAdded(view);
                }
                this.bUH = false;
            }
        }
    }

    public void setViewActionDispatchListener(a aVar) {
        this.bUI = aVar;
        XL();
    }
}
