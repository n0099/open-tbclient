package com.baidu.tbadk.core.util.a;

import com.baidu.adp.lib.util.BdLog;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
/* loaded from: classes.dex */
class h implements Runnable {
    final /* synthetic */ f Zo;
    private final /* synthetic */ URL Zp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(f fVar, URL url) {
        this.Zo = fVar;
        this.Zp = url;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            BdLog.i("testcdn" + this.Zp.getHost());
            InetAddress.getByName(this.Zp.getHost()).getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
