package com.baidu.android.nebula.a;

import com.baidu.lightapp.plugin.videoplayer.coreplayer.Constants;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.io.IOUtils;
/* loaded from: classes.dex */
public class a {
    private static final Map a = new HashMap();
    private Map b = new HashMap();
    private StringBuilder c = new StringBuilder();
    private int d = 404;
    private String e = "HTTP/1.1";

    static {
        a.put(new Integer((int) Constants.MEDIA_INFO), "OK");
        a.put(new Integer(404), "Page Not Found");
        a.put(new Integer(500), "Intenal Error");
    }

    public a() {
        this.b.put("Content-Type", "text/html");
        this.b.put("Content-Encoding", "utf-8");
    }

    public Map a() {
        return this.b;
    }

    public void a(int i) {
        this.d = i;
    }

    public void a(String str) {
        this.b.put("Content-Type", str);
    }

    public void b(String str) {
        this.c.append(str);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        String str = (String) a.get(Integer.valueOf(this.d));
        if (str == null) {
            str = "Unknown";
        }
        sb.append(this.e + " " + this.d + " " + str + IOUtils.LINE_SEPARATOR_WINDOWS);
        this.b.put("Content-Length", String.valueOf(this.c.toString().getBytes().length));
        for (String str2 : this.b.keySet()) {
            sb.append(str2 + ": " + ((String) this.b.get(str2)) + IOUtils.LINE_SEPARATOR_WINDOWS);
        }
        sb.append(IOUtils.LINE_SEPARATOR_WINDOWS + this.c.toString());
        return sb.toString();
    }
}
