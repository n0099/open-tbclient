package com.baidu.tbadk.core.util;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.text.TextUtils;
/* loaded from: classes.dex */
public class w implements MediaScannerConnection.MediaScannerConnectionClient {
    private MediaScannerConnection bQZ;
    private String bRa;
    private String[] bRb;
    private a bRc;
    private boolean completed;
    private int length;
    private Context mContext;
    private String[] mPaths;
    private String wU;

    /* loaded from: classes.dex */
    public interface a {
        void ahA();
    }

    public w(Context context) {
        this.mContext = context;
        this.bQZ = new MediaScannerConnection(this.mContext, this);
    }

    public void nD(String str) {
        this.wU = str;
        String substring = this.wU.substring(this.wU.lastIndexOf("."));
        this.bRa = "image/jpeg";
        if (substring.equals(".gif")) {
            this.bRa = "image/gif";
        }
        this.bQZ.connect();
    }

    public void nE(String str) {
        this.wU = str;
        this.bRa = fo(str);
        this.bQZ.connect();
    }

    private String fo(String str) {
        String lowerCase = str.toLowerCase();
        if (!lowerCase.endsWith("mp4") && !lowerCase.endsWith("mpeg4") && lowerCase.endsWith("3gp")) {
            return "video/3gp";
        }
        return "video/mp4";
    }

    @Override // android.media.MediaScannerConnection.MediaScannerConnectionClient
    public void onMediaScannerConnected() {
        if (!TextUtils.isEmpty(this.wU) && !TextUtils.isEmpty(this.bRa)) {
            this.bQZ.scanFile(this.wU, this.bRa);
        }
        if (this.mPaths != null && this.bRb != null && this.mPaths.length == this.bRb.length) {
            int length = this.mPaths.length;
            for (int i = 0; i < length; i++) {
                this.bQZ.scanFile(this.mPaths[i], this.bRb[i]);
            }
        }
    }

    @Override // android.media.MediaScannerConnection.OnScanCompletedListener
    public void onScanCompleted(String str, Uri uri) {
        if (!TextUtils.isEmpty(this.wU) && !TextUtils.isEmpty(this.bRa) && str.equals(this.wU)) {
            this.bQZ.disconnect();
            this.wU = null;
            this.bRa = null;
            this.completed = true;
        } else if (this.mPaths != null && this.bRb != null && this.mPaths.length == this.bRb.length) {
            this.length--;
            if (this.length == 0) {
                this.bQZ.disconnect();
                this.mPaths = null;
                this.bRb = null;
                this.completed = true;
            } else {
                this.completed = false;
            }
        }
        if (this.completed && this.bRc != null) {
            this.bRc.ahA();
        }
    }
}
