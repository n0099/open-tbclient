package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class PersonInfoActivityConfig extends IntentConfig {
    public static final int REQUSET_CHANGE = 101;
    public static final String TAG_DATA = "data";
    public static boolean IS_SUPPORT_EDIT = true;
    public static boolean IS_HAVE_MYMARK = false;
    public static boolean IS_HAVE_ADDRESSLIST = false;

    public PersonInfoActivityConfig(Context context, String str, String str2) {
        super(context);
        getIntent().putExtra("user_id", str);
        getIntent().putExtra("user_name", str2);
    }

    public PersonInfoActivityConfig(Context context, String str, String str2, String str3) {
        super(context);
        getIntent().putExtra("user_id", str);
        getIntent().putExtra("user_name", str2);
        getIntent().putExtra("from", str3);
    }

    public PersonInfoActivityConfig(Context context, String str, String str2, String str3, String str4) {
        super(context);
        getIntent().putExtra("user_id", str);
        getIntent().putExtra("user_name", str2);
        getIntent().putExtra("from", str3);
        getIntent().putExtra("st_type", str4);
    }
}
