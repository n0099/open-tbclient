package com.baidu.adp.lib.Disk;

import android.os.Environment;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import java.io.File;
/* loaded from: classes.dex */
public class b {
    private final String vN = Environment.getExternalStorageDirectory().getAbsolutePath();
    private String vO = this.vN + "/baidu/";
    private String vP;
    private String vQ;

    public b() {
        this.vP = null;
        this.vQ = null;
        try {
            this.vP = BdBaseApplication.getInst().getContext().getFilesDir().getAbsolutePath() + "/";
            this.vQ = BdBaseApplication.getInst().getContext().getCacheDir().getAbsolutePath() + "/";
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void Z(String str) {
        if (str != null) {
            this.vO = this.vN + "/" + str + "/";
        }
    }

    public boolean gd() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    public String a(String str, boolean z, boolean z2, boolean z3) {
        String str2;
        if (z2) {
            if (!gd()) {
                return null;
            }
            if (str != null) {
                str2 = this.vO + str + "/";
            } else {
                str2 = this.vO;
            }
        } else if (z3) {
            if (this.vQ == null) {
                return null;
            }
            if (str != null) {
                str2 = this.vQ + str + "/";
            } else {
                str2 = this.vQ;
            }
        } else if (this.vP == null) {
            return null;
        } else {
            if (str != null) {
                str2 = this.vP + str + "/";
            } else {
                str2 = this.vP;
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

    public File a(String str, String str2, boolean z, boolean z2, boolean z3) {
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
