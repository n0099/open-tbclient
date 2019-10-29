package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.frs.ForumWriteData;
/* loaded from: classes.dex */
public class RecordVideoActivityConfig extends IntentConfig {
    public static final String ENTRANCE_FLAG = "entrance_flag";
    public static final String FORUM_WRITE_DATA = "forum_write_data";
    public static final String VIDEO_TITLE = "video_title";
    public static final String WRITE_IMAGE_INFO = "write_image_info";

    public RecordVideoActivityConfig(Context context, int i, ForumWriteData forumWriteData, WriteImagesInfo writeImagesInfo, String str, int i2) {
        super(context);
        getIntent().putExtra(FORUM_WRITE_DATA, forumWriteData);
        getIntent().putExtra(WRITE_IMAGE_INFO, writeImagesInfo);
        getIntent().putExtra("video_title", str);
        getIntent().putExtra(ENTRANCE_FLAG, i);
        getIntent().putExtra("from_type", i2);
        setRequestCode(RequestResponseCode.REQUEST_RECORDER_VIDEO);
        setIntentAction(IntentAction.ActivityForResult);
    }
}
