package com.baidu.tbadk.coreExtra.a;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.bd;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
/* loaded from: classes.dex */
public class a {
    private static a aay;
    private boolean aax;

    private a() {
        this.aax = false;
        try {
            if (!bd.isEmpty(new BufferedReader(new InputStreamReader(TbadkCoreApplication.m411getInst().getApp().getAssets().open("apk_ab_test.txt"))).readLine())) {
                this.aax = true;
            }
        } catch (Throwable th) {
            this.aax = false;
        }
    }

    public static synchronized a uu() {
        a aVar;
        synchronized (a.class) {
            if (aay == null) {
                aay = new a();
            }
            aVar = aay;
        }
        return aVar;
    }

    public boolean uv() {
        return this.aax;
    }

    public HttpURLConnection g(HttpURLConnection httpURLConnection) {
        if (this.aax && httpURLConnection != null) {
            httpURLConnection.setRequestProperty("Cookie", "pub_env=3;");
        }
        return httpURLConnection;
    }

    public String uw() {
        return this.aax ? "pub_env=3;" : "";
    }
}
