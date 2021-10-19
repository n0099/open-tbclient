package com.alibaba.fastjson.serializer;

import androidx.core.view.InputDeviceCompat;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.util.IOUtils;
import com.alibaba.fastjson.util.RyuDouble;
import com.alibaba.fastjson.util.RyuFloat;
import com.alipay.sdk.encrypt.a;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.util.List;
import kotlin.text.Typography;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
/* loaded from: classes4.dex */
public final class SerializeWriter extends Writer {
    public static /* synthetic */ Interceptable $ic;
    public static int BUFFER_THRESHOLD;
    public static final char[] VALUE_FALSE;
    public static final char[] VALUE_TRUE;
    public static final ThreadLocal<char[]> bufLocal;
    public static final ThreadLocal<byte[]> bytesBufLocal;
    public static final int nonDirectFeatures;
    public transient /* synthetic */ FieldHolder $fh;
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

    static {
        InterceptResult invokeClinit;
        int parseInt;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(539259591, "Lcom/alibaba/fastjson/serializer/SerializeWriter;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(539259591, "Lcom/alibaba/fastjson/serializer/SerializeWriter;");
                return;
            }
        }
        bufLocal = new ThreadLocal<>();
        bytesBufLocal = new ThreadLocal<>();
        VALUE_TRUE = ":true".toCharArray();
        VALUE_FALSE = ":false".toCharArray();
        BUFFER_THRESHOLD = 131072;
        try {
            String stringProperty = IOUtils.getStringProperty("fastjson.serializer_buffer_threshold");
            if (stringProperty != null && stringProperty.length() > 0 && (parseInt = Integer.parseInt(stringProperty)) >= 64 && parseInt <= 65536) {
                BUFFER_THRESHOLD = parseInt * 1024;
            }
        } catch (Throwable unused) {
        }
        nonDirectFeatures = SerializerFeature.UseSingleQuotes.mask | 0 | SerializerFeature.BrowserCompatible.mask | SerializerFeature.PrettyFormat.mask | SerializerFeature.WriteEnumUsingToString.mask | SerializerFeature.WriteNonStringValueAsString.mask | SerializerFeature.WriteSlashAsSpecial.mask | SerializerFeature.IgnoreErrorGetter.mask | SerializerFeature.WriteClassName.mask | SerializerFeature.NotWriteDefaultValue.mask;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SerializeWriter() {
        this((Writer) null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this((Writer) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    private int encodeToUTF8(OutputStream outputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, this, outputStream)) == null) {
            int i2 = (int) (this.count * 3.0d);
            byte[] bArr = bytesBufLocal.get();
            if (bArr == null) {
                bArr = new byte[8192];
                bytesBufLocal.set(bArr);
            }
            byte[] bArr2 = bArr.length < i2 ? new byte[i2] : bArr;
            int encodeUTF8 = IOUtils.encodeUTF8(this.buf, 0, this.count, bArr2);
            outputStream.write(bArr2, 0, encodeUTF8);
            if (bArr2 != bArr && bArr2.length <= BUFFER_THRESHOLD) {
                bytesBufLocal.set(bArr2);
            }
            return encodeUTF8;
        }
        return invokeL.intValue;
    }

    private byte[] encodeToUTF8Bytes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) {
            int i2 = (int) (this.count * 3.0d);
            byte[] bArr = bytesBufLocal.get();
            if (bArr == null) {
                bArr = new byte[8192];
                bytesBufLocal.set(bArr);
            }
            byte[] bArr2 = bArr.length < i2 ? new byte[i2] : bArr;
            int encodeUTF8 = IOUtils.encodeUTF8(this.buf, 0, this.count, bArr2);
            byte[] bArr3 = new byte[encodeUTF8];
            System.arraycopy(bArr2, 0, bArr3, 0, encodeUTF8);
            if (bArr2 != bArr && bArr2.length <= BUFFER_THRESHOLD) {
                bytesBufLocal.set(bArr2);
            }
            return bArr3;
        }
        return (byte[]) invokeV.objValue;
    }

    private void writeEnumFieldValue(char c2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65546, this, new Object[]{Character.valueOf(c2), str, str2}) == null) {
            if (this.useSingleQuotes) {
                writeFieldValue(c2, str, str2);
            } else {
                writeFieldValueStringWithDoubleQuote(c2, str, str2);
            }
        }
    }

    private void writeKeyWithSingleQuoteIfHasSpecial(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, this, str) == null) {
            byte[] bArr = IOUtils.specicalFlags_singleQuotes;
            int length = str.length();
            boolean z = true;
            int i2 = this.count + length + 1;
            int i3 = 0;
            if (i2 > this.buf.length) {
                if (this.writer != null) {
                    if (length == 0) {
                        write(39);
                        write(39);
                        write(58);
                        return;
                    }
                    int i4 = 0;
                    while (true) {
                        if (i4 < length) {
                            char charAt = str.charAt(i4);
                            if (charAt < bArr.length && bArr[charAt] != 0) {
                                break;
                            }
                            i4++;
                        } else {
                            z = false;
                            break;
                        }
                    }
                    if (z) {
                        write(39);
                    }
                    while (i3 < length) {
                        char charAt2 = str.charAt(i3);
                        if (charAt2 < bArr.length && bArr[charAt2] != 0) {
                            write(92);
                            write(IOUtils.replaceChars[charAt2]);
                        } else {
                            write(charAt2);
                        }
                        i3++;
                    }
                    if (z) {
                        write(39);
                    }
                    write(58);
                    return;
                }
                expandCapacity(i2);
            }
            if (length == 0) {
                int i5 = this.count;
                if (i5 + 3 > this.buf.length) {
                    expandCapacity(i5 + 3);
                }
                char[] cArr = this.buf;
                int i6 = this.count;
                int i7 = i6 + 1;
                this.count = i7;
                cArr[i6] = ExtendedMessageFormat.QUOTE;
                int i8 = i7 + 1;
                this.count = i8;
                cArr[i7] = ExtendedMessageFormat.QUOTE;
                this.count = i8 + 1;
                cArr[i8] = ':';
                return;
            }
            int i9 = this.count;
            int i10 = i9 + length;
            str.getChars(0, length, this.buf, i9);
            this.count = i2;
            int i11 = i9;
            boolean z2 = false;
            while (i11 < i10) {
                char[] cArr2 = this.buf;
                char c2 = cArr2[i11];
                if (c2 < bArr.length && bArr[c2] != 0) {
                    if (!z2) {
                        i2 += 3;
                        if (i2 > cArr2.length) {
                            expandCapacity(i2);
                        }
                        this.count = i2;
                        char[] cArr3 = this.buf;
                        int i12 = i11 + 1;
                        System.arraycopy(cArr3, i12, cArr3, i11 + 3, (i10 - i11) - 1);
                        char[] cArr4 = this.buf;
                        System.arraycopy(cArr4, i3, cArr4, 1, i11);
                        char[] cArr5 = this.buf;
                        cArr5[i9] = ExtendedMessageFormat.QUOTE;
                        cArr5[i12] = '\\';
                        int i13 = i12 + 1;
                        cArr5[i13] = IOUtils.replaceChars[c2];
                        i10 += 2;
                        cArr5[this.count - 2] = ExtendedMessageFormat.QUOTE;
                        i11 = i13;
                        z2 = true;
                    } else {
                        i2++;
                        if (i2 > cArr2.length) {
                            expandCapacity(i2);
                        }
                        this.count = i2;
                        char[] cArr6 = this.buf;
                        int i14 = i11 + 1;
                        System.arraycopy(cArr6, i14, cArr6, i11 + 2, i10 - i11);
                        char[] cArr7 = this.buf;
                        cArr7[i11] = '\\';
                        cArr7[i14] = IOUtils.replaceChars[c2];
                        i10++;
                        i11 = i14;
                    }
                }
                i11++;
                i3 = 0;
            }
            this.buf[i2 - 1] = ':';
        }
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (this.writer != null && this.count > 0) {
                flush();
            }
            char[] cArr = this.buf;
            if (cArr.length <= BUFFER_THRESHOLD) {
                bufLocal.set(cArr);
            }
            this.buf = null;
        }
    }

    public void computeFeatures() {
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
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
            this.keySeperator = this.useSingleQuotes ? ExtendedMessageFormat.QUOTE : '\"';
            boolean z = (this.features & SerializerFeature.BrowserSecure.mask) != 0;
            this.browserSecure = z;
            if (z) {
                j2 = 5764610843043954687L;
            } else {
                j2 = (this.features & SerializerFeature.WriteSlashAsSpecial.mask) != 0 ? 140758963191807L : 21474836479L;
            }
            this.sepcialBits = j2;
        }
    }

    public void config(SerializerFeature serializerFeature, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048587, this, serializerFeature, z) == null) {
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
    }

    public void expandCapacity(int i2) {
        char[] cArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            int i3 = this.maxBufSize;
            if (i3 != -1 && i2 >= i3) {
                throw new JSONException("serialize exceeded MAX_OUTPUT_LENGTH=" + this.maxBufSize + ", minimumCapacity=" + i2);
            }
            char[] cArr2 = this.buf;
            int length = cArr2.length + (cArr2.length >> 1) + 1;
            if (length >= i2) {
                i2 = length;
            }
            char[] cArr3 = new char[i2];
            System.arraycopy(this.buf, 0, cArr3, 0, this.count);
            if (this.buf.length < BUFFER_THRESHOLD && ((cArr = bufLocal.get()) == null || cArr.length < this.buf.length)) {
                bufLocal.set(this.buf);
            }
            this.buf = cArr3;
        }
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
        Writer writer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (writer = this.writer) == null) {
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
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.buf.length : invokeV.intValue;
    }

    public int getMaxBufSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.maxBufSize : invokeV.intValue;
    }

    public boolean isEnabled(SerializerFeature serializerFeature) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, serializerFeature)) == null) ? (serializerFeature.mask & this.features) != 0 : invokeL.booleanValue;
    }

    public boolean isNotWriteDefaultValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.notWriteDefaultValue : invokeV.booleanValue;
    }

    public boolean isSortField() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.sortField : invokeV.booleanValue;
    }

    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            this.count = 0;
        }
    }

    public void setMaxBufSize(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i2) == null) {
            if (i2 >= this.buf.length) {
                this.maxBufSize = i2;
                return;
            }
            throw new JSONException("must > " + this.buf.length);
        }
    }

    public int size() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.count : invokeV.intValue;
    }

    public byte[] toBytes(String str) {
        InterceptResult invokeL;
        Charset charset;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, str)) == null) {
            if (str != null && !"UTF-8".equals(str)) {
                charset = Charset.forName(str);
            } else {
                charset = IOUtils.UTF8;
            }
            return toBytes(charset);
        }
        return (byte[]) invokeL.objValue;
    }

    public char[] toCharArray() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            if (this.writer == null) {
                int i2 = this.count;
                char[] cArr = new char[i2];
                System.arraycopy(this.buf, 0, cArr, 0, i2);
                return cArr;
            }
            throw new UnsupportedOperationException("writer not null");
        }
        return (char[]) invokeV.objValue;
    }

    public char[] toCharArrayForSpringWebSocket() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            if (this.writer == null) {
                int i2 = this.count;
                char[] cArr = new char[i2 - 2];
                System.arraycopy(this.buf, 1, cArr, 0, i2 - 2);
                return cArr;
            }
            throw new UnsupportedOperationException("writer not null");
        }
        return (char[]) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? new String(this.buf, 0, this.count) : (String) invokeV.objValue;
    }

    @Override // java.io.Writer
    public void write(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i2) == null) {
            int i3 = 1;
            int i4 = this.count + 1;
            if (i4 > this.buf.length) {
                if (this.writer == null) {
                    expandCapacity(i4);
                } else {
                    flush();
                    this.buf[this.count] = (char) i2;
                    this.count = i3;
                }
            }
            i3 = i4;
            this.buf[this.count] = (char) i2;
            this.count = i3;
        }
    }

    public void writeByteArray(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, bArr) == null) {
            if (isEnabled(SerializerFeature.WriteClassName.mask)) {
                writeHex(bArr);
                return;
            }
            int length = bArr.length;
            char c2 = this.useSingleQuotes ? ExtendedMessageFormat.QUOTE : '\"';
            if (length == 0) {
                write(this.useSingleQuotes ? "''" : "\"\"");
                return;
            }
            char[] cArr = IOUtils.CA;
            int i2 = (length / 3) * 3;
            int i3 = length - 1;
            int i4 = this.count;
            int i5 = (((i3 / 3) + 1) << 2) + i4 + 2;
            if (i5 > this.buf.length) {
                if (this.writer != null) {
                    write(c2);
                    int i6 = 0;
                    while (i6 < i2) {
                        int i7 = i6 + 1;
                        int i8 = i7 + 1;
                        int i9 = ((bArr[i6] & 255) << 16) | ((bArr[i7] & 255) << 8) | (bArr[i8] & 255);
                        write(cArr[(i9 >>> 18) & 63]);
                        write(cArr[(i9 >>> 12) & 63]);
                        write(cArr[(i9 >>> 6) & 63]);
                        write(cArr[i9 & 63]);
                        i6 = i8 + 1;
                    }
                    int i10 = length - i2;
                    if (i10 > 0) {
                        int i11 = ((bArr[i2] & 255) << 10) | (i10 == 2 ? (bArr[i3] & 255) << 2 : 0);
                        write(cArr[i11 >> 12]);
                        write(cArr[(i11 >>> 6) & 63]);
                        write(i10 == 2 ? cArr[i11 & 63] : a.f36026h);
                        write(61);
                    }
                    write(c2);
                    return;
                }
                expandCapacity(i5);
            }
            this.count = i5;
            int i12 = i4 + 1;
            this.buf[i4] = c2;
            int i13 = 0;
            while (i13 < i2) {
                int i14 = i13 + 1;
                int i15 = i14 + 1;
                int i16 = ((bArr[i13] & 255) << 16) | ((bArr[i14] & 255) << 8);
                int i17 = i15 + 1;
                int i18 = i16 | (bArr[i15] & 255);
                char[] cArr2 = this.buf;
                int i19 = i12 + 1;
                cArr2[i12] = cArr[(i18 >>> 18) & 63];
                int i20 = i19 + 1;
                cArr2[i19] = cArr[(i18 >>> 12) & 63];
                int i21 = i20 + 1;
                cArr2[i20] = cArr[(i18 >>> 6) & 63];
                i12 = i21 + 1;
                cArr2[i21] = cArr[i18 & 63];
                i13 = i17;
            }
            int i22 = length - i2;
            if (i22 > 0) {
                int i23 = ((bArr[i2] & 255) << 10) | (i22 == 2 ? (bArr[i3] & 255) << 2 : 0);
                char[] cArr3 = this.buf;
                cArr3[i5 - 5] = cArr[i23 >> 12];
                cArr3[i5 - 4] = cArr[(i23 >>> 6) & 63];
                cArr3[i5 - 3] = i22 == 2 ? cArr[i23 & 63] : a.f36026h;
                this.buf[i5 - 2] = a.f36026h;
            }
            this.buf[i5 - 1] = c2;
        }
    }

    public void writeDouble(double d2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048611, this, new Object[]{Double.valueOf(d2), Boolean.valueOf(z)}) == null) {
            if (!Double.isNaN(d2) && !Double.isInfinite(d2)) {
                int i2 = this.count + 24;
                if (i2 > this.buf.length) {
                    if (this.writer == null) {
                        expandCapacity(i2);
                    } else {
                        String ryuDouble = RyuDouble.toString(d2);
                        write(ryuDouble, 0, ryuDouble.length());
                        if (z && isEnabled(SerializerFeature.WriteClassName)) {
                            write(68);
                            return;
                        }
                        return;
                    }
                }
                this.count += RyuDouble.toString(d2, this.buf, this.count);
                if (z && isEnabled(SerializerFeature.WriteClassName)) {
                    write(68);
                    return;
                }
                return;
            }
            writeNull();
        }
    }

    public void writeEnum(Enum<?> r5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, r5) == null) {
            if (r5 == null) {
                writeNull();
                return;
            }
            String str = null;
            if (this.writeEnumUsingName && !this.writeEnumUsingToString) {
                str = r5.name();
            } else if (this.writeEnumUsingToString) {
                str = r5.toString();
            }
            if (str != null) {
                int i2 = isEnabled(SerializerFeature.UseSingleQuotes) ? 39 : 34;
                write(i2);
                write(str);
                write(i2);
                return;
            }
            writeInt(r5.ordinal());
        }
    }

    public void writeFieldName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, str) == null) {
            writeFieldName(str, false);
        }
    }

    public void writeFieldNameDirect(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, str) == null) {
            int length = str.length();
            int i2 = this.count + length + 3;
            if (i2 > this.buf.length) {
                expandCapacity(i2);
            }
            int i3 = this.count;
            char[] cArr = this.buf;
            cArr[i3] = '\"';
            str.getChars(0, length, cArr, i3 + 1);
            this.count = i2;
            char[] cArr2 = this.buf;
            cArr2[i2 - 2] = '\"';
            cArr2[i2 - 1] = ':';
        }
    }

    public void writeFieldValue(char c2, String str, char c3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048616, this, new Object[]{Character.valueOf(c2), str, Character.valueOf(c3)}) == null) {
            write(c2);
            writeFieldName(str);
            if (c3 == 0) {
                writeString("\u0000");
            } else {
                writeString(Character.toString(c3));
            }
        }
    }

    public void writeFieldValueStringWithDoubleQuote(char c2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048625, this, new Object[]{Character.valueOf(c2), str, str2}) == null) {
            int length = str.length();
            int i2 = this.count;
            int length2 = str2.length();
            int i3 = i2 + length + length2 + 6;
            if (i3 > this.buf.length) {
                if (this.writer != null) {
                    write(c2);
                    writeStringWithDoubleQuote(str, ':');
                    writeStringWithDoubleQuote(str2, (char) 0);
                    return;
                }
                expandCapacity(i3);
            }
            char[] cArr = this.buf;
            int i4 = this.count;
            cArr[i4] = c2;
            int i5 = i4 + 2;
            int i6 = i5 + length;
            cArr[i4 + 1] = '\"';
            str.getChars(0, length, cArr, i5);
            this.count = i3;
            char[] cArr2 = this.buf;
            cArr2[i6] = '\"';
            int i7 = i6 + 1;
            int i8 = i7 + 1;
            cArr2[i7] = ':';
            cArr2[i8] = '\"';
            str2.getChars(0, length2, cArr2, i8 + 1);
            this.buf[this.count - 1] = '\"';
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:54:0x00d6, code lost:
        if (r1[r7] == 4) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x021a, code lost:
        if (r3 != '>') goto L103;
     */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00dd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void writeFieldValueStringWithDoubleQuoteCheck(char c2, String str, String str2) {
        int length;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048626, this, new Object[]{Character.valueOf(c2), str, str2}) == null) {
            int length2 = str.length();
            int i3 = this.count;
            if (str2 == null) {
                i2 = i3 + length2 + 8;
                length = 4;
            } else {
                length = str2.length();
                i2 = i3 + length2 + length + 6;
            }
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
            int i4 = this.count;
            cArr[i4] = c2;
            int i5 = i4 + 2;
            int i6 = i5 + length2;
            cArr[i4 + 1] = '\"';
            str.getChars(0, length2, cArr, i5);
            this.count = i2;
            char[] cArr2 = this.buf;
            cArr2[i6] = '\"';
            int i7 = i6 + 1;
            int i8 = i7 + 1;
            cArr2[i7] = ':';
            if (str2 == null) {
                int i9 = i8 + 1;
                cArr2[i8] = 'n';
                int i10 = i9 + 1;
                cArr2[i9] = 'u';
                cArr2[i10] = 'l';
                cArr2[i10 + 1] = 'l';
                return;
            }
            int i11 = i8 + 1;
            cArr2[i8] = '\"';
            int i12 = i11 + length;
            str2.getChars(0, length, cArr2, i11);
            int i13 = -1;
            int i14 = 0;
            char c3 = 0;
            int i15 = -1;
            int i16 = -1;
            for (int i17 = i11; i17 < i12; i17++) {
                char c4 = this.buf[i17];
                if (c4 >= ']') {
                    if (c4 >= 127 && (c4 == 8232 || c4 == 8233 || c4 < 160)) {
                        if (i15 == i13) {
                            i15 = i17;
                        }
                        i14++;
                        i2 += 4;
                        i16 = i17;
                    }
                } else if ((c4 < '@' && (this.sepcialBits & (1 << c4)) != 0) || c4 == '\\') {
                    i14++;
                    if (c4 != '(' && c4 != ')' && c4 != '<' && c4 != '>') {
                        byte[] bArr = IOUtils.specicalFlags_doubleQuotes;
                        if (c4 < bArr.length) {
                        }
                        i13 = -1;
                        if (i15 == -1) {
                            i15 = i17;
                            i16 = i15;
                        }
                        i16 = i17;
                    }
                    i2 += 4;
                    i13 = -1;
                    if (i15 == -1) {
                    }
                    i16 = i17;
                } else {
                    i13 = -1;
                }
                c3 = c4;
            }
            if (i14 > 0) {
                int i18 = i2 + i14;
                if (i18 > this.buf.length) {
                    expandCapacity(i18);
                }
                this.count = i18;
                if (i14 == 1) {
                    if (c3 == 8232) {
                        int i19 = i16 + 1;
                        char[] cArr3 = this.buf;
                        System.arraycopy(cArr3, i19, cArr3, i16 + 6, (i12 - i16) - 1);
                        char[] cArr4 = this.buf;
                        cArr4[i16] = '\\';
                        cArr4[i19] = 'u';
                        int i20 = i19 + 1;
                        cArr4[i20] = '2';
                        int i21 = i20 + 1;
                        cArr4[i21] = '0';
                        int i22 = i21 + 1;
                        cArr4[i22] = '2';
                        cArr4[i22 + 1] = '8';
                    } else if (c3 == 8233) {
                        int i23 = i16 + 1;
                        char[] cArr5 = this.buf;
                        System.arraycopy(cArr5, i23, cArr5, i16 + 6, (i12 - i16) - 1);
                        char[] cArr6 = this.buf;
                        cArr6[i16] = '\\';
                        cArr6[i23] = 'u';
                        int i24 = i23 + 1;
                        cArr6[i24] = '2';
                        int i25 = i24 + 1;
                        cArr6[i25] = '0';
                        int i26 = i25 + 1;
                        cArr6[i26] = '2';
                        cArr6[i26 + 1] = '9';
                    } else if (c3 != '(' && c3 != ')' && c3 != '<' && c3 != '>') {
                        byte[] bArr2 = IOUtils.specicalFlags_doubleQuotes;
                        if (c3 < bArr2.length && bArr2[c3] == 4) {
                            int i27 = i16 + 1;
                            char[] cArr7 = this.buf;
                            System.arraycopy(cArr7, i27, cArr7, i16 + 6, (i12 - i16) - 1);
                            char[] cArr8 = this.buf;
                            cArr8[i16] = '\\';
                            int i28 = i27 + 1;
                            cArr8[i27] = 'u';
                            int i29 = i28 + 1;
                            char[] cArr9 = IOUtils.DIGITS;
                            cArr8[i28] = cArr9[(c3 >>> '\f') & 15];
                            int i30 = i29 + 1;
                            cArr8[i29] = cArr9[(c3 >>> '\b') & 15];
                            cArr8[i30] = cArr9[(c3 >>> 4) & 15];
                            cArr8[i30 + 1] = cArr9[c3 & 15];
                        } else {
                            int i31 = i16 + 1;
                            char[] cArr10 = this.buf;
                            System.arraycopy(cArr10, i31, cArr10, i16 + 2, (i12 - i16) - 1);
                            char[] cArr11 = this.buf;
                            cArr11[i16] = '\\';
                            cArr11[i31] = IOUtils.replaceChars[c3];
                        }
                    } else {
                        int i32 = i16 + 1;
                        char[] cArr12 = this.buf;
                        System.arraycopy(cArr12, i32, cArr12, i16 + 6, (i12 - i16) - 1);
                        char[] cArr13 = this.buf;
                        cArr13[i16] = '\\';
                        int i33 = i32 + 1;
                        cArr13[i32] = 'u';
                        int i34 = i33 + 1;
                        char[] cArr14 = IOUtils.DIGITS;
                        cArr13[i33] = cArr14[(c3 >>> '\f') & 15];
                        int i35 = i34 + 1;
                        cArr13[i34] = cArr14[(c3 >>> '\b') & 15];
                        cArr13[i35] = cArr14[(c3 >>> 4) & 15];
                        cArr13[i35 + 1] = cArr14[c3 & 15];
                    }
                } else if (i14 > 1) {
                    for (int i36 = i15 - i11; i36 < str2.length(); i36++) {
                        char charAt = str2.charAt(i36);
                        if (this.browserSecure) {
                            if (charAt != '(' && charAt != ')') {
                                if (charAt != '<') {
                                }
                            }
                            char[] cArr15 = this.buf;
                            int i37 = i15 + 1;
                            cArr15[i15] = '\\';
                            int i38 = i37 + 1;
                            cArr15[i37] = 'u';
                            int i39 = i38 + 1;
                            char[] cArr16 = IOUtils.DIGITS;
                            cArr15[i38] = cArr16[(charAt >>> '\f') & 15];
                            int i40 = i39 + 1;
                            cArr15[i39] = cArr16[(charAt >>> '\b') & 15];
                            int i41 = i40 + 1;
                            cArr15[i40] = cArr16[(charAt >>> 4) & 15];
                            i15 = i41 + 1;
                            cArr15[i41] = cArr16[charAt & 15];
                        }
                        byte[] bArr3 = IOUtils.specicalFlags_doubleQuotes;
                        if ((charAt < bArr3.length && bArr3[charAt] != 0) || (charAt == '/' && isEnabled(SerializerFeature.WriteSlashAsSpecial))) {
                            char[] cArr17 = this.buf;
                            int i42 = i15 + 1;
                            cArr17[i15] = '\\';
                            if (IOUtils.specicalFlags_doubleQuotes[charAt] == 4) {
                                int i43 = i42 + 1;
                                cArr17[i42] = 'u';
                                int i44 = i43 + 1;
                                char[] cArr18 = IOUtils.DIGITS;
                                cArr17[i43] = cArr18[(charAt >>> '\f') & 15];
                                int i45 = i44 + 1;
                                cArr17[i44] = cArr18[(charAt >>> '\b') & 15];
                                int i46 = i45 + 1;
                                cArr17[i45] = cArr18[(charAt >>> 4) & 15];
                                i15 = i46 + 1;
                                cArr17[i46] = cArr18[charAt & 15];
                            } else {
                                i15 = i42 + 1;
                                cArr17[i42] = IOUtils.replaceChars[charAt];
                            }
                        } else if (charAt != 8232 && charAt != 8233) {
                            this.buf[i15] = charAt;
                            i15++;
                        } else {
                            char[] cArr19 = this.buf;
                            int i47 = i15 + 1;
                            cArr19[i15] = '\\';
                            int i48 = i47 + 1;
                            cArr19[i47] = 'u';
                            int i49 = i48 + 1;
                            char[] cArr20 = IOUtils.DIGITS;
                            cArr19[i48] = cArr20[(charAt >>> '\f') & 15];
                            int i50 = i49 + 1;
                            cArr19[i49] = cArr20[(charAt >>> '\b') & 15];
                            int i51 = i50 + 1;
                            cArr19[i50] = cArr20[(charAt >>> 4) & 15];
                            i15 = i51 + 1;
                            cArr19[i51] = cArr20[charAt & 15];
                        }
                    }
                }
            }
            this.buf[this.count - 1] = '\"';
        }
    }

    public void writeFloat(float f2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048627, this, new Object[]{Float.valueOf(f2), Boolean.valueOf(z)}) == null) {
            if (f2 == f2 && f2 != Float.POSITIVE_INFINITY && f2 != Float.NEGATIVE_INFINITY) {
                int i2 = this.count + 15;
                if (i2 > this.buf.length) {
                    if (this.writer == null) {
                        expandCapacity(i2);
                    } else {
                        String ryuFloat = RyuFloat.toString(f2);
                        write(ryuFloat, 0, ryuFloat.length());
                        if (z && isEnabled(SerializerFeature.WriteClassName)) {
                            write(70);
                            return;
                        }
                        return;
                    }
                }
                this.count += RyuFloat.toString(f2, this.buf, this.count);
                if (z && isEnabled(SerializerFeature.WriteClassName)) {
                    write(70);
                    return;
                }
                return;
            }
            writeNull();
        }
    }

    public void writeHex(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, bArr) == null) {
            int length = this.count + (bArr.length * 2) + 3;
            if (length > this.buf.length) {
                expandCapacity(length);
            }
            char[] cArr = this.buf;
            int i2 = this.count;
            int i3 = i2 + 1;
            this.count = i3;
            cArr[i2] = 'x';
            this.count = i3 + 1;
            cArr[i3] = ExtendedMessageFormat.QUOTE;
            for (byte b2 : bArr) {
                int i4 = b2 & 255;
                int i5 = i4 >> 4;
                int i6 = i4 & 15;
                char[] cArr2 = this.buf;
                int i7 = this.count;
                this.count = i7 + 1;
                int i8 = 48;
                cArr2[i7] = (char) (i5 + (i5 < 10 ? 48 : 55));
                char[] cArr3 = this.buf;
                int i9 = this.count;
                this.count = i9 + 1;
                if (i6 >= 10) {
                    i8 = 55;
                }
                cArr3[i9] = (char) (i6 + i8);
            }
            char[] cArr4 = this.buf;
            int i10 = this.count;
            this.count = i10 + 1;
            cArr4[i10] = ExtendedMessageFormat.QUOTE;
        }
    }

    public void writeInt(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048629, this, i2) == null) {
            if (i2 == Integer.MIN_VALUE) {
                write("-2147483648");
                return;
            }
            int stringSize = i2 < 0 ? IOUtils.stringSize(-i2) + 1 : IOUtils.stringSize(i2);
            int i3 = this.count + stringSize;
            if (i3 > this.buf.length) {
                if (this.writer == null) {
                    expandCapacity(i3);
                } else {
                    char[] cArr = new char[stringSize];
                    IOUtils.getChars(i2, stringSize, cArr);
                    write(cArr, 0, stringSize);
                    return;
                }
            }
            IOUtils.getChars(i2, i3, this.buf);
            this.count = i3;
        }
    }

    public void writeLong(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048630, this, j2) == null) {
            boolean z = isEnabled(SerializerFeature.BrowserCompatible) && !isEnabled(SerializerFeature.WriteClassName) && (j2 > 9007199254740991L || j2 < -9007199254740991L);
            if (j2 == Long.MIN_VALUE) {
                if (z) {
                    write("\"-9223372036854775808\"");
                    return;
                } else {
                    write("-9223372036854775808");
                    return;
                }
            }
            int stringSize = j2 < 0 ? IOUtils.stringSize(-j2) + 1 : IOUtils.stringSize(j2);
            int i2 = this.count + stringSize;
            if (z) {
                i2 += 2;
            }
            if (i2 > this.buf.length) {
                if (this.writer == null) {
                    expandCapacity(i2);
                } else {
                    char[] cArr = new char[stringSize];
                    IOUtils.getChars(j2, stringSize, cArr);
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
                cArr2[this.count] = '\"';
                int i3 = i2 - 1;
                IOUtils.getChars(j2, i3, cArr2);
                this.buf[i3] = '\"';
            } else {
                IOUtils.getChars(j2, i2, this.buf);
            }
            this.count = i2;
        }
    }

    public void writeLongAndChar(long j2, char c2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048631, this, new Object[]{Long.valueOf(j2), Character.valueOf(c2)}) == null) {
            writeLong(j2);
            write(c2);
        }
    }

    public void writeNull() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048632, this) == null) {
            write(StringUtil.NULL_STRING);
        }
    }

    public void writeString(String str, char c2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048636, this, new Object[]{str, Character.valueOf(c2)}) == null) {
            if (this.useSingleQuotes) {
                writeStringWithSingleQuote(str);
                write(c2);
                return;
            }
            writeStringWithDoubleQuote(str, c2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:167:0x0309, code lost:
        if (r8[r10] == 4) goto L185;
     */
    /* JADX WARN: Code restructure failed: missing block: B:214:0x0450, code lost:
        if (r4 != '>') goto L231;
     */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0310  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void writeStringWithDoubleQuote(String str, char c2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048638, this, new Object[]{str, Character.valueOf(c2)}) == null) {
            if (str == null) {
                writeNull();
                if (c2 != 0) {
                    write(c2);
                    return;
                }
                return;
            }
            int length = str.length();
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
                    while (i3 < str.length()) {
                        char charAt = str.charAt(i3);
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
                            int i4 = charAt * 2;
                            write(IOUtils.ASCII_CHARS[i4]);
                            write(IOUtils.ASCII_CHARS[i4 + 1]);
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
            int i7 = i6 + length;
            char[] cArr = this.buf;
            cArr[i5] = '\"';
            str.getChars(0, length, cArr, i6);
            this.count = i2;
            int i8 = -1;
            if (isEnabled(SerializerFeature.BrowserCompatible)) {
                for (int i9 = i6; i9 < i7; i9++) {
                    char c4 = this.buf[i9];
                    if (c4 == '\"' || c4 == '/' || c4 == '\\' || c4 == '\b' || c4 == '\f' || c4 == '\n' || c4 == '\r' || c4 == '\t') {
                        i2++;
                    } else if (c4 < ' ' || c4 >= 127) {
                        i2 += 5;
                    }
                    i8 = i9;
                }
                if (i2 > this.buf.length) {
                    expandCapacity(i2);
                }
                this.count = i2;
                while (i8 >= i6) {
                    char[] cArr2 = this.buf;
                    char c5 = cArr2[i8];
                    if (c5 == '\b' || c5 == '\f' || c5 == '\n' || c5 == '\r' || c5 == '\t') {
                        char[] cArr3 = this.buf;
                        int i10 = i8 + 1;
                        System.arraycopy(cArr3, i10, cArr3, i8 + 2, (i7 - i8) - 1);
                        char[] cArr4 = this.buf;
                        cArr4[i8] = '\\';
                        cArr4[i10] = IOUtils.replaceChars[c5];
                    } else if (c5 == '\"' || c5 == '/' || c5 == '\\') {
                        char[] cArr5 = this.buf;
                        int i11 = i8 + 1;
                        System.arraycopy(cArr5, i11, cArr5, i8 + 2, (i7 - i8) - 1);
                        char[] cArr6 = this.buf;
                        cArr6[i8] = '\\';
                        cArr6[i11] = c5;
                    } else {
                        if (c5 < ' ') {
                            int i12 = i8 + 1;
                            System.arraycopy(cArr2, i12, cArr2, i8 + 6, (i7 - i8) - 1);
                            char[] cArr7 = this.buf;
                            cArr7[i8] = '\\';
                            cArr7[i12] = 'u';
                            cArr7[i8 + 2] = '0';
                            cArr7[i8 + 3] = '0';
                            char[] cArr8 = IOUtils.ASCII_CHARS;
                            int i13 = c5 * 2;
                            cArr7[i8 + 4] = cArr8[i13];
                            cArr7[i8 + 5] = cArr8[i13 + 1];
                        } else if (c5 >= 127) {
                            int i14 = i8 + 1;
                            System.arraycopy(cArr2, i14, cArr2, i8 + 6, (i7 - i8) - 1);
                            char[] cArr9 = this.buf;
                            cArr9[i8] = '\\';
                            cArr9[i14] = 'u';
                            char[] cArr10 = IOUtils.DIGITS;
                            cArr9[i8 + 2] = cArr10[(c5 >>> '\f') & 15];
                            cArr9[i8 + 3] = cArr10[(c5 >>> '\b') & 15];
                            cArr9[i8 + 4] = cArr10[(c5 >>> 4) & 15];
                            cArr9[i8 + 5] = cArr10[c5 & 15];
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
                    char[] cArr11 = this.buf;
                    int i15 = this.count;
                    cArr11[i15 - 2] = '\"';
                    cArr11[i15 - 1] = c2;
                    return;
                }
                this.buf[this.count - 1] = '\"';
                return;
            }
            int i16 = -1;
            int i17 = 0;
            char c6 = 0;
            int i18 = -1;
            for (int i19 = i6; i19 < i7; i19++) {
                char c7 = this.buf[i19];
                if (c7 >= ']') {
                    if (c7 >= 127 && (c7 == 8232 || c7 == 8233 || c7 < 160)) {
                        if (i16 == i8) {
                            i16 = i19;
                        }
                        i17++;
                        i2 += 4;
                        i18 = i19;
                    }
                } else if ((c7 < '@' && (this.sepcialBits & (1 << c7)) != 0) || c7 == '\\') {
                    i17++;
                    if (c7 != '(' && c7 != ')' && c7 != '<' && c7 != '>') {
                        byte[] bArr2 = IOUtils.specicalFlags_doubleQuotes;
                        if (c7 < bArr2.length) {
                        }
                        i8 = -1;
                        if (i16 == -1) {
                            i16 = i19;
                            i18 = i16;
                        }
                        i18 = i19;
                    }
                    i2 += 4;
                    i8 = -1;
                    if (i16 == -1) {
                    }
                    i18 = i19;
                } else {
                    i8 = -1;
                }
                c6 = c7;
            }
            if (i17 > 0) {
                int i20 = i2 + i17;
                if (i20 > this.buf.length) {
                    expandCapacity(i20);
                }
                this.count = i20;
                if (i17 == 1) {
                    if (c6 == 8232) {
                        int i21 = i18 + 1;
                        char[] cArr12 = this.buf;
                        System.arraycopy(cArr12, i21, cArr12, i18 + 6, (i7 - i18) - 1);
                        char[] cArr13 = this.buf;
                        cArr13[i18] = '\\';
                        cArr13[i21] = 'u';
                        int i22 = i21 + 1;
                        cArr13[i22] = '2';
                        int i23 = i22 + 1;
                        cArr13[i23] = '0';
                        int i24 = i23 + 1;
                        cArr13[i24] = '2';
                        cArr13[i24 + 1] = '8';
                    } else if (c6 == 8233) {
                        int i25 = i18 + 1;
                        char[] cArr14 = this.buf;
                        System.arraycopy(cArr14, i25, cArr14, i18 + 6, (i7 - i18) - 1);
                        char[] cArr15 = this.buf;
                        cArr15[i18] = '\\';
                        cArr15[i25] = 'u';
                        int i26 = i25 + 1;
                        cArr15[i26] = '2';
                        int i27 = i26 + 1;
                        cArr15[i27] = '0';
                        int i28 = i27 + 1;
                        cArr15[i28] = '2';
                        cArr15[i28 + 1] = '9';
                    } else if (c6 != '(' && c6 != ')' && c6 != '<' && c6 != '>') {
                        byte[] bArr3 = IOUtils.specicalFlags_doubleQuotes;
                        if (c6 < bArr3.length && bArr3[c6] == 4) {
                            int i29 = i18 + 1;
                            char[] cArr16 = this.buf;
                            System.arraycopy(cArr16, i29, cArr16, i18 + 6, (i7 - i18) - 1);
                            char[] cArr17 = this.buf;
                            cArr17[i18] = '\\';
                            int i30 = i29 + 1;
                            cArr17[i29] = 'u';
                            int i31 = i30 + 1;
                            char[] cArr18 = IOUtils.DIGITS;
                            cArr17[i30] = cArr18[(c6 >>> '\f') & 15];
                            int i32 = i31 + 1;
                            cArr17[i31] = cArr18[(c6 >>> '\b') & 15];
                            cArr17[i32] = cArr18[(c6 >>> 4) & 15];
                            cArr17[i32 + 1] = cArr18[c6 & 15];
                        } else {
                            int i33 = i18 + 1;
                            char[] cArr19 = this.buf;
                            System.arraycopy(cArr19, i33, cArr19, i18 + 2, (i7 - i18) - 1);
                            char[] cArr20 = this.buf;
                            cArr20[i18] = '\\';
                            cArr20[i33] = IOUtils.replaceChars[c6];
                        }
                    } else {
                        int i34 = i18 + 1;
                        char[] cArr21 = this.buf;
                        System.arraycopy(cArr21, i34, cArr21, i18 + 6, (i7 - i18) - 1);
                        char[] cArr22 = this.buf;
                        cArr22[i18] = '\\';
                        cArr22[i34] = 'u';
                        int i35 = i34 + 1;
                        char[] cArr23 = IOUtils.DIGITS;
                        cArr22[i35] = cArr23[(c6 >>> '\f') & 15];
                        int i36 = i35 + 1;
                        cArr22[i36] = cArr23[(c6 >>> '\b') & 15];
                        int i37 = i36 + 1;
                        cArr22[i37] = cArr23[(c6 >>> 4) & 15];
                        cArr22[i37 + 1] = cArr23[c6 & 15];
                    }
                } else if (i17 > 1) {
                    for (int i38 = i16 - i6; i38 < str.length(); i38++) {
                        char charAt2 = str.charAt(i38);
                        if (this.browserSecure) {
                            if (charAt2 != '(' && charAt2 != ')') {
                                if (charAt2 != '<') {
                                }
                            }
                            char[] cArr24 = this.buf;
                            int i39 = i16 + 1;
                            cArr24[i16] = '\\';
                            int i40 = i39 + 1;
                            cArr24[i39] = 'u';
                            int i41 = i40 + 1;
                            char[] cArr25 = IOUtils.DIGITS;
                            cArr24[i40] = cArr25[(charAt2 >>> '\f') & 15];
                            int i42 = i41 + 1;
                            cArr24[i41] = cArr25[(charAt2 >>> '\b') & 15];
                            int i43 = i42 + 1;
                            cArr24[i42] = cArr25[(charAt2 >>> 4) & 15];
                            i16 = i43 + 1;
                            cArr24[i43] = cArr25[charAt2 & 15];
                        }
                        byte[] bArr4 = IOUtils.specicalFlags_doubleQuotes;
                        if ((charAt2 >= bArr4.length || bArr4[charAt2] == 0) && (charAt2 != '/' || !isEnabled(SerializerFeature.WriteSlashAsSpecial))) {
                            if (charAt2 != 8232 && charAt2 != 8233) {
                                this.buf[i16] = charAt2;
                                i16++;
                            } else {
                                char[] cArr26 = this.buf;
                                int i44 = i16 + 1;
                                cArr26[i16] = '\\';
                                int i45 = i44 + 1;
                                cArr26[i44] = 'u';
                                int i46 = i45 + 1;
                                char[] cArr27 = IOUtils.DIGITS;
                                cArr26[i45] = cArr27[(charAt2 >>> '\f') & 15];
                                int i47 = i46 + 1;
                                cArr26[i46] = cArr27[(charAt2 >>> '\b') & 15];
                                int i48 = i47 + 1;
                                cArr26[i47] = cArr27[(charAt2 >>> 4) & 15];
                                i16 = i48 + 1;
                                cArr26[i48] = cArr27[charAt2 & 15];
                            }
                        }
                        char[] cArr28 = this.buf;
                        int i49 = i16 + 1;
                        cArr28[i16] = '\\';
                        if (IOUtils.specicalFlags_doubleQuotes[charAt2] == 4) {
                            int i50 = i49 + 1;
                            cArr28[i49] = 'u';
                            int i51 = i50 + 1;
                            char[] cArr29 = IOUtils.DIGITS;
                            cArr28[i50] = cArr29[(charAt2 >>> '\f') & 15];
                            int i52 = i51 + 1;
                            cArr28[i51] = cArr29[(charAt2 >>> '\b') & 15];
                            int i53 = i52 + 1;
                            cArr28[i52] = cArr29[(charAt2 >>> 4) & 15];
                            i16 = i53 + 1;
                            cArr28[i53] = cArr29[charAt2 & 15];
                        } else {
                            i16 = i49 + 1;
                            cArr28[i49] = IOUtils.replaceChars[charAt2];
                        }
                    }
                }
            }
            if (c2 != 0) {
                char[] cArr30 = this.buf;
                int i54 = this.count;
                cArr30[i54 - 2] = '\"';
                cArr30[i54 - 1] = c2;
                return;
            }
            this.buf[this.count - 1] = '\"';
        }
    }

    public void writeStringWithSingleQuote(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048640, this, str) == null) {
            int i2 = 0;
            if (str == null) {
                int i3 = this.count + 4;
                if (i3 > this.buf.length) {
                    expandCapacity(i3);
                }
                StringUtil.NULL_STRING.getChars(0, 4, this.buf, this.count);
                this.count = i3;
                return;
            }
            int length = str.length();
            int i4 = this.count + length + 2;
            if (i4 > this.buf.length) {
                if (this.writer != null) {
                    write(39);
                    while (i2 < str.length()) {
                        char charAt = str.charAt(i2);
                        if (charAt > '\r' && charAt != '\\' && charAt != '\'' && (charAt != '/' || !isEnabled(SerializerFeature.WriteSlashAsSpecial))) {
                            write(charAt);
                        } else {
                            write(92);
                            write(IOUtils.replaceChars[charAt]);
                        }
                        i2++;
                    }
                    write(39);
                    return;
                }
                expandCapacity(i4);
            }
            int i5 = this.count;
            int i6 = i5 + 1;
            int i7 = i6 + length;
            char[] cArr = this.buf;
            cArr[i5] = ExtendedMessageFormat.QUOTE;
            str.getChars(0, length, cArr, i6);
            this.count = i4;
            int i8 = -1;
            char c2 = 0;
            for (int i9 = i6; i9 < i7; i9++) {
                char c3 = this.buf[i9];
                if (c3 <= '\r' || c3 == '\\' || c3 == '\'' || (c3 == '/' && isEnabled(SerializerFeature.WriteSlashAsSpecial))) {
                    i2++;
                    i8 = i9;
                    c2 = c3;
                }
            }
            int i10 = i4 + i2;
            if (i10 > this.buf.length) {
                expandCapacity(i10);
            }
            this.count = i10;
            if (i2 == 1) {
                char[] cArr2 = this.buf;
                int i11 = i8 + 1;
                System.arraycopy(cArr2, i11, cArr2, i8 + 2, (i7 - i8) - 1);
                char[] cArr3 = this.buf;
                cArr3[i8] = '\\';
                cArr3[i11] = IOUtils.replaceChars[c2];
            } else if (i2 > 1) {
                char[] cArr4 = this.buf;
                int i12 = i8 + 1;
                System.arraycopy(cArr4, i12, cArr4, i8 + 2, (i7 - i8) - 1);
                char[] cArr5 = this.buf;
                cArr5[i8] = '\\';
                cArr5[i12] = IOUtils.replaceChars[c2];
                int i13 = i7 + 1;
                for (int i14 = i12 - 2; i14 >= i6; i14--) {
                    char c4 = this.buf[i14];
                    if (c4 <= '\r' || c4 == '\\' || c4 == '\'' || (c4 == '/' && isEnabled(SerializerFeature.WriteSlashAsSpecial))) {
                        char[] cArr6 = this.buf;
                        int i15 = i14 + 1;
                        System.arraycopy(cArr6, i15, cArr6, i14 + 2, (i13 - i14) - 1);
                        char[] cArr7 = this.buf;
                        cArr7[i14] = '\\';
                        cArr7[i15] = IOUtils.replaceChars[c4];
                        i13++;
                    }
                }
            }
            this.buf[this.count - 1] = ExtendedMessageFormat.QUOTE;
        }
    }

    public void writeTo(Writer writer) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048644, this, writer) == null) {
            if (this.writer == null) {
                writer.write(this.buf, 0, this.count);
                return;
            }
            throw new UnsupportedOperationException("writer not null");
        }
    }

    public int writeToEx(OutputStream outputStream, Charset charset) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048645, this, outputStream, charset)) == null) {
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
        return invokeLL.intValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SerializeWriter(Writer writer) {
        this(writer, JSON.DEFAULT_GENERATE_FEATURE, SerializerFeature.EMPTY);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {writer};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Writer) objArr2[0], ((Integer) objArr2[1]).intValue(), (SerializerFeature[]) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
    }

    public boolean isEnabled(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i2)) == null) ? (i2 & this.features) != 0 : invokeI.booleanValue;
    }

    public void writeFieldName(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048614, this, str, z) == null) {
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
                int i2 = 0;
                while (true) {
                    if (i2 >= str.length()) {
                        z2 = z3;
                        break;
                    }
                    char charAt = str.charAt(i2);
                    if ((charAt < '@' && (this.sepcialBits & (1 << charAt)) != 0) || charAt == '\\') {
                        break;
                    }
                    i2++;
                }
                if (z2) {
                    writeStringWithDoubleQuote(str, ':');
                    return;
                }
                write(str);
                write(58);
            }
        }
    }

    public void writeNull(SerializerFeature serializerFeature) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048634, this, serializerFeature) == null) {
            writeNull(0, serializerFeature.mask);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SerializeWriter(SerializerFeature... serializerFeatureArr) {
        this((Writer) null, serializerFeatureArr);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {serializerFeatureArr};
            interceptable.invokeUnInit(65543, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Writer) objArr2[0], (SerializerFeature[]) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65543, newInitContext);
                return;
            }
        }
    }

    public void writeNull(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048633, this, i2, i3) == null) {
            if ((i2 & i3) == 0 && (this.features & i3) == 0) {
                writeNull();
                return;
            }
            int i4 = SerializerFeature.WriteMapNullValue.mask;
            if ((i2 & i4) != 0 && (i2 & (~i4) & SerializerFeature.WRITE_MAP_NULL_FEATURES) == 0) {
                writeNull();
            } else if (i3 == SerializerFeature.WriteNullListAsEmpty.mask) {
                write("[]");
            } else if (i3 == SerializerFeature.WriteNullStringAsEmpty.mask) {
                writeString("");
            } else if (i3 == SerializerFeature.WriteNullBooleanAsFalse.mask) {
                write("false");
            } else if (i3 == SerializerFeature.WriteNullNumberAsZero.mask) {
                write(48);
            } else {
                writeNull();
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SerializeWriter(Writer writer, SerializerFeature... serializerFeatureArr) {
        this(writer, 0, serializerFeatureArr);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {writer, serializerFeatureArr};
            interceptable.invokeUnInit(AdIconUtil.BAIDU_LOGO_ID, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Writer) objArr2[0], ((Integer) objArr2[1]).intValue(), (SerializerFeature[]) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(AdIconUtil.BAIDU_LOGO_ID, newInitContext);
                return;
            }
        }
    }

    public byte[] toBytes(Charset charset) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, charset)) == null) {
            if (this.writer == null) {
                if (charset == IOUtils.UTF8) {
                    return encodeToUTF8Bytes();
                }
                return new String(this.buf, 0, this.count).getBytes(charset);
            }
            throw new UnsupportedOperationException("writer not null");
        }
        return (byte[]) invokeL.objValue;
    }

    public void writeTo(OutputStream outputStream, String str) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048642, this, outputStream, str) == null) {
            writeTo(outputStream, Charset.forName(str));
        }
    }

    public SerializeWriter(Writer writer, int i2, SerializerFeature... serializerFeatureArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {writer, Integer.valueOf(i2), serializerFeatureArr};
            interceptable.invokeUnInit(AdIconUtil.AD_TEXT_ID, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(AdIconUtil.AD_TEXT_ID, newInitContext);
                return;
            }
        }
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
            i2 |= serializerFeature.getMask();
        }
        this.features = i2;
        computeFeatures();
    }

    public void writeFieldValue(char c2, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048624, this, new Object[]{Character.valueOf(c2), str, Boolean.valueOf(z)}) == null) {
            if (!this.quoteFieldNames) {
                write(c2);
                writeFieldName(str);
                write(z);
                return;
            }
            int i2 = z ? 4 : 5;
            int length = str.length();
            int i3 = this.count + length + 4 + i2;
            if (i3 > this.buf.length) {
                if (this.writer != null) {
                    write(c2);
                    writeString(str);
                    write(58);
                    write(z);
                    return;
                }
                expandCapacity(i3);
            }
            int i4 = this.count;
            this.count = i3;
            char[] cArr = this.buf;
            cArr[i4] = c2;
            int i5 = i4 + length + 1;
            cArr[i4 + 1] = this.keySeperator;
            str.getChars(0, length, cArr, i4 + 2);
            char[] cArr2 = this.buf;
            cArr2[i5 + 1] = this.keySeperator;
            if (z) {
                System.arraycopy(VALUE_TRUE, 0, cArr2, i5 + 2, 5);
            } else {
                System.arraycopy(VALUE_FALSE, 0, cArr2, i5 + 2, 6);
            }
        }
    }

    public void writeString(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048635, this, str) == null) {
            if (this.useSingleQuotes) {
                writeStringWithSingleQuote(str);
            } else {
                writeStringWithDoubleQuote(str, (char) 0);
            }
        }
    }

    public void writeTo(OutputStream outputStream, Charset charset) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048643, this, outputStream, charset) == null) {
            writeToEx(outputStream, charset);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.io.Writer, java.lang.Appendable
    public SerializeWriter append(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence)) == null) {
            String charSequence2 = charSequence == null ? StringUtil.NULL_STRING : charSequence.toString();
            write(charSequence2, 0, charSequence2.length());
            return this;
        }
        return (SerializeWriter) invokeL.objValue;
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i2, int i3) {
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048609, this, cArr, i2, i3) == null) {
            if (i2 < 0 || i2 > cArr.length || i3 < 0 || (i4 = i2 + i3) > cArr.length || i4 < 0) {
                throw new IndexOutOfBoundsException();
            }
            if (i3 == 0) {
                return;
            }
            int i5 = this.count + i3;
            if (i5 > this.buf.length) {
                if (this.writer == null) {
                    expandCapacity(i5);
                } else {
                    do {
                        char[] cArr2 = this.buf;
                        int length = cArr2.length;
                        int i6 = this.count;
                        int i7 = length - i6;
                        System.arraycopy(cArr, i2, cArr2, i6, i7);
                        this.count = this.buf.length;
                        flush();
                        i3 -= i7;
                        i2 += i7;
                    } while (i3 > this.buf.length);
                    i5 = i3;
                }
            }
            System.arraycopy(cArr, i2, this.buf, this.count, i3);
            this.count = i5;
        }
    }

    public void writeString(char[] cArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048637, this, cArr) == null) {
            if (this.useSingleQuotes) {
                writeStringWithSingleQuote(cArr);
            } else {
                writeStringWithDoubleQuote(new String(cArr), (char) 0);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.io.Writer, java.lang.Appendable
    public SerializeWriter append(CharSequence charSequence, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i2, i3)) == null) {
            if (charSequence == null) {
                charSequence = StringUtil.NULL_STRING;
            }
            String charSequence2 = charSequence.subSequence(i2, i3).toString();
            write(charSequence2, 0, charSequence2.length());
            return this;
        }
        return (SerializeWriter) invokeLII.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.io.Writer, java.lang.Appendable
    public SerializeWriter append(char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Character.valueOf(c2)})) == null) {
            write(c2);
            return this;
        }
        return (SerializeWriter) invokeCommon.objValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SerializeWriter(int i2) {
        this((Writer) null, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Writer) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    public SerializeWriter(Writer writer, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {writer, Integer.valueOf(i2)};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
        this.maxBufSize = -1;
        this.writer = writer;
        if (i2 > 0) {
            this.buf = new char[i2];
            computeFeatures();
            return;
        }
        throw new IllegalArgumentException("Negative initial size: " + i2);
    }

    @Override // java.io.Writer
    public void write(String str, int i2, int i3) {
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048606, this, str, i2, i3) == null) {
            int i5 = this.count + i3;
            if (i5 > this.buf.length) {
                if (this.writer == null) {
                    expandCapacity(i5);
                } else {
                    while (true) {
                        char[] cArr = this.buf;
                        int length = cArr.length;
                        int i6 = this.count;
                        int i7 = length - i6;
                        i4 = i2 + i7;
                        str.getChars(i2, i4, cArr, i6);
                        this.count = this.buf.length;
                        flush();
                        i3 -= i7;
                        if (i3 <= this.buf.length) {
                            break;
                        }
                        i2 = i4;
                    }
                    i5 = i3;
                    i2 = i4;
                }
            }
            str.getChars(i2, i3 + i2, this.buf, this.count);
            this.count = i5;
        }
    }

    public void writeFieldValue(char c2, String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048619, this, new Object[]{Character.valueOf(c2), str, Integer.valueOf(i2)}) == null) {
            if (i2 != Integer.MIN_VALUE && this.quoteFieldNames) {
                int stringSize = i2 < 0 ? IOUtils.stringSize(-i2) + 1 : IOUtils.stringSize(i2);
                int length = str.length();
                int i3 = this.count + length + 4 + stringSize;
                if (i3 > this.buf.length) {
                    if (this.writer != null) {
                        write(c2);
                        writeFieldName(str);
                        writeInt(i2);
                        return;
                    }
                    expandCapacity(i3);
                }
                int i4 = this.count;
                this.count = i3;
                char[] cArr = this.buf;
                cArr[i4] = c2;
                int i5 = i4 + length + 1;
                cArr[i4 + 1] = this.keySeperator;
                str.getChars(0, length, cArr, i4 + 2);
                char[] cArr2 = this.buf;
                cArr2[i5 + 1] = this.keySeperator;
                cArr2[i5 + 2] = ':';
                IOUtils.getChars(i2, this.count, cArr2);
                return;
            }
            write(c2);
            writeFieldName(str);
            writeInt(i2);
        }
    }

    @Override // java.io.Writer
    public void write(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, str) == null) {
            if (str == null) {
                writeNull();
            } else {
                write(str, 0, str.length());
            }
        }
    }

    public void write(List<String> list) {
        boolean z;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, list) == null) {
            if (list.isEmpty()) {
                write("[]");
                return;
            }
            int i3 = this.count;
            int size = list.size();
            int i4 = i3;
            int i5 = 0;
            while (i5 < size) {
                String str = list.get(i5);
                if (str == null) {
                    z = true;
                } else {
                    int length = str.length();
                    z = false;
                    for (int i6 = 0; i6 < length; i6++) {
                        char charAt = str.charAt(i6);
                        z = charAt < ' ' || charAt > '~' || charAt == '\"' || charAt == '\\';
                        if (z) {
                            break;
                        }
                    }
                }
                if (z) {
                    this.count = i3;
                    write(91);
                    for (int i7 = 0; i7 < list.size(); i7++) {
                        String str2 = list.get(i7);
                        if (i7 != 0) {
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
                int length2 = str.length() + i4 + 3;
                if (i5 == list.size() - 1) {
                    length2++;
                }
                if (length2 > this.buf.length) {
                    this.count = i4;
                    expandCapacity(length2);
                }
                if (i5 == 0) {
                    i2 = i4 + 1;
                    this.buf[i4] = '[';
                } else {
                    i2 = i4 + 1;
                    this.buf[i4] = ',';
                }
                int i8 = i2 + 1;
                this.buf[i2] = '\"';
                str.getChars(0, str.length(), this.buf, i8);
                int length3 = i8 + str.length();
                this.buf[length3] = '\"';
                i5++;
                i4 = length3 + 1;
            }
            this.buf[i4] = ']';
            this.count = i4 + 1;
        }
    }

    public void writeStringWithSingleQuote(char[] cArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048641, this, cArr) == null) {
            int i2 = 0;
            if (cArr == null) {
                int i3 = this.count + 4;
                if (i3 > this.buf.length) {
                    expandCapacity(i3);
                }
                StringUtil.NULL_STRING.getChars(0, 4, this.buf, this.count);
                this.count = i3;
                return;
            }
            int length = cArr.length;
            int i4 = this.count + length + 2;
            if (i4 > this.buf.length) {
                if (this.writer != null) {
                    write(39);
                    while (i2 < cArr.length) {
                        char c2 = cArr[i2];
                        if (c2 > '\r' && c2 != '\\' && c2 != '\'' && (c2 != '/' || !isEnabled(SerializerFeature.WriteSlashAsSpecial))) {
                            write(c2);
                        } else {
                            write(92);
                            write(IOUtils.replaceChars[c2]);
                        }
                        i2++;
                    }
                    write(39);
                    return;
                }
                expandCapacity(i4);
            }
            int i5 = this.count;
            int i6 = i5 + 1;
            int i7 = length + i6;
            char[] cArr2 = this.buf;
            cArr2[i5] = ExtendedMessageFormat.QUOTE;
            System.arraycopy(cArr, 0, cArr2, i6, cArr.length);
            this.count = i4;
            int i8 = -1;
            char c3 = 0;
            for (int i9 = i6; i9 < i7; i9++) {
                char c4 = this.buf[i9];
                if (c4 <= '\r' || c4 == '\\' || c4 == '\'' || (c4 == '/' && isEnabled(SerializerFeature.WriteSlashAsSpecial))) {
                    i2++;
                    i8 = i9;
                    c3 = c4;
                }
            }
            int i10 = i4 + i2;
            if (i10 > this.buf.length) {
                expandCapacity(i10);
            }
            this.count = i10;
            if (i2 == 1) {
                char[] cArr3 = this.buf;
                int i11 = i8 + 1;
                System.arraycopy(cArr3, i11, cArr3, i8 + 2, (i7 - i8) - 1);
                char[] cArr4 = this.buf;
                cArr4[i8] = '\\';
                cArr4[i11] = IOUtils.replaceChars[c3];
            } else if (i2 > 1) {
                char[] cArr5 = this.buf;
                int i12 = i8 + 1;
                System.arraycopy(cArr5, i12, cArr5, i8 + 2, (i7 - i8) - 1);
                char[] cArr6 = this.buf;
                cArr6[i8] = '\\';
                cArr6[i12] = IOUtils.replaceChars[c3];
                int i13 = i7 + 1;
                for (int i14 = i12 - 2; i14 >= i6; i14--) {
                    char c5 = this.buf[i14];
                    if (c5 <= '\r' || c5 == '\\' || c5 == '\'' || (c5 == '/' && isEnabled(SerializerFeature.WriteSlashAsSpecial))) {
                        char[] cArr7 = this.buf;
                        int i15 = i14 + 1;
                        System.arraycopy(cArr7, i15, cArr7, i14 + 2, (i13 - i14) - 1);
                        char[] cArr8 = this.buf;
                        cArr8[i14] = '\\';
                        cArr8[i15] = IOUtils.replaceChars[c5];
                        i13++;
                    }
                }
            }
            this.buf[this.count - 1] = ExtendedMessageFormat.QUOTE;
        }
    }

    public void writeFieldValue(char c2, String str, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048620, this, new Object[]{Character.valueOf(c2), str, Long.valueOf(j2)}) == null) {
            if (j2 != Long.MIN_VALUE && this.quoteFieldNames && !isEnabled(SerializerFeature.BrowserCompatible.mask)) {
                int stringSize = j2 < 0 ? IOUtils.stringSize(-j2) + 1 : IOUtils.stringSize(j2);
                int length = str.length();
                int i2 = this.count + length + 4 + stringSize;
                if (i2 > this.buf.length) {
                    if (this.writer != null) {
                        write(c2);
                        writeFieldName(str);
                        writeLong(j2);
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
                IOUtils.getChars(j2, this.count, cArr2);
                return;
            }
            write(c2);
            writeFieldName(str);
            writeLong(j2);
        }
    }

    public void write(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048608, this, z) == null) {
            if (z) {
                write("true");
            } else {
                write("false");
            }
        }
    }

    public void writeFieldValue(char c2, String str, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048618, this, new Object[]{Character.valueOf(c2), str, Float.valueOf(f2)}) == null) {
            write(c2);
            writeFieldName(str);
            writeFloat(f2, false);
        }
    }

    public void writeFieldValue(char c2, String str, double d2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048617, this, new Object[]{Character.valueOf(c2), str, Double.valueOf(d2)}) == null) {
            write(c2);
            writeFieldName(str);
            writeDouble(d2, false);
        }
    }

    public void writeFieldValue(char c2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048622, this, new Object[]{Character.valueOf(c2), str, str2}) == null) {
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
    }

    public void writeFieldValue(char c2, String str, Enum<?> r7) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048621, this, new Object[]{Character.valueOf(c2), str, r7}) == null) {
            if (r7 == null) {
                write(c2);
                writeFieldName(str);
                writeNull();
            } else if (this.writeEnumUsingName && !this.writeEnumUsingToString) {
                writeEnumFieldValue(c2, str, r7.name());
            } else if (this.writeEnumUsingToString) {
                writeEnumFieldValue(c2, str, r7.toString());
            } else {
                writeFieldValue(c2, str, r7.ordinal());
            }
        }
    }

    public void writeFieldValue(char c2, String str, BigDecimal bigDecimal) {
        String bigDecimal2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048623, this, new Object[]{Character.valueOf(c2), str, bigDecimal}) == null) {
            write(c2);
            writeFieldName(str);
            if (bigDecimal == null) {
                writeNull();
                return;
            }
            int scale = bigDecimal.scale();
            if (isEnabled(SerializerFeature.WriteBigDecimalAsPlain) && scale >= -100 && scale < 100) {
                bigDecimal2 = bigDecimal.toPlainString();
            } else {
                bigDecimal2 = bigDecimal.toString();
            }
            write(bigDecimal2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:167:0x0305, code lost:
        if (r7[r10] == 4) goto L186;
     */
    /* JADX WARN: Code restructure failed: missing block: B:216:0x044c, code lost:
        if (r3 != '>') goto L231;
     */
    /* JADX WARN: Removed duplicated region for block: B:171:0x030e  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0312  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void writeStringWithDoubleQuote(char[] cArr, char c2) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048639, this, new Object[]{cArr, Character.valueOf(c2)}) == null) {
            if (cArr == null) {
                writeNull();
                if (c2 != 0) {
                    write(c2);
                    return;
                }
                return;
            }
            int length = cArr.length;
            int i3 = this.count + length + 2;
            if (c2 != 0) {
                i3++;
            }
            int length2 = this.buf.length;
            char c3 = Typography.greater;
            if (i3 > length2) {
                if (this.writer != null) {
                    write(34);
                    int i4 = 0;
                    while (i4 < cArr.length) {
                        char c4 = cArr[i4];
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
                            int i5 = c4 * 2;
                            write(IOUtils.ASCII_CHARS[i5]);
                            write(IOUtils.ASCII_CHARS[i5 + 1]);
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
                        i4++;
                        c3 = Typography.greater;
                    }
                    write(34);
                    if (c2 != 0) {
                        write(c2);
                        return;
                    }
                    return;
                }
                expandCapacity(i3);
            }
            int i6 = this.count;
            int i7 = i6 + 1;
            int i8 = length + i7;
            char[] cArr2 = this.buf;
            cArr2[i6] = '\"';
            System.arraycopy(cArr, 0, cArr2, i7, cArr.length);
            this.count = i3;
            int i9 = -1;
            if (isEnabled(SerializerFeature.BrowserCompatible)) {
                for (int i10 = i7; i10 < i8; i10++) {
                    char c5 = this.buf[i10];
                    if (c5 == '\"' || c5 == '/' || c5 == '\\' || c5 == '\b' || c5 == '\f' || c5 == '\n' || c5 == '\r' || c5 == '\t') {
                        i3++;
                    } else if (c5 < ' ' || c5 >= 127) {
                        i3 += 5;
                    }
                    i9 = i10;
                }
                if (i3 > this.buf.length) {
                    expandCapacity(i3);
                }
                this.count = i3;
                while (i9 >= i7) {
                    char[] cArr3 = this.buf;
                    char c6 = cArr3[i9];
                    if (c6 == '\b' || c6 == '\f' || c6 == '\n' || c6 == '\r' || c6 == '\t') {
                        char[] cArr4 = this.buf;
                        int i11 = i9 + 1;
                        System.arraycopy(cArr4, i11, cArr4, i9 + 2, (i8 - i9) - 1);
                        char[] cArr5 = this.buf;
                        cArr5[i9] = '\\';
                        cArr5[i11] = IOUtils.replaceChars[c6];
                    } else if (c6 == '\"' || c6 == '/' || c6 == '\\') {
                        char[] cArr6 = this.buf;
                        int i12 = i9 + 1;
                        System.arraycopy(cArr6, i12, cArr6, i9 + 2, (i8 - i9) - 1);
                        char[] cArr7 = this.buf;
                        cArr7[i9] = '\\';
                        cArr7[i12] = c6;
                    } else {
                        if (c6 < ' ') {
                            int i13 = i9 + 1;
                            System.arraycopy(cArr3, i13, cArr3, i9 + 6, (i8 - i9) - 1);
                            char[] cArr8 = this.buf;
                            cArr8[i9] = '\\';
                            cArr8[i13] = 'u';
                            cArr8[i9 + 2] = '0';
                            cArr8[i9 + 3] = '0';
                            char[] cArr9 = IOUtils.ASCII_CHARS;
                            int i14 = c6 * 2;
                            cArr8[i9 + 4] = cArr9[i14];
                            cArr8[i9 + 5] = cArr9[i14 + 1];
                        } else if (c6 >= 127) {
                            int i15 = i9 + 1;
                            System.arraycopy(cArr3, i15, cArr3, i9 + 6, (i8 - i9) - 1);
                            char[] cArr10 = this.buf;
                            cArr10[i9] = '\\';
                            cArr10[i15] = 'u';
                            char[] cArr11 = IOUtils.DIGITS;
                            cArr10[i9 + 2] = cArr11[(c6 >>> '\f') & 15];
                            cArr10[i9 + 3] = cArr11[(c6 >>> '\b') & 15];
                            cArr10[i9 + 4] = cArr11[(c6 >>> 4) & 15];
                            cArr10[i9 + 5] = cArr11[c6 & 15];
                        } else {
                            i9--;
                        }
                        i8 += 5;
                        i9--;
                    }
                    i8++;
                    i9--;
                }
                if (c2 != 0) {
                    char[] cArr12 = this.buf;
                    int i16 = this.count;
                    cArr12[i16 - 2] = '\"';
                    cArr12[i16 - 1] = c2;
                    return;
                }
                this.buf[this.count - 1] = '\"';
                return;
            }
            int i17 = i7;
            int i18 = -1;
            int i19 = 0;
            char c7 = 0;
            int i20 = -1;
            while (i17 < i8) {
                char c8 = this.buf[i17];
                if (c8 < ']') {
                    int i21 = i18;
                    if ((c8 < '@' && (this.sepcialBits & (1 << c8)) != 0) || c8 == '\\') {
                        i19++;
                        if (c8 != '(' && c8 != ')' && c8 != '<' && c8 != '>') {
                            byte[] bArr2 = IOUtils.specicalFlags_doubleQuotes;
                            if (c8 < bArr2.length) {
                            }
                            i2 = i21;
                            if (i2 != -1) {
                                i2 = i17;
                                i20 = i2;
                            } else {
                                i20 = i17;
                            }
                            c7 = c8;
                            i17++;
                            i18 = i2;
                            i9 = -1;
                        }
                        i3 += 4;
                        i2 = i21;
                        if (i2 != -1) {
                        }
                        c7 = c8;
                        i17++;
                        i18 = i2;
                        i9 = -1;
                    } else {
                        i2 = i21;
                    }
                } else if (c8 < 127 || !(c8 == 8232 || c8 == 8233 || c8 < 160)) {
                    i2 = i18;
                } else {
                    if (i18 == i9) {
                        i18 = i17;
                    }
                    i19++;
                    i3 += 4;
                    i20 = i17;
                    i2 = i18;
                    c7 = c8;
                }
                i17++;
                i18 = i2;
                i9 = -1;
            }
            int i22 = i18;
            if (i19 > 0) {
                int i23 = i3 + i19;
                if (i23 > this.buf.length) {
                    expandCapacity(i23);
                }
                this.count = i23;
                if (i19 == 1) {
                    if (c7 == 8232) {
                        int i24 = i20 + 1;
                        char[] cArr13 = this.buf;
                        System.arraycopy(cArr13, i24, cArr13, i20 + 6, (i8 - i20) - 1);
                        char[] cArr14 = this.buf;
                        cArr14[i20] = '\\';
                        cArr14[i24] = 'u';
                        int i25 = i24 + 1;
                        cArr14[i25] = '2';
                        int i26 = i25 + 1;
                        cArr14[i26] = '0';
                        int i27 = i26 + 1;
                        cArr14[i27] = '2';
                        cArr14[i27 + 1] = '8';
                    } else if (c7 == 8233) {
                        int i28 = i20 + 1;
                        char[] cArr15 = this.buf;
                        System.arraycopy(cArr15, i28, cArr15, i20 + 6, (i8 - i20) - 1);
                        char[] cArr16 = this.buf;
                        cArr16[i20] = '\\';
                        cArr16[i28] = 'u';
                        int i29 = i28 + 1;
                        cArr16[i29] = '2';
                        int i30 = i29 + 1;
                        cArr16[i30] = '0';
                        int i31 = i30 + 1;
                        cArr16[i31] = '2';
                        cArr16[i31 + 1] = '9';
                    } else if (c7 != '(' && c7 != ')' && c7 != '<' && c7 != '>') {
                        byte[] bArr3 = IOUtils.specicalFlags_doubleQuotes;
                        if (c7 < bArr3.length && bArr3[c7] == 4) {
                            int i32 = i20 + 1;
                            char[] cArr17 = this.buf;
                            System.arraycopy(cArr17, i32, cArr17, i20 + 6, (i8 - i20) - 1);
                            char[] cArr18 = this.buf;
                            cArr18[i20] = '\\';
                            int i33 = i32 + 1;
                            cArr18[i32] = 'u';
                            int i34 = i33 + 1;
                            char[] cArr19 = IOUtils.DIGITS;
                            cArr18[i33] = cArr19[(c7 >>> '\f') & 15];
                            int i35 = i34 + 1;
                            cArr18[i34] = cArr19[(c7 >>> '\b') & 15];
                            cArr18[i35] = cArr19[(c7 >>> 4) & 15];
                            cArr18[i35 + 1] = cArr19[c7 & 15];
                        } else {
                            int i36 = i20 + 1;
                            char[] cArr20 = this.buf;
                            System.arraycopy(cArr20, i36, cArr20, i20 + 2, (i8 - i20) - 1);
                            char[] cArr21 = this.buf;
                            cArr21[i20] = '\\';
                            cArr21[i36] = IOUtils.replaceChars[c7];
                        }
                    } else {
                        int i37 = i20 + 1;
                        char[] cArr22 = this.buf;
                        System.arraycopy(cArr22, i37, cArr22, i20 + 6, (i8 - i20) - 1);
                        char[] cArr23 = this.buf;
                        cArr23[i20] = '\\';
                        cArr23[i37] = 'u';
                        int i38 = i37 + 1;
                        char[] cArr24 = IOUtils.DIGITS;
                        cArr23[i38] = cArr24[(c7 >>> '\f') & 15];
                        int i39 = i38 + 1;
                        cArr23[i39] = cArr24[(c7 >>> '\b') & 15];
                        int i40 = i39 + 1;
                        cArr23[i40] = cArr24[(c7 >>> 4) & 15];
                        cArr23[i40 + 1] = cArr24[c7 & 15];
                    }
                } else if (i19 > 1) {
                    for (int i41 = i22 - i7; i41 < cArr.length; i41++) {
                        char c9 = cArr[i41];
                        if (this.browserSecure) {
                            if (c9 != '(' && c9 != ')') {
                                if (c9 != '<') {
                                }
                            }
                            char[] cArr25 = this.buf;
                            int i42 = i22 + 1;
                            cArr25[i22] = '\\';
                            int i43 = i42 + 1;
                            cArr25[i42] = 'u';
                            int i44 = i43 + 1;
                            char[] cArr26 = IOUtils.DIGITS;
                            cArr25[i43] = cArr26[(c9 >>> '\f') & 15];
                            int i45 = i44 + 1;
                            cArr25[i44] = cArr26[(c9 >>> '\b') & 15];
                            int i46 = i45 + 1;
                            cArr25[i45] = cArr26[(c9 >>> 4) & 15];
                            i22 = i46 + 1;
                            cArr25[i46] = cArr26[c9 & 15];
                        }
                        byte[] bArr4 = IOUtils.specicalFlags_doubleQuotes;
                        if ((c9 >= bArr4.length || bArr4[c9] == 0) && (c9 != '/' || !isEnabled(SerializerFeature.WriteSlashAsSpecial))) {
                            if (c9 != 8232 && c9 != 8233) {
                                this.buf[i22] = c9;
                                i22++;
                            } else {
                                char[] cArr27 = this.buf;
                                int i47 = i22 + 1;
                                cArr27[i22] = '\\';
                                int i48 = i47 + 1;
                                cArr27[i47] = 'u';
                                int i49 = i48 + 1;
                                char[] cArr28 = IOUtils.DIGITS;
                                cArr27[i48] = cArr28[(c9 >>> '\f') & 15];
                                int i50 = i49 + 1;
                                cArr27[i49] = cArr28[(c9 >>> '\b') & 15];
                                int i51 = i50 + 1;
                                cArr27[i50] = cArr28[(c9 >>> 4) & 15];
                                i22 = i51 + 1;
                                cArr27[i51] = cArr28[c9 & 15];
                            }
                        }
                        char[] cArr29 = this.buf;
                        int i52 = i22 + 1;
                        cArr29[i22] = '\\';
                        if (IOUtils.specicalFlags_doubleQuotes[c9] == 4) {
                            int i53 = i52 + 1;
                            cArr29[i52] = 'u';
                            int i54 = i53 + 1;
                            char[] cArr30 = IOUtils.DIGITS;
                            cArr29[i53] = cArr30[(c9 >>> '\f') & 15];
                            int i55 = i54 + 1;
                            cArr29[i54] = cArr30[(c9 >>> '\b') & 15];
                            int i56 = i55 + 1;
                            cArr29[i55] = cArr30[(c9 >>> 4) & 15];
                            i22 = i56 + 1;
                            cArr29[i56] = cArr30[c9 & 15];
                        } else {
                            i22 = i52 + 1;
                            cArr29[i52] = IOUtils.replaceChars[c9];
                        }
                    }
                }
            }
            if (c2 != 0) {
                char[] cArr31 = this.buf;
                int i57 = this.count;
                cArr31[i57 - 2] = '\"';
                cArr31[i57 - 1] = c2;
                return;
            }
            this.buf[this.count - 1] = '\"';
        }
    }
}
