package com.alibaba.fastjson;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
/* loaded from: classes.dex */
public abstract class JSONValidator implements Cloneable, Closeable {
    public char ch;
    public boolean eof;
    public Type type;
    public Boolean valiateResult;
    public int pos = -1;
    public int count = 0;
    public boolean supportMultiValue = false;

    /* loaded from: classes.dex */
    public static class ReaderValidator extends JSONValidator {
        public static final ThreadLocal<char[]> bufLocal = new ThreadLocal<>();
        public char[] buf;
        public final Reader r;
        public int end = -1;
        public int readCount = 0;

        public ReaderValidator(Reader reader) {
            this.r = reader;
            char[] cArr = bufLocal.get();
            this.buf = cArr;
            if (cArr != null) {
                bufLocal.set(null);
            } else {
                this.buf = new char[8192];
            }
            next();
            skipWhiteSpace();
        }

        @Override // com.alibaba.fastjson.JSONValidator, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            bufLocal.set(this.buf);
            this.r.close();
        }

        @Override // com.alibaba.fastjson.JSONValidator
        public void next() {
            int i2 = this.pos;
            if (i2 < this.end) {
                char[] cArr = this.buf;
                int i3 = i2 + 1;
                this.pos = i3;
                this.ch = cArr[i3];
            } else if (this.eof) {
            } else {
                try {
                    int read = this.r.read(this.buf, 0, this.buf.length);
                    this.readCount++;
                    if (read > 0) {
                        this.ch = this.buf[0];
                        this.pos = 0;
                        this.end = read - 1;
                    } else if (read == -1) {
                        this.pos = 0;
                        this.end = 0;
                        this.buf = null;
                        this.ch = (char) 0;
                        this.eof = true;
                    } else {
                        this.pos = 0;
                        this.end = 0;
                        this.buf = null;
                        this.ch = (char) 0;
                        this.eof = true;
                        throw new JSONException("read error");
                    }
                } catch (IOException unused) {
                    throw new JSONException("read error");
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public enum Type {
        Object,
        Array,
        Value
    }

    /* loaded from: classes.dex */
    public static class UTF16Validator extends JSONValidator {
        public final String str;

        public UTF16Validator(String str) {
            this.str = str;
            next();
            skipWhiteSpace();
        }

        @Override // com.alibaba.fastjson.JSONValidator
        public final void fieldName() {
            char charAt;
            int i2 = this.pos;
            do {
                i2++;
                if (i2 >= this.str.length() || (charAt = this.str.charAt(i2)) == '\\') {
                    next();
                    while (true) {
                        char c2 = this.ch;
                        if (c2 == '\\') {
                            next();
                            if (this.ch == 'u') {
                                next();
                                next();
                                next();
                                next();
                                next();
                            } else {
                                next();
                            }
                        } else if (c2 == '\"') {
                            next();
                            return;
                        } else {
                            next();
                        }
                    }
                }
            } while (charAt != '\"');
            int i3 = i2 + 1;
            this.ch = this.str.charAt(i3);
            this.pos = i3;
        }

        @Override // com.alibaba.fastjson.JSONValidator
        public void next() {
            int i2 = this.pos + 1;
            this.pos = i2;
            if (i2 >= this.str.length()) {
                this.ch = (char) 0;
                this.eof = true;
                return;
            }
            this.ch = this.str.charAt(this.pos);
        }
    }

    /* loaded from: classes.dex */
    public static class UTF8InputStreamValidator extends JSONValidator {
        public static final ThreadLocal<byte[]> bufLocal = new ThreadLocal<>();
        public byte[] buf;
        public final InputStream is;
        public int end = -1;
        public int readCount = 0;

        public UTF8InputStreamValidator(InputStream inputStream) {
            this.is = inputStream;
            byte[] bArr = bufLocal.get();
            this.buf = bArr;
            if (bArr != null) {
                bufLocal.set(null);
            } else {
                this.buf = new byte[8192];
            }
            next();
            skipWhiteSpace();
        }

        @Override // com.alibaba.fastjson.JSONValidator, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            bufLocal.set(this.buf);
            this.is.close();
        }

        @Override // com.alibaba.fastjson.JSONValidator
        public void next() {
            int i2 = this.pos;
            if (i2 < this.end) {
                byte[] bArr = this.buf;
                int i3 = i2 + 1;
                this.pos = i3;
                this.ch = (char) bArr[i3];
            } else if (this.eof) {
            } else {
                try {
                    int read = this.is.read(this.buf, 0, this.buf.length);
                    this.readCount++;
                    if (read > 0) {
                        this.ch = (char) this.buf[0];
                        this.pos = 0;
                        this.end = read - 1;
                    } else if (read == -1) {
                        this.pos = 0;
                        this.end = 0;
                        this.buf = null;
                        this.ch = (char) 0;
                        this.eof = true;
                    } else {
                        this.pos = 0;
                        this.end = 0;
                        this.buf = null;
                        this.ch = (char) 0;
                        this.eof = true;
                        throw new JSONException("read error");
                    }
                } catch (IOException unused) {
                    throw new JSONException("read error");
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class UTF8Validator extends JSONValidator {
        public final byte[] bytes;

        public UTF8Validator(byte[] bArr) {
            this.bytes = bArr;
            next();
            skipWhiteSpace();
        }

        @Override // com.alibaba.fastjson.JSONValidator
        public void next() {
            int i2 = this.pos + 1;
            this.pos = i2;
            byte[] bArr = this.bytes;
            if (i2 >= bArr.length) {
                this.ch = (char) 0;
                this.eof = true;
                return;
            }
            this.ch = (char) bArr[i2];
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:123:0x0175, code lost:
        if (r0 <= '9') goto L130;
     */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0187  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean any() {
        char c2;
        char c3;
        char c4;
        char c5;
        char c6;
        char c7;
        char c8;
        char c9;
        char c10 = this.ch;
        if (c10 != '\"') {
            if (c10 != '+' && c10 != '-') {
                if (c10 == '[') {
                    next();
                    skipWhiteSpace();
                    if (this.ch == ']') {
                        next();
                        this.type = Type.Array;
                        return true;
                    }
                    while (any()) {
                        skipWhiteSpace();
                        char c11 = this.ch;
                        if (c11 != ',') {
                            if (c11 == ']') {
                                next();
                                this.type = Type.Array;
                                return true;
                            }
                            return false;
                        }
                        next();
                        skipWhiteSpace();
                    }
                    return false;
                } else if (c10 == 'f') {
                    next();
                    if (this.ch != 'a') {
                        return false;
                    }
                    next();
                    if (this.ch != 'l') {
                        return false;
                    }
                    next();
                    if (this.ch != 's') {
                        return false;
                    }
                    next();
                    if (this.ch != 'e') {
                        return false;
                    }
                    next();
                    if (isWhiteSpace(this.ch) || (c7 = this.ch) == ',' || c7 == ']' || c7 == '}' || c7 == 0) {
                        this.type = Type.Value;
                        return true;
                    }
                    return false;
                } else if (c10 == 'n') {
                    next();
                    if (this.ch != 'u') {
                        return false;
                    }
                    next();
                    if (this.ch != 'l') {
                        return false;
                    }
                    next();
                    if (this.ch != 'l') {
                        return false;
                    }
                    next();
                    if (isWhiteSpace(this.ch) || (c8 = this.ch) == ',' || c8 == ']' || c8 == '}' || c8 == 0) {
                        this.type = Type.Value;
                        return true;
                    }
                    return false;
                } else if (c10 == 't') {
                    next();
                    if (this.ch != 'r') {
                        return false;
                    }
                    next();
                    if (this.ch != 'u') {
                        return false;
                    }
                    next();
                    if (this.ch != 'e') {
                        return false;
                    }
                    next();
                    if (isWhiteSpace(this.ch) || (c9 = this.ch) == ',' || c9 == ']' || c9 == '}' || c9 == 0) {
                        this.type = Type.Value;
                        return true;
                    }
                    return false;
                } else if (c10 == '{') {
                    next();
                    while (isWhiteSpace(this.ch)) {
                        next();
                    }
                    if (this.ch == '}') {
                        next();
                        this.type = Type.Object;
                        return true;
                    }
                    while (this.ch == '\"') {
                        fieldName();
                        skipWhiteSpace();
                        if (this.ch != ':') {
                            break;
                        }
                        next();
                        skipWhiteSpace();
                        if (!any()) {
                            return false;
                        }
                        skipWhiteSpace();
                        char c12 = this.ch;
                        if (c12 == ',') {
                            next();
                            skipWhiteSpace();
                        } else if (c12 == '}') {
                            next();
                            this.type = Type.Object;
                            return true;
                        }
                    }
                    return false;
                } else {
                    switch (c10) {
                        case '0':
                        case '1':
                        case '2':
                        case '3':
                        case '4':
                        case '5':
                        case '6':
                        case '7':
                        case '8':
                        case '9':
                            break;
                        default:
                            return false;
                    }
                }
            }
            char c13 = this.ch;
            if (c13 == '-' || c13 == '+') {
                next();
                skipWhiteSpace();
                char c14 = this.ch;
                if (c14 >= '0') {
                }
                return false;
            }
            do {
                next();
                c2 = this.ch;
                if (c2 >= '0') {
                }
                if (this.ch == '.') {
                    next();
                    char c15 = this.ch;
                    if (c15 < '0' || c15 > '9') {
                        return false;
                    }
                    while (true) {
                        char c16 = this.ch;
                        if (c16 >= '0' && c16 <= '9') {
                            next();
                        }
                    }
                }
                c3 = this.ch;
                if (c3 != 'e' || c3 == 'E') {
                    next();
                    c4 = this.ch;
                    if (c4 != '-' || c4 == '+') {
                        next();
                    }
                    c5 = this.ch;
                    if (c5 >= '0' && c5 <= '9') {
                        next();
                        while (true) {
                            c6 = this.ch;
                            if (c6 >= '0' && c6 <= '9') {
                                next();
                            }
                        }
                    }
                    return false;
                }
                this.type = Type.Value;
                return true;
            } while (c2 <= '9');
            if (this.ch == '.') {
            }
            c3 = this.ch;
            if (c3 != 'e') {
            }
            next();
            c4 = this.ch;
            if (c4 != '-') {
            }
            next();
            c5 = this.ch;
            if (c5 >= '0') {
                next();
                while (true) {
                    c6 = this.ch;
                    if (c6 >= '0') {
                        next();
                    }
                }
                this.type = Type.Value;
                return true;
            }
            return false;
        }
        next();
        while (!this.eof) {
            char c17 = this.ch;
            if (c17 == '\\') {
                next();
                if (this.ch == 'u') {
                    next();
                    next();
                    next();
                    next();
                    next();
                } else {
                    next();
                }
            } else if (c17 == '\"') {
                next();
                this.type = Type.Value;
                return true;
            } else {
                next();
            }
        }
        return false;
    }

    public static JSONValidator from(String str) {
        return new UTF16Validator(str);
    }

    public static JSONValidator fromUtf8(byte[] bArr) {
        return new UTF8Validator(bArr);
    }

    public static final boolean isWhiteSpace(char c2) {
        return c2 == ' ' || c2 == '\t' || c2 == '\r' || c2 == '\n' || c2 == '\f' || c2 == '\b';
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
    }

    public void fieldName() {
        next();
        while (true) {
            char c2 = this.ch;
            if (c2 == '\\') {
                next();
                if (this.ch == 'u') {
                    next();
                    next();
                    next();
                    next();
                    next();
                } else {
                    next();
                }
            } else if (c2 == '\"') {
                next();
                return;
            } else {
                next();
            }
        }
    }

    public Type getType() {
        if (this.type == null) {
            validate();
        }
        return this.type;
    }

    public boolean isSupportMultiValue() {
        return this.supportMultiValue;
    }

    public abstract void next();

    public JSONValidator setSupportMultiValue(boolean z) {
        this.supportMultiValue = z;
        return this;
    }

    public void skipWhiteSpace() {
        while (isWhiteSpace(this.ch)) {
            next();
        }
    }

    public boolean string() {
        next();
        while (!this.eof) {
            char c2 = this.ch;
            if (c2 == '\\') {
                next();
                if (this.ch == 'u') {
                    next();
                    next();
                    next();
                    next();
                    next();
                } else {
                    next();
                }
            } else if (c2 == '\"') {
                next();
                return true;
            } else {
                next();
            }
        }
        return false;
    }

    public boolean validate() {
        Boolean bool = this.valiateResult;
        if (bool != null) {
            return bool.booleanValue();
        }
        while (any()) {
            this.count++;
            if (this.eof) {
                this.valiateResult = Boolean.TRUE;
                return true;
            } else if (this.supportMultiValue) {
                skipWhiteSpace();
                if (this.eof) {
                    this.valiateResult = Boolean.TRUE;
                    return true;
                }
            } else {
                this.valiateResult = Boolean.FALSE;
                return false;
            }
        }
        this.valiateResult = Boolean.FALSE;
        return false;
    }

    public static JSONValidator from(Reader reader) {
        return new ReaderValidator(reader);
    }

    public static JSONValidator fromUtf8(InputStream inputStream) {
        return new UTF8InputStreamValidator(inputStream);
    }
}
