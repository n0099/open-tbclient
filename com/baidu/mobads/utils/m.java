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
/* loaded from: classes2.dex */
public class m {

    /* renamed from: a  reason: collision with root package name */
    public static long f8545a = 30000000;

    /* renamed from: b  reason: collision with root package name */
    public Context f8546b;

    /* loaded from: classes2.dex */
    public class a implements Observer {

        /* renamed from: b  reason: collision with root package name */
        public final Handler f8548b;

        /* renamed from: c  reason: collision with root package name */
        public final String f8549c;

        /* renamed from: d  reason: collision with root package name */
        public long f8550d = System.currentTimeMillis();

        public a(Handler handler, String str) {
            this.f8548b = handler;
            this.f8549c = str;
        }

        @Override // java.util.Observer
        public void update(Observable observable, Object obj) {
            IOAdDownloader iOAdDownloader = (IOAdDownloader) observable;
            long currentTimeMillis = System.currentTimeMillis() - this.f8550d;
            if (iOAdDownloader.getState() == IOAdDownloader.DownloadStatus.COMPLETED) {
                m.this.c(iOAdDownloader.getOutputPath());
                m.this.a(this.f8548b, iOAdDownloader.getOutputPath(), currentTimeMillis);
                m.this.a(this.f8549c);
            }
            if (iOAdDownloader.getState() == IOAdDownloader.DownloadStatus.ERROR) {
                m.this.a(this.f8548b, Boolean.FALSE, (String) null, currentTimeMillis);
                m.this.a(this.f8549c);
            }
        }
    }

    public m(Context context) {
        this.f8546b = context;
    }

    public static String b(String str) {
        return XAdSDKFoundationFacade.getInstance().getCommonUtils().md5(str);
    }

    public void c(String str) {
        try {
            File file = new File(str);
            if (file.exists()) {
                file.setLastModified(System.currentTimeMillis());
            }
        } catch (Exception unused) {
        }
    }

    public static void a(int i) {
        f8545a = i * 1000 * 1000;
    }

    public void a(String str) {
        com.baidu.mobads.f.c.a().a((com.baidu.mobads.f.a) new n(this, str));
    }

    public static String a(Context context) {
        return context.getFilesDir().getPath() + File.separator + "__bidu_cache_dir" + File.separator;
    }

    public static String a(Context context, String str) {
        return a(context) + b(str);
    }

    public void a(Context context, String str, String str2, String str3, Handler handler) {
        try {
            File file = new File(a(context, str));
            if (!file.exists()) {
                a(handler, false);
                IOAdDownloader createSimpleFileDownloader = com.baidu.mobads.openad.download.a.a(this.f8546b).createSimpleFileDownloader(new URL(str), str2, str3, false);
                createSimpleFileDownloader.addObserver(new a(handler, str2));
                createSimpleFileDownloader.start();
            } else {
                a(handler, true);
                a(handler, file.getAbsolutePath(), -1L);
                file.setLastModified(System.currentTimeMillis());
            }
        } catch (Exception unused) {
            a(handler, -1L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Handler handler, String str, long j) {
        a(handler, Boolean.TRUE, str, j);
    }

    private void a(Handler handler, long j) {
        a(handler, Boolean.FALSE, (String) null, j);
    }

    private void a(Handler handler, boolean z) {
        try {
            Message obtainMessage = handler.obtainMessage();
            obtainMessage.what = 1;
            Bundle bundle = new Bundle();
            bundle.putBoolean("caching_file_exist", z);
            obtainMessage.setData(bundle);
            handler.sendMessage(obtainMessage);
        } catch (Exception e2) {
            q.a().d(e2);
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
        } catch (Exception e2) {
            q.a().d(e2);
        }
    }
}
