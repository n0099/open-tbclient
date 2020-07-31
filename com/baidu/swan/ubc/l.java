package com.baidu.swan.ubc;

import android.content.Context;
import java.util.concurrent.ExecutorService;
import org.json.JSONArray;
/* loaded from: classes9.dex */
public interface l {
    void G(String str, int i);

    int RU();

    ExecutorService TZ();

    m Uz();

    void a(String str, int i, JSONArray jSONArray);

    void a(String str, String str2, int i, String str3, int i2);

    void a(String str, String str2, int i, String str3, long j, int i2);

    String air();

    String anq();

    boolean anr();

    boolean ans();

    boolean ant();

    String cf(Context context);

    void f(String str, int i, String str2);

    String getAppId();

    String getAppVersion();

    String getDeviceId(Context context);

    String getHostName();

    String getUserId(Context context);

    boolean mR(String str);
}
