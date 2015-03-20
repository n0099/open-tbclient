package com.baidu.tbadk;

import com.baidu.adp.lib.b.f;
import com.baidu.adp.lib.g.l;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.ab;
import com.baidu.android.procmo.ProcessMonitor;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class UninstallInquirer {
    private static final String UNINSTALL_FEED_BACK_URL = "http://tieba.baidu.com/mo/q/uninstallfeedback?v=";
    private static UninstallInquirer _instance;
    private boolean isStarted = false;
    private ProcessMonitor monitor;

    private UninstallInquirer() {
    }

    public static UninstallInquirer getInstance() {
        synchronized (UninstallInquirer.class) {
            if (_instance == null) {
                _instance = new UninstallInquirer();
            }
        }
        return _instance;
    }

    public void startProcessBySwitch() {
        if (isUnistallFeedBackOpen()) {
            startProcessInternal();
        }
    }

    public void startProcessBySync(boolean z) {
        if (z) {
            startProcessInternal();
            return;
        }
        this.isStarted = false;
        if (this.monitor != null) {
            this.monitor.stopSelf();
        }
    }

    private void startProcessInternal() {
        if (!this.isStarted && TbadkCoreApplication.m411getInst().isMainProcess(true)) {
            this.isStarted = true;
            l.hJ().c(new Runnable() { // from class: com.baidu.tbadk.UninstallInquirer.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        TbadkCoreApplication m411getInst = TbadkCoreApplication.m411getInst();
                        UninstallInquirer.this.monitor = new ProcessMonitor(TbadkCoreApplication.m411getInst().getContext(), ab.toMd5(m411getInst.getContext().getPackageName()), UninstallInquirer.UNINSTALL_FEED_BACK_URL + m411getInst.getVersionName(), "", 0);
                        UninstallInquirer.this.monitor.start();
                    } catch (Throwable th) {
                        BdLog.e(th);
                    }
                }
            });
        }
    }

    private boolean isUnistallFeedBackOpen() {
        return f.gz().ag("uninstall_feed_back_switch") == 0;
    }
}
