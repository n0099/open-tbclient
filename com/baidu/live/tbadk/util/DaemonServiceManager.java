package com.baidu.live.tbadk.util;

import android.text.TextUtils;
import com.baidu.live.adp.lib.asynctask.BdAsyncTask;
import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.FileHelper;
/* loaded from: classes7.dex */
public class DaemonServiceManager {
    public static final String CRASH_HOUR_RECORD_FILE = "crash_hour_record.log";
    public static final int MAX_CRASH_NUM_HOUR = 1;
    private static DaemonServiceManager mInstance = new DaemonServiceManager();
    private CheckCrashNumCallBack mCallBack;
    private CheckCrashNumOverLimitTask mTask;

    /* loaded from: classes7.dex */
    public interface CheckCrashNumCallBack {
        void onResult(boolean z);
    }

    private DaemonServiceManager() {
    }

    public static DaemonServiceManager getInstance() {
        return mInstance;
    }

    public void checkCrashNumOverLimit(CheckCrashNumCallBack checkCrashNumCallBack) {
        this.mCallBack = checkCrashNumCallBack;
        if (this.mTask != null) {
            this.mTask.cancel();
        }
        this.mTask = new CheckCrashNumOverLimitTask();
        this.mTask.setPriority(4);
        this.mTask.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkCrashNumOverLimit() {
        int i;
        long j = 0;
        byte[] GetFileData = FileHelper.GetFileData(TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/" + CRASH_HOUR_RECORD_FILE);
        String str = null;
        if (GetFileData != null) {
            str = new String(GetFileData);
        }
        long j2 = StringUtils.getyyyyMMddHHTimeForNow();
        if (TextUtils.isEmpty(str)) {
            i = 0;
        } else {
            String[] split = str.split(":");
            if (split == null || split.length != 2) {
                i = 0;
            } else {
                i = JavaTypesHelper.toInt(split[0], 0);
                j = JavaTypesHelper.toLong(split[1], j2);
            }
        }
        if (j == j2 && i > 1) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class CheckCrashNumOverLimitTask extends BdAsyncTask<String, Integer, Boolean> {
        private CheckCrashNumOverLimitTask() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            return Boolean.valueOf(DaemonServiceManager.this.checkCrashNumOverLimit());
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            if (DaemonServiceManager.this.mCallBack != null && bool != null) {
                DaemonServiceManager.this.mCallBack.onResult(bool.booleanValue());
            }
        }
    }
}
