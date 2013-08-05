package com.baidu.android.systemmonitor.devicestatistic;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Environment;
import android.text.TextUtils;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static a f679a = null;
    private BroadcastReceiver b;
    private Context c;
    private HashMap d = null;

    private a(Context context) {
        this.b = null;
        this.c = null;
        this.c = context.getApplicationContext();
        d();
        this.b = new g(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.MEDIA_UNMOUNTED");
        intentFilter.addAction("android.intent.action.MEDIA_MOUNTED");
        intentFilter.addDataScheme("file");
        intentFilter.addCategory("android.intent.category.DEFAULT");
        IntentFilter intentFilter2 = new IntentFilter();
        intentFilter2.addAction("com.baidu.moplus.systemmonitor.pathdeleted");
        intentFilter2.addAction("com.baidu.moplus.systemmonitor.pathrefresh");
        this.c.registerReceiver(this.b, intentFilter);
        this.c.registerReceiver(this.b, intentFilter2);
    }

    public static synchronized a a(Context context) {
        a aVar;
        synchronized (a.class) {
            if (f679a == null) {
                f679a = new a(context);
            }
            aVar = f679a;
        }
        return aVar;
    }

    public static void a() {
        if (f679a != null) {
            f679a.f();
            f679a = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        h hVar;
        if (TextUtils.isEmpty(str) || this.d == null || (hVar = (h) this.d.remove(str)) == null) {
            return;
        }
        hVar.stopWatching();
    }

    private boolean b(String str) {
        return new File(str).exists();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {
            if (this.d == null) {
                this.d = new HashMap();
            }
            Iterator it = com.baidu.android.systemmonitor.a.a.i.a(this.c).a().iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                if (b(str)) {
                    this.d.put(str, new h(str, this.c));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {
            if (this.d == null) {
                this.d = new HashMap();
            }
            Iterator it = com.baidu.android.systemmonitor.a.a.i.a(this.c).a().iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                if (this.d.containsKey(str)) {
                    if (!b(str)) {
                        a(str);
                    }
                } else if (b(str)) {
                    this.d.put(str, new h(str, this.c));
                }
            }
        }
    }

    private void f() {
        if (this.b != null) {
            this.c.unregisterReceiver(this.b);
        }
        this.b = null;
        c();
    }

    public void b() {
        if (this.d == null || this.d.size() == 0) {
            return;
        }
        for (h hVar : this.d.values()) {
            hVar.startWatching();
        }
    }

    public void c() {
        if (this.d != null && this.d.size() != 0) {
            for (h hVar : this.d.values()) {
                hVar.startWatching();
            }
        }
        this.d = null;
    }
}
