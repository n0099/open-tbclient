package com.baidu.live.b;

import android.content.Context;
import com.baidu.live.tbadk.core.frameworkdata.IntentConfig;
/* loaded from: classes4.dex */
public class j extends IntentConfig {
    public j(Context context, com.baidu.live.data.w wVar, int i, String str, long j) {
        super(context);
        getIntent().putExtra("ala_get_headline_headline_info_is_open", wVar.aIC.aHt);
        getIntent().putExtra("ala_get_headline_headline_info_end_time", wVar.aIC.endTime);
        getIntent().putExtra("ala_get_headline_headline_info_server_time", wVar.aIC.serverTime);
        getIntent().putExtra("ala_get_headline_headline_info_init_score", wVar.aIC.aHu);
        getIntent().putExtra("ala_get_headline_headline_info_cur_score", wVar.aIC.aHw);
        getIntent().putExtra("ala_get_headline_headline_info_support_url", wVar.aIC.aHE);
        getIntent().putExtra("ala_get_headline_headline_info_gift_name", wVar.aIC.giftName);
        getIntent().putExtra("ala_get_headline_headline_info_gift_image_url", wVar.aIC.aHz);
        getIntent().putExtra("ala_get_headline_headline_info_gift_num", wVar.aIC.giftNum);
        getIntent().putExtra("ala_get_headline_headline_info_gift_score", wVar.aIC.aHy);
        getIntent().putExtra("ala_get_headline_headline_info_live_id", wVar.aIC.liveId);
        getIntent().putExtra("ala_get_headline_headline_info_anchor_head", wVar.aIC.aHC);
        getIntent().putExtra("ala_get_headline_headline_info_user_head", wVar.aIC.aHD);
        getIntent().putExtra("ala_get_headline_headline_info_user_name", wVar.aIC.userName);
        getIntent().putExtra("ala_get_headline_headline_info_anchor_name", wVar.aIC.aHA);
        getIntent().putExtra("ala_get_headline_is_host", wVar.isHost);
        getIntent().putExtra("ala_get_headline_user_id", wVar.aIe.userId);
        getIntent().putExtra("ala_get_headline_portrait", wVar.aIe.portrait);
        getIntent().putExtra("ala_get_headline_userName", wVar.aIe.userName);
        getIntent().putExtra("ala_get_headline_nickName", wVar.aIe.nickName);
        getIntent().putExtra("ala_get_headline_live_id", wVar.mLiveInfo.live_id);
        getIntent().putExtra("ala_get_headline_room_id", wVar.mLiveInfo.room_id);
        getIntent().putExtra("ala_get_headline_appId", wVar.mLiveInfo.appId);
        getIntent().putExtra("ala_get_headline_feed_id", wVar.mLiveInfo.feed_id);
        getIntent().putExtra("ala_get_headline_current_status", i);
        getIntent().putExtra("ala_get_headline_other_params", str);
        getIntent().putExtra("ala_get_headline_count_down_time", j);
    }
}
