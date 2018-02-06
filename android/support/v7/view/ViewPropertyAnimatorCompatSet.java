package android.support.v7.view;

import android.support.annotation.RestrictTo;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;
import android.view.View;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Iterator;
@RestrictTo
/* loaded from: classes2.dex */
public class ViewPropertyAnimatorCompatSet {
    ViewPropertyAnimatorListener Hl;
    private Interpolator mInterpolator;
    private boolean mIsStarted;
    private long mDuration = -1;
    private final ViewPropertyAnimatorListenerAdapter Hm = new ViewPropertyAnimatorListenerAdapter() { // from class: android.support.v7.view.ViewPropertyAnimatorCompatSet.1
        private boolean Hn = false;
        private int Ho = 0;

        @Override // android.support.v4.view.ViewPropertyAnimatorListenerAdapter, android.support.v4.view.ViewPropertyAnimatorListener
        public void onAnimationStart(View view) {
            if (!this.Hn) {
                this.Hn = true;
                if (ViewPropertyAnimatorCompatSet.this.Hl != null) {
                    ViewPropertyAnimatorCompatSet.this.Hl.onAnimationStart(null);
                }
            }
        }

        void onEnd() {
            this.Ho = 0;
            this.Hn = false;
            ViewPropertyAnimatorCompatSet.this.eL();
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorListenerAdapter, android.support.v4.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            int i = this.Ho + 1;
            this.Ho = i;
            if (i == ViewPropertyAnimatorCompatSet.this.mAnimators.size()) {
                if (ViewPropertyAnimatorCompatSet.this.Hl != null) {
                    ViewPropertyAnimatorCompatSet.this.Hl.onAnimationEnd(null);
                }
                onEnd();
            }
        }
    };
    final ArrayList<ViewPropertyAnimatorCompat> mAnimators = new ArrayList<>();

    public ViewPropertyAnimatorCompatSet play(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat) {
        if (!this.mIsStarted) {
            this.mAnimators.add(viewPropertyAnimatorCompat);
        }
        return this;
    }

    public ViewPropertyAnimatorCompatSet playSequentially(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2) {
        this.mAnimators.add(viewPropertyAnimatorCompat);
        viewPropertyAnimatorCompat2.setStartDelay(viewPropertyAnimatorCompat.getDuration());
        this.mAnimators.add(viewPropertyAnimatorCompat2);
        return this;
    }

    public void start() {
        if (!this.mIsStarted) {
            Iterator<ViewPropertyAnimatorCompat> it = this.mAnimators.iterator();
            while (it.hasNext()) {
                ViewPropertyAnimatorCompat next = it.next();
                if (this.mDuration >= 0) {
                    next.setDuration(this.mDuration);
                }
                if (this.mInterpolator != null) {
                    next.setInterpolator(this.mInterpolator);
                }
                if (this.Hl != null) {
                    next.setListener(this.Hm);
                }
                next.start();
            }
            this.mIsStarted = true;
        }
    }

    void eL() {
        this.mIsStarted = false;
    }

    public void cancel() {
        if (this.mIsStarted) {
            Iterator<ViewPropertyAnimatorCompat> it = this.mAnimators.iterator();
            while (it.hasNext()) {
                it.next().cancel();
            }
            this.mIsStarted = false;
        }
    }

    public ViewPropertyAnimatorCompatSet setDuration(long j) {
        if (!this.mIsStarted) {
            this.mDuration = j;
        }
        return this;
    }

    public ViewPropertyAnimatorCompatSet setInterpolator(Interpolator interpolator) {
        if (!this.mIsStarted) {
            this.mInterpolator = interpolator;
        }
        return this;
    }

    public ViewPropertyAnimatorCompatSet setListener(ViewPropertyAnimatorListener viewPropertyAnimatorListener) {
        if (!this.mIsStarted) {
            this.Hl = viewPropertyAnimatorListener;
        }
        return this;
    }
}
