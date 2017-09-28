package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class CardBoxMemberPayActivityConfig extends IntentConfig {
    public static final String PACKET_ID = "packet_id";

    public CardBoxMemberPayActivityConfig(Context context, String str, String str2, String str3) {
        super(context);
        getIntent().putExtra(PACKET_ID, str);
        getIntent().putExtra("refer_page", str2);
        getIntent().putExtra("click_zone", str3);
    }
}
