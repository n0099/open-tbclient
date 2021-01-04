package com.baidu.live.d;

import android.content.Context;
import com.baidu.live.tbadk.core.frameworkdata.IntentConfig;
/* loaded from: classes11.dex */
public class j extends IntentConfig {
    public j(Context context, com.baidu.live.data.x xVar, int i, String str, long j) {
        super(context);
        getIntent().putExtra("ala_get_headline_headline_info_is_open", xVar.aKS.aJI);
        getIntent().putExtra("ala_get_headline_headline_info_end_time", xVar.aKS.endTime);
        getIntent().putExtra("ala_get_headline_headline_info_server_time", xVar.aKS.serverTime);
        getIntent().putExtra("ala_get_headline_headline_info_init_score", xVar.aKS.aJJ);
        getIntent().putExtra("ala_get_headline_headline_info_cur_score", xVar.aKS.aJL);
        getIntent().putExtra("ala_get_headline_headline_info_support_url", xVar.aKS.aJT);
        getIntent().putExtra("ala_get_headline_headline_info_gift_name", xVar.aKS.giftName);
        getIntent().putExtra("ala_get_headline_headline_info_gift_image_url", xVar.aKS.aJO);
        getIntent().putExtra("ala_get_headline_headline_info_gift_num", xVar.aKS.giftNum);
        getIntent().putExtra("ala_get_headline_headline_info_gift_score", xVar.aKS.aJN);
        getIntent().putExtra("ala_get_headline_headline_info_live_id", xVar.aKS.liveId);
        getIntent().putExtra("ala_get_headline_headline_info_anchor_head", xVar.aKS.aJQ);
        getIntent().putExtra("ala_get_headline_headline_info_user_head", xVar.aKS.aJR);
        getIntent().putExtra("ala_get_headline_headline_info_user_name", xVar.aKS.userName);
        getIntent().putExtra("ala_get_headline_headline_info_anchor_name", xVar.aKS.aJP);
        getIntent().putExtra("ala_get_headline_is_host", xVar.isHost);
        getIntent().putExtra("ala_get_headline_user_id", xVar.aKu.userId);
        getIntent().putExtra("ala_get_headline_portrait", xVar.aKu.portrait);
        getIntent().putExtra("ala_get_headline_userName", xVar.aKu.userName);
        getIntent().putExtra("ala_get_headline_nickName", xVar.aKu.nickName);
        getIntent().putExtra("ala_get_headline_live_id", xVar.mLiveInfo.live_id);
        getIntent().putExtra("ala_get_headline_room_id", xVar.mLiveInfo.room_id);
        getIntent().putExtra("ala_get_headline_appId", xVar.mLiveInfo.appId);
        getIntent().putExtra("ala_get_headline_feed_id", xVar.mLiveInfo.feed_id);
        getIntent().putExtra("ala_get_headline_current_status", i);
        getIntent().putExtra("ala_get_headline_other_params", str);
        getIntent().putExtra("ala_get_headline_count_down_time", j);
    }
}
