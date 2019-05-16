package com.baidu.tbadk.core.util;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.text.TextUtils;
/* loaded from: classes.dex */
public class w implements MediaScannerConnection.MediaScannerConnectionClient {
    private MediaScannerConnection bQY;
    private String bQZ;
    private String[] bRa;
    private a bRb;
    private boolean completed;
    private int length;
    private Context mContext;
    private String[] mPaths;
    private String wV;

    /* loaded from: classes.dex */
    public interface a {
        void ahA();
    }

    public w(Context context) {
        this.mContext = context;
        this.bQY = new MediaScannerConnection(this.mContext, this);
    }

    public void nE(String str) {
        this.wV = str;
        String substring = this.wV.substring(this.wV.lastIndexOf("."));
        this.bQZ = "image/jpeg";
        if (substring.equals(".gif")) {
            this.bQZ = "image/gif";
        }
        this.bQY.connect();
    }

    public void nF(String str) {
        this.wV = str;
        this.bQZ = fp(str);
        this.bQY.connect();
    }

    private String fp(String str) {
        String lowerCase = str.toLowerCase();
        if (!lowerCase.endsWith("mp4") && !lowerCase.endsWith("mpeg4") && lowerCase.endsWith("3gp")) {
            return "video/3gp";
        }
        return "video/mp4";
    }

    @Override // android.media.MediaScannerConnection.MediaScannerConnectionClient
    public void onMediaScannerConnected() {
        if (!TextUtils.isEmpty(this.wV) && !TextUtils.isEmpty(this.bQZ)) {
            this.bQY.scanFile(this.wV, this.bQZ);
        }
        if (this.mPaths != null && this.bRa != null && this.mPaths.length == this.bRa.length) {
            int length = this.mPaths.length;
            for (int i = 0; i < length; i++) {
                this.bQY.scanFile(this.mPaths[i], this.bRa[i]);
            }
        }
    }

    @Override // android.media.MediaScannerConnection.OnScanCompletedListener
    public void onScanCompleted(String str, Uri uri) {
        if (!TextUtils.isEmpty(this.wV) && !TextUtils.isEmpty(this.bQZ) && str.equals(this.wV)) {
            this.bQY.disconnect();
            this.wV = null;
            this.bQZ = null;
            this.completed = true;
        } else if (this.mPaths != null && this.bRa != null && this.mPaths.length == this.bRa.length) {
            this.length--;
            if (this.length == 0) {
                this.bQY.disconnect();
                this.mPaths = null;
                this.bRa = null;
                this.completed = true;
            } else {
                this.completed = false;
            }
        }
        if (this.completed && this.bRb != null) {
            this.bRb.ahA();
        }
    }
}
