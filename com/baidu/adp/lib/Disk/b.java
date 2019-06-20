package com.baidu.adp.lib.Disk;

import android.os.Environment;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import java.io.File;
/* loaded from: classes.dex */
public class b {
    private final String wB = Environment.getExternalStorageDirectory().getAbsolutePath();
    private String wC = this.wB + "/baidu/";
    private String wD;
    private String wE;

    public b() {
        this.wD = null;
        this.wE = null;
        try {
            this.wD = BdBaseApplication.getInst().getContext().getFilesDir().getAbsolutePath() + "/";
            this.wE = BdBaseApplication.getInst().getContext().getCacheDir().getAbsolutePath() + "/";
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void Z(String str) {
        if (str != null) {
            this.wC = this.wB + "/" + str + "/";
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
                str2 = this.wC + str + "/";
            } else {
                str2 = this.wC;
            }
        } else if (z3) {
            if (this.wE == null) {
                return null;
            }
            if (str != null) {
                str2 = this.wE + str + "/";
            } else {
                str2 = this.wE;
            }
        } else if (this.wD == null) {
            return null;
        } else {
            if (str != null) {
                str2 = this.wD + str + "/";
            } else {
                str2 = this.wD;
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
