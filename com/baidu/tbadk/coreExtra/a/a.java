package com.baidu.tbadk.coreExtra.a;

import com.baidu.adp.lib.util.o;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aq;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
/* loaded from: classes.dex */
public class a {
    private static a agT;
    private boolean agS;

    private a() {
        this.agS = false;
        try {
            InputStream open = TbadkCoreApplication.m411getInst().getApp().getAssets().open("apk_ab_test.txt");
            if (!aq.isEmpty(new BufferedReader(new InputStreamReader(open)).readLine())) {
                this.agS = true;
            }
            o.d(open);
        } catch (Throwable th) {
            try {
                this.agS = false;
                o.d(null);
            } catch (Throwable th2) {
                o.d(null);
                throw th2;
            }
        }
    }

    public static synchronized a wq() {
        a aVar;
        synchronized (a.class) {
            if (agT == null) {
                agT = new a();
            }
            aVar = agT;
        }
        return aVar;
    }

    public boolean wr() {
        return this.agS;
    }

    public String ws() {
        return this.agS ? "pub_env=3;" : "";
    }
}
