package com.baidu.adp.lib.network.willdelete;

import java.net.HttpURLConnection;
/* loaded from: classes.dex */
public class a {
    private HttpURLConnection kI;
    private boolean kJ = false;

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(HttpURLConnection httpURLConnection) {
        if (this.kJ) {
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
        this.kI = httpURLConnection;
    }

    public void cancel() {
        this.kJ = true;
        if (this.kI != null) {
            try {
                this.kI.disconnect();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.kI = null;
    }

    public void finish() {
        this.kI = null;
    }

    public boolean isCanceled() {
        return this.kJ;
    }
}
