package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.MemberPayStatistic;
/* loaded from: classes3.dex */
public class CardBoxMemberPayActivityConfig extends IntentConfig {
    public static final String PACKET_ID = "packet_id";

    public CardBoxMemberPayActivityConfig(Context context, String str, String str2, String str3) {
        super(context);
        getIntent().putExtra(PACKET_ID, str);
        getIntent().putExtra(MemberPayStatistic.REFER_PAGE, str2);
        getIntent().putExtra(MemberPayStatistic.CLICK_ZONE, str3);
    }
}
