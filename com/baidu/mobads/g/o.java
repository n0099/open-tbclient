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
    public Context f8298a;

    /* renamed from: b  reason: collision with root package name */
    public URL f8299b;

    /* renamed from: c  reason: collision with root package name */
    public String f8300c;

    /* renamed from: d  reason: collision with root package name */
    public final e f8301d;

    /* renamed from: e  reason: collision with root package name */
    public a f8302e;

    /* renamed from: f  reason: collision with root package name */
    public SharedPreferences f8303f;

    /* renamed from: g  reason: collision with root package name */
    public SharedPreferences.OnSharedPreferenceChangeListener f8304g;

    /* loaded from: classes2.dex */
    public interface a {
        void a(e eVar);

        void b(e eVar);
    }

    public o(Context context, URL url, e eVar, a aVar) {
        this.f8299b = null;
        this.f8300c = null;
        this.f8304g = new p(this);
        this.f8299b = url;
        this.f8301d = eVar;
        a(context, aVar);
    }

    private void a(Context context, a aVar) {
        this.f8298a = context;
        this.f8302e = aVar;
        SharedPreferences sharedPreferences = context.getSharedPreferences("__xadsdk_downloaded__version__", 0);
        this.f8303f = sharedPreferences;
        sharedPreferences.registerOnSharedPreferenceChangeListener(this.f8304g);
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        IOAdDownloader iOAdDownloader = (IOAdDownloader) observable;
        if (iOAdDownloader.getState() == IOAdDownloader.DownloadStatus.COMPLETED) {
            this.f8302e.a(new e(this.f8301d, iOAdDownloader.getOutputPath(), Boolean.TRUE));
        }
        if (iOAdDownloader.getState() == IOAdDownloader.DownloadStatus.ERROR) {
            this.f8302e.b(new e(this.f8301d, iOAdDownloader.getOutputPath(), Boolean.FALSE));
        }
    }

    public void a(String str, String str2) {
        IOAdDownloader createSimpleFileDownloader = XAdSDKFoundationFacade.getInstance().getDownloaderManager(this.f8298a).createSimpleFileDownloader(this.f8300c != null ? new URL(this.f8300c) : this.f8299b, str, str2, false);
        createSimpleFileDownloader.addObserver(this);
        createSimpleFileDownloader.start();
        SharedPreferences.Editor edit = this.f8303f.edit();
        edit.putString("version", this.f8301d.toString());
        if (Build.VERSION.SDK_INT >= 9) {
            edit.apply();
        } else {
            edit.commit();
        }
    }

    public o(Context context, String str, e eVar, a aVar) {
        this.f8299b = null;
        this.f8300c = null;
        this.f8304g = new p(this);
        this.f8300c = str;
        this.f8301d = eVar;
        a(context, aVar);
    }
}
