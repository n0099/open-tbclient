package com.baidu.cyberplayer.sdk.task;

import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.Keep;
import com.baidu.cyberplayer.sdk.e;
import com.baidu.cyberplayer.sdk.utils.a;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
@Keep
/* loaded from: classes3.dex */
public class UpgradeTask extends Task {
    public UpgradeTask(String str, HashMap<String, String> hashMap) {
        super(str, hashMap);
    }

    @Override // com.baidu.cyberplayer.sdk.task.Task
    public void run() throws Exception {
        CyberLog.d("UpgradeTask", "task run start:" + this.a);
        ArrayList<String> b = a.b(e.a().a((String) null), this.a, this.b.get("saveDirectory"));
        for (int i = 0; i < b.size(); i++) {
            File file = new File(b.get(i));
            a.C0102a a = a.C0102a.a(file.getName());
            if (a != null) {
                File file2 = new File(file.getParent(), a.a);
                if (file.renameTo(file2)) {
                    CyberLog.d("UpgradeTask", "rename success:" + file2.getAbsolutePath());
                } else {
                    CyberLog.d("UpgradeTask", "rename failed:" + file2.getAbsolutePath());
                }
            }
        }
        CyberLog.d("UpgradeTask", "task run end:" + this.a);
    }
}
