package com.baidu.tbadk.core.util.a;

import com.baidu.adp.lib.util.BdLog;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
/* loaded from: classes.dex */
class h implements Runnable {
    final /* synthetic */ f ahE;
    private final /* synthetic */ URL ahF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(f fVar, URL url) {
        this.ahE = fVar;
        this.ahF = url;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            BdLog.i("testcdn" + this.ahF.getHost());
            InetAddress.getByName(this.ahF.getHost()).getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
