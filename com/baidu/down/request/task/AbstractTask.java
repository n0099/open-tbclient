package com.baidu.down.request.task;

import android.content.Context;
import com.baidu.down.common.DownConstants;
import com.baidu.down.common.TaskMsg;
import com.baidu.down.common.intercepter.IIntercepter;
import com.baidu.down.loopj.android.http.BinaryHttpResponseHandler;
import com.baidu.down.retry.HttpRetryStrategyHandler;
import com.baidu.down.statistic.TaskSpeedStat;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes8.dex */
public abstract class AbstractTask implements DownConstants, Comparable<AbstractTask> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DF_SEG_SIZE = 524288;
    public static int DF_SEG_WRITE_SIZE = 524288;
    public static final int MODE_HTTPCLIENT_COMMON = 0;
    public static final int MODE_HTTPCLIENT_MULTISRC = 1;
    public static final int MODE_MULTISRC_MASK = 1;
    public static final int MODE_OKHTTP_COMMON = 16;
    public static final int MODE_OKHTTP_MASK = 16;
    public static final int MODE_OKHTTP_MULTISRC = 17;
    public static final int RANGE_BLOCK_SIZE = 307200;
    public static final int TASK_TYPE_MUTI = 3;
    public static final int TASK_TYPE_NARMAL = 1;
    public static final int TASK_TYPE_WAP = 2;
    public static final int URL_TYPE_DEFAULT = 0;
    public static final int URL_TYPE_FASTEST = 2;
    public static final int URL_TYPE_NOT_MEASURE = 1;
    public static int bufferSize = 16384;
    public static long minSegLen = 524288;
    public transient /* synthetic */ FieldHolder $fh;
    public RandomAccessFile fout;
    public boolean isReplace;
    public boolean mBNotifyStart;
    public Context mContext;
    public long mCurLength;
    public int mDownInfoMode;
    public String mDownInfoParams;
    public long mDownloadId;
    public String mDownloadType;
    public String mDownloadUri;
    public String mETag;
    public File mFile;
    public String mFileDir;
    public String mFilePath;
    public String mFilename;
    public String mFromParam;
    public HashMap<String, String> mHeaders;
    public String mHost;
    public HttpRetryStrategyHandler mHttpRetryStrategyHandler;
    public Map<String, IIntercepter<?>> mIntercepters;
    public boolean mIsVisibility;
    public boolean mKeepNameAndPath;
    public long mLastNotifyBytes;
    public long mLastNotifySpeed;
    public long mLastNotifyTime;
    public boolean mLengthRec;
    public int mMaxTestIpCount;
    public int mMaxThread;
    public String mMimetype;
    public boolean mNeedMuti;
    public int mPriority;
    public ProgressInfo mProgressInfo;
    public String mRealUrl;
    public int mRetryCount;
    public String mSid;
    public String mSize;
    public long mSizeB;
    public long mStartTime;
    public int mStatus;
    public String mStrRedownload;
    public BinaryHttpResponseHandler mTaskHandler;
    public TaskSpeedStat mTaskSpeedStat;
    public int mTaskType;
    public TaskMsg mTaskmsg;
    public int mThreadCount;
    public String mTj;
    public long mTotalLength;
    public String mUri;
    public long mWriteFileLastTime;
    public Context myContext;
    public boolean needThumbnail;
    public boolean needWriteDb;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-457838231, "Lcom/baidu/down/request/task/AbstractTask;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-457838231, "Lcom/baidu/down/request/task/AbstractTask;");
        }
    }

    public AbstractTask(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mMaxThread = 2;
        this.mMaxTestIpCount = 2;
        this.mThreadCount = 0;
        this.mBNotifyStart = false;
        this.mIntercepters = new HashMap();
        this.mStatus = -1;
        this.mDownloadId = -1L;
        this.mUri = "";
        this.mRealUrl = "";
        this.mFilename = "";
        this.mKeepNameAndPath = false;
        this.mFileDir = "";
        this.mFilePath = "";
        this.mMimetype = "";
        this.mETag = "";
        this.mIsVisibility = true;
        this.mTotalLength = 0L;
        this.mProgressInfo = new ProgressInfo();
        this.mRetryCount = 0;
        this.mFile = null;
        this.mNeedMuti = false;
        this.mLastNotifyTime = 0L;
        this.mLastNotifySpeed = 0L;
        this.mLastNotifyBytes = 0L;
        this.mWriteFileLastTime = 0L;
        this.mLengthRec = false;
        this.mDownloadUri = "";
        this.mStrRedownload = "";
        this.mPriority = 3;
        this.myContext = null;
        this.mTaskType = i2;
    }

    public abstract String getDefaultUrl();

    public abstract String getFastestUrl();

    public abstract String getNoMeasuredUrl(boolean z);

    public int getPriority() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mPriority : invokeV.intValue;
    }

    public String getTaskKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.mUri + this.mDownloadId;
        }
        return (String) invokeV.objValue;
    }

    public abstract void pause();

    public abstract void pend();

    public void setPriority(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            if (i2 < 1) {
                i2 = 1;
            } else if (i2 > 5) {
                i2 = 5;
            }
            this.mPriority = i2;
        }
    }

    public void setTaskmsg(TaskMsg taskMsg) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, taskMsg) == null) {
            this.mTaskmsg = taskMsg;
        }
    }

    public abstract void start();

    public abstract void stop(boolean z);

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return "[mUri=" + this.mUri + "][mDownloadId=" + this.mDownloadId + "][status=" + this.mStatus + PreferencesUtil.RIGHT_MOUNT;
        }
        return (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    public int compareTo(AbstractTask abstractTask) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, abstractTask)) == null) {
            int i2 = this.mPriority;
            int i3 = abstractTask.mPriority;
            if (i2 > i3) {
                return -1;
            }
            if (i2 == i3) {
                long j2 = this.mLastNotifyBytes;
                if (j2 > 0) {
                    long j3 = this.mTotalLength;
                    if (j3 > 0) {
                        long j4 = this.mLastNotifySpeed;
                        if (j4 > 0) {
                            long j5 = abstractTask.mLastNotifyBytes;
                            if (j5 > 0) {
                                long j6 = abstractTask.mTotalLength;
                                if (j6 > 0) {
                                    long j7 = abstractTask.mLastNotifySpeed;
                                    if (j7 > 0) {
                                        int i4 = (((j3 - j2) / j4) > ((j6 - j5) / j7) ? 1 : (((j3 - j2) / j4) == ((j6 - j5) / j7) ? 0 : -1));
                                        if (i4 > 0) {
                                            return 1;
                                        }
                                        return i4 < 0 ? -1 : 0;
                                    }
                                }
                            }
                        }
                    }
                }
                if (this.mTotalLength == 0) {
                    long j8 = this.mSizeB;
                    if (j8 > 0 && abstractTask.mTotalLength == 0) {
                        long j9 = abstractTask.mSizeB;
                        if (j9 > 0) {
                            if (j8 > j9) {
                                return 1;
                            }
                            if (j8 < j9) {
                                return -1;
                            }
                        }
                    }
                }
                return 0;
            }
            return 1;
        }
        return invokeL.intValue;
    }
}
