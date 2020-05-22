package com.baidu.live.c;

import android.content.Context;
import com.baidu.live.tbadk.core.frameworkdata.IntentAction;
import com.baidu.live.tbadk.core.frameworkdata.IntentConfig;
import com.baidu.sapi2.dto.FaceBaseDTO;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
/* loaded from: classes3.dex */
public class g extends IntentConfig {
    public g(Context context, String str, String str2, String str3, String str4, int i, String str5, String str6, boolean z, int i2, int i3, int i4, boolean z2, int i5, String str7, String str8, boolean z3, int i6) {
        super(context);
        getIntent().putExtra("user_id", str);
        getIntent().putExtra("user_name", str2);
        getIntent().putExtra("live_Id", str3);
        getIntent().putExtra("room_id", str4);
        getIntent().putExtra("is_block", i);
        getIntent().putExtra(FaceBaseDTO.KEY_BUSINESS_SCENE, str5);
        getIntent().putExtra("app_id", str6);
        getIntent().putExtra("can_graffiti", z);
        getIntent().putExtra("custom_tab_id", i2);
        getIntent().putExtra("custom_category_id", i3);
        getIntent().putExtra("custom_gift_id", i4);
        getIntent().putExtra("new_gift_t_dou_strategy", z2);
        getIntent().putExtra("user_level", i5);
        getIntent().putExtra("feed_id", str7);
        getIntent().putExtra(IntentConfig.OTHER_PARAMS, str8);
        getIntent().putExtra("isJoinGuardClub", z3);
        getIntent().putExtra(VideoPlayActivityConfig.PAGE_FROM, i6);
        setIntentAction(IntentAction.ActivityForResult);
    }

    public void aN(boolean z) {
        getIntent().putExtra("is_new_user", z);
    }

    public void aO(boolean z) {
        getIntent().putExtra("entry_super_customer", z);
    }

    public void bB(int i) {
        getIntent().putExtra("guard_club_join_amount", i);
    }

    public void aP(boolean z) {
        getIntent().putExtra("is_redpkg_unable", z);
    }

    public void aQ(boolean z) {
        getIntent().putExtra("throne_enabled", z);
    }

    public void aR(boolean z) {
        getIntent().putExtra("noble_enabled", z);
    }

    public void el(String str) {
        getIntent().putExtra("bg_info", str);
    }
}
