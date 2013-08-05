package com.baidu.adp.lib.network;

import java.net.HttpURLConnection;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private HttpURLConnection f429a;
    private boolean b;

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
        this.f429a = httpURLConnection;
    }

    public void a() {
        this.f429a = null;
    }

    public boolean b() {
        return this.b;
    }
}
