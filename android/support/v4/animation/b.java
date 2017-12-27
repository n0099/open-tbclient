package android.support.v4.animation;

import android.view.View;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
class b implements android.support.v4.animation.a {
    @Override // android.support.v4.animation.a
    public ValueAnimatorCompat emptyValueAnimator() {
        return new a();
    }

    /* loaded from: classes2.dex */
    private static class a implements ValueAnimatorCompat {
        private long mStartTime;
        View mTarget;
        List<AnimatorListenerCompat> mListeners = new ArrayList();
        List<AnimatorUpdateListenerCompat> wd = new ArrayList();
        private long mDuration = 200;
        private float we = 0.0f;
        private boolean mStarted = false;
        private boolean vz = false;
        private Runnable wf = new Runnable() { // from class: android.support.v4.animation.b.a.1
            @Override // java.lang.Runnable
            public void run() {
                float time = (((float) (a.this.getTime() - a.this.mStartTime)) * 1.0f) / ((float) a.this.mDuration);
                if (time > 1.0f || a.this.mTarget.getParent() == null) {
                    time = 1.0f;
                }
                a.this.we = time;
                a.this.dc();
                if (a.this.we >= 1.0f) {
                    a.this.dd();
                } else {
                    a.this.mTarget.postDelayed(a.this.wf, 16L);
                }
            }
        };

        /* JADX INFO: Access modifiers changed from: private */
        public void dc() {
            for (int size = this.wd.size() - 1; size >= 0; size--) {
                this.wd.get(size).onAnimationUpdate(this);
            }
        }

        @Override // android.support.v4.animation.ValueAnimatorCompat
        public void setTarget(View view) {
            this.mTarget = view;
        }

        @Override // android.support.v4.animation.ValueAnimatorCompat
        public void addListener(AnimatorListenerCompat animatorListenerCompat) {
            this.mListeners.add(animatorListenerCompat);
        }

        @Override // android.support.v4.animation.ValueAnimatorCompat
        public void setDuration(long j) {
            if (!this.mStarted) {
                this.mDuration = j;
            }
        }

        @Override // android.support.v4.animation.ValueAnimatorCompat
        public void start() {
            if (!this.mStarted) {
                this.mStarted = true;
                dispatchStart();
                this.we = 0.0f;
                this.mStartTime = getTime();
                this.mTarget.postDelayed(this.wf, 16L);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public long getTime() {
            return this.mTarget.getDrawingTime();
        }

        private void dispatchStart() {
            for (int size = this.mListeners.size() - 1; size >= 0; size--) {
                this.mListeners.get(size).onAnimationStart(this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dd() {
            for (int size = this.mListeners.size() - 1; size >= 0; size--) {
                this.mListeners.get(size).onAnimationEnd(this);
            }
        }

        private void de() {
            for (int size = this.mListeners.size() - 1; size >= 0; size--) {
                this.mListeners.get(size).onAnimationCancel(this);
            }
        }

        @Override // android.support.v4.animation.ValueAnimatorCompat
        public void cancel() {
            if (!this.vz) {
                this.vz = true;
                if (this.mStarted) {
                    de();
                }
                dd();
            }
        }

        @Override // android.support.v4.animation.ValueAnimatorCompat
        public void addUpdateListener(AnimatorUpdateListenerCompat animatorUpdateListenerCompat) {
            this.wd.add(animatorUpdateListenerCompat);
        }

        @Override // android.support.v4.animation.ValueAnimatorCompat
        public float getAnimatedFraction() {
            return this.we;
        }
    }

    @Override // android.support.v4.animation.a
    public void clearInterpolator(View view) {
    }
}
