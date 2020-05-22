package com.baidu.live.view.dispatch;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.view.PriorityVerticalLinearLayout;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes3.dex */
public class DispatchedPvlLayout extends PriorityVerticalLinearLayout {
    private boolean bjn;
    private boolean bjo;
    private a bjp;

    public DispatchedPvlLayout(Context context) {
        super(context);
        this.bjn = false;
        this.bjo = false;
    }

    public DispatchedPvlLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bjn = false;
        this.bjo = false;
    }

    public DispatchedPvlLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bjn = false;
        this.bjo = false;
    }

    @Override // com.baidu.live.view.PriorityVerticalLinearLayout, android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if ((!this.bjn || !b.a(view, this.bjp)) && layoutParams != null) {
            super.addView(view, i, layoutParams);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (this.bjo || !this.bjn || !b.b(view, this.bjp)) {
            super.removeView(view);
        }
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        super.removeAllViews();
        if (this.bjn && this.bjp != null) {
            this.bjp.Jz();
        }
    }

    @Override // android.view.ViewGroup
    public int indexOfChild(View view) {
        if (!this.bjo && this.bjn) {
            if (this.bjp == null || !this.bjp.X(view)) {
                return super.indexOfChild(view);
            }
            return this.bjp.indexOfChild(view);
        }
        return super.indexOfChild(view);
    }

    public void setViewActionDispatched(boolean z) {
        if (this.bjn != z) {
            this.bjn = z;
            if (z) {
                Jy();
            }
        }
    }

    public boolean Jx() {
        return this.bjn;
    }

    private void Jy() {
        if (this.bjn && getChildCount() > 0 && this.bjp != null) {
            LinkedList linkedList = new LinkedList();
            for (int i = 0; i < getChildCount(); i++) {
                View childAt = getChildAt(i);
                if (this.bjp.X(childAt)) {
                    linkedList.add(childAt);
                }
            }
            if (!linkedList.isEmpty()) {
                this.bjo = true;
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    View view = (View) it.next();
                    super.removeView(view);
                    this.bjp.onViewAdded(view);
                }
                this.bjo = false;
            }
        }
    }

    public void setViewActionDispatchListener(a aVar) {
        this.bjp = aVar;
        Jy();
    }
}
