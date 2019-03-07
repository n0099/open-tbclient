package com.baidu.pass.biometrics.base.dynamicupdate;

import android.content.Context;
import java.io.File;
/* loaded from: classes2.dex */
public class ConfigUtils {
    private static final String SP_FILE_NAME_BIOMETRICS = "pass_biometrics_system";

    public static String getFPFileLastModified(Context context) {
        File file = new File("/data/data/" + context.getPackageName() + "/shared_prefs/" + SP_FILE_NAME_BIOMETRICS + ".xml");
        return file.exists() ? "" + (file.lastModified() / 1000) : "";
    }
}
