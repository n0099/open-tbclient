package com.baidu.swan.game.ad.downloader;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.IBinder;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.adlanding.download.model.SwanAdDownloadState;
import com.baidu.swan.apps.ap.v;
import com.baidu.swan.apps.scheme.actions.SwanAppDownloadAction;
import com.baidu.swan.game.ad.downloader.core.AdDownloadService;
import com.baidu.swan.game.ad.downloader.core.a;
import com.baidu.swan.game.ad.downloader.exception.DownloadException;
import com.baidu.swan.game.ad.downloader.model.DownloadInfo;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes14.dex */
public class b extends com.baidu.swan.apps.process.a.a.a {
    private static final String cMF = AppRuntime.getAppContext().getPackageName();
    private static boolean dxR = false;
    private AdDownloadService.a dxQ;
    private Bundle mParams;
    private boolean cMH = false;
    private ServiceConnection Sz = new ServiceConnection() { // from class: com.baidu.swan.game.ad.downloader.b.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            b.this.dxQ = (AdDownloadService.a) iBinder;
            if (com.baidu.swan.apps.b.DEBUG) {
                Log.d("AdDownload", "service connected");
            }
            b.this.X(b.this.mParams);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            b.this.dxQ = null;
            if (com.baidu.swan.apps.b.DEBUG) {
                Log.d("AdDownload", "service disconnected");
            }
        }
    };

    @Override // com.baidu.swan.apps.process.a.a.a
    public void y(@NonNull Bundle bundle) {
        this.mParams = bundle;
        if (SwanAppDownloadAction.SwanAppDownloadType.find(bundle.getString("type")) == SwanAppDownloadAction.SwanAppDownloadType.TYPE_STOP_SERVICE) {
            aLL();
            return;
        }
        aLK();
        aLM();
    }

    public void aLK() {
        if (!dxR) {
            Context context = getContext();
            Intent intent = new Intent();
            intent.setAction("com.baidu.swan.game.ad.downloader.core.AdDownloadService");
            intent.setPackage(cMF);
            context.startService(intent);
            dxR = true;
        }
    }

    public void aLL() {
        if (dxR) {
            Context context = getContext();
            Intent intent = new Intent();
            intent.setAction("com.baidu.swan.game.ad.downloader.core.AdDownloadService");
            intent.setPackage(cMF);
            context.stopService(intent);
            dxR = false;
        }
    }

    public void aLM() {
        if (!this.cMH) {
            this.cMH = true;
            Context context = getContext();
            Intent intent = new Intent();
            intent.setAction("com.baidu.swan.game.ad.downloader.core.AdDownloadService");
            intent.setPackage(cMF);
            context.bindService(intent, this.Sz, 128);
        }
    }

    public void aLN() {
        if (this.cMH) {
            this.cMH = false;
            Context context = getContext();
            Intent intent = new Intent();
            intent.setAction("com.baidu.swan.game.ad.downloader.core.AdDownloadService");
            intent.setPackage(cMF);
            context.unbindService(this.Sz);
        }
    }

    public void X(@NonNull Bundle bundle) {
        try {
            SwanAppDownloadAction.SwanAppDownloadType find = SwanAppDownloadAction.SwanAppDownloadType.find(bundle.getString("type"));
            JSONObject parseString = v.parseString(bundle.getString(PushConstants.PARAMS, null));
            String optString = parseString.optString("url");
            if (!TextUtils.isEmpty(optString) && this.dxQ != null) {
                switch (find) {
                    case TYPE_QUERY_STATUS:
                        y(parseString, optString);
                        break;
                    case TYPE_START_DOWNLOAD:
                        z(parseString, optString);
                        break;
                    case TYPE_PAUSE_DOWNLOAD:
                        uD(optString);
                        break;
                    case TYPE_CANCEL_DOWNLOAD:
                        uH(optString);
                        break;
                    case TYPE_RESUME_DOWNLOAD:
                        uI(optString);
                        break;
                    case TYPE_INSTALL_APP:
                        A(parseString, optString);
                        break;
                }
            }
        } catch (Exception e) {
            aLO();
        }
    }

    public static String getDownloadDir() {
        if (!Environment.getExternalStorageState().equals("mounted")) {
            return "";
        }
        String str = AppRuntime.getAppContext().getExternalFilesDir(null) + File.separator + "swanAdDownload";
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
            return str;
        }
        return str;
    }

    private void y(@NonNull JSONObject jSONObject, @NonNull String str) {
        DownloadInfo uK = this.dxQ.uK(str);
        int value = SwanAdDownloadState.NOT_START.value();
        int parseInt = Integer.parseInt("0");
        if (uK == null) {
            aw(value, parseInt);
            return;
        }
        long progress = uK.getProgress();
        long size = uK.getSize();
        switch (SwanAdDownloadState.convert(uK.getStatus())) {
            case NOT_START:
            case WAIT:
            case PREPARE_DOWNLOAD:
                value = SwanAdDownloadState.NOT_START.value();
                parseInt = Integer.parseInt("0");
                break;
            case DOWNLOADED:
                value = SwanAdDownloadState.DOWNLOADED.value();
                parseInt = Integer.parseInt("100");
                break;
            case DOWNLOADING:
                value = SwanAdDownloadState.DOWNLOADING.value();
                parseInt = Integer.parseInt(m(progress, size));
                break;
            case DOWNLOAD_FAILED:
                value = SwanAdDownloadState.DOWNLOAD_FAILED.value();
                parseInt = Integer.parseInt("0");
                break;
            case DOWNLOAD_PAUSED:
                value = SwanAdDownloadState.DOWNLOAD_PAUSED.value();
                parseInt = Integer.parseInt(m(progress, size));
                break;
            case DELETED:
                value = SwanAdDownloadState.DELETED.value();
                parseInt = Integer.parseInt("0");
                break;
        }
        aw(value, parseInt);
    }

    private void z(@NonNull JSONObject jSONObject, @NonNull String str) {
        DownloadInfo uK = this.dxQ.uK(str);
        String optString = jSONObject.optString("name");
        String downloadDir = getDownloadDir();
        if (TextUtils.isEmpty(downloadDir)) {
            aLO();
            return;
        }
        String concat = new File(downloadDir).getAbsolutePath().concat("/").concat(String.valueOf(str.hashCode()) + ".apk");
        if (uK == null) {
            uK = new DownloadInfo.a().uN(str).uO(concat).uP(optString).aMa();
        }
        uK.setDownloadListener(new a(optString, str));
        this.dxQ.a(uK);
    }

    private void aLO() {
        aw(SwanAdDownloadState.DOWNLOAD_FAILED.value(), Integer.parseInt("0"));
    }

    private void uD(@NonNull String str) {
        this.dxQ.b(this.dxQ.uK(str));
    }

    private void uH(@NonNull String str) {
        this.dxQ.c(this.dxQ.uK(str));
    }

    private void uI(@NonNull String str) {
        this.dxQ.d(this.dxQ.uK(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String uJ(@NonNull String str) {
        return this.dxQ.uK(str).getPackageName();
    }

    private void A(@NonNull JSONObject jSONObject, @NonNull String str) {
        e.ah(this.dxQ.uK(str).getPath(), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aw(final int i, final int i2) {
        com.baidu.swan.apps.runtime.d.getMainHandler().post(new Runnable() { // from class: com.baidu.swan.game.ad.downloader.b.2
            @Override // java.lang.Runnable
            public void run() {
                b.this.cWN.putInt("state", i);
                b.this.cWN.putInt("progress", i2);
                b.this.finish();
            }
        });
        aLN();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPackageName(final String str) {
        com.baidu.swan.apps.runtime.d.getMainHandler().post(new Runnable() { // from class: com.baidu.swan.game.ad.downloader.b.3
            @Override // java.lang.Runnable
            public void run() {
                b.this.cWN.putString("packageName", str);
                b.this.finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Context getContext() {
        return AppRuntime.getAppContext();
    }

    public static String m(long j, long j2) {
        return (j2 <= 0 || j <= 0) ? "0" : String.valueOf((int) Math.floor((100 * j) / j2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes14.dex */
    public class a implements com.baidu.swan.game.ad.downloader.c.b {
        private final String packageName;
        private final String url;

        public a(String str, String str2) {
            this.packageName = str;
            this.url = str2;
        }

        @Override // com.baidu.swan.game.ad.downloader.c.b
        public void onStart() {
            b.this.aw(SwanAdDownloadState.DOWNLOADING.value(), Integer.parseInt("0"));
            if (com.baidu.swan.apps.b.DEBUG) {
                Log.d("AdDownload", "下载开始");
            }
        }

        @Override // com.baidu.swan.game.ad.downloader.c.b
        public void aLP() {
            b.this.aw(SwanAdDownloadState.NOT_START.value(), Integer.parseInt("0"));
            if (com.baidu.swan.apps.b.DEBUG) {
                Log.d("AdDownload", "下载等待");
            }
        }

        @Override // com.baidu.swan.game.ad.downloader.c.b
        public void n(long j, long j2) {
            String m = b.m(j, j2);
            b.this.aw(SwanAdDownloadState.DOWNLOAD_PAUSED.value(), Integer.parseInt(m));
            if (com.baidu.swan.apps.b.DEBUG) {
                Log.d("AdDownload", "下载暂停" + m);
            }
        }

        @Override // com.baidu.swan.game.ad.downloader.c.b
        public void o(long j, long j2) {
            String m = b.m(j, j2);
            b.this.aw(SwanAdDownloadState.DOWNLOADING.value(), Integer.parseInt(m));
            if (com.baidu.swan.apps.b.DEBUG) {
                Log.d("AdDownload", "下载进度" + m);
            }
        }

        @Override // com.baidu.swan.game.ad.downloader.c.b
        public void aLQ() {
            b.this.aw(SwanAdDownloadState.DELETED.value(), Integer.parseInt("0"));
            if (com.baidu.swan.apps.b.DEBUG) {
                Log.d("AdDownload", "下载移除");
            }
        }

        @Override // com.baidu.swan.game.ad.downloader.c.b
        public void aLR() {
            b.this.aw(SwanAdDownloadState.DOWNLOADED.value(), Integer.parseInt("100"));
            if (com.baidu.swan.apps.b.DEBUG) {
                Log.d("AdDownload", "下载完成");
            }
            String str = this.packageName;
            if (TextUtils.isEmpty(this.packageName) && this.url != null) {
                str = b.this.uJ(this.url);
                b.this.setPackageName(str);
            }
            if (!TextUtils.isEmpty(str)) {
                Uri parse = Uri.parse(this.url);
                final com.baidu.swan.game.ad.downloader.c.c a2 = com.baidu.swan.game.ad.downloader.core.a.a(b.this.getContext(), null);
                a2.a(str, parse, new a.AbstractC0494a<Boolean>() { // from class: com.baidu.swan.game.ad.downloader.b.a.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.game.ad.downloader.core.a.AbstractC0494a
                    /* renamed from: k */
                    public void onResult(Boolean bool) {
                        super.onResult(bool);
                        if (bool.booleanValue()) {
                            if (com.baidu.swan.apps.b.DEBUG) {
                                Log.d("AdDownload", "安装完成");
                            }
                            a2.i(a2.uK(a.this.url));
                            b.this.aw(SwanAdDownloadState.INSTALLED.value(), Integer.parseInt("100"));
                        }
                    }
                });
            }
        }

        @Override // com.baidu.swan.game.ad.downloader.c.b
        public void a(DownloadException downloadException) {
            b.this.aw(SwanAdDownloadState.DOWNLOAD_FAILED.value(), Integer.parseInt("-1"));
        }
    }
}
