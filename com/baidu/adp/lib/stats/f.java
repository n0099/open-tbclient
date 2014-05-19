package com.baidu.adp.lib.stats;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.io.IOUtils;
/* loaded from: classes.dex */
public abstract class f {
    protected static String k;
    private long a;
    private Context b;
    protected StringBuffer l;
    protected String n;
    protected String o;
    protected String p;
    protected boolean e = false;
    protected boolean f = false;
    protected boolean g = false;
    protected int h = 50;
    protected int i = 0;
    protected boolean j = false;
    protected int m = 0;
    protected boolean q = false;
    protected long r = 0;
    protected BdStatFirstSwitchData s = null;

    public abstract void a(String str);

    public abstract boolean a(boolean z);

    public abstract void b(String str);

    public abstract boolean b(boolean z);

    public abstract String c();

    public abstract ArrayList<String> c(String str);

    public abstract void c(boolean z);

    public abstract boolean d();

    public abstract ArrayList<String> f();

    public f(Context context, String str) {
        this.a = 0L;
        this.b = null;
        this.b = context;
        this.o = str;
        this.a = System.currentTimeMillis();
        com.baidu.adp.lib.util.c.f(this.o);
        if (TextUtils.isEmpty(k)) {
            k = a();
        }
        this.l = new StringBuffer();
    }

    public void d(boolean z) {
        this.j = z;
    }

    public String h() {
        return this.p;
    }

    public long i() {
        return this.r;
    }

    public void a(long j) {
        this.r = j;
    }

    public boolean j() {
        return this.q;
    }

    public void e(boolean z) {
        this.q = z;
    }

    public boolean k() {
        return this.e;
    }

    public void a(s sVar) {
        if (sVar != null) {
            try {
                this.l.append(sVar.toString());
                this.l.append(IOUtils.LINE_SEPARATOR_WINDOWS);
                this.m++;
            } catch (Exception e) {
                BdLog.e(getClass(), "add", e);
            }
        }
        if (System.currentTimeMillis() - this.a > TbConfig.USE_TIME_INTERVAL) {
            h.a().a(this, true, false);
        } else {
            h.a().a(this, false, false);
        }
        this.a = System.currentTimeMillis();
    }

    public boolean l() {
        return this.m > 0 && (this.g || this.m >= 10);
    }

    public void a(BdStatFirstSwitchData bdStatFirstSwitchData) {
        if (bdStatFirstSwitchData != null) {
            this.s = bdStatFirstSwitchData;
            BdStatCommonSwitchData common = this.s.getCommon();
            if (common != null) {
                this.g = common.isIs_exact();
                this.e = common.isIs_open();
                this.f = common.isIs_only_wifi();
            }
        }
    }

    public boolean d(String str) {
        if (TextUtils.isEmpty(str) || this.s == null || this.s.getChildren() == null) {
            return true;
        }
        Iterator<BdStatSecondSwitchData> it = this.s.getChildren().iterator();
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

    public ArrayList<String> m() {
        if (this.l != null && this.l.length() > 0) {
            ArrayList<String> arrayList = new ArrayList<>();
            String[] split = this.l.toString().split(IOUtils.LINE_SEPARATOR_WINDOWS);
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

    public void n() {
        this.l = new StringBuffer(this.l.length());
        this.m = 0;
    }

    private String a() {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        if (this.b == null) {
            return null;
        }
        ActivityManager activityManager = (ActivityManager) this.b.getSystemService("activity");
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
                            String a = r.a(str.getBytes("UTF-8"));
                            if (!TextUtils.isEmpty(a) && a.length() > 8) {
                                return a.substring(a.length() - 8);
                            }
                            return a;
                        } catch (UnsupportedEncodingException e) {
                            BdLog.e(getClass(), "getProcessName", e);
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
