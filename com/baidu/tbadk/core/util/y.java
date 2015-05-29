package com.baidu.tbadk.core.util;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.text.TextUtils;
/* loaded from: classes.dex */
public class y implements MediaScannerConnection.MediaScannerConnectionClient {
    private MediaScannerConnection UH;
    private String[] UI;
    private String[] UJ;
    private boolean UK;
    private z UL;
    private int length;
    private Context mContext;
    private String mMimeType;
    private String mPath;

    public y(Context context) {
        this.mContext = context;
        this.UH = new MediaScannerConnection(this.mContext, this);
    }

    public void cR(String str) {
        this.mPath = str;
        String substring = this.mPath.substring(this.mPath.lastIndexOf("."));
        this.mMimeType = "image/jpeg";
        if (substring.equals(".gif")) {
            this.mMimeType = "image/gif";
        }
        this.UH.connect();
    }

    @Override // android.media.MediaScannerConnection.MediaScannerConnectionClient
    public void onMediaScannerConnected() {
        if (!TextUtils.isEmpty(this.mPath) && !TextUtils.isEmpty(this.mMimeType)) {
            this.UH.scanFile(this.mPath, this.mMimeType);
        }
        if (this.UI != null && this.UJ != null && this.UI.length == this.UJ.length) {
            int length = this.UI.length;
            for (int i = 0; i < length; i++) {
                this.UH.scanFile(this.UI[i], this.UJ[i]);
            }
        }
    }

    @Override // android.media.MediaScannerConnection.OnScanCompletedListener
    public void onScanCompleted(String str, Uri uri) {
        if (!TextUtils.isEmpty(this.mPath) && !TextUtils.isEmpty(this.mMimeType) && str.equals(this.mPath)) {
            this.UH.disconnect();
            this.mPath = null;
            this.mMimeType = null;
            this.UK = true;
        } else if (this.UI != null && this.UJ != null && this.UI.length == this.UJ.length) {
            this.length--;
            if (this.length == 0) {
                this.UH.disconnect();
                this.UI = null;
                this.UJ = null;
                this.UK = true;
            } else {
                this.UK = false;
            }
        }
        if (this.UK && this.UL != null) {
            this.UL.sV();
        }
    }
}
