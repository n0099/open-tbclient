package c.b.b.q;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
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
            int i = 0;
            char c6 = 0;
            int i2 = 0;
            int i3 = 0;
            while (true) {
                int i4 = -1;
                boolean z = true;
                while (true) {
                    int read = bufferedReader.read();
                    if (read == -1) {
                        if (c6 == c4 && i2 <= 4) {
                            throw new IllegalArgumentException("Invalid Unicode sequence: expected format \\uxxxx");
                        }
                        if (i4 == -1 && i > 0) {
                            i4 = i;
                        }
                        if (i4 >= 0) {
                            String str = new String(cArr, 0, i);
                            String substring = str.substring(0, i4);
                            String substring2 = str.substring(i4);
                            if (c6 == c5) {
                                substring2 = substring2 + "\u0000";
                            }
                            wVar.i(substring, substring2);
                            return;
                        }
                        return;
                    }
                    char c7 = (char) read;
                    if (i == cArr.length) {
                        char[] cArr2 = new char[cArr.length * 2];
                        System.arraycopy(cArr, 0, cArr2, 0, i);
                        cArr = cArr2;
                    }
                    if (c6 == c4) {
                        int digit = Character.digit(c7, 16);
                        if (digit >= 0) {
                            i3 = (i3 << 4) + digit;
                            i2++;
                            if (i2 < 4) {
                                c4 = 2;
                            }
                        } else if (i2 <= 4) {
                            throw new IllegalArgumentException("Invalid Unicode sequence: illegal character");
                        }
                        cArr[i] = (char) i3;
                        i++;
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
                                if (i4 == -1) {
                                    i4 = i;
                                    c4 = 2;
                                    c5 = 1;
                                    c6 = 0;
                                }
                            } else if (c7 == '\\') {
                                if (c6 == 4) {
                                    i4 = i;
                                }
                                c4 = 2;
                                c5 = 1;
                                c6 = 1;
                            }
                            if (Character.isSpace(c7)) {
                                if (c6 == 3) {
                                    c6 = 5;
                                }
                                if (i != 0 && i != i4) {
                                    c3 = 5;
                                    if (c6 != 5) {
                                        if (i4 == -1) {
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
                            c7 = '\r';
                        } else if (c7 == 't') {
                            c7 = '\t';
                        } else if (c7 == 'u') {
                            c4 = 2;
                            c6 = 2;
                            i2 = 0;
                            i3 = 0;
                        }
                        c6 = 0;
                    } else {
                        c4 = 2;
                        c6 = 3;
                    }
                    if (c6 == 4) {
                        i4 = i;
                        c6 = 0;
                    }
                    cArr[i] = c7;
                    i++;
                    c4 = 2;
                    c5 = 1;
                    z = false;
                }
                if (i > 0 || (i == 0 && i4 == 0)) {
                    if (i4 == -1) {
                        i4 = i;
                    }
                    String str2 = new String(cArr, 0, i);
                    wVar.i(str2.substring(0, i4), str2.substring(i4));
                }
                c4 = 2;
                c5 = 1;
                i = 0;
                c6 = 0;
            }
        } else {
            throw new NullPointerException("reader cannot be null");
        }
    }
}
