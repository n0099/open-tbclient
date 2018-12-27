package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import java.net.URLEncoder;
/* loaded from: classes.dex */
public class MyRedPacketDetailActivityConfig extends IntentConfig {
    public static final String BaiduAuthInfoURL = "https://m.baifubao.com/static/wap/auth/";
    public static final String PRIMARY_REDPACKET_ID = "primary_redpacket_id";
    public static final String ServiceType = "1099";
    public static final int TYPE_PRIMARY_RED_PACKET = 1;
    public static final int TYPE_SUB_RED_PACKET = 2;
    public static final int TYPE_SUB_RED_PACKET_DETAIL = 3;
    public static final String BaiduBalanceURL = "https://m.baifubao.com/wap/0/wallet/0/balance/0?titlebar=0";
    public static final String VERIFYURL = "https://m.baifubao.com/static/wap/auth/?service_type=1099&titlebar=0&ru=" + URLEncoder.encode(BaiduBalanceURL);

    public MyRedPacketDetailActivityConfig(Context context) {
        super(context);
    }

    public MyRedPacketDetailActivityConfig(Context context, long j) {
        super(context);
        getIntent().putExtra(PRIMARY_REDPACKET_ID, j);
    }
}
