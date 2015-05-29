package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.c;
/* loaded from: classes.dex */
public class AlbumActivityConfig extends c {
    public static final String ALBUM_RESULT = "album_result";
    public static final String CAMERA_PHOTO_NAME = "camera_photo_name";
    public static final String CAMERA_RESULT = "camera_result";
    public static final String LAST_ALBUM_ID = "last_album_id";
    public static final String WRITE_IMAGES_INFO = "write_images_info";

    public AlbumActivityConfig(Context context, String str, String str2) {
        super(context);
        getIntent().putExtra(WRITE_IMAGES_INFO, str);
        getIntent().putExtra(CAMERA_PHOTO_NAME, str2);
        setIntentAction(IntentAction.ActivityForResult);
    }

    public AlbumActivityConfig(Context context, String str) {
        super(context);
        getIntent().putExtra(WRITE_IMAGES_INFO, str);
        setIntentAction(IntentAction.ActivityForResult);
    }
}
