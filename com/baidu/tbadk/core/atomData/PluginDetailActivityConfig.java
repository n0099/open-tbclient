package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.c;
/* loaded from: classes.dex */
public class PluginDetailActivityConfig extends c {
    public static final String PLUGIN_NAME = "name";

    public PluginDetailActivityConfig(Context context, String str) {
        super(context);
        getIntent().putExtra("name", str);
    }

    public PluginDetailActivityConfig(Context context, String str, int i) {
        this(context, str);
        setIntentAction(IntentAction.ActivityForResult);
        setRequestCode(i);
    }
}
