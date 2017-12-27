package android.support.v7.widget;

import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
/* loaded from: classes2.dex */
public abstract class SnapHelper extends RecyclerView.OnFlingListener {
    RecyclerView SG;
    private final RecyclerView.OnScrollListener Si = new RecyclerView.OnScrollListener() { // from class: android.support.v7.widget.SnapHelper.1
        boolean Vt = false;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            if (i == 0 && this.Vt) {
                this.Vt = false;
                SnapHelper.this.hS();
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            if (i != 0 || i2 != 0) {
                this.Vt = true;
            }
        }
    };
    private Scroller Vs;

    public abstract int[] calculateDistanceToFinalSnap(RecyclerView.LayoutManager layoutManager, View view);

    public abstract View findSnapView(RecyclerView.LayoutManager layoutManager);

    public abstract int findTargetSnapPosition(RecyclerView.LayoutManager layoutManager, int i, int i2);

    @Override // android.support.v7.widget.RecyclerView.OnFlingListener
    public boolean onFling(int i, int i2) {
        RecyclerView.LayoutManager layoutManager = this.SG.getLayoutManager();
        if (layoutManager == null || this.SG.getAdapter() == null) {
            return false;
        }
        int minFlingVelocity = this.SG.getMinFlingVelocity();
        return (Math.abs(i2) > minFlingVelocity || Math.abs(i) > minFlingVelocity) && a(layoutManager, i, i2);
    }

    public void attachToRecyclerView(RecyclerView recyclerView) throws IllegalStateException {
        if (this.SG != recyclerView) {
            if (this.SG != null) {
                hR();
            }
            this.SG = recyclerView;
            if (this.SG != null) {
                hQ();
                this.Vs = new Scroller(this.SG.getContext(), new DecelerateInterpolator());
                hS();
            }
        }
    }

    private void hQ() throws IllegalStateException {
        if (this.SG.getOnFlingListener() != null) {
            throw new IllegalStateException("An instance of OnFlingListener already set.");
        }
        this.SG.addOnScrollListener(this.Si);
        this.SG.setOnFlingListener(this);
    }

    private void hR() {
        this.SG.removeOnScrollListener(this.Si);
        this.SG.setOnFlingListener(null);
    }

    public int[] calculateScrollDistance(int i, int i2) {
        this.Vs.fling(0, 0, i, i2, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return new int[]{this.Vs.getFinalX(), this.Vs.getFinalY()};
    }

    private boolean a(RecyclerView.LayoutManager layoutManager, int i, int i2) {
        LinearSmoothScroller c;
        int findTargetSnapPosition;
        if (!(layoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) || (c = c(layoutManager)) == null || (findTargetSnapPosition = findTargetSnapPosition(layoutManager, i, i2)) == -1) {
            return false;
        }
        c.setTargetPosition(findTargetSnapPosition);
        layoutManager.startSmoothScroll(c);
        return true;
    }

    void hS() {
        RecyclerView.LayoutManager layoutManager;
        View findSnapView;
        if (this.SG != null && (layoutManager = this.SG.getLayoutManager()) != null && (findSnapView = findSnapView(layoutManager)) != null) {
            int[] calculateDistanceToFinalSnap = calculateDistanceToFinalSnap(layoutManager, findSnapView);
            if (calculateDistanceToFinalSnap[0] != 0 || calculateDistanceToFinalSnap[1] != 0) {
                this.SG.smoothScrollBy(calculateDistanceToFinalSnap[0], calculateDistanceToFinalSnap[1]);
            }
        }
    }

    private LinearSmoothScroller c(RecyclerView.LayoutManager layoutManager) {
        if (layoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) {
            return new LinearSmoothScroller(this.SG.getContext()) { // from class: android.support.v7.widget.SnapHelper.2
                @Override // android.support.v7.widget.LinearSmoothScroller, android.support.v7.widget.RecyclerView.SmoothScroller
                protected void onTargetFound(View view, RecyclerView.State state, RecyclerView.SmoothScroller.Action action) {
                    int[] calculateDistanceToFinalSnap = SnapHelper.this.calculateDistanceToFinalSnap(SnapHelper.this.SG.getLayoutManager(), view);
                    int i = calculateDistanceToFinalSnap[0];
                    int i2 = calculateDistanceToFinalSnap[1];
                    int calculateTimeForDeceleration = calculateTimeForDeceleration(Math.max(Math.abs(i), Math.abs(i2)));
                    if (calculateTimeForDeceleration > 0) {
                        action.update(i, i2, calculateTimeForDeceleration, this.mDecelerateInterpolator);
                    }
                }

                @Override // android.support.v7.widget.LinearSmoothScroller
                protected float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
                    return 100.0f / displayMetrics.densityDpi;
                }
            };
        }
        return null;
    }
}
