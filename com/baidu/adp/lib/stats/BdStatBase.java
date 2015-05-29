package com.baidu.adp.lib.stats;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.ac;
import com.baidu.tbadk.TbConfig;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public abstract class BdStatBase implements Serializable {
    protected static final int MAX_FILE_EXCEPTION_COUNT = 5;
    protected static final int MAX_FILE_LENGTH = 102400;
    protected static final long MAX_STORAGE_TIME = 259200000;
    protected static String mProcessNameMd5 = null;
    private static final long serialVersionUID = 5207364475676984722L;
    private Context mContext;
    protected String mCurrentLogFile;
    private long mLastLogTime;
    protected String mLogDir;
    protected StringBuffer mMemCache;
    protected String mUid;
    protected boolean mIsLogOpen = false;
    protected boolean mIsOnlyWifi = false;
    protected boolean mIsEachRefreshFile = false;
    protected int mMaxMemCount = 50;
    protected int mFileExceptionCount = 0;
    protected boolean mIsNetworkWifi = false;
    protected int mMemCacheCount = 0;
    protected boolean mIsUploading = false;
    protected long mLastUploadTime = 0;
    protected BdStatFirstSwitchData mSwitchData = null;

    public abstract void changeUser(String str);

    public abstract boolean checkFileFailed();

    public abstract boolean checkToSendSaveMessage(boolean z);

    public abstract boolean checkToSendUploadMessage(boolean z);

    public abstract void clearLogResource();

    public abstract void clearLogs();

    public abstract String getCurrentLogFile();

    public abstract BdUploadingLogInfo getLogFiles();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract int getLogFilesMaxSize();

    public abstract String getPostFileName();

    protected abstract boolean isLogDataFull();

    public abstract ArrayList<String> readLogFile(String str);

    public abstract void refreshFile(boolean z);

    public abstract void splitFile();

    public abstract void uploadSucc(ArrayList<s> arrayList);

    public BdStatBase(Context context, String str, boolean z) {
        this.mLastLogTime = 0L;
        this.mContext = null;
        this.mContext = context;
        this.mLogDir = str;
        this.mLastLogTime = System.currentTimeMillis();
        com.baidu.adp.lib.util.f.aP(this.mLogDir);
        if (TextUtils.isEmpty(mProcessNameMd5)) {
            if (z) {
                mProcessNameMd5 = "44f94582";
            } else {
                mProcessNameMd5 = hw();
            }
        }
        this.mMemCache = new StringBuffer();
    }

    public boolean ismIsNetworkWifi() {
        return this.mIsNetworkWifi;
    }

    public void setmIsNetworkWifi(boolean z) {
        this.mIsNetworkWifi = z;
    }

    public String getmUid() {
        return this.mUid;
    }

    public void setmUid(String str) {
        this.mUid = str;
    }

    public long getmLastUploadTime() {
        return this.mLastUploadTime;
    }

    public void setmLastUploadTime(long j) {
        this.mLastUploadTime = j;
    }

    public boolean ismIsUploading() {
        return this.mIsUploading;
    }

    public void setmIsUploading(boolean z) {
        this.mIsUploading = z;
    }

    public String getmFilePath() {
        return this.mLogDir;
    }

    public void setmFilePath(String str) {
        this.mLogDir = str;
    }

    public boolean ismIsLogOpen() {
        return this.mIsLogOpen;
    }

    public void setmIsLogOpen(boolean z) {
        this.mIsLogOpen = z;
    }

    public boolean ismIsOnlyWifi() {
        return this.mIsOnlyWifi;
    }

    public void setmIsOnlyWifi(boolean z) {
        this.mIsOnlyWifi = z;
    }

    public boolean ismIsEachRefreshFile() {
        return this.mIsEachRefreshFile;
    }

    public void setmIsEachRefreshFile(boolean z) {
        this.mIsEachRefreshFile = z;
    }

    public void add(q qVar) {
        if (qVar != null) {
            try {
                this.mMemCache.append(qVar.toString());
                this.mMemCache.append("\r\n");
                this.mMemCacheCount++;
            } catch (Exception e) {
                BdLog.e(e);
            } catch (OutOfMemoryError e2) {
                BdBaseApplication.getInst().onAppMemoryLow();
            }
        }
        if (System.currentTimeMillis() - this.mLastLogTime > TbConfig.USE_TIME_INTERVAL) {
            f.hz().a(this, true, false);
        } else {
            f.hz().a(this, false, false);
        }
        this.mLastLogTime = System.currentTimeMillis();
    }

    public boolean isNeedRefreshFile() {
        return this.mMemCacheCount > 0 && (this.mIsEachRefreshFile || this.mMemCacheCount >= 10);
    }

    public void setSwitchData(BdStatFirstSwitchData bdStatFirstSwitchData) {
        if (bdStatFirstSwitchData != null) {
            this.mSwitchData = bdStatFirstSwitchData;
            BdStatCommonSwitchData common = this.mSwitchData.getCommon();
            if (common != null) {
                this.mIsEachRefreshFile = common.isIs_exact();
                this.mIsLogOpen = common.isIs_open();
                this.mIsOnlyWifi = common.isIs_only_wifi();
            }
        }
    }

    public boolean isSubTypeOpen(String str) {
        if (TextUtils.isEmpty(str) || this.mSwitchData == null || this.mSwitchData.getChildren() == null) {
            return true;
        }
        Iterator<BdStatSecondSwitchData> it = this.mSwitchData.getChildren().iterator();
        while (it.hasNext()) {
            BdStatSecondSwitchData next = it.next();
            if (next != null && next.getType() != null && next.getType().equals(str)) {
                return next.isIs_open();
            }
        }
        return true;
    }

    public ArrayList<String> filter(ArrayList<String> arrayList) {
        return arrayList;
    }

    public ArrayList<String> getMemData() {
        if (this.mMemCache != null && this.mMemCache.length() > 0) {
            ArrayList<String> arrayList = new ArrayList<>();
            String[] split = this.mMemCache.toString().split("\r\n");
            if (split != null && split.length > 0) {
                for (String str : split) {
                    arrayList.add(str);
                }
                return arrayList;
            }
            return arrayList;
        }
        return null;
    }

    public void clearMemData() {
        this.mMemCache = new StringBuffer();
        this.mMemCacheCount = 0;
    }

    public void handleException() {
    }

    private String hw() {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        if (this.mContext == null) {
            return null;
        }
        ActivityManager activityManager = (ActivityManager) this.mContext.getSystemService("activity");
        if (activityManager != null && (runningAppProcesses = activityManager.getRunningAppProcesses()) != null) {
            int myPid = Process.myPid();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= runningAppProcesses.size()) {
                    break;
                }
                if (runningAppProcesses.get(i2).pid == myPid) {
                    String str = runningAppProcesses.get(i2).processName;
                    if (!TextUtils.isEmpty(str)) {
                        try {
                            String p = ac.p(str.getBytes("UTF-8"));
                            if (!TextUtils.isEmpty(p) && p.length() > 8) {
                                return p.substring(p.length() - 8);
                            }
                            return p;
                        } catch (UnsupportedEncodingException e) {
                            BdLog.e(e.getMessage());
                            return str;
                        }
                    }
                }
                i = i2 + 1;
            }
        }
        return null;
    }
}
