package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.util.IOUtils;
import java.io.CharArrayReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.math.BigDecimal;
/* loaded from: classes15.dex */
public final class JSONReaderScanner extends JSONLexerBase {
    private static final ThreadLocal<char[]> BUF_LOCAL = new ThreadLocal<>();
    private char[] buf;
    private int bufLength;
    private Reader reader;

    public JSONReaderScanner(String str) {
        this(str, JSON.DEFAULT_PARSER_FEATURE);
    }

    public JSONReaderScanner(String str, int i) {
        this(new StringReader(str), i);
    }

    public JSONReaderScanner(char[] cArr, int i) {
        this(cArr, i, JSON.DEFAULT_PARSER_FEATURE);
    }

    public JSONReaderScanner(Reader reader) {
        this(reader, JSON.DEFAULT_PARSER_FEATURE);
    }

    public JSONReaderScanner(Reader reader, int i) {
        super(i);
        this.reader = reader;
        this.buf = BUF_LOCAL.get();
        if (this.buf != null) {
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
        } catch (IOException e) {
            throw new JSONException(e.getMessage(), e);
        }
    }

    public JSONReaderScanner(char[] cArr, int i, int i2) {
        this(new CharArrayReader(cArr, 0, i), i2);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final char charAt(int i) {
        if (i >= this.bufLength) {
            if (this.bufLength == -1) {
                return i < this.sp ? this.buf[i] : JSONLexer.EOI;
            } else if (this.bp == 0) {
                char[] cArr = new char[(this.buf.length * 3) / 2];
                System.arraycopy(this.buf, this.bp, cArr, 0, this.bufLength);
                try {
                    this.bufLength = this.reader.read(cArr, this.bufLength, cArr.length - this.bufLength) + this.bufLength;
                    this.buf = cArr;
                } catch (IOException e) {
                    throw new JSONException(e.getMessage(), e);
                }
            } else {
                int i2 = this.bufLength - this.bp;
                if (i2 > 0) {
                    System.arraycopy(this.buf, this.bp, this.buf, 0, i2);
                }
                try {
                    this.bufLength = this.reader.read(this.buf, i2, this.buf.length - i2);
                    if (this.bufLength == 0) {
                        throw new JSONException("illegal state, textLength is zero");
                    }
                    if (this.bufLength == -1) {
                        return JSONLexer.EOI;
                    }
                    this.bufLength += i2;
                    i -= this.bp;
                    this.np -= this.bp;
                    this.bp = 0;
                } catch (IOException e2) {
                    throw new JSONException(e2.getMessage(), e2);
                }
            }
        }
        return this.buf[i];
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final int indexOf(char c, int i) {
        int i2 = i - this.bp;
        while (true) {
            char charAt = charAt(this.bp + i2);
            if (c == charAt) {
                return i2 + this.bp;
            }
            if (charAt != 26) {
                i2++;
            } else {
                return -1;
            }
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final String addSymbol(int i, int i2, int i3, SymbolTable symbolTable) {
        return symbolTable.addSymbol(this.buf, i, i2, i3);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public final char next() {
        int i = this.bp + 1;
        this.bp = i;
        if (i >= this.bufLength) {
            if (this.bufLength == -1) {
                return JSONLexer.EOI;
            }
            if (this.sp > 0) {
                int i2 = this.bufLength - this.sp;
                if (this.ch == '\"' && i2 > 0) {
                    i2--;
                }
                System.arraycopy(this.buf, i2, this.buf, 0, this.sp);
            }
            this.np = -1;
            i = this.sp;
            this.bp = i;
            try {
                int i3 = this.bp;
                int length = this.buf.length - i3;
                if (length == 0) {
                    char[] cArr = new char[this.buf.length * 2];
                    System.arraycopy(this.buf, 0, cArr, 0, this.buf.length);
                    this.buf = cArr;
                    length = this.buf.length - i3;
                }
                this.bufLength = this.reader.read(this.buf, this.bp, length);
                if (this.bufLength == 0) {
                    throw new JSONException("illegal stat, textLength is zero");
                }
                if (this.bufLength == -1) {
                    this.ch = JSONLexer.EOI;
                    return JSONLexer.EOI;
                }
                this.bufLength += this.bp;
            } catch (IOException e) {
                throw new JSONException(e.getMessage(), e);
            }
        }
        char c = this.buf[i];
        this.ch = c;
        return c;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    protected final void copyTo(int i, int i2, char[] cArr) {
        System.arraycopy(this.buf, i, cArr, 0, i2);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final boolean charArrayCompare(char[] cArr) {
        for (int i = 0; i < cArr.length; i++) {
            if (charAt(this.bp + i) != cArr[i]) {
                return false;
            }
        }
        return true;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public byte[] bytesValue() {
        if (this.token == 26) {
            throw new JSONException("TODO");
        }
        return IOUtils.decodeBase64(this.buf, this.np + 1, this.sp);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    protected final void arrayCopy(int i, char[] cArr, int i2, int i3) {
        System.arraycopy(this.buf, i, cArr, i2, i3);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public final String stringVal() {
        if (this.hasSpecial) {
            return new String(this.sbuf, 0, this.sp);
        }
        int i = this.np + 1;
        if (i < 0) {
            throw new IllegalStateException();
        }
        if (i > this.buf.length - this.sp) {
            throw new IllegalStateException();
        }
        return new String(this.buf, i, this.sp);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final String subString(int i, int i2) {
        if (i2 < 0) {
            throw new StringIndexOutOfBoundsException(i2);
        }
        return new String(this.buf, i, i2);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final char[] sub_chars(int i, int i2) {
        if (i2 < 0) {
            throw new StringIndexOutOfBoundsException(i2);
        }
        if (i == 0) {
            return this.buf;
        }
        char[] cArr = new char[i2];
        System.arraycopy(this.buf, i, cArr, 0, i2);
        return cArr;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public final String numberString() {
        int i = this.np;
        if (i == -1) {
            i = 0;
        }
        char charAt = charAt((this.sp + i) - 1);
        int i2 = this.sp;
        if (charAt == 'L' || charAt == 'S' || charAt == 'B' || charAt == 'F' || charAt == 'D') {
            i2--;
        }
        return new String(this.buf, i, i2);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public final BigDecimal decimalValue() {
        int i = this.np;
        if (i == -1) {
            i = 0;
        }
        char charAt = charAt((this.sp + i) - 1);
        int i2 = this.sp;
        if (charAt == 'L' || charAt == 'S' || charAt == 'B' || charAt == 'F' || charAt == 'D') {
            i2--;
        }
        return new BigDecimal(this.buf, i, i2);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        super.close();
        if (this.buf.length <= 65536) {
            BUF_LOCAL.set(this.buf);
        }
        this.buf = null;
        IOUtils.close(this.reader);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public boolean isEOF() {
        return this.bufLength == -1 || this.bp == this.buf.length || (this.ch == 26 && this.bp + 1 == this.buf.length);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public final boolean isBlankInput() {
        int i = 0;
        while (true) {
            char c = this.buf[i];
            if (c == 26) {
                this.token = 20;
                return true;
            } else if (!isWhitespace(c)) {
                return false;
            } else {
                i++;
            }
        }
    }
}
