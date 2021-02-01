package com.baidu.swan.ubc;

import android.content.Context;
import java.util.concurrent.ExecutorService;
import org.json.JSONArray;
/* loaded from: classes15.dex */
public interface l {
    void O(String str, int i);

    void a(String str, int i, JSONArray jSONArray);

    void a(String str, String str2, int i, String str3, int i2);

    void a(String str, String str2, int i, String str3, long j, int i2);

    boolean aDA();

    String aDx();

    boolean aDy();

    boolean aDz();

    m aiF();

    ExecutorService aie();

    String ayi();

    String ayj();

    String dd(Context context);

    String getAppId();

    String getAppVersion();

    String getDeviceId(Context context);

    int getFrameType();

    String getHostName();

    String getUserId(Context context);

    void i(String str, int i, String str2);

    boolean qe(String str);
}
