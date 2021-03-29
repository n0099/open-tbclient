package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.util.IOUtils;
import com.alipay.sdk.encrypt.a;
import com.baidu.android.common.others.lang.StringUtil;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.util.List;
import kotlin.text.Typography;
/* loaded from: classes.dex */
public final class SerializeWriter extends Writer {
    public static final ThreadLocal<char[]> bufLocal = new ThreadLocal<>();
    public static final ThreadLocal<byte[]> bytesBufLocal = new ThreadLocal<>();
    public static final int nonDirectFeatures = ((((((((SerializerFeature.UseSingleQuotes.mask | 0) | SerializerFeature.BrowserCompatible.mask) | SerializerFeature.PrettyFormat.mask) | SerializerFeature.WriteEnumUsingToString.mask) | SerializerFeature.WriteNonStringValueAsString.mask) | SerializerFeature.WriteSlashAsSpecial.mask) | SerializerFeature.IgnoreErrorGetter.mask) | SerializerFeature.WriteClassName.mask) | SerializerFeature.NotWriteDefaultValue.mask;
    public boolean beanToArray;
    public boolean browserSecure;
    public char[] buf;
    public int count;
    public boolean disableCircularReferenceDetect;
    public int features;
    public char keySeperator;
    public int maxBufSize;
    public boolean notWriteDefaultValue;
    public boolean quoteFieldNames;
    public long sepcialBits;
    public boolean sortField;
    public boolean useSingleQuotes;
    public boolean writeDirect;
    public boolean writeEnumUsingName;
    public boolean writeEnumUsingToString;
    public boolean writeNonStringValueAsString;
    public final Writer writer;

    public SerializeWriter() {
        this((Writer) null);
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

    private void writeEnumFieldValue(char c2, String str, String str2) {
        if (this.useSingleQuotes) {
            writeFieldValue(c2, str, str2);
        } else {
            writeFieldValueStringWithDoubleQuote(c2, str, str2);
        }
    }

    private void writeKeyWithSingleQuoteIfHasSpecial(String str) {
        byte[] bArr = IOUtils.specicalFlags_singleQuotes;
        int length = str.length();
        boolean z = true;
        int i = this.count + length + 1;
        int i2 = 0;
        if (i > this.buf.length) {
            if (this.writer != null) {
                if (length == 0) {
                    write(39);
                    write(39);
                    write(58);
                    return;
                }
                int i3 = 0;
                while (true) {
                    if (i3 < length) {
                        char charAt = str.charAt(i3);
                        if (charAt < bArr.length && bArr[charAt] != 0) {
                            break;
                        }
                        i3++;
                    } else {
                        z = false;
                        break;
                    }
                }
                if (z) {
                    write(39);
                }
                while (i2 < length) {
                    char charAt2 = str.charAt(i2);
                    if (charAt2 < bArr.length && bArr[charAt2] != 0) {
                        write(92);
                        write(IOUtils.replaceChars[charAt2]);
                    } else {
                        write(charAt2);
                    }
                    i2++;
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
            int i4 = this.count;
            if (i4 + 3 > this.buf.length) {
                expandCapacity(i4 + 3);
            }
            char[] cArr = this.buf;
            int i5 = this.count;
            int i6 = i5 + 1;
            this.count = i6;
            cArr[i5] = '\'';
            int i7 = i6 + 1;
            this.count = i7;
            cArr[i6] = '\'';
            this.count = i7 + 1;
            cArr[i7] = ':';
            return;
        }
        int i8 = this.count;
        int i9 = i8 + length;
        str.getChars(0, length, this.buf, i8);
        this.count = i;
        int i10 = i8;
        boolean z2 = false;
        while (i10 < i9) {
            char[] cArr2 = this.buf;
            char c2 = cArr2[i10];
            if (c2 < bArr.length && bArr[c2] != 0) {
                if (!z2) {
                    i += 3;
                    if (i > cArr2.length) {
                        expandCapacity(i);
                    }
                    this.count = i;
                    char[] cArr3 = this.buf;
                    int i11 = i10 + 1;
                    System.arraycopy(cArr3, i11, cArr3, i10 + 3, (i9 - i10) - 1);
                    char[] cArr4 = this.buf;
                    System.arraycopy(cArr4, i2, cArr4, 1, i10);
                    char[] cArr5 = this.buf;
                    cArr5[i8] = '\'';
                    cArr5[i11] = '\\';
                    int i12 = i11 + 1;
                    cArr5[i12] = IOUtils.replaceChars[c2];
                    i9 += 2;
                    cArr5[this.count - 2] = '\'';
                    i10 = i12;
                    z2 = true;
                } else {
                    i++;
                    if (i > cArr2.length) {
                        expandCapacity(i);
                    }
                    this.count = i;
                    char[] cArr6 = this.buf;
                    int i13 = i10 + 1;
                    System.arraycopy(cArr6, i13, cArr6, i10 + 2, i9 - i10);
                    char[] cArr7 = this.buf;
                    cArr7[i10] = '\\';
                    cArr7[i13] = IOUtils.replaceChars[c2];
                    i9++;
                    i10 = i13;
                }
            }
            i10++;
            i2 = 0;
        }
        this.buf[i - 1] = ':';
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.writer != null && this.count > 0) {
            flush();
        }
        char[] cArr = this.buf;
        if (cArr.length <= 131072) {
            bufLocal.set(cArr);
        }
        this.buf = null;
    }

    public void computeFeatures() {
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
        this.keySeperator = this.useSingleQuotes ? '\'' : Typography.quote;
        boolean z = (this.features & SerializerFeature.BrowserSecure.mask) != 0;
        this.browserSecure = z;
        if (z) {
            j = 5764610843043954687L;
        } else {
            j = (this.features & SerializerFeature.WriteSlashAsSpecial.mask) != 0 ? 140758963191807L : 21474836479L;
        }
        this.sepcialBits = j;
    }

    public void config(SerializerFeature serializerFeature, boolean z) {
        if (z) {
            int mask = this.features | serializerFeature.getMask();
            this.features = mask;
            if (serializerFeature == SerializerFeature.WriteEnumUsingToString) {
                this.features = (~SerializerFeature.WriteEnumUsingName.getMask()) & mask;
            } else if (serializerFeature == SerializerFeature.WriteEnumUsingName) {
                this.features = (~SerializerFeature.WriteEnumUsingToString.getMask()) & mask;
            }
        } else {
            this.features = (~serializerFeature.getMask()) & this.features;
        }
        computeFeatures();
    }

    public void expandCapacity(int i) {
        int i2 = this.maxBufSize;
        if (i2 != -1 && i >= i2) {
            throw new JSONException("serialize exceeded MAX_OUTPUT_LENGTH=" + this.maxBufSize + ", minimumCapacity=" + i);
        }
        char[] cArr = this.buf;
        int length = cArr.length + (cArr.length >> 1) + 1;
        if (length >= i) {
            i = length;
        }
        char[] cArr2 = new char[i];
        System.arraycopy(this.buf, 0, cArr2, 0, this.count);
        this.buf = cArr2;
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
        Writer writer = this.writer;
        if (writer == null) {
            return;
        }
        try {
            writer.write(this.buf, 0, this.count);
            this.writer.flush();
            this.count = 0;
        } catch (IOException e2) {
            throw new JSONException(e2.getMessage(), e2);
        }
    }

    public int getBufferLength() {
        return this.buf.length;
    }

    public int getMaxBufSize() {
        return this.maxBufSize;
    }

    public boolean isEnabled(SerializerFeature serializerFeature) {
        return (serializerFeature.mask & this.features) != 0;
    }

    public boolean isNotWriteDefaultValue() {
        return this.notWriteDefaultValue;
    }

    public boolean isSortField() {
        return this.sortField;
    }

    public void setMaxBufSize(int i) {
        if (i >= this.buf.length) {
            this.maxBufSize = i;
            return;
        }
        throw new JSONException("must > " + this.buf.length);
    }

    public int size() {
        return this.count;
    }

    public byte[] toBytes(String str) {
        Charset charset;
        if (str != null && !"UTF-8".equals(str)) {
            charset = Charset.forName(str);
        } else {
            charset = IOUtils.UTF8;
        }
        return toBytes(charset);
    }

    public char[] toCharArray() {
        if (this.writer == null) {
            int i = this.count;
            char[] cArr = new char[i];
            System.arraycopy(this.buf, 0, cArr, 0, i);
            return cArr;
        }
        throw new UnsupportedOperationException("writer not null");
    }

    public char[] toCharArrayForSpringWebSocket() {
        if (this.writer == null) {
            int i = this.count;
            char[] cArr = new char[i - 2];
            System.arraycopy(this.buf, 1, cArr, 0, i - 2);
            return cArr;
        }
        throw new UnsupportedOperationException("writer not null");
    }

    public String toString() {
        return new String(this.buf, 0, this.count);
    }

    @Override // java.io.Writer
    public void write(int i) {
        int i2 = 1;
        int i3 = this.count + 1;
        if (i3 > this.buf.length) {
            if (this.writer == null) {
                expandCapacity(i3);
            } else {
                flush();
                this.buf[this.count] = (char) i;
                this.count = i2;
            }
        }
        i2 = i3;
        this.buf[this.count] = (char) i;
        this.count = i2;
    }

    public void writeByteArray(byte[] bArr) {
        if (isEnabled(SerializerFeature.WriteClassName.mask)) {
            writeHex(bArr);
            return;
        }
        int length = bArr.length;
        char c2 = this.useSingleQuotes ? '\'' : Typography.quote;
        if (length == 0) {
            write(this.useSingleQuotes ? "''" : "\"\"");
            return;
        }
        char[] cArr = IOUtils.CA;
        int i = (length / 3) * 3;
        int i2 = length - 1;
        int i3 = this.count;
        int i4 = (((i2 / 3) + 1) << 2) + i3 + 2;
        if (i4 > this.buf.length) {
            if (this.writer != null) {
                write(c2);
                int i5 = 0;
                while (i5 < i) {
                    int i6 = i5 + 1;
                    int i7 = i6 + 1;
                    int i8 = ((bArr[i5] & 255) << 16) | ((bArr[i6] & 255) << 8) | (bArr[i7] & 255);
                    write(cArr[(i8 >>> 18) & 63]);
                    write(cArr[(i8 >>> 12) & 63]);
                    write(cArr[(i8 >>> 6) & 63]);
                    write(cArr[i8 & 63]);
                    i5 = i7 + 1;
                }
                int i9 = length - i;
                if (i9 > 0) {
                    int i10 = ((bArr[i] & 255) << 10) | (i9 == 2 ? (bArr[i2] & 255) << 2 : 0);
                    write(cArr[i10 >> 12]);
                    write(cArr[(i10 >>> 6) & 63]);
                    write(i9 == 2 ? cArr[i10 & 63] : a.f1897h);
                    write(61);
                }
                write(c2);
                return;
            }
            expandCapacity(i4);
        }
        this.count = i4;
        int i11 = i3 + 1;
        this.buf[i3] = c2;
        int i12 = 0;
        while (i12 < i) {
            int i13 = i12 + 1;
            int i14 = i13 + 1;
            int i15 = ((bArr[i12] & 255) << 16) | ((bArr[i13] & 255) << 8);
            int i16 = i14 + 1;
            int i17 = i15 | (bArr[i14] & 255);
            char[] cArr2 = this.buf;
            int i18 = i11 + 1;
            cArr2[i11] = cArr[(i17 >>> 18) & 63];
            int i19 = i18 + 1;
            cArr2[i18] = cArr[(i17 >>> 12) & 63];
            int i20 = i19 + 1;
            cArr2[i19] = cArr[(i17 >>> 6) & 63];
            i11 = i20 + 1;
            cArr2[i20] = cArr[i17 & 63];
            i12 = i16;
        }
        int i21 = length - i;
        if (i21 > 0) {
            int i22 = ((bArr[i] & 255) << 10) | (i21 == 2 ? (bArr[i2] & 255) << 2 : 0);
            char[] cArr3 = this.buf;
            cArr3[i4 - 5] = cArr[i22 >> 12];
            cArr3[i4 - 4] = cArr[(i22 >>> 6) & 63];
            cArr3[i4 - 3] = i21 == 2 ? cArr[i22 & 63] : a.f1897h;
            this.buf[i4 - 2] = a.f1897h;
        }
        this.buf[i4 - 1] = c2;
    }

    public void writeDouble(double d2, boolean z) {
        if (!Double.isNaN(d2) && !Double.isInfinite(d2)) {
            String d3 = Double.toString(d2);
            if (isEnabled(SerializerFeature.WriteNullNumberAsZero) && d3.endsWith(".0")) {
                d3 = d3.substring(0, d3.length() - 2);
            }
            write(d3);
            if (z && isEnabled(SerializerFeature.WriteClassName)) {
                write(68);
                return;
            }
            return;
        }
        writeNull();
    }

    public void writeEnum(Enum<?> r3) {
        if (r3 == null) {
            writeNull();
            return;
        }
        String str = null;
        if (this.writeEnumUsingName && !this.writeEnumUsingToString) {
            str = r3.name();
        } else if (this.writeEnumUsingToString) {
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

    public void writeFieldName(String str) {
        writeFieldName(str, false);
    }

    public void writeFieldNameDirect(String str) {
        int length = str.length();
        int i = this.count + length + 3;
        if (i > this.buf.length) {
            expandCapacity(i);
        }
        int i2 = this.count;
        char[] cArr = this.buf;
        cArr[i2] = Typography.quote;
        str.getChars(0, length, cArr, i2 + 1);
        this.count = i;
        char[] cArr2 = this.buf;
        cArr2[i - 2] = Typography.quote;
        cArr2[i - 1] = ':';
    }

    public void writeFieldValue(char c2, String str, char c3) {
        write(c2);
        writeFieldName(str);
        if (c3 == 0) {
            writeString("\u0000");
        } else {
            writeString(Character.toString(c3));
        }
    }

    public void writeFieldValueStringWithDoubleQuote(char c2, String str, String str2) {
        int length = str.length();
        int i = this.count;
        int length2 = str2.length();
        int i2 = i + length + length2 + 6;
        if (i2 > this.buf.length) {
            if (this.writer != null) {
                write(c2);
                writeStringWithDoubleQuote(str, ':');
                writeStringWithDoubleQuote(str2, (char) 0);
                return;
            }
            expandCapacity(i2);
        }
        char[] cArr = this.buf;
        int i3 = this.count;
        cArr[i3] = c2;
        int i4 = i3 + 2;
        int i5 = i4 + length;
        cArr[i3 + 1] = Typography.quote;
        str.getChars(0, length, cArr, i4);
        this.count = i2;
        char[] cArr2 = this.buf;
        cArr2[i5] = Typography.quote;
        int i6 = i5 + 1;
        int i7 = i6 + 1;
        cArr2[i6] = ':';
        cArr2[i7] = Typography.quote;
        str2.getChars(0, length2, cArr2, i7 + 1);
        this.buf[this.count - 1] = Typography.quote;
    }

    /* JADX WARN: Code restructure failed: missing block: B:52:0x00d2, code lost:
        if (r1[r7] == 4) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x0216, code lost:
        if (r3 != '>') goto L101;
     */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00d9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void writeFieldValueStringWithDoubleQuoteCheck(char c2, String str, String str2) {
        int length;
        int i;
        int length2 = str.length();
        int i2 = this.count;
        if (str2 == null) {
            i = i2 + length2 + 8;
            length = 4;
        } else {
            length = str2.length();
            i = i2 + length2 + length + 6;
        }
        if (i > this.buf.length) {
            if (this.writer != null) {
                write(c2);
                writeStringWithDoubleQuote(str, ':');
                writeStringWithDoubleQuote(str2, (char) 0);
                return;
            }
            expandCapacity(i);
        }
        char[] cArr = this.buf;
        int i3 = this.count;
        cArr[i3] = c2;
        int i4 = i3 + 2;
        int i5 = i4 + length2;
        cArr[i3 + 1] = Typography.quote;
        str.getChars(0, length2, cArr, i4);
        this.count = i;
        char[] cArr2 = this.buf;
        cArr2[i5] = Typography.quote;
        int i6 = i5 + 1;
        int i7 = i6 + 1;
        cArr2[i6] = ':';
        if (str2 == null) {
            int i8 = i7 + 1;
            cArr2[i7] = 'n';
            int i9 = i8 + 1;
            cArr2[i8] = 'u';
            cArr2[i9] = 'l';
            cArr2[i9 + 1] = 'l';
            return;
        }
        int i10 = i7 + 1;
        cArr2[i7] = Typography.quote;
        int i11 = i10 + length;
        str2.getChars(0, length, cArr2, i10);
        int i12 = -1;
        int i13 = 0;
        char c3 = 0;
        int i14 = -1;
        int i15 = -1;
        for (int i16 = i10; i16 < i11; i16++) {
            char c4 = this.buf[i16];
            if (c4 >= ']') {
                if (c4 >= 127 && (c4 == 8232 || c4 == 8233 || c4 < 160)) {
                    if (i14 == i12) {
                        i14 = i16;
                    }
                    i13++;
                    i += 4;
                    i15 = i16;
                }
            } else if ((c4 < '@' && (this.sepcialBits & (1 << c4)) != 0) || c4 == '\\') {
                i13++;
                if (c4 != '(' && c4 != ')' && c4 != '<' && c4 != '>') {
                    byte[] bArr = IOUtils.specicalFlags_doubleQuotes;
                    if (c4 < bArr.length) {
                    }
                    i12 = -1;
                    if (i14 == -1) {
                        i14 = i16;
                        i15 = i14;
                    }
                    i15 = i16;
                }
                i += 4;
                i12 = -1;
                if (i14 == -1) {
                }
                i15 = i16;
            } else {
                i12 = -1;
            }
            c3 = c4;
        }
        if (i13 > 0) {
            int i17 = i + i13;
            if (i17 > this.buf.length) {
                expandCapacity(i17);
            }
            this.count = i17;
            if (i13 == 1) {
                if (c3 == 8232) {
                    int i18 = i15 + 1;
                    char[] cArr3 = this.buf;
                    System.arraycopy(cArr3, i18, cArr3, i15 + 6, (i11 - i15) - 1);
                    char[] cArr4 = this.buf;
                    cArr4[i15] = '\\';
                    cArr4[i18] = 'u';
                    int i19 = i18 + 1;
                    cArr4[i19] = '2';
                    int i20 = i19 + 1;
                    cArr4[i20] = '0';
                    int i21 = i20 + 1;
                    cArr4[i21] = '2';
                    cArr4[i21 + 1] = '8';
                } else if (c3 == 8233) {
                    int i22 = i15 + 1;
                    char[] cArr5 = this.buf;
                    System.arraycopy(cArr5, i22, cArr5, i15 + 6, (i11 - i15) - 1);
                    char[] cArr6 = this.buf;
                    cArr6[i15] = '\\';
                    cArr6[i22] = 'u';
                    int i23 = i22 + 1;
                    cArr6[i23] = '2';
                    int i24 = i23 + 1;
                    cArr6[i24] = '0';
                    int i25 = i24 + 1;
                    cArr6[i25] = '2';
                    cArr6[i25 + 1] = '9';
                } else if (c3 != '(' && c3 != ')' && c3 != '<' && c3 != '>') {
                    byte[] bArr2 = IOUtils.specicalFlags_doubleQuotes;
                    if (c3 < bArr2.length && bArr2[c3] == 4) {
                        int i26 = i15 + 1;
                        char[] cArr7 = this.buf;
                        System.arraycopy(cArr7, i26, cArr7, i15 + 6, (i11 - i15) - 1);
                        char[] cArr8 = this.buf;
                        cArr8[i15] = '\\';
                        int i27 = i26 + 1;
                        cArr8[i26] = 'u';
                        int i28 = i27 + 1;
                        char[] cArr9 = IOUtils.DIGITS;
                        cArr8[i27] = cArr9[(c3 >>> '\f') & 15];
                        int i29 = i28 + 1;
                        cArr8[i28] = cArr9[(c3 >>> '\b') & 15];
                        cArr8[i29] = cArr9[(c3 >>> 4) & 15];
                        cArr8[i29 + 1] = cArr9[c3 & 15];
                    } else {
                        int i30 = i15 + 1;
                        char[] cArr10 = this.buf;
                        System.arraycopy(cArr10, i30, cArr10, i15 + 2, (i11 - i15) - 1);
                        char[] cArr11 = this.buf;
                        cArr11[i15] = '\\';
                        cArr11[i30] = IOUtils.replaceChars[c3];
                    }
                } else {
                    int i31 = i15 + 1;
                    char[] cArr12 = this.buf;
                    System.arraycopy(cArr12, i31, cArr12, i15 + 6, (i11 - i15) - 1);
                    char[] cArr13 = this.buf;
                    cArr13[i15] = '\\';
                    int i32 = i31 + 1;
                    cArr13[i31] = 'u';
                    int i33 = i32 + 1;
                    char[] cArr14 = IOUtils.DIGITS;
                    cArr13[i32] = cArr14[(c3 >>> '\f') & 15];
                    int i34 = i33 + 1;
                    cArr13[i33] = cArr14[(c3 >>> '\b') & 15];
                    cArr13[i34] = cArr14[(c3 >>> 4) & 15];
                    cArr13[i34 + 1] = cArr14[c3 & 15];
                }
            } else if (i13 > 1) {
                for (int i35 = i14 - i10; i35 < str2.length(); i35++) {
                    char charAt = str2.charAt(i35);
                    if (this.browserSecure) {
                        if (charAt != '(' && charAt != ')') {
                            if (charAt != '<') {
                            }
                        }
                        char[] cArr15 = this.buf;
                        int i36 = i14 + 1;
                        cArr15[i14] = '\\';
                        int i37 = i36 + 1;
                        cArr15[i36] = 'u';
                        int i38 = i37 + 1;
                        char[] cArr16 = IOUtils.DIGITS;
                        cArr15[i37] = cArr16[(charAt >>> '\f') & 15];
                        int i39 = i38 + 1;
                        cArr15[i38] = cArr16[(charAt >>> '\b') & 15];
                        int i40 = i39 + 1;
                        cArr15[i39] = cArr16[(charAt >>> 4) & 15];
                        i14 = i40 + 1;
                        cArr15[i40] = cArr16[charAt & 15];
                    }
                    byte[] bArr3 = IOUtils.specicalFlags_doubleQuotes;
                    if ((charAt < bArr3.length && bArr3[charAt] != 0) || (charAt == '/' && isEnabled(SerializerFeature.WriteSlashAsSpecial))) {
                        char[] cArr17 = this.buf;
                        int i41 = i14 + 1;
                        cArr17[i14] = '\\';
                        if (IOUtils.specicalFlags_doubleQuotes[charAt] == 4) {
                            int i42 = i41 + 1;
                            cArr17[i41] = 'u';
                            int i43 = i42 + 1;
                            char[] cArr18 = IOUtils.DIGITS;
                            cArr17[i42] = cArr18[(charAt >>> '\f') & 15];
                            int i44 = i43 + 1;
                            cArr17[i43] = cArr18[(charAt >>> '\b') & 15];
                            int i45 = i44 + 1;
                            cArr17[i44] = cArr18[(charAt >>> 4) & 15];
                            i14 = i45 + 1;
                            cArr17[i45] = cArr18[charAt & 15];
                        } else {
                            i14 = i41 + 1;
                            cArr17[i41] = IOUtils.replaceChars[charAt];
                        }
                    } else if (charAt != 8232 && charAt != 8233) {
                        this.buf[i14] = charAt;
                        i14++;
                    } else {
                        char[] cArr19 = this.buf;
                        int i46 = i14 + 1;
                        cArr19[i14] = '\\';
                        int i47 = i46 + 1;
                        cArr19[i46] = 'u';
                        int i48 = i47 + 1;
                        char[] cArr20 = IOUtils.DIGITS;
                        cArr19[i47] = cArr20[(charAt >>> '\f') & 15];
                        int i49 = i48 + 1;
                        cArr19[i48] = cArr20[(charAt >>> '\b') & 15];
                        int i50 = i49 + 1;
                        cArr19[i49] = cArr20[(charAt >>> 4) & 15];
                        i14 = i50 + 1;
                        cArr19[i50] = cArr20[charAt & 15];
                    }
                }
            }
        }
        this.buf[this.count - 1] = Typography.quote;
    }

    public void writeFloat(float f2, boolean z) {
        if (!Float.isNaN(f2) && !Float.isInfinite(f2)) {
            String f3 = Float.toString(f2);
            if (isEnabled(SerializerFeature.WriteNullNumberAsZero) && f3.endsWith(".0")) {
                f3 = f3.substring(0, f3.length() - 2);
            }
            write(f3);
            if (z && isEnabled(SerializerFeature.WriteClassName)) {
                write(70);
                return;
            }
            return;
        }
        writeNull();
    }

    public void writeHex(byte[] bArr) {
        int i = 2;
        int length = this.count + (bArr.length * 2) + 3;
        int i2 = 0;
        if (length > this.buf.length) {
            if (this.writer != null) {
                char[] cArr = new char[bArr.length + 3];
                cArr[0] = 'x';
                cArr[1] = '\'';
                while (i2 < bArr.length) {
                    int i3 = bArr[i2] & 255;
                    int i4 = i3 >> 4;
                    int i5 = i3 & 15;
                    int i6 = i + 1;
                    cArr[i] = (char) (i4 + (i4 < 10 ? 48 : 55));
                    i = i6 + 1;
                    cArr[i6] = (char) (i5 + (i5 < 10 ? 48 : 55));
                    i2++;
                }
                cArr[i] = '\'';
                try {
                    this.writer.write(cArr);
                    return;
                } catch (IOException e2) {
                    throw new JSONException("writeBytes error.", e2);
                }
            }
            expandCapacity(length);
        }
        char[] cArr2 = this.buf;
        int i7 = this.count;
        int i8 = i7 + 1;
        this.count = i8;
        cArr2[i7] = 'x';
        this.count = i8 + 1;
        cArr2[i8] = '\'';
        while (i2 < bArr.length) {
            int i9 = bArr[i2] & 255;
            int i10 = i9 >> 4;
            int i11 = i9 & 15;
            char[] cArr3 = this.buf;
            int i12 = this.count;
            this.count = i12 + 1;
            cArr3[i12] = (char) (i10 + (i10 < 10 ? 48 : 55));
            char[] cArr4 = this.buf;
            int i13 = this.count;
            this.count = i13 + 1;
            cArr4[i13] = (char) (i11 + (i11 < 10 ? 48 : 55));
            i2++;
        }
        char[] cArr5 = this.buf;
        int i14 = this.count;
        this.count = i14 + 1;
        cArr5[i14] = '\'';
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
                write(cArr, 0, stringSize);
                return;
            }
        }
        IOUtils.getChars(i, i2, this.buf);
        this.count = i2;
    }

    public void writeLong(long j) {
        boolean z = isEnabled(SerializerFeature.BrowserCompatible) && !isEnabled(SerializerFeature.WriteClassName) && (j > 9007199254740991L || j < -9007199254740991L);
        if (j == Long.MIN_VALUE) {
            if (z) {
                write("\"-9223372036854775808\"");
                return;
            } else {
                write("-9223372036854775808");
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
                    write(cArr, 0, stringSize);
                    write(34);
                    return;
                }
                write(cArr, 0, stringSize);
                return;
            }
        }
        if (z) {
            char[] cArr2 = this.buf;
            cArr2[this.count] = Typography.quote;
            int i2 = i - 1;
            IOUtils.getChars(j, i2, cArr2);
            this.buf[i2] = Typography.quote;
        } else {
            IOUtils.getChars(j, i, this.buf);
        }
        this.count = i;
    }

    public void writeNull() {
        write(StringUtil.NULL_STRING);
    }

    public void writeString(String str, char c2) {
        if (this.useSingleQuotes) {
            writeStringWithSingleQuote(str);
            write(c2);
            return;
        }
        writeStringWithDoubleQuote(str, c2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:165:0x0305, code lost:
        if (r8[r10] == 4) goto L183;
     */
    /* JADX WARN: Code restructure failed: missing block: B:212:0x044c, code lost:
        if (r4 != '>') goto L229;
     */
    /* JADX WARN: Removed duplicated region for block: B:169:0x030c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void writeStringWithDoubleQuote(String str, char c2) {
        if (str == null) {
            writeNull();
            if (c2 != 0) {
                write(c2);
                return;
            }
            return;
        }
        int length = str.length();
        int i = this.count + length + 2;
        if (c2 != 0) {
            i++;
        }
        int length2 = this.buf.length;
        char c3 = Typography.greater;
        if (i > length2) {
            if (this.writer != null) {
                write(34);
                int i2 = 0;
                while (i2 < str.length()) {
                    char charAt = str.charAt(i2);
                    if (isEnabled(SerializerFeature.BrowserSecure) && (charAt == '(' || charAt == ')' || charAt == '<' || charAt == c3)) {
                        write(92);
                        write(117);
                        write(IOUtils.DIGITS[(charAt >>> '\f') & 15]);
                        write(IOUtils.DIGITS[(charAt >>> '\b') & 15]);
                        write(IOUtils.DIGITS[(charAt >>> 4) & 15]);
                        write(IOUtils.DIGITS[charAt & 15]);
                    } else if (!isEnabled(SerializerFeature.BrowserCompatible)) {
                        byte[] bArr = IOUtils.specicalFlags_doubleQuotes;
                        if ((charAt < bArr.length && bArr[charAt] != 0) || (charAt == '/' && isEnabled(SerializerFeature.WriteSlashAsSpecial))) {
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
                    } else if (charAt == '\b' || charAt == '\f' || charAt == '\n' || charAt == '\r' || charAt == '\t' || charAt == '\"' || charAt == '/' || charAt == '\\') {
                        write(92);
                        write(IOUtils.replaceChars[charAt]);
                    } else if (charAt < ' ') {
                        write(92);
                        write(117);
                        write(48);
                        write(48);
                        int i3 = charAt * 2;
                        write(IOUtils.ASCII_CHARS[i3]);
                        write(IOUtils.ASCII_CHARS[i3 + 1]);
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
                    i2++;
                    c3 = Typography.greater;
                }
                write(34);
                if (c2 != 0) {
                    write(c2);
                    return;
                }
                return;
            }
            expandCapacity(i);
        }
        int i4 = this.count;
        int i5 = i4 + 1;
        int i6 = i5 + length;
        char[] cArr = this.buf;
        cArr[i4] = Typography.quote;
        str.getChars(0, length, cArr, i5);
        this.count = i;
        int i7 = -1;
        if (isEnabled(SerializerFeature.BrowserCompatible)) {
            for (int i8 = i5; i8 < i6; i8++) {
                char c4 = this.buf[i8];
                if (c4 == '\"' || c4 == '/' || c4 == '\\' || c4 == '\b' || c4 == '\f' || c4 == '\n' || c4 == '\r' || c4 == '\t') {
                    i++;
                } else if (c4 < ' ' || c4 >= 127) {
                    i += 5;
                }
                i7 = i8;
            }
            if (i > this.buf.length) {
                expandCapacity(i);
            }
            this.count = i;
            while (i7 >= i5) {
                char[] cArr2 = this.buf;
                char c5 = cArr2[i7];
                if (c5 == '\b' || c5 == '\f' || c5 == '\n' || c5 == '\r' || c5 == '\t') {
                    char[] cArr3 = this.buf;
                    int i9 = i7 + 1;
                    System.arraycopy(cArr3, i9, cArr3, i7 + 2, (i6 - i7) - 1);
                    char[] cArr4 = this.buf;
                    cArr4[i7] = '\\';
                    cArr4[i9] = IOUtils.replaceChars[c5];
                } else if (c5 == '\"' || c5 == '/' || c5 == '\\') {
                    char[] cArr5 = this.buf;
                    int i10 = i7 + 1;
                    System.arraycopy(cArr5, i10, cArr5, i7 + 2, (i6 - i7) - 1);
                    char[] cArr6 = this.buf;
                    cArr6[i7] = '\\';
                    cArr6[i10] = c5;
                } else {
                    if (c5 < ' ') {
                        int i11 = i7 + 1;
                        System.arraycopy(cArr2, i11, cArr2, i7 + 6, (i6 - i7) - 1);
                        char[] cArr7 = this.buf;
                        cArr7[i7] = '\\';
                        cArr7[i11] = 'u';
                        cArr7[i7 + 2] = '0';
                        cArr7[i7 + 3] = '0';
                        char[] cArr8 = IOUtils.ASCII_CHARS;
                        int i12 = c5 * 2;
                        cArr7[i7 + 4] = cArr8[i12];
                        cArr7[i7 + 5] = cArr8[i12 + 1];
                    } else if (c5 >= 127) {
                        int i13 = i7 + 1;
                        System.arraycopy(cArr2, i13, cArr2, i7 + 6, (i6 - i7) - 1);
                        char[] cArr9 = this.buf;
                        cArr9[i7] = '\\';
                        cArr9[i13] = 'u';
                        char[] cArr10 = IOUtils.DIGITS;
                        cArr9[i7 + 2] = cArr10[(c5 >>> '\f') & 15];
                        cArr9[i7 + 3] = cArr10[(c5 >>> '\b') & 15];
                        cArr9[i7 + 4] = cArr10[(c5 >>> 4) & 15];
                        cArr9[i7 + 5] = cArr10[c5 & 15];
                    } else {
                        i7--;
                    }
                    i6 += 5;
                    i7--;
                }
                i6++;
                i7--;
            }
            if (c2 != 0) {
                char[] cArr11 = this.buf;
                int i14 = this.count;
                cArr11[i14 - 2] = Typography.quote;
                cArr11[i14 - 1] = c2;
                return;
            }
            this.buf[this.count - 1] = Typography.quote;
            return;
        }
        int i15 = -1;
        int i16 = 0;
        char c6 = 0;
        int i17 = -1;
        for (int i18 = i5; i18 < i6; i18++) {
            char c7 = this.buf[i18];
            if (c7 >= ']') {
                if (c7 >= 127 && (c7 == 8232 || c7 == 8233 || c7 < 160)) {
                    if (i15 == i7) {
                        i15 = i18;
                    }
                    i16++;
                    i += 4;
                    i17 = i18;
                }
            } else if ((c7 < '@' && (this.sepcialBits & (1 << c7)) != 0) || c7 == '\\') {
                i16++;
                if (c7 != '(' && c7 != ')' && c7 != '<' && c7 != '>') {
                    byte[] bArr2 = IOUtils.specicalFlags_doubleQuotes;
                    if (c7 < bArr2.length) {
                    }
                    i7 = -1;
                    if (i15 == -1) {
                        i15 = i18;
                        i17 = i15;
                    }
                    i17 = i18;
                }
                i += 4;
                i7 = -1;
                if (i15 == -1) {
                }
                i17 = i18;
            } else {
                i7 = -1;
            }
            c6 = c7;
        }
        if (i16 > 0) {
            int i19 = i + i16;
            if (i19 > this.buf.length) {
                expandCapacity(i19);
            }
            this.count = i19;
            if (i16 == 1) {
                if (c6 == 8232) {
                    int i20 = i17 + 1;
                    char[] cArr12 = this.buf;
                    System.arraycopy(cArr12, i20, cArr12, i17 + 6, (i6 - i17) - 1);
                    char[] cArr13 = this.buf;
                    cArr13[i17] = '\\';
                    cArr13[i20] = 'u';
                    int i21 = i20 + 1;
                    cArr13[i21] = '2';
                    int i22 = i21 + 1;
                    cArr13[i22] = '0';
                    int i23 = i22 + 1;
                    cArr13[i23] = '2';
                    cArr13[i23 + 1] = '8';
                } else if (c6 == 8233) {
                    int i24 = i17 + 1;
                    char[] cArr14 = this.buf;
                    System.arraycopy(cArr14, i24, cArr14, i17 + 6, (i6 - i17) - 1);
                    char[] cArr15 = this.buf;
                    cArr15[i17] = '\\';
                    cArr15[i24] = 'u';
                    int i25 = i24 + 1;
                    cArr15[i25] = '2';
                    int i26 = i25 + 1;
                    cArr15[i26] = '0';
                    int i27 = i26 + 1;
                    cArr15[i27] = '2';
                    cArr15[i27 + 1] = '9';
                } else if (c6 != '(' && c6 != ')' && c6 != '<' && c6 != '>') {
                    byte[] bArr3 = IOUtils.specicalFlags_doubleQuotes;
                    if (c6 < bArr3.length && bArr3[c6] == 4) {
                        int i28 = i17 + 1;
                        char[] cArr16 = this.buf;
                        System.arraycopy(cArr16, i28, cArr16, i17 + 6, (i6 - i17) - 1);
                        char[] cArr17 = this.buf;
                        cArr17[i17] = '\\';
                        int i29 = i28 + 1;
                        cArr17[i28] = 'u';
                        int i30 = i29 + 1;
                        char[] cArr18 = IOUtils.DIGITS;
                        cArr17[i29] = cArr18[(c6 >>> '\f') & 15];
                        int i31 = i30 + 1;
                        cArr17[i30] = cArr18[(c6 >>> '\b') & 15];
                        cArr17[i31] = cArr18[(c6 >>> 4) & 15];
                        cArr17[i31 + 1] = cArr18[c6 & 15];
                    } else {
                        int i32 = i17 + 1;
                        char[] cArr19 = this.buf;
                        System.arraycopy(cArr19, i32, cArr19, i17 + 2, (i6 - i17) - 1);
                        char[] cArr20 = this.buf;
                        cArr20[i17] = '\\';
                        cArr20[i32] = IOUtils.replaceChars[c6];
                    }
                } else {
                    int i33 = i17 + 1;
                    char[] cArr21 = this.buf;
                    System.arraycopy(cArr21, i33, cArr21, i17 + 6, (i6 - i17) - 1);
                    char[] cArr22 = this.buf;
                    cArr22[i17] = '\\';
                    cArr22[i33] = 'u';
                    int i34 = i33 + 1;
                    char[] cArr23 = IOUtils.DIGITS;
                    cArr22[i34] = cArr23[(c6 >>> '\f') & 15];
                    int i35 = i34 + 1;
                    cArr22[i35] = cArr23[(c6 >>> '\b') & 15];
                    int i36 = i35 + 1;
                    cArr22[i36] = cArr23[(c6 >>> 4) & 15];
                    cArr22[i36 + 1] = cArr23[c6 & 15];
                }
            } else if (i16 > 1) {
                for (int i37 = i15 - i5; i37 < str.length(); i37++) {
                    char charAt2 = str.charAt(i37);
                    if (this.browserSecure) {
                        if (charAt2 != '(' && charAt2 != ')') {
                            if (charAt2 != '<') {
                            }
                        }
                        char[] cArr24 = this.buf;
                        int i38 = i15 + 1;
                        cArr24[i15] = '\\';
                        int i39 = i38 + 1;
                        cArr24[i38] = 'u';
                        int i40 = i39 + 1;
                        char[] cArr25 = IOUtils.DIGITS;
                        cArr24[i39] = cArr25[(charAt2 >>> '\f') & 15];
                        int i41 = i40 + 1;
                        cArr24[i40] = cArr25[(charAt2 >>> '\b') & 15];
                        int i42 = i41 + 1;
                        cArr24[i41] = cArr25[(charAt2 >>> 4) & 15];
                        i15 = i42 + 1;
                        cArr24[i42] = cArr25[charAt2 & 15];
                    }
                    byte[] bArr4 = IOUtils.specicalFlags_doubleQuotes;
                    if ((charAt2 >= bArr4.length || bArr4[charAt2] == 0) && (charAt2 != '/' || !isEnabled(SerializerFeature.WriteSlashAsSpecial))) {
                        if (charAt2 != 8232 && charAt2 != 8233) {
                            this.buf[i15] = charAt2;
                            i15++;
                        } else {
                            char[] cArr26 = this.buf;
                            int i43 = i15 + 1;
                            cArr26[i15] = '\\';
                            int i44 = i43 + 1;
                            cArr26[i43] = 'u';
                            int i45 = i44 + 1;
                            char[] cArr27 = IOUtils.DIGITS;
                            cArr26[i44] = cArr27[(charAt2 >>> '\f') & 15];
                            int i46 = i45 + 1;
                            cArr26[i45] = cArr27[(charAt2 >>> '\b') & 15];
                            int i47 = i46 + 1;
                            cArr26[i46] = cArr27[(charAt2 >>> 4) & 15];
                            i15 = i47 + 1;
                            cArr26[i47] = cArr27[charAt2 & 15];
                        }
                    }
                    char[] cArr28 = this.buf;
                    int i48 = i15 + 1;
                    cArr28[i15] = '\\';
                    if (IOUtils.specicalFlags_doubleQuotes[charAt2] == 4) {
                        int i49 = i48 + 1;
                        cArr28[i48] = 'u';
                        int i50 = i49 + 1;
                        char[] cArr29 = IOUtils.DIGITS;
                        cArr28[i49] = cArr29[(charAt2 >>> '\f') & 15];
                        int i51 = i50 + 1;
                        cArr28[i50] = cArr29[(charAt2 >>> '\b') & 15];
                        int i52 = i51 + 1;
                        cArr28[i51] = cArr29[(charAt2 >>> 4) & 15];
                        i15 = i52 + 1;
                        cArr28[i52] = cArr29[charAt2 & 15];
                    } else {
                        i15 = i48 + 1;
                        cArr28[i48] = IOUtils.replaceChars[charAt2];
                    }
                }
            }
        }
        if (c2 != 0) {
            char[] cArr30 = this.buf;
            int i53 = this.count;
            cArr30[i53 - 2] = Typography.quote;
            cArr30[i53 - 1] = c2;
            return;
        }
        this.buf[this.count - 1] = Typography.quote;
    }

    public void writeStringWithSingleQuote(String str) {
        int i = 0;
        if (str == null) {
            int i2 = this.count + 4;
            if (i2 > this.buf.length) {
                expandCapacity(i2);
            }
            StringUtil.NULL_STRING.getChars(0, 4, this.buf, this.count);
            this.count = i2;
            return;
        }
        int length = str.length();
        int i3 = this.count + length + 2;
        if (i3 > this.buf.length) {
            if (this.writer != null) {
                write(39);
                while (i < str.length()) {
                    char charAt = str.charAt(i);
                    if (charAt > '\r' && charAt != '\\' && charAt != '\'' && (charAt != '/' || !isEnabled(SerializerFeature.WriteSlashAsSpecial))) {
                        write(charAt);
                    } else {
                        write(92);
                        write(IOUtils.replaceChars[charAt]);
                    }
                    i++;
                }
                write(39);
                return;
            }
            expandCapacity(i3);
        }
        int i4 = this.count;
        int i5 = i4 + 1;
        int i6 = i5 + length;
        char[] cArr = this.buf;
        cArr[i4] = '\'';
        str.getChars(0, length, cArr, i5);
        this.count = i3;
        int i7 = -1;
        char c2 = 0;
        for (int i8 = i5; i8 < i6; i8++) {
            char c3 = this.buf[i8];
            if (c3 <= '\r' || c3 == '\\' || c3 == '\'' || (c3 == '/' && isEnabled(SerializerFeature.WriteSlashAsSpecial))) {
                i++;
                i7 = i8;
                c2 = c3;
            }
        }
        int i9 = i3 + i;
        if (i9 > this.buf.length) {
            expandCapacity(i9);
        }
        this.count = i9;
        if (i == 1) {
            char[] cArr2 = this.buf;
            int i10 = i7 + 1;
            System.arraycopy(cArr2, i10, cArr2, i7 + 2, (i6 - i7) - 1);
            char[] cArr3 = this.buf;
            cArr3[i7] = '\\';
            cArr3[i10] = IOUtils.replaceChars[c2];
        } else if (i > 1) {
            char[] cArr4 = this.buf;
            int i11 = i7 + 1;
            System.arraycopy(cArr4, i11, cArr4, i7 + 2, (i6 - i7) - 1);
            char[] cArr5 = this.buf;
            cArr5[i7] = '\\';
            cArr5[i11] = IOUtils.replaceChars[c2];
            int i12 = i6 + 1;
            for (int i13 = i11 - 2; i13 >= i5; i13--) {
                char c4 = this.buf[i13];
                if (c4 <= '\r' || c4 == '\\' || c4 == '\'' || (c4 == '/' && isEnabled(SerializerFeature.WriteSlashAsSpecial))) {
                    char[] cArr6 = this.buf;
                    int i14 = i13 + 1;
                    System.arraycopy(cArr6, i14, cArr6, i13 + 2, (i12 - i13) - 1);
                    char[] cArr7 = this.buf;
                    cArr7[i13] = '\\';
                    cArr7[i14] = IOUtils.replaceChars[c4];
                    i12++;
                }
            }
        }
        this.buf[this.count - 1] = '\'';
    }

    public void writeTo(Writer writer) throws IOException {
        if (this.writer == null) {
            writer.write(this.buf, 0, this.count);
            return;
        }
        throw new UnsupportedOperationException("writer not null");
    }

    public int writeToEx(OutputStream outputStream, Charset charset) throws IOException {
        if (this.writer == null) {
            if (charset == IOUtils.UTF8) {
                return encodeToUTF8(outputStream);
            }
            byte[] bytes = new String(this.buf, 0, this.count).getBytes(charset);
            outputStream.write(bytes);
            return bytes.length;
        }
        throw new UnsupportedOperationException("writer not null");
    }

    public SerializeWriter(Writer writer) {
        this(writer, JSON.DEFAULT_GENERATE_FEATURE, SerializerFeature.EMPTY);
    }

    public boolean isEnabled(int i) {
        return (i & this.features) != 0;
    }

    public void writeFieldName(String str, boolean z) {
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
            boolean z2 = true;
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

    public void writeNull(SerializerFeature serializerFeature) {
        writeNull(0, serializerFeature.mask);
    }

    public SerializeWriter(SerializerFeature... serializerFeatureArr) {
        this((Writer) null, serializerFeatureArr);
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

    public SerializeWriter(Writer writer, SerializerFeature... serializerFeatureArr) {
        this(writer, 0, serializerFeatureArr);
    }

    public byte[] toBytes(Charset charset) {
        if (this.writer == null) {
            if (charset == IOUtils.UTF8) {
                return encodeToUTF8Bytes();
            }
            return new String(this.buf, 0, this.count).getBytes(charset);
        }
        throw new UnsupportedOperationException("writer not null");
    }

    public void writeTo(OutputStream outputStream, String str) throws IOException {
        writeTo(outputStream, Charset.forName(str));
    }

    public SerializeWriter(Writer writer, int i, SerializerFeature... serializerFeatureArr) {
        this.maxBufSize = -1;
        this.writer = writer;
        char[] cArr = bufLocal.get();
        this.buf = cArr;
        if (cArr != null) {
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

    public void writeFieldValue(char c2, String str, boolean z) {
        if (!this.quoteFieldNames) {
            write(c2);
            writeFieldName(str);
            write(z);
            return;
        }
        int i = z ? 4 : 5;
        int length = str.length();
        int i2 = this.count + length + 4 + i;
        if (i2 > this.buf.length) {
            if (this.writer != null) {
                write(c2);
                writeString(str);
                write(58);
                write(z);
                return;
            }
            expandCapacity(i2);
        }
        int i3 = this.count;
        this.count = i2;
        char[] cArr = this.buf;
        cArr[i3] = c2;
        int i4 = i3 + length + 1;
        cArr[i3 + 1] = this.keySeperator;
        str.getChars(0, length, cArr, i3 + 2);
        this.buf[i4 + 1] = this.keySeperator;
        if (z) {
            System.arraycopy(":true".toCharArray(), 0, this.buf, i4 + 2, 5);
        } else {
            System.arraycopy(":false".toCharArray(), 0, this.buf, i4 + 2, 6);
        }
    }

    public void writeString(String str) {
        if (this.useSingleQuotes) {
            writeStringWithSingleQuote(str);
        } else {
            writeStringWithDoubleQuote(str, (char) 0);
        }
    }

    public void writeTo(OutputStream outputStream, Charset charset) throws IOException {
        writeToEx(outputStream, charset);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.io.Writer, java.lang.Appendable
    public SerializeWriter append(CharSequence charSequence) {
        String charSequence2 = charSequence == null ? StringUtil.NULL_STRING : charSequence.toString();
        write(charSequence2, 0, charSequence2.length());
        return this;
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i, int i2) {
        int i3;
        if (i < 0 || i > cArr.length || i2 < 0 || (i3 = i + i2) > cArr.length || i3 < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (i2 == 0) {
            return;
        }
        int i4 = this.count + i2;
        if (i4 > this.buf.length) {
            if (this.writer == null) {
                expandCapacity(i4);
            } else {
                do {
                    char[] cArr2 = this.buf;
                    int length = cArr2.length;
                    int i5 = this.count;
                    int i6 = length - i5;
                    System.arraycopy(cArr, i, cArr2, i5, i6);
                    this.count = this.buf.length;
                    flush();
                    i2 -= i6;
                    i += i6;
                } while (i2 > this.buf.length);
                i4 = i2;
            }
        }
        System.arraycopy(cArr, i, this.buf, this.count, i2);
        this.count = i4;
    }

    public void writeString(char[] cArr) {
        if (this.useSingleQuotes) {
            writeStringWithSingleQuote(cArr);
        } else {
            writeStringWithDoubleQuote(new String(cArr), (char) 0);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.io.Writer, java.lang.Appendable
    public SerializeWriter append(CharSequence charSequence, int i, int i2) {
        if (charSequence == null) {
            charSequence = StringUtil.NULL_STRING;
        }
        String charSequence2 = charSequence.subSequence(i, i2).toString();
        write(charSequence2, 0, charSequence2.length());
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.io.Writer, java.lang.Appendable
    public SerializeWriter append(char c2) {
        write(c2);
        return this;
    }

    public SerializeWriter(int i) {
        this((Writer) null, i);
    }

    public SerializeWriter(Writer writer, int i) {
        this.maxBufSize = -1;
        this.writer = writer;
        if (i > 0) {
            this.buf = new char[i];
            computeFeatures();
            return;
        }
        throw new IllegalArgumentException("Negative initial size: " + i);
    }

    @Override // java.io.Writer
    public void write(String str, int i, int i2) {
        int i3;
        int i4 = this.count + i2;
        if (i4 > this.buf.length) {
            if (this.writer == null) {
                expandCapacity(i4);
            } else {
                while (true) {
                    char[] cArr = this.buf;
                    int length = cArr.length;
                    int i5 = this.count;
                    int i6 = length - i5;
                    i3 = i + i6;
                    str.getChars(i, i3, cArr, i5);
                    this.count = this.buf.length;
                    flush();
                    i2 -= i6;
                    if (i2 <= this.buf.length) {
                        break;
                    }
                    i = i3;
                }
                i4 = i2;
                i = i3;
            }
        }
        str.getChars(i, i2 + i, this.buf, this.count);
        this.count = i4;
    }

    public void writeFieldValue(char c2, String str, int i) {
        if (i != Integer.MIN_VALUE && this.quoteFieldNames) {
            int stringSize = i < 0 ? IOUtils.stringSize(-i) + 1 : IOUtils.stringSize(i);
            int length = str.length();
            int i2 = this.count + length + 4 + stringSize;
            if (i2 > this.buf.length) {
                if (this.writer != null) {
                    write(c2);
                    writeFieldName(str);
                    writeInt(i);
                    return;
                }
                expandCapacity(i2);
            }
            int i3 = this.count;
            this.count = i2;
            char[] cArr = this.buf;
            cArr[i3] = c2;
            int i4 = i3 + length + 1;
            cArr[i3 + 1] = this.keySeperator;
            str.getChars(0, length, cArr, i3 + 2);
            char[] cArr2 = this.buf;
            cArr2[i4 + 1] = this.keySeperator;
            cArr2[i4 + 2] = ':';
            IOUtils.getChars(i, this.count, cArr2);
            return;
        }
        write(c2);
        writeFieldName(str);
        writeInt(i);
    }

    @Override // java.io.Writer
    public void write(String str) {
        if (str == null) {
            writeNull();
        } else {
            write(str, 0, str.length());
        }
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
        int i3 = i2;
        int i4 = 0;
        while (i4 < size) {
            String str = list.get(i4);
            if (str == null) {
                z = true;
            } else {
                int length = str.length();
                z = false;
                for (int i5 = 0; i5 < length; i5++) {
                    char charAt = str.charAt(i5);
                    z = charAt < ' ' || charAt > '~' || charAt == '\"' || charAt == '\\';
                    if (z) {
                        break;
                    }
                }
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
                        write(StringUtil.NULL_STRING);
                    } else {
                        writeStringWithDoubleQuote(str2, (char) 0);
                    }
                }
                write(93);
                return;
            }
            int length2 = str.length() + i3 + 3;
            if (i4 == list.size() - 1) {
                length2++;
            }
            if (length2 > this.buf.length) {
                this.count = i3;
                expandCapacity(length2);
            }
            if (i4 == 0) {
                i = i3 + 1;
                this.buf[i3] = '[';
            } else {
                i = i3 + 1;
                this.buf[i3] = ',';
            }
            int i7 = i + 1;
            this.buf[i] = Typography.quote;
            str.getChars(0, str.length(), this.buf, i7);
            int length3 = i7 + str.length();
            this.buf[length3] = Typography.quote;
            i4++;
            i3 = length3 + 1;
        }
        this.buf[i3] = ']';
        this.count = i3 + 1;
    }

    public void writeStringWithSingleQuote(char[] cArr) {
        int i = 0;
        if (cArr == null) {
            int i2 = this.count + 4;
            if (i2 > this.buf.length) {
                expandCapacity(i2);
            }
            StringUtil.NULL_STRING.getChars(0, 4, this.buf, this.count);
            this.count = i2;
            return;
        }
        int length = cArr.length;
        int i3 = this.count + length + 2;
        if (i3 > this.buf.length) {
            if (this.writer != null) {
                write(39);
                while (i < cArr.length) {
                    char c2 = cArr[i];
                    if (c2 > '\r' && c2 != '\\' && c2 != '\'' && (c2 != '/' || !isEnabled(SerializerFeature.WriteSlashAsSpecial))) {
                        write(c2);
                    } else {
                        write(92);
                        write(IOUtils.replaceChars[c2]);
                    }
                    i++;
                }
                write(39);
                return;
            }
            expandCapacity(i3);
        }
        int i4 = this.count;
        int i5 = i4 + 1;
        int i6 = length + i5;
        char[] cArr2 = this.buf;
        cArr2[i4] = '\'';
        System.arraycopy(cArr, 0, cArr2, i5, cArr.length);
        this.count = i3;
        int i7 = -1;
        char c3 = 0;
        for (int i8 = i5; i8 < i6; i8++) {
            char c4 = this.buf[i8];
            if (c4 <= '\r' || c4 == '\\' || c4 == '\'' || (c4 == '/' && isEnabled(SerializerFeature.WriteSlashAsSpecial))) {
                i++;
                i7 = i8;
                c3 = c4;
            }
        }
        int i9 = i3 + i;
        if (i9 > this.buf.length) {
            expandCapacity(i9);
        }
        this.count = i9;
        if (i == 1) {
            char[] cArr3 = this.buf;
            int i10 = i7 + 1;
            System.arraycopy(cArr3, i10, cArr3, i7 + 2, (i6 - i7) - 1);
            char[] cArr4 = this.buf;
            cArr4[i7] = '\\';
            cArr4[i10] = IOUtils.replaceChars[c3];
        } else if (i > 1) {
            char[] cArr5 = this.buf;
            int i11 = i7 + 1;
            System.arraycopy(cArr5, i11, cArr5, i7 + 2, (i6 - i7) - 1);
            char[] cArr6 = this.buf;
            cArr6[i7] = '\\';
            cArr6[i11] = IOUtils.replaceChars[c3];
            int i12 = i6 + 1;
            for (int i13 = i11 - 2; i13 >= i5; i13--) {
                char c5 = this.buf[i13];
                if (c5 <= '\r' || c5 == '\\' || c5 == '\'' || (c5 == '/' && isEnabled(SerializerFeature.WriteSlashAsSpecial))) {
                    char[] cArr7 = this.buf;
                    int i14 = i13 + 1;
                    System.arraycopy(cArr7, i14, cArr7, i13 + 2, (i12 - i13) - 1);
                    char[] cArr8 = this.buf;
                    cArr8[i13] = '\\';
                    cArr8[i14] = IOUtils.replaceChars[c5];
                    i12++;
                }
            }
        }
        this.buf[this.count - 1] = '\'';
    }

    public void writeFieldValue(char c2, String str, long j) {
        if (j != Long.MIN_VALUE && this.quoteFieldNames) {
            int stringSize = j < 0 ? IOUtils.stringSize(-j) + 1 : IOUtils.stringSize(j);
            int length = str.length();
            int i = this.count + length + 4 + stringSize;
            if (i > this.buf.length) {
                if (this.writer != null) {
                    write(c2);
                    writeFieldName(str);
                    writeLong(j);
                    return;
                }
                expandCapacity(i);
            }
            int i2 = this.count;
            this.count = i;
            char[] cArr = this.buf;
            cArr[i2] = c2;
            int i3 = i2 + length + 1;
            cArr[i2 + 1] = this.keySeperator;
            str.getChars(0, length, cArr, i2 + 2);
            char[] cArr2 = this.buf;
            cArr2[i3 + 1] = this.keySeperator;
            cArr2[i3 + 2] = ':';
            IOUtils.getChars(j, this.count, cArr2);
            return;
        }
        write(c2);
        writeFieldName(str);
        writeLong(j);
    }

    public void write(boolean z) {
        if (z) {
            write("true");
        } else {
            write("false");
        }
    }

    public void writeFieldValue(char c2, String str, float f2) {
        write(c2);
        writeFieldName(str);
        writeFloat(f2, false);
    }

    public void writeFieldValue(char c2, String str, double d2) {
        write(c2);
        writeFieldName(str);
        writeDouble(d2, false);
    }

    public void writeFieldValue(char c2, String str, String str2) {
        if (this.quoteFieldNames) {
            if (this.useSingleQuotes) {
                write(c2);
                writeFieldName(str);
                if (str2 == null) {
                    writeNull();
                    return;
                } else {
                    writeString(str2);
                    return;
                }
            } else if (isEnabled(SerializerFeature.BrowserCompatible)) {
                write(c2);
                writeStringWithDoubleQuote(str, ':');
                writeStringWithDoubleQuote(str2, (char) 0);
                return;
            } else {
                writeFieldValueStringWithDoubleQuoteCheck(c2, str, str2);
                return;
            }
        }
        write(c2);
        writeFieldName(str);
        if (str2 == null) {
            writeNull();
        } else {
            writeString(str2);
        }
    }

    public void writeFieldValue(char c2, String str, Enum<?> r4) {
        if (r4 == null) {
            write(c2);
            writeFieldName(str);
            writeNull();
        } else if (this.writeEnumUsingName && !this.writeEnumUsingToString) {
            writeEnumFieldValue(c2, str, r4.name());
        } else if (this.writeEnumUsingToString) {
            writeEnumFieldValue(c2, str, r4.toString());
        } else {
            writeFieldValue(c2, str, r4.ordinal());
        }
    }

    public void writeFieldValue(char c2, String str, BigDecimal bigDecimal) {
        write(c2);
        writeFieldName(str);
        if (bigDecimal == null) {
            writeNull();
        } else {
            write(bigDecimal.toString());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:165:0x0301, code lost:
        if (r7[r10] == 4) goto L184;
     */
    /* JADX WARN: Code restructure failed: missing block: B:214:0x0448, code lost:
        if (r3 != '>') goto L229;
     */
    /* JADX WARN: Removed duplicated region for block: B:169:0x030a  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x030e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void writeStringWithDoubleQuote(char[] cArr, char c2) {
        int i;
        if (cArr == null) {
            writeNull();
            if (c2 != 0) {
                write(c2);
                return;
            }
            return;
        }
        int length = cArr.length;
        int i2 = this.count + length + 2;
        if (c2 != 0) {
            i2++;
        }
        int length2 = this.buf.length;
        char c3 = Typography.greater;
        if (i2 > length2) {
            if (this.writer != null) {
                write(34);
                int i3 = 0;
                while (i3 < cArr.length) {
                    char c4 = cArr[i3];
                    if (isEnabled(SerializerFeature.BrowserSecure) && (c4 == '(' || c4 == ')' || c4 == '<' || c4 == c3)) {
                        write(92);
                        write(117);
                        write(IOUtils.DIGITS[(c4 >>> '\f') & 15]);
                        write(IOUtils.DIGITS[(c4 >>> '\b') & 15]);
                        write(IOUtils.DIGITS[(c4 >>> 4) & 15]);
                        write(IOUtils.DIGITS[c4 & 15]);
                    } else if (!isEnabled(SerializerFeature.BrowserCompatible)) {
                        byte[] bArr = IOUtils.specicalFlags_doubleQuotes;
                        if ((c4 < bArr.length && bArr[c4] != 0) || (c4 == '/' && isEnabled(SerializerFeature.WriteSlashAsSpecial))) {
                            write(92);
                            if (IOUtils.specicalFlags_doubleQuotes[c4] == 4) {
                                write(117);
                                write(IOUtils.DIGITS[(c4 >>> '\f') & 15]);
                                write(IOUtils.DIGITS[(c4 >>> '\b') & 15]);
                                write(IOUtils.DIGITS[(c4 >>> 4) & 15]);
                                write(IOUtils.DIGITS[c4 & 15]);
                            } else {
                                write(IOUtils.replaceChars[c4]);
                            }
                        }
                        write(c4);
                    } else if (c4 == '\b' || c4 == '\f' || c4 == '\n' || c4 == '\r' || c4 == '\t' || c4 == '\"' || c4 == '/' || c4 == '\\') {
                        write(92);
                        write(IOUtils.replaceChars[c4]);
                    } else if (c4 < ' ') {
                        write(92);
                        write(117);
                        write(48);
                        write(48);
                        int i4 = c4 * 2;
                        write(IOUtils.ASCII_CHARS[i4]);
                        write(IOUtils.ASCII_CHARS[i4 + 1]);
                    } else {
                        if (c4 >= 127) {
                            write(92);
                            write(117);
                            write(IOUtils.DIGITS[(c4 >>> '\f') & 15]);
                            write(IOUtils.DIGITS[(c4 >>> '\b') & 15]);
                            write(IOUtils.DIGITS[(c4 >>> 4) & 15]);
                            write(IOUtils.DIGITS[c4 & 15]);
                        }
                        write(c4);
                    }
                    i3++;
                    c3 = Typography.greater;
                }
                write(34);
                if (c2 != 0) {
                    write(c2);
                    return;
                }
                return;
            }
            expandCapacity(i2);
        }
        int i5 = this.count;
        int i6 = i5 + 1;
        int i7 = length + i6;
        char[] cArr2 = this.buf;
        cArr2[i5] = Typography.quote;
        System.arraycopy(cArr, 0, cArr2, i6, cArr.length);
        this.count = i2;
        int i8 = -1;
        if (isEnabled(SerializerFeature.BrowserCompatible)) {
            for (int i9 = i6; i9 < i7; i9++) {
                char c5 = this.buf[i9];
                if (c5 == '\"' || c5 == '/' || c5 == '\\' || c5 == '\b' || c5 == '\f' || c5 == '\n' || c5 == '\r' || c5 == '\t') {
                    i2++;
                } else if (c5 < ' ' || c5 >= 127) {
                    i2 += 5;
                }
                i8 = i9;
            }
            if (i2 > this.buf.length) {
                expandCapacity(i2);
            }
            this.count = i2;
            while (i8 >= i6) {
                char[] cArr3 = this.buf;
                char c6 = cArr3[i8];
                if (c6 == '\b' || c6 == '\f' || c6 == '\n' || c6 == '\r' || c6 == '\t') {
                    char[] cArr4 = this.buf;
                    int i10 = i8 + 1;
                    System.arraycopy(cArr4, i10, cArr4, i8 + 2, (i7 - i8) - 1);
                    char[] cArr5 = this.buf;
                    cArr5[i8] = '\\';
                    cArr5[i10] = IOUtils.replaceChars[c6];
                } else if (c6 == '\"' || c6 == '/' || c6 == '\\') {
                    char[] cArr6 = this.buf;
                    int i11 = i8 + 1;
                    System.arraycopy(cArr6, i11, cArr6, i8 + 2, (i7 - i8) - 1);
                    char[] cArr7 = this.buf;
                    cArr7[i8] = '\\';
                    cArr7[i11] = c6;
                } else {
                    if (c6 < ' ') {
                        int i12 = i8 + 1;
                        System.arraycopy(cArr3, i12, cArr3, i8 + 6, (i7 - i8) - 1);
                        char[] cArr8 = this.buf;
                        cArr8[i8] = '\\';
                        cArr8[i12] = 'u';
                        cArr8[i8 + 2] = '0';
                        cArr8[i8 + 3] = '0';
                        char[] cArr9 = IOUtils.ASCII_CHARS;
                        int i13 = c6 * 2;
                        cArr8[i8 + 4] = cArr9[i13];
                        cArr8[i8 + 5] = cArr9[i13 + 1];
                    } else if (c6 >= 127) {
                        int i14 = i8 + 1;
                        System.arraycopy(cArr3, i14, cArr3, i8 + 6, (i7 - i8) - 1);
                        char[] cArr10 = this.buf;
                        cArr10[i8] = '\\';
                        cArr10[i14] = 'u';
                        char[] cArr11 = IOUtils.DIGITS;
                        cArr10[i8 + 2] = cArr11[(c6 >>> '\f') & 15];
                        cArr10[i8 + 3] = cArr11[(c6 >>> '\b') & 15];
                        cArr10[i8 + 4] = cArr11[(c6 >>> 4) & 15];
                        cArr10[i8 + 5] = cArr11[c6 & 15];
                    } else {
                        i8--;
                    }
                    i7 += 5;
                    i8--;
                }
                i7++;
                i8--;
            }
            if (c2 != 0) {
                char[] cArr12 = this.buf;
                int i15 = this.count;
                cArr12[i15 - 2] = Typography.quote;
                cArr12[i15 - 1] = c2;
                return;
            }
            this.buf[this.count - 1] = Typography.quote;
            return;
        }
        int i16 = i6;
        int i17 = -1;
        int i18 = 0;
        char c7 = 0;
        int i19 = -1;
        while (i16 < i7) {
            char c8 = this.buf[i16];
            if (c8 < ']') {
                int i20 = i17;
                if ((c8 < '@' && (this.sepcialBits & (1 << c8)) != 0) || c8 == '\\') {
                    i18++;
                    if (c8 != '(' && c8 != ')' && c8 != '<' && c8 != '>') {
                        byte[] bArr2 = IOUtils.specicalFlags_doubleQuotes;
                        if (c8 < bArr2.length) {
                        }
                        i = i20;
                        if (i != -1) {
                            i = i16;
                            i19 = i;
                        } else {
                            i19 = i16;
                        }
                        c7 = c8;
                        i16++;
                        i17 = i;
                        i8 = -1;
                    }
                    i2 += 4;
                    i = i20;
                    if (i != -1) {
                    }
                    c7 = c8;
                    i16++;
                    i17 = i;
                    i8 = -1;
                } else {
                    i = i20;
                }
            } else if (c8 < 127 || !(c8 == 8232 || c8 == 8233 || c8 < 160)) {
                i = i17;
            } else {
                if (i17 == i8) {
                    i17 = i16;
                }
                i18++;
                i2 += 4;
                i19 = i16;
                i = i17;
                c7 = c8;
            }
            i16++;
            i17 = i;
            i8 = -1;
        }
        int i21 = i17;
        if (i18 > 0) {
            int i22 = i2 + i18;
            if (i22 > this.buf.length) {
                expandCapacity(i22);
            }
            this.count = i22;
            if (i18 == 1) {
                if (c7 == 8232) {
                    int i23 = i19 + 1;
                    char[] cArr13 = this.buf;
                    System.arraycopy(cArr13, i23, cArr13, i19 + 6, (i7 - i19) - 1);
                    char[] cArr14 = this.buf;
                    cArr14[i19] = '\\';
                    cArr14[i23] = 'u';
                    int i24 = i23 + 1;
                    cArr14[i24] = '2';
                    int i25 = i24 + 1;
                    cArr14[i25] = '0';
                    int i26 = i25 + 1;
                    cArr14[i26] = '2';
                    cArr14[i26 + 1] = '8';
                } else if (c7 == 8233) {
                    int i27 = i19 + 1;
                    char[] cArr15 = this.buf;
                    System.arraycopy(cArr15, i27, cArr15, i19 + 6, (i7 - i19) - 1);
                    char[] cArr16 = this.buf;
                    cArr16[i19] = '\\';
                    cArr16[i27] = 'u';
                    int i28 = i27 + 1;
                    cArr16[i28] = '2';
                    int i29 = i28 + 1;
                    cArr16[i29] = '0';
                    int i30 = i29 + 1;
                    cArr16[i30] = '2';
                    cArr16[i30 + 1] = '9';
                } else if (c7 != '(' && c7 != ')' && c7 != '<' && c7 != '>') {
                    byte[] bArr3 = IOUtils.specicalFlags_doubleQuotes;
                    if (c7 < bArr3.length && bArr3[c7] == 4) {
                        int i31 = i19 + 1;
                        char[] cArr17 = this.buf;
                        System.arraycopy(cArr17, i31, cArr17, i19 + 6, (i7 - i19) - 1);
                        char[] cArr18 = this.buf;
                        cArr18[i19] = '\\';
                        int i32 = i31 + 1;
                        cArr18[i31] = 'u';
                        int i33 = i32 + 1;
                        char[] cArr19 = IOUtils.DIGITS;
                        cArr18[i32] = cArr19[(c7 >>> '\f') & 15];
                        int i34 = i33 + 1;
                        cArr18[i33] = cArr19[(c7 >>> '\b') & 15];
                        cArr18[i34] = cArr19[(c7 >>> 4) & 15];
                        cArr18[i34 + 1] = cArr19[c7 & 15];
                    } else {
                        int i35 = i19 + 1;
                        char[] cArr20 = this.buf;
                        System.arraycopy(cArr20, i35, cArr20, i19 + 2, (i7 - i19) - 1);
                        char[] cArr21 = this.buf;
                        cArr21[i19] = '\\';
                        cArr21[i35] = IOUtils.replaceChars[c7];
                    }
                } else {
                    int i36 = i19 + 1;
                    char[] cArr22 = this.buf;
                    System.arraycopy(cArr22, i36, cArr22, i19 + 6, (i7 - i19) - 1);
                    char[] cArr23 = this.buf;
                    cArr23[i19] = '\\';
                    cArr23[i36] = 'u';
                    int i37 = i36 + 1;
                    char[] cArr24 = IOUtils.DIGITS;
                    cArr23[i37] = cArr24[(c7 >>> '\f') & 15];
                    int i38 = i37 + 1;
                    cArr23[i38] = cArr24[(c7 >>> '\b') & 15];
                    int i39 = i38 + 1;
                    cArr23[i39] = cArr24[(c7 >>> 4) & 15];
                    cArr23[i39 + 1] = cArr24[c7 & 15];
                }
            } else if (i18 > 1) {
                for (int i40 = i21 - i6; i40 < cArr.length; i40++) {
                    char c9 = cArr[i40];
                    if (this.browserSecure) {
                        if (c9 != '(' && c9 != ')') {
                            if (c9 != '<') {
                            }
                        }
                        char[] cArr25 = this.buf;
                        int i41 = i21 + 1;
                        cArr25[i21] = '\\';
                        int i42 = i41 + 1;
                        cArr25[i41] = 'u';
                        int i43 = i42 + 1;
                        char[] cArr26 = IOUtils.DIGITS;
                        cArr25[i42] = cArr26[(c9 >>> '\f') & 15];
                        int i44 = i43 + 1;
                        cArr25[i43] = cArr26[(c9 >>> '\b') & 15];
                        int i45 = i44 + 1;
                        cArr25[i44] = cArr26[(c9 >>> 4) & 15];
                        i21 = i45 + 1;
                        cArr25[i45] = cArr26[c9 & 15];
                    }
                    byte[] bArr4 = IOUtils.specicalFlags_doubleQuotes;
                    if ((c9 >= bArr4.length || bArr4[c9] == 0) && (c9 != '/' || !isEnabled(SerializerFeature.WriteSlashAsSpecial))) {
                        if (c9 != 8232 && c9 != 8233) {
                            this.buf[i21] = c9;
                            i21++;
                        } else {
                            char[] cArr27 = this.buf;
                            int i46 = i21 + 1;
                            cArr27[i21] = '\\';
                            int i47 = i46 + 1;
                            cArr27[i46] = 'u';
                            int i48 = i47 + 1;
                            char[] cArr28 = IOUtils.DIGITS;
                            cArr27[i47] = cArr28[(c9 >>> '\f') & 15];
                            int i49 = i48 + 1;
                            cArr27[i48] = cArr28[(c9 >>> '\b') & 15];
                            int i50 = i49 + 1;
                            cArr27[i49] = cArr28[(c9 >>> 4) & 15];
                            i21 = i50 + 1;
                            cArr27[i50] = cArr28[c9 & 15];
                        }
                    }
                    char[] cArr29 = this.buf;
                    int i51 = i21 + 1;
                    cArr29[i21] = '\\';
                    if (IOUtils.specicalFlags_doubleQuotes[c9] == 4) {
                        int i52 = i51 + 1;
                        cArr29[i51] = 'u';
                        int i53 = i52 + 1;
                        char[] cArr30 = IOUtils.DIGITS;
                        cArr29[i52] = cArr30[(c9 >>> '\f') & 15];
                        int i54 = i53 + 1;
                        cArr29[i53] = cArr30[(c9 >>> '\b') & 15];
                        int i55 = i54 + 1;
                        cArr29[i54] = cArr30[(c9 >>> 4) & 15];
                        i21 = i55 + 1;
                        cArr29[i55] = cArr30[c9 & 15];
                    } else {
                        i21 = i51 + 1;
                        cArr29[i51] = IOUtils.replaceChars[c9];
                    }
                }
            }
        }
        if (c2 != 0) {
            char[] cArr31 = this.buf;
            int i56 = this.count;
            cArr31[i56 - 2] = Typography.quote;
            cArr31[i56 - 1] = c2;
            return;
        }
        this.buf[this.count - 1] = Typography.quote;
    }
}
