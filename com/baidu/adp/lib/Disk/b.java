package com.baidu.adp.lib.Disk;

import android.os.Environment;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import java.io.File;
/* loaded from: classes.dex */
public class b {
    private final String EXTERNAL_STORAGE_DIRECTORY = Environment.getExternalStorageDirectory().getAbsolutePath();
    private String pI = this.EXTERNAL_STORAGE_DIRECTORY + "/baidu/";
    private String pJ;
    private String pK;

    public b() {
        this.pJ = null;
        this.pK = null;
        try {
            this.pJ = BdBaseApplication.getInst().getContext().getFilesDir().getAbsolutePath() + "/";
            this.pK = BdBaseApplication.getInst().getContext().getCacheDir().getAbsolutePath() + "/";
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void M(String str) {
        if (str != null) {
            this.pI = this.EXTERNAL_STORAGE_DIRECTORY + "/" + str + "/";
        }
    }

    /* renamed from: do  reason: not valid java name */
    public boolean m8do() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    public String a(String str, boolean z, boolean z2, boolean z3) {
        String str2;
        if (z2) {
            if (!m8do()) {
                return null;
            }
            if (str != null) {
                str2 = this.pI + str + "/";
            } else {
                str2 = this.pI;
            }
        } else if (z3) {
            if (this.pK == null) {
                return null;
            }
            if (str != null) {
                str2 = this.pK + str + "/";
            } else {
                str2 = this.pK;
            }
        } else if (this.pJ == null) {
            return null;
        } else {
            if (str != null) {
                str2 = this.pJ + str + "/";
            } else {
                str2 = this.pJ;
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
