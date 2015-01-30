package com.baidu.tbadk.coreExtra.a;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.bf;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
/* loaded from: classes.dex */
public class a {
    private static a QP;
    private boolean QO;

    private a() {
        this.QO = false;
        try {
            if (!bf.isEmpty(new BufferedReader(new InputStreamReader(TbadkCoreApplication.m255getInst().getApp().getAssets().open("apk_ab_test.txt"))).readLine())) {
                this.QO = true;
            }
        } catch (Throwable th) {
            this.QO = false;
        }
    }

    public static synchronized a rD() {
        a aVar;
        synchronized (a.class) {
            if (QP == null) {
                QP = new a();
            }
            aVar = QP;
        }
        return aVar;
    }

    public boolean rE() {
        return this.QO;
    }

    public HttpURLConnection g(HttpURLConnection httpURLConnection) {
        if (this.QO && httpURLConnection != null) {
            httpURLConnection.setRequestProperty("Cookie", "pub_env=3;");
        }
        return httpURLConnection;
    }

    public String rF() {
        return this.QO ? "pub_env=3;" : "";
    }
}
