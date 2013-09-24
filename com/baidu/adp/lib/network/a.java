package com.baidu.adp.lib.network;

import java.net.HttpURLConnection;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private HttpURLConnection f452a;
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
        this.f452a = httpURLConnection;
    }

    public void a() {
        this.b = true;
        if (this.f452a != null) {
            try {
                this.f452a.disconnect();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.f452a = null;
    }

    public void b() {
        this.f452a = null;
    }

    public boolean c() {
        return this.b;
    }
}
