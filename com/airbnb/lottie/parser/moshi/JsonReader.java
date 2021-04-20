package com.airbnb.lottie.parser.moshi;

import d.a.a.w.k0.b;
import java.io.Closeable;
import java.io.IOException;
import java.util.Arrays;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Options;
/* loaded from: classes.dex */
public abstract class JsonReader implements Closeable {
    public static final String[] k = new String[128];

    /* renamed from: e  reason: collision with root package name */
    public int f1626e;

    /* renamed from: f  reason: collision with root package name */
    public int[] f1627f = new int[32];

    /* renamed from: g  reason: collision with root package name */
    public String[] f1628g = new String[32];

    /* renamed from: h  reason: collision with root package name */
    public int[] f1629h = new int[32];
    public boolean i;
    public boolean j;

    /* loaded from: classes.dex */
    public enum Token {
        BEGIN_ARRAY,
        END_ARRAY,
        BEGIN_OBJECT,
        END_OBJECT,
        NAME,
        STRING,
        NUMBER,
        BOOLEAN,
        NULL,
        END_DOCUMENT
    }

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final String[] f1630a;

        /* renamed from: b  reason: collision with root package name */
        public final Options f1631b;

        public a(String[] strArr, Options options) {
            this.f1630a = strArr;
            this.f1631b = options;
        }

        public static a a(String... strArr) {
            try {
                ByteString[] byteStringArr = new ByteString[strArr.length];
                Buffer buffer = new Buffer();
                for (int i = 0; i < strArr.length; i++) {
                    JsonReader.G(buffer, strArr[i]);
                    buffer.readByte();
                    byteStringArr[i] = buffer.readByteString();
                }
                return new a((String[]) strArr.clone(), Options.of(byteStringArr));
            } catch (IOException e2) {
                throw new AssertionError(e2);
            }
        }
    }

    static {
        for (int i = 0; i <= 31; i++) {
            k[i] = String.format("\\u%04x", Integer.valueOf(i));
        }
        String[] strArr = k;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
    }

    public static JsonReader A(BufferedSource bufferedSource) {
        return new b(bufferedSource);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void G(BufferedSink bufferedSink, String str) throws IOException {
        int i;
        String str2;
        String[] strArr = k;
        bufferedSink.writeByte(34);
        int length = str.length();
        int i2 = 0;
        while (i < length) {
            char charAt = str.charAt(i);
            if (charAt < 128) {
                str2 = strArr[charAt];
                i = str2 == null ? i + 1 : 0;
                if (i2 < i) {
                    bufferedSink.writeUtf8(str, i2, i);
                }
                bufferedSink.writeUtf8(str2);
                i2 = i + 1;
            } else {
                if (charAt == 8232) {
                    str2 = "\\u2028";
                } else if (charAt == 8233) {
                    str2 = "\\u2029";
                }
                if (i2 < i) {
                }
                bufferedSink.writeUtf8(str2);
                i2 = i + 1;
            }
        }
        if (i2 < length) {
            bufferedSink.writeUtf8(str, i2, length);
        }
        bufferedSink.writeByte(34);
    }

    public abstract Token B() throws IOException;

    public final void C(int i) {
        int i2 = this.f1626e;
        int[] iArr = this.f1627f;
        if (i2 == iArr.length) {
            if (i2 != 256) {
                this.f1627f = Arrays.copyOf(iArr, iArr.length * 2);
                String[] strArr = this.f1628g;
                this.f1628g = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
                int[] iArr2 = this.f1629h;
                this.f1629h = Arrays.copyOf(iArr2, iArr2.length * 2);
            } else {
                throw new JsonDataException("Nesting too deep at " + s());
            }
        }
        int[] iArr3 = this.f1627f;
        int i3 = this.f1626e;
        this.f1626e = i3 + 1;
        iArr3[i3] = i;
    }

    public abstract int D(a aVar) throws IOException;

    public abstract void E() throws IOException;

    public abstract void F() throws IOException;

    public final JsonEncodingException H(String str) throws JsonEncodingException {
        throw new JsonEncodingException(str + " at path " + s());
    }

    public abstract void n() throws IOException;

    public abstract void o() throws IOException;

    public abstract void q() throws IOException;

    public abstract void r() throws IOException;

    public final String s() {
        return d.a.a.w.k0.a.a(this.f1626e, this.f1627f, this.f1628g, this.f1629h);
    }

    public abstract boolean t() throws IOException;

    public abstract boolean v() throws IOException;

    public abstract double w() throws IOException;

    public abstract int x() throws IOException;

    public abstract String y() throws IOException;

    public abstract String z() throws IOException;
}
