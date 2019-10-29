package com.baidu.live.tbadk.core.util;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.DefaultConfig;
/* loaded from: classes6.dex */
public class MediaScannerClient implements MediaScannerConnection.MediaScannerConnectionClient {
    private boolean completed;
    private int length;
    private MediaScannerConnection mConnection;
    private Context mContext;
    private onScanCompletedListener mListener;
    private String mMimeType;
    private String[] mMimeTypes;
    private String mPath;
    private String[] mPaths;

    /* loaded from: classes6.dex */
    public interface onScanCompletedListener {
        void onScanCompeted();
    }

    public MediaScannerClient(Context context) {
        this.mContext = context;
        this.mConnection = new MediaScannerConnection(this.mContext, this);
    }

    public void saveImage(String str) {
        this.mPath = str;
        String substring = this.mPath.substring(this.mPath.lastIndexOf(DefaultConfig.TOKEN_SEPARATOR));
        this.mMimeType = "image/jpeg";
        if (substring.equals(".gif")) {
            this.mMimeType = "image/gif";
        }
        this.mConnection.connect();
    }

    public void saveVideo(String str) {
        this.mPath = str;
        this.mMimeType = getVideoMimeType(str);
        this.mConnection.connect();
    }

    private String getVideoMimeType(String str) {
        String lowerCase = str.toLowerCase();
        if (!lowerCase.endsWith("mp4") && !lowerCase.endsWith("mpeg4") && lowerCase.endsWith("3gp")) {
            return "video/3gp";
        }
        return "video/mp4";
    }

    public void scanFile(String str, String str2) {
        this.mPath = str;
        this.mMimeType = str2;
        if (!TextUtils.isEmpty(this.mPath) && !TextUtils.isEmpty(this.mMimeType)) {
            this.mConnection.connect();
            return;
        }
        this.mPath = null;
        this.mMimeType = null;
    }

    public void scanFiles(String[] strArr, String[] strArr2) {
        this.mPaths = strArr;
        this.mMimeTypes = strArr2;
        if (this.mPaths != null && this.mMimeTypes != null && this.mPaths.length == this.mMimeTypes.length) {
            this.length = this.mPaths.length;
            this.mConnection.connect();
            return;
        }
        this.mPaths = null;
        this.mMimeTypes = null;
        this.length = 0;
    }

    public void setOnScanCompletedListener(onScanCompletedListener onscancompletedlistener) {
        this.mListener = onscancompletedlistener;
    }

    @Override // android.media.MediaScannerConnection.MediaScannerConnectionClient
    public void onMediaScannerConnected() {
        if (!TextUtils.isEmpty(this.mPath) && !TextUtils.isEmpty(this.mMimeType)) {
            this.mConnection.scanFile(this.mPath, this.mMimeType);
        }
        if (this.mPaths != null && this.mMimeTypes != null && this.mPaths.length == this.mMimeTypes.length) {
            int length = this.mPaths.length;
            for (int i = 0; i < length; i++) {
                this.mConnection.scanFile(this.mPaths[i], this.mMimeTypes[i]);
            }
        }
    }

    @Override // android.media.MediaScannerConnection.OnScanCompletedListener
    public void onScanCompleted(String str, Uri uri) {
        if (!TextUtils.isEmpty(this.mPath) && !TextUtils.isEmpty(this.mMimeType) && str.equals(this.mPath)) {
            this.mConnection.disconnect();
            this.mPath = null;
            this.mMimeType = null;
            this.completed = true;
        } else if (this.mPaths != null && this.mMimeTypes != null && this.mPaths.length == this.mMimeTypes.length) {
            this.length--;
            if (this.length == 0) {
                this.mConnection.disconnect();
                this.mPaths = null;
                this.mMimeTypes = null;
                this.completed = true;
            } else {
                this.completed = false;
            }
        }
        if (this.completed && this.mListener != null) {
            this.mListener.onScanCompeted();
        }
    }
}
