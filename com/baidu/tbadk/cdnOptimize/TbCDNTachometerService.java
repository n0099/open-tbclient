package com.baidu.tbadk.cdnOptimize;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseService;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
/* loaded from: classes.dex */
public class TbCDNTachometerService extends BdBaseService {
    private static final String LAST_GETCDNLIST_TIME = "com.baidu.tbadk.opTimize.lastGetCdnListTiem";
    private static final long TACHOMETER_INTERVAL = 300000;
    public static final String TB_CDNIP_BROADCASE_ACTION = "com.baidu.tbadk.opTimize.tbCdnIpBroadCastAction";
    public static final String TB_CDNIP_BROADCASE_ISMOBILE = "com.baidu.tbadk.opTimize.ismobile";
    public static final String TB_CDNIP_BROADCASE_KEY = "com.baidu.tbadk.opTimize.cdnIpBroadCast";
    public static final String TB_CDNIP_BROADCASE_NEED_USEIP = "com.baidu.tbadk.opTimize.cdnipBroadCastNeedUseIp";
    public static final String TB_CDNIP_BROADCASE_NUM = "com.baidu.tbadk.opTimize.tbCdnIpBroadCastNum";
    private static Object lock = new Object();
    private static long lastTachometerTime = 0;
    private static CustomMessageTask customNormalTask = new CustomMessageTask(2017000, new b());
    private final long TACHOMETER_MAXTIME = TbConfig.USE_TIME_INTERVAL;
    private final int TIMER_MSG_KEY = 1002;
    private m cdnTachometerModel = null;
    private ArrayList<String> optimalIpList = new ArrayList<>();
    private ArrayList<String> belowOnePointFiveIpList = new ArrayList<>();
    private boolean isNormal = false;
    private BdUniqueId mId = BdUniqueId.gen();
    private int returnRequestNum = 0;
    private HashMap<String, ArrayList<String>> cdnIpMap = new HashMap<>();
    private int startID = 0;
    private final String cdnHiPhotosDomain = "c.hiphotos.baidu.com";
    private int hiPhotosMaxTime = 3000;
    private boolean canBroadCast = false;
    private boolean isBroadFirstIp = false;
    private final int TB_CDN_MIN_IP_INTERVAL = TbConfig.READ_IMAGE_CACHE_TIMEOUT_NOT_WIFI;
    private long lastNotifyIpTime = 0;
    private int lastNotifyIpCount = 0;
    private int numOfThrowIp = 0;
    private CustomMessageListener customNormalListener = new c(this, 2017000);
    private final Handler handler = new d(this, Looper.getMainLooper());
    private final o tachometerModelCallBack = new e(this);

    static {
        customNormalTask.a(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        customNormalTask.a(new BdAsyncTaskParallel(BdUniqueId.gen(), 10));
        MessageManager.getInstance().registerTask(customNormalTask);
    }

    public static void startTachometerService(Context context, boolean z, boolean z2) {
        if (context != null && com.baidu.adp.lib.util.i.fg() && TbadkCoreApplication.m255getInst().isMainProcess(true)) {
            if (!z2) {
                synchronized (lock) {
                    if (0 == lastTachometerTime) {
                        lastTachometerTime = com.baidu.tbadk.core.sharedPref.b.oj().getLong(LAST_GETCDNLIST_TIME, 0L);
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    if (0 == lastTachometerTime || currentTimeMillis - lastTachometerTime >= TACHOMETER_INTERVAL) {
                        lastTachometerTime = currentTimeMillis;
                        com.baidu.tbadk.core.sharedPref.b.oj().putLong(LAST_GETCDNLIST_TIME, currentTimeMillis);
                    } else {
                        return;
                    }
                }
            }
            Intent intent = new Intent(context, TbCDNTachometerService.class);
            intent.putExtra("isNormal", z);
            com.baidu.adp.lib.g.j.f(context, intent);
        }
    }

    private void registerListener() {
        this.customNormalListener.setTag(this.mId);
        MessageManager.getInstance().registerListener(this.customNormalListener);
    }

    private void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.mId);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // com.baidu.adp.base.BdBaseService, android.app.Service
    public void onCreate() {
        super.onCreate();
        registerListener();
        this.cdnTachometerModel = new m(null);
        this.cdnTachometerModel.a(this.tachometerModelCallBack);
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
        if (intent != null) {
            this.isNormal = intent.getBooleanExtra("isNormal", false);
        }
        Message message = new Message();
        message.what = 1002;
        this.handler.sendMessageDelayed(message, TbConfig.USE_TIME_INTERVAL);
        this.startID = i;
        getIPList();
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        unRegisterListener();
        this.cdnTachometerModel.a((o) null);
        this.cdnTachometerModel.destroy();
    }

    public void getIPList() {
        this.cdnTachometerModel.a((o) null);
        this.cdnTachometerModel.a(this.tachometerModelCallBack);
        this.cdnTachometerModel.lE();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startTachometer(g gVar) {
        this.numOfThrowIp = 0;
        if (gVar == null || gVar.BI != 0) {
            broadCastAndStopSelf(null);
        } else if (!gVar.BL) {
            broadCastAndStopSelf(null);
        } else if (gVar.BK.size() == 0) {
            broadCastAndStopSelf(null);
        } else {
            breakUpIpList(gVar.BK);
            String str = gVar.imageUrl;
            String str2 = gVar.BM;
            String str3 = gVar.BJ;
            if (str != null && str2 != null && str3 != null) {
                int size = gVar.BK.size();
                if (size > 0) {
                    f fVar = new f(this, gVar, 0);
                    fVar.cdnTachometerModel = this.cdnTachometerModel;
                    f.a(fVar, this.isNormal);
                    f.a(fVar, "c.hiphotos.baidu.com");
                    CustomMessage customMessage = new CustomMessage(2017000, fVar);
                    customMessage.setTag(this.mId);
                    MessageManager.getInstance().sendMessage(customMessage);
                }
                for (int i = 0; i < size; i++) {
                    ArrayList<String> arrayList = gVar.BK.get(i);
                    String str4 = "";
                    if (arrayList.size() > 0) {
                        str4 = arrayList.get(0);
                    }
                    if (!this.cdnIpMap.containsKey(str4)) {
                        this.cdnIpMap.put(str4, arrayList);
                    }
                    f fVar2 = new f(this, gVar, i);
                    fVar2.cdnTachometerModel = this.cdnTachometerModel;
                    f.a(fVar2, this.isNormal);
                    CustomMessage customMessage2 = new CustomMessage(2017000, fVar2);
                    customMessage2.setTag(this.mId);
                    MessageManager.getInstance().sendMessage(customMessage2);
                }
            }
        }
    }

    private void breakUpIpList(ArrayList<ArrayList<String>> arrayList) {
        int size;
        if (arrayList != null && (size = arrayList.size()) > 1) {
            int i = size / 2;
            Random random = new Random();
            for (int i2 = 0; i2 < i; i2++) {
                int nextInt = random.nextInt(size);
                if (nextInt < size) {
                    arrayList.set(i2, arrayList.get(nextInt));
                    arrayList.set(nextInt, arrayList.get(i2));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void judgeIsBroadcastCdnIp() {
        if (!this.isBroadFirstIp && this.belowOnePointFiveIpList.size() > 0) {
            this.isBroadFirstIp = true;
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(this.belowOnePointFiveIpList.get(0).split("_")[0]);
            broadCast(arrayList);
        }
        if (this.optimalIpList.size() >= 5) {
            BroadcastCdnIp();
        } else if (this.returnRequestNum >= this.cdnIpMap.size()) {
            BroadcastCdnIp();
        } else if (this.lastNotifyIpCount < this.optimalIpList.size() && System.currentTimeMillis() - this.lastNotifyIpTime >= 2000) {
            int i = this.lastNotifyIpCount;
            this.lastNotifyIpCount = this.optimalIpList.size();
            this.lastNotifyIpTime = System.currentTimeMillis();
            if (i != 0) {
                ArrayList<String> arrayList2 = new ArrayList<>();
                int size = this.optimalIpList.size();
                int i2 = size <= 5 ? size : 5;
                for (int i3 = 0; i3 < i2; i3++) {
                    arrayList2.add(this.optimalIpList.get(i3));
                }
                broadCast(arrayList2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BroadcastCdnIp() {
        int i = 0;
        if (this.canBroadCast) {
            ArrayList<String> arrayList = new ArrayList<>();
            if (this.optimalIpList.size() >= 5) {
                int size = this.optimalIpList.size();
                if (size > 5) {
                    size = 5;
                }
                while (i < size) {
                    arrayList.add(this.optimalIpList.get(i));
                    i++;
                }
            } else if (this.belowOnePointFiveIpList.size() > 0) {
                int size2 = this.belowOnePointFiveIpList.size();
                if (size2 > 5) {
                    size2 = 5;
                }
                while (i < size2) {
                    try {
                        arrayList.add(this.belowOnePointFiveIpList.get(i).split("_")[0]);
                    } catch (Exception e) {
                        BdLog.e(e);
                    }
                    i++;
                }
            }
            broadCastAndStopSelf(arrayList);
        }
    }

    private void broadCastAndStopSelf(ArrayList<String> arrayList) {
        MessageManager.getInstance().removeMessage(this.mId);
        this.handler.removeMessages(1002);
        broadCast(arrayList);
        stopSelfResult(this.startID);
    }

    private void broadCast(ArrayList<String> arrayList) {
        Intent intent = new Intent();
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        this.numOfThrowIp++;
        intent.setAction(TB_CDNIP_BROADCASE_ACTION);
        intent.putExtra(TB_CDNIP_BROADCASE_KEY, arrayList);
        intent.putExtra(TB_CDNIP_BROADCASE_NEED_USEIP, !this.isNormal);
        intent.putExtra(TB_CDNIP_BROADCASE_NUM, this.numOfThrowIp);
        intent.putExtra(TB_CDNIP_BROADCASE_ISMOBILE, false);
        sendBroadcast(intent);
    }
}
