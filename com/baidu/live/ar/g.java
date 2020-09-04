package com.baidu.live.ar;

import android.text.TextUtils;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import java.io.File;
/* loaded from: classes7.dex */
public class g {
    private static File aAg = getPrivateCaptureRootChildDir("duFilter");
    public static String aAh;

    public static File getPrivateCaptureRootChildDir(String str) {
        String str2 = TbadkCoreApplication.getInst().getContext().getFilesDir().getAbsoluteFile() + File.separator + "live_ar" + File.separator;
        return TextUtils.isEmpty(str) ? new File(str2) : new File(str2, str);
    }

    public static void fF(String str) {
        aAh = str;
    }
}
