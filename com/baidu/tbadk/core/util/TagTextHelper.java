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

        HotTopicTag(@StringRes int i2, @ColorRes int i3) {
            this.tagStrRes = i2;
            this.tagColorRes = i3;
        }

        public static HotTopicTag getHotTopicTag(int i2) {
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        if (i2 != 4) {
                            if (i2 != 5) {
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
    public static int getHotTopicTagColorRes(int i2) {
        HotTopicTag hotTopicTag = HotTopicTag.getHotTopicTag(i2);
        if (hotTopicTag != null) {
            return hotTopicTag.tagColorRes;
        }
        return R.color.transparent;
    }

    public static String getHotTopicTagStr(@NonNull Context context, int i2) {
        HotTopicTag hotTopicTag = HotTopicTag.getHotTopicTag(i2);
        return hotTopicTag != null ? context.getString(hotTopicTag.tagStrRes) : "";
    }

    @ColorRes
    public static int getIndexTextColorRes(int i2) {
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    return R.color.CAM_X0110;
                }
                return R.color.CAM_X0312;
            }
            return R.color.CAM_X0305;
        }
        return R.color.CAM_X0301;
    }
}
