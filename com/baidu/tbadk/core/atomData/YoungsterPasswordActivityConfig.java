package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class YoungsterPasswordActivityConfig extends IntentConfig {
    public static final String KEY_YOUNGSTER_PASSWORD_FROM = "key_youngster_password_from";
    public static final String KEY_YOUNGSTER_PASSWORD_INPUT = "key_youngster_password_input";
    public static final String KEY_YOUNGSTER_PASSWORD_PAGE_TYPE = "key_youngster_password_page_type";
    public static final int YOUNGSTER_PASSWORD_FROM_FRS = 1;
    public static final int YOUNGSTER_PASSWORD_FROM_HOMEPAGE = 3;
    public static final int YOUNGSTER_PASSWORD_FROM_SETTING = 2;

    public YoungsterPasswordActivityConfig(Context context) {
        super(context);
    }

    public void setYoungsterPasswordPageType(int i) {
        getIntent().putExtra(KEY_YOUNGSTER_PASSWORD_PAGE_TYPE, i);
    }

    public void setKeyYoungsterPasswordInput(String str) {
        getIntent().putExtra(KEY_YOUNGSTER_PASSWORD_INPUT, str);
    }

    public void setKeyYoungsterPasswordFrom(int i) {
        getIntent().putExtra(KEY_YOUNGSTER_PASSWORD_FROM, i);
    }
}
