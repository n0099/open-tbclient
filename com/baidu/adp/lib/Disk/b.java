package com.baidu.adp.lib.Disk;

import android.os.Environment;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import java.io.File;
/* loaded from: classes.dex */
public class b {
    private final String yg = Environment.getExternalStorageDirectory().getAbsolutePath();
    private String yh = this.yg + "/baidu/";
    private String yi;
    private String yj;

    public b() {
        this.yi = null;
        this.yj = null;
        try {
            this.yi = BdBaseApplication.getInst().getContext().getFilesDir().getAbsolutePath() + "/";
            this.yj = BdBaseApplication.getInst().getContext().getCacheDir().getAbsolutePath() + "/";
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void aq(String str) {
        if (str != null) {
            this.yh = this.yg + "/" + str + "/";
        }
    }

    public boolean hk() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    public String a(String str, boolean z, boolean z2, boolean z3) {
        String str2;
        if (z2) {
            if (!hk()) {
                return null;
            }
            if (str != null) {
                str2 = this.yh + str + "/";
            } else {
                str2 = this.yh;
            }
        } else if (z3) {
            if (this.yj == null) {
                return null;
            }
            if (str != null) {
                str2 = this.yj + str + "/";
            } else {
                str2 = this.yj;
            }
        } else if (this.yi == null) {
            return null;
        } else {
            if (str != null) {
                str2 = this.yi + str + "/";
            } else {
                str2 = this.yi;
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
