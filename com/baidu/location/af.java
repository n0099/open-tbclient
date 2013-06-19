package com.baidu.location;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import com.baidu.cyberplayer.sdk.BVideoView;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.Calendar;
/* loaded from: classes.dex */
public class af {
    final /* synthetic */ f a;
    private AlarmManager d;
    private ag e;
    private PendingIntent f;
    private Context g;
    private long h;
    private final long b = 86100000;
    private final int c = 200;
    private long[] i = new long[20];
    private int j = 0;
    private u k = null;
    private String l = null;
    private int m = 1;
    private boolean n = false;
    private boolean o = false;
    private boolean p = false;
    private String q = null;

    public af(f fVar, Context context) {
        this.a = fVar;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = 0L;
        this.g = context;
        this.h = System.currentTimeMillis();
        this.d = (AlarmManager) context.getSystemService("alarm");
        this.e = new ag(this);
        context.registerReceiver(this.e, new IntentFilter("com.baidu.locTest.LocationServer"));
        this.f = PendingIntent.getBroadcast(context, 0, new Intent("com.baidu.locTest.LocationServer"), 134217728);
        this.d.setRepeating(2, ap.W, ap.W, this.f);
        fVar.registerReceiver(this.e, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
    }

    public void a() {
        this.g.unregisterReceiver(this.e);
        this.d.cancel(this.f);
        File unused = f.f = null;
    }

    public void b() {
        w wVar;
        w wVar2;
        t tVar;
        t tVar2;
        w wVar3;
        int i;
        w wVar4;
        int i2 = 0;
        try {
            ap.a("baidu_location_service", "regular expire...");
            g();
            if (this.p) {
                this.p = false;
                return;
            }
            h();
            this.j = 0;
            this.k = null;
            wVar = this.a.j;
            if (wVar != null) {
                wVar4 = this.a.j;
                wVar4.e();
            }
            wVar2 = this.a.j;
            if (wVar2 != null) {
                wVar3 = this.a.j;
                aa h = wVar3.h();
                if (h != null && h.a != null) {
                    int size = h.a.size();
                    if (size > 20) {
                        size = 20;
                    }
                    int i3 = 0;
                    while (i3 < size) {
                        try {
                            i = i2 + 1;
                            try {
                                this.i[i2] = Long.parseLong(((ScanResult) h.a.get(i3)).BSSID.replace(":", ""), 16);
                            } catch (Exception e) {
                            }
                        } catch (Exception e2) {
                            i = i2;
                        }
                        i3++;
                        i2 = i;
                    }
                    this.j = i2;
                }
            }
            tVar = this.a.h;
            if (tVar != null) {
                tVar2 = this.a.h;
                this.k = tVar2.d();
            }
            if (this.k != null) {
                c();
            }
        } catch (Exception e3) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:67:0x0291  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0364  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void c() {
        String str;
        File file;
        boolean z;
        w wVar;
        String str2;
        w wVar2;
        e();
        ap.a("baidu_location_service", "trace1:" + this.l);
        try {
            str = this.a.c() ? "y2" : "y1";
        } catch (Exception e) {
            str = "y";
        }
        if (!this.n) {
            try {
                file = f.f;
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                if (randomAccessFile.length() < 1) {
                    randomAccessFile.close();
                    return;
                }
                int readInt = randomAccessFile.readInt();
                for (int i = 0; i < readInt; i++) {
                    randomAccessFile.seek((i * 200) + 4);
                    randomAccessFile.readLong();
                    int readInt2 = randomAccessFile.readInt();
                    int readInt3 = randomAccessFile.readInt();
                    int readInt4 = randomAccessFile.readInt();
                    byte[] bArr = new byte[200];
                    randomAccessFile.read(bArr, 0, (readInt4 * 8) + 16);
                    int i2 = (bArr[3] & 255) | ((bArr[2] << 8) & 65280) | ((bArr[1] << 16) & 16711680) | ((bArr[0] << 24) & (-16777216));
                    int i3 = (bArr[7] & 255) | ((bArr[6] << 8) & 65280) | ((bArr[5] << 16) & 16711680) | ((bArr[4] << 24) & (-16777216));
                    int i4 = (bArr[11] & 255) | ((bArr[10] << 8) & 65280) | ((bArr[9] << 16) & 16711680) | ((bArr[8] << 24) & (-16777216));
                    int i5 = (bArr[15] & 255) | ((bArr[14] << 8) & 65280) | ((bArr[13] << 16) & 16711680) | ((bArr[12] << 24) & (-16777216));
                    if (this.k.c == i2 && this.k.d == i3 && this.k.a == i4 && this.k.b == i5) {
                        long[] jArr = new long[readInt4];
                        for (int i6 = 0; i6 < readInt4; i6++) {
                            jArr[i6] = ((bArr[(i6 * 8) + 16] & 255) << 56) | ((bArr[((i6 * 8) + 16) + 1] & 255) << 48) | ((bArr[((i6 * 8) + 16) + 2] & 255) << 40) | ((bArr[((i6 * 8) + 16) + 3] & 255) << 32) | ((bArr[((i6 * 8) + 16) + 4] & 255) << 24) | ((bArr[((i6 * 8) + 16) + 5] & 255) << 16) | ((bArr[((i6 * 8) + 16) + 6] & 255) << 8) | (bArr[(i6 * 8) + 16 + 7] & 255);
                        }
                        int i7 = 0;
                        int i8 = 0;
                        while (i8 < this.j) {
                            int i9 = i7;
                            for (int i10 = 0; i10 < readInt4; i10++) {
                                if (this.i[i8] == jArr[i10]) {
                                    i9++;
                                }
                            }
                            i8++;
                            i7 = i9;
                        }
                        if (i7 > 5 || i7 * 8 > this.j + readInt4 || ((readInt4 == 0 && this.j == 0) || ((readInt4 == 1 && this.j == 1 && this.i[0] == jArr[0]) || (readInt4 > 1 && this.j > 1 && this.i[0] == jArr[0] && this.i[1] == jArr[1])))) {
                            z = true;
                            randomAccessFile.seek((i * 200) + 16);
                            randomAccessFile.writeInt(readInt3 + 1);
                            if (this.l != null) {
                                this.l += "|" + readInt2 + str;
                                if (this.q != null) {
                                    this.l += this.q;
                                }
                            }
                            ap.a("baidu_location_service", "daily info:is same");
                            if (!z) {
                                String str3 = (this.k.c == 460 ? "|x," : "|x460,") + this.k.d + "," + this.k.a + "," + this.k.b;
                                long j = 0;
                                wVar = this.a.j;
                                if (wVar != null) {
                                    wVar2 = this.a.j;
                                    String f = wVar2.f();
                                    if (f != null) {
                                        try {
                                            j = Long.parseLong(f, 16);
                                        } catch (Exception e2) {
                                        }
                                    }
                                }
                                if (this.j == 1) {
                                    str3 = str3 + "w" + Long.toHexString(this.i[0]) + "k";
                                    if (this.i[0] == j) {
                                        str2 = str3 + "k";
                                        this.l += str2 + str;
                                        if (this.q != null) {
                                            this.l += this.q;
                                        }
                                        d();
                                    }
                                    str2 = str3;
                                    this.l += str2 + str;
                                    if (this.q != null) {
                                    }
                                    d();
                                } else {
                                    if (this.j > 1) {
                                        String str4 = str3 + "w" + Long.toHexString(this.i[0]);
                                        if (this.i[0] == j) {
                                            str4 = str4 + "k";
                                            j = 0;
                                        }
                                        str2 = j > 0 ? str4 + "," + Long.toHexString(j) + "k" : str4 + "," + Long.toHexString(this.i[1]);
                                        this.l += str2 + str;
                                        if (this.q != null) {
                                        }
                                        d();
                                    }
                                    str2 = str3;
                                    this.l += str2 + str;
                                    if (this.q != null) {
                                    }
                                    d();
                                }
                            }
                            ap.a("baidu_location_service", "trace2:" + this.l);
                            f();
                            this.l = null;
                        }
                    }
                }
            } catch (Exception e3) {
                return;
            }
        }
        z = false;
        if (!z) {
        }
        ap.a("baidu_location_service", "trace2:" + this.l);
        f();
        this.l = null;
    }

    public void d() {
        File file;
        File file2;
        e();
        file = f.f;
        if (file == null) {
            return;
        }
        try {
            file2 = f.f;
            RandomAccessFile randomAccessFile = new RandomAccessFile(file2, "rw");
            if (randomAccessFile.length() < 1) {
                randomAccessFile.close();
                return;
            }
            randomAccessFile.seek(0L);
            int readInt = randomAccessFile.readInt();
            randomAccessFile.seek(0L);
            randomAccessFile.writeInt(readInt + 1);
            randomAccessFile.seek((readInt * 200) + 4);
            randomAccessFile.writeLong(System.currentTimeMillis());
            randomAccessFile.writeInt(this.m);
            randomAccessFile.writeInt(0);
            randomAccessFile.writeInt(this.j);
            randomAccessFile.writeInt(this.k.c);
            randomAccessFile.writeInt(this.k.d);
            randomAccessFile.writeInt(this.k.a);
            randomAccessFile.writeInt(this.k.b);
            byte[] bArr = new byte[160];
            for (int i = 0; i < this.j; i++) {
                bArr[(i * 8) + 7] = (byte) this.i[i];
                bArr[(i * 8) + 6] = (byte) (this.i[i] >> 8);
                bArr[(i * 8) + 5] = (byte) (this.i[i] >> 16);
                bArr[(i * 8) + 4] = (byte) (this.i[i] >> 24);
                bArr[(i * 8) + 3] = (byte) (this.i[i] >> 32);
                bArr[(i * 8) + 2] = (byte) (this.i[i] >> 40);
                bArr[(i * 8) + 1] = (byte) (this.i[i] >> 48);
                bArr[(i * 8) + 0] = (byte) (this.i[i] >> 56);
            }
            if (this.j > 0) {
                randomAccessFile.write(bArr, 0, this.j * 8);
            }
            randomAccessFile.writeInt(this.j);
            randomAccessFile.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void e() {
        String str;
        String str2;
        File file;
        File file2;
        File file3;
        try {
            str = this.a.d;
            if (str == null) {
                File unused = f.f = null;
                return;
            }
            str2 = this.a.d;
            File unused2 = f.f = new File(str2);
            file = f.f;
            if (file.exists()) {
                return;
            }
            File file4 = new File(f.a);
            if (!file4.exists()) {
                file4.mkdirs();
            }
            file2 = f.f;
            file2.createNewFile();
            file3 = f.f;
            RandomAccessFile randomAccessFile = new RandomAccessFile(file3, "rw");
            randomAccessFile.seek(0L);
            randomAccessFile.writeInt(0);
            randomAccessFile.close();
        } catch (Exception e) {
            e.printStackTrace();
            File unused3 = f.f = null;
        }
    }

    public void f() {
        File file;
        File file2;
        int i;
        f.a();
        file = f.g;
        if (file == null) {
            return;
        }
        try {
            file2 = f.g;
            RandomAccessFile randomAccessFile = new RandomAccessFile(file2, "rw");
            if (randomAccessFile.length() < 1) {
                randomAccessFile.close();
                return;
            }
            randomAccessFile.seek(0L);
            int readInt = randomAccessFile.readInt();
            int readInt2 = randomAccessFile.readInt();
            int readInt3 = randomAccessFile.readInt();
            if (this.n && this.o) {
                ap.a("baidu_location_service", "trace new info:" + readInt + ":" + readInt2 + ":" + readInt3);
                int i2 = (readInt2 + 1) % 200;
                randomAccessFile.seek(4L);
                randomAccessFile.writeInt(i2);
                readInt++;
                if (readInt >= 200) {
                    readInt = 199;
                }
                if (i2 == readInt3 && readInt > 0) {
                    readInt3 = (readInt3 + 1) % 200;
                    randomAccessFile.writeInt(readInt3);
                }
                ap.a("baidu_location_service", "trace new info:" + readInt + ":" + readInt2 + ":" + readInt3);
                i = (i2 * BVideoView.MEDIA_INFO_BAD_INTERLEAVING) + 24;
            } else {
                i = (readInt2 * BVideoView.MEDIA_INFO_BAD_INTERLEAVING) + 24;
            }
            randomAccessFile.seek(i + 4);
            byte[] bytes = this.l.getBytes();
            for (int i3 = 0; i3 < bytes.length; i3++) {
                bytes[i3] = (byte) (bytes[i3] ^ 90);
            }
            randomAccessFile.write(bytes, 0, bytes.length);
            randomAccessFile.writeInt(bytes.length);
            randomAccessFile.seek(i);
            randomAccessFile.writeInt(bytes.length);
            if (this.n && this.o) {
                randomAccessFile.seek(0L);
                randomAccessFile.writeInt(readInt);
            }
            randomAccessFile.close();
        } catch (Exception e) {
        }
    }

    public void g() {
        File file;
        File file2;
        this.n = false;
        this.o = false;
        e();
        f.a();
        try {
            file = f.g;
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            randomAccessFile.seek(0L);
            int readInt = randomAccessFile.readInt();
            int readInt2 = randomAccessFile.readInt();
            randomAccessFile.readInt();
            long readLong = randomAccessFile.readLong();
            int readInt3 = randomAccessFile.readInt();
            if (readInt < 0) {
                this.n = true;
                this.o = true;
                randomAccessFile.close();
                return;
            }
            randomAccessFile.seek((readInt2 * BVideoView.MEDIA_INFO_BAD_INTERLEAVING) + 24);
            int readInt4 = randomAccessFile.readInt();
            if (readInt4 > 680) {
                this.n = true;
                this.o = true;
                randomAccessFile.close();
                return;
            }
            byte[] bArr = new byte[BVideoView.MEDIA_INFO_BAD_INTERLEAVING];
            randomAccessFile.read(bArr, 0, readInt4);
            if (readInt4 != randomAccessFile.readInt()) {
                ap.a("baidu_location_service", "trace true check fail");
                this.n = true;
                this.o = true;
                randomAccessFile.close();
                return;
            }
            for (int i = 0; i < bArr.length; i++) {
                bArr[i] = (byte) (bArr[i] ^ 90);
            }
            this.l = new String(bArr, 0, readInt4);
            if (!this.l.contains("&tr=")) {
                this.n = true;
                this.o = true;
                randomAccessFile.close();
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            long j = currentTimeMillis - readLong;
            if (j > (ap.W * 3) - ap.Y) {
                this.n = true;
            } else if (j > (ap.W * 2) - ap.Y) {
                this.l += "|" + readInt3;
                this.m = readInt3 + 2;
            } else if (j <= ap.W - ap.Y) {
                this.p = true;
                randomAccessFile.close();
                return;
            } else {
                this.m = readInt3 + 1;
            }
            randomAccessFile.seek(12L);
            randomAccessFile.writeLong(currentTimeMillis);
            randomAccessFile.writeInt(this.m);
            randomAccessFile.close();
            file2 = f.f;
            RandomAccessFile randomAccessFile2 = new RandomAccessFile(file2, "rw");
            randomAccessFile2.seek(0L);
            if (randomAccessFile2.readInt() != 0) {
                randomAccessFile2.close();
                return;
            }
            this.n = true;
            randomAccessFile2.close();
            ap.a("baidu_location_service", "Day file number 0");
        } catch (Exception e) {
            e.printStackTrace();
            ap.a("baidu_location_service", "exception!!!");
            this.n = true;
            this.o = true;
        }
    }

    public void h() {
        File file;
        File file2;
        if (this.n) {
            this.m = 1;
            ap.W = ap.X * 1000 * 60;
            ap.Y = ap.W >> 2;
            Calendar calendar = Calendar.getInstance();
            int i = calendar.get(5);
            int i2 = calendar.get(1);
            String str = (i2 > 2000 ? i2 - 2000 : 0) + "," + (calendar.get(2) + 1) + "," + i + "," + calendar.get(11) + "," + calendar.get(12) + "," + ap.X;
            if (this.o) {
                this.l = "&tr=" + ap.h + "," + str;
            } else {
                this.l += "|T" + str;
            }
            ap.a("baidu_location_service", "trace begin:" + this.l);
            try {
                file = f.g;
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                randomAccessFile.seek(12L);
                randomAccessFile.writeLong(System.currentTimeMillis());
                randomAccessFile.writeInt(this.m);
                randomAccessFile.close();
                file2 = f.f;
                RandomAccessFile randomAccessFile2 = new RandomAccessFile(file2, "rw");
                randomAccessFile2.seek(0L);
                randomAccessFile2.writeInt(0);
                randomAccessFile2.close();
            } catch (Exception e) {
            }
        }
    }
}
