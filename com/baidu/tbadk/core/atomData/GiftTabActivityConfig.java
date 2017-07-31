package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class GiftTabActivityConfig extends IntentConfig {
    public static final String ACCOUNT_TYPE = "account_type";
    public static final String FROM = "from";
    public static final String FROM_LIVE_ROOM = "android_live_room";
    public static final String FROM_PB = "android_pb";
    public static final String FROM_PERSON_CENTER = "android_person_center";
    public static final String FROM_PERSON_CHAT = "android_person_chat";
    public static final String FROM_PHOTO_LIVE = "android_photo_live";
    public static final String GIFT_POST_ID = "gift_post_id";
    public static final String GIFT_RECEIVER_ID = "gift_receiver_id";
    public static final String GIFT_RECEIVER_NAME = "gift_receiver_name";
    public static final String GIFT_RECEIVER_NAME_SHOW = "gift_receiver_name_show";
    public static final String GIFT_THREAD_ID = "gift_thread_id";

    public GiftTabActivityConfig(Context context, long j, String str, String str2) {
        this(context, j, str, str2, FROM_PERSON_CENTER);
    }

    public GiftTabActivityConfig(Context context, long j, String str, String str2, String str3) {
        super(context);
        getIntent().putExtra("gift_receiver_id", j);
        getIntent().putExtra(GIFT_RECEIVER_NAME, str);
        getIntent().putExtra(GIFT_RECEIVER_NAME_SHOW, str2);
        getIntent().putExtra("from", str3);
    }

    public GiftTabActivityConfig(Context context, long j, String str, String str2, String str3, int i) {
        super(context);
        setIntentAction(IntentAction.ActivityForResult);
        setRequestCode(i);
        getIntent().putExtra("gift_receiver_id", j);
        getIntent().putExtra(GIFT_RECEIVER_NAME, str);
        getIntent().putExtra(GIFT_RECEIVER_NAME_SHOW, str2);
        getIntent().putExtra("from", str3);
    }

    public GiftTabActivityConfig(Context context, long j, String str, String str2, String str3, long j2, long j3) {
        super(context);
        getIntent().putExtra("gift_receiver_id", j);
        getIntent().putExtra(GIFT_RECEIVER_NAME, str);
        getIntent().putExtra(GIFT_RECEIVER_NAME_SHOW, str2);
        getIntent().putExtra("from", str3);
        getIntent().putExtra(GIFT_THREAD_ID, j2);
        getIntent().putExtra(GIFT_POST_ID, j3);
    }
}
