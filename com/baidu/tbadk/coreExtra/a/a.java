package com.baidu.tbadk.coreExtra.a;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ba;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
/* loaded from: classes.dex */
public class a {
    private static a Qo;
    private boolean Qn;

    private a() {
        this.Qn = false;
        try {
            if (!ba.isEmpty(new BufferedReader(new InputStreamReader(TbadkCoreApplication.m255getInst().getApp().getAssets().open("apk_ab_test.txt"))).readLine())) {
                this.Qn = true;
            }
        } catch (Throwable th) {
            this.Qn = false;
        }
    }

    public static synchronized a rr() {
        a aVar;
        synchronized (a.class) {
            if (Qo == null) {
                Qo = new a();
            }
            aVar = Qo;
        }
        return aVar;
    }

    public boolean rs() {
        return this.Qn;
    }

    public HttpURLConnection g(HttpURLConnection httpURLConnection) {
        if (this.Qn && httpURLConnection != null) {
            httpURLConnection.setRequestProperty("Cookie", "pub_env=3;");
        }
        return httpURLConnection;
    }

    public String rt() {
        return this.Qn ? "pub_env=3;" : "";
    }
}
