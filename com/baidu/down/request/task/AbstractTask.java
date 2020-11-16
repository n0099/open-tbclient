package com.baidu.down.request.task;

import android.content.Context;
import android.support.v4.media.session.PlaybackStateCompat;
import com.baidu.down.common.DownConstants;
import com.baidu.down.common.TaskMsg;
import com.baidu.down.common.intercepter.IIntercepter;
import com.baidu.down.loopj.android.http.BinaryHttpResponseHandler;
import com.baidu.down.retry.HttpRetryStrategyHandler;
import com.baidu.down.statistic.TaskSpeedStat;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes15.dex */
public abstract class AbstractTask implements DownConstants, Comparable<AbstractTask> {
    public static final int DF_SEG_SIZE = 524288;
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
    public static int DF_SEG_WRITE_SIZE = 524288;
    public static int bufferSize = 16384;
    public static long minSegLen = PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
    public int mMaxThread = 2;
    public int mMaxTestIpCount = 2;
    public int mThreadCount = 0;
    public boolean mBNotifyStart = false;
    public Map<String, IIntercepter<?>> mIntercepters = new HashMap();
    public int mStatus = -1;
    public long mDownloadId = -1;
    public String mUri = "";
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
    private int mPriority = 3;
    public Context myContext = null;

    public abstract String getDefaultUrl();

    public abstract String getFastestUrl();

    public abstract String getNoMeasuredUrl(boolean z);

    public abstract void pause();

    public abstract void pend();

    public abstract void start();

    public abstract void stop(boolean z);

    public AbstractTask(int i) {
        this.mTaskType = i;
    }

    public String getTaskKey() {
        return this.mUri + this.mDownloadId;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    public int compareTo(AbstractTask abstractTask) {
        if (this.mPriority > abstractTask.mPriority) {
            return -1;
        }
        if (this.mPriority == abstractTask.mPriority) {
            if (this.mLastNotifyBytes > 0 && this.mTotalLength > 0 && this.mLastNotifySpeed > 0 && abstractTask.mLastNotifyBytes > 0 && abstractTask.mTotalLength > 0 && abstractTask.mLastNotifySpeed > 0) {
                long j = (this.mTotalLength - this.mLastNotifyBytes) / this.mLastNotifySpeed;
                long j2 = (abstractTask.mTotalLength - abstractTask.mLastNotifyBytes) / abstractTask.mLastNotifySpeed;
                if (j > j2) {
                    return 1;
                }
                return j >= j2 ? 0 : -1;
            } else if (this.mTotalLength != 0 || this.mSizeB <= 0 || abstractTask.mTotalLength != 0 || abstractTask.mSizeB <= 0) {
                return 0;
            } else {
                if (this.mSizeB > abstractTask.mSizeB) {
                    return 1;
                }
                return this.mSizeB >= abstractTask.mSizeB ? 0 : -1;
            }
        }
        return 1;
    }

    public void setPriority(int i) {
        if (i < 1) {
            i = 1;
        } else if (i > 5) {
            i = 5;
        }
        this.mPriority = i;
    }

    public int getPriority() {
        return this.mPriority;
    }

    public void setTaskmsg(TaskMsg taskMsg) {
        this.mTaskmsg = taskMsg;
    }

    public String toString() {
        return "[mUri=" + this.mUri + "][mDownloadId=" + this.mDownloadId + "][status=" + this.mStatus + "]";
    }
}
