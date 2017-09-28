package com.baidu.tbadk.core.util;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.text.TextUtils;
/* loaded from: classes.dex */
public class w implements MediaScannerConnection.MediaScannerConnectionClient {
    private MediaScannerConnection afA;
    private String afB;
    private String[] afC;
    private String[] afD;
    private boolean afE;
    private a afF;
    private int length;
    private Context mContext;
    private String mPath;

    /* loaded from: classes.dex */
    public interface a {
        void uL();
    }

    public w(Context context) {
        this.mContext = context;
        this.afA = new MediaScannerConnection(this.mContext, this);
    }

    public void dC(String str) {
        this.mPath = str;
        String substring = this.mPath.substring(this.mPath.lastIndexOf("."));
        this.afB = "image/jpeg";
        if (substring.equals(".gif")) {
            this.afB = "image/gif";
        }
        this.afA.connect();
    }

    public void scanFile(String str, String str2) {
        this.mPath = str;
        this.afB = str2;
        if (!TextUtils.isEmpty(this.mPath) && !TextUtils.isEmpty(this.afB)) {
            this.afA.connect();
            return;
        }
        this.mPath = null;
        this.afB = null;
    }

    @Override // android.media.MediaScannerConnection.MediaScannerConnectionClient
    public void onMediaScannerConnected() {
        if (!TextUtils.isEmpty(this.mPath) && !TextUtils.isEmpty(this.afB)) {
            this.afA.scanFile(this.mPath, this.afB);
        }
        if (this.afC != null && this.afD != null && this.afC.length == this.afD.length) {
            int length = this.afC.length;
            for (int i = 0; i < length; i++) {
                this.afA.scanFile(this.afC[i], this.afD[i]);
            }
        }
    }

    @Override // android.media.MediaScannerConnection.OnScanCompletedListener
    public void onScanCompleted(String str, Uri uri) {
        if (!TextUtils.isEmpty(this.mPath) && !TextUtils.isEmpty(this.afB) && str.equals(this.mPath)) {
            this.afA.disconnect();
            this.mPath = null;
            this.afB = null;
            this.afE = true;
        } else if (this.afC != null && this.afD != null && this.afC.length == this.afD.length) {
            this.length--;
            if (this.length == 0) {
                this.afA.disconnect();
                this.afC = null;
                this.afD = null;
                this.afE = true;
            } else {
                this.afE = false;
            }
        }
        if (this.afE && this.afF != null) {
            this.afF.uL();
        }
    }
}
