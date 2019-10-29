package com.baidu.tbadk.core.atomData;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class LegoListActivityConfig extends IntentConfig {
    public static final String AD_ID = "ad_id";
    public static final String ANIMATION_INFO = "animation_info";
    public static final String DOWNLOAD_MIDDLE_KEY = "download_middle";
    public static final String HAS_ANIMATION = "has_animation";
    public static final String IS_FROM = "source";
    public static final String IS_IMMERSIVE = "is_immersive";
    public static final String IS_LANDINGPAGE = "is_landingpage";
    public static final String ITEM_ID = "item_id";
    public static final String JUMP_NEW_WEB = "1";
    public static final String NEXT_PAGE = "next_page";
    public static final String PAGE_ID = "page_id";
    public static final int PAGE_TAB = 1;
    public static final String PAGE_TYPE = "page_type";
    public static final String PARAMS = "params";
    public static final String PRE_LOAD = "pre_load";
    public static final String RN = "rn";
    private final Context mContext;

    public LegoListActivityConfig(Context context) {
        super(context);
        this.mContext = context;
    }

    public LegoListActivityConfig createNormalCfg(long j, int i, String str, int i2, int i3, String str2) {
        Intent intent = getIntent();
        intent.putExtra("page_id", j);
        intent.putExtra("page_type", i);
        if (!TextUtils.isEmpty(str)) {
            intent.putExtra(ITEM_ID, str);
        }
        intent.putExtra(IS_IMMERSIVE, i2);
        intent.putExtra("rn", i3);
        intent.putExtra("params", str2);
        if (!(this.mContext instanceof Activity)) {
            intent.addFlags(268435456);
        }
        return this;
    }

    public LegoListActivityConfig addLandingPageParams(String str, String str2, String str3, int i, int i2, String str4) {
        Intent intent = getIntent();
        intent.putExtra(HAS_ANIMATION, i);
        intent.putExtra(IS_LANDINGPAGE, i2);
        if (!TextUtils.isEmpty(str)) {
            intent.putExtra(ANIMATION_INFO, str);
        }
        if (!TextUtils.isEmpty(str2)) {
            intent.putExtra(PRE_LOAD, str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            intent.putExtra(NEXT_PAGE, str3);
        }
        intent.putExtra("source", str4);
        return this;
    }
}
