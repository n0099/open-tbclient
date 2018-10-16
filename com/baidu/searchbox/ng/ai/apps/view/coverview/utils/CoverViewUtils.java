package com.baidu.searchbox.ng.ai.apps.view.coverview.utils;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import com.baidu.searchbox.ng.ai.apps.util.AiAppJSONUtils;
import com.baidu.searchbox.ng.ai.apps.view.container.AiAppsNAViewContainer;
import com.baidu.searchbox.ng.ai.apps.view.container.util.Diff;
import com.baidu.searchbox.ng.ai.apps.view.coverview.model.CoverViewModel;
import com.baidu.searchbox.ng.ai.apps.view.coverview.subview.CoverViewHelper;
import com.baidu.searchbox.ng.ai.apps.view.coverview.subview.ICoverView;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class CoverViewUtils {
    public static boolean updateCoverView(AiAppsNAViewContainer aiAppsNAViewContainer, CoverViewModel coverViewModel) {
        if (aiAppsNAViewContainer == null) {
            return false;
        }
        View nAView = aiAppsNAViewContainer.getNAView();
        if (nAView == null || !(nAView instanceof ICoverView)) {
            return false;
        }
        ICoverView iCoverView = (ICoverView) nAView;
        if (coverViewModel == null || coverViewModel.position == null || !coverViewModel.position.isValid()) {
            return false;
        }
        CoverViewModel model = iCoverView.getModel();
        if (model == null || model.position == null || !model.position.isValid()) {
            return false;
        }
        Diff diffCoverViewModel = diffCoverViewModel(model, coverViewModel);
        if ((diffCoverViewModel.get() & 4) == 4) {
            return performAnimation(aiAppsNAViewContainer, coverViewModel);
        }
        if ((diffCoverViewModel.get() & 2) == 2) {
            iCoverView.bindModel(coverViewModel);
        } else {
            iCoverView.setModel(coverViewModel);
        }
        return aiAppsNAViewContainer.updateView(coverViewModel);
    }

    @NonNull
    public static Diff diffCoverViewModel(CoverViewModel coverViewModel, CoverViewModel coverViewModel2) {
        Diff diff = new Diff();
        if (coverViewModel != coverViewModel2) {
            if (coverViewModel != null && coverViewModel2 != null) {
                coverViewModel.diff(coverViewModel2, diff);
            } else {
                diff.mask(15);
            }
        }
        return diff;
    }

    private static boolean performAnimation(@NonNull AiAppsNAViewContainer aiAppsNAViewContainer, @NonNull CoverViewModel coverViewModel) {
        long j;
        if (coverViewModel.animData == null || TextUtils.isEmpty(coverViewModel.animData.optString("duration"))) {
            return false;
        }
        View nAView = aiAppsNAViewContainer.getNAView();
        if (nAView == null || !(nAView instanceof ICoverView)) {
            return false;
        }
        ICoverView iCoverView = (ICoverView) nAView;
        ValueAnimator createTranslateAnimator = createTranslateAnimator(aiAppsNAViewContainer, coverViewModel, false);
        ValueAnimator createTranslateAnimator2 = createTranslateAnimator(aiAppsNAViewContainer, coverViewModel, true);
        ValueAnimator createAlphaAnimator = createAlphaAnimator(aiAppsNAViewContainer, coverViewModel);
        try {
            j = Long.parseLong(coverViewModel.animData.optString("duration"));
        } catch (Exception e) {
            j = 0;
        }
        Interpolator obtainInterpolator = CoverViewModel.obtainInterpolator(coverViewModel.animData.optString(CoverViewModel.TRANS_KEY_EASING));
        iCoverView.bindModel(coverViewModel);
        aiAppsNAViewContainer.bindModel(coverViewModel);
        AnimatorSet createAnimatorSet = createAnimatorSet(aiAppsNAViewContainer, coverViewModel, j, obtainInterpolator, createTranslateAnimator, createTranslateAnimator2, createAlphaAnimator);
        if (createAnimatorSet != null) {
            createAnimatorSet.start();
        }
        return true;
    }

    private static ValueAnimator createTranslateAnimator(@NonNull final AiAppsNAViewContainer aiAppsNAViewContainer, @NonNull CoverViewModel coverViewModel, final boolean z) {
        CoverViewModel model;
        ValueAnimator valueAnimator;
        View nAView = aiAppsNAViewContainer.getNAView();
        if (nAView == null || !(nAView instanceof ICoverView) || (model = ((ICoverView) nAView).getModel()) == null) {
            return null;
        }
        int left = z ? model.position.getLeft() : model.position.getTop();
        int left2 = z ? coverViewModel.position.getLeft() : coverViewModel.position.getTop();
        if (left != left2) {
            valueAnimator = ValueAnimator.ofInt(left, left2);
            valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.searchbox.ng.ai.apps.view.coverview.utils.CoverViewUtils.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    if (AiAppsNAViewContainer.this != null) {
                        ViewGroup.LayoutParams layoutParams = AiAppsNAViewContainer.this.getLayoutParams();
                        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                            if (z) {
                                marginLayoutParams.leftMargin = ((Integer) valueAnimator2.getAnimatedValue()).intValue();
                            } else {
                                marginLayoutParams.topMargin = ((Integer) valueAnimator2.getAnimatedValue()).intValue();
                            }
                            AiAppsNAViewContainer.this.syncPosition(marginLayoutParams);
                        }
                    }
                }
            });
        } else {
            valueAnimator = null;
        }
        return valueAnimator;
    }

    private static ValueAnimator createAlphaAnimator(@NonNull AiAppsNAViewContainer aiAppsNAViewContainer, @NonNull CoverViewModel coverViewModel) {
        CoverViewModel model;
        ObjectAnimator objectAnimator;
        View nAView = aiAppsNAViewContainer.getNAView();
        if (nAView == null || !(nAView instanceof ICoverView) || (model = ((ICoverView) nAView).getModel()) == null) {
            return null;
        }
        if (coverViewModel.styleData != null) {
            float f = AiAppJSONUtils.getFloat(model.styleData, CoverViewHelper.OPACITY, 1.0f);
            float f2 = AiAppJSONUtils.getFloat(coverViewModel.styleData, CoverViewHelper.OPACITY, f);
            if (f != f2) {
                objectAnimator = ObjectAnimator.ofFloat(aiAppsNAViewContainer, "alpha", f, f2);
                return objectAnimator;
            }
        }
        objectAnimator = null;
        return objectAnimator;
    }

    private static AnimatorSet createAnimatorSet(AiAppsNAViewContainer aiAppsNAViewContainer, CoverViewModel coverViewModel, long j, @NonNull Interpolator interpolator, ValueAnimator... valueAnimatorArr) {
        if (j <= 0 || valueAnimatorArr == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (ValueAnimator valueAnimator : valueAnimatorArr) {
            if (valueAnimator != null) {
                arrayList.add(valueAnimator);
            }
        }
        if (arrayList.size() != 0) {
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setInterpolator(interpolator);
            animatorSet.setDuration(j);
            animatorSet.playTogether(arrayList);
            return animatorSet;
        }
        return null;
    }
}
