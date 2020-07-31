package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.util.IOUtils;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.util.List;
/* loaded from: classes3.dex */
public final class SerializeWriter extends Writer {
    private static final ThreadLocal<char[]> bufLocal = new ThreadLocal<>();
    private static final ThreadLocal<byte[]> bytesBufLocal = new ThreadLocal<>();
    static final int nonDirectFeatures = ((((((((SerializerFeature.UseSingleQuotes.mask | 0) | SerializerFeature.BrowserCompatible.mask) | SerializerFeature.PrettyFormat.mask) | SerializerFeature.WriteEnumUsingToString.mask) | SerializerFeature.WriteNonStringValueAsString.mask) | SerializerFeature.WriteSlashAsSpecial.mask) | SerializerFeature.IgnoreErrorGetter.mask) | SerializerFeature.WriteClassName.mask) | SerializerFeature.NotWriteDefaultValue.mask;
    protected boolean beanToArray;
    protected boolean browserSecure;
    protected char[] buf;
    protected int count;
    protected boolean disableCircularReferenceDetect;
    protected int features;
    protected char keySeperator;
    protected int maxBufSize;
    protected boolean notWriteDefaultValue;
    protected boolean quoteFieldNames;
    protected long sepcialBits;
    protected boolean sortField;
    protected boolean useSingleQuotes;
    protected boolean writeDirect;
    protected boolean writeEnumUsingName;
    protected boolean writeEnumUsingToString;
    protected boolean writeNonStringValueAsString;
    private final Writer writer;

    public SerializeWriter() {
        this((Writer) null);
    }

    public SerializeWriter(Writer writer) {
        this(writer, JSON.DEFAULT_GENERATE_FEATURE, SerializerFeature.EMPTY);
    }

    public SerializeWriter(SerializerFeature... serializerFeatureArr) {
        this((Writer) null, serializerFeatureArr);
    }

    public SerializeWriter(Writer writer, SerializerFeature... serializerFeatureArr) {
        this(writer, 0, serializerFeatureArr);
    }

    public SerializeWriter(Writer writer, int i, SerializerFeature... serializerFeatureArr) {
        this.maxBufSize = -1;
        this.writer = writer;
        this.buf = bufLocal.get();
        if (this.buf != null) {
            bufLocal.set(null);
        } else {
            this.buf = new char[2048];
        }
        for (SerializerFeature serializerFeature : serializerFeatureArr) {
            i |= serializerFeature.getMask();
        }
        this.features = i;
        computeFeatures();
    }

    public int getMaxBufSize() {
        return this.maxBufSize;
    }

    public void setMaxBufSize(int i) {
        if (i < this.buf.length) {
            throw new JSONException("must > " + this.buf.length);
        }
        this.maxBufSize = i;
    }

    public int getBufferLength() {
        return this.buf.length;
    }

    public SerializeWriter(int i) {
        this((Writer) null, i);
    }

    public SerializeWriter(Writer writer, int i) {
        this.maxBufSize = -1;
        this.writer = writer;
        if (i <= 0) {
            throw new IllegalArgumentException("Negative initial size: " + i);
        }
        this.buf = new char[i];
        computeFeatures();
    }

    public void config(SerializerFeature serializerFeature, boolean z) {
        if (z) {
            this.features |= serializerFeature.getMask();
            if (serializerFeature == SerializerFeature.WriteEnumUsingToString) {
                this.features &= SerializerFeature.WriteEnumUsingName.getMask() ^ (-1);
            } else if (serializerFeature == SerializerFeature.WriteEnumUsingName) {
                this.features &= SerializerFeature.WriteEnumUsingToString.getMask() ^ (-1);
            }
        } else {
            this.features &= serializerFeature.getMask() ^ (-1);
        }
        computeFeatures();
    }

    protected void computeFeatures() {
        long j;
        this.quoteFieldNames = (this.features & SerializerFeature.QuoteFieldNames.mask) != 0;
        this.useSingleQuotes = (this.features & SerializerFeature.UseSingleQuotes.mask) != 0;
        this.sortField = (this.features & SerializerFeature.SortField.mask) != 0;
        this.disableCircularReferenceDetect = (this.features & SerializerFeature.DisableCircularReferenceDetect.mask) != 0;
        this.beanToArray = (this.features & SerializerFeature.BeanToArray.mask) != 0;
        this.writeNonStringValueAsString = (this.features & SerializerFeature.WriteNonStringValueAsString.mask) != 0;
        this.notWriteDefaultValue = (this.features & SerializerFeature.NotWriteDefaultValue.mask) != 0;
        this.writeEnumUsingName = (this.features & SerializerFeature.WriteEnumUsingName.mask) != 0;
        this.writeEnumUsingToString = (this.features & SerializerFeature.WriteEnumUsingToString.mask) != 0;
        this.writeDirect = this.quoteFieldNames && (this.features & nonDirectFeatures) == 0 && (this.beanToArray || this.writeEnumUsingName);
        this.keySeperator = this.useSingleQuotes ? '\'' : '\"';
        this.browserSecure = (this.features & SerializerFeature.BrowserSecure.mask) != 0;
        if (this.browserSecure) {
            j = 5764610843043954687L;
        } else {
            j = (this.features & SerializerFeature.WriteSlashAsSpecial.mask) != 0 ? 140758963191807L : 21474836479L;
        }
        this.sepcialBits = j;
    }

    public boolean isSortField() {
        return this.sortField;
    }

    public boolean isNotWriteDefaultValue() {
        return this.notWriteDefaultValue;
    }

    public boolean isEnabled(SerializerFeature serializerFeature) {
        return (this.features & serializerFeature.mask) != 0;
    }

    public boolean isEnabled(int i) {
        return (this.features & i) != 0;
    }

    @Override // java.io.Writer
    public void write(int i) {
        int i2 = this.count + 1;
        if (i2 > this.buf.length) {
            if (this.writer == null) {
                expandCapacity(i2);
            } else {
                flush();
                i2 = 1;
            }
        }
        this.buf[this.count] = (char) i;
        this.count = i2;
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i, int i2) {
        int i3;
        if (i < 0 || i > cArr.length || i2 < 0 || i + i2 > cArr.length || i + i2 < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (i2 != 0) {
            int i4 = this.count + i2;
            if (i4 <= this.buf.length) {
                i3 = i2;
                i2 = i4;
            } else if (this.writer == null) {
                expandCapacity(i4);
                i3 = i2;
                i2 = i4;
            } else {
                do {
                    int length = this.buf.length - this.count;
                    System.arraycopy(cArr, i, this.buf, this.count, length);
                    this.count = this.buf.length;
                    flush();
                    i2 -= length;
                    i += length;
                } while (i2 > this.buf.length);
                i3 = i2;
            }
            System.arraycopy(cArr, i, this.buf, this.count, i3);
            this.count = i2;
        }
    }

    public void expandCapacity(int i) {
        if (this.maxBufSize != -1 && i >= this.maxBufSize) {
            throw new JSONException("serialize exceeded MAX_OUTPUT_LENGTH=" + this.maxBufSize + ", minimumCapacity=" + i);
        }
        int length = this.buf.length + (this.buf.length >> 1) + 1;
        if (length >= i) {
            i = length;
        }
        char[] cArr = new char[i];
        System.arraycopy(this.buf, 0, cArr, 0, this.count);
        this.buf = cArr;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.io.Writer, java.lang.Appendable
    public SerializeWriter append(CharSequence charSequence) {
        String charSequence2 = charSequence == null ? "null" : charSequence.toString();
        write(charSequence2, 0, charSequence2.length());
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.io.Writer, java.lang.Appendable
    public SerializeWriter append(CharSequence charSequence, int i, int i2) {
        if (charSequence == null) {
            charSequence = "null";
        }
        String charSequence2 = charSequence.subSequence(i, i2).toString();
        write(charSequence2, 0, charSequence2.length());
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.io.Writer, java.lang.Appendable
    public SerializeWriter append(char c) {
        write(c);
        return this;
    }

    @Override // java.io.Writer
    public void write(String str, int i, int i2) {
        int i3;
        int i4 = this.count + i2;
        if (i4 <= this.buf.length) {
            i3 = i2;
            i2 = i4;
        } else if (this.writer == null) {
            expandCapacity(i4);
            i3 = i2;
            i2 = i4;
        } else {
            do {
                int length = this.buf.length - this.count;
                str.getChars(i, i + length, this.buf, this.count);
                this.count = this.buf.length;
                flush();
                i2 -= length;
                i += length;
            } while (i2 > this.buf.length);
            i3 = i2;
        }
        str.getChars(i, i3 + i, this.buf, this.count);
        this.count = i2;
    }

    public void writeTo(Writer writer) throws IOException {
        if (this.writer != null) {
            throw new UnsupportedOperationException("writer not null");
        }
        writer.write(this.buf, 0, this.count);
    }

    public void writeTo(OutputStream outputStream, String str) throws IOException {
        writeTo(outputStream, Charset.forName(str));
    }

    public void writeTo(OutputStream outputStream, Charset charset) throws IOException {
        writeToEx(outputStream, charset);
    }

    public int writeToEx(OutputStream outputStream, Charset charset) throws IOException {
        if (this.writer != null) {
            throw new UnsupportedOperationException("writer not null");
        }
        if (charset == IOUtils.UTF8) {
            return encodeToUTF8(outputStream);
        }
        byte[] bytes = new String(this.buf, 0, this.count).getBytes(charset);
        outputStream.write(bytes);
        return bytes.length;
    }

    public char[] toCharArray() {
        if (this.writer != null) {
            throw new UnsupportedOperationException("writer not null");
        }
        char[] cArr = new char[this.count];
        System.arraycopy(this.buf, 0, cArr, 0, this.count);
        return cArr;
    }

    public char[] toCharArrayForSpringWebSocket() {
        if (this.writer != null) {
            throw new UnsupportedOperationException("writer not null");
        }
        char[] cArr = new char[this.count - 2];
        System.arraycopy(this.buf, 1, cArr, 0, this.count - 2);
        return cArr;
    }

    public byte[] toBytes(String str) {
        return toBytes((str == null || "UTF-8".equals(str)) ? IOUtils.UTF8 : Charset.forName(str));
    }

    public byte[] toBytes(Charset charset) {
        if (this.writer != null) {
            throw new UnsupportedOperationException("writer not null");
        }
        return charset == IOUtils.UTF8 ? encodeToUTF8Bytes() : new String(this.buf, 0, this.count).getBytes(charset);
    }

    private int encodeToUTF8(OutputStream outputStream) throws IOException {
        int i = (int) (this.count * 3.0d);
        byte[] bArr = bytesBufLocal.get();
        if (bArr == null) {
            bArr = new byte[8192];
            bytesBufLocal.set(bArr);
        }
        if (bArr.length < i) {
            bArr = new byte[i];
        }
        int encodeUTF8 = IOUtils.encodeUTF8(this.buf, 0, this.count, bArr);
        outputStream.write(bArr, 0, encodeUTF8);
        return encodeUTF8;
    }

    private byte[] encodeToUTF8Bytes() {
        int i = (int) (this.count * 3.0d);
        byte[] bArr = bytesBufLocal.get();
        if (bArr == null) {
            bArr = new byte[8192];
            bytesBufLocal.set(bArr);
        }
        if (bArr.length < i) {
            bArr = new byte[i];
        }
        int encodeUTF8 = IOUtils.encodeUTF8(this.buf, 0, this.count, bArr);
        byte[] bArr2 = new byte[encodeUTF8];
        System.arraycopy(bArr, 0, bArr2, 0, encodeUTF8);
        return bArr2;
    }

    public int size() {
        return this.count;
    }

    public String toString() {
        return new String(this.buf, 0, this.count);
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.writer != null && this.count > 0) {
            flush();
        }
        if (this.buf.length <= 131072) {
            bufLocal.set(this.buf);
        }
        this.buf = null;
    }

    @Override // java.io.Writer
    public void write(String str) {
        if (str == null) {
            writeNull();
        } else {
            write(str, 0, str.length());
        }
    }

    public void writeInt(int i) {
        if (i == Integer.MIN_VALUE) {
            write("-2147483648");
            return;
        }
        int stringSize = i < 0 ? IOUtils.stringSize(-i) + 1 : IOUtils.stringSize(i);
        int i2 = this.count + stringSize;
        if (i2 > this.buf.length) {
            if (this.writer == null) {
                expandCapacity(i2);
            } else {
                char[] cArr = new char[stringSize];
                IOUtils.getChars(i, stringSize, cArr);
                write(cArr, 0, cArr.length);
                return;
            }
        }
        IOUtils.getChars(i, i2, this.buf);
        this.count = i2;
    }

    public void writeByteArray(byte[] bArr) {
        if (isEnabled(SerializerFeature.WriteClassName.mask)) {
            writeHex(bArr);
            return;
        }
        int length = bArr.length;
        char c = this.useSingleQuotes ? '\'' : '\"';
        if (length == 0) {
            write(this.useSingleQuotes ? "''" : "\"\"");
            return;
        }
        char[] cArr = IOUtils.CA;
        int i = (length / 3) * 3;
        int i2 = this.count;
        int i3 = ((((length - 1) / 3) + 1) << 2) + this.count + 2;
        if (i3 > this.buf.length) {
            if (this.writer != null) {
                write(c);
                int i4 = 0;
                while (i4 < i) {
                    int i5 = i4 + 1;
                    int i6 = i5 + 1;
                    int i7 = ((bArr[i5] & 255) << 8) | ((bArr[i4] & 255) << 16);
                    i4 = i6 + 1;
                    int i8 = i7 | (bArr[i6] & 255);
                    write(cArr[(i8 >>> 18) & 63]);
                    write(cArr[(i8 >>> 12) & 63]);
                    write(cArr[(i8 >>> 6) & 63]);
                    write(cArr[i8 & 63]);
                }
                int i9 = length - i;
                if (i9 > 0) {
                    int i10 = (i9 == 2 ? (bArr[length - 1] & 255) << 2 : 0) | ((bArr[i] & 255) << 10);
                    write(cArr[i10 >> 12]);
                    write(cArr[(i10 >>> 6) & 63]);
                    write(i9 == 2 ? cArr[i10 & 63] : '=');
                    write(61);
                }
                write(c);
                return;
            }
            expandCapacity(i3);
        }
        this.count = i3;
        int i11 = i2 + 1;
        this.buf[i2] = c;
        int i12 = 0;
        while (i12 < i) {
            int i13 = i12 + 1;
            int i14 = i13 + 1;
            int i15 = ((bArr[i13] & 255) << 8) | ((bArr[i12] & 255) << 16);
            i12 = i14 + 1;
            int i16 = i15 | (bArr[i14] & 255);
            int i17 = i11 + 1;
            this.buf[i11] = cArr[(i16 >>> 18) & 63];
            int i18 = i17 + 1;
            this.buf[i17] = cArr[(i16 >>> 12) & 63];
            int i19 = i18 + 1;
            this.buf[i18] = cArr[(i16 >>> 6) & 63];
            i11 = i19 + 1;
            this.buf[i19] = cArr[i16 & 63];
        }
        int i20 = length - i;
        if (i20 > 0) {
            int i21 = (i20 == 2 ? (bArr[length - 1] & 255) << 2 : 0) | ((bArr[i] & 255) << 10);
            this.buf[i3 - 5] = cArr[i21 >> 12];
            this.buf[i3 - 4] = cArr[(i21 >>> 6) & 63];
            this.buf[i3 - 3] = i20 == 2 ? cArr[i21 & 63] : '=';
            this.buf[i3 - 2] = '=';
        }
        this.buf[i3 - 1] = c;
    }

    public void writeHex(byte[] bArr) {
        int i = 0;
        int length = this.count + (bArr.length * 2) + 3;
        if (length > this.buf.length) {
            if (this.writer != null) {
                char[] cArr = new char[bArr.length + 3];
                cArr[0] = 'x';
                int i2 = 2;
                cArr[1] = '\'';
                while (i < bArr.length) {
                    int i3 = bArr[i] & 255;
                    int i4 = i3 >> 4;
                    int i5 = i3 & 15;
                    int i6 = i2 + 1;
                    cArr[i2] = (char) ((i4 < 10 ? 48 : 55) + i4);
                    i2 = i6 + 1;
                    cArr[i6] = (char) ((i5 < 10 ? 48 : 55) + i5);
                    i++;
                }
                int i7 = i2 + 1;
                cArr[i2] = '\'';
                try {
                    this.writer.write(cArr);
                    return;
                } catch (IOException e) {
                    throw new JSONException("writeBytes error.", e);
                }
            }
            expandCapacity(length);
        }
        char[] cArr2 = this.buf;
        int i8 = this.count;
        this.count = i8 + 1;
        cArr2[i8] = 'x';
        char[] cArr3 = this.buf;
        int i9 = this.count;
        this.count = i9 + 1;
        cArr3[i9] = '\'';
        while (i < bArr.length) {
            int i10 = bArr[i] & 255;
            int i11 = i10 >> 4;
            int i12 = i10 & 15;
            char[] cArr4 = this.buf;
            int i13 = this.count;
            this.count = i13 + 1;
            cArr4[i13] = (char) ((i11 < 10 ? 48 : 55) + i11);
            char[] cArr5 = this.buf;
            int i14 = this.count;
            this.count = i14 + 1;
            cArr5[i14] = (char) ((i12 < 10 ? 48 : 55) + i12);
            i++;
        }
        char[] cArr6 = this.buf;
        int i15 = this.count;
        this.count = i15 + 1;
        cArr6[i15] = '\'';
    }

    public void writeFloat(float f, boolean z) {
        if (Float.isNaN(f) || Float.isInfinite(f)) {
            writeNull();
            return;
        }
        String f2 = Float.toString(f);
        if (isEnabled(SerializerFeature.WriteNullNumberAsZero) && f2.endsWith(".0")) {
            f2 = f2.substring(0, f2.length() - 2);
        }
        write(f2);
        if (z && isEnabled(SerializerFeature.WriteClassName)) {
            write(70);
        }
    }

    public void writeDouble(double d, boolean z) {
        if (Double.isNaN(d) || Double.isInfinite(d)) {
            writeNull();
            return;
        }
        String d2 = Double.toString(d);
        if (isEnabled(SerializerFeature.WriteNullNumberAsZero) && d2.endsWith(".0")) {
            d2 = d2.substring(0, d2.length() - 2);
        }
        write(d2);
        if (z && isEnabled(SerializerFeature.WriteClassName)) {
            write(68);
        }
    }

    public void writeEnum(Enum<?> r3) {
        String str;
        if (r3 == null) {
            writeNull();
            return;
        }
        if (this.writeEnumUsingName && !this.writeEnumUsingToString) {
            str = r3.name();
        } else if (!this.writeEnumUsingToString) {
            str = null;
        } else {
            str = r3.toString();
        }
        if (str != null) {
            int i = isEnabled(SerializerFeature.UseSingleQuotes) ? 39 : 34;
            write(i);
            write(str);
            write(i);
            return;
        }
        writeInt(r3.ordinal());
    }

    public void writeLong(long j) {
        boolean z = isEnabled(SerializerFeature.BrowserCompatible) && !isEnabled(SerializerFeature.WriteClassName) && (j > 9007199254740991L || j < -9007199254740991L);
        if (j == Long.MIN_VALUE) {
            if (!z) {
                write("-9223372036854775808");
                return;
            } else {
                write("\"-9223372036854775808\"");
                return;
            }
        }
        int stringSize = j < 0 ? IOUtils.stringSize(-j) + 1 : IOUtils.stringSize(j);
        int i = this.count + stringSize;
        if (z) {
            i += 2;
        }
        if (i > this.buf.length) {
            if (this.writer == null) {
                expandCapacity(i);
            } else {
                char[] cArr = new char[stringSize];
                IOUtils.getChars(j, stringSize, cArr);
                if (z) {
                    write(34);
                    write(cArr, 0, cArr.length);
                    write(34);
                    return;
                }
                write(cArr, 0, cArr.length);
                return;
            }
        }
        if (z) {
            this.buf[this.count] = '\"';
            IOUtils.getChars(j, i - 1, this.buf);
            this.buf[i - 1] = '\"';
        } else {
            IOUtils.getChars(j, i, this.buf);
        }
        this.count = i;
    }

    public void writeNull() {
        write("null");
    }

    public void writeNull(SerializerFeature serializerFeature) {
        writeNull(0, serializerFeature.mask);
    }

    public void writeNull(int i, int i2) {
        if ((i & i2) == 0 && (this.features & i2) == 0) {
            writeNull();
        } else if (i2 == SerializerFeature.WriteNullListAsEmpty.mask) {
            write("[]");
        } else if (i2 == SerializerFeature.WriteNullStringAsEmpty.mask) {
            writeString("");
        } else if (i2 == SerializerFeature.WriteNullBooleanAsFalse.mask) {
            write("false");
        } else if (i2 == SerializerFeature.WriteNullNumberAsZero.mask) {
            write(48);
        } else {
            writeNull();
        }
    }

    public void writeStringWithDoubleQuote(String str, char c) {
        int i;
        int i2;
        int i3;
        char c2;
        int i4;
        if (str == null) {
            writeNull();
            if (c != 0) {
                write(c);
                return;
            }
            return;
        }
        int length = str.length();
        int i5 = this.count + length + 2;
        if (c != 0) {
            i5++;
        }
        if (i5 > this.buf.length) {
            if (this.writer != null) {
                write(34);
                for (int i6 = 0; i6 < str.length(); i6++) {
                    char charAt = str.charAt(i6);
                    if (isEnabled(SerializerFeature.BrowserSecure) && (charAt == '(' || charAt == ')' || charAt == '<' || charAt == '>')) {
                        write(92);
                        write(117);
                        write(IOUtils.DIGITS[(charAt >>> '\f') & 15]);
                        write(IOUtils.DIGITS[(charAt >>> '\b') & 15]);
                        write(IOUtils.DIGITS[(charAt >>> 4) & 15]);
                        write(IOUtils.DIGITS[charAt & 15]);
                    } else if (isEnabled(SerializerFeature.BrowserCompatible)) {
                        if (charAt == '\b' || charAt == '\f' || charAt == '\n' || charAt == '\r' || charAt == '\t' || charAt == '\"' || charAt == '/' || charAt == '\\') {
                            write(92);
                            write(IOUtils.replaceChars[charAt]);
                        } else if (charAt < ' ') {
                            write(92);
                            write(117);
                            write(48);
                            write(48);
                            write(IOUtils.ASCII_CHARS[charAt * 2]);
                            write(IOUtils.ASCII_CHARS[(charAt * 2) + 1]);
                        } else {
                            if (charAt >= 127) {
                                write(92);
                                write(117);
                                write(IOUtils.DIGITS[(charAt >>> '\f') & 15]);
                                write(IOUtils.DIGITS[(charAt >>> '\b') & 15]);
                                write(IOUtils.DIGITS[(charAt >>> 4) & 15]);
                                write(IOUtils.DIGITS[charAt & 15]);
                            }
                            write(charAt);
                        }
                    } else {
                        if ((charAt < IOUtils.specicalFlags_doubleQuotes.length && IOUtils.specicalFlags_doubleQuotes[charAt] != 0) || (charAt == '/' && isEnabled(SerializerFeature.WriteSlashAsSpecial))) {
                            write(92);
                            if (IOUtils.specicalFlags_doubleQuotes[charAt] == 4) {
                                write(117);
                                write(IOUtils.DIGITS[(charAt >>> '\f') & 15]);
                                write(IOUtils.DIGITS[(charAt >>> '\b') & 15]);
                                write(IOUtils.DIGITS[(charAt >>> 4) & 15]);
                                write(IOUtils.DIGITS[charAt & 15]);
                            } else {
                                write(IOUtils.replaceChars[charAt]);
                            }
                        }
                        write(charAt);
                    }
                }
                write(34);
                if (c != 0) {
                    write(c);
                    return;
                }
                return;
            }
            expandCapacity(i5);
        }
        int i7 = this.count + 1;
        int i8 = i7 + length;
        this.buf[this.count] = '\"';
        str.getChars(0, length, this.buf, i7);
        this.count = i5;
        if (isEnabled(SerializerFeature.BrowserCompatible)) {
            int i9 = i5;
            int i10 = -1;
            for (int i11 = i7; i11 < i8; i11++) {
                char c3 = this.buf[i11];
                if (c3 == '\"' || c3 == '/' || c3 == '\\') {
                    i9++;
                    i10 = i11;
                } else if (c3 == '\b' || c3 == '\f' || c3 == '\n' || c3 == '\r' || c3 == '\t') {
                    i9++;
                    i10 = i11;
                } else if (c3 < ' ') {
                    i9 += 5;
                    i10 = i11;
                } else if (c3 >= 127) {
                    i9 += 5;
                    i10 = i11;
                }
            }
            if (i9 > this.buf.length) {
                expandCapacity(i9);
            }
            this.count = i9;
            int i12 = i8;
            for (int i13 = i10; i13 >= i7; i13--) {
                char c4 = this.buf[i13];
                if (c4 == '\b' || c4 == '\f' || c4 == '\n' || c4 == '\r' || c4 == '\t') {
                    System.arraycopy(this.buf, i13 + 1, this.buf, i13 + 2, (i12 - i13) - 1);
                    this.buf[i13] = '\\';
                    this.buf[i13 + 1] = IOUtils.replaceChars[c4];
                    i12++;
                } else if (c4 == '\"' || c4 == '/' || c4 == '\\') {
                    System.arraycopy(this.buf, i13 + 1, this.buf, i13 + 2, (i12 - i13) - 1);
                    this.buf[i13] = '\\';
                    this.buf[i13 + 1] = c4;
                    i12++;
                } else if (c4 < ' ') {
                    System.arraycopy(this.buf, i13 + 1, this.buf, i13 + 6, (i12 - i13) - 1);
                    this.buf[i13] = '\\';
                    this.buf[i13 + 1] = 'u';
                    this.buf[i13 + 2] = '0';
                    this.buf[i13 + 3] = '0';
                    this.buf[i13 + 4] = IOUtils.ASCII_CHARS[c4 * 2];
                    this.buf[i13 + 5] = IOUtils.ASCII_CHARS[(c4 * 2) + 1];
                    i12 += 5;
                } else if (c4 >= 127) {
                    System.arraycopy(this.buf, i13 + 1, this.buf, i13 + 6, (i12 - i13) - 1);
                    this.buf[i13] = '\\';
                    this.buf[i13 + 1] = 'u';
                    this.buf[i13 + 2] = IOUtils.DIGITS[(c4 >>> '\f') & 15];
                    this.buf[i13 + 3] = IOUtils.DIGITS[(c4 >>> '\b') & 15];
                    this.buf[i13 + 4] = IOUtils.DIGITS[(c4 >>> 4) & 15];
                    this.buf[i13 + 5] = IOUtils.DIGITS[c4 & 15];
                    i12 += 5;
                }
            }
            if (c != 0) {
                this.buf[this.count - 2] = '\"';
                this.buf[this.count - 1] = c;
                return;
            }
            this.buf[this.count - 1] = '\"';
            return;
        }
        int i14 = 0;
        int i15 = -1;
        char c5 = 0;
        int i16 = i5;
        int i17 = -1;
        int i18 = i7;
        while (i18 < i8) {
            char c6 = this.buf[i18];
            if (c6 >= ']') {
                if (c6 >= 127 && (c6 == 8232 || c6 == 8233 || c6 < 160)) {
                    if (i17 == -1) {
                        i17 = i18;
                    }
                    int i19 = i14 + 1;
                    i = i16 + 4;
                    i2 = i19;
                    i3 = i17;
                    c2 = c6;
                    i4 = i18;
                }
                i4 = i15;
                i2 = i14;
                i = i16;
                int i20 = i17;
                c2 = c5;
                i3 = i20;
            } else {
                if ((c6 < '@' && (this.sepcialBits & (1 << c6)) != 0) || c6 == '\\') {
                    int i21 = i14 + 1;
                    int i22 = (c6 == '(' || c6 == ')' || c6 == '<' || c6 == '>' || (c6 < IOUtils.specicalFlags_doubleQuotes.length && IOUtils.specicalFlags_doubleQuotes[c6] == 4)) ? i16 + 4 : i16;
                    if (i17 == -1) {
                        c2 = c6;
                        i = i22;
                        i4 = i18;
                        i2 = i21;
                        i3 = i18;
                    } else {
                        i = i22;
                        i2 = i21;
                        i3 = i17;
                        c2 = c6;
                        i4 = i18;
                    }
                }
                i4 = i15;
                i2 = i14;
                i = i16;
                int i202 = i17;
                c2 = c5;
                i3 = i202;
            }
            i18++;
            i16 = i;
            i14 = i2;
            i15 = i4;
            int i23 = i3;
            c5 = c2;
            i17 = i23;
        }
        if (i14 > 0) {
            int i24 = i16 + i14;
            if (i24 > this.buf.length) {
                expandCapacity(i24);
            }
            this.count = i24;
            if (i14 == 1) {
                if (c5 == 8232) {
                    System.arraycopy(this.buf, i15 + 1, this.buf, i15 + 6, (i8 - i15) - 1);
                    this.buf[i15] = '\\';
                    int i25 = i15 + 1;
                    this.buf[i25] = 'u';
                    int i26 = i25 + 1;
                    this.buf[i26] = '2';
                    int i27 = i26 + 1;
                    this.buf[i27] = '0';
                    int i28 = i27 + 1;
                    this.buf[i28] = '2';
                    this.buf[i28 + 1] = '8';
                } else if (c5 == 8233) {
                    System.arraycopy(this.buf, i15 + 1, this.buf, i15 + 6, (i8 - i15) - 1);
                    this.buf[i15] = '\\';
                    int i29 = i15 + 1;
                    this.buf[i29] = 'u';
                    int i30 = i29 + 1;
                    this.buf[i30] = '2';
                    int i31 = i30 + 1;
                    this.buf[i31] = '0';
                    int i32 = i31 + 1;
                    this.buf[i32] = '2';
                    this.buf[i32 + 1] = '9';
                } else if (c5 == '(' || c5 == ')' || c5 == '<' || c5 == '>') {
                    System.arraycopy(this.buf, i15 + 1, this.buf, i15 + 6, (i8 - i15) - 1);
                    this.buf[i15] = '\\';
                    int i33 = i15 + 1;
                    this.buf[i33] = 'u';
                    int i34 = i33 + 1;
                    this.buf[i34] = IOUtils.DIGITS[(c5 >>> '\f') & 15];
                    int i35 = i34 + 1;
                    this.buf[i35] = IOUtils.DIGITS[(c5 >>> '\b') & 15];
                    int i36 = i35 + 1;
                    this.buf[i36] = IOUtils.DIGITS[(c5 >>> 4) & 15];
                    this.buf[i36 + 1] = IOUtils.DIGITS[c5 & 15];
                } else if (c5 < IOUtils.specicalFlags_doubleQuotes.length && IOUtils.specicalFlags_doubleQuotes[c5] == 4) {
                    System.arraycopy(this.buf, i15 + 1, this.buf, i15 + 6, (i8 - i15) - 1);
                    int i37 = i15 + 1;
                    this.buf[i15] = '\\';
                    int i38 = i37 + 1;
                    this.buf[i37] = 'u';
                    int i39 = i38 + 1;
                    this.buf[i38] = IOUtils.DIGITS[(c5 >>> '\f') & 15];
                    int i40 = i39 + 1;
                    this.buf[i39] = IOUtils.DIGITS[(c5 >>> '\b') & 15];
                    int i41 = i40 + 1;
                    this.buf[i40] = IOUtils.DIGITS[(c5 >>> 4) & 15];
                    int i42 = i41 + 1;
                    this.buf[i41] = IOUtils.DIGITS[c5 & 15];
                } else {
                    System.arraycopy(this.buf, i15 + 1, this.buf, i15 + 2, (i8 - i15) - 1);
                    this.buf[i15] = '\\';
                    this.buf[i15 + 1] = IOUtils.replaceChars[c5];
                }
            } else if (i14 > 1) {
                int i43 = i8;
                int i44 = i17;
                int i45 = i44;
                for (int i46 = i17 - i7; i46 < str.length(); i46++) {
                    char charAt2 = str.charAt(i46);
                    if (this.browserSecure && (charAt2 == '(' || charAt2 == ')' || charAt2 == '<' || charAt2 == '>')) {
                        int i47 = i45 + 1;
                        this.buf[i45] = '\\';
                        int i48 = i47 + 1;
                        this.buf[i47] = 'u';
                        int i49 = i48 + 1;
                        this.buf[i48] = IOUtils.DIGITS[(charAt2 >>> '\f') & 15];
                        int i50 = i49 + 1;
                        this.buf[i49] = IOUtils.DIGITS[(charAt2 >>> '\b') & 15];
                        int i51 = i50 + 1;
                        this.buf[i50] = IOUtils.DIGITS[(charAt2 >>> 4) & 15];
                        i45 = i51 + 1;
                        this.buf[i51] = IOUtils.DIGITS[charAt2 & 15];
                        i43 += 5;
                    } else if ((charAt2 < IOUtils.specicalFlags_doubleQuotes.length && IOUtils.specicalFlags_doubleQuotes[charAt2] != 0) || (charAt2 == '/' && isEnabled(SerializerFeature.WriteSlashAsSpecial))) {
                        int i52 = i45 + 1;
                        this.buf[i45] = '\\';
                        if (IOUtils.specicalFlags_doubleQuotes[charAt2] == 4) {
                            int i53 = i52 + 1;
                            this.buf[i52] = 'u';
                            int i54 = i53 + 1;
                            this.buf[i53] = IOUtils.DIGITS[(charAt2 >>> '\f') & 15];
                            int i55 = i54 + 1;
                            this.buf[i54] = IOUtils.DIGITS[(charAt2 >>> '\b') & 15];
                            int i56 = i55 + 1;
                            this.buf[i55] = IOUtils.DIGITS[(charAt2 >>> 4) & 15];
                            i45 = i56 + 1;
                            this.buf[i56] = IOUtils.DIGITS[charAt2 & 15];
                            i43 += 5;
                        } else {
                            i45 = i52 + 1;
                            this.buf[i52] = IOUtils.replaceChars[charAt2];
                            i43++;
                        }
                    } else if (charAt2 == 8232 || charAt2 == 8233) {
                        int i57 = i45 + 1;
                        this.buf[i45] = '\\';
                        int i58 = i57 + 1;
                        this.buf[i57] = 'u';
                        int i59 = i58 + 1;
                        this.buf[i58] = IOUtils.DIGITS[(charAt2 >>> '\f') & 15];
                        int i60 = i59 + 1;
                        this.buf[i59] = IOUtils.DIGITS[(charAt2 >>> '\b') & 15];
                        int i61 = i60 + 1;
                        this.buf[i60] = IOUtils.DIGITS[(charAt2 >>> 4) & 15];
                        i45 = i61 + 1;
                        this.buf[i61] = IOUtils.DIGITS[charAt2 & 15];
                        i43 += 5;
                    } else {
                        this.buf[i45] = charAt2;
                        i45++;
                    }
                }
            }
        }
        if (c != 0) {
            this.buf[this.count - 2] = '\"';
            this.buf[this.count - 1] = c;
            return;
        }
        this.buf[this.count - 1] = '\"';
    }

    public void writeStringWithDoubleQuote(char[] cArr, char c) {
        int i;
        int i2;
        int i3;
        char c2;
        int i4;
        if (cArr == null) {
            writeNull();
            if (c != 0) {
                write(c);
                return;
            }
            return;
        }
        int length = cArr.length;
        int i5 = this.count + length + 2;
        if (c != 0) {
            i5++;
        }
        if (i5 > this.buf.length) {
            if (this.writer != null) {
                write(34);
                for (char c3 : cArr) {
                    if (isEnabled(SerializerFeature.BrowserSecure) && (c3 == '(' || c3 == ')' || c3 == '<' || c3 == '>')) {
                        write(92);
                        write(117);
                        write(IOUtils.DIGITS[(c3 >>> '\f') & 15]);
                        write(IOUtils.DIGITS[(c3 >>> '\b') & 15]);
                        write(IOUtils.DIGITS[(c3 >>> 4) & 15]);
                        write(IOUtils.DIGITS[c3 & 15]);
                    } else if (isEnabled(SerializerFeature.BrowserCompatible)) {
                        if (c3 == '\b' || c3 == '\f' || c3 == '\n' || c3 == '\r' || c3 == '\t' || c3 == '\"' || c3 == '/' || c3 == '\\') {
                            write(92);
                            write(IOUtils.replaceChars[c3]);
                        } else if (c3 < ' ') {
                            write(92);
                            write(117);
                            write(48);
                            write(48);
                            write(IOUtils.ASCII_CHARS[c3 * 2]);
                            write(IOUtils.ASCII_CHARS[(c3 * 2) + 1]);
                        } else {
                            if (c3 >= 127) {
                                write(92);
                                write(117);
                                write(IOUtils.DIGITS[(c3 >>> '\f') & 15]);
                                write(IOUtils.DIGITS[(c3 >>> '\b') & 15]);
                                write(IOUtils.DIGITS[(c3 >>> 4) & 15]);
                                write(IOUtils.DIGITS[c3 & 15]);
                            }
                            write(c3);
                        }
                    } else {
                        if ((c3 < IOUtils.specicalFlags_doubleQuotes.length && IOUtils.specicalFlags_doubleQuotes[c3] != 0) || (c3 == '/' && isEnabled(SerializerFeature.WriteSlashAsSpecial))) {
                            write(92);
                            if (IOUtils.specicalFlags_doubleQuotes[c3] == 4) {
                                write(117);
                                write(IOUtils.DIGITS[(c3 >>> '\f') & 15]);
                                write(IOUtils.DIGITS[(c3 >>> '\b') & 15]);
                                write(IOUtils.DIGITS[(c3 >>> 4) & 15]);
                                write(IOUtils.DIGITS[c3 & 15]);
                            } else {
                                write(IOUtils.replaceChars[c3]);
                            }
                        }
                        write(c3);
                    }
                }
                write(34);
                if (c != 0) {
                    write(c);
                    return;
                }
                return;
            }
            expandCapacity(i5);
        }
        int i6 = this.count + 1;
        int i7 = i6 + length;
        this.buf[this.count] = '\"';
        System.arraycopy(cArr, 0, this.buf, i6, cArr.length);
        this.count = i5;
        if (isEnabled(SerializerFeature.BrowserCompatible)) {
            int i8 = i5;
            int i9 = -1;
            for (int i10 = i6; i10 < i7; i10++) {
                char c4 = this.buf[i10];
                if (c4 == '\"' || c4 == '/' || c4 == '\\') {
                    i8++;
                    i9 = i10;
                } else if (c4 == '\b' || c4 == '\f' || c4 == '\n' || c4 == '\r' || c4 == '\t') {
                    i8++;
                    i9 = i10;
                } else if (c4 < ' ') {
                    i8 += 5;
                    i9 = i10;
                } else if (c4 >= 127) {
                    i8 += 5;
                    i9 = i10;
                }
            }
            if (i8 > this.buf.length) {
                expandCapacity(i8);
            }
            this.count = i8;
            int i11 = i7;
            for (int i12 = i9; i12 >= i6; i12--) {
                char c5 = this.buf[i12];
                if (c5 == '\b' || c5 == '\f' || c5 == '\n' || c5 == '\r' || c5 == '\t') {
                    System.arraycopy(this.buf, i12 + 1, this.buf, i12 + 2, (i11 - i12) - 1);
                    this.buf[i12] = '\\';
                    this.buf[i12 + 1] = IOUtils.replaceChars[c5];
                    i11++;
                } else if (c5 == '\"' || c5 == '/' || c5 == '\\') {
                    System.arraycopy(this.buf, i12 + 1, this.buf, i12 + 2, (i11 - i12) - 1);
                    this.buf[i12] = '\\';
                    this.buf[i12 + 1] = c5;
                    i11++;
                } else if (c5 < ' ') {
                    System.arraycopy(this.buf, i12 + 1, this.buf, i12 + 6, (i11 - i12) - 1);
                    this.buf[i12] = '\\';
                    this.buf[i12 + 1] = 'u';
                    this.buf[i12 + 2] = '0';
                    this.buf[i12 + 3] = '0';
                    this.buf[i12 + 4] = IOUtils.ASCII_CHARS[c5 * 2];
                    this.buf[i12 + 5] = IOUtils.ASCII_CHARS[(c5 * 2) + 1];
                    i11 += 5;
                } else if (c5 >= 127) {
                    System.arraycopy(this.buf, i12 + 1, this.buf, i12 + 6, (i11 - i12) - 1);
                    this.buf[i12] = '\\';
                    this.buf[i12 + 1] = 'u';
                    this.buf[i12 + 2] = IOUtils.DIGITS[(c5 >>> '\f') & 15];
                    this.buf[i12 + 3] = IOUtils.DIGITS[(c5 >>> '\b') & 15];
                    this.buf[i12 + 4] = IOUtils.DIGITS[(c5 >>> 4) & 15];
                    this.buf[i12 + 5] = IOUtils.DIGITS[c5 & 15];
                    i11 += 5;
                }
            }
            if (c != 0) {
                this.buf[this.count - 2] = '\"';
                this.buf[this.count - 1] = c;
                return;
            }
            this.buf[this.count - 1] = '\"';
            return;
        }
        int i13 = 0;
        int i14 = -1;
        char c6 = 0;
        int i15 = i5;
        int i16 = -1;
        int i17 = i6;
        while (i17 < i7) {
            char c7 = this.buf[i17];
            if (c7 >= ']') {
                if (c7 >= 127 && (c7 == 8232 || c7 == 8233 || c7 < 160)) {
                    if (i16 == -1) {
                        i16 = i17;
                    }
                    int i18 = i13 + 1;
                    i = i15 + 4;
                    i2 = i18;
                    i3 = i16;
                    c2 = c7;
                    i4 = i17;
                }
                i4 = i14;
                i2 = i13;
                i = i15;
                int i19 = i16;
                c2 = c6;
                i3 = i19;
            } else {
                if ((c7 < '@' && (this.sepcialBits & (1 << c7)) != 0) || c7 == '\\') {
                    int i20 = i13 + 1;
                    int i21 = (c7 == '(' || c7 == ')' || c7 == '<' || c7 == '>' || (c7 < IOUtils.specicalFlags_doubleQuotes.length && IOUtils.specicalFlags_doubleQuotes[c7] == 4)) ? i15 + 4 : i15;
                    if (i16 == -1) {
                        c2 = c7;
                        i = i21;
                        i4 = i17;
                        i2 = i20;
                        i3 = i17;
                    } else {
                        i = i21;
                        i2 = i20;
                        i3 = i16;
                        c2 = c7;
                        i4 = i17;
                    }
                }
                i4 = i14;
                i2 = i13;
                i = i15;
                int i192 = i16;
                c2 = c6;
                i3 = i192;
            }
            i17++;
            i15 = i;
            i13 = i2;
            i14 = i4;
            int i22 = i3;
            c6 = c2;
            i16 = i22;
        }
        if (i13 > 0) {
            int i23 = i15 + i13;
            if (i23 > this.buf.length) {
                expandCapacity(i23);
            }
            this.count = i23;
            if (i13 == 1) {
                if (c6 == 8232) {
                    System.arraycopy(this.buf, i14 + 1, this.buf, i14 + 6, (i7 - i14) - 1);
                    this.buf[i14] = '\\';
                    int i24 = i14 + 1;
                    this.buf[i24] = 'u';
                    int i25 = i24 + 1;
                    this.buf[i25] = '2';
                    int i26 = i25 + 1;
                    this.buf[i26] = '0';
                    int i27 = i26 + 1;
                    this.buf[i27] = '2';
                    this.buf[i27 + 1] = '8';
                } else if (c6 == 8233) {
                    System.arraycopy(this.buf, i14 + 1, this.buf, i14 + 6, (i7 - i14) - 1);
                    this.buf[i14] = '\\';
                    int i28 = i14 + 1;
                    this.buf[i28] = 'u';
                    int i29 = i28 + 1;
                    this.buf[i29] = '2';
                    int i30 = i29 + 1;
                    this.buf[i30] = '0';
                    int i31 = i30 + 1;
                    this.buf[i31] = '2';
                    this.buf[i31 + 1] = '9';
                } else if (c6 == '(' || c6 == ')' || c6 == '<' || c6 == '>') {
                    System.arraycopy(this.buf, i14 + 1, this.buf, i14 + 6, (i7 - i14) - 1);
                    this.buf[i14] = '\\';
                    int i32 = i14 + 1;
                    this.buf[i32] = 'u';
                    int i33 = i32 + 1;
                    this.buf[i33] = IOUtils.DIGITS[(c6 >>> '\f') & 15];
                    int i34 = i33 + 1;
                    this.buf[i34] = IOUtils.DIGITS[(c6 >>> '\b') & 15];
                    int i35 = i34 + 1;
                    this.buf[i35] = IOUtils.DIGITS[(c6 >>> 4) & 15];
                    this.buf[i35 + 1] = IOUtils.DIGITS[c6 & 15];
                } else if (c6 < IOUtils.specicalFlags_doubleQuotes.length && IOUtils.specicalFlags_doubleQuotes[c6] == 4) {
                    System.arraycopy(this.buf, i14 + 1, this.buf, i14 + 6, (i7 - i14) - 1);
                    int i36 = i14 + 1;
                    this.buf[i14] = '\\';
                    int i37 = i36 + 1;
                    this.buf[i36] = 'u';
                    int i38 = i37 + 1;
                    this.buf[i37] = IOUtils.DIGITS[(c6 >>> '\f') & 15];
                    int i39 = i38 + 1;
                    this.buf[i38] = IOUtils.DIGITS[(c6 >>> '\b') & 15];
                    int i40 = i39 + 1;
                    this.buf[i39] = IOUtils.DIGITS[(c6 >>> 4) & 15];
                    int i41 = i40 + 1;
                    this.buf[i40] = IOUtils.DIGITS[c6 & 15];
                } else {
                    System.arraycopy(this.buf, i14 + 1, this.buf, i14 + 2, (i7 - i14) - 1);
                    this.buf[i14] = '\\';
                    this.buf[i14 + 1] = IOUtils.replaceChars[c6];
                }
            } else if (i13 > 1) {
                int i42 = i7;
                int i43 = i16;
                int i44 = i43;
                for (int i45 = i16 - i6; i45 < cArr.length; i45++) {
                    char c8 = cArr[i45];
                    if (this.browserSecure && (c8 == '(' || c8 == ')' || c8 == '<' || c8 == '>')) {
                        int i46 = i44 + 1;
                        this.buf[i44] = '\\';
                        int i47 = i46 + 1;
                        this.buf[i46] = 'u';
                        int i48 = i47 + 1;
                        this.buf[i47] = IOUtils.DIGITS[(c8 >>> '\f') & 15];
                        int i49 = i48 + 1;
                        this.buf[i48] = IOUtils.DIGITS[(c8 >>> '\b') & 15];
                        int i50 = i49 + 1;
                        this.buf[i49] = IOUtils.DIGITS[(c8 >>> 4) & 15];
                        i44 = i50 + 1;
                        this.buf[i50] = IOUtils.DIGITS[c8 & 15];
                        i42 += 5;
                    } else if ((c8 < IOUtils.specicalFlags_doubleQuotes.length && IOUtils.specicalFlags_doubleQuotes[c8] != 0) || (c8 == '/' && isEnabled(SerializerFeature.WriteSlashAsSpecial))) {
                        int i51 = i44 + 1;
                        this.buf[i44] = '\\';
                        if (IOUtils.specicalFlags_doubleQuotes[c8] == 4) {
                            int i52 = i51 + 1;
                            this.buf[i51] = 'u';
                            int i53 = i52 + 1;
                            this.buf[i52] = IOUtils.DIGITS[(c8 >>> '\f') & 15];
                            int i54 = i53 + 1;
                            this.buf[i53] = IOUtils.DIGITS[(c8 >>> '\b') & 15];
                            int i55 = i54 + 1;
                            this.buf[i54] = IOUtils.DIGITS[(c8 >>> 4) & 15];
                            i44 = i55 + 1;
                            this.buf[i55] = IOUtils.DIGITS[c8 & 15];
                            i42 += 5;
                        } else {
                            i44 = i51 + 1;
                            this.buf[i51] = IOUtils.replaceChars[c8];
                            i42++;
                        }
                    } else if (c8 == 8232 || c8 == 8233) {
                        int i56 = i44 + 1;
                        this.buf[i44] = '\\';
                        int i57 = i56 + 1;
                        this.buf[i56] = 'u';
                        int i58 = i57 + 1;
                        this.buf[i57] = IOUtils.DIGITS[(c8 >>> '\f') & 15];
                        int i59 = i58 + 1;
                        this.buf[i58] = IOUtils.DIGITS[(c8 >>> '\b') & 15];
                        int i60 = i59 + 1;
                        this.buf[i59] = IOUtils.DIGITS[(c8 >>> 4) & 15];
                        i44 = i60 + 1;
                        this.buf[i60] = IOUtils.DIGITS[c8 & 15];
                        i42 += 5;
                    } else {
                        this.buf[i44] = c8;
                        i44++;
                    }
                }
            }
        }
        if (c != 0) {
            this.buf[this.count - 2] = '\"';
            this.buf[this.count - 1] = c;
            return;
        }
        this.buf[this.count - 1] = '\"';
    }

    public void writeFieldNameDirect(String str) {
        int length = str.length();
        int i = this.count + length + 3;
        if (i > this.buf.length) {
            expandCapacity(i);
        }
        this.buf[this.count] = '\"';
        str.getChars(0, length, this.buf, this.count + 1);
        this.count = i;
        this.buf[this.count - 2] = '\"';
        this.buf[this.count - 1] = ':';
    }

    public void write(List<String> list) {
        boolean z;
        int i;
        if (list.isEmpty()) {
            write("[]");
            return;
        }
        int i2 = this.count;
        int size = list.size();
        int i3 = 0;
        int i4 = i2;
        while (i3 < size) {
            String str = list.get(i3);
            if (str != null) {
                int length = str.length();
                z = false;
                for (int i5 = 0; i5 < length; i5++) {
                    char charAt = str.charAt(i5);
                    z = charAt < ' ' || charAt > '~' || charAt == '\"' || charAt == '\\';
                    if (z) {
                        break;
                    }
                }
            } else {
                z = true;
            }
            if (z) {
                this.count = i2;
                write(91);
                for (int i6 = 0; i6 < list.size(); i6++) {
                    String str2 = list.get(i6);
                    if (i6 != 0) {
                        write(44);
                    }
                    if (str2 == null) {
                        write("null");
                    } else {
                        writeStringWithDoubleQuote(str2, (char) 0);
                    }
                }
                write(93);
                return;
            }
            int length2 = str.length() + i4 + 3;
            if (i3 == list.size() - 1) {
                length2++;
            }
            if (length2 > this.buf.length) {
                this.count = i4;
                expandCapacity(length2);
            }
            if (i3 == 0) {
                i = i4 + 1;
                this.buf[i4] = '[';
            } else {
                i = i4 + 1;
                this.buf[i4] = ',';
            }
            int i7 = i + 1;
            this.buf[i] = '\"';
            str.getChars(0, str.length(), this.buf, i7);
            int length3 = str.length() + i7;
            this.buf[length3] = '\"';
            i3++;
            i4 = length3 + 1;
        }
        this.buf[i4] = ']';
        this.count = i4 + 1;
    }

    public void writeFieldValue(char c, String str, char c2) {
        write(c);
        writeFieldName(str);
        if (c2 == 0) {
            writeString("\u0000");
        } else {
            writeString(Character.toString(c2));
        }
    }

    public void writeFieldValue(char c, String str, boolean z) {
        if (!this.quoteFieldNames) {
            write(c);
            writeFieldName(str);
            write(z);
            return;
        }
        int i = z ? 4 : 5;
        int length = str.length();
        int i2 = i + this.count + length + 4;
        if (i2 > this.buf.length) {
            if (this.writer != null) {
                write(c);
                writeString(str);
                write(58);
                write(z);
                return;
            }
            expandCapacity(i2);
        }
        int i3 = this.count;
        this.count = i2;
        this.buf[i3] = c;
        int i4 = i3 + length + 1;
        this.buf[i3 + 1] = this.keySeperator;
        str.getChars(0, length, this.buf, i3 + 2);
        this.buf[i4 + 1] = this.keySeperator;
        if (z) {
            System.arraycopy(":true".toCharArray(), 0, this.buf, i4 + 2, 5);
        } else {
            System.arraycopy(":false".toCharArray(), 0, this.buf, i4 + 2, 6);
        }
    }

    public void write(boolean z) {
        if (z) {
            write("true");
        } else {
            write("false");
        }
    }

    public void writeFieldValue(char c, String str, int i) {
        if (i == Integer.MIN_VALUE || !this.quoteFieldNames) {
            write(c);
            writeFieldName(str);
            writeInt(i);
            return;
        }
        int stringSize = i < 0 ? IOUtils.stringSize(-i) + 1 : IOUtils.stringSize(i);
        int length = str.length();
        int i2 = stringSize + this.count + length + 4;
        if (i2 > this.buf.length) {
            if (this.writer != null) {
                write(c);
                writeFieldName(str);
                writeInt(i);
                return;
            }
            expandCapacity(i2);
        }
        int i3 = this.count;
        this.count = i2;
        this.buf[i3] = c;
        int i4 = i3 + length + 1;
        this.buf[i3 + 1] = this.keySeperator;
        str.getChars(0, length, this.buf, i3 + 2);
        this.buf[i4 + 1] = this.keySeperator;
        this.buf[i4 + 2] = ':';
        IOUtils.getChars(i, this.count, this.buf);
    }

    public void writeFieldValue(char c, String str, long j) {
        if (j == Long.MIN_VALUE || !this.quoteFieldNames) {
            write(c);
            writeFieldName(str);
            writeLong(j);
            return;
        }
        int stringSize = j < 0 ? IOUtils.stringSize(-j) + 1 : IOUtils.stringSize(j);
        int length = str.length();
        int i = stringSize + this.count + length + 4;
        if (i > this.buf.length) {
            if (this.writer != null) {
                write(c);
                writeFieldName(str);
                writeLong(j);
                return;
            }
            expandCapacity(i);
        }
        int i2 = this.count;
        this.count = i;
        this.buf[i2] = c;
        int i3 = i2 + length + 1;
        this.buf[i2 + 1] = this.keySeperator;
        str.getChars(0, length, this.buf, i2 + 2);
        this.buf[i3 + 1] = this.keySeperator;
        this.buf[i3 + 2] = ':';
        IOUtils.getChars(j, this.count, this.buf);
    }

    public void writeFieldValue(char c, String str, float f) {
        write(c);
        writeFieldName(str);
        writeFloat(f, false);
    }

    public void writeFieldValue(char c, String str, double d) {
        write(c);
        writeFieldName(str);
        writeDouble(d, false);
    }

    public void writeFieldValue(char c, String str, String str2) {
        if (this.quoteFieldNames) {
            if (this.useSingleQuotes) {
                write(c);
                writeFieldName(str);
                if (str2 == null) {
                    writeNull();
                    return;
                } else {
                    writeString(str2);
                    return;
                }
            } else if (isEnabled(SerializerFeature.BrowserCompatible)) {
                write(c);
                writeStringWithDoubleQuote(str, ':');
                writeStringWithDoubleQuote(str2, (char) 0);
                return;
            } else {
                writeFieldValueStringWithDoubleQuoteCheck(c, str, str2);
                return;
            }
        }
        write(c);
        writeFieldName(str);
        if (str2 == null) {
            writeNull();
        } else {
            writeString(str2);
        }
    }

    public void writeFieldValueStringWithDoubleQuoteCheck(char c, String str, String str2) {
        int length;
        int i;
        int i2;
        int i3;
        int i4;
        char c2;
        int i5;
        int length2 = str.length();
        int i6 = this.count;
        if (str2 == null) {
            length = 4;
            i = i6 + length2 + 8;
        } else {
            length = str2.length();
            i = i6 + length2 + length + 6;
        }
        if (i > this.buf.length) {
            if (this.writer != null) {
                write(c);
                writeStringWithDoubleQuote(str, ':');
                writeStringWithDoubleQuote(str2, (char) 0);
                return;
            }
            expandCapacity(i);
        }
        this.buf[this.count] = c;
        int i7 = this.count + 2;
        int i8 = i7 + length2;
        this.buf[this.count + 1] = '\"';
        str.getChars(0, length2, this.buf, i7);
        this.count = i;
        this.buf[i8] = '\"';
        int i9 = i8 + 1;
        int i10 = i9 + 1;
        this.buf[i9] = ':';
        if (str2 == null) {
            int i11 = i10 + 1;
            this.buf[i10] = 'n';
            int i12 = i11 + 1;
            this.buf[i11] = 'u';
            int i13 = i12 + 1;
            this.buf[i12] = 'l';
            int i14 = i13 + 1;
            this.buf[i13] = 'l';
            return;
        }
        int i15 = i10 + 1;
        this.buf[i10] = '\"';
        int i16 = i15 + length;
        str2.getChars(0, length, this.buf, i15);
        int i17 = 0;
        int i18 = -1;
        char c3 = 0;
        int i19 = i;
        int i20 = -1;
        int i21 = i15;
        while (i21 < i16) {
            char c4 = this.buf[i21];
            if (c4 >= ']') {
                if (c4 >= 127 && (c4 == 8232 || c4 == 8233 || c4 < 160)) {
                    if (i20 == -1) {
                        i20 = i21;
                    }
                    int i22 = i17 + 1;
                    i2 = i19 + 4;
                    i3 = i22;
                    i4 = i20;
                    c2 = c4;
                    i5 = i21;
                }
                i5 = i18;
                i3 = i17;
                i2 = i19;
                int i23 = i20;
                c2 = c3;
                i4 = i23;
            } else {
                if ((c4 < '@' && (this.sepcialBits & (1 << c4)) != 0) || c4 == '\\') {
                    int i24 = i17 + 1;
                    int i25 = (c4 == '(' || c4 == ')' || c4 == '<' || c4 == '>' || (c4 < IOUtils.specicalFlags_doubleQuotes.length && IOUtils.specicalFlags_doubleQuotes[c4] == 4)) ? i19 + 4 : i19;
                    if (i20 == -1) {
                        c2 = c4;
                        i2 = i25;
                        i5 = i21;
                        i3 = i24;
                        i4 = i21;
                    } else {
                        i2 = i25;
                        i3 = i24;
                        i4 = i20;
                        c2 = c4;
                        i5 = i21;
                    }
                }
                i5 = i18;
                i3 = i17;
                i2 = i19;
                int i232 = i20;
                c2 = c3;
                i4 = i232;
            }
            i21++;
            i19 = i2;
            i17 = i3;
            i18 = i5;
            int i26 = i4;
            c3 = c2;
            i20 = i26;
        }
        if (i17 > 0) {
            int i27 = i19 + i17;
            if (i27 > this.buf.length) {
                expandCapacity(i27);
            }
            this.count = i27;
            if (i17 == 1) {
                if (c3 == 8232) {
                    System.arraycopy(this.buf, i18 + 1, this.buf, i18 + 6, (i16 - i18) - 1);
                    this.buf[i18] = '\\';
                    int i28 = i18 + 1;
                    this.buf[i28] = 'u';
                    int i29 = i28 + 1;
                    this.buf[i29] = '2';
                    int i30 = i29 + 1;
                    this.buf[i30] = '0';
                    int i31 = i30 + 1;
                    this.buf[i31] = '2';
                    this.buf[i31 + 1] = '8';
                } else if (c3 == 8233) {
                    System.arraycopy(this.buf, i18 + 1, this.buf, i18 + 6, (i16 - i18) - 1);
                    this.buf[i18] = '\\';
                    int i32 = i18 + 1;
                    this.buf[i32] = 'u';
                    int i33 = i32 + 1;
                    this.buf[i33] = '2';
                    int i34 = i33 + 1;
                    this.buf[i34] = '0';
                    int i35 = i34 + 1;
                    this.buf[i35] = '2';
                    this.buf[i35 + 1] = '9';
                } else if (c3 == '(' || c3 == ')' || c3 == '<' || c3 == '>') {
                    System.arraycopy(this.buf, i18 + 1, this.buf, i18 + 6, (i16 - i18) - 1);
                    int i36 = i18 + 1;
                    this.buf[i18] = '\\';
                    int i37 = i36 + 1;
                    this.buf[i36] = 'u';
                    int i38 = i37 + 1;
                    this.buf[i37] = IOUtils.DIGITS[(c3 >>> '\f') & 15];
                    int i39 = i38 + 1;
                    this.buf[i38] = IOUtils.DIGITS[(c3 >>> '\b') & 15];
                    int i40 = i39 + 1;
                    this.buf[i39] = IOUtils.DIGITS[(c3 >>> 4) & 15];
                    int i41 = i40 + 1;
                    this.buf[i40] = IOUtils.DIGITS[c3 & 15];
                } else if (c3 < IOUtils.specicalFlags_doubleQuotes.length && IOUtils.specicalFlags_doubleQuotes[c3] == 4) {
                    System.arraycopy(this.buf, i18 + 1, this.buf, i18 + 6, (i16 - i18) - 1);
                    int i42 = i18 + 1;
                    this.buf[i18] = '\\';
                    int i43 = i42 + 1;
                    this.buf[i42] = 'u';
                    int i44 = i43 + 1;
                    this.buf[i43] = IOUtils.DIGITS[(c3 >>> '\f') & 15];
                    int i45 = i44 + 1;
                    this.buf[i44] = IOUtils.DIGITS[(c3 >>> '\b') & 15];
                    int i46 = i45 + 1;
                    this.buf[i45] = IOUtils.DIGITS[(c3 >>> 4) & 15];
                    int i47 = i46 + 1;
                    this.buf[i46] = IOUtils.DIGITS[c3 & 15];
                } else {
                    System.arraycopy(this.buf, i18 + 1, this.buf, i18 + 2, (i16 - i18) - 1);
                    this.buf[i18] = '\\';
                    this.buf[i18 + 1] = IOUtils.replaceChars[c3];
                }
            } else if (i17 > 1) {
                int i48 = i16;
                int i49 = i20;
                int i50 = i49;
                for (int i51 = i20 - i15; i51 < str2.length(); i51++) {
                    char charAt = str2.charAt(i51);
                    if (this.browserSecure && (charAt == '(' || charAt == ')' || charAt == '<' || charAt == '>')) {
                        int i52 = i50 + 1;
                        this.buf[i50] = '\\';
                        int i53 = i52 + 1;
                        this.buf[i52] = 'u';
                        int i54 = i53 + 1;
                        this.buf[i53] = IOUtils.DIGITS[(charAt >>> '\f') & 15];
                        int i55 = i54 + 1;
                        this.buf[i54] = IOUtils.DIGITS[(charAt >>> '\b') & 15];
                        int i56 = i55 + 1;
                        this.buf[i55] = IOUtils.DIGITS[(charAt >>> 4) & 15];
                        i50 = i56 + 1;
                        this.buf[i56] = IOUtils.DIGITS[charAt & 15];
                        i48 += 5;
                    } else if ((charAt < IOUtils.specicalFlags_doubleQuotes.length && IOUtils.specicalFlags_doubleQuotes[charAt] != 0) || (charAt == '/' && isEnabled(SerializerFeature.WriteSlashAsSpecial))) {
                        int i57 = i50 + 1;
                        this.buf[i50] = '\\';
                        if (IOUtils.specicalFlags_doubleQuotes[charAt] == 4) {
                            int i58 = i57 + 1;
                            this.buf[i57] = 'u';
                            int i59 = i58 + 1;
                            this.buf[i58] = IOUtils.DIGITS[(charAt >>> '\f') & 15];
                            int i60 = i59 + 1;
                            this.buf[i59] = IOUtils.DIGITS[(charAt >>> '\b') & 15];
                            int i61 = i60 + 1;
                            this.buf[i60] = IOUtils.DIGITS[(charAt >>> 4) & 15];
                            i50 = i61 + 1;
                            this.buf[i61] = IOUtils.DIGITS[charAt & 15];
                            i48 += 5;
                        } else {
                            i50 = i57 + 1;
                            this.buf[i57] = IOUtils.replaceChars[charAt];
                            i48++;
                        }
                    } else if (charAt == 8232 || charAt == 8233) {
                        int i62 = i50 + 1;
                        this.buf[i50] = '\\';
                        int i63 = i62 + 1;
                        this.buf[i62] = 'u';
                        int i64 = i63 + 1;
                        this.buf[i63] = IOUtils.DIGITS[(charAt >>> '\f') & 15];
                        int i65 = i64 + 1;
                        this.buf[i64] = IOUtils.DIGITS[(charAt >>> '\b') & 15];
                        int i66 = i65 + 1;
                        this.buf[i65] = IOUtils.DIGITS[(charAt >>> 4) & 15];
                        i50 = i66 + 1;
                        this.buf[i66] = IOUtils.DIGITS[charAt & 15];
                        i48 += 5;
                    } else {
                        this.buf[i50] = charAt;
                        i50++;
                    }
                }
            }
        }
        this.buf[this.count - 1] = '\"';
    }

    public void writeFieldValueStringWithDoubleQuote(char c, String str, String str2) {
        int length = str.length();
        int i = this.count;
        int length2 = str2.length();
        int i2 = i + length + length2 + 6;
        if (i2 > this.buf.length) {
            if (this.writer != null) {
                write(c);
                writeStringWithDoubleQuote(str, ':');
                writeStringWithDoubleQuote(str2, (char) 0);
                return;
            }
            expandCapacity(i2);
        }
        this.buf[this.count] = c;
        int i3 = this.count + 2;
        int i4 = i3 + length;
        this.buf[this.count + 1] = '\"';
        str.getChars(0, length, this.buf, i3);
        this.count = i2;
        this.buf[i4] = '\"';
        int i5 = i4 + 1;
        int i6 = i5 + 1;
        this.buf[i5] = ':';
        this.buf[i6] = '\"';
        str2.getChars(0, length2, this.buf, i6 + 1);
        this.buf[this.count - 1] = '\"';
    }

    public void writeFieldValue(char c, String str, Enum<?> r4) {
        if (r4 == null) {
            write(c);
            writeFieldName(str);
            writeNull();
        } else if (this.writeEnumUsingName && !this.writeEnumUsingToString) {
            writeEnumFieldValue(c, str, r4.name());
        } else if (this.writeEnumUsingToString) {
            writeEnumFieldValue(c, str, r4.toString());
        } else {
            writeFieldValue(c, str, r4.ordinal());
        }
    }

    private void writeEnumFieldValue(char c, String str, String str2) {
        if (this.useSingleQuotes) {
            writeFieldValue(c, str, str2);
        } else {
            writeFieldValueStringWithDoubleQuote(c, str, str2);
        }
    }

    public void writeFieldValue(char c, String str, BigDecimal bigDecimal) {
        write(c);
        writeFieldName(str);
        if (bigDecimal == null) {
            writeNull();
        } else {
            write(bigDecimal.toString());
        }
    }

    public void writeString(String str, char c) {
        if (this.useSingleQuotes) {
            writeStringWithSingleQuote(str);
            write(c);
            return;
        }
        writeStringWithDoubleQuote(str, c);
    }

    public void writeString(String str) {
        if (this.useSingleQuotes) {
            writeStringWithSingleQuote(str);
        } else {
            writeStringWithDoubleQuote(str, (char) 0);
        }
    }

    public void writeString(char[] cArr) {
        if (this.useSingleQuotes) {
            writeStringWithSingleQuote(cArr);
        } else {
            writeStringWithDoubleQuote(new String(cArr), (char) 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void writeStringWithSingleQuote(String str) {
        int i;
        int i2;
        char c = 0;
        if (str == null) {
            int i3 = this.count + 4;
            if (i3 > this.buf.length) {
                expandCapacity(i3);
            }
            "null".getChars(0, 4, this.buf, this.count);
            this.count = i3;
            return;
        }
        int length = str.length();
        int i4 = this.count + length + 2;
        if (i4 > this.buf.length) {
            if (this.writer != null) {
                write(39);
                while (c < str.length()) {
                    char charAt = str.charAt(c);
                    if (charAt <= '\r' || charAt == '\\' || charAt == '\'' || (charAt == '/' && isEnabled(SerializerFeature.WriteSlashAsSpecial))) {
                        write(92);
                        write(IOUtils.replaceChars[charAt]);
                    } else {
                        write(charAt);
                    }
                    c++;
                }
                write(39);
                return;
            }
            expandCapacity(i4);
        }
        int i5 = this.count + 1;
        int i6 = i5 + length;
        this.buf[this.count] = '\'';
        str.getChars(0, length, this.buf, i5);
        this.count = i4;
        int i7 = -1;
        int i8 = i5;
        int i9 = 0;
        while (i8 < i6) {
            char c2 = this.buf[i8];
            if (c2 <= '\r' || c2 == '\\' || c2 == '\'' || (c2 == '/' && isEnabled(SerializerFeature.WriteSlashAsSpecial))) {
                i = i9 + 1;
                c = c2;
                i2 = i8;
            } else {
                i2 = i7;
                i = i9;
            }
            i8++;
            i9 = i;
            i7 = i2;
        }
        int i10 = i4 + i9;
        if (i10 > this.buf.length) {
            expandCapacity(i10);
        }
        this.count = i10;
        if (i9 == 1) {
            System.arraycopy(this.buf, i7 + 1, this.buf, i7 + 2, (i6 - i7) - 1);
            this.buf[i7] = '\\';
            this.buf[i7 + 1] = IOUtils.replaceChars[c];
        } else if (i9 > 1) {
            System.arraycopy(this.buf, i7 + 1, this.buf, i7 + 2, (i6 - i7) - 1);
            this.buf[i7] = '\\';
            int i11 = i7 + 1;
            this.buf[i11] = IOUtils.replaceChars[c];
            int i12 = i6 + 1;
            for (int i13 = i11 - 2; i13 >= i5; i13--) {
                char c3 = this.buf[i13];
                if (c3 <= '\r' || c3 == '\\' || c3 == '\'' || (c3 == '/' && isEnabled(SerializerFeature.WriteSlashAsSpecial))) {
                    System.arraycopy(this.buf, i13 + 1, this.buf, i13 + 2, (i12 - i13) - 1);
                    this.buf[i13] = '\\';
                    this.buf[i13 + 1] = IOUtils.replaceChars[c3];
                    i12++;
                }
            }
        }
        this.buf[this.count - 1] = '\'';
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:64:0x0096 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v12 */
    protected void writeStringWithSingleQuote(char[] cArr) {
        int i;
        int i2;
        int i3 = 0;
        if (cArr == null) {
            int i4 = this.count + 4;
            if (i4 > this.buf.length) {
                expandCapacity(i4);
            }
            "null".getChars(0, 4, this.buf, this.count);
            this.count = i4;
            return;
        }
        int length = cArr.length;
        int i5 = this.count + length + 2;
        if (i5 > this.buf.length) {
            if (this.writer != null) {
                write(39);
                while (i3 < cArr.length) {
                    char c = cArr[i3];
                    if (c <= '\r' || c == '\\' || c == '\'' || (c == '/' && isEnabled(SerializerFeature.WriteSlashAsSpecial))) {
                        write(92);
                        write(IOUtils.replaceChars[c]);
                    } else {
                        write(c);
                    }
                    i3++;
                }
                write(39);
                return;
            }
            expandCapacity(i5);
        }
        int i6 = this.count + 1;
        int i7 = i6 + length;
        this.buf[this.count] = '\'';
        System.arraycopy(cArr, 0, this.buf, i6, cArr.length);
        this.count = i5;
        int i8 = -1;
        int i9 = i6;
        int i10 = 0;
        while (i9 < i7) {
            char c2 = this.buf[i9];
            if (c2 <= '\r' || c2 == '\\' || c2 == '\'' || (c2 == '/' && isEnabled(SerializerFeature.WriteSlashAsSpecial))) {
                i = i10 + 1;
                i3 = c2;
                i2 = i9;
            } else {
                i2 = i8;
                i = i10;
            }
            i9++;
            i10 = i;
            i8 = i2;
            i3 = i3;
        }
        int i11 = i5 + i10;
        if (i11 > this.buf.length) {
            expandCapacity(i11);
        }
        this.count = i11;
        if (i10 == 1) {
            System.arraycopy(this.buf, i8 + 1, this.buf, i8 + 2, (i7 - i8) - 1);
            this.buf[i8] = '\\';
            this.buf[i8 + 1] = IOUtils.replaceChars[i3 == true ? 1 : 0];
        } else if (i10 > 1) {
            System.arraycopy(this.buf, i8 + 1, this.buf, i8 + 2, (i7 - i8) - 1);
            this.buf[i8] = '\\';
            int i12 = i8 + 1;
            this.buf[i12] = IOUtils.replaceChars[i3 == true ? 1 : 0];
            int i13 = i7 + 1;
            for (int i14 = i12 - 2; i14 >= i6; i14--) {
                char c3 = this.buf[i14];
                if (c3 <= '\r' || c3 == '\\' || c3 == '\'' || (c3 == '/' && isEnabled(SerializerFeature.WriteSlashAsSpecial))) {
                    System.arraycopy(this.buf, i14 + 1, this.buf, i14 + 2, (i13 - i14) - 1);
                    this.buf[i14] = '\\';
                    this.buf[i14 + 1] = IOUtils.replaceChars[c3];
                    i13++;
                }
            }
        }
        this.buf[this.count - 1] = '\'';
    }

    public void writeFieldName(String str) {
        writeFieldName(str, false);
    }

    public void writeFieldName(String str, boolean z) {
        boolean z2 = true;
        if (str == null) {
            write("null:");
        } else if (this.useSingleQuotes) {
            if (this.quoteFieldNames) {
                writeStringWithSingleQuote(str);
                write(58);
                return;
            }
            writeKeyWithSingleQuoteIfHasSpecial(str);
        } else if (this.quoteFieldNames) {
            writeStringWithDoubleQuote(str, ':');
        } else {
            boolean z3 = str.length() == 0;
            int i = 0;
            while (true) {
                if (i >= str.length()) {
                    z2 = z3;
                    break;
                }
                char charAt = str.charAt(i);
                if ((charAt < '@' && (this.sepcialBits & (1 << charAt)) != 0) || charAt == '\\') {
                    break;
                }
                i++;
            }
            if (z2) {
                writeStringWithDoubleQuote(str, ':');
                return;
            }
            write(str);
            write(58);
        }
    }

    private void writeKeyWithSingleQuoteIfHasSpecial(String str) {
        boolean z;
        byte[] bArr = IOUtils.specicalFlags_singleQuotes;
        int length = str.length();
        int i = this.count + length + 1;
        if (i > this.buf.length) {
            if (this.writer != null) {
                if (length == 0) {
                    write(39);
                    write(39);
                    write(58);
                    return;
                }
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        z = false;
                        break;
                    }
                    char charAt = str.charAt(i2);
                    if (charAt >= bArr.length || bArr[charAt] == 0) {
                        i2++;
                    } else {
                        z = true;
                        break;
                    }
                }
                if (z) {
                    write(39);
                }
                for (int i3 = 0; i3 < length; i3++) {
                    char charAt2 = str.charAt(i3);
                    if (charAt2 < bArr.length && bArr[charAt2] != 0) {
                        write(92);
                        write(IOUtils.replaceChars[charAt2]);
                    } else {
                        write(charAt2);
                    }
                }
                if (z) {
                    write(39);
                }
                write(58);
                return;
            }
            expandCapacity(i);
        }
        if (length == 0) {
            if (this.count + 3 > this.buf.length) {
                expandCapacity(this.count + 3);
            }
            char[] cArr = this.buf;
            int i4 = this.count;
            this.count = i4 + 1;
            cArr[i4] = '\'';
            char[] cArr2 = this.buf;
            int i5 = this.count;
            this.count = i5 + 1;
            cArr2[i5] = '\'';
            char[] cArr3 = this.buf;
            int i6 = this.count;
            this.count = i6 + 1;
            cArr3[i6] = ':';
            return;
        }
        int i7 = this.count;
        int i8 = i7 + length;
        str.getChars(0, length, this.buf, i7);
        this.count = i;
        boolean z2 = false;
        int i9 = i7;
        while (i9 < i8) {
            char c = this.buf[i9];
            if (c < bArr.length && bArr[c] != 0) {
                if (!z2) {
                    i += 3;
                    if (i > this.buf.length) {
                        expandCapacity(i);
                    }
                    this.count = i;
                    System.arraycopy(this.buf, i9 + 1, this.buf, i9 + 3, (i8 - i9) - 1);
                    System.arraycopy(this.buf, 0, this.buf, 1, i9);
                    this.buf[i7] = '\'';
                    int i10 = i9 + 1;
                    this.buf[i10] = '\\';
                    i9 = i10 + 1;
                    this.buf[i9] = IOUtils.replaceChars[c];
                    i8 += 2;
                    this.buf[this.count - 2] = '\'';
                    z2 = true;
                } else {
                    i++;
                    if (i > this.buf.length) {
                        expandCapacity(i);
                    }
                    this.count = i;
                    System.arraycopy(this.buf, i9 + 1, this.buf, i9 + 2, i8 - i9);
                    this.buf[i9] = '\\';
                    i9++;
                    this.buf[i9] = IOUtils.replaceChars[c];
                    i8++;
                }
            }
            i9++;
        }
        this.buf[i - 1] = ':';
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
        if (this.writer != null) {
            try {
                this.writer.write(this.buf, 0, this.count);
                this.writer.flush();
                this.count = 0;
            } catch (IOException e) {
                throw new JSONException(e.getMessage(), e);
            }
        }
    }
}
