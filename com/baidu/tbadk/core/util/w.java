package com.baidu.tbadk.core.util;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.text.TextUtils;
/* loaded from: classes.dex */
public class w implements MediaScannerConnection.MediaScannerConnectionClient {
    private MediaScannerConnection bJo;
    private String bJp;
    private String[] bJq;
    private a bJr;
    private boolean completed;
    private int length;
    private Context mContext;
    private String mPath;
    private String[] mPaths;

    /* loaded from: classes.dex */
    public interface a {
        void acC();
    }

    public w(Context context) {
        this.mContext = context;
        this.bJo = new MediaScannerConnection(this.mContext, this);
    }

    public void mw(String str) {
        this.mPath = str;
        String substring = this.mPath.substring(this.mPath.lastIndexOf("."));
        this.bJp = "image/jpeg";
        if (substring.equals(".gif")) {
            this.bJp = "image/gif";
        }
        this.bJo.connect();
    }

    public void mx(String str) {
        this.mPath = str;
        this.bJp = fd(str);
        this.bJo.connect();
    }

    private String fd(String str) {
        String lowerCase = str.toLowerCase();
        if (!lowerCase.endsWith("mp4") && !lowerCase.endsWith("mpeg4") && lowerCase.endsWith("3gp")) {
            return "video/3gp";
        }
        return "video/mp4";
    }

    @Override // android.media.MediaScannerConnection.MediaScannerConnectionClient
    public void onMediaScannerConnected() {
        if (!TextUtils.isEmpty(this.mPath) && !TextUtils.isEmpty(this.bJp)) {
            this.bJo.scanFile(this.mPath, this.bJp);
        }
        if (this.mPaths != null && this.bJq != null && this.mPaths.length == this.bJq.length) {
            int length = this.mPaths.length;
            for (int i = 0; i < length; i++) {
                this.bJo.scanFile(this.mPaths[i], this.bJq[i]);
            }
        }
    }

    @Override // android.media.MediaScannerConnection.OnScanCompletedListener
    public void onScanCompleted(String str, Uri uri) {
        if (!TextUtils.isEmpty(this.mPath) && !TextUtils.isEmpty(this.bJp) && str.equals(this.mPath)) {
            this.bJo.disconnect();
            this.mPath = null;
            this.bJp = null;
            this.completed = true;
        } else if (this.mPaths != null && this.bJq != null && this.mPaths.length == this.bJq.length) {
            this.length--;
            if (this.length == 0) {
                this.bJo.disconnect();
                this.mPaths = null;
                this.bJq = null;
                this.completed = true;
            } else {
                this.completed = false;
            }
        }
        if (this.completed && this.bJr != null) {
            this.bJr.acC();
        }
    }
}
