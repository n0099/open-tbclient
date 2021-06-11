package com.baidu.adp.titan;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import androidx.annotation.Nullable;
import d.a.c.j.f;
import d.a.c.j.h;
import d.a.c.j.i;
/* loaded from: classes.dex */
public class TitanDownloadService extends Service {
    public static final boolean DEBUG = true;
    public static final String TAG = "Titan";
    public Context mContext;
    public final String pkgName = "com.baidu.titan.patch";

    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f2265e;

        public a(f fVar) {
            this.f2265e = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            i.f(TitanDownloadService.this.mContext, "com.baidu.titan.patch", this.f2265e);
        }
    }

    /* loaded from: classes.dex */
    public class b implements f {

        /* renamed from: a  reason: collision with root package name */
        public int f2267a;

        public b(int i2) {
            this.f2267a = i2;
        }

        @Override // d.a.c.j.f
        public void a(String str, int i2, String str2) {
            if (i2 == -1) {
                Log.d(TitanDownloadService.TAG, "onResult: -1");
            } else if (i2 == 0) {
                Log.d(TitanDownloadService.TAG, "onResult: 0");
            }
            TitanDownloadService.this.stopSelf(this.f2267a);
        }
    }

    public static void startServiceIfNeeded(Context context) {
        Log.d(TAG, "start service");
        h d2 = h.d();
        d2.g();
        if (d2.e() == 0) {
            Log.d(TAG, "startServiceIfNeeded last update time = 0");
            d2.i(System.currentTimeMillis());
            d2.k();
            return;
        }
        long abs = Math.abs(System.currentTimeMillis() - d2.e());
        Log.d(TAG, "startServiceIfNeeded interval = " + abs);
        try {
            Log.d(TAG, "start service");
            context.startService(new Intent(context, TitanDownloadService.class));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        this.mContext = getApplicationContext();
        new Thread(new a(new b(i3)), "titan_sandbox_downloader").start();
        return super.onStartCommand(intent, i2, i3);
    }
}
