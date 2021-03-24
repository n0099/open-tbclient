package com.baidu.mobads.h;

import android.os.Build;
import android.telephony.CellIdentityCdma;
import android.telephony.CellIdentityGsm;
import android.telephony.CellIdentityLte;
import android.telephony.CellIdentityWcdma;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoWcdma;
import android.telephony.CellLocation;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import com.baidu.mobads.MobadsPermissionSettings;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Locale;
import java.util.Random;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: c  reason: collision with root package name */
    public static Method f8312c;

    /* renamed from: d  reason: collision with root package name */
    public static Method f8313d;

    /* renamed from: e  reason: collision with root package name */
    public static Method f8314e;

    /* renamed from: f  reason: collision with root package name */
    public static Class<?> f8315f;

    /* renamed from: h  reason: collision with root package name */
    public static char[] f8316h = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_.".toCharArray();

    /* renamed from: a  reason: collision with root package name */
    public TelephonyManager f8317a;

    /* renamed from: b  reason: collision with root package name */
    public C0106a f8318b = new C0106a();

    /* renamed from: g  reason: collision with root package name */
    public String f8319g;

    /* renamed from: com.baidu.mobads.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0106a {

        /* renamed from: a  reason: collision with root package name */
        public int f8320a;

        /* renamed from: b  reason: collision with root package name */
        public int f8321b;

        /* renamed from: c  reason: collision with root package name */
        public int f8322c;

        /* renamed from: d  reason: collision with root package name */
        public int f8323d;

        /* renamed from: e  reason: collision with root package name */
        public char f8324e;

        public C0106a() {
            this.f8320a = -1;
            this.f8321b = -1;
            this.f8322c = -1;
            this.f8323d = -1;
            this.f8324e = (char) 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean b() {
            return this.f8320a > -1 && this.f8321b > 0;
        }

        public String a() {
            if (b()) {
                StringBuffer stringBuffer = new StringBuffer(128);
                stringBuffer.append(this.f8324e);
                stringBuffer.append("h");
                int i = this.f8322c;
                if (i != 460) {
                    stringBuffer.append(i);
                }
                stringBuffer.append(String.format(Locale.CHINA, "h%xh%xh%x", Integer.valueOf(this.f8323d), Integer.valueOf(this.f8320a), Integer.valueOf(this.f8321b)));
                return stringBuffer.toString();
            }
            return null;
        }
    }

    public a(String str) {
        this.f8317a = null;
        this.f8319g = null;
        this.f8319g = "&" + str + "&null";
        try {
            this.f8317a = (TelephonyManager) XAdSDKFoundationFacade.getInstance().getApplicationContext().getSystemService("phone");
        } catch (Exception unused) {
        }
    }

    private int b(int i) {
        if (i == Integer.MAX_VALUE) {
            return -1;
        }
        return i;
    }

    private C0106a b() {
        if (Integer.valueOf(Build.VERSION.SDK_INT).intValue() < 17) {
            return null;
        }
        try {
            List<CellInfo> allCellInfo = this.f8317a.getAllCellInfo();
            if (allCellInfo == null || allCellInfo.size() <= 0) {
                return null;
            }
            C0106a c0106a = null;
            for (CellInfo cellInfo : allCellInfo) {
                try {
                    if (cellInfo.isRegistered() && (c0106a = a(cellInfo)) != null) {
                        if (c0106a.b()) {
                            return c0106a;
                        }
                        return null;
                    }
                } catch (Exception unused) {
                }
            }
            return c0106a;
        } catch (Exception | NoSuchMethodError unused2) {
            return null;
        }
    }

    public String a() {
        if (MobadsPermissionSettings.hasPermissionGranted("permission_location")) {
            try {
                return a(10);
            } catch (Exception unused) {
                return null;
            }
        }
        return "";
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x002e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String a(int i) {
        String str;
        C0106a b2;
        try {
            b2 = b();
        } catch (Exception unused) {
            str = null;
        }
        if (b2 != null && b2.b()) {
            this.f8318b = b2;
            str = this.f8318b.a();
            if (str == null) {
                str = "Z";
            }
            if (str.equals("Z")) {
                return a(str + "t" + System.currentTimeMillis() + this.f8319g);
            }
            return null;
        }
        a(this.f8317a.getCellLocation());
        str = this.f8318b.a();
        if (str == null) {
        }
        if (str.equals("Z")) {
        }
    }

    private void a(CellLocation cellLocation) {
        if (cellLocation == null || this.f8317a == null) {
            return;
        }
        C0106a c0106a = new C0106a();
        String networkOperator = this.f8317a.getNetworkOperator();
        if (networkOperator != null && networkOperator.length() > 0) {
            try {
                if (networkOperator.length() >= 3) {
                    int intValue = Integer.valueOf(networkOperator.substring(0, 3)).intValue();
                    if (intValue < 0) {
                        intValue = this.f8318b.f8322c;
                    }
                    c0106a.f8322c = intValue;
                }
                String substring = networkOperator.substring(3);
                if (substring != null) {
                    char[] charArray = substring.toCharArray();
                    int i = 0;
                    while (i < charArray.length && Character.isDigit(charArray[i])) {
                        i++;
                    }
                    int intValue2 = Integer.valueOf(substring.substring(0, i)).intValue();
                    if (intValue2 < 0) {
                        intValue2 = this.f8318b.f8323d;
                    }
                    c0106a.f8323d = intValue2;
                }
            } catch (Exception unused) {
            }
        }
        if (cellLocation instanceof GsmCellLocation) {
            GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
            c0106a.f8320a = gsmCellLocation.getLac();
            c0106a.f8321b = gsmCellLocation.getCid();
            c0106a.f8324e = 'g';
        } else if (cellLocation instanceof CdmaCellLocation) {
            c0106a.f8324e = 'w';
            if (f8315f == null) {
                try {
                    Class<?> cls = Class.forName("android.telephony.cdma.CdmaCellLocation");
                    f8315f = cls;
                    f8312c = cls.getMethod("getBaseStationId", new Class[0]);
                    f8313d = f8315f.getMethod("getNetworkId", new Class[0]);
                    f8314e = f8315f.getMethod("getSystemId", new Class[0]);
                } catch (Exception unused2) {
                    f8315f = null;
                    return;
                }
            }
            Class<?> cls2 = f8315f;
            if (cls2 != null && cls2.isInstance(cellLocation)) {
                try {
                    int intValue3 = ((Integer) f8314e.invoke(cellLocation, new Object[0])).intValue();
                    if (intValue3 < 0) {
                        intValue3 = this.f8318b.f8323d;
                    }
                    c0106a.f8323d = intValue3;
                    c0106a.f8321b = ((Integer) f8312c.invoke(cellLocation, new Object[0])).intValue();
                    c0106a.f8320a = ((Integer) f8313d.invoke(cellLocation, new Object[0])).intValue();
                } catch (Exception unused3) {
                    return;
                }
            }
        }
        if (c0106a.b()) {
            this.f8318b = c0106a;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x00be A[Catch: Exception -> 0x00ee, TRY_LEAVE, TryCatch #0 {Exception -> 0x00ee, blocks: (B:18:0x00ba, B:20:0x00be), top: B:23:0x00ba }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private C0106a a(CellInfo cellInfo) {
        int intValue = Integer.valueOf(Build.VERSION.SDK_INT).intValue();
        if (intValue < 17) {
            return null;
        }
        C0106a c0106a = new C0106a();
        boolean z = false;
        if (cellInfo instanceof CellInfoGsm) {
            CellIdentityGsm cellIdentity = ((CellInfoGsm) cellInfo).getCellIdentity();
            c0106a.f8322c = b(cellIdentity.getMcc());
            c0106a.f8323d = b(cellIdentity.getMnc());
            c0106a.f8320a = b(cellIdentity.getLac());
            c0106a.f8321b = b(cellIdentity.getCid());
            c0106a.f8324e = 'g';
        } else if (cellInfo instanceof CellInfoCdma) {
            CellIdentityCdma cellIdentity2 = ((CellInfoCdma) cellInfo).getCellIdentity();
            c0106a.f8323d = b(cellIdentity2.getSystemId());
            c0106a.f8320a = b(cellIdentity2.getNetworkId());
            c0106a.f8321b = b(cellIdentity2.getBasestationId());
            c0106a.f8324e = 'w';
        } else {
            if (cellInfo instanceof CellInfoLte) {
                CellIdentityLte cellIdentity3 = ((CellInfoLte) cellInfo).getCellIdentity();
                c0106a.f8322c = b(cellIdentity3.getMcc());
                c0106a.f8323d = b(cellIdentity3.getMnc());
                c0106a.f8320a = b(cellIdentity3.getTac());
                c0106a.f8321b = b(cellIdentity3.getCi());
                c0106a.f8324e = 'g';
            }
            if (intValue >= 18 && !z) {
                try {
                    if (cellInfo instanceof CellInfoWcdma) {
                        CellIdentityWcdma cellIdentity4 = ((CellInfoWcdma) cellInfo).getCellIdentity();
                        c0106a.f8322c = b(cellIdentity4.getMcc());
                        c0106a.f8323d = b(cellIdentity4.getMnc());
                        c0106a.f8320a = b(cellIdentity4.getLac());
                        c0106a.f8321b = b(cellIdentity4.getCid());
                        c0106a.f8324e = 'g';
                    }
                } catch (Exception unused) {
                }
            }
            return c0106a;
        }
        z = true;
        if (intValue >= 18) {
            if (cellInfo instanceof CellInfoWcdma) {
            }
        }
        return c0106a;
    }

    public static String a(String str) {
        if (str == null) {
            return null;
        }
        byte[] bytes = str.getBytes();
        byte nextInt = (byte) new Random().nextInt(255);
        byte nextInt2 = (byte) new Random().nextInt(255);
        byte[] bArr = new byte[bytes.length + 2];
        int length = bytes.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            bArr[i2] = (byte) (bytes[i] ^ nextInt);
            i++;
            i2++;
        }
        bArr[i2] = nextInt;
        bArr[i2 + 1] = nextInt2;
        return a(bArr);
    }

    public static String a(byte[] bArr) {
        boolean z;
        char[] cArr = new char[((bArr.length + 2) / 3) * 4];
        int i = 0;
        int i2 = 0;
        while (i < bArr.length) {
            int i3 = (bArr[i] & 255) << 8;
            int i4 = i + 1;
            boolean z2 = true;
            if (i4 < bArr.length) {
                i3 |= bArr[i4] & 255;
                z = true;
            } else {
                z = false;
            }
            int i5 = i3 << 8;
            int i6 = i + 2;
            if (i6 < bArr.length) {
                i5 |= bArr[i6] & 255;
            } else {
                z2 = false;
            }
            int i7 = 64;
            cArr[i2 + 3] = f8316h[z2 ? 63 - (i5 & 63) : 64];
            int i8 = i5 >> 6;
            int i9 = i2 + 2;
            char[] cArr2 = f8316h;
            if (z) {
                i7 = 63 - (i8 & 63);
            }
            cArr[i9] = cArr2[i7];
            int i10 = i8 >> 6;
            char[] cArr3 = f8316h;
            cArr[i2 + 1] = cArr3[63 - (i10 & 63)];
            cArr[i2 + 0] = cArr3[63 - ((i10 >> 6) & 63)];
            i += 3;
            i2 += 4;
        }
        return new String(cArr);
    }
}
