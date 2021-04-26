package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tieba.face.data.EmotionImageData;
/* loaded from: classes3.dex */
public class EmotionEditActivityConfig extends IntentConfig {
    public static final String EMOTION_DATA = "EmotionImageData";
    public static final String EMOTION_IS_GIF = "EmotionIsGif";
    public static final String FROM_PB_BOTTOM = "from_pb_bottom";
    public static final String FROM_PB_SEARCH = "from_pb_search";

    public EmotionEditActivityConfig(Context context, int i2, EmotionImageData emotionImageData, boolean z, String str) {
        super(context);
        setRequestCode(i2);
        getIntent().putExtra(EMOTION_DATA, emotionImageData);
        getIntent().putExtra(EMOTION_IS_GIF, z);
        getIntent().putExtra("from", str);
        setIntentAction(IntentAction.ActivityForResult);
    }
}
