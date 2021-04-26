package com.alipay.security.mobile.module.c;

import com.baidu.android.common.others.lang.StringUtil;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static String f2053a = "";

    /* renamed from: b  reason: collision with root package name */
    public static String f2054b = "";

    /* renamed from: c  reason: collision with root package name */
    public static String f2055c = "";

    public static synchronized void a(String str) {
        synchronized (d.class) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            a(arrayList);
        }
    }

    public static synchronized void a(String str, String str2, String str3) {
        synchronized (d.class) {
            f2053a = str;
            f2054b = str2;
            f2055c = str3;
        }
    }

    public static synchronized void a(Throwable th) {
        String str;
        synchronized (d.class) {
            ArrayList arrayList = new ArrayList();
            if (th != null) {
                StringWriter stringWriter = new StringWriter();
                th.printStackTrace(new PrintWriter(stringWriter));
                str = stringWriter.toString();
            } else {
                str = "";
            }
            arrayList.add(str);
            a(arrayList);
        }
    }

    public static synchronized void a(List<String> list) {
        synchronized (d.class) {
            if (!com.alipay.security.mobile.module.a.a.a(f2054b) && !com.alipay.security.mobile.module.a.a.a(f2055c)) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(f2055c);
                Iterator<String> it = list.iterator();
                while (it.hasNext()) {
                    stringBuffer.append(StringUtil.ARRAY_ELEMENT_SEPARATOR + it.next());
                }
                stringBuffer.append("\n");
                try {
                    File file = new File(f2053a);
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    File file2 = new File(f2053a, f2054b);
                    if (!file2.exists()) {
                        file2.createNewFile();
                    }
                    FileWriter fileWriter = ((long) stringBuffer.length()) + file2.length() <= 51200 ? new FileWriter(file2, true) : new FileWriter(file2);
                    fileWriter.write(stringBuffer.toString());
                    fileWriter.flush();
                    fileWriter.close();
                } catch (Exception unused) {
                }
            }
        }
    }
}
