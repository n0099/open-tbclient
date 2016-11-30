package com.baidu.tbadk.core.util;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.text.TextUtils;
/* loaded from: classes.dex */
public class y implements MediaScannerConnection.MediaScannerConnectionClient {
    private MediaScannerConnection aaN;
    private String aaO;
    private String[] aaP;
    private String[] aaQ;
    private boolean aaR;
    private a aaS;
    private int length;
    private Context mContext;
    private String mPath;

    /* loaded from: classes.dex */
    public interface a {
        void uU();
    }

    public y(Context context) {
        this.mContext = context;
        this.aaN = new MediaScannerConnection(this.mContext, this);
    }

    public void dr(String str) {
        this.mPath = str;
        String substring = this.mPath.substring(this.mPath.lastIndexOf("."));
        this.aaO = "image/jpeg";
        if (substring.equals(".gif")) {
            this.aaO = "image/gif";
        }
        this.aaN.connect();
    }

    @Override // android.media.MediaScannerConnection.MediaScannerConnectionClient
    public void onMediaScannerConnected() {
        if (!TextUtils.isEmpty(this.mPath) && !TextUtils.isEmpty(this.aaO)) {
            this.aaN.scanFile(this.mPath, this.aaO);
        }
        if (this.aaP != null && this.aaQ != null && this.aaP.length == this.aaQ.length) {
            int length = this.aaP.length;
            for (int i = 0; i < length; i++) {
                this.aaN.scanFile(this.aaP[i], this.aaQ[i]);
            }
        }
    }

    @Override // android.media.MediaScannerConnection.OnScanCompletedListener
    public void onScanCompleted(String str, Uri uri) {
        if (!TextUtils.isEmpty(this.mPath) && !TextUtils.isEmpty(this.aaO) && str.equals(this.mPath)) {
            this.aaN.disconnect();
            this.mPath = null;
            this.aaO = null;
            this.aaR = true;
        } else if (this.aaP != null && this.aaQ != null && this.aaP.length == this.aaQ.length) {
            this.length--;
            if (this.length == 0) {
                this.aaN.disconnect();
                this.aaP = null;
                this.aaQ = null;
                this.aaR = true;
            } else {
                this.aaR = false;
            }
        }
        if (this.aaR && this.aaS != null) {
            this.aaS.uU();
        }
    }
}
