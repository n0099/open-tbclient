package com.baidu.ar.ui.rotateview;

import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import com.baidu.ar.rotate.Orientation;
/* loaded from: classes3.dex */
public class RotateViewUtils {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class a implements Animation.AnimationListener {
        private IRotateView a;
        private Orientation b;

        public a(IRotateView iRotateView, Orientation orientation) {
            this.a = iRotateView;
            this.b = orientation;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            this.a.clearAnimation();
            this.a.requestOrientation(this.b);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i) {
        if (i < 0) {
            i = (i % 360) + 360;
        }
        return Math.round(i / 90.0f) * 90;
    }

    private static RotateAnimation a(int i, Animation.AnimationListener animationListener) {
        float f = 90.0f;
        switch (i) {
            case 1:
                f = -90.0f;
                break;
            case 2:
                f = 180.0f;
                break;
        }
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setFillAfter(false);
        rotateAnimation.setDuration(200L);
        rotateAnimation.setAnimationListener(animationListener);
        return rotateAnimation;
    }

    private static void a(IRotateView iRotateView, int i, Orientation orientation) {
        iRotateView.startAnimation(a(i, new a(iRotateView, orientation)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(IRotateView iRotateView, Orientation orientation, boolean z) {
        if (!iRotateView.isShown() || !z) {
            iRotateView.requestOrientation(orientation);
            return;
        }
        iRotateView.clearAnimation();
        switch (iRotateView.getAngle()) {
            case 0:
            case 180:
            case 360:
                switch (orientation) {
                    case PORTRAIT:
                    default:
                        return;
                    case LANDSCAPE:
                        a(iRotateView, 1, orientation);
                        return;
                    case LANDSCAPE_REVERSE:
                        a(iRotateView, 0, orientation);
                        return;
                }
            case 90:
                switch (orientation) {
                    case PORTRAIT:
                        a(iRotateView, 1, orientation);
                        return;
                    case LANDSCAPE:
                        a(iRotateView, 2, orientation);
                        return;
                    case LANDSCAPE_REVERSE:
                    default:
                        return;
                }
            case 270:
                switch (orientation) {
                    case PORTRAIT:
                        a(iRotateView, 0, orientation);
                        return;
                    case LANDSCAPE:
                    default:
                        return;
                    case LANDSCAPE_REVERSE:
                        a(iRotateView, 2, orientation);
                        return;
                }
            default:
                return;
        }
    }

    public static void requestOrientation(IRotateView iRotateView, Orientation orientation) {
        if (iRotateView != null) {
            iRotateView.requestOrientation(orientation);
        }
    }

    public static void requestOrientation(IRotateView iRotateView, Orientation orientation, boolean z) {
        if (iRotateView != null) {
            iRotateView.requestOrientation(orientation, z);
        }
    }

    public static void updateOrientation(IRotateView iRotateView, Orientation orientation) {
        switch (orientation) {
            case PORTRAIT:
                iRotateView.setAngle(0);
                return;
            case LANDSCAPE:
                iRotateView.setAngle(-90);
                return;
            case LANDSCAPE_REVERSE:
                iRotateView.setAngle(90);
                return;
            default:
                return;
        }
    }
}
