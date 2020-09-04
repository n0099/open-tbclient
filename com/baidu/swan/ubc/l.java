package com.baidu.swan.ubc;

import android.content.Context;
import java.util.concurrent.ExecutorService;
import org.json.JSONArray;
/* loaded from: classes10.dex */
public interface l {
    void H(String str, int i);

    int XP();

    void a(String str, int i, JSONArray jSONArray);

    void a(String str, String str2, int i, String str3, int i2);

    void a(String str, String str2, int i, String str3, long j, int i2);

    m aaB();

    ExecutorService aac();

    String apW();

    String apX();

    String avl();

    boolean avm();

    boolean avn();

    boolean avo();

    String cl(Context context);

    void f(String str, int i, String str2);

    String getAppId();

    String getAppVersion();

    String getDeviceId(Context context);

    String getHostName();

    String getUserId(Context context);

    boolean oR(String str);
}
