package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSON;
/* loaded from: classes.dex */
public class SymbolTable {
    public final int indexMask;
    public final String[] symbols;

    public SymbolTable(int i2) {
        this.indexMask = i2 - 1;
        this.symbols = new String[i2];
        addSymbol("$ref", 0, 4, 1185263);
        String str = JSON.DEFAULT_TYPE_KEY;
        addSymbol(str, 0, str.length(), JSON.DEFAULT_TYPE_KEY.hashCode());
    }

    public static int hash(char[] cArr, int i2, int i3) {
        int i4 = 0;
        int i5 = 0;
        while (i4 < i3) {
            i5 = (i5 * 31) + cArr[i2];
            i4++;
            i2++;
        }
        return i5;
    }

    public static String subString(String str, int i2, int i3) {
        char[] cArr = new char[i3];
        str.getChars(i2, i3 + i2, cArr, 0);
        return new String(cArr);
    }

    public String addSymbol(char[] cArr, int i2, int i3) {
        return addSymbol(cArr, i2, i3, hash(cArr, i2, i3));
    }

    public String addSymbol(char[] cArr, int i2, int i3, int i4) {
        int i5 = this.indexMask & i4;
        String str = this.symbols[i5];
        if (str != null) {
            boolean z = false;
            if (i4 == str.hashCode() && i3 == str.length()) {
                int i6 = 0;
                while (true) {
                    if (i6 >= i3) {
                        z = true;
                        break;
                    } else if (cArr[i2 + i6] != str.charAt(i6)) {
                        break;
                    } else {
                        i6++;
                    }
                }
            }
            return z ? str : new String(cArr, i2, i3);
        }
        String intern = new String(cArr, i2, i3).intern();
        this.symbols[i5] = intern;
        return intern;
    }

    public String addSymbol(String str, int i2, int i3, int i4) {
        return addSymbol(str, i2, i3, i4, false);
    }

    public String addSymbol(String str, int i2, int i3, int i4, boolean z) {
        int i5 = this.indexMask & i4;
        String str2 = this.symbols[i5];
        if (str2 != null) {
            if (i4 == str2.hashCode() && i3 == str2.length() && str.startsWith(str2, i2)) {
                return str2;
            }
            String subString = subString(str, i2, i3);
            if (z) {
                this.symbols[i5] = subString;
            }
            return subString;
        }
        if (i3 != str.length()) {
            str = subString(str, i2, i3);
        }
        String intern = str.intern();
        this.symbols[i5] = intern;
        return intern;
    }
}
