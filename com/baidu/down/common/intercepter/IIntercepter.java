package com.baidu.down.common.intercepter;

import android.content.Context;
/* loaded from: classes4.dex */
public interface IIntercepter<T> {
    public static final String TYPE_NETWORK = "network";
    public static final String TYPE_RESPONSE = "response";

    InterceptResult process(Context context, String str, long j, T t);
}
