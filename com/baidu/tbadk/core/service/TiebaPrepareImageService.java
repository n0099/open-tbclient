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
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tieba.R;
import d.a.i0.z0.p0;
/* loaded from: classes3.dex */
public class TiebaPrepareImageService extends BdBaseService {
    public static final String DISPLAY_SIZE = "display_size";
    public static final String FILE_NAME = "file_name";
    public static volatile boolean IS_DECODING = false;
    public static final String MAX_SIZE = "max_size";
    public static final String REQUESTCODE = "request_code";
    public int mDisplaySize;
    public int mMaxSize;
    public int mRequestCode = 0;
    public Uri mUri = null;
    public String mFileName = null;
    public b mTask = null;
    public final Handler mHandler = new Handler();
    public final Runnable mStartRun = new a();

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (TiebaPrepareImageService.IS_DECODING) {
                TiebaPrepareImageService.this.mHandler.postDelayed(TiebaPrepareImageService.this.mStartRun, 1000L);
                return;
            }
            TiebaPrepareImageService tiebaPrepareImageService = TiebaPrepareImageService.this;
            TiebaPrepareImageService tiebaPrepareImageService2 = TiebaPrepareImageService.this;
            tiebaPrepareImageService.mTask = new b(tiebaPrepareImageService2.mRequestCode, TiebaPrepareImageService.this.mUri, TiebaPrepareImageService.this.mFileName);
            TiebaPrepareImageService.this.mTask.execute(new Object[0]);
        }
    }

    /* loaded from: classes3.dex */
    public class b extends BdAsyncTask<Object, Integer, Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public int f12893a;

        /* renamed from: b  reason: collision with root package name */
        public Uri f12894b;

        /* renamed from: c  reason: collision with root package name */
        public String f12895c;

        /* renamed from: d  reason: collision with root package name */
        public String f12896d = null;

        public b(int i2, Uri uri, String str) {
            this.f12893a = 0;
            this.f12894b = null;
            this.f12895c = null;
            this.f12893a = i2;
            this.f12894b = uri;
            this.f12895c = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Boolean doInBackground(Object... objArr) {
            Bitmap c2;
            boolean z = true;
            TiebaPrepareImageService.IS_DECODING = true;
            boolean z2 = false;
            try {
                c2 = p0.c(this.f12893a, TiebaPrepareImageService.this, this.f12894b, this.f12895c, TiebaPrepareImageService.this.mMaxSize);
            } catch (Exception unused) {
                TiebaPrepareImageService.IS_DECODING = false;
            } catch (Throwable th) {
                TiebaPrepareImageService.IS_DECODING = false;
                throw th;
            }
            if (c2 != null) {
                if (FileHelper.SaveFile(null, TbConfig.IMAGE_RESIZED_FILE, c2, 85) != null) {
                    Bitmap resizeBitmap = BitmapHelper.resizeBitmap(c2, TiebaPrepareImageService.this.mDisplaySize > 0 ? TiebaPrepareImageService.this.mDisplaySize : 100);
                    if (resizeBitmap == null || FileHelper.SaveFile(null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY, resizeBitmap, 85) == null) {
                        this.f12896d = TiebaPrepareImageService.this.getString(R.string.error_sd_error);
                    } else {
                        TiebaPrepareImageService.IS_DECODING = false;
                        z2 = z;
                        return Boolean.valueOf(z2);
                    }
                } else {
                    this.f12896d = TiebaPrepareImageService.this.getString(R.string.error_sd_error);
                }
            } else {
                this.f12896d = TiebaPrepareImageService.this.getString(R.string.pic_parser_error);
            }
            z = false;
            TiebaPrepareImageService.IS_DECODING = false;
            z2 = z;
            return Boolean.valueOf(z2);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            TiebaPrepareImageService.this.mTask = null;
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            super.onPostExecute((b) bool);
            Intent intent = new Intent(TbConfig.getBroadcastActionImageResized());
            intent.putExtra("result", bool);
            String str = this.f12896d;
            if (str != null) {
                intent.putExtra("error", str);
            }
            TiebaPrepareImageService.this.sendBroadcast(intent);
        }
    }

    public static void StartService(int i2, Uri uri, int i3, int i4, String str) {
        Intent intent = new Intent(TbadkCoreApplication.getInst().getApp(), TiebaPrepareImageService.class);
        intent.putExtra("request_code", i2);
        intent.putExtra(MAX_SIZE, i3);
        intent.putExtra("display_size", i4);
        intent.putExtra("file_name", str);
        intent.setData(uri);
        TbadkCoreApplication.getInst().getApp().startService(intent);
    }

    public static void StopService() {
        TbadkCoreApplication.getInst().getApp().stopService(new Intent(TbadkCoreApplication.getInst().getApp(), TiebaPrepareImageService.class));
    }

    private void startPrepareImage(Intent intent) {
        b bVar = this.mTask;
        if (bVar != null) {
            bVar.cancel();
        }
        this.mUri = intent.getData();
        this.mFileName = intent.getStringExtra("file_name");
        this.mRequestCode = intent.getIntExtra("request_code", 0);
        this.mMaxSize = intent.getIntExtra(MAX_SIZE, 1800);
        this.mDisplaySize = intent.getIntExtra("display_size", 0);
        TbadkCoreApplication.getInst().addRemoteActivity(null);
        if (!IS_DECODING) {
            b bVar2 = new b(this.mRequestCode, this.mUri, this.mFileName);
            this.mTask = bVar2;
            bVar2.execute(new Object[0]);
            return;
        }
        this.mHandler.postDelayed(this.mStartRun, 1000L);
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
        b bVar = this.mTask;
        if (bVar != null) {
            bVar.cancel();
        }
        this.mHandler.removeCallbacks(this.mStartRun);
        this.mTask = null;
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i2) {
        super.onStart(intent, i2);
        if (intent != null) {
            startPrepareImage(intent);
        }
    }

    public static void StartService(int i2, Uri uri, int i3, int i4) {
        Intent intent = new Intent(TbadkCoreApplication.getInst().getApp(), TiebaPrepareImageService.class);
        intent.putExtra("request_code", i2);
        intent.putExtra(MAX_SIZE, i3);
        intent.putExtra("display_size", i4);
        intent.setData(uri);
        TbadkCoreApplication.getInst().getApp().startService(intent);
    }

    public static void StartService(int i2, Uri uri, int i3) {
        StartService(i2, uri, i3, 0);
    }
}
