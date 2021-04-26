package com.baidu.down.common;

import com.baidu.down.common.intercepter.IIntercepter;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class FileMsg {
    public long mCurFilePos;
    public String mDownInfoParams;
    public String mDownloadType;
    public String mETag;
    public String mFileName;
    public String mFromParam;
    public HashMap<String, String> mHeaders;
    public long mId;
    public String mMimetype;
    public Boolean mNeedMuti;
    public int mPattern;
    public String mSavePath;
    public String mSid;
    public String mSize;
    public String mTj;
    public long mTotalSize;
    public String mUrl;
    public boolean mKeepNameAndPath = false;
    public int mMaxThread = 2;
    public boolean mIsReplace = false;
    public boolean mNeedThumbnail = false;
    public String mProgressStr = "";
    public boolean mAntiHijack = false;
    public Map<String, IIntercepter<?>> mIntercepters = new HashMap();
    public int mPriority = 3;
    public boolean mNeedWriteDb = true;

    public FileMsg(String str, long j, String str2, String str3, String str4, Boolean bool, String str5) {
        this.mId = -1L;
        this.mId = j;
        this.mUrl = str;
        this.mSavePath = str2;
        this.mFileName = str3;
        this.mMimetype = str4;
        this.mNeedMuti = bool;
        this.mETag = str5;
    }

    public void addIntercepter(String str, IIntercepter<?> iIntercepter) {
        if (str != null) {
            this.mIntercepters.put(str, iIntercepter);
        }
    }

    public FileMsg(String str, long j, String str2, String str3, String str4, Boolean bool, HashMap<String, String> hashMap, long j2, long j3, String str5) {
        this.mId = -1L;
        this.mId = j;
        this.mUrl = str;
        this.mSavePath = str2;
        this.mFileName = str3;
        this.mMimetype = str4;
        this.mNeedMuti = bool;
        this.mHeaders = hashMap;
        this.mCurFilePos = j2;
        this.mTotalSize = j3;
        this.mETag = str5;
    }
}
