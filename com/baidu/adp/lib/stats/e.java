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

    public abstract String c();

    public abstract void c(boolean z);

    public abstract boolean d();

    public e(Context context, Handler handler, String str) {
        this.p = 0L;
        this.q = null;
        this.q = context;
        this.j = handler;
        this.k = str;
        this.p = System.currentTimeMillis();
        com.baidu.adp.lib.g.b.f(this.k);
        if (TextUtils.isEmpty(g)) {
            g = l();
        }
        this.h = new StringBuffer();
    }

    public void d(boolean z) {
        this.f = z;
        if (z && this.b) {
            c(true);
        }
    }

    public String e() {
        return this.l;
    }

    public long f() {
        return this.n;
    }

    public boolean g() {
        return this.m;
    }

    public void e(boolean z) {
        this.m = z;
    }

    public boolean h() {
        return this.a;
    }

    public void a(t tVar) {
        if (tVar != null) {
            try {
                this.h.append(tVar.toString());
                this.h.append("\r\n");
                this.i++;
            } catch (Exception e) {
                com.baidu.adp.lib.g.e.a(getClass(), "add", e);
            }
        }
        this.p = System.currentTimeMillis();
        a(false);
    }

    public boolean i() {
        return this.i > 0 && (this.c || this.i >= 10 || System.currentTimeMillis() - this.p > 60000);
    }

    public void a(BdStatFirstSwitchData bdStatFirstSwitchData) {
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

    public boolean c(String str) {
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

    public ArrayList<String> j() {
        if (this.h != null && this.h.length() > 0) {
            ArrayList<String> arrayList = new ArrayList<>();
            String[] split = this.h.toString().split("\r\n");
            if (split == null || split.length <= 0) {
                return arrayList;
            }
            for (String str : split) {
                arrayList.add(str);
            }
            return arrayList;
        }
        return null;
    }

    public void k() {
        this.h = new StringBuffer(this.h.length());
        this.i = 0;
    }

    private String l() {
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
                            String a = s.a(str.getBytes("UTF-8"));
                            if (!TextUtils.isEmpty(a) && a.length() > 8) {
                                return a.substring(a.length() - 8);
                            }
                            return a;
                        } catch (UnsupportedEncodingException e) {
                            com.baidu.adp.lib.g.e.a(getClass(), "getProcessName", e);
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
