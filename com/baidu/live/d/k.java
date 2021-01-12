package com.baidu.live.d;

import android.content.Context;
import com.baidu.live.tbadk.core.frameworkdata.IntentAction;
import com.baidu.live.tbadk.core.frameworkdata.IntentConfig;
/* loaded from: classes10.dex */
public class k extends IntentConfig {
    public k(Context context, String str, String str2, String str3, String str4, int i, String str5, String str6, boolean z, int i2, int i3, int i4, boolean z2, int i5, String str7, String str8, boolean z3, int i6) {
        super(context);
        getIntent().putExtra("user_id", str);
        getIntent().putExtra("user_name", str2);
        getIntent().putExtra("live_Id", str3);
        getIntent().putExtra("room_id", str4);
        getIntent().putExtra("is_block", i);
        getIntent().putExtra("scene", str5);
        getIntent().putExtra("app_id", str6);
        getIntent().putExtra("can_graffiti", z);
        getIntent().putExtra("custom_tab_id", i2);
        getIntent().putExtra("custom_category_id", i3);
        getIntent().putExtra("custom_gift_id", i4);
        getIntent().putExtra("new_gift_t_dou_strategy", z2);
        getIntent().putExtra(com.baidu.tbadk.core.frameworkData.IntentConfig.USER_LEVEL, i5);
        getIntent().putExtra("feed_id", str7);
        getIntent().putExtra(IntentConfig.OTHER_PARAMS, str8);
        getIntent().putExtra("isJoinGuardClub", z3);
        getIntent().putExtra("page_from", i6);
        setIntentAction(IntentAction.ActivityForResult);
    }

    public k(Context context) {
        super(context);
    }

    public void be(boolean z) {
        getIntent().putExtra("is_new_user", z);
    }

    public void bf(boolean z) {
        getIntent().putExtra("entry_super_customer", z);
    }

    public void cm(int i) {
        getIntent().putExtra("guard_club_join_amount", i);
    }

    public void bg(boolean z) {
        getIntent().putExtra("is_redpkg_unable", z);
    }

    public void bh(boolean z) {
        getIntent().putExtra("throne_enabled", z);
    }

    public void bi(boolean z) {
        getIntent().putExtra("noble_enabled", z);
    }

    public void eP(String str) {
        getIntent().putExtra("bg_info", str);
    }

    public void eQ(String str) {
        getIntent().putExtra("login_user_id", str);
    }

    public void eR(String str) {
        getIntent().putExtra("active_params", str);
    }
}
