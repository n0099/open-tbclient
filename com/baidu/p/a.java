package com.baidu.p;

import android.text.TextUtils;
import android.util.Base64;
import java.io.UnsupportedEncodingException;
/* loaded from: classes11.dex */
public class a {
    public static String Um(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "process";
        }
        try {
            return new String(Base64.encode(str.getBytes("UTF-8"), 0), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "";
        }
    }
}
