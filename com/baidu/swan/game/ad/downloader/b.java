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
/* loaded from: classes19.dex */
public class b extends com.baidu.swan.apps.process.a.a.a {
    private static final String cyz = AppRuntime.getAppContext().getPackageName();
    private static boolean djJ = false;
    private AdDownloadService.a djI;
    private Bundle mParams;
    private boolean cyB = false;
    private ServiceConnection RQ = new ServiceConnection() { // from class: com.baidu.swan.game.ad.downloader.b.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            b.this.djI = (AdDownloadService.a) iBinder;
            if (com.baidu.swan.apps.b.DEBUG) {
                Log.d("AdDownload", "service connected");
            }
            b.this.X(b.this.mParams);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            b.this.djI = null;
            if (com.baidu.swan.apps.b.DEBUG) {
                Log.d("AdDownload", "service disconnected");
            }
        }
    };

    @Override // com.baidu.swan.apps.process.a.a.a
    public void y(@NonNull Bundle bundle) {
        this.mParams = bundle;
        if (SwanAppDownloadAction.SwanAppDownloadType.find(bundle.getString("type")) == SwanAppDownloadAction.SwanAppDownloadType.TYPE_STOP_SERVICE) {
            aIr();
            return;
        }
        aIq();
        aIs();
    }

    public void aIq() {
        if (!djJ) {
            Context context = getContext();
            Intent intent = new Intent();
            intent.setAction("com.baidu.swan.game.ad.downloader.core.AdDownloadService");
            intent.setPackage(cyz);
            context.startService(intent);
            djJ = true;
        }
    }

    public void aIr() {
        if (djJ) {
            Context context = getContext();
            Intent intent = new Intent();
            intent.setAction("com.baidu.swan.game.ad.downloader.core.AdDownloadService");
            intent.setPackage(cyz);
            context.stopService(intent);
            djJ = false;
        }
    }

    public void aIs() {
        if (!this.cyB) {
            this.cyB = true;
            Context context = getContext();
            Intent intent = new Intent();
            intent.setAction("com.baidu.swan.game.ad.downloader.core.AdDownloadService");
            intent.setPackage(cyz);
            context.bindService(intent, this.RQ, 128);
        }
    }

    public void aIt() {
        if (this.cyB) {
            this.cyB = false;
            Context context = getContext();
            Intent intent = new Intent();
            intent.setAction("com.baidu.swan.game.ad.downloader.core.AdDownloadService");
            intent.setPackage(cyz);
            context.unbindService(this.RQ);
        }
    }

    public void X(@NonNull Bundle bundle) {
        try {
            SwanAppDownloadAction.SwanAppDownloadType find = SwanAppDownloadAction.SwanAppDownloadType.find(bundle.getString("type"));
            JSONObject parseString = v.parseString(bundle.getString(PushConstants.PARAMS, null));
            String optString = parseString.optString("url");
            if (!TextUtils.isEmpty(optString) && this.djI != null) {
                switch (find) {
                    case TYPE_QUERY_STATUS:
                        y(parseString, optString);
                        break;
                    case TYPE_START_DOWNLOAD:
                        z(parseString, optString);
                        break;
                    case TYPE_PAUSE_DOWNLOAD:
                        ty(optString);
                        break;
                    case TYPE_CANCEL_DOWNLOAD:
                        tC(optString);
                        break;
                    case TYPE_RESUME_DOWNLOAD:
                        tD(optString);
                        break;
                    case TYPE_INSTALL_APP:
                        A(parseString, optString);
                        break;
                }
            }
        } catch (Exception e) {
            aIu();
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
        DownloadInfo tF = this.djI.tF(str);
        int value = SwanAdDownloadState.NOT_START.value();
        int parseInt = Integer.parseInt("0");
        if (tF == null) {
            ax(value, parseInt);
            return;
        }
        long progress = tF.getProgress();
        long size = tF.getSize();
        switch (SwanAdDownloadState.convert(tF.getStatus())) {
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
                parseInt = Integer.parseInt(q(progress, size));
                break;
            case DOWNLOAD_FAILED:
                value = SwanAdDownloadState.DOWNLOAD_FAILED.value();
                parseInt = Integer.parseInt("0");
                break;
            case DOWNLOAD_PAUSED:
                value = SwanAdDownloadState.DOWNLOAD_PAUSED.value();
                parseInt = Integer.parseInt(q(progress, size));
                break;
            case DELETED:
                value = SwanAdDownloadState.DELETED.value();
                parseInt = Integer.parseInt("0");
                break;
        }
        ax(value, parseInt);
    }

    private void z(@NonNull JSONObject jSONObject, @NonNull String str) {
        DownloadInfo tF = this.djI.tF(str);
        String optString = jSONObject.optString("name");
        String downloadDir = getDownloadDir();
        if (TextUtils.isEmpty(downloadDir)) {
            aIu();
            return;
        }
        String concat = new File(downloadDir).getAbsolutePath().concat("/").concat(String.valueOf(str.hashCode()) + ".apk");
        if (tF == null) {
            tF = new DownloadInfo.a().tI(str).tJ(concat).tK(optString).aIG();
        }
        tF.setDownloadListener(new a(optString, str));
        this.djI.a(tF);
    }

    private void aIu() {
        ax(SwanAdDownloadState.DOWNLOAD_FAILED.value(), Integer.parseInt("0"));
    }

    private void ty(@NonNull String str) {
        this.djI.b(this.djI.tF(str));
    }

    private void tC(@NonNull String str) {
        this.djI.c(this.djI.tF(str));
    }

    private void tD(@NonNull String str) {
        this.djI.d(this.djI.tF(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String tE(@NonNull String str) {
        return this.djI.tF(str).getPackageName();
    }

    private void A(@NonNull JSONObject jSONObject, @NonNull String str) {
        e.ad(this.djI.tF(str).getPath(), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ax(final int i, final int i2) {
        com.baidu.swan.apps.runtime.d.getMainHandler().post(new Runnable() { // from class: com.baidu.swan.game.ad.downloader.b.2
            @Override // java.lang.Runnable
            public void run() {
                b.this.cIK.putInt("state", i);
                b.this.cIK.putInt("progress", i2);
                b.this.finish();
            }
        });
        aIt();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPackageName(final String str) {
        com.baidu.swan.apps.runtime.d.getMainHandler().post(new Runnable() { // from class: com.baidu.swan.game.ad.downloader.b.3
            @Override // java.lang.Runnable
            public void run() {
                b.this.cIK.putString("packageName", str);
                b.this.finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Context getContext() {
        return AppRuntime.getAppContext();
    }

    public static String q(long j, long j2) {
        return (j2 <= 0 || j <= 0) ? "0" : String.valueOf((int) Math.floor((100 * j) / j2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes19.dex */
    public class a implements com.baidu.swan.game.ad.downloader.c.b {
        private final String packageName;
        private final String url;

        public a(String str, String str2) {
            this.packageName = str;
            this.url = str2;
        }

        @Override // com.baidu.swan.game.ad.downloader.c.b
        public void onStart() {
            b.this.ax(SwanAdDownloadState.DOWNLOADING.value(), Integer.parseInt("0"));
            if (com.baidu.swan.apps.b.DEBUG) {
                Log.d("AdDownload", "下载开始");
            }
        }

        @Override // com.baidu.swan.game.ad.downloader.c.b
        public void aIv() {
            b.this.ax(SwanAdDownloadState.NOT_START.value(), Integer.parseInt("0"));
            if (com.baidu.swan.apps.b.DEBUG) {
                Log.d("AdDownload", "下载等待");
            }
        }

        @Override // com.baidu.swan.game.ad.downloader.c.b
        public void r(long j, long j2) {
            String q = b.q(j, j2);
            b.this.ax(SwanAdDownloadState.DOWNLOAD_PAUSED.value(), Integer.parseInt(q));
            if (com.baidu.swan.apps.b.DEBUG) {
                Log.d("AdDownload", "下载暂停" + q);
            }
        }

        @Override // com.baidu.swan.game.ad.downloader.c.b
        public void s(long j, long j2) {
            String q = b.q(j, j2);
            b.this.ax(SwanAdDownloadState.DOWNLOADING.value(), Integer.parseInt(q));
            if (com.baidu.swan.apps.b.DEBUG) {
                Log.d("AdDownload", "下载进度" + q);
            }
        }

        @Override // com.baidu.swan.game.ad.downloader.c.b
        public void aIw() {
            b.this.ax(SwanAdDownloadState.DELETED.value(), Integer.parseInt("0"));
            if (com.baidu.swan.apps.b.DEBUG) {
                Log.d("AdDownload", "下载移除");
            }
        }

        @Override // com.baidu.swan.game.ad.downloader.c.b
        public void aIx() {
            b.this.ax(SwanAdDownloadState.DOWNLOADED.value(), Integer.parseInt("100"));
            if (com.baidu.swan.apps.b.DEBUG) {
                Log.d("AdDownload", "下载完成");
            }
            String str = this.packageName;
            if (TextUtils.isEmpty(this.packageName) && this.url != null) {
                str = b.this.tE(this.url);
                b.this.setPackageName(str);
            }
            if (!TextUtils.isEmpty(str)) {
                Uri parse = Uri.parse(this.url);
                final com.baidu.swan.game.ad.downloader.c.c a = com.baidu.swan.game.ad.downloader.core.a.a(b.this.getContext(), null);
                a.a(str, parse, new a.AbstractC0482a<Boolean>() { // from class: com.baidu.swan.game.ad.downloader.b.a.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.game.ad.downloader.core.a.AbstractC0482a
                    /* renamed from: j */
                    public void onResult(Boolean bool) {
                        super.onResult(bool);
                        if (bool.booleanValue()) {
                            if (com.baidu.swan.apps.b.DEBUG) {
                                Log.d("AdDownload", "安装完成");
                            }
                            a.i(a.tF(a.this.url));
                            b.this.ax(SwanAdDownloadState.INSTALLED.value(), Integer.parseInt("100"));
                        }
                    }
                });
            }
        }

        @Override // com.baidu.swan.game.ad.downloader.c.b
        public void a(DownloadException downloadException) {
            b.this.ax(SwanAdDownloadState.DOWNLOAD_FAILED.value(), Integer.parseInt("-1"));
        }
    }
}
