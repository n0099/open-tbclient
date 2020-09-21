package com.baidu.live.tbadk.core.atomdata;

import android.content.Context;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.IntentAction;
import com.baidu.live.tbadk.core.frameworkdata.IntentConfig;
/* loaded from: classes4.dex */
public class AlaCharmCardActivityConfig extends IntentConfig {
    public static final String CHARM_VALUE = "charm_value";
    public static final String FLOWER_VALUE = "flower_value";
    public static final String GROUP_ID = "group_id";
    public static final String LIVE_ID = "live_id";
    public static final String LIVE_OWNER_FLAG = "live_owner_flag";
    public static final String LIVE_OWNER_UID = "live_owner_uid";
    public static final String LOGINUSER_PORTRAIT = "login_user_portrait";
    public static final String LOGIN_USER_ID = "login_user_id";
    public static final String LOGIN_USER_NAME = "login_user_name";
    public static final String NEED_SHOW_GIFT_PANEL = "need_show_gift_panel";
    public static final String ONLINE_COUNT = "online_count";
    public static final String USER_ID = "user_id";
    public static final String USER_NAME = "user_name";

    public AlaCharmCardActivityConfig(Context context, String str, String str2, String str3, String str4, String str5, boolean z, String str6, String str7, String str8, String str9, long j, String str10) {
        super(context);
        getIntent().putExtra("user_name", str);
        getIntent().putExtra("user_id", str2);
        getIntent().putExtra("charm_value", str3);
        getIntent().putExtra("group_id", str4);
        getIntent().putExtra("live_id", str5);
        getIntent().putExtra("live_owner_flag", z);
        getIntent().putExtra("live_owner_uid", str6);
        getIntent().putExtra("login_user_id", str7);
        getIntent().putExtra("login_user_name", str8);
        getIntent().putExtra("login_user_portrait", str9);
        getIntent().putExtra("online_count", j);
        getIntent().putExtra(IntentConfig.OTHER_PARAMS, str10);
        setRequestCode(RequestResponseCode.REQUEST_ALA_PERSON_CHARM_CARD);
        setIntentAction(IntentAction.ActivityForResult);
    }
}
