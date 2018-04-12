package android.support.design.widget;

import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.support.design.R;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
/* loaded from: classes2.dex */
class ViewUtilsLollipop {
    private static final int[] STATE_LIST_ANIM_ATTRS = {16843848};

    ViewUtilsLollipop() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setBoundsViewOutlineProvider(View view2) {
        view2.setOutlineProvider(ViewOutlineProvider.BOUNDS);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setStateListAnimatorFromAttrs(View view2, AttributeSet attributeSet, int i, int i2) {
        Context context = view2.getContext();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, STATE_LIST_ANIM_ATTRS, i, i2);
        try {
            if (obtainStyledAttributes.hasValue(0)) {
                view2.setStateListAnimator(AnimatorInflater.loadStateListAnimator(context, obtainStyledAttributes.getResourceId(0, 0)));
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setDefaultAppBarLayoutStateListAnimator(View view2, float f) {
        int integer = view2.getResources().getInteger(R.integer.app_bar_elevation_anim_duration);
        android.animation.StateListAnimator stateListAnimator = new android.animation.StateListAnimator();
        stateListAnimator.addState(new int[]{16842766, R.attr.state_collapsible, -R.attr.state_collapsed}, ObjectAnimator.ofFloat(view2, "elevation", 0.0f).setDuration(integer));
        stateListAnimator.addState(new int[]{16842766}, ObjectAnimator.ofFloat(view2, "elevation", f).setDuration(integer));
        stateListAnimator.addState(new int[0], ObjectAnimator.ofFloat(view2, "elevation", 0.0f).setDuration(0L));
        view2.setStateListAnimator(stateListAnimator);
    }
}
