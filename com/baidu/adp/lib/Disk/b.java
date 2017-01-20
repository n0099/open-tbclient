package com.baidu.adp.lib.Disk;

import android.os.Environment;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import java.io.File;
/* loaded from: classes.dex */
public class b {
    private final String jS = Environment.getExternalStorageDirectory().getAbsolutePath();
    private String jT = String.valueOf(this.jS) + "/baidu/";
    private String jU;

    public b() {
        this.jU = null;
        try {
            this.jU = String.valueOf(BdBaseApplication.getInst().getContext().getFilesDir().getAbsolutePath()) + "/";
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void E(String str) {
        if (str != null) {
            this.jT = String.valueOf(this.jS) + "/" + str + "/";
        }
    }

    public boolean cy() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    public String b(String str, boolean z, boolean z2) {
        String str2;
        if (z2) {
            if (!cy()) {
                return null;
            }
            if (str != null) {
                str2 = String.valueOf(this.jT) + str + "/";
            } else {
                str2 = this.jT;
            }
        } else if (this.jU == null) {
            return null;
        } else {
            if (str != null) {
                str2 = String.valueOf(this.jU) + str + "/";
            } else {
                str2 = this.jU;
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
        return new File(String.valueOf(b) + str2);
    }

    public File c(String str, boolean z, boolean z2) {
        String b = b(str, z, z2);
        if (b == null) {
            return null;
        }
        return new File(b);
    }
}
