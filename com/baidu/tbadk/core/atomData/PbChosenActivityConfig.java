package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.a;
/* loaded from: classes.dex */
public class PbChosenActivityConfig extends a {
    public static final String KEY_SHARE_URL = "share_url";
    public static final String KEY_TID = "ftid";

    public PbChosenActivityConfig(Context context, long j, String str) {
        super(context);
        getIntent().putExtra(KEY_TID, j);
        getIntent().putExtra(KEY_SHARE_URL, str);
    }
}
