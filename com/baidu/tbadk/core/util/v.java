package com.baidu.tbadk.core.util;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.text.TextUtils;
/* loaded from: classes.dex */
public class v implements MediaScannerConnection.MediaScannerConnectionClient {
    private String adV;
    private MediaScannerConnection agK;
    private String[] agL;
    private String[] agM;
    private boolean agN;
    private a agO;
    private int length;
    private Context mContext;
    private String mPath;

    /* loaded from: classes.dex */
    public interface a {
        void vj();
    }

    public v(Context context) {
        this.mContext = context;
        this.agK = new MediaScannerConnection(this.mContext, this);
    }

    public void dO(String str) {
        this.mPath = str;
        String substring = this.mPath.substring(this.mPath.lastIndexOf("."));
        this.adV = "image/jpeg";
        if (substring.equals(".gif")) {
            this.adV = "image/gif";
        }
        this.agK.connect();
    }

    public void scanFile(String str, String str2) {
        this.mPath = str;
        this.adV = str2;
        if (!TextUtils.isEmpty(this.mPath) && !TextUtils.isEmpty(this.adV)) {
            this.agK.connect();
            return;
        }
        this.mPath = null;
        this.adV = null;
    }

    @Override // android.media.MediaScannerConnection.MediaScannerConnectionClient
    public void onMediaScannerConnected() {
        if (!TextUtils.isEmpty(this.mPath) && !TextUtils.isEmpty(this.adV)) {
            this.agK.scanFile(this.mPath, this.adV);
        }
        if (this.agL != null && this.agM != null && this.agL.length == this.agM.length) {
            int length = this.agL.length;
            for (int i = 0; i < length; i++) {
                this.agK.scanFile(this.agL[i], this.agM[i]);
            }
        }
    }

    @Override // android.media.MediaScannerConnection.OnScanCompletedListener
    public void onScanCompleted(String str, Uri uri) {
        if (!TextUtils.isEmpty(this.mPath) && !TextUtils.isEmpty(this.adV) && str.equals(this.mPath)) {
            this.agK.disconnect();
            this.mPath = null;
            this.adV = null;
            this.agN = true;
        } else if (this.agL != null && this.agM != null && this.agL.length == this.agM.length) {
            this.length--;
            if (this.length == 0) {
                this.agK.disconnect();
                this.agL = null;
                this.agM = null;
                this.agN = true;
            } else {
                this.agN = false;
            }
        }
        if (this.agN && this.agO != null) {
            this.agO.vj();
        }
    }
}
