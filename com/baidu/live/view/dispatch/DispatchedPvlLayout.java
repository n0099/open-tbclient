package com.baidu.live.view.dispatch;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.view.PriorityVerticalLinearLayout;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes4.dex */
public class DispatchedPvlLayout extends PriorityVerticalLinearLayout {
    private boolean bLn;
    private boolean bLo;
    private a bLp;

    public DispatchedPvlLayout(Context context) {
        super(context);
        this.bLn = false;
        this.bLo = false;
    }

    public DispatchedPvlLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bLn = false;
        this.bLo = false;
    }

    public DispatchedPvlLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bLn = false;
        this.bLo = false;
    }

    @Override // com.baidu.live.view.PriorityVerticalLinearLayout, android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if ((!this.bLn || !b.a(view, this.bLp)) && layoutParams != null) {
            super.addView(view, i, layoutParams);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (this.bLo || !this.bLn || !b.b(view, this.bLp)) {
            super.removeView(view);
        }
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        super.removeAllViews();
        if (this.bLn && this.bLp != null) {
            this.bLp.Wi();
        }
    }

    @Override // android.view.ViewGroup
    public int indexOfChild(View view) {
        if (!this.bLo && this.bLn) {
            if (this.bLp == null || !this.bLp.ai(view)) {
                return super.indexOfChild(view);
            }
            return this.bLp.indexOfChild(view);
        }
        return super.indexOfChild(view);
    }

    public void setViewActionDispatched(boolean z) {
        if (this.bLn != z) {
            this.bLn = z;
            if (z) {
                Wh();
            }
        }
    }

    private void Wh() {
        if (this.bLn && getChildCount() > 0 && this.bLp != null) {
            LinkedList linkedList = new LinkedList();
            for (int i = 0; i < getChildCount(); i++) {
                View childAt = getChildAt(i);
                if (this.bLp.ai(childAt)) {
                    linkedList.add(childAt);
                }
            }
            if (!linkedList.isEmpty()) {
                this.bLo = true;
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    View view = (View) it.next();
                    super.removeView(view);
                    this.bLp.onViewAdded(view);
                }
                this.bLo = false;
            }
        }
    }

    public void setViewActionDispatchListener(a aVar) {
        this.bLp = aVar;
        Wh();
    }
}
