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
import com.baidu.tieba.bb5;
import com.baidu.tieba.c65;
import com.baidu.tieba.cd9;
import com.baidu.tieba.d09;
import com.baidu.tieba.dd9;
import com.baidu.tieba.fl5;
import com.baidu.tieba.hf;
import com.baidu.tieba.i09;
import com.baidu.tieba.jg;
import com.baidu.tieba.lo5;
import com.baidu.tieba.na;
import com.baidu.tieba.rv4;
import com.baidu.tieba.so5;
import com.baidu.tieba.w8;
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
            d09.n().r();
        }
    }

    private void setServiceOnCreateCallBack() {
        BdBaseService.setServiceOnCreateCallBack(new na() { // from class: com.baidu.searchbox.task.async.appcreate.InitLaunchAsyncTask.2
            @Override // com.baidu.tieba.na
            public void onServiceCreate() {
                so5.e().c(new so5.b() { // from class: com.baidu.searchbox.task.async.appcreate.InitLaunchAsyncTask.2.1
                    @Override // com.baidu.tieba.so5.b
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
            TbadkApplication.getInst().mReadThreadHistory = new dd9(300);
            TbadkApplication.getInst().mPhotoLiveReadHistory = new cd9(300);
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
        fl5.b().n(System.currentTimeMillis() - currentTimeMillis);
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public void execute() {
        setServiceOnCreateCallBack();
        i09.g().j();
        bb5.j().m(TbadkCoreApplication.getInst().isMainProcess(false));
        intReadThreadHistory();
        c65.c();
        rv4.t().B();
        lo5.m().s(TbadkCoreApplication.getInst());
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
                fl5.b().q(System.currentTimeMillis() - currentTimeMillis);
            }
        }
        EmotionUtil.statisticsEmotionGroupNums();
        ColdStartStatsUtil.startUBCStats(TbadkCoreApplication.getInst().isMainProcess(false));
        if (TbadkCoreApplication.getInst().isRemoteProcess()) {
            fl5.b().g(System.currentTimeMillis() - TbadkCoreApplication.getInst().processCreateTime);
        }
    }
}
