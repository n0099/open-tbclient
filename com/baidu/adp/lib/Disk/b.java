package com.baidu.adp.lib.Disk;

import android.os.Environment;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import java.io.File;
/* loaded from: classes.dex */
public class b {
    private final String qN = Environment.getExternalStorageDirectory().getAbsolutePath();
    private String qO = this.qN + "/baidu/";
    private String qP;

    public b() {
        this.qP = null;
        try {
            this.qP = BdBaseApplication.getInst().getContext().getFilesDir().getAbsolutePath() + "/";
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void H(String str) {
        if (str != null) {
            this.qO = this.qN + "/" + str + "/";
        }
    }

    public boolean dH() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    public String a(String str, boolean z, boolean z2) {
        String str2;
        if (z2) {
            if (!dH()) {
                return null;
            }
            if (str != null) {
                str2 = this.qO + str + "/";
            } else {
                str2 = this.qO;
            }
        } else if (this.qP == null) {
            return null;
        } else {
            if (str != null) {
                str2 = this.qP + str + "/";
            } else {
                str2 = this.qP;
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
