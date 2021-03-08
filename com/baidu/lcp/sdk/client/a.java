package com.baidu.lcp.sdk.client;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.lcp.sdk.client.bean.BLCPRequest;
import com.baidu.lcp.sdk.d.e;
/* loaded from: classes3.dex */
public class a {
    public static void c(Context context, String str, String str2, int i) {
        c.vD().c(context, str, str2, i);
    }

    public static void a(@NonNull BLCPRequest bLCPRequest, @Nullable com.baidu.lcp.sdk.client.bean.b bVar) {
        c.vD().a(bLCPRequest, bVar);
    }

    public static boolean az(Context context) {
        return e.az(context);
    }

    public static int vC() {
        return c.vC();
    }

    public static void pingRequest() {
        c.vD().pingRequest();
    }
}
