package com.baidu.searchbox.v8engine.net.io;

import com.baidu.android.common.others.IStringUtil;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.huawei.hms.common.internal.TransactionIdCreater;
import java.io.Serializable;
import java.util.Arrays;
/* loaded from: classes3.dex */
public class d implements Serializable, Comparable<d> {
    public static final char[] a = {TransactionIdCreater.FILL_BYTE, '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    public static final d b = a(new byte[0]);
    public final byte[] c;
    public transient int d;
    public transient String e;

    public String a() {
        String str = this.e;
        if (str == null) {
            String str2 = new String(this.c, com.baidu.searchbox.v8engine.net.b.a);
            this.e = str2;
            return str2;
        }
        return str;
    }

    public String b() {
        byte[] bArr = this.c;
        char[] cArr = new char[bArr.length * 2];
        int i = 0;
        for (byte b2 : bArr) {
            int i2 = i + 1;
            char[] cArr2 = a;
            cArr[i] = cArr2[(b2 >> 4) & 15];
            i = i2 + 1;
            cArr[i2] = cArr2[b2 & 15];
        }
        return new String(cArr);
    }

    public int c() {
        return this.c.length;
    }

    public byte[] d() {
        return (byte[]) this.c.clone();
    }

    public int hashCode() {
        int i = this.d;
        if (i == 0) {
            int hashCode = Arrays.hashCode(this.c);
            this.d = hashCode;
            return hashCode;
        }
        return i;
    }

    public d(byte[] bArr) {
        this.c = bArr;
    }

    public static d a(byte... bArr) {
        if (bArr != null) {
            return new d((byte[]) bArr.clone());
        }
        throw new IllegalArgumentException("data == null");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d) {
            d dVar = (d) obj;
            int c = dVar.c();
            byte[] bArr = this.c;
            if (c == bArr.length && dVar.a(0, bArr, 0, bArr.length)) {
                return true;
            }
        }
        return false;
    }

    public static int a(String str, int i) {
        int length = str.length();
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            if (i3 == i) {
                return i2;
            }
            int codePointAt = str.codePointAt(i2);
            if ((Character.isISOControl(codePointAt) && codePointAt != 10 && codePointAt != 13) || codePointAt == 65533) {
                return -1;
            }
            i3++;
            i2 += Character.charCount(codePointAt);
        }
        return str.length();
    }

    public byte a(int i) {
        return this.c[i];
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(d dVar) {
        int c = c();
        int c2 = dVar.c();
        int min = Math.min(c, c2);
        for (int i = 0; i < min; i++) {
            int a2 = a(i) & 255;
            int a3 = dVar.a(i) & 255;
            if (a2 != a3) {
                if (a2 < a3) {
                    return -1;
                } else {
                    return 1;
                }
            }
        }
        if (c == c2) {
            return 0;
        }
        if (c < c2) {
            return -1;
        }
        return 1;
    }

    public d a(int i, int i2) {
        if (i >= 0) {
            byte[] bArr = this.c;
            if (i2 <= bArr.length) {
                int i3 = i2 - i;
                if (i3 >= 0) {
                    if (i == 0 && i2 == bArr.length) {
                        return this;
                    }
                    byte[] bArr2 = new byte[i3];
                    System.arraycopy(this.c, i, bArr2, 0, i3);
                    return new d(bArr2);
                }
                throw new IllegalArgumentException("endIndex < beginIndex");
            }
            throw new IllegalArgumentException("endIndex > length(" + this.c.length + SmallTailInfo.EMOTION_SUFFIX);
        }
        throw new IllegalArgumentException("beginIndex < 0");
    }

    public boolean a(int i, d dVar, int i2, int i3) {
        return dVar.a(i2, this.c, i, i3);
    }

    public boolean a(int i, byte[] bArr, int i2, int i3) {
        if (i >= 0) {
            byte[] bArr2 = this.c;
            if (i <= bArr2.length - i3 && i2 >= 0 && i2 <= bArr.length - i3 && j.a(bArr2, i, bArr, i2, i3)) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        StringBuilder sb;
        if (this.c.length == 0) {
            return "[size=0]";
        }
        String a2 = a();
        int a3 = a(a2, 64);
        if (a3 == -1) {
            if (this.c.length <= 64) {
                return "[hex=" + b() + PreferencesUtil.RIGHT_MOUNT;
            }
            return "[size=" + this.c.length + " hex=" + a(0, 64).b() + "…]";
        }
        String replace = a2.substring(0, a3).replace(IStringUtil.WINDOWS_FOLDER_SEPARATOR, "\\\\").replace("\n", "\\n").replace("\r", "\\r");
        if (a3 < a2.length()) {
            sb = new StringBuilder();
            sb.append("[size=");
            sb.append(this.c.length);
            sb.append(" text=");
            sb.append(replace);
            sb.append("…]");
        } else {
            sb = new StringBuilder();
            sb.append("[text=");
            sb.append(replace);
            sb.append(PreferencesUtil.RIGHT_MOUNT);
        }
        return sb.toString();
    }
}
