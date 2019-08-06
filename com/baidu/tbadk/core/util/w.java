package com.baidu.tbadk.core.util;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.text.TextUtils;
/* loaded from: classes.dex */
public class w implements MediaScannerConnection.MediaScannerConnectionClient {
    private MediaScannerConnection bSf;
    private String bSg;
    private String[] bSh;
    private a bSi;
    private boolean completed;
    private int length;
    private Context mContext;
    private String[] mPaths;
    private String wX;

    /* loaded from: classes.dex */
    public interface a {
        void aiE();
    }

    public w(Context context) {
        this.mContext = context;
        this.bSf = new MediaScannerConnection(this.mContext, this);
    }

    public void nP(String str) {
        this.wX = str;
        String substring = this.wX.substring(this.wX.lastIndexOf("."));
        this.bSg = "image/jpeg";
        if (substring.equals(".gif")) {
            this.bSg = "image/gif";
        }
        this.bSf.connect();
    }

    public void nQ(String str) {
        this.wX = str;
        this.bSg = ft(str);
        this.bSf.connect();
    }

    private String ft(String str) {
        String lowerCase = str.toLowerCase();
        if (!lowerCase.endsWith("mp4") && !lowerCase.endsWith("mpeg4") && lowerCase.endsWith("3gp")) {
            return "video/3gp";
        }
        return "video/mp4";
    }

    @Override // android.media.MediaScannerConnection.MediaScannerConnectionClient
    public void onMediaScannerConnected() {
        if (!TextUtils.isEmpty(this.wX) && !TextUtils.isEmpty(this.bSg)) {
            this.bSf.scanFile(this.wX, this.bSg);
        }
        if (this.mPaths != null && this.bSh != null && this.mPaths.length == this.bSh.length) {
            int length = this.mPaths.length;
            for (int i = 0; i < length; i++) {
                this.bSf.scanFile(this.mPaths[i], this.bSh[i]);
            }
        }
    }

    @Override // android.media.MediaScannerConnection.OnScanCompletedListener
    public void onScanCompleted(String str, Uri uri) {
        if (!TextUtils.isEmpty(this.wX) && !TextUtils.isEmpty(this.bSg) && str.equals(this.wX)) {
            this.bSf.disconnect();
            this.wX = null;
            this.bSg = null;
            this.completed = true;
        } else if (this.mPaths != null && this.bSh != null && this.mPaths.length == this.bSh.length) {
            this.length--;
            if (this.length == 0) {
                this.bSf.disconnect();
                this.mPaths = null;
                this.bSh = null;
                this.completed = true;
            } else {
                this.completed = false;
            }
        }
        if (this.completed && this.bSi != null) {
            this.bSi.aiE();
        }
    }
}
