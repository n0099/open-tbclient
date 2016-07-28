package com.baidu.adp.lib.Disk;

import android.os.Environment;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import java.io.File;
/* loaded from: classes.dex */
public class b {
    private final String hG = Environment.getExternalStorageDirectory().getAbsolutePath();
    private String hH = String.valueOf(this.hG) + "/baidu/";
    private String hI;

    public b() {
        this.hI = null;
        try {
            this.hI = String.valueOf(BdBaseApplication.getInst().getContext().getFilesDir().getAbsolutePath()) + "/";
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void D(String str) {
        if (str != null) {
            this.hH = String.valueOf(this.hG) + "/" + str + "/";
        }
    }

    public boolean bF() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    public String b(String str, boolean z, boolean z2) {
        String str2;
        if (z2) {
            if (!bF()) {
                return null;
            }
            if (str != null) {
                str2 = String.valueOf(this.hH) + str + "/";
            } else {
                str2 = this.hH;
            }
        } else if (this.hI == null) {
            return null;
        } else {
            if (str != null) {
                str2 = String.valueOf(this.hI) + str + "/";
            } else {
                str2 = this.hI;
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
