package com.baidu.adp.lib.Disk;

import android.os.Environment;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import java.io.File;
/* loaded from: classes.dex */
public class b {
    private final String sZ = Environment.getExternalStorageDirectory().getAbsolutePath();
    private String tb = this.sZ + "/baidu/";
    private String tc;

    public b() {
        this.tc = null;
        try {
            this.tc = BdBaseApplication.getInst().getContext().getFilesDir().getAbsolutePath() + "/";
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void N(String str) {
        if (str != null) {
            this.tb = this.sZ + "/" + str + "/";
        }
    }

    public boolean dR() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    public String b(String str, boolean z, boolean z2) {
        String str2;
        if (z2) {
            if (!dR()) {
                return null;
            }
            if (str != null) {
                str2 = this.tb + str + "/";
            } else {
                str2 = this.tb;
            }
        } else if (this.tc == null) {
            return null;
        } else {
            if (str != null) {
                str2 = this.tc + str + "/";
            } else {
                str2 = this.tc;
            }
        }
        File file = new File(str2);
        if (!file.exists()) {
            if (z && file.mkdirs()) {
                return str2;
            }
            return null;
        }
        return str2;
    }

    public File a(String str, String str2, boolean z, boolean z2) {
        String b;
        if (str2 == null || (b = b(str, z, z2)) == null) {
            return null;
        }
        return new File(b + str2);
    }

    public File c(String str, boolean z, boolean z2) {
        String b = b(str, z, z2);
        if (b == null) {
            return null;
        }
        return new File(b);
    }
}
