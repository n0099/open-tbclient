package android.support.v7.widget;

import android.support.v7.widget.RecyclerView;
import android.view.View;
/* loaded from: classes2.dex */
class m {
    int Pi;
    int Pj;
    int Pk;
    int Pl;
    boolean Po;
    boolean Pp;
    boolean Ph = true;
    int Pm = 0;
    int Pn = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(RecyclerView.State state) {
        return this.Pj >= 0 && this.Pj < state.getItemCount();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View a(RecyclerView.Recycler recycler) {
        View viewForPosition = recycler.getViewForPosition(this.Pj);
        this.Pj += this.Pk;
        return viewForPosition;
    }

    public String toString() {
        return "LayoutState{mAvailable=" + this.Pi + ", mCurrentPosition=" + this.Pj + ", mItemDirection=" + this.Pk + ", mLayoutDirection=" + this.Pl + ", mStartLine=" + this.Pm + ", mEndLine=" + this.Pn + '}';
    }
}
