package com.baidu.tbadk.coreExtra.a;

import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.az;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
/* loaded from: classes.dex */
public class a {
    private static a Ld;
    private boolean Lc;

    private a() {
        this.Lc = false;
        try {
            if (!az.aA(new BufferedReader(new InputStreamReader(TbadkApplication.m251getInst().getApp().getAssets().open("apk_ab_test.txt"))).readLine())) {
                this.Lc = true;
            }
        } catch (Throwable th) {
            this.Lc = false;
        }
    }

    public static synchronized a or() {
        a aVar;
        synchronized (a.class) {
            if (Ld == null) {
                Ld = new a();
            }
            aVar = Ld;
        }
        return aVar;
    }

    public boolean os() {
        return this.Lc;
    }

    public HttpURLConnection f(HttpURLConnection httpURLConnection) {
        if (this.Lc && httpURLConnection != null) {
            httpURLConnection.setRequestProperty("Cookie", "pub_env=3;");
        }
        return httpURLConnection;
    }

    public String ot() {
        return this.Lc ? "pub_env=3;" : "";
    }
}
