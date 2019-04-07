package com.baidu.tbadk.core.util;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.text.TextUtils;
/* loaded from: classes.dex */
public class w implements MediaScannerConnection.MediaScannerConnectionClient {
    private MediaScannerConnection bJn;
    private String bJo;
    private String[] bJp;
    private a bJq;
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
        this.bJn = new MediaScannerConnection(this.mContext, this);
    }

    public void mw(String str) {
        this.mPath = str;
        String substring = this.mPath.substring(this.mPath.lastIndexOf("."));
        this.bJo = "image/jpeg";
        if (substring.equals(".gif")) {
            this.bJo = "image/gif";
        }
        this.bJn.connect();
    }

    public void mx(String str) {
        this.mPath = str;
        this.bJo = fd(str);
        this.bJn.connect();
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
        if (!TextUtils.isEmpty(this.mPath) && !TextUtils.isEmpty(this.bJo)) {
            this.bJn.scanFile(this.mPath, this.bJo);
        }
        if (this.mPaths != null && this.bJp != null && this.mPaths.length == this.bJp.length) {
            int length = this.mPaths.length;
            for (int i = 0; i < length; i++) {
                this.bJn.scanFile(this.mPaths[i], this.bJp[i]);
            }
        }
    }

    @Override // android.media.MediaScannerConnection.OnScanCompletedListener
    public void onScanCompleted(String str, Uri uri) {
        if (!TextUtils.isEmpty(this.mPath) && !TextUtils.isEmpty(this.bJo) && str.equals(this.mPath)) {
            this.bJn.disconnect();
            this.mPath = null;
            this.bJo = null;
            this.completed = true;
        } else if (this.mPaths != null && this.bJp != null && this.mPaths.length == this.bJp.length) {
            this.length--;
            if (this.length == 0) {
                this.bJn.disconnect();
                this.mPaths = null;
                this.bJp = null;
                this.completed = true;
            } else {
                this.completed = false;
            }
        }
        if (this.completed && this.bJq != null) {
            this.bJq.acC();
        }
    }
}
