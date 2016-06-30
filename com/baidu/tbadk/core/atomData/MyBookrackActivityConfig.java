package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class MyBookrackActivityConfig extends IntentConfig {
    public static final String TAB_ID = "tab_id";
    public static final int TAB_MY_DOWNLOAD = 1;
    public static final int TAB_MY_FOLLOW = 0;

    public MyBookrackActivityConfig(Context context, int i) {
        super(context);
        getIntent().putExtra(TAB_ID, i);
    }
}
