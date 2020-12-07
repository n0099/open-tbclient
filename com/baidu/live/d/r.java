package com.baidu.live.d;

import android.content.Context;
import com.baidu.live.tbadk.core.frameworkdata.IntentConfig;
/* loaded from: classes4.dex */
public class r extends IntentConfig {
    public r(Context context, com.baidu.live.data.w wVar, String str, String str2) {
        super(context);
        getIntent().putExtra("ala_get_poke_user_id", wVar.aJV.userId);
        getIntent().putExtra("ala_get_poke_portrait", wVar.aJV.portrait);
        getIntent().putExtra("ala_get_poke_userName", wVar.aJV.userName);
        getIntent().putExtra("ala_get_poke_nickName", wVar.aJV.nickName);
        getIntent().putExtra("ala_get_poke_live_id", wVar.mLiveInfo.live_id);
        getIntent().putExtra("ala_get_poke_room_id", wVar.mLiveInfo.room_id);
        getIntent().putExtra("ala_get_poke_appId", wVar.mLiveInfo.appId);
        getIntent().putExtra("ala_get_poke_feed_id", wVar.mLiveInfo.feed_id);
        if (str2 != null) {
            getIntent().putExtra("ala_get_poke_poke_info", str2);
        }
        getIntent().putExtra("ala_get_poke_other_params", str);
    }
}
