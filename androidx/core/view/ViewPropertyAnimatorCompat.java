package androidx.core.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.os.Build;
import android.view.View;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public final class ViewPropertyAnimatorCompat {
    public static final int LISTENER_TAG_ID = 2113929216;
    public WeakReference<View> mView;
    public Runnable mStartAction = null;
    public Runnable mEndAction = null;
    public int mOldLayerType = -1;

    /* loaded from: classes.dex */
    public static class ViewPropertyAnimatorListenerApi14 implements ViewPropertyAnimatorListener {
        public boolean mAnimEndCalled;
        public ViewPropertyAnimatorCompat mVpa;

        public ViewPropertyAnimatorListenerApi14(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat) {
            this.mVpa = viewPropertyAnimatorCompat;
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationCancel(View view2) {
            ViewPropertyAnimatorListener viewPropertyAnimatorListener;
            Object tag = view2.getTag(ViewPropertyAnimatorCompat.LISTENER_TAG_ID);
            if (tag instanceof ViewPropertyAnimatorListener) {
                viewPropertyAnimatorListener = (ViewPropertyAnimatorListener) tag;
            } else {
                viewPropertyAnimatorListener = null;
            }
            if (viewPropertyAnimatorListener != null) {
                viewPropertyAnimatorListener.onAnimationCancel(view2);
            }
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationStart(View view2) {
            this.mAnimEndCalled = false;
            ViewPropertyAnimatorListener viewPropertyAnimatorListener = null;
            if (this.mVpa.mOldLayerType > -1) {
                view2.setLayerType(2, null);
            }
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = this.mVpa;
            Runnable runnable = viewPropertyAnimatorCompat.mStartAction;
            if (runnable != null) {
                viewPropertyAnimatorCompat.mStartAction = null;
                runnable.run();
            }
            Object tag = view2.getTag(ViewPropertyAnimatorCompat.LISTENER_TAG_ID);
            if (tag instanceof ViewPropertyAnimatorListener) {
                viewPropertyAnimatorListener = (ViewPropertyAnimatorListener) tag;
            }
            if (viewPropertyAnimatorListener != null) {
                viewPropertyAnimatorListener.onAnimationStart(view2);
            }
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListener
        @SuppressLint({"WrongConstant"})
        public void onAnimationEnd(View view2) {
            int i = this.mVpa.mOldLayerType;
            ViewPropertyAnimatorListener viewPropertyAnimatorListener = null;
            if (i > -1) {
                view2.setLayerType(i, null);
                this.mVpa.mOldLayerType = -1;
            }
            if (Build.VERSION.SDK_INT >= 16 || !this.mAnimEndCalled) {
                ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = this.mVpa;
                Runnable runnable = viewPropertyAnimatorCompat.mEndAction;
                if (runnable != null) {
                    viewPropertyAnimatorCompat.mEndAction = null;
                    runnable.run();
                }
                Object tag = view2.getTag(ViewPropertyAnimatorCompat.LISTENER_TAG_ID);
                if (tag instanceof ViewPropertyAnimatorListener) {
                    viewPropertyAnimatorListener = (ViewPropertyAnimatorListener) tag;
                }
                if (viewPropertyAnimatorListener != null) {
                    viewPropertyAnimatorListener.onAnimationEnd(view2);
                }
                this.mAnimEndCalled = true;
            }
        }
    }

    public ViewPropertyAnimatorCompat(View view2) {
        this.mView = new WeakReference<>(view2);
    }

    public ViewPropertyAnimatorCompat alpha(float f) {
        View view2 = this.mView.get();
        if (view2 != null) {
            view2.animate().alpha(f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat alphaBy(float f) {
        View view2 = this.mView.get();
        if (view2 != null) {
            view2.animate().alphaBy(f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat rotation(float f) {
        View view2 = this.mView.get();
        if (view2 != null) {
            view2.animate().rotation(f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat rotationBy(float f) {
        View view2 = this.mView.get();
        if (view2 != null) {
            view2.animate().rotationBy(f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat rotationX(float f) {
        View view2 = this.mView.get();
        if (view2 != null) {
            view2.animate().rotationX(f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat rotationXBy(float f) {
        View view2 = this.mView.get();
        if (view2 != null) {
            view2.animate().rotationXBy(f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat rotationY(float f) {
        View view2 = this.mView.get();
        if (view2 != null) {
            view2.animate().rotationY(f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat rotationYBy(float f) {
        View view2 = this.mView.get();
        if (view2 != null) {
            view2.animate().rotationYBy(f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat scaleX(float f) {
        View view2 = this.mView.get();
        if (view2 != null) {
            view2.animate().scaleX(f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat scaleXBy(float f) {
        View view2 = this.mView.get();
        if (view2 != null) {
            view2.animate().scaleXBy(f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat scaleY(float f) {
        View view2 = this.mView.get();
        if (view2 != null) {
            view2.animate().scaleY(f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat scaleYBy(float f) {
        View view2 = this.mView.get();
        if (view2 != null) {
            view2.animate().scaleYBy(f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat setDuration(long j) {
        View view2 = this.mView.get();
        if (view2 != null) {
            view2.animate().setDuration(j);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat setInterpolator(Interpolator interpolator) {
        View view2 = this.mView.get();
        if (view2 != null) {
            view2.animate().setInterpolator(interpolator);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat setListener(ViewPropertyAnimatorListener viewPropertyAnimatorListener) {
        View view2 = this.mView.get();
        if (view2 != null) {
            if (Build.VERSION.SDK_INT >= 16) {
                setListenerInternal(view2, viewPropertyAnimatorListener);
            } else {
                view2.setTag(LISTENER_TAG_ID, viewPropertyAnimatorListener);
                setListenerInternal(view2, new ViewPropertyAnimatorListenerApi14(this));
            }
        }
        return this;
    }

    public ViewPropertyAnimatorCompat setStartDelay(long j) {
        View view2 = this.mView.get();
        if (view2 != null) {
            view2.animate().setStartDelay(j);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat setUpdateListener(final ViewPropertyAnimatorUpdateListener viewPropertyAnimatorUpdateListener) {
        final View view2 = this.mView.get();
        if (view2 != null && Build.VERSION.SDK_INT >= 19) {
            ValueAnimator.AnimatorUpdateListener animatorUpdateListener = null;
            if (viewPropertyAnimatorUpdateListener != null) {
                animatorUpdateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: androidx.core.view.ViewPropertyAnimatorCompat.2
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        viewPropertyAnimatorUpdateListener.onAnimationUpdate(view2);
                    }
                };
            }
            view2.animate().setUpdateListener(animatorUpdateListener);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat translationX(float f) {
        View view2 = this.mView.get();
        if (view2 != null) {
            view2.animate().translationX(f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat translationXBy(float f) {
        View view2 = this.mView.get();
        if (view2 != null) {
            view2.animate().translationXBy(f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat translationY(float f) {
        View view2 = this.mView.get();
        if (view2 != null) {
            view2.animate().translationY(f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat translationYBy(float f) {
        View view2 = this.mView.get();
        if (view2 != null) {
            view2.animate().translationYBy(f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat translationZ(float f) {
        View view2 = this.mView.get();
        if (view2 != null && Build.VERSION.SDK_INT >= 21) {
            view2.animate().translationZ(f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat translationZBy(float f) {
        View view2 = this.mView.get();
        if (view2 != null && Build.VERSION.SDK_INT >= 21) {
            view2.animate().translationZBy(f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat withEndAction(Runnable runnable) {
        View view2 = this.mView.get();
        if (view2 != null) {
            if (Build.VERSION.SDK_INT >= 16) {
                view2.animate().withEndAction(runnable);
            } else {
                setListenerInternal(view2, new ViewPropertyAnimatorListenerApi14(this));
                this.mEndAction = runnable;
            }
        }
        return this;
    }

    public ViewPropertyAnimatorCompat withStartAction(Runnable runnable) {
        View view2 = this.mView.get();
        if (view2 != null) {
            if (Build.VERSION.SDK_INT >= 16) {
                view2.animate().withStartAction(runnable);
            } else {
                setListenerInternal(view2, new ViewPropertyAnimatorListenerApi14(this));
                this.mStartAction = runnable;
            }
        }
        return this;
    }

    public ViewPropertyAnimatorCompat x(float f) {
        View view2 = this.mView.get();
        if (view2 != null) {
            view2.animate().x(f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat xBy(float f) {
        View view2 = this.mView.get();
        if (view2 != null) {
            view2.animate().xBy(f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat y(float f) {
        View view2 = this.mView.get();
        if (view2 != null) {
            view2.animate().y(f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat yBy(float f) {
        View view2 = this.mView.get();
        if (view2 != null) {
            view2.animate().yBy(f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat z(float f) {
        View view2 = this.mView.get();
        if (view2 != null && Build.VERSION.SDK_INT >= 21) {
            view2.animate().z(f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat zBy(float f) {
        View view2 = this.mView.get();
        if (view2 != null && Build.VERSION.SDK_INT >= 21) {
            view2.animate().zBy(f);
        }
        return this;
    }

    private void setListenerInternal(final View view2, final ViewPropertyAnimatorListener viewPropertyAnimatorListener) {
        if (viewPropertyAnimatorListener != null) {
            view2.animate().setListener(new AnimatorListenerAdapter() { // from class: androidx.core.view.ViewPropertyAnimatorCompat.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    viewPropertyAnimatorListener.onAnimationCancel(view2);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    viewPropertyAnimatorListener.onAnimationEnd(view2);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    viewPropertyAnimatorListener.onAnimationStart(view2);
                }
            });
        } else {
            view2.animate().setListener(null);
        }
    }

    public void cancel() {
        View view2 = this.mView.get();
        if (view2 != null) {
            view2.animate().cancel();
        }
    }

    public long getDuration() {
        View view2 = this.mView.get();
        if (view2 != null) {
            return view2.animate().getDuration();
        }
        return 0L;
    }

    public Interpolator getInterpolator() {
        View view2 = this.mView.get();
        if (view2 != null && Build.VERSION.SDK_INT >= 18) {
            return (Interpolator) view2.animate().getInterpolator();
        }
        return null;
    }

    public long getStartDelay() {
        View view2 = this.mView.get();
        if (view2 != null) {
            return view2.animate().getStartDelay();
        }
        return 0L;
    }

    public void start() {
        View view2 = this.mView.get();
        if (view2 != null) {
            view2.animate().start();
        }
    }

    @SuppressLint({"WrongConstant"})
    public ViewPropertyAnimatorCompat withLayer() {
        View view2 = this.mView.get();
        if (view2 != null) {
            if (Build.VERSION.SDK_INT >= 16) {
                view2.animate().withLayer();
            } else {
                this.mOldLayerType = view2.getLayerType();
                setListenerInternal(view2, new ViewPropertyAnimatorListenerApi14(this));
            }
        }
        return this;
    }
}
