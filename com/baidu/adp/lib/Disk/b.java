package com.baidu.adp.lib.Disk;

import android.os.Environment;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import java.io.File;
/* loaded from: classes.dex */
public class b {
    private final String yS = Environment.getExternalStorageDirectory().getAbsolutePath();
    private String yT = this.yS + "/baidu/";
    private String yU;
    private String yV;

    public b() {
        this.yU = null;
        this.yV = null;
        try {
            this.yU = BdBaseApplication.getInst().getContext().getFilesDir().getAbsolutePath() + "/";
            this.yV = BdBaseApplication.getInst().getContext().getCacheDir().getAbsolutePath() + "/";
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void aq(String str) {
        if (str != null) {
            this.yT = this.yS + "/" + str + "/";
        }
    }

    public boolean hy() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    public String a(String str, boolean z, boolean z2, boolean z3) {
        String str2;
        if (z2) {
            if (!hy()) {
                return null;
            }
            if (str != null) {
                str2 = this.yT + str + "/";
            } else {
                str2 = this.yT;
            }
        } else if (z3) {
            if (this.yV == null) {
                return null;
            }
            if (str != null) {
                str2 = this.yV + str + "/";
            } else {
                str2 = this.yV;
            }
        } else if (this.yU == null) {
            return null;
        } else {
            if (str != null) {
                str2 = this.yU + str + "/";
            } else {
                str2 = this.yU;
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
