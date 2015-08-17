package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class PluginDownloadServiceConfig extends IntentConfig {
    public static final String BACKGROUND_DOWNLOAD = "background_download";
    public static final String DOWNLOAD_NAMES = "download_names";

    public PluginDownloadServiceConfig(Context context, boolean z, String[] strArr) {
        super(context);
        setIntentAction(IntentAction.StartService);
        getIntent().putExtra(BACKGROUND_DOWNLOAD, z);
        getIntent().putExtra(DOWNLOAD_NAMES, strArr);
    }
}
