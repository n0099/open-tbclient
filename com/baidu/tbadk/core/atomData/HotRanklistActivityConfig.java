package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes2.dex */
public class HotRanklistActivityConfig extends IntentConfig {
    public static final String ST_TYPE = "hot_ranklist";

    public HotRanklistActivityConfig(Context context) {
        super(context);
    }

    public HotRanklistActivityConfig createNormalConfig(String str, String str2) {
        Intent intent = getIntent();
        intent.putExtra("call_from", str);
        intent.putExtra("list_type", str2);
        return this;
    }
}
