package com.baidu.tbadk;

import com.baidu.adp.lib.b.f;
import com.baidu.adp.lib.g.k;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.u;
import com.baidu.android.procmo.ProcessMonitor;
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
        if (!this.isStarted && TbadkApplication.m251getInst().isMainProcess(true)) {
            this.isStarted = true;
            k.el().b(new Runnable() { // from class: com.baidu.tbadk.UninstallInquirer.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        TbadkApplication m251getInst = TbadkApplication.m251getInst();
                        new ProcessMonitor(TbadkApplication.m251getInst(), u.aE(m251getInst.getPackageName()), UninstallInquirer.UNINSTALL_FEED_BACK_URL + m251getInst.getVersionName(), "", 0).start();
                    } catch (Throwable th) {
                        BdLog.e(th);
                    }
                }
            });
        }
    }

    private boolean isUnistallFeedBackOpen() {
        return f.db().U("uninstall_feed_back_switch") == 0;
    }
}
