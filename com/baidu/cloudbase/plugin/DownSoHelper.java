package com.baidu.cloudbase.plugin;

import a.a.a.d.a.shuoy;
import a.a.a.d.bv;
import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.mobads.container.util.XAdSimpleImageLoader;
import d.a.k.d.b;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class DownSoHelper {

    /* renamed from: a  reason: collision with root package name */
    public Context f4632a;

    /* renamed from: b  reason: collision with root package name */
    public List<b> f4633b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, Integer> f4634c = new HashMap();

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static DownSoHelper f4635a = new DownSoHelper();
    }

    public static DownSoHelper k(Context context) {
        a.f4635a.f4632a = context.getApplicationContext();
        return a.f4635a;
    }

    public final void e(b bVar, String str, int i2, String str2) {
        this.f4634c.put(str, 2);
        if (bVar != null) {
            bVar.onDownloadFail(str, i2, str2);
        }
        if (this.f4633b != null) {
            for (int i3 = 0; i3 < this.f4633b.size(); i3++) {
                this.f4633b.get(i3).onDownloadFail(str, i2, str2);
            }
        }
    }

    public final void f(b bVar, String str, float f2) {
        if (bVar != null) {
            bVar.onDownloadProgress(f2);
        }
        if (this.f4633b != null) {
            for (int i2 = 0; i2 < this.f4633b.size(); i2++) {
                this.f4633b.get(i2).onDownloadProgress(f2);
            }
        }
    }

    public final void g(b bVar, String str) {
        if (bVar != null) {
            bVar.onDownloadStart(str);
        }
        if (this.f4633b != null) {
            for (int i2 = 0; i2 < this.f4633b.size(); i2++) {
                this.f4633b.get(i2).onDownloadStart(str);
            }
        }
    }

    public final void h(b bVar, String str, String str2) {
        this.f4634c.put(str, 3);
        if (bVar != null) {
            bVar.onDownloadSuccess(str, str2);
        }
        if (this.f4633b != null) {
            for (int i2 = 0; i2 < this.f4633b.size(); i2++) {
                this.f4633b.get(i2).onDownloadSuccess(str, str2);
            }
        }
    }

    public final void i(String str, String str2, Looper looper, b bVar) {
        if (!m(str)) {
            d.a.k.e.a.a(new File(str2));
        }
        File file = new File(str2);
        if (!file.exists()) {
            file.mkdirs();
        }
        this.f4634c.put(str, 1);
        String d2 = d.a.k.d.a.d(this.f4632a, str, str2);
        File file2 = new File(d2 + XAdSimpleImageLoader.TEMP_SUFFIX);
        File file3 = new File(d2 + ".zip");
        Log.d("RtcDownSo", "start down folder=" + str2 + "name=" + file2.getName());
        d.a.k.b.a.i().h(str, str2, file2.getName(), looper, new bv(this, bVar, str, file2, file3, d2));
    }

    public void j(@NonNull String str, boolean z, b bVar) {
        String b2 = d.a.k.d.a.b(this.f4632a);
        if (TextUtils.isEmpty(str)) {
            bVar.onDownloadFail(str, 108, "download url is empty.");
        } else if (l(str, b2)) {
            if (bVar != null) {
                bVar.onDownloadSuccess(str, d.a.k.d.a.d(this.f4632a, str, b2));
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
        return d.a.k.d.a.i(this.f4632a, str, str2);
    }

    public final boolean m(String str) {
        return d.a.k.b.a.i().l(str);
    }

    public boolean n(@NonNull String str) {
        File file = new File(str);
        if (file.exists()) {
            Context context = this.f4632a;
            if (context == null ? false : shuoy.a().b(context, file)) {
                return true;
            }
            try {
                shuoy.a().a(this.f4632a, file);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            Context context2 = this.f4632a;
            if (context2 == null) {
                return false;
            }
            return shuoy.a().b(context2, file);
        }
        return false;
    }

    public void o(String str) {
        d.a.k.d.a.k(str);
    }
}
