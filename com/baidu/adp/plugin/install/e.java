package com.baidu.adp.plugin.install;

import android.os.Handler;
import com.baidu.adp.base.BdBaseApplication;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements Runnable {
    private final /* synthetic */ String sv;
    private final /* synthetic */ String sw;
    final /* synthetic */ c this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar, String str, String str2) {
        this.this$0 = cVar;
        this.sv = str;
        this.sw = str2;
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
        arrayList = this.this$0.sm;
        if (!arrayList.contains(this.sv)) {
            arrayList2 = this.this$0.sm;
            arrayList2.add(this.sv);
            handler = c.sHandler;
            hashMap = this.this$0.st;
            handler.removeCallbacks((Runnable) hashMap.remove(this.sv));
            linkedList = this.this$0.sk;
            if (linkedList.contains(this.sv)) {
                linkedList2 = this.this$0.sk;
                linkedList2.remove(this.sv);
            }
            arrayList3 = this.this$0.sl;
            if (arrayList3.contains(this.sv)) {
                arrayList4 = this.this$0.sl;
                arrayList4.remove(this.sv);
            }
            this.this$0.c(BdBaseApplication.getInst(), this.sw, true);
            com.baidu.adp.plugin.b.a.hU().aZ("plugin_install_timeout");
            com.baidu.adp.plugin.b.a.hU().g("plugin_install", "timeout", this.sv);
            return;
        }
        com.baidu.adp.plugin.b.a.hU().aZ("plugin_retry_install_timeout");
        com.baidu.adp.plugin.b.a.hU().g("plugin_install", "retry_timeout", this.sv);
    }
}
