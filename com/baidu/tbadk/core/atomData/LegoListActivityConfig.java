package com.baidu.tbadk.core.atomData;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class LegoListActivityConfig extends IntentConfig {
    public static final String ITEM_ID = "item_id";
    public static final String PAGE_ID = "page_id";
    public static final int PAGE_LIST = 2;
    public static final int PAGE_TAB = 1;
    public static final String PAGE_TYPE = "page_type";
    public static final String PARAMS = "params";
    public static final String RN = "rn";
    private final Context mContext;

    public LegoListActivityConfig(Context context) {
        super(context);
        this.mContext = context;
    }

    public LegoListActivityConfig createNormalCfg(long j, int i, String str, int i2, String str2) {
        Intent intent = getIntent();
        intent.putExtra("page_id", j);
        intent.putExtra("page_type", i);
        if (!TextUtils.isEmpty(str)) {
            intent.putExtra(ITEM_ID, str);
        }
        intent.putExtra(RN, i2);
        intent.putExtra(PARAMS, str2);
        if (!(this.mContext instanceof Activity)) {
            intent.addFlags(268435456);
        }
        return this;
    }
}
