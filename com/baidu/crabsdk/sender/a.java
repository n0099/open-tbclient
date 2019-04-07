package com.baidu.crabsdk.sender;

import android.content.Context;
/* loaded from: classes3.dex */
public abstract class a {
    public Context ack;
    public final int bt = 30000;

    public a(Context context) {
        this.ack = context;
    }

    public abstract void d(String str);
}
