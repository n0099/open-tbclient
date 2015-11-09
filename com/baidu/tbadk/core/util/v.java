package com.baidu.tbadk.core.util;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.text.TextUtils;
/* loaded from: classes.dex */
public class v implements MediaScannerConnection.MediaScannerConnectionClient {
    private MediaScannerConnection ZS;
    private String[] ZT;
    private String[] ZU;
    private boolean ZV;
    private a ZW;
    private int length;
    private Context mContext;
    private String mMimeType;
    private String mPath;

    /* loaded from: classes.dex */
    public interface a {
        void uf();
    }

    public v(Context context) {
        this.mContext = context;
        this.ZS = new MediaScannerConnection(this.mContext, this);
    }

    public void dd(String str) {
        this.mPath = str;
        String substring = this.mPath.substring(this.mPath.lastIndexOf("."));
        this.mMimeType = "image/jpeg";
        if (substring.equals(".gif")) {
            this.mMimeType = "image/gif";
        }
        this.ZS.connect();
    }

    @Override // android.media.MediaScannerConnection.MediaScannerConnectionClient
    public void onMediaScannerConnected() {
        if (!TextUtils.isEmpty(this.mPath) && !TextUtils.isEmpty(this.mMimeType)) {
            this.ZS.scanFile(this.mPath, this.mMimeType);
        }
        if (this.ZT != null && this.ZU != null && this.ZT.length == this.ZU.length) {
            int length = this.ZT.length;
            for (int i = 0; i < length; i++) {
                this.ZS.scanFile(this.ZT[i], this.ZU[i]);
            }
        }
    }

    @Override // android.media.MediaScannerConnection.OnScanCompletedListener
    public void onScanCompleted(String str, Uri uri) {
        if (!TextUtils.isEmpty(this.mPath) && !TextUtils.isEmpty(this.mMimeType) && str.equals(this.mPath)) {
            this.ZS.disconnect();
            this.mPath = null;
            this.mMimeType = null;
            this.ZV = true;
        } else if (this.ZT != null && this.ZU != null && this.ZT.length == this.ZU.length) {
            this.length--;
            if (this.length == 0) {
                this.ZS.disconnect();
                this.ZT = null;
                this.ZU = null;
                this.ZV = true;
            } else {
                this.ZV = false;
            }
        }
        if (this.ZV && this.ZW != null) {
            this.ZW.uf();
        }
    }
}
