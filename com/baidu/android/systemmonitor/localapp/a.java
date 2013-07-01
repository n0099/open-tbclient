package com.baidu.android.systemmonitor.localapp;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.baidu.android.systemmonitor.a.c;
import com.baidu.android.systemmonitor.security.md5.MD5;
import java.io.File;
import java.io.IOException;
/* loaded from: classes.dex */
public class a implements Comparable {

    /* renamed from: a  reason: collision with root package name */
    public static final String f429a = a.class.getSimpleName();
    public String b;
    public String d;
    public long e;
    public int f;
    private String j;
    private String n;
    private String o;
    private String p;
    private String q;
    private boolean k = false;
    private String l = "";
    private String m = "";
    public int c = 0;
    public boolean g = false;
    private String r = "";
    private long s = -1;
    private int t = 0;
    private String u = "";
    public boolean h = false;
    public int i = 0;
    private String v = "";

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(a aVar) {
        boolean z = this.o != null && this.o.equals(aVar.o);
        boolean z2 = this.f == aVar.f;
        boolean z3 = this.q != null && this.q.equals(aVar.q);
        if (z) {
            return (z2 && z3) ? 0 : 1;
        }
        return -1;
    }

    public String a() {
        return this.o;
    }

    public String a(Context context) {
        PackageInfo b;
        if (TextUtils.isEmpty(this.j) && (b = c.b(context, this.o)) != null) {
            c((String) b.applicationInfo.loadLabel(context.getPackageManager()));
        }
        return this.j;
    }

    public void a(long j) {
        this.s = j;
    }

    public void a(String str) {
        this.v = str;
    }

    public void a(boolean z) {
        this.k = z;
    }

    public String b(Context context) {
        if (TextUtils.isEmpty(this.q)) {
            PackageInfo b = c.b(context, this.o);
            if (b != null) {
                this.q = c.a(c.b(b.signatures[0].toCharsString().getBytes()));
            } else {
                this.q = "";
            }
        }
        return this.q;
    }

    public void b(String str) {
        this.p = str;
    }

    public String c(Context context) {
        if (TextUtils.isEmpty(this.l)) {
            File file = new File(this.v);
            if (!file.exists()) {
                c.c(context, this.o);
            }
            try {
                this.l = MD5.a(MD5.a(file));
            } catch (IOException e) {
            }
        }
        return this.l;
    }

    public void c(String str) {
        this.j = str;
    }

    public void d(String str) {
        this.n = str;
    }

    public void e(String str) {
        this.o = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[").append("[key=").append(this.n).append("]appname=").append(this.j).append("]packagename=").append(this.o).append("]versionname=").append(this.b).append("]versioncode=").append(this.f).append("]signmd5=").append(this.q).append("[mUpdatebleDate=").append("[mFilePath=").append(this.d).append("]serversignmd5=").append("]downloadType=").append(this.m).append("]mIsSilentInstalling=").append("]mApksize=").append(this.p).append("]mInstalledApkDir=").append(this.v).append("]md5=").append(this.l).append("]]");
        return sb.toString();
    }
}
