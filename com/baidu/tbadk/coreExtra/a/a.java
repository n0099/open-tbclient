package com.baidu.tbadk.coreExtra.a;

import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.ay;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
/* loaded from: classes.dex */
public class a {
    private static a Lc;
    private boolean Lb;

    private a() {
        this.Lb = false;
        try {
            if (!ay.aA(new BufferedReader(new InputStreamReader(TbadkApplication.m251getInst().getApp().getAssets().open("apk_ab_test.txt"))).readLine())) {
                this.Lb = true;
            }
        } catch (Throwable th) {
            this.Lb = false;
        }
    }

    public static synchronized a or() {
        a aVar;
        synchronized (a.class) {
            if (Lc == null) {
                Lc = new a();
            }
            aVar = Lc;
        }
        return aVar;
    }

    public boolean os() {
        return this.Lb;
    }

    public HttpURLConnection f(HttpURLConnection httpURLConnection) {
        if (this.Lb && httpURLConnection != null) {
            httpURLConnection.setRequestProperty("Cookie", "pub_env=3;");
        }
        return httpURLConnection;
    }

    public String ot() {
        return this.Lb ? "pub_env=3;" : "";
    }
}
