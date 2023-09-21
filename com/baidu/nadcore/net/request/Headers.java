package com.baidu.nadcore.net.request;

import androidx.annotation.Nullable;
import com.baidu.tieba.bh0;
import com.baidu.tieba.g31;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
/* loaded from: classes3.dex */
public final class Headers {
    public final String[] a;

    /* loaded from: classes3.dex */
    public static class IllegalUnicodeException extends Exception {
        public IllegalUnicodeException(String str) {
            super(str);
        }
    }

    /* loaded from: classes3.dex */
    public static final class a {
        public final List<String> a = new ArrayList(20);

        public Headers c() {
            return new Headers(this);
        }

        public a a(String str, String str2) {
            try {
                Headers.a(str);
                Headers.b(str2, str);
                b(str, str2);
                return this;
            } catch (Exception e) {
                if (!bh0.a) {
                    return this;
                }
                throw new IllegalStateException(e);
            }
        }

        public a b(String str, String str2) {
            g31.b(this.a, str);
            g31.b(this.a, str2.trim());
            return this;
        }

        public a e(String str, String str2) {
            try {
                Headers.a(str);
                Headers.b(str2, str);
                d(str);
                b(str, str2);
            } catch (IllegalUnicodeException unused) {
            }
            return this;
        }

        public a d(String str) {
            int i = 0;
            while (i < g31.l(this.a)) {
                if (str.equalsIgnoreCase((String) g31.d(this.a, i))) {
                    g31.i(this.a, i);
                    g31.i(this.a, i);
                    i -= 2;
                }
                i += 2;
            }
            return this;
        }
    }

    public Headers(a aVar) {
        List<String> list = aVar.a;
        this.a = (String[]) list.toArray(new String[g31.l(list)]);
    }

    @Nullable
    public String d(String str) {
        return e(this.a, str);
    }

    public boolean equals(@Nullable Object obj) {
        if ((obj instanceof Headers) && Arrays.equals(((Headers) obj).a, this.a)) {
            return true;
        }
        return false;
    }

    public String f(int i) {
        return this.a[i * 2];
    }

    public String h(int i) {
        return this.a[(i * 2) + 1];
    }

    public static void a(String str) throws IllegalUnicodeException {
        if (str != null) {
            if (!str.isEmpty()) {
                int length = str.length();
                for (int i = 0; i < length; i++) {
                    char charAt = str.charAt(i);
                    if (charAt <= ' ' || charAt >= 127) {
                        throw new IllegalUnicodeException(c("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(charAt), Integer.valueOf(i), str));
                    }
                }
                return;
            }
            throw new IllegalArgumentException("name is empty");
        }
        throw new NullPointerException("name == null");
    }

    public static void b(String str, String str2) throws IllegalUnicodeException {
        if (str != null) {
            int length = str.length();
            for (int i = 0; i < length; i++) {
                char charAt = str.charAt(i);
                if ((charAt <= 31 && charAt != '\t') || charAt >= 127) {
                    throw new IllegalUnicodeException(c("Unexpected char %#04x at %d in %s value: %s", Integer.valueOf(charAt), Integer.valueOf(i), str2, str));
                }
            }
            return;
        }
        throw new NullPointerException("value for name " + str2 + " == null");
    }

    public static String c(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    public static String e(String[] strArr, String str) {
        for (int length = strArr.length - 2; length >= 0; length -= 2) {
            if (str.equalsIgnoreCase(strArr[length])) {
                return strArr[length + 1];
            }
        }
        return null;
    }

    public int g() {
        return this.a.length / 2;
    }

    public int hashCode() {
        return Arrays.hashCode(this.a);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int g = g();
        for (int i = 0; i < g; i++) {
            sb.append(f(i));
            sb.append(": ");
            sb.append(h(i));
            sb.append("\n");
        }
        return sb.toString();
    }
}
