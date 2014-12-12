package com.baidu.adp.lib.network.willdelete;

import java.net.HttpURLConnection;
/* loaded from: classes.dex */
public class a {
    private HttpURLConnection kJ;
    private boolean kK = false;

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(HttpURLConnection httpURLConnection) {
        if (this.kK) {
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
        this.kJ = httpURLConnection;
    }

    public void cancel() {
        this.kK = true;
        if (this.kJ != null) {
            try {
                this.kJ.disconnect();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.kJ = null;
    }

    public void finish() {
        this.kJ = null;
    }

    public boolean isCanceled() {
        return this.kK;
    }
}
