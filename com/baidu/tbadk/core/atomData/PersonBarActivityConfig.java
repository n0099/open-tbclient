package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes3.dex */
public class PersonBarActivityConfig extends IntentConfig {
    public static final String BAR_ID = "bar_id";
    public static final String BAR_NAME = "bar_name";
    public static final String IS_CHOOSE_BAR_MODE = "is_choose_bar_mode";
    public static final String KEY_CURRENT_TAB = "key_current_tab";
    public static final String KEY_SEX = "key_sex";
    public static final String KEY_UID = "key_uid";
    public static final String LIKE_BARS_COUNT = "like_bars_count";
    public static final String REQUEST_CODE = "tb_request_code";

    public PersonBarActivityConfig(Context context, String str, int i2) {
        super(context);
        Intent intent = getIntent();
        intent.putExtra("key_uid", str);
        intent.putExtra("key_sex", i2);
    }

    public PersonBarActivityConfig(Context context, int i2, String str, int i3) {
        super(context);
        Intent intent = getIntent();
        intent.putExtra("key_uid", str);
        intent.putExtra("key_sex", i3);
        intent.putExtra(LIKE_BARS_COUNT, i2);
    }

    public PersonBarActivityConfig(Context context, String str, int i2, int i3) {
        super(context);
        Intent intent = getIntent();
        intent.putExtra("key_uid", str);
        intent.putExtra("key_sex", i2);
        intent.putExtra("key_current_tab", i3);
    }

    public PersonBarActivityConfig(Context context, String str, int i2, boolean z, int i3) {
        super(context);
        Intent intent = getIntent();
        intent.putExtra("key_uid", str);
        intent.putExtra("key_sex", i2);
        intent.putExtra(IS_CHOOSE_BAR_MODE, z);
        intent.putExtra("tb_request_code", i3);
        setIntentAction(IntentAction.ActivityForResult);
        setRequestCode(i3);
    }

    public PersonBarActivityConfig(Context context, String str, int i2, boolean z, int i3, String str2) {
        super(context);
        Intent intent = getIntent();
        intent.putExtra("key_uid", str);
        intent.putExtra("key_sex", i2);
        intent.putExtra(IS_CHOOSE_BAR_MODE, z);
        intent.putExtra("tb_request_code", i3);
        intent.putExtra(BAR_ID, str2);
        setIntentAction(IntentAction.ActivityForResult);
        setRequestCode(i3);
    }
}
