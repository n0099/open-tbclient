package com.baidu.tbadk.coreExtra.a;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.bd;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
/* loaded from: classes.dex */
public class a {
    private static a aaw;
    private boolean aav;

    private a() {
        this.aav = false;
        try {
            if (!bd.isEmpty(new BufferedReader(new InputStreamReader(TbadkCoreApplication.m411getInst().getApp().getAssets().open("apk_ab_test.txt"))).readLine())) {
                this.aav = true;
            }
        } catch (Throwable th) {
            this.aav = false;
        }
    }

    public static synchronized a uu() {
        a aVar;
        synchronized (a.class) {
            if (aaw == null) {
                aaw = new a();
            }
            aVar = aaw;
        }
        return aVar;
    }

    public boolean uv() {
        return this.aav;
    }

    public HttpURLConnection g(HttpURLConnection httpURLConnection) {
        if (this.aav && httpURLConnection != null) {
            httpURLConnection.setRequestProperty("Cookie", "pub_env=3;");
        }
        return httpURLConnection;
    }

    public String uw() {
        return this.aav ? "pub_env=3;" : "";
    }
}
