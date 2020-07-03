package com.baidu.live.c;

import android.content.Context;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.IntentAction;
import com.baidu.live.tbadk.core.frameworkdata.IntentConfig;
/* loaded from: classes3.dex */
public class g extends IntentConfig {
    public g(Context context) {
        super(context);
        setRequestCode(RequestResponseCode.REQUEST_ALA_FREE_GIFT_TASK);
        setIntentAction(IntentAction.ActivityForResult);
    }

    public void aN(boolean z) {
        getIntent().putExtra("is_from_flower_guide", z);
    }
}
