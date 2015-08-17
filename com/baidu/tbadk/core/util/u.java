package com.baidu.tbadk.core.util;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.text.TextUtils;
/* loaded from: classes.dex */
public class u implements MediaScannerConnection.MediaScannerConnectionClient {
    private MediaScannerConnection ZJ;
    private String[] ZK;
    private String[] ZL;
    private boolean ZM;
    private a ZN;
    private int length;
    private Context mContext;
    private String mMimeType;
    private String mPath;

    /* loaded from: classes.dex */
    public interface a {
        void uc();
    }

    public u(Context context) {
        this.mContext = context;
        this.ZJ = new MediaScannerConnection(this.mContext, this);
    }

    public void cT(String str) {
        this.mPath = str;
        String substring = this.mPath.substring(this.mPath.lastIndexOf("."));
        this.mMimeType = "image/jpeg";
        if (substring.equals(".gif")) {
            this.mMimeType = "image/gif";
        }
        this.ZJ.connect();
    }

    @Override // android.media.MediaScannerConnection.MediaScannerConnectionClient
    public void onMediaScannerConnected() {
        if (!TextUtils.isEmpty(this.mPath) && !TextUtils.isEmpty(this.mMimeType)) {
            this.ZJ.scanFile(this.mPath, this.mMimeType);
        }
        if (this.ZK != null && this.ZL != null && this.ZK.length == this.ZL.length) {
            int length = this.ZK.length;
            for (int i = 0; i < length; i++) {
                this.ZJ.scanFile(this.ZK[i], this.ZL[i]);
            }
        }
    }

    @Override // android.media.MediaScannerConnection.OnScanCompletedListener
    public void onScanCompleted(String str, Uri uri) {
        if (!TextUtils.isEmpty(this.mPath) && !TextUtils.isEmpty(this.mMimeType) && str.equals(this.mPath)) {
            this.ZJ.disconnect();
            this.mPath = null;
            this.mMimeType = null;
            this.ZM = true;
        } else if (this.ZK != null && this.ZL != null && this.ZK.length == this.ZL.length) {
            this.length--;
            if (this.length == 0) {
                this.ZJ.disconnect();
                this.ZK = null;
                this.ZL = null;
                this.ZM = true;
            } else {
                this.ZM = false;
            }
        }
        if (this.ZM && this.ZN != null) {
            this.ZN.uc();
        }
    }
}
