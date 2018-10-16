package com.baidu.searchbox.ng.ai.apps.animator;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.ng.ai.apps.AiAppsActivity;
import com.baidu.searchbox.ng.ai.apps.performance.AiAppsPerformanceUBC;
import com.baidu.searchbox.ng.ai.apps.performance.UbcFlowEvent;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsUIUtils;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes2.dex */
public class AiAppsLoadingAnimator {
    private static final String ALPHA = "alpha";
    public static final float ALPHA_NORMAL = 1.0f;
    public static final float ALPHA_TRANSPARENT = 0.0f;
    public static final float DARK_LOADING_POINT_TRANSLATION = 19.0f;
    public static final int ICON_ANIMATOR_DURATION = 220;
    public static final float ICON_TRANSLATION = 29.0f;
    public static final float LIGHT_LOADING_POINT_TRANSLATION = 9.5f;
    public static final int LOADING_POINT_ANIMATOR_DURATION = 240;
    public static final int LOADING_POINT_CIRCLE_ANIMATOR_DURATION = 380;
    private static final String SCALEX = "scaleX";
    private static final String SCALEY = "scaleY";
    public static final float SCALE_NONE = 0.0f;
    public static final float SCALE_NORMAL = 1.0f;
    public static final int TITLE_ANIMATOR_DURATION = 300;
    public static final float TITLE_TRANSLATION = 85.0f;
    private static final String TRANSLATIONX = "translationX";
    private static final String TRANSLATIONY = "translationY";
    public static final float TRANSLATION_BASE = 0.0f;
    private List<AnimatorSet> mStartedAnimators = new CopyOnWriteArrayList();

    private ObjectAnimator createTitleAnimator(AiAppsActivity aiAppsActivity) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(aiAppsActivity.getLoadingView().mAiAppsTitle, TRANSLATIONY, 0.0f, -AiAppsUIUtils.dip2px(AppRuntime.getAppContext(), 85.0f));
        ofFloat.setDuration(300L);
        return ofFloat;
    }

    private AnimatorSet createIconAnimator(AiAppsActivity aiAppsActivity) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ObjectAnimator.ofFloat(aiAppsActivity.getLoadingView().mAiAppsRelativeLayout, TRANSLATIONY, 0.0f, -AiAppsUIUtils.dip2px(AppRuntime.getAppContext(), 29.0f))).with(ObjectAnimator.ofFloat(aiAppsActivity.getLoadingView().mAiAppsRelativeLayout, SCALEX, 1.0f, 0.0f)).with(ObjectAnimator.ofFloat(aiAppsActivity.getLoadingView().mAiAppsRelativeLayout, SCALEY, 1.0f, 0.0f));
        animatorSet.setDuration(220L);
        return animatorSet;
    }

    private AnimatorSet createLoadingPointVisible(AiAppsActivity aiAppsActivity) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(aiAppsActivity.getLoadingView().mLightLoadingPoint, TRANSLATIONX, 0.0f, -AiAppsUIUtils.dip2px(AppRuntime.getAppContext(), 9.5f));
        ofFloat.setDuration(240L);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(aiAppsActivity.getLoadingView().mDarkLoadingPoint, ALPHA, 0.0f, 1.0f);
        ofFloat2.setDuration(240L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat).with(ofFloat2);
        return animatorSet;
    }

    private AnimatorSet createLoadingPointCircle(AiAppsActivity aiAppsActivity) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(aiAppsActivity.getLoadingView().mLightLoadingPoint, TRANSLATIONX, -AiAppsUIUtils.dip2px(AppRuntime.getAppContext(), 9.5f), AiAppsUIUtils.dip2px(AppRuntime.getAppContext(), 9.5f));
        ofFloat.setDuration(380L);
        ofFloat.setRepeatMode(2);
        ofFloat.setRepeatCount(-1);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(aiAppsActivity.getLoadingView().mDarkLoadingPoint, TRANSLATIONX, 0.0f, -AiAppsUIUtils.dip2px(AppRuntime.getAppContext(), 19.0f));
        ofFloat2.setDuration(380L);
        ofFloat2.setRepeatMode(2);
        ofFloat2.setRepeatCount(-1);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat).with(ofFloat2);
        return animatorSet;
    }

    public void startLoadingAnimator(AiAppsActivity aiAppsActivity) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(createLoadingPointVisible(aiAppsActivity)).before(createLoadingPointCircle(aiAppsActivity));
        animatorSet.start();
        AiAppsPerformanceUBC.requireSession().record(new UbcFlowEvent(AiAppsPerformanceUBC.ACTION_FIRST_ANIM_START));
        this.mStartedAnimators.add(animatorSet);
    }

    public void startLoadFinishAnimator(final AiAppsActivity aiAppsActivity) {
        AnimatorSet animatorSet = new AnimatorSet();
        aiAppsActivity.getLoadingView().mDarkLoadingPoint.setVisibility(8);
        aiAppsActivity.getLoadingView().mLightLoadingPoint.setVisibility(8);
        animatorSet.playTogether(createIconAnimator(aiAppsActivity), createTitleAnimator(aiAppsActivity));
        animatorSet.start();
        AiAppsPerformanceUBC.requireSession().record(new UbcFlowEvent(AiAppsPerformanceUBC.ACTION_SECOND_ANIM_START));
        animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.baidu.searchbox.ng.ai.apps.animator.AiAppsLoadingAnimator.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AiAppsPerformanceUBC.requireSession().record(new UbcFlowEvent(AiAppsPerformanceUBC.ACTION_SECOND_ANIM_END)).naFlowDone();
                if (!aiAppsActivity.isFinishing()) {
                    aiAppsActivity.getLoadingView().mStartLoadingContainer.setVisibility(8);
                    aiAppsActivity.getFloatLayer().reset();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.mStartedAnimators.add(animatorSet);
    }

    public void stopAnimations() {
        for (AnimatorSet animatorSet : this.mStartedAnimators) {
            animatorSet.removeAllListeners();
            animatorSet.cancel();
        }
        this.mStartedAnimators.clear();
    }
}
