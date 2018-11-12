package com.baidu.adp.lib.Disk;

import android.os.Environment;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import java.io.File;
/* loaded from: classes.dex */
public class b {
    private final String EXTERNAL_STORAGE_DIRECTORY = Environment.getExternalStorageDirectory().getAbsolutePath();
    private String yV = this.EXTERNAL_STORAGE_DIRECTORY + "/baidu/";
    private String yW;
    private String yX;

    public b() {
        this.yW = null;
        this.yX = null;
        try {
            this.yW = BdBaseApplication.getInst().getContext().getFilesDir().getAbsolutePath() + "/";
            this.yX = BdBaseApplication.getInst().getContext().getCacheDir().getAbsolutePath() + "/";
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void aq(String str) {
        if (str != null) {
            this.yV = this.EXTERNAL_STORAGE_DIRECTORY + "/" + str + "/";
        }
    }

    public boolean hA() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    public String a(String str, boolean z, boolean z2, boolean z3) {
        String str2;
        if (z2) {
            if (!hA()) {
                return null;
            }
            if (str != null) {
                str2 = this.yV + str + "/";
            } else {
                str2 = this.yV;
            }
        } else if (z3) {
            if (this.yX == null) {
                return null;
            }
            if (str != null) {
                str2 = this.yX + str + "/";
            } else {
                str2 = this.yX;
            }
        } else if (this.yW == null) {
            return null;
        } else {
            if (str != null) {
                str2 = this.yW + str + "/";
            } else {
                str2 = this.yW;
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
