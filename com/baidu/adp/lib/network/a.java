package com.baidu.adp.lib.network;

import java.net.HttpURLConnection;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private HttpURLConnection f512a;
    private boolean b = false;

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(HttpURLConnection httpURLConnection) {
        if (this.b) {
            if (httpURLConnection != null) {
                try {
                    httpURLConnection.disconnect();
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            return;
        }
        this.f512a = httpURLConnection;
    }

    public void a() {
        this.b = true;
        if (this.f512a != null) {
            try {
                this.f512a.disconnect();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.f512a = null;
    }

    public void b() {
        this.f512a = null;
    }

    public boolean c() {
        return this.b;
    }
}
