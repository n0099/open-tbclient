package com.baidu.adp.lib.Disk;

import android.os.Environment;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import java.io.File;
/* loaded from: classes.dex */
public class b {
    private String dA;
    private final String dy = Environment.getExternalStorageDirectory().getAbsolutePath();
    private String dz = String.valueOf(this.dy) + "/baidu/";

    public b() {
        this.dA = null;
        try {
            this.dA = String.valueOf(BdBaseApplication.getInst().getFilesDir().getAbsolutePath()) + "/";
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void p(String str) {
        if (str != null) {
            this.dz = String.valueOf(this.dy) + "/" + str + "/";
        }
    }

    public boolean bm() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    public String a(String str, boolean z, boolean z2) {
        String str2;
        if (z2) {
            if (!bm()) {
                return null;
            }
            if (str != null) {
                str2 = String.valueOf(this.dz) + str + "/";
            } else {
                str2 = this.dz;
            }
        } else if (this.dA == null) {
            return null;
        } else {
            if (str != null) {
                str2 = String.valueOf(this.dA) + str + "/";
            } else {
                str2 = this.dA;
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
