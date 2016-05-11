package com.baidu.tbadk.core.util.a;

import com.baidu.adp.lib.util.BdLog;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
/* loaded from: classes.dex */
class h implements Runnable {
    final /* synthetic */ f YX;
    private final /* synthetic */ URL YY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(f fVar, URL url) {
        this.YX = fVar;
        this.YY = url;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            BdLog.i("testcdn" + this.YY.getHost());
            InetAddress.getByName(this.YY.getHost()).getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
