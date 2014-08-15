package com.baidu.tbadk.aladin.a;
/* loaded from: classes.dex */
public class a {
    private String a;
    private String b;
    private String c;

    public a(String str) {
        String[] split;
        if (str != null && (split = str.split(" ")) != null && split.length == 3) {
            this.a = split[0];
            this.b = split[1];
            this.c = split[2];
        }
    }

    public String a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    public void a(String str) {
        this.b = str;
    }

    public String c() {
        return this.c;
    }
}
