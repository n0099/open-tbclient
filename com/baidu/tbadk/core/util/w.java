package com.baidu.tbadk.core.util;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.text.TextUtils;
/* loaded from: classes.dex */
public class w implements MediaScannerConnection.MediaScannerConnectionClient {
    private MediaScannerConnection bJl;
    private String bJm;
    private String[] bJn;
    private a bJo;
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
        this.bJl = new MediaScannerConnection(this.mContext, this);
    }

    public void mv(String str) {
        this.mPath = str;
        String substring = this.mPath.substring(this.mPath.lastIndexOf("."));
        this.bJm = "image/jpeg";
        if (substring.equals(".gif")) {
            this.bJm = "image/gif";
        }
        this.bJl.connect();
    }

    public void mw(String str) {
        this.mPath = str;
        this.bJm = fc(str);
        this.bJl.connect();
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
        if (!TextUtils.isEmpty(this.mPath) && !TextUtils.isEmpty(this.bJm)) {
            this.bJl.scanFile(this.mPath, this.bJm);
        }
        if (this.mPaths != null && this.bJn != null && this.mPaths.length == this.bJn.length) {
            int length = this.mPaths.length;
            for (int i = 0; i < length; i++) {
                this.bJl.scanFile(this.mPaths[i], this.bJn[i]);
            }
        }
    }

    @Override // android.media.MediaScannerConnection.OnScanCompletedListener
    public void onScanCompleted(String str, Uri uri) {
        if (!TextUtils.isEmpty(this.mPath) && !TextUtils.isEmpty(this.bJm) && str.equals(this.mPath)) {
            this.bJl.disconnect();
            this.mPath = null;
            this.bJm = null;
            this.completed = true;
        } else if (this.mPaths != null && this.bJn != null && this.mPaths.length == this.bJn.length) {
            this.length--;
            if (this.length == 0) {
                this.bJl.disconnect();
                this.mPaths = null;
                this.bJn = null;
                this.completed = true;
            } else {
                this.completed = false;
            }
        }
        if (this.completed && this.bJo != null) {
            this.bJo.acF();
        }
    }
}
