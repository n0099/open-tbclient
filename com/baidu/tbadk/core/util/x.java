package com.baidu.tbadk.core.util;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.text.TextUtils;
/* loaded from: classes.dex */
public class x implements MediaScannerConnection.MediaScannerConnectionClient {
    private MediaScannerConnection apL;
    private String apM;
    private String[] apN;
    private String[] apO;
    private boolean apP;
    private a apQ;
    private int length;
    private Context mContext;
    private String mPath;

    /* loaded from: classes.dex */
    public interface a {
        void yV();
    }

    public x(Context context) {
        this.mContext = context;
        this.apL = new MediaScannerConnection(this.mContext, this);
    }

    public void eA(String str) {
        this.mPath = str;
        String substring = this.mPath.substring(this.mPath.lastIndexOf("."));
        this.apM = "image/jpeg";
        if (substring.equals(".gif")) {
            this.apM = "image/gif";
        }
        this.apL.connect();
    }

    public void eB(String str) {
        this.mPath = str;
        this.apM = eC(str);
        this.apL.connect();
    }

    private String eC(String str) {
        String lowerCase = str.toLowerCase();
        if (!lowerCase.endsWith("mp4") && !lowerCase.endsWith("mpeg4") && lowerCase.endsWith("3gp")) {
            return "video/3gp";
        }
        return "video/mp4";
    }

    @Override // android.media.MediaScannerConnection.MediaScannerConnectionClient
    public void onMediaScannerConnected() {
        if (!TextUtils.isEmpty(this.mPath) && !TextUtils.isEmpty(this.apM)) {
            this.apL.scanFile(this.mPath, this.apM);
        }
        if (this.apN != null && this.apO != null && this.apN.length == this.apO.length) {
            int length = this.apN.length;
            for (int i = 0; i < length; i++) {
                this.apL.scanFile(this.apN[i], this.apO[i]);
            }
        }
    }

    @Override // android.media.MediaScannerConnection.OnScanCompletedListener
    public void onScanCompleted(String str, Uri uri) {
        if (!TextUtils.isEmpty(this.mPath) && !TextUtils.isEmpty(this.apM) && str.equals(this.mPath)) {
            this.apL.disconnect();
            this.mPath = null;
            this.apM = null;
            this.apP = true;
        } else if (this.apN != null && this.apO != null && this.apN.length == this.apO.length) {
            this.length--;
            if (this.length == 0) {
                this.apL.disconnect();
                this.apN = null;
                this.apO = null;
                this.apP = true;
            } else {
                this.apP = false;
            }
        }
        if (this.apP && this.apQ != null) {
            this.apQ.yV();
        }
    }
}
