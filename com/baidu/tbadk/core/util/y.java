package com.baidu.tbadk.core.util;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.text.TextUtils;
/* loaded from: classes.dex */
public class y implements MediaScannerConnection.MediaScannerConnectionClient {
    private MediaScannerConnection aeZ;
    private String afa;
    private String[] afb;
    private String[] afc;
    private boolean afd;
    private a afe;
    private int length;
    private Context mContext;
    private String mPath;

    /* loaded from: classes.dex */
    public interface a {
        void vu();
    }

    public y(Context context) {
        this.mContext = context;
        this.aeZ = new MediaScannerConnection(this.mContext, this);
    }

    public void dq(String str) {
        this.mPath = str;
        String substring = this.mPath.substring(this.mPath.lastIndexOf("."));
        this.afa = "image/jpeg";
        if (substring.equals(".gif")) {
            this.afa = "image/gif";
        }
        this.aeZ.connect();
    }

    @Override // android.media.MediaScannerConnection.MediaScannerConnectionClient
    public void onMediaScannerConnected() {
        if (!TextUtils.isEmpty(this.mPath) && !TextUtils.isEmpty(this.afa)) {
            this.aeZ.scanFile(this.mPath, this.afa);
        }
        if (this.afb != null && this.afc != null && this.afb.length == this.afc.length) {
            int length = this.afb.length;
            for (int i = 0; i < length; i++) {
                this.aeZ.scanFile(this.afb[i], this.afc[i]);
            }
        }
    }

    @Override // android.media.MediaScannerConnection.OnScanCompletedListener
    public void onScanCompleted(String str, Uri uri) {
        if (!TextUtils.isEmpty(this.mPath) && !TextUtils.isEmpty(this.afa) && str.equals(this.mPath)) {
            this.aeZ.disconnect();
            this.mPath = null;
            this.afa = null;
            this.afd = true;
        } else if (this.afb != null && this.afc != null && this.afb.length == this.afc.length) {
            this.length--;
            if (this.length == 0) {
                this.aeZ.disconnect();
                this.afb = null;
                this.afc = null;
                this.afd = true;
            } else {
                this.afd = false;
            }
        }
        if (this.afd && this.afe != null) {
            this.afe.vu();
        }
    }
}
