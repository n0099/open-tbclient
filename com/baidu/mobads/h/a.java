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
import com.baidu.webkit.internal.ETAG;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Locale;
import java.util.Random;
/* loaded from: classes4.dex */
public class a {
    private static Method c = null;
    private static Method d = null;
    private static Method e = null;
    private static Class<?> f = null;
    private static char[] h = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_.".toCharArray();

    /* renamed from: a  reason: collision with root package name */
    private TelephonyManager f2402a;
    private C0270a b = new C0270a();
    private String g;

    public a(String str) {
        this.f2402a = null;
        this.g = null;
        this.g = ETAG.ITEM_SEPARATOR + str + "&null";
        try {
            this.f2402a = (TelephonyManager) XAdSDKFoundationFacade.getInstance().getApplicationContext().getSystemService("phone");
        } catch (Exception e2) {
        }
    }

    public String a() {
        if (!MobadsPermissionSettings.hasPermissionGranted("permission_location")) {
            return "";
        }
        try {
            return a(10);
        } catch (Exception e2) {
            return null;
        }
    }

    private String a(int i) {
        String str;
        if (i < 3) {
        }
        try {
            C0270a b = b();
            if (b == null || !b.b()) {
                a(this.f2402a.getCellLocation());
            } else {
                this.b = b;
            }
            str = this.b.a();
        } catch (Exception e2) {
            str = null;
        }
        if (str == null) {
            str = "Z";
        }
        if (str.equals("Z")) {
            return null;
        }
        return a(str + "t" + System.currentTimeMillis() + this.g);
    }

    private void a(CellLocation cellLocation) {
        int i = 0;
        if (cellLocation != null && this.f2402a != null) {
            C0270a c0270a = new C0270a();
            String networkOperator = this.f2402a.getNetworkOperator();
            if (networkOperator != null && networkOperator.length() > 0) {
                try {
                    if (networkOperator.length() >= 3) {
                        int intValue = Integer.valueOf(networkOperator.substring(0, 3)).intValue();
                        if (intValue < 0) {
                            intValue = this.b.c;
                        }
                        c0270a.c = intValue;
                    }
                    String substring = networkOperator.substring(3);
                    if (substring != null) {
                        char[] charArray = substring.toCharArray();
                        while (i < charArray.length && Character.isDigit(charArray[i])) {
                            i++;
                        }
                        int intValue2 = Integer.valueOf(substring.substring(0, i)).intValue();
                        if (intValue2 < 0) {
                            intValue2 = this.b.d;
                        }
                        c0270a.d = intValue2;
                    }
                } catch (Exception e2) {
                }
            }
            if (cellLocation instanceof GsmCellLocation) {
                c0270a.f2403a = ((GsmCellLocation) cellLocation).getLac();
                c0270a.b = ((GsmCellLocation) cellLocation).getCid();
                c0270a.e = 'g';
            } else if (cellLocation instanceof CdmaCellLocation) {
                c0270a.e = 'w';
                if (f == null) {
                    try {
                        f = Class.forName("android.telephony.cdma.CdmaCellLocation");
                        c = f.getMethod("getBaseStationId", new Class[0]);
                        d = f.getMethod("getNetworkId", new Class[0]);
                        e = f.getMethod("getSystemId", new Class[0]);
                    } catch (Exception e3) {
                        f = null;
                        return;
                    }
                }
                if (f != null && f.isInstance(cellLocation)) {
                    try {
                        int intValue3 = ((Integer) e.invoke(cellLocation, new Object[0])).intValue();
                        if (intValue3 < 0) {
                            intValue3 = this.b.d;
                        }
                        c0270a.d = intValue3;
                        c0270a.b = ((Integer) c.invoke(cellLocation, new Object[0])).intValue();
                        c0270a.f2403a = ((Integer) d.invoke(cellLocation, new Object[0])).intValue();
                    } catch (Exception e4) {
                        return;
                    }
                }
            }
            if (c0270a.b()) {
                this.b = c0270a;
            }
        }
    }

    private C0270a b() {
        if (Integer.valueOf(Build.VERSION.SDK_INT).intValue() < 17) {
            return null;
        }
        try {
            try {
                List<CellInfo> allCellInfo = this.f2402a.getAllCellInfo();
                if (allCellInfo == null || allCellInfo.size() <= 0) {
                    return null;
                }
                C0270a c0270a = null;
                for (CellInfo cellInfo : allCellInfo) {
                    try {
                        if (cellInfo.isRegistered()) {
                            C0270a a2 = a(cellInfo);
                            if (a2 != null) {
                                try {
                                    if (!a2.b()) {
                                        a2 = null;
                                    }
                                    return a2;
                                } catch (Exception e2) {
                                    return a2;
                                }
                            }
                            c0270a = a2;
                        }
                    } catch (Exception e3) {
                        return c0270a;
                    }
                }
                return c0270a;
            } catch (NoSuchMethodError e4) {
                return null;
            }
        } catch (Exception e5) {
            return null;
        }
    }

    private C0270a a(CellInfo cellInfo) {
        int intValue = Integer.valueOf(Build.VERSION.SDK_INT).intValue();
        if (intValue < 17) {
            return null;
        }
        C0270a c0270a = new C0270a();
        boolean z = false;
        if (cellInfo instanceof CellInfoGsm) {
            CellIdentityGsm cellIdentity = ((CellInfoGsm) cellInfo).getCellIdentity();
            c0270a.c = b(cellIdentity.getMcc());
            c0270a.d = b(cellIdentity.getMnc());
            c0270a.f2403a = b(cellIdentity.getLac());
            c0270a.b = b(cellIdentity.getCid());
            c0270a.e = 'g';
            z = true;
        } else if (cellInfo instanceof CellInfoCdma) {
            CellIdentityCdma cellIdentity2 = ((CellInfoCdma) cellInfo).getCellIdentity();
            c0270a.d = b(cellIdentity2.getSystemId());
            c0270a.f2403a = b(cellIdentity2.getNetworkId());
            c0270a.b = b(cellIdentity2.getBasestationId());
            c0270a.e = 'w';
            z = true;
        } else if (cellInfo instanceof CellInfoLte) {
            CellIdentityLte cellIdentity3 = ((CellInfoLte) cellInfo).getCellIdentity();
            c0270a.c = b(cellIdentity3.getMcc());
            c0270a.d = b(cellIdentity3.getMnc());
            c0270a.f2403a = b(cellIdentity3.getTac());
            c0270a.b = b(cellIdentity3.getCi());
            c0270a.e = 'g';
            z = true;
        }
        if (intValue >= 18 && !z) {
            try {
                if (cellInfo instanceof CellInfoWcdma) {
                    CellIdentityWcdma cellIdentity4 = ((CellInfoWcdma) cellInfo).getCellIdentity();
                    c0270a.c = b(cellIdentity4.getMcc());
                    c0270a.d = b(cellIdentity4.getMnc());
                    c0270a.f2403a = b(cellIdentity4.getLac());
                    c0270a.b = b(cellIdentity4.getCid());
                    c0270a.e = 'g';
                }
            } catch (Exception e2) {
            }
        }
        return c0270a;
    }

    private int b(int i) {
        if (i == Integer.MAX_VALUE) {
            return -1;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.mobads.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0270a {

        /* renamed from: a  reason: collision with root package name */
        public int f2403a;
        public int b;
        public int c;
        public int d;
        public char e;

        private C0270a() {
            this.f2403a = -1;
            this.b = -1;
            this.c = -1;
            this.d = -1;
            this.e = (char) 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean b() {
            return this.f2403a > -1 && this.b > 0;
        }

        public String a() {
            if (!b()) {
                return null;
            }
            StringBuffer stringBuffer = new StringBuffer(128);
            stringBuffer.append(this.e);
            stringBuffer.append("h");
            if (this.c != 460) {
                stringBuffer.append(this.c);
            }
            stringBuffer.append(String.format(Locale.CHINA, "h%xh%xh%x", Integer.valueOf(this.d), Integer.valueOf(this.f2403a), Integer.valueOf(this.b)));
            return stringBuffer.toString();
        }
    }

    private static String a(String str) {
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
        int i3 = i2 + 1;
        bArr[i2] = nextInt;
        int i4 = i3 + 1;
        bArr[i3] = nextInt2;
        return a(bArr);
    }

    private static String a(byte[] bArr) {
        boolean z;
        boolean z2;
        char[] cArr = new char[((bArr.length + 2) / 3) * 4];
        int i = 0;
        int i2 = 0;
        while (i2 < bArr.length) {
            int i3 = (bArr[i2] & 255) << 8;
            if (i2 + 1 < bArr.length) {
                i3 |= bArr[i2 + 1] & 255;
                z = true;
            } else {
                z = false;
            }
            int i4 = i3 << 8;
            if (i2 + 2 < bArr.length) {
                i4 |= bArr[i2 + 2] & 255;
                z2 = true;
            } else {
                z2 = false;
            }
            cArr[i + 3] = h[z2 ? 63 - (i4 & 63) : 64];
            int i5 = i4 >> 6;
            cArr[i + 2] = h[z ? 63 - (i5 & 63) : 64];
            int i6 = i5 >> 6;
            cArr[i + 1] = h[63 - (i6 & 63)];
            cArr[i + 0] = h[63 - ((i6 >> 6) & 63)];
            i2 += 3;
            i += 4;
        }
        return new String(cArr);
    }
}
