package com.baidu.down.request.task;

import android.content.Context;
import com.baidu.down.common.DownConstants;
import com.baidu.down.common.TaskMsg;
import com.baidu.down.common.intercepter.IIntercepter;
import com.baidu.down.loopj.android.http.BinaryHttpResponseHandler;
import com.baidu.down.retry.HttpRetryStrategyHandler;
import com.baidu.down.statistic.TaskSpeedStat;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public abstract class AbstractTask implements DownConstants, Comparable<AbstractTask> {
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
    public RandomAccessFile fout;
    public boolean isReplace;
    public Context mContext;
    public long mCurLength;
    public int mDownInfoMode;
    public String mDownInfoParams;
    public String mDownloadType;
    public String mFromParam;
    public HashMap<String, String> mHeaders;
    public String mHost;
    public HttpRetryStrategyHandler mHttpRetryStrategyHandler;
    public String mSid;
    public String mSize;
    public long mSizeB;
    public long mStartTime;
    public BinaryHttpResponseHandler mTaskHandler;
    public TaskSpeedStat mTaskSpeedStat;
    public int mTaskType;
    public TaskMsg mTaskmsg;
    public String mTj;
    public boolean needThumbnail;
    public boolean needWriteDb;
    public int mMaxThread = 2;
    public int mMaxTestIpCount = 2;
    public int mThreadCount = 0;
    public boolean mBNotifyStart = false;
    public Map<String, IIntercepter<?>> mIntercepters = new HashMap();
    public int mStatus = -1;
    public long mDownloadId = -1;
    public String mUri = "";
    public String mRealUrl = "";
    public String mFilename = "";
    public boolean mKeepNameAndPath = false;
    public String mFileDir = "";
    public String mFilePath = "";
    public String mMimetype = "";
    public String mETag = "";
    public boolean mIsVisibility = true;
    public long mTotalLength = 0;
    public ProgressInfo mProgressInfo = new ProgressInfo();
    public int mRetryCount = 0;
    public File mFile = null;
    public boolean mNeedMuti = false;
    public long mLastNotifyTime = 0;
    public long mLastNotifySpeed = 0;
    public long mLastNotifyBytes = 0;
    public long mWriteFileLastTime = 0;
    public boolean mLengthRec = false;
    public String mDownloadUri = "";
    public String mStrRedownload = "";
    public int mPriority = 3;
    public Context myContext = null;

    public AbstractTask(int i2) {
        this.mTaskType = i2;
    }

    public abstract String getDefaultUrl();

    public abstract String getFastestUrl();

    public abstract String getNoMeasuredUrl(boolean z);

    public int getPriority() {
        return this.mPriority;
    }

    public String getTaskKey() {
        return this.mUri + this.mDownloadId;
    }

    public abstract void pause();

    public abstract void pend();

    public void setPriority(int i2) {
        if (i2 < 1) {
            i2 = 1;
        } else if (i2 > 5) {
            i2 = 5;
        }
        this.mPriority = i2;
    }

    public void setTaskmsg(TaskMsg taskMsg) {
        this.mTaskmsg = taskMsg;
    }

    public abstract void start();

    public abstract void stop(boolean z);

    public String toString() {
        return "[mUri=" + this.mUri + "][mDownloadId=" + this.mDownloadId + "][status=" + this.mStatus + PreferencesUtil.RIGHT_MOUNT;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    public int compareTo(AbstractTask abstractTask) {
        int i2 = this.mPriority;
        int i3 = abstractTask.mPriority;
        if (i2 > i3) {
            return -1;
        }
        if (i2 == i3) {
            long j = this.mLastNotifyBytes;
            if (j > 0) {
                long j2 = this.mTotalLength;
                if (j2 > 0) {
                    long j3 = this.mLastNotifySpeed;
                    if (j3 > 0) {
                        long j4 = abstractTask.mLastNotifyBytes;
                        if (j4 > 0) {
                            long j5 = abstractTask.mTotalLength;
                            if (j5 > 0) {
                                long j6 = abstractTask.mLastNotifySpeed;
                                if (j6 > 0) {
                                    int i4 = (((j2 - j) / j3) > ((j5 - j4) / j6) ? 1 : (((j2 - j) / j3) == ((j5 - j4) / j6) ? 0 : -1));
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
                long j7 = this.mSizeB;
                if (j7 > 0 && abstractTask.mTotalLength == 0) {
                    long j8 = abstractTask.mSizeB;
                    if (j8 > 0) {
                        if (j7 > j8) {
                            return 1;
                        }
                        if (j7 < j8) {
                            return -1;
                        }
                    }
                }
            }
            return 0;
        }
        return 1;
    }
}
