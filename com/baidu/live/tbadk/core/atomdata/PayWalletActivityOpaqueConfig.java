package com.baidu.live.tbadk.core.atomdata;

import android.content.Context;
import com.baidu.live.tbadk.core.frameworkdata.IntentAction;
import com.baidu.live.tbadk.core.frameworkdata.IntentConfig;
import com.baidu.live.tbadk.util.PageDialogHelper;
/* loaded from: classes6.dex */
public class PayWalletActivityOpaqueConfig extends IntentConfig {
    public static final String CLICK_ZONE = "click_zone";
    public static final String IS_LEFT = "is_left";
    public static final String IS_PAY = "isPay";
    public static final String IS_PAY_DIALOG = "is_pay_dialog";
    public static final String MONEY = "money";
    public static final String PAY_CONFIG = "pay_config";
    public static final String PAY_FROM = "pay_from";
    public static final String PAY_TYPE = "pay_type";
    public static final String PROPS_ID = "props_id";
    public static final String PROPS_MON = "props_mon";
    public static final String REFER_PAGE = "refer_page";
    public static final String TBEAN_NUM = "tbean_num";

    public PayWalletActivityOpaqueConfig(Context context, int i, String str, String str2, String str3, String str4, boolean z, String str5, boolean z2, PageDialogHelper.PayForm payForm, String str6, String str7, int i2) {
        super(context);
        setRequestCode(i2);
        setIntentAction(IntentAction.ActivityForResult);
        getIntent().putExtra("pay_type", i);
        getIntent().putExtra("is_left", str);
        getIntent().putExtra("props_id", str2);
        getIntent().putExtra("money", str3);
        getIntent().putExtra("props_mon", str4);
        getIntent().putExtra("isPay", z);
        getIntent().putExtra("tbean_num", str5);
        getIntent().putExtra("is_pay_dialog", z2);
        getIntent().putExtra("pay_from", payForm.ordinal());
        getIntent().putExtra("refer_page", str6);
        getIntent().putExtra("click_zone", str7);
        setIntentAction(IntentAction.ActivityForResult);
    }

    public void setFrom(String str) {
        getIntent().putExtra("from", str);
    }
}
