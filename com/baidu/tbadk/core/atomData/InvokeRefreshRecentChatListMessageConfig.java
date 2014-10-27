package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.a;
/* loaded from: classes.dex */
public class InvokeRefreshRecentChatListMessageConfig extends a {
    public InvokeRefreshRecentChatListMessageConfig(Context context, boolean z) {
        super(context);
        getIntent().putExtra("isNeedShowNotify", z);
    }
}
