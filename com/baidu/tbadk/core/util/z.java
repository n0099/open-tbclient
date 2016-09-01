package com.baidu.tbadk.core.util;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.text.TextUtils;
/* loaded from: classes.dex */
public class z implements MediaScannerConnection.MediaScannerConnectionClient {
    private MediaScannerConnection aac;
    private String aad;
    private String[] aae;
    private String[] aaf;
    private boolean aag;
    private a aah;
    private int length;
    private Context mContext;
    private String mPath;

    /* loaded from: classes.dex */
    public interface a {
        void uB();
    }

    public z(Context context) {
        this.mContext = context;
        this.aac = new MediaScannerConnection(this.mContext, this);
    }

    public void dn(String str) {
        this.mPath = str;
        String substring = this.mPath.substring(this.mPath.lastIndexOf("."));
        this.aad = "image/jpeg";
        if (substring.equals(".gif")) {
            this.aad = "image/gif";
        }
        this.aac.connect();
    }

    @Override // android.media.MediaScannerConnection.MediaScannerConnectionClient
    public void onMediaScannerConnected() {
        if (!TextUtils.isEmpty(this.mPath) && !TextUtils.isEmpty(this.aad)) {
            this.aac.scanFile(this.mPath, this.aad);
        }
        if (this.aae != null && this.aaf != null && this.aae.length == this.aaf.length) {
            int length = this.aae.length;
            for (int i = 0; i < length; i++) {
                this.aac.scanFile(this.aae[i], this.aaf[i]);
            }
        }
    }

    @Override // android.media.MediaScannerConnection.OnScanCompletedListener
    public void onScanCompleted(String str, Uri uri) {
        if (!TextUtils.isEmpty(this.mPath) && !TextUtils.isEmpty(this.aad) && str.equals(this.mPath)) {
            this.aac.disconnect();
            this.mPath = null;
            this.aad = null;
            this.aag = true;
        } else if (this.aae != null && this.aaf != null && this.aae.length == this.aaf.length) {
            this.length--;
            if (this.length == 0) {
                this.aac.disconnect();
                this.aae = null;
                this.aaf = null;
                this.aag = true;
            } else {
                this.aag = false;
            }
        }
        if (this.aag && this.aah != null) {
            this.aah.uB();
        }
    }
}
