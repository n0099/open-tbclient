package com.baidu.clientupdate.download;

import android.net.Uri;
import android.util.Pair;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class Download implements Serializable {
    public boolean mNotificationShowed;
    public String mUrl = "";
    public String mFileName = "";
    public String mSavedPath = "";
    public long mFileLength = 0;
    public long mCurrentLength = 0;
    public DownloadState mState = DownloadState.WAITING;
    public String mFailReason = "";
    public long mId = -1;
    public String mMimeType = "";
    public String mETag = "";
    public boolean mbMustInternal = false;
    public String mSourceKey = "";
    public boolean mNeedNotification = false;
    public List mRequestHeaders = new ArrayList();

    /* renamed from: a  reason: collision with root package name */
    long f1733a = 0;

    /* renamed from: b  reason: collision with root package name */
    long f1734b = 0;
    int c = 0;
    boolean d = true;

    public void addRequestHeader(String str, String str2) {
        if (str == null) {
            throw new NullPointerException("header cannot be null");
        }
        if (str.contains(":")) {
            throw new IllegalArgumentException("header may not contain ':'");
        }
        if (str2 == null) {
            str2 = "";
        }
        this.mRequestHeaders.add(Pair.create(str, str2));
    }

    public long getCurrentLength() {
        return this.mCurrentLength;
    }

    public String getDownloadFileName() {
        return new File(this.mSavedPath, this.mFileName != null ? Uri.encode(this.mFileName) : null).getPath();
    }

    public String getDownloadUri() {
        return this.mUrl;
    }

    public String getFailReason() {
        return this.mFailReason;
    }

    public long getFileLength() {
        return this.mFileLength;
    }

    public String getFileType() {
        return this.mMimeType;
    }

    public long getId() {
        return this.mId;
    }

    public int getProgress() {
        if (this.mCurrentLength == 0 || this.mFileLength == 0) {
            return 0;
        }
        int i = (int) ((this.mCurrentLength * 100) / this.mFileLength);
        if (i >= 100) {
            return 99;
        }
        return i;
    }

    public DownloadState getState() {
        return this.mState;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[mUrl=").append(this.mUrl).append("]").append("[mFileName=").append(this.mFileName).append("]").append("[mSavedPath=").append(this.mSavedPath).append("]").append("[mFileLength=").append(this.mFileLength).append("]").append("[mCurrentLength=").append(this.mCurrentLength).append("]").append("[mState=").append(this.mState.toString()).append("]").append("[mFailReason=").append(this.mFailReason).append("]").append("[mId=").append(this.mId).append("]").append("[mMimeType=").append(this.mMimeType).append("]");
        return stringBuffer.toString();
    }
}
