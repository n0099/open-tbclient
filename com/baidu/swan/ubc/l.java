package com.baidu.swan.ubc;

import android.content.Context;
import java.util.concurrent.ExecutorService;
import org.json.JSONArray;
/* loaded from: classes11.dex */
public interface l {
    void G(String str, int i);

    int Qz();

    m ST();

    ExecutorService St();

    void a(String str, int i, JSONArray jSONArray);

    void a(String str, String str2, int i, String str3, int i2);

    void a(String str, String str2, int i, String str3, long j, int i2);

    String afW();

    String akR();

    boolean akS();

    boolean akT();

    boolean akU();

    String cb(Context context);

    void f(String str, int i, String str2);

    String getAppId();

    String getAppVersion();

    String getDeviceId(Context context);

    String getHostName();

    String getUserId(Context context);

    boolean mj(String str);
}
