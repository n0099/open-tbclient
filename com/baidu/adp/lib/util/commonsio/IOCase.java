package com.baidu.adp.lib.util.commonsio;

import java.io.Serializable;
/* loaded from: classes.dex */
public final class IOCase implements Serializable {
    public static final IOCase SYSTEM;
    private static final long serialVersionUID = -6343169151696340687L;
    private final transient boolean nX;
    private final String name;
    public static final IOCase SENSITIVE = new IOCase("Sensitive", true);
    public static final IOCase INSENSITIVE = new IOCase("Insensitive", false);

    static {
        SYSTEM = new IOCase("System", b.fC() ? false : true);
    }

    public static IOCase forName(String str) {
        if (SENSITIVE.name.equals(str)) {
            return SENSITIVE;
        }
        if (INSENSITIVE.name.equals(str)) {
            return INSENSITIVE;
        }
        if (SYSTEM.name.equals(str)) {
            return SYSTEM;
        }
        throw new IllegalArgumentException("Invalid IOCase name: " + str);
    }

    private IOCase(String str, boolean z) {
        this.name = str;
        this.nX = z;
    }

    private Object readResolve() {
        return forName(this.name);
    }

    public String getName() {
        return this.name;
    }

    public boolean isCaseSensitive() {
        return this.nX;
    }

    public int checkCompareTo(String str, String str2) {
        if (str == null || str2 == null) {
            throw new NullPointerException("The strings must not be null");
        }
        return this.nX ? str.compareTo(str2) : str.compareToIgnoreCase(str2);
    }

    public boolean checkEquals(String str, String str2) {
        if (str == null || str2 == null) {
            throw new NullPointerException("The strings must not be null");
        }
        return this.nX ? str.equals(str2) : str.equalsIgnoreCase(str2);
    }

    public boolean checkStartsWith(String str, String str2) {
        return str.regionMatches(!this.nX, 0, str2, 0, str2.length());
    }

    public boolean checkEndsWith(String str, String str2) {
        int length = str2.length();
        return str.regionMatches(!this.nX, str.length() - length, str2, 0, length);
    }

    public int checkIndexOf(String str, int i, String str2) {
        int length = str.length() - str2.length();
        if (length >= i) {
            for (int i2 = i; i2 <= length; i2++) {
                if (checkRegionMatches(str, i2, str2)) {
                    return i2;
                }
            }
        }
        return -1;
    }

    public boolean checkRegionMatches(String str, int i, String str2) {
        return str.regionMatches(!this.nX, i, str2, 0, str2.length());
    }

    public String toString() {
        return this.name;
    }
}
