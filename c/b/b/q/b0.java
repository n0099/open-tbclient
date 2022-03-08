package c.b.b.q;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import org.apache.commons.lang3.CharUtils;
/* loaded from: classes3.dex */
public final class b0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Code restructure failed: missing block: B:114:0x0132, code lost:
        if (r11 != 3) goto L56;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(w<String, String> wVar, Reader reader) throws IOException {
        char c2;
        char c3;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLL(65536, null, wVar, reader) != null) {
            return;
        }
        if (wVar == null) {
            throw new NullPointerException("properties cannot be null");
        }
        if (reader != null) {
            char[] cArr = new char[40];
            BufferedReader bufferedReader = new BufferedReader(reader);
            char c4 = 2;
            char c5 = 1;
            int i2 = 0;
            char c6 = 0;
            int i3 = 0;
            int i4 = 0;
            while (true) {
                int i5 = -1;
                boolean z = true;
                while (true) {
                    int read = bufferedReader.read();
                    if (read == -1) {
                        if (c6 == c4 && i3 <= 4) {
                            throw new IllegalArgumentException("Invalid Unicode sequence: expected format \\uxxxx");
                        }
                        if (i5 == -1 && i2 > 0) {
                            i5 = i2;
                        }
                        if (i5 >= 0) {
                            String str = new String(cArr, 0, i2);
                            String substring = str.substring(0, i5);
                            String substring2 = str.substring(i5);
                            if (c6 == c5) {
                                substring2 = substring2 + "\u0000";
                            }
                            wVar.i(substring, substring2);
                            return;
                        }
                        return;
                    }
                    char c7 = (char) read;
                    if (i2 == cArr.length) {
                        char[] cArr2 = new char[cArr.length * 2];
                        System.arraycopy(cArr, 0, cArr2, 0, i2);
                        cArr = cArr2;
                    }
                    if (c6 == c4) {
                        int digit = Character.digit(c7, 16);
                        if (digit >= 0) {
                            i4 = (i4 << 4) + digit;
                            i3++;
                            if (i3 < 4) {
                                c4 = 2;
                            }
                        } else if (i3 <= 4) {
                            throw new IllegalArgumentException("Invalid Unicode sequence: illegal character");
                        }
                        cArr[i2] = (char) i4;
                        i2++;
                        if (c7 != '\n') {
                            c4 = 2;
                            c6 = 0;
                        } else {
                            c6 = 0;
                        }
                    }
                    if (c6 != c5) {
                        if (c7 == '\n') {
                            if (c6 != 3) {
                                break;
                            }
                            c4 = 2;
                            c5 = 1;
                            c6 = 5;
                        } else if (c7 == '\r') {
                            break;
                        } else {
                            if (c7 == '!' || c7 == '#') {
                                if (z) {
                                    do {
                                        int read2 = bufferedReader.read();
                                        if (read2 == -1 || (c2 = (char) read2) == '\r') {
                                            break;
                                        }
                                    } while (c2 != '\n');
                                    c4 = 2;
                                    c5 = 1;
                                }
                            } else if (c7 == ':' || c7 == '=') {
                                if (i5 == -1) {
                                    i5 = i2;
                                    c4 = 2;
                                    c5 = 1;
                                    c6 = 0;
                                }
                            } else if (c7 == '\\') {
                                if (c6 == 4) {
                                    i5 = i2;
                                }
                                c4 = 2;
                                c5 = 1;
                                c6 = 1;
                            }
                            if (Character.isSpace(c7)) {
                                if (c6 == 3) {
                                    c6 = 5;
                                }
                                if (i2 != 0 && i2 != i5) {
                                    c3 = 5;
                                    if (c6 != 5) {
                                        if (i5 == -1) {
                                            c4 = 2;
                                            c5 = 1;
                                            c6 = 4;
                                        }
                                    }
                                }
                                c4 = 2;
                                c5 = 1;
                            } else {
                                c3 = 5;
                            }
                            if (c6 != c3) {
                            }
                            c6 = 0;
                        }
                    } else if (c7 == '\n') {
                        c4 = 2;
                        c6 = 5;
                    } else if (c7 != '\r') {
                        if (c7 == 'b') {
                            c7 = '\b';
                        } else if (c7 == 'f') {
                            c7 = '\f';
                        } else if (c7 == 'n') {
                            c7 = '\n';
                        } else if (c7 == 'r') {
                            c7 = CharUtils.CR;
                        } else if (c7 == 't') {
                            c7 = '\t';
                        } else if (c7 == 'u') {
                            c4 = 2;
                            c6 = 2;
                            i3 = 0;
                            i4 = 0;
                        }
                        c6 = 0;
                    } else {
                        c4 = 2;
                        c6 = 3;
                    }
                    if (c6 == 4) {
                        i5 = i2;
                        c6 = 0;
                    }
                    cArr[i2] = c7;
                    i2++;
                    c4 = 2;
                    c5 = 1;
                    z = false;
                }
                if (i2 > 0 || (i2 == 0 && i5 == 0)) {
                    if (i5 == -1) {
                        i5 = i2;
                    }
                    String str2 = new String(cArr, 0, i2);
                    wVar.i(str2.substring(0, i5), str2.substring(i5));
                }
                c4 = 2;
                c5 = 1;
                i2 = 0;
                c6 = 0;
            }
        } else {
            throw new NullPointerException("reader cannot be null");
        }
    }
}
