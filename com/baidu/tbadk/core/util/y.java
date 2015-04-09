package com.baidu.tbadk.core.util;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.text.TextUtils;
/* loaded from: classes.dex */
public class y implements MediaScannerConnection.MediaScannerConnectionClient {
    private MediaScannerConnection TX;
    private String[] TY;
    private String[] TZ;
    private boolean Ua;
    private z Ub;
    private int length;
    private Context mContext;
    private String mMimeType;
    private String mPath;

    public y(Context context) {
        this.mContext = context;
        this.TX = new MediaScannerConnection(this.mContext, this);
    }

    public void cC(String str) {
        this.mPath = str;
        String substring = this.mPath.substring(this.mPath.lastIndexOf("."));
        this.mMimeType = "image/jpeg";
        if (substring.equals(".gif")) {
            this.mMimeType = "image/gif";
        }
        this.TX.connect();
    }

    @Override // android.media.MediaScannerConnection.MediaScannerConnectionClient
    public void onMediaScannerConnected() {
        if (!TextUtils.isEmpty(this.mPath) && !TextUtils.isEmpty(this.mMimeType)) {
            this.TX.scanFile(this.mPath, this.mMimeType);
        }
        if (this.TY != null && this.TZ != null && this.TY.length == this.TZ.length) {
            int length = this.TY.length;
            for (int i = 0; i < length; i++) {
                this.TX.scanFile(this.TY[i], this.TZ[i]);
            }
        }
    }

    @Override // android.media.MediaScannerConnection.OnScanCompletedListener
    public void onScanCompleted(String str, Uri uri) {
        if (!TextUtils.isEmpty(this.mPath) && !TextUtils.isEmpty(this.mMimeType) && str.equals(this.mPath)) {
            this.TX.disconnect();
            this.mPath = null;
            this.mMimeType = null;
            this.Ua = true;
        } else if (this.TY != null && this.TZ != null && this.TY.length == this.TZ.length) {
            this.length--;
            if (this.length == 0) {
                this.TX.disconnect();
                this.TY = null;
                this.TZ = null;
                this.Ua = true;
            } else {
                this.Ua = false;
            }
        }
        if (this.Ua && this.Ub != null) {
            this.Ub.sn();
        }
    }
}
