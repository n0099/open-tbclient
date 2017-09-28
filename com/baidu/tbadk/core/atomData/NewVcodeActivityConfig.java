package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.adp.lib.g.b;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* loaded from: classes.dex */
public class NewVcodeActivityConfig extends IntentConfig {
    public static final String IS_AD = "is_ad";
    public static final String NEED_FEED_BACK_BUTTON = "need_feed_back_button";
    public static final String PAGE_TYPE = "page_type";
    public static final String SAVE_KEY = "model";

    public NewVcodeActivityConfig(Context context, int i, WriteData writeData, boolean z, String str) {
        super(context);
        setRequestCode(i);
        setIntentAction(IntentAction.ActivityForResult);
        if (writeData != null) {
            getIntent().putExtra("model", writeData);
            getIntent().putExtra("is_ad", z);
            getIntent().putExtra("page_type", b.g(str, 0));
        }
    }

    public void setHideFeedBackButton() {
        if (getIntent() != null) {
            getIntent().putExtra(NEED_FEED_BACK_BUTTON, false);
        }
    }
}
