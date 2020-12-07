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
    private AdDownloadService.a dRv;
    private Bundle mParams;
    private static final String dgl = AppRuntime.getAppContext().getPackageName();
    private static boolean dRw = false;
    private boolean dgn = false;
    private ServiceConnection Tw = new ServiceConnection() { // from class: com.baidu.swan.game.ad.downloader.b.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            b.this.dRv = (AdDownloadService.a) iBinder;
            if (com.baidu.swan.apps.b.DEBUG) {
                Log.d("AdDownload", "service connected");
            }
            b.this.X(b.this.mParams);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            b.this.dRv = null;
            if (com.baidu.swan.apps.b.DEBUG) {
                Log.d("AdDownload", "service disconnected");
            }
        }
    };

    @Override // com.baidu.swan.apps.process.a.a.a
    public void y(@NonNull Bundle bundle) {
        this.mParams = bundle;
        if (SwanAppDownloadAction.SwanAppDownloadType.find(bundle.getString("type")) == SwanAppDownloadAction.SwanAppDownloadType.TYPE_STOP_SERVICE) {
            aSC();
            return;
        }
        aSB();
        aSD();
    }

    public void aSB() {
        if (!dRw) {
            Context context = getContext();
            Intent intent = new Intent();
            intent.setAction("com.baidu.swan.game.ad.downloader.core.AdDownloadService");
            intent.setPackage(dgl);
            context.startService(intent);
            dRw = true;
        }
    }

    public void aSC() {
        if (dRw) {
            Context context = getContext();
            Intent intent = new Intent();
            intent.setAction("com.baidu.swan.game.ad.downloader.core.AdDownloadService");
            intent.setPackage(dgl);
            context.stopService(intent);
            dRw = false;
        }
    }

    public void aSD() {
        if (!this.dgn) {
            this.dgn = true;
            Context context = getContext();
            Intent intent = new Intent();
            intent.setAction("com.baidu.swan.game.ad.downloader.core.AdDownloadService");
            intent.setPackage(dgl);
            context.bindService(intent, this.Tw, 128);
        }
    }

    public void aSE() {
        if (this.dgn) {
            this.dgn = false;
            Context context = getContext();
            Intent intent = new Intent();
            intent.setAction("com.baidu.swan.game.ad.downloader.core.AdDownloadService");
            intent.setPackage(dgl);
            context.unbindService(this.Tw);
        }
    }

    public void X(@NonNull Bundle bundle) {
        try {
            SwanAppDownloadAction.SwanAppDownloadType find = SwanAppDownloadAction.SwanAppDownloadType.find(bundle.getString("type"));
            JSONObject parseString = v.parseString(bundle.getString(PushConstants.PARAMS, null));
            String optString = parseString.optString("url");
            if (!TextUtils.isEmpty(optString) && this.dRv != null) {
                switch (find) {
                    case TYPE_QUERY_STATUS:
                        v(parseString, optString);
                        break;
                    case TYPE_START_DOWNLOAD:
                        w(parseString, optString);
                        break;
                    case TYPE_PAUSE_DOWNLOAD:
                        vM(optString);
                        break;
                    case TYPE_CANCEL_DOWNLOAD:
                        vQ(optString);
                        break;
                    case TYPE_RESUME_DOWNLOAD:
                        vR(optString);
                        break;
                    case TYPE_INSTALL_APP:
                        x(parseString, optString);
                        break;
                }
            }
        } catch (Exception e) {
            aSF();
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

    private void v(@NonNull JSONObject jSONObject, @NonNull String str) {
        DownloadInfo vT = this.dRv.vT(str);
        int value = SwanAdDownloadState.NOT_START.value();
        int parseInt = Integer.parseInt("0");
        if (vT == null) {
            az(value, parseInt);
            return;
        }
        long progress = vT.getProgress();
        long size = vT.getSize();
        switch (SwanAdDownloadState.convert(vT.getStatus())) {
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
                parseInt = Integer.parseInt(n(progress, size));
                break;
            case DOWNLOAD_FAILED:
                value = SwanAdDownloadState.DOWNLOAD_FAILED.value();
                parseInt = Integer.parseInt("0");
                break;
            case DOWNLOAD_PAUSED:
                value = SwanAdDownloadState.DOWNLOAD_PAUSED.value();
                parseInt = Integer.parseInt(n(progress, size));
                break;
            case DELETED:
                value = SwanAdDownloadState.DELETED.value();
                parseInt = Integer.parseInt("0");
                break;
        }
        az(value, parseInt);
    }

    private void w(@NonNull JSONObject jSONObject, @NonNull String str) {
        DownloadInfo vT = this.dRv.vT(str);
        String optString = jSONObject.optString("name");
        String downloadDir = getDownloadDir();
        if (TextUtils.isEmpty(downloadDir)) {
            aSF();
            return;
        }
        String concat = new File(downloadDir).getAbsolutePath().concat("/").concat(String.valueOf(str.hashCode()) + ".apk");
        if (vT == null) {
            vT = new DownloadInfo.a().vW(str).vX(concat).vY(optString).aSR();
        }
        vT.setDownloadListener(new a(optString, str));
        this.dRv.a(vT);
    }

    private void aSF() {
        az(SwanAdDownloadState.DOWNLOAD_FAILED.value(), Integer.parseInt("0"));
    }

    private void vM(@NonNull String str) {
        this.dRv.b(this.dRv.vT(str));
    }

    private void vQ(@NonNull String str) {
        this.dRv.c(this.dRv.vT(str));
    }

    private void vR(@NonNull String str) {
        this.dRv.d(this.dRv.vT(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String vS(@NonNull String str) {
        return this.dRv.vT(str).getPackageName();
    }

    private void x(@NonNull JSONObject jSONObject, @NonNull String str) {
        e.ak(this.dRv.vT(str).getPath(), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void az(final int i, final int i2) {
        com.baidu.swan.apps.runtime.d.getMainHandler().post(new Runnable() { // from class: com.baidu.swan.game.ad.downloader.b.2
            @Override // java.lang.Runnable
            public void run() {
                b.this.dqB.putInt("state", i);
                b.this.dqB.putInt("progress", i2);
                b.this.finish();
            }
        });
        aSE();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPackageName(final String str) {
        com.baidu.swan.apps.runtime.d.getMainHandler().post(new Runnable() { // from class: com.baidu.swan.game.ad.downloader.b.3
            @Override // java.lang.Runnable
            public void run() {
                b.this.dqB.putString("packageName", str);
                b.this.finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Context getContext() {
        return AppRuntime.getAppContext();
    }

    public static String n(long j, long j2) {
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
            b.this.az(SwanAdDownloadState.DOWNLOADING.value(), Integer.parseInt("0"));
            if (com.baidu.swan.apps.b.DEBUG) {
                Log.d("AdDownload", "下载开始");
            }
        }

        @Override // com.baidu.swan.game.ad.downloader.c.b
        public void aSG() {
            b.this.az(SwanAdDownloadState.NOT_START.value(), Integer.parseInt("0"));
            if (com.baidu.swan.apps.b.DEBUG) {
                Log.d("AdDownload", "下载等待");
            }
        }

        @Override // com.baidu.swan.game.ad.downloader.c.b
        public void o(long j, long j2) {
            String n = b.n(j, j2);
            b.this.az(SwanAdDownloadState.DOWNLOAD_PAUSED.value(), Integer.parseInt(n));
            if (com.baidu.swan.apps.b.DEBUG) {
                Log.d("AdDownload", "下载暂停" + n);
            }
        }

        @Override // com.baidu.swan.game.ad.downloader.c.b
        public void p(long j, long j2) {
            String n = b.n(j, j2);
            b.this.az(SwanAdDownloadState.DOWNLOADING.value(), Integer.parseInt(n));
            if (com.baidu.swan.apps.b.DEBUG) {
                Log.d("AdDownload", "下载进度" + n);
            }
        }

        @Override // com.baidu.swan.game.ad.downloader.c.b
        public void aSH() {
            b.this.az(SwanAdDownloadState.DELETED.value(), Integer.parseInt("0"));
            if (com.baidu.swan.apps.b.DEBUG) {
                Log.d("AdDownload", "下载移除");
            }
        }

        @Override // com.baidu.swan.game.ad.downloader.c.b
        public void aSI() {
            b.this.az(SwanAdDownloadState.DOWNLOADED.value(), Integer.parseInt("100"));
            if (com.baidu.swan.apps.b.DEBUG) {
                Log.d("AdDownload", "下载完成");
            }
            String str = this.packageName;
            if (TextUtils.isEmpty(this.packageName) && this.url != null) {
                str = b.this.vS(this.url);
                b.this.setPackageName(str);
            }
            if (!TextUtils.isEmpty(str)) {
                Uri parse = Uri.parse(this.url);
                final com.baidu.swan.game.ad.downloader.c.c a2 = com.baidu.swan.game.ad.downloader.core.a.a(b.this.getContext(), null);
                a2.a(str, parse, new a.AbstractC0530a<Boolean>() { // from class: com.baidu.swan.game.ad.downloader.b.a.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.game.ad.downloader.core.a.AbstractC0530a
                    /* renamed from: k */
                    public void onResult(Boolean bool) {
                        super.onResult(bool);
                        if (bool.booleanValue()) {
                            if (com.baidu.swan.apps.b.DEBUG) {
                                Log.d("AdDownload", "安装完成");
                            }
                            a2.i(a2.vT(a.this.url));
                            b.this.az(SwanAdDownloadState.INSTALLED.value(), Integer.parseInt("100"));
                        }
                    }
                });
            }
        }

        @Override // com.baidu.swan.game.ad.downloader.c.b
        public void a(DownloadException downloadException) {
            b.this.az(SwanAdDownloadState.DOWNLOAD_FAILED.value(), Integer.parseInt("-1"));
        }
    }
}
