package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class PbSearchEmotionActivityConfig extends IntentConfig {
    public static final String TOP_WORDS = "top_words";

    public PbSearchEmotionActivityConfig(Context context, int i, ArrayList<String> arrayList) {
        super(context);
        setIntentAction(IntentAction.ActivityForResult);
        setRequestCode(i);
        getIntent().putStringArrayListExtra(TOP_WORDS, arrayList);
    }
}
