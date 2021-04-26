package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.frs.ForumWriteData;
/* loaded from: classes3.dex */
public class RecordVideoActivityConfig extends IntentConfig {
    public static final String ENTRANCE_FLAG = "entrance_flag";
    public static final String FORUM_WRITE_DATA = "forum_write_data";
    public static final String SHOW_TYPE = "show_type";
    public static final int SHOW_TYPE_PIC_ONLY = 1;
    public static final int SHOW_TYPE_TRY_BOTH = 0;
    public static final int SHOW_TYPE_VIDEO_ONLY = 2;
    public static final String VIDEO_TITLE = "video_title";
    public static final String WRITE_IMAGE_INFO = "write_image_info";

    public RecordVideoActivityConfig(Context context, int i2, ForumWriteData forumWriteData, WriteImagesInfo writeImagesInfo, String str, int i3) {
        super(context);
        getIntent().putExtra("forum_write_data", forumWriteData);
        getIntent().putExtra(WRITE_IMAGE_INFO, writeImagesInfo);
        getIntent().putExtra("video_title", str);
        getIntent().putExtra(ENTRANCE_FLAG, i2);
        getIntent().putExtra("from_type", i3);
        setRequestCode(13010);
        setIntentAction(IntentAction.ActivityForResult);
    }

    public void setExtraData(AntiData antiData, PostPrefixData postPrefixData, String str, String str2) {
        if (getIntent() != null) {
            getIntent().putExtra(IntentConfig.FORUM_FIRST_DIR, str);
            getIntent().putExtra(IntentConfig.FORUM_SECOND_DIR, str2);
            getIntent().putExtra("prefix_data", postPrefixData);
            getIntent().putExtra("anti_data", antiData);
        }
    }

    public void setShowType(int i2) {
        if (getIntent() != null) {
            getIntent().putExtra(SHOW_TYPE, i2);
        }
    }
}
