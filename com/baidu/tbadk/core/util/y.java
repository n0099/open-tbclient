package com.baidu.tbadk.core.util;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.text.TextUtils;
/* loaded from: classes.dex */
public class y implements MediaScannerConnection.MediaScannerConnectionClient {
    private MediaScannerConnection afa;
    private String afb;
    private String[] afc;
    private String[] afd;
    private boolean afe;
    private a aff;
    private int length;
    private Context mContext;
    private String mPath;

    /* loaded from: classes.dex */
    public interface a {
        void vu();
    }

    public y(Context context) {
        this.mContext = context;
        this.afa = new MediaScannerConnection(this.mContext, this);
    }

    public void dq(String str) {
        this.mPath = str;
        String substring = this.mPath.substring(this.mPath.lastIndexOf("."));
        this.afb = "image/jpeg";
        if (substring.equals(".gif")) {
            this.afb = "image/gif";
        }
        this.afa.connect();
    }

    @Override // android.media.MediaScannerConnection.MediaScannerConnectionClient
    public void onMediaScannerConnected() {
        if (!TextUtils.isEmpty(this.mPath) && !TextUtils.isEmpty(this.afb)) {
            this.afa.scanFile(this.mPath, this.afb);
        }
        if (this.afc != null && this.afd != null && this.afc.length == this.afd.length) {
            int length = this.afc.length;
            for (int i = 0; i < length; i++) {
                this.afa.scanFile(this.afc[i], this.afd[i]);
            }
        }
    }

    @Override // android.media.MediaScannerConnection.OnScanCompletedListener
    public void onScanCompleted(String str, Uri uri) {
        if (!TextUtils.isEmpty(this.mPath) && !TextUtils.isEmpty(this.afb) && str.equals(this.mPath)) {
            this.afa.disconnect();
            this.mPath = null;
            this.afb = null;
            this.afe = true;
        } else if (this.afc != null && this.afd != null && this.afc.length == this.afd.length) {
            this.length--;
            if (this.length == 0) {
                this.afa.disconnect();
                this.afc = null;
                this.afd = null;
                this.afe = true;
            } else {
                this.afe = false;
            }
        }
        if (this.afe && this.aff != null) {
            this.aff.vu();
        }
    }
}
