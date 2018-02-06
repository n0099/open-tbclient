package com.baidu.adp.lib.Disk;

import android.os.Environment;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import java.io.File;
/* loaded from: classes.dex */
public class b {
    private final String afp = Environment.getExternalStorageDirectory().getAbsolutePath();
    private String afq = this.afp + "/baidu/";
    private String afr;
    private String afs;

    public b() {
        this.afr = null;
        this.afs = null;
        try {
            this.afr = BdBaseApplication.getInst().getContext().getFilesDir().getAbsolutePath() + "/";
            this.afs = BdBaseApplication.getInst().getContext().getCacheDir().getAbsolutePath() + "/";
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void P(String str) {
        if (str != null) {
            this.afq = this.afp + "/" + str + "/";
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
                str2 = this.afq + str + "/";
            } else {
                str2 = this.afq;
            }
        } else if (z3) {
            if (this.afs == null) {
                return null;
            }
            if (str != null) {
                str2 = this.afs + str + "/";
            } else {
                str2 = this.afs;
            }
        } else if (this.afr == null) {
            return null;
        } else {
            if (str != null) {
                str2 = this.afr + str + "/";
            } else {
                str2 = this.afr;
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
