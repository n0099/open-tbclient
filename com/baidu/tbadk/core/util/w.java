package com.baidu.tbadk.core.util;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.text.TextUtils;
/* loaded from: classes.dex */
public class w implements MediaScannerConnection.MediaScannerConnectionClient {
    private MediaScannerConnection bJk;
    private String bJl;
    private String[] bJm;
    private a bJn;
    private boolean completed;
    private int length;
    private Context mContext;
    private String mPath;
    private String[] mPaths;

    /* loaded from: classes.dex */
    public interface a {
        void acF();
    }

    public w(Context context) {
        this.mContext = context;
        this.bJk = new MediaScannerConnection(this.mContext, this);
    }

    public void mv(String str) {
        this.mPath = str;
        String substring = this.mPath.substring(this.mPath.lastIndexOf("."));
        this.bJl = "image/jpeg";
        if (substring.equals(".gif")) {
            this.bJl = "image/gif";
        }
        this.bJk.connect();
    }

    public void mw(String str) {
        this.mPath = str;
        this.bJl = fc(str);
        this.bJk.connect();
    }

    private String fc(String str) {
        String lowerCase = str.toLowerCase();
        if (!lowerCase.endsWith("mp4") && !lowerCase.endsWith("mpeg4") && lowerCase.endsWith("3gp")) {
            return "video/3gp";
        }
        return "video/mp4";
    }

    @Override // android.media.MediaScannerConnection.MediaScannerConnectionClient
    public void onMediaScannerConnected() {
        if (!TextUtils.isEmpty(this.mPath) && !TextUtils.isEmpty(this.bJl)) {
            this.bJk.scanFile(this.mPath, this.bJl);
        }
        if (this.mPaths != null && this.bJm != null && this.mPaths.length == this.bJm.length) {
            int length = this.mPaths.length;
            for (int i = 0; i < length; i++) {
                this.bJk.scanFile(this.mPaths[i], this.bJm[i]);
            }
        }
    }

    @Override // android.media.MediaScannerConnection.OnScanCompletedListener
    public void onScanCompleted(String str, Uri uri) {
        if (!TextUtils.isEmpty(this.mPath) && !TextUtils.isEmpty(this.bJl) && str.equals(this.mPath)) {
            this.bJk.disconnect();
            this.mPath = null;
            this.bJl = null;
            this.completed = true;
        } else if (this.mPaths != null && this.bJm != null && this.mPaths.length == this.bJm.length) {
            this.length--;
            if (this.length == 0) {
                this.bJk.disconnect();
                this.mPaths = null;
                this.bJm = null;
                this.completed = true;
            } else {
                this.completed = false;
            }
        }
        if (this.completed && this.bJn != null) {
            this.bJn.acF();
        }
    }
}
