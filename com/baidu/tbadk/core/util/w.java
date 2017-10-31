package com.baidu.tbadk.core.util;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.text.TextUtils;
/* loaded from: classes.dex */
public class w implements MediaScannerConnection.MediaScannerConnectionClient {
    private MediaScannerConnection afJ;
    private String afK;
    private String[] afL;
    private String[] afM;
    private boolean afN;
    private a afO;
    private int length;
    private Context mContext;
    private String mPath;

    /* loaded from: classes.dex */
    public interface a {
        void uL();
    }

    public w(Context context) {
        this.mContext = context;
        this.afJ = new MediaScannerConnection(this.mContext, this);
    }

    public void dH(String str) {
        this.mPath = str;
        String substring = this.mPath.substring(this.mPath.lastIndexOf("."));
        this.afK = "image/jpeg";
        if (substring.equals(".gif")) {
            this.afK = "image/gif";
        }
        this.afJ.connect();
    }

    public void scanFile(String str, String str2) {
        this.mPath = str;
        this.afK = str2;
        if (!TextUtils.isEmpty(this.mPath) && !TextUtils.isEmpty(this.afK)) {
            this.afJ.connect();
            return;
        }
        this.mPath = null;
        this.afK = null;
    }

    @Override // android.media.MediaScannerConnection.MediaScannerConnectionClient
    public void onMediaScannerConnected() {
        if (!TextUtils.isEmpty(this.mPath) && !TextUtils.isEmpty(this.afK)) {
            this.afJ.scanFile(this.mPath, this.afK);
        }
        if (this.afL != null && this.afM != null && this.afL.length == this.afM.length) {
            int length = this.afL.length;
            for (int i = 0; i < length; i++) {
                this.afJ.scanFile(this.afL[i], this.afM[i]);
            }
        }
    }

    @Override // android.media.MediaScannerConnection.OnScanCompletedListener
    public void onScanCompleted(String str, Uri uri) {
        if (!TextUtils.isEmpty(this.mPath) && !TextUtils.isEmpty(this.afK) && str.equals(this.mPath)) {
            this.afJ.disconnect();
            this.mPath = null;
            this.afK = null;
            this.afN = true;
        } else if (this.afL != null && this.afM != null && this.afL.length == this.afM.length) {
            this.length--;
            if (this.length == 0) {
                this.afJ.disconnect();
                this.afL = null;
                this.afM = null;
                this.afN = true;
            } else {
                this.afN = false;
            }
        }
        if (this.afN && this.afO != null) {
            this.afO.uL();
        }
    }
}
