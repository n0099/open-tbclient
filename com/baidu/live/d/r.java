package com.baidu.live.d;

import android.content.Context;
import com.baidu.live.tbadk.core.frameworkdata.IntentConfig;
/* loaded from: classes10.dex */
public class r extends IntentConfig {
    public r(Context context, com.baidu.live.data.ab abVar, String str, String str2) {
        super(context);
        getIntent().putExtra("ala_get_poke_user_id", abVar.aJD.userId);
        getIntent().putExtra("ala_get_poke_portrait", abVar.aJD.portrait);
        getIntent().putExtra("ala_get_poke_userName", abVar.aJD.userName);
        getIntent().putExtra("ala_get_poke_nickName", abVar.aJD.nickName);
        getIntent().putExtra("ala_get_poke_live_id", abVar.mLiveInfo.live_id);
        getIntent().putExtra("ala_get_poke_room_id", abVar.mLiveInfo.room_id);
        getIntent().putExtra("ala_get_poke_appId", abVar.mLiveInfo.appId);
        getIntent().putExtra("ala_get_poke_feed_id", abVar.mLiveInfo.feed_id);
        if (str2 != null) {
            getIntent().putExtra("ala_get_poke_poke_info", str2);
        }
        getIntent().putExtra("ala_get_poke_other_params", str);
    }
}
