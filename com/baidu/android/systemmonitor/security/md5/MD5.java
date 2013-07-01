package com.baidu.android.systemmonitor.security.md5;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
/* loaded from: classes.dex */
public class MD5 {
    static byte[] c = {Byte.MIN_VALUE, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    private static boolean d = false;
    private static boolean e = true;
    private static final char[] f = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: a  reason: collision with root package name */
    a f431a;
    a b;

    public MD5() {
        if (e) {
            c();
        }
        a();
    }

    private native void Transform_native(int[] iArr, byte[] bArr, int i, int i2);

    public static String a(byte[] bArr) {
        int i = 0;
        char[] cArr = new char[bArr.length * 2];
        for (int i2 = 0; i2 < bArr.length; i2++) {
            int i3 = i + 1;
            cArr[i] = f[(bArr[i2] >>> 4) & 15];
            i = i3 + 1;
            cArr[i3] = f[bArr[i2] & 15];
        }
        return new String(cArr);
    }

    /*  JADX ERROR: Type inference failed with exception
        jadx.core.utils.exceptions.JadxOverflowException: Type update terminated with stack overflow, arg: (r1v50 ?? I:int)
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:56)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:30)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:18)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:114)
        */
    private void a(com.baidu.android.systemmonitor.security.md5.a r12, byte[] r13, int r14, int[] r15) {
        /*
            r11 = this;
            r10 = 4
            r9 = 3
            r8 = 2
            r7 = 1
            r6 = 0
            int[] r0 = r12.f432a
            r0 = r0[r6]
            int[] r1 = r12.f432a
            r1 = r1[r7]
            int[] r2 = r12.f432a
            r2 = r2[r8]
            int[] r3 = r12.f432a
            r3 = r3[r9]
            r11.a(r13, r14, r15)
            r4 = r1 & r2
            r5 = r1 ^ (-1)
            r5 = r5 & r3
            r4 = r4 | r5
            r5 = r15[r6]
            int r4 = r4 + r5
            r5 = -680876936(0xffffffffd76aa478, float:-2.5799211E14)
            int r4 = r4 + r5
            int r0 = r0 + r4
            int r4 = r0 << 7
            int r0 = r0 >>> 25
            r0 = r0 | r4
            int r0 = r0 + r1
            r4 = r0 & r1
            r5 = r0 ^ (-1)
            r5 = r5 & r2
            r4 = r4 | r5
            r5 = r15[r7]
            int r4 = r4 + r5
            r5 = -389564586(0xffffffffe8c7b756, float:-7.545063E24)
            int r4 = r4 + r5
            int r3 = r3 + r4
            int r4 = r3 << 12
            int r3 = r3 >>> 20
            r3 = r3 | r4
            int r3 = r3 + r0
            r4 = r3 & r0
            r5 = r3 ^ (-1)
            r5 = r5 & r1
            r4 = r4 | r5
            r5 = r15[r8]
            int r4 = r4 + r5
            r5 = 606105819(0x242070db, float:3.4790062E-17)
            int r4 = r4 + r5
            int r2 = r2 + r4
            int r4 = r2 << 17
            int r2 = r2 >>> 15
            r2 = r2 | r4
            int r2 = r2 + r3
            r4 = r2 & r3
            r5 = r2 ^ (-1)
            r5 = r5 & r0
            r4 = r4 | r5
            r5 = r15[r9]
            int r4 = r4 + r5
            r5 = -1044525330(0xffffffffc1bdceee, float:-23.72604)
            int r4 = r4 + r5
            int r1 = r1 + r4
            int r4 = r1 << 22
            int r1 = r1 >>> 10
            r1 = r1 | r4
            int r1 = r1 + r2
            r4 = r1 & r2
            r5 = r1 ^ (-1)
            r5 = r5 & r3
            r4 = r4 | r5
            r5 = r15[r10]
            int r4 = r4 + r5
            r5 = -176418897(0xfffffffff57c0faf, float:-3.1952561E32)
            int r4 = r4 + r5
            int r0 = r0 + r4
            int r4 = r0 << 7
            int r0 = r0 >>> 25
            r0 = r0 | r4
            int r0 = r0 + r1
            r4 = r0 & r1
            r5 = r0 ^ (-1)
            r5 = r5 & r2
            r4 = r4 | r5
            r5 = 5
            r5 = r15[r5]
            int r4 = r4 + r5
            r5 = 1200080426(0x4787c62a, float:69516.33)
            int r4 = r4 + r5
            int r3 = r3 + r4
            int r4 = r3 << 12
            int r3 = r3 >>> 20
            r3 = r3 | r4
            int r3 = r3 + r0
            r4 = r3 & r0
            r5 = r3 ^ (-1)
            r5 = r5 & r1
            r4 = r4 | r5
            r5 = 6
            r5 = r15[r5]
            int r4 = r4 + r5
            r5 = -1473231341(0xffffffffa8304613, float:-9.7851575E-15)
            int r4 = r4 + r5
            int r2 = r2 + r4
            int r4 = r2 << 17
            int r2 = r2 >>> 15
            r2 = r2 | r4
            int r2 = r2 + r3
            r4 = r2 & r3
            r5 = r2 ^ (-1)
            r5 = r5 & r0
            r4 = r4 | r5
            r5 = 7
            r5 = r15[r5]
            int r4 = r4 + r5
            r5 = -45705983(0xfffffffffd469501, float:-1.6497551E37)
            int r4 = r4 + r5
            int r1 = r1 + r4
            int r4 = r1 << 22
            int r1 = r1 >>> 10
            r1 = r1 | r4
            int r1 = r1 + r2
            r4 = r1 & r2
            r5 = r1 ^ (-1)
            r5 = r5 & r3
            r4 = r4 | r5
            r5 = 8
            r5 = r15[r5]
            int r4 = r4 + r5
            r5 = 1770035416(0x698098d8, float:1.9433036E25)
            int r4 = r4 + r5
            int r0 = r0 + r4
            int r4 = r0 << 7
            int r0 = r0 >>> 25
            r0 = r0 | r4
            int r0 = r0 + r1
            r4 = r0 & r1
            r5 = r0 ^ (-1)
            r5 = r5 & r2
            r4 = r4 | r5
            r5 = 9
            r5 = r15[r5]
            int r4 = r4 + r5
            r5 = -1958414417(0xffffffff8b44f7af, float:-3.7934563E-32)
            int r4 = r4 + r5
            int r3 = r3 + r4
            int r4 = r3 << 12
            int r3 = r3 >>> 20
            r3 = r3 | r4
            int r3 = r3 + r0
            r4 = r3 & r0
            r5 = r3 ^ (-1)
            r5 = r5 & r1
            r4 = r4 | r5
            r5 = 10
            r5 = r15[r5]
            int r4 = r4 + r5
            r5 = -42063(0xffffffffffff5bb1, float:NaN)
            int r4 = r4 + r5
            int r2 = r2 + r4
            int r4 = r2 << 17
            int r2 = r2 >>> 15
            r2 = r2 | r4
            int r2 = r2 + r3
            r4 = r2 & r3
            r5 = r2 ^ (-1)
            r5 = r5 & r0
            r4 = r4 | r5
            r5 = 11
            r5 = r15[r5]
            int r4 = r4 + r5
            r5 = -1990404162(0xffffffff895cd7be, float:-2.6582978E-33)
            int r4 = r4 + r5
            int r1 = r1 + r4
            int r4 = r1 << 22
            int r1 = r1 >>> 10
            r1 = r1 | r4
            int r1 = r1 + r2
            r4 = r1 & r2
            r5 = r1 ^ (-1)
            r5 = r5 & r3
            r4 = r4 | r5
            r5 = 12
            r5 = r15[r5]
            int r4 = r4 + r5
            r5 = 1804603682(0x6b901122, float:3.4833245E26)
            int r4 = r4 + r5
            int r0 = r0 + r4
            int r4 = r0 << 7
            int r0 = r0 >>> 25
            r0 = r0 | r4
            int r0 = r0 + r1
            r4 = r0 & r1
            r5 = r0 ^ (-1)
            r5 = r5 & r2
            r4 = r4 | r5
            r5 = 13
            r5 = r15[r5]
            int r4 = r4 + r5
            r5 = -40341101(0xfffffffffd987193, float:-2.5329046E37)
            int r4 = r4 + r5
            int r3 = r3 + r4
            int r4 = r3 << 12
            int r3 = r3 >>> 20
            r3 = r3 | r4
            int r3 = r3 + r0
            r4 = r3 & r0
            r5 = r3 ^ (-1)
            r5 = r5 & r1
            r4 = r4 | r5
            r5 = 14
            r5 = r15[r5]
            int r4 = r4 + r5
            r5 = -1502002290(0xffffffffa679438e, float:-8.6480783E-16)
            int r4 = r4 + r5
            int r2 = r2 + r4
            int r4 = r2 << 17
            int r2 = r2 >>> 15
            r2 = r2 | r4
            int r2 = r2 + r3
            r4 = r2 & r3
            r5 = r2 ^ (-1)
            r5 = r5 & r0
            r4 = r4 | r5
            r5 = 15
            r5 = r15[r5]
            int r4 = r4 + r5
            r5 = 1236535329(0x49b40821, float:1474820.1)
            int r4 = r4 + r5
            int r1 = r1 + r4
            int r4 = r1 << 22
            int r1 = r1 >>> 10
            r1 = r1 | r4
            int r1 = r1 + r2
            r4 = r1 & r3
            r5 = r3 ^ (-1)
            r5 = r5 & r2
            r4 = r4 | r5
            r5 = r15[r7]
            int r4 = r4 + r5
            r5 = -165796510(0xfffffffff61e2562, float:-8.018956E32)
            int r4 = r4 + r5
            int r0 = r0 + r4
            int r4 = r0 << 5
            int r0 = r0 >>> 27
            r0 = r0 | r4
            int r0 = r0 + r1
            r4 = r0 & r2
            r5 = r2 ^ (-1)
            r5 = r5 & r1
            r4 = r4 | r5
            r5 = 6
            r5 = r15[r5]
            int r4 = r4 + r5
            r5 = -1069501632(0xffffffffc040b340, float:-3.0109406)
            int r4 = r4 + r5
            int r3 = r3 + r4
            int r4 = r3 << 9
            int r3 = r3 >>> 23
            r3 = r3 | r4
            int r3 = r3 + r0
            r4 = r3 & r1
            r5 = r1 ^ (-1)
            r5 = r5 & r0
            r4 = r4 | r5
            r5 = 11
            r5 = r15[r5]
            int r4 = r4 + r5
            r5 = 643717713(0x265e5a51, float:7.7144124E-16)
            int r4 = r4 + r5
            int r2 = r2 + r4
            int r4 = r2 << 14
            int r2 = r2 >>> 18
            r2 = r2 | r4
            int r2 = r2 + r3
            r4 = r2 & r0
            r5 = r0 ^ (-1)
            r5 = r5 & r3
            r4 = r4 | r5
            r5 = r15[r6]
            int r4 = r4 + r5
            r5 = -373897302(0xffffffffe9b6c7aa, float:-2.7620923E25)
            int r4 = r4 + r5
            int r1 = r1 + r4
            int r4 = r1 << 20
            int r1 = r1 >>> 12
            r1 = r1 | r4
            int r1 = r1 + r2
            r4 = r1 & r3
            r5 = r3 ^ (-1)
            r5 = r5 & r2
            r4 = r4 | r5
            r5 = 5
            r5 = r15[r5]
            int r4 = r4 + r5
            r5 = -701558691(0xffffffffd62f105d, float:-4.8121204E13)
            int r4 = r4 + r5
            int r0 = r0 + r4
            int r4 = r0 << 5
            int r0 = r0 >>> 27
            r0 = r0 | r4
            int r0 = r0 + r1
            r4 = r0 & r2
            r5 = r2 ^ (-1)
            r5 = r5 & r1
            r4 = r4 | r5
            r5 = 10
            r5 = r15[r5]
            int r4 = r4 + r5
            r5 = 38016083(0x2441453, float:1.4405639E-37)
            int r4 = r4 + r5
            int r3 = r3 + r4
            int r4 = r3 << 9
            int r3 = r3 >>> 23
            r3 = r3 | r4
            int r3 = r3 + r0
            r4 = r3 & r1
            r5 = r1 ^ (-1)
            r5 = r5 & r0
            r4 = r4 | r5
            r5 = 15
            r5 = r15[r5]
            int r4 = r4 + r5
            r5 = -660478335(0xffffffffd8a1e681, float:-1.424091E15)
            int r4 = r4 + r5
            int r2 = r2 + r4
            int r4 = r2 << 14
            int r2 = r2 >>> 18
            r2 = r2 | r4
            int r2 = r2 + r3
            r4 = r2 & r0
            r5 = r0 ^ (-1)
            r5 = r5 & r3
            r4 = r4 | r5
            r5 = r15[r10]
            int r4 = r4 + r5
            r5 = -405537848(0xffffffffe7d3fbc8, float:-2.0021277E24)
            int r4 = r4 + r5
            int r1 = r1 + r4
            int r4 = r1 << 20
            int r1 = r1 >>> 12
            r1 = r1 | r4
            int r1 = r1 + r2
            r4 = r1 & r3
            r5 = r3 ^ (-1)
            r5 = r5 & r2
            r4 = r4 | r5
            r5 = 9
            r5 = r15[r5]
            int r4 = r4 + r5
            r5 = 568446438(0x21e1cde6, float:1.5301094E-18)
            int r4 = r4 + r5
            int r0 = r0 + r4
            int r4 = r0 << 5
            int r0 = r0 >>> 27
            r0 = r0 | r4
            int r0 = r0 + r1
            r4 = r0 & r2
            r5 = r2 ^ (-1)
            r5 = r5 & r1
            r4 = r4 | r5
            r5 = 14
            r5 = r15[r5]
            int r4 = r4 + r5
            r5 = -1019803690(0xffffffffc33707d6, float:-183.03061)
            int r4 = r4 + r5
            int r3 = r3 + r4
            int r4 = r3 << 9
            int r3 = r3 >>> 23
            r3 = r3 | r4
            int r3 = r3 + r0
            r4 = r3 & r1
            r5 = r1 ^ (-1)
            r5 = r5 & r0
            r4 = r4 | r5
            r5 = r15[r9]
            int r4 = r4 + r5
            r5 = -187363961(0xfffffffff4d50d87, float:-1.3503828E32)
            int r4 = r4 + r5
            int r2 = r2 + r4
            int r4 = r2 << 14
            int r2 = r2 >>> 18
            r2 = r2 | r4
            int r2 = r2 + r3
            r4 = r2 & r0
            r5 = r0 ^ (-1)
            r5 = r5 & r3
            r4 = r4 | r5
            r5 = 8
            r5 = r15[r5]
            int r4 = r4 + r5
            r5 = 1163531501(0x455a14ed, float:3489.3079)
            int r4 = r4 + r5
            int r1 = r1 + r4
            int r4 = r1 << 20
            int r1 = r1 >>> 12
            r1 = r1 | r4
            int r1 = r1 + r2
            r4 = r1 & r3
            r5 = r3 ^ (-1)
            r5 = r5 & r2
            r4 = r4 | r5
            r5 = 13
            r5 = r15[r5]
            int r4 = r4 + r5
            r5 = -1444681467(0xffffffffa9e3e905, float:-1.01212475E-13)
            int r4 = r4 + r5
            int r0 = r0 + r4
            int r4 = r0 << 5
            int r0 = r0 >>> 27
            r0 = r0 | r4
            int r0 = r0 + r1
            r4 = r0 & r2
            r5 = r2 ^ (-1)
            r5 = r5 & r1
            r4 = r4 | r5
            r5 = r15[r8]
            int r4 = r4 + r5
            r5 = -51403784(0xfffffffffcefa3f8, float:-9.954277E36)
            int r4 = r4 + r5
            int r3 = r3 + r4
            int r4 = r3 << 9
            int r3 = r3 >>> 23
            r3 = r3 | r4
            int r3 = r3 + r0
            r4 = r3 & r1
            r5 = r1 ^ (-1)
            r5 = r5 & r0
            r4 = r4 | r5
            r5 = 7
            r5 = r15[r5]
            int r4 = r4 + r5
            r5 = 1735328473(0x676f02d9, float:1.1286981E24)
            int r4 = r4 + r5
            int r2 = r2 + r4
            int r4 = r2 << 14
            int r2 = r2 >>> 18
            r2 = r2 | r4
            int r2 = r2 + r3
            r4 = r2 & r0
            r5 = r0 ^ (-1)
            r5 = r5 & r3
            r4 = r4 | r5
            r5 = 12
            r5 = r15[r5]
            int r4 = r4 + r5
            r5 = -1926607734(0xffffffff8d2a4c8a, float:-5.2477425E-31)
            int r4 = r4 + r5
            int r1 = r1 + r4
            int r4 = r1 << 20
            int r1 = r1 >>> 12
            r1 = r1 | r4
            int r1 = r1 + r2
            r4 = r1 ^ r2
            r4 = r4 ^ r3
            r5 = 5
            r5 = r15[r5]
            int r4 = r4 + r5
            r5 = -378558(0xfffffffffffa3942, float:NaN)
            int r4 = r4 + r5
            int r0 = r0 + r4
            int r4 = r0 << 4
            int r0 = r0 >>> 28
            r0 = r0 | r4
            int r0 = r0 + r1
            r4 = r0 ^ r1
            r4 = r4 ^ r2
            r5 = 8
            r5 = r15[r5]
            int r4 = r4 + r5
            r5 = -2022574463(0xffffffff8771f681, float:-1.8203266E-34)
            int r4 = r4 + r5
            int r3 = r3 + r4
            int r4 = r3 << 11
            int r3 = r3 >>> 21
            r3 = r3 | r4
            int r3 = r3 + r0
            r4 = r3 ^ r0
            r4 = r4 ^ r1
            r5 = 11
            r5 = r15[r5]
            int r4 = r4 + r5
            r5 = 1839030562(0x6d9d6122, float:6.0883216E27)
            int r4 = r4 + r5
            int r2 = r2 + r4
            int r4 = r2 << 16
            int r2 = r2 >>> 16
            r2 = r2 | r4
            int r2 = r2 + r3
            r4 = r2 ^ r3
            r4 = r4 ^ r0
            r5 = 14
            r5 = r15[r5]
            int r4 = r4 + r5
            r5 = -35309556(0xfffffffffde5380c, float:-3.8085528E37)
            int r4 = r4 + r5
            int r1 = r1 + r4
            int r4 = r1 << 23
            int r1 = r1 >>> 9
            r1 = r1 | r4
            int r1 = r1 + r2
            r4 = r1 ^ r2
            r4 = r4 ^ r3
            r5 = r15[r7]
            int r4 = r4 + r5
            r5 = -1530992060(0xffffffffa4beea44, float:-8.2796227E-17)
            int r4 = r4 + r5
            int r0 = r0 + r4
            int r4 = r0 << 4
            int r0 = r0 >>> 28
            r0 = r0 | r4
            int r0 = r0 + r1
            r4 = r0 ^ r1
            r4 = r4 ^ r2
            r5 = r15[r10]
            int r4 = r4 + r5
            r5 = 1272893353(0x4bdecfa9, float:2.9204306E7)
            int r4 = r4 + r5
            int r3 = r3 + r4
            int r4 = r3 << 11
            int r3 = r3 >>> 21
            r3 = r3 | r4
            int r3 = r3 + r0
            r4 = r3 ^ r0
            r4 = r4 ^ r1
            r5 = 7
            r5 = r15[r5]
            int r4 = r4 + r5
            r5 = -155497632(0xfffffffff6bb4b60, float:-1.8993912E33)
            int r4 = r4 + r5
            int r2 = r2 + r4
            int r4 = r2 << 16
            int r2 = r2 >>> 16
            r2 = r2 | r4
            int r2 = r2 + r3
            r4 = r2 ^ r3
            r4 = r4 ^ r0
            r5 = 10
            r5 = r15[r5]
            int r4 = r4 + r5
            r5 = -1094730640(0xffffffffbebfbc70, float:-0.37448454)
            int r4 = r4 + r5
            int r1 = r1 + r4
            int r4 = r1 << 23
            int r1 = r1 >>> 9
            r1 = r1 | r4
            int r1 = r1 + r2
            r4 = r1 ^ r2
            r4 = r4 ^ r3
            r5 = 13
            r5 = r15[r5]
            int r4 = r4 + r5
            r5 = 681279174(0x289b7ec6, float:1.7263436E-14)
            int r4 = r4 + r5
            int r0 = r0 + r4
            int r4 = r0 << 4
            int r0 = r0 >>> 28
            r0 = r0 | r4
            int r0 = r0 + r1
            r4 = r0 ^ r1
            r4 = r4 ^ r2
            r5 = r15[r6]
            int r4 = r4 + r5
            r5 = -358537222(0xffffffffeaa127fa, float:-9.741292E25)
            int r4 = r4 + r5
            int r3 = r3 + r4
            int r4 = r3 << 11
            int r3 = r3 >>> 21
            r3 = r3 | r4
            int r3 = r3 + r0
            r4 = r3 ^ r0
            r4 = r4 ^ r1
            r5 = r15[r9]
            int r4 = r4 + r5
            r5 = -722521979(0xffffffffd4ef3085, float:-8.2184897E12)
            int r4 = r4 + r5
            int r2 = r2 + r4
            int r4 = r2 << 16
            int r2 = r2 >>> 16
            r2 = r2 | r4
            int r2 = r2 + r3
            r4 = r2 ^ r3
            r4 = r4 ^ r0
            r5 = 6
            r5 = r15[r5]
            int r4 = r4 + r5
            r5 = 76029189(0x4881d05, float:3.2000097E-36)
            int r4 = r4 + r5
            int r1 = r1 + r4
            int r4 = r1 << 23
            int r1 = r1 >>> 9
            r1 = r1 | r4
            int r1 = r1 + r2
            r4 = r1 ^ r2
            r4 = r4 ^ r3
            r5 = 9
            r5 = r15[r5]
            int r4 = r4 + r5
            r5 = -640364487(0xffffffffd9d4d039, float:-7.487705E15)
            int r4 = r4 + r5
            int r0 = r0 + r4
            int r4 = r0 << 4
            int r0 = r0 >>> 28
            r0 = r0 | r4
            int r0 = r0 + r1
            r4 = r0 ^ r1
            r4 = r4 ^ r2
            r5 = 12
            r5 = r15[r5]
            int r4 = r4 + r5
            r5 = -421815835(0xffffffffe6db99e5, float:-5.1851856E23)
            int r4 = r4 + r5
            int r3 = r3 + r4
            int r4 = r3 << 11
            int r3 = r3 >>> 21
            r3 = r3 | r4
            int r3 = r3 + r0
            r4 = r3 ^ r0
            r4 = r4 ^ r1
            r5 = 15
            r5 = r15[r5]
            int r4 = r4 + r5
            r5 = 530742520(0x1fa27cf8, float:6.881641E-20)
            int r4 = r4 + r5
            int r2 = r2 + r4
            int r4 = r2 << 16
            int r2 = r2 >>> 16
            r2 = r2 | r4
            int r2 = r2 + r3
            r4 = r2 ^ r3
            r4 = r4 ^ r0
            r5 = r15[r8]
            int r4 = r4 + r5
            r5 = -995338651(0xffffffffc4ac5665, float:-1378.6998)
            int r4 = r4 + r5
            int r1 = r1 + r4
            int r4 = r1 << 23
            int r1 = r1 >>> 9
            r1 = r1 | r4
            int r1 = r1 + r2
            r4 = r3 ^ (-1)
            r4 = r4 | r1
            r4 = r4 ^ r2
            r5 = r15[r6]
            int r4 = r4 + r5
            r5 = -198630844(0xfffffffff4292244, float:-5.3600657E31)
            int r4 = r4 + r5
            int r0 = r0 + r4
            int r4 = r0 << 6
            int r0 = r0 >>> 26
            r0 = r0 | r4
            int r0 = r0 + r1
            r4 = r2 ^ (-1)
            r4 = r4 | r0
            r4 = r4 ^ r1
            r5 = 7
            r5 = r15[r5]
            int r4 = r4 + r5
            r5 = 1126891415(0x432aff97, float:170.9984)
            int r4 = r4 + r5
            int r3 = r3 + r4
            int r4 = r3 << 10
            int r3 = r3 >>> 22
            r3 = r3 | r4
            int r3 = r3 + r0
            r4 = r1 ^ (-1)
            r4 = r4 | r3
            r4 = r4 ^ r0
            r5 = 14
            r5 = r15[r5]
            int r4 = r4 + r5
            r5 = -1416354905(0xffffffffab9423a7, float:-1.0525928E-12)
            int r4 = r4 + r5
            int r2 = r2 + r4
            int r4 = r2 << 15
            int r2 = r2 >>> 17
            r2 = r2 | r4
            int r2 = r2 + r3
            r4 = r0 ^ (-1)
            r4 = r4 | r2
            r4 = r4 ^ r3
            r5 = 5
            r5 = r15[r5]
            int r4 = r4 + r5
            r5 = -57434055(0xfffffffffc93a039, float:-6.132139E36)
            int r4 = r4 + r5
            int r1 = r1 + r4
            int r4 = r1 << 21
            int r1 = r1 >>> 11
            r1 = r1 | r4
            int r1 = r1 + r2
            r4 = r3 ^ (-1)
            r4 = r4 | r1
            r4 = r4 ^ r2
            r5 = 12
            r5 = r15[r5]
            int r4 = r4 + r5
            r5 = 1700485571(0x655b59c3, float:6.474088E22)
            int r4 = r4 + r5
            int r0 = r0 + r4
            int r4 = r0 << 6
            int r0 = r0 >>> 26
            r0 = r0 | r4
            int r0 = r0 + r1
            r4 = r2 ^ (-1)
            r4 = r4 | r0
            r4 = r4 ^ r1
            r5 = r15[r9]
            int r4 = r4 + r5
            r5 = -1894986606(0xffffffff8f0ccc92, float:-6.941932E-30)
            int r4 = r4 + r5
            int r3 = r3 + r4
            int r4 = r3 << 10
            int r3 = r3 >>> 22
            r3 = r3 | r4
            int r3 = r3 + r0
            r4 = r1 ^ (-1)
            r4 = r4 | r3
            r4 = r4 ^ r0
            r5 = 10
            r5 = r15[r5]
            int r4 = r4 + r5
            r5 = -1051523(0xffffffffffeff47d, float:NaN)
            int r4 = r4 + r5
            int r2 = r2 + r4
            int r4 = r2 << 15
            int r2 = r2 >>> 17
            r2 = r2 | r4
            int r2 = r2 + r3
            r4 = r0 ^ (-1)
            r4 = r4 | r2
            r4 = r4 ^ r3
            r5 = r15[r7]
            int r4 = r4 + r5
            r5 = -2054922799(0xffffffff85845dd1, float:-1.2447683E-35)
            int r4 = r4 + r5
            int r1 = r1 + r4
            int r4 = r1 << 21
            int r1 = r1 >>> 11
            r1 = r1 | r4
            int r1 = r1 + r2
            r4 = r3 ^ (-1)
            r4 = r4 | r1
            r4 = r4 ^ r2
            r5 = 8
            r5 = r15[r5]
            int r4 = r4 + r5
            r5 = 1873313359(0x6fa87e4f, float:1.0429236E29)
            int r4 = r4 + r5
            int r0 = r0 + r4
            int r4 = r0 << 6
            int r0 = r0 >>> 26
            r0 = r0 | r4
            int r0 = r0 + r1
            r4 = r2 ^ (-1)
            r4 = r4 | r0
            r4 = r4 ^ r1
            r5 = 15
            r5 = r15[r5]
            int r4 = r4 + r5
            r5 = -30611744(0xfffffffffe2ce6e0, float:-5.7456497E37)
            int r4 = r4 + r5
            int r3 = r3 + r4
            int r4 = r3 << 10
            int r3 = r3 >>> 22
            r3 = r3 | r4
            int r3 = r3 + r0
            r4 = r1 ^ (-1)
            r4 = r4 | r3
            r4 = r4 ^ r0
            r5 = 6
            r5 = r15[r5]
            int r4 = r4 + r5
            r5 = -1560198380(0xffffffffa3014314, float:-7.007308E-18)
            int r4 = r4 + r5
            int r2 = r2 + r4
            int r4 = r2 << 15
            int r2 = r2 >>> 17
            r2 = r2 | r4
            int r2 = r2 + r3
            r4 = r0 ^ (-1)
            r4 = r4 | r2
            r4 = r4 ^ r3
            r5 = 13
            r5 = r15[r5]
            int r4 = r4 + r5
            r5 = 1309151649(0x4e0811a1, float:5.707142E8)
            int r4 = r4 + r5
            int r1 = r1 + r4
            int r4 = r1 << 21
            int r1 = r1 >>> 11
            r1 = r1 | r4
            int r1 = r1 + r2
            r4 = r3 ^ (-1)
            r4 = r4 | r1
            r4 = r4 ^ r2
            r5 = r15[r10]
            int r4 = r4 + r5
            r5 = -145523070(0xfffffffff7537e82, float:-4.2896114E33)
            int r4 = r4 + r5
            int r0 = r0 + r4
            int r4 = r0 << 6
            int r0 = r0 >>> 26
            r0 = r0 | r4
            int r0 = r0 + r1
            r4 = r2 ^ (-1)
            r4 = r4 | r0
            r4 = r4 ^ r1
            r5 = 11
            r5 = r15[r5]
            int r4 = r4 + r5
            r5 = -1120210379(0xffffffffbd3af235, float:-0.045641143)
            int r4 = r4 + r5
            int r3 = r3 + r4
            int r4 = r3 << 10
            int r3 = r3 >>> 22
            r3 = r3 | r4
            int r3 = r3 + r0
            r4 = r1 ^ (-1)
            r4 = r4 | r3
            r4 = r4 ^ r0
            r5 = r15[r8]
            int r4 = r4 + r5
            r5 = 718787259(0x2ad7d2bb, float:3.8337896E-13)
            int r4 = r4 + r5
            int r2 = r2 + r4
            int r4 = r2 << 15
            int r2 = r2 >>> 17
            r2 = r2 | r4
            int r2 = r2 + r3
            r4 = r0 ^ (-1)
            r4 = r4 | r2
            r4 = r4 ^ r3
            r5 = 9
            r5 = r15[r5]
            int r4 = r4 + r5
            r5 = -343485551(0xffffffffeb86d391, float:-3.259903E26)
            int r4 = r4 + r5
            int r1 = r1 + r4
            int r4 = r1 << 21
            int r1 = r1 >>> 11
            r1 = r1 | r4
            int r1 = r1 + r2
            int[] r4 = r12.f432a
            r5 = r4[r6]
            int r0 = r0 + r5
            r4[r6] = r0
            int[] r0 = r12.f432a
            r4 = r0[r7]
            int r1 = r1 + r4
            r0[r7] = r1
            int[] r0 = r12.f432a
            r1 = r0[r8]
            int r1 = r1 + r2
            r0[r8] = r1
            int[] r0 = r12.f432a
            r1 = r0[r9]
            int r1 = r1 + r3
            r0[r9] = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.android.systemmonitor.security.md5.MD5.a(com.baidu.android.systemmonitor.security.md5.a, byte[], int, int[]):void");
    }

    private void a(byte[] bArr, int i, int[] iArr) {
        iArr[0] = (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | (bArr[i + 3] << 24);
        iArr[1] = (bArr[i + 4] & 255) | ((bArr[i + 5] & 255) << 8) | ((bArr[i + 6] & 255) << 16) | (bArr[i + 7] << 24);
        iArr[2] = (bArr[i + 8] & 255) | ((bArr[i + 9] & 255) << 8) | ((bArr[i + 10] & 255) << 16) | (bArr[i + 11] << 24);
        iArr[3] = (bArr[i + 12] & 255) | ((bArr[i + 13] & 255) << 8) | ((bArr[i + 14] & 255) << 16) | (bArr[i + 15] << 24);
        iArr[4] = (bArr[i + 16] & 255) | ((bArr[i + 17] & 255) << 8) | ((bArr[i + 18] & 255) << 16) | (bArr[i + 19] << 24);
        iArr[5] = (bArr[i + 20] & 255) | ((bArr[i + 21] & 255) << 8) | ((bArr[i + 22] & 255) << 16) | (bArr[i + 23] << 24);
        iArr[6] = (bArr[i + 24] & 255) | ((bArr[i + 25] & 255) << 8) | ((bArr[i + 26] & 255) << 16) | (bArr[i + 27] << 24);
        iArr[7] = (bArr[i + 28] & 255) | ((bArr[i + 29] & 255) << 8) | ((bArr[i + 30] & 255) << 16) | (bArr[i + 31] << 24);
        iArr[8] = (bArr[i + 32] & 255) | ((bArr[i + 33] & 255) << 8) | ((bArr[i + 34] & 255) << 16) | (bArr[i + 35] << 24);
        iArr[9] = (bArr[i + 36] & 255) | ((bArr[i + 37] & 255) << 8) | ((bArr[i + 38] & 255) << 16) | (bArr[i + 39] << 24);
        iArr[10] = (bArr[i + 40] & 255) | ((bArr[i + 41] & 255) << 8) | ((bArr[i + 42] & 255) << 16) | (bArr[i + 43] << 24);
        iArr[11] = (bArr[i + 44] & 255) | ((bArr[i + 45] & 255) << 8) | ((bArr[i + 46] & 255) << 16) | (bArr[i + 47] << 24);
        iArr[12] = (bArr[i + 48] & 255) | ((bArr[i + 49] & 255) << 8) | ((bArr[i + 50] & 255) << 16) | (bArr[i + 51] << 24);
        iArr[13] = (bArr[i + 52] & 255) | ((bArr[i + 53] & 255) << 8) | ((bArr[i + 54] & 255) << 16) | (bArr[i + 55] << 24);
        iArr[14] = (bArr[i + 56] & 255) | ((bArr[i + 57] & 255) << 8) | ((bArr[i + 58] & 255) << 16) | (bArr[i + 59] << 24);
        iArr[15] = (bArr[i + 60] & 255) | ((bArr[i + 61] & 255) << 8) | ((bArr[i + 62] & 255) << 16) | (bArr[i + 63] << 24);
    }

    public static byte[] a(File file) {
        b bVar;
        if (!file.exists()) {
            throw new FileNotFoundException(file.toString());
        }
        try {
            long length = file.length();
            long j = length >= 512 ? length : 512L;
            byte[] bArr = new byte[(int) (j <= 65536 ? j : 65536L)];
            bVar = new b(new FileInputStream(file));
            do {
                try {
                } catch (IOException e2) {
                    e = e2;
                    if (bVar != null) {
                        try {
                            bVar.close();
                        } catch (Exception e3) {
                            throw e;
                        }
                    }
                    throw e;
                }
            } while (bVar.read(bArr) != -1);
            bVar.close();
            return bVar.a();
        } catch (IOException e4) {
            e = e4;
            bVar = null;
        }
    }

    private byte[] a(int[] iArr, int i) {
        byte[] bArr = new byte[i];
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3 += 4) {
            bArr[i3] = (byte) (iArr[i2] & 255);
            bArr[i3 + 1] = (byte) ((iArr[i2] >>> 8) & 255);
            bArr[i3 + 2] = (byte) ((iArr[i2] >>> 16) & 255);
            bArr[i3 + 3] = (byte) ((iArr[i2] >>> 24) & 255);
            i2++;
        }
        return bArr;
    }

    private static synchronized void c() {
        synchronized (MD5.class) {
            if (e) {
                d = d();
                e = false;
            }
        }
    }

    private static synchronized boolean d() {
        boolean z;
        synchronized (MD5.class) {
            try {
                System.loadLibrary("MoplusMD5");
                z = true;
            } catch (Exception e2) {
                z = false;
            }
        }
        return z;
    }

    public synchronized void a() {
        this.f431a = new a();
        this.b = null;
    }

    public void a(byte b) {
        a(new byte[]{b}, 1);
    }

    public void a(int i) {
        a((byte) (i & 255));
    }

    public void a(a aVar, byte[] bArr, int i, int i2) {
        int i3 = 0;
        this.b = null;
        if (i2 - i > bArr.length) {
            i2 = bArr.length - i;
        }
        int i4 = (int) (aVar.b & 63);
        aVar.b += i2;
        int i5 = 64 - i4;
        if (i2 >= i5) {
            if (d) {
                if (i5 == 64) {
                    i5 = 0;
                } else {
                    for (int i6 = 0; i6 < i5; i6++) {
                        aVar.c[i6 + i4] = bArr[i6 + i];
                    }
                    Transform_native(aVar.f432a, aVar.c, 0, 64);
                }
                int i7 = (((i2 - i5) / 64) * 64) + i5;
                int i8 = i2 - i5;
                int i9 = i5 + i;
                while (i8 > 65536) {
                    Transform_native(aVar.f432a, bArr, i9, 65536);
                    i8 -= 65536;
                    i9 += 65536;
                }
                Transform_native(aVar.f432a, bArr, i9, i8);
                i5 = i7;
            } else {
                int[] iArr = new int[16];
                if (i5 == 64) {
                    i5 = 0;
                } else {
                    for (int i10 = 0; i10 < i5; i10++) {
                        aVar.c[i10 + i4] = bArr[i10 + i];
                    }
                    a(aVar, aVar.c, 0, iArr);
                }
                while (i5 + 63 < i2) {
                    a(aVar, bArr, i5 + i, iArr);
                    i5 += 64;
                }
            }
            i4 = 0;
            i3 = i5;
        }
        if (i3 < i2) {
            for (int i11 = i3; i11 < i2; i11++) {
                aVar.c[(i4 + i11) - i3] = bArr[i11 + i];
            }
        }
    }

    public void a(byte[] bArr, int i) {
        a(this.f431a, bArr, 0, i);
    }

    public void a(byte[] bArr, int i, int i2) {
        a(this.f431a, bArr, i, i2);
    }

    public synchronized byte[] b() {
        if (this.b == null) {
            a aVar = new a(this.f431a);
            byte[] a2 = a(new int[]{(int) (aVar.b << 3), (int) (aVar.b >> 29)}, 8);
            int i = (int) (aVar.b & 63);
            a(aVar, c, 0, i < 56 ? 56 - i : 120 - i);
            a(aVar, a2, 0, 8);
            this.b = aVar;
        }
        return a(this.b.f432a, 16);
    }
}
