package com.baidu.tbadk.core.util;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.text.TextUtils;
/* loaded from: classes.dex */
public class aa implements MediaScannerConnection.MediaScannerConnectionClient {
    private String acd;
    private MediaScannerConnection aeT;
    private String[] aeU;
    private String[] aeV;
    private boolean aeW;
    private a aeX;
    private int length;
    private Context mContext;
    private String mPath;

    /* loaded from: classes.dex */
    public interface a {
        void uT();
    }

    public aa(Context context) {
        this.mContext = context;
        this.aeT = new MediaScannerConnection(this.mContext, this);
    }

    public void dF(String str) {
        this.mPath = str;
        String substring = this.mPath.substring(this.mPath.lastIndexOf("."));
        this.acd = "image/jpeg";
        if (substring.equals(".gif")) {
            this.acd = "image/gif";
        }
        this.aeT.connect();
    }

    @Override // android.media.MediaScannerConnection.MediaScannerConnectionClient
    public void onMediaScannerConnected() {
        if (!TextUtils.isEmpty(this.mPath) && !TextUtils.isEmpty(this.acd)) {
            this.aeT.scanFile(this.mPath, this.acd);
        }
        if (this.aeU != null && this.aeV != null && this.aeU.length == this.aeV.length) {
            int length = this.aeU.length;
            for (int i = 0; i < length; i++) {
                this.aeT.scanFile(this.aeU[i], this.aeV[i]);
            }
        }
    }

    @Override // android.media.MediaScannerConnection.OnScanCompletedListener
    public void onScanCompleted(String str, Uri uri) {
        if (!TextUtils.isEmpty(this.mPath) && !TextUtils.isEmpty(this.acd) && str.equals(this.mPath)) {
            this.aeT.disconnect();
            this.mPath = null;
            this.acd = null;
            this.aeW = true;
        } else if (this.aeU != null && this.aeV != null && this.aeU.length == this.aeV.length) {
            this.length--;
            if (this.length == 0) {
                this.aeT.disconnect();
                this.aeU = null;
                this.aeV = null;
                this.aeW = true;
            } else {
                this.aeW = false;
            }
        }
        if (this.aeW && this.aeX != null) {
            this.aeX.uT();
        }
    }
}
