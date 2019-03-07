package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.plugins.c;
/* loaded from: classes.dex */
public class QRCodeScanActivityConfig extends IntentConfig {
    public QRCodeScanActivityConfig(Context context) {
        super(context);
    }

    @Override // com.baidu.tbadk.core.frameworkData.IntentConfig
    public boolean isValid() {
        if (c.ay(getContext(), "com.baidu.tieba.pluginExtend")) {
            return super.isValid();
        }
        return false;
    }
}
