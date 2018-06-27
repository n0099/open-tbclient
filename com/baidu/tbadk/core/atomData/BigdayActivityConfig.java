package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class BigdayActivityConfig extends IntentConfig {
    public static final String BIGDAY_ID = "bigday_id";
    public static final String IMG_URL = "img_url";
    public static final String JUMP_URL = "jump_url";

    public BigdayActivityConfig(Context context, String str, String str2, long j) {
        super(context);
        Intent intent = getIntent();
        intent.putExtra(IMG_URL, str);
        intent.putExtra(JUMP_URL, str2);
        intent.putExtra(BIGDAY_ID, j);
    }
}
