package com.baidu.swan.apps.adaptation.a;

import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.swan.apps.scheme.actions.SwanAppDownloadAction;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public interface f {
    boolean a(@NonNull Context context, @NonNull UnitedSchemeEntity unitedSchemeEntity, @NonNull SwanAppDownloadAction.SwanAppDownloadType swanAppDownloadType, @NonNull JSONObject jSONObject, @NonNull CallbackHandler callbackHandler);

    boolean a(@NonNull Context context, @NonNull JSONObject jSONObject, @NonNull SwanAppDownloadAction.SwanAppDownloadType swanAppDownloadType, @NonNull com.baidu.swan.apps.adlanding.download.a.a aVar);

    boolean g(Context context, JSONObject jSONObject);

    /* loaded from: classes8.dex */
    public static class a implements f {
        private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

        @Override // com.baidu.swan.apps.adaptation.a.f
        public boolean g(Context context, JSONObject jSONObject) {
            return h(context, jSONObject);
        }

        @Override // com.baidu.swan.apps.adaptation.a.f
        public boolean a(@NonNull Context context, @NonNull UnitedSchemeEntity unitedSchemeEntity, @NonNull SwanAppDownloadAction.SwanAppDownloadType swanAppDownloadType, @NonNull JSONObject jSONObject, @NonNull CallbackHandler callbackHandler) {
            return h(context, jSONObject);
        }

        @Override // com.baidu.swan.apps.adaptation.a.f
        public boolean a(@NonNull Context context, @NonNull JSONObject jSONObject, @NonNull SwanAppDownloadAction.SwanAppDownloadType swanAppDownloadType, @NonNull com.baidu.swan.apps.adlanding.download.a.a aVar) {
            return h(context, jSONObject);
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
            com.baidu.swan.apps.ab.a.a("android.permission.WRITE_EXTERNAL_STORAGE", new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 3, context, new com.baidu.swan.apps.ab.b() { // from class: com.baidu.swan.apps.adaptation.a.f.a.1
                @Override // com.baidu.swan.apps.ab.b
                public void jC(String str) {
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
                public void ai(int i, String str) {
                    if (a.DEBUG) {
                        Log.d("DownloadImpl", "onAuthorizedFailed,  errorCode: " + i + " errorMsg: " + str);
                    }
                }
            });
            return true;
        }
    }
}
