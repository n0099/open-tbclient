package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.a;
/* loaded from: classes.dex */
public class PayActivityConfig extends a {
    public static final String IS_LEFT = "is_left";
    public static final String IS_PAY = "is_pay";
    public static final String PAY_TYPE = "pay_type";
    public static final String PROPS_ID = "props_id";
    public static final String PROPS_MON = "props_mon";
    public static final String QUAN_NUM = "quan_num";

    public PayActivityConfig(Context context, String str, String str2, String str3, String str4, String str5) {
        super(context);
        getIntent().putExtra("pay_type", str);
        getIntent().putExtra(PROPS_ID, str2);
        getIntent().putExtra("quan_num", str3);
        getIntent().putExtra(IS_LEFT, str4);
        getIntent().putExtra(PROPS_MON, str5);
    }
}
