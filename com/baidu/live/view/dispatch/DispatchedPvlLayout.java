package com.baidu.live.view.dispatch;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.view.PriorityVerticalLinearLayout;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes7.dex */
public class DispatchedPvlLayout extends PriorityVerticalLinearLayout {
    private boolean buB;
    private boolean buC;
    private a buD;

    public DispatchedPvlLayout(Context context) {
        super(context);
        this.buB = false;
        this.buC = false;
    }

    public DispatchedPvlLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.buB = false;
        this.buC = false;
    }

    public DispatchedPvlLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.buB = false;
        this.buC = false;
    }

    @Override // com.baidu.live.view.PriorityVerticalLinearLayout, android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if ((!this.buB || !b.a(view, this.buD)) && layoutParams != null) {
            super.addView(view, i, layoutParams);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (this.buC || !this.buB || !b.b(view, this.buD)) {
            super.removeView(view);
        }
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        super.removeAllViews();
        if (this.buB && this.buD != null) {
            this.buD.QP();
        }
    }

    @Override // android.view.ViewGroup
    public int indexOfChild(View view) {
        if (!this.buC && this.buB) {
            if (this.buD == null || !this.buD.ab(view)) {
                return super.indexOfChild(view);
            }
            return this.buD.indexOfChild(view);
        }
        return super.indexOfChild(view);
    }

    public void setViewActionDispatched(boolean z) {
        if (this.buB != z) {
            this.buB = z;
            if (z) {
                QO();
            }
        }
    }

    private void QO() {
        if (this.buB && getChildCount() > 0 && this.buD != null) {
            LinkedList linkedList = new LinkedList();
            for (int i = 0; i < getChildCount(); i++) {
                View childAt = getChildAt(i);
                if (this.buD.ab(childAt)) {
                    linkedList.add(childAt);
                }
            }
            if (!linkedList.isEmpty()) {
                this.buC = true;
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    View view = (View) it.next();
                    super.removeView(view);
                    this.buD.onViewAdded(view);
                }
                this.buC = false;
            }
        }
    }

    public void setViewActionDispatchListener(a aVar) {
        this.buD = aVar;
        QO();
    }
}
