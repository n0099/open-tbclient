package com.baidu.live.b;

import android.content.Context;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.IntentAction;
import com.baidu.live.tbadk.core.frameworkdata.IntentConfig;
/* loaded from: classes6.dex */
public class d extends IntentConfig {
    public d(Context context) {
        super(context);
        setRequestCode(RequestResponseCode.REQUEST_ALA_FREE_GIFT_TASK);
        setIntentAction(IntentAction.ActivityForResult);
    }

    public void ab(boolean z) {
        getIntent().putExtra("is_from_flower_guide", z);
    }
}
