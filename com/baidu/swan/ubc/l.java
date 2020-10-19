package com.baidu.swan.ubc;

import android.content.Context;
import java.util.concurrent.ExecutorService;
import org.json.JSONArray;
/* loaded from: classes9.dex */
public interface l {
    void I(String str, int i);

    void a(String str, int i, JSONArray jSONArray);

    void a(String str, String str2, int i, String str3, int i2);

    void a(String str, String str2, int i, String str3, long j, int i2);

    int abk();

    m adW();

    ExecutorService adx();

    String ats();

    String att();

    String ayF();

    boolean ayG();

    boolean ayH();

    boolean ayI();

    String cq(Context context);

    String getAppId();

    String getAppVersion();

    String getDeviceId(Context context);

    String getHostName();

    String getUserId(Context context);

    void h(String str, int i, String str2);

    boolean pW(String str);
}
