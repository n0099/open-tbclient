package com.baidu.adp.lib.Disk;

import android.os.Environment;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import java.io.File;
/* loaded from: classes.dex */
public class b {
    private final String rs = Environment.getExternalStorageDirectory().getAbsolutePath();
    private String rt = this.rs + "/baidu/";
    private String ru;

    public b() {
        this.ru = null;
        try {
            this.ru = BdBaseApplication.getInst().getContext().getFilesDir().getAbsolutePath() + "/";
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void H(String str) {
        if (str != null) {
            this.rt = this.rs + "/" + str + "/";
        }
    }

    public boolean dG() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    public String b(String str, boolean z, boolean z2) {
        String str2;
        if (z2) {
            if (!dG()) {
                return null;
            }
            if (str != null) {
                str2 = this.rt + str + "/";
            } else {
                str2 = this.rt;
            }
        } else if (this.ru == null) {
            return null;
        } else {
            if (str != null) {
                str2 = this.ru + str + "/";
            } else {
                str2 = this.ru;
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
