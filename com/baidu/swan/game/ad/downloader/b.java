package com.baidu.swan.game.ad.downloader;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.IBinder;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.adlanding.download.model.SwanAdDownloadState;
import com.baidu.swan.apps.ao.v;
import com.baidu.swan.apps.scheme.actions.SwanAppDownloadAction;
import com.baidu.swan.game.ad.downloader.core.AdDownloadService;
import com.baidu.swan.game.ad.downloader.core.a;
import com.baidu.swan.game.ad.downloader.exception.DownloadException;
import com.baidu.swan.game.ad.downloader.model.DownloadInfo;
import com.bytedance.sdk.openadsdk.preload.falconx.statistic.StatisticData;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b extends com.baidu.swan.apps.process.a.a.a {
    private static final String dle = AppRuntime.getAppContext().getPackageName();
    private static boolean eas = false;
    private AdDownloadService.a ear;
    private Bundle mParams;
    private boolean dlg = false;
    private ServiceConnection Ty = new ServiceConnection() { // from class: com.baidu.swan.game.ad.downloader.b.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            b.this.ear = (AdDownloadService.a) iBinder;
            if (com.baidu.swan.apps.b.DEBUG) {
                Log.d("AdDownload", "service connected");
            }
            b.this.X(b.this.mParams);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            b.this.ear = null;
            if (com.baidu.swan.apps.b.DEBUG) {
                Log.d("AdDownload", "service disconnected");
            }
        }
    };

    @Override // com.baidu.swan.apps.process.a.a.a
    public void y(@NonNull Bundle bundle) {
        this.mParams = bundle;
        if (SwanAppDownloadAction.SwanAppDownloadType.find(bundle.getString("type")) == SwanAppDownloadAction.SwanAppDownloadType.TYPE_STOP_SERVICE) {
            aUW();
            return;
        }
        aUV();
        aUX();
    }

    public void aUV() {
        if (!eas) {
            Context context = getContext();
            Intent intent = new Intent();
            intent.setAction("com.baidu.swan.game.ad.downloader.core.AdDownloadService");
            intent.setPackage(dle);
            context.startService(intent);
            eas = true;
        }
    }

    public void aUW() {
        if (eas) {
            Context context = getContext();
            Intent intent = new Intent();
            intent.setAction("com.baidu.swan.game.ad.downloader.core.AdDownloadService");
            intent.setPackage(dle);
            context.stopService(intent);
            eas = false;
        }
    }

    public void aUX() {
        if (!this.dlg) {
            this.dlg = true;
            Context context = getContext();
            Intent intent = new Intent();
            intent.setAction("com.baidu.swan.game.ad.downloader.core.AdDownloadService");
            intent.setPackage(dle);
            context.bindService(intent, this.Ty, 128);
        }
    }

    public void aUY() {
        if (this.dlg) {
            this.dlg = false;
            Context context = getContext();
            Intent intent = new Intent();
            intent.setAction("com.baidu.swan.game.ad.downloader.core.AdDownloadService");
            intent.setPackage(dle);
            context.unbindService(this.Ty);
        }
    }

    public void X(@NonNull Bundle bundle) {
        try {
            SwanAppDownloadAction.SwanAppDownloadType find = SwanAppDownloadAction.SwanAppDownloadType.find(bundle.getString("type"));
            JSONObject parseString = v.parseString(bundle.getString(PushConstants.PARAMS, null));
            String optString = parseString.optString("url");
            if (!TextUtils.isEmpty(optString) && this.ear != null) {
                switch (find) {
                    case TYPE_QUERY_STATUS:
                        v(parseString, optString);
                        break;
                    case TYPE_START_DOWNLOAD:
                        w(parseString, optString);
                        break;
                    case TYPE_PAUSE_DOWNLOAD:
                        vL(optString);
                        break;
                    case TYPE_CANCEL_DOWNLOAD:
                        vP(optString);
                        break;
                    case TYPE_RESUME_DOWNLOAD:
                        vQ(optString);
                        break;
                    case TYPE_INSTALL_APP:
                        x(parseString, optString);
                        break;
                }
            }
        } catch (Exception e) {
            aUZ();
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
        DownloadInfo vS = this.ear.vS(str);
        int value = SwanAdDownloadState.NOT_START.value();
        int parseInt = Integer.parseInt("0");
        if (vS == null) {
            aw(value, parseInt);
            return;
        }
        long progress = vS.getProgress();
        long size = vS.getSize();
        switch (SwanAdDownloadState.convert(vS.getStatus())) {
            case NOT_START:
            case WAIT:
            case PREPARE_DOWNLOAD:
                value = SwanAdDownloadState.NOT_START.value();
                parseInt = Integer.parseInt("0");
                break;
            case DOWNLOADED:
                value = SwanAdDownloadState.DOWNLOADED.value();
                parseInt = Integer.parseInt(StatisticData.ERROR_CODE_NOT_FOUND);
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
        aw(value, parseInt);
    }

    private void w(@NonNull JSONObject jSONObject, @NonNull String str) {
        DownloadInfo vS = this.ear.vS(str);
        String optString = jSONObject.optString("name");
        String downloadDir = getDownloadDir();
        if (TextUtils.isEmpty(downloadDir)) {
            aUZ();
            return;
        }
        String concat = new File(downloadDir).getAbsolutePath().concat("/").concat(String.valueOf(str.hashCode()) + ".apk");
        if (vS == null) {
            vS = new DownloadInfo.a().vV(str).vW(concat).vX(optString).aVl();
        }
        vS.setDownloadListener(new a(optString, str));
        this.ear.a(vS);
    }

    private void aUZ() {
        aw(SwanAdDownloadState.DOWNLOAD_FAILED.value(), Integer.parseInt("0"));
    }

    private void vL(@NonNull String str) {
        this.ear.b(this.ear.vS(str));
    }

    private void vP(@NonNull String str) {
        this.ear.c(this.ear.vS(str));
    }

    private void vQ(@NonNull String str) {
        this.ear.d(this.ear.vS(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String vR(@NonNull String str) {
        return this.ear.vS(str).getPackageName();
    }

    private void x(@NonNull JSONObject jSONObject, @NonNull String str) {
        e.ak(this.ear.vS(str).getPath(), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aw(final int i, final int i2) {
        com.baidu.swan.apps.runtime.d.getMainHandler().post(new Runnable() { // from class: com.baidu.swan.game.ad.downloader.b.2
            @Override // java.lang.Runnable
            public void run() {
                b.this.dvA.putInt("state", i);
                b.this.dvA.putInt("progress", i2);
                b.this.finish();
            }
        });
        aUY();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPackageName(final String str) {
        com.baidu.swan.apps.runtime.d.getMainHandler().post(new Runnable() { // from class: com.baidu.swan.game.ad.downloader.b.3
            @Override // java.lang.Runnable
            public void run() {
                b.this.dvA.putString("packageName", str);
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
    /* loaded from: classes3.dex */
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
        public void aVa() {
            b.this.aw(SwanAdDownloadState.NOT_START.value(), Integer.parseInt("0"));
            if (com.baidu.swan.apps.b.DEBUG) {
                Log.d("AdDownload", "下载等待");
            }
        }

        @Override // com.baidu.swan.game.ad.downloader.c.b
        public void r(long j, long j2) {
            String q = b.q(j, j2);
            b.this.aw(SwanAdDownloadState.DOWNLOAD_PAUSED.value(), Integer.parseInt(q));
            if (com.baidu.swan.apps.b.DEBUG) {
                Log.d("AdDownload", "下载暂停" + q);
            }
        }

        @Override // com.baidu.swan.game.ad.downloader.c.b
        public void s(long j, long j2) {
            String q = b.q(j, j2);
            b.this.aw(SwanAdDownloadState.DOWNLOADING.value(), Integer.parseInt(q));
            if (com.baidu.swan.apps.b.DEBUG) {
                Log.d("AdDownload", "下载进度" + q);
            }
        }

        @Override // com.baidu.swan.game.ad.downloader.c.b
        public void aVb() {
            b.this.aw(SwanAdDownloadState.DELETED.value(), Integer.parseInt("0"));
            if (com.baidu.swan.apps.b.DEBUG) {
                Log.d("AdDownload", "下载移除");
            }
        }

        @Override // com.baidu.swan.game.ad.downloader.c.b
        public void aVc() {
            b.this.aw(SwanAdDownloadState.DOWNLOADED.value(), Integer.parseInt(StatisticData.ERROR_CODE_NOT_FOUND));
            if (com.baidu.swan.apps.b.DEBUG) {
                Log.d("AdDownload", "下载完成");
            }
            String str = this.packageName;
            if (TextUtils.isEmpty(this.packageName) && this.url != null) {
                str = b.this.vR(this.url);
                b.this.setPackageName(str);
            }
            if (!TextUtils.isEmpty(str)) {
                Uri parse = Uri.parse(this.url);
                final com.baidu.swan.game.ad.downloader.c.c a2 = com.baidu.swan.game.ad.downloader.core.a.a(b.this.getContext(), null);
                a2.a(str, parse, new a.AbstractC0523a<Boolean>() { // from class: com.baidu.swan.game.ad.downloader.b.a.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.game.ad.downloader.core.a.AbstractC0523a
                    /* renamed from: l */
                    public void onResult(Boolean bool) {
                        super.onResult(bool);
                        if (bool.booleanValue()) {
                            if (com.baidu.swan.apps.b.DEBUG) {
                                Log.d("AdDownload", "安装完成");
                            }
                            a2.i(a2.vS(a.this.url));
                            b.this.aw(SwanAdDownloadState.INSTALLED.value(), Integer.parseInt(StatisticData.ERROR_CODE_NOT_FOUND));
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
