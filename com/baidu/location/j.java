package com.baidu.location;

import com.baidu.location.au;
import com.baidu.location.u;
import com.baidu.tbadk.game.GameInfoData;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.Iterator;
import java.util.Locale;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements a0, b {
    private static j lh = null;
    double lm = 0.0d;
    double li = 0.0d;
    boolean lf = false;
    long lk = 0;
    double lc = 0.0d;
    double ld = 0.0d;
    volatile int lg = -1;
    int lj = -1;
    private x lb = null;
    private x ln = null;
    private int le = 5;
    private int ll = 0;

    private j() {
    }

    public static j dg() {
        if (lh == null) {
            lh = new j();
        }
        return lh;
    }

    public String dc() {
        String str;
        if (this.ll < 5) {
            return null;
        }
        String format = String.format(Locale.CHINA, "&ofln=%d&ofwn=", Integer.valueOf(this.ll));
        Iterator it = this.lb.iterator();
        while (true) {
            str = format;
            if (!it.hasNext()) {
                break;
            }
            format = String.format(Locale.CHINA, "%s%s|", str, (String) it.next());
        }
        String format2 = String.format(Locale.CHINA, "%s&ofcn=", str);
        Iterator it2 = this.ln.iterator();
        while (true) {
            String str2 = format2;
            if (!it2.hasNext()) {
                return str2;
            }
            format2 = String.format(Locale.CHINA, "%s%s|", str2, (String) it2.next());
        }
    }

    public void dd() {
        String m276long = c.m276long();
        if (m276long == null) {
            return;
        }
        File file = new File(m276long + File.separator + "offinfo.dat");
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            randomAccessFile.seek(0L);
            randomAccessFile.writeInt(this.ll);
            int size = this.lb.size();
            for (int i = 0; i < size; i++) {
                randomAccessFile.writeInt(Integer.valueOf((String) this.lb.get(i)).intValue());
            }
            for (int i2 = size; i2 < this.le; i2++) {
                randomAccessFile.writeInt(-1);
            }
            int size2 = this.ln.size();
            for (int i3 = 0; i3 < size2; i3++) {
                randomAccessFile.writeInt(Integer.valueOf((String) this.ln.get(i3)).intValue());
            }
            for (int i4 = size2; i4 < this.le; i4++) {
                randomAccessFile.writeInt(-1);
            }
            randomAccessFile.close();
        } catch (Exception e) {
        }
        this.lb.clear();
        this.ln.clear();
        this.lb = null;
        this.ln = null;
    }

    public void de() {
        if (this.ll >= 5) {
            this.ll = 0;
            this.lb.clear();
            this.ln.clear();
        }
    }

    public void df() {
        this.lb = new x(this.le);
        this.ln = new x(this.le);
        String m276long = c.m276long();
        if (m276long == null) {
            return;
        }
        File file = new File(m276long + File.separator + "offinfo.dat");
        if (file.exists()) {
            try {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                randomAccessFile.seek(0L);
                this.ll = randomAccessFile.readInt();
                for (int i = 0; i < this.le; i++) {
                    int readInt = randomAccessFile.readInt();
                    if (readInt >= 0) {
                        this.lb.add("" + readInt);
                    }
                }
                for (int i2 = 0; i2 < this.le; i2++) {
                    int readInt2 = randomAccessFile.readInt();
                    if (readInt2 >= 0) {
                        this.ln.add("" + readInt2);
                    }
                }
                randomAccessFile.close();
            } catch (Exception e) {
                this.ll = 0;
                this.lb.clear();
                this.ln.clear();
            }
        }
    }

    /* renamed from: if  reason: not valid java name */
    public void m294if(u.a aVar, au.b bVar) {
        this.ll++;
        if (aVar == null || !aVar.a()) {
            this.ln.add(GameInfoData.NOT_FROM_DETAIL);
        } else {
            this.ln.add("1");
        }
        if (bVar == null || bVar.m227try() <= 0) {
            this.lb.add(GameInfoData.NOT_FROM_DETAIL);
        } else {
            this.lb.add("" + bVar.m227try());
        }
    }
}
