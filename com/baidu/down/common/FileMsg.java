package com.baidu.down.common;

import com.baidu.down.common.intercepter.IIntercepter;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class FileMsg {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mAntiHijack;
    public long mCurFilePos;
    public String mDownInfoParams;
    public String mDownloadType;
    public String mETag;
    public String mFileName;
    public String mFromParam;
    public HashMap mHeaders;
    public long mId;
    public Map mIntercepters;
    public boolean mIsReplace;
    public boolean mKeepNameAndPath;
    public int mMaxThread;
    public String mMimetype;
    public Boolean mNeedMuti;
    public boolean mNeedThumbnail;
    public boolean mNeedWriteDb;
    public int mPattern;
    public int mPriority;
    public String mProgressStr;
    public String mRealUrl;
    public String mSavePath;
    public String mSid;
    public String mSize;
    public String mTj;
    public long mTotalSize;
    public String mUrl;

    public FileMsg(String str, long j, String str2, String str3, String str4, Boolean bool, String str5) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Long.valueOf(j), str2, str3, str4, bool, str5};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mKeepNameAndPath = false;
        this.mId = -1L;
        this.mMaxThread = 2;
        this.mIsReplace = false;
        this.mNeedThumbnail = false;
        this.mProgressStr = "";
        this.mAntiHijack = false;
        this.mIntercepters = new HashMap();
        this.mPriority = 3;
        this.mNeedWriteDb = true;
        this.mId = j;
        this.mUrl = str;
        this.mSavePath = str2;
        this.mFileName = str3;
        this.mMimetype = str4;
        this.mNeedMuti = bool;
        this.mETag = str5;
    }

    public FileMsg(String str, long j, String str2, String str3, String str4, Boolean bool, HashMap hashMap, long j2, long j3, String str5) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Long.valueOf(j), str2, str3, str4, bool, hashMap, Long.valueOf(j2), Long.valueOf(j3), str5};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mKeepNameAndPath = false;
        this.mId = -1L;
        this.mMaxThread = 2;
        this.mIsReplace = false;
        this.mNeedThumbnail = false;
        this.mProgressStr = "";
        this.mAntiHijack = false;
        this.mIntercepters = new HashMap();
        this.mPriority = 3;
        this.mNeedWriteDb = false;
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

    public void addIntercepter(String str, IIntercepter iIntercepter) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, str, iIntercepter) == null) && str != null) {
            this.mIntercepters.put(str, iIntercepter);
        }
    }
}
