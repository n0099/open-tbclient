package com.baidu.adp.plugin.install;

import android.os.Handler;
import com.baidu.adp.base.BdBaseApplication;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements Runnable {
    private final /* synthetic */ String CX;
    private final /* synthetic */ String CY;
    final /* synthetic */ c this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar, String str, String str2) {
        this.this$0 = cVar;
        this.CX = str;
        this.CY = str2;
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
        arrayList = this.this$0.CQ;
        if (!arrayList.contains(this.CX)) {
            arrayList2 = this.this$0.CQ;
            arrayList2.add(this.CX);
            handler = c.oy;
            hashMap = this.this$0.CV;
            handler.removeCallbacks((Runnable) hashMap.remove(this.CX));
            linkedList = this.this$0.CO;
            if (linkedList.contains(this.CX)) {
                linkedList2 = this.this$0.CO;
                linkedList2.remove(this.CX);
            }
            arrayList3 = this.this$0.CP;
            if (arrayList3.contains(this.CX)) {
                arrayList4 = this.this$0.CP;
                arrayList4.remove(this.CX);
            }
            this.this$0.c(BdBaseApplication.getInst(), this.CY, true);
            com.baidu.adp.plugin.b.a.lB().bo("plugin_install_timeout");
            com.baidu.adp.plugin.b.a.lB().g("plugin_install", "timeout", this.CX);
            return;
        }
        com.baidu.adp.plugin.b.a.lB().bo("plugin_retry_install_timeout");
        com.baidu.adp.plugin.b.a.lB().g("plugin_install", "retry_timeout", this.CX);
    }
}
