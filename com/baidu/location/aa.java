package com.baidu.location;

import android.net.wifi.ScanResult;
import java.util.List;
/* loaded from: classes.dex */
public class aa {
    public List a;
    final /* synthetic */ w b;
    private long c;
    private long d;

    public aa(w wVar, List list, long j) {
        String str;
        this.b = wVar;
        this.a = null;
        this.c = 0L;
        this.d = 0L;
        this.c = j;
        this.a = list;
        this.d = System.currentTimeMillis();
        i();
        str = w.a;
        ap.b(str, a());
    }

    private void i() {
        boolean z;
        if (b() < 1) {
            return;
        }
        boolean z2 = true;
        for (int size = this.a.size() - 1; size >= 1 && z2; size--) {
            int i = 0;
            z2 = false;
            while (i < size) {
                if (((ScanResult) this.a.get(i)).level < ((ScanResult) this.a.get(i + 1)).level) {
                    this.a.set(i + 1, this.a.get(i));
                    this.a.set(i, (ScanResult) this.a.get(i + 1));
                    z = true;
                } else {
                    z = z2;
                }
                i++;
                z2 = z;
            }
        }
    }

    public String a() {
        StringBuilder sb = new StringBuilder();
        sb.append("wifi=");
        if (this.a == null) {
            return sb.toString();
        }
        for (int i = 0; i < this.a.size(); i++) {
            int i2 = ((ScanResult) this.a.get(i)).level;
            sb.append(((ScanResult) this.a.get(i)).BSSID.replace(":", ""));
            sb.append(String.format(",%d;", Integer.valueOf(i2)));
        }
        return sb.toString();
    }

    public String a(int i) {
        String str;
        int i2;
        boolean z;
        if (b() < 1) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer(512);
        String f = this.b.f();
        int size = this.a.size();
        if (size <= i) {
            i = size;
        }
        int i3 = 0;
        boolean z2 = true;
        int i4 = 0;
        int i5 = 0;
        while (i3 < i) {
            if (((ScanResult) this.a.get(i3)).level == 0) {
                z = z2;
                i2 = i5;
            } else if (z2) {
                stringBuffer.append("&wf=");
                String replace = ((ScanResult) this.a.get(i3)).BSSID.replace(":", "");
                stringBuffer.append(replace);
                int i6 = ((ScanResult) this.a.get(i3)).level;
                if (i6 < 0) {
                    i6 = -i6;
                }
                stringBuffer.append(String.format(";%d;", Integer.valueOf(i6)));
                i2 = i5 + 1;
                i4 = (f == null || !f.equals(replace)) ? i4 : i2;
                z = false;
            } else {
                stringBuffer.append("|");
                String replace2 = ((ScanResult) this.a.get(i3)).BSSID.replace(":", "");
                stringBuffer.append(replace2);
                int i7 = ((ScanResult) this.a.get(i3)).level;
                if (i7 < 0) {
                    i7 = -i7;
                }
                stringBuffer.append(String.format(";%d;", Integer.valueOf(i7)));
                int i8 = i5 + 1;
                if (f == null || !f.equals(replace2)) {
                    boolean z3 = z2;
                    i2 = i8;
                    z = z3;
                } else {
                    i4 = i8;
                    boolean z4 = z2;
                    i2 = i8;
                    z = z4;
                }
            }
            i3++;
            i5 = i2;
            z2 = z;
        }
        if (z2) {
            return null;
        }
        str = w.a;
        ap.a(str, f + i4);
        stringBuffer.append("&wf_n=" + i4);
        stringBuffer.append("&wf_st=");
        stringBuffer.append(this.c);
        stringBuffer.append("&wf_et=");
        stringBuffer.append(this.d);
        return stringBuffer.toString();
    }

    public boolean a(aa aaVar) {
        if (this.a == null || aaVar == null || aaVar.a == null) {
            return false;
        }
        int size = this.a.size() < aaVar.a.size() ? this.a.size() : aaVar.a.size();
        for (int i = 0; i < size; i++) {
            if (!((ScanResult) this.a.get(i)).BSSID.equals(((ScanResult) aaVar.a.get(i)).BSSID)) {
                return false;
            }
        }
        return true;
    }

    public boolean a(aa aaVar, aa aaVar2, float f) {
        String str;
        int i;
        if (aaVar == null || aaVar2 == null) {
            return false;
        }
        List list = aaVar.a;
        List list2 = aaVar2.a;
        if (list == list2) {
            return true;
        }
        if (list == null || list2 == null) {
            return false;
        }
        int size = list.size();
        int size2 = list2.size();
        float f2 = size + size2;
        if (size == 0 && size2 == 0) {
            return true;
        }
        if (size == 0 || size2 == 0) {
            return false;
        }
        int i2 = 0;
        int i3 = 0;
        while (i2 < size) {
            String str2 = ((ScanResult) list.get(i2)).BSSID;
            if (str2 != null) {
                int i4 = 0;
                while (true) {
                    if (i4 >= size2) {
                        i = i3;
                        break;
                    } else if (str2.equals(((ScanResult) list2.get(i4)).BSSID)) {
                        i = i3 + 1;
                        break;
                    } else {
                        i4++;
                    }
                }
            } else {
                i = i3;
            }
            i2++;
            i3 = i;
        }
        str = w.a;
        ap.a(str, String.format("same %d,total %f,rate %f...", Integer.valueOf(i3), Float.valueOf(f2), Float.valueOf(f)));
        return ((float) (i3 * 2)) >= f2 * f;
    }

    public int b() {
        if (this.a == null) {
            return 0;
        }
        return this.a.size();
    }

    public String b(int i) {
        int i2 = 0;
        if (i == 0 || b() < 1) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer(256);
        int i3 = 0;
        int i4 = 1;
        while (true) {
            int i5 = i2;
            if (i5 >= ap.J) {
                return stringBuffer.toString();
            }
            if ((i4 & i) != 0) {
                if (i3 == 0) {
                    stringBuffer.append("&ssid=");
                } else {
                    stringBuffer.append("|");
                }
                stringBuffer.append(((ScanResult) this.a.get(i5)).BSSID);
                stringBuffer.append(";");
                stringBuffer.append(((ScanResult) this.a.get(i5)).SSID);
                i3++;
            }
            i4 <<= 1;
            i2 = i5 + 1;
        }
    }

    public boolean b(aa aaVar) {
        if (this.a == null || aaVar == null || aaVar.a == null) {
            return false;
        }
        int size = this.a.size() < aaVar.a.size() ? this.a.size() : aaVar.a.size();
        for (int i = 0; i < size; i++) {
            String str = ((ScanResult) this.a.get(i)).BSSID;
            int i2 = ((ScanResult) this.a.get(i)).level;
            String str2 = ((ScanResult) aaVar.a.get(i)).BSSID;
            int i3 = ((ScanResult) aaVar.a.get(i)).level;
            if (!str.equals(str2) || i2 != i3) {
                return false;
            }
        }
        return true;
    }

    public String c() {
        try {
            return a(ap.J);
        } catch (Exception e) {
            return null;
        }
    }

    public boolean c(aa aaVar) {
        return a(aaVar, this, ap.M);
    }

    public String d() {
        try {
            return a(15);
        } catch (Exception e) {
            return null;
        }
    }

    public String e() {
        boolean z;
        StringBuffer stringBuffer = new StringBuffer(512);
        stringBuffer.append("wifi info:");
        if (b() < 1) {
            return stringBuffer.toString();
        }
        int size = this.a.size();
        if (size > 10) {
            size = 10;
        }
        int i = 0;
        boolean z2 = true;
        while (i < size) {
            if (((ScanResult) this.a.get(i)).level == 0) {
                z = z2;
            } else if (z2) {
                stringBuffer.append("wifi=");
                stringBuffer.append(((ScanResult) this.a.get(i)).BSSID.replace(":", ""));
                stringBuffer.append(String.format(";%d;", Integer.valueOf(((ScanResult) this.a.get(i)).level)));
                z = false;
            } else {
                stringBuffer.append(";");
                stringBuffer.append(((ScanResult) this.a.get(i)).BSSID.replace(":", ""));
                stringBuffer.append(String.format(",%d;", Integer.valueOf(((ScanResult) this.a.get(i)).level)));
                z = z2;
            }
            i++;
            z2 = z;
        }
        return stringBuffer.toString();
    }

    public boolean f() {
        return System.currentTimeMillis() - this.d < 3000;
    }

    public boolean g() {
        return System.currentTimeMillis() - this.d < 5000;
    }

    public boolean h() {
        return System.currentTimeMillis() - this.c < 3000;
    }
}
