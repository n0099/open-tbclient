package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.util.PageDialogHelper;
/* loaded from: classes.dex */
public class BuyTBeanActivityConfig extends IntentConfig {
    public static final String GIFT_TBEAN = "gift_tbean";
    public static final String IS_FROM_ALA = "is_from_ala";
    public static final String IS_FROM_ALA_GIFT_PANEL = "is_from_ala_gift_panel";
    public static final String PAY_FORM = "pay_form";
    public static final String PAY_TYPE = "pay_type";
    public static final String SCENE_ID = "scene_id";
    public static final int SOURCE_ALA_BUY_HOST_GUARDIAN = 4;
    public static final int SOURCE_ALA_GIFT_LEFT_CORNER = 3;
    public static final int SOURCE_ALA_GIFT_PANEL = 1;
    public static final int SOURCE_ALA_LIVEROOM_OUTSIDE_SHOW = 2;
    public static final int SOURCE_ALA_ONE_THOUSAND_GIFT = 5;
    public static final int SOURCE_DEFAULT = 0;
    public static final String TBEAN_LEFT_TO_BUY_ALA_GIFT = "tbean_left_to_buy_ala_gift";

    public BuyTBeanActivityConfig(Context context, long j) {
        super(context);
        getIntent().putExtra("gift_tbean", j);
    }

    public BuyTBeanActivityConfig(Context context, long j, int i, String str, PageDialogHelper.PayForm payForm) {
        super(context);
        getIntent().putExtra("gift_tbean", j);
        getIntent().putExtra("scene_id", str);
        getIntent().putExtra("pay_type", i);
        getIntent().putExtra("pay_form", payForm);
    }

    public void setReferPageAndClickZone(String str, String str2) {
        getIntent().putExtra("refer_page", str);
        getIntent().putExtra("click_zone", str2);
    }

    public BuyTBeanActivityConfig setIsFromALa(boolean z) {
        getIntent().putExtra(IS_FROM_ALA, z);
        return this;
    }

    public BuyTBeanActivityConfig setFromDecreaseGiftStepStrategy(int i) {
        getIntent().putExtra(IS_FROM_ALA_GIFT_PANEL, i);
        return this;
    }

    public BuyTBeanActivityConfig setTBeanLeftToBuyGift(long j) {
        getIntent().putExtra(TBEAN_LEFT_TO_BUY_ALA_GIFT, j);
        return this;
    }
}
