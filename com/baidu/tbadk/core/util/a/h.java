package com.baidu.tbadk.core.util.a;

import com.baidu.adp.lib.util.BdLog;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
/* loaded from: classes.dex */
class h implements Runnable {
    final /* synthetic */ f ahq;
    private final /* synthetic */ URL ahr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(f fVar, URL url) {
        this.ahq = fVar;
        this.ahr = url;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            BdLog.i("testcdn" + this.ahr.getHost());
            InetAddress.getByName(this.ahr.getHost()).getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
