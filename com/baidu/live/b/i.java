package com.baidu.live.b;

import android.content.Context;
import com.baidu.live.tbadk.core.frameworkdata.IntentAction;
import com.baidu.live.tbadk.core.frameworkdata.IntentConfig;
/* loaded from: classes4.dex */
public class i extends IntentConfig {
    public i(Context context, String str, String str2, String str3, String str4, int i, String str5, String str6, boolean z, int i2, int i3, int i4, boolean z2, int i5, String str7, String str8, boolean z3, int i6) {
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
        getIntent().putExtra("user_level", i5);
        getIntent().putExtra("feed_id", str7);
        getIntent().putExtra(IntentConfig.OTHER_PARAMS, str8);
        getIntent().putExtra("isJoinGuardClub", z3);
        getIntent().putExtra("page_from", i6);
        setIntentAction(IntentAction.ActivityForResult);
    }

    public void aZ(boolean z) {
        getIntent().putExtra("is_new_user", z);
    }

    public void ba(boolean z) {
        getIntent().putExtra("entry_super_customer", z);
    }

    public void dG(int i) {
        getIntent().putExtra("guard_club_join_amount", i);
    }

    public void bb(boolean z) {
        getIntent().putExtra("is_redpkg_unable", z);
    }

    public void bc(boolean z) {
        getIntent().putExtra("throne_enabled", z);
    }

    public void bd(boolean z) {
        getIntent().putExtra("noble_enabled", z);
    }

    public void fW(String str) {
        getIntent().putExtra("bg_info", str);
    }

    public void fX(String str) {
        getIntent().putExtra("login_user_id", str);
    }

    public void fY(String str) {
        getIntent().putExtra("active_params", str);
    }
}
