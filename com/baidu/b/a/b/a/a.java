package com.baidu.b.a.b.a;

import java.util.Random;
/* loaded from: classes2.dex */
public class a {
    public String acE;
    public String channelId;
    public String md5;
    public String name;
    public String packageName;
    public long acC = -1;
    public long acD = 0;
    public int rollback = 0;
    public int KP = -1;
    public int type = 0;
    public String filePath = "";
    public byte[] fileData = null;
    public int acF = 0;
    public long acG = 0;
    public long currentSize = 0;
    public long createTime = 0;
    public long updateTime = 0;
    public long acH = 0;
    public int acI = 0;
    public String acJ = sh();

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof a)) {
            return a((a) obj);
        }
        return false;
    }

    public boolean a(a aVar) {
        return this.channelId.equals(aVar.channelId) && this.packageName.equals(aVar.packageName) && this.acC == aVar.acC && this.md5.equals(aVar.md5);
    }

    public static String sh() {
        long currentTimeMillis = System.currentTimeMillis();
        return String.valueOf(currentTimeMillis) + String.valueOf(new Random(currentTimeMillis).nextInt());
    }
}
