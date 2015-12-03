package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class MyGiftListActivityConfig extends IntentConfig {
    public static final String ST_TYPE = "st_type";
    public static final String USER_ID = "id";
    public static final String USER_NAME = "user_name";
    public static final String USER_SEX = "sex";

    public MyGiftListActivityConfig(Context context, String str, String str2, int i) {
        super(context);
        getIntent().putExtra("id", str);
        getIntent().putExtra(USER_SEX, i);
        getIntent().putExtra("user_name", str2);
    }

    public MyGiftListActivityConfig(Context context, String str, String str2, int i, String str3) {
        super(context);
        getIntent().putExtra("id", str);
        getIntent().putExtra(USER_SEX, i);
        getIntent().putExtra("st_type", str3);
        getIntent().putExtra("user_name", str2);
    }
}
