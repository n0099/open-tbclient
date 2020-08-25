package com.baidu.tbadk.core.atomData;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes2.dex */
public class FrsGoodActivityConfig extends IntentConfig {
    public FrsGoodActivityConfig(Context context) {
        super(context);
    }

    public FrsGoodActivityConfig createNormalCfg(String str, String str2) {
        return createBackSpecialCfg(str, str2, false, false);
    }

    public FrsGoodActivityConfig createBackSpecialCfg(String str, String str2, boolean z, boolean z2) {
        Intent intent = getIntent();
        Bundle bundle = new Bundle();
        bundle.putString("name", str);
        bundle.putString("from", str2);
        bundle.putBoolean("back_special", z);
        bundle.putBoolean(FrsActivityConfig.GOOD, z2);
        intent.putExtras(bundle);
        bundle.putLong("TibaStatic.StartTime", System.currentTimeMillis());
        if (!(getContext() instanceof Activity)) {
            intent.addFlags(268435456);
        }
        return this;
    }
}
