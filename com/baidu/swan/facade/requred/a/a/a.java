package com.baidu.swan.facade.requred.a.a;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.sapi2.views.SmsLoginView;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.adaptation.a.f;
import com.baidu.swan.apps.adlanding.download.model.SwanAdDownloadState;
import com.baidu.swan.apps.scheme.actions.SwanAppDownloadAction;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.bytedance.sdk.openadsdk.preload.falconx.statistic.StatisticData;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a implements f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String TAG = f.a.class.getSimpleName();
    private String dYr;
    C0516a dYs;
    String dYt;
    String dYu;
    CallbackHandler det;
    String mCallback;
    Context mContext;
    String mPkgName;
    String mUrl;

    @Override // com.baidu.swan.apps.adaptation.a.f
    public boolean g(Context context, JSONObject jSONObject) {
        return h(context, jSONObject);
    }

    @Override // com.baidu.swan.apps.adaptation.a.f
    public boolean a(@NonNull Context context, @NonNull UnitedSchemeEntity unitedSchemeEntity, @NonNull final SwanAppDownloadAction.SwanAppDownloadType swanAppDownloadType, @NonNull JSONObject jSONObject, @NonNull CallbackHandler callbackHandler) {
        this.mContext = context;
        this.det = callbackHandler;
        this.mCallback = jSONObject.optString("cb");
        this.dYu = jSONObject.optString("onProgressUpdate");
        this.mUrl = jSONObject.optString("url");
        this.mPkgName = jSONObject.optString("name");
        this.dYt = String.valueOf(this.mUrl.hashCode());
        if (TextUtils.isEmpty(this.mCallback) || TextUtils.isEmpty(this.mUrl)) {
            n(false, "Missing parameters");
            return false;
        }
        if (swanAppDownloadType == SwanAppDownloadAction.SwanAppDownloadType.TYPE_INSTALL_APP) {
            aTZ();
        }
        return com.baidu.swan.game.ad.downloader.c.a(context, jSONObject, swanAppDownloadType, new com.baidu.swan.apps.adlanding.download.a.a() { // from class: com.baidu.swan.facade.requred.a.a.a.1
            @Override // com.baidu.swan.apps.adlanding.download.a.a
            public void eR(boolean z) {
                if (a.DEBUG) {
                    Log.d("SwanAdDownloadImpl", "onShowButton:" + z);
                }
            }

            @Override // com.baidu.swan.apps.adlanding.download.a.a
            public void a(SwanAdDownloadState swanAdDownloadState, int i) {
                if (a.DEBUG) {
                    Log.d("SwanAdDownloadImpl", "onStateChange   onStateChange:" + swanAdDownloadState + ", onProgressChange:" + i);
                }
                switch (AnonymousClass3.dYv[swanAppDownloadType.ordinal()]) {
                    case 1:
                        a.this.a(swanAdDownloadState, String.valueOf(i));
                        return;
                    case 2:
                        a.this.b(swanAdDownloadState, String.valueOf(i));
                        return;
                    case 3:
                        a.this.vL(String.valueOf(i));
                        return;
                    case 4:
                        a.this.aTX();
                        return;
                    case 5:
                        a.this.c(swanAdDownloadState, String.valueOf(i));
                        return;
                    case 6:
                        a.this.aTY();
                        return;
                    default:
                        return;
                }
            }

            @Override // com.baidu.swan.apps.adlanding.download.a.a
            public void b(SwanAdDownloadState swanAdDownloadState, int i) {
                if (a.DEBUG) {
                    Log.d("SwanAdDownloadImpl", "onProgressChange   onStateChange:" + swanAdDownloadState + ", onProgressChange:" + i);
                }
            }

            @Override // com.baidu.swan.apps.adlanding.download.a.a
            public void kV(String str) {
                if (a.DEBUG) {
                    Log.d("SwanAdDownloadImpl", "onPackageNameChange:" + str);
                }
            }

            @Override // com.baidu.swan.apps.adlanding.download.a.a
            public void amO() {
                if (a.DEBUG) {
                    Log.d("SwanAdDownloadImpl", "onInstall:");
                }
            }

            @Override // com.baidu.swan.apps.adlanding.download.a.a
            public String amP() {
                if (a.DEBUG) {
                    Log.d("SwanAdDownloadImpl", "onAppOpen:");
                    return null;
                }
                return null;
            }
        });
    }

    /* renamed from: com.baidu.swan.facade.requred.a.a.a$3  reason: invalid class name */
    /* loaded from: classes6.dex */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] dYv = new int[SwanAppDownloadAction.SwanAppDownloadType.values().length];

        static {
            try {
                dYv[SwanAppDownloadAction.SwanAppDownloadType.TYPE_QUERY_STATUS.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                dYv[SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                dYv[SwanAppDownloadAction.SwanAppDownloadType.TYPE_PAUSE_DOWNLOAD.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                dYv[SwanAppDownloadAction.SwanAppDownloadType.TYPE_CANCEL_DOWNLOAD.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                dYv[SwanAppDownloadAction.SwanAppDownloadType.TYPE_RESUME_DOWNLOAD.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                dYv[SwanAppDownloadAction.SwanAppDownloadType.TYPE_INSTALL_APP.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.f
    public boolean a(@NonNull Context context, @NonNull JSONObject jSONObject, @NonNull SwanAppDownloadAction.SwanAppDownloadType swanAppDownloadType, @NonNull com.baidu.swan.apps.adlanding.download.a.a aVar) {
        return com.baidu.swan.game.ad.downloader.c.a(context, jSONObject, swanAppDownloadType, aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@NonNull SwanAdDownloadState swanAdDownloadState, @NonNull String str) {
        this.det.handleSchemeDispatchCallback(this.dYu, a(swanAdDownloadState, str, this.dYt));
        if (swanAdDownloadState == SwanAdDownloadState.DOWNLOADED && "-1".equals(str)) {
            this.det.handleSchemeDispatchCallback(this.mCallback, a(swanAdDownloadState, str, this.dYt, SwanAdDownloadState.DELETED.value()));
        } else if (TextUtils.equals(str, StatisticData.ERROR_CODE_NOT_FOUND)) {
            this.det.handleSchemeDispatchCallback(this.mCallback, a(SwanAdDownloadState.DOWNLOADED, str, this.dYt));
        } else {
            this.det.handleSchemeDispatchCallback(this.mCallback, a(swanAdDownloadState, str, this.dYt));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(@NonNull SwanAdDownloadState swanAdDownloadState, @NonNull String str) {
        this.dYr = this.mCallback;
        this.det.handleSchemeDispatchCallback(this.dYu, a(swanAdDownloadState, str, this.dYt));
        if (swanAdDownloadState == SwanAdDownloadState.DOWNLOADED) {
            this.det.handleSchemeDispatchCallback(this.mCallback, n(true, "onSuccess"));
            this.dYr = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vL(@NonNull String str) {
        this.det.handleSchemeDispatchCallback(this.dYu, a(SwanAdDownloadState.DOWNLOAD_PAUSED, str, this.dYt));
        this.det.handleSchemeDispatchCallback(this.mCallback, n(true, null));
        if (this.dYr != null) {
            this.det.handleSchemeDispatchCallback(this.dYr, n(false, MissionEvent.MESSAGE_PAUSE));
            this.dYr = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTX() {
        this.det.handleSchemeDispatchCallback(this.dYu, a(SwanAdDownloadState.DOWNLOAD_FAILED, "0", this.dYt));
        this.det.handleSchemeDispatchCallback(this.mCallback, n(true, null));
        if (this.dYr != null) {
            this.det.handleSchemeDispatchCallback(this.dYr, n(false, "onStopped"));
            this.dYr = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(@NonNull SwanAdDownloadState swanAdDownloadState, @NonNull String str) {
        if (DEBUG) {
            Log.d("SwanAdDownloadImpl", "handleResumeDownload");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTY() {
        if (DEBUG) {
            Log.d("SwanAdDownloadImpl", "handleInstallApp");
        }
        String concat = new File(com.baidu.swan.game.ad.downloader.b.getDownloadDir()).getAbsolutePath().concat("/").concat(this.dYt + ".apk");
        if (new File(concat).exists()) {
            aTZ();
            if (!com.baidu.swan.game.ad.downloader.e.ak(concat, false)) {
                this.det.handleSchemeDispatchCallback(this.mCallback, n(false, "install apk error"));
                return;
            }
            return;
        }
        this.det.handleSchemeDispatchCallback(this.mCallback, n(false, "Apk Not Found"));
    }

    @NonNull
    private String a(SwanAdDownloadState swanAdDownloadState, @NonNull String str, @NonNull String str2) {
        return a(swanAdDownloadState, str, str2, -1);
    }

    @NonNull
    private String a(SwanAdDownloadState swanAdDownloadState, @NonNull String str, @NonNull String str2, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            if (i > 0) {
                jSONObject.put("state", i);
            } else {
                jSONObject.put("state", swanAdDownloadState);
            }
            jSONObject.put("progress", str);
            jSONObject.put("fileId", str2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return a(true, (String) null, jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public String n(boolean z, @Nullable String str) {
        return a(z, str, (JSONObject) null);
    }

    @NonNull
    private String a(boolean z, @Nullable String str, @Nullable JSONObject jSONObject) {
        if (str == null) {
            str = z ? "success" : SmsLoginView.f.l;
        }
        return UnitedSchemeUtility.wrapCallbackParams(jSONObject, z ? 0 : 1001, str).toString();
    }

    private void aTZ() {
        if (this.dYs == null) {
            this.dYs = new C0516a();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
            intentFilter.addDataScheme("package");
            this.mContext.registerReceiver(this.dYs, intentFilter);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.facade.requred.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0516a extends BroadcastReceiver {
        private long time;

        private C0516a() {
            this.time = 0L;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null && intent.getData() != null && "android.intent.action.PACKAGE_ADDED".equals(intent.getAction())) {
                if (TextUtils.equals(a.this.mPkgName, intent.getData().getSchemeSpecificPart())) {
                    a.this.det.handleSchemeDispatchCallback(a.this.mCallback, a.this.n(true, null));
                    a.this.release();
                }
            }
        }
    }

    public void release() {
        if (this.dYs != null) {
            this.mContext.unregisterReceiver(this.dYs);
            this.dYs = null;
        }
    }

    private boolean h(final Context context, JSONObject jSONObject) {
        final String optString = jSONObject.optString("url");
        final String optString2 = jSONObject.optString("title");
        final String optString3 = jSONObject.optString("description");
        final boolean optBoolean = jSONObject.optBoolean("autoinstall");
        if (TextUtils.isEmpty(optString)) {
            com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "download url is empty");
            return false;
        }
        com.baidu.swan.apps.ab.a.a("android.permission.WRITE_EXTERNAL_STORAGE", new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 3, context, new com.baidu.swan.apps.ab.b() { // from class: com.baidu.swan.facade.requred.a.a.a.2
            @Override // com.baidu.swan.apps.ab.b
            public void kN(String str) {
                DownloadManager.Request request = new DownloadManager.Request(Uri.parse(optString));
                request.setDestinationInExternalPublicDir("", optString.substring(optString.lastIndexOf("/") + 1));
                if (!TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(optString3)) {
                    request.setNotificationVisibility(1);
                    request.setTitle(optString2);
                    request.setDescription(optString3);
                    request.setVisibleInDownloadsUi(true);
                    request.allowScanningByMediaScanner();
                    request.setMimeType("application/vnd.android.package-archive");
                }
                DownloadManager downloadManager = (DownloadManager) AppRuntime.getAppContext().getSystemService("download");
                if (downloadManager != null) {
                    downloadManager.enqueue(request);
                    if (!optBoolean) {
                        com.baidu.swan.apps.ao.e.f(context, new Intent("android.intent.action.VIEW_DOWNLOADS"));
                    }
                }
            }

            @Override // com.baidu.swan.apps.ab.b
            public void ah(int i, String str) {
                if (a.DEBUG) {
                    Log.d(a.TAG, "onAuthorizedFailed,  errorCode: " + i + " errorMsg: " + str);
                }
            }
        });
        return true;
    }
}
