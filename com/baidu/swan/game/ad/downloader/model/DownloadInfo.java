package com.baidu.swan.game.ad.downloader.model;

import android.text.TextUtils;
import com.baidu.swan.apps.adlanding.download.model.SwanAdDownloadState;
import com.baidu.swan.game.ad.downloader.c.b;
import com.baidu.swan.game.ad.downloader.exception.DownloadException;
import java.io.Serializable;
/* loaded from: classes3.dex */
public class DownloadInfo implements Serializable {
    private long mCreateAt;
    private transient b mDownloadListener;
    private DownloadException mException;
    private String mId;
    private String mPackageName;
    private String mPath;
    private long mProgress;
    private long mSize;
    private int mStatus;
    private String mUri;

    public b getDownloadListener() {
        return this.mDownloadListener;
    }

    public void setDownloadListener(b bVar) {
        this.mDownloadListener = bVar;
    }

    public DownloadException getException() {
        return this.mException;
    }

    public void setException(DownloadException downloadException) {
        this.mException = downloadException;
    }

    public String getId() {
        return this.mId;
    }

    public void setId(String str) {
        this.mId = str;
    }

    public long getCreateAt() {
        return this.mCreateAt;
    }

    public void setCreateAt(long j) {
        this.mCreateAt = j;
    }

    public String getUri() {
        return this.mUri;
    }

    public void setUri(String str) {
        this.mUri = str;
    }

    public String getPackageName() {
        return this.mPackageName;
    }

    public DownloadInfo setPackageName(String str) {
        this.mPackageName = str;
        return this;
    }

    public String getPath() {
        return this.mPath;
    }

    public void setPath(String str) {
        this.mPath = str;
    }

    public long getSize() {
        return this.mSize;
    }

    public void setSize(long j) {
        this.mSize = j;
    }

    public long getProgress() {
        return this.mProgress;
    }

    public void setProgress(long j) {
        this.mProgress = j;
    }

    public int getStatus() {
        return this.mStatus;
    }

    public void setStatus(int i) {
        this.mStatus = i;
    }

    public String toString() {
        return "DownloadInfo{mDownloadListener=" + this.mDownloadListener + ", mException=" + this.mException + ", mId='" + this.mId + "', mCreateAt=" + this.mCreateAt + ", mUri='" + this.mUri + "', mPackageName='" + this.mPackageName + "', mPath='" + this.mPath + "', mSize=" + this.mSize + ", mProgress=" + this.mProgress + ", mStatus=" + this.mStatus + '}';
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.mId.equals(((DownloadInfo) obj).mId);
    }

    public int hashCode() {
        return this.mId.hashCode();
    }

    public boolean isPause() {
        return this.mStatus == SwanAdDownloadState.DOWNLOAD_PAUSED.value() || this.mStatus == SwanAdDownloadState.DOWNLOAD_FAILED.value() || this.mStatus == SwanAdDownloadState.DELETED.value();
    }

    /* loaded from: classes3.dex */
    public static final class a {
        private long eaV = -1;
        private String id;
        private String packageName;
        private String path;
        private String url;

        public a dd(long j) {
            this.eaV = j;
            return this;
        }

        public a vV(String str) {
            this.url = str;
            return this;
        }

        public a vW(String str) {
            this.path = str;
            return this;
        }

        public a vX(String str) {
            this.packageName = str;
            return this;
        }

        public DownloadInfo aVl() {
            DownloadInfo downloadInfo = new DownloadInfo();
            if (TextUtils.isEmpty(this.url)) {
                throw new DownloadException(0, "uri cannot be null.");
            }
            downloadInfo.setUri(this.url);
            if (TextUtils.isEmpty(this.path)) {
                throw new DownloadException(1, "path cannot be null.");
            }
            downloadInfo.setPath(this.path);
            if (TextUtils.isEmpty(this.packageName)) {
                downloadInfo.setPackageName(this.packageName);
            }
            if (this.eaV == -1) {
                dd(System.currentTimeMillis());
            }
            if (TextUtils.isEmpty(this.id)) {
                downloadInfo.setId(this.url);
            } else {
                downloadInfo.setId(this.id);
            }
            return downloadInfo;
        }
    }
}
