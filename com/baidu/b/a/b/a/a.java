package com.baidu.b.a.b.a;

import java.util.Random;
/* loaded from: classes2.dex */
public class a {
    public String aaT;
    public String channelId;
    public String md5;
    public String name;
    public String packageName;
    public long version = -1;
    public long aaS = 0;
    public int rollback = 0;
    public int IL = -1;
    public int type = 0;
    public String filePath = "";
    public byte[] fileData = null;
    public int aaU = 0;
    public long aaV = 0;
    public long currentSize = 0;
    public long createTime = 0;
    public long updateTime = 0;
    public long aaW = 0;
    public int aaX = 0;
    public String aaY = ry();

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof a)) {
            return a((a) obj);
        }
        return false;
    }

    public boolean a(a aVar) {
        return this.channelId.equals(aVar.channelId) && this.packageName.equals(aVar.packageName) && this.version == aVar.version && this.md5.equals(aVar.md5);
    }

    public static String ry() {
        long currentTimeMillis = System.currentTimeMillis();
        return String.valueOf(currentTimeMillis) + String.valueOf(new Random(currentTimeMillis).nextInt());
    }
}
