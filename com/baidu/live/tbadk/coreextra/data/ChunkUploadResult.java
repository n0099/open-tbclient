package com.baidu.live.tbadk.coreextra.data;
/* loaded from: classes3.dex */
public class ChunkUploadResult {
    private ChunkUploadData mData;
    private int mErrorCode;
    private String mErrorString;
    private boolean mIsSuccess;

    public ChunkUploadData getData() {
        return this.mData;
    }

    public void setData(ChunkUploadData chunkUploadData) {
        this.mData = chunkUploadData;
    }

    public boolean isSuccess() {
        return this.mIsSuccess;
    }

    public void setIsSuccess(boolean z) {
        this.mIsSuccess = z;
    }

    public int getErrorCode() {
        return this.mErrorCode;
    }

    public void setErrorCode(int i) {
        this.mErrorCode = i;
    }

    public String getErrorString() {
        return this.mErrorString;
    }

    public void setErrorString(String str) {
        this.mErrorString = str;
    }
}
