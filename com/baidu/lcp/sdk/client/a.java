package com.baidu.lcp.sdk.client;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.lcp.sdk.client.bean.BLCPRequest;
import com.baidu.lcp.sdk.d.e;
/* loaded from: classes3.dex */
public class a {
    public static void c(Context context, String str, String str2, int i) {
        c.zy().c(context, str, str2, i);
    }

    public static void a(@NonNull BLCPRequest bLCPRequest, @Nullable com.baidu.lcp.sdk.client.bean.b bVar) {
        c.zy().a(bLCPRequest, bVar);
    }

    public static boolean aB(Context context) {
        return e.aB(context);
    }

    public static int zx() {
        return c.zx();
    }

    public static void pingRequest() {
        c.zy().pingRequest();
    }
}
