package com.baidu.searchbox.task.async.appcreate;

import com.baidu.adp.base.BdActivityStack;
import com.baidu.adp.base.BdBaseService;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.appsearchlib.NASLib;
import com.baidu.bdhttpdns.BDHttpDns;
import com.baidu.searchbox.performance.speed.task.LaunchTask;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ColdStartStatsUtil;
import com.baidu.tbadk.core.util.EmotionUtil;
import com.baidu.tbadk.core.util.ICDNProblemUploader;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.httpNet.ICDNIPDirectConnect;
import com.baidu.tbadk.switchs.UseHttpdnsSdkSwitch;
import com.baidu.tieba.cha;
import com.baidu.tieba.dha;
import com.baidu.tieba.ih5;
import com.baidu.tieba.j05;
import com.baidu.tieba.lf;
import com.baidu.tieba.ns5;
import com.baidu.tieba.p0a;
import com.baidu.tieba.rate.RateManager;
import com.baidu.tieba.sa;
import com.baidu.tieba.sv5;
import com.baidu.tieba.vb5;
import com.baidu.tieba.zv5;
/* loaded from: classes4.dex */
public class InitLaunchAsyncTask extends LaunchTask {
    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public String getName() {
        return "InitLaunchAsync";
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public int getProcess() {
        return -1;
    }

    private void initQuickWebViewManager() {
        if (TbadkCoreApplication.getInst().isMainProcess(true)) {
            p0a.n().r();
        }
    }

    private void setServiceOnCreateCallBack() {
        BdBaseService.setServiceOnCreateCallBack(new sa() { // from class: com.baidu.searchbox.task.async.appcreate.InitLaunchAsyncTask.2
            @Override // com.baidu.tieba.sa
            public void onServiceCreate() {
                zv5.e().c(new zv5.b() { // from class: com.baidu.searchbox.task.async.appcreate.InitLaunchAsyncTask.2.1
                    @Override // com.baidu.tieba.zv5.b
                    public void onResult(boolean z) {
                        if (z) {
                            BdBaseService.serviceStartFlag = 2;
                        } else {
                            BdBaseService.serviceStartFlag = 1;
                        }
                    }
                });
            }
        });
    }

    public void intReadThreadHistory() {
        if (TbadkCoreApplication.getInst().isMainProcess(true)) {
            TbadkApplication.getInst().mReadThreadHistory = new dha(300);
            TbadkApplication.getInst().mPhotoLiveReadHistory = new cha(300);
            BdActivityStack.getInst().setOnActivityAllClosed(TbadkApplication.getInst());
        }
    }

    private void initICDN() {
        lf.e = UseHttpdnsSdkSwitch.isOn();
        if (UseHttpdnsSdkSwitch.isOn()) {
            final BDHttpDns service = BDHttpDns.getService(TbadkCoreApplication.getInst().getApplicationContext());
            service.setLogEnable(false);
            try {
                service.setAccountID("119799");
                service.setSecret("87JNTZjGacgUzuMBYvid");
            } catch (Exception e) {
                BdLog.e(e);
            }
            service.setHttpsRequestEnable(true);
            service.setNetworkSwitchPolicy(true, true);
            service.setCachePolicy(BDHttpDns.CachePolicy.POLICY_TOLERANT);
            if (TbadkCoreApplication.getInst().isMainProcess(true)) {
                SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.searchbox.task.async.appcreate.InitLaunchAsyncTask.3
                    @Override // java.lang.Runnable
                    public void run() {
                        service.setPreResolveTag(PrefetchEvent.MODULE);
                    }
                }, 1000L);
            }
        }
        long currentTimeMillis = System.currentTimeMillis();
        ICDNProblemUploader.getInstance();
        ICDNIPDirectConnect.getInstance();
        if (TbadkCoreApplication.getInst().isMainProcess(true) && ICDNIPDirectConnect.getInstance() != null) {
            ICDNIPDirectConnect.getInstance().init();
        }
        ns5.a().m(System.currentTimeMillis() - currentTimeMillis);
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public void execute() {
        setServiceOnCreateCallBack();
        RateManager.getInstance().init();
        ih5.j().m(TbadkCoreApplication.getInst().isMainProcess(false));
        intReadThreadHistory();
        vb5.c();
        j05.t().B();
        sv5.m().s(TbadkCoreApplication.getInst());
        initICDN();
        initQuickWebViewManager();
        if (TbadkCoreApplication.getInst().isMainProcess(false)) {
            TbadkApplication.getInst().updateSignAlarm();
            TbadkApplication.getInst().initLikeForum();
            TbadkApplication.getInst().initSignedForum();
            if (TbSingleton.getInstance().isAuditPackageSwitchOn()) {
                long currentTimeMillis = System.currentTimeMillis();
                NASLib.setCallBack(new NASLib.NASCallBack() { // from class: com.baidu.searchbox.task.async.appcreate.InitLaunchAsyncTask.1
                    @Override // com.baidu.appsearchlib.NASLib.NASCallBack
                    public void callback(String str, String str2) {
                        UrlManager.getInstance().dealOneLink(null, new String[]{str2});
                    }
                });
                ns5.a().p(System.currentTimeMillis() - currentTimeMillis);
            }
        }
        EmotionUtil.statisticsEmotionGroupNums();
        ColdStartStatsUtil.startUBCStats(TbadkCoreApplication.getInst().isMainProcess(false));
        if (TbadkCoreApplication.getInst().isRemoteProcess()) {
            ns5.a().f(System.currentTimeMillis() - TbadkCoreApplication.getInst().processCreateTime);
        }
    }
}
