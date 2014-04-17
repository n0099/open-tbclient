package com.baidu.adp.lib.stats;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Handler;
import android.os.Process;
import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.io.IOUtils;
/* loaded from: classes.dex */
public abstract class e {
    protected static String g;
    protected StringBuffer h;
    protected Handler j;
    protected String k;
    protected String l;
    private long p;
    private Context q;
    protected boolean a = false;
    protected boolean b = false;
    protected boolean c = false;
    protected int d = 50;
    protected int e = 0;
    protected boolean f = false;
    protected int i = 0;
    protected boolean m = false;
    protected long n = 0;
    protected BdStatFirstSwitchData o = null;

    public abstract void a();

    public abstract void a(String str);

    public abstract void a(boolean z);

    public abstract ArrayList<String> b();

    public abstract void b(String str);

    public abstract void b(boolean z);

    public abstract String c();

    public abstract boolean d();

    public e(Context context, Handler handler, String str) {
        this.p = 0L;
        this.q = null;
        this.q = context;
        this.j = handler;
        this.k = str;
        this.p = System.currentTimeMillis();
        com.baidu.adp.lib.util.c.d(this.k);
        if (TextUtils.isEmpty(g)) {
            g = e();
        }
        this.h = new StringBuffer();
    }

    public final void c(boolean z) {
        this.f = z;
        b(true);
    }

    public final String f() {
        return this.l;
    }

    public final long g() {
        return this.n;
    }

    public final void a(long j) {
        this.n = j;
    }

    public final boolean h() {
        return this.m;
    }

    public final void d(boolean z) {
        this.m = z;
    }

    public final boolean i() {
        return this.a;
    }

    public final void a(r rVar) {
        if (rVar != null) {
            try {
                this.h.append(rVar.toString());
                this.h.append(IOUtils.LINE_SEPARATOR_WINDOWS);
                this.i++;
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.a(getClass(), "add", e);
            }
        }
        if (System.currentTimeMillis() - this.p > 60000) {
            a(true);
        } else {
            a(false);
        }
        this.p = System.currentTimeMillis();
    }

    public final boolean j() {
        return this.i > 0 && (this.c || this.i >= 10);
    }

    public final void a(BdStatFirstSwitchData bdStatFirstSwitchData) {
        if (bdStatFirstSwitchData != null) {
            this.o = bdStatFirstSwitchData;
            BdStatCommonSwitchData common = this.o.getCommon();
            if (common != null) {
                this.c = common.isIs_exact();
                this.a = common.isIs_open();
                this.b = common.isIs_only_wifi();
            }
        }
    }

    public final boolean c(String str) {
        if (TextUtils.isEmpty(str) || this.o == null || this.o.getChildren() == null) {
            return true;
        }
        Iterator<BdStatSecondSwitchData> it = this.o.getChildren().iterator();
        while (it.hasNext()) {
            BdStatSecondSwitchData next = it.next();
            if (next != null && next.getType() != null && next.getType().equals(str)) {
                return next.isIs_open();
            }
        }
        return true;
    }

    public ArrayList<String> a(ArrayList<String> arrayList) {
        return arrayList;
    }

    public final ArrayList<String> k() {
        if (this.h != null && this.h.length() > 0) {
            ArrayList<String> arrayList = new ArrayList<>();
            String[] split = this.h.toString().split(IOUtils.LINE_SEPARATOR_WINDOWS);
            if (split != null && split.length > 0) {
                for (String str : split) {
                    arrayList.add(str);
                }
                return arrayList;
            }
            return arrayList;
        }
        return null;
    }

    public final void l() {
        this.h = new StringBuffer(this.h.length());
        this.i = 0;
    }

    private String e() {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        if (this.q == null) {
            return null;
        }
        ActivityManager activityManager = (ActivityManager) this.q.getSystemService("activity");
        if (activityManager != null && (runningAppProcesses = activityManager.getRunningAppProcesses()) != null) {
            int myPid = Process.myPid();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= runningAppProcesses.size()) {
                    break;
                }
                if (runningAppProcesses.get(i2).pid == myPid) {
                    String str = runningAppProcesses.get(i2).processName;
                    if (!TextUtils.isEmpty(str)) {
                        try {
                            String a = q.a(str.getBytes("UTF-8"));
                            if (!TextUtils.isEmpty(a) && a.length() > 8) {
                                return a.substring(a.length() - 8);
                            }
                            return a;
                        } catch (UnsupportedEncodingException e) {
                            com.baidu.adp.lib.util.f.a(getClass(), "getProcessName", e);
                            return str;
                        }
                    }
                }
                i = i2 + 1;
            }
        }
        return null;
    }
}
