package com.baidu.tbadk.core.util;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.text.TextUtils;
/* loaded from: classes.dex */
public class z implements MediaScannerConnection.MediaScannerConnectionClient {
    private MediaScannerConnection aaE;
    private String[] aaF;
    private String[] aaG;
    private boolean aaH;
    private a aaI;
    private int length;
    private Context mContext;
    private String mMimeType;
    private String mPath;

    /* loaded from: classes.dex */
    public interface a {
        void uK();
    }

    public z(Context context) {
        this.mContext = context;
        this.aaE = new MediaScannerConnection(this.mContext, this);
    }

    public void dm(String str) {
        this.mPath = str;
        String substring = this.mPath.substring(this.mPath.lastIndexOf("."));
        this.mMimeType = "image/jpeg";
        if (substring.equals(".gif")) {
            this.mMimeType = "image/gif";
        }
        this.aaE.connect();
    }

    @Override // android.media.MediaScannerConnection.MediaScannerConnectionClient
    public void onMediaScannerConnected() {
        if (!TextUtils.isEmpty(this.mPath) && !TextUtils.isEmpty(this.mMimeType)) {
            this.aaE.scanFile(this.mPath, this.mMimeType);
        }
        if (this.aaF != null && this.aaG != null && this.aaF.length == this.aaG.length) {
            int length = this.aaF.length;
            for (int i = 0; i < length; i++) {
                this.aaE.scanFile(this.aaF[i], this.aaG[i]);
            }
        }
    }

    @Override // android.media.MediaScannerConnection.OnScanCompletedListener
    public void onScanCompleted(String str, Uri uri) {
        if (!TextUtils.isEmpty(this.mPath) && !TextUtils.isEmpty(this.mMimeType) && str.equals(this.mPath)) {
            this.aaE.disconnect();
            this.mPath = null;
            this.mMimeType = null;
            this.aaH = true;
        } else if (this.aaF != null && this.aaG != null && this.aaF.length == this.aaG.length) {
            this.length--;
            if (this.length == 0) {
                this.aaE.disconnect();
                this.aaF = null;
                this.aaG = null;
                this.aaH = true;
            } else {
                this.aaH = false;
            }
        }
        if (this.aaH && this.aaI != null) {
            this.aaI.uK();
        }
    }
}
