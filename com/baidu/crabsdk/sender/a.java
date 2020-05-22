package com.baidu.crabsdk.sender;

import android.content.Context;
/* loaded from: classes8.dex */
public abstract class a {
    public final int amq = 30000;
    public Context amr;

    public a(Context context) {
        this.amr = context;
    }

    public abstract void e(String str);
}
