package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes3.dex */
public class MyGiftListActivityConfig extends IntentConfig {
    public static final int AccountTypeForum = 1;
    public static final int AccountTypeUser = 0;
    public static final String NAME_SHOW = "name_show";
    public static final String ST_TYPE = "st_type";
    public static final String USER_ID = "id";
    public static final String USER_NAME = "user_name";
    public static final String USER_SEX = "sex";
    public static final String USER_TPYE = "user_type";

    public MyGiftListActivityConfig(Context context, String str, String str2, String str3, int i) {
        super(context);
        getIntent().putExtra("id", str);
        getIntent().putExtra("sex", i);
        getIntent().putExtra("user_name", str2);
        getIntent().putExtra("name_show", str3);
    }

    public MyGiftListActivityConfig(Context context, String str, String str2, String str3, int i, int i2) {
        super(context);
        getIntent().putExtra("id", str);
        getIntent().putExtra("sex", i);
        getIntent().putExtra("user_name", str2);
        getIntent().putExtra("name_show", str3);
        getIntent().putExtra("user_type", i2);
    }

    public MyGiftListActivityConfig(Context context, String str, String str2, String str3, int i, String str4) {
        super(context);
        getIntent().putExtra("id", str);
        getIntent().putExtra("sex", i);
        getIntent().putExtra("st_type", str4);
        getIntent().putExtra("user_name", str2);
        getIntent().putExtra("name_show", str3);
    }
}
