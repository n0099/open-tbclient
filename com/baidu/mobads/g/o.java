package com.baidu.mobads.g;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import com.baidu.mobads.openad.interfaces.download.IOAdDownloader;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import java.net.URL;
import java.util.Observable;
import java.util.Observer;
/* loaded from: classes3.dex */
public class o implements Observer {

    /* renamed from: a  reason: collision with root package name */
    private Context f3381a;

    /* renamed from: b  reason: collision with root package name */
    private URL f3382b;
    private String c;
    private final e d;
    private a e;
    private SharedPreferences f;
    private SharedPreferences.OnSharedPreferenceChangeListener g;

    /* loaded from: classes3.dex */
    public interface a {
        void a(e eVar);

        void b(e eVar);
    }

    public o(Context context, URL url, e eVar, a aVar) {
        this.f3382b = null;
        this.c = null;
        this.g = new p(this);
        this.f3382b = url;
        this.d = eVar;
        a(context, aVar);
    }

    public o(Context context, String str, e eVar, a aVar) {
        this.f3382b = null;
        this.c = null;
        this.g = new p(this);
        this.c = str;
        this.d = eVar;
        a(context, aVar);
    }

    private void a(Context context, a aVar) {
        this.f3381a = context;
        this.e = aVar;
        this.f = this.f3381a.getSharedPreferences("__xadsdk_downloaded__version__", 0);
        this.f.registerOnSharedPreferenceChangeListener(this.g);
    }

    public void a(String str, String str2) {
        IOAdDownloader createSimpleFileDownloader = XAdSDKFoundationFacade.getInstance().getDownloaderManager(this.f3381a).createSimpleFileDownloader(this.c != null ? new URL(this.c) : this.f3382b, str, str2, false);
        createSimpleFileDownloader.addObserver(this);
        createSimpleFileDownloader.start();
        SharedPreferences.Editor edit = this.f.edit();
        edit.putString("version", this.d.toString());
        if (Build.VERSION.SDK_INT >= 9) {
            edit.apply();
        } else {
            edit.commit();
        }
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        IOAdDownloader iOAdDownloader = (IOAdDownloader) observable;
        if (iOAdDownloader.getState() == IOAdDownloader.DownloadStatus.COMPLETED) {
            this.e.a(new e(this.d, iOAdDownloader.getOutputPath(), true));
        }
        if (iOAdDownloader.getState() == IOAdDownloader.DownloadStatus.ERROR) {
            this.e.b(new e(this.d, iOAdDownloader.getOutputPath(), false));
        }
    }
}
