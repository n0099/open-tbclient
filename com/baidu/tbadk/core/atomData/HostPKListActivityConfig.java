package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class HostPKListActivityConfig extends IntentConfig {
    public static final String HOST_LEVEL = "host_level";

    public HostPKListActivityConfig(Context context) {
        super(context);
    }

    public HostPKListActivityConfig create(int i) {
        getIntent().putExtra(HOST_LEVEL, i);
        return this;
    }
}
