package com.baidu.adp.lib.Disk;

import android.os.Environment;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import java.io.File;
/* loaded from: classes.dex */
public class b {
    private final String wC = Environment.getExternalStorageDirectory().getAbsolutePath();
    private String wD = this.wC + "/baidu/";
    private String wE;
    private String wF;

    public b() {
        this.wE = null;
        this.wF = null;
        try {
            this.wE = BdBaseApplication.getInst().getContext().getFilesDir().getAbsolutePath() + "/";
            this.wF = BdBaseApplication.getInst().getContext().getCacheDir().getAbsolutePath() + "/";
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void Z(String str) {
        if (str != null) {
            this.wD = this.wC + "/" + str + "/";
        }
    }

    public boolean gs() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    public String a(String str, boolean z, boolean z2, boolean z3) {
        String str2;
        if (z2) {
            if (!gs()) {
                return null;
            }
            if (str != null) {
                str2 = this.wD + str + "/";
            } else {
                str2 = this.wD;
            }
        } else if (z3) {
            if (this.wF == null) {
                return null;
            }
            if (str != null) {
                str2 = this.wF + str + "/";
            } else {
                str2 = this.wF;
            }
        } else if (this.wE == null) {
            return null;
        } else {
            if (str != null) {
                str2 = this.wE + str + "/";
            } else {
                str2 = this.wE;
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
