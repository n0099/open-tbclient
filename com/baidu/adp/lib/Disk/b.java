package com.baidu.adp.lib.Disk;

import android.os.Environment;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import java.io.File;
/* loaded from: classes.dex */
public class b {
    private final String jZ = Environment.getExternalStorageDirectory().getAbsolutePath();
    private String kb = String.valueOf(this.jZ) + "/baidu/";
    private String kc;

    public b() {
        this.kc = null;
        try {
            this.kc = String.valueOf(BdBaseApplication.getInst().getContext().getFilesDir().getAbsolutePath()) + "/";
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void E(String str) {
        if (str != null) {
            this.kb = String.valueOf(this.jZ) + "/" + str + "/";
        }
    }

    public boolean cA() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    public String b(String str, boolean z, boolean z2) {
        String str2;
        if (z2) {
            if (!cA()) {
                return null;
            }
            if (str != null) {
                str2 = String.valueOf(this.kb) + str + "/";
            } else {
                str2 = this.kb;
            }
        } else if (this.kc == null) {
            return null;
        } else {
            if (str != null) {
                str2 = String.valueOf(this.kc) + str + "/";
            } else {
                str2 = this.kc;
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
