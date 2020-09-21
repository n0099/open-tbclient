package com.baidu.swan.ubc;

import android.content.Context;
import java.util.concurrent.ExecutorService;
import org.json.JSONArray;
/* loaded from: classes14.dex */
public interface l {
    void H(String str, int i);

    int Yy();

    void a(String str, int i, JSONArray jSONArray);

    void a(String str, String str2, int i, String str3, int i2);

    void a(String str, String str2, int i, String str3, long j, int i2);

    ExecutorService aaL();

    m abk();

    String aqG();

    String aqH();

    String avU();

    boolean avV();

    boolean avW();

    boolean avX();

    String ck(Context context);

    void f(String str, int i, String str2);

    String getAppId();

    String getAppVersion();

    String getDeviceId(Context context);

    String getHostName();

    String getUserId(Context context);

    boolean pk(String str);
}
