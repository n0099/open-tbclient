package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class VrPlayerActivityConfig extends IntentConfig {
    public static final String IS_LOGO = "is_logo";
    public static final String PIC_HEIGHT = "pic_height";
    public static final String PIC_WIDTH = "pic_width";
    public static final String RES_PATH = "video_path";
    public static final String TITLE = "title";
    public static final String TYPE = "type";
    public static final int TYPE_PIC = 2;
    public static final int TYPE_VIDEO = 1;

    public VrPlayerActivityConfig(Context context, int i, boolean z, String str) {
        super(context);
        if (getIntent() != null) {
            getIntent().putExtra("type", i);
            getIntent().putExtra(IS_LOGO, z);
            getIntent().putExtra(RES_PATH, str);
        }
    }

    public void addPicParam(int i, int i2) {
        if (getIntent() != null) {
            getIntent().putExtra(PIC_WIDTH, i);
            getIntent().putExtra(PIC_HEIGHT, i2);
        }
    }

    public void addTitle(String str) {
        if (getIntent() != null) {
            getIntent().putExtra("title", str);
        }
    }
}
