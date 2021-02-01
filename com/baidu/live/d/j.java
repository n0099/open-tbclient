package com.baidu.live.d;

import android.content.Context;
import com.baidu.live.tbadk.core.frameworkdata.IntentConfig;
/* loaded from: classes11.dex */
public class j extends IntentConfig {
    public j(Context context, com.baidu.live.data.ab abVar, int i, String str, long j) {
        super(context);
        getIntent().putExtra("ala_get_headline_headline_info_is_open", abVar.aIB.aHr);
        getIntent().putExtra("ala_get_headline_headline_info_end_time", abVar.aIB.endTime);
        getIntent().putExtra("ala_get_headline_headline_info_server_time", abVar.aIB.serverTime);
        getIntent().putExtra("ala_get_headline_headline_info_init_score", abVar.aIB.aHs);
        getIntent().putExtra("ala_get_headline_headline_info_cur_score", abVar.aIB.aHu);
        getIntent().putExtra("ala_get_headline_headline_info_support_url", abVar.aIB.aHC);
        getIntent().putExtra("ala_get_headline_headline_info_gift_name", abVar.aIB.giftName);
        getIntent().putExtra("ala_get_headline_headline_info_gift_image_url", abVar.aIB.aHx);
        getIntent().putExtra("ala_get_headline_headline_info_gift_num", abVar.aIB.giftNum);
        getIntent().putExtra("ala_get_headline_headline_info_gift_score", abVar.aIB.aHw);
        getIntent().putExtra("ala_get_headline_headline_info_live_id", abVar.aIB.liveId);
        getIntent().putExtra("ala_get_headline_headline_info_anchor_head", abVar.aIB.aHz);
        getIntent().putExtra("ala_get_headline_headline_info_user_head", abVar.aIB.aHA);
        getIntent().putExtra("ala_get_headline_headline_info_user_name", abVar.aIB.userName);
        getIntent().putExtra("ala_get_headline_headline_info_anchor_name", abVar.aIB.aHy);
        getIntent().putExtra("ala_get_headline_is_host", abVar.isHost);
        getIntent().putExtra("ala_get_headline_user_id", abVar.aId.userId);
        getIntent().putExtra("ala_get_headline_portrait", abVar.aId.portrait);
        getIntent().putExtra("ala_get_headline_userName", abVar.aId.userName);
        getIntent().putExtra("ala_get_headline_nickName", abVar.aId.nickName);
        getIntent().putExtra("ala_get_headline_live_id", abVar.mLiveInfo.live_id);
        getIntent().putExtra("ala_get_headline_room_id", abVar.mLiveInfo.room_id);
        getIntent().putExtra("ala_get_headline_appId", abVar.mLiveInfo.appId);
        getIntent().putExtra("ala_get_headline_feed_id", abVar.mLiveInfo.feed_id);
        getIntent().putExtra("ala_get_headline_current_status", i);
        getIntent().putExtra("ala_get_headline_other_params", str);
        getIntent().putExtra("ala_get_headline_count_down_time", j);
    }
}
