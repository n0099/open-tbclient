package com.baidu.live.view.dispatch;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.view.PriorityVerticalLinearLayout;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes10.dex */
public class DispatchedPvlLayout extends PriorityVerticalLinearLayout {
    private boolean bQQ;
    private boolean bQR;
    private a bQS;

    public DispatchedPvlLayout(Context context) {
        super(context);
        this.bQQ = false;
        this.bQR = false;
    }

    public DispatchedPvlLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bQQ = false;
        this.bQR = false;
    }

    public DispatchedPvlLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bQQ = false;
        this.bQR = false;
    }

    @Override // com.baidu.live.view.PriorityVerticalLinearLayout, android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if ((!this.bQQ || !b.a(view, this.bQS)) && layoutParams != null) {
            super.addView(view, i, layoutParams);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (this.bQR || !this.bQQ || !b.b(view, this.bQS)) {
            super.removeView(view);
        }
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        super.removeAllViews();
        if (this.bQQ && this.bQS != null) {
            this.bQS.Wd();
        }
    }

    @Override // android.view.ViewGroup
    public int indexOfChild(View view) {
        if (!this.bQR && this.bQQ) {
            if (this.bQS == null || !this.bQS.ai(view)) {
                return super.indexOfChild(view);
            }
            return this.bQS.indexOfChild(view);
        }
        return super.indexOfChild(view);
    }

    public void setViewActionDispatched(boolean z) {
        if (this.bQQ != z) {
            this.bQQ = z;
            if (z) {
                Wc();
            }
        }
    }

    private void Wc() {
        if (this.bQQ && getChildCount() > 0 && this.bQS != null) {
            LinkedList linkedList = new LinkedList();
            for (int i = 0; i < getChildCount(); i++) {
                View childAt = getChildAt(i);
                if (this.bQS.ai(childAt)) {
                    linkedList.add(childAt);
                }
            }
            if (!linkedList.isEmpty()) {
                this.bQR = true;
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    View view = (View) it.next();
                    super.removeView(view);
                    this.bQS.aj(view);
                }
                this.bQR = false;
            }
        }
    }

    public void setViewActionDispatchListener(a aVar) {
        this.bQS = aVar;
        Wc();
    }
}
