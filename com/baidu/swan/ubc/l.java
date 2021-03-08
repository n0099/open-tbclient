package com.baidu.swan.ubc;

import android.content.Context;
import java.util.concurrent.ExecutorService;
import org.json.JSONArray;
/* loaded from: classes14.dex */
public interface l {
    void P(String str, int i);

    void a(String str, int i, JSONArray jSONArray);

    void a(String str, String str2, int i, String str3, int i2);

    void a(String str, String str2, int i, String str3, long j, int i2);

    String aDA();

    boolean aDB();

    boolean aDC();

    boolean aDD();

    m aiI();

    ExecutorService aih();

    String ayl();

    String aym();

    String dc(Context context);

    String getAppId();

    String getAppVersion();

    String getDeviceId(Context context);

    int getFrameType();

    String getHostName();

    String getUserId(Context context);

    void i(String str, int i, String str2);

    boolean ql(String str);
}
