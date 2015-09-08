package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class PhotoLiveHeadlineRulesActivityConfig extends IntentConfig {
    public PhotoLiveHeadlineRulesActivityConfig(Context context) {
        super(context);
    }

    public PhotoLiveHeadlineRulesActivityConfig createConfig(ArrayList<String> arrayList) {
        getIntent().putStringArrayListExtra(IntentConfig.DATAS, arrayList);
        return this;
    }
}
