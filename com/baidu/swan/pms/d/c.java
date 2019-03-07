package com.baidu.swan.pms.d;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.io.IOException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c {
    public static File cC(Context context) {
        File dir = context.getDir("pms_dir", 0);
        if (!dir.exists()) {
            dir.mkdir();
        }
        return dir;
    }

    public static String bi(String str, String str2) {
        return A(str, str2, File.separator);
    }

    public static String A(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str)) {
            if (TextUtils.isEmpty(str2)) {
                return str;
            }
            if (str.endsWith(str3)) {
                if (str2.startsWith(str3)) {
                    return str.concat(str2.substring(str3.length()));
                }
                return str.concat(str2);
            } else if (str2.startsWith(str3)) {
                return str.concat(str2);
            } else {
                return str.concat(str3).concat(str2);
            }
        }
        return str2;
    }

    public static File bj(String str, String str2) {
        File file = new File(str);
        if (file.exists() || file.mkdirs()) {
            String bi = bi(str, str2);
            String str3 = bi;
            for (int i = 0; i < 1000; i++) {
                File file2 = new File(str3);
                try {
                    if (!file2.exists() && file2.createNewFile()) {
                        return file2;
                    }
                } catch (IOException e) {
                    if (com.baidu.swan.pms.e.DEBUG) {
                        e.printStackTrace();
                    }
                }
                str3 = bi + "_" + i;
            }
            return null;
        }
        return null;
    }

    public static String o(String... strArr) {
        JSONObject jSONObject = new JSONObject();
        if (strArr != null) {
            try {
                if (strArr.length > 0 && strArr.length % 2 == 0) {
                    for (int i = 0; i < strArr.length; i += 2) {
                        String str = strArr[i];
                        String str2 = strArr[i + 1];
                        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                            jSONObject.put(str, str2);
                        }
                    }
                }
            } catch (Exception e) {
                if (com.baidu.swan.pms.e.DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        return "errmsg:" + jSONObject.toString();
    }
}
