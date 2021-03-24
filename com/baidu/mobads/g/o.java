package com.baidu.mobads.g;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import com.baidu.mobads.openad.interfaces.download.IOAdDownloader;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import java.net.URL;
import java.util.Observable;
import java.util.Observer;
/* loaded from: classes2.dex */
public class o implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public Context f8297a;

    /* renamed from: b  reason: collision with root package name */
    public URL f8298b;

    /* renamed from: c  reason: collision with root package name */
    public String f8299c;

    /* renamed from: d  reason: collision with root package name */
    public final e f8300d;

    /* renamed from: e  reason: collision with root package name */
    public a f8301e;

    /* renamed from: f  reason: collision with root package name */
    public SharedPreferences f8302f;

    /* renamed from: g  reason: collision with root package name */
    public SharedPreferences.OnSharedPreferenceChangeListener f8303g;

    /* loaded from: classes2.dex */
    public interface a {
        void a(e eVar);

        void b(e eVar);
    }

    public o(Context context, URL url, e eVar, a aVar) {
        this.f8298b = null;
        this.f8299c = null;
        this.f8303g = new p(this);
        this.f8298b = url;
        this.f8300d = eVar;
        a(context, aVar);
    }

    private void a(Context context, a aVar) {
        this.f8297a = context;
        this.f8301e = aVar;
        SharedPreferences sharedPreferences = context.getSharedPreferences("__xadsdk_downloaded__version__", 0);
        this.f8302f = sharedPreferences;
        sharedPreferences.registerOnSharedPreferenceChangeListener(this.f8303g);
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        IOAdDownloader iOAdDownloader = (IOAdDownloader) observable;
        if (iOAdDownloader.getState() == IOAdDownloader.DownloadStatus.COMPLETED) {
            this.f8301e.a(new e(this.f8300d, iOAdDownloader.getOutputPath(), Boolean.TRUE));
        }
        if (iOAdDownloader.getState() == IOAdDownloader.DownloadStatus.ERROR) {
            this.f8301e.b(new e(this.f8300d, iOAdDownloader.getOutputPath(), Boolean.FALSE));
        }
    }

    public void a(String str, String str2) {
        IOAdDownloader createSimpleFileDownloader = XAdSDKFoundationFacade.getInstance().getDownloaderManager(this.f8297a).createSimpleFileDownloader(this.f8299c != null ? new URL(this.f8299c) : this.f8298b, str, str2, false);
        createSimpleFileDownloader.addObserver(this);
        createSimpleFileDownloader.start();
        SharedPreferences.Editor edit = this.f8302f.edit();
        edit.putString("version", this.f8300d.toString());
        if (Build.VERSION.SDK_INT >= 9) {
            edit.apply();
        } else {
            edit.commit();
        }
    }

    public o(Context context, String str, e eVar, a aVar) {
        this.f8298b = null;
        this.f8299c = null;
        this.f8303g = new p(this);
        this.f8299c = str;
        this.f8300d = eVar;
        a(context, aVar);
    }
}
