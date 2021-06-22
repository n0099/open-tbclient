package com.baidu.searchbox.v8engine.net.io;

import com.baidu.android.common.others.IStringUtil;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import java.io.Serializable;
import java.util.Arrays;
/* loaded from: classes2.dex */
public class d implements Serializable, Comparable<d> {

    /* renamed from: a  reason: collision with root package name */
    public static final char[] f10126a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: b  reason: collision with root package name */
    public static final d f10127b = a(new byte[0]);

    /* renamed from: c  reason: collision with root package name */
    public final byte[] f10128c;

    /* renamed from: d  reason: collision with root package name */
    public transient int f10129d;

    /* renamed from: e  reason: collision with root package name */
    public transient String f10130e;

    public d(byte[] bArr) {
        this.f10128c = bArr;
    }

    public static d a(byte... bArr) {
        if (bArr != null) {
            return new d((byte[]) bArr.clone());
        }
        throw new IllegalArgumentException("data == null");
    }

    public String b() {
        byte[] bArr = this.f10128c;
        char[] cArr = new char[bArr.length * 2];
        int i2 = 0;
        for (byte b2 : bArr) {
            int i3 = i2 + 1;
            char[] cArr2 = f10126a;
            cArr[i2] = cArr2[(b2 >> 4) & 15];
            i2 = i3 + 1;
            cArr[i3] = cArr2[b2 & 15];
        }
        return new String(cArr);
    }

    public int c() {
        return this.f10128c.length;
    }

    public byte[] d() {
        return (byte[]) this.f10128c.clone();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d) {
            d dVar = (d) obj;
            int c2 = dVar.c();
            byte[] bArr = this.f10128c;
            if (c2 == bArr.length && dVar.a(0, bArr, 0, bArr.length)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i2 = this.f10129d;
        if (i2 != 0) {
            return i2;
        }
        int hashCode = Arrays.hashCode(this.f10128c);
        this.f10129d = hashCode;
        return hashCode;
    }

    public String toString() {
        StringBuilder sb;
        if (this.f10128c.length == 0) {
            return "[size=0]";
        }
        String a2 = a();
        int a3 = a(a2, 64);
        if (a3 == -1) {
            if (this.f10128c.length <= 64) {
                return "[hex=" + b() + PreferencesUtil.RIGHT_MOUNT;
            }
            return "[size=" + this.f10128c.length + " hex=" + a(0, 64).b() + "…]";
        }
        String replace = a2.substring(0, a3).replace(IStringUtil.WINDOWS_FOLDER_SEPARATOR, "\\\\").replace("\n", "\\n").replace("\r", "\\r");
        if (a3 < a2.length()) {
            sb = new StringBuilder();
            sb.append("[size=");
            sb.append(this.f10128c.length);
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

    public String a() {
        String str = this.f10130e;
        if (str != null) {
            return str;
        }
        String str2 = new String(this.f10128c, com.baidu.searchbox.v8engine.net.b.f10122a);
        this.f10130e = str2;
        return str2;
    }

    public d a(int i2, int i3) {
        if (i2 >= 0) {
            byte[] bArr = this.f10128c;
            if (i3 > bArr.length) {
                throw new IllegalArgumentException("endIndex > length(" + this.f10128c.length + SmallTailInfo.EMOTION_SUFFIX);
            }
            int i4 = i3 - i2;
            if (i4 >= 0) {
                if (i2 == 0 && i3 == bArr.length) {
                    return this;
                }
                byte[] bArr2 = new byte[i4];
                System.arraycopy(this.f10128c, i2, bArr2, 0, i4);
                return new d(bArr2);
            }
            throw new IllegalArgumentException("endIndex < beginIndex");
        }
        throw new IllegalArgumentException("beginIndex < 0");
    }

    public byte a(int i2) {
        return this.f10128c[i2];
    }

    public boolean a(int i2, d dVar, int i3, int i4) {
        return dVar.a(i3, this.f10128c, i2, i4);
    }

    public boolean a(int i2, byte[] bArr, int i3, int i4) {
        if (i2 >= 0) {
            byte[] bArr2 = this.f10128c;
            if (i2 <= bArr2.length - i4 && i3 >= 0 && i3 <= bArr.length - i4 && j.a(bArr2, i2, bArr, i3, i4)) {
                return true;
            }
        }
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(d dVar) {
        int c2 = c();
        int c3 = dVar.c();
        int min = Math.min(c2, c3);
        for (int i2 = 0; i2 < min; i2++) {
            int a2 = a(i2) & 255;
            int a3 = dVar.a(i2) & 255;
            if (a2 != a3) {
                return a2 < a3 ? -1 : 1;
            }
        }
        if (c2 == c3) {
            return 0;
        }
        return c2 < c3 ? -1 : 1;
    }

    public static int a(String str, int i2) {
        int length = str.length();
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            if (i4 == i2) {
                return i3;
            }
            int codePointAt = str.codePointAt(i3);
            if ((Character.isISOControl(codePointAt) && codePointAt != 10 && codePointAt != 13) || codePointAt == 65533) {
                return -1;
            }
            i4++;
            i3 += Character.charCount(codePointAt);
        }
        return str.length();
    }
}
