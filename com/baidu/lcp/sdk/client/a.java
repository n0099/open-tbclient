package com.baidu.lcp.sdk.client;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.baidu.lcp.sdk.client.bean.BLCPRequest;
import com.baidu.lcp.sdk.d.e;
/* loaded from: classes14.dex */
public class a {
    public static void c(Context context, String str, String str2, int i) {
        c.Ak().c(context, str, str2, i);
    }

    public static void a(@NonNull BLCPRequest bLCPRequest, @Nullable com.baidu.lcp.sdk.client.bean.b bVar) {
        c.Ak().a(bLCPRequest, bVar);
    }

    public static boolean aC(Context context) {
        return e.aC(context);
    }

    public static int Aj() {
        return c.Aj();
    }

    public static void pingRequest() {
        c.Ak().pingRequest();
    }
}
