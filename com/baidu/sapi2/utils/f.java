package com.baidu.sapi2.utils;

import android.content.Context;
import com.baidu.sapi2.SapiAccountManager;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class f {
    static List<String> b = new ArrayList();
    static int c;
    Context a;

    private void e() {
        b.clear();
        b.add(g.c);
        b.add(g.d);
        b.add(g.e);
    }

    public f(Context context) {
        this.a = context;
        d();
        e();
    }

    public String a() {
        String url = SapiAccountManager.getInstance().getSapiConfiguration().environment.getURL();
        if (c > 0) {
            if (c > b.size()) {
                c = 1;
            }
            return b.get(c - 1);
        }
        return url;
    }

    public void b() {
        c++;
    }

    public boolean c() {
        return c >= b.size();
    }

    public void d() {
        c = 0;
    }
}
