package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.a;
/* loaded from: classes.dex */
public class LiveGroupHistoryActivityConfig extends a {
    public LiveGroupHistoryActivityConfig(Context context, String str) {
        super(context);
        getIntent().putExtra("group_id", str);
    }
}
