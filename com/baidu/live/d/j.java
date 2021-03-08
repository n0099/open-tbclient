package com.baidu.live.d;

import android.content.Context;
import com.baidu.live.tbadk.core.frameworkdata.IntentConfig;
/* loaded from: classes10.dex */
public class j extends IntentConfig {
    public j(Context context, com.baidu.live.data.ab abVar, int i, String str, long j) {
        super(context);
        getIntent().putExtra("ala_get_headline_headline_info_is_open", abVar.aKb.aIR);
        getIntent().putExtra("ala_get_headline_headline_info_end_time", abVar.aKb.endTime);
        getIntent().putExtra("ala_get_headline_headline_info_server_time", abVar.aKb.serverTime);
        getIntent().putExtra("ala_get_headline_headline_info_init_score", abVar.aKb.aIS);
        getIntent().putExtra("ala_get_headline_headline_info_cur_score", abVar.aKb.aIU);
        getIntent().putExtra("ala_get_headline_headline_info_support_url", abVar.aKb.aJc);
        getIntent().putExtra("ala_get_headline_headline_info_gift_name", abVar.aKb.giftName);
        getIntent().putExtra("ala_get_headline_headline_info_gift_image_url", abVar.aKb.aIX);
        getIntent().putExtra("ala_get_headline_headline_info_gift_num", abVar.aKb.giftNum);
        getIntent().putExtra("ala_get_headline_headline_info_gift_score", abVar.aKb.aIW);
        getIntent().putExtra("ala_get_headline_headline_info_live_id", abVar.aKb.liveId);
        getIntent().putExtra("ala_get_headline_headline_info_anchor_head", abVar.aKb.aIZ);
        getIntent().putExtra("ala_get_headline_headline_info_user_head", abVar.aKb.aJa);
        getIntent().putExtra("ala_get_headline_headline_info_user_name", abVar.aKb.userName);
        getIntent().putExtra("ala_get_headline_headline_info_anchor_name", abVar.aKb.aIY);
        getIntent().putExtra("ala_get_headline_is_host", abVar.isHost);
        getIntent().putExtra("ala_get_headline_user_id", abVar.aJD.userId);
        getIntent().putExtra("ala_get_headline_portrait", abVar.aJD.portrait);
        getIntent().putExtra("ala_get_headline_userName", abVar.aJD.userName);
        getIntent().putExtra("ala_get_headline_nickName", abVar.aJD.nickName);
        getIntent().putExtra("ala_get_headline_live_id", abVar.mLiveInfo.live_id);
        getIntent().putExtra("ala_get_headline_room_id", abVar.mLiveInfo.room_id);
        getIntent().putExtra("ala_get_headline_appId", abVar.mLiveInfo.appId);
        getIntent().putExtra("ala_get_headline_feed_id", abVar.mLiveInfo.feed_id);
        getIntent().putExtra("ala_get_headline_current_status", i);
        getIntent().putExtra("ala_get_headline_other_params", str);
        getIntent().putExtra("ala_get_headline_count_down_time", j);
    }
}
