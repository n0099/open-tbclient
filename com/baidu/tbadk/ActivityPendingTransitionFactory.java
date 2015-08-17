package com.baidu.tbadk;

import android.app.Activity;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class ActivityPendingTransitionFactory {
    public static final int TYPE_BIG_IMAGE = 2;
    public static final int TYPE_CUSTOM_FROM_THIRD_PARTY = 3;
    public static final int TYPE_NORMAL = 1;
    public static final int TYPE_NO_ANIMATION = 0;
    public static boolean IS_CUSTOM_FROM_THIRD_PARTY = false;
    public static int RES_NFADE_IN = i.a.fade_in;
    public static int RES_FADE_OUT = i.a.fade_out;
    public static int RES_NORMAL_IN_FROM_RIGHT = i.a.in_from_right;
    public static int RES_NORMAL_OUT_TO_RIGHT = i.a.out_to_right;
    public static int RES_BIG_IMAGE_IN_FROM_RIGHT = i.a.big_imageview_in;
    public static int RES_BIG_IMAGE_OUT_TO_RIGHT = i.a.big_imageview_out;
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
                default:
                    pageActivity.overridePendingTransition(RES_NFADE_IN, RES_NORMAL_OUT_TO_RIGHT);
                    return;
            }
        }
    }
}
