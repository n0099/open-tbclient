package com.baidu.swan.facade.requred.a.a;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.sapi2.views.SmsLoginView;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.adaptation.a.f;
import com.baidu.swan.apps.adlanding.download.model.SwanAdDownloadState;
import com.baidu.swan.apps.scheme.actions.SwanAppDownloadAction;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes20.dex */
public class a implements f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String TAG = f.a.class.getSimpleName();
    CallbackHandler crL;
    private String dhH;
    C0475a dhI;
    String dhJ;
    String dhK;
    String mCallback;
    Context mContext;
    String mPkgName;
    String mUrl;

    @Override // com.baidu.swan.apps.adaptation.a.f
    public boolean h(Context context, JSONObject jSONObject) {
        return i(context, jSONObject);
    }

    @Override // com.baidu.swan.apps.adaptation.a.f
    public boolean a(@NonNull Context context, @NonNull UnitedSchemeEntity unitedSchemeEntity, @NonNull final SwanAppDownloadAction.SwanAppDownloadType swanAppDownloadType, @NonNull JSONObject jSONObject, @NonNull CallbackHandler callbackHandler) {
        this.mContext = context;
        this.crL = callbackHandler;
        this.mCallback = jSONObject.optString("cb");
        this.dhK = jSONObject.optString("onProgressUpdate");
        this.mUrl = jSONObject.optString("url");
        this.mPkgName = jSONObject.optString("name");
        this.dhJ = String.valueOf(this.mUrl.hashCode());
        if (TextUtils.isEmpty(this.mCallback) || TextUtils.isEmpty(this.mUrl)) {
            l(false, "Missing parameters");
            return false;
        }
        if (swanAppDownloadType == SwanAppDownloadAction.SwanAppDownloadType.TYPE_INSTALL_APP) {
            aHt();
        }
        return com.baidu.swan.game.ad.downloader.c.a(context, jSONObject, swanAppDownloadType, new com.baidu.swan.apps.adlanding.download.a.a() { // from class: com.baidu.swan.facade.requred.a.a.a.1
            @Override // com.baidu.swan.apps.adlanding.download.a.a
            public void dA(boolean z) {
                if (a.DEBUG) {
                    Log.d("SwanAdDownloadImpl", "onShowButton:" + z);
                }
            }

            @Override // com.baidu.swan.apps.adlanding.download.a.a
            public void a(SwanAdDownloadState swanAdDownloadState, int i) {
                if (a.DEBUG) {
                    Log.d("SwanAdDownloadImpl", "onStateChange   onStateChange:" + swanAdDownloadState + ", onProgressChange:" + i);
                }
                switch (AnonymousClass3.dhL[swanAppDownloadType.ordinal()]) {
                    case 1:
                        a.this.a(swanAdDownloadState, String.valueOf(i));
                        return;
                    case 2:
                        a.this.b(swanAdDownloadState, String.valueOf(i));
                        return;
                    case 3:
                        a.this.ty(String.valueOf(i));
                        return;
                    case 4:
                        a.this.aHr();
                        return;
                    case 5:
                        a.this.c(swanAdDownloadState, String.valueOf(i));
                        return;
                    case 6:
                        a.this.aHs();
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
            public void iO(String str) {
                if (a.DEBUG) {
                    Log.d("SwanAdDownloadImpl", "onPackageNameChange:" + str);
                }
            }

            @Override // com.baidu.swan.apps.adlanding.download.a.a
            public void abo() {
                if (a.DEBUG) {
                    Log.d("SwanAdDownloadImpl", "onInstall:");
                }
            }

            @Override // com.baidu.swan.apps.adlanding.download.a.a
            public String abp() {
                if (a.DEBUG) {
                    Log.d("SwanAdDownloadImpl", "onAppOpen:");
                    return null;
                }
                return null;
            }
        });
    }

    /* renamed from: com.baidu.swan.facade.requred.a.a.a$3  reason: invalid class name */
    /* loaded from: classes20.dex */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] dhL = new int[SwanAppDownloadAction.SwanAppDownloadType.values().length];

        static {
            try {
                dhL[SwanAppDownloadAction.SwanAppDownloadType.TYPE_QUERY_STATUS.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                dhL[SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                dhL[SwanAppDownloadAction.SwanAppDownloadType.TYPE_PAUSE_DOWNLOAD.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                dhL[SwanAppDownloadAction.SwanAppDownloadType.TYPE_CANCEL_DOWNLOAD.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                dhL[SwanAppDownloadAction.SwanAppDownloadType.TYPE_RESUME_DOWNLOAD.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                dhL[SwanAppDownloadAction.SwanAppDownloadType.TYPE_INSTALL_APP.ordinal()] = 6;
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
        this.crL.handleSchemeDispatchCallback(this.dhK, a(swanAdDownloadState, str, this.dhJ));
        if (swanAdDownloadState == SwanAdDownloadState.DOWNLOADED && "-1".equals(str)) {
            this.crL.handleSchemeDispatchCallback(this.mCallback, a(swanAdDownloadState, str, this.dhJ, SwanAdDownloadState.DELETED.value()));
        } else if (TextUtils.equals(str, "100")) {
            this.crL.handleSchemeDispatchCallback(this.mCallback, a(SwanAdDownloadState.DOWNLOADED, str, this.dhJ));
        } else {
            this.crL.handleSchemeDispatchCallback(this.mCallback, a(swanAdDownloadState, str, this.dhJ));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(@NonNull SwanAdDownloadState swanAdDownloadState, @NonNull String str) {
        this.dhH = this.mCallback;
        this.crL.handleSchemeDispatchCallback(this.dhK, a(swanAdDownloadState, str, this.dhJ));
        if (swanAdDownloadState == SwanAdDownloadState.DOWNLOADED) {
            this.crL.handleSchemeDispatchCallback(this.mCallback, l(true, "onSuccess"));
            this.dhH = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ty(@NonNull String str) {
        this.crL.handleSchemeDispatchCallback(this.dhK, a(SwanAdDownloadState.DOWNLOAD_PAUSED, str, this.dhJ));
        this.crL.handleSchemeDispatchCallback(this.mCallback, l(true, null));
        if (this.dhH != null) {
            this.crL.handleSchemeDispatchCallback(this.dhH, l(false, MissionEvent.MESSAGE_PAUSE));
            this.dhH = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aHr() {
        this.crL.handleSchemeDispatchCallback(this.dhK, a(SwanAdDownloadState.DOWNLOAD_FAILED, "0", this.dhJ));
        this.crL.handleSchemeDispatchCallback(this.mCallback, l(true, null));
        if (this.dhH != null) {
            this.crL.handleSchemeDispatchCallback(this.dhH, l(false, "onStopped"));
            this.dhH = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(@NonNull SwanAdDownloadState swanAdDownloadState, @NonNull String str) {
        if (DEBUG) {
            Log.d("SwanAdDownloadImpl", "handleResumeDownload");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aHs() {
        if (DEBUG) {
            Log.d("SwanAdDownloadImpl", "handleInstallApp");
        }
        String concat = new File(com.baidu.swan.game.ad.downloader.b.getDownloadDir()).getAbsolutePath().concat("/").concat(this.dhJ + ".apk");
        if (new File(concat).exists()) {
            aHt();
            if (!com.baidu.swan.game.ad.downloader.e.ad(concat, false)) {
                this.crL.handleSchemeDispatchCallback(this.mCallback, l(false, "install apk error"));
                return;
            }
            return;
        }
        this.crL.handleSchemeDispatchCallback(this.mCallback, l(false, "Apk Not Found"));
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
    public String l(boolean z, @Nullable String str) {
        return a(z, str, (JSONObject) null);
    }

    @NonNull
    private String a(boolean z, @Nullable String str, @Nullable JSONObject jSONObject) {
        if (str == null) {
            str = z ? "success" : SmsLoginView.f.l;
        }
        return UnitedSchemeUtility.wrapCallbackParams(jSONObject, z ? 0 : 1001, str).toString();
    }

    private void aHt() {
        if (this.dhI == null) {
            this.dhI = new C0475a();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
            intentFilter.addDataScheme("package");
            this.mContext.registerReceiver(this.dhI, intentFilter);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.facade.requred.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes20.dex */
    public class C0475a extends BroadcastReceiver {
        private long time;

        private C0475a() {
            this.time = 0L;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null && intent.getData() != null && "android.intent.action.PACKAGE_ADDED".equals(intent.getAction())) {
                if (TextUtils.equals(a.this.mPkgName, intent.getData().getSchemeSpecificPart())) {
                    a.this.crL.handleSchemeDispatchCallback(a.this.mCallback, a.this.l(true, null));
                    a.this.release();
                }
            }
        }
    }

    public void release() {
        if (this.dhI != null) {
            this.mContext.unregisterReceiver(this.dhI);
            this.dhI = null;
        }
    }

    private boolean i(final Context context, JSONObject jSONObject) {
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
            public void iG(String str) {
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
                        com.baidu.swan.apps.ap.e.startActivitySafely(context, new Intent("android.intent.action.VIEW_DOWNLOADS"));
                    }
                }
            }

            @Override // com.baidu.swan.apps.ab.b
            public void N(int i, String str) {
                if (a.DEBUG) {
                    Log.d(a.TAG, "onAuthorizedFailed,  errorCode: " + i + " errorMsg: " + str);
                }
            }
        });
        return true;
    }
}
