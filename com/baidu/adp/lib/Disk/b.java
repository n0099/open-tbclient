package com.baidu.adp.lib.Disk;

import android.os.Environment;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import java.io.File;
/* loaded from: classes.dex */
public class b {
    private final String yR = Environment.getExternalStorageDirectory().getAbsolutePath();
    private String yS = this.yR + "/baidu/";
    private String yT;
    private String yU;

    public b() {
        this.yT = null;
        this.yU = null;
        try {
            this.yT = BdBaseApplication.getInst().getContext().getFilesDir().getAbsolutePath() + "/";
            this.yU = BdBaseApplication.getInst().getContext().getCacheDir().getAbsolutePath() + "/";
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void aq(String str) {
        if (str != null) {
            this.yS = this.yR + "/" + str + "/";
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
                str2 = this.yS + str + "/";
            } else {
                str2 = this.yS;
            }
        } else if (z3) {
            if (this.yU == null) {
                return null;
            }
            if (str != null) {
                str2 = this.yU + str + "/";
            } else {
                str2 = this.yU;
            }
        } else if (this.yT == null) {
            return null;
        } else {
            if (str != null) {
                str2 = this.yT + str + "/";
            } else {
                str2 = this.yT;
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
