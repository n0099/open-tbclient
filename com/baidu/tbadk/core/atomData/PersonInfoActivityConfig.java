package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.a;
/* loaded from: classes.dex */
public class PersonInfoActivityConfig extends a {
    public static final int REQUSET_CHANGE = 101;
    public static final String TAG_DATA = "data";

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
