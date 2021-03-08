package com.baidu.android.util.io;

import java.text.DecimalFormat;
@Deprecated
/* loaded from: classes4.dex */
public class ByteUnitConverter {
    public static final int GB = 1073741824;
    public static final int KB = 1024;
    public static final int MB = 1048576;
    private static final int UNIT = 1024;
    private String convertStr;

    /* loaded from: classes4.dex */
    public enum UNITS {
        B,
        KB,
        MB,
        GB
    }

    private void convertByte(double d) {
        String str;
        float f;
        if (d < 1024.0d) {
            str = "B";
            f = (float) d;
        } else if (d < 1048576.0d) {
            str = "KB";
            f = ((float) d) / 1024.0f;
        } else if (d < 1.073741824E9d) {
            str = "MB";
            f = ((float) d) / 1048576.0f;
        } else {
            str = "GB";
            f = ((float) d) / 1.0737418E9f;
        }
        this.convertStr = new DecimalFormat("0.00").format(f) + str;
    }

    private void convertKiloByte(double d) {
        convertByte(1024.0d * d);
    }

    private void convertMegaByte(double d) {
        convertKiloByte(1024.0d * d);
    }

    private void convertGigaByte(double d) {
        convertMegaByte(1024.0d * d);
    }

    public ByteUnitConverter(double d) {
        this(d, UNITS.B);
    }

    public ByteUnitConverter(double d, UNITS units) {
        switch (units) {
            case B:
                convertByte(d);
                return;
            case KB:
                convertKiloByte(d);
                return;
            case MB:
                convertMegaByte(d);
                return;
            case GB:
                convertGigaByte(d);
                return;
            default:
                return;
        }
    }

    public String toString() {
        return this.convertStr;
    }
}
