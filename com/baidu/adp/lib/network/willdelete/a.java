package com.baidu.adp.lib.network.willdelete;

import java.net.HttpURLConnection;
/* loaded from: classes.dex */
public class a {
    private HttpURLConnection a;
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
        this.a = httpURLConnection;
    }

    public void a() {
        this.b = true;
        if (this.a != null) {
            try {
                this.a.disconnect();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.a = null;
    }

    public void b() {
        this.a = null;
    }

    public boolean c() {
        return this.b;
    }
}
