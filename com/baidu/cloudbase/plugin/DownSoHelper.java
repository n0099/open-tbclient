package com.baidu.cloudbase.plugin;

import a.a.a.d.a.shuoy;
import a.a.a.d.bv;
import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import d.b.k.d.b;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class DownSoHelper {

    /* renamed from: a  reason: collision with root package name */
    public Context f4630a;

    /* renamed from: b  reason: collision with root package name */
    public List<b> f4631b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, Integer> f4632c = new HashMap();

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static DownSoHelper f4633a = new DownSoHelper();
    }

    public static DownSoHelper k(Context context) {
        a.f4633a.f4630a = context.getApplicationContext();
        return a.f4633a;
    }

    public final void e(b bVar, String str, int i, String str2) {
        this.f4632c.put(str, 2);
        if (bVar != null) {
            bVar.onDownloadFail(str, i, str2);
        }
        if (this.f4631b != null) {
            for (int i2 = 0; i2 < this.f4631b.size(); i2++) {
                this.f4631b.get(i2).onDownloadFail(str, i, str2);
            }
        }
    }

    public final void f(b bVar, String str, float f2) {
        if (bVar != null) {
            bVar.onDownloadProgress(f2);
        }
        if (this.f4631b != null) {
            for (int i = 0; i < this.f4631b.size(); i++) {
                this.f4631b.get(i).onDownloadProgress(f2);
            }
        }
    }

    public final void g(b bVar, String str) {
        if (bVar != null) {
            bVar.onDownloadStart(str);
        }
        if (this.f4631b != null) {
            for (int i = 0; i < this.f4631b.size(); i++) {
                this.f4631b.get(i).onDownloadStart(str);
            }
        }
    }

    public final void h(b bVar, String str, String str2) {
        this.f4632c.put(str, 3);
        if (bVar != null) {
            bVar.onDownloadSuccess(str, str2);
        }
        if (this.f4631b != null) {
            for (int i = 0; i < this.f4631b.size(); i++) {
                this.f4631b.get(i).onDownloadSuccess(str, str2);
            }
        }
    }

    public final void i(String str, String str2, Looper looper, b bVar) {
        if (!m(str)) {
            d.b.k.e.a.a(new File(str2));
        }
        File file = new File(str2);
        if (!file.exists()) {
            file.mkdirs();
        }
        this.f4632c.put(str, 1);
        String d2 = d.b.k.d.a.d(this.f4630a, str, str2);
        File file2 = new File(d2 + ".temp");
        File file3 = new File(d2 + ".zip");
        Log.d("RtcDownSo", "start down folder=" + str2 + "name=" + file2.getName());
        d.b.k.b.a.i().h(str, str2, file2.getName(), looper, new bv(this, bVar, str, file2, file3, d2));
    }

    public void j(@NonNull String str, boolean z, b bVar) {
        String b2 = d.b.k.d.a.b(this.f4630a);
        if (TextUtils.isEmpty(str)) {
            bVar.onDownloadFail(str, 108, "download url is empty.");
        } else if (l(str, b2)) {
            if (bVar != null) {
                bVar.onDownloadSuccess(str, d.b.k.d.a.d(this.f4630a, str, b2));
            }
        } else {
            if (z) {
                if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
                    Looper.prepare();
                    Log.d("RtcDownSo", "start down so sub thread");
                    i(str, b2, Looper.myLooper(), bVar);
                    Looper.loop();
                    return;
                }
                Log.d("RtcDownSo", "start down so main thread");
            }
            i(str, b2, Looper.getMainLooper(), bVar);
        }
    }

    public boolean l(@NonNull String str, String str2) {
        return d.b.k.d.a.i(this.f4630a, str, str2);
    }

    public final boolean m(String str) {
        return d.b.k.b.a.i().l(str);
    }

    public boolean n(@NonNull String str) {
        File file = new File(str);
        if (file.exists()) {
            Context context = this.f4630a;
            if (context == null ? false : shuoy.a().b(context, file)) {
                return true;
            }
            try {
                shuoy.a().a(this.f4630a, file);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            Context context2 = this.f4630a;
            if (context2 == null) {
                return false;
            }
            return shuoy.a().b(context2, file);
        }
        return false;
    }

    public void o(String str) {
        d.b.k.d.a.k(str);
    }
}
