package com.baidu.tbadk.core.util.a;

import com.baidu.adp.lib.util.BdLog;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
/* loaded from: classes.dex */
class h implements Runnable {
    final /* synthetic */ f agO;
    private final /* synthetic */ URL agP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(f fVar, URL url) {
        this.agO = fVar;
        this.agP = url;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            BdLog.i("testcdn" + this.agP.getHost());
            InetAddress.getByName(this.agP.getHost()).getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
