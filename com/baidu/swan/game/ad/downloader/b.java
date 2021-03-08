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
/* loaded from: classes5.dex */
public class b extends com.baidu.swan.apps.process.a.a.a {
    private AdDownloadService.a dZo;
    private Bundle mParams;
    private static final String dke = AppRuntime.getAppContext().getPackageName();
    private static boolean dZp = false;
    private boolean dkg = false;
    private ServiceConnection US = new ServiceConnection() { // from class: com.baidu.swan.game.ad.downloader.b.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            b.this.dZo = (AdDownloadService.a) iBinder;
            if (com.baidu.swan.apps.b.DEBUG) {
                Log.d("AdDownload", "service connected");
            }
            b.this.X(b.this.mParams);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            b.this.dZo = null;
            if (com.baidu.swan.apps.b.DEBUG) {
                Log.d("AdDownload", "service disconnected");
            }
        }
    };

    @Override // com.baidu.swan.apps.process.a.a.a
    public void y(@NonNull Bundle bundle) {
        this.mParams = bundle;
        if (SwanAppDownloadAction.SwanAppDownloadType.find(bundle.getString("type")) == SwanAppDownloadAction.SwanAppDownloadType.TYPE_STOP_SERVICE) {
            aRw();
            return;
        }
        aRv();
        aRx();
    }

    public void aRv() {
        if (!dZp) {
            Context context = getContext();
            Intent intent = new Intent();
            intent.setAction("com.baidu.swan.game.ad.downloader.core.AdDownloadService");
            intent.setPackage(dke);
            context.startService(intent);
            dZp = true;
        }
    }

    public void aRw() {
        if (dZp) {
            Context context = getContext();
            Intent intent = new Intent();
            intent.setAction("com.baidu.swan.game.ad.downloader.core.AdDownloadService");
            intent.setPackage(dke);
            context.stopService(intent);
            dZp = false;
        }
    }

    public void aRx() {
        if (!this.dkg) {
            this.dkg = true;
            Context context = getContext();
            Intent intent = new Intent();
            intent.setAction("com.baidu.swan.game.ad.downloader.core.AdDownloadService");
            intent.setPackage(dke);
            context.bindService(intent, this.US, 128);
        }
    }

    public void aRy() {
        if (this.dkg) {
            this.dkg = false;
            Context context = getContext();
            Intent intent = new Intent();
            intent.setAction("com.baidu.swan.game.ad.downloader.core.AdDownloadService");
            intent.setPackage(dke);
            context.unbindService(this.US);
        }
    }

    public void X(@NonNull Bundle bundle) {
        try {
            SwanAppDownloadAction.SwanAppDownloadType find = SwanAppDownloadAction.SwanAppDownloadType.find(bundle.getString("type"));
            JSONObject parseString = v.parseString(bundle.getString(PushConstants.PARAMS, null));
            String optString = parseString.optString("url");
            if (!TextUtils.isEmpty(optString) && this.dZo != null) {
                switch (find) {
                    case TYPE_QUERY_STATUS:
                        u(parseString, optString);
                        break;
                    case TYPE_START_DOWNLOAD:
                        v(parseString, optString);
                        break;
                    case TYPE_PAUSE_DOWNLOAD:
                        va(optString);
                        break;
                    case TYPE_CANCEL_DOWNLOAD:
                        ve(optString);
                        break;
                    case TYPE_RESUME_DOWNLOAD:
                        vf(optString);
                        break;
                    case TYPE_INSTALL_APP:
                        w(parseString, optString);
                        break;
                }
            }
        } catch (Exception e) {
            aRz();
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

    private void u(@NonNull JSONObject jSONObject, @NonNull String str) {
        DownloadInfo vh = this.dZo.vh(str);
        int value = SwanAdDownloadState.NOT_START.value();
        int parseInt = Integer.parseInt("0");
        if (vh == null) {
            at(value, parseInt);
            return;
        }
        long progress = vh.getProgress();
        long size = vh.getSize();
        switch (SwanAdDownloadState.convert(vh.getStatus())) {
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
                parseInt = Integer.parseInt(u(progress, size));
                break;
            case DOWNLOAD_FAILED:
                value = SwanAdDownloadState.DOWNLOAD_FAILED.value();
                parseInt = Integer.parseInt("0");
                break;
            case DOWNLOAD_PAUSED:
                value = SwanAdDownloadState.DOWNLOAD_PAUSED.value();
                parseInt = Integer.parseInt(u(progress, size));
                break;
            case DELETED:
                value = SwanAdDownloadState.DELETED.value();
                parseInt = Integer.parseInt("0");
                break;
        }
        at(value, parseInt);
    }

    private void v(@NonNull JSONObject jSONObject, @NonNull String str) {
        DownloadInfo vh = this.dZo.vh(str);
        String optString = jSONObject.optString("name");
        String downloadDir = getDownloadDir();
        if (TextUtils.isEmpty(downloadDir)) {
            aRz();
            return;
        }
        String concat = new File(downloadDir).getAbsolutePath().concat("/").concat(String.valueOf(str.hashCode()) + ".apk");
        if (vh == null) {
            vh = new DownloadInfo.a().vk(str).vl(concat).vm(optString).aRL();
        }
        vh.setDownloadListener(new a(optString, str));
        this.dZo.a(vh);
    }

    private void aRz() {
        at(SwanAdDownloadState.DOWNLOAD_FAILED.value(), Integer.parseInt("0"));
    }

    private void va(@NonNull String str) {
        this.dZo.b(this.dZo.vh(str));
    }

    private void ve(@NonNull String str) {
        this.dZo.c(this.dZo.vh(str));
    }

    private void vf(@NonNull String str) {
        this.dZo.d(this.dZo.vh(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String vg(@NonNull String str) {
        return this.dZo.vh(str).getPackageName();
    }

    private void w(@NonNull JSONObject jSONObject, @NonNull String str) {
        e.aj(this.dZo.vh(str).getPath(), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void at(final int i, final int i2) {
        com.baidu.swan.apps.runtime.d.getMainHandler().post(new Runnable() { // from class: com.baidu.swan.game.ad.downloader.b.2
            @Override // java.lang.Runnable
            public void run() {
                b.this.duz.putInt("state", i);
                b.this.duz.putInt("progress", i2);
                b.this.finish();
            }
        });
        aRy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPackageName(final String str) {
        com.baidu.swan.apps.runtime.d.getMainHandler().post(new Runnable() { // from class: com.baidu.swan.game.ad.downloader.b.3
            @Override // java.lang.Runnable
            public void run() {
                b.this.duz.putString("packageName", str);
                b.this.finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Context getContext() {
        return AppRuntime.getAppContext();
    }

    public static String u(long j, long j2) {
        return (j2 <= 0 || j <= 0) ? "0" : String.valueOf((int) Math.floor((100 * j) / j2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class a implements com.baidu.swan.game.ad.downloader.c.b {
        private final String packageName;
        private final String url;

        public a(String str, String str2) {
            this.packageName = str;
            this.url = str2;
        }

        @Override // com.baidu.swan.game.ad.downloader.c.b
        public void onStart() {
            b.this.at(SwanAdDownloadState.DOWNLOADING.value(), Integer.parseInt("0"));
            if (com.baidu.swan.apps.b.DEBUG) {
                Log.d("AdDownload", "下载开始");
            }
        }

        @Override // com.baidu.swan.game.ad.downloader.c.b
        public void aRA() {
            b.this.at(SwanAdDownloadState.NOT_START.value(), Integer.parseInt("0"));
            if (com.baidu.swan.apps.b.DEBUG) {
                Log.d("AdDownload", "下载等待");
            }
        }

        @Override // com.baidu.swan.game.ad.downloader.c.b
        public void v(long j, long j2) {
            String u = b.u(j, j2);
            b.this.at(SwanAdDownloadState.DOWNLOAD_PAUSED.value(), Integer.parseInt(u));
            if (com.baidu.swan.apps.b.DEBUG) {
                Log.d("AdDownload", "下载暂停" + u);
            }
        }

        @Override // com.baidu.swan.game.ad.downloader.c.b
        public void w(long j, long j2) {
            String u = b.u(j, j2);
            b.this.at(SwanAdDownloadState.DOWNLOADING.value(), Integer.parseInt(u));
            if (com.baidu.swan.apps.b.DEBUG) {
                Log.d("AdDownload", "下载进度" + u);
            }
        }

        @Override // com.baidu.swan.game.ad.downloader.c.b
        public void aRB() {
            b.this.at(SwanAdDownloadState.DELETED.value(), Integer.parseInt("0"));
            if (com.baidu.swan.apps.b.DEBUG) {
                Log.d("AdDownload", "下载移除");
            }
        }

        @Override // com.baidu.swan.game.ad.downloader.c.b
        public void aRC() {
            b.this.at(SwanAdDownloadState.DOWNLOADED.value(), Integer.parseInt(StatisticData.ERROR_CODE_NOT_FOUND));
            if (com.baidu.swan.apps.b.DEBUG) {
                Log.d("AdDownload", "下载完成");
            }
            String str = this.packageName;
            if (TextUtils.isEmpty(this.packageName) && this.url != null) {
                str = b.this.vg(this.url);
                b.this.setPackageName(str);
            }
            if (!TextUtils.isEmpty(str)) {
                Uri parse = Uri.parse(this.url);
                final com.baidu.swan.game.ad.downloader.c.c a2 = com.baidu.swan.game.ad.downloader.core.a.a(b.this.getContext(), null);
                a2.a(str, parse, new a.AbstractC0509a<Boolean>() { // from class: com.baidu.swan.game.ad.downloader.b.a.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.game.ad.downloader.core.a.AbstractC0509a
                    /* renamed from: l */
                    public void onResult(Boolean bool) {
                        super.onResult(bool);
                        if (bool.booleanValue()) {
                            if (com.baidu.swan.apps.b.DEBUG) {
                                Log.d("AdDownload", "安装完成");
                            }
                            a2.i(a2.vh(a.this.url));
                            b.this.at(SwanAdDownloadState.INSTALLED.value(), Integer.parseInt(StatisticData.ERROR_CODE_NOT_FOUND));
                        }
                    }
                });
            }
        }

        @Override // com.baidu.swan.game.ad.downloader.c.b
        public void a(DownloadException downloadException) {
            b.this.at(SwanAdDownloadState.DOWNLOAD_FAILED.value(), Integer.parseInt("-1"));
        }
    }
}
