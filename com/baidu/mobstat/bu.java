package com.baidu.mobstat;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class bu {
    public static volatile bu b;
    public static OnAppBackgroundListener k;
    public String f;
    public String g;
    public static final Pattern c = Pattern.compile("\\s*|\t|\r|\n");
    public static boolean i = false;
    public static boolean j = false;
    public static boolean l = true;
    public List<PermissionEnum> d = new ArrayList();
    public String e = "android.permission.APP_LIST";
    public final int a = 100;
    public List<JSONObject> h = new ArrayList();

    public static bu a() {
        if (b == null) {
            synchronized (bu.class) {
                if (b == null) {
                    b = new bu();
                }
            }
        }
        return b;
    }

    private boolean f() {
        OnAppBackgroundListener onAppBackgroundListener = k;
        if (onAppBackgroundListener != null) {
            return onAppBackgroundListener.isBackground();
        }
        return j;
    }

    public String b() {
        if (TextUtils.isEmpty(this.g)) {
            return "";
        }
        return this.g;
    }

    public String c() {
        if (TextUtils.isEmpty(this.f)) {
            return "";
        }
        return bw.a(c.matcher(this.f).replaceAll(""));
    }

    public boolean d() {
        return a(true);
    }

    public boolean e() {
        return l;
    }

    public void a(OnAppBackgroundListener onAppBackgroundListener) {
        k = onAppBackgroundListener;
    }

    public void b(boolean z) {
        i = z;
    }

    public void c(boolean z) {
        l = z;
    }

    public void a(String str) {
        this.g = str;
    }

    public boolean a(boolean z) {
        if (z) {
            if (i && !f()) {
                return true;
            }
            return false;
        }
        return i;
    }
}
