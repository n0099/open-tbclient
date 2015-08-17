package com.baidu.tbadk.coreExtra.a;

import com.baidu.adp.lib.util.o;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aq;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
/* loaded from: classes.dex */
public class a {
    private static a agJ;
    private boolean agI;

    private a() {
        this.agI = false;
        try {
            InputStream open = TbadkCoreApplication.m411getInst().getApp().getAssets().open("apk_ab_test.txt");
            if (!aq.isEmpty(new BufferedReader(new InputStreamReader(open)).readLine())) {
                this.agI = true;
            }
            o.d(open);
        } catch (Throwable th) {
            try {
                this.agI = false;
                o.d(null);
            } catch (Throwable th2) {
                o.d(null);
                throw th2;
            }
        }
    }

    public static synchronized a wl() {
        a aVar;
        synchronized (a.class) {
            if (agJ == null) {
                agJ = new a();
            }
            aVar = agJ;
        }
        return aVar;
    }

    public boolean wm() {
        return this.agI;
    }

    public String wn() {
        return this.agI ? "pub_env=3;" : "";
    }
}
