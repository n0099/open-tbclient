package com.baidu.tbadk.core.atomData;

import android.content.Context;
/* loaded from: classes3.dex */
public class OfficialHistoryImageActivityConfig extends AbsMsgImageActivityConfig {
    public OfficialHistoryImageActivityConfig(Context context, String str, String str2) {
        super(context);
        getIntent().putExtra(AbsMsgImageActivityConfig.CURRENT_URL, str);
        getIntent().putExtra("id", "0");
        getIntent().putExtra(AbsMsgImageActivityConfig.ID_UNIQUE, str2);
    }
}
