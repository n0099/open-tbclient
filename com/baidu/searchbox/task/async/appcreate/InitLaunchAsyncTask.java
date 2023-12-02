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
import com.baidu.tieba.ab;
import com.baidu.tieba.et5;
import com.baidu.tieba.i6;
import com.baidu.tieba.ib;
import com.baidu.tieba.lt5;
import com.baidu.tieba.qd5;
import com.baidu.tieba.qxa;
import com.baidu.tieba.rate.RateManager;
import com.baidu.tieba.rxa;
import com.baidu.tieba.sv4;
import com.baidu.tieba.tga;
import com.baidu.tieba.vp5;
import com.baidu.tieba.w75;
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
            tga.n().r();
        }
    }

    private void setServiceOnCreateCallBack() {
        BdBaseService.setServiceOnCreateCallBack(new i6() { // from class: com.baidu.searchbox.task.async.appcreate.InitLaunchAsyncTask.2
            @Override // com.baidu.tieba.i6
            public void onServiceCreate() {
                lt5.e().c(new lt5.b() { // from class: com.baidu.searchbox.task.async.appcreate.InitLaunchAsyncTask.2.1
                    @Override // com.baidu.tieba.lt5.b
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
            TbadkApplication.getInst().mReadThreadHistory = new rxa(300);
            TbadkApplication.getInst().mPhotoLiveReadHistory = new qxa(300);
            BdActivityStack.getInst().setOnActivityAllClosed(TbadkApplication.getInst());
        }
    }

    private void initICDN() {
        ab.e = UseHttpdnsSdkSwitch.isOn();
        if (UseHttpdnsSdkSwitch.isOn()) {
            final BDHttpDns service = BDHttpDns.getService(TbadkCoreApplication.getInst().getApplicationContext());
            service.setLogEnable(false);
            try {
                service.setAccountID(ib.a);
                service.setSecret(ib.b);
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
        vp5.a().m(System.currentTimeMillis() - currentTimeMillis);
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public void execute() {
        setServiceOnCreateCallBack();
        RateManager.getInstance().init();
        qd5.j().m(TbadkCoreApplication.getInst().isMainProcess(false));
        intReadThreadHistory();
        w75.c();
        sv4.t().B();
        et5.m().s(TbadkCoreApplication.getInst());
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
                vp5.a().p(System.currentTimeMillis() - currentTimeMillis);
            }
        }
        EmotionUtil.statisticsEmotionGroupNums();
        ColdStartStatsUtil.startUBCStats(TbadkCoreApplication.getInst().isMainProcess(false));
        if (TbadkCoreApplication.getInst().isRemoteProcess()) {
            vp5.a().f(System.currentTimeMillis() - TbadkCoreApplication.getInst().processCreateTime);
        }
    }
}
