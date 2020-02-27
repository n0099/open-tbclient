package com.baidu.live.tbadk.core.atomdata;

import android.content.Context;
import com.baidu.live.tbadk.core.frameworkdata.IntentConfig;
import com.baidu.live.tbadk.util.PageDialogHelper;
/* loaded from: classes3.dex */
public class BuyTBeanActivityConfig extends IntentConfig {
    public static final String CALLBACK = "callback";
    public static final String FROM_EXTRA = "from_extra";
    public static final String FROM_LIVE = "from_live";
    public static final String GIFT_TBEAN = "gift_tbean";
    public static final String IS_FROM_JOIN_GUARDCLUB = "is_from_join_guardclub";
    public static final String IS_TRANSLUCENT = "is_translucent";
    public static final String OTHER_PARAMS = "other_params";
    public static final String PAY_FORM = "pay_form";
    public static final String PAY_SOURCE = "pay_source";
    public static final String PAY_TYPE = "pay_type";
    public static final String SCENE_ID = "scene_id";
    public static final String T_BEAN_NOT_ENOUGH = "t_bean_not_enough";

    public BuyTBeanActivityConfig(Context context, long j) {
        super(context);
        getIntent().putExtra("gift_tbean", j);
    }

    public BuyTBeanActivityConfig(Context context, long j, String str, boolean z, String str2, boolean z2) {
        super(context);
        getIntent().putExtra("gift_tbean", j);
        getIntent().putExtra("other_params", str);
        getIntent().putExtra(FROM_LIVE, z);
        getIntent().putExtra(FROM_EXTRA, str2);
        getIntent().putExtra(T_BEAN_NOT_ENOUGH, z2);
    }

    public BuyTBeanActivityConfig(Context context, long j, boolean z) {
        super(context);
        getIntent().putExtra("gift_tbean", j);
        getIntent().putExtra(PAY_SOURCE, z);
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

    public void setCallback(String str) {
        getIntent().putExtra(CALLBACK, str);
    }

    public void setIsFromJoinGuardclub(boolean z) {
        getIntent().putExtra(IS_FROM_JOIN_GUARDCLUB, z);
    }

    public void setIsTranslucent(boolean z) {
        getIntent().putExtra("is_translucent", z);
    }

    public void setFrom(String str) {
        getIntent().putExtra("from", str);
    }
}
