package com.baidu.helios.common.b.a;

import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
/* loaded from: classes3.dex */
public class d {
    public static void a(InputStream inputStream, OutputStream outputStream, int i) throws IOException {
        byte[] bArr = new byte[i];
        while (true) {
            int read = inputStream.read(bArr);
            if (read > 0) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }

    public static String d(InputStream inputStream, String str) throws IOException {
        CharArrayWriter charArrayWriter = new CharArrayWriter();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, str);
        char[] cArr = new char[8192];
        while (true) {
            int read = inputStreamReader.read(cArr);
            if (read > 0) {
                charArrayWriter.write(cArr, 0, read);
            } else {
                return charArrayWriter.toString();
            }
        }
    }
}
