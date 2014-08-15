package com.baidu.tbadk.c;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.ae;
/* loaded from: classes.dex */
public class e extends Thread {
    private int a;
    private int b;
    private String c = null;

    public e(int i, int i2) {
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
        ae aeVar = new ae(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.LOAD_REG_PV_ADDRESS);
        aeVar.a("img_num", String.valueOf(this.a));
        aeVar.a("img_total", String.valueOf(this.b));
        if (this.c != null) {
            aeVar.a("img_type", this.c);
        }
        aeVar.h();
    }
}
