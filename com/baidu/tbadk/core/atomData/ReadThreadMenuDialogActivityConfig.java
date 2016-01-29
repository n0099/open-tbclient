package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class ReadThreadMenuDialogActivityConfig extends IntentConfig {
    public static final String OPTION_LIST = "option_list";

    public ReadThreadMenuDialogActivityConfig(Context context) {
        super(context);
    }

    public ReadThreadMenuDialogActivityConfig(Context context, String[] strArr) {
        super(context);
        getIntent().putExtra(OPTION_LIST, strArr);
    }
}
