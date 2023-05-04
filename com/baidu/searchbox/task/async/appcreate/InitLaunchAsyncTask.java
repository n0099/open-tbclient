package com.baidu.searchbox.task.async.appcreate;

import com.baidu.adp.base.BdBaseService;
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
import com.baidu.tieba.cd9;
import com.baidu.tieba.fn5;
import com.baidu.tieba.hf;
import com.baidu.tieba.jg;
import com.baidu.tieba.kw4;
import com.baidu.tieba.lq5;
import com.baidu.tieba.na;
import com.baidu.tieba.qq9;
import com.baidu.tieba.rq9;
import com.baidu.tieba.sq5;
import com.baidu.tieba.w75;
import com.baidu.tieba.w8;
import com.baidu.tieba.xc9;
import com.baidu.tieba.zc5;
/* loaded from: classes2.dex */
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
            xc9.n().r();
        }
    }

    private void setServiceOnCreateCallBack() {
        BdBaseService.setServiceOnCreateCallBack(new na() { // from class: com.baidu.searchbox.task.async.appcreate.InitLaunchAsyncTask.2
            @Override // com.baidu.tieba.na
            public void onServiceCreate() {
                sq5.e().c(new sq5.b() { // from class: com.baidu.searchbox.task.async.appcreate.InitLaunchAsyncTask.2.1
                    @Override // com.baidu.tieba.sq5.b
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
            TbadkApplication.getInst().mReadThreadHistory = new rq9(300);
            TbadkApplication.getInst().mPhotoLiveReadHistory = new qq9(300);
            w8.f().s(TbadkApplication.getInst());
        }
    }

    private void initICDN() {
        hf.e = UseHttpdnsSdkSwitch.isOn();
        if (UseHttpdnsSdkSwitch.isOn()) {
            final BDHttpDns h = BDHttpDns.h(TbadkCoreApplication.getInst().getApplicationContext());
            h.m(false);
            try {
                h.j("119799");
                h.p("87JNTZjGacgUzuMBYvid");
            } catch (Exception e) {
                BdLog.e(e);
            }
            h.l(true);
            h.n(true, true);
            h.k(BDHttpDns.CachePolicy.POLICY_TOLERANT);
            if (TbadkCoreApplication.getInst().isMainProcess(true)) {
                jg.a().postDelayed(new Runnable() { // from class: com.baidu.searchbox.task.async.appcreate.InitLaunchAsyncTask.3
                    @Override // java.lang.Runnable
                    public void run() {
                        h.o(PrefetchEvent.MODULE);
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
        fn5.b().n(System.currentTimeMillis() - currentTimeMillis);
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public void execute() {
        setServiceOnCreateCallBack();
        cd9.g().j();
        zc5.j().m(TbadkCoreApplication.getInst().isMainProcess(false));
        intReadThreadHistory();
        w75.c();
        kw4.t().B();
        lq5.m().s(TbadkCoreApplication.getInst());
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
                fn5.b().q(System.currentTimeMillis() - currentTimeMillis);
            }
        }
        EmotionUtil.statisticsEmotionGroupNums();
        ColdStartStatsUtil.startUBCStats(TbadkCoreApplication.getInst().isMainProcess(false));
        if (TbadkCoreApplication.getInst().isRemoteProcess()) {
            fn5.b().g(System.currentTimeMillis() - TbadkCoreApplication.getInst().processCreateTime);
        }
    }
}
