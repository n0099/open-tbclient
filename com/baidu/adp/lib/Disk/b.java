package com.baidu.adp.lib.Disk;

import android.os.Environment;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import java.io.File;
/* loaded from: classes.dex */
public class b {
    private final String afq = Environment.getExternalStorageDirectory().getAbsolutePath();
    private String afr = this.afq + "/baidu/";
    private String afs;

    public b() {
        this.afs = null;
        try {
            this.afs = BdBaseApplication.getInst().getContext().getFilesDir().getAbsolutePath() + "/";
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void P(String str) {
        if (str != null) {
            this.afr = this.afq + "/" + str + "/";
        }
    }

    public boolean lk() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    public String a(String str, boolean z, boolean z2) {
        String str2;
        if (z2) {
            if (!lk()) {
                return null;
            }
            if (str != null) {
                str2 = this.afr + str + "/";
            } else {
                str2 = this.afr;
            }
        } else if (this.afs == null) {
            return null;
        } else {
            if (str != null) {
                str2 = this.afs + str + "/";
            } else {
                str2 = this.afs;
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
