package com.baidu.adp.lib.Disk;

import android.os.Environment;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import java.io.File;
/* loaded from: classes.dex */
public class b {
    private final String afj = Environment.getExternalStorageDirectory().getAbsolutePath();
    private String afk = this.afj + "/baidu/";
    private String afl;
    private String afm;

    public b() {
        this.afl = null;
        this.afm = null;
        try {
            this.afl = BdBaseApplication.getInst().getContext().getFilesDir().getAbsolutePath() + "/";
            this.afm = BdBaseApplication.getInst().getContext().getCacheDir().getAbsolutePath() + "/";
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void P(String str) {
        if (str != null) {
            this.afk = this.afj + "/" + str + "/";
        }
    }

    public boolean lk() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    public String a(String str, boolean z, boolean z2, boolean z3) {
        String str2;
        if (z2) {
            if (!lk()) {
                return null;
            }
            if (str != null) {
                str2 = this.afk + str + "/";
            } else {
                str2 = this.afk;
            }
        } else if (z3) {
            if (this.afm == null) {
                return null;
            }
            if (str != null) {
                str2 = this.afm + str + "/";
            } else {
                str2 = this.afm;
            }
        } else if (this.afl == null) {
            return null;
        } else {
            if (str != null) {
                str2 = this.afl + str + "/";
            } else {
                str2 = this.afl;
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
