package com.baidu.tbadk.core.util;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.text.TextUtils;
/* loaded from: classes.dex */
public class y implements MediaScannerConnection.MediaScannerConnectionClient {
    private MediaScannerConnection TV;
    private String[] TW;
    private String[] TX;
    private boolean TY;
    private z TZ;
    private int length;
    private Context mContext;
    private String mMimeType;
    private String mPath;

    public y(Context context) {
        this.mContext = context;
        this.TV = new MediaScannerConnection(this.mContext, this);
    }

    public void cC(String str) {
        this.mPath = str;
        String substring = this.mPath.substring(this.mPath.lastIndexOf("."));
        this.mMimeType = "image/jpeg";
        if (substring.equals(".gif")) {
            this.mMimeType = "image/gif";
        }
        this.TV.connect();
    }

    @Override // android.media.MediaScannerConnection.MediaScannerConnectionClient
    public void onMediaScannerConnected() {
        if (!TextUtils.isEmpty(this.mPath) && !TextUtils.isEmpty(this.mMimeType)) {
            this.TV.scanFile(this.mPath, this.mMimeType);
        }
        if (this.TW != null && this.TX != null && this.TW.length == this.TX.length) {
            int length = this.TW.length;
            for (int i = 0; i < length; i++) {
                this.TV.scanFile(this.TW[i], this.TX[i]);
            }
        }
    }

    @Override // android.media.MediaScannerConnection.OnScanCompletedListener
    public void onScanCompleted(String str, Uri uri) {
        if (!TextUtils.isEmpty(this.mPath) && !TextUtils.isEmpty(this.mMimeType) && str.equals(this.mPath)) {
            this.TV.disconnect();
            this.mPath = null;
            this.mMimeType = null;
            this.TY = true;
        } else if (this.TW != null && this.TX != null && this.TW.length == this.TX.length) {
            this.length--;
            if (this.length == 0) {
                this.TV.disconnect();
                this.TW = null;
                this.TX = null;
                this.TY = true;
            } else {
                this.TY = false;
            }
        }
        if (this.TY && this.TZ != null) {
            this.TZ.sn();
        }
    }
}
