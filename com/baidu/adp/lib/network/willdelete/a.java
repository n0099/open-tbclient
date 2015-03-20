package com.baidu.adp.lib.network.willdelete;

import java.net.HttpURLConnection;
/* loaded from: classes.dex */
public class a {
    private HttpURLConnection wa;
    private boolean wb = false;

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(HttpURLConnection httpURLConnection) {
        if (this.wb) {
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
        this.wa = httpURLConnection;
    }

    public void cancel() {
        this.wb = true;
        if (this.wa != null) {
            try {
                this.wa.disconnect();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.wa = null;
    }

    public void finish() {
        this.wa = null;
    }

    public boolean isCanceled() {
        return this.wb;
    }
}
