package com.baidu.live.b;

import android.content.Context;
import com.baidu.live.tbadk.core.frameworkdata.IntentConfig;
/* loaded from: classes4.dex */
public class j extends IntentConfig {
    public j(Context context, com.baidu.live.data.w wVar, int i, String str, long j) {
        super(context);
        getIntent().putExtra("ala_get_headline_headline_info_is_open", wVar.aJt.aIl);
        getIntent().putExtra("ala_get_headline_headline_info_end_time", wVar.aJt.endTime);
        getIntent().putExtra("ala_get_headline_headline_info_server_time", wVar.aJt.serverTime);
        getIntent().putExtra("ala_get_headline_headline_info_init_score", wVar.aJt.aIm);
        getIntent().putExtra("ala_get_headline_headline_info_cur_score", wVar.aJt.aIo);
        getIntent().putExtra("ala_get_headline_headline_info_support_url", wVar.aJt.aIv);
        getIntent().putExtra("ala_get_headline_headline_info_gift_name", wVar.aJt.giftName);
        getIntent().putExtra("ala_get_headline_headline_info_gift_image_url", wVar.aJt.aIr);
        getIntent().putExtra("ala_get_headline_headline_info_gift_num", wVar.aJt.giftNum);
        getIntent().putExtra("ala_get_headline_headline_info_gift_score", wVar.aJt.aIq);
        getIntent().putExtra("ala_get_headline_headline_info_live_id", wVar.aJt.liveId);
        getIntent().putExtra("ala_get_headline_headline_info_anchor_head", wVar.aJt.aIt);
        getIntent().putExtra("ala_get_headline_headline_info_user_head", wVar.aJt.aIu);
        getIntent().putExtra("ala_get_headline_headline_info_user_name", wVar.aJt.userName);
        getIntent().putExtra("ala_get_headline_headline_info_anchor_name", wVar.aJt.aIs);
        getIntent().putExtra("ala_get_headline_is_host", wVar.isHost);
        getIntent().putExtra("ala_get_headline_user_id", wVar.aIV.userId);
        getIntent().putExtra("ala_get_headline_portrait", wVar.aIV.portrait);
        getIntent().putExtra("ala_get_headline_userName", wVar.aIV.userName);
        getIntent().putExtra("ala_get_headline_nickName", wVar.aIV.nickName);
        getIntent().putExtra("ala_get_headline_live_id", wVar.mLiveInfo.live_id);
        getIntent().putExtra("ala_get_headline_room_id", wVar.mLiveInfo.room_id);
        getIntent().putExtra("ala_get_headline_appId", wVar.mLiveInfo.appId);
        getIntent().putExtra("ala_get_headline_feed_id", wVar.mLiveInfo.feed_id);
        getIntent().putExtra("ala_get_headline_current_status", i);
        getIntent().putExtra("ala_get_headline_other_params", str);
        getIntent().putExtra("ala_get_headline_count_down_time", j);
    }
}
