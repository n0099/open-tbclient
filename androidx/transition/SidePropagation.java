package androidx.transition;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class SidePropagation extends VisibilityPropagation {
    public float mPropagationSpeed = 3.0f;
    public int mSide = 80;

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0017, code lost:
        r0 = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0026, code lost:
        if ((androidx.core.view.ViewCompat.getLayoutDirection(r7) == 1) != false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0013, code lost:
        if ((androidx.core.view.ViewCompat.getLayoutDirection(r7) == 1) != false) goto L7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0015, code lost:
        r0 = 5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int distance(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        int i10 = this.mSide;
        if (i10 != 8388611) {
            if (i10 == 8388613) {
            }
        }
        if (i10 != 3) {
            if (i10 != 5) {
                if (i10 != 48) {
                    if (i10 != 80) {
                        return 0;
                    }
                    return (i3 - i7) + Math.abs(i4 - i2);
                }
                return (i9 - i3) + Math.abs(i4 - i2);
            }
            return (i2 - i6) + Math.abs(i5 - i3);
        }
        return (i8 - i2) + Math.abs(i5 - i3);
    }

    private int getMaxDistance(ViewGroup viewGroup) {
        int i2 = this.mSide;
        if (i2 != 3 && i2 != 5 && i2 != 8388611 && i2 != 8388613) {
            return viewGroup.getHeight();
        }
        return viewGroup.getWidth();
    }

    @Override // androidx.transition.TransitionPropagation
    public long getStartDelay(ViewGroup viewGroup, Transition transition, TransitionValues transitionValues, TransitionValues transitionValues2) {
        int i2;
        int i3;
        int i4;
        TransitionValues transitionValues3 = transitionValues;
        if (transitionValues3 == null && transitionValues2 == null) {
            return 0L;
        }
        Rect epicenter = transition.getEpicenter();
        if (transitionValues2 == null || getViewVisibility(transitionValues3) == 0) {
            i2 = -1;
        } else {
            transitionValues3 = transitionValues2;
            i2 = 1;
        }
        int viewX = getViewX(transitionValues3);
        int viewY = getViewY(transitionValues3);
        int[] iArr = new int[2];
        viewGroup.getLocationOnScreen(iArr);
        int round = iArr[0] + Math.round(viewGroup.getTranslationX());
        int round2 = iArr[1] + Math.round(viewGroup.getTranslationY());
        int width = round + viewGroup.getWidth();
        int height = round2 + viewGroup.getHeight();
        if (epicenter != null) {
            i3 = epicenter.centerX();
            i4 = epicenter.centerY();
        } else {
            i3 = (round + width) / 2;
            i4 = (round2 + height) / 2;
        }
        float distance = distance(viewGroup, viewX, viewY, i3, i4, round, round2, width, height) / getMaxDistance(viewGroup);
        long duration = transition.getDuration();
        if (duration < 0) {
            duration = 300;
        }
        return Math.round((((float) (duration * i2)) / this.mPropagationSpeed) * distance);
    }

    public void setPropagationSpeed(float f2) {
        if (f2 != 0.0f) {
            this.mPropagationSpeed = f2;
            return;
        }
        throw new IllegalArgumentException("propagationSpeed may not be 0");
    }

    public void setSide(int i2) {
        this.mSide = i2;
    }
}
