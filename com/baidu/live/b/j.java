package com.baidu.live.b;

import android.content.Context;
import com.baidu.live.tbadk.core.frameworkdata.IntentConfig;
/* loaded from: classes4.dex */
public class j extends IntentConfig {
    public j(Context context, com.baidu.live.data.w wVar, int i, String str, long j) {
        super(context);
        getIntent().putExtra("ala_get_headline_headline_info_is_open", wVar.aHI.aGA);
        getIntent().putExtra("ala_get_headline_headline_info_end_time", wVar.aHI.endTime);
        getIntent().putExtra("ala_get_headline_headline_info_server_time", wVar.aHI.serverTime);
        getIntent().putExtra("ala_get_headline_headline_info_init_score", wVar.aHI.aGB);
        getIntent().putExtra("ala_get_headline_headline_info_cur_score", wVar.aHI.aGD);
        getIntent().putExtra("ala_get_headline_headline_info_support_url", wVar.aHI.aGK);
        getIntent().putExtra("ala_get_headline_headline_info_gift_name", wVar.aHI.giftName);
        getIntent().putExtra("ala_get_headline_headline_info_gift_image_url", wVar.aHI.aGG);
        getIntent().putExtra("ala_get_headline_headline_info_gift_num", wVar.aHI.giftNum);
        getIntent().putExtra("ala_get_headline_headline_info_gift_score", wVar.aHI.aGF);
        getIntent().putExtra("ala_get_headline_headline_info_live_id", wVar.aHI.liveId);
        getIntent().putExtra("ala_get_headline_headline_info_anchor_head", wVar.aHI.aGI);
        getIntent().putExtra("ala_get_headline_headline_info_user_head", wVar.aHI.aGJ);
        getIntent().putExtra("ala_get_headline_headline_info_user_name", wVar.aHI.userName);
        getIntent().putExtra("ala_get_headline_headline_info_anchor_name", wVar.aHI.aGH);
        getIntent().putExtra("ala_get_headline_is_host", wVar.isHost);
        getIntent().putExtra("ala_get_headline_user_id", wVar.aHk.userId);
        getIntent().putExtra("ala_get_headline_portrait", wVar.aHk.portrait);
        getIntent().putExtra("ala_get_headline_userName", wVar.aHk.userName);
        getIntent().putExtra("ala_get_headline_nickName", wVar.aHk.nickName);
        getIntent().putExtra("ala_get_headline_live_id", wVar.mLiveInfo.live_id);
        getIntent().putExtra("ala_get_headline_room_id", wVar.mLiveInfo.room_id);
        getIntent().putExtra("ala_get_headline_appId", wVar.mLiveInfo.appId);
        getIntent().putExtra("ala_get_headline_feed_id", wVar.mLiveInfo.feed_id);
        getIntent().putExtra("ala_get_headline_current_status", i);
        getIntent().putExtra("ala_get_headline_other_params", str);
        getIntent().putExtra("ala_get_headline_count_down_time", j);
    }
}
