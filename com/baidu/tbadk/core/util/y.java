package com.baidu.tbadk.core.util;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.text.TextUtils;
/* loaded from: classes.dex */
public class y implements MediaScannerConnection.MediaScannerConnectionClient {
    private MediaScannerConnection abE;
    private String[] abF;
    private String[] abG;
    private boolean abH;
    private a abI;
    private int length;
    private Context mContext;
    private String mMimeType;
    private String mPath;

    /* loaded from: classes.dex */
    public interface a {
        void vz();
    }

    public y(Context context) {
        this.mContext = context;
        this.abE = new MediaScannerConnection(this.mContext, this);
    }

    public void dm(String str) {
        this.mPath = str;
        String substring = this.mPath.substring(this.mPath.lastIndexOf("."));
        this.mMimeType = "image/jpeg";
        if (substring.equals(".gif")) {
            this.mMimeType = "image/gif";
        }
        this.abE.connect();
    }

    @Override // android.media.MediaScannerConnection.MediaScannerConnectionClient
    public void onMediaScannerConnected() {
        if (!TextUtils.isEmpty(this.mPath) && !TextUtils.isEmpty(this.mMimeType)) {
            this.abE.scanFile(this.mPath, this.mMimeType);
        }
        if (this.abF != null && this.abG != null && this.abF.length == this.abG.length) {
            int length = this.abF.length;
            for (int i = 0; i < length; i++) {
                this.abE.scanFile(this.abF[i], this.abG[i]);
            }
        }
    }

    @Override // android.media.MediaScannerConnection.OnScanCompletedListener
    public void onScanCompleted(String str, Uri uri) {
        if (!TextUtils.isEmpty(this.mPath) && !TextUtils.isEmpty(this.mMimeType) && str.equals(this.mPath)) {
            this.abE.disconnect();
            this.mPath = null;
            this.mMimeType = null;
            this.abH = true;
        } else if (this.abF != null && this.abG != null && this.abF.length == this.abG.length) {
            this.length--;
            if (this.length == 0) {
                this.abE.disconnect();
                this.abF = null;
                this.abG = null;
                this.abH = true;
            } else {
                this.abH = false;
            }
        }
        if (this.abH && this.abI != null) {
            this.abI.vz();
        }
    }
}
