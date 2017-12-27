package com.baidu.tbadk.core.util;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.text.TextUtils;
/* loaded from: classes.dex */
public class w implements MediaScannerConnection.MediaScannerConnectionClient {
    private MediaScannerConnection aUo;
    private String aUp;
    private String[] aUq;
    private String[] aUr;
    private boolean aUs;
    private a aUt;
    private int length;
    private Context mContext;
    private String mPath;

    /* loaded from: classes.dex */
    public interface a {
        void Cl();
    }

    public w(Context context) {
        this.mContext = context;
        this.aUo = new MediaScannerConnection(this.mContext, this);
    }

    public void dO(String str) {
        this.mPath = str;
        String substring = this.mPath.substring(this.mPath.lastIndexOf("."));
        this.aUp = "image/jpeg";
        if (substring.equals(".gif")) {
            this.aUp = "image/gif";
        }
        this.aUo.connect();
    }

    public void dP(String str) {
        this.mPath = str;
        this.aUp = dQ(str);
        this.aUo.connect();
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
        if (!TextUtils.isEmpty(this.mPath) && !TextUtils.isEmpty(this.aUp)) {
            this.aUo.scanFile(this.mPath, this.aUp);
        }
        if (this.aUq != null && this.aUr != null && this.aUq.length == this.aUr.length) {
            int length = this.aUq.length;
            for (int i = 0; i < length; i++) {
                this.aUo.scanFile(this.aUq[i], this.aUr[i]);
            }
        }
    }

    @Override // android.media.MediaScannerConnection.OnScanCompletedListener
    public void onScanCompleted(String str, Uri uri) {
        if (!TextUtils.isEmpty(this.mPath) && !TextUtils.isEmpty(this.aUp) && str.equals(this.mPath)) {
            this.aUo.disconnect();
            this.mPath = null;
            this.aUp = null;
            this.aUs = true;
        } else if (this.aUq != null && this.aUr != null && this.aUq.length == this.aUr.length) {
            this.length--;
            if (this.length == 0) {
                this.aUo.disconnect();
                this.aUq = null;
                this.aUr = null;
                this.aUs = true;
            } else {
                this.aUs = false;
            }
        }
        if (this.aUs && this.aUt != null) {
            this.aUt.Cl();
        }
    }
}
