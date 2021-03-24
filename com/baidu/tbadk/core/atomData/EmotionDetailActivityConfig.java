package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes3.dex */
public class EmotionDetailActivityConfig extends IntentConfig {
    public static final String EMOTION_FROM_PACKAGE = "from_package";
    public static final String EMOTION_IS_GIF_KEY = "is_gif";
    public static final String EMOTION_PCK_ID_KEY = "pck_id";
    public static final String EMOTION_PIC_ID_KEY = "pic_id";

    public EmotionDetailActivityConfig(Context context, int i, long j, boolean z) {
        super(context);
        Intent intent = getIntent();
        intent.putExtra("pck_id", i);
        intent.putExtra(EMOTION_PIC_ID_KEY, j);
        intent.putExtra(EMOTION_IS_GIF_KEY, z);
    }

    public EmotionDetailActivityConfig setFromEmotionPackage(boolean z) {
        getIntent().putExtra(EMOTION_FROM_PACKAGE, z);
        return this;
    }

    public EmotionDetailActivityConfig(Context context, int i, long j, int i2, boolean z) {
        super(context);
        Intent intent = getIntent();
        setRequestCode(i2);
        intent.putExtra("pck_id", i);
        intent.putExtra(EMOTION_PIC_ID_KEY, j);
        intent.putExtra(EMOTION_IS_GIF_KEY, z);
        setIntentAction(IntentAction.ActivityForResult);
    }
}
