package com.baidu.tbadk.clearResource;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import java.io.File;
/* loaded from: classes.dex */
public class ClearResourceStatic {
    private static long Nj = 86400000;

    static {
        MessageManager.getInstance().registerListener(new a(CmdConfigCustom.METHOD_ACCOUNT_CHANGE));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void l(File file) {
        if (file != null) {
            try {
                if (file.isDirectory()) {
                    File[] listFiles = file.listFiles();
                    if (listFiles != null) {
                        for (int i = 0; i < listFiles.length; i++) {
                            if (listFiles[i].isDirectory()) {
                                l(listFiles[i]);
                            } else {
                                listFiles[i].delete();
                            }
                        }
                        return;
                    }
                    return;
                }
                file.delete();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
