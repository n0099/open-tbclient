package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.c;
/* loaded from: classes.dex */
public class PluginCenterActivityConfig extends c {
    public static final int FROM_DISCOVER = 1;
    public static final int FROM_SETTING = 0;
    public static final String KEY_FROM_TYPE = "key_from_type";

    public PluginCenterActivityConfig(Context context) {
        this(context, 0);
    }

    public PluginCenterActivityConfig(Context context, int i) {
        super(context);
        getIntent().putExtra(KEY_FROM_TYPE, i);
    }
}
