package com.baidu.tbadk.core.util;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.text.TextUtils;
/* loaded from: classes.dex */
public class ab implements MediaScannerConnection.MediaScannerConnectionClient {
    private MediaScannerConnection Iu;
    private String[] Iv;
    private String[] Iw;
    private boolean Ix;
    private ac Iy;
    private int length;
    private Context mContext;
    private String mMimeType;
    private String mPath;

    public ab(Context context) {
        this.mContext = context;
        this.Iu = new MediaScannerConnection(this.mContext, this);
    }

    public void cw(String str) {
        this.mPath = str;
        String substring = this.mPath.substring(this.mPath.lastIndexOf("."));
        this.mMimeType = "image/jpeg";
        if (substring.equals(".gif")) {
            this.mMimeType = "image/gif";
        }
        this.Iu.connect();
    }

    @Override // android.media.MediaScannerConnection.MediaScannerConnectionClient
    public void onMediaScannerConnected() {
        if (!TextUtils.isEmpty(this.mPath) && !TextUtils.isEmpty(this.mMimeType)) {
            this.Iu.scanFile(this.mPath, this.mMimeType);
        }
        if (this.Iv != null && this.Iw != null && this.Iv.length == this.Iw.length) {
            int length = this.Iv.length;
            for (int i = 0; i < length; i++) {
                this.Iu.scanFile(this.Iv[i], this.Iw[i]);
            }
        }
    }

    @Override // android.media.MediaScannerConnection.OnScanCompletedListener
    public void onScanCompleted(String str, Uri uri) {
        if (!TextUtils.isEmpty(this.mPath) && !TextUtils.isEmpty(this.mMimeType) && str.equals(this.mPath)) {
            this.Iu.disconnect();
            this.mPath = null;
            this.mMimeType = null;
            this.Ix = true;
        } else if (this.Iv != null && this.Iw != null && this.Iv.length == this.Iw.length) {
            this.length--;
            if (this.length == 0) {
                this.Iu.disconnect();
                this.Iv = null;
                this.Iw = null;
                this.Ix = true;
            } else {
                this.Ix = false;
            }
        }
        if (this.Ix && this.Iy != null) {
            this.Iy.oX();
        }
    }
}
