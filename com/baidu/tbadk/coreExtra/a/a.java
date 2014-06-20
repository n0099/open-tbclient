package com.baidu.tbadk.coreExtra.a;

import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.bg;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
/* loaded from: classes.dex */
public class a {
    private static a b;
    private boolean a;

    private a() {
        this.a = false;
        try {
            if (!bg.c(new BufferedReader(new InputStreamReader(TbadkApplication.m252getInst().getApp().getAssets().open("apk_ab_test.txt"))).readLine())) {
                this.a = true;
            }
        } catch (Throwable th) {
            this.a = false;
        }
    }

    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            if (b == null) {
                b = new a();
            }
            aVar = b;
        }
        return aVar;
    }

    public boolean b() {
        return this.a;
    }

    public HttpURLConnection a(HttpURLConnection httpURLConnection) {
        if (this.a && httpURLConnection != null) {
            httpURLConnection.setRequestProperty("Cookie", "pub_env=3;");
        }
        return httpURLConnection;
    }

    public String c() {
        return this.a ? "pub_env=3;" : "";
    }
}
