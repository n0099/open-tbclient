package com.baidu.adp.lib.Disk;

import android.os.Environment;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import java.io.File;
/* loaded from: classes.dex */
public class b {
    private final String rd = Environment.getExternalStorageDirectory().getAbsolutePath();
    private String re = String.valueOf(this.rd) + "/baidu/";
    private String rf;

    public b() {
        this.rf = null;
        try {
            this.rf = String.valueOf(BdBaseApplication.getInst().getContext().getFilesDir().getAbsolutePath()) + "/";
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void O(String str) {
        if (str != null) {
            this.re = String.valueOf(this.rd) + "/" + str + "/";
        }
    }

    public boolean fo() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    public String a(String str, boolean z, boolean z2) {
        String str2;
        if (z2) {
            if (!fo()) {
                return null;
            }
            if (str != null) {
                str2 = String.valueOf(this.re) + str + "/";
            } else {
                str2 = this.re;
            }
        } else if (this.rf == null) {
            return null;
        } else {
            if (str != null) {
                str2 = String.valueOf(this.rf) + str + "/";
            } else {
                str2 = this.rf;
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
