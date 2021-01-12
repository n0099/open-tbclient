package com.baidu.live.d;

import android.content.Context;
import com.baidu.live.tbadk.core.frameworkdata.IntentConfig;
/* loaded from: classes10.dex */
public class j extends IntentConfig {
    public j(Context context, com.baidu.live.data.x xVar, int i, String str, long j) {
        super(context);
        getIntent().putExtra("ala_get_headline_headline_info_is_open", xVar.aGf.aEV);
        getIntent().putExtra("ala_get_headline_headline_info_end_time", xVar.aGf.endTime);
        getIntent().putExtra("ala_get_headline_headline_info_server_time", xVar.aGf.serverTime);
        getIntent().putExtra("ala_get_headline_headline_info_init_score", xVar.aGf.aEW);
        getIntent().putExtra("ala_get_headline_headline_info_cur_score", xVar.aGf.aEY);
        getIntent().putExtra("ala_get_headline_headline_info_support_url", xVar.aGf.aFg);
        getIntent().putExtra("ala_get_headline_headline_info_gift_name", xVar.aGf.giftName);
        getIntent().putExtra("ala_get_headline_headline_info_gift_image_url", xVar.aGf.aFb);
        getIntent().putExtra("ala_get_headline_headline_info_gift_num", xVar.aGf.giftNum);
        getIntent().putExtra("ala_get_headline_headline_info_gift_score", xVar.aGf.aFa);
        getIntent().putExtra("ala_get_headline_headline_info_live_id", xVar.aGf.liveId);
        getIntent().putExtra("ala_get_headline_headline_info_anchor_head", xVar.aGf.aFd);
        getIntent().putExtra("ala_get_headline_headline_info_user_head", xVar.aGf.aFe);
        getIntent().putExtra("ala_get_headline_headline_info_user_name", xVar.aGf.userName);
        getIntent().putExtra("ala_get_headline_headline_info_anchor_name", xVar.aGf.aFc);
        getIntent().putExtra("ala_get_headline_is_host", xVar.isHost);
        getIntent().putExtra("ala_get_headline_user_id", xVar.aFH.userId);
        getIntent().putExtra("ala_get_headline_portrait", xVar.aFH.portrait);
        getIntent().putExtra("ala_get_headline_userName", xVar.aFH.userName);
        getIntent().putExtra("ala_get_headline_nickName", xVar.aFH.nickName);
        getIntent().putExtra("ala_get_headline_live_id", xVar.mLiveInfo.live_id);
        getIntent().putExtra("ala_get_headline_room_id", xVar.mLiveInfo.room_id);
        getIntent().putExtra("ala_get_headline_appId", xVar.mLiveInfo.appId);
        getIntent().putExtra("ala_get_headline_feed_id", xVar.mLiveInfo.feed_id);
        getIntent().putExtra("ala_get_headline_current_status", i);
        getIntent().putExtra("ala_get_headline_other_params", str);
        getIntent().putExtra("ala_get_headline_count_down_time", j);
    }
}
