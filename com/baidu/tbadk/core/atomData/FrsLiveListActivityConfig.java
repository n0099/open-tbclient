package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.a;
/* loaded from: classes.dex */
public class FrsLiveListActivityConfig extends a {
    public FrsLiveListActivityConfig(Context context, String str, boolean z) {
        super(context);
        getIntent().putExtra("forum_id", str);
        getIntent().putExtra("frs_manager", z);
    }
}
