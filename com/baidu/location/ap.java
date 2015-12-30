package com.baidu.location;

import android.net.wifi.ScanResult;
import android.os.Environment;
import android.text.TextUtils;
import com.baidu.location.au;
import com.baidu.location.u;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ap implements a0, n {
    private static ap h9 = null;
    private static String[] ia = null;
    private static final String ib = "loc_cache.dat";
    private static final String ic = ";";
    private static final String ie = ",";
    private static final int ig = 5;
    private static final double ih = 121.314d;
    private String[] id = null;

    /* loaded from: classes.dex */
    public class a {

        /* renamed from: do  reason: not valid java name */
        public int f54do;

        /* renamed from: for  reason: not valid java name */
        public boolean f55for;

        /* renamed from: if  reason: not valid java name */
        public double f56if;

        /* renamed from: int  reason: not valid java name */
        public double f57int;

        /* renamed from: new  reason: not valid java name */
        public long f58new;

        /* renamed from: try  reason: not valid java name */
        public double f59try;

        public a() {
        }
    }

    private long b0() {
        if (this.id == null || this.id.length < 3) {
            return 0L;
        }
        return Long.valueOf(this.id[3]).longValue();
    }

    private boolean b1() {
        u.a at = u.au().at();
        return !TextUtils.isEmpty(ia[1]) && ia[1].equals(String.format("%s|%s|%s|%s", Integer.valueOf(at.f107byte), Integer.valueOf(at.f108case), Integer.valueOf(at.a), Integer.valueOf(at.f111for)));
    }

    private void b3() {
        if (this.id != null || ia == null) {
            return;
        }
        String str = ia[0];
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.id = str.split(ie);
    }

    private double b4() {
        if (this.id == null || this.id.length <= 0) {
            return 0.0d;
        }
        return Double.valueOf(this.id[0]).doubleValue() - ih;
    }

    public static ap b5() {
        if (h9 == null) {
            h9 = new ap();
        }
        return h9;
    }

    private double bY() {
        if (this.id == null || this.id.length <= 2) {
            return 0.0d;
        }
        return Double.valueOf(this.id[2]).doubleValue();
    }

    private double bZ() {
        if (this.id == null || this.id.length <= 1) {
            return 0.0d;
        }
        return Double.valueOf(this.id[1]).doubleValue() - ih;
    }

    public a b2() {
        byte[] bArr = null;
        if ("mounted".equals(Environment.getExternalStorageState())) {
            File file = new File(I + File.separator + ib);
            if (file.exists()) {
                try {
                    FileInputStream fileInputStream = new FileInputStream(file);
                    byte[] bArr2 = new byte[128];
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    while (true) {
                        int read = fileInputStream.read(bArr2);
                        if (read == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr2, 0, read);
                    }
                    bArr = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.close();
                    fileInputStream.close();
                } catch (Exception e) {
                }
            }
        }
        ia = new String(bArr).split(";");
        b3();
        a aVar = new a();
        aVar.f57int = b4();
        aVar.f59try = bZ();
        aVar.f56if = bY();
        aVar.f55for = b1();
        aVar.f54do = b6();
        aVar.f58new = b0();
        return aVar;
    }

    public int b6() {
        List list;
        int i;
        String[] split = ia[2] != null ? ia[2].split(ie) : null;
        au.b b7 = au.cc().b7();
        if (b7 == null || (list = b7.f74for) == null) {
            return 0;
        }
        int i2 = 0;
        int i3 = 0;
        while (i2 < 5) {
            ScanResult scanResult = (ScanResult) list.get(i2);
            if (scanResult != null) {
                String replace = scanResult.BSSID.replace(":", "");
                for (String str : split) {
                    if (replace.equals(str)) {
                        i = i3 + 1;
                        break;
                    }
                }
            }
            i = i3;
            i2++;
            i3 = i;
        }
        return i3;
    }

    /* renamed from: new  reason: not valid java name */
    public void m186new(BDLocation bDLocation) {
        List list;
        if (bDLocation.getLocType() != 161) {
            return;
        }
        String format = String.format("%s,%s,%s,%d", Double.valueOf(bDLocation.getLongitude() + ih), Double.valueOf(bDLocation.getLatitude() + ih), Float.valueOf(bDLocation.getRadius()), Long.valueOf(System.currentTimeMillis()));
        u.a at = u.au().at();
        String format2 = at.a() ? String.format("%s|%s|%s|%s", Integer.valueOf(at.f107byte), Integer.valueOf(at.f108case), Integer.valueOf(at.a), Integer.valueOf(at.f111for)) : null;
        String str = null;
        au.b b7 = au.cc().b7();
        if (b7 != null && (list = b7.f74for) != null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < 5; i++) {
                ScanResult scanResult = (ScanResult) list.get(i);
                if (scanResult != null) {
                    arrayList.add(scanResult.BSSID.replace(":", ""));
                }
            }
            str = TextUtils.join(ie, arrayList);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(format).append(";").append(format2).append(";").append(str);
        String sb2 = sb.toString();
        if ("mounted".equals(Environment.getExternalStorageState())) {
            File file = new File(I + File.separator + ib);
            File parentFile = file.getParentFile();
            if (!parentFile.exists()) {
                parentFile.mkdirs();
            }
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                fileOutputStream.write(sb2.getBytes());
                fileOutputStream.close();
            } catch (Exception e) {
            }
        }
    }
}
