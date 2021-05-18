package com.baidu.swan.game.ad.downloader.model;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.swan.game.ad.downloader.exception.DownloadException;
import d.a.i0.f.i.k.f.c;
import java.io.Serializable;
/* loaded from: classes3.dex */
public class DownloadInfo implements Serializable {
    public long mCreateAt;
    public transient c mDownloadListener;
    public DownloadException mException;
    public String mId;
    public String mPackageName;
    public String mPath;
    public long mProgress;
    public long mSize;
    public int mStatus;
    public String mUri;

    /* loaded from: classes3.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public String f11628a;

        /* renamed from: b  reason: collision with root package name */
        public long f11629b = -1;

        /* renamed from: c  reason: collision with root package name */
        public String f11630c;

        /* renamed from: d  reason: collision with root package name */
        public String f11631d;

        /* renamed from: e  reason: collision with root package name */
        public String f11632e;

        public DownloadInfo a() {
            DownloadInfo downloadInfo = new DownloadInfo();
            if (!TextUtils.isEmpty(this.f11630c)) {
                downloadInfo.setUri(this.f11630c);
                if (!TextUtils.isEmpty(this.f11632e)) {
                    downloadInfo.setPath(this.f11632e);
                    if (TextUtils.isEmpty(this.f11631d)) {
                        downloadInfo.setPackageName(this.f11631d);
                    }
                    if (this.f11629b == -1) {
                        b(System.currentTimeMillis());
                    }
                    if (TextUtils.isEmpty(this.f11628a)) {
                        downloadInfo.setId(this.f11630c);
                    } else {
                        downloadInfo.setId(this.f11628a);
                    }
                    return downloadInfo;
                }
                throw new DownloadException(1, "path cannot be null.");
            }
            throw new DownloadException(0, "uri cannot be null.");
        }

        public a b(long j) {
            this.f11629b = j;
            return this;
        }

        public a c(String str) {
            this.f11631d = str;
            return this;
        }

        public a d(String str) {
            this.f11632e = str;
            return this;
        }

        public a e(String str) {
            this.f11630c = str;
            return this;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || DownloadInfo.class != obj.getClass()) {
            return false;
        }
        return this.mId.equals(((DownloadInfo) obj).mId);
    }

    public long getCreateAt() {
        return this.mCreateAt;
    }

    public c getDownloadListener() {
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
        return this.mStatus == DownloadState.DOWNLOAD_PAUSED.value() || this.mStatus == DownloadState.DOWNLOAD_FAILED.value() || this.mStatus == DownloadState.DELETED.value();
    }

    public void setCreateAt(long j) {
        this.mCreateAt = j;
    }

    public void setDownloadListener(c cVar) {
        this.mDownloadListener = cVar;
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

    public void setStatus(int i2) {
        this.mStatus = i2;
    }

    public void setUri(String str) {
        this.mUri = str;
    }

    @NonNull
    public String toString() {
        return "DownloadInfo{mDownloadListener=" + this.mDownloadListener + ", mException=" + this.mException + ", mId='" + this.mId + "', mCreateAt=" + this.mCreateAt + ", mUri='" + this.mUri + "', mPackageName='" + this.mPackageName + "', mPath='" + this.mPath + "', mSize=" + this.mSize + ", mProgress=" + this.mProgress + ", mStatus=" + this.mStatus + '}';
    }
}
