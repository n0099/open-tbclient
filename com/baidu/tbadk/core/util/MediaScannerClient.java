package com.baidu.tbadk.core.util;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes3.dex */
public class MediaScannerClient implements MediaScannerConnection.MediaScannerConnectionClient {
    public boolean completed;
    public int length;
    public onScanCompletedListener mListener;
    public String mMimeType;
    public String[] mMimeTypes;
    public String mPath;
    public String[] mPaths;
    public Context mContext = TbadkCoreApplication.getInst().getContext();
    public MediaScannerConnection mConnection = new MediaScannerConnection(this.mContext, this);

    /* loaded from: classes3.dex */
    public interface onScanCompletedListener {
        void onScanCompeted();
    }

    public MediaScannerClient(Context context) {
    }

    private String getVideoMimeType(String str) {
        String lowerCase = str.toLowerCase();
        return (lowerCase.endsWith("mp4") || lowerCase.endsWith("mpeg4") || !lowerCase.endsWith("3gp")) ? "video/mp4" : "video/3gp";
    }

    @Override // android.media.MediaScannerConnection.MediaScannerConnectionClient
    public void onMediaScannerConnected() {
        String[] strArr;
        if (!TextUtils.isEmpty(this.mPath) && !TextUtils.isEmpty(this.mMimeType)) {
            this.mConnection.scanFile(this.mPath, this.mMimeType);
        }
        String[] strArr2 = this.mPaths;
        if (strArr2 == null || (strArr = this.mMimeTypes) == null || strArr2.length != strArr.length) {
            return;
        }
        int length = strArr2.length;
        for (int i2 = 0; i2 < length; i2++) {
            this.mConnection.scanFile(this.mPaths[i2], this.mMimeTypes[i2]);
        }
    }

    @Override // android.media.MediaScannerConnection.OnScanCompletedListener
    public void onScanCompleted(String str, Uri uri) {
        String[] strArr;
        onScanCompletedListener onscancompletedlistener;
        if (!TextUtils.isEmpty(this.mPath) && !TextUtils.isEmpty(this.mMimeType) && str.equals(this.mPath)) {
            this.mConnection.disconnect();
            this.mConnection = null;
            this.mPath = null;
            this.mMimeType = null;
            this.completed = true;
        } else {
            String[] strArr2 = this.mPaths;
            if (strArr2 != null && (strArr = this.mMimeTypes) != null && strArr2.length == strArr.length) {
                int i2 = this.length - 1;
                this.length = i2;
                if (i2 == 0) {
                    this.mConnection.disconnect();
                    this.mConnection = null;
                    this.mPaths = null;
                    this.mMimeTypes = null;
                    this.completed = true;
                } else {
                    this.completed = false;
                }
            }
        }
        if (!this.completed || (onscancompletedlistener = this.mListener) == null) {
            return;
        }
        onscancompletedlistener.onScanCompeted();
    }

    public void saveImage(String str) {
        this.mPath = str;
        String substring = str.substring(str.lastIndexOf("."));
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

    public void scanFile(String str, String str2) {
        this.mPath = str;
        this.mMimeType = str2;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.mMimeType)) {
            this.mConnection.connect();
            return;
        }
        this.mPath = null;
        this.mMimeType = null;
    }

    public void scanFiles(String[] strArr, String[] strArr2) {
        this.mPaths = strArr;
        this.mMimeTypes = strArr2;
        if (strArr != null && strArr2 != null && strArr.length == strArr2.length) {
            this.length = strArr.length;
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
}
