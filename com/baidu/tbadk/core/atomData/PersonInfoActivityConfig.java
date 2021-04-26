package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes3.dex */
public class PersonInfoActivityConfig extends IntentConfig {
    public static final String FANS_NUM = "fans_num";
    public static final int REQUSET_CHANGE = 101;
    public static final String TAG_DATA = "data";

    public PersonInfoActivityConfig(Context context, String str, String str2) {
        super(context);
        getIntent().putExtra("user_id", str);
        getIntent().putExtra("user_name", str2);
    }

    public void setSourceTid(String str) {
        getIntent().putExtra("thread_id", str);
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
        getIntent().putExtra("thread_id", str4);
    }

    public PersonInfoActivityConfig(Context context, String str, String str2, String str3, String str4, String str5, String str6) {
        super(context);
        getIntent().putExtra("user_id", str);
        getIntent().putExtra("user_name", str2);
        getIntent().putExtra("from", str3);
        getIntent().putExtra("st_type", str4);
        getIntent().putExtra("thread_id", str5);
        getIntent().putExtra("nid", str6);
    }

    public PersonInfoActivityConfig(Context context, String str, String str2, int i2) {
        super(context);
        getIntent().putExtra("user_id", str);
        getIntent().putExtra("user_name", str2);
        getIntent().putExtra(FANS_NUM, i2);
    }
}
