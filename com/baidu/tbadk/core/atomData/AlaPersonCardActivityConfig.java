package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class AlaPersonCardActivityConfig extends IntentConfig {
    public static final String PERSON_DESCRIPTION = "PERSON_DESCRIPTION";
    public static final String PERSON_FANS_COUNT = "PERSON_FANS_COUNT";
    public static final String PERSON_FOLLOWS_COUNT = "PERSON_FOLLOWS_COUNT";
    public static final String PERSON_FOLLOW_STATUS = "PERSON_FOLLOW_STATUS";
    public static final String PERSON_GROUP_ID = "PERSON_GROUP_ID";
    public static final String PERSON_LEVEL = "PERSON_LEVEL";
    public static final String PERSON_LIVE_ID = "PERSON_LIVE_ID";
    public static final String PERSON_LIVE_OWNER_FLAG = "PERSON_LIVE_OWNER_FLAG";
    public static final String PERSON_LIVE_OWNER_UID = "PERSON_LIVE_OWNER_UID";
    public static final String PERSON_LOCATION = "PERSON_LOCATION";
    public static final String PERSON_PORTRAIT_URL = "PERSON_PORTRAIT_URL";
    public static final String PERSON_SEND_COUNT = "PERSON_SEND_COUNT";
    public static final String PERSON_SEX = "PERSON_SEX";
    public static final String PERSON_USER_ID = "PERSON_USER_ID";
    public static final String PERSON_USER_NAME = "PERSON_USER_NAME";

    public AlaPersonCardActivityConfig(Context context, String str) {
        super(context);
        getIntent().putExtra(PERSON_USER_ID, str);
        setIntentAction(IntentAction.Activity);
    }

    public AlaPersonCardActivityConfig(Context context, String str, String str2, String str3, int i, int i2, String str4, String str5, int i3, long j, long j2, int i4, String str6, String str7, boolean z, String str8) {
        super(context);
        getIntent().putExtra(PERSON_USER_ID, str);
        getIntent().putExtra(PERSON_USER_NAME, str2);
        getIntent().putExtra(PERSON_PORTRAIT_URL, str3);
        getIntent().putExtra(PERSON_SEX, i);
        getIntent().putExtra(PERSON_LEVEL, i2);
        getIntent().putExtra(PERSON_LOCATION, str4);
        getIntent().putExtra(PERSON_DESCRIPTION, str5);
        getIntent().putExtra(PERSON_SEND_COUNT, i3);
        getIntent().putExtra(PERSON_FANS_COUNT, j);
        getIntent().putExtra(PERSON_FOLLOWS_COUNT, j2);
        getIntent().putExtra(PERSON_FOLLOW_STATUS, i4);
        getIntent().putExtra(PERSON_GROUP_ID, str6);
        getIntent().putExtra(PERSON_LIVE_ID, str7);
        getIntent().putExtra(PERSON_LIVE_OWNER_FLAG, z);
        getIntent().putExtra(PERSON_LIVE_OWNER_UID, str8);
        setRequestCode(25014);
        setIntentAction(IntentAction.ActivityForResult);
    }

    public AlaPersonCardActivityConfig(Context context, String str, String str2, String str3, int i, int i2, String str4, String str5, int i3, long j, long j2, int i4) {
        super(context);
        getIntent().putExtra(PERSON_USER_ID, str);
        getIntent().putExtra(PERSON_USER_NAME, str2);
        getIntent().putExtra(PERSON_PORTRAIT_URL, str3);
        getIntent().putExtra(PERSON_SEX, i);
        getIntent().putExtra(PERSON_LEVEL, i2);
        getIntent().putExtra(PERSON_LOCATION, str4);
        getIntent().putExtra(PERSON_DESCRIPTION, str5);
        getIntent().putExtra(PERSON_SEND_COUNT, i3);
        getIntent().putExtra(PERSON_FANS_COUNT, j);
        getIntent().putExtra(PERSON_FOLLOWS_COUNT, j2);
        getIntent().putExtra(PERSON_FOLLOW_STATUS, i4);
        setRequestCode(25014);
        setIntentAction(IntentAction.ActivityForResult);
    }
}
