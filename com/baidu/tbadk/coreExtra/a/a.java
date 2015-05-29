package com.baidu.tbadk.coreExtra.a;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.bb;
import java.io.BufferedReader;
import java.io.InputStreamReader;
/* loaded from: classes.dex */
public class a {
    private static a abC;
    private boolean abB;

    private a() {
        this.abB = false;
        try {
            if (!bb.isEmpty(new BufferedReader(new InputStreamReader(TbadkCoreApplication.m411getInst().getApp().getAssets().open("apk_ab_test.txt"))).readLine())) {
                this.abB = true;
            }
        } catch (Throwable th) {
            this.abB = false;
        }
    }

    public static synchronized a vd() {
        a aVar;
        synchronized (a.class) {
            if (abC == null) {
                abC = new a();
            }
            aVar = abC;
        }
        return aVar;
    }

    public boolean ve() {
        return this.abB;
    }

    public String vf() {
        return this.abB ? "pub_env=3;" : "";
    }
}
