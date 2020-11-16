package com.baidu.tbadk.core.util;

import android.content.Context;
import android.support.annotation.ColorRes;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public final class TagTextHelper {

    /* loaded from: classes.dex */
    private enum HotTopicTag {
        NEW(R.string.tag_str_new, R.color.CAM_X0305),
        HOT(R.string.tag_str_hot, R.color.CAM_X0301),
        REC(R.string.tag_str_rec, R.color.CAM_X0302),
        BAO(R.string.tag_str_bao, R.color.CAM_X0308),
        FEI(R.string.tag_str_fei, R.color.CAM_X0317);
        
        @ColorRes
        int tagColorRes;
        @StringRes
        int tagStrRes;

        HotTopicTag(@StringRes int i, @ColorRes int i2) {
            this.tagStrRes = i;
            this.tagColorRes = i2;
        }

        static HotTopicTag getHotTopicTag(int i) {
            switch (i) {
                case 1:
                    return NEW;
                case 2:
                    return HOT;
                case 3:
                    return REC;
                case 4:
                    return BAO;
                case 5:
                    return FEI;
                default:
                    return null;
            }
        }
    }

    public static String t(@NonNull Context context, int i) {
        HotTopicTag hotTopicTag = HotTopicTag.getHotTopicTag(i);
        return hotTopicTag != null ? context.getString(hotTopicTag.tagStrRes) : "";
    }

    @ColorRes
    public static int pz(int i) {
        HotTopicTag hotTopicTag = HotTopicTag.getHotTopicTag(i);
        return hotTopicTag != null ? hotTopicTag.tagColorRes : R.color.transparent;
    }

    @ColorRes
    public static int pA(int i) {
        switch (i) {
            case 1:
                return R.color.CAM_X0301;
            case 2:
                return R.color.CAM_X0305;
            case 3:
                return R.color.CAM_X0312;
            default:
                return R.color.CAM_X0110;
        }
    }
}
