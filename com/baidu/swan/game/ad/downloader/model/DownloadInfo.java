package com.baidu.swan.game.ad.downloader.model;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.swan.game.ad.downloader.exception.DownloadException;
import com.baidu.tieba.bz3;
import java.io.Serializable;
/* loaded from: classes4.dex */
public class DownloadInfo implements Serializable {
    public long mCreateAt;
    public transient bz3 mDownloadListener;
    public DownloadException mException;
    public String mId;
    public String mPackageName;
    public String mPath;
    public long mProgress;
    public long mSize;
    public int mStatus;
    public String mUri;

    public long getCreateAt() {
        return this.mCreateAt;
    }

    public bz3 getDownloadListener() {
        return this.mDownloadListener;
    }

    public DownloadException getException() {
        return this.mException;
    }

    public String getId() {
        return this.mId;
    }

    public String getPackageName() {
        return this.mPackageName;
    }

    public String getPath() {
        return this.mPath;
    }

    public long getProgress() {
        return this.mProgress;
    }

    public long getSize() {
        return this.mSize;
    }

    public int getStatus() {
        return this.mStatus;
    }

    public String getUri() {
        return this.mUri;
    }

    public int hashCode() {
        return this.mId.hashCode();
    }

    public boolean isPause() {
        if (this.mStatus != DownloadState.DOWNLOAD_PAUSED.value() && this.mStatus != DownloadState.DOWNLOAD_FAILED.value() && this.mStatus != DownloadState.DELETED.value()) {
            return false;
        }
        return true;
    }

    /* loaded from: classes4.dex */
    public static final class a {
        public String a;
        public long b = -1;
        public String c;
        public String d;
        public String e;

        public DownloadInfo a() {
            DownloadInfo downloadInfo = new DownloadInfo();
            if (!TextUtils.isEmpty(this.c)) {
                downloadInfo.setUri(this.c);
                if (!TextUtils.isEmpty(this.e)) {
                    downloadInfo.setPath(this.e);
                    if (TextUtils.isEmpty(this.d)) {
                        downloadInfo.setPackageName(this.d);
                    }
                    if (this.b == -1) {
                        b(System.currentTimeMillis());
                    }
                    if (TextUtils.isEmpty(this.a)) {
                        downloadInfo.setId(this.c);
                    } else {
                        downloadInfo.setId(this.a);
                    }
                    return downloadInfo;
                }
                throw new DownloadException(1, "path cannot be null.");
            }
            throw new DownloadException(0, "uri cannot be null.");
        }

        public a b(long j) {
            this.b = j;
            return this;
        }

        public a c(String str) {
            this.d = str;
            return this;
        }

        public a d(String str) {
            this.e = str;
            return this;
        }

        public a e(String str) {
            this.c = str;
            return this;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && DownloadInfo.class == obj.getClass()) {
            return this.mId.equals(((DownloadInfo) obj).mId);
        }
        return false;
    }

    public void setCreateAt(long j) {
        this.mCreateAt = j;
    }

    public void setDownloadListener(bz3 bz3Var) {
        this.mDownloadListener = bz3Var;
    }

    public void setException(DownloadException downloadException) {
        this.mException = downloadException;
    }

    public void setId(String str) {
        this.mId = str;
    }

    public DownloadInfo setPackageName(String str) {
        this.mPackageName = str;
        return this;
    }

    public void setPath(String str) {
        this.mPath = str;
    }

    public void setProgress(long j) {
        this.mProgress = j;
    }

    public void setSize(long j) {
        this.mSize = j;
    }

    public void setStatus(int i) {
        this.mStatus = i;
    }

    public void setUri(String str) {
        this.mUri = str;
    }

    @NonNull
    public String toString() {
        return "DownloadInfo{mDownloadListener=" + this.mDownloadListener + ", mException=" + this.mException + ", mId='" + this.mId + "', mCreateAt=" + this.mCreateAt + ", mUri='" + this.mUri + "', mPackageName='" + this.mPackageName + "', mPath='" + this.mPath + "', mSize=" + this.mSize + ", mProgress=" + this.mProgress + ", mStatus=" + this.mStatus + '}';
    }
}
