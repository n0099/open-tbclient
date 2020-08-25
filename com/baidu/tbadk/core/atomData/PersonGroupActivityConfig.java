package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes2.dex */
public class PersonGroupActivityConfig extends IntentConfig {
    public static final int FROM_ADDRESSLIST = 1;
    public static final int FROM_GAME_VEBVIEW = 2;
    public static final int FROM_OTHER = 0;
    public static final String KEY_CURRENT_TAB = "key_current_tab";
    public static final String KEY_FROME_WHERE = "key_from_where";
    public static final String KEY_SEX = "key_sex";
    public static final String KEY_UID = "key_uid";
    public static final String REQUEST_CODE = "tb_request_code";

    public PersonGroupActivityConfig(Context context, String str, int i) {
        super(context);
        Intent intent = getIntent();
        intent.putExtra("key_uid", str);
        intent.putExtra("key_sex", i);
    }

    public PersonGroupActivityConfig(Context context, String str, int i, int i2) {
        super(context);
        Intent intent = getIntent();
        intent.putExtra("key_uid", str);
        intent.putExtra("key_sex", i);
        intent.putExtra("key_current_tab", i2);
    }

    public PersonGroupActivityConfig(Context context, int i, int i2) {
        super(context);
        Intent intent = getIntent();
        intent.putExtra("key_uid", TbadkCoreApplication.getCurrentAccount());
        intent.putExtra("key_sex", 0);
        intent.putExtra("key_from_where", i2);
        intent.putExtra("tb_request_code", i);
        setIntentAction(IntentAction.ActivityForResult);
        setRequestCode(i);
    }

    public PersonGroupActivityConfig(Context context, int i, int i2, int i3) {
        super(context);
        Intent intent = getIntent();
        intent.putExtra("key_uid", TbadkCoreApplication.getCurrentAccount());
        intent.putExtra("key_sex", i);
        intent.putExtra("key_from_where", i3);
        intent.putExtra("tb_request_code", i2);
        setIntentAction(IntentAction.ActivityForResult);
        setRequestCode(i2);
    }

    public PersonGroupActivityConfig(Context context, int i) {
        super(context);
        Intent intent = getIntent();
        intent.putExtra("key_uid", TbadkCoreApplication.getCurrentAccount());
        intent.putExtra("key_sex", 0);
        intent.putExtra("tb_request_code", i);
        setIntentAction(IntentAction.ActivityForResult);
        setRequestCode(i);
    }
}
