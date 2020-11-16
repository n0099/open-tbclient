package com.baidu.down.manage;

import android.util.Pair;
import com.baidu.down.common.DownDetail;
import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes15.dex */
public class Download {
    private static final DecimalFormat DFOEMAT = new DecimalFormat("###0.0");
    private String mFromParam;
    private Long mId;
    private String mKeyByUser;
    private String mSize;
    private String mUrl = "";
    private String mFileName = "";
    private String mSavedPathForUser = "";
    private String mMimetype = "";
    private String mEtag = "";
    private Integer mStatus = Integer.valueOf(DownloadState.WAITING.ordinal());
    private Long mTotalbytes = 0L;
    private Long mCurrentbytes = 0L;
    private String mFailedReason = "";
    private String mProgressmap = "";
    private String mUrihost = "";
    private Long mControlFlag = 9L;
    private Integer mFailedType = -1;
    private int mPriority = 3;
    List<Pair<String, String>> mRequestHeaders = new ArrayList();
    long mLastProgressNotiStamp = 0;
    long mLastProgressSaveStamp = 0;
    float mLastProgressNoti = 0.0f;
    long mLastSpeed = 0;
    boolean mNeedDeleteFile = true;
    private String mRedownloadReason = "";
    String mRequestHeader = "";
    DownDetail mDownDetail = new DownDetail();
    private String mDownDir = "";
    private boolean mNotificationNeeded = false;

    public Long getId() {
        return this.mId;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setId(Long l) {
        this.mId = l;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public void setUrl(String str) {
        this.mUrl = str;
    }

    public String getFileName() {
        return this.mFileName;
    }

    public void setFileName(String str) {
        this.mFileName = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getSavedPathForUser() {
        return this.mSavedPathForUser;
    }

    public void setSavedPathForUser(String str) {
        this.mSavedPathForUser = str;
    }

    public boolean getNotificationNeeded() {
        return this.mNotificationNeeded;
    }

    public void setNotificationNeeded(boolean z) {
        this.mNotificationNeeded = z;
    }

    public String getMimetype() {
        return this.mMimetype;
    }

    public void setMimetype(String str) {
        this.mMimetype = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getEtag() {
        return this.mEtag;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setEtag(String str) {
        this.mEtag = str;
    }

    Integer getStatus() {
        return this.mStatus;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setStatus(Integer num) {
        this.mStatus = num;
    }

    public Long getTotalbytes() {
        return this.mTotalbytes;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setTotalbytes(Long l) {
        this.mTotalbytes = l;
    }

    public Long getCurrentbytes() {
        return this.mCurrentbytes;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setCurrentbytes(Long l) {
        this.mCurrentbytes = l;
    }

    public String getFailedReason() {
        return this.mFailedReason;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setFailedReason(String str) {
        this.mFailedReason = str;
    }

    public Integer getFailedType() {
        return this.mFailedType;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setFailedType(Integer num) {
        this.mFailedType = num;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getProgressmap() {
        return this.mProgressmap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setProgressmap(String str) {
        this.mProgressmap = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getUrihost() {
        return this.mUrihost;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setUrihost(String str) {
        this.mUrihost = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getPriority() {
        return this.mPriority;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setPriority(int i) {
        this.mPriority = i;
    }

    Boolean getAutoPause() {
        return Boolean.valueOf(hasControlFlag(2L));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setAutoPause(Boolean bool) {
        if (bool.booleanValue()) {
            addControlFlag(2L);
        } else {
            removeControlFlag(2L);
        }
    }

    Boolean getSupportrange() {
        return Boolean.valueOf(hasControlFlag(1L));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setSupportrange(Boolean bool) {
        if (bool.booleanValue()) {
            addControlFlag(1L);
        } else {
            removeControlFlag(1L);
        }
    }

    public boolean isWifiOnly() {
        return hasControlFlag(4L);
    }

    public void setWifiOnly(boolean z) {
        if (z) {
            addControlFlag(4L);
        } else {
            removeControlFlag(4L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Long getControlFlag() {
        return this.mControlFlag;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setControlFlag(Long l) {
        this.mControlFlag = l;
    }

    void addRequestHeader(String str, String str2) {
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

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[mUrl=").append(this.mUrl).append("]").append("[mFileName=").append(this.mFileName).append("]").append("[mSavedPath=").append(this.mSavedPathForUser).append("]").append("[mFileLength=").append(this.mTotalbytes).append("]").append("[mCurrentLength=").append(this.mCurrentbytes).append("]").append("[mState=").append(this.mStatus).append("]").append("[mFailReason=").append(this.mStatus).append("]").append("[mId=").append(this.mId).append("]").append("[mProgressmap=").append(this.mProgressmap).append("]").append("[mEtag=").append(this.mEtag).append("]").append("[mMimeType=").append(this.mMimetype).append("]").append("[mSavedPathForUser=").append(this.mSavedPathForUser).append("]");
        return stringBuffer.toString();
    }

    /* loaded from: classes15.dex */
    public enum DownloadState {
        WAITING,
        DOWNLOADING,
        PAUSE,
        FAILED,
        CANCEL,
        FINISH,
        UNKNOWN;

        public static DownloadState getState(int i) {
            switch (i) {
                case 0:
                    return WAITING;
                case 1:
                    return DOWNLOADING;
                case 2:
                    return PAUSE;
                case 3:
                    return FAILED;
                case 4:
                    return CANCEL;
                case 5:
                    return FINISH;
                default:
                    return UNKNOWN;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getDownloadFileName() {
        return new File(this.mSavedPathForUser, this.mFileName).getPath();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
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

    String getExactProgressString() {
        return DFOEMAT.format(getCurrentProgress());
    }

    public DownloadState getState() {
        return DownloadState.values()[this.mStatus.intValue()];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setState(DownloadState downloadState) {
        this.mStatus = Integer.valueOf(downloadState.ordinal());
    }

    String getRedownloadReason() {
        return this.mRedownloadReason;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setRedownloadReason(String str) {
        this.mRedownloadReason = str;
    }

    boolean isCheckConentType() {
        return hasControlFlag(8L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setCheckContentType(boolean z) {
        if (z) {
            addControlFlag(8L);
        } else {
            removeControlFlag(8L);
        }
    }

    private void addControlFlag(long j) {
        this.mControlFlag = Long.valueOf(this.mControlFlag.longValue() | j);
    }

    private void removeControlFlag(long j) {
        this.mControlFlag = Long.valueOf(this.mControlFlag.longValue() & ((-1) ^ j));
    }

    private boolean hasControlFlag(long j) {
        return (this.mControlFlag.longValue() & j) > 0;
    }

    public String getRealDownloadDir() {
        return this.mDownDir;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setDownDir(String str) {
        this.mDownDir = str;
    }

    public String getFromParam() {
        return this.mFromParam;
    }

    public void setNeedDeleteFile(boolean z) {
        this.mNeedDeleteFile = z;
    }

    public void setFromParam(String str) {
        this.mFromParam = str;
    }

    public String getKeyByUser() {
        return this.mKeyByUser;
    }

    public void setKeyByUser(String str) {
        this.mKeyByUser = str;
    }
}
