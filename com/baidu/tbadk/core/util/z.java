package com.baidu.tbadk.core.util;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.text.TextUtils;
/* loaded from: classes.dex */
public class z implements MediaScannerConnection.MediaScannerConnectionClient {
    private MediaScannerConnection abh;
    private String[] abi;
    private String[] abj;
    private boolean abk;
    private a abl;
    private int length;
    private Context mContext;
    private String mMimeType;
    private String mPath;

    /* loaded from: classes.dex */
    public interface a {
        void uu();
    }

    public z(Context context) {
        this.mContext = context;
        this.abh = new MediaScannerConnection(this.mContext, this);
    }

    public void dq(String str) {
        this.mPath = str;
        String substring = this.mPath.substring(this.mPath.lastIndexOf("."));
        this.mMimeType = "image/jpeg";
        if (substring.equals(".gif")) {
            this.mMimeType = "image/gif";
        }
        this.abh.connect();
    }

    @Override // android.media.MediaScannerConnection.MediaScannerConnectionClient
    public void onMediaScannerConnected() {
        if (!TextUtils.isEmpty(this.mPath) && !TextUtils.isEmpty(this.mMimeType)) {
            this.abh.scanFile(this.mPath, this.mMimeType);
        }
        if (this.abi != null && this.abj != null && this.abi.length == this.abj.length) {
            int length = this.abi.length;
            for (int i = 0; i < length; i++) {
                this.abh.scanFile(this.abi[i], this.abj[i]);
            }
        }
    }

    @Override // android.media.MediaScannerConnection.OnScanCompletedListener
    public void onScanCompleted(String str, Uri uri) {
        if (!TextUtils.isEmpty(this.mPath) && !TextUtils.isEmpty(this.mMimeType) && str.equals(this.mPath)) {
            this.abh.disconnect();
            this.mPath = null;
            this.mMimeType = null;
            this.abk = true;
        } else if (this.abi != null && this.abj != null && this.abi.length == this.abj.length) {
            this.length--;
            if (this.length == 0) {
                this.abh.disconnect();
                this.abi = null;
                this.abj = null;
                this.abk = true;
            } else {
                this.abk = false;
            }
        }
        if (this.abk && this.abl != null) {
            this.abl.uu();
        }
    }
}
