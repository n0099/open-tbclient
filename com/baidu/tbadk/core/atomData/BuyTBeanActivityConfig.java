package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.a;
/* loaded from: classes.dex */
public class BuyTBeanActivityConfig extends a {
    public static final String GIFT_TBEAN = "gift_tbean";
    public static final String JUMP_URL = "jump_url";

    public BuyTBeanActivityConfig(Context context, int i) {
        super(context);
        getIntent().putExtra(GIFT_TBEAN, i);
    }

    public BuyTBeanActivityConfig(Context context, int i, String str) {
        super(context);
        getIntent().putExtra(GIFT_TBEAN, i);
        getIntent().putExtra(JUMP_URL, str);
    }
}
