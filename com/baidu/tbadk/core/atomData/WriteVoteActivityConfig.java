package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import java.io.Serializable;
/* loaded from: classes.dex */
public class WriteVoteActivityConfig extends IntentConfig {
    public static final String EXTRA_DATA_KEY = "extra_data";
    public static final String EXTRA_TITLE_KEY = "title";

    public WriteVoteActivityConfig(Context context, int i) {
        super(context);
        setRequestCode(i);
        setIntentAction(IntentAction.ActivityForResult);
    }

    public void setExtraData(Serializable serializable) {
        getIntent().putExtra(EXTRA_DATA_KEY, serializable);
    }

    public void setExtraTitle(String str) {
        getIntent().putExtra("title", str);
    }
}
