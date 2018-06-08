package com.baidu.adp.lib.Disk;

import android.os.Environment;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import java.io.File;
/* loaded from: classes.dex */
public class b {
    private final String EXTERNAL_STORAGE_DIRECTORY = Environment.getExternalStorageDirectory().getAbsolutePath();
    private String vW = this.EXTERNAL_STORAGE_DIRECTORY + "/baidu/";
    private String vX;
    private String vY;

    public b() {
        this.vX = null;
        this.vY = null;
        try {
            this.vX = BdBaseApplication.getInst().getContext().getFilesDir().getAbsolutePath() + "/";
            this.vY = BdBaseApplication.getInst().getContext().getCacheDir().getAbsolutePath() + "/";
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void Y(String str) {
        if (str != null) {
            this.vW = this.EXTERNAL_STORAGE_DIRECTORY + "/" + str + "/";
        }
    }

    public boolean ge() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    public String a(String str, boolean z, boolean z2, boolean z3) {
        String str2;
        if (z2) {
            if (!ge()) {
                return null;
            }
            if (str != null) {
                str2 = this.vW + str + "/";
            } else {
                str2 = this.vW;
            }
        } else if (z3) {
            if (this.vY == null) {
                return null;
            }
            if (str != null) {
                str2 = this.vY + str + "/";
            } else {
                str2 = this.vY;
            }
        } else if (this.vX == null) {
            return null;
        } else {
            if (str != null) {
                str2 = this.vX + str + "/";
            } else {
                str2 = this.vX;
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
