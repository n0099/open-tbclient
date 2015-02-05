package com.baidu.tbadk.core.util;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.text.TextUtils;
/* loaded from: classes.dex */
public class ab implements MediaScannerConnection.MediaScannerConnectionClient {
    private MediaScannerConnection Ir;
    private String[] Is;
    private String[] It;
    private boolean Iu;
    private ac Iv;
    private int length;
    private Context mContext;
    private String mMimeType;
    private String mPath;

    public ab(Context context) {
        this.mContext = context;
        this.Ir = new MediaScannerConnection(this.mContext, this);
    }

    public void ct(String str) {
        this.mPath = str;
        String substring = this.mPath.substring(this.mPath.lastIndexOf("."));
        this.mMimeType = "image/jpeg";
        if (substring.equals(".gif")) {
            this.mMimeType = "image/gif";
        }
        this.Ir.connect();
    }

    @Override // android.media.MediaScannerConnection.MediaScannerConnectionClient
    public void onMediaScannerConnected() {
        if (!TextUtils.isEmpty(this.mPath) && !TextUtils.isEmpty(this.mMimeType)) {
            this.Ir.scanFile(this.mPath, this.mMimeType);
        }
        if (this.Is != null && this.It != null && this.Is.length == this.It.length) {
            int length = this.Is.length;
            for (int i = 0; i < length; i++) {
                this.Ir.scanFile(this.Is[i], this.It[i]);
            }
        }
    }

    @Override // android.media.MediaScannerConnection.OnScanCompletedListener
    public void onScanCompleted(String str, Uri uri) {
        if (!TextUtils.isEmpty(this.mPath) && !TextUtils.isEmpty(this.mMimeType) && str.equals(this.mPath)) {
            this.Ir.disconnect();
            this.mPath = null;
            this.mMimeType = null;
            this.Iu = true;
        } else if (this.Is != null && this.It != null && this.Is.length == this.It.length) {
            this.length--;
            if (this.length == 0) {
                this.Ir.disconnect();
                this.Is = null;
                this.It = null;
                this.Iu = true;
            } else {
                this.Iu = false;
            }
        }
        if (this.Iu && this.Iv != null) {
            this.Iv.oQ();
        }
    }
}
