package com.baidu.mobads.openad.b;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;
import com.baidu.mobads.AppActivity;
import com.baidu.mobads.interfaces.download.activate.IXAppInfo;
import com.baidu.mobads.openad.interfaces.download.IOAdDownloader;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import com.baidu.mobads.utils.m;
import com.baidu.mobads.utils.p;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Observable;
import java.util.Observer;
/* loaded from: classes8.dex */
public class b implements Observer {
    private static NotificationManager a;
    private static int b = 10091;
    private static HashMap<String, b> g = new HashMap<>();
    private com.baidu.mobads.command.a c;
    private Context d;
    private com.baidu.mobads.b.b e = null;
    private String f = "";
    private Handler h = new Handler(Looper.getMainLooper());

    public com.baidu.mobads.command.a a() {
        return this.c;
    }

    public static synchronized b a(String str) {
        b bVar;
        synchronized (b.class) {
            bVar = g.get(str);
        }
        return bVar;
    }

    public static synchronized b b(String str) {
        b remove;
        synchronized (b.class) {
            remove = g.remove(str);
        }
        return remove;
    }

    public static synchronized void a(String str, b bVar) {
        synchronized (b.class) {
            g.put(str, bVar);
        }
    }

    public static synchronized int c(String str) {
        int i;
        synchronized (b.class) {
            b bVar = g.get(str);
            if (bVar == null || bVar.a() == null) {
                i = b;
                b = i + 1;
            } else {
                i = bVar.a().f;
            }
        }
        return i;
    }

    public b(Context context, com.baidu.mobads.command.a aVar) {
        this.c = null;
        XAdSDKFoundationFacade.getInstance().getAdLogger().d("OAdApkDownloaderObserver", "observer created");
        if (a == null) {
            a = (NotificationManager) context.getSystemService("notification");
        }
        this.d = context.getApplicationContext();
        this.c = aVar;
        a(this.c.i, this);
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        int progress;
        IOAdDownloader iOAdDownloader = (IOAdDownloader) observable;
        this.c.g = iOAdDownloader.getState();
        String fileName = XAdSDKFoundationFacade.getInstance().getURIUitls().getFileName(iOAdDownloader.getOutputPath());
        if (!this.c.b.equals(fileName)) {
            this.c.b = fileName;
        }
        if (this.c.g == IOAdDownloader.DownloadStatus.DOWNLOADING) {
            if (this.c.d < 0) {
                XAdSDKFoundationFacade.getInstance().getAdLogger().d("OAdApkDownloaderObserver", "download update---mExtraInfo.contentLength < 0");
                this.c.d = iOAdDownloader.getFileSize();
                this.c.k = iOAdDownloader.getTargetURL();
                this.c.a(this.d);
                this.f = String.format(Locale.CHINA, "%.1fM", Float.valueOf(((float) this.c.d) / 1048576.0f));
            }
            if (iOAdDownloader.getProgress() > 0.0f && (progress = (int) iOAdDownloader.getProgress()) > this.c.e) {
                this.c.e = progress;
                if (this.c.m) {
                    a(iOAdDownloader);
                    return;
                }
                return;
            }
            return;
        }
        if (this.c.g == IOAdDownloader.DownloadStatus.COMPLETED) {
            com.baidu.mobads.utils.e commonUtils = XAdSDKFoundationFacade.getInstance().getCommonUtils();
            commonUtils.sendDownloadAdLog(this.d, 528, com.baidu.mobads.openad.c.b.COMPLETE, this.c.q, this.c.i, commonUtils.getAppId(this.d), "", ((p) XAdSDKFoundationFacade.getInstance().getSystemUtils()).getPhoneOSBrand(), Build.MODEL, Build.VERSION.RELEASE, Build.VERSION.SDK_INT);
            XAdSDKFoundationFacade.getInstance().getAdLogger().d("OAdApkDownloaderObserver", "download success-->>" + iOAdDownloader.getOutputPath());
            boolean z = this.c.l;
            if (z) {
                XAdSDKFoundationFacade.getInstance().getAdLogger().d("OAdApkDownloaderObserver", "launch installing .............");
                String str = this.c.c + this.c.b;
                if (!this.c.i.contains(".")) {
                    this.c.i = XAdSDKFoundationFacade.getInstance().getPackageUtils().getLocalApkFileInfo(this.d, str).packageName;
                }
                if (this.e == null) {
                    com.baidu.mobads.b.a aVar = new com.baidu.mobads.b.a(this.c);
                    this.e = new com.baidu.mobads.b.b(this.d, this.c.i, new File(str), z);
                    this.e.a(aVar);
                    this.e.a();
                }
            }
            com.baidu.mobads.c.a.a().a(this.d, this.c);
            IXAppInfo a2 = com.baidu.mobads.command.a.a.a(this.c);
            if (a2 != null) {
                com.baidu.mobads.production.b.f().getXMonitorActivation(this.d, m.a()).addAppInfoForMonitor(a2);
            }
        } else if (this.c.g == IOAdDownloader.DownloadStatus.ERROR) {
            this.c.k = iOAdDownloader.getTargetURL();
            XAdSDKFoundationFacade.getInstance().getAdLogger().e("OAdApkDownloaderObserver", "download failed-->>" + iOAdDownloader.getOutputPath());
            com.baidu.mobads.c.a.a().a(this.c);
        } else if (iOAdDownloader.getState() == IOAdDownloader.DownloadStatus.INITING) {
            this.c.r++;
        }
        if (this.c.m) {
            a(iOAdDownloader);
        }
        this.c.a(this.d);
    }

    public void a(IOAdDownloader iOAdDownloader) {
        this.h.post(new c(this, iOAdDownloader));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str) {
        Toast.makeText(this.d, str, 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(16)
    public Notification b(IOAdDownloader iOAdDownloader) {
        String str;
        int i = 17301634;
        String str2 = this.c.a;
        String str3 = "正在下载 " + this.c.a;
        String str4 = "";
        if (this.c.g == IOAdDownloader.DownloadStatus.COMPLETED) {
            str2 = this.c.g.getMessage() + ": " + str2;
            str4 = " 点击这里安装应用";
        } else if (this.c.g == IOAdDownloader.DownloadStatus.PAUSED) {
            String str5 = this.c.g.getMessage() + ": " + str2;
            if (!iOAdDownloader.isPausedManually()) {
                str = "目前不在wifi网络下， 点击这里继续下载";
            } else {
                str = "点击这里继续下载";
            }
            str2 = str5;
            str3 = "已为您暂停下载， 点击通知栏继续下载";
            str4 = str;
        } else if (this.c.g == IOAdDownloader.DownloadStatus.ERROR) {
            str2 = this.c.g.getMessage() + ": " + str2;
            str4 = " 稍后点击这里重新下载";
        } else if (this.c.g == IOAdDownloader.DownloadStatus.DOWNLOADING) {
            str2 = this.c.g.getMessage() + ": " + str2;
            str4 = "下载进度: " + this.c.e + "%  应用大小: " + this.f;
            i = 17301633;
        } else if (this.c.g != IOAdDownloader.DownloadStatus.INITING) {
            i = 17301633;
        } else {
            str2 = this.c.g.getMessage() + ": " + str2;
            str4 = this.c.g.getMessage();
            i = 17301633;
        }
        Intent intent = new Intent(this.d, AppActivity.getActivityClass());
        intent.putExtra("dealWithDownload", true);
        intent.putExtra("pausedManually", iOAdDownloader.isPausedManually());
        intent.putExtra("status", this.c.g.getCode());
        intent.putExtra("pk", this.c.i);
        intent.putExtra("localApkPath", this.c.c + this.c.b);
        intent.putExtra("title", str2);
        intent.addFlags(268435456);
        intent.setAction(Long.toString(System.currentTimeMillis()));
        PendingIntent activity = PendingIntent.getActivity(this.d, this.c.f, intent, 134217728);
        if (Build.VERSION.SDK_INT >= 16) {
            if (this.c.h == null) {
                this.c.h = new Notification.Builder(this.d);
            }
            return ((Notification.Builder) this.c.h).setContentTitle(str2).setContentText(str4).setTicker(str3).setSmallIcon(i).setContentIntent(activity).setAutoCancel(true).setProgress(100, this.c.e, false).build();
        }
        if (this.c.h == null) {
            this.c.h = new Notification();
        }
        Notification notification = (Notification) this.c.h;
        notification.icon = i;
        notification.flags |= 16;
        notification.tickerText = str3;
        notification.contentIntent = activity;
        try {
            notification.getClass().getMethod("setLatestEventInfo", Context.class, CharSequence.class, CharSequence.class, PendingIntent.class).invoke(notification, this.d, str2, str4, activity);
            return notification;
        } catch (IllegalAccessException e) {
            return notification;
        } catch (IllegalArgumentException e2) {
            return notification;
        } catch (NoSuchMethodException e3) {
            return notification;
        } catch (InvocationTargetException e4) {
            return notification;
        }
    }
}
