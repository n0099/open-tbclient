package com.baidu.location.c;

import com.baidu.location.Jni;
import java.io.File;
import java.io.RandomAccessFile;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class f {
    private g OL;
    private static volatile f OJ = null;
    private static String c = "LogSDK";
    private static int d = 5;
    private static int e = 1024;
    private static final String f = com.baidu.location.h.h.a + "/llg.dat";
    private static final String g = com.baidu.location.h.h.a + "/ller.dat";
    public static final String a = com.baidu.location.h.h.a + "/llin.dat";
    private SimpleDateFormat h = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private g OM = null;
    private a OO = null;
    private long l = 0;

    /* loaded from: classes.dex */
    private class a extends com.baidu.location.h.f {
        private String b = null;
        private boolean c = false;

        a() {
            this.k = new HashMap();
        }

        @Override // com.baidu.location.h.f
        public void a() {
            this.k.clear();
            this.k.put("qt", "stat");
            this.k.put("req", this.b);
            this.h = "http://loc.map.baidu.com/statloc";
        }

        public void a(String str) {
            this.b = str;
            if (this.b != null) {
                e();
                this.c = true;
            }
        }

        @Override // com.baidu.location.h.f
        public void a(boolean z) {
            this.c = false;
            if (!z || this.j == null) {
                f.this.l = System.currentTimeMillis();
                return;
            }
            try {
                String str = this.j;
            } catch (Exception e) {
            }
        }

        public boolean b() {
            return this.c;
        }
    }

    private f() {
        this.OL = null;
        if (this.OL == null) {
            this.OL = new g();
        }
    }

    public static synchronized void a(String str, String str2) {
        int i;
        synchronized (f.class) {
            File file = new File(str);
            if (!file.exists()) {
                b(str);
            }
            try {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                randomAccessFile.seek(4L);
                int readInt = randomAccessFile.readInt();
                int readInt2 = randomAccessFile.readInt();
                int readInt3 = randomAccessFile.readInt();
                int readInt4 = randomAccessFile.readInt();
                int readInt5 = randomAccessFile.readInt();
                if (readInt3 < readInt) {
                    randomAccessFile.seek((readInt2 * readInt3) + 128);
                    byte[] bytes = (str2 + (char) 0).getBytes();
                    randomAccessFile.writeInt(bytes.length);
                    randomAccessFile.write(bytes, 0, bytes.length);
                    i = readInt3 + 1;
                } else {
                    randomAccessFile.seek((readInt4 * readInt2) + 128);
                    byte[] bytes2 = (str2 + (char) 0).getBytes();
                    randomAccessFile.writeInt(bytes2.length);
                    randomAccessFile.write(bytes2, 0, bytes2.length);
                    readInt4++;
                    if (readInt4 > readInt3) {
                        readInt4 = 0;
                        i = readInt3;
                    } else {
                        i = readInt3;
                    }
                }
                randomAccessFile.seek(12L);
                randomAccessFile.writeInt(i);
                randomAccessFile.writeInt(readInt4);
                randomAccessFile.writeInt(readInt5);
                randomAccessFile.close();
            } catch (Exception e2) {
            }
        }
    }

    public static boolean a(String str, List<String> list) {
        File file = new File(str);
        if (file.exists()) {
            try {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                randomAccessFile.seek(8L);
                int readInt = randomAccessFile.readInt();
                int readInt2 = randomAccessFile.readInt();
                int readInt3 = randomAccessFile.readInt();
                byte[] bArr = new byte[e];
                int i = readInt2;
                int i2 = d + 1;
                boolean z = false;
                while (i2 > 0 && i > 0) {
                    if (i < readInt3) {
                        readInt3 = 0;
                    }
                    try {
                        randomAccessFile.seek(((i - 1) * readInt) + 128);
                        int readInt4 = randomAccessFile.readInt();
                        if (readInt4 > 0 && readInt4 < readInt) {
                            randomAccessFile.read(bArr, 0, readInt4);
                            if (bArr[readInt4 - 1] == 0) {
                                list.add(0, new String(bArr, 0, readInt4 - 1));
                                z = true;
                            }
                        }
                        i2--;
                        i--;
                    } catch (Exception e2) {
                        return z;
                    }
                }
                randomAccessFile.seek(12L);
                randomAccessFile.writeInt(i);
                randomAccessFile.writeInt(readInt3);
                randomAccessFile.close();
                return z;
            } catch (Exception e3) {
                return false;
            }
        }
        return false;
    }

    private static void b(String str) {
        try {
            File file = new File(str);
            if (file.exists()) {
                return;
            }
            File file2 = new File(com.baidu.location.h.h.a);
            if (!file2.exists()) {
                file2.mkdirs();
            }
            if (!file.createNewFile()) {
                file = null;
            }
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            randomAccessFile.seek(0L);
            randomAccessFile.writeInt(32);
            randomAccessFile.writeInt(1000);
            randomAccessFile.writeInt(1040);
            randomAccessFile.writeInt(0);
            randomAccessFile.writeInt(0);
            randomAccessFile.writeInt(0);
            randomAccessFile.close();
        } catch (Exception e2) {
        }
    }

    public static f nm() {
        if (OJ == null) {
            synchronized (f.class) {
                if (OJ == null) {
                    OJ = new f();
                }
            }
        }
        return OJ;
    }

    public void a(g gVar) {
        if (gVar != null) {
            a(f, Jni.encode(gVar.b()));
        }
    }

    public void a(String str) {
        if (str != null) {
            try {
                StringBuffer stringBuffer = new StringBuffer();
                String format = this.h.format(new Date());
                stringBuffer.append("&time=");
                stringBuffer.append(format);
                stringBuffer.append("&err=");
                stringBuffer.append(str);
                stringBuffer.append(com.baidu.location.h.c.nS().a(false));
                stringBuffer.append(com.baidu.location.a.a.mS().c());
                a(g, Jni.encode(stringBuffer.toString()));
            } catch (Exception e2) {
            }
        }
    }

    public void c() {
        if (this.OL != null) {
            a(f, Jni.encode(this.OL.b()));
            this.OL.a();
        }
    }

    public void d() {
        boolean z;
        boolean z2;
        if (this.OO == null) {
            this.OO = new a();
        }
        if (System.currentTimeMillis() - this.l >= 3600000 && !this.OO.b()) {
            try {
                ArrayList arrayList = new ArrayList();
                a(g, arrayList);
                if (arrayList.size() > 0) {
                    z = false;
                    z2 = true;
                } else {
                    a(f, arrayList);
                    if (arrayList.size() == 0) {
                        a(a, arrayList);
                        z = true;
                        z2 = false;
                    } else {
                        z = false;
                        z2 = false;
                    }
                }
                JSONArray jSONArray = new JSONArray();
                JSONObject jSONObject = new JSONObject();
                if (arrayList.size() > 0) {
                    int size = arrayList.size();
                    for (int i = 0; i < size; i++) {
                        jSONArray.put((String) arrayList.get(i));
                    }
                    if (z2) {
                        jSONObject.put("locpt", jSONArray);
                    } else if (z) {
                        jSONObject.put("locup", jSONArray);
                    } else {
                        jSONObject.put("loctc", jSONArray);
                    }
                    this.OO.a(jSONObject.toString());
                }
            } catch (Exception e2) {
            }
        }
    }

    public g nn() {
        return this.OL;
    }
}
