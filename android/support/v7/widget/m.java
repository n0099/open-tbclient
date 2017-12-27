package android.support.v7.widget;

import android.support.v7.widget.RecyclerView;
import android.view.View;
/* loaded from: classes2.dex */
class m {
    int Po;
    int Pp;
    int Pq;
    int Pr;
    boolean Pu;
    boolean Pv;
    boolean Pn = true;
    int Ps = 0;
    int Pt = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(RecyclerView.State state) {
        return this.Pp >= 0 && this.Pp < state.getItemCount();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View a(RecyclerView.Recycler recycler) {
        View viewForPosition = recycler.getViewForPosition(this.Pp);
        this.Pp += this.Pq;
        return viewForPosition;
    }

    public String toString() {
        return "LayoutState{mAvailable=" + this.Po + ", mCurrentPosition=" + this.Pp + ", mItemDirection=" + this.Pq + ", mLayoutDirection=" + this.Pr + ", mStartLine=" + this.Ps + ", mEndLine=" + this.Pt + '}';
    }
}
