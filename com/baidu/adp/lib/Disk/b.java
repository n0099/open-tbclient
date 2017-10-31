package com.baidu.adp.lib.Disk;

import android.os.Environment;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import java.io.File;
/* loaded from: classes.dex */
public class b {
    private final String qQ = Environment.getExternalStorageDirectory().getAbsolutePath();
    private String qR = this.qQ + "/baidu/";
    private String qS;

    public b() {
        this.qS = null;
        try {
            this.qS = BdBaseApplication.getInst().getContext().getFilesDir().getAbsolutePath() + "/";
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void H(String str) {
        if (str != null) {
            this.qR = this.qQ + "/" + str + "/";
        }
    }

    public boolean dG() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    public String a(String str, boolean z, boolean z2) {
        String str2;
        if (z2) {
            if (!dG()) {
                return null;
            }
            if (str != null) {
                str2 = this.qR + str + "/";
            } else {
                str2 = this.qR;
            }
        } else if (this.qS == null) {
            return null;
        } else {
            if (str != null) {
                str2 = this.qS + str + "/";
            } else {
                str2 = this.qS;
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
        return new File(a + str2);
    }

    public File b(String str, boolean z, boolean z2) {
        String a = a(str, z, z2);
        if (a == null) {
            return null;
        }
        return new File(a);
    }
}
