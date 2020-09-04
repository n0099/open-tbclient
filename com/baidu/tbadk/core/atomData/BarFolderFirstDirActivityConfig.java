package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class BarFolderFirstDirActivityConfig extends IntentConfig {
    public static final String ST_TYPE = "st_type";

    public BarFolderFirstDirActivityConfig(Context context, String str) {
        super(context);
        getIntent().putExtra("st_type", str);
    }
}
