package com.baidu.platform.comapi.wnplatform.e;

import android.text.TextUtils;
import com.baidu.f.a.c;
import com.baidu.searchbox.ugc.model.UgcConstant;
import com.google.protobuf.micro.MessageMicro;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes20.dex */
public class d {
    static final String a = d.class.getSimpleName();
    private static Map<String, Method> b = new HashMap();

    private static Method a(ClassLoader classLoader, String str) throws ClassNotFoundException, NoSuchMethodException {
        String str2 = str + UgcConstant.AT_RULE_TAG + classLoader.hashCode();
        Method method = b.get(str2);
        if (method == null && (method = Class.forName(str, true, classLoader).getDeclaredMethod("parseFrom", byte[].class)) != null) {
            method.setAccessible(true);
            b.put(str2, method);
        }
        return method;
    }

    public static MessageMicro a(String str, String str2, byte[] bArr, int i, int i2) {
        if (bArr != null && !TextUtils.isEmpty(str2)) {
            try {
                return (MessageMicro) a(d.class.getClassLoader(), str + "." + str2.replace("\\.", "\\$")).invoke(null, a(new ByteArrayInputStream(bArr, i, i2)));
            } catch (Exception e) {
            }
        }
        return null;
    }

    public static List<MessageMicro> a(byte[] bArr, String str) throws IOException {
        ArrayList arrayList = new ArrayList();
        if (bArr != null && bArr.length != 0) {
            int i = ByteBuffer.wrap(bArr, 0, 4).order(ByteOrder.BIG_ENDIAN).getInt();
            com.baidu.f.a.c w = com.baidu.f.a.c.w(a(new ByteArrayInputStream(bArr, 4, i)));
            int vQ = w.vQ();
            int i2 = i + 4;
            for (int i3 = 0; i3 < vQ; i3++) {
                c.a bV = w.bV(i3);
                String name = bV.getName();
                int vS = bV.vS();
                int offset = bV.getOffset() + i2;
                if (name.equals("M")) {
                    b bVar = new b();
                    bVar.a = a(new ByteArrayInputStream(bArr, offset, vS));
                    arrayList.add(bVar);
                } else {
                    MessageMicro a2 = a(str, name, bArr, offset, vS);
                    if (a2 != null) {
                        arrayList.add(a2);
                    }
                }
            }
        }
        return arrayList;
    }

    public static List<MessageMicro> a(byte[] bArr) throws IOException {
        return a(bArr, "com.baidu.entity.pb");
    }

    public static byte[] a(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        a(inputStream, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    private static void a(InputStream inputStream, OutputStream outputStream) throws IOException {
        if (!(inputStream instanceof BufferedInputStream)) {
            inputStream = new BufferedInputStream(inputStream);
        }
        if (!(outputStream instanceof BufferedOutputStream)) {
            outputStream = new BufferedOutputStream(outputStream);
        }
        byte[] bArr = new byte[512];
        while (true) {
            try {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    outputStream.write(bArr, 0, read);
                } else {
                    outputStream.flush();
                    return;
                }
            } finally {
                inputStream.close();
                outputStream.close();
            }
        }
    }
}
