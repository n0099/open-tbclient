package com.baidu.tbadk.core.util;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.text.TextUtils;
/* loaded from: classes.dex */
public class v implements MediaScannerConnection.MediaScannerConnectionClient {
    private MediaScannerConnection ZO;
    private String[] ZP;
    private String[] ZQ;
    private boolean ZR;
    private a ZS;
    private int length;
    private Context mContext;
    private String mMimeType;
    private String mPath;

    /* loaded from: classes.dex */
    public interface a {
        void uc();
    }

    public v(Context context) {
        this.mContext = context;
        this.ZO = new MediaScannerConnection(this.mContext, this);
    }

    public void dd(String str) {
        this.mPath = str;
        String substring = this.mPath.substring(this.mPath.lastIndexOf("."));
        this.mMimeType = "image/jpeg";
        if (substring.equals(".gif")) {
            this.mMimeType = "image/gif";
        }
        this.ZO.connect();
    }

    @Override // android.media.MediaScannerConnection.MediaScannerConnectionClient
    public void onMediaScannerConnected() {
        if (!TextUtils.isEmpty(this.mPath) && !TextUtils.isEmpty(this.mMimeType)) {
            this.ZO.scanFile(this.mPath, this.mMimeType);
        }
        if (this.ZP != null && this.ZQ != null && this.ZP.length == this.ZQ.length) {
            int length = this.ZP.length;
            for (int i = 0; i < length; i++) {
                this.ZO.scanFile(this.ZP[i], this.ZQ[i]);
            }
        }
    }

    @Override // android.media.MediaScannerConnection.OnScanCompletedListener
    public void onScanCompleted(String str, Uri uri) {
        if (!TextUtils.isEmpty(this.mPath) && !TextUtils.isEmpty(this.mMimeType) && str.equals(this.mPath)) {
            this.ZO.disconnect();
            this.mPath = null;
            this.mMimeType = null;
            this.ZR = true;
        } else if (this.ZP != null && this.ZQ != null && this.ZP.length == this.ZQ.length) {
            this.length--;
            if (this.length == 0) {
                this.ZO.disconnect();
                this.ZP = null;
                this.ZQ = null;
                this.ZR = true;
            } else {
                this.ZR = false;
            }
        }
        if (this.ZR && this.ZS != null) {
            this.ZS.uc();
        }
    }
}
