package com.baidu.tbadk.core.util;

import android.content.Context;
import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public final class TagTextHelper {

    /* loaded from: classes3.dex */
    public enum HotTopicTag {
        NEW(R.string.tag_str_new, R.color.CAM_X0305),
        HOT(R.string.tag_str_hot, R.color.CAM_X0301),
        REC(R.string.tag_str_rec, R.color.CAM_X0302),
        BAO(R.string.tag_str_bao, R.color.CAM_X0308),
        FEI(R.string.tag_str_fei, R.color.CAM_X0317);
        
        @ColorRes
        public int tagColorRes;
        @StringRes
        public int tagStrRes;

        HotTopicTag(@StringRes int i, @ColorRes int i2) {
            this.tagStrRes = i;
            this.tagColorRes = i2;
        }

        public static HotTopicTag getHotTopicTag(int i) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i != 5) {
                                return null;
                            }
                            return FEI;
                        }
                        return BAO;
                    }
                    return REC;
                }
                return HOT;
            }
            return NEW;
        }
    }

    @ColorRes
    public static int getHotTopicTagColorRes(int i) {
        HotTopicTag hotTopicTag = HotTopicTag.getHotTopicTag(i);
        if (hotTopicTag != null) {
            return hotTopicTag.tagColorRes;
        }
        return R.color.transparent;
    }

    public static String getHotTopicTagStr(@NonNull Context context, int i) {
        HotTopicTag hotTopicTag = HotTopicTag.getHotTopicTag(i);
        return hotTopicTag != null ? context.getString(hotTopicTag.tagStrRes) : "";
    }

    @ColorRes
    public static int getIndexTextColorRes(int i) {
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    return R.color.CAM_X0110;
                }
                return R.color.CAM_X0312;
            }
            return R.color.CAM_X0305;
        }
        return R.color.CAM_X0301;
    }
}
