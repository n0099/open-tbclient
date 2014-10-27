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
    private static final String DISPLAY_SIZE = "display_size";
    public static final String FILE_NAME = "file_name";
    public static volatile boolean IS_DECODING = false;
    private static final String MAX_SIZE = "max_size";
    private static final String REQUESTCODE = "request_code";
    private int mDisplaySize;
    private int mMaxSize;
    private int mRequestCode = 0;
    private Uri mUri = null;
    private String mFileName = null;
    private b mTask = null;
    private final Handler mHandler = new Handler();
    private final Runnable mStartRun = new a(this);

    public static void StartService(int i, Uri uri, int i2, int i3, String str) {
        Intent intent = new Intent(TbadkApplication.m251getInst().getApp(), TiebaPrepareImageService.class);
        intent.putExtra("request_code", i);
        intent.putExtra(MAX_SIZE, i2);
        intent.putExtra("display_size", i3);
        intent.putExtra("file_name", str);
        intent.setData(uri);
        TbadkApplication.m251getInst().getApp().startService(intent);
    }

    public static void StartService(int i, Uri uri, int i2, int i3) {
        Intent intent = new Intent(TbadkApplication.m251getInst().getApp(), TiebaPrepareImageService.class);
        intent.putExtra("request_code", i);
        intent.putExtra(MAX_SIZE, i2);
        intent.putExtra("display_size", i3);
        intent.setData(uri);
        TbadkApplication.m251getInst().getApp().startService(intent);
    }

    public static void StartService(int i, Uri uri, int i2) {
        StartService(i, uri, i2, 0);
    }

    public static void StopService() {
        TbadkApplication.m251getInst().getApp().stopService(new Intent(TbadkApplication.m251getInst().getApp(), TiebaPrepareImageService.class));
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
        if (this.mTask != null) {
            this.mTask.cancel();
        }
        this.mHandler.removeCallbacks(this.mStartRun);
        this.mTask = null;
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
        if (intent != null) {
            startPrepareImage(intent);
        }
    }

    private void startPrepareImage(Intent intent) {
        if (this.mTask != null) {
            this.mTask.cancel();
        }
        this.mUri = intent.getData();
        this.mFileName = intent.getStringExtra("file_name");
        this.mRequestCode = intent.getIntExtra("request_code", 0);
        this.mMaxSize = intent.getIntExtra(MAX_SIZE, TbConfig.POST_IMAGE_MIDDLE);
        this.mDisplaySize = intent.getIntExtra("display_size", 0);
        TbadkApplication.m251getInst().addRemoteActivity(null);
        if (!IS_DECODING) {
            this.mTask = new b(this, this.mRequestCode, this.mUri, this.mFileName);
            this.mTask.execute(new Object[0]);
            return;
        }
        this.mHandler.postDelayed(this.mStartRun, 1000L);
    }
}
