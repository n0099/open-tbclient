package com.baidu.location;

import java.io.File;
import java.io.RandomAccessFile;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e {

    /* renamed from: if  reason: not valid java name */
    static e f91if;

    /* renamed from: new  reason: not valid java name */
    String f95new = "firll.dat";

    /* renamed from: for  reason: not valid java name */
    int f93for = 3164;

    /* renamed from: do  reason: not valid java name */
    int f92do = 0;
    int a = 20;

    /* renamed from: int  reason: not valid java name */
    int f94int = 40;

    e() {
    }

    private long a(int i) {
        String m276long = c.m276long();
        if (m276long == null) {
            return -1L;
        }
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(m276long + File.separator + this.f95new, "rw");
            randomAccessFile.seek(i);
            int readInt = randomAccessFile.readInt();
            long readLong = randomAccessFile.readLong();
            int readInt2 = randomAccessFile.readInt();
            randomAccessFile.close();
            if (readInt == readInt2) {
                return readLong;
            }
            return -1L;
        } catch (Exception e) {
            return -1L;
        }
    }

    private void a(int i, long j) {
        String m276long = c.m276long();
        if (m276long == null) {
            return;
        }
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(m276long + File.separator + this.f95new, "rw");
            randomAccessFile.seek(i);
            randomAccessFile.writeInt(this.f93for);
            randomAccessFile.writeLong(j);
            randomAccessFile.writeInt(this.f93for);
            randomAccessFile.close();
        } catch (Exception e) {
        }
    }

    /* renamed from: if  reason: not valid java name */
    public static e m284if() {
        if (f91if == null) {
            f91if = new e();
        }
        return f91if;
    }

    public long a() {
        return a(this.a);
    }

    public void a(long j) {
        a(this.f94int, j);
    }

    /* renamed from: do  reason: not valid java name */
    public long m285do() {
        return a(this.f92do);
    }

    /* renamed from: do  reason: not valid java name */
    public void m286do(long j) {
        a(this.f92do, j);
    }

    /* renamed from: for  reason: not valid java name */
    public long m287for() {
        return a(this.f94int);
    }

    /* renamed from: if  reason: not valid java name */
    public void m288if(long j) {
        a(this.a, j);
    }
}
