package com.baidu.live.d;

import android.content.Context;
import com.baidu.live.tbadk.core.frameworkdata.IntentConfig;
/* loaded from: classes11.dex */
public class r extends IntentConfig {
    public r(Context context, com.baidu.live.data.x xVar, String str, String str2) {
        super(context);
        getIntent().putExtra("ala_get_poke_user_id", xVar.aKu.userId);
        getIntent().putExtra("ala_get_poke_portrait", xVar.aKu.portrait);
        getIntent().putExtra("ala_get_poke_userName", xVar.aKu.userName);
        getIntent().putExtra("ala_get_poke_nickName", xVar.aKu.nickName);
        getIntent().putExtra("ala_get_poke_live_id", xVar.mLiveInfo.live_id);
        getIntent().putExtra("ala_get_poke_room_id", xVar.mLiveInfo.room_id);
        getIntent().putExtra("ala_get_poke_appId", xVar.mLiveInfo.appId);
        getIntent().putExtra("ala_get_poke_feed_id", xVar.mLiveInfo.feed_id);
        if (str2 != null) {
            getIntent().putExtra("ala_get_poke_poke_info", str2);
        }
        getIntent().putExtra("ala_get_poke_other_params", str);
    }
}
