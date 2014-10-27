package com.baidu.tbadk.aladin.a;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class c {
    private final Map<String, String> xm = new HashMap(20);
    private String content = "";

    public String iM() {
        StringBuilder sb = new StringBuilder();
        sb.append("HTTP/");
        sb.append("1.0");
        sb.append(" ");
        sb.append("200");
        sb.append(" ");
        sb.append("ok");
        sb.append("\n");
        for (Map.Entry<String, String> entry : this.xm.entrySet()) {
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
        if (this.content != null) {
            sb.append(this.content);
        }
        return sb.toString();
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void u(String str, String str2) {
        if (str != null && str2 != null) {
            this.xm.put(str, str2);
        }
    }
}
