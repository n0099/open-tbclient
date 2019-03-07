package cn.jiguang.d.d;

import java.net.InetAddress;
import java.net.UnknownHostException;
/* loaded from: classes3.dex */
final class h extends Thread {
    private String a;
    private InetAddress mc = null;

    public h(String str) {
        this.a = null;
        this.a = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final synchronized InetAddress bV() {
        return this.mc;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        try {
            this.mc = InetAddress.getByName(this.a);
        } catch (UnknownHostException e) {
            cn.jiguang.e.c.a("ConnectingHelper", "Unknown host exception!", e);
        } catch (Exception e2) {
            cn.jiguang.e.c.a("ConnectingHelper", "The failure appears to have been a lack of INTERNET !", e2);
        }
    }
}
