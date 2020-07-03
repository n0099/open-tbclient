package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class MissonDetailsActivityConfig extends IntentConfig {
    public static final String ANTI_DATA = "anti_data";
    public static final String CURRENT_LEVEL = "current_level";
    public static final String FANS_NAME = "fans_name";
    public static final String FLOOR_NUM = "floor_num";
    public static final String FROM_PERSON = "from_person";
    public static final String FROM_PHOTO_LIVE = "from_photo_live";
    public static final String IS_MEMBER = "is_member";
    public static final String IS_UPGRADE_SUCCESS = "is_upgrade_success";
    public static final String THREAD_TITLE = "thread_title";

    public MissonDetailsActivityConfig(Context context, int i, int i2, String str, String str2, String str3, String str4, String str5, String str6, long j, int i3, int i4, AntiData antiData, String str7) {
        super(context);
        setRequestCode(i);
        setIntentAction(IntentAction.ActivityForResult);
        getIntent().putExtra("current_level", i2);
        getIntent().putExtra("portrait", str);
        getIntent().putExtra("user_name", str2);
        getIntent().putExtra("from", str3);
        getIntent().putExtra("thread_id", str4);
        getIntent().putExtra(THREAD_TITLE, str5);
        getIntent().putExtra("forum_name", str6);
        getIntent().putExtra("forum_id", j);
        getIntent().putExtra("floor_num", i3);
        getIntent().putExtra(IS_MEMBER, i4);
        getIntent().putExtra("anti_data", antiData);
        getIntent().putExtra(FANS_NAME, str7);
    }

    public MissonDetailsActivityConfig(Context context, int i, int i2, String str, String str2, String str3, String str4, String str5, String str6) {
        this(context, i, i2, str, str2, str3, str4, str5, str6, 0L, 0, 0, null, null);
    }

    public MissonDetailsActivityConfig(Context context, int i, int i2, String str, String str2, String str3) {
        this(context, i, i2, str, str2, str3, null, null, null, 0L, 0, 0, null, null);
    }
}
