package com.baidu.adp.lib.Disk;

import android.os.Environment;
import com.baidu.adp.base.BdBaseApplication;
import java.io.File;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b {
    private final String a = Environment.getExternalStorageDirectory().getAbsolutePath();
    private String b = String.valueOf(this.a) + "/baidu/";
    private final String c = String.valueOf(BdBaseApplication.getInst().getFilesDir().getAbsolutePath()) + "/";

    public void a(String str) {
        if (str != null) {
            this.b = String.valueOf(this.a) + "/" + str + "/";
        }
    }

    public boolean a() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    public String a(String str, boolean z, boolean z2) {
        String str2;
        if (z2) {
            if (!a()) {
                return null;
            }
            if (str != null) {
                str2 = String.valueOf(this.b) + str + "/";
            } else {
                str2 = this.b;
            }
        } else if (str != null) {
            str2 = String.valueOf(this.c) + str + "/";
        } else {
            str2 = this.c;
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
        return new File(String.valueOf(a) + str2);
    }

    public File b(String str, boolean z, boolean z2) {
        String a = a(str, z, z2);
        if (a == null) {
            return null;
        }
        return new File(a);
    }
}
