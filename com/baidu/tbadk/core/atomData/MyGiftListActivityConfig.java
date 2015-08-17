package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class MyGiftListActivityConfig extends IntentConfig {
    public static final String ST_TYPE = "st_type";
    public static final String USER_ID = "id";
    public static final String USER_SEX = "sex";

    public MyGiftListActivityConfig(Context context, String str, int i) {
        super(context);
        getIntent().putExtra("id", str);
        getIntent().putExtra(USER_SEX, i);
    }

    public MyGiftListActivityConfig(Context context, String str, int i, String str2) {
        super(context);
        getIntent().putExtra("id", str);
        getIntent().putExtra(USER_SEX, i);
        getIntent().putExtra("st_type", str2);
    }
}
