package com.baidu.tbadk.core.util;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.text.TextUtils;
/* loaded from: classes.dex */
public class z implements MediaScannerConnection.MediaScannerConnectionClient {
    private MediaScannerConnection aap;
    private String aaq;
    private String[] aar;
    private String[] aas;
    private boolean aat;
    private a aau;
    private int length;
    private Context mContext;
    private String mPath;

    /* loaded from: classes.dex */
    public interface a {
        void uQ();
    }

    public z(Context context) {
        this.mContext = context;
        this.aap = new MediaScannerConnection(this.mContext, this);
    }

    public void dp(String str) {
        this.mPath = str;
        String substring = this.mPath.substring(this.mPath.lastIndexOf("."));
        this.aaq = "image/jpeg";
        if (substring.equals(".gif")) {
            this.aaq = "image/gif";
        }
        this.aap.connect();
    }

    @Override // android.media.MediaScannerConnection.MediaScannerConnectionClient
    public void onMediaScannerConnected() {
        if (!TextUtils.isEmpty(this.mPath) && !TextUtils.isEmpty(this.aaq)) {
            this.aap.scanFile(this.mPath, this.aaq);
        }
        if (this.aar != null && this.aas != null && this.aar.length == this.aas.length) {
            int length = this.aar.length;
            for (int i = 0; i < length; i++) {
                this.aap.scanFile(this.aar[i], this.aas[i]);
            }
        }
    }

    @Override // android.media.MediaScannerConnection.OnScanCompletedListener
    public void onScanCompleted(String str, Uri uri) {
        if (!TextUtils.isEmpty(this.mPath) && !TextUtils.isEmpty(this.aaq) && str.equals(this.mPath)) {
            this.aap.disconnect();
            this.mPath = null;
            this.aaq = null;
            this.aat = true;
        } else if (this.aar != null && this.aas != null && this.aar.length == this.aas.length) {
            this.length--;
            if (this.length == 0) {
                this.aap.disconnect();
                this.aar = null;
                this.aas = null;
                this.aat = true;
            } else {
                this.aat = false;
            }
        }
        if (this.aat && this.aau != null) {
            this.aau.uQ();
        }
    }
}
