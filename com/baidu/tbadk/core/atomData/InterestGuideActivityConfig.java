package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes3.dex */
public class InterestGuideActivityConfig extends IntentConfig {
    public static final int INTEREST_GUID_SHOW_SCENE_FIRST_START = 1;
    public static final int INTEREST_GUID_SHOW_SCENE_OTHER = 2;
    public static final String KEY_INTEREST_GUID_SHOW_SCENE = "interest_guid_show_scene";

    public InterestGuideActivityConfig(Context context) {
        super(context);
    }

    public InterestGuideActivityConfig(Context context, int i2) {
        super(context);
        getIntent().putExtra(KEY_INTEREST_GUID_SHOW_SCENE, i2);
    }
}
