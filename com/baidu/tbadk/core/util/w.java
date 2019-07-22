package com.baidu.tbadk.core.util;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.text.TextUtils;
/* loaded from: classes.dex */
public class w implements MediaScannerConnection.MediaScannerConnectionClient {
    private MediaScannerConnection bRZ;
    private String bSa;
    private String[] bSb;
    private a bSc;
    private boolean completed;
    private int length;
    private Context mContext;
    private String[] mPaths;
    private String wX;

    /* loaded from: classes.dex */
    public interface a {
        void aiC();
    }

    public w(Context context) {
        this.mContext = context;
        this.bRZ = new MediaScannerConnection(this.mContext, this);
    }

    public void nP(String str) {
        this.wX = str;
        String substring = this.wX.substring(this.wX.lastIndexOf("."));
        this.bSa = "image/jpeg";
        if (substring.equals(".gif")) {
            this.bSa = "image/gif";
        }
        this.bRZ.connect();
    }

    public void nQ(String str) {
        this.wX = str;
        this.bSa = ft(str);
        this.bRZ.connect();
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
        if (!TextUtils.isEmpty(this.wX) && !TextUtils.isEmpty(this.bSa)) {
            this.bRZ.scanFile(this.wX, this.bSa);
        }
        if (this.mPaths != null && this.bSb != null && this.mPaths.length == this.bSb.length) {
            int length = this.mPaths.length;
            for (int i = 0; i < length; i++) {
                this.bRZ.scanFile(this.mPaths[i], this.bSb[i]);
            }
        }
    }

    @Override // android.media.MediaScannerConnection.OnScanCompletedListener
    public void onScanCompleted(String str, Uri uri) {
        if (!TextUtils.isEmpty(this.wX) && !TextUtils.isEmpty(this.bSa) && str.equals(this.wX)) {
            this.bRZ.disconnect();
            this.wX = null;
            this.bSa = null;
            this.completed = true;
        } else if (this.mPaths != null && this.bSb != null && this.mPaths.length == this.bSb.length) {
            this.length--;
            if (this.length == 0) {
                this.bRZ.disconnect();
                this.mPaths = null;
                this.bSb = null;
                this.completed = true;
            } else {
                this.completed = false;
            }
        }
        if (this.completed && this.bSc != null) {
            this.bSc.aiC();
        }
    }
}
