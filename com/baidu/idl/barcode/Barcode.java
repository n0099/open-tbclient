package com.baidu.idl.barcode;
/* loaded from: classes2.dex */
public final class Barcode {
    public static final int B_CODE128 = 16;
    public static final int B_CODE39 = 4;
    public static final int B_EAN = 1;
    public static final int B_EAN8 = 64;
    public static final int B_I25 = 8;
    public static final int B_PDF417 = 32;
    public static final int B_QRCODE = 2;
    public static final int B_UPCE = 128;
    public static final int CONF_BARCODE = 0;
    public static final int CONF_QRCODE = 2;

    static {
        System.loadLibrary("rabjni_V2_4_0");
    }

    public static native BarcodeResult decodeByte(byte[] bArr, int i2, int i3, int i4);

    public static native BarcodeResult[] readBarcode(byte[] bArr, int i2, int i3, int i4, int i5);
}
