package com.baidu.live.tbadk.core.atomdata;

import android.content.Context;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.IntentAction;
import com.baidu.live.tbadk.core.frameworkdata.IntentConfig;
/* loaded from: classes11.dex */
public class YuyinBannedPostActivityConfig extends IntentConfig {
    public static final String GROUP_ID = "group_id";
    public static final String LIVE_ID = "live_id";
    public static final String ROOM_ID = "room_id";

    public YuyinBannedPostActivityConfig(Context context, String str, String str2, String str3) {
        super(context);
        getIntent().putExtra("room_id", str);
        getIntent().putExtra("live_id", str2);
        getIntent().putExtra("group_id", str3);
        setRequestCode(RequestResponseCode.REQUEST_ALA_PERSON_CHARM_CARD);
        setIntentAction(IntentAction.ActivityForResult);
    }
}
