package com.baidu.tbadk;

import com.baidu.adp.lib.b.f;
import com.baidu.adp.lib.g.l;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.z;
import com.baidu.android.procmo.ProcessMonitor;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class UninstallInquirer {
    private static final String UNINSTALL_FEED_BACK_URL = "http://tieba.baidu.com/mo/q/uninstallfeedback?v=";
    private static UninstallInquirer _instance;
    private boolean isStarted = false;

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
        }
    }

    private void startProcessInternal() {
        if (!this.isStarted && TbadkCoreApplication.m255getInst().isMainProcess(true)) {
            this.isStarted = true;
            l.em().c(new Runnable() { // from class: com.baidu.tbadk.UninstallInquirer.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        TbadkCoreApplication m255getInst = TbadkCoreApplication.m255getInst();
                        new ProcessMonitor(TbadkCoreApplication.m255getInst().getContext(), z.toMd5(m255getInst.getContext().getPackageName()), UninstallInquirer.UNINSTALL_FEED_BACK_URL + m255getInst.getVersionName(), "", 0).start();
                    } catch (Throwable th) {
                        BdLog.e(th);
                    }
                }
            });
        }
    }

    private boolean isUnistallFeedBackOpen() {
        return f.dc().Z("uninstall_feed_back_switch") == 0;
    }
}
