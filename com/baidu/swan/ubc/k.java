package com.baidu.swan.ubc;

import android.content.Context;
import java.util.concurrent.ExecutorService;
import org.json.JSONArray;
/* loaded from: classes11.dex */
public interface k {
    void C(String str, int i);

    int Ol();

    ExecutorService PC();

    l Qp();

    void a(String str, int i, JSONArray jSONArray);

    void a(String str, String str2, int i, String str3, int i2);

    void a(String str, String str2, int i, String str3, long j, int i2);

    String acN();

    String ahx();

    boolean ahy();

    boolean ahz();

    String bQ(Context context);

    void c(String str, Object obj, int i);

    void f(String str, int i, String str2);

    String getAppId();

    String getAppVersion();

    String getDeviceId(Context context);

    String getHostName();

    String getUserId(Context context);

    boolean kV(String str);
}
