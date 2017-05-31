package com.baidu.tbadk.core.util;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.text.TextUtils;
/* loaded from: classes.dex */
public class y implements MediaScannerConnection.MediaScannerConnectionClient {
    private MediaScannerConnection aek;
    private String ael;
    private String[] aem;
    private String[] aen;
    private boolean aeo;
    private a aep;
    private int length;
    private Context mContext;
    private String mPath;

    /* loaded from: classes.dex */
    public interface a {
        void uD();
    }

    public y(Context context) {
        this.mContext = context;
        this.aek = new MediaScannerConnection(this.mContext, this);
    }

    public void dl(String str) {
        this.mPath = str;
        String substring = this.mPath.substring(this.mPath.lastIndexOf("."));
        this.ael = "image/jpeg";
        if (substring.equals(".gif")) {
            this.ael = "image/gif";
        }
        this.aek.connect();
    }

    @Override // android.media.MediaScannerConnection.MediaScannerConnectionClient
    public void onMediaScannerConnected() {
        if (!TextUtils.isEmpty(this.mPath) && !TextUtils.isEmpty(this.ael)) {
            this.aek.scanFile(this.mPath, this.ael);
        }
        if (this.aem != null && this.aen != null && this.aem.length == this.aen.length) {
            int length = this.aem.length;
            for (int i = 0; i < length; i++) {
                this.aek.scanFile(this.aem[i], this.aen[i]);
            }
        }
    }

    @Override // android.media.MediaScannerConnection.OnScanCompletedListener
    public void onScanCompleted(String str, Uri uri) {
        if (!TextUtils.isEmpty(this.mPath) && !TextUtils.isEmpty(this.ael) && str.equals(this.mPath)) {
            this.aek.disconnect();
            this.mPath = null;
            this.ael = null;
            this.aeo = true;
        } else if (this.aem != null && this.aen != null && this.aem.length == this.aen.length) {
            this.length--;
            if (this.length == 0) {
                this.aek.disconnect();
                this.aem = null;
                this.aen = null;
                this.aeo = true;
            } else {
                this.aeo = false;
            }
        }
        if (this.aeo && this.aep != null) {
            this.aep.uD();
        }
    }
}
