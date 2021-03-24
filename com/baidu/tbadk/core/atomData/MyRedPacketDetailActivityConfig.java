package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes3.dex */
public class MyRedPacketDetailActivityConfig extends IntentConfig {
    public static final String PRIMARY_REDPACKET_ID = "primary_redpacket_id";
    public static final int TYPE_PRIMARY_RED_PACKET = 1;
    public static final int TYPE_SUB_RED_PACKET = 2;
    public static final int TYPE_SUB_RED_PACKET_DETAIL = 3;

    public MyRedPacketDetailActivityConfig(Context context) {
        super(context);
    }

    public MyRedPacketDetailActivityConfig(Context context, long j) {
        super(context);
        getIntent().putExtra(PRIMARY_REDPACKET_ID, j);
    }
}
