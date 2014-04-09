package com.baidu.tbadk.core.b;

import android.content.Context;
/* loaded from: classes.dex */
public final class ai extends com.baidu.tbadk.core.frameworkData.a {
    public ai(Context context, String str, String str2, String str3, boolean z) {
        super(context);
        d().putExtra("thread_id", str);
        d().putExtra("post_id", str2);
        d().putExtra("post_desc", str3);
        d().putExtra("is_from_pb", z);
    }
}
