package com.baidu.android.imsdk.mcast;

import android.content.Context;
/* loaded from: classes5.dex */
public class CastServiceFactory {
    public static UnLoginCastService createCastService(Context context) {
        return new UnLoginCastService(context);
    }
}
