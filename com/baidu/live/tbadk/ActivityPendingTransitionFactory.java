package com.baidu.live.tbadk;

import android.app.Activity;
import com.baidu.live.sdk.a;
/* loaded from: classes11.dex */
public class ActivityPendingTransitionFactory {
    public static final int TYPE_BIG_IMAGE = 2;
    public static final int TYPE_BOTTOM = 4;
    public static final int TYPE_CUSTOM_FROM_THIRD_PARTY = 3;
    public static final int TYPE_NORMAL = 1;
    public static final int TYPE_NO_ANIMATION = 0;
    public static boolean IS_CUSTOM_FROM_THIRD_PARTY = false;
    public static int RES_NFADE_IN = a.C0203a.sdk_fade_in;
    public static int RES_FADE_OUT = a.C0203a.sdk_fade_out;
    public static int RES_NORMAL_IN_FROM_RIGHT = a.C0203a.sdk_in_from_right;
    public static int RES_NORMAL_IN_FROM_BOTTOM = a.C0203a.sdk_in_from_bottom;
    public static int RES_NORMAL_OUT_TO_RIGHT = a.C0203a.sdk_out_to_right;
    public static int RES_NORMAL_OUT_TO_BOTTOM = a.C0203a.sdk_out_to_bottom;
    public static int RES_BIG_IMAGE_IN_FROM_RIGHT = a.C0203a.sdk_anim_alpha_0_to_1_duration_300;
    public static int RES_BIG_IMAGE_OUT_TO_RIGHT = a.C0203a.sdk_anim_alpha_1_to_0_duration_300;
    public static int RES_CUSTOM_FADE_IN = 0;
    public static int RES_CUSTOM_FADE_OUT = 0;
    public static int RES_CUSTOM_IN_FROM_RIGHT = 0;
    public static int RES_CUSTOM_OUT_TO_RIGHT = 0;

    public static void enterExitAnimation(TbPageContext<?> tbPageContext, int i) {
        if (tbPageContext != null) {
            Activity pageActivity = tbPageContext.getPageActivity();
            if (IS_CUSTOM_FROM_THIRD_PARTY) {
                i = 3;
            }
            switch (i) {
                case 0:
                    pageActivity.overridePendingTransition(0, 0);
                    return;
                case 1:
                    pageActivity.overridePendingTransition(RES_NORMAL_IN_FROM_RIGHT, RES_FADE_OUT);
                    return;
                case 2:
                    pageActivity.overridePendingTransition(RES_BIG_IMAGE_IN_FROM_RIGHT, RES_FADE_OUT);
                    return;
                case 3:
                    pageActivity.overridePendingTransition(RES_CUSTOM_IN_FROM_RIGHT, RES_CUSTOM_FADE_OUT);
                    return;
                case 4:
                    pageActivity.overridePendingTransition(RES_NORMAL_IN_FROM_BOTTOM, RES_FADE_OUT);
                    return;
                default:
                    pageActivity.overridePendingTransition(RES_NORMAL_IN_FROM_RIGHT, RES_FADE_OUT);
                    return;
            }
        }
    }

    public static void closeAnimation(TbPageContext<?> tbPageContext, int i) {
        if (tbPageContext != null) {
            Activity pageActivity = tbPageContext.getPageActivity();
            if (IS_CUSTOM_FROM_THIRD_PARTY) {
                i = 3;
            }
            switch (i) {
                case 0:
                    pageActivity.overridePendingTransition(0, 0);
                    return;
                case 1:
                    pageActivity.overridePendingTransition(RES_NFADE_IN, RES_NORMAL_OUT_TO_RIGHT);
                    return;
                case 2:
                    pageActivity.overridePendingTransition(RES_NFADE_IN, RES_BIG_IMAGE_OUT_TO_RIGHT);
                    return;
                case 3:
                    pageActivity.overridePendingTransition(RES_CUSTOM_FADE_IN, RES_CUSTOM_OUT_TO_RIGHT);
                    return;
                case 4:
                    pageActivity.overridePendingTransition(RES_NFADE_IN, RES_NORMAL_OUT_TO_BOTTOM);
                    return;
                default:
                    pageActivity.overridePendingTransition(RES_NFADE_IN, RES_NORMAL_OUT_TO_RIGHT);
                    return;
            }
        }
    }
}
