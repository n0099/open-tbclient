package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.content.Intent;
/* loaded from: classes.dex */
public class PhotoLiveCommentActivityConfig extends SubPbActivityConfig {
    public static final String FROM_LIVE_COMMENT = "from_live_comment";
    public static final int FROM_NONE_PHOTO_LIVE = -100;
    public static final int FROM_PHOTO_LIVE = 100;
    public static final int FROM_PHOTO_LIVE_COMMENT_CONTENT = 101;
    public static final String KEY_FLOOR_NUM = "floor_num";
    public static final String KEY_FROM = "from";
    public static final String KEY_PULL_COMMENT_PER_SEC = "pull_comment_per_sec";

    public PhotoLiveCommentActivityConfig(Context context) {
        super(context);
    }

    public PhotoLiveCommentActivityConfig createPhotoLiveCommentActivityConfig(String str, String str2, boolean z) {
        return createPhotoLiveCommentActivityConfig(str, str2, z ? 100 : -100, 0, -1, false);
    }

    public PhotoLiveCommentActivityConfig createPhotoLiveCommentActivityConfig(String str, String str2, int i, int i2, int i3, boolean z) {
        Intent intent = getIntent();
        intent.putExtra("thread_id", str);
        intent.putExtra("post_id", str2);
        intent.putExtra("from", i);
        intent.putExtra("floor_num", i2);
        intent.putExtra(KEY_PULL_COMMENT_PER_SEC, i3);
        intent.putExtra(SubPbActivityConfig.KEY_SHOW_KEYBOARD, z);
        return this;
    }
}
