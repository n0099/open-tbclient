package com.baidu.live.view.dispatch;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes11.dex */
public class DispatchedRelativeLayout extends RelativeLayout {
    private boolean bVC;
    private boolean bVD;
    private a bVE;

    public DispatchedRelativeLayout(Context context) {
        super(context);
        this.bVC = false;
        this.bVD = false;
    }

    public DispatchedRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bVC = false;
        this.bVD = false;
    }

    public DispatchedRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bVC = false;
        this.bVD = false;
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (!this.bVC || !b.a(view, this.bVE)) {
            super.addView(view, i, layoutParams);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (this.bVD || !this.bVC || !b.b(view, this.bVE)) {
            super.removeView(view);
        }
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        super.removeAllViews();
        if (!this.bVD && this.bVC && this.bVE != null) {
            this.bVE.ZV();
        }
    }

    @Override // android.view.ViewGroup
    public int indexOfChild(View view) {
        if (!this.bVD && this.bVC) {
            if (this.bVE == null || !this.bVE.ai(view)) {
                return super.indexOfChild(view);
            }
            return this.bVE.indexOfChild(view);
        }
        return super.indexOfChild(view);
    }

    public void setViewActionDispatched(boolean z) {
        if (this.bVC != z) {
            this.bVC = z;
            if (z) {
                ZU();
            }
        }
    }

    private void ZU() {
        if (this.bVC && getChildCount() > 0 && this.bVE != null) {
            LinkedList linkedList = new LinkedList();
            for (int i = 0; i < getChildCount(); i++) {
                View childAt = getChildAt(i);
                if (this.bVE.ai(childAt)) {
                    linkedList.add(childAt);
                }
            }
            this.bVD = true;
            if (!linkedList.isEmpty()) {
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    View view = (View) it.next();
                    super.removeView(view);
                    this.bVE.aj(view);
                }
            }
            this.bVD = false;
        }
    }

    public void setViewActionDispatchListener(a aVar) {
        this.bVE = aVar;
        ZU();
    }
}
