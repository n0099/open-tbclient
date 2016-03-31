package com.baidu.tbadk.core.util;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.text.TextUtils;
/* loaded from: classes.dex */
public class z implements MediaScannerConnection.MediaScannerConnectionClient {
    private MediaScannerConnection aaP;
    private String aaQ;
    private String[] aaR;
    private String[] aaS;
    private boolean aaT;
    private a aaU;
    private int length;
    private Context mContext;
    private String mPath;

    /* loaded from: classes.dex */
    public interface a {
        void vS();
    }

    public z(Context context) {
        this.mContext = context;
        this.aaP = new MediaScannerConnection(this.mContext, this);
    }

    public void dq(String str) {
        this.mPath = str;
        String substring = this.mPath.substring(this.mPath.lastIndexOf("."));
        this.aaQ = "image/jpeg";
        if (substring.equals(".gif")) {
            this.aaQ = "image/gif";
        }
        this.aaP.connect();
    }

    @Override // android.media.MediaScannerConnection.MediaScannerConnectionClient
    public void onMediaScannerConnected() {
        if (!TextUtils.isEmpty(this.mPath) && !TextUtils.isEmpty(this.aaQ)) {
            this.aaP.scanFile(this.mPath, this.aaQ);
        }
        if (this.aaR != null && this.aaS != null && this.aaR.length == this.aaS.length) {
            int length = this.aaR.length;
            for (int i = 0; i < length; i++) {
                this.aaP.scanFile(this.aaR[i], this.aaS[i]);
            }
        }
    }

    @Override // android.media.MediaScannerConnection.OnScanCompletedListener
    public void onScanCompleted(String str, Uri uri) {
        if (!TextUtils.isEmpty(this.mPath) && !TextUtils.isEmpty(this.aaQ) && str.equals(this.mPath)) {
            this.aaP.disconnect();
            this.mPath = null;
            this.aaQ = null;
            this.aaT = true;
        } else if (this.aaR != null && this.aaS != null && this.aaR.length == this.aaS.length) {
            this.length--;
            if (this.length == 0) {
                this.aaP.disconnect();
                this.aaR = null;
                this.aaS = null;
                this.aaT = true;
            } else {
                this.aaT = false;
            }
        }
        if (this.aaT && this.aaU != null) {
            this.aaU.vS();
        }
    }
}
