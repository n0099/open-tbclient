package com.baidu.tbadk.core.util;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.text.TextUtils;
/* loaded from: classes.dex */
public class w implements MediaScannerConnection.MediaScannerConnectionClient {
    private MediaScannerConnection bSG;
    private String bSH;
    private String[] bSI;
    private a bSJ;
    private boolean completed;
    private int length;
    private Context mContext;
    private String[] mPaths;
    private String wX;

    /* loaded from: classes.dex */
    public interface a {
        void aiI();
    }

    public w(Context context) {
        this.mContext = context;
        this.bSG = new MediaScannerConnection(this.mContext, this);
    }

    public void nR(String str) {
        this.wX = str;
        String substring = this.wX.substring(this.wX.lastIndexOf("."));
        this.bSH = "image/jpeg";
        if (substring.equals(".gif")) {
            this.bSH = "image/gif";
        }
        this.bSG.connect();
    }

    public void nS(String str) {
        this.wX = str;
        this.bSH = fv(str);
        this.bSG.connect();
    }

    private String fv(String str) {
        String lowerCase = str.toLowerCase();
        if (!lowerCase.endsWith("mp4") && !lowerCase.endsWith("mpeg4") && lowerCase.endsWith("3gp")) {
            return "video/3gp";
        }
        return "video/mp4";
    }

    @Override // android.media.MediaScannerConnection.MediaScannerConnectionClient
    public void onMediaScannerConnected() {
        if (!TextUtils.isEmpty(this.wX) && !TextUtils.isEmpty(this.bSH)) {
            this.bSG.scanFile(this.wX, this.bSH);
        }
        if (this.mPaths != null && this.bSI != null && this.mPaths.length == this.bSI.length) {
            int length = this.mPaths.length;
            for (int i = 0; i < length; i++) {
                this.bSG.scanFile(this.mPaths[i], this.bSI[i]);
            }
        }
    }

    @Override // android.media.MediaScannerConnection.OnScanCompletedListener
    public void onScanCompleted(String str, Uri uri) {
        if (!TextUtils.isEmpty(this.wX) && !TextUtils.isEmpty(this.bSH) && str.equals(this.wX)) {
            this.bSG.disconnect();
            this.wX = null;
            this.bSH = null;
            this.completed = true;
        } else if (this.mPaths != null && this.bSI != null && this.mPaths.length == this.bSI.length) {
            this.length--;
            if (this.length == 0) {
                this.bSG.disconnect();
                this.mPaths = null;
                this.bSI = null;
                this.completed = true;
            } else {
                this.completed = false;
            }
        }
        if (this.completed && this.bSJ != null) {
            this.bSJ.aiI();
        }
    }
}
