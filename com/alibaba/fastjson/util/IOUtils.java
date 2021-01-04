package com.alibaba.fastjson.util;

import androidx.appcompat.widget.ActivityChooserView;
import com.alibaba.fastjson.JSONException;
import com.baidu.ala.recorder.video.AlaRecorderLog;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;
import java.nio.charset.MalformedInputException;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Arrays;
import java.util.Properties;
/* loaded from: classes6.dex */
public class IOUtils {
    public static final char[] ASCII_CHARS;
    public static final char[] CA;
    static final char[] DigitOnes;
    static final char[] DigitTens;
    public static final String FASTJSON_COMPATIBLEWITHFIELDNAME = "fastjson.compatibleWithFieldName";
    public static final String FASTJSON_COMPATIBLEWITHJAVABEAN = "fastjson.compatibleWithJavaBean";
    public static final String FASTJSON_PROPERTIES = "fastjson.properties";
    public static final int[] IA;
    static final char[] digits;
    public static final boolean[] identifierFlags;
    public static final char[] replaceChars;
    static final int[] sizeTable;
    public static final byte[] specicalFlags_doubleQuotes;
    public static final boolean[] specicalFlags_doubleQuotesFlags;
    public static final byte[] specicalFlags_singleQuotes;
    public static final boolean[] specicalFlags_singleQuotesFlags;
    public static final Properties DEFAULT_PROPERTIES = new Properties();
    public static final Charset UTF8 = Charset.forName("UTF-8");
    public static final char[] DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    public static final boolean[] firstIdentifierFlags = new boolean[256];

    static {
        for (char c = 0; c < firstIdentifierFlags.length; c = (char) (c + 1)) {
            if (c >= 'A' && c <= 'Z') {
                firstIdentifierFlags[c] = true;
            } else if (c >= 'a' && c <= 'z') {
                firstIdentifierFlags[c] = true;
            } else if (c == '_' || c == '$') {
                firstIdentifierFlags[c] = true;
            }
        }
        identifierFlags = new boolean[256];
        for (char c2 = 0; c2 < identifierFlags.length; c2 = (char) (c2 + 1)) {
            if (c2 >= 'A' && c2 <= 'Z') {
                identifierFlags[c2] = true;
            } else if (c2 >= 'a' && c2 <= 'z') {
                identifierFlags[c2] = true;
            } else if (c2 == '_') {
                identifierFlags[c2] = true;
            } else if (c2 >= '0' && c2 <= '9') {
                identifierFlags[c2] = true;
            }
        }
        try {
            loadPropertiesFromFile();
        } catch (Throwable th) {
        }
        specicalFlags_doubleQuotes = new byte[161];
        specicalFlags_singleQuotes = new byte[161];
        specicalFlags_doubleQuotesFlags = new boolean[161];
        specicalFlags_singleQuotesFlags = new boolean[161];
        replaceChars = new char[93];
        specicalFlags_doubleQuotes[0] = 4;
        specicalFlags_doubleQuotes[1] = 4;
        specicalFlags_doubleQuotes[2] = 4;
        specicalFlags_doubleQuotes[3] = 4;
        specicalFlags_doubleQuotes[4] = 4;
        specicalFlags_doubleQuotes[5] = 4;
        specicalFlags_doubleQuotes[6] = 4;
        specicalFlags_doubleQuotes[7] = 4;
        specicalFlags_doubleQuotes[8] = 1;
        specicalFlags_doubleQuotes[9] = 1;
        specicalFlags_doubleQuotes[10] = 1;
        specicalFlags_doubleQuotes[11] = 4;
        specicalFlags_doubleQuotes[12] = 1;
        specicalFlags_doubleQuotes[13] = 1;
        specicalFlags_doubleQuotes[34] = 1;
        specicalFlags_doubleQuotes[92] = 1;
        specicalFlags_singleQuotes[0] = 4;
        specicalFlags_singleQuotes[1] = 4;
        specicalFlags_singleQuotes[2] = 4;
        specicalFlags_singleQuotes[3] = 4;
        specicalFlags_singleQuotes[4] = 4;
        specicalFlags_singleQuotes[5] = 4;
        specicalFlags_singleQuotes[6] = 4;
        specicalFlags_singleQuotes[7] = 4;
        specicalFlags_singleQuotes[8] = 1;
        specicalFlags_singleQuotes[9] = 1;
        specicalFlags_singleQuotes[10] = 1;
        specicalFlags_singleQuotes[11] = 4;
        specicalFlags_singleQuotes[12] = 1;
        specicalFlags_singleQuotes[13] = 1;
        specicalFlags_singleQuotes[92] = 1;
        specicalFlags_singleQuotes[39] = 1;
        for (int i = 14; i <= 31; i++) {
            specicalFlags_doubleQuotes[i] = 4;
            specicalFlags_singleQuotes[i] = 4;
        }
        for (int i2 = 127; i2 < 160; i2++) {
            specicalFlags_doubleQuotes[i2] = 4;
            specicalFlags_singleQuotes[i2] = 4;
        }
        for (int i3 = 0; i3 < 161; i3++) {
            specicalFlags_doubleQuotesFlags[i3] = specicalFlags_doubleQuotes[i3] != 0;
            specicalFlags_singleQuotesFlags[i3] = specicalFlags_singleQuotes[i3] != 0;
        }
        replaceChars[0] = '0';
        replaceChars[1] = '1';
        replaceChars[2] = '2';
        replaceChars[3] = '3';
        replaceChars[4] = '4';
        replaceChars[5] = '5';
        replaceChars[6] = '6';
        replaceChars[7] = '7';
        replaceChars[8] = 'b';
        replaceChars[9] = 't';
        replaceChars[10] = 'n';
        replaceChars[11] = 'v';
        replaceChars[12] = 'f';
        replaceChars[13] = 'r';
        replaceChars[34] = '\"';
        replaceChars[39] = '\'';
        replaceChars[47] = '/';
        replaceChars[92] = '\\';
        ASCII_CHARS = new char[]{'0', '0', '0', '1', '0', '2', '0', '3', '0', '4', '0', '5', '0', '6', '0', '7', '0', '8', '0', '9', '0', 'A', '0', 'B', '0', 'C', '0', 'D', '0', 'E', '0', 'F', '1', '0', '1', '1', '1', '2', '1', '3', '1', '4', '1', '5', '1', '6', '1', '7', '1', '8', '1', '9', '1', 'A', '1', 'B', '1', 'C', '1', 'D', '1', 'E', '1', 'F', '2', '0', '2', '1', '2', '2', '2', '3', '2', '4', '2', '5', '2', '6', '2', '7', '2', '8', '2', '9', '2', 'A', '2', 'B', '2', 'C', '2', 'D', '2', 'E', '2', 'F'};
        digits = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        DigitTens = new char[]{'0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '4', '4', '4', '4', '4', '4', '4', '4', '4', '4', '5', '5', '5', '5', '5', '5', '5', '5', '5', '5', '6', '6', '6', '6', '6', '6', '6', '6', '6', '6', '7', '7', '7', '7', '7', '7', '7', '7', '7', '7', '8', '8', '8', '8', '8', '8', '8', '8', '8', '8', '9', '9', '9', '9', '9', '9', '9', '9', '9', '9'};
        DigitOnes = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        sizeTable = new int[]{9, 99, 999, AlaRecorderLog.ErrorCode.ERROR_RECORDER_NOT_DEFINE_ERROR, BdStatsConstant.ErrorCode.ERR_LOG_FAST, 999999, 9999999, 99999999, 999999999, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED};
        CA = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();
        IA = new int[256];
        Arrays.fill(IA, -1);
        int length = CA.length;
        for (int i4 = 0; i4 < length; i4++) {
            IA[CA[i4]] = i4;
        }
        IA[61] = 0;
    }

    public static String getStringProperty(String str) {
        String str2 = null;
        try {
            str2 = System.getProperty(str);
        } catch (SecurityException e) {
        }
        return str2 == null ? DEFAULT_PROPERTIES.getProperty(str) : str2;
    }

    public static void loadPropertiesFromFile() {
        InputStream inputStream = (InputStream) AccessController.doPrivileged(new PrivilegedAction<InputStream>() { // from class: com.alibaba.fastjson.util.IOUtils.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.security.PrivilegedAction
            public InputStream run() {
                ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
                return contextClassLoader != null ? contextClassLoader.getResourceAsStream(IOUtils.FASTJSON_PROPERTIES) : ClassLoader.getSystemResourceAsStream(IOUtils.FASTJSON_PROPERTIES);
            }
        });
        if (inputStream != null) {
            try {
                DEFAULT_PROPERTIES.load(inputStream);
                inputStream.close();
            } catch (IOException e) {
            }
        }
    }

    public static void close(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e) {
            }
        }
    }

    public static int stringSize(long j) {
        long j2 = 10;
        for (int i = 1; i < 19; i++) {
            if (j >= j2) {
                j2 *= 10;
            } else {
                return i;
            }
        }
        return 19;
    }

    public static void getChars(long j, int i, char[] cArr) {
        char c;
        int i2;
        if (j >= 0) {
            c = 0;
            i2 = i;
        } else {
            j = -j;
            c = '-';
            i2 = i;
        }
        while (j > 2147483647L) {
            long j2 = j / 100;
            int i3 = (int) (j - (((j2 << 6) + (j2 << 5)) + (j2 << 2)));
            int i4 = i2 - 1;
            cArr[i4] = DigitOnes[i3];
            int i5 = i4 - 1;
            cArr[i5] = DigitTens[i3];
            i2 = i5;
            j = j2;
        }
        int i6 = (int) j;
        while (i6 >= 65536) {
            int i7 = i6 / 100;
            int i8 = i6 - (((i7 << 6) + (i7 << 5)) + (i7 << 2));
            int i9 = i2 - 1;
            cArr[i9] = DigitOnes[i8];
            i2 = i9 - 1;
            cArr[i2] = DigitTens[i8];
            i6 = i7;
        }
        int i10 = i2;
        while (true) {
            int i11 = (52429 * i6) >>> 19;
            i10--;
            cArr[i10] = digits[i6 - ((i11 << 3) + (i11 << 1))];
            if (i11 == 0) {
                break;
            }
            i6 = i11;
        }
        if (c != 0) {
            cArr[i10 - 1] = c;
        }
    }

    public static void getChars(int i, int i2, char[] cArr) {
        char c;
        int i3;
        int i4;
        if (i >= 0) {
            c = 0;
            i3 = i2;
            i4 = i;
        } else {
            i4 = -i;
            c = '-';
            i3 = i2;
        }
        while (i4 >= 65536) {
            int i5 = i4 / 100;
            int i6 = i4 - (((i5 << 6) + (i5 << 5)) + (i5 << 2));
            int i7 = i3 - 1;
            cArr[i7] = DigitOnes[i6];
            int i8 = i7 - 1;
            cArr[i8] = DigitTens[i6];
            i3 = i8;
            i4 = i5;
        }
        while (true) {
            int i9 = (52429 * i4) >>> 19;
            i3--;
            cArr[i3] = digits[i4 - ((i9 << 3) + (i9 << 1))];
            if (i9 == 0) {
                break;
            }
            i4 = i9;
        }
        if (c != 0) {
            cArr[i3 - 1] = c;
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:12:0x0006 */
    public static void getChars(byte b2, int i, char[] cArr) {
        char c = 0;
        int i2 = b2;
        if (b2 < 0) {
            c = '-';
            i2 = -b2;
        }
        while (true) {
            int i3 = (52429 * i2) >>> 19;
            i--;
            cArr[i] = digits[i2 - ((i3 << 3) + (i3 << 1))];
            if (i3 == 0) {
                break;
            }
            i2 = i3;
        }
        if (c != 0) {
            cArr[i - 1] = c;
        }
    }

    public static int stringSize(int i) {
        int i2 = 0;
        while (i > sizeTable[i2]) {
            i2++;
        }
        return i2 + 1;
    }

    public static void decode(CharsetDecoder charsetDecoder, ByteBuffer byteBuffer, CharBuffer charBuffer) {
        try {
            CoderResult decode = charsetDecoder.decode(byteBuffer, charBuffer, true);
            if (!decode.isUnderflow()) {
                decode.throwException();
            }
            CoderResult flush = charsetDecoder.flush(charBuffer);
            if (!flush.isUnderflow()) {
                flush.throwException();
            }
        } catch (CharacterCodingException e) {
            throw new JSONException("utf8 decode error, " + e.getMessage(), e);
        }
    }

    public static boolean firstIdentifier(char c) {
        return c < firstIdentifierFlags.length && firstIdentifierFlags[c];
    }

    public static boolean isIdent(char c) {
        return c < identifierFlags.length && identifierFlags[c];
    }

    public static byte[] decodeBase64(char[] cArr, int i, int i2) {
        int i3;
        if (i2 == 0) {
            return new byte[0];
        }
        int i4 = (i + i2) - 1;
        int i5 = i;
        while (i5 < i4 && IA[cArr[i5]] < 0) {
            i5++;
        }
        int i6 = i4;
        while (i6 > 0 && IA[cArr[i6]] < 0) {
            i6--;
        }
        if (cArr[i6] == '=') {
            i3 = cArr[i6 + (-1)] == '=' ? 2 : 1;
        } else {
            i3 = 0;
        }
        int i7 = (i6 - i5) + 1;
        int i8 = i2 > 76 ? (cArr[76] == '\r' ? i7 / 78 : 0) << 1 : 0;
        int i9 = (((i7 - i8) * 6) >> 3) - i3;
        byte[] bArr = new byte[i9];
        int i10 = (i9 / 3) * 3;
        int i11 = 0;
        int i12 = 0;
        while (i12 < i10) {
            int i13 = i5 + 1;
            int i14 = i13 + 1;
            int i15 = (IA[cArr[i5]] << 18) | (IA[cArr[i13]] << 12);
            int i16 = i14 + 1;
            int i17 = (IA[cArr[i14]] << 6) | i15;
            int i18 = i16 + 1;
            int i19 = i17 | IA[cArr[i16]];
            int i20 = i12 + 1;
            bArr[i12] = (byte) (i19 >> 16);
            int i21 = i20 + 1;
            bArr[i20] = (byte) (i19 >> 8);
            i12 = i21 + 1;
            bArr[i21] = (byte) i19;
            if (i8 > 0 && (i11 = i11 + 1) == 19) {
                i18 += 2;
                i11 = 0;
            }
            i5 = i18;
        }
        if (i12 < i9) {
            int i22 = 0;
            int i23 = 0;
            while (i5 <= i6 - i3) {
                int i24 = i23 | (IA[cArr[i5]] << (18 - (i22 * 6)));
                i22++;
                i23 = i24;
                i5++;
            }
            int i25 = 16;
            for (int i26 = i12; i26 < i9; i26++) {
                bArr[i26] = (byte) (i23 >> i25);
                i25 -= 8;
            }
        }
        return bArr;
    }

    public static byte[] decodeBase64(String str, int i, int i2) {
        int i3;
        if (i2 == 0) {
            return new byte[0];
        }
        int i4 = (i + i2) - 1;
        int i5 = i;
        while (i5 < i4 && IA[str.charAt(i5)] < 0) {
            i5++;
        }
        int i6 = i4;
        while (i6 > 0 && IA[str.charAt(i6)] < 0) {
            i6--;
        }
        if (str.charAt(i6) == '=') {
            i3 = str.charAt(i6 + (-1)) == '=' ? 2 : 1;
        } else {
            i3 = 0;
        }
        int i7 = (i6 - i5) + 1;
        int i8 = i2 > 76 ? (str.charAt(76) == '\r' ? i7 / 78 : 0) << 1 : 0;
        int i9 = (((i7 - i8) * 6) >> 3) - i3;
        byte[] bArr = new byte[i9];
        int i10 = (i9 / 3) * 3;
        int i11 = 0;
        int i12 = 0;
        while (i12 < i10) {
            int i13 = i5 + 1;
            int i14 = i13 + 1;
            int i15 = (IA[str.charAt(i5)] << 18) | (IA[str.charAt(i13)] << 12);
            int i16 = i14 + 1;
            int i17 = (IA[str.charAt(i14)] << 6) | i15;
            int i18 = i16 + 1;
            int i19 = i17 | IA[str.charAt(i16)];
            int i20 = i12 + 1;
            bArr[i12] = (byte) (i19 >> 16);
            int i21 = i20 + 1;
            bArr[i20] = (byte) (i19 >> 8);
            i12 = i21 + 1;
            bArr[i21] = (byte) i19;
            if (i8 > 0 && (i11 = i11 + 1) == 19) {
                i18 += 2;
                i11 = 0;
            }
            i5 = i18;
        }
        if (i12 < i9) {
            int i22 = 0;
            int i23 = 0;
            while (i5 <= i6 - i3) {
                int i24 = i23 | (IA[str.charAt(i5)] << (18 - (i22 * 6)));
                i22++;
                i23 = i24;
                i5++;
            }
            int i25 = 16;
            for (int i26 = i12; i26 < i9; i26++) {
                bArr[i26] = (byte) (i23 >> i25);
                i25 -= 8;
            }
        }
        return bArr;
    }

    public static byte[] decodeBase64(String str) {
        int i;
        int length = str.length();
        if (length == 0) {
            return new byte[0];
        }
        int i2 = length - 1;
        int i3 = 0;
        while (i3 < i2 && IA[str.charAt(i3) & 255] < 0) {
            i3++;
        }
        int i4 = i2;
        while (i4 > 0 && IA[str.charAt(i4) & 255] < 0) {
            i4--;
        }
        if (str.charAt(i4) == '=') {
            i = str.charAt(i4 + (-1)) == '=' ? 2 : 1;
        } else {
            i = 0;
        }
        int i5 = (i4 - i3) + 1;
        int i6 = length > 76 ? (str.charAt(76) == '\r' ? i5 / 78 : 0) << 1 : 0;
        int i7 = (((i5 - i6) * 6) >> 3) - i;
        byte[] bArr = new byte[i7];
        int i8 = (i7 / 3) * 3;
        int i9 = 0;
        int i10 = 0;
        while (i10 < i8) {
            int i11 = i3 + 1;
            int i12 = i11 + 1;
            int i13 = (IA[str.charAt(i3)] << 18) | (IA[str.charAt(i11)] << 12);
            int i14 = i12 + 1;
            int i15 = (IA[str.charAt(i12)] << 6) | i13;
            int i16 = i14 + 1;
            int i17 = i15 | IA[str.charAt(i14)];
            int i18 = i10 + 1;
            bArr[i10] = (byte) (i17 >> 16);
            int i19 = i18 + 1;
            bArr[i18] = (byte) (i17 >> 8);
            i10 = i19 + 1;
            bArr[i19] = (byte) i17;
            if (i6 > 0 && (i9 = i9 + 1) == 19) {
                i16 += 2;
                i9 = 0;
            }
            i3 = i16;
        }
        if (i10 < i7) {
            int i20 = 0;
            int i21 = 0;
            while (i3 <= i4 - i) {
                int i22 = i21 | (IA[str.charAt(i3)] << (18 - (i20 * 6)));
                i20++;
                i21 = i22;
                i3++;
            }
            int i23 = 16;
            for (int i24 = i10; i24 < i7; i24++) {
                bArr[i24] = (byte) (i21 >> i23);
                i23 -= 8;
            }
        }
        return bArr;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v20, types: [int] */
    public static int encodeUTF8(char[] cArr, int i, int i2, byte[] bArr) {
        int i3;
        int i4 = i + i2;
        int i5 = 0;
        int min = 0 + Math.min(i2, bArr.length);
        int i6 = i;
        while (i5 < min && cArr[i6] < 128) {
            bArr[i5] = (byte) cArr[i6];
            i5++;
            i6++;
        }
        int i7 = i5;
        int i8 = i6;
        while (i8 < i4) {
            int i9 = i8 + 1;
            char c = cArr[i8];
            if (c < 128) {
                i3 = i7 + 1;
                bArr[i7] = (byte) c;
            } else if (c < 2048) {
                int i10 = i7 + 1;
                bArr[i7] = (byte) ((c >> 6) | 192);
                i3 = i10 + 1;
                bArr[i10] = (byte) ((c & '?') | 128);
            } else if (c >= 55296 && c < 57344) {
                int i11 = i9 - 1;
                if (Character.isHighSurrogate(c)) {
                    if (i4 - i11 < 2) {
                        c = 65535;
                    } else {
                        char c2 = cArr[i11 + 1];
                        if (Character.isLowSurrogate(c2)) {
                            c = Character.toCodePoint(c, c2);
                        } else {
                            throw new JSONException("encodeUTF8 error", new MalformedInputException(1));
                        }
                    }
                } else if (Character.isLowSurrogate(c)) {
                    throw new JSONException("encodeUTF8 error", new MalformedInputException(1));
                }
                if (c < 0) {
                    i3 = i7 + 1;
                    bArr[i7] = 63;
                } else {
                    int i12 = i7 + 1;
                    bArr[i7] = (byte) ((c >> 18) | 240);
                    int i13 = i12 + 1;
                    bArr[i12] = (byte) (((c >> '\f') & 63) | 128);
                    int i14 = i13 + 1;
                    bArr[i13] = (byte) (((c >> 6) & 63) | 128);
                    i3 = i14 + 1;
                    bArr[i14] = (byte) ((c & '?') | 128);
                    i9++;
                }
            } else {
                int i15 = i7 + 1;
                bArr[i7] = (byte) ((c >> '\f') | 224);
                int i16 = i15 + 1;
                bArr[i15] = (byte) (((c >> 6) & 63) | 128);
                i3 = i16 + 1;
                bArr[i16] = (byte) ((c & '?') | 128);
            }
            i7 = i3;
            i8 = i9;
        }
        return i7;
    }

    public static int decodeUTF8(byte[] bArr, int i, int i2, char[] cArr) {
        int i3 = i + i2;
        int min = Math.min(i2, cArr.length);
        int i4 = 0;
        int i5 = i;
        while (i4 < min && bArr[i5] >= 0) {
            cArr[i4] = (char) bArr[i5];
            i4++;
            i5++;
        }
        int i6 = i5;
        while (i6 < i3) {
            int i7 = i6 + 1;
            byte b2 = bArr[i6];
            if (b2 >= 0) {
                cArr[i4] = (char) b2;
                i4++;
                i6 = i7;
            } else if ((b2 >> 5) == -2 && (b2 & 30) != 0) {
                if (i7 >= i3) {
                    return -1;
                }
                i6 = i7 + 1;
                byte b3 = bArr[i7];
                if ((b3 & 192) != 128) {
                    return -1;
                }
                cArr[i4] = (char) ((b3 ^ (b2 << 6)) ^ 3968);
                i4++;
            } else if ((b2 >> 4) == -2) {
                if (i7 + 1 >= i3) {
                    return -1;
                }
                int i8 = i7 + 1;
                byte b4 = bArr[i7];
                i6 = i8 + 1;
                byte b5 = bArr[i8];
                if ((b2 == -32 && (b4 & 224) == 128) || (b4 & 192) != 128 || (b5 & 192) != 128) {
                    return -1;
                }
                char c = (char) ((b5 ^ (-123008)) ^ ((b4 << 6) ^ (b2 << 12)));
                if (c >= 55296 && c < 57344) {
                    return -1;
                }
                cArr[i4] = c;
                i4++;
            } else if ((b2 >> 3) != -2 || i7 + 2 >= i3) {
                return -1;
            } else {
                int i9 = i7 + 1;
                byte b6 = bArr[i7];
                int i10 = i9 + 1;
                byte b7 = bArr[i9];
                int i11 = i10 + 1;
                byte b8 = bArr[i10];
                int i12 = (((b2 << 18) ^ (b6 << 12)) ^ (b7 << 6)) ^ (3678080 ^ b8);
                if ((b6 & 192) != 128 || (b7 & 192) != 128 || (b8 & 192) != 128 || !Character.isSupplementaryCodePoint(i12)) {
                    return -1;
                }
                int i13 = i4 + 1;
                cArr[i4] = (char) ((i12 >>> 10) + 55232);
                i4 = i13 + 1;
                cArr[i13] = (char) ((i12 & 1023) + 56320);
                i6 = i11;
            }
        }
        return i4;
    }

    public static String readAll(Reader reader) {
        StringBuilder sb = new StringBuilder();
        try {
            char[] cArr = new char[2048];
            while (true) {
                int read = reader.read(cArr, 0, cArr.length);
                if (read >= 0) {
                    sb.append(cArr, 0, read);
                } else {
                    return sb.toString();
                }
            }
        } catch (Exception e) {
            throw new JSONException("read string from reader error", e);
        }
    }

    public static boolean isValidJsonpQueryParam(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt != '.' && !isIdent(charAt)) {
                return false;
            }
        }
        return true;
    }
}
