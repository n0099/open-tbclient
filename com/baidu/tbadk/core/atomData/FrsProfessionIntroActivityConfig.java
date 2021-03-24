package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes3.dex */
public class FrsProfessionIntroActivityConfig extends IntentConfig {
    public static final String KEY_DARK_DARK_COLOR = "key_dark_dark_color";
    public static final String KEY_DARK_LIGHT_COLOR = "key_dark_light_color";
    public static final String KEY_DAY_DARK_COLOR = "key_day_dark_color";
    public static final String KEY_DAY_LIGHT_COLOR = "key_day_light_color";
    public static final String KEY_NIGHT_DARK_COLOR = "key_night_dark_color";
    public static final String KEY_NIGHT_LIGHT_COLOR = "key_night_light_color";
    public static final String KEY_PATTEN_BACKGROUND = "key_patten_background";
    public static final String KEY_RESULT = "key_result";

    public FrsProfessionIntroActivityConfig(Context context) {
        super(context);
        setRequestCode(25041);
        setIntentAction(IntentAction.ActivityForResult);
    }

    public void putColor(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        getIntent().putExtra(KEY_PATTEN_BACKGROUND, str);
        getIntent().putExtra(KEY_DAY_LIGHT_COLOR, str2);
        getIntent().putExtra(KEY_DAY_DARK_COLOR, str3);
        getIntent().putExtra(KEY_NIGHT_LIGHT_COLOR, str4);
        getIntent().putExtra(KEY_NIGHT_DARK_COLOR, str5);
        getIntent().putExtra(KEY_DARK_LIGHT_COLOR, str6);
        getIntent().putExtra(KEY_DARK_DARK_COLOR, str7);
    }
}
