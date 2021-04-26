package com.alipay.android.phone.mrpc.core;

import android.text.format.Time;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public final class k {

    /* renamed from: a  reason: collision with root package name */
    public static final Pattern f1627a = Pattern.compile("([0-9]{1,2})[- ]([A-Za-z]{3,9})[- ]([0-9]{2,4})[ ]([0-9]{1,2}:[0-9][0-9]:[0-9][0-9])");

    /* renamed from: b  reason: collision with root package name */
    public static final Pattern f1628b = Pattern.compile("[ ]([A-Za-z]{3,9})[ ]+([0-9]{1,2})[ ]([0-9]{1,2}:[0-9][0-9]:[0-9][0-9])[ ]([0-9]{2,4})");

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f1629a;

        /* renamed from: b  reason: collision with root package name */
        public int f1630b;

        /* renamed from: c  reason: collision with root package name */
        public int f1631c;

        public a(int i2, int i3, int i4) {
            this.f1629a = i2;
            this.f1630b = i3;
            this.f1631c = i4;
        }
    }

    public static long a(String str) {
        int c2;
        int d2;
        int i2;
        a aVar;
        int i3;
        int i4;
        int i5;
        Matcher matcher = f1627a.matcher(str);
        if (matcher.find()) {
            i2 = b(matcher.group(1));
            c2 = c(matcher.group(2));
            d2 = d(matcher.group(3));
            aVar = e(matcher.group(4));
        } else {
            Matcher matcher2 = f1628b.matcher(str);
            if (!matcher2.find()) {
                throw new IllegalArgumentException();
            }
            c2 = c(matcher2.group(1));
            int b2 = b(matcher2.group(2));
            a e2 = e(matcher2.group(3));
            d2 = d(matcher2.group(4));
            i2 = b2;
            aVar = e2;
        }
        if (d2 >= 2038) {
            i3 = 1;
            i4 = 0;
            i5 = 2038;
        } else {
            i3 = i2;
            i4 = c2;
            i5 = d2;
        }
        Time time = new Time("UTC");
        time.set(aVar.f1631c, aVar.f1630b, aVar.f1629a, i3, i4, i5);
        return time.toMillis(false);
    }

    public static int b(String str) {
        return str.length() == 2 ? ((str.charAt(0) - '0') * 10) + (str.charAt(1) - '0') : str.charAt(0) - '0';
    }

    public static int c(String str) {
        int lowerCase = ((Character.toLowerCase(str.charAt(0)) + Character.toLowerCase(str.charAt(1))) + Character.toLowerCase(str.charAt(2))) - 291;
        if (lowerCase != 9) {
            if (lowerCase != 10) {
                if (lowerCase != 22) {
                    if (lowerCase != 26) {
                        if (lowerCase != 29) {
                            if (lowerCase != 32) {
                                if (lowerCase != 40) {
                                    if (lowerCase != 42) {
                                        if (lowerCase != 48) {
                                            switch (lowerCase) {
                                                case 35:
                                                    return 9;
                                                case 36:
                                                    return 4;
                                                case 37:
                                                    return 8;
                                                default:
                                                    throw new IllegalArgumentException();
                                            }
                                        }
                                        return 10;
                                    }
                                    return 5;
                                }
                                return 6;
                            }
                            return 3;
                        }
                        return 2;
                    }
                    return 7;
                }
                return 0;
            }
            return 1;
        }
        return 11;
    }

    public static int d(String str) {
        if (str.length() == 2) {
            int charAt = ((str.charAt(0) - '0') * 10) + (str.charAt(1) - '0');
            return charAt >= 70 ? charAt + 1900 : charAt + 2000;
        } else if (str.length() == 3) {
            return ((str.charAt(0) - '0') * 100) + ((str.charAt(1) - '0') * 10) + (str.charAt(2) - '0') + 1900;
        } else {
            if (str.length() == 4) {
                return ((str.charAt(0) - '0') * 1000) + ((str.charAt(1) - '0') * 100) + ((str.charAt(2) - '0') * 10) + (str.charAt(3) - '0');
            }
            return 1970;
        }
    }

    public static a e(String str) {
        int i2;
        int i3;
        int i4;
        int charAt = str.charAt(0) - '0';
        if (str.charAt(1) != ':') {
            i2 = 2;
            charAt = (charAt * 10) + (str.charAt(1) - '0');
        } else {
            i2 = 1;
        }
        int i5 = i2 + 1 + 1 + 1 + 1;
        return new a(charAt, ((str.charAt(i3) - '0') * 10) + (str.charAt(i4) - '0'), ((str.charAt(i5) - '0') * 10) + (str.charAt(i5 + 1) - '0'));
    }
}
