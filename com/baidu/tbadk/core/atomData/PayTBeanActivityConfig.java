package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.c;
/* loaded from: classes.dex */
public class PayTBeanActivityConfig extends c {
    public static final String ICON_COUNT = "icon_count";
    public static final String ICON_ID = "icon_id";
    public static final String PAY_TYPE = "pay_type";
    public static final String QUAN_NUM = "quan_num";

    public PayTBeanActivityConfig(Context context, String str, String str2, String str3, String str4) {
        super(context);
        getIntent().putExtra("pay_type", str);
        getIntent().putExtra(ICON_ID, str2);
        getIntent().putExtra("quan_num", str3);
        getIntent().putExtra(ICON_COUNT, str4);
    }
}
