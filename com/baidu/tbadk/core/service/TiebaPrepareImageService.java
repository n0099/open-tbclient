package com.baidu.tbadk.core.service;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.IBinder;
import com.baidu.adp.base.BdBaseService;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.util.r;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class TiebaPrepareImageService extends BdBaseService {
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
    private a mTask = null;
    private final Handler mHandler = new Handler();
    private final Runnable mStartRun = new com.baidu.tbadk.core.service.a(this);

    public static void StartService(int i, Uri uri, int i2, int i3, String str) {
        Intent intent = new Intent(TbadkCoreApplication.m411getInst().getApp(), TiebaPrepareImageService.class);
        intent.putExtra("request_code", i);
        intent.putExtra(MAX_SIZE, i2);
        intent.putExtra("display_size", i3);
        intent.putExtra("file_name", str);
        intent.setData(uri);
        TbadkCoreApplication.m411getInst().getApp().startService(intent);
    }

    public static void StartService(int i, Uri uri, int i2, int i3) {
        Intent intent = new Intent(TbadkCoreApplication.m411getInst().getApp(), TiebaPrepareImageService.class);
        intent.putExtra("request_code", i);
        intent.putExtra(MAX_SIZE, i2);
        intent.putExtra("display_size", i3);
        intent.setData(uri);
        TbadkCoreApplication.m411getInst().getApp().startService(intent);
    }

    public static void StartService(int i, Uri uri, int i2) {
        StartService(i, uri, i2, 0);
    }

    public static void StopService() {
        TbadkCoreApplication.m411getInst().getApp().stopService(new Intent(TbadkCoreApplication.m411getInst().getApp(), TiebaPrepareImageService.class));
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // com.baidu.adp.base.BdBaseService, android.app.Service
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
        TbadkCoreApplication.m411getInst().addRemoteActivity(null);
        if (!IS_DECODING) {
            this.mTask = new a(this.mRequestCode, this.mUri, this.mFileName);
            this.mTask.execute(new Object[0]);
            return;
        }
        this.mHandler.postDelayed(this.mStartRun, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Object, Integer, Boolean> {
        String ZL = null;
        String mFileName;
        int mRequestCode;
        Uri mUri;

        public a(int i, Uri uri, String str) {
            this.mRequestCode = 0;
            this.mUri = null;
            this.mFileName = null;
            this.mRequestCode = i;
            this.mUri = uri;
            this.mFileName = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: f */
        public Boolean doInBackground(Object... objArr) {
            boolean z = true;
            TiebaPrepareImageService.IS_DECODING = true;
            try {
                Bitmap a = r.a(this.mRequestCode, TiebaPrepareImageService.this, this.mUri, this.mFileName, TiebaPrepareImageService.this.mMaxSize);
                if (a != null) {
                    if (m.b(null, TbConfig.IMAGE_RESIZED_FILE, a, 80) != null) {
                        int i = 100;
                        if (TiebaPrepareImageService.this.mDisplaySize > 0) {
                            i = TiebaPrepareImageService.this.mDisplaySize;
                        }
                        Bitmap resizeBitmap = BitmapHelper.resizeBitmap(a, i);
                        if (resizeBitmap == null || m.b(null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY, resizeBitmap, 80) == null) {
                            this.ZL = TiebaPrepareImageService.this.getString(t.j.error_sd_error);
                            z = false;
                        }
                    } else {
                        this.ZL = TiebaPrepareImageService.this.getString(t.j.error_sd_error);
                        z = false;
                    }
                } else {
                    this.ZL = TiebaPrepareImageService.this.getString(t.j.pic_parser_error);
                    z = false;
                }
                TiebaPrepareImageService.IS_DECODING = false;
            } catch (Exception e) {
                TiebaPrepareImageService.IS_DECODING = false;
                z = false;
            } catch (Throwable th) {
                TiebaPrepareImageService.IS_DECODING = false;
                throw th;
            }
            return Boolean.valueOf(z);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            TiebaPrepareImageService.this.mTask = null;
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(Boolean bool) {
            super.onPostExecute(bool);
            Intent intent = new Intent(TbConfig.getBroadcastActionImageResized());
            intent.putExtra("result", bool);
            if (this.ZL != null) {
                intent.putExtra("error", this.ZL);
            }
            TiebaPrepareImageService.this.sendBroadcast(intent);
        }
    }
}
