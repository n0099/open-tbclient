package com.baidu.live.tbadk.core.atomdata;

import android.content.Context;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.IntentAction;
import com.baidu.live.tbadk.core.frameworkdata.IntentConfig;
/* loaded from: classes2.dex */
public class AlaPersonCardActivityConfig extends IntentConfig {
    public static final String PERSON_APP_ID = "PERSON_APP_ID";
    public static final String PERSON_DESCRIPTION = "PERSON_DESCRIPTION";
    public static final String PERSON_FANS_COUNT = "PERSON_FANS_COUNT";
    public static final String PERSON_FOLLOWS_COUNT = "PERSON_FOLLOWS_COUNT";
    public static final String PERSON_FOLLOW_STATUS = "PERSON_FOLLOW_STATUS";
    public static final String PERSON_GROUP_ID = "PERSON_GROUP_ID";
    public static final String PERSON_IS_FROM_GUARD_CLUB = "PERSON_IS_FROM_GUARD_CLUB";
    public static final String PERSON_LEVEL = "PERSON_LEVEL";
    public static final String PERSON_LIVE_ID = "PERSON_LIVE_ID";
    public static final String PERSON_LIVE_OWNER_FLAG = "PERSON_LIVE_OWNER_FLAG";
    public static final String PERSON_LIVE_OWNER_UID = "PERSON_LIVE_OWNER_UID";
    public static final String PERSON_LOCATION = "PERSON_LOCATION";
    public static final String PERSON_PORTRAIT_URL = "PERSON_PORTRAIT_URL";
    public static final String PERSON_SEND_COUNT = "PERSON_SEND_COUNT";
    public static final String PERSON_SEX = "PERSON_SEX";
    public static final String PERSON_SHOW_NAME = "PERSON_SHOW_NAME";
    public static final String PERSON_USER_ID = "PERSON_USER_ID";
    public static final String PERSON_USER_NAME = "PERSON_USER_NAME";

    public AlaPersonCardActivityConfig(Context context, String str) {
        super(context);
        getIntent().putExtra("PERSON_USER_ID", str);
        setIntentAction(IntentAction.Activity);
    }

    public AlaPersonCardActivityConfig(Context context, String str, String str2, String str3, int i, int i2, String str4, String str5, long j, long j2, long j3, int i3, String str6, String str7, boolean z, String str8, String str9, String str10, String str11) {
        this(context, str, str2, str3, i, i2, str4, str5, j, j2, j3, i3, str6, str7, z, str8, str9, str10, str11, false);
    }

    public AlaPersonCardActivityConfig(Context context, String str, String str2, String str3, int i, int i2, String str4, String str5, long j, long j2, long j3, int i3, String str6, String str7, boolean z, String str8, String str9, String str10, String str11, boolean z2) {
        super(context);
        getIntent().putExtra("PERSON_USER_ID", str);
        getIntent().putExtra("PERSON_USER_NAME", str2);
        getIntent().putExtra("PERSON_SEX", i);
        getIntent().putExtra("PERSON_LEVEL", i2);
        getIntent().putExtra("PERSON_LOCATION", str4);
        getIntent().putExtra("PERSON_DESCRIPTION", str5);
        getIntent().putExtra("PERSON_SEND_COUNT", j);
        getIntent().putExtra("PERSON_FANS_COUNT", -1L);
        getIntent().putExtra("PERSON_FOLLOWS_COUNT", -1L);
        getIntent().putExtra("PERSON_FOLLOW_STATUS", i3);
        getIntent().putExtra("PERSON_GROUP_ID", str6);
        getIntent().putExtra("PERSON_LIVE_ID", str7);
        getIntent().putExtra("PERSON_LIVE_OWNER_FLAG", z);
        getIntent().putExtra("PERSON_LIVE_OWNER_UID", str8);
        getIntent().putExtra("PERSON_APP_ID", str9);
        getIntent().putExtra(PERSON_SHOW_NAME, str10);
        getIntent().putExtra(PERSON_IS_FROM_GUARD_CLUB, z2);
        getIntent().putExtra("other_params", str11);
        setRequestCode(RequestResponseCode.REQUEST_ALA_PERSON_CARD);
        setIntentAction(IntentAction.ActivityForResult);
    }

    public AlaPersonCardActivityConfig(Context context, String str, String str2, String str3, int i, int i2, String str4, String str5, long j, long j2, long j3, int i3, String str6, String str7, boolean z, String str8, String str9, String str10) {
        super(context);
        getIntent().putExtra("PERSON_USER_ID", str);
        getIntent().putExtra("PERSON_USER_NAME", str2);
        getIntent().putExtra("PERSON_SEX", i);
        getIntent().putExtra("PERSON_LEVEL", i2);
        getIntent().putExtra("PERSON_LOCATION", str4);
        getIntent().putExtra("PERSON_DESCRIPTION", str5);
        getIntent().putExtra("PERSON_SEND_COUNT", j);
        getIntent().putExtra("PERSON_FANS_COUNT", -1L);
        getIntent().putExtra("PERSON_FOLLOWS_COUNT", -1L);
        getIntent().putExtra("PERSON_FOLLOW_STATUS", i3);
        getIntent().putExtra("PERSON_GROUP_ID", str6);
        getIntent().putExtra("PERSON_LIVE_ID", str7);
        getIntent().putExtra("PERSON_LIVE_OWNER_FLAG", z);
        getIntent().putExtra("PERSON_LIVE_OWNER_UID", str8);
        getIntent().putExtra("PERSON_APP_ID", str9);
        getIntent().putExtra(PERSON_SHOW_NAME, str10);
        setRequestCode(RequestResponseCode.REQUEST_ALA_PERSON_CARD);
        setIntentAction(IntentAction.ActivityForResult);
    }
}
