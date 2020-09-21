package com.baidu.location.b;

import android.annotation.TargetApi;
import android.location.GnssNavigationMessage;
import android.support.media.ExifInterface;
import com.alibaba.fastjson.asm.Opcodes;
import com.baidu.android.imsdk.internal.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class q {
    private static final double[] a = {1999.0d, 8.0d, 22.0d, 0.0d, 0.0d, 0.0d};
    private HashMap<String, c> b = new HashMap<>();
    private HashMap<String, String> c = new HashMap<>();

    /* loaded from: classes3.dex */
    private static class a {
        private static q a = new q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b {
        int a = 0;
        double b = 0.0d;

        public b() {
        }
    }

    /* loaded from: classes3.dex */
    private class c {
        private boolean b;
        private boolean c;
        private long d;
        private int e;
        private int f;
        private ArrayList<String> g;
        private int h;
        private double i;
        private double j;
        private double k;
        private int l;
        private b m;

        public c(int i, int i2) {
            a(i, i2);
            this.h = 0;
            this.i = 0.0d;
            this.j = 0.0d;
            this.k = 0.0d;
            this.l = 0;
            this.m = new b();
        }

        private b a(int i, double d) {
            b a = a(q.a);
            d = (d < -1.0E9d || 1.0E9d < d) ? 0.0d : 0.0d;
            a.a += (604800 * i) + ((int) d);
            a.b = d - ((int) d);
            return a;
        }

        private b a(double[] dArr) {
            int i = 1;
            int[] iArr = {1, 32, 60, 91, Constants.METHOD_IM_FRIEND_GROUP_DROP, 152, Opcodes.INVOKEVIRTUAL, 213, 244, 274, 305, 335};
            b bVar = new b();
            int i2 = (int) dArr[0];
            int i3 = (int) dArr[1];
            int i4 = (int) dArr[2];
            if (i2 < 1970 || 2099 < i2 || i3 < 1 || 12 < i3) {
                return bVar;
            }
            int i5 = ((iArr[i3 - 1] + (((i2 - 1970) * 365) + ((i2 - 1969) / 4))) + i4) - 2;
            if (i2 % 4 != 0 || i3 < 3) {
                i = 0;
            }
            int floor = (int) Math.floor(dArr[5]);
            bVar.a = ((i + i5) * 86400) + (((int) dArr[3]) * 3600) + (((int) dArr[4]) * 60) + floor;
            bVar.b = dArr[5] - floor;
            return bVar;
        }

        @TargetApi(24)
        private String a(GnssNavigationMessage gnssNavigationMessage) {
            StringBuilder sb = new StringBuilder();
            byte[] data = gnssNavigationMessage.getData();
            int length = data.length;
            for (int i = 0; i < length; i++) {
                sb.append(String.format("%8s", Integer.toBinaryString(data[i] & 255)).replace(' ', '0'));
            }
            return sb.toString();
        }

        private void a() {
            boolean z;
            if (this.g.size() != 0) {
                int i = 0;
                while (true) {
                    if (i >= this.g.size()) {
                        z = true;
                        break;
                    } else if (this.g.get(i).contains("None")) {
                        z = false;
                        break;
                    } else {
                        i++;
                    }
                }
            } else {
                z = false;
            }
            if (z) {
                this.c = true;
            } else {
                this.c = false;
            }
        }

        private void a(int i, int i2) {
            int i3 = 5;
            switch (this.f) {
                case 257:
                case 769:
                case 1282:
                    break;
                case 1281:
                    i3 = 3;
                    break;
                case 1537:
                    i3 = 6;
                    break;
                default:
                    i3 = 0;
                    break;
            }
            if (this.g != null) {
                this.g.clear();
            } else {
                this.g = new ArrayList<>();
            }
            for (int i4 = 0; i4 < i3; i4++) {
                this.g.add("None");
            }
            this.e = i;
            this.f = i2;
            this.b = false;
            this.c = false;
            this.d = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @TargetApi(24)
        public void a(GnssNavigationMessage gnssNavigationMessage, long j) {
            int type = gnssNavigationMessage.getType();
            int svid = gnssNavigationMessage.getSvid();
            int submessageId = gnssNavigationMessage.getSubmessageId();
            byte[] data = gnssNavigationMessage.getData();
            if (j - this.d > 1200 || this.b || this.g.size() == 0 || type != this.f || svid != this.e) {
                a(svid, type);
            }
            if (this.g.size() == 0) {
                return;
            }
            int i = submessageId - (this.f == 1537 ? 0 : 1);
            if (i < this.g.size()) {
                StringBuilder sb = new StringBuilder();
                boolean z = true;
                for (byte b : data) {
                    if (z) {
                        z = false;
                    } else {
                        sb.append(',');
                    }
                    sb.append((int) b);
                }
                this.g.set(i, sb.toString());
                if (this.f == 1537) {
                    a(a(gnssNavigationMessage));
                }
                a();
                this.d = j;
            }
        }

        private void a(String str) {
            String str2;
            char charAt = str.charAt(0);
            char charAt2 = str.charAt(120);
            if (charAt == '1' && charAt2 == '0') {
                str2 = str.substring(2, 18) + str.substring(122, 234);
            } else if (charAt != '0' || charAt2 != '1') {
                return;
            } else {
                str2 = str.substring(2, 114) + str.substring(122, 138);
            }
            int parseInt = Integer.parseInt(str2.substring(0, 6), 2);
            if (parseInt == 0) {
                b(str2);
            } else if (parseInt == 1) {
                c(str2);
            } else if (parseInt == 4) {
                d(str2);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String b() {
            boolean z;
            StringBuilder sb = new StringBuilder();
            if (this.c) {
                if (this.f == 1537) {
                    c();
                }
                sb.append(this.m.a);
                sb.append('|');
                int i = 0;
                boolean z2 = true;
                while (i < this.g.size()) {
                    if (z2) {
                        z = false;
                    } else {
                        sb.append(',');
                        z = z2;
                    }
                    sb.append(this.g.get(i));
                    i++;
                    z2 = z;
                }
                this.b = true;
                return sb.toString();
            }
            return sb.toString();
        }

        private void b(String str) {
            this.h = Integer.parseInt(str.substring(96, 108), 2);
            this.i = Long.parseLong(str.substring(108, 128), 2);
        }

        private void c() {
            b a;
            b a2 = a(this.h, this.i);
            double d = ((a.a - a2.a) + a(this.h, this.j).b) - a2.b;
            if (d > 302400.0d) {
                this.h--;
            } else if (d < -302400.0d) {
                this.h++;
            }
            this.m = a(this.h, this.k);
            this.l = this.h + 1024;
        }

        private void c(String str) {
            this.j = Long.parseLong(str.substring(16, 30), 2) * 60.0d;
        }

        private void d(String str) {
            this.k = Long.parseLong(str.substring(54, 68), 2) * 60;
        }
    }

    public static q a() {
        return a.a;
    }

    @TargetApi(24)
    public void a(GnssNavigationMessage gnssNavigationMessage, long j) {
        String str;
        int svid = gnssNavigationMessage.getSvid();
        int type = gnssNavigationMessage.getType();
        switch (type) {
            case 257:
                str = "G";
                break;
            case 769:
                str = "R";
                break;
            case 1281:
                str = "CO";
                break;
            case 1282:
                str = "CT";
                break;
            case 1537:
                str = ExifInterface.LONGITUDE_EAST;
                break;
            default:
                str = "none";
                break;
        }
        String str2 = str + svid;
        if (str2.contains("none") || this.b == null) {
            return;
        }
        if (!this.b.containsKey(str2)) {
            this.b.put(str2, new c(svid, type));
        }
        this.b.get(str2).a(gnssNavigationMessage, j);
    }

    public ArrayList<String> b() {
        ArrayList<String> arrayList = new ArrayList<>();
        for (Map.Entry<String, c> entry : this.b.entrySet()) {
            String key = entry.getKey();
            c value = entry.getValue();
            String b2 = value.b();
            if (b2 != null && b2.length() != 0 && value.f != 257 && value.f != 769) {
                if (!this.c.containsKey(key)) {
                    this.c.put(key, b2);
                } else if (b2.equals(this.c.get(key))) {
                }
                arrayList.add(key + '|' + b2);
            }
        }
        return arrayList;
    }
}
