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
        NEW(R.string.tag_str_new, R.color.cp_link_tip_d),
        HOT(R.string.tag_str_hot, R.color.cp_cont_h),
        REC(R.string.tag_str_rec, R.color.cp_link_tip_a),
        BAO(R.string.tag_str_bao, R.color.cp_other_b),
        FEI(R.string.tag_str_fei, R.color.cp_other_k);
        
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

    public static String s(@NonNull Context context, int i) {
        HotTopicTag hotTopicTag = HotTopicTag.getHotTopicTag(i);
        return hotTopicTag != null ? context.getString(hotTopicTag.tagStrRes) : "";
    }

    @ColorRes
    public static int lz(int i) {
        HotTopicTag hotTopicTag = HotTopicTag.getHotTopicTag(i);
        return hotTopicTag != null ? hotTopicTag.tagColorRes : R.color.transparent;
    }

    @ColorRes
    public static int lA(int i) {
        switch (i) {
            case 1:
                return R.color.cp_cont_h;
            case 2:
                return R.color.cp_link_tip_d;
            case 3:
                return R.color.cp_other_f;
            default:
                return R.color.cp_cont_e;
        }
    }
}
