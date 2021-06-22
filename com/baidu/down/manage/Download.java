package com.baidu.down.manage;

import android.util.Pair;
import com.baidu.down.common.DownDetail;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class Download {
    public static final DecimalFormat DFOEMAT = new DecimalFormat("###0.0");
    public String mFromParam;
    public Long mId;
    public String mKeyByUser;
    public String mSize;
    public String mUrl = "";
    public String mRealUrl = "";
    public String mFileName = "";
    public String mSavedPathForUser = "";
    public String mMimetype = "";
    public String mEtag = "";
    public Integer mStatus = Integer.valueOf(DownloadState.WAITING.ordinal());
    public Long mTotalbytes = 0L;
    public Long mCurrentbytes = 0L;
    public String mFailedReason = "";
    public String mProgressmap = "";
    public String mUrihost = "";
    public Long mControlFlag = 9L;
    public Integer mFailedType = -1;
    public int mPriority = 3;
    public List<Pair<String, String>> mRequestHeaders = new ArrayList();
    public long mLastProgressNotiStamp = 0;
    public long mLastProgressSaveStamp = 0;
    public float mLastProgressNoti = 0.0f;
    public long mLastSpeed = 0;
    public boolean mNeedDeleteFile = true;
    public String mRedownloadReason = "";
    public String mRequestHeader = "";
    public DownDetail mDownDetail = new DownDetail();
    public String mDownDir = "";
    public boolean mNotificationNeeded = false;

    /* loaded from: classes2.dex */
    public enum DownloadState {
        WAITING,
        DOWNLOADING,
        PAUSE,
        FAILED,
        CANCEL,
        FINISH,
        UNKNOWN;

        public static DownloadState getState(int i2) {
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 != 3) {
                            if (i2 != 4) {
                                if (i2 != 5) {
                                    return UNKNOWN;
                                }
                                return FINISH;
                            }
                            return CANCEL;
                        }
                        return FAILED;
                    }
                    return PAUSE;
                }
                return DOWNLOADING;
            }
            return WAITING;
        }
    }

    private void addControlFlag(long j) {
        this.mControlFlag = Long.valueOf(j | this.mControlFlag.longValue());
    }

    private boolean hasControlFlag(long j) {
        return (j & this.mControlFlag.longValue()) > 0;
    }

    private void removeControlFlag(long j) {
        this.mControlFlag = Long.valueOf((~j) & this.mControlFlag.longValue());
    }

    public void addRequestHeader(String str, String str2) {
        if (str != null) {
            if (!str.contains(":")) {
                if (str2 == null) {
                    str2 = "";
                }
                this.mRequestHeaders.add(Pair.create(str, str2));
                return;
            }
            throw new IllegalArgumentException("header may not contain ':'");
        }
        throw new NullPointerException("header cannot be null");
    }

    public Long getControlFlag() {
        return this.mControlFlag;
    }

    public float getCurrentProgress() {
        if (this.mCurrentbytes.longValue() == 0 || this.mTotalbytes.longValue() == 0) {
            return 0.0f;
        }
        float longValue = ((float) (this.mCurrentbytes.longValue() * 100)) / ((float) this.mTotalbytes.longValue());
        if (longValue >= 100.0f) {
            return 99.99f;
        }
        return longValue;
    }

    public Long getCurrentbytes() {
        return this.mCurrentbytes;
    }

    public String getDownloadFileName() {
        return new File(this.mSavedPathForUser, this.mFileName).getPath();
    }

    public String getEtag() {
        return this.mEtag;
    }

    public String getExactProgressString() {
        return DFOEMAT.format(getCurrentProgress());
    }

    public String getFailedReason() {
        return this.mFailedReason;
    }

    public Integer getFailedType() {
        return this.mFailedType;
    }

    public String getFileName() {
        return this.mFileName;
    }

    public String getFromParam() {
        return this.mFromParam;
    }

    public Long getId() {
        return this.mId;
    }

    public String getKeyByUser() {
        return this.mKeyByUser;
    }

    public String getMimetype() {
        return this.mMimetype;
    }

    public boolean getNotificationNeeded() {
        return this.mNotificationNeeded;
    }

    public int getPriority() {
        return this.mPriority;
    }

    public int getProgress() {
        if (this.mCurrentbytes.longValue() == 0 || this.mTotalbytes.longValue() == 0) {
            return 0;
        }
        int longValue = (int) ((this.mCurrentbytes.longValue() * 100) / this.mTotalbytes.longValue());
        if (longValue >= 100) {
            return 99;
        }
        return longValue;
    }

    public String getProgressmap() {
        return this.mProgressmap;
    }

    public String getRealDownloadDir() {
        return this.mDownDir;
    }

    public String getRealUrl() {
        return this.mRealUrl;
    }

    public String getRedownloadReason() {
        return this.mRedownloadReason;
    }

    public String getSavedPathForUser() {
        return this.mSavedPathForUser;
    }

    public DownloadState getState() {
        return DownloadState.values()[this.mStatus.intValue()];
    }

    public Integer getStatus() {
        return this.mStatus;
    }

    public Boolean getSupportrange() {
        return Boolean.valueOf(hasControlFlag(1L));
    }

    public Long getTotalbytes() {
        return this.mTotalbytes;
    }

    public String getUrihost() {
        return this.mUrihost;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public Boolean isAutoPause() {
        return Boolean.valueOf(hasControlFlag(2L));
    }

    public boolean isCheckConentType() {
        return hasControlFlag(8L);
    }

    public boolean isWifiOnly() {
        return hasControlFlag(4L);
    }

    public void setAutoPause(Boolean bool) {
        if (bool.booleanValue()) {
            addControlFlag(2L);
        } else {
            removeControlFlag(2L);
        }
    }

    public void setCheckContentType(boolean z) {
        if (z) {
            addControlFlag(8L);
        } else {
            removeControlFlag(8L);
        }
    }

    public void setControlFlag(Long l) {
        this.mControlFlag = l;
    }

    public void setCurrentbytes(Long l) {
        this.mCurrentbytes = l;
    }

    public void setDownDir(String str) {
        this.mDownDir = str;
    }

    public void setEtag(String str) {
        this.mEtag = str;
    }

    public void setFailedReason(String str) {
        this.mFailedReason = str;
    }

    public void setFailedType(Integer num) {
        this.mFailedType = num;
    }

    public void setFileName(String str) {
        this.mFileName = str;
    }

    public void setFromParam(String str) {
        this.mFromParam = str;
    }

    public void setId(Long l) {
        this.mId = l;
    }

    public void setKeyByUser(String str) {
        this.mKeyByUser = str;
    }

    public void setMimetype(String str) {
        this.mMimetype = str;
    }

    public void setNeedDeleteFile(boolean z) {
        this.mNeedDeleteFile = z;
    }

    public void setNotificationNeeded(boolean z) {
        this.mNotificationNeeded = z;
    }

    public void setPriority(int i2) {
        this.mPriority = i2;
    }

    public void setProgressmap(String str) {
        this.mProgressmap = str;
    }

    public void setRealUrl(String str) {
        this.mRealUrl = str;
    }

    public void setRedownloadReason(String str) {
        this.mRedownloadReason = str;
    }

    public void setSavedPathForUser(String str) {
        this.mSavedPathForUser = str;
    }

    public void setState(DownloadState downloadState) {
        this.mStatus = Integer.valueOf(downloadState.ordinal());
    }

    public void setStatus(Integer num) {
        this.mStatus = num;
    }

    public void setSupportrange(Boolean bool) {
        if (bool.booleanValue()) {
            addControlFlag(1L);
        } else {
            removeControlFlag(1L);
        }
    }

    public void setTotalbytes(Long l) {
        this.mTotalbytes = l;
    }

    public void setUrihost(String str) {
        this.mUrihost = str;
    }

    public void setUrl(String str) {
        this.mUrl = str;
    }

    public void setWifiOnly(boolean z) {
        if (z) {
            addControlFlag(4L);
        } else {
            removeControlFlag(4L);
        }
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
        stringBuffer.append(this.mSavedPathForUser);
        stringBuffer.append(PreferencesUtil.RIGHT_MOUNT);
        stringBuffer.append("[mFileLength=");
        stringBuffer.append(this.mTotalbytes);
        stringBuffer.append(PreferencesUtil.RIGHT_MOUNT);
        stringBuffer.append("[mCurrentLength=");
        stringBuffer.append(this.mCurrentbytes);
        stringBuffer.append(PreferencesUtil.RIGHT_MOUNT);
        stringBuffer.append("[mState=");
        stringBuffer.append(this.mStatus);
        stringBuffer.append(PreferencesUtil.RIGHT_MOUNT);
        stringBuffer.append("[mFailReason=");
        stringBuffer.append(this.mStatus);
        stringBuffer.append(PreferencesUtil.RIGHT_MOUNT);
        stringBuffer.append("[mId=");
        stringBuffer.append(this.mId);
        stringBuffer.append(PreferencesUtil.RIGHT_MOUNT);
        stringBuffer.append("[mProgressmap=");
        stringBuffer.append(this.mProgressmap);
        stringBuffer.append(PreferencesUtil.RIGHT_MOUNT);
        stringBuffer.append("[mEtag=");
        stringBuffer.append(this.mEtag);
        stringBuffer.append(PreferencesUtil.RIGHT_MOUNT);
        stringBuffer.append("[mMimeType=");
        stringBuffer.append(this.mMimetype);
        stringBuffer.append(PreferencesUtil.RIGHT_MOUNT);
        stringBuffer.append("[mSavedPathForUser=");
        stringBuffer.append(this.mSavedPathForUser);
        stringBuffer.append(PreferencesUtil.RIGHT_MOUNT);
        return stringBuffer.toString();
    }
}
