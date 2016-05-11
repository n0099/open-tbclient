package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class ThActivityDetailActivityConfig extends IntentConfig {
    public static final String ALBUM = "ALBUM";
    public static final String ALBUM_ID = "album_id";
    public static final String ALBUM_NAME = "album_name";
    public static final String END_TIME = "end_time";
    public static final String FROM = "FROM";
    public static final String JOIN_NUM = "num_signup";
    public static final String LOCATION = "location";
    public static final String START_TIME = "start_time";
    public static final String TH_FROM_BANNER = "FROM_BANNER";
    public static final String TH_FROM_CREATE = "FROM_CREATE";
    public static final String TH_FROM_ENTERFORUM = "FROM_ENTERFORUM";
    public static final String TH_FROM_FRS = "FROM_FRS";
    public static final String TH_FROM_H5 = "FROM_H5";
    public static final String TH_FROM_MAIN = "FROM_MAIN";
    public static final String TH_FROM_NOTICE = "FROM_NOTICE";
    public static final String TH_FROM_PB = "FROM_PB";

    public ThActivityDetailActivityConfig(Context context) {
        super(context);
        setIntentAction(IntentAction.Activity);
    }

    public void createActivityDetailConfig(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            getIntent().putExtra(ALBUM_ID, str);
        }
        if (!TextUtils.isEmpty(str2)) {
            getIntent().putExtra("FROM", str2);
        }
        setIntentAction(IntentAction.Activity);
    }

    public void createActivityDetailConfig(String str, String str2, int i, int i2, String str3, int i3, String str4) {
        if (!TextUtils.isEmpty(str)) {
            getIntent().putExtra(ALBUM_ID, str);
        }
        if (!TextUtils.isEmpty(str2)) {
            getIntent().putExtra(ALBUM_NAME, str2);
        }
        getIntent().putExtra(START_TIME, i);
        getIntent().putExtra(END_TIME, i2);
        getIntent().putExtra(LOCATION, str3);
        getIntent().putExtra(JOIN_NUM, i3);
        if (!TextUtils.isEmpty(str4)) {
            getIntent().putExtra("FROM", str4);
        }
        setIntentAction(IntentAction.Activity);
    }
}
