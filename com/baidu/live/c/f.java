package com.baidu.live.c;

import android.content.Context;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.IntentAction;
import com.baidu.live.tbadk.core.frameworkdata.IntentConfig;
/* loaded from: classes2.dex */
public class f extends IntentConfig {
    public f(Context context) {
        super(context);
        setRequestCode(RequestResponseCode.REQUEST_ALA_FREE_GIFT_TASK);
        setIntentAction(IntentAction.ActivityForResult);
    }

    public void ak(boolean z) {
        getIntent().putExtra("is_from_flower_guide", z);
    }
}
