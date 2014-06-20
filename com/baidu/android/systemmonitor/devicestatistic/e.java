package com.baidu.android.systemmonitor.devicestatistic;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Environment;
import android.text.TextUtils;
import com.baidu.android.a.r;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
/* loaded from: classes.dex */
public final class e {
    private static e a = null;
    private BroadcastReceiver b;
    private Context c;
    private HashMap d = null;

    private e(Context context) {
        this.b = null;
        this.c = null;
        this.c = context.getApplicationContext();
        d();
        this.b = new c(this);
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

    public static synchronized e a(Context context) {
        e eVar;
        synchronized (e.class) {
            if (a == null) {
                a = new e(context);
            }
            eVar = a;
        }
        return eVar;
    }

    public static void a() {
        if (a != null) {
            a.f();
            a = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        i iVar;
        if (TextUtils.isEmpty(str) || this.d == null || (iVar = (i) this.d.remove(str)) == null) {
            return;
        }
        iVar.stopWatching();
    }

    private boolean b(String str) {
        return new File(str).exists();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if ("mounted".equals(Environment.getExternalStorageState())) {
            if (this.d == null) {
                this.d = new HashMap();
            }
            Iterator it = r.a(this.c).a().iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                if (b(str)) {
                    this.d.put(str, new i(str, this.c));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if ("mounted".equals(Environment.getExternalStorageState())) {
            if (this.d == null) {
                this.d = new HashMap();
            }
            Iterator it = r.a(this.c).a().iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                if (this.d.containsKey(str)) {
                    if (!b(str)) {
                        a(str);
                    }
                } else if (b(str)) {
                    this.d.put(str, new i(str, this.c));
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
        for (i iVar : this.d.values()) {
            iVar.startWatching();
        }
    }

    public void c() {
        if (this.d != null && this.d.size() != 0) {
            for (i iVar : this.d.values()) {
                iVar.startWatching();
            }
        }
        this.d = null;
    }
}
