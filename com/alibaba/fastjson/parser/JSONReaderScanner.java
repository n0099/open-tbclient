package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.util.IOUtils;
import java.io.CharArrayReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.math.BigDecimal;
import java.math.MathContext;
/* loaded from: classes.dex */
public final class JSONReaderScanner extends JSONLexerBase {
    public static final ThreadLocal<char[]> BUF_LOCAL = new ThreadLocal<>();
    public char[] buf;
    public int bufLength;
    public Reader reader;

    public JSONReaderScanner(String str) {
        this(str, JSON.DEFAULT_PARSER_FEATURE);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final String addSymbol(int i2, int i3, int i4, SymbolTable symbolTable) {
        return symbolTable.addSymbol(this.buf, i2, i3, i4);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final void arrayCopy(int i2, char[] cArr, int i3, int i4) {
        System.arraycopy(this.buf, i2, cArr, i3, i4);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public byte[] bytesValue() {
        if (this.token != 26) {
            return IOUtils.decodeBase64(this.buf, this.np + 1, this.sp);
        }
        throw new JSONException("TODO");
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final boolean charArrayCompare(char[] cArr) {
        for (int i2 = 0; i2 < cArr.length; i2++) {
            if (charAt(this.bp + i2) != cArr[i2]) {
                return false;
            }
        }
        return true;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final char charAt(int i2) {
        int i3 = this.bufLength;
        if (i2 >= i3) {
            if (i3 == -1) {
                return i2 < this.sp ? this.buf[i2] : JSONLexer.EOI;
            }
            int i4 = this.bp;
            if (i4 == 0) {
                char[] cArr = this.buf;
                int length = (cArr.length * 3) / 2;
                char[] cArr2 = new char[length];
                System.arraycopy(cArr, i4, cArr2, 0, i3);
                int i5 = this.bufLength;
                try {
                    this.bufLength += this.reader.read(cArr2, i5, length - i5);
                    this.buf = cArr2;
                } catch (IOException e2) {
                    throw new JSONException(e2.getMessage(), e2);
                }
            } else {
                int i6 = i3 - i4;
                if (i6 > 0) {
                    char[] cArr3 = this.buf;
                    System.arraycopy(cArr3, i4, cArr3, 0, i6);
                }
                try {
                    int read = this.reader.read(this.buf, i6, this.buf.length - i6);
                    this.bufLength = read;
                    if (read == 0) {
                        throw new JSONException("illegal state, textLength is zero");
                    }
                    if (read == -1) {
                        return JSONLexer.EOI;
                    }
                    this.bufLength = read + i6;
                    int i7 = this.bp;
                    i2 -= i7;
                    this.np -= i7;
                    this.bp = 0;
                } catch (IOException e3) {
                    throw new JSONException(e3.getMessage(), e3);
                }
            }
        }
        return this.buf[i2];
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        super.close();
        char[] cArr = this.buf;
        if (cArr.length <= 65536) {
            BUF_LOCAL.set(cArr);
        }
        this.buf = null;
        IOUtils.close(this.reader);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final void copyTo(int i2, int i3, char[] cArr) {
        System.arraycopy(this.buf, i2, cArr, 0, i3);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public final BigDecimal decimalValue() {
        int i2 = this.np;
        if (i2 == -1) {
            i2 = 0;
        }
        char charAt = charAt((this.sp + i2) - 1);
        int i3 = this.sp;
        if (charAt == 'L' || charAt == 'S' || charAt == 'B' || charAt == 'F' || charAt == 'D') {
            i3--;
        }
        if (i3 <= 65535) {
            return new BigDecimal(this.buf, i2, i3, MathContext.UNLIMITED);
        }
        throw new JSONException("decimal overflow");
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final int indexOf(char c2, int i2) {
        int i3 = i2 - this.bp;
        while (true) {
            char charAt = charAt(this.bp + i3);
            if (c2 == charAt) {
                return i3 + this.bp;
            }
            if (charAt == 26) {
                return -1;
            }
            i3++;
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public final boolean isBlankInput() {
        int i2 = 0;
        while (true) {
            char c2 = this.buf[i2];
            if (c2 == 26) {
                this.token = 20;
                return true;
            } else if (!JSONLexerBase.isWhitespace(c2)) {
                return false;
            } else {
                i2++;
            }
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public boolean isEOF() {
        if (this.bufLength != -1) {
            int i2 = this.bp;
            char[] cArr = this.buf;
            if (i2 != cArr.length) {
                return this.ch == 26 && i2 + 1 >= cArr.length;
            }
            return true;
        }
        return true;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public final char next() {
        int i2 = this.bp + 1;
        this.bp = i2;
        int i3 = this.bufLength;
        if (i2 >= i3) {
            if (i3 == -1) {
                return JSONLexer.EOI;
            }
            int i4 = this.sp;
            if (i4 > 0) {
                int i5 = i3 - i4;
                if (this.ch == '\"' && i5 > 0) {
                    i5--;
                }
                char[] cArr = this.buf;
                System.arraycopy(cArr, i5, cArr, 0, this.sp);
            }
            this.np = -1;
            int i6 = this.sp;
            this.bp = i6;
            try {
                int length = this.buf.length - i6;
                if (length == 0) {
                    char[] cArr2 = new char[this.buf.length * 2];
                    System.arraycopy(this.buf, 0, cArr2, 0, this.buf.length);
                    this.buf = cArr2;
                    length = cArr2.length - i6;
                }
                int read = this.reader.read(this.buf, this.bp, length);
                this.bufLength = read;
                if (read == 0) {
                    throw new JSONException("illegal stat, textLength is zero");
                }
                if (read == -1) {
                    this.ch = JSONLexer.EOI;
                    return JSONLexer.EOI;
                }
                this.bufLength = read + this.bp;
                i2 = i6;
            } catch (IOException e2) {
                throw new JSONException(e2.getMessage(), e2);
            }
        }
        char c2 = this.buf[i2];
        this.ch = c2;
        return c2;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public final String numberString() {
        int i2 = this.np;
        if (i2 == -1) {
            i2 = 0;
        }
        char charAt = charAt((this.sp + i2) - 1);
        int i3 = this.sp;
        if (charAt == 'L' || charAt == 'S' || charAt == 'B' || charAt == 'F' || charAt == 'D') {
            i3--;
        }
        return new String(this.buf, i2, i3);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public final String stringVal() {
        if (!this.hasSpecial) {
            int i2 = this.np + 1;
            if (i2 >= 0) {
                if (i2 <= this.buf.length - this.sp) {
                    return new String(this.buf, i2, this.sp);
                }
                throw new IllegalStateException();
            }
            throw new IllegalStateException();
        }
        return new String(this.sbuf, 0, this.sp);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final String subString(int i2, int i3) {
        if (i3 >= 0) {
            return new String(this.buf, i2, i3);
        }
        throw new StringIndexOutOfBoundsException(i3);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final char[] sub_chars(int i2, int i3) {
        if (i3 >= 0) {
            if (i2 == 0) {
                return this.buf;
            }
            char[] cArr = new char[i3];
            System.arraycopy(this.buf, i2, cArr, 0, i3);
            return cArr;
        }
        throw new StringIndexOutOfBoundsException(i3);
    }

    public JSONReaderScanner(String str, int i2) {
        this(new StringReader(str), i2);
    }

    public JSONReaderScanner(char[] cArr, int i2) {
        this(cArr, i2, JSON.DEFAULT_PARSER_FEATURE);
    }

    public JSONReaderScanner(Reader reader) {
        this(reader, JSON.DEFAULT_PARSER_FEATURE);
    }

    public JSONReaderScanner(Reader reader, int i2) {
        super(i2);
        this.reader = reader;
        char[] cArr = BUF_LOCAL.get();
        this.buf = cArr;
        if (cArr != null) {
            BUF_LOCAL.set(null);
        }
        if (this.buf == null) {
            this.buf = new char[16384];
        }
        try {
            this.bufLength = reader.read(this.buf);
            this.bp = -1;
            next();
            if (this.ch == 65279) {
                next();
            }
        } catch (IOException e2) {
            throw new JSONException(e2.getMessage(), e2);
        }
    }

    public JSONReaderScanner(char[] cArr, int i2, int i3) {
        this(new CharArrayReader(cArr, 0, i2), i3);
    }
}
