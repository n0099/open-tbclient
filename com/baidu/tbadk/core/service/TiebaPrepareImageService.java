package com.baidu.tbadk.core.service;

import android.app.Service;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.IBinder;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
public class TiebaPrepareImageService extends Service {
    public static volatile boolean a = false;
    private int f;
    private int g;
    private int b = 0;
    private Uri c = null;
    private h d = null;
    private final Handler e = new Handler();
    private final Runnable h = new g(this);

    public static void a(int i, Uri uri, int i2, int i3) {
        Intent intent = new Intent(TbadkApplication.m252getInst().getApp(), TiebaPrepareImageService.class);
        intent.putExtra(com.baidu.tbadk.core.frameworkData.a.REQUEST_CODE, i);
        intent.putExtra("max_size", i2);
        intent.putExtra("display_size", i3);
        intent.setData(uri);
        TbadkApplication.m252getInst().getApp().startService(intent);
    }

    public static void a(int i, Uri uri, int i2) {
        a(i, uri, i2, 0);
    }

    public static void a() {
        TbadkApplication.m252getInst().getApp().stopService(new Intent(TbadkApplication.m252getInst().getApp(), TiebaPrepareImageService.class));
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
            a(intent);
        }
    }

    private void a(Intent intent) {
        if (this.d != null) {
            this.d.cancel();
        }
        this.c = intent.getData();
        this.b = intent.getIntExtra(com.baidu.tbadk.core.frameworkData.a.REQUEST_CODE, 0);
        this.f = intent.getIntExtra("max_size", TbConfig.POST_IMAGE_MIDDLE);
        this.g = intent.getIntExtra("display_size", 0);
        TbadkApplication.m252getInst().addRemoteActivity(null);
        if (!a) {
            this.d = new h(this, this.b, this.c);
            this.d.execute(new Object[0]);
            return;
        }
        this.e.postDelayed(this.h, 1000L);
    }
}
