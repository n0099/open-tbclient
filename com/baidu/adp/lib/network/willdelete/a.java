package com.baidu.adp.lib.network.willdelete;

import java.net.HttpURLConnection;
/* loaded from: classes.dex */
public class a {
    private HttpURLConnection kM;
    private boolean kN = false;

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(HttpURLConnection httpURLConnection) {
        if (this.kN) {
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
        this.kM = httpURLConnection;
    }

    public void cancel() {
        this.kN = true;
        if (this.kM != null) {
            try {
                this.kM.disconnect();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.kM = null;
    }

    public void finish() {
        this.kM = null;
    }

    public boolean isCanceled() {
        return this.kN;
    }
}
