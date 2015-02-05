package com.baidu.adp.plugin.install;

import android.os.Handler;
import com.baidu.adp.base.BdBaseApplication;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements Runnable {
    private final /* synthetic */ String ss;
    private final /* synthetic */ String st;
    final /* synthetic */ c this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar, String str, String str2) {
        this.this$0 = cVar;
        this.ss = str;
        this.st = str2;
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
        arrayList = this.this$0.sj;
        if (!arrayList.contains(this.ss)) {
            arrayList2 = this.this$0.sj;
            arrayList2.add(this.ss);
            handler = c.sHandler;
            hashMap = this.this$0.sq;
            handler.removeCallbacks((Runnable) hashMap.remove(this.ss));
            linkedList = this.this$0.sh;
            if (linkedList.contains(this.ss)) {
                linkedList2 = this.this$0.sh;
                linkedList2.remove(this.ss);
            }
            arrayList3 = this.this$0.si;
            if (arrayList3.contains(this.ss)) {
                arrayList4 = this.this$0.si;
                arrayList4.remove(this.ss);
            }
            this.this$0.c(BdBaseApplication.getInst(), this.st, true);
            com.baidu.adp.plugin.b.a.hN().aW("plugin_install_timeout");
            com.baidu.adp.plugin.b.a.hN().g("plugin_install", "timeout", this.ss);
            return;
        }
        com.baidu.adp.plugin.b.a.hN().aW("plugin_retry_install_timeout");
        com.baidu.adp.plugin.b.a.hN().g("plugin_install", "retry_timeout", this.ss);
    }
}
