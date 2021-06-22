package com.baidu.clientupdate.download;

import android.net.Uri;
import android.util.Pair;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
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
    public long f4629a = 0;

    /* renamed from: b  reason: collision with root package name */
    public long f4630b = 0;

    /* renamed from: c  reason: collision with root package name */
    public int f4631c = 0;

    /* renamed from: d  reason: collision with root package name */
    public boolean f4632d = true;

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
        String str = this.mFileName;
        return new File(this.mSavedPath, str != null ? Uri.encode(str) : null).getPath();
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
        long j = this.mCurrentLength;
        if (j != 0) {
            long j2 = this.mFileLength;
            if (j2 == 0) {
                return 0;
            }
            int i2 = (int) ((j * 100) / j2);
            if (i2 >= 100) {
                return 99;
            }
            return i2;
        }
        return 0;
    }

    public DownloadState getState() {
        return this.mState;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[mUrl=");
        stringBuffer.append(this.mUrl);
        stringBuffer.append(PreferencesUtil.RIGHT_MOUNT);
        stringBuffer.append("[mFileName=");
        stringBuffer.append(this.mFileName);
        stringBuffer.append(PreferencesUtil.RIGHT_MOUNT);
        stringBuffer.append("[mSavedPath=");
        stringBuffer.append(this.mSavedPath);
        stringBuffer.append(PreferencesUtil.RIGHT_MOUNT);
        stringBuffer.append("[mFileLength=");
        stringBuffer.append(this.mFileLength);
        stringBuffer.append(PreferencesUtil.RIGHT_MOUNT);
        stringBuffer.append("[mCurrentLength=");
        stringBuffer.append(this.mCurrentLength);
        stringBuffer.append(PreferencesUtil.RIGHT_MOUNT);
        stringBuffer.append("[mState=");
        stringBuffer.append(this.mState.toString());
        stringBuffer.append(PreferencesUtil.RIGHT_MOUNT);
        stringBuffer.append("[mFailReason=");
        stringBuffer.append(this.mFailReason);
        stringBuffer.append(PreferencesUtil.RIGHT_MOUNT);
        stringBuffer.append("[mId=");
        stringBuffer.append(this.mId);
        stringBuffer.append(PreferencesUtil.RIGHT_MOUNT);
        stringBuffer.append("[mMimeType=");
        stringBuffer.append(this.mMimeType);
        stringBuffer.append(PreferencesUtil.RIGHT_MOUNT);
        return stringBuffer.toString();
    }
}
