package com.baidu.tbadk.coreExtra.a;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.bf;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
/* loaded from: classes.dex */
public class a {
    private static a QM;
    private boolean QL;

    private a() {
        this.QL = false;
        try {
            if (!bf.isEmpty(new BufferedReader(new InputStreamReader(TbadkCoreApplication.m255getInst().getApp().getAssets().open("apk_ab_test.txt"))).readLine())) {
                this.QL = true;
            }
        } catch (Throwable th) {
            this.QL = false;
        }
    }

    public static synchronized a rx() {
        a aVar;
        synchronized (a.class) {
            if (QM == null) {
                QM = new a();
            }
            aVar = QM;
        }
        return aVar;
    }

    public boolean ry() {
        return this.QL;
    }

    public HttpURLConnection g(HttpURLConnection httpURLConnection) {
        if (this.QL && httpURLConnection != null) {
            httpURLConnection.setRequestProperty("Cookie", "pub_env=3;");
        }
        return httpURLConnection;
    }

    public String rz() {
        return this.QL ? "pub_env=3;" : "";
    }
}
