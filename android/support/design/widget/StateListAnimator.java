package android.support.design.widget;

import android.support.design.widget.ValueAnimatorCompat;
import android.util.StateSet;
import java.util.ArrayList;
/* loaded from: classes2.dex */
final class StateListAnimator {
    private final ArrayList<Tuple> mTuples = new ArrayList<>();
    private Tuple mLastMatch = null;
    ValueAnimatorCompat mRunningAnimator = null;
    private final ValueAnimatorCompat.AnimatorListener mAnimationListener = new ValueAnimatorCompat.AnimatorListenerAdapter() { // from class: android.support.design.widget.StateListAnimator.1
        @Override // android.support.design.widget.ValueAnimatorCompat.AnimatorListenerAdapter, android.support.design.widget.ValueAnimatorCompat.AnimatorListener
        public void onAnimationEnd(ValueAnimatorCompat valueAnimatorCompat) {
            if (StateListAnimator.this.mRunningAnimator == valueAnimatorCompat) {
                StateListAnimator.this.mRunningAnimator = null;
            }
        }
    };

    public void addState(int[] iArr, ValueAnimatorCompat valueAnimatorCompat) {
        Tuple tuple = new Tuple(iArr, valueAnimatorCompat);
        valueAnimatorCompat.addListener(this.mAnimationListener);
        this.mTuples.add(tuple);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setState(int[] iArr) {
        Tuple tuple;
        int size = this.mTuples.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                tuple = null;
                break;
            }
            tuple = this.mTuples.get(i);
            if (StateSet.stateSetMatches(tuple.mSpecs, iArr)) {
                break;
            }
            i++;
        }
        if (tuple != this.mLastMatch) {
            if (this.mLastMatch != null) {
                cancel();
            }
            this.mLastMatch = tuple;
            if (tuple != null) {
                start(tuple);
            }
        }
    }

    private void start(Tuple tuple) {
        this.mRunningAnimator = tuple.mAnimator;
        this.mRunningAnimator.start();
    }

    private void cancel() {
        if (this.mRunningAnimator != null) {
            this.mRunningAnimator.cancel();
            this.mRunningAnimator = null;
        }
    }

    public void jumpToCurrentState() {
        if (this.mRunningAnimator != null) {
            this.mRunningAnimator.end();
            this.mRunningAnimator = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class Tuple {
        final ValueAnimatorCompat mAnimator;
        final int[] mSpecs;

        Tuple(int[] iArr, ValueAnimatorCompat valueAnimatorCompat) {
            this.mSpecs = iArr;
            this.mAnimator = valueAnimatorCompat;
        }
    }
}
