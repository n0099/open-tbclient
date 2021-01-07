package com.baidu.mobads.utils;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.baidu.mobads.openad.interfaces.download.IOAdDownloader;
import java.io.File;
import java.net.URL;
import java.util.Observable;
import java.util.Observer;
/* loaded from: classes3.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    private static long f3537a = 30000000;

    /* renamed from: b  reason: collision with root package name */
    private Context f3538b;

    public i(Context context) {
        this.f3538b = context;
    }

    public static void a(int i) {
        f3537a = i * 1000 * 1000;
    }

    public void a(String str) {
        new Thread(new j(this, str)).start();
    }

    public static String a(Context context) {
        return context.getFilesDir().getPath() + File.separator + "__bidu_cache_dir" + File.separator;
    }

    public static String b(String str) {
        return XAdSDKFoundationFacade.getInstance().getCommonUtils().md5(str);
    }

    public static String a(Context context, String str) {
        File file = new File(b(context, str + "ad_360_unzip"));
        if (!file.exists()) {
            file.mkdirs();
        }
        if (file.listFiles() != null && file.listFiles().length > 0) {
            for (File file2 : file.listFiles()) {
                file2.delete();
            }
        }
        return file.getAbsolutePath();
    }

    public static String b(Context context, String str) {
        return a(context) + b(str);
    }

    public void a(Context context, String str, String str2, String str3, Handler handler) {
        try {
            File file = new File(b(context, str));
            if (!file.exists()) {
                a(handler, false);
                IOAdDownloader createSimpleFileDownloader = com.baidu.mobads.openad.b.d.a(this.f3538b).createSimpleFileDownloader(new URL(str), str2, str3, false);
                createSimpleFileDownloader.addObserver(new a(handler, str2));
                createSimpleFileDownloader.start();
            } else {
                a(handler, true);
                a(handler, file.getAbsolutePath(), -1L);
                file.setLastModified(System.currentTimeMillis());
            }
        } catch (Exception e) {
            e.printStackTrace();
            a(handler, -1L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Handler handler, String str, long j) {
        a(handler, (Boolean) true, str, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Handler handler, long j) {
        a(handler, (Boolean) false, (String) null, j);
    }

    private void a(Handler handler, boolean z) {
        try {
            Message obtainMessage = handler.obtainMessage();
            obtainMessage.what = 1;
            Bundle bundle = new Bundle();
            bundle.putBoolean("caching_file_exist", z);
            obtainMessage.setData(bundle);
            handler.sendMessage(obtainMessage);
        } catch (Exception e) {
            m.a().d(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Handler handler, Boolean bool, String str, long j) {
        try {
            Message obtainMessage = handler.obtainMessage();
            obtainMessage.what = 0;
            Bundle bundle = new Bundle();
            bundle.putBoolean("caching_result", bool.booleanValue());
            bundle.putLong("caching_time_consume", j);
            bundle.putString("local_creative_url", str);
            obtainMessage.setData(bundle);
            handler.sendMessage(obtainMessage);
        } catch (Exception e) {
            m.a().d(e);
        }
    }

    public void c(String str) {
        try {
            File file = new File(str);
            if (file.exists()) {
                file.setLastModified(System.currentTimeMillis());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* loaded from: classes3.dex */
    class a implements Observer {

        /* renamed from: b  reason: collision with root package name */
        private final Handler f3540b;
        private final String c;
        private long d = System.currentTimeMillis();

        public a(Handler handler, String str) {
            this.f3540b = handler;
            this.c = str;
        }

        @Override // java.util.Observer
        public void update(Observable observable, Object obj) {
            IOAdDownloader iOAdDownloader = (IOAdDownloader) observable;
            long currentTimeMillis = System.currentTimeMillis() - this.d;
            if (iOAdDownloader.getState() == IOAdDownloader.DownloadStatus.COMPLETED) {
                i.this.c(iOAdDownloader.getOutputPath());
                i.this.a(this.f3540b, iOAdDownloader.getOutputPath(), currentTimeMillis);
                i.this.a(this.c);
            }
            if (iOAdDownloader.getState() == IOAdDownloader.DownloadStatus.ERROR) {
                i.this.a(this.f3540b, (Boolean) false, (String) null, currentTimeMillis);
                i.this.a(this.f3540b, currentTimeMillis);
                i.this.a(this.c);
            }
        }
    }
}
