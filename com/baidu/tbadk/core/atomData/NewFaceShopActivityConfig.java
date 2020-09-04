package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class NewFaceShopActivityConfig extends IntentConfig {
    public static final String PARAM_URL = "url";

    public NewFaceShopActivityConfig(Context context, String str) {
        super(context);
        getIntent().putExtra("url", str);
    }
}
