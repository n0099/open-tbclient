package com.baidu.swan.ubc;

import android.content.Context;
import java.util.concurrent.ExecutorService;
import org.json.JSONArray;
/* loaded from: classes6.dex */
public interface l {
    void M(String str, int i);

    void a(String str, int i, JSONArray jSONArray);

    void a(String str, String str2, int i, String str3, int i2);

    void a(String str, String str2, int i, String str3, long j, int i2);

    String aDb();

    boolean aDc();

    boolean aDd();

    boolean aDe();

    int afr();

    ExecutorService ahG();

    m aih();

    String axK();

    String axL();

    String de(Context context);

    String getAppId();

    String getAppVersion();

    String getDeviceId(Context context);

    String getHostName();

    String getUserId(Context context);

    void i(String str, int i, String str2);

    boolean pM(String str);
}
