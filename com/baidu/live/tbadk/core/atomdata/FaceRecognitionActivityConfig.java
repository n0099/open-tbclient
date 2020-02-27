package com.baidu.live.tbadk.core.atomdata;

import android.content.Context;
import com.baidu.live.tbadk.core.frameworkdata.IntentAction;
import com.baidu.live.tbadk.core.frameworkdata.IntentConfig;
/* loaded from: classes3.dex */
public class FaceRecognitionActivityConfig extends IntentConfig {
    public static final String RETRY = "retry";
    public static final String UID = "uid";

    public FaceRecognitionActivityConfig(Context context, String str) {
        super(context);
        getIntent().putExtra("uid", str);
    }

    public FaceRecognitionActivityConfig(Context context, int i, String str) {
        super(context);
        getIntent().putExtra("uid", str);
        setRequestCode(i);
        setIntentAction(IntentAction.ActivityForResult);
    }

    public void setRetryTag(String str) {
        getIntent().putExtra("retry", str);
    }
}
