package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class EmotionDetailActivityConfig extends IntentConfig {
    public static final String EMOTION_PCK_ID_KEY = "pck_id";
    public static final String EMOTION_PIC_ID_KEY = "pic_id";

    public EmotionDetailActivityConfig(Context context, int i, long j) {
        super(context);
        Intent intent = getIntent();
        intent.putExtra("pck_id", i);
        intent.putExtra(EMOTION_PIC_ID_KEY, j);
    }

    public EmotionDetailActivityConfig(Context context, int i, long j, int i2) {
        super(context);
        Intent intent = getIntent();
        setRequestCode(i2);
        intent.putExtra("pck_id", i);
        intent.putExtra(EMOTION_PIC_ID_KEY, j);
        setIntentAction(IntentAction.ActivityForResult);
    }
}
