package cn.jiguang.d.d;

import java.net.InetAddress;
import java.net.UnknownHostException;
/* loaded from: classes3.dex */
final class h extends Thread {
    private String a;
    private InetAddress lu = null;

    public h(String str) {
        this.a = null;
        this.a = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final synchronized InetAddress bF() {
        return this.lu;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        try {
            this.lu = InetAddress.getByName(this.a);
        } catch (UnknownHostException e) {
            cn.jiguang.e.c.a("ConnectingHelper", "Unknown host exception!", e);
        } catch (Exception e2) {
            cn.jiguang.e.c.a("ConnectingHelper", "The failure appears to have been a lack of INTERNET !", e2);
        }
    }
}
