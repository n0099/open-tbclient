package com.baidu.live.d;

import android.content.Context;
import com.baidu.live.data.AlaLiveWishListData;
import com.baidu.live.tbadk.core.frameworkdata.IntentConfig;
/* loaded from: classes11.dex */
public class w extends IntentConfig {
    public w(Context context, com.baidu.live.data.x xVar, String str, String str2, boolean z) {
        super(context);
        getIntent().putExtra("live_id", str);
        getIntent().putExtra("anchor_id", str2);
        getIntent().putExtra("is_guest_state", z);
        getIntent().putExtra("ala_wish_list_data", AlaLiveWishListData.toListString(xVar.aKV));
    }
}
