package com.baidu.adp.lib.Disk;

import android.os.Environment;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import java.io.File;
/* loaded from: classes.dex */
public class b {
    private final String wE = Environment.getExternalStorageDirectory().getAbsolutePath();
    private String wF = this.wE + "/baidu/";
    private String wG;
    private String wH;

    public b() {
        this.wG = null;
        this.wH = null;
        try {
            this.wG = BdBaseApplication.getInst().getContext().getFilesDir().getAbsolutePath() + "/";
            this.wH = BdBaseApplication.getInst().getContext().getCacheDir().getAbsolutePath() + "/";
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void Z(String str) {
        if (str != null) {
            this.wF = this.wE + "/" + str + "/";
        }
    }

    public boolean gB() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    public String a(String str, boolean z, boolean z2, boolean z3) {
        String str2;
        if (z2) {
            if (!gB()) {
                return null;
            }
            if (str != null) {
                str2 = this.wF + str + "/";
            } else {
                str2 = this.wF;
            }
        } else if (z3) {
            if (this.wH == null) {
                return null;
            }
            if (str != null) {
                str2 = this.wH + str + "/";
            } else {
                str2 = this.wH;
            }
        } else if (this.wG == null) {
            return null;
        } else {
            if (str != null) {
                str2 = this.wG + str + "/";
            } else {
                str2 = this.wG;
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

    public File b(String str, String str2, boolean z, boolean z2, boolean z3) {
        String a;
        if (str2 == null || (a = a(str, z, z2, z3)) == null) {
            return null;
        }
        return new File(a + str2);
    }

    public File b(String str, boolean z, boolean z2, boolean z3) {
        String a = a(str, z, z2, z3);
        if (a == null) {
            return null;
        }
        return new File(a);
    }
}
