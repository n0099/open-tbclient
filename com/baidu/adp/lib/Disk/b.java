package com.baidu.adp.lib.Disk;

import android.os.Environment;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import java.io.File;
/* loaded from: classes.dex */
public class b {
    private final String rt = Environment.getExternalStorageDirectory().getAbsolutePath();
    private String ru = String.valueOf(this.rt) + "/baidu/";
    private String rv;

    public b() {
        this.rv = null;
        try {
            this.rv = String.valueOf(BdBaseApplication.getInst().getContext().getFilesDir().getAbsolutePath()) + "/";
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void A(String str) {
        if (str != null) {
            this.ru = String.valueOf(this.rt) + "/" + str + "/";
        }
    }

    public boolean dH() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    public String b(String str, boolean z, boolean z2) {
        String str2;
        if (z2) {
            if (!dH()) {
                return null;
            }
            if (str != null) {
                str2 = String.valueOf(this.ru) + str + "/";
            } else {
                str2 = this.ru;
            }
        } else if (this.rv == null) {
            return null;
        } else {
            if (str != null) {
                str2 = String.valueOf(this.rv) + str + "/";
            } else {
                str2 = this.rv;
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
