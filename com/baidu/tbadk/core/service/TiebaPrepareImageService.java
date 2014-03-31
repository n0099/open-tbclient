package com.baidu.tbadk.core.service;

import android.app.Service;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.IBinder;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
public class TiebaPrepareImageService extends Service {
    public static volatile boolean a = false;
    private int f;
    private int g;
    private int b = 0;
    private Uri c = null;
    private c d = null;
    private final Handler e = new Handler();
    private final Runnable h = new b(this);

    public static void a(int i, Uri uri, int i2, int i3) {
        Intent intent = new Intent(TbadkApplication.j().b(), TiebaPrepareImageService.class);
        intent.putExtra("request_code", i);
        intent.putExtra("max_size", i2);
        intent.putExtra("display_size", i3);
        intent.setData(uri);
        TbadkApplication.j().b().startService(intent);
    }

    public static void a(int i, Uri uri, int i2) {
        a(i, uri, i2, 0);
    }

    public static void a() {
        TbadkApplication.j().b().stopService(new Intent(TbadkApplication.j().b(), TiebaPrepareImageService.class));
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        if (this.d != null) {
            this.d.cancel();
        }
        this.e.removeCallbacks(this.h);
        this.d = null;
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
        if (intent != null) {
            if (this.d != null) {
                this.d.cancel();
            }
            this.c = intent.getData();
            this.b = intent.getIntExtra("request_code", 0);
            this.f = intent.getIntExtra("max_size", 750);
            this.g = intent.getIntExtra("display_size", 0);
            TbadkApplication.j().a((com.baidu.tbadk.a) null);
            if (a) {
                this.e.postDelayed(this.h, 1000L);
                return;
            }
            this.d = new c(this, this.b, this.c);
            this.d.execute(new Object[0]);
        }
    }
}
