package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class BuyGiftActivityConfig extends IntentConfig {
    public static final String FROM = "from";
    public static final int FROM_PERSON_CENTER = 1;
    public static final int FROM_PERSON_CHAT = 2;
    public static final int FROM_PHOTO_LIVE = 3;
    public static final String GIFT_RECEIVER_ID = "gift_receiver_id";

    public BuyGiftActivityConfig(Context context, long j) {
        this(context, j, 1);
    }

    public BuyGiftActivityConfig(Context context, long j, int i) {
        super(context);
        getIntent().putExtra(GIFT_RECEIVER_ID, j);
        getIntent().putExtra("from", i);
    }
}
