package com.baidu.swan.apps.statistic.b;
/* loaded from: classes2.dex */
public class a {
    public String id;
    public long timestamp;
    public String value;

    public a(String str) {
        this.id = str;
        this.timestamp = System.currentTimeMillis();
        this.value = "";
    }

    public a(String str, String str2, String str3) {
        this.id = str;
        this.timestamp = Long.valueOf(str2).longValue();
        this.value = str3;
    }

    public String toString() {
        return "id: " + this.id + ", timestamp: " + this.timestamp + ", value: " + this.value;
    }
}
