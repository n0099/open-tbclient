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
/* loaded from: classes2.dex */
public class c extends Thread {

    /* renamed from: f  reason: collision with root package name */
    public static volatile c f8262f;

    /* renamed from: b  reason: collision with root package name */
    public volatile String f8264b;

    /* renamed from: c  reason: collision with root package name */
    public String f8265c;

    /* renamed from: d  reason: collision with root package name */
    public double f8266d;

    /* renamed from: e  reason: collision with root package name */
    public Handler f8267e;

    /* renamed from: g  reason: collision with root package name */
    public final Context f8268g;
    public final e i;

    /* renamed from: h  reason: collision with root package name */
    public o f8269h = null;
    public IXAdLogger j = XAdSDKFoundationFacade.getInstance().getAdLogger();

    /* renamed from: a  reason: collision with root package name */
    public o.a f8263a = new d(this);

    public c(Context context, e eVar, String str, Handler handler) {
        this.f8265c = null;
        this.f8268g = context;
        this.i = eVar;
        a(eVar.c());
        this.f8267e = handler;
        this.f8265c = str;
    }

    private boolean b() {
        double d2;
        try {
            try {
                this.f8269h = new o(this.f8268g, new URL(this.f8264b), this.i, this.f8263a);
            } catch (MalformedURLException unused) {
                this.f8269h = new o(this.f8268g, this.f8264b, this.i, this.f8263a);
            }
            if (g.f8281c != null) {
                d2 = g.f8281c.f8250a;
            } else if (g.f8280b == null) {
                d2 = 0.0d;
            } else if (g.f8280b.f8250a > 0.0d) {
                d2 = g.f8280b.f8250a;
            } else {
                d2 = g.f8280b.f8250a;
            }
            this.j.d("XAdApkDownloadThread", "isNewApkAvailable: local apk version is: " + d2 + ", remote apk version: " + this.i.b());
            if (d2 > 0.0d) {
                if (this.i.b() > 0.0d) {
                    this.j.d("XAdApkDownloadThread", "remote not null, local apk version is null, force upgrade");
                    this.f8266d = this.i.b();
                    return true;
                }
                this.j.d("XAdApkDownloadThread", "remote is null, local apk version is null, do not upgrade");
                return false;
            } else if (this.i.b() <= 0.0d) {
                this.j.d("XAdApkDownloadThread", "remote apk version is: null, local apk version is: " + d2 + ", do not upgrade");
                return false;
            } else if (this.i.b() > d2) {
                this.f8266d = this.i.b();
                return true;
            } else {
                return false;
            }
        } catch (Exception e2) {
            String str = "parse apk failed, error:" + e2.toString();
            this.j.d("XAdApkDownloadThread", str);
            throw new g.a(str);
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            if (b()) {
                try {
                    a();
                    this.j.d("XAdApkDownloadThread", "download apk successfully, downloader exit");
                    f8262f = null;
                } catch (IOException e2) {
                    IXAdLogger iXAdLogger = this.j;
                    iXAdLogger.d("XAdApkDownloadThread", "create File or HTTP Get failed, exception: " + e2.getMessage());
                }
                this.j.d("XAdApkDownloadThread", "no newer apk, downloader exit");
                f8262f = null;
            }
        } catch (Throwable unused) {
        }
    }

    public static c a(Context context, e eVar, String str, Handler handler) {
        if (f8262f == null) {
            f8262f = new c(context, eVar, str, handler);
        }
        return f8262f;
    }

    public void a(String str) {
        this.f8264b = str;
        interrupt();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, e eVar, String str2) {
        if (str.equals("OK") || str.equals("ERROR")) {
            Message obtainMessage = this.f8267e.obtainMessage();
            Bundle bundle = new Bundle();
            bundle.putParcelable("APK_INFO", eVar);
            bundle.putString("CODE", str);
            obtainMessage.setData(bundle);
            this.f8267e.sendMessage(obtainMessage);
        }
    }

    private String a() {
        String str = "__xadsdk__remote__final__" + UUID.randomUUID().toString() + ".jar";
        String str2 = this.f8265c + str;
        File file = new File(str2);
        try {
            file.createNewFile();
            this.f8269h.a(this.f8265c, str);
            return str2;
        } catch (IOException e2) {
            file.delete();
            throw e2;
        }
    }
}
