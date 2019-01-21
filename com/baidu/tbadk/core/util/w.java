package com.baidu.tbadk.core.util;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.text.TextUtils;
/* loaded from: classes.dex */
public class w implements MediaScannerConnection.MediaScannerConnectionClient {
    private MediaScannerConnection aBq;
    private String[] aBr;
    private a aBs;
    private boolean completed;
    private int length;
    private Context mContext;
    private String mMimeType;
    private String mPath;
    private String[] mPaths;

    /* loaded from: classes.dex */
    public interface a {
        void Du();
    }

    public w(Context context) {
        this.mContext = context;
        this.aBq = new MediaScannerConnection(this.mContext, this);
    }

    public void fK(String str) {
        this.mPath = str;
        String substring = this.mPath.substring(this.mPath.lastIndexOf("."));
        this.mMimeType = "image/jpeg";
        if (substring.equals(".gif")) {
            this.mMimeType = "image/gif";
        }
        this.aBq.connect();
    }

    public void fL(String str) {
        this.mPath = str;
        this.mMimeType = getVideoMimeType(str);
        this.aBq.connect();
    }

    private String getVideoMimeType(String str) {
        String lowerCase = str.toLowerCase();
        if (!lowerCase.endsWith("mp4") && !lowerCase.endsWith("mpeg4") && lowerCase.endsWith("3gp")) {
            return "video/3gp";
        }
        return "video/mp4";
    }

    @Override // android.media.MediaScannerConnection.MediaScannerConnectionClient
    public void onMediaScannerConnected() {
        if (!TextUtils.isEmpty(this.mPath) && !TextUtils.isEmpty(this.mMimeType)) {
            this.aBq.scanFile(this.mPath, this.mMimeType);
        }
        if (this.mPaths != null && this.aBr != null && this.mPaths.length == this.aBr.length) {
            int length = this.mPaths.length;
            for (int i = 0; i < length; i++) {
                this.aBq.scanFile(this.mPaths[i], this.aBr[i]);
            }
        }
    }

    @Override // android.media.MediaScannerConnection.OnScanCompletedListener
    public void onScanCompleted(String str, Uri uri) {
        if (!TextUtils.isEmpty(this.mPath) && !TextUtils.isEmpty(this.mMimeType) && str.equals(this.mPath)) {
            this.aBq.disconnect();
            this.mPath = null;
            this.mMimeType = null;
            this.completed = true;
        } else if (this.mPaths != null && this.aBr != null && this.mPaths.length == this.aBr.length) {
            this.length--;
            if (this.length == 0) {
                this.aBq.disconnect();
                this.mPaths = null;
                this.aBr = null;
                this.completed = true;
            } else {
                this.completed = false;
            }
        }
        if (this.completed && this.aBs != null) {
            this.aBs.Du();
        }
    }
}
