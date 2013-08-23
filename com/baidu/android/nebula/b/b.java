package com.baidu.android.nebula.b;

import com.baidu.browser.core.util.BdUtil;
import com.baidu.browser.explorer.BdWebErrorView;
import com.baidu.cyberplayer.sdk.internal.HttpUtils;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static final Map f558a = new HashMap();
    private Map b = new HashMap();
    private StringBuilder c = new StringBuilder();
    private int d = BdWebErrorView.ERROR_CODE_404;
    private String e = "HTTP/1.1";

    static {
        f558a.put(new Integer(200), "OK");
        f558a.put(new Integer((int) BdWebErrorView.ERROR_CODE_404), "Page Not Found");
        f558a.put(new Integer((int) BdWebErrorView.ERROR_CODE_500), "Intenal Error");
    }

    public b() {
        this.b.put("Content-Type", "text/html");
        this.b.put(HttpUtils.HEADER_NAME_CONTENT_ENCODING, BdUtil.UTF8);
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
        String str = (String) f558a.get(Integer.valueOf(this.d));
        if (str == null) {
            str = "Unknown";
        }
        sb.append(this.e + " " + this.d + " " + str + "\r\n");
        this.b.put(HttpUtils.HEADER_NAME_CONTENT_LENGTH, String.valueOf(this.c.toString().getBytes().length));
        for (String str2 : this.b.keySet()) {
            sb.append(str2 + ": " + ((String) this.b.get(str2)) + "\r\n");
        }
        sb.append("\r\n" + this.c.toString());
        return sb.toString();
    }
}
