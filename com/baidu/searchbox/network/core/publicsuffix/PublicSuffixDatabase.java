package com.baidu.searchbox.network.core.publicsuffix;

import com.baidu.searchbox.network.core.HttpResourceManager;
import com.baidu.searchbox.network.core.internal.Util;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.IDN;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import okio.BufferedSource;
import okio.GzipSource;
import okio.Okio;
/* loaded from: classes13.dex */
public final class PublicSuffixDatabase {
    private static final byte EXCEPTION_MARKER = 33;
    public static final String PUBLIC_SUFFIX_RESOURCE = "publicsuffixes.gz";
    private byte[] publicSuffixExceptionListBytes;
    private byte[] publicSuffixListBytes;
    private static final byte[] WILDCARD_LABEL = {42};
    private static final String[] EMPTY_RULE = new String[0];
    private static final String[] PREVAILING_RULE = {"*"};
    private static final PublicSuffixDatabase instance = new PublicSuffixDatabase();
    private final AtomicBoolean listRead = new AtomicBoolean(false);
    private final CountDownLatch readCompleteLatch = new CountDownLatch(1);

    public static PublicSuffixDatabase get() {
        return instance;
    }

    public String getEffectiveTldPlusOne(String str) {
        int length;
        if (str == null) {
            throw new NullPointerException("domain == null");
        }
        String[] split = IDN.toUnicode(str).split("\\.");
        String[] findMatchingRule = findMatchingRule(split);
        if (split.length == findMatchingRule.length && findMatchingRule[0].charAt(0) != '!') {
            return null;
        }
        if (findMatchingRule[0].charAt(0) == '!') {
            length = split.length - findMatchingRule.length;
        } else {
            length = split.length - (findMatchingRule.length + 1);
        }
        StringBuilder sb = new StringBuilder();
        String[] split2 = str.split("\\.");
        while (length < split2.length) {
            sb.append(split2[length]).append('.');
            length++;
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    private String[] findMatchingRule(String[] strArr) {
        String str;
        String str2;
        String str3 = null;
        int i = 0;
        if (!this.listRead.get() && this.listRead.compareAndSet(false, true)) {
            readTheListUninterruptibly();
        } else {
            try {
                this.readCompleteLatch.await();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        synchronized (this) {
            if (this.publicSuffixListBytes == null) {
                throw new IllegalStateException("Unable to load publicsuffixes.gz resource from the classpath.");
            }
        }
        byte[][] bArr = new byte[strArr.length];
        for (int i2 = 0; i2 < strArr.length; i2++) {
            bArr[i2] = strArr[i2].getBytes(Util.UTF_8);
        }
        int i3 = 0;
        while (true) {
            if (i3 >= bArr.length) {
                str = null;
                break;
            }
            str = binarySearchBytes(this.publicSuffixListBytes, bArr, i3);
            if (str != null) {
                break;
            }
            i3++;
        }
        if (bArr.length > 1) {
            byte[][] bArr2 = (byte[][]) bArr.clone();
            for (int i4 = 0; i4 < bArr2.length - 1; i4++) {
                bArr2[i4] = WILDCARD_LABEL;
                String binarySearchBytes = binarySearchBytes(this.publicSuffixListBytes, bArr2, i4);
                if (binarySearchBytes != null) {
                    str2 = binarySearchBytes;
                    break;
                }
            }
        }
        str2 = null;
        if (str2 != null) {
            while (true) {
                if (i >= bArr.length - 1) {
                    break;
                }
                String binarySearchBytes2 = binarySearchBytes(this.publicSuffixExceptionListBytes, bArr, i);
                if (binarySearchBytes2 != null) {
                    str3 = binarySearchBytes2;
                    break;
                }
                i++;
            }
        }
        if (str3 != null) {
            return ("!" + str3).split("\\.");
        }
        if (str == null && str2 == null) {
            return PREVAILING_RULE;
        }
        String[] split = str != null ? str.split("\\.") : EMPTY_RULE;
        String[] split2 = str2 != null ? str2.split("\\.") : EMPTY_RULE;
        return split.length > split2.length ? split : split2;
    }

    private static String binarySearchBytes(byte[] bArr, byte[][] bArr2, int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8 = 0;
        int length = bArr.length;
        while (i8 < length) {
            int i9 = (i8 + length) / 2;
            while (i9 > -1 && bArr[i9] != 10) {
                i9--;
            }
            int i10 = i9 + 1;
            int i11 = 1;
            while (bArr[i10 + i11] != 10) {
                i11++;
            }
            int i12 = (i10 + i11) - i10;
            int i13 = 0;
            int i14 = 0;
            boolean z = false;
            int i15 = i;
            while (true) {
                if (z) {
                    i2 = 46;
                    z = false;
                } else {
                    i2 = bArr2[i15][i13] & 255;
                }
                i3 = i2 - (bArr[i10 + i14] & 255);
                if (i3 != 0) {
                    i4 = i14;
                    i5 = i13;
                    break;
                }
                i14++;
                int i16 = i13 + 1;
                if (i14 == i12) {
                    i5 = i16;
                    i4 = i14;
                    break;
                }
                if (bArr2[i15].length == i16) {
                    if (i15 == bArr2.length - 1) {
                        i5 = i16;
                        i4 = i14;
                        break;
                    }
                    i15++;
                    i16 = -1;
                    z = true;
                }
                i13 = i16;
            }
            if (i3 < 0) {
                i7 = i10 - 1;
                i6 = i8;
            } else if (i3 > 0) {
                i6 = i11 + i10 + 1;
                i7 = length;
            } else {
                int i17 = i12 - i4;
                int length2 = bArr2[i15].length - i5;
                for (int i18 = i15 + 1; i18 < bArr2.length; i18++) {
                    length2 += bArr2[i18].length;
                }
                if (length2 < i17) {
                    i7 = i10 - 1;
                    i6 = i8;
                } else if (length2 > i17) {
                    i6 = i11 + i10 + 1;
                    i7 = length;
                } else {
                    return new String(bArr, i10, i12, Util.UTF_8);
                }
            }
            length = i7;
            i8 = i6;
        }
        return null;
    }

    private void readTheListUninterruptibly() {
        boolean z;
        boolean z2 = false;
        while (true) {
            try {
                try {
                    z = z2;
                    readTheList();
                    break;
                } catch (InterruptedIOException e) {
                    Thread.interrupted();
                    z2 = true;
                } catch (IOException e2) {
                    if (!z) {
                        return;
                    }
                    Thread.currentThread().interrupt();
                    return;
                }
            } catch (Throwable th) {
                if (z) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (!z) {
            return;
        }
        Thread.currentThread().interrupt();
    }

    private void readTheList() throws IOException {
        InputStream publicSuffixResourceInputStream = HttpResourceManager.getSingleton().getPublicSuffixResourceInputStream();
        if (publicSuffixResourceInputStream != null) {
            BufferedSource buffer = Okio.buffer(new GzipSource(Okio.source(publicSuffixResourceInputStream)));
            try {
                byte[] bArr = new byte[buffer.readInt()];
                buffer.readFully(bArr);
                byte[] bArr2 = new byte[buffer.readInt()];
                buffer.readFully(bArr2);
                synchronized (this) {
                    this.publicSuffixListBytes = bArr;
                    this.publicSuffixExceptionListBytes = bArr2;
                }
                this.readCompleteLatch.countDown();
            } finally {
                Util.closeQuietly(buffer);
            }
        }
    }

    void setListBytes(byte[] bArr, byte[] bArr2) {
        this.publicSuffixListBytes = bArr;
        this.publicSuffixExceptionListBytes = bArr2;
        this.listRead.set(true);
        this.readCompleteLatch.countDown();
    }
}
