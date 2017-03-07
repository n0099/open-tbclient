package com.baidu.tbadk.core.util;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.text.TextUtils;
/* loaded from: classes.dex */
public class y implements MediaScannerConnection.MediaScannerConnectionClient {
    private MediaScannerConnection aeL;
    private String aeM;
    private String[] aeN;
    private String[] aeO;
    private boolean aeP;
    private a aeQ;
    private int length;
    private Context mContext;
    private String mPath;

    /* loaded from: classes.dex */
    public interface a {
        void uX();
    }

    public y(Context context) {
        this.mContext = context;
        this.aeL = new MediaScannerConnection(this.mContext, this);
    }

    public void dj(String str) {
        this.mPath = str;
        String substring = this.mPath.substring(this.mPath.lastIndexOf("."));
        this.aeM = "image/jpeg";
        if (substring.equals(".gif")) {
            this.aeM = "image/gif";
        }
        this.aeL.connect();
    }

    @Override // android.media.MediaScannerConnection.MediaScannerConnectionClient
    public void onMediaScannerConnected() {
        if (!TextUtils.isEmpty(this.mPath) && !TextUtils.isEmpty(this.aeM)) {
            this.aeL.scanFile(this.mPath, this.aeM);
        }
        if (this.aeN != null && this.aeO != null && this.aeN.length == this.aeO.length) {
            int length = this.aeN.length;
            for (int i = 0; i < length; i++) {
                this.aeL.scanFile(this.aeN[i], this.aeO[i]);
            }
        }
    }

    @Override // android.media.MediaScannerConnection.OnScanCompletedListener
    public void onScanCompleted(String str, Uri uri) {
        if (!TextUtils.isEmpty(this.mPath) && !TextUtils.isEmpty(this.aeM) && str.equals(this.mPath)) {
            this.aeL.disconnect();
            this.mPath = null;
            this.aeM = null;
            this.aeP = true;
        } else if (this.aeN != null && this.aeO != null && this.aeN.length == this.aeO.length) {
            this.length--;
            if (this.length == 0) {
                this.aeL.disconnect();
                this.aeN = null;
                this.aeO = null;
                this.aeP = true;
            } else {
                this.aeP = false;
            }
        }
        if (this.aeP && this.aeQ != null) {
            this.aeQ.uX();
        }
    }
}
