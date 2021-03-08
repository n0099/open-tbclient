package com.baidu.poly.a.i;

import android.text.TextUtils;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
/* loaded from: classes14.dex */
public class a extends Exception {
    public a(String str) {
        super(str);
    }

    public String U() {
        Throwable cause = getCause();
        String str = null;
        if (cause != null) {
            if (cause instanceof a) {
                str = cause.toString();
            } else {
                StringWriter stringWriter = new StringWriter();
                cause.printStackTrace(new PrintWriter((Writer) stringWriter, true));
                str = stringWriter.getBuffer().toString();
            }
        }
        String exc = toString();
        return !TextUtils.isEmpty(str) ? exc + "\nCaused by: " + str : exc;
    }

    public a(String str, Throwable th) {
        super(str, th);
    }
}
