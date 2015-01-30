package com.baidu.adp.lib.Disk;

import android.os.Environment;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import java.io.File;
/* loaded from: classes.dex */
public class b {
    private final String fF = Environment.getExternalStorageDirectory().getAbsolutePath();
    private String fG = String.valueOf(this.fF) + "/baidu/";
    private String fH;

    public b() {
        this.fH = null;
        try {
            this.fH = String.valueOf(BdBaseApplication.getInst().getContext().getFilesDir().getAbsolutePath()) + "/";
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void E(String str) {
        if (str != null) {
            this.fG = String.valueOf(this.fF) + "/" + str + "/";
        }
    }

    public boolean bL() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    public String a(String str, boolean z, boolean z2) {
        String str2;
        if (z2) {
            if (!bL()) {
                return null;
            }
            if (str != null) {
                str2 = String.valueOf(this.fG) + str + "/";
            } else {
                str2 = this.fG;
            }
        } else if (this.fH == null) {
            return null;
        } else {
            if (str != null) {
                str2 = String.valueOf(this.fH) + str + "/";
            } else {
                str2 = this.fH;
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
