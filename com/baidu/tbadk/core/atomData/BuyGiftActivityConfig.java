package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.a;
/* loaded from: classes.dex */
public class BuyGiftActivityConfig extends a {
    public static final String GIFT_RECEIVER_ID = "gift_receiver_id";

    public BuyGiftActivityConfig(Context context, long j) {
        super(context);
        getIntent().putExtra(GIFT_RECEIVER_ID, j);
    }
}
