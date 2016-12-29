package com.baidu.tbadk.core.util;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.text.TextUtils;
/* loaded from: classes.dex */
public class y implements MediaScannerConnection.MediaScannerConnectionClient {
    private MediaScannerConnection aah;
    private String aai;
    private String[] aaj;
    private String[] aak;
    private boolean aal;
    private a aam;
    private int length;
    private Context mContext;
    private String mPath;

    /* loaded from: classes.dex */
    public interface a {
        void uG();
    }

    public y(Context context) {
        this.mContext = context;
        this.aah = new MediaScannerConnection(this.mContext, this);
    }

    public void ds(String str) {
        this.mPath = str;
        String substring = this.mPath.substring(this.mPath.lastIndexOf("."));
        this.aai = "image/jpeg";
        if (substring.equals(".gif")) {
            this.aai = "image/gif";
        }
        this.aah.connect();
    }

    @Override // android.media.MediaScannerConnection.MediaScannerConnectionClient
    public void onMediaScannerConnected() {
        if (!TextUtils.isEmpty(this.mPath) && !TextUtils.isEmpty(this.aai)) {
            this.aah.scanFile(this.mPath, this.aai);
        }
        if (this.aaj != null && this.aak != null && this.aaj.length == this.aak.length) {
            int length = this.aaj.length;
            for (int i = 0; i < length; i++) {
                this.aah.scanFile(this.aaj[i], this.aak[i]);
            }
        }
    }

    @Override // android.media.MediaScannerConnection.OnScanCompletedListener
    public void onScanCompleted(String str, Uri uri) {
        if (!TextUtils.isEmpty(this.mPath) && !TextUtils.isEmpty(this.aai) && str.equals(this.mPath)) {
            this.aah.disconnect();
            this.mPath = null;
            this.aai = null;
            this.aal = true;
        } else if (this.aaj != null && this.aak != null && this.aaj.length == this.aak.length) {
            this.length--;
            if (this.length == 0) {
                this.aah.disconnect();
                this.aaj = null;
                this.aak = null;
                this.aal = true;
            } else {
                this.aal = false;
            }
        }
        if (this.aal && this.aam != null) {
            this.aam.uG();
        }
    }
}
