package com.baidu.adp.lib.Disk;

import android.os.Environment;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import java.io.File;
/* loaded from: classes.dex */
public class b {
    private final String fD = Environment.getExternalStorageDirectory().getAbsolutePath();
    private String fE = String.valueOf(this.fD) + "/baidu/";
    private String fF;

    public b() {
        this.fF = null;
        try {
            this.fF = String.valueOf(BdBaseApplication.getInst().getContext().getFilesDir().getAbsolutePath()) + "/";
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void E(String str) {
        if (str != null) {
            this.fE = String.valueOf(this.fD) + "/" + str + "/";
        }
    }

    public boolean bN() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    public String a(String str, boolean z, boolean z2) {
        String str2;
        if (z2) {
            if (!bN()) {
                return null;
            }
            if (str != null) {
                str2 = String.valueOf(this.fE) + str + "/";
            } else {
                str2 = this.fE;
            }
        } else if (this.fF == null) {
            return null;
        } else {
            if (str != null) {
                str2 = String.valueOf(this.fF) + str + "/";
            } else {
                str2 = this.fF;
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
        String a;
        if (str2 == null || (a = a(str, z, z2)) == null) {
            return null;
        }
        return new File(String.valueOf(a) + str2);
    }

    public File b(String str, boolean z, boolean z2) {
        String a = a(str, z, z2);
        if (a == null) {
            return null;
        }
        return new File(a);
    }
}
