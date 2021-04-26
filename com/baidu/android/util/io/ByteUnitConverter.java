package com.baidu.android.util.io;

import java.text.DecimalFormat;
@Deprecated
/* loaded from: classes.dex */
public class ByteUnitConverter {
    public static final int GB = 1073741824;
    public static final int KB = 1024;
    public static final int MB = 1048576;
    public static final int UNIT = 1024;
    public String convertStr;

    /* renamed from: com.baidu.android.util.io.ByteUnitConverter$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$baidu$android$util$io$ByteUnitConverter$UNITS;

        static {
            int[] iArr = new int[UNITS.values().length];
            $SwitchMap$com$baidu$android$util$io$ByteUnitConverter$UNITS = iArr;
            try {
                iArr[UNITS.B.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$baidu$android$util$io$ByteUnitConverter$UNITS[UNITS.KB.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$baidu$android$util$io$ByteUnitConverter$UNITS[UNITS.MB.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$baidu$android$util$io$ByteUnitConverter$UNITS[UNITS.GB.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: classes.dex */
    public enum UNITS {
        B,
        KB,
        MB,
        GB
    }

    public ByteUnitConverter(double d2) {
        this(d2, UNITS.B);
    }

    private void convertByte(double d2) {
        float f2;
        String str;
        if (d2 < 1024.0d) {
            f2 = (float) d2;
            str = "B";
        } else if (d2 < 1048576.0d) {
            f2 = ((float) d2) / 1024.0f;
            str = "KB";
        } else if (d2 < 1.073741824E9d) {
            f2 = ((float) d2) / 1048576.0f;
            str = "MB";
        } else {
            f2 = ((float) d2) / 1.0737418E9f;
            str = "GB";
        }
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        this.convertStr = decimalFormat.format(f2) + str;
    }

    private void convertGigaByte(double d2) {
        convertMegaByte(d2 * 1024.0d);
    }

    private void convertKiloByte(double d2) {
        convertByte(d2 * 1024.0d);
    }

    private void convertMegaByte(double d2) {
        convertKiloByte(d2 * 1024.0d);
    }

    public String toString() {
        return this.convertStr;
    }

    public ByteUnitConverter(double d2, UNITS units) {
        int i2 = AnonymousClass1.$SwitchMap$com$baidu$android$util$io$ByteUnitConverter$UNITS[units.ordinal()];
        if (i2 == 1) {
            convertByte(d2);
        } else if (i2 == 2) {
            convertKiloByte(d2);
        } else if (i2 == 3) {
            convertMegaByte(d2);
        } else if (i2 != 4) {
        } else {
            convertGigaByte(d2);
        }
    }
}
