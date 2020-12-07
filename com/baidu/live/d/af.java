package com.baidu.live.d;

import android.content.Context;
import android.util.Log;
import com.baidu.ala.atomdata.AlaSDKShareEmptyActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.IntentConfig;
/* loaded from: classes4.dex */
public class af extends IntentConfig {
    public af(Context context, String str, String str2, String str3, boolean z, String str4, String str5, String str6, String str7) {
        super(context);
        getIntent().putExtra("uid", str);
        getIntent().putExtra("nickname", str2);
        getIntent().putExtra("msgType", str3);
        getIntent().putExtra("isMediaRole", z);
        getIntent().putExtra(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID, str4);
        getIntent().putExtra("groupid", str5);
        getIntent().putExtra("paid", str6);
        getIntent().putExtra("userIcon", str7);
        Log.i("chat_im_chatactivity", "nickname=>" + str2 + "；msgType=>" + str3 + "；isMediaRole=>" + z + "；id=>" + str + "；paid=>" + str6);
    }
}
