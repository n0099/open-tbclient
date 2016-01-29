package com.baidu.adp.lib.Disk;

import android.os.Environment;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import java.io.File;
/* loaded from: classes.dex */
public class b {
    private final String ri = Environment.getExternalStorageDirectory().getAbsolutePath();
    private String rj = String.valueOf(this.ri) + "/baidu/";
    private String rk;

    public b() {
        this.rk = null;
        try {
            this.rk = String.valueOf(BdBaseApplication.getInst().getContext().getFilesDir().getAbsolutePath()) + "/";
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void K(String str) {
        if (str != null) {
            this.rj = String.valueOf(this.ri) + "/" + str + "/";
        }
    }

    public boolean fq() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    public String b(String str, boolean z, boolean z2) {
        String str2;
        if (z2) {
            if (!fq()) {
                return null;
            }
            if (str != null) {
                str2 = String.valueOf(this.rj) + str + "/";
            } else {
                str2 = this.rj;
            }
        } else if (this.rk == null) {
            return null;
        } else {
            if (str != null) {
                str2 = String.valueOf(this.rk) + str + "/";
            } else {
                str2 = this.rk;
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
