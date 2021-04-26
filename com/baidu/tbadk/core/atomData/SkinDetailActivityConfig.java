package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes3.dex */
public class SkinDetailActivityConfig extends IntentConfig {
    public static final String THEME_ALBUM_PICTURE = "theme_album_picture";
    public static final String THEME_CURRENT_TYPE = "current_type";
    public static final String THEME_ID = "theme_id";
    public static final String THEME_PERMISSION_ICON_URL = "theme_permission_icon_url";

    public SkinDetailActivityConfig(Context context, int i2) {
        super(context);
        getIntent().putExtra(THEME_ID, i2);
    }

    public SkinDetailActivityConfig(Context context, int i2, String str, String str2) {
        super(context);
        getIntent().putExtra(THEME_ID, i2);
        getIntent().putExtra(THEME_ALBUM_PICTURE, str);
        getIntent().putExtra(THEME_PERMISSION_ICON_URL, str2);
    }

    public SkinDetailActivityConfig(Context context, int i2, int i3, String str, String str2) {
        super(context);
        getIntent().putExtra(THEME_ID, i2);
        getIntent().putExtra(THEME_CURRENT_TYPE, i3);
        getIntent().putExtra(THEME_ALBUM_PICTURE, str);
        getIntent().putExtra(THEME_PERMISSION_ICON_URL, str2);
    }
}
