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
    ViewPropertyAnimatorListener Hm;
    private Interpolator mInterpolator;
    private boolean mIsStarted;
    private long mDuration = -1;
    private final ViewPropertyAnimatorListenerAdapter Hn = new ViewPropertyAnimatorListenerAdapter() { // from class: android.support.v7.view.ViewPropertyAnimatorCompatSet.1
        private boolean Ho = false;
        private int Hp = 0;

        @Override // android.support.v4.view.ViewPropertyAnimatorListenerAdapter, android.support.v4.view.ViewPropertyAnimatorListener
        public void onAnimationStart(View view) {
            if (!this.Ho) {
                this.Ho = true;
                if (ViewPropertyAnimatorCompatSet.this.Hm != null) {
                    ViewPropertyAnimatorCompatSet.this.Hm.onAnimationStart(null);
                }
            }
        }

        void onEnd() {
            this.Hp = 0;
            this.Ho = false;
            ViewPropertyAnimatorCompatSet.this.eL();
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorListenerAdapter, android.support.v4.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            int i = this.Hp + 1;
            this.Hp = i;
            if (i == ViewPropertyAnimatorCompatSet.this.mAnimators.size()) {
                if (ViewPropertyAnimatorCompatSet.this.Hm != null) {
                    ViewPropertyAnimatorCompatSet.this.Hm.onAnimationEnd(null);
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
                if (this.Hm != null) {
                    next.setListener(this.Hn);
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
            this.Hm = viewPropertyAnimatorListener;
        }
        return this;
    }
}
