package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class AlbumActivityConfig extends IntentConfig {
    public static final String ALBUM_RESULT = "album_result";
    public static final String AUTO_PHOTO_NAME = "auto_photo_name";
    public static final int AVATAR_TYPE = 2;
    public static final String CAMERA_PHOTO_NAME = "camera_photo_name";
    public static final String CAMERA_REQUEST_FROM = "camera_request_from";
    public static final String CAMERA_RESULT = "camera_result";
    public static final int COMMON_TYPE = 0;
    public static final String FINISH_SELF = "finish_self";
    public static final int FROM_DEFAULT = 0;
    public static final String FROM_FRS = "frs";
    public static final String FROM_MAIN_TAB = "main_tab";
    public static final String FROM_PB = "pb";
    public static final int FROM_PB_SHOW_PICTURE = 2;
    public static final int FROM_PHOTO_LIVE_COVER = 1;
    public static final int FROM_PHOTO_LIVE_UPGRADE_DIALOG = 3;
    public static final int FROM_VOTE = 3;
    public static final int FROM_WEB_VIEW = 5;
    public static final String FROM_WRITE = "write";
    public static final int IM_TYPE = 1;
    public static final String IS_SELECT_DIRECTLY = "select_directly";
    public static final String KEY_FORUM_WRITE_DATA = "KEY_FORUM_WRITE_DATA";
    public static final String LAST_ALBUM_ID = "last_album_id";
    public static final String USE_ORIGINAL_IMG = "use_original_img";
    public static final String WRITE_IMAGES_INFO = "write_images_info";

    public AlbumActivityConfig(Context context, String str) {
        super(context);
        getIntent().putExtra(CAMERA_REQUEST_FROM, 0);
        getIntent().putExtra(WRITE_IMAGES_INFO, str);
        setIntentAction(IntentAction.ActivityForResult);
    }

    public AlbumActivityConfig(Context context, boolean z, String str) {
        super(context);
        getIntent().putExtra(CAMERA_REQUEST_FROM, 0);
        getIntent().putExtra(WRITE_IMAGES_INFO, str);
        getIntent().putExtra(USE_ORIGINAL_IMG, z);
        setIntentAction(IntentAction.ActivityForResult);
    }

    public AlbumActivityConfig(Context context, String str, String str2) {
        this(context, str);
        getIntent().putExtra(CAMERA_PHOTO_NAME, str2);
    }

    public AlbumActivityConfig(Context context, String str, String str2, boolean z) {
        this(context, str);
        getIntent().putExtra(CAMERA_PHOTO_NAME, str2);
        getIntent().putExtra(USE_ORIGINAL_IMG, z);
    }

    public AlbumActivityConfig(Context context, String str, boolean z) {
        this(context, str);
        getIntent().putExtra(AUTO_PHOTO_NAME, z);
    }

    public AlbumActivityConfig(Context context, String str, boolean z, boolean z2) {
        this(context, str);
        getIntent().putExtra(AUTO_PHOTO_NAME, z);
        getIntent().putExtra(USE_ORIGINAL_IMG, z2);
    }

    public AlbumActivityConfig(Context context, String str, int i) {
        this(context, str);
        getIntent().putExtra(CAMERA_REQUEST_FROM, i);
    }

    public AlbumActivityConfig(Context context, String str, String str2, int i) {
        this(context, str, str2);
        getIntent().putExtra(CAMERA_REQUEST_FROM, i);
    }

    public void setRequestFrom(int i) {
        if (getIntent() != null) {
            getIntent().putExtra(CAMERA_REQUEST_FROM, i);
        }
    }

    public void setAlbumThread(int i) {
        if (getIntent() != null) {
            getIntent().putExtra(IntentConfig.KEY_ALBUM_THREAD, i);
        }
    }

    public void setFromWrite(boolean z) {
        if (getIntent() != null) {
            getIntent().putExtra("from_write", z);
        }
    }

    public void setResourceType(int i) {
        if (getIntent() != null) {
            getIntent().putExtra("from_type", i);
        }
    }

    public void setCallFrom(String str) {
        getIntent().putExtra("KEY_CALL_FROM", str);
    }
}
