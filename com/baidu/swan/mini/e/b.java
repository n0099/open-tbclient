package com.baidu.swan.mini.e;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
/* loaded from: classes11.dex */
public class b {
    public static String ql(String str) {
        return P(str, true);
    }

    private static String P(String str, boolean z) {
        if (str == null) {
            return "";
        }
        try {
            StringWriter stringWriter = new StringWriter(str.length() * 2);
            a(stringWriter, str, z);
            return stringWriter.toString();
        } catch (IOException e) {
            if (com.baidu.swan.apps.b.DEBUG) {
                e.printStackTrace();
            }
            return "";
        }
    }

    private static void a(Writer writer, String str, boolean z) throws IOException {
        if (writer == null) {
            throw new IllegalArgumentException("The Writer must not be null");
        }
        if (str != null) {
            int length = str.length();
            for (int i = 0; i < length; i++) {
                char charAt = str.charAt(i);
                if (charAt > 4095) {
                    writer.write("\\u" + d(charAt));
                } else if (charAt > 255) {
                    writer.write("\\u0" + d(charAt));
                } else if (charAt > 127) {
                    writer.write("\\u00" + d(charAt));
                } else if (charAt < ' ') {
                    switch (charAt) {
                        case '\b':
                            writer.write(92);
                            writer.write(98);
                            continue;
                        case '\t':
                            writer.write(92);
                            writer.write(116);
                            continue;
                        case '\n':
                            writer.write(92);
                            writer.write(110);
                            continue;
                        case 11:
                        default:
                            if (charAt > 15) {
                                writer.write("\\u00" + d(charAt));
                                continue;
                            } else {
                                writer.write("\\u000" + d(charAt));
                                break;
                            }
                        case '\f':
                            writer.write(92);
                            writer.write(102);
                            continue;
                        case '\r':
                            writer.write(92);
                            writer.write(114);
                            continue;
                    }
                } else {
                    switch (charAt) {
                        case '\"':
                            writer.write(92);
                            writer.write(34);
                            continue;
                        case '\'':
                            if (z) {
                                writer.write(92);
                            }
                            writer.write(39);
                            continue;
                        case '/':
                            writer.write(92);
                            writer.write(47);
                            continue;
                        case '\\':
                            writer.write(92);
                            writer.write(92);
                            continue;
                        default:
                            writer.write(charAt);
                            continue;
                    }
                }
            }
        }
    }

    private static String d(char c) {
        return Integer.toHexString(c).toUpperCase();
    }
}
