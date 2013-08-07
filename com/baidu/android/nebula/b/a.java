package com.baidu.android.nebula.b;

import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private int f534a;
    private Map b;
    private Map c;
    private byte[] d;

    public a() {
        this.f534a = -1;
        this.b = new HashMap();
        this.c = new HashMap();
    }

    public a(String str) {
        this.f534a = -1;
        this.b = new HashMap();
        this.c = new HashMap();
        if (str == null) {
            return;
        }
        String[] split = str.split("\r\n");
        if (split.length >= 2) {
            String[] split2 = split[0].split(" ");
            if (split2.length >= 2) {
                this.f534a = c.a(split2[0]);
                String str2 = split2[1];
                if (str2 != null) {
                    this.b.put("URI", str2);
                    int indexOf = str2.indexOf("?");
                    try {
                        this.c = new HashMap();
                        if (indexOf != -1) {
                            String[] split3 = str2.substring(indexOf + 1).split("&");
                            for (String str3 : split3) {
                                String[] split4 = str3.split("=");
                                if (split4.length >= 2) {
                                    split4[0] = URLDecoder.decode(split4[0], "utf8");
                                    split4[1] = URLDecoder.decode(split4[1], "utf8");
                                    this.c.put(split4[0], split4[1]);
                                }
                            }
                        }
                        for (int i = 1; i < split.length; i++) {
                            String[] split5 = split[i].split(": ");
                            if (split5.length >= 2) {
                                split5[0] = split5[0].trim();
                                split5[1] = split5[1].trim();
                                this.b.put(split5[0], split5[1]);
                            }
                        }
                    } catch (Exception e) {
                    }
                }
            }
        }
    }

    public String a(String str) {
        return (String) this.b.get(str);
    }

    public Map a() {
        return this.c;
    }

    public void a(byte[] bArr) {
        this.d = bArr;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry entry : this.b.entrySet()) {
            sb.append(((String) entry.getKey()) + " : " + ((String) entry.getValue()) + "\n");
        }
        if (this.d != null) {
            sb.append(new String(this.d));
        }
        return sb.toString();
    }
}
