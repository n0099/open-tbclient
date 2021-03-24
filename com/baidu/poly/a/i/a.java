package com.baidu.poly.a.i;

import android.text.TextUtils;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
/* loaded from: classes2.dex */
public class a extends Exception {
    public a(String str) {
        super(str);
    }

    public String U() {
        String str;
        Throwable cause = getCause();
        if (cause == null) {
            str = null;
        } else if (cause instanceof a) {
            str = cause.toString();
        } else {
            StringWriter stringWriter = new StringWriter();
            cause.printStackTrace(new PrintWriter((Writer) stringWriter, true));
            str = stringWriter.getBuffer().toString();
        }
        String exc = toString();
        if (TextUtils.isEmpty(str)) {
            return exc;
        }
        return exc + "\nCaused by: " + str;
    }

    public a(String str, Throwable th) {
        super(str, th);
    }
}
