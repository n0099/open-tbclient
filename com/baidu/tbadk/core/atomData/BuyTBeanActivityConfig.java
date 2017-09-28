package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.util.PageDialogHelper;
/* loaded from: classes.dex */
public class BuyTBeanActivityConfig extends IntentConfig {
    public static final String GIFT_TBEAN = "gift_tbean";
    public static final String PAY_FORM = "pay_form";
    public static final String PAY_TYPE = "pay_type";
    public static final String SCENE_ID = "scene_id";

    public BuyTBeanActivityConfig(Context context, long j) {
        super(context);
        getIntent().putExtra(GIFT_TBEAN, j);
    }

    public BuyTBeanActivityConfig(Context context, long j, int i, String str, PageDialogHelper.PayForm payForm) {
        super(context);
        getIntent().putExtra(GIFT_TBEAN, j);
        getIntent().putExtra("scene_id", str);
        getIntent().putExtra("pay_type", i);
        getIntent().putExtra(PAY_FORM, payForm);
    }

    public void setReferPageAndClickZone(String str, String str2) {
        getIntent().putExtra("refer_page", str);
        getIntent().putExtra("click_zone", str2);
    }
}
