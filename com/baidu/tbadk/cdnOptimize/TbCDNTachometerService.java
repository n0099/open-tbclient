package com.baidu.tbadk.cdnOptimize;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbadkApplication;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
/* loaded from: classes.dex */
public class TbCDNTachometerService extends Service {
    private static final String LAST_GETCDNLIST_TIME = "com.baidu.tbadk.opTimize.lastGetCdnListTiem";
    private static final long TACHOMETER_INTERVAL = 300000;
    public static final String TB_CDNIP_BROADCASE_ACTION = "com.baidu.tbadk.opTimize.tbCdnIpBroadCastAction";
    public static final String TB_CDNIP_BROADCASE_KEY = "com.baidu.tbadk.opTimize.cdnIpBroadCast";
    public static final String TB_CDNIP_BROADCASE_NEED_USEIP_STRING = "com.baidu.tbadk.opTimize.cdnipBroadCastNeedUseIp";
    private static Object lock = new Object();
    private static long lastTachometerTime = 0;
    private static CustomMessageTask customNormalTask = new CustomMessageTask(2016000, new a());
    private final long TACHOMETER_MAXTIME = 10000;
    private final int TIMER_MSG_KEY = 1002;
    private final int TIMER_MSG_CDNDOMIN_KEY = 1003;
    private g cdnTachometerModel = null;
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
    private CustomMessageListener customNormalListener = new b(this, 2016000);
    @SuppressLint({"HandlerLeak"})
    private final Handler handler = new c(this, Looper.getMainLooper());
    private final i tachometerModelCallBack = new d(this);

    static {
        customNormalTask.a(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        customNormalTask.a(new BdAsyncTaskParallel(BdUniqueId.gen(), 10));
        MessageManager.getInstance().registerTask(customNormalTask);
    }

    public static void startTachometerService(Context context, boolean z, boolean z2) {
        if (context != null && com.baidu.adp.lib.network.willdelete.h.a() && TbadkApplication.m252getInst().isMainProcess(true)) {
            if (!z2) {
                synchronized (lock) {
                    if (0 == lastTachometerTime) {
                        lastTachometerTime = com.baidu.tbadk.core.sharedPref.b.a().a(LAST_GETCDNLIST_TIME, 0L);
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    if (0 == lastTachometerTime || currentTimeMillis - lastTachometerTime >= TACHOMETER_INTERVAL) {
                        lastTachometerTime = currentTimeMillis;
                        com.baidu.tbadk.core.sharedPref.b.a().b(LAST_GETCDNLIST_TIME, currentTimeMillis);
                    } else {
                        return;
                    }
                }
            }
            Intent intent = new Intent(context, TbCDNTachometerService.class);
            intent.putExtra("isNormal", z);
            com.baidu.adp.lib.e.d.a(context, intent);
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

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        registerListener();
        this.cdnTachometerModel = new g();
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
        this.handler.sendMessageDelayed(message, 10000L);
        this.startID = i;
        getIPList();
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        unRegisterListener();
        this.cdnTachometerModel.a((i) null);
    }

    public void getIPList() {
        this.cdnTachometerModel.a((i) null);
        this.cdnTachometerModel.a(this.tachometerModelCallBack);
        this.cdnTachometerModel.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startTachometer(f fVar) {
        if (fVar == null || fVar.a != 0) {
            broadCastAndStopSelf(null);
        } else if (!fVar.f) {
            broadCastAndStopSelf(null);
        } else if (fVar.e.size() == 0) {
            broadCastAndStopSelf(null);
        } else {
            breakUpIpList(fVar.e);
            String str = fVar.c;
            String str2 = fVar.g;
            String str3 = fVar.d;
            if (str != null || str2 != null || str3 != null) {
                int size = fVar.e.size();
                if (size > 0) {
                    e eVar = new e(this, fVar, 0);
                    eVar.f = this.cdnTachometerModel;
                    e.a(eVar, this.isNormal);
                    e.a(eVar, "c.hiphotos.baidu.com");
                    CustomMessage customMessage = new CustomMessage(2016000, eVar);
                    customMessage.setTag(this.mId);
                    MessageManager.getInstance().sendMessage(customMessage);
                    Message message = new Message();
                    message.what = 1003;
                    this.handler.sendMessageDelayed(message, 10000L);
                }
                for (int i = 0; i < size; i++) {
                    ArrayList<String> arrayList = fVar.e.get(i);
                    String str4 = "";
                    if (arrayList.size() > 0) {
                        str4 = arrayList.get(0);
                    }
                    if (!this.cdnIpMap.containsKey(str4)) {
                        this.cdnIpMap.put(str4, arrayList);
                    }
                    e eVar2 = new e(this, fVar, i);
                    eVar2.f = this.cdnTachometerModel;
                    e.a(eVar2, this.isNormal);
                    CustomMessage customMessage2 = new CustomMessage(2016000, eVar2);
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
        if (this.optimalIpList.size() >= 5) {
            BroadcastCdnIp();
        } else if (this.returnRequestNum >= this.cdnIpMap.size()) {
            BroadcastCdnIp();
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
        Intent intent = new Intent();
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        intent.setAction(TB_CDNIP_BROADCASE_ACTION);
        intent.putExtra(TB_CDNIP_BROADCASE_KEY, arrayList);
        intent.putExtra(TB_CDNIP_BROADCASE_NEED_USEIP_STRING, !this.isNormal);
        MessageManager.getInstance().removeMessage(this.mId);
        sendBroadcast(intent);
        stopSelfResult(this.startID);
    }
}
