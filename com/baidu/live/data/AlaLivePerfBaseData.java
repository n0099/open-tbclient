package com.baidu.live.data;

import android.app.ActivityManager;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.live.adp.lib.asynctask.BdAsyncTask;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.performancelog.PerformanceLoggerHelper;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class AlaLivePerfBaseData implements Serializable {
    public static final int ALA_LIVE_TYPE_CAMERA_AUTO = 3;
    public static final int ALA_LIVE_TYPE_CAMERA_LANDSCAPE = 2;
    public static final int ALA_LIVE_TYPE_CAMERA_PORTRAIT = 1;
    public static final int ALA_LIVE_TYPE_SCREEN_AUTO = 6;
    public static final int ALA_LIVE_TYPE_SCREEN_LANDSCAPE = 5;
    public static final int ALA_LIVE_TYPE_SCREEN_PORTRAIT = 4;
    public static final int ALA_SIMPLE_MAX_NUM = 50;
    private static final long SAMPLE_TIME_MIN_INTERVAL = 2000;
    private static final long serialVersionUID = 2553722034441138777L;
    public long IMFlow;
    public long dataFlow;
    public long dropACount;
    public long dropCount;
    public long dropICount;
    public long dropPCount;
    public float energyUsage;
    public int errCode;
    public int errSubReason;
    public boolean isCharging;
    public boolean isSuccess;
    public String liveID;
    public long logID;
    private PerfAsyncTask mPerTask;
    public long mediaFlow;
    public long netFlow;
    public long prictureFlow;
    public int cpuStatCount = 0;
    public int cpuAvg = 0;
    public int cpuMax = 0;
    public int cpuMin = 0;
    public int cpuTotal = 0;
    public int memStatCount = 0;
    public int memAvg = 0;
    public int memMax = 0;
    public int memMin = 0;
    public int memTotal = 0;
    public int liveType = 1;
    public int sessionLine = 1;
    private int mMemoryCpuSimpleIndex = 0;
    private long mLastSampleTime = 0;
    private final MyHanlder mainHanlderHandler = new MyHanlder(Looper.getMainLooper()) { // from class: com.baidu.live.data.AlaLivePerfBaseData.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            AlaLivePerfBaseData.this.mPerTask = new PerfAsyncTask();
            AlaLivePerfBaseData.this.mPerTask.setSelfExecute(true);
            AlaLivePerfBaseData.this.mPerTask.execute(new String[0]);
        }
    };
    public List<Integer> memoryArray = new ArrayList();
    public List<Integer> cpuArray = new ArrayList();

    public void sampleMemAndCPU() {
        if (this.mMemoryCpuSimpleIndex < 50 && System.currentTimeMillis() - this.mLastSampleTime > 2000) {
            this.mLastSampleTime = System.currentTimeMillis();
            this.mainHanlderHandler.sendEmptyMessage(0);
        }
    }

    public String getCpuMemJsonFormat() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.cpuStatCount > 0) {
                jSONObject.putOpt("cpu_avg", Integer.toString(this.cpuTotal / this.cpuStatCount));
                jSONObject.putOpt("cpu_max", Integer.toString(this.cpuMax));
                jSONObject.putOpt("cpu_min", Integer.toString(this.cpuMin));
            }
            if (this.memStatCount > 0) {
                jSONObject.putOpt("mem_avg", Integer.toString(this.memTotal / this.memStatCount));
                jSONObject.putOpt("mem_max", Integer.toString(this.memMax));
                jSONObject.putOpt("mem_min", Integer.toString(this.memMin));
            }
            return jSONObject.toString();
        } catch (Throwable th) {
            return "";
        }
    }

    /* loaded from: classes10.dex */
    private class PerfAsyncTask extends BdAsyncTask<String, Integer, Boolean> implements Serializable {
        private static final long serialVersionUID = 736604043413032431L;

        public PerfAsyncTask() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            if (AlaLivePerfBaseData.this.memoryArray.size() >= 50) {
                return Boolean.TRUE;
            }
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            ((ActivityManager) TbadkCoreApplication.getInst().getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getMemoryInfo(memoryInfo);
            try {
                FileReader fileReader = new FileReader("/proc/meminfo");
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                int parseLong = (int) ((memoryInfo.availMem * 100) / (Long.parseLong(bufferedReader.readLine().split("\\s+")[1]) * 1024));
                AlaLivePerfBaseData.this.memoryArray.add(Integer.valueOf(parseLong));
                AlaLivePerfBaseData.this.memStatCount++;
                if (AlaLivePerfBaseData.this.memTotal == 0) {
                    AlaLivePerfBaseData.this.memMax = parseLong;
                    AlaLivePerfBaseData.this.memMin = parseLong;
                } else {
                    AlaLivePerfBaseData.this.memMin = AlaLivePerfBaseData.this.memMin < parseLong ? AlaLivePerfBaseData.this.memMin : parseLong;
                    AlaLivePerfBaseData.this.memMax = AlaLivePerfBaseData.this.memMax > parseLong ? AlaLivePerfBaseData.this.memMax : parseLong;
                }
                AlaLivePerfBaseData alaLivePerfBaseData = AlaLivePerfBaseData.this;
                alaLivePerfBaseData.memTotal = parseLong + alaLivePerfBaseData.memTotal;
                bufferedReader.close();
                fileReader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            int cpuUsageStatistic = PerformanceLoggerHelper.getInstance().getCpuUsageStatistic();
            AlaLivePerfBaseData.this.cpuArray.add(Integer.valueOf(cpuUsageStatistic));
            AlaLivePerfBaseData.this.cpuStatCount++;
            if (AlaLivePerfBaseData.this.cpuTotal == 0) {
                AlaLivePerfBaseData.this.cpuMax = cpuUsageStatistic;
                AlaLivePerfBaseData.this.cpuMin = cpuUsageStatistic;
            } else {
                AlaLivePerfBaseData.this.cpuMin = AlaLivePerfBaseData.this.cpuMin < cpuUsageStatistic ? AlaLivePerfBaseData.this.cpuMin : cpuUsageStatistic;
                AlaLivePerfBaseData.this.cpuMax = AlaLivePerfBaseData.this.cpuMax > cpuUsageStatistic ? AlaLivePerfBaseData.this.cpuMax : cpuUsageStatistic;
            }
            AlaLivePerfBaseData alaLivePerfBaseData2 = AlaLivePerfBaseData.this;
            alaLivePerfBaseData2.cpuTotal = cpuUsageStatistic + alaLivePerfBaseData2.cpuTotal;
            return Boolean.TRUE;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
        }
    }

    /* loaded from: classes10.dex */
    private class MyHanlder extends Handler implements Serializable {
        private static final long serialVersionUID = -6005043708305598215L;

        public MyHanlder(Looper looper) {
            super(looper);
        }
    }

    public void reset() {
        this.logID = 0L;
        this.liveID = "";
        this.memoryArray = new ArrayList();
        this.cpuArray = new ArrayList();
        this.energyUsage = 0.0f;
        this.isCharging = false;
        this.dataFlow = 0L;
        this.netFlow = 0L;
        this.prictureFlow = 0L;
        this.mediaFlow = 0L;
        this.IMFlow = 0L;
        this.isSuccess = false;
        this.errCode = 0;
        this.errSubReason = 0;
        this.dropCount = 0L;
        this.dropICount = 0L;
        this.dropPCount = 0L;
        this.dropACount = 0L;
        this.mMemoryCpuSimpleIndex = 0;
    }
}
