package com.baidu.adp.plugin.install;

import android.os.Handler;
import com.baidu.adp.base.BdBaseApplication;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements Runnable {
    private final /* synthetic */ String Dg;
    private final /* synthetic */ String Dh;
    final /* synthetic */ c this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar, String str, String str2) {
        this.this$0 = cVar;
        this.Dg = str;
        this.Dh = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        ArrayList arrayList;
        ArrayList arrayList2;
        Handler handler;
        HashMap hashMap;
        LinkedList linkedList;
        ArrayList arrayList3;
        ArrayList arrayList4;
        LinkedList linkedList2;
        arrayList = this.this$0.CZ;
        if (!arrayList.contains(this.Dg)) {
            arrayList2 = this.this$0.CZ;
            arrayList2.add(this.Dg);
            handler = c.ot;
            hashMap = this.this$0.De;
            handler.removeCallbacks((Runnable) hashMap.remove(this.Dg));
            linkedList = this.this$0.CX;
            if (linkedList.contains(this.Dg)) {
                linkedList2 = this.this$0.CX;
                linkedList2.remove(this.Dg);
            }
            arrayList3 = this.this$0.CY;
            if (arrayList3.contains(this.Dg)) {
                arrayList4 = this.this$0.CY;
                arrayList4.remove(this.Dg);
            }
            this.this$0.c(BdBaseApplication.getInst(), this.Dh, true);
            com.baidu.adp.plugin.b.a.lh().be("plugin_install_timeout");
            com.baidu.adp.plugin.b.a.lh().g("plugin_install", "timeout", this.Dg);
            return;
        }
        com.baidu.adp.plugin.b.a.lh().be("plugin_retry_install_timeout");
        com.baidu.adp.plugin.b.a.lh().g("plugin_install", "retry_timeout", this.Dg);
    }
}
