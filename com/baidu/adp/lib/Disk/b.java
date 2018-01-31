package com.baidu.adp.lib.Disk;

import android.os.Environment;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import java.io.File;
/* loaded from: classes.dex */
public class b {
    private final String afr = Environment.getExternalStorageDirectory().getAbsolutePath();
    private String afs = this.afr + "/baidu/";
    private String aft;
    private String afu;

    public b() {
        this.aft = null;
        this.afu = null;
        try {
            this.aft = BdBaseApplication.getInst().getContext().getFilesDir().getAbsolutePath() + "/";
            this.afu = BdBaseApplication.getInst().getContext().getCacheDir().getAbsolutePath() + "/";
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void P(String str) {
        if (str != null) {
            this.afs = this.afr + "/" + str + "/";
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
                str2 = this.afs + str + "/";
            } else {
                str2 = this.afs;
            }
        } else if (z3) {
            if (this.afu == null) {
                return null;
            }
            if (str != null) {
                str2 = this.afu + str + "/";
            } else {
                str2 = this.afu;
            }
        } else if (this.aft == null) {
            return null;
        } else {
            if (str != null) {
                str2 = this.aft + str + "/";
            } else {
                str2 = this.aft;
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
