package com.baidu.tbadk.core.util;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.text.TextUtils;
/* loaded from: classes.dex */
public class v implements MediaScannerConnection.MediaScannerConnectionClient {
    private MediaScannerConnection ZM;
    private String[] ZN;
    private String[] ZO;
    private boolean ZP;
    private a ZQ;
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
        this.ZM = new MediaScannerConnection(this.mContext, this);
    }

    public void dc(String str) {
        this.mPath = str;
        String substring = this.mPath.substring(this.mPath.lastIndexOf("."));
        this.mMimeType = "image/jpeg";
        if (substring.equals(".gif")) {
            this.mMimeType = "image/gif";
        }
        this.ZM.connect();
    }

    @Override // android.media.MediaScannerConnection.MediaScannerConnectionClient
    public void onMediaScannerConnected() {
        if (!TextUtils.isEmpty(this.mPath) && !TextUtils.isEmpty(this.mMimeType)) {
            this.ZM.scanFile(this.mPath, this.mMimeType);
        }
        if (this.ZN != null && this.ZO != null && this.ZN.length == this.ZO.length) {
            int length = this.ZN.length;
            for (int i = 0; i < length; i++) {
                this.ZM.scanFile(this.ZN[i], this.ZO[i]);
            }
        }
    }

    @Override // android.media.MediaScannerConnection.OnScanCompletedListener
    public void onScanCompleted(String str, Uri uri) {
        if (!TextUtils.isEmpty(this.mPath) && !TextUtils.isEmpty(this.mMimeType) && str.equals(this.mPath)) {
            this.ZM.disconnect();
            this.mPath = null;
            this.mMimeType = null;
            this.ZP = true;
        } else if (this.ZN != null && this.ZO != null && this.ZN.length == this.ZO.length) {
            this.length--;
            if (this.length == 0) {
                this.ZM.disconnect();
                this.ZN = null;
                this.ZO = null;
                this.ZP = true;
            } else {
                this.ZP = false;
            }
        }
        if (this.ZP && this.ZQ != null) {
            this.ZQ.uf();
        }
    }
}
