package com.baidu.cyberplayer.sdk.task;

import com.baidu.cyberplayer.sdk.CyberGlobalSetting;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.Keep;
import com.baidu.cyberplayer.sdk.utils.CyberFileUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
@Keep
/* loaded from: classes3.dex */
public class UpgradeTask extends Task {
    public static final String TAG = "UpgradeTask";

    public UpgradeTask(String str, HashMap<String, String> hashMap) {
        super(str, hashMap);
    }

    @Override // com.baidu.cyberplayer.sdk.task.Task
    public void run() throws Exception {
        CyberLog.d(TAG, "task run start:" + this.mName);
        ArrayList<String> downloadAndUnzip = CyberFileUtils.downloadAndUnzip(CyberGlobalSetting.getInstance().getLibsDownloadServerUrl(null), this.mName, this.mParams.get("saveDirectory"));
        for (int i = 0; i < downloadAndUnzip.size(); i++) {
            File file = new File(downloadAndUnzip.get(i));
            CyberFileUtils.CyberFileNameInfo parser = CyberFileUtils.CyberFileNameInfo.parser(file.getName());
            if (parser != null) {
                File file2 = new File(file.getParent(), parser.mShortName);
                if (file.renameTo(file2)) {
                    CyberLog.d(TAG, "rename success:" + file2.getAbsolutePath());
                } else {
                    CyberLog.d(TAG, "rename failed:" + file2.getAbsolutePath());
                }
            }
        }
        CyberLog.d(TAG, "task run end:" + this.mName);
    }
}
