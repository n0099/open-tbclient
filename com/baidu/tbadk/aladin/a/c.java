package com.baidu.tbadk.aladin.a;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class c {
    private final Map<String, String> a = new HashMap(20);
    private String b = "";

    public String a() {
        StringBuilder sb = new StringBuilder();
        sb.append("HTTP/");
        sb.append("1.0");
        sb.append(" ");
        sb.append("200");
        sb.append(" ");
        sb.append("ok");
        sb.append("\n");
        for (Map.Entry<String, String> entry : this.a.entrySet()) {
            if (entry != null) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (key != null && value != null) {
                    sb.append(key);
                    sb.append(":");
                    sb.append(value);
                    sb.append("\n");
                }
            }
        }
        sb.append("\n");
        if (this.b != null) {
            sb.append(this.b);
        }
        return sb.toString();
    }

    public void a(String str) {
        this.b = str;
    }

    public void a(String str, String str2) {
        if (str != null && str2 != null) {
            this.a.put(str, str2);
        }
    }
}
