package com.baidu.live.d;

import android.content.Context;
import com.baidu.live.tbadk.core.frameworkdata.IntentConfig;
/* loaded from: classes4.dex */
public class j extends IntentConfig {
    public j(Context context, com.baidu.live.data.w wVar, int i, String str, long j) {
        super(context);
        getIntent().putExtra("ala_get_headline_headline_info_is_open", wVar.aKt.aJk);
        getIntent().putExtra("ala_get_headline_headline_info_end_time", wVar.aKt.endTime);
        getIntent().putExtra("ala_get_headline_headline_info_server_time", wVar.aKt.serverTime);
        getIntent().putExtra("ala_get_headline_headline_info_init_score", wVar.aKt.aJl);
        getIntent().putExtra("ala_get_headline_headline_info_cur_score", wVar.aKt.aJn);
        getIntent().putExtra("ala_get_headline_headline_info_support_url", wVar.aKt.aJu);
        getIntent().putExtra("ala_get_headline_headline_info_gift_name", wVar.aKt.giftName);
        getIntent().putExtra("ala_get_headline_headline_info_gift_image_url", wVar.aKt.aJq);
        getIntent().putExtra("ala_get_headline_headline_info_gift_num", wVar.aKt.giftNum);
        getIntent().putExtra("ala_get_headline_headline_info_gift_score", wVar.aKt.aJp);
        getIntent().putExtra("ala_get_headline_headline_info_live_id", wVar.aKt.liveId);
        getIntent().putExtra("ala_get_headline_headline_info_anchor_head", wVar.aKt.aJs);
        getIntent().putExtra("ala_get_headline_headline_info_user_head", wVar.aKt.aJt);
        getIntent().putExtra("ala_get_headline_headline_info_user_name", wVar.aKt.userName);
        getIntent().putExtra("ala_get_headline_headline_info_anchor_name", wVar.aKt.aJr);
        getIntent().putExtra("ala_get_headline_is_host", wVar.isHost);
        getIntent().putExtra("ala_get_headline_user_id", wVar.aJV.userId);
        getIntent().putExtra("ala_get_headline_portrait", wVar.aJV.portrait);
        getIntent().putExtra("ala_get_headline_userName", wVar.aJV.userName);
        getIntent().putExtra("ala_get_headline_nickName", wVar.aJV.nickName);
        getIntent().putExtra("ala_get_headline_live_id", wVar.mLiveInfo.live_id);
        getIntent().putExtra("ala_get_headline_room_id", wVar.mLiveInfo.room_id);
        getIntent().putExtra("ala_get_headline_appId", wVar.mLiveInfo.appId);
        getIntent().putExtra("ala_get_headline_feed_id", wVar.mLiveInfo.feed_id);
        getIntent().putExtra("ala_get_headline_current_status", i);
        getIntent().putExtra("ala_get_headline_other_params", str);
        getIntent().putExtra("ala_get_headline_count_down_time", j);
    }
}
