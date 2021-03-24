package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSON;
/* loaded from: classes.dex */
public class SymbolTable {
    public final int indexMask;
    public final String[] symbols;

    public SymbolTable(int i) {
        this.indexMask = i - 1;
        this.symbols = new String[i];
        addSymbol("$ref", 0, 4, 1185263);
        String str = JSON.DEFAULT_TYPE_KEY;
        addSymbol(str, 0, str.length(), JSON.DEFAULT_TYPE_KEY.hashCode());
    }

    public static int hash(char[] cArr, int i, int i2) {
        int i3 = 0;
        int i4 = 0;
        while (i3 < i2) {
            i4 = (i4 * 31) + cArr[i];
            i3++;
            i++;
        }
        return i4;
    }

    public static String subString(String str, int i, int i2) {
        char[] cArr = new char[i2];
        str.getChars(i, i2 + i, cArr, 0);
        return new String(cArr);
    }

    public String addSymbol(char[] cArr, int i, int i2) {
        return addSymbol(cArr, i, i2, hash(cArr, i, i2));
    }

    public String addSymbol(char[] cArr, int i, int i2, int i3) {
        int i4 = this.indexMask & i3;
        String str = this.symbols[i4];
        if (str != null) {
            boolean z = false;
            if (i3 == str.hashCode() && i2 == str.length()) {
                int i5 = 0;
                while (true) {
                    if (i5 >= i2) {
                        z = true;
                        break;
                    } else if (cArr[i + i5] != str.charAt(i5)) {
                        break;
                    } else {
                        i5++;
                    }
                }
            }
            return z ? str : new String(cArr, i, i2);
        }
        String intern = new String(cArr, i, i2).intern();
        this.symbols[i4] = intern;
        return intern;
    }

    public String addSymbol(String str, int i, int i2, int i3) {
        return addSymbol(str, i, i2, i3, false);
    }

    public String addSymbol(String str, int i, int i2, int i3, boolean z) {
        int i4 = this.indexMask & i3;
        String str2 = this.symbols[i4];
        if (str2 != null) {
            if (i3 == str2.hashCode() && i2 == str2.length() && str.startsWith(str2, i)) {
                return str2;
            }
            String subString = subString(str, i, i2);
            if (z) {
                this.symbols[i4] = subString;
            }
            return subString;
        }
        if (i2 != str.length()) {
            str = subString(str, i, i2);
        }
        String intern = str.intern();
        this.symbols[i4] = intern;
        return intern;
    }
}
