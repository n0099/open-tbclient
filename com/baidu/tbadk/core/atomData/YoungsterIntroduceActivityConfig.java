package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes3.dex */
public class YoungsterIntroduceActivityConfig extends IntentConfig {
    public YoungsterIntroduceActivityConfig(Context context) {
        super(context);
    }

    public void setKeyYoungsterPasswordFrom(int i2) {
        getIntent().putExtra(YoungsterPasswordActivityConfig.KEY_YOUNGSTER_PASSWORD_FROM, i2);
    }
}
