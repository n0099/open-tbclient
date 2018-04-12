package android.support.v4.view;

import android.os.Build;
import android.view.View;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
/* loaded from: classes2.dex */
public final class ViewPropertyAnimatorCompat {
    static final ViewPropertyAnimatorCompatImpl IMPL;
    static final int LISTENER_TAG_ID = 2113929216;
    private static final String TAG = "ViewAnimatorCompat";
    private WeakReference<View> mView;
    Runnable mStartAction = null;
    Runnable mEndAction = null;
    int mOldLayerType = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public interface ViewPropertyAnimatorCompatImpl {
        void alpha(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view2, float f);

        void alphaBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view2, float f);

        void cancel(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view2);

        long getDuration(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view2);

        Interpolator getInterpolator(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view2);

        long getStartDelay(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view2);

        void rotation(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view2, float f);

        void rotationBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view2, float f);

        void rotationX(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view2, float f);

        void rotationXBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view2, float f);

        void rotationY(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view2, float f);

        void rotationYBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view2, float f);

        void scaleX(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view2, float f);

        void scaleXBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view2, float f);

        void scaleY(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view2, float f);

        void scaleYBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view2, float f);

        void setDuration(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view2, long j);

        void setInterpolator(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view2, Interpolator interpolator);

        void setListener(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view2, ViewPropertyAnimatorListener viewPropertyAnimatorListener);

        void setStartDelay(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view2, long j);

        void setUpdateListener(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view2, ViewPropertyAnimatorUpdateListener viewPropertyAnimatorUpdateListener);

        void start(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view2);

        void translationX(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view2, float f);

        void translationXBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view2, float f);

        void translationY(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view2, float f);

        void translationYBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view2, float f);

        void translationZ(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view2, float f);

        void translationZBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view2, float f);

        void withEndAction(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view2, Runnable runnable);

        void withLayer(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view2);

        void withStartAction(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view2, Runnable runnable);

        void x(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view2, float f);

        void xBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view2, float f);

        void y(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view2, float f);

        void yBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view2, float f);

        void z(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view2, float f);

        void zBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view2, float f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewPropertyAnimatorCompat(View view2) {
        this.mView = new WeakReference<>(view2);
    }

    /* loaded from: classes2.dex */
    static class BaseViewPropertyAnimatorCompatImpl implements ViewPropertyAnimatorCompatImpl {
        WeakHashMap<View, Runnable> mStarterMap = null;

        BaseViewPropertyAnimatorCompatImpl() {
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void setDuration(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view2, long j) {
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void alpha(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view2, float f) {
            postStartMessage(viewPropertyAnimatorCompat, view2);
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void translationX(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view2, float f) {
            postStartMessage(viewPropertyAnimatorCompat, view2);
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void translationY(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view2, float f) {
            postStartMessage(viewPropertyAnimatorCompat, view2);
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void withEndAction(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view2, Runnable runnable) {
            viewPropertyAnimatorCompat.mEndAction = runnable;
            postStartMessage(viewPropertyAnimatorCompat, view2);
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public long getDuration(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view2) {
            return 0L;
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void setInterpolator(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view2, Interpolator interpolator) {
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public Interpolator getInterpolator(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view2) {
            return null;
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void setStartDelay(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view2, long j) {
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public long getStartDelay(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view2) {
            return 0L;
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void alphaBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view2, float f) {
            postStartMessage(viewPropertyAnimatorCompat, view2);
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void rotation(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view2, float f) {
            postStartMessage(viewPropertyAnimatorCompat, view2);
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void rotationBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view2, float f) {
            postStartMessage(viewPropertyAnimatorCompat, view2);
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void rotationX(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view2, float f) {
            postStartMessage(viewPropertyAnimatorCompat, view2);
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void rotationXBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view2, float f) {
            postStartMessage(viewPropertyAnimatorCompat, view2);
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void rotationY(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view2, float f) {
            postStartMessage(viewPropertyAnimatorCompat, view2);
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void rotationYBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view2, float f) {
            postStartMessage(viewPropertyAnimatorCompat, view2);
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void scaleX(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view2, float f) {
            postStartMessage(viewPropertyAnimatorCompat, view2);
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void scaleXBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view2, float f) {
            postStartMessage(viewPropertyAnimatorCompat, view2);
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void scaleY(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view2, float f) {
            postStartMessage(viewPropertyAnimatorCompat, view2);
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void scaleYBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view2, float f) {
            postStartMessage(viewPropertyAnimatorCompat, view2);
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void cancel(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view2) {
            postStartMessage(viewPropertyAnimatorCompat, view2);
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void x(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view2, float f) {
            postStartMessage(viewPropertyAnimatorCompat, view2);
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void xBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view2, float f) {
            postStartMessage(viewPropertyAnimatorCompat, view2);
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void y(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view2, float f) {
            postStartMessage(viewPropertyAnimatorCompat, view2);
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void yBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view2, float f) {
            postStartMessage(viewPropertyAnimatorCompat, view2);
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void z(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view2, float f) {
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void zBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view2, float f) {
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void translationXBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view2, float f) {
            postStartMessage(viewPropertyAnimatorCompat, view2);
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void translationYBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view2, float f) {
            postStartMessage(viewPropertyAnimatorCompat, view2);
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void translationZ(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view2, float f) {
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void translationZBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view2, float f) {
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void start(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view2) {
            removeStartMessage(view2);
            startAnimation(viewPropertyAnimatorCompat, view2);
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void withLayer(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view2) {
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void withStartAction(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view2, Runnable runnable) {
            viewPropertyAnimatorCompat.mStartAction = runnable;
            postStartMessage(viewPropertyAnimatorCompat, view2);
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void setListener(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view2, ViewPropertyAnimatorListener viewPropertyAnimatorListener) {
            view2.setTag(ViewPropertyAnimatorCompat.LISTENER_TAG_ID, viewPropertyAnimatorListener);
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void setUpdateListener(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view2, ViewPropertyAnimatorUpdateListener viewPropertyAnimatorUpdateListener) {
        }

        void startAnimation(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view2) {
            Object tag = view2.getTag(ViewPropertyAnimatorCompat.LISTENER_TAG_ID);
            ViewPropertyAnimatorListener viewPropertyAnimatorListener = tag instanceof ViewPropertyAnimatorListener ? (ViewPropertyAnimatorListener) tag : null;
            Runnable runnable = viewPropertyAnimatorCompat.mStartAction;
            Runnable runnable2 = viewPropertyAnimatorCompat.mEndAction;
            viewPropertyAnimatorCompat.mStartAction = null;
            viewPropertyAnimatorCompat.mEndAction = null;
            if (runnable != null) {
                runnable.run();
            }
            if (viewPropertyAnimatorListener != null) {
                viewPropertyAnimatorListener.onAnimationStart(view2);
                viewPropertyAnimatorListener.onAnimationEnd(view2);
            }
            if (runnable2 != null) {
                runnable2.run();
            }
            if (this.mStarterMap != null) {
                this.mStarterMap.remove(view2);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes2.dex */
        public class Starter implements Runnable {
            WeakReference<View> mViewRef;
            ViewPropertyAnimatorCompat mVpa;

            Starter(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view2) {
                this.mViewRef = new WeakReference<>(view2);
                this.mVpa = viewPropertyAnimatorCompat;
            }

            @Override // java.lang.Runnable
            public void run() {
                View view2 = this.mViewRef.get();
                if (view2 != null) {
                    BaseViewPropertyAnimatorCompatImpl.this.startAnimation(this.mVpa, view2);
                }
            }
        }

        private void removeStartMessage(View view2) {
            Runnable runnable;
            if (this.mStarterMap != null && (runnable = this.mStarterMap.get(view2)) != null) {
                view2.removeCallbacks(runnable);
            }
        }

        private void postStartMessage(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view2) {
            Runnable runnable = null;
            if (this.mStarterMap != null) {
                runnable = this.mStarterMap.get(view2);
            }
            if (runnable == null) {
                runnable = new Starter(viewPropertyAnimatorCompat, view2);
                if (this.mStarterMap == null) {
                    this.mStarterMap = new WeakHashMap<>();
                }
                this.mStarterMap.put(view2, runnable);
            }
            view2.removeCallbacks(runnable);
            view2.post(runnable);
        }
    }

    /* loaded from: classes2.dex */
    static class ICSViewPropertyAnimatorCompatImpl extends BaseViewPropertyAnimatorCompatImpl {
        WeakHashMap<View, Integer> mLayerMap = null;

        ICSViewPropertyAnimatorCompatImpl() {
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.BaseViewPropertyAnimatorCompatImpl, android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void setDuration(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view2, long j) {
            ViewPropertyAnimatorCompatICS.setDuration(view2, j);
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.BaseViewPropertyAnimatorCompatImpl, android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void alpha(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view2, float f) {
            ViewPropertyAnimatorCompatICS.alpha(view2, f);
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.BaseViewPropertyAnimatorCompatImpl, android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void translationX(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view2, float f) {
            ViewPropertyAnimatorCompatICS.translationX(view2, f);
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.BaseViewPropertyAnimatorCompatImpl, android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void translationY(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view2, float f) {
            ViewPropertyAnimatorCompatICS.translationY(view2, f);
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.BaseViewPropertyAnimatorCompatImpl, android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public long getDuration(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view2) {
            return ViewPropertyAnimatorCompatICS.getDuration(view2);
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.BaseViewPropertyAnimatorCompatImpl, android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void setInterpolator(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view2, Interpolator interpolator) {
            ViewPropertyAnimatorCompatICS.setInterpolator(view2, interpolator);
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.BaseViewPropertyAnimatorCompatImpl, android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void setStartDelay(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view2, long j) {
            ViewPropertyAnimatorCompatICS.setStartDelay(view2, j);
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.BaseViewPropertyAnimatorCompatImpl, android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public long getStartDelay(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view2) {
            return ViewPropertyAnimatorCompatICS.getStartDelay(view2);
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.BaseViewPropertyAnimatorCompatImpl, android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void alphaBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view2, float f) {
            ViewPropertyAnimatorCompatICS.alphaBy(view2, f);
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.BaseViewPropertyAnimatorCompatImpl, android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void rotation(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view2, float f) {
            ViewPropertyAnimatorCompatICS.rotation(view2, f);
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.BaseViewPropertyAnimatorCompatImpl, android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void rotationBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view2, float f) {
            ViewPropertyAnimatorCompatICS.rotationBy(view2, f);
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.BaseViewPropertyAnimatorCompatImpl, android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void rotationX(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view2, float f) {
            ViewPropertyAnimatorCompatICS.rotationX(view2, f);
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.BaseViewPropertyAnimatorCompatImpl, android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void rotationXBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view2, float f) {
            ViewPropertyAnimatorCompatICS.rotationXBy(view2, f);
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.BaseViewPropertyAnimatorCompatImpl, android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void rotationY(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view2, float f) {
            ViewPropertyAnimatorCompatICS.rotationY(view2, f);
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.BaseViewPropertyAnimatorCompatImpl, android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void rotationYBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view2, float f) {
            ViewPropertyAnimatorCompatICS.rotationYBy(view2, f);
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.BaseViewPropertyAnimatorCompatImpl, android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void scaleX(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view2, float f) {
            ViewPropertyAnimatorCompatICS.scaleX(view2, f);
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.BaseViewPropertyAnimatorCompatImpl, android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void scaleXBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view2, float f) {
            ViewPropertyAnimatorCompatICS.scaleXBy(view2, f);
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.BaseViewPropertyAnimatorCompatImpl, android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void scaleY(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view2, float f) {
            ViewPropertyAnimatorCompatICS.scaleY(view2, f);
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.BaseViewPropertyAnimatorCompatImpl, android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void scaleYBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view2, float f) {
            ViewPropertyAnimatorCompatICS.scaleYBy(view2, f);
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.BaseViewPropertyAnimatorCompatImpl, android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void cancel(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view2) {
            ViewPropertyAnimatorCompatICS.cancel(view2);
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.BaseViewPropertyAnimatorCompatImpl, android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void x(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view2, float f) {
            ViewPropertyAnimatorCompatICS.x(view2, f);
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.BaseViewPropertyAnimatorCompatImpl, android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void xBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view2, float f) {
            ViewPropertyAnimatorCompatICS.xBy(view2, f);
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.BaseViewPropertyAnimatorCompatImpl, android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void y(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view2, float f) {
            ViewPropertyAnimatorCompatICS.y(view2, f);
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.BaseViewPropertyAnimatorCompatImpl, android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void yBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view2, float f) {
            ViewPropertyAnimatorCompatICS.yBy(view2, f);
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.BaseViewPropertyAnimatorCompatImpl, android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void translationXBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view2, float f) {
            ViewPropertyAnimatorCompatICS.translationXBy(view2, f);
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.BaseViewPropertyAnimatorCompatImpl, android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void translationYBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view2, float f) {
            ViewPropertyAnimatorCompatICS.translationYBy(view2, f);
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.BaseViewPropertyAnimatorCompatImpl, android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void start(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view2) {
            ViewPropertyAnimatorCompatICS.start(view2);
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.BaseViewPropertyAnimatorCompatImpl, android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void setListener(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view2, ViewPropertyAnimatorListener viewPropertyAnimatorListener) {
            view2.setTag(ViewPropertyAnimatorCompat.LISTENER_TAG_ID, viewPropertyAnimatorListener);
            ViewPropertyAnimatorCompatICS.setListener(view2, new MyVpaListener(viewPropertyAnimatorCompat));
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.BaseViewPropertyAnimatorCompatImpl, android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void withEndAction(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view2, Runnable runnable) {
            ViewPropertyAnimatorCompatICS.setListener(view2, new MyVpaListener(viewPropertyAnimatorCompat));
            viewPropertyAnimatorCompat.mEndAction = runnable;
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.BaseViewPropertyAnimatorCompatImpl, android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void withStartAction(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view2, Runnable runnable) {
            ViewPropertyAnimatorCompatICS.setListener(view2, new MyVpaListener(viewPropertyAnimatorCompat));
            viewPropertyAnimatorCompat.mStartAction = runnable;
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.BaseViewPropertyAnimatorCompatImpl, android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void withLayer(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view2) {
            viewPropertyAnimatorCompat.mOldLayerType = ViewCompat.getLayerType(view2);
            ViewPropertyAnimatorCompatICS.setListener(view2, new MyVpaListener(viewPropertyAnimatorCompat));
        }

        /* loaded from: classes2.dex */
        static class MyVpaListener implements ViewPropertyAnimatorListener {
            boolean mAnimEndCalled;
            ViewPropertyAnimatorCompat mVpa;

            MyVpaListener(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat) {
                this.mVpa = viewPropertyAnimatorCompat;
            }

            @Override // android.support.v4.view.ViewPropertyAnimatorListener
            public void onAnimationStart(View view2) {
                this.mAnimEndCalled = false;
                if (this.mVpa.mOldLayerType >= 0) {
                    ViewCompat.setLayerType(view2, 2, null);
                }
                if (this.mVpa.mStartAction != null) {
                    Runnable runnable = this.mVpa.mStartAction;
                    this.mVpa.mStartAction = null;
                    runnable.run();
                }
                Object tag = view2.getTag(ViewPropertyAnimatorCompat.LISTENER_TAG_ID);
                ViewPropertyAnimatorListener viewPropertyAnimatorListener = tag instanceof ViewPropertyAnimatorListener ? (ViewPropertyAnimatorListener) tag : null;
                if (viewPropertyAnimatorListener != null) {
                    viewPropertyAnimatorListener.onAnimationStart(view2);
                }
            }

            @Override // android.support.v4.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(View view2) {
                if (this.mVpa.mOldLayerType >= 0) {
                    ViewCompat.setLayerType(view2, this.mVpa.mOldLayerType, null);
                    this.mVpa.mOldLayerType = -1;
                }
                if (Build.VERSION.SDK_INT >= 16 || !this.mAnimEndCalled) {
                    if (this.mVpa.mEndAction != null) {
                        Runnable runnable = this.mVpa.mEndAction;
                        this.mVpa.mEndAction = null;
                        runnable.run();
                    }
                    Object tag = view2.getTag(ViewPropertyAnimatorCompat.LISTENER_TAG_ID);
                    ViewPropertyAnimatorListener viewPropertyAnimatorListener = tag instanceof ViewPropertyAnimatorListener ? (ViewPropertyAnimatorListener) tag : null;
                    if (viewPropertyAnimatorListener != null) {
                        viewPropertyAnimatorListener.onAnimationEnd(view2);
                    }
                    this.mAnimEndCalled = true;
                }
            }

            @Override // android.support.v4.view.ViewPropertyAnimatorListener
            public void onAnimationCancel(View view2) {
                ViewPropertyAnimatorListener viewPropertyAnimatorListener;
                Object tag = view2.getTag(ViewPropertyAnimatorCompat.LISTENER_TAG_ID);
                if (!(tag instanceof ViewPropertyAnimatorListener)) {
                    viewPropertyAnimatorListener = null;
                } else {
                    viewPropertyAnimatorListener = (ViewPropertyAnimatorListener) tag;
                }
                if (viewPropertyAnimatorListener != null) {
                    viewPropertyAnimatorListener.onAnimationCancel(view2);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    static class JBViewPropertyAnimatorCompatImpl extends ICSViewPropertyAnimatorCompatImpl {
        JBViewPropertyAnimatorCompatImpl() {
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.ICSViewPropertyAnimatorCompatImpl, android.support.v4.view.ViewPropertyAnimatorCompat.BaseViewPropertyAnimatorCompatImpl, android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void setListener(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view2, ViewPropertyAnimatorListener viewPropertyAnimatorListener) {
            ViewPropertyAnimatorCompatJB.setListener(view2, viewPropertyAnimatorListener);
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.ICSViewPropertyAnimatorCompatImpl, android.support.v4.view.ViewPropertyAnimatorCompat.BaseViewPropertyAnimatorCompatImpl, android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void withStartAction(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view2, Runnable runnable) {
            ViewPropertyAnimatorCompatJB.withStartAction(view2, runnable);
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.ICSViewPropertyAnimatorCompatImpl, android.support.v4.view.ViewPropertyAnimatorCompat.BaseViewPropertyAnimatorCompatImpl, android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void withEndAction(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view2, Runnable runnable) {
            ViewPropertyAnimatorCompatJB.withEndAction(view2, runnable);
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.ICSViewPropertyAnimatorCompatImpl, android.support.v4.view.ViewPropertyAnimatorCompat.BaseViewPropertyAnimatorCompatImpl, android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void withLayer(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view2) {
            ViewPropertyAnimatorCompatJB.withLayer(view2);
        }
    }

    /* loaded from: classes2.dex */
    static class JBMr2ViewPropertyAnimatorCompatImpl extends JBViewPropertyAnimatorCompatImpl {
        JBMr2ViewPropertyAnimatorCompatImpl() {
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.BaseViewPropertyAnimatorCompatImpl, android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public Interpolator getInterpolator(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view2) {
            return ViewPropertyAnimatorCompatJellybeanMr2.getInterpolator(view2);
        }
    }

    /* loaded from: classes2.dex */
    static class KitKatViewPropertyAnimatorCompatImpl extends JBMr2ViewPropertyAnimatorCompatImpl {
        KitKatViewPropertyAnimatorCompatImpl() {
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.BaseViewPropertyAnimatorCompatImpl, android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void setUpdateListener(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view2, ViewPropertyAnimatorUpdateListener viewPropertyAnimatorUpdateListener) {
            ViewPropertyAnimatorCompatKK.setUpdateListener(view2, viewPropertyAnimatorUpdateListener);
        }
    }

    /* loaded from: classes2.dex */
    static class LollipopViewPropertyAnimatorCompatImpl extends KitKatViewPropertyAnimatorCompatImpl {
        LollipopViewPropertyAnimatorCompatImpl() {
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.BaseViewPropertyAnimatorCompatImpl, android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void translationZ(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view2, float f) {
            ViewPropertyAnimatorCompatLollipop.translationZ(view2, f);
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.BaseViewPropertyAnimatorCompatImpl, android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void translationZBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view2, float f) {
            ViewPropertyAnimatorCompatLollipop.translationZBy(view2, f);
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.BaseViewPropertyAnimatorCompatImpl, android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void z(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view2, float f) {
            ViewPropertyAnimatorCompatLollipop.z(view2, f);
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.BaseViewPropertyAnimatorCompatImpl, android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void zBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view2, float f) {
            ViewPropertyAnimatorCompatLollipop.zBy(view2, f);
        }
    }

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 21) {
            IMPL = new LollipopViewPropertyAnimatorCompatImpl();
        } else if (i >= 19) {
            IMPL = new KitKatViewPropertyAnimatorCompatImpl();
        } else if (i >= 18) {
            IMPL = new JBMr2ViewPropertyAnimatorCompatImpl();
        } else if (i >= 16) {
            IMPL = new JBViewPropertyAnimatorCompatImpl();
        } else if (i >= 14) {
            IMPL = new ICSViewPropertyAnimatorCompatImpl();
        } else {
            IMPL = new BaseViewPropertyAnimatorCompatImpl();
        }
    }

    public ViewPropertyAnimatorCompat setDuration(long j) {
        View view2 = this.mView.get();
        if (view2 != null) {
            IMPL.setDuration(this, view2, j);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat alpha(float f) {
        View view2 = this.mView.get();
        if (view2 != null) {
            IMPL.alpha(this, view2, f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat alphaBy(float f) {
        View view2 = this.mView.get();
        if (view2 != null) {
            IMPL.alphaBy(this, view2, f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat translationX(float f) {
        View view2 = this.mView.get();
        if (view2 != null) {
            IMPL.translationX(this, view2, f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat translationY(float f) {
        View view2 = this.mView.get();
        if (view2 != null) {
            IMPL.translationY(this, view2, f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat withEndAction(Runnable runnable) {
        View view2 = this.mView.get();
        if (view2 != null) {
            IMPL.withEndAction(this, view2, runnable);
        }
        return this;
    }

    public long getDuration() {
        View view2 = this.mView.get();
        if (view2 != null) {
            return IMPL.getDuration(this, view2);
        }
        return 0L;
    }

    public ViewPropertyAnimatorCompat setInterpolator(Interpolator interpolator) {
        View view2 = this.mView.get();
        if (view2 != null) {
            IMPL.setInterpolator(this, view2, interpolator);
        }
        return this;
    }

    public Interpolator getInterpolator() {
        View view2 = this.mView.get();
        if (view2 != null) {
            return IMPL.getInterpolator(this, view2);
        }
        return null;
    }

    public ViewPropertyAnimatorCompat setStartDelay(long j) {
        View view2 = this.mView.get();
        if (view2 != null) {
            IMPL.setStartDelay(this, view2, j);
        }
        return this;
    }

    public long getStartDelay() {
        View view2 = this.mView.get();
        if (view2 != null) {
            return IMPL.getStartDelay(this, view2);
        }
        return 0L;
    }

    public ViewPropertyAnimatorCompat rotation(float f) {
        View view2 = this.mView.get();
        if (view2 != null) {
            IMPL.rotation(this, view2, f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat rotationBy(float f) {
        View view2 = this.mView.get();
        if (view2 != null) {
            IMPL.rotationBy(this, view2, f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat rotationX(float f) {
        View view2 = this.mView.get();
        if (view2 != null) {
            IMPL.rotationX(this, view2, f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat rotationXBy(float f) {
        View view2 = this.mView.get();
        if (view2 != null) {
            IMPL.rotationXBy(this, view2, f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat rotationY(float f) {
        View view2 = this.mView.get();
        if (view2 != null) {
            IMPL.rotationY(this, view2, f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat rotationYBy(float f) {
        View view2 = this.mView.get();
        if (view2 != null) {
            IMPL.rotationYBy(this, view2, f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat scaleX(float f) {
        View view2 = this.mView.get();
        if (view2 != null) {
            IMPL.scaleX(this, view2, f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat scaleXBy(float f) {
        View view2 = this.mView.get();
        if (view2 != null) {
            IMPL.scaleXBy(this, view2, f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat scaleY(float f) {
        View view2 = this.mView.get();
        if (view2 != null) {
            IMPL.scaleY(this, view2, f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat scaleYBy(float f) {
        View view2 = this.mView.get();
        if (view2 != null) {
            IMPL.scaleYBy(this, view2, f);
        }
        return this;
    }

    public void cancel() {
        View view2 = this.mView.get();
        if (view2 != null) {
            IMPL.cancel(this, view2);
        }
    }

    public ViewPropertyAnimatorCompat x(float f) {
        View view2 = this.mView.get();
        if (view2 != null) {
            IMPL.x(this, view2, f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat xBy(float f) {
        View view2 = this.mView.get();
        if (view2 != null) {
            IMPL.xBy(this, view2, f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat y(float f) {
        View view2 = this.mView.get();
        if (view2 != null) {
            IMPL.y(this, view2, f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat yBy(float f) {
        View view2 = this.mView.get();
        if (view2 != null) {
            IMPL.yBy(this, view2, f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat translationXBy(float f) {
        View view2 = this.mView.get();
        if (view2 != null) {
            IMPL.translationXBy(this, view2, f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat translationYBy(float f) {
        View view2 = this.mView.get();
        if (view2 != null) {
            IMPL.translationYBy(this, view2, f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat translationZBy(float f) {
        View view2 = this.mView.get();
        if (view2 != null) {
            IMPL.translationZBy(this, view2, f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat translationZ(float f) {
        View view2 = this.mView.get();
        if (view2 != null) {
            IMPL.translationZ(this, view2, f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat z(float f) {
        View view2 = this.mView.get();
        if (view2 != null) {
            IMPL.z(this, view2, f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat zBy(float f) {
        View view2 = this.mView.get();
        if (view2 != null) {
            IMPL.zBy(this, view2, f);
        }
        return this;
    }

    public void start() {
        View view2 = this.mView.get();
        if (view2 != null) {
            IMPL.start(this, view2);
        }
    }

    public ViewPropertyAnimatorCompat withLayer() {
        View view2 = this.mView.get();
        if (view2 != null) {
            IMPL.withLayer(this, view2);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat withStartAction(Runnable runnable) {
        View view2 = this.mView.get();
        if (view2 != null) {
            IMPL.withStartAction(this, view2, runnable);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat setListener(ViewPropertyAnimatorListener viewPropertyAnimatorListener) {
        View view2 = this.mView.get();
        if (view2 != null) {
            IMPL.setListener(this, view2, viewPropertyAnimatorListener);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat setUpdateListener(ViewPropertyAnimatorUpdateListener viewPropertyAnimatorUpdateListener) {
        View view2 = this.mView.get();
        if (view2 != null) {
            IMPL.setUpdateListener(this, view2, viewPropertyAnimatorUpdateListener);
        }
        return this;
    }
}
