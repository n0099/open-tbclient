package com.baidu.tbadk.b;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.an;
/* loaded from: classes.dex */
public class d extends Thread {
    private int a;
    private int b;
    private String c = null;

    public d(int i, int i2) {
        this.a = 0;
        this.b = 0;
        this.a = i;
        this.b = i2;
    }

    public void a(String str) {
        this.c = str;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        an anVar = new an(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.LOAD_REG_PV_ADDRESS);
        anVar.a("img_num", String.valueOf(this.a));
        anVar.a("img_total", String.valueOf(this.b));
        if (this.c != null) {
            anVar.a("img_type", this.c);
        }
        anVar.i();
    }
}
