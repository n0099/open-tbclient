package android.support.v7.widget;

import android.support.v7.widget.RecyclerView;
import android.view.View;
/* loaded from: classes2.dex */
class m {
    int Pn;
    int Po;
    int Pp;
    int Pq;
    boolean Pt;
    boolean Pu;
    boolean Pm = true;
    int Pr = 0;
    int Ps = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(RecyclerView.State state) {
        return this.Po >= 0 && this.Po < state.getItemCount();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View a(RecyclerView.Recycler recycler) {
        View viewForPosition = recycler.getViewForPosition(this.Po);
        this.Po += this.Pp;
        return viewForPosition;
    }

    public String toString() {
        return "LayoutState{mAvailable=" + this.Pn + ", mCurrentPosition=" + this.Po + ", mItemDirection=" + this.Pp + ", mLayoutDirection=" + this.Pq + ", mStartLine=" + this.Pr + ", mEndLine=" + this.Ps + '}';
    }
}
