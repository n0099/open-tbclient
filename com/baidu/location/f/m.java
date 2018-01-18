package com.baidu.location.f;

import com.xiaomi.mipush.sdk.Constants;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m {
    public static String a = null;
    private String d;
    private boolean c = false;
    private boolean e = false;
    private double aAm = 0.0d;
    private double aBA = 0.0d;
    public int b = 0;

    public m(List<String> list, String str, String str2, String str3) {
        this.d = "";
        this.d = str3;
        d();
    }

    private boolean a(String str) {
        if (str == null || str.length() <= 8) {
            return false;
        }
        int i = 0;
        for (int i2 = 1; i2 < str.length() - 3; i2++) {
            i ^= str.charAt(i2);
        }
        return Integer.toHexString(i).equalsIgnoreCase(str.substring(str.length() + (-2), str.length()));
    }

    private void d() {
        if (a(this.d)) {
            String substring = this.d.substring(0, this.d.length() - 3);
            int i = 0;
            for (int i2 = 0; i2 < substring.length(); i2++) {
                if (substring.charAt(i2) == ',') {
                    i++;
                }
            }
            String[] split = substring.split(Constants.ACCEPT_TIME_SEPARATOR_SP, i + 1);
            if (split.length < 6) {
                return;
            }
            if (!split[2].equals("") && !split[split.length - 3].equals("") && !split[split.length - 2].equals("") && !split[split.length - 1].equals("")) {
                try {
                    this.aAm = Double.valueOf(split[split.length - 3]).doubleValue();
                    this.aBA = Double.valueOf(split[split.length - 2]).doubleValue();
                } catch (Exception e) {
                }
                this.e = true;
            }
        }
        this.c = this.e;
    }

    public boolean a() {
        return this.c;
    }

    public double b() {
        return this.aAm;
    }

    public double c() {
        return this.aBA;
    }
}
