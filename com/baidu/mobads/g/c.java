package com.baidu.mobads.g;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.baidu.mobads.g.g;
import com.baidu.mobads.g.o;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.UUID;
/* loaded from: classes3.dex */
public class c extends Thread {
    private static volatile c f;

    /* renamed from: b  reason: collision with root package name */
    private volatile String f3366b;
    private String c;
    private double d;
    private Handler e;
    private final Context g;
    private final e i;
    private o h = null;
    private IXAdLogger j = XAdSDKFoundationFacade.getInstance().getAdLogger();

    /* renamed from: a  reason: collision with root package name */
    o.a f3365a = new d(this);

    public static c a(Context context, e eVar, String str, Handler handler) {
        if (f == null) {
            f = new c(context, eVar, str, handler);
        }
        return f;
    }

    private c(Context context, e eVar, String str, Handler handler) {
        this.c = null;
        this.g = context;
        this.i = eVar;
        a(eVar.c());
        this.e = handler;
        this.c = str;
    }

    public void a(String str) {
        this.f3366b = str;
        interrupt();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            if (b()) {
                try {
                    a();
                    this.j.d("XAdApkDownloadThread", "download apk successfully, downloader exit");
                    f = null;
                } catch (IOException e) {
                    this.j.e("XAdApkDownloadThread", "create File or HTTP Get failed, exception: " + e.getMessage());
                }
                this.j.d("XAdApkDownloadThread", "no newer apk, downloader exit");
                f = null;
            }
        } catch (Throwable th) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, e eVar, String str2) {
        if (str.equals("OK") || str.equals("ERROR")) {
            Message obtainMessage = this.e.obtainMessage();
            Bundle bundle = new Bundle();
            bundle.putParcelable("APK_INFO", eVar);
            bundle.putString("CODE", str);
            obtainMessage.setData(bundle);
            this.e.sendMessage(obtainMessage);
        }
    }

    private String a() {
        String str = "__xadsdk__remote__final__" + UUID.randomUUID().toString() + ".jar";
        String str2 = this.c + str;
        File file = new File(str2);
        try {
            file.createNewFile();
            this.h.a(this.c, str);
            return str2;
        } catch (IOException e) {
            file.delete();
            throw e;
        }
    }

    private boolean b() {
        double d;
        try {
            try {
                this.h = new o(this.g, new URL(this.f3366b), this.i, this.f3365a);
            } catch (MalformedURLException e) {
                this.h = new o(this.g, this.f3366b, this.i, this.f3365a);
            }
            if (g.c != null) {
                d = g.c.f3361a;
            } else if (g.f3371b == null) {
                d = 0.0d;
            } else if (g.f3371b.f3361a > 0.0d) {
                d = g.f3371b.f3361a;
            } else {
                d = g.f3371b.f3361a;
            }
            this.j.d("XAdApkDownloadThread", "isNewApkAvailable: local apk version is: " + d + ", remote apk version: " + this.i.b());
            if (d > 0.0d) {
                if (this.i.b() > 0.0d) {
                    this.j.e("XAdApkDownloadThread", "remote not null, local apk version is null, force upgrade");
                    this.d = this.i.b();
                    return true;
                }
                this.j.e("XAdApkDownloadThread", "remote is null, local apk version is null, do not upgrade");
                return false;
            } else if (this.i.b() <= 0.0d) {
                this.j.e("XAdApkDownloadThread", "remote apk version is: null, local apk version is: " + d + ", do not upgrade");
                return false;
            } else if (this.i.b() > d) {
                this.d = this.i.b();
                return true;
            } else {
                return false;
            }
        } catch (Exception e2) {
            String str = "parse apk failed, error:" + e2.toString();
            this.j.e("XAdApkDownloadThread", str);
            throw new g.a(str);
        }
    }
}
