package com.baidu.live.tbadk.core.atomdata;

import android.app.Activity;
import android.content.Context;
import com.baidu.live.tbadk.core.frameworkdata.IntentAction;
import com.baidu.live.tbadk.core.frameworkdata.IntentConfig;
/* loaded from: classes11.dex */
public class CommonWebViewActivityConfig extends IntentConfig {
    public static final String CERT_RETRY = "retry";
    public static final String TAG_TITLE = "tag_title";
    public static final String TAG_URL = "tag_url";

    public CommonWebViewActivityConfig(Context context, String str) {
        super(context);
        getIntent().putExtra("tag_url", str);
        if (!(getContext() instanceof Activity)) {
            getIntent().addFlags(268435456);
        }
    }

    public CommonWebViewActivityConfig(Context context, int i, String str) {
        super(context);
        getIntent().putExtra("tag_url", str);
        if (!(getContext() instanceof Activity)) {
            getIntent().addFlags(268435456);
            return;
        }
        setRequestCode(i);
        setIntentAction(IntentAction.ActivityForResult);
    }

    public void setCertRetryTag(String str) {
        getIntent().putExtra("retry", str);
    }
}
