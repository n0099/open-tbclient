package com.baidu.location;

import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aw implements a0 {
    public static String kX = null;
    private String k2;
    private String k8;
    private String k9;
    private List kU;
    private boolean k3 = false;
    private boolean la = false;
    private String kY = "";
    private int k4 = 0;
    private int k6 = 0;
    private char k1 = 'N';
    private boolean k5 = false;
    private int kT = 1;
    private double k0 = 0.0d;
    private double kW = 0.0d;
    private boolean kZ = false;
    private int k7 = 0;
    private final boolean kV = false;
    public int kS = 0;

    public aw(List list, String str, String str2, String str3) {
        this.k2 = "";
        this.k8 = "";
        this.k9 = "";
        this.kU = null;
        this.kU = list;
        this.k2 = str;
        this.k8 = str2;
        this.k9 = str3;
        c6();
    }

    private void c6() {
        if (u(this.k9)) {
            String substring = this.k9.substring(0, this.k9.length() - 3);
            int i = 0;
            for (int i2 = 0; i2 < substring.length(); i2++) {
                if (substring.charAt(i2) == ',') {
                    i++;
                }
            }
            String[] split = substring.split(",", i + 1);
            if (split.length < 6) {
                return;
            }
            if (!split[2].equals("") && !split[split.length - 3].equals("") && !split[split.length - 2].equals("") && !split[split.length - 1].equals("")) {
                this.kT = Integer.valueOf(split[2]).intValue();
                this.k0 = Double.valueOf(split[split.length - 3]).doubleValue();
                this.kW = Double.valueOf(split[split.length - 2]).doubleValue();
                this.k5 = true;
            }
        }
        this.k3 = this.k5;
    }

    private boolean u(String str) {
        if (str == null || str.length() <= 8) {
            return false;
        }
        int i = 0;
        for (int i2 = 1; i2 < str.length() - 3; i2++) {
            i ^= str.charAt(i2);
        }
        return Integer.toHexString(i).equalsIgnoreCase(str.substring(str.length() + (-2), str.length()));
    }

    public double c7() {
        return this.kW;
    }

    public String c8() {
        return this.kY;
    }

    public boolean c9() {
        return this.k3;
    }

    public double da() {
        return this.k0;
    }

    public int db() {
        return this.k4;
    }
}
