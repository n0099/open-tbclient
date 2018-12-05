package com.baidu.tbadk.core.util;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.text.TextUtils;
/* loaded from: classes.dex */
public class w implements MediaScannerConnection.MediaScannerConnectionClient {
    private MediaScannerConnection aAN;
    private String[] aAO;
    private a aAP;
    private boolean completed;
    private int length;
    private Context mContext;
    private String mMimeType;
    private String mPath;
    private String[] mPaths;

    /* loaded from: classes.dex */
    public interface a {
        void Dh();
    }

    public w(Context context) {
        this.mContext = context;
        this.aAN = new MediaScannerConnection(this.mContext, this);
    }

    public void fx(String str) {
        this.mPath = str;
        String substring = this.mPath.substring(this.mPath.lastIndexOf("."));
        this.mMimeType = "image/jpeg";
        if (substring.equals(".gif")) {
            this.mMimeType = "image/gif";
        }
        this.aAN.connect();
    }

    public void fy(String str) {
        this.mPath = str;
        this.mMimeType = getVideoMimeType(str);
        this.aAN.connect();
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
            this.aAN.scanFile(this.mPath, this.mMimeType);
        }
        if (this.mPaths != null && this.aAO != null && this.mPaths.length == this.aAO.length) {
            int length = this.mPaths.length;
            for (int i = 0; i < length; i++) {
                this.aAN.scanFile(this.mPaths[i], this.aAO[i]);
            }
        }
    }

    @Override // android.media.MediaScannerConnection.OnScanCompletedListener
    public void onScanCompleted(String str, Uri uri) {
        if (!TextUtils.isEmpty(this.mPath) && !TextUtils.isEmpty(this.mMimeType) && str.equals(this.mPath)) {
            this.aAN.disconnect();
            this.mPath = null;
            this.mMimeType = null;
            this.completed = true;
        } else if (this.mPaths != null && this.aAO != null && this.mPaths.length == this.aAO.length) {
            this.length--;
            if (this.length == 0) {
                this.aAN.disconnect();
                this.mPaths = null;
                this.aAO = null;
                this.completed = true;
            } else {
                this.completed = false;
            }
        }
        if (this.completed && this.aAP != null) {
            this.aAP.Dh();
        }
    }
}
