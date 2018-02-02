package com.baidu.tbadk.core.util;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.text.TextUtils;
/* loaded from: classes.dex */
public class w implements MediaScannerConnection.MediaScannerConnectionClient {
    private MediaScannerConnection aUq;
    private String aUr;
    private String[] aUs;
    private String[] aUt;
    private boolean aUu;
    private a aUv;
    private int length;
    private Context mContext;
    private String mPath;

    /* loaded from: classes.dex */
    public interface a {
        void Ce();
    }

    public w(Context context) {
        this.mContext = context;
        this.aUq = new MediaScannerConnection(this.mContext, this);
    }

    public void dU(String str) {
        this.mPath = str;
        String substring = this.mPath.substring(this.mPath.lastIndexOf("."));
        this.aUr = "image/jpeg";
        if (substring.equals(".gif")) {
            this.aUr = "image/gif";
        }
        this.aUq.connect();
    }

    public void dV(String str) {
        this.mPath = str;
        this.aUr = dW(str);
        this.aUq.connect();
    }

    private String dW(String str) {
        String lowerCase = str.toLowerCase();
        if (!lowerCase.endsWith("mp4") && !lowerCase.endsWith("mpeg4") && lowerCase.endsWith("3gp")) {
            return "video/3gp";
        }
        return "video/mp4";
    }

    @Override // android.media.MediaScannerConnection.MediaScannerConnectionClient
    public void onMediaScannerConnected() {
        if (!TextUtils.isEmpty(this.mPath) && !TextUtils.isEmpty(this.aUr)) {
            this.aUq.scanFile(this.mPath, this.aUr);
        }
        if (this.aUs != null && this.aUt != null && this.aUs.length == this.aUt.length) {
            int length = this.aUs.length;
            for (int i = 0; i < length; i++) {
                this.aUq.scanFile(this.aUs[i], this.aUt[i]);
            }
        }
    }

    @Override // android.media.MediaScannerConnection.OnScanCompletedListener
    public void onScanCompleted(String str, Uri uri) {
        if (!TextUtils.isEmpty(this.mPath) && !TextUtils.isEmpty(this.aUr) && str.equals(this.mPath)) {
            this.aUq.disconnect();
            this.mPath = null;
            this.aUr = null;
            this.aUu = true;
        } else if (this.aUs != null && this.aUt != null && this.aUs.length == this.aUt.length) {
            this.length--;
            if (this.length == 0) {
                this.aUq.disconnect();
                this.aUs = null;
                this.aUt = null;
                this.aUu = true;
            } else {
                this.aUu = false;
            }
        }
        if (this.aUu && this.aUv != null) {
            this.aUv.Ce();
        }
    }
}
