package com.baidu.live.b;

import android.content.Context;
import com.baidu.live.data.AlaLiveWishListData;
import com.baidu.live.tbadk.core.frameworkdata.IntentConfig;
/* loaded from: classes4.dex */
public class t extends IntentConfig {
    public t(Context context, com.baidu.live.data.u uVar, String str, String str2, boolean z) {
        super(context);
        getIntent().putExtra("live_id", str);
        getIntent().putExtra("anchor_id", str2);
        getIntent().putExtra("is_guest_state", z);
        getIntent().putExtra("ala_wish_list_data", AlaLiveWishListData.toListString(uVar.aIi));
    }
}
