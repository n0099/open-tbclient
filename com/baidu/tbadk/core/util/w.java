package com.baidu.tbadk.core.util;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.text.TextUtils;
/* loaded from: classes.dex */
public class w implements MediaScannerConnection.MediaScannerConnectionClient {
    private MediaScannerConnection aUn;
    private String aUo;
    private String[] aUp;
    private String[] aUq;
    private boolean aUr;
    private a aUs;
    private int length;
    private Context mContext;
    private String mPath;

    /* loaded from: classes.dex */
    public interface a {
        void Cd();
    }

    public w(Context context) {
        this.mContext = context;
        this.aUn = new MediaScannerConnection(this.mContext, this);
    }

    public void dO(String str) {
        this.mPath = str;
        String substring = this.mPath.substring(this.mPath.lastIndexOf("."));
        this.aUo = "image/jpeg";
        if (substring.equals(".gif")) {
            this.aUo = "image/gif";
        }
        this.aUn.connect();
    }

    public void dP(String str) {
        this.mPath = str;
        this.aUo = dQ(str);
        this.aUn.connect();
    }

    private String dQ(String str) {
        String lowerCase = str.toLowerCase();
        if (!lowerCase.endsWith("mp4") && !lowerCase.endsWith("mpeg4") && lowerCase.endsWith("3gp")) {
            return "video/3gp";
        }
        return "video/mp4";
    }

    @Override // android.media.MediaScannerConnection.MediaScannerConnectionClient
    public void onMediaScannerConnected() {
        if (!TextUtils.isEmpty(this.mPath) && !TextUtils.isEmpty(this.aUo)) {
            this.aUn.scanFile(this.mPath, this.aUo);
        }
        if (this.aUp != null && this.aUq != null && this.aUp.length == this.aUq.length) {
            int length = this.aUp.length;
            for (int i = 0; i < length; i++) {
                this.aUn.scanFile(this.aUp[i], this.aUq[i]);
            }
        }
    }

    @Override // android.media.MediaScannerConnection.OnScanCompletedListener
    public void onScanCompleted(String str, Uri uri) {
        if (!TextUtils.isEmpty(this.mPath) && !TextUtils.isEmpty(this.aUo) && str.equals(this.mPath)) {
            this.aUn.disconnect();
            this.mPath = null;
            this.aUo = null;
            this.aUr = true;
        } else if (this.aUp != null && this.aUq != null && this.aUp.length == this.aUq.length) {
            this.length--;
            if (this.length == 0) {
                this.aUn.disconnect();
                this.aUp = null;
                this.aUq = null;
                this.aUr = true;
            } else {
                this.aUr = false;
            }
        }
        if (this.aUr && this.aUs != null) {
            this.aUs.Cd();
        }
    }
}
